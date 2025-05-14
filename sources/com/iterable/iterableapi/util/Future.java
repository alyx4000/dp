package com.iterable.iterableapi.util;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public class Future<T> {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private Handler callbackHandler;
    private final List<SuccessCallback<T>> successCallbacks = new ArrayList();
    private final List<FailureCallback> failureCallbacks = new ArrayList();

    public interface FailureCallback {
        void onFailure(Throwable th);
    }

    public interface SuccessCallback<T> {
        void onSuccess(T t);
    }

    public static <T> Future<T> runAsync(Callable<T> callable) {
        return new Future<>(callable);
    }

    private Future(final Callable<T> callable) {
        Looper myLooper = Looper.myLooper();
        this.callbackHandler = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper);
        EXECUTOR.submit(new Runnable() { // from class: com.iterable.iterableapi.util.Future.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Future.this.handleSuccess(callable.call());
                } catch (Exception e) {
                    Future.this.handleFailure(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuccess(final T t) {
        this.callbackHandler.post(new Runnable() { // from class: com.iterable.iterableapi.util.Future.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<SuccessCallback> arrayList;
                synchronized (Future.this.successCallbacks) {
                    arrayList = new ArrayList(Future.this.successCallbacks);
                }
                for (SuccessCallback successCallback : arrayList) {
                    if (successCallback != 0) {
                        successCallback.onSuccess(t);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailure(final Throwable th) {
        this.callbackHandler.post(new Runnable() { // from class: com.iterable.iterableapi.util.Future.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<FailureCallback> arrayList;
                synchronized (Future.this.failureCallbacks) {
                    arrayList = new ArrayList(Future.this.failureCallbacks);
                }
                for (FailureCallback failureCallback : arrayList) {
                    if (failureCallback != null) {
                        failureCallback.onFailure(th);
                    }
                }
            }
        });
    }

    public Future<T> onSuccess(SuccessCallback<T> successCallback) {
        synchronized (this.successCallbacks) {
            this.successCallbacks.add(successCallback);
        }
        return this;
    }

    public Future<T> onFailure(FailureCallback failureCallback) {
        synchronized (this.failureCallbacks) {
            this.failureCallbacks.add(failureCallback);
        }
        return this;
    }
}
