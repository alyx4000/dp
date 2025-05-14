package sdk.pendo.io.p2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/* loaded from: classes6.dex */
public class g {
    private static final ThreadLocal<Set<i>> c = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private final int f1493a;
    private int b;

    public g(int i, int i2) {
        sdk.pendo.io.o2.h.a(i % 2 != 0, "HashCodeBuilder requires an odd initial value", new Object[0]);
        sdk.pendo.io.o2.h.a(i2 % 2 != 0, "HashCodeBuilder requires an odd multiplier", new Object[0]);
        this.f1493a = i2;
        this.b = i;
    }

    private void b(Object obj) {
        if (obj instanceof long[]) {
            a((long[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            a((char[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj);
        } else {
            a((Object[]) obj);
        }
    }

    static boolean c(Object obj) {
        Set<i> a2 = a();
        return a2 != null && a2.contains(new i(obj));
    }

    private static void d(Object obj) {
        Set<i> a2 = a();
        if (a2 == null) {
            a2 = new HashSet<>();
            c.set(a2);
        }
        a2.add(new i(obj));
    }

    private static void e(Object obj) {
        Set<i> a2 = a();
        if (a2 != null) {
            a2.remove(new i(obj));
            if (a2.isEmpty()) {
                c.remove();
            }
        }
    }

    public g a(byte b) {
        this.b = (this.b * this.f1493a) + b;
        return this;
    }

    public int hashCode() {
        return b();
    }

    public g a(char c2) {
        this.b = (this.b * this.f1493a) + c2;
        return this;
    }

    public int b() {
        return this.b;
    }

    public g a(double d) {
        return a(Double.doubleToLongBits(d));
    }

    public g a(float f) {
        this.b = (this.b * this.f1493a) + Float.floatToIntBits(f);
        return this;
    }

    public g a(int i) {
        this.b = (this.b * this.f1493a) + i;
        return this;
    }

    public g a(long j) {
        this.b = (this.b * this.f1493a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public g a(Object obj) {
        if (obj == null) {
            this.b *= this.f1493a;
        } else if (obj.getClass().isArray()) {
            b(obj);
        } else {
            this.b = (this.b * this.f1493a) + obj.hashCode();
        }
        return this;
    }

    public g a(short s) {
        this.b = (this.b * this.f1493a) + s;
        return this;
    }

    public g a(boolean z) {
        this.b = (this.b * this.f1493a) + (!z ? 1 : 0);
        return this;
    }

    public g a(byte[] bArr) {
        if (bArr == null) {
            this.b *= this.f1493a;
        } else {
            for (byte b : bArr) {
                a(b);
            }
        }
        return this;
    }

    public g a(char[] cArr) {
        if (cArr == null) {
            this.b *= this.f1493a;
        } else {
            for (char c2 : cArr) {
                a(c2);
            }
        }
        return this;
    }

    public g a(double[] dArr) {
        if (dArr == null) {
            this.b *= this.f1493a;
        } else {
            for (double d : dArr) {
                a(d);
            }
        }
        return this;
    }

    public g a(float[] fArr) {
        if (fArr == null) {
            this.b *= this.f1493a;
        } else {
            for (float f : fArr) {
                a(f);
            }
        }
        return this;
    }

    public g a(int[] iArr) {
        if (iArr == null) {
            this.b *= this.f1493a;
        } else {
            for (int i : iArr) {
                a(i);
            }
        }
        return this;
    }

    public g a(long[] jArr) {
        if (jArr == null) {
            this.b *= this.f1493a;
        } else {
            for (long j : jArr) {
                a(j);
            }
        }
        return this;
    }

    public g a(Object[] objArr) {
        if (objArr == null) {
            this.b *= this.f1493a;
        } else {
            for (Object obj : objArr) {
                a(obj);
            }
        }
        return this;
    }

    public g a(short[] sArr) {
        if (sArr == null) {
            this.b *= this.f1493a;
        } else {
            for (short s : sArr) {
                a(s);
            }
        }
        return this;
    }

    public g a(boolean[] zArr) {
        if (zArr == null) {
            this.b *= this.f1493a;
        } else {
            for (boolean z : zArr) {
                a(z);
            }
        }
        return this;
    }

    static Set<i> a() {
        return c.get();
    }

    private static void a(Object obj, Class<?> cls, g gVar, boolean z, String[] strArr) {
        if (c(obj)) {
            return;
        }
        try {
            d(obj);
            Field[] fieldArr = (Field[]) sdk.pendo.io.o2.a.a(cls.getDeclaredFields(), Comparator.comparing(new Function() { // from class: sdk.pendo.io.p2.g$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    String name;
                    name = ((Field) obj2).getName();
                    return name;
                }
            }));
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field : fieldArr) {
                if (!sdk.pendo.io.o2.b.b(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(h.class))) {
                    try {
                        gVar.a(field.get(obj));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            e(obj);
        }
    }

    public static <T> int a(int i, int i2, T t, boolean z, Class<? super T> cls, String... strArr) {
        sdk.pendo.io.o2.h.a(t, "object", new Object[0]);
        g gVar = new g(i, i2);
        Class<?> cls2 = t.getClass();
        while (true) {
            a(t, cls2, gVar, z, strArr);
            if (cls2.getSuperclass() == null || cls2 == cls) {
                break;
            }
            cls2 = cls2.getSuperclass();
        }
        return gVar.b();
    }
}
