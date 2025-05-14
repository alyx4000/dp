package io.branch.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallReferrerResult.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, d2 = {"Lio/branch/data/InstallReferrerResult;", "", "appStore", "", "latestInstallTimestamp", "", "latestRawReferrer", "latestClickTimestamp", "(Ljava/lang/String;JLjava/lang/String;J)V", "getAppStore", "()Ljava/lang/String;", "setAppStore", "(Ljava/lang/String;)V", "getLatestClickTimestamp", "()J", "setLatestClickTimestamp", "(J)V", "getLatestInstallTimestamp", "setLatestInstallTimestamp", "getLatestRawReferrer", "setLatestRawReferrer", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Branch-SDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class InstallReferrerResult {
    private String appStore;
    private long latestClickTimestamp;
    private long latestInstallTimestamp;
    private String latestRawReferrer;

    public static /* synthetic */ InstallReferrerResult copy$default(InstallReferrerResult installReferrerResult, String str, long j, String str2, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = installReferrerResult.appStore;
        }
        if ((i & 2) != 0) {
            j = installReferrerResult.latestInstallTimestamp;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            str2 = installReferrerResult.latestRawReferrer;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            j2 = installReferrerResult.latestClickTimestamp;
        }
        return installReferrerResult.copy(str, j3, str3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppStore() {
        return this.appStore;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLatestInstallTimestamp() {
        return this.latestInstallTimestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLatestRawReferrer() {
        return this.latestRawReferrer;
    }

    /* renamed from: component4, reason: from getter */
    public final long getLatestClickTimestamp() {
        return this.latestClickTimestamp;
    }

    public final InstallReferrerResult copy(String appStore, long latestInstallTimestamp, String latestRawReferrer, long latestClickTimestamp) {
        return new InstallReferrerResult(appStore, latestInstallTimestamp, latestRawReferrer, latestClickTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallReferrerResult)) {
            return false;
        }
        InstallReferrerResult installReferrerResult = (InstallReferrerResult) other;
        return Intrinsics.areEqual(this.appStore, installReferrerResult.appStore) && this.latestInstallTimestamp == installReferrerResult.latestInstallTimestamp && Intrinsics.areEqual(this.latestRawReferrer, installReferrerResult.latestRawReferrer) && this.latestClickTimestamp == installReferrerResult.latestClickTimestamp;
    }

    public int hashCode() {
        String str = this.appStore;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.latestInstallTimestamp)) * 31;
        String str2 = this.latestRawReferrer;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.latestClickTimestamp);
    }

    public String toString() {
        return "InstallReferrerResult(appStore=" + this.appStore + ", latestInstallTimestamp=" + this.latestInstallTimestamp + ", latestRawReferrer=" + this.latestRawReferrer + ", latestClickTimestamp=" + this.latestClickTimestamp + ')';
    }

    public InstallReferrerResult(String str, long j, String str2, long j2) {
        this.appStore = str;
        this.latestInstallTimestamp = j;
        this.latestRawReferrer = str2;
        this.latestClickTimestamp = j2;
    }

    public final String getAppStore() {
        return this.appStore;
    }

    public final void setAppStore(String str) {
        this.appStore = str;
    }

    public final long getLatestInstallTimestamp() {
        return this.latestInstallTimestamp;
    }

    public final void setLatestInstallTimestamp(long j) {
        this.latestInstallTimestamp = j;
    }

    public final String getLatestRawReferrer() {
        return this.latestRawReferrer;
    }

    public final void setLatestRawReferrer(String str) {
        this.latestRawReferrer = str;
    }

    public final long getLatestClickTimestamp() {
        return this.latestClickTimestamp;
    }

    public final void setLatestClickTimestamp(long j) {
        this.latestClickTimestamp = j;
    }
}
