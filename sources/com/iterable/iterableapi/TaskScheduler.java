package com.iterable.iterableapi;

import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterableTaskRunner;
import java.util.HashMap;
import org.json.JSONException;

/* compiled from: OfflineRequestProcessor.java */
/* loaded from: classes5.dex */
class TaskScheduler implements IterableTaskRunner.TaskCompletedListener {
    private final IterableTaskRunner taskRunner;
    private final IterableTaskStorage taskStorage;
    static HashMap<String, IterableHelper.SuccessHandler> successCallbackMap = new HashMap<>();
    static HashMap<String, IterableHelper.FailureHandler> failureCallbackMap = new HashMap<>();

    TaskScheduler(IterableTaskStorage iterableTaskStorage, IterableTaskRunner iterableTaskRunner) {
        this.taskStorage = iterableTaskStorage;
        this.taskRunner = iterableTaskRunner;
        iterableTaskRunner.addTaskCompletedListener(this);
    }

    void scheduleTask(IterableApiRequest iterableApiRequest, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        try {
            String createTask = this.taskStorage.createTask(iterableApiRequest.resourcePath, IterableTaskType.API, iterableApiRequest.toJSONObject().toString());
            if (createTask == null) {
                new IterableRequestTask().execute(iterableApiRequest);
            } else {
                successCallbackMap.put(createTask, successHandler);
                failureCallbackMap.put(createTask, failureHandler);
            }
        } catch (JSONException unused) {
            IterableLogger.e("RequestProcessor", "Failed serializing the request for offline execution. Attempting to request the request now...");
            new IterableRequestTask().execute(iterableApiRequest);
        }
    }

    @Override // com.iterable.iterableapi.IterableTaskRunner.TaskCompletedListener
    public void onTaskCompleted(String str, IterableTaskRunner.TaskResult taskResult, IterableApiResponse iterableApiResponse) {
        IterableHelper.SuccessHandler successHandler = successCallbackMap.get(str);
        IterableHelper.FailureHandler failureHandler = failureCallbackMap.get(str);
        successCallbackMap.remove(str);
        failureCallbackMap.remove(str);
        if (iterableApiResponse.success) {
            if (successHandler != null) {
                successHandler.onSuccess(iterableApiResponse.responseJson);
            }
        } else if (failureHandler != null) {
            failureHandler.onFailure(iterableApiResponse.errorMessage, iterableApiResponse.responseJson);
        }
    }
}
