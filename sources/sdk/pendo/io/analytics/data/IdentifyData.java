package sdk.pendo.io.analytics.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.c8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u001b\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/analytics/data/IdentifyData;", "", "", "b", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getNewVisitor", "()Ljava/lang/String;", "newVisitor", "oldAnonymousVisitor", "c", "getNewAccount", "newAccount", "d", "getOldAccount", "oldAccount", "", "e", "J", "getTime", "()J", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final /* data */ class IdentifyData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String newVisitor;

    /* renamed from: b, reason: from kotlin metadata */
    private final String oldAnonymousVisitor;

    /* renamed from: c, reason: from kotlin metadata */
    private final String newAccount;

    /* renamed from: d, reason: from kotlin metadata */
    private final String oldAccount;

    /* renamed from: e, reason: from kotlin metadata */
    private final long time;

    public IdentifyData(String newVisitor, String oldAnonymousVisitor, String newAccount, String oldAccount, long j) {
        Intrinsics.checkNotNullParameter(newVisitor, "newVisitor");
        Intrinsics.checkNotNullParameter(oldAnonymousVisitor, "oldAnonymousVisitor");
        Intrinsics.checkNotNullParameter(newAccount, "newAccount");
        Intrinsics.checkNotNullParameter(oldAccount, "oldAccount");
        this.newVisitor = newVisitor;
        this.oldAnonymousVisitor = oldAnonymousVisitor;
        this.newAccount = newAccount;
        this.oldAccount = oldAccount;
        this.time = j;
    }

    /* renamed from: a, reason: from getter */
    public final String getOldAnonymousVisitor() {
        return this.oldAnonymousVisitor;
    }

    public final String b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", c.IDENTIFY.b());
        jSONObject.put("device_time", this.time);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("visitor_id", this.newVisitor);
        jSONObject2.put("old_visitor_id", this.oldAnonymousVisitor);
        jSONObject2.put("account_id", this.newAccount);
        jSONObject2.put("old_account_id", this.oldAccount);
        jSONObject.put("props", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
        return jSONObject3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdentifyData)) {
            return false;
        }
        IdentifyData identifyData = (IdentifyData) other;
        return Intrinsics.areEqual(this.newVisitor, identifyData.newVisitor) && Intrinsics.areEqual(this.oldAnonymousVisitor, identifyData.oldAnonymousVisitor) && Intrinsics.areEqual(this.newAccount, identifyData.newAccount) && Intrinsics.areEqual(this.oldAccount, identifyData.oldAccount) && this.time == identifyData.time;
    }

    public int hashCode() {
        return (((((((this.newVisitor.hashCode() * 31) + this.oldAnonymousVisitor.hashCode()) * 31) + this.newAccount.hashCode()) * 31) + this.oldAccount.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "IdentifyData(newVisitor=" + this.newVisitor + ", oldAnonymousVisitor=" + this.oldAnonymousVisitor + ", newAccount=" + this.newAccount + ", oldAccount=" + this.oldAccount + ", time=" + this.time + ")";
    }

    public /* synthetic */ IdentifyData(String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? System.currentTimeMillis() : j);
    }
}
