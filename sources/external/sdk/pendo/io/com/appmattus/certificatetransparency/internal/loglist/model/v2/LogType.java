package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sdk.pendo.io.g2.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0081\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogType;", "", "(Ljava/lang/String;I)V", "PROD", "TEST", "$serializer", "Companion", "certificatetransparency"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum LogType {
    PROD,
    TEST;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogType$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogType;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b<LogType> serializer() {
            return LogType$$serializer.INSTANCE;
        }
    }
}
