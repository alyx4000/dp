package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ReactCxxErrorHandler {
    private static Method mHandleErrorFunc;
    private static Object mObject;

    public static void setHandleErrorFunc(Object obj, Method method) {
        mObject = obj;
        mHandleErrorFunc = method;
    }

    private static void handleError(String str) {
        if (mHandleErrorFunc != null) {
            try {
                mHandleErrorFunc.invoke(mObject, new Exception(str));
            } catch (Exception e) {
                FLog.e("ReactCxxErrorHandler", "Failed to invoke error handler function", e);
            }
        }
    }
}
