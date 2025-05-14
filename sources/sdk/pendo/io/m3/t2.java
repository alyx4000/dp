package sdk.pendo.io.m3;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
class t2 implements Enumeration {

    /* renamed from: a, reason: collision with root package name */
    private p f1392a;
    private Object b = a();

    public t2(byte[] bArr) {
        this.f1392a = new p(bArr, true);
    }

    private Object a() {
        try {
            return this.f1392a.b();
        } catch (IOException e) {
            throw new z("malformed ASN.1: " + e, e);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.b != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.b;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.b = a();
        return obj;
    }
}
