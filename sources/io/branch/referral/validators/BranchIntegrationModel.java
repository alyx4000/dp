package io.branch.referral.validators;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import io.branch.referral.BranchAsyncTask;
import io.branch.referral.BranchUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class BranchIntegrationModel {
    boolean appSettingsAvailable = false;
    final List<String> applinkScheme = new ArrayList();
    private final String branchKeyLive;
    private final String branchKeyTest;
    JSONObject deeplinkUriScheme;
    final String packageName;

    public BranchIntegrationModel(Context context) {
        String str;
        String str2;
        ApplicationInfo applicationInfo;
        this.packageName = context.getPackageName();
        String str3 = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str = null;
        }
        if (applicationInfo.metaData != null) {
            str = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
            try {
                str3 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey.test");
            } catch (PackageManager.NameNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                str2 = str3;
                str3 = str;
                this.branchKeyLive = str3;
                this.branchKeyTest = str2;
                updateDeepLinkSchemes(context);
            }
            str2 = str3;
            str3 = str;
            this.branchKeyLive = str3;
            this.branchKeyTest = str2;
            updateDeepLinkSchemes(context);
        }
        str2 = null;
        this.branchKeyLive = str3;
        this.branchKeyTest = str2;
        updateDeepLinkSchemes(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateDeepLinkSchemes(android.content.Context r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            io.branch.referral.validators.BranchIntegrationModel$getDeepLinkSchemeTasks r2 = new io.branch.referral.validators.BranchIntegrationModel$getDeepLinkSchemeTasks     // Catch: java.lang.Exception -> L1f
            r2.<init>()     // Catch: java.lang.Exception -> L1f
            r3 = 1
            android.content.Context[] r4 = new android.content.Context[r3]     // Catch: java.lang.Exception -> L1f
            r4[r0] = r8     // Catch: java.lang.Exception -> L1f
            android.os.AsyncTask r8 = r2.executeTask(r4)     // Catch: java.lang.Exception -> L1f
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L1f
            r4 = 2500(0x9c4, double:1.235E-320)
            java.lang.Object r8 = r8.get(r4, r2)     // Catch: java.lang.Exception -> L1f
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch: java.lang.Exception -> L1f
            r7.appSettingsAvailable = r3     // Catch: java.lang.Exception -> L1d
            goto L2a
        L1d:
            r1 = move-exception
            goto L23
        L1f:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
        L23:
            java.lang.String r1 = r1.getMessage()
            io.branch.referral.BranchLogger.d(r1)
        L2a:
            if (r8 == 0) goto L56
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.URIScheme
            java.lang.String r1 = r1.getKey()
            org.json.JSONObject r1 = r8.optJSONObject(r1)
            r7.deeplinkUriScheme = r1
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.AppLinks
            java.lang.String r1 = r1.getKey()
            org.json.JSONArray r8 = r8.optJSONArray(r1)
            if (r8 == 0) goto L56
        L44:
            int r1 = r8.length()
            if (r0 >= r1) goto L56
            java.util.List<java.lang.String> r1 = r7.applinkScheme
            java.lang.String r2 = r8.optString(r0)
            r1.add(r2)
            int r0 = r0 + 1
            goto L44
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.validators.BranchIntegrationModel.updateDeepLinkSchemes(android.content.Context):void");
    }

    private class getDeepLinkSchemeTasks extends BranchAsyncTask<Context, Void, JSONObject> {
        private getDeepLinkSchemeTasks() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Context... contextArr) {
            return BranchUtil.getDeepLinkSchemes(contextArr[0]);
        }
    }
}
