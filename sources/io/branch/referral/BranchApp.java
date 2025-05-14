package io.branch.referral;

import android.app.Application;

/* loaded from: classes2.dex */
public class BranchApp extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Branch.getAutoInstance(this);
    }
}
