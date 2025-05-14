package sdk.pendo.io.l;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sdk.pendo.io.events.ConditionData;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lsdk/pendo/io/l/f;", "", "", ConditionData.NUMBER_VALUE, "I", "b", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "V1", "UNKNOWN_VERSION", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public enum f {
    V1(0),
    UNKNOWN_VERSION(256);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int number;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lsdk/pendo/io/l/f$a;", "", "", ConditionData.NUMBER_VALUE, "Lsdk/pendo/io/l/f;", "a", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.l.f$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(int number) {
            f fVar;
            f[] values = f.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    fVar = null;
                    break;
                }
                fVar = values[i];
                if (fVar.getNumber() == number) {
                    break;
                }
                i++;
            }
            return fVar == null ? f.UNKNOWN_VERSION : fVar;
        }
    }

    f(int i) {
        this.number = i;
    }

    /* renamed from: b, reason: from getter */
    public final int getNumber() {
        return this.number;
    }
}
