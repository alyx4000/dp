package sdk.pendo.io.k0;

import java.lang.reflect.Field;
import java.util.Locale;
import sdk.pendo.io.models.SessionDataKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public abstract class c implements sdk.pendo.io.k0.d {
    private static final /* synthetic */ c[] $VALUES;
    public static final c IDENTITY;
    public static final c LOWER_CASE_WITH_DASHES;
    public static final c LOWER_CASE_WITH_DOTS;
    public static final c LOWER_CASE_WITH_UNDERSCORES;
    public static final c UPPER_CAMEL_CASE;
    public static final c UPPER_CAMEL_CASE_WITH_SPACES;
    public static final c UPPER_CASE_WITH_UNDERSCORES;

    enum a extends c {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // sdk.pendo.io.k0.d
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        IDENTITY = aVar;
        c cVar = new c("UPPER_CAMEL_CASE", 1) { // from class: sdk.pendo.io.k0.c.b
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.d
            public String a(Field field) {
                return c.a(field.getName());
            }
        };
        UPPER_CAMEL_CASE = cVar;
        c cVar2 = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: sdk.pendo.io.k0.c.c
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.d
            public String a(Field field) {
                return c.a(c.a(field.getName(), ' '));
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = cVar2;
        c cVar3 = new c("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: sdk.pendo.io.k0.c.d
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.d
            public String a(Field field) {
                return c.a(field.getName(), SessionDataKt.UNDERSCORE).toUpperCase(Locale.ENGLISH);
            }
        };
        UPPER_CASE_WITH_UNDERSCORES = cVar3;
        c cVar4 = new c("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: sdk.pendo.io.k0.c.e
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.d
            public String a(Field field) {
                return c.a(field.getName(), SessionDataKt.UNDERSCORE).toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = cVar4;
        c cVar5 = new c("LOWER_CASE_WITH_DASHES", 5) { // from class: sdk.pendo.io.k0.c.f
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.d
            public String a(Field field) {
                return c.a(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = cVar5;
        c cVar6 = new c("LOWER_CASE_WITH_DOTS", 6) { // from class: sdk.pendo.io.k0.c.g
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.d
            public String a(Field field) {
                return c.a(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = cVar6;
        $VALUES = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6};
    }

    private c(String str, int i) {
    }

    static String a(String str, char c) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) $VALUES.clone();
    }

    /* synthetic */ c(String str, int i, a aVar) {
        this(str, i);
    }

    static String a(String str) {
        StringBuilder append;
        String substring;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isLetter(charAt)) {
                if (Character.isUpperCase(charAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(charAt);
                if (i == 0) {
                    append = new StringBuilder().append(upperCase);
                    substring = str.substring(1);
                } else {
                    append = new StringBuilder().append(str.substring(0, i)).append(upperCase);
                    substring = str.substring(i + 1);
                }
                return append.append(substring).toString();
            }
        }
        return str;
    }
}
