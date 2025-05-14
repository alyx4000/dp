package com.iterable.iterableapi;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.iterable.iterableapi.IterableInAppMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableInAppFileStorage implements IterableInAppStorage, IterableInAppMessage.OnChangeListener {
    private static final String FOLDER_PATH = "IterableInAppFileStorage";
    private static final String INDEX_FILE = "index.html";
    private static final int OPERATION_SAVE = 100;
    private static final String TAG = "IterableInAppFileStorage";
    private final Context context;
    FileOperationHandler fileOperationHandler;
    private final HandlerThread fileOperationThread;
    private Map<String, IterableInAppMessage> messages = Collections.synchronizedMap(new LinkedHashMap());

    IterableInAppFileStorage(Context context) {
        HandlerThread handlerThread = new HandlerThread("FileOperationThread");
        this.fileOperationThread = handlerThread;
        this.context = context;
        handlerThread.start();
        this.fileOperationHandler = new FileOperationHandler(handlerThread.getLooper());
        load();
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized List<IterableInAppMessage> getMessages() {
        return new ArrayList(this.messages.values());
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized IterableInAppMessage getMessage(String str) {
        return this.messages.get(str);
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized void addMessage(IterableInAppMessage iterableInAppMessage) {
        this.messages.put(iterableInAppMessage.getMessageId(), iterableInAppMessage);
        iterableInAppMessage.setOnChangeListener(this);
        saveMessagesInBackground();
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized void removeMessage(IterableInAppMessage iterableInAppMessage) {
        iterableInAppMessage.setOnChangeListener(null);
        removeHTML(iterableInAppMessage.getMessageId());
        this.messages.remove(iterableInAppMessage.getMessageId());
        saveMessagesInBackground();
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public void saveHTML(String str, String str2) {
        File createFolderForMessage = createFolderForMessage(str);
        if (createFolderForMessage == null) {
            IterableLogger.e("IterableInAppFileStorage", "Failed to create folder for HTML content");
        } else {
            if (IterableUtil.writeFile(new File(createFolderForMessage, INDEX_FILE), str2)) {
                return;
            }
            IterableLogger.e("IterableInAppFileStorage", "Failed to store HTML content");
        }
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public String getHTML(String str) {
        return IterableUtil.readFile(getFileForContent(str));
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public void removeHTML(String str) {
        File folderForMessage = getFolderForMessage(str);
        File[] listFiles = folderForMessage.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
        folderForMessage.delete();
    }

    @Override // com.iterable.iterableapi.IterableInAppMessage.OnChangeListener
    public void onInAppMessageChanged(IterableInAppMessage iterableInAppMessage) {
        saveMessagesInBackground();
    }

    private synchronized void clearMessages() {
        Iterator<Map.Entry<String, IterableInAppMessage>> it = this.messages.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().setOnChangeListener(null);
        }
        this.messages.clear();
    }

    private JSONObject serializeMessages() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Map.Entry<String, IterableInAppMessage>> it = this.messages.entrySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().getValue().toJSONObject());
            }
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_MESSAGE, jSONArray);
        } catch (JSONException e) {
            IterableLogger.e("IterableInAppFileStorage", "Error while serializing messages", e);
        }
        return jSONObject;
    }

    private void loadMessagesFromJson(JSONObject jSONObject) {
        IterableInAppMessage fromJSONObject;
        clearMessages();
        JSONArray optJSONArray = jSONObject.optJSONArray(IterableConstants.ITERABLE_IN_APP_MESSAGE);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && (fromJSONObject = IterableInAppMessage.fromJSONObject(optJSONObject, this)) != null) {
                    fromJSONObject.setOnChangeListener(this);
                    this.messages.put(fromJSONObject.getMessageId(), fromJSONObject);
                }
            }
        }
    }

    private void load() {
        try {
            File inAppStorageFile = getInAppStorageFile();
            if (inAppStorageFile.exists()) {
                loadMessagesFromJson(new JSONObject(IterableUtil.readFile(inAppStorageFile)));
            } else if (getInAppCacheStorageFile().exists()) {
                loadMessagesFromJson(new JSONObject(IterableUtil.readFile(getInAppCacheStorageFile())));
            }
        } catch (Exception e) {
            IterableLogger.e("IterableInAppFileStorage", "Error while loading in-app messages from file", e);
        }
    }

    private void saveMessagesInBackground() {
        if (this.fileOperationHandler.hasMessages(100)) {
            return;
        }
        this.fileOperationHandler.sendEmptyMessageDelayed(100, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void saveMessages() {
        saveHTMLContent();
        saveMetadata();
    }

    private synchronized void saveHTMLContent() {
        for (IterableInAppMessage iterableInAppMessage : this.messages.values()) {
            if (iterableInAppMessage.hasLoadedHtmlFromJson()) {
                saveHTML(iterableInAppMessage.getMessageId(), iterableInAppMessage.getContent().html);
                iterableInAppMessage.setLoadedHtmlFromJson(false);
            }
        }
    }

    private synchronized void saveMetadata() {
        try {
            IterableUtil.writeFile(getInAppStorageFile(), serializeMessages().toString());
        } catch (Exception e) {
            IterableLogger.e("IterableInAppFileStorage", "Error while saving in-app messages to file", e);
        }
    }

    private File getInAppStorageFile() {
        return new File(getInAppContentFolder(), "itbl_inapp.json");
    }

    private File getInAppCacheStorageFile() {
        return new File(IterableUtil.getSdkCacheDir(this.context), "itbl_inapp.json");
    }

    private File createFolderForMessage(String str) {
        File folderForMessage = getFolderForMessage(str);
        if (folderForMessage.isDirectory() && new File(folderForMessage, INDEX_FILE).exists()) {
            IterableLogger.v("IterableInAppFileStorage", "Directory with file already exists. No need to store again");
            return null;
        }
        if (folderForMessage.mkdir()) {
            return folderForMessage;
        }
        return null;
    }

    private File getInAppContentFolder() {
        return IterableUtil.getDirectory(IterableUtil.getSDKFilesDirectory(this.context), "IterableInAppFileStorage");
    }

    private File getFolderForMessage(String str) {
        return new File(getInAppContentFolder(), str);
    }

    private File getFileForContent(String str) {
        return new File(getFolderForMessage(str), INDEX_FILE);
    }

    class FileOperationHandler extends Handler {
        FileOperationHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                IterableInAppFileStorage.this.saveMessages();
            }
        }
    }
}
