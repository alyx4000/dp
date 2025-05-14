package sdk.pendo.io.j5;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/j5/d;", "", "<init>", "(Ljava/lang/String;I)V", "Singleton", "Factory", "Scoped", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class d {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ d[] $VALUES;
    public static final d Singleton = new d("Singleton", 0);
    public static final d Factory = new d("Factory", 1);
    public static final d Scoped = new d("Scoped", 2);

    static {
        d[] a2 = a();
        $VALUES = a2;
        $ENTRIES = EnumEntriesKt.enumEntries(a2);
    }

    private d(String str, int i) {
    }

    private static final /* synthetic */ d[] a() {
        return new d[]{Singleton, Factory, Scoped};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) $VALUES.clone();
    }
}
