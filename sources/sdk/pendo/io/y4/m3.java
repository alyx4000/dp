package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encoding;

/* loaded from: classes4.dex */
public class m3 {

    /* renamed from: a, reason: collision with root package name */
    protected short f1789a;
    protected Object b;

    public m3(short s, Object obj) {
        if (!a(s, obj)) {
            throw new IllegalArgumentException("'identifier' is not an instance of the correct type");
        }
        this.f1789a = s;
        this.b = obj;
    }

    protected void a(short s) {
        if (this.f1789a != s || !a(s, this.b)) {
            throw new IllegalStateException("TrustedAuthority is not of type " + j0.a(s));
        }
    }

    public sdk.pendo.io.c4.c b() {
        a((short) 2);
        return (sdk.pendo.io.c4.c) this.b;
    }

    public void a(OutputStream outputStream) {
        l3.a(this.f1789a, outputStream);
        short s = this.f1789a;
        if (s != 0) {
            if (s != 1) {
                if (s == 2) {
                    l3.a(((sdk.pendo.io.c4.c) this.b).a(ASN1Encoding.DER), outputStream);
                    return;
                } else if (s != 3) {
                    throw new h2((short) 80);
                }
            }
            outputStream.write((byte[]) this.b);
        }
    }

    public short a() {
        return this.f1789a;
    }

    protected static boolean a(short s, Object obj) {
        if (s == 0) {
            return obj == null;
        }
        if (s != 1) {
            if (s == 2) {
                return obj instanceof sdk.pendo.io.c4.c;
            }
            if (s != 3) {
                throw new IllegalArgumentException("'identifierType' is an unsupported IdentifierType");
            }
        }
        return a(obj);
    }

    protected static boolean a(Object obj) {
        return (obj instanceof byte[]) && ((byte[]) obj).length == 20;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [sdk.pendo.io.c4.c, sdk.pendo.io.m3.t] */
    public static m3 a(InputStream inputStream) {
        byte[] bArr;
        short g = l3.g(inputStream);
        if (g != 0) {
            if (g != 1) {
                if (g == 2) {
                    byte[] a2 = l3.a(inputStream, 1);
                    ?? a3 = sdk.pendo.io.c4.c.a(l3.h(a2));
                    l3.a((sdk.pendo.io.m3.t) a3, a2);
                    bArr = a3;
                } else if (g != 3) {
                    throw new h2((short) 50);
                }
            }
            bArr = l3.a(20, inputStream);
        } else {
            bArr = null;
        }
        return new m3(g, bArr);
    }
}
