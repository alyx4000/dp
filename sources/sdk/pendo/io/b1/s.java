package sdk.pendo.io.b1;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private String f880a;
    private int b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private byte[] f881a;
        private byte[] b;
    }

    public s(String str, int i) {
        this.f880a = str;
        this.b = i;
    }

    public byte[] a(Key key, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, String str) {
        return a(bArr2, bArr3, bArr4, a(key, bArr, 2, str));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, Cipher cipher) {
        a(cipher, bArr3);
        try {
            return cipher.doFinal(sdk.pendo.io.k1.a.a(bArr, bArr2));
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new sdk.pendo.io.k1.g(e.toString(), e);
        }
    }

    public a a(Key key, byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        Cipher a2 = a(key, bArr, 1, str);
        a(a2, bArr3);
        try {
            byte[] doFinal = a2.doFinal(bArr2);
            a aVar = new a();
            int length = doFinal.length - this.b;
            aVar.f881a = sdk.pendo.io.k1.a.a(doFinal, 0, length);
            aVar.b = sdk.pendo.io.k1.a.a(doFinal, length, this.b);
            return aVar;
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new sdk.pendo.io.k1.g(e.toString(), e);
        }
    }

    public Cipher a(Key key, byte[] bArr, int i, String str) {
        Cipher a2 = f.a(this.f880a, str);
        try {
            a2.init(i, key, new GCMParameterSpec(sdk.pendo.io.k1.a.a(this.b), bArr));
            return a2;
        } catch (InvalidAlgorithmParameterException e) {
            throw new sdk.pendo.io.k1.g(e.toString(), e);
        } catch (InvalidKeyException e2) {
            throw new sdk.pendo.io.k1.g("Invalid key for " + this.f880a, e2);
        }
    }

    public boolean a(sdk.pendo.io.h7.a aVar, int i, int i2, String str) {
        if (e.a(this.f880a, i)) {
            byte[] bArr = {BuiltinOptions.ReadVariableOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.Rfft2dOptions, BuiltinOptions.HashtableSizeOptions, BuiltinOptions.GeluOptions, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.GeluOptions};
            byte[] bArr2 = {BuiltinOptions.ScatterNdOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.SegmentSumOptions};
            byte[] d = sdk.pendo.io.k1.a.d(i);
            try {
                a(new sdk.pendo.io.i1.a(d), sdk.pendo.io.k1.a.d(i2), bArr, bArr2, null);
                return true;
            } catch (Throwable th) {
                aVar.a("{} is not available ({}).", str, sdk.pendo.io.k1.b.a(th));
            }
        }
        return false;
    }

    private void a(Cipher cipher, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        cipher.updateAAD(bArr);
    }
}
