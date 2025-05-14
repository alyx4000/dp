package sdk.pendo.io.analytics.data;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.models.SessionData;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "anonVisitorId", "anonAccountId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final /* data */ class AnonDataForIdentifyEvent {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String anonVisitorId;

    /* renamed from: b, reason: from kotlin metadata */
    private final String anonAccountId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent$a;", "", "Lsdk/pendo/io/models/SessionData;", "sessionData", "Lsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent;", "a", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
        
            if (r3.isAnonymous() == true) goto L7;
         */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent a(sdk.pendo.io.models.SessionData r3) {
            /*
                r2 = this;
                if (r3 == 0) goto La
                boolean r0 = r3.isAnonymous()
                r1 = 1
                if (r0 != r1) goto La
                goto Lb
            La:
                r1 = 0
            Lb:
                if (r1 == 0) goto L1b
                sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent r0 = new sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent
                java.lang.String r1 = r3.getVisitorId()
                java.lang.String r3 = r3.getAccountId()
                r0.<init>(r1, r3)
                return r0
            L1b:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent.Companion.a(sdk.pendo.io.models.SessionData):sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent");
        }
    }

    public AnonDataForIdentifyEvent(String anonVisitorId, String anonAccountId) {
        Intrinsics.checkNotNullParameter(anonVisitorId, "anonVisitorId");
        Intrinsics.checkNotNullParameter(anonAccountId, "anonAccountId");
        this.anonVisitorId = anonVisitorId;
        this.anonAccountId = anonAccountId;
    }

    @JvmStatic
    public static final AnonDataForIdentifyEvent a(SessionData sessionData) {
        return INSTANCE.a(sessionData);
    }

    /* renamed from: b, reason: from getter */
    public final String getAnonVisitorId() {
        return this.anonVisitorId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnonDataForIdentifyEvent)) {
            return false;
        }
        AnonDataForIdentifyEvent anonDataForIdentifyEvent = (AnonDataForIdentifyEvent) other;
        return Intrinsics.areEqual(this.anonVisitorId, anonDataForIdentifyEvent.anonVisitorId) && Intrinsics.areEqual(this.anonAccountId, anonDataForIdentifyEvent.anonAccountId);
    }

    public int hashCode() {
        return (this.anonVisitorId.hashCode() * 31) + this.anonAccountId.hashCode();
    }

    public String toString() {
        return "AnonDataForIdentifyEvent(anonVisitorId=" + this.anonVisitorId + ", anonAccountId=" + this.anonAccountId + ")";
    }

    /* renamed from: a, reason: from getter */
    public final String getAnonAccountId() {
        return this.anonAccountId;
    }
}
