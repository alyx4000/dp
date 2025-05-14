package sdk.pendo.io.k3;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.g;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0000\" \u0010\t\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\" \u0010\r\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"", "map", "", "a", "[B", "getBASE64", "()[B", "getBASE64$annotations", "()V", "BASE64", "b", "getBASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "BASE64_URL_SAFE", "external.sdk.pendo.io.okio"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f1284a;
    private static final byte[] b;

    static {
        g.a aVar = g.f0;
        f1284a = aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").b();
        b = aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").b();
    }

    public static final String a(byte[] bArr, byte[] map) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b2 = bArr[i];
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            byte b4 = bArr[i4];
            int i6 = i2 + 1;
            bArr2[i2] = map[(b2 & UByte.MAX_VALUE) >> 2];
            int i7 = i6 + 1;
            bArr2[i6] = map[((b2 & 3) << 4) | ((b3 & UByte.MAX_VALUE) >> 4)];
            int i8 = i7 + 1;
            bArr2[i7] = map[((b3 & 15) << 2) | ((b4 & UByte.MAX_VALUE) >> 6)];
            i2 = i8 + 1;
            bArr2[i8] = map[b4 & 63];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i];
            int i9 = i2 + 1;
            bArr2[i2] = map[(b5 & UByte.MAX_VALUE) >> 2];
            int i10 = i9 + 1;
            bArr2[i9] = map[(b5 & 3) << 4];
            bArr2[i10] = 61;
            bArr2[i10 + 1] = 61;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b6 = bArr[i];
            byte b7 = bArr[i11];
            int i12 = i2 + 1;
            bArr2[i2] = map[(b6 & UByte.MAX_VALUE) >> 2];
            int i13 = i12 + 1;
            bArr2[i12] = map[((b6 & 3) << 4) | ((b7 & UByte.MAX_VALUE) >> 4)];
            bArr2[i13] = map[(b7 & 15) << 2];
            bArr2[i13 + 1] = 61;
        }
        return d0.a(bArr2);
    }

    public static /* synthetic */ String a(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = f1284a;
        }
        return a(bArr, bArr2);
    }
}
