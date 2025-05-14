package com.facebook.soloader.recovery;

import com.facebook.soloader.BackupSoSource;
import com.facebook.soloader.LogUtil;
import com.facebook.soloader.SoLoader;
import com.facebook.soloader.SoLoaderDSONotFoundError;
import com.facebook.soloader.SoLoaderULError;
import com.facebook.soloader.SoSource;

/* loaded from: classes3.dex */
public class ReunpackBackupSoSources implements RecoveryStrategy {
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        SoLoaderULError soLoaderULError;
        String message;
        if (!(unsatisfiedLinkError instanceof SoLoaderULError) || (unsatisfiedLinkError instanceof SoLoaderDSONotFoundError) || (message = (soLoaderULError = (SoLoaderULError) unsatisfiedLinkError).getMessage()) == null || (!message.contains("/app/") && !message.contains("/mnt/"))) {
            return false;
        }
        String soName = soLoaderULError.getSoName();
        LogUtil.e(SoLoader.TAG, "Reunpacking BackupSoSources due to " + unsatisfiedLinkError + (soName == null ? "" : ", retrying for specific library " + soName));
        for (SoSource soSource : soSourceArr) {
            if (soSource instanceof BackupSoSource) {
                BackupSoSource backupSoSource = (BackupSoSource) soSource;
                try {
                    LogUtil.e(SoLoader.TAG, "Runpacking BackupSoSource " + backupSoSource.getName());
                    backupSoSource.prepareForceRefresh();
                } catch (Exception e) {
                    LogUtil.e(SoLoader.TAG, "Encountered an exception while reunpacking BackupSoSource " + backupSoSource.getName() + " for library " + soName + ": ", e);
                    return false;
                }
            }
        }
        return true;
    }
}
