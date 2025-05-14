package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.s;
import sdk.pendo.io.k0.t;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.r0.b;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final u b = b(s.LAZILY_PARSED_NUMBER);

    /* renamed from: a, reason: collision with root package name */
    private final t f732a;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f733a;

        static {
            int[] iArr = new int[b.values().length];
            f733a = iArr;
            try {
                iArr[b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f733a[b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f733a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private NumberTypeAdapter(t tVar) {
        this.f732a = tVar;
    }

    public static u a(t tVar) {
        return tVar == s.LAZILY_PARSED_NUMBER ? b : b(tVar);
    }

    private static u b(t tVar) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.NumberTypeAdapter.1
            @Override // sdk.pendo.io.k0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
                if (aVar.a() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Number a(sdk.pendo.io.r0.a aVar) {
        b D = aVar.D();
        int i = a.f733a[D.ordinal()];
        if (i == 1) {
            aVar.A();
            return null;
        }
        if (i == 2 || i == 3) {
            return this.f732a.a(aVar);
        }
        throw new q("Expecting number, got: " + D + "; at path " + aVar.q());
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Number number) {
        cVar.a(number);
    }
}
