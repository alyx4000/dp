package sdk.pendo.io.k3;

import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.tensorflow.lite.schema.BuiltinOptions;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0016\u0018\u0000 72\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0005B\u0011\b\u0000\u0012\u0006\u0010(\u001a\u00020\u0014¢\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\u0007\u001a\u00020\u0000J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0010¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0000H\u0016J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0087\u0002¢\u0006\u0004\b\u0005\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000f\u0010\u0016\u001a\u00020\u0014H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0005\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0010¢\u0006\u0004\b\u0005\u0010\u001dJ(\u0010\u0005\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J(\u0010\u0005\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0000J\u0013\u0010#\u001a\u00020 2\b\u0010\u001e\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010$\u001a\u00020\fH\u0016J\u0011\u0010\u0005\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0000H\u0096\u0002J\b\u0010%\u001a\u00020\u0003H\u0016R\u001a\u0010(\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u000f\u0010\u0017R\"\u0010$\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0013\"\u0004\b+\u0010,R$\u00102\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b\u000f\u00101R\u0011\u00104\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b3\u0010\u0013¨\u00068"}, d2 = {"Lsdk/pendo/io/k3/g;", "Ljava/io/Serializable;", "", "", "o", "a", "j", "k", "algorithm", "(Ljava/lang/String;)Lsdk/pendo/io/k3/g;", "h", "m", "", "pos", "", "b", "(I)B", "index", "e", "()I", "", "n", ContextChain.TAG_INFRA, "()[B", "Lsdk/pendo/io/k3/d;", "buffer", "offset", "byteCount", "", "(Lsdk/pendo/io/k3/d;II)V", "other", "otherOffset", "", "prefix", "", "equals", "hashCode", "toString", "f", "[B", "data", "s", "I", "c", "(I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/String;", "g", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "utf8", "l", "size", "<init>", "([B)V", "f0", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public class g implements Serializable, Comparable<g> {

    /* renamed from: f0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final g t0 = new g(new byte[0]);

    /* renamed from: A, reason: from kotlin metadata */
    private transient String utf8;

    /* renamed from: f, reason: from kotlin metadata */
    private final byte[] data;

    /* renamed from: s, reason: from kotlin metadata */
    private transient int hashCode;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003H\u0007J'\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\f\u0010\f\u001a\u00020\u0005*\u00020\u000bH\u0007J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0006\u0010\u000fJ\f\u0010\u0006\u001a\u00020\u0005*\u00020\u000bH\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/k3/g$a;", "", "", "", "data", "Lsdk/pendo/io/k3/g;", "a", "", "offset", "byteCount", "([BII)Lsdk/pendo/io/k3/g;", "", "b", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lsdk/pendo/io/k3/g;", "EMPTY", "Lsdk/pendo/io/k3/g;", "", "serialVersionUID", "J", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.k3.g$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final g a(String str) {
            int b;
            int b2;
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                b = sdk.pendo.io.l3.b.b(str.charAt(i2));
                b2 = sdk.pendo.io.l3.b.b(str.charAt(i2 + 1));
                bArr[i] = (byte) ((b << 4) + b2);
            }
            return new g(bArr);
        }

        @JvmStatic
        public final g b(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            g gVar = new g(d0.a(str));
            gVar.b(str);
            return gVar;
        }

        @JvmStatic
        public final g a(String str, Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new g(bytes);
        }

        @JvmStatic
        public final g a(byte... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            return new g(copyOf);
        }

        @JvmStatic
        public final g a(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            int a2 = b.a(bArr, i2);
            b.a(bArr.length, i, a2);
            return new g(ArraysKt.copyOfRange(bArr, i, a2 + i));
        }

        public static /* synthetic */ g a(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = b.a();
            }
            return companion.a(bArr, i, i2);
        }
    }

    public g(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public String a() {
        return a.a(getData(), null, 1, null);
    }

    /* renamed from: b, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int e() {
        return getData().length;
    }

    public boolean equals(Object other) {
        if (other != this) {
            if (!(other instanceof g)) {
                return false;
            }
            g gVar = (g) other;
            if (gVar.l() != getData().length || !gVar.a(0, getData(), 0, getData().length)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public String h() {
        char[] cArr = new char[getData().length * 2];
        int i = 0;
        for (byte b : getData()) {
            int i2 = i + 1;
            cArr[i] = sdk.pendo.io.l3.b.a()[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = sdk.pendo.io.l3.b.a()[b & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = Arrays.hashCode(getData());
        c(hashCode2);
        return hashCode2;
    }

    public byte[] i() {
        return getData();
    }

    public final g j() {
        return a("SHA-1");
    }

    public final g k() {
        return a("SHA-256");
    }

    public final int l() {
        return e();
    }

    public g m() {
        for (int i = 0; i < getData().length; i++) {
            byte b = getData()[i];
            if (b >= 65 && b <= 90) {
                byte[] data = getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b + BuiltinOptions.StridedSliceOptions);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        copyOf[i2] = (byte) (b2 + BuiltinOptions.StridedSliceOptions);
                    }
                }
                return new g(copyOf);
            }
        }
        return this;
    }

    public byte[] n() {
        byte[] data = getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public String o() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String a2 = d0.a(i());
        b(a2);
        return a2;
    }

    public String toString() {
        int b;
        StringBuilder append;
        StringBuilder append2;
        String str;
        if (!(getData().length == 0)) {
            b = sdk.pendo.io.l3.b.b(getData(), 64);
            if (b != -1) {
                String o = o();
                String substring = o.substring(0, b);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
                if (b >= o.length()) {
                    append = new StringBuilder("[text=").append(replace$default).append(']');
                    return append.toString();
                }
                append2 = new StringBuilder("[size=").append(getData().length).append(" text=").append(replace$default);
            } else if (getData().length <= 64) {
                str = "[hex=" + h() + ']';
            } else {
                StringBuilder append3 = new StringBuilder("[size=").append(getData().length).append(" hex=");
                int a2 = b.a(this, 64);
                if (!(a2 <= getData().length)) {
                    throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
                }
                if (!(a2 + 0 >= 0)) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                append2 = append3.append((a2 == getData().length ? this : new g(ArraysKt.copyOfRange(getData(), 0, a2))).h());
            }
            append = append2.append("…]");
            return append.toString();
        }
        str = "[size=0]";
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(sdk.pendo.io.k3.g r8) {
        /*
            r7 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            int r0 = r7.l()
            int r1 = r8.l()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            if (r4 >= r2) goto L29
            byte r5 = r7.a(r4)
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r6 = r8.a(r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r5 != r6) goto L26
            int r4 = r4 + 1
            goto L13
        L26:
            if (r5 >= r6) goto L30
            goto L2e
        L29:
            if (r0 != r1) goto L2c
            goto L31
        L2c:
            if (r0 >= r1) goto L30
        L2e:
            r3 = -1
            goto L31
        L30:
            r3 = 1
        L31:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.k3.g.compareTo(sdk.pendo.io.k3.g):int");
    }

    public byte b(int pos) {
        return getData()[pos];
    }

    public final void c(int i) {
        this.hashCode = i;
    }

    public g a(String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, l());
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNull(digest);
        return new g(digest);
    }

    public final void b(String str) {
        this.utf8 = str;
    }

    public final byte a(int index) {
        return b(index);
    }

    public final boolean b(g prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return a(0, prefix, 0, prefix.l());
    }

    @JvmStatic
    public static final g a(byte... bArr) {
        return INSTANCE.a(bArr);
    }

    public boolean a(int offset, g other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.a(otherOffset, getData(), offset, byteCount);
    }

    public boolean a(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && b.a(getData(), offset, other, otherOffset, byteCount);
    }

    public void a(d buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        sdk.pendo.io.l3.b.a(this, buffer, offset, byteCount);
    }
}
