package sdk.pendo.io.n5;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lsdk/pendo/io/n5/b;", "", "<init>", "(Ljava/lang/String;I)V", "DEBUG", "INFO", "WARNING", "ERROR", "NONE", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ b[] $VALUES;
    public static final b DEBUG = new b("DEBUG", 0);
    public static final b INFO = new b("INFO", 1);
    public static final b WARNING = new b("WARNING", 2);
    public static final b ERROR = new b("ERROR", 3);
    public static final b NONE = new b("NONE", 4);

    static {
        b[] a2 = a();
        $VALUES = a2;
        $ENTRIES = EnumEntriesKt.enumEntries(a2);
    }

    private b(String str, int i) {
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{DEBUG, INFO, WARNING, ERROR, NONE};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }
}
