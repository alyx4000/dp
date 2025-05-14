package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.util.ArrayList;
import sdk.pendo.io.k0.s;
import sdk.pendo.io.k0.t;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.g;
import sdk.pendo.io.r0.b;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final u c = b(s.DOUBLE);

    /* renamed from: a, reason: collision with root package name */
    private final Gson f734a;
    private final t b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f735a;

        static {
            int[] iArr = new int[b.values().length];
            f735a = iArr;
            try {
                iArr[b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f735a[b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f735a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f735a[b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f735a[b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f735a[b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private ObjectTypeAdapter(Gson gson, t tVar) {
        this.f734a = gson;
        this.b = tVar;
    }

    public static u a(t tVar) {
        return tVar == s.DOUBLE ? c : b(tVar);
    }

    private static u b(final t tVar) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.ObjectTypeAdapter.1
            @Override // sdk.pendo.io.k0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
                if (aVar.a() == Object.class) {
                    return new ObjectTypeAdapter(gson, t.this);
                }
                return null;
            }
        };
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public Object a(sdk.pendo.io.r0.a aVar) {
        switch (a.f735a[aVar.D().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.s()) {
                    arrayList.add(a(aVar));
                }
                aVar.o();
                return arrayList;
            case 2:
                g gVar = new g();
                aVar.b();
                while (aVar.s()) {
                    gVar.put(aVar.z(), a(aVar));
                }
                aVar.p();
                return gVar;
            case 3:
                return aVar.B();
            case 4:
                return this.b.a(aVar);
            case 5:
                return Boolean.valueOf(aVar.v());
            case 6:
                aVar.A();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Object obj) {
        if (obj == null) {
            cVar.s();
            return;
        }
        TypeAdapter a2 = this.f734a.a(obj.getClass());
        if (!(a2 instanceof ObjectTypeAdapter)) {
            a2.a(cVar, obj);
        } else {
            cVar.m();
            cVar.o();
        }
    }
}
