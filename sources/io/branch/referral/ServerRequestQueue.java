package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerRequestQueue {
    private static final int MAX_ITEMS = 25;
    private static final String PREF_KEY = "BNCServerRequestQueue";
    private static ServerRequestQueue SharedInstance;
    private static final Object reqQueueLockObject = new Object();
    private SharedPreferences.Editor editor;
    private final List<ServerRequest> queue;
    private SharedPreferences sharedPref;
    private final Semaphore serverSema_ = new Semaphore(1);
    int networkCount_ = 0;
    final ConcurrentHashMap<String, String> instrumentationExtraData_ = new ConcurrentHashMap<>();

    public static ServerRequestQueue getInstance(Context context) {
        if (SharedInstance == null) {
            synchronized (ServerRequestQueue.class) {
                if (SharedInstance == null) {
                    SharedInstance = new ServerRequestQueue(context);
                }
            }
        }
        return SharedInstance;
    }

    static void shutDown() {
        synchronized (reqQueueLockObject) {
            SharedInstance = null;
        }
    }

    private ServerRequestQueue(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        this.sharedPref = sharedPreferences;
        this.editor = sharedPreferences.edit();
        this.queue = retrieve(context);
    }

    private void persist() {
        JSONObject json;
        try {
            JSONArray jSONArray = new JSONArray();
            synchronized (reqQueueLockObject) {
                for (ServerRequest serverRequest : this.queue) {
                    if (serverRequest.isPersistable() && (json = serverRequest.toJSON()) != null) {
                        jSONArray.put(json);
                    }
                }
            }
            this.editor.putString(PREF_KEY, jSONArray.toString()).apply();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder("Failed to persist queue");
            if (message == null) {
                message = "";
            }
            BranchLogger.v(sb.append(message).toString());
        }
    }

    private List<ServerRequest> retrieve(Context context) {
        String string = this.sharedPref.getString(PREF_KEY, null);
        List<ServerRequest> synchronizedList = Collections.synchronizedList(new LinkedList());
        synchronized (reqQueueLockObject) {
            if (string != null) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    int min = Math.min(jSONArray.length(), 25);
                    for (int i = 0; i < min; i++) {
                        ServerRequest fromJSON = ServerRequest.fromJSON(jSONArray.getJSONObject(i), context);
                        if (fromJSON != null) {
                            synchronizedList.add(fromJSON);
                        }
                    }
                } catch (JSONException e) {
                    BranchLogger.d(e.getMessage());
                }
            }
        }
        return synchronizedList;
    }

    public int getSize() {
        int size;
        synchronized (reqQueueLockObject) {
            size = this.queue.size();
        }
        return size;
    }

    void enqueue(ServerRequest serverRequest) {
        synchronized (reqQueueLockObject) {
            if (serverRequest != null) {
                this.queue.add(serverRequest);
                if (getSize() >= 25) {
                    this.queue.remove(1);
                }
                persist();
            }
        }
    }

    ServerRequest peek() {
        ServerRequest serverRequest;
        synchronized (reqQueueLockObject) {
            try {
                serverRequest = this.queue.get(0);
            } catch (IndexOutOfBoundsException | NoSuchElementException e) {
                BranchLogger.d(e.getMessage());
                serverRequest = null;
            }
        }
        return serverRequest;
    }

    public void printQueue() {
        synchronized (reqQueueLockObject) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.queue.size(); i++) {
                sb.append(this.queue.get(i)).append(" with locks ").append(this.queue.get(i).printWaitLocks()).append("\n");
            }
            BranchLogger.v("Queue is: " + ((Object) sb));
        }
    }

    ServerRequest peekAt(int i) {
        ServerRequest serverRequest;
        synchronized (reqQueueLockObject) {
            try {
                serverRequest = this.queue.get(i);
            } catch (IndexOutOfBoundsException | NoSuchElementException e) {
                BranchLogger.d(e.getMessage());
                serverRequest = null;
            }
        }
        return serverRequest;
    }

    void insert(ServerRequest serverRequest, int i) {
        synchronized (reqQueueLockObject) {
            try {
                if (this.queue.size() < i) {
                    i = this.queue.size();
                }
                this.queue.add(i, serverRequest);
                persist();
            } catch (IndexOutOfBoundsException e) {
                BranchLogger.d(e.getMessage());
            }
        }
    }

    public ServerRequest removeAt(int i) {
        IndexOutOfBoundsException e;
        ServerRequest serverRequest;
        synchronized (reqQueueLockObject) {
            try {
                serverRequest = this.queue.remove(i);
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                serverRequest = null;
            }
            try {
                persist();
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                BranchLogger.d(e.getMessage());
                return serverRequest;
            }
        }
        return serverRequest;
    }

    public boolean remove(ServerRequest serverRequest) {
        boolean z;
        synchronized (reqQueueLockObject) {
            z = false;
            try {
                z = this.queue.remove(serverRequest);
                persist();
            } catch (UnsupportedOperationException e) {
                BranchLogger.d(e.getMessage());
            }
        }
        return z;
    }

    void clear() {
        synchronized (reqQueueLockObject) {
            try {
                this.queue.clear();
                persist();
            } catch (UnsupportedOperationException e) {
                BranchLogger.d(e.getMessage());
            }
        }
    }

    ServerRequestInitSession getSelfInitRequest() {
        synchronized (reqQueueLockObject) {
            for (ServerRequest serverRequest : this.queue) {
                if (serverRequest instanceof ServerRequestInitSession) {
                    ServerRequestInitSession serverRequestInitSession = (ServerRequestInitSession) serverRequest;
                    if (serverRequestInitSession.initiatedByClient) {
                        return serverRequestInitSession;
                    }
                }
            }
            return null;
        }
    }

    void unlockProcessWait(ServerRequest.PROCESS_WAIT_LOCK process_wait_lock) {
        synchronized (reqQueueLockObject) {
            for (ServerRequest serverRequest : this.queue) {
                if (serverRequest != null) {
                    serverRequest.removeProcessWaitLock(process_wait_lock);
                }
            }
        }
    }

    public void postInitClear() {
        PrefHelper prefHelper = Branch.getInstance().getPrefHelper();
        boolean canClearInitData = canClearInitData();
        BranchLogger.v("postInitClear " + prefHelper + " can clear init data " + canClearInitData);
        if (prefHelper == null || !canClearInitData) {
            return;
        }
        prefHelper.setLinkClickIdentifier(PrefHelper.NO_STRING_VALUE);
        prefHelper.setGoogleSearchInstallIdentifier(PrefHelper.NO_STRING_VALUE);
        prefHelper.setAppStoreReferrer(PrefHelper.NO_STRING_VALUE);
        prefHelper.setExternalIntentUri(PrefHelper.NO_STRING_VALUE);
        prefHelper.setExternalIntentExtra(PrefHelper.NO_STRING_VALUE);
        prefHelper.setAppLink(PrefHelper.NO_STRING_VALUE);
        prefHelper.setPushIdentifier(PrefHelper.NO_STRING_VALUE);
        prefHelper.setInstallReferrerParams(PrefHelper.NO_STRING_VALUE);
        prefHelper.setIsFullAppConversion(false);
        prefHelper.setInitialReferrer(PrefHelper.NO_STRING_VALUE);
        if (prefHelper.getLong("bnc_previous_update_time") == 0) {
            prefHelper.setLong("bnc_previous_update_time", prefHelper.getLong("bnc_last_known_update_time"));
        }
    }

    void processNextQueueItem(String str) {
        BranchLogger.v("processNextQueueItem " + str);
        printQueue();
        try {
            this.serverSema_.acquire();
            if (this.networkCount_ == 0 && getSize() > 0) {
                this.networkCount_ = 1;
                ServerRequest peek = peek();
                this.serverSema_.release();
                if (peek != null) {
                    BranchLogger.d("processNextQueueItem, req " + peek);
                    if (!peek.isWaitingOnProcessToFinish()) {
                        if (!(peek instanceof ServerRequestRegisterInstall) && !hasUser()) {
                            BranchLogger.d("Branch Error: User session has not been initialized!");
                            this.networkCount_ = 0;
                            peek.handleFailure(BranchError.ERR_NO_SESSION, "");
                        } else if (requestNeedsSession(peek) && !isSessionAvailableForRequest()) {
                            this.networkCount_ = 0;
                            peek.handleFailure(BranchError.ERR_NO_SESSION, "");
                        } else {
                            executeTimedBranchPostTask(peek, Branch.getInstance().prefHelper_.getTaskTimeout());
                        }
                    } else {
                        this.networkCount_ = 0;
                    }
                } else {
                    remove(null);
                }
            } else {
                this.serverSema_.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insertRequestAtFront(ServerRequest serverRequest) {
        if (this.networkCount_ == 0) {
            insert(serverRequest, 0);
        } else {
            insert(serverRequest, 1);
        }
    }

    private boolean requestNeedsSession(ServerRequest serverRequest) {
        return ((serverRequest instanceof ServerRequestInitSession) || (serverRequest instanceof ServerRequestCreateUrl)) ? false : true;
    }

    private boolean isSessionAvailableForRequest() {
        return hasSession() && hasRandomizedDeviceToken();
    }

    private boolean hasSession() {
        return !Branch.getInstance().prefHelper_.getSessionID().equals(PrefHelper.NO_STRING_VALUE);
    }

    private boolean hasRandomizedDeviceToken() {
        return !Branch.getInstance().prefHelper_.getRandomizedDeviceToken().equals(PrefHelper.NO_STRING_VALUE);
    }

    boolean hasUser() {
        return !Branch.getInstance().prefHelper_.getRandomizedBundleToken().equals(PrefHelper.NO_STRING_VALUE);
    }

    void updateAllRequestsInQueue() {
        JSONObject post;
        for (int i = 0; i < getSize(); i++) {
            try {
                ServerRequest peekAt = peekAt(i);
                if (peekAt != null && (post = peekAt.getPost()) != null) {
                    if (post.has(Defines.Jsonkey.SessionID.getKey())) {
                        peekAt.getPost().put(Defines.Jsonkey.SessionID.getKey(), Branch.getInstance().prefHelper_.getSessionID());
                    }
                    if (post.has(Defines.Jsonkey.RandomizedBundleToken.getKey())) {
                        peekAt.getPost().put(Defines.Jsonkey.RandomizedBundleToken.getKey(), Branch.getInstance().prefHelper_.getRandomizedBundleToken());
                    }
                    if (post.has(Defines.Jsonkey.RandomizedDeviceToken.getKey())) {
                        peekAt.getPost().put(Defines.Jsonkey.RandomizedDeviceToken.getKey(), Branch.getInstance().prefHelper_.getRandomizedDeviceToken());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void executeTimedBranchPostTask(ServerRequest serverRequest, final int i) {
        BranchLogger.v("executeTimedBranchPostTask " + serverRequest);
        if (serverRequest instanceof ServerRequestInitSession) {
            BranchLogger.v("callback to be returned " + ((ServerRequestInitSession) serverRequest).callback_);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final BranchPostTask branchPostTask = new BranchPostTask(serverRequest, countDownLatch);
        branchPostTask.executeTask(new Void[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new Runnable() { // from class: io.branch.referral.ServerRequestQueue.1
                @Override // java.lang.Runnable
                public void run() {
                    ServerRequestQueue.this.awaitTimedBranchPostTask(countDownLatch, i, branchPostTask);
                }
            }).start();
        } else {
            awaitTimedBranchPostTask(countDownLatch, i, branchPostTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awaitTimedBranchPostTask(CountDownLatch countDownLatch, int i, BranchPostTask branchPostTask) {
        try {
            if (countDownLatch.await(i, TimeUnit.MILLISECONDS)) {
                return;
            }
            branchPostTask.cancel(true);
            branchPostTask.onPostExecuteInner(new ServerResponse(branchPostTask.thisReq_.getRequestPath(), BranchError.ERR_BRANCH_TASK_TIMEOUT, "", ""));
        } catch (InterruptedException e) {
            branchPostTask.cancel(true);
            branchPostTask.onPostExecuteInner(new ServerResponse(branchPostTask.thisReq_.getRequestPath(), BranchError.ERR_BRANCH_TASK_TIMEOUT, "", e.getMessage()));
        }
    }

    public void handleNewRequest(ServerRequest serverRequest) {
        BranchLogger.d("handleNewRequest " + serverRequest);
        if (Branch.getInstance().getTrackingController().isTrackingDisabled() && !serverRequest.prepareExecuteWithoutTracking()) {
            BranchLogger.d("Requested operation cannot be completed since tracking is disabled [" + serverRequest.requestPath_.getPath() + "]");
            serverRequest.handleFailure(BranchError.ERR_BRANCH_TRACKING_DISABLED, "");
            return;
        }
        if (Branch.getInstance().initState_ != Branch.SESSION_STATE.INITIALISED && !(serverRequest instanceof ServerRequestInitSession) && requestNeedsSession(serverRequest)) {
            BranchLogger.d("handleNewRequest " + serverRequest + " needs a session");
            serverRequest.addProcessWaitLock(ServerRequest.PROCESS_WAIT_LOCK.SDK_INIT_WAIT_LOCK);
        }
        enqueue(serverRequest);
        serverRequest.onRequestQueued();
        processNextQueueItem("handleNewRequest");
    }

    public boolean canClearInitData() {
        int i;
        synchronized (reqQueueLockObject) {
            i = 0;
            for (int i2 = 0; i2 < this.queue.size(); i2++) {
                if (this.queue.get(i2) instanceof ServerRequestInitSession) {
                    i++;
                }
            }
        }
        return i <= 1;
    }

    private class BranchPostTask extends BranchAsyncTask<Void, Void, ServerResponse> {
        final CountDownLatch latch_;
        ServerRequest thisReq_;

        public BranchPostTask(ServerRequest serverRequest, CountDownLatch countDownLatch) {
            this.thisReq_ = serverRequest;
            this.latch_ = countDownLatch;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.thisReq_.onPreExecute();
            this.thisReq_.doFinalUpdateOnMainThread();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public ServerResponse doInBackground(Void... voidArr) {
            ServerResponse make_restful_post;
            this.thisReq_.doFinalUpdateOnBackgroundThread();
            if (Branch.getInstance().getTrackingController().isTrackingDisabled() && !this.thisReq_.prepareExecuteWithoutTracking()) {
                return new ServerResponse(this.thisReq_.getRequestPath(), BranchError.ERR_BRANCH_TRACKING_DISABLED, "", "");
            }
            String branchKey = Branch.getInstance().prefHelper_.getBranchKey();
            if (this.thisReq_.isGetRequest()) {
                make_restful_post = Branch.getInstance().getBranchRemoteInterface().make_restful_get(this.thisReq_.getRequestUrl(), this.thisReq_.getGetParams(), this.thisReq_.getRequestPath(), branchKey);
            } else {
                BranchLogger.v("Beginning rest post for " + this.thisReq_);
                make_restful_post = Branch.getInstance().getBranchRemoteInterface().make_restful_post(this.thisReq_.getPostWithInstrumentationValues(ServerRequestQueue.this.instrumentationExtraData_), this.thisReq_.getRequestUrl(), this.thisReq_.getRequestPath(), branchKey);
            }
            CountDownLatch countDownLatch = this.latch_;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            return make_restful_post;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(ServerResponse serverResponse) {
            super.onPostExecute((BranchPostTask) serverResponse);
            onPostExecuteInner(serverResponse);
        }

        void onPostExecuteInner(ServerResponse serverResponse) {
            BranchLogger.v("onPostExecuteInner " + this + " " + serverResponse);
            CountDownLatch countDownLatch = this.latch_;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (serverResponse == null) {
                this.thisReq_.handleFailure(BranchError.ERR_BRANCH_INVALID_REQUEST, "Null response.");
                return;
            }
            int statusCode = serverResponse.getStatusCode();
            if (statusCode == 200) {
                onRequestSuccess(serverResponse);
            } else {
                onRequestFailed(serverResponse, statusCode);
            }
            ServerRequestQueue.this.networkCount_ = 0;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.branch.referral.ServerRequestQueue.BranchPostTask.1
                @Override // java.lang.Runnable
                public void run() {
                    ServerRequestQueue.this.processNextQueueItem("onPostExecuteInner");
                }
            });
        }

        private void onRequestSuccess(ServerResponse serverResponse) {
            boolean z;
            BranchLogger.v("onRequestSuccess " + serverResponse);
            JSONObject object = serverResponse.getObject();
            if (object == null) {
                this.thisReq_.handleFailure(500, "Null response json.");
            }
            ServerRequest serverRequest = this.thisReq_;
            if ((serverRequest instanceof ServerRequestCreateUrl) && object != null) {
                try {
                    Branch.getInstance().linkCache_.put(((ServerRequestCreateUrl) serverRequest).getLinkPost(), object.getString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (this.thisReq_ instanceof ServerRequestInitSession) {
                if (!Branch.getInstance().isTrackingDisabled() && object != null) {
                    try {
                        boolean z2 = true;
                        if (object.has(Defines.Jsonkey.SessionID.getKey())) {
                            Branch.getInstance().prefHelper_.setSessionID(object.getString(Defines.Jsonkey.SessionID.getKey()));
                            z = true;
                        } else {
                            z = false;
                        }
                        if (object.has(Defines.Jsonkey.RandomizedBundleToken.getKey())) {
                            String string = object.getString(Defines.Jsonkey.RandomizedBundleToken.getKey());
                            if (!Branch.getInstance().prefHelper_.getRandomizedBundleToken().equals(string)) {
                                Branch.getInstance().linkCache_.clear();
                                Branch.getInstance().prefHelper_.setRandomizedBundleToken(string);
                                z = true;
                            }
                        }
                        if (object.has(Defines.Jsonkey.RandomizedDeviceToken.getKey())) {
                            Branch.getInstance().prefHelper_.setRandomizedDeviceToken(object.getString(Defines.Jsonkey.RandomizedDeviceToken.getKey()));
                        } else {
                            z2 = z;
                        }
                        if (z2) {
                            ServerRequestQueue.this.updateAllRequestsInQueue();
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.thisReq_ instanceof ServerRequestInitSession) {
                    Branch.getInstance().setInitState(Branch.SESSION_STATE.INITIALISED);
                    Branch.getInstance().checkForAutoDeepLinkConfiguration();
                    if (Branch.getInstance().getLatestReferringParamsLatch != null) {
                        Branch.getInstance().getLatestReferringParamsLatch.countDown();
                    }
                    if (Branch.getInstance().getFirstReferringParamsLatch != null) {
                        Branch.getInstance().getFirstReferringParamsLatch.countDown();
                    }
                }
            }
            if (object != null) {
                this.thisReq_.onRequestSucceeded(serverResponse, Branch.getInstance());
                ServerRequestQueue.this.remove(this.thisReq_);
            } else if (this.thisReq_.shouldRetryOnFail()) {
                this.thisReq_.clearCallbacks();
            } else {
                ServerRequestQueue.this.remove(this.thisReq_);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void onRequestFailed(io.branch.referral.ServerResponse r6, int r7) {
            /*
                r5 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "onRequestFailed "
                r0.<init>(r1)
                java.lang.String r1 = r6.getMessage()
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                io.branch.referral.BranchLogger.v(r0)
                io.branch.referral.ServerRequest r0 = r5.thisReq_
                boolean r0 = r0 instanceof io.branch.referral.ServerRequestInitSession
                if (r0 == 0) goto L37
                io.branch.referral.Branch r0 = io.branch.referral.Branch.getInstance()
                io.branch.referral.PrefHelper r0 = r0.prefHelper_
                java.lang.String r0 = r0.getSessionParams()
                java.lang.String r1 = "bnc_no_value"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L37
                io.branch.referral.Branch r0 = io.branch.referral.Branch.getInstance()
                io.branch.referral.Branch$SESSION_STATE r1 = io.branch.referral.Branch.SESSION_STATE.UNINITIALISED
                r0.setInitState(r1)
            L37:
                r0 = 0
                r1 = 400(0x190, float:5.6E-43)
                if (r7 == r1) goto L40
                r2 = 409(0x199, float:5.73E-43)
                if (r7 != r2) goto L4c
            L40:
                io.branch.referral.ServerRequest r2 = r5.thisReq_
                boolean r3 = r2 instanceof io.branch.referral.ServerRequestCreateUrl
                if (r3 == 0) goto L4c
                io.branch.referral.ServerRequestCreateUrl r2 = (io.branch.referral.ServerRequestCreateUrl) r2
                r2.handleDuplicateURLError()
                goto L74
            L4c:
                io.branch.referral.ServerRequestQueue r2 = io.branch.referral.ServerRequestQueue.this
                r2.networkCount_ = r0
                io.branch.referral.ServerRequest r2 = r5.thisReq_
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = r6.getFailReason()
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r4 = " "
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r6 = r6.getMessage()
                java.lang.StringBuilder r6 = r3.append(r6)
                java.lang.String r6 = r6.toString()
                r2.handleFailure(r7, r6)
            L74:
                r6 = 1
                if (r1 > r7) goto L7b
                r1 = 451(0x1c3, float:6.32E-43)
                if (r7 <= r1) goto L7f
            L7b:
                r1 = -117(0xffffffffffffff8b, float:NaN)
                if (r7 != r1) goto L80
            L7f:
                r0 = r6
            L80:
                if (r0 != 0) goto La1
                io.branch.referral.ServerRequest r7 = r5.thisReq_
                boolean r7 = r7.shouldRetryOnFail()
                if (r7 == 0) goto La1
                io.branch.referral.ServerRequest r7 = r5.thisReq_
                int r7 = r7.currentRetryCount
                io.branch.referral.Branch r0 = io.branch.referral.Branch.getInstance()
                io.branch.referral.PrefHelper r0 = r0.prefHelper_
                int r0 = r0.getNoConnectionRetryMax()
                if (r7 < r0) goto L9b
                goto La1
            L9b:
                io.branch.referral.ServerRequest r7 = r5.thisReq_
                r7.clearCallbacks()
                goto Lac
            La1:
                io.branch.referral.Branch r7 = io.branch.referral.Branch.getInstance()
                io.branch.referral.ServerRequestQueue r7 = r7.requestQueue_
                io.branch.referral.ServerRequest r0 = r5.thisReq_
                r7.remove(r0)
            Lac:
                io.branch.referral.ServerRequest r7 = r5.thisReq_
                int r0 = r7.currentRetryCount
                int r0 = r0 + r6
                r7.currentRetryCount = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestQueue.BranchPostTask.onRequestFailed(io.branch.referral.ServerResponse, int):void");
        }
    }

    public void addExtraInstrumentationData(HashMap<String, String> hashMap) {
        this.instrumentationExtraData_.putAll(hashMap);
    }

    public void addExtraInstrumentationData(String str, String str2) {
        this.instrumentationExtraData_.put(str, str2);
    }
}
