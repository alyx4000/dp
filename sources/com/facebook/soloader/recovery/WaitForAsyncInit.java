package com.facebook.soloader.recovery;

import com.facebook.soloader.ApplicationSoSource;
import com.facebook.soloader.AsyncInitSoSource;
import com.facebook.soloader.LogUtil;
import com.facebook.soloader.SoLoader;
import com.facebook.soloader.SoLoaderULError;
import com.facebook.soloader.SoSource;

/* loaded from: classes3.dex */
public class WaitForAsyncInit implements RecoveryStrategy {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        String soName = unsatisfiedLinkError instanceof SoLoaderULError ? ((SoLoaderULError) unsatisfiedLinkError).getSoName() : null;
        LogUtil.e(SoLoader.TAG, "Waiting on SoSources due to " + unsatisfiedLinkError + (soName == null ? "" : ", retrying for specific library " + soName));
        for (ApplicationSoSource applicationSoSource : soSourceArr) {
            if (applicationSoSource instanceof AsyncInitSoSource) {
                LogUtil.e(SoLoader.TAG, "Waiting on SoSource " + applicationSoSource.getName());
                ((AsyncInitSoSource) applicationSoSource).waitUntilInitCompleted();
            }
        }
        return true;
    }
}
