package sdk.pendo.io.z4;

import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.v0;

/* loaded from: classes4.dex */
public class x implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final x f1889a = new x();

    @Override // sdk.pendo.io.z4.g
    public int a(int i) {
        return i;
    }

    @Override // sdk.pendo.io.z4.g
    public int a(int i, int i2) {
        return i;
    }

    @Override // sdk.pendo.io.z4.g
    public n a(long j, short s, v0 v0Var, byte[] bArr, int i, int i2) {
        return new n(bArr, i, i2, s);
    }

    @Override // sdk.pendo.io.z4.g
    public boolean a() {
        return false;
    }

    @Override // sdk.pendo.io.z4.g
    public int b(int i) {
        return i;
    }

    @Override // sdk.pendo.io.z4.g
    public void c() {
        throw new h2((short) 80);
    }

    @Override // sdk.pendo.io.z4.g
    public q a(long j, short s, v0 v0Var, int i, byte[] bArr, int i2, int i3) {
        int i4 = i + i3;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, i, i3);
        return new q(bArr2, 0, i4, s);
    }

    @Override // sdk.pendo.io.z4.g
    public void b() {
        throw new h2((short) 80);
    }
}
