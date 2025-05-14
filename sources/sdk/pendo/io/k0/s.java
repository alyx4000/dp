package sdk.pendo.io.k0;

import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public abstract class s implements t {
    private static final /* synthetic */ s[] $VALUES;
    public static final s BIG_DECIMAL;
    public static final s DOUBLE;
    public static final s LAZILY_PARSED_NUMBER;
    public static final s LONG_OR_DOUBLE;

    enum a extends s {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // sdk.pendo.io.k0.t
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(sdk.pendo.io.r0.a aVar) {
            return Double.valueOf(aVar.w());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        DOUBLE = aVar;
        s sVar = new s("LAZILY_PARSED_NUMBER", 1) { // from class: sdk.pendo.io.k0.s.b
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.t
            public Number a(sdk.pendo.io.r0.a aVar2) {
                return new sdk.pendo.io.m0.f(aVar2.B());
            }
        };
        LAZILY_PARSED_NUMBER = sVar;
        s sVar2 = new s("LONG_OR_DOUBLE", 2) { // from class: sdk.pendo.io.k0.s.c
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.t
            public Number a(sdk.pendo.io.r0.a aVar2) {
                String B = aVar2.B();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(B));
                    } catch (NumberFormatException unused) {
                        Double valueOf = Double.valueOf(B);
                        if ((valueOf.isInfinite() || valueOf.isNaN()) && !aVar2.t()) {
                            throw new sdk.pendo.io.r0.d("JSON forbids NaN and infinities: " + valueOf + "; at path " + aVar2.r());
                        }
                        return valueOf;
                    }
                } catch (NumberFormatException e) {
                    throw new m("Cannot parse " + B + "; at path " + aVar2.r(), e);
                }
            }
        };
        LONG_OR_DOUBLE = sVar2;
        s sVar3 = new s("BIG_DECIMAL", 3) { // from class: sdk.pendo.io.k0.s.d
            {
                a aVar2 = null;
            }

            @Override // sdk.pendo.io.k0.t
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(sdk.pendo.io.r0.a aVar2) {
                String B = aVar2.B();
                try {
                    return new BigDecimal(B);
                } catch (NumberFormatException e) {
                    throw new m("Cannot parse " + B + "; at path " + aVar2.r(), e);
                }
            }
        };
        BIG_DECIMAL = sVar3;
        $VALUES = new s[]{aVar, sVar, sVar2, sVar3};
    }

    private s(String str, int i) {
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) $VALUES.clone();
    }

    /* synthetic */ s(String str, int i, a aVar) {
        this(str, i);
    }
}
