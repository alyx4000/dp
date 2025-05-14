package sdk.pendo.io.m3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.UByte;

/* loaded from: classes6.dex */
public class v extends a0 {
    static final o0 A = new a(v.class, 6);
    private static final ConcurrentMap<b, v> f0 = new ConcurrentHashMap();
    private final String f;
    private byte[] s;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return v.a(s1Var.k(), false);
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f1393a;
        private final byte[] b;

        b(byte[] bArr) {
            this.f1393a = sdk.pendo.io.d5.a.b(bArr);
            this.b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return sdk.pendo.io.d5.a.a(this.b, ((b) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return this.f1393a;
        }
    }

    public v(String str) {
        if (str == null) {
            throw new NullPointerException("'identifier' cannot be null");
        }
        if (!c(str)) {
            throw new IllegalArgumentException("string " + str + " not an OID");
        }
        this.f = str;
    }

    private static boolean c(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return c0.a(str, 2);
    }

    private synchronized byte[] k() {
        if (this.s == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a(byteArrayOutputStream);
            this.s = byteArrayOutputStream.toByteArray();
        }
        return this.s;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (a0Var == this) {
            return true;
        }
        if (a0Var instanceof v) {
            return this.f.equals(((v) a0Var).f);
        }
        return false;
    }

    public v b(String str) {
        return new v(this, str);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return this.f.hashCode();
    }

    public String l() {
        return this.f;
    }

    public v m() {
        b bVar = new b(k());
        ConcurrentMap<b, v> concurrentMap = f0;
        v vVar = concurrentMap.get(bVar);
        if (vVar != null) {
            return vVar;
        }
        v putIfAbsent = concurrentMap.putIfAbsent(bVar, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    public String toString() {
        return l();
    }

    v(v vVar, String str) {
        if (!c0.a(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.f = vVar.l() + "." + str;
    }

    static v a(byte[] bArr, boolean z) {
        v vVar = f0.get(new b(bArr));
        return vVar == null ? new v(bArr, z) : vVar;
    }

    v(byte[] bArr, boolean z) {
        int i;
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        BigInteger bigInteger = null;
        int i2 = 0;
        long j = 0;
        while (i2 != bArr2.length) {
            int i3 = bArr2[i2] & UByte.MAX_VALUE;
            if (j <= 72057594037927808L) {
                i = i2;
                long j2 = j + (i3 & 127);
                if ((i3 & 128) == 0) {
                    if (z2) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z2 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                    i2 = i + 1;
                } else {
                    j = j2 << 7;
                    i2 = i + 1;
                }
            } else {
                i = i2;
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf(i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z2) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80L));
                        z2 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    bigInteger = null;
                    j = 0;
                    i2 = i + 1;
                } else {
                    bigInteger = or.shiftLeft(7);
                    i2 = i + 1;
                }
            }
        }
        this.f = stringBuffer.toString();
        this.s = z ? sdk.pendo.io.d5.a.a(bArr) : bArr2;
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) {
        w2 w2Var = new w2(this.f);
        int parseInt = Integer.parseInt(w2Var.b()) * 40;
        String b2 = w2Var.b();
        if (b2.length() <= 18) {
            c0.a(byteArrayOutputStream, parseInt + Long.parseLong(b2));
        } else {
            c0.a(byteArrayOutputStream, new BigInteger(b2).add(BigInteger.valueOf(parseInt)));
        }
        while (w2Var.a()) {
            String b3 = w2Var.b();
            if (b3.length() <= 18) {
                c0.a(byteArrayOutputStream, Long.parseLong(b3));
            } else {
                c0.a(byteArrayOutputStream, new BigInteger(b3));
            }
        }
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 6, k());
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, k().length);
    }

    public static v a(Object obj) {
        if (obj == null || (obj instanceof v)) {
            return (v) obj;
        }
        if (obj instanceof g) {
            a0 b2 = ((g) obj).b();
            if (b2 instanceof v) {
                return (v) b2;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (v) A.a((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }
}
