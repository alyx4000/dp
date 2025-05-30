package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.socure.docv.capturesdk.common.utils.Scanner;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class ReconnectingWebSocket extends WebSocketListener {
    private static final int RECONNECT_DELAY_MS = 2000;
    private static final String TAG = "ReconnectingWebSocket";
    private ConnectionCallback mConnectionCallback;
    private MessageCallback mMessageCallback;
    private boolean mSuppressConnectionErrors;
    private final String mUrl;
    private WebSocket mWebSocket;
    private boolean mClosed = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final OkHttpClient mOkHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(0, TimeUnit.MINUTES).build();

    public interface ConnectionCallback {
        void onConnected();

        void onDisconnected();
    }

    public interface MessageCallback {
        void onMessage(String str);

        void onMessage(ByteString byteString);
    }

    public ReconnectingWebSocket(String str, MessageCallback messageCallback, ConnectionCallback connectionCallback) {
        this.mUrl = str;
        this.mMessageCallback = messageCallback;
        this.mConnectionCallback = connectionCallback;
    }

    public void connect() {
        if (this.mClosed) {
            throw new IllegalStateException("Can't connect closed client");
        }
        this.mOkHttpClient.newWebSocket(new Request.Builder().url(this.mUrl).build(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void delayedReconnect() {
        if (!this.mClosed) {
            connect();
        }
    }

    private void reconnect() {
        if (this.mClosed) {
            throw new IllegalStateException("Can't reconnect closed client");
        }
        if (!this.mSuppressConnectionErrors) {
            FLog.w(TAG, "Couldn't connect to \"" + this.mUrl + "\", will silently retry");
            this.mSuppressConnectionErrors = true;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.facebook.react.packagerconnection.ReconnectingWebSocket.1
            @Override // java.lang.Runnable
            public void run() {
                ReconnectingWebSocket.this.delayedReconnect();
            }
        }, Scanner.CAMERA_SETUP_DELAY_MS);
    }

    public void closeQuietly() {
        this.mClosed = true;
        closeWebSocketQuietly();
        this.mMessageCallback = null;
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onDisconnected();
        }
    }

    private void closeWebSocketQuietly() {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            try {
                webSocket.close(1000, "End of session");
            } catch (Exception unused) {
            }
            this.mWebSocket = null;
        }
    }

    private void abort(String str, Throwable th) {
        FLog.e(TAG, "Error occurred, shutting down websocket connection: " + str, th);
        closeWebSocketQuietly();
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onOpen(WebSocket webSocket, Response response) {
        this.mWebSocket = webSocket;
        this.mSuppressConnectionErrors = false;
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onConnected();
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onFailure(WebSocket webSocket, Throwable th, Response response) {
        if (this.mWebSocket != null) {
            abort("Websocket exception", th);
        }
        if (!this.mClosed) {
            ConnectionCallback connectionCallback = this.mConnectionCallback;
            if (connectionCallback != null) {
                connectionCallback.onDisconnected();
            }
            reconnect();
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onMessage(WebSocket webSocket, String str) {
        MessageCallback messageCallback = this.mMessageCallback;
        if (messageCallback != null) {
            messageCallback.onMessage(str);
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onMessage(WebSocket webSocket, ByteString byteString) {
        MessageCallback messageCallback = this.mMessageCallback;
        if (messageCallback != null) {
            messageCallback.onMessage(byteString);
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onClosed(WebSocket webSocket, int i, String str) {
        this.mWebSocket = null;
        if (!this.mClosed) {
            ConnectionCallback connectionCallback = this.mConnectionCallback;
            if (connectionCallback != null) {
                connectionCallback.onDisconnected();
            }
            reconnect();
        }
    }

    public synchronized void sendMessage(String str) throws IOException {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            webSocket.send(str);
        } else {
            throw new ClosedChannelException();
        }
    }

    public synchronized void sendMessage(ByteString byteString) throws IOException {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            webSocket.send(byteString);
        } else {
            throw new ClosedChannelException();
        }
    }
}
