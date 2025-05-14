package io.branch.referral;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferringUrlUtility.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003JA\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006("}, d2 = {"Lio/branch/referral/BranchUrlQueryParameter;", "", "name", "", "value", "timestamp", "Ljava/util/Date;", "isDeepLink", "", "validityWindow", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;ZJ)V", "()Z", "setDeepLink", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getTimestamp", "()Ljava/util/Date;", "setTimestamp", "(Ljava/util/Date;)V", "getValidityWindow", "()J", "setValidityWindow", "(J)V", "getValue", "setValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Branch-SDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BranchUrlQueryParameter {
    private boolean isDeepLink;
    private String name;
    private Date timestamp;
    private long validityWindow;
    private String value;

    public BranchUrlQueryParameter() {
        this(null, null, null, false, 0L, 31, null);
    }

    public static /* synthetic */ BranchUrlQueryParameter copy$default(BranchUrlQueryParameter branchUrlQueryParameter, String str, String str2, Date date, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = branchUrlQueryParameter.name;
        }
        if ((i & 2) != 0) {
            str2 = branchUrlQueryParameter.value;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            date = branchUrlQueryParameter.timestamp;
        }
        Date date2 = date;
        if ((i & 8) != 0) {
            z = branchUrlQueryParameter.isDeepLink;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            j = branchUrlQueryParameter.validityWindow;
        }
        return branchUrlQueryParameter.copy(str, str3, date2, z2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final Date getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsDeepLink() {
        return this.isDeepLink;
    }

    /* renamed from: component5, reason: from getter */
    public final long getValidityWindow() {
        return this.validityWindow;
    }

    public final BranchUrlQueryParameter copy(String name, String value, Date timestamp, boolean isDeepLink, long validityWindow) {
        return new BranchUrlQueryParameter(name, value, timestamp, isDeepLink, validityWindow);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BranchUrlQueryParameter)) {
            return false;
        }
        BranchUrlQueryParameter branchUrlQueryParameter = (BranchUrlQueryParameter) other;
        return Intrinsics.areEqual(this.name, branchUrlQueryParameter.name) && Intrinsics.areEqual(this.value, branchUrlQueryParameter.value) && Intrinsics.areEqual(this.timestamp, branchUrlQueryParameter.timestamp) && this.isDeepLink == branchUrlQueryParameter.isDeepLink && this.validityWindow == branchUrlQueryParameter.validityWindow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Date date = this.timestamp;
        int hashCode3 = (hashCode2 + (date != null ? date.hashCode() : 0)) * 31;
        boolean z = this.isDeepLink;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode3 + i) * 31) + Long.hashCode(this.validityWindow);
    }

    public String toString() {
        return "BranchUrlQueryParameter(name=" + this.name + ", value=" + this.value + ", timestamp=" + this.timestamp + ", isDeepLink=" + this.isDeepLink + ", validityWindow=" + this.validityWindow + ')';
    }

    public BranchUrlQueryParameter(String str, String str2, Date date, boolean z, long j) {
        this.name = str;
        this.value = str2;
        this.timestamp = date;
        this.isDeepLink = z;
        this.validityWindow = j;
    }

    public /* synthetic */ BranchUrlQueryParameter(String str, String str2, Date date, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) == 0 ? date : null, (i & 8) != 0 ? false : z, (i & 16) != 0 ? 0L : j);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public final boolean isDeepLink() {
        return this.isDeepLink;
    }

    public final void setDeepLink(boolean z) {
        this.isDeepLink = z;
    }

    public final long getValidityWindow() {
        return this.validityWindow;
    }

    public final void setValidityWindow(long j) {
        this.validityWindow = j;
    }
}
