package com.iterable.iterableapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class IterableActionRunner {
    static IterableActionRunnerImpl instance = new IterableActionRunnerImpl();

    IterableActionRunner() {
    }

    static boolean executeAction(Context context, IterableAction iterableAction, IterableActionSource iterableActionSource) {
        return instance.executeAction(context, iterableAction, iterableActionSource);
    }

    static class IterableActionRunnerImpl {
        private static final String TAG = "IterableActionRunner";

        IterableActionRunnerImpl() {
        }

        boolean executeAction(Context context, IterableAction iterableAction, IterableActionSource iterableActionSource) {
            if (iterableAction == null) {
                return false;
            }
            IterableActionContext iterableActionContext = new IterableActionContext(iterableAction, iterableActionSource);
            if (iterableAction.isOfType(IterableAction.ACTION_TYPE_OPEN_URL)) {
                return openUri(context, Uri.parse(iterableAction.getData()), iterableActionContext);
            }
            return callCustomActionIfSpecified(iterableAction, iterableActionContext);
        }

        private boolean openUri(Context context, Uri uri, IterableActionContext iterableActionContext) {
            if (!IterableUtil.isUrlOpenAllowed(uri.toString())) {
                return false;
            }
            if (IterableApi.sharedInstance.config.urlHandler != null && IterableApi.sharedInstance.config.urlHandler.handleIterableURL(uri, iterableActionContext)) {
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 1) {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo.packageName.equals(context.getPackageName())) {
                        Log.d(TAG, "The deep link will be handled by the app: " + next.activityInfo.packageName);
                        intent.setPackage(next.activityInfo.packageName);
                        break;
                    }
                }
            }
            intent.setFlags(872415232);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
            IterableLogger.e(TAG, "Could not find activities to handle deep link:" + uri);
            return false;
        }

        private boolean callCustomActionIfSpecified(IterableAction iterableAction, IterableActionContext iterableActionContext) {
            if (iterableAction.getType() == null || iterableAction.getType().isEmpty() || IterableApi.sharedInstance.config.customActionHandler == null) {
                return false;
            }
            return IterableApi.sharedInstance.config.customActionHandler.handleIterableCustomAction(iterableAction, iterableActionContext);
        }
    }
}
