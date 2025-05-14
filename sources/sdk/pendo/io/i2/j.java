package sdk.pendo.io.i2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/i2/j;", "", "", "toString", "", "hashCode", "<init>", "()V", "a", "b", "Lsdk/pendo/io/i2/j$b;", "Lsdk/pendo/io/i2/j$a;", "Lsdk/pendo/io/i2/e;", "Lsdk/pendo/io/i2/k;", "Lsdk/pendo/io/i2/d;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class j {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/i2/j$a;", "Lsdk/pendo/io/i2/j;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
    public static final class a extends j {

        /* renamed from: a, reason: collision with root package name */
        public static final a f1195a = new a();

        private a() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/i2/j$b;", "Lsdk/pendo/io/i2/j;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
    public static final class b extends j {

        /* renamed from: a, reason: collision with root package name */
        public static final b f1196a = new b();

        private b() {
            super(null);
        }
    }

    private j() {
    }

    public /* synthetic */ j(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        return simpleName;
    }
}
