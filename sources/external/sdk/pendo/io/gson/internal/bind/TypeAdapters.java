package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.j;
import sdk.pendo.io.k0.k;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.k0.n;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.l0.c;
import sdk.pendo.io.m0.f;
import sdk.pendo.io.r0.b;

/* loaded from: classes2.dex */
public final class TypeAdapters {
    public static final TypeAdapter<BigInteger> A;
    public static final TypeAdapter<f> B;
    public static final u C;
    public static final TypeAdapter<StringBuilder> D;
    public static final u E;
    public static final TypeAdapter<StringBuffer> F;
    public static final u G;
    public static final TypeAdapter<URL> H;
    public static final u I;
    public static final TypeAdapter<URI> J;
    public static final u K;
    public static final TypeAdapter<InetAddress> L;
    public static final u M;
    public static final TypeAdapter<UUID> N;
    public static final u O;
    public static final TypeAdapter<Currency> P;
    public static final u Q;
    public static final TypeAdapter<Calendar> R;
    public static final u S;
    public static final TypeAdapter<Locale> T;
    public static final u U;
    public static final TypeAdapter<i> V;
    public static final u W;
    public static final u X;

    /* renamed from: a, reason: collision with root package name */
    public static final TypeAdapter<Class> f741a;
    public static final u b;
    public static final TypeAdapter<BitSet> c;
    public static final u d;
    public static final TypeAdapter<Boolean> e;
    public static final TypeAdapter<Boolean> f;
    public static final u g;
    public static final TypeAdapter<Number> h;
    public static final u i;
    public static final TypeAdapter<Number> j;
    public static final u k;
    public static final TypeAdapter<Number> l;
    public static final u m;
    public static final TypeAdapter<AtomicInteger> n;
    public static final u o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final u q;
    public static final TypeAdapter<AtomicIntegerArray> r;
    public static final u s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Character> w;
    public static final u x;
    public static final TypeAdapter<String> y;
    public static final TypeAdapter<BigDecimal> z;

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, T> f743a = new HashMap();
        private final Map<T, String> b = new HashMap();

        class a implements PrivilegedAction<Field[]> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f744a;

