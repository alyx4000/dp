package sdk.pendo.io.f7;

import android.view.View;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.l;

/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final sdk.pendo.io.d6.h<sdk.pendo.io.f7.a, sdk.pendo.io.f7.a> f1085a = new a();
    private static final sdk.pendo.io.d6.h<sdk.pendo.io.f7.b, sdk.pendo.io.f7.b> b = new b();

    class a implements sdk.pendo.io.d6.h<sdk.pendo.io.f7.a, sdk.pendo.io.f7.a> {
        a() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.f7.a apply(sdk.pendo.io.f7.a aVar) {
            switch (c.f1086a[aVar.ordinal()]) {
                case 1:
                    return sdk.pendo.io.f7.a.DESTROY;
                case 2:
                    return sdk.pendo.io.f7.a.STOP;
                case 3:
                    return sdk.pendo.io.f7.a.PAUSE;
                case 4:
                    return sdk.pendo.io.f7.a.STOP;
                case 5:
                    return sdk.pendo.io.f7.a.DESTROY;
                case 6:
                    throw new e("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + aVar + " not yet implemented");
            }
        }
    }

    class b implements sdk.pendo.io.d6.h<sdk.pendo.io.f7.b, sdk.pendo.io.f7.b> {
        b() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.f7.b apply(sdk.pendo.io.f7.b bVar) {
            switch (c.b[bVar.ordinal()]) {
                case 1:
                    return sdk.pendo.io.f7.b.DETACH;
                case 2:
                    return sdk.pendo.io.f7.b.DESTROY;
                case 3:
                    return sdk.pendo.io.f7.b.DESTROY_VIEW;
                case 4:
                    return sdk.pendo.io.f7.b.STOP;
                case 5:
                    return sdk.pendo.io.f7.b.PAUSE;
                case 6:
                    return sdk.pendo.io.f7.b.STOP;
                case 7:
                    return sdk.pendo.io.f7.b.DESTROY_VIEW;
                case 8:
                    return sdk.pendo.io.f7.b.DESTROY;
                case 9:
                    return sdk.pendo.io.f7.b.DETACH;
                case 10:
                    throw new e("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + bVar + " not yet implemented");
            }
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1086a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[sdk.pendo.io.f7.b.values().length];
            b = iArr;
            try {
                iArr[sdk.pendo.io.f7.b.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[sdk.pendo.io.f7.b.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[sdk.pendo.io.f7.b.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[sdk.pendo.io.f7.b.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[sdk.pendo.io.f7.b.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[sdk.pendo.io.f7.b.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[sdk.pendo.io.f7.b.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[sdk.pendo.io.f7.b.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[sdk.pendo.io.f7.b.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[sdk.pendo.io.f7.b.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[sdk.pendo.io.f7.a.values().length];
            f1086a = iArr2;
            try {
                iArr2[sdk.pendo.io.f7.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1086a[sdk.pendo.io.f7.a.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1086a[sdk.pendo.io.f7.a.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1086a[sdk.pendo.io.f7.a.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1086a[sdk.pendo.io.f7.a.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1086a[sdk.pendo.io.f7.a.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public static <T> d<T> a(j<sdk.pendo.io.f7.a> jVar) {
        return f.a((j) jVar, (sdk.pendo.io.d6.h) f1085a);
    }

    public static <T> d<T> a(View view) {
        sdk.pendo.io.g7.a.a(view, "view == null");
        return f.a(j.a((l) new h(view)));
    }
}
