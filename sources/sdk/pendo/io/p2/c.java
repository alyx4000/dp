package sdk.pendo.io.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<sdk.pendo.io.p2.b<?>> f1491a;
    private final boolean b;
    private final T c;
    private final T d;
    private final sdk.pendo.io.p2.k e;

    class a extends sdk.pendo.io.p2.b<Float[]> {
        final /* synthetic */ float[] f0;
        final /* synthetic */ float[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, float[] fArr, float[] fArr2) {
            super(str);
            this.f0 = fArr;
            this.t0 = fArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float[] a() {
            return sdk.pendo.io.o2.b.a(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Float[] b() {
            return sdk.pendo.io.o2.b.a(this.t0);
        }
    }

    class b extends sdk.pendo.io.p2.b<Integer> {
        final /* synthetic */ int f0;
        final /* synthetic */ int t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, int i, int i2) {
            super(str);
            this.f0 = i;
            this.t0 = i2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer a() {
            return Integer.valueOf(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer b() {
            return Integer.valueOf(this.t0);
        }
    }

    /* renamed from: sdk.pendo.io.p2.c$c, reason: collision with other inner class name */
    class C0225c extends sdk.pendo.io.p2.b<Integer[]> {
        final /* synthetic */ int[] f0;
        final /* synthetic */ int[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0225c(String str, int[] iArr, int[] iArr2) {
            super(str);
            this.f0 = iArr;
            this.t0 = iArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer[] a() {
            return sdk.pendo.io.o2.b.d(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer[] b() {
            return sdk.pendo.io.o2.b.d(this.t0);
        }
    }

    class d extends sdk.pendo.io.p2.b<Long[]> {
        final /* synthetic */ long[] f0;
        final /* synthetic */ long[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, long[] jArr, long[] jArr2) {
            super(str);
            this.f0 = jArr;
            this.t0 = jArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Long[] a() {
            return sdk.pendo.io.o2.b.a(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Long[] b() {
            return sdk.pendo.io.o2.b.a(this.t0);
        }
    }

    class e extends sdk.pendo.io.p2.b<Short[]> {
        final /* synthetic */ short[] f0;
        final /* synthetic */ short[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, short[] sArr, short[] sArr2) {
            super(str);
            this.f0 = sArr;
            this.t0 = sArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Short[] a() {
            return sdk.pendo.io.o2.b.a(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Short[] b() {
            return sdk.pendo.io.o2.b.a(this.t0);
        }
    }

    class f extends sdk.pendo.io.p2.b<Object> {
        final /* synthetic */ Object f0;
        final /* synthetic */ Object t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object obj, Object obj2) {
            super(str);
            this.f0 = obj;
            this.t0 = obj2;
        }

        @Override // sdk.pendo.io.u2.b
        public Object a() {
            return this.f0;
        }

        @Override // sdk.pendo.io.u2.b
        public Object b() {
            return this.t0;
        }
    }

    class g extends sdk.pendo.io.p2.b<Object[]> {
        final /* synthetic */ Object[] f0;
        final /* synthetic */ Object[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, Object[] objArr2) {
            super(str);
            this.f0 = objArr;
            this.t0 = objArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object[] a() {
            return this.f0;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object[] b() {
            return this.t0;
        }
    }

    class h extends sdk.pendo.io.p2.b<Boolean[]> {
        final /* synthetic */ boolean[] f0;
        final /* synthetic */ boolean[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, boolean[] zArr, boolean[] zArr2) {
            super(str);
            this.f0 = zArr;
            this.t0 = zArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean[] a() {
            return sdk.pendo.io.o2.b.a(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean[] b() {
            return sdk.pendo.io.o2.b.a(this.t0);
        }
    }

    class i extends sdk.pendo.io.p2.b<Byte[]> {
        final /* synthetic */ byte[] f0;
        final /* synthetic */ byte[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, byte[] bArr, byte[] bArr2) {
            super(str);
            this.f0 = bArr;
            this.t0 = bArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Byte[] a() {
            return sdk.pendo.io.o2.b.a(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Byte[] b() {
            return sdk.pendo.io.o2.b.a(this.t0);
        }
    }

    class j extends sdk.pendo.io.p2.b<Character[]> {
        final /* synthetic */ char[] f0;
        final /* synthetic */ char[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, char[] cArr, char[] cArr2) {
            super(str);
            this.f0 = cArr;
            this.t0 = cArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character[] a() {
            return sdk.pendo.io.o2.b.b(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Character[] b() {
            return sdk.pendo.io.o2.b.b(this.t0);
        }
    }

    class k extends sdk.pendo.io.p2.b<Double[]> {
        final /* synthetic */ double[] f0;
        final /* synthetic */ double[] t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, double[] dArr, double[] dArr2) {
            super(str);
            this.f0 = dArr;
            this.t0 = dArr2;
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double[] a() {
            return sdk.pendo.io.o2.b.a(this.f0);
        }

        @Override // sdk.pendo.io.u2.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Double[] b() {
            return sdk.pendo.io.o2.b.a(this.t0);
        }
    }

    public c(T t, T t2, sdk.pendo.io.p2.k kVar, boolean z) {
        boolean z2 = false;
        sdk.pendo.io.o2.h.a(t, "lhs", new Object[0]);
        sdk.pendo.io.o2.h.a(t2, "rhs", new Object[0]);
        this.f1491a = new ArrayList();
        this.c = t;
        this.d = t2;
        this.e = kVar;
        if (z && (t == t2 || t.equals(t2))) {
            z2 = true;
        }
        this.b = z2;
    }

    public c<T> a(String str, int i2, int i3) {
        a(str);
        if (!this.b && i2 != i3) {
            this.f1491a.add(new b(str, i2, i3));
        }
        return this;
    }

    public c<T> a(String str, Object obj, Object obj2) {
        a(str);
        if (this.b || obj == obj2) {
            return this;
        }
        Object obj3 = obj != null ? obj : obj2;
        if (obj3.getClass().isArray()) {
            return obj3 instanceof boolean[] ? a(str, (boolean[]) obj, (boolean[]) obj2) : obj3 instanceof byte[] ? a(str, (byte[]) obj, (byte[]) obj2) : obj3 instanceof char[] ? a(str, (char[]) obj, (char[]) obj2) : obj3 instanceof double[] ? a(str, (double[]) obj, (double[]) obj2) : obj3 instanceof float[] ? a(str, (float[]) obj, (float[]) obj2) : obj3 instanceof int[] ? a(str, (int[]) obj, (int[]) obj2) : obj3 instanceof long[] ? a(str, (long[]) obj, (long[]) obj2) : obj3 instanceof short[] ? a(str, (short[]) obj, (short[]) obj2) : a(str, (Object[]) obj, (Object[]) obj2);
        }
        if (obj != null && obj.equals(obj2)) {
            return this;
        }
        this.f1491a.add(new f(str, obj, obj2));
        return this;
    }

    public c<T> a(String str, byte[] bArr, byte[] bArr2) {
        a(str);
        if (!this.b && !Arrays.equals(bArr, bArr2)) {
            this.f1491a.add(new i(str, bArr, bArr2));
        }
        return this;
    }

    public c<T> a(String str, char[] cArr, char[] cArr2) {
        a(str);
        if (!this.b && !Arrays.equals(cArr, cArr2)) {
            this.f1491a.add(new j(str, cArr, cArr2));
        }
        return this;
    }

    public c<T> a(String str, double[] dArr, double[] dArr2) {
        a(str);
        if (!this.b && !Arrays.equals(dArr, dArr2)) {
            this.f1491a.add(new k(str, dArr, dArr2));
        }
        return this;
    }

    public c<T> a(String str, float[] fArr, float[] fArr2) {
        a(str);
        if (!this.b && !Arrays.equals(fArr, fArr2)) {
            this.f1491a.add(new a(str, fArr, fArr2));
        }
        return this;
    }

    public c<T> a(String str, int[] iArr, int[] iArr2) {
        a(str);
        if (!this.b && !Arrays.equals(iArr, iArr2)) {
            this.f1491a.add(new C0225c(str, iArr, iArr2));
        }
        return this;
    }

    public c<T> a(String str, long[] jArr, long[] jArr2) {
        a(str);
        if (!this.b && !Arrays.equals(jArr, jArr2)) {
            this.f1491a.add(new d(str, jArr, jArr2));
        }
        return this;
    }

    public c<T> a(String str, Object[] objArr, Object[] objArr2) {
        a(str);
        if (!this.b && !Arrays.equals(objArr, objArr2)) {
            this.f1491a.add(new g(str, objArr, objArr2));
        }
        return this;
    }

    public c<T> a(String str, short[] sArr, short[] sArr2) {
        a(str);
        if (!this.b && !Arrays.equals(sArr, sArr2)) {
            this.f1491a.add(new e(str, sArr, sArr2));
        }
        return this;
    }

    public c<T> a(String str, boolean[] zArr, boolean[] zArr2) {
        a(str);
        if (!this.b && !Arrays.equals(zArr, zArr2)) {
            this.f1491a.add(new h(str, zArr, zArr2));
        }
        return this;
    }

    public sdk.pendo.io.p2.d<T> a() {
        return new sdk.pendo.io.p2.d<>(this.c, this.d, this.f1491a, this.e);
    }

    private void a(String str) {
        sdk.pendo.io.o2.h.a(str, "fieldName", new Object[0]);
    }
}
