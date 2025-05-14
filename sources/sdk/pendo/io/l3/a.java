package sdk.pendo.io.l3;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.d;
import sdk.pendo.io.k3.d0;
import sdk.pendo.io.k3.r;
import sdk.pendo.io.k3.v;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0004\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001aA\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u001a\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\" \u0010\u0018\u001a\u00020\u00138\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u0014\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0004\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/k3/d;", "", "newline", "", "a", "Lsdk/pendo/io/k3/r;", "options", "", "selectTruncated", "", "Lsdk/pendo/io/k3/d$a;", "unsafeCursor", ExifInterface.GPS_DIRECTION_TRUE, "fromIndex", "Lkotlin/Function2;", "Lsdk/pendo/io/k3/v;", "lambda", "seek", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "", "[B", "()[B", "getHEX_DIGIT_BYTES$annotations", "()V", "HEX_DIGIT_BYTES", "external.sdk.pendo.io.okio"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f1314a = d0.a("0123456789abcdef");

    public static final d.a a(d dVar, d.a unsafeCursor) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        d.a a2 = sdk.pendo.io.k3.b.a(unsafeCursor);
        if (!(a2.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        a2.buffer = dVar;
        a2.readWrite = true;
        return a2;
    }

    public static final byte[] a() {
        return f1314a;
    }

    public static final String a(d dVar, long j) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (dVar.h(j2) == 13) {
                String i = dVar.i(j2);
                dVar.skip(2L);
                return i;
            }
        }
        String i2 = dVar.i(j);
        dVar.skip(1L);
        return i2;
    }

    public static final int a(d dVar, r options, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        v vVar;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        v vVar2 = dVar.head;
        if (vVar2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = vVar2.data;
        int i5 = vVar2.pos;
        int i6 = vVar2.limit;
        int[] trie = options.getTrie();
        v vVar3 = vVar2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int i10 = trie[i8];
            int i11 = i9 + 1;
            int i12 = trie[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (vVar3 == null) {
                break;
            }
            if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & UByte.MAX_VALUE;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == trie[i11]) {
                        i2 = trie[i11 + i10];
                        if (i == i6) {
                            vVar3 = vVar3.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                            Intrinsics.checkNotNull(vVar3);
                            i = vVar3.pos;
                            bArr = vVar3.data;
                            i6 = vVar3.limit;
                            if (vVar3 == vVar2) {
                                vVar3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            int i15 = i11 + (i10 * (-1));
            while (true) {
                int i16 = i5 + 1;
                int i17 = i11 + 1;
                if ((bArr[i5] & UByte.MAX_VALUE) != trie[i11]) {
                    return i7;
                }
                boolean z2 = i17 == i15;
                if (i16 == i6) {
                    Intrinsics.checkNotNull(vVar3);
                    v vVar4 = vVar3.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    Intrinsics.checkNotNull(vVar4);
                    i4 = vVar4.pos;
                    byte[] bArr2 = vVar4.data;
                    i3 = vVar4.limit;
                    if (vVar4 != vVar2) {
                        vVar = vVar4;
                        bArr = bArr2;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        bArr = bArr2;
                        vVar = null;
                    }
                } else {
                    v vVar5 = vVar3;
                    i3 = i6;
                    i4 = i16;
                    vVar = vVar5;
                }
                if (z2) {
                    i2 = trie[i17];
                    i = i4;
                    i6 = i3;
                    vVar3 = vVar;
                    break;
                }
                i5 = i4;
                i6 = i3;
                i11 = i17;
                vVar3 = vVar;
            }
            if (i2 >= 0) {
                return i2;
            }
            i8 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i7;
    }

    public static /* synthetic */ int a(d dVar, r rVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(dVar, rVar, z);
    }
}
