package sdk.pendo.io.m3;

import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes6.dex */
public class l0 extends a0 {
    static final o0 s = new a(l0.class, 23);
    final byte[] f;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return l0.b(s1Var.k());
        }
    }

    l0(byte[] bArr) {
        if (bArr.length < 2) {
            throw new IllegalArgumentException("UTCTime string too short");
        }
        this.f = bArr;
        if (!a(0) || !a(1)) {
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
    }

    static l0 b(byte[] bArr) {
        return new l0(bArr);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (a0Var instanceof l0) {
            return sdk.pendo.io.d5.a.a(this.f, ((l0) a0Var).f);
        }
        return false;
    }

    @Override // sdk.pendo.io.m3.a0
    final boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f);
    }

    public String k() {
        String l = l();
        return (l.charAt(0) < '5' ? new StringBuilder("20") : new StringBuilder("19")).append(l).toString();
    }

    public String l() {
        StringBuilder append;
        String substring;
        StringBuilder append2;
        StringBuilder append3;
        String str;
        String b = sdk.pendo.io.d5.i.b(this.f);
        if (b.indexOf(45) >= 0 || b.indexOf(43) >= 0) {
            int indexOf = b.indexOf(45);
            if (indexOf < 0) {
                indexOf = b.indexOf(43);
            }
            if (indexOf == b.length() - 3) {
                b = b + "00";
            }
            if (indexOf == 10) {
                append = new StringBuilder().append(b.substring(0, 10)).append("00GMT").append(b.substring(10, 13)).append(":");
                substring = b.substring(13, 15);
            } else {
                append = new StringBuilder().append(b.substring(0, 12)).append(TimeZones.GMT_ID).append(b.substring(12, 15)).append(":");
                substring = b.substring(15, 17);
            }
            append2 = append.append(substring);
        } else {
            if (b.length() == 11) {
                append3 = new StringBuilder().append(b.substring(0, 10));
                str = "00GMT+00:00";
            } else {
                append3 = new StringBuilder().append(b.substring(0, 12));
                str = "GMT+00:00";
            }
            append2 = append3.append(str);
        }
        return append2.toString();
    }

    public String toString() {
        return sdk.pendo.io.d5.i.b(this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 23, this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, this.f.length);
    }

    private boolean a(int i) {
        byte b;
        byte[] bArr = this.f;
        return bArr.length > i && (b = bArr[i]) >= 48 && b <= 57;
    }
}