            a(Class cls) {
                this.f744a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.f744a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String name = r4.name();
                    c cVar = (c) field.getAnnotation(c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f743a.put(str, r4);
                        }
                    }
                    this.f743a.put(name, r4);
                    this.b.put(r4, name);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public T a(sdk.pendo.io.r0.a aVar) {
            if (aVar.D() != b.NULL) {
                return this.f743a.get(aVar.B());
            }
            aVar.A();
            return null;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.r0.c cVar, T t) {
            cVar.e(t == null ? null : this.b.get(t));
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f745a;

        static {
            int[] iArr = new int[b.values().length];
            f745a = iArr;
            try {
                iArr[b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f745a[b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f745a[b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f745a[b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f745a[b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f745a[b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f745a[b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f745a[b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f745a[b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f745a[b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        TypeAdapter<Class> a2 = new TypeAdapter<Class>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.1
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Class a(sdk.pendo.io.r0.a aVar) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Class cls) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
        }.a();
        f741a = a2;
        b = a(Class.class, a2);
        TypeAdapter<BitSet> a3 = new TypeAdapter<BitSet>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.2
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BitSet a(sdk.pendo.io.r0.a aVar) {
                BitSet bitSet = new BitSet();
                aVar.a();
                b D2 = aVar.D();
                int i2 = 0;
                while (D2 != b.END_ARRAY) {
                    int i3 = a.f745a[D2.ordinal()];
                    boolean z2 = true;
                    if (i3 == 1 || i3 == 2) {
                        int x2 = aVar.x();
                        if (x2 == 0) {
                            z2 = false;
                        } else if (x2 != 1) {
                            throw new q("Invalid bitset value " + x2 + ", expected 0 or 1; at path " + aVar.r());
                        }
                    } else {
                        if (i3 != 3) {
                            throw new q("Invalid bitset value type: " + D2 + "; at path " + aVar.q());
                        }
                        z2 = aVar.v();
                    }
                    if (z2) {
                        bitSet.set(i2);
                    }
                    i2++;
                    D2 = aVar.D();
                }
                aVar.o();
                return bitSet;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, BitSet bitSet) {
                cVar.e();
                int length = bitSet.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.h(bitSet.get(i2) ? 1L : 0L);
                }
                cVar.n();
            }
        }.a();
        c = a3;
        d = a(BitSet.class, a3);
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.3
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(sdk.pendo.io.r0.a aVar) {
                b D2 = aVar.D();
                if (D2 != b.NULL) {
                    return D2 == b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.B())) : Boolean.valueOf(aVar.v());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Boolean bool) {
                cVar.a(bool);
            }
        };
        e = typeAdapter;
        f = new TypeAdapter<Boolean>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.4
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return Boolean.valueOf(aVar.B());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Boolean bool) {
                cVar.e(bool == null ? "null" : bool.toString());
            }
        };
        g = a(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter<Number> typeAdapter2 = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.5
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                try {
                    int x2 = aVar.x();
                    if (x2 > 255 || x2 < -128) {
                        throw new q("Lossy conversion from " + x2 + " to byte; at path " + aVar.r());
                    }
                    return Byte.valueOf((byte) x2);
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Number number) {
                cVar.a(number);
            }
        };
        h = typeAdapter2;
        i = a(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter<Number> typeAdapter3 = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.6
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                try {
                    int x2 = aVar.x();
                    if (x2 > 65535 || x2 < -32768) {
                        throw new q("Lossy conversion from " + x2 + " to short; at path " + aVar.r());
                    }
                    return Short.valueOf((short) x2);
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Number number) {
                cVar.a(number);
            }
        };
        j = typeAdapter3;
        k = a(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.7
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.x());
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Number number) {
                cVar.a(number);
            }
        };
        l = typeAdapter4;
        m = a(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter<AtomicInteger> a4 = new TypeAdapter<AtomicInteger>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.8
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicInteger a(sdk.pendo.io.r0.a aVar) {
                try {
                    return new AtomicInteger(aVar.x());
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, AtomicInteger atomicInteger) {
                cVar.h(atomicInteger.get());
            }
        }.a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        TypeAdapter<AtomicBoolean> a5 = new TypeAdapter<AtomicBoolean>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.9
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicBoolean a(sdk.pendo.io.r0.a aVar) {
                return new AtomicBoolean(aVar.v());
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, AtomicBoolean atomicBoolean) {
                cVar.d(atomicBoolean.get());
            }
        }.a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        TypeAdapter<AtomicIntegerArray> a6 = new TypeAdapter<AtomicIntegerArray>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.10
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicIntegerArray a(sdk.pendo.io.r0.a aVar) {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.s()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.x()));
                    } catch (NumberFormatException e2) {
                        throw new q(e2);
                    }
                }
                aVar.o();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, AtomicIntegerArray atomicIntegerArray) {
                cVar.e();
                int length = atomicIntegerArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.h(atomicIntegerArray.get(i2));
                }
                cVar.n();
            }
        }.a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        t = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.11
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.y());
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Number number) {
                cVar.a(number);
            }
        };
        u = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.12
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return Float.valueOf((float) aVar.w());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Number number) {
                cVar.a(number);
            }
        };
        v = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.13
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return Double.valueOf(aVar.w());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Number number) {
                cVar.a(number);
            }
        };
        TypeAdapter<Character> typeAdapter5 = new TypeAdapter<Character>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.14
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Character a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                String B2 = aVar.B();
                if (B2.length() == 1) {
                    return Character.valueOf(B2.charAt(0));
                }
                throw new q("Expecting character, got: " + B2 + "; at " + aVar.r());
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Character ch) {
                cVar.e(ch == null ? null : String.valueOf(ch));
            }
        };
        w = typeAdapter5;
        x = a(Character.TYPE, Character.class, typeAdapter5);
        TypeAdapter<String> typeAdapter6 = new TypeAdapter<String>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.15
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public String a(sdk.pendo.io.r0.a aVar) {
                b D2 = aVar.D();
                if (D2 != b.NULL) {
                    return D2 == b.BOOLEAN ? Boolean.toString(aVar.v()) : aVar.B();
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, String str) {
                cVar.e(str);
            }
        };
        y = typeAdapter6;
        z = new TypeAdapter<BigDecimal>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.16
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                String B2 = aVar.B();
                try {
                    return new BigDecimal(B2);
                } catch (NumberFormatException e2) {
                    throw new q("Failed parsing '" + B2 + "' as BigDecimal; at path " + aVar.r(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, BigDecimal bigDecimal) {
                cVar.a(bigDecimal);
            }
        };
        A = new TypeAdapter<BigInteger>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.17
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigInteger a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                String B2 = aVar.B();
                try {
                    return new BigInteger(B2);
                } catch (NumberFormatException e2) {
                    throw new q("Failed parsing '" + B2 + "' as BigInteger; at path " + aVar.r(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, BigInteger bigInteger) {
                cVar.a(bigInteger);
            }
        };
        B = new TypeAdapter<f>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.18
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return new f(aVar.B());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, f fVar) {
                cVar.a(fVar);
            }
        };
        C = a(String.class, typeAdapter6);
        TypeAdapter<StringBuilder> typeAdapter7 = new TypeAdapter<StringBuilder>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.19
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public StringBuilder a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return new StringBuilder(aVar.B());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, StringBuilder sb) {
                cVar.e(sb == null ? null : sb.toString());
            }
        };
        D = typeAdapter7;
        E = a(StringBuilder.class, typeAdapter7);
        TypeAdapter<StringBuffer> typeAdapter8 = new TypeAdapter<StringBuffer>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.20
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public StringBuffer a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return new StringBuffer(aVar.B());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, StringBuffer stringBuffer) {
                cVar.e(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        F = typeAdapter8;
        G = a(StringBuffer.class, typeAdapter8);
        TypeAdapter<URL> typeAdapter9 = new TypeAdapter<URL>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.21
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public URL a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                String B2 = aVar.B();
                if ("null".equals(B2)) {
                    return null;
                }
                return new URL(B2);
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, URL url) {
                cVar.e(url == null ? null : url.toExternalForm());
            }
        };
        H = typeAdapter9;
        I = a(URL.class, typeAdapter9);
        TypeAdapter<URI> typeAdapter10 = new TypeAdapter<URI>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.22
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public URI a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                try {
                    String B2 = aVar.B();
                    if ("null".equals(B2)) {
                        return null;
                    }
                    return new URI(B2);
                } catch (URISyntaxException e2) {
                    throw new j(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, URI uri) {
                cVar.e(uri == null ? null : uri.toASCIIString());
            }
        };
        J = typeAdapter10;
        K = a(URI.class, typeAdapter10);
        TypeAdapter<InetAddress> typeAdapter11 = new TypeAdapter<InetAddress>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.23
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InetAddress a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return InetAddress.getByName(aVar.B());
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, InetAddress inetAddress) {
                cVar.e(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        L = typeAdapter11;
        M = b(InetAddress.class, typeAdapter11);
        TypeAdapter<UUID> typeAdapter12 = new TypeAdapter<UUID>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.24
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public UUID a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                String B2 = aVar.B();
                try {
                    return UUID.fromString(B2);
                } catch (IllegalArgumentException e2) {
                    throw new q("Failed parsing '" + B2 + "' as UUID; at path " + aVar.r(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, UUID uuid) {
                cVar.e(uuid == null ? null : uuid.toString());
            }
        };
        N = typeAdapter12;
        O = a(UUID.class, typeAdapter12);
        TypeAdapter<Currency> a7 = new TypeAdapter<Currency>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.25
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Currency a(sdk.pendo.io.r0.a aVar) {
                String B2 = aVar.B();
                try {
                    return Currency.getInstance(B2);
                } catch (IllegalArgumentException e2) {
                    throw new q("Failed parsing '" + B2 + "' as Currency; at path " + aVar.r(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Currency currency) {
                cVar.e(currency.getCurrencyCode());
            }
        }.a();
        P = a7;
        Q = a(Currency.class, a7);
        TypeAdapter<Calendar> typeAdapter13 = new TypeAdapter<Calendar>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.26
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Calendar a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                aVar.b();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.D() != b.END_OBJECT) {
                    String z2 = aVar.z();
                    int x2 = aVar.x();
                    if ("year".equals(z2)) {
                        i2 = x2;
                    } else if ("month".equals(z2)) {
                        i3 = x2;
                    } else if ("dayOfMonth".equals(z2)) {
                        i4 = x2;
                    } else if ("hourOfDay".equals(z2)) {
                        i5 = x2;
                    } else if ("minute".equals(z2)) {
                        i6 = x2;
                    } else if ("second".equals(z2)) {
                        i7 = x2;
                    }
                }
                aVar.p();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Calendar calendar) {
                if (calendar == null) {
                    cVar.s();
                    return;
                }
                cVar.m();
                cVar.b("year");
                cVar.h(calendar.get(1));
                cVar.b("month");
                cVar.h(calendar.get(2));
                cVar.b("dayOfMonth");
                cVar.h(calendar.get(5));
                cVar.b("hourOfDay");
                cVar.h(calendar.get(11));
                cVar.b("minute");
                cVar.h(calendar.get(12));
                cVar.b("second");
                cVar.h(calendar.get(13));
                cVar.o();
            }
        };
        R = typeAdapter13;
        S = b(Calendar.class, GregorianCalendar.class, typeAdapter13);
        TypeAdapter<Locale> typeAdapter14 = new TypeAdapter<Locale>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.27
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Locale a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() == b.NULL) {
                    aVar.A();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.B(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, Locale locale) {
                cVar.e(locale == null ? null : locale.toString());
            }
        };
        T = typeAdapter14;
        U = a(Locale.class, typeAdapter14);
        TypeAdapter<i> typeAdapter15 = new TypeAdapter<i>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.28
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i a(sdk.pendo.io.r0.a aVar) {
                if (aVar instanceof external.sdk.pendo.io.gson.internal.bind.a) {
                    return ((external.sdk.pendo.io.gson.internal.bind.a) aVar).K();
                }
                switch (a.f745a[aVar.D().ordinal()]) {
                    case 1:
                        return new n(new f(aVar.B()));
                    case 2:
                        return new n(aVar.B());
                    case 3:
                        return new n(Boolean.valueOf(aVar.v()));
                    case 4:
                        aVar.A();
                        return k.f;
                    case 5:
                        sdk.pendo.io.k0.f fVar = new sdk.pendo.io.k0.f();
                        aVar.a();
                        while (aVar.s()) {
                            fVar.a(a(aVar));
                        }
                        aVar.o();
                        return fVar;
                    case 6:
                        l lVar = new l();
                        aVar.b();
                        while (aVar.s()) {
                            lVar.a(aVar.z(), a(aVar));
                        }
                        aVar.p();
                        return lVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.r0.c cVar, i iVar) {
                if (iVar == null || iVar.i()) {
                    cVar.s();
                    return;
                }
                if (iVar.k()) {
                    n f2 = iVar.f();
                    if (f2.p()) {
                        cVar.a(f2.n());
                        return;
                    } else if (f2.o()) {
                        cVar.d(f2.a());
                        return;
                    } else {
                        cVar.e(f2.g());
                        return;
                    }
                }
                if (iVar.h()) {
                    cVar.e();
                    Iterator<i> it = iVar.d().iterator();
                    while (it.hasNext()) {
                        a(cVar, it.next());
                    }
                    cVar.n();
                    return;
                }
                if (!iVar.j()) {
                    throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
                }
                cVar.m();
                for (Map.Entry<String, i> entry : iVar.e().l()) {
                    cVar.b(entry.getKey());
                    a(cVar, entry.getValue());
                }
                cVar.o();
            }
        };
        V = typeAdapter15;
        W = b(i.class, typeAdapter15);
        X = new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.29
            @Override // sdk.pendo.io.k0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
                Class<? super T> a8 = aVar.a();
                if (!Enum.class.isAssignableFrom(a8) || a8 == Enum.class) {
                    return null;
                }
                if (!a8.isEnum()) {
                    a8 = a8.getSuperclass();
                }
                return new EnumTypeAdapter(a8);
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.31
            @Override // sdk.pendo.io.k0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
                if (aVar.a() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> u b(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.33
            @Override // sdk.pendo.io.k0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.32
            @Override // sdk.pendo.io.k0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> u b(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.34
            @Override // sdk.pendo.io.k0.u
            public <T2> TypeAdapter<T2> a(Gson gson, sdk.pendo.io.q0.a<T2> aVar) {
                final Class<? super T2> a2 = aVar.a();
                if (cls.isAssignableFrom(a2)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.34.1
                        @Override // external.sdk.pendo.io.gson.TypeAdapter
                        public T1 a(sdk.pendo.io.r0.a aVar2) {
                            T1 t1 = (T1) typeAdapter.a(aVar2);
                            if (t1 == null || a2.isInstance(t1)) {
                                return t1;
                            }
                            throw new q("Expected a " + a2.getName() + " but was " + t1.getClass().getName() + "; at path " + aVar2.r());
                        }

                        @Override // external.sdk.pendo.io.gson.TypeAdapter
                        public void a(sdk.pendo.io.r0.c cVar, T1 t1) {
                            typeAdapter.a(cVar, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> u a(final sdk.pendo.io.q0.a<TT> aVar, final TypeAdapter<TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.30
            @Override // sdk.pendo.io.k0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar2) {
                if (aVar2.equals(sdk.pendo.io.q0.a.this)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }
}
