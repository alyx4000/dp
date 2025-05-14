package sdk.pendo.io.k3;

import com.facebook.common.callercontext.ContextChain;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100!\u0012\u0006\u0010,\u001a\u00020'¢\u0006\u0004\b-\u0010.J\b\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\u0017\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003H\u0010¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0010H\u0016J'\u0010\u0004\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0004\u0010\u0017J(\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016J(\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u000f\u0010\u001b\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010,\u001a\u00020'8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lsdk/pendo/io/k3/x;", "Lsdk/pendo/io/k3/g;", "r", "", "a", "h", "m", "algorithm", "(Ljava/lang/String;)Lsdk/pendo/io/k3/g;", "", "pos", "", "b", "(I)B", "e", "()I", "", "n", "Lsdk/pendo/io/k3/d;", "buffer", "offset", "byteCount", "", "(Lsdk/pendo/io/k3/d;II)V", "other", "otherOffset", "", ContextChain.TAG_INFRA, "()[B", "", "equals", "hashCode", "toString", "", "u0", "[[B", "q", "()[[B", "segments", "", "v0", "[I", ContextChain.TAG_PRODUCT, "()[I", "directory", "<init>", "([[B[I)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class x extends g {

    /* renamed from: u0, reason: from kotlin metadata */
    private final transient byte[][] segments;

    /* renamed from: v0, reason: from kotlin metadata */
    private final transient int[] directory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(byte[][] segments, int[] directory) {
        super(g.t0.getData());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final g r() {
        return new g(n());
    }

    @Override // sdk.pendo.io.k3.g
    public String a() {
        return r().a();
    }

    @Override // sdk.pendo.io.k3.g
    public byte b(int pos) {
        b.a(getDirectory()[getSegments().length - 1], pos, 1L);
        int a2 = sdk.pendo.io.l3.c.a(this, pos);
        return getSegments()[a2][(pos - (a2 == 0 ? 0 : getDirectory()[a2 - 1])) + getDirectory()[getSegments().length + a2]];
    }

    @Override // sdk.pendo.io.k3.g
    public int e() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // sdk.pendo.io.k3.g
    public boolean equals(Object other) {
        if (other != this) {
            if (!(other instanceof g)) {
                return false;
            }
            g gVar = (g) other;
            if (gVar.l() != l() || !a(0, gVar, 0, l())) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.k3.g
    public String h() {
        return r().h();
    }

    @Override // sdk.pendo.io.k3.g
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory()[length + i];
            int i5 = getDirectory()[i];
            byte[] bArr = getSegments()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        c(i2);
        return i2;
    }

    @Override // sdk.pendo.io.k3.g
    public byte[] i() {
        return n();
    }

    @Override // sdk.pendo.io.k3.g
    public g m() {
        return r().m();
    }

    @Override // sdk.pendo.io.k3.g
    public byte[] n() {
        byte[] bArr = new byte[l()];
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory()[length + i];
            int i5 = getDirectory()[i];
            int i6 = i5 - i3;
            ArraysKt.copyInto(getSegments()[i], bArr, i2, i4, i4 + i6);
            i2 += i6;
            i++;
            i3 = i5;
        }
        return bArr;
    }

    /* renamed from: p, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    /* renamed from: q, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // sdk.pendo.io.k3.g
    public String toString() {
        return r().toString();
    }

    @Override // sdk.pendo.io.k3.g
    public g a(String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            messageDigest.update(getSegments()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNull(digest);
        return new g(digest);
    }

    @Override // sdk.pendo.io.k3.g
    public boolean a(int offset, g other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > l() - byteCount) {
            return false;
        }
        int i = byteCount + offset;
        int a2 = sdk.pendo.io.l3.c.a(this, offset);
        while (offset < i) {
            int i2 = a2 == 0 ? 0 : getDirectory()[a2 - 1];
            int i3 = getDirectory()[a2] - i2;
            int i4 = getDirectory()[getSegments().length + a2];
            int min = Math.min(i, i3 + i2) - offset;
            if (!other.a(otherOffset, getSegments()[a2], i4 + (offset - i2), min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            a2++;
        }
        return true;
    }

    @Override // sdk.pendo.io.k3.g
    public boolean a(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > l() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i = byteCount + offset;
        int a2 = sdk.pendo.io.l3.c.a(this, offset);
        while (offset < i) {
            int i2 = a2 == 0 ? 0 : getDirectory()[a2 - 1];
            int i3 = getDirectory()[a2] - i2;
            int i4 = getDirectory()[getSegments().length + a2];
            int min = Math.min(i, i3 + i2) - offset;
            if (!b.a(getSegments()[a2], i4 + (offset - i2), other, otherOffset, min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            a2++;
        }
        return true;
    }

    @Override // sdk.pendo.io.k3.g
    public void a(d buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = offset + byteCount;
        int a2 = sdk.pendo.io.l3.c.a(this, offset);
        while (offset < i) {
            int i2 = a2 == 0 ? 0 : getDirectory()[a2 - 1];
            int i3 = getDirectory()[a2] - i2;
            int i4 = getDirectory()[getSegments().length + a2];
            int min = Math.min(i, i3 + i2) - offset;
            int i5 = i4 + (offset - i2);
            v vVar = new v(getSegments()[a2], i5, i5 + min, true, false);
            v vVar2 = buffer.head;
            if (vVar2 == null) {
                vVar.prev = vVar;
                vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = vVar;
                buffer.head = vVar;
            } else {
                Intrinsics.checkNotNull(vVar2);
                v vVar3 = vVar2.prev;
                Intrinsics.checkNotNull(vVar3);
                vVar3.a(vVar);
            }
            offset += min;
            a2++;
        }
        buffer.j(buffer.getSize() + byteCount);
    }
}
