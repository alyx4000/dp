package sdk.pendo.io.v1;

import sdk.pendo.io.v1.d;

/* loaded from: classes4.dex */
public class e extends c {
    private static final sdk.pendo.io.h7.a g = sdk.pendo.io.h7.b.a((Class<?>) e.class);
    private final d f;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1654a;

        static {
            int[] iArr = new int[d.a.values().length];
            f1654a = iArr;
            try {
                iArr[d.a.SLICE_FROM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1654a[d.a.SLICE_BETWEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1654a[d.a.SLICE_TO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    e(d dVar) {
        this.f = dVar;
    }

    private void b(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        int d = gVar.e().d(obj);
        int intValue = this.f.a().intValue();
        int min = Math.min(d, this.f.c().intValue());
        if (intValue >= min || d == 0) {
            return;
        }
        g.a("Slice between indexes on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(d), Integer.valueOf(intValue), Integer.valueOf(min), toString());
        while (intValue < min) {
            a(intValue, str, obj, gVar);
            intValue++;
        }
    }

    private void c(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        int d = gVar.e().d(obj);
        int intValue = this.f.a().intValue();
        if (intValue < 0) {
            intValue += d;
        }
        int max = Math.max(0, intValue);
        g.a("Slice from index on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(d), Integer.valueOf(max), Integer.valueOf(d - 1), toString());
        if (d == 0 || max >= d) {
            return;
        }
        while (max < d) {
            a(max, str, obj, gVar);
            max++;
        }
    }

    private void d(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        int d = gVar.e().d(obj);
        if (d == 0) {
            return;
        }
        int intValue = this.f.c().intValue();
        if (intValue < 0) {
            intValue += d;
        }
        int min = Math.min(d, intValue);
        g.a("Slice to index on array with length: {}. From index: 0 to: {}. Input: {}", Integer.valueOf(d), Integer.valueOf(min), toString());
        for (int i = 0; i < min; i++) {
            a(i, str, obj, gVar);
        }
    }

    @Override // sdk.pendo.io.v1.j
    public void a(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        if (c(str, obj, gVar)) {
            int i = a.f1654a[this.f.b().ordinal()];
            if (i == 1) {
                c(str, hVar, obj, gVar);
            } else if (i == 2) {
                b(str, hVar, obj, gVar);
            } else {
                if (i != 3) {
                    return;
                }
                d(str, hVar, obj, gVar);
            }
        }
    }

    @Override // sdk.pendo.io.v1.j
    public boolean e() {
        return false;
    }

    @Override // sdk.pendo.io.v1.j
    public String a() {
        return this.f.toString();
    }
}
