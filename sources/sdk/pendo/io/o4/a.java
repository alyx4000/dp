package sdk.pendo.io.o4;

import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes6.dex */
public class a extends IvParameterSpec {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f1459a;
    private final int b;

    public a(byte[] bArr, int i, byte[] bArr2) {
        super(bArr);
        this.b = i;
        this.f1459a = sdk.pendo.io.d5.a.a(bArr2);
    }
}
