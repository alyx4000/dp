package sdk.pendo.io.p2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class e {
    private static final ThreadLocal<Set<sdk.pendo.io.u2.b<i, i>>> g = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private boolean f1492a = true;
    private boolean b;
    private boolean c;
    private List<Class<?>> d;
    private Class<?> e;
    private String[] f;

    public e() {
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(String.class);
    }

    private void b(Object obj, Object obj2) {
        if (obj.getClass() != obj2.getClass()) {
            a(false);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            a((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, (boolean[]) obj2);
        } else {
            a((Object[]) obj, (Object[]) obj2);
        }
    }

    static sdk.pendo.io.u2.b<i, i> c(Object obj, Object obj2) {
        return sdk.pendo.io.u2.b.a(new i(obj), new i(obj2));
    }

    static boolean d(Object obj, Object obj2) {
        Set<sdk.pendo.io.u2.b<i, i>> a2 = a();
        sdk.pendo.io.u2.b<i, i> c = c(obj, obj2);
        return a2 != null && (a2.contains(c) || a2.contains(sdk.pendo.io.u2.b.a(c.b(), c.a())));
    }

    private static void f(Object obj, Object obj2) {
        Set<sdk.pendo.io.u2.b<i, i>> a2 = a();
        if (a2 == null) {
            a2 = new HashSet<>();
            g.set(a2);
        }
        a2.add(c(obj, obj2));
    }

    private static void g(Object obj, Object obj2) {
        Set<sdk.pendo.io.u2.b<i, i>> a2 = a();
        if (a2 != null) {
            a2.remove(c(obj, obj2));
            if (a2.isEmpty()) {
                g.remove();
            }
        }
    }

    public e a(byte b, byte b2) {
        if (!this.f1492a) {
            return this;
        }
        this.f1492a = b == b2;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if (r2.isInstance(r6) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0031, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x002d, code lost:
    
        if (r1.isInstance(r7) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public sdk.pendo.io.p2.e e(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            boolean r0 = r5.f1492a
            if (r0 != 0) goto L5
            return r5
        L5:
            if (r6 != r7) goto L8
            return r5
        L8:
            r0 = 0
            if (r6 == 0) goto L6d
            if (r7 != 0) goto Le
            goto L6d
        Le:
            java.lang.Class r1 = r6.getClass()
            java.lang.Class r2 = r7.getClass()
            boolean r3 = r1.isInstance(r7)
            if (r3 == 0) goto L23
            boolean r3 = r2.isInstance(r6)
            if (r3 != 0) goto L2f
            goto L31
        L23:
            boolean r3 = r2.isInstance(r6)
            if (r3 == 0) goto L6a
            boolean r3 = r1.isInstance(r7)
            if (r3 != 0) goto L31
        L2f:
            r3 = r1
            goto L32
        L31:
            r3 = r2
        L32:
            boolean r4 = r3.isArray()     // Catch: java.lang.IllegalArgumentException -> L67
            if (r4 == 0) goto L3c
            r5.a(r6, r7)     // Catch: java.lang.IllegalArgumentException -> L67
            goto L69
        L3c:
            java.util.List<java.lang.Class<?>> r4 = r5.d     // Catch: java.lang.IllegalArgumentException -> L67
            if (r4 == 0) goto L55
            boolean r1 = r4.contains(r1)     // Catch: java.lang.IllegalArgumentException -> L67
            if (r1 != 0) goto L4e
            java.util.List<java.lang.Class<?>> r1 = r5.d     // Catch: java.lang.IllegalArgumentException -> L67
            boolean r1 = r1.contains(r2)     // Catch: java.lang.IllegalArgumentException -> L67
            if (r1 == 0) goto L55
        L4e:
            boolean r6 = r6.equals(r7)     // Catch: java.lang.IllegalArgumentException -> L67
            r5.f1492a = r6     // Catch: java.lang.IllegalArgumentException -> L67
            goto L69
        L55:
            r5.a(r6, r7, r3)     // Catch: java.lang.IllegalArgumentException -> L67
            java.lang.Class r1 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L67
            if (r1 == 0) goto L69
            java.lang.Class<?> r1 = r5.e     // Catch: java.lang.IllegalArgumentException -> L67
            if (r3 == r1) goto L69
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L67
            goto L55
        L67:
            r5.f1492a = r0
        L69:
            return r5
        L6a:
            r5.f1492a = r0
            return r5
        L6d:
            r5.f1492a = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.p2.e.e(java.lang.Object, java.lang.Object):sdk.pendo.io.p2.e");
    }

    public e a(char c, char c2) {
        if (!this.f1492a) {
            return this;
        }
        this.f1492a = c == c2;
        return this;
    }

    public boolean b() {
        return this.f1492a;
    }

    public e c(boolean z) {
        this.b = z;
        return this;
    }

    public e a(double d, double d2) {
        return !this.f1492a ? this : a(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public e b(boolean z) {
        this.c = z;
        return this;
    }

    public e a(float f, float f2) {
        return !this.f1492a ? this : a(Float.floatToIntBits(f), Float.floatToIntBits(f2));
    }

    public e a(int i, int i2) {
        if (!this.f1492a) {
            return this;
        }
        this.f1492a = i == i2;
        return this;
    }

    public e a(long j, long j2) {
        if (!this.f1492a) {
            return this;
        }
        this.f1492a = j == j2;
        return this;
    }

    public e a(Object obj, Object obj2) {
        if (!this.f1492a || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            a(false);
            return this;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            b(obj, obj2);
        } else if (!this.c || sdk.pendo.io.o2.d.b(cls)) {
            this.f1492a = obj.equals(obj2);
        } else {
            e(obj, obj2);
        }
        return this;
    }

    public e a(short s, short s2) {
        if (!this.f1492a) {
            return this;
        }
        this.f1492a = s == s2;
        return this;
    }

    public e a(boolean z, boolean z2) {
        if (!this.f1492a) {
            return this;
        }
        this.f1492a = z == z2;
        return this;
    }

    public e a(byte[] bArr, byte[] bArr2) {
        if (!this.f1492a || bArr == bArr2) {
            return this;
        }
        if (bArr == null || bArr2 == null) {
            a(false);
            return this;
        }
        if (bArr.length != bArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < bArr.length && this.f1492a; i++) {
            a(bArr[i], bArr2[i]);
        }
        return this;
    }

    public e a(char[] cArr, char[] cArr2) {
        if (!this.f1492a || cArr == cArr2) {
            return this;
        }
        if (cArr == null || cArr2 == null) {
            a(false);
            return this;
        }
        if (cArr.length != cArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < cArr.length && this.f1492a; i++) {
            a(cArr[i], cArr2[i]);
        }
        return this;
    }

    public e a(double[] dArr, double[] dArr2) {
        if (!this.f1492a || dArr == dArr2) {
            return this;
        }
        if (dArr == null || dArr2 == null) {
            a(false);
            return this;
        }
        if (dArr.length != dArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < dArr.length && this.f1492a; i++) {
            a(dArr[i], dArr2[i]);
        }
        return this;
    }

    public e a(float[] fArr, float[] fArr2) {
        if (!this.f1492a || fArr == fArr2) {
            return this;
        }
        if (fArr == null || fArr2 == null) {
            a(false);
            return this;
        }
        if (fArr.length != fArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < fArr.length && this.f1492a; i++) {
            a(fArr[i], fArr2[i]);
        }
        return this;
    }

    public e a(int[] iArr, int[] iArr2) {
        if (!this.f1492a || iArr == iArr2) {
            return this;
        }
        if (iArr == null || iArr2 == null) {
            a(false);
            return this;
        }
        if (iArr.length != iArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < iArr.length && this.f1492a; i++) {
            a(iArr[i], iArr2[i]);
        }
        return this;
    }

    public e a(long[] jArr, long[] jArr2) {
        if (!this.f1492a || jArr == jArr2) {
            return this;
        }
        if (jArr == null || jArr2 == null) {
            a(false);
            return this;
        }
        if (jArr.length != jArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < jArr.length && this.f1492a; i++) {
            a(jArr[i], jArr2[i]);
        }
        return this;
    }

    public e a(Object[] objArr, Object[] objArr2) {
        if (!this.f1492a || objArr == objArr2) {
            return this;
        }
        if (objArr == null || objArr2 == null) {
            a(false);
            return this;
        }
        if (objArr.length != objArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < objArr.length && this.f1492a; i++) {
            a(objArr[i], objArr2[i]);
        }
        return this;
    }

    public e a(short[] sArr, short[] sArr2) {
        if (!this.f1492a || sArr == sArr2) {
            return this;
        }
        if (sArr == null || sArr2 == null) {
            a(false);
            return this;
        }
        if (sArr.length != sArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < sArr.length && this.f1492a; i++) {
            a(sArr[i], sArr2[i]);
        }
        return this;
    }

    public e a(boolean[] zArr, boolean[] zArr2) {
        if (!this.f1492a || zArr == zArr2) {
            return this;
        }
        if (zArr == null || zArr2 == null) {
            a(false);
            return this;
        }
        if (zArr.length != zArr2.length) {
            a(false);
            return this;
        }
        for (int i = 0; i < zArr.length && this.f1492a; i++) {
            a(zArr[i], zArr2[i]);
        }
        return this;
    }

    static Set<sdk.pendo.io.u2.b<i, i>> a() {
        return g.get();
    }

    private void a(Object obj, Object obj2, Class<?> cls) {
        if (d(obj, obj2)) {
            return;
        }
        try {
            f(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i = 0; i < declaredFields.length && this.f1492a; i++) {
                Field field = declaredFields[i];
                if (!sdk.pendo.io.o2.b.b(this.f, field.getName()) && !field.getName().contains("$") && ((this.b || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(f.class))) {
                    try {
                        a(field.get(obj), field.get(obj2));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            g(obj, obj2);
        }
    }

    public static boolean a(Object obj, Object obj2, boolean z, Class<?> cls, boolean z2, String... strArr) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return new e().a(strArr).a(cls).c(z).b(z2).e(obj, obj2).b();
    }

    public static boolean a(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        return a(obj, obj2, z, cls, false, strArr);
    }

    public static boolean a(Object obj, Object obj2, String... strArr) {
        return a(obj, obj2, false, null, strArr);
    }

    protected void a(boolean z) {
        this.f1492a = z;
    }

    public e a(String... strArr) {
        this.f = strArr;
        return this;
    }

    public e a(Class<?> cls) {
        this.e = cls;
        return this;
    }
}
