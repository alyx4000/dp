package sdk.pendo.io.m3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes6.dex */
public class m extends a0 {
    static final o0 s = new a(m.class, 24);
    final byte[] f;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return m.b(s1Var.k());
        }
    }

    m(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("GeneralizedTime string too short");
        }
        this.f = bArr;
        if (!b(0) || !b(1) || !b(2) || !b(3)) {
            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }
    }

    private String b(String str) {
        String str2;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str2 = "-";
        } else {
            str2 = "+";
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime()) {
                if (m()) {
                    str = c(str);
                }
                if (timeZone.inDaylightTime(k().parse(str + TimeZones.GMT_ID + str2 + a(i) + ":" + a(i2)))) {
                    i += str2.equals("+") ? 1 : -1;
                }
            }
        } catch (ParseException unused) {
        }
        return TimeZones.GMT_ID + str2 + a(i) + ":" + a(i2);
    }

    private String c(String str) {
        String str2;
        StringBuilder sb;
        char charAt;
        String substring = str.substring(14);
        int i = 1;
        while (i < substring.length() && '0' <= (charAt = substring.charAt(i)) && charAt <= '9') {
            i++;
        }
        int i2 = i - 1;
        if (i2 > 3) {
            str2 = substring.substring(0, 4) + substring.substring(i);
            sb = new StringBuilder();
        } else if (i2 == 1) {
            str2 = substring.substring(0, i) + "00" + substring.substring(i);
            sb = new StringBuilder();
        } else {
            if (i2 != 2) {
                return str;
            }
            str2 = substring.substring(0, i) + "0" + substring.substring(i);
            sb = new StringBuilder();
        }
        return sb.append(str.substring(0, 14)).append(str2).toString();
    }

    private SimpleDateFormat k() {
        SimpleDateFormat simpleDateFormat = m() ? new SimpleDateFormat("yyyyMMddHHmmss.SSSz") : o() ? new SimpleDateFormat("yyyyMMddHHmmssz") : n() ? new SimpleDateFormat("yyyyMMddHHmmz") : new SimpleDateFormat("yyyyMMddHHz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (a0Var instanceof m) {
            return sdk.pendo.io.d5.a.a(this.f, ((m) a0Var).f);
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

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        return new n1(this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        return new n1(this.f);
    }

    public String l() {
        StringBuilder append;
        String substring;
        StringBuilder append2;
        StringBuilder append3;
        String str;
        String b = sdk.pendo.io.d5.i.b(this.f);
        if (b.charAt(b.length() - 1) != 'Z') {
            int length = b.length() - 6;
            char charAt = b.charAt(length);
            if ((charAt == '-' || charAt == '+') && b.indexOf(TimeZones.GMT_ID) == length - 3) {
                return b;
            }
            int length2 = b.length() - 5;
            char charAt2 = b.charAt(length2);
            if (charAt2 == '-' || charAt2 == '+') {
                int i = length2 + 3;
                append = new StringBuilder().append(b.substring(0, length2)).append(TimeZones.GMT_ID).append(b.substring(length2, i)).append(":");
                substring = b.substring(i);
            } else {
                int length3 = b.length() - 3;
                char charAt3 = b.charAt(length3);
                if (charAt3 == '-' || charAt3 == '+') {
                    append3 = new StringBuilder().append(b.substring(0, length3)).append(TimeZones.GMT_ID).append(b.substring(length3));
                    str = ":00";
                } else {
                    append = new StringBuilder().append(b);
                    substring = b(b);
                }
            }
            append2 = append.append(substring);
            return append2.toString();
        }
        append3 = new StringBuilder().append(b.substring(0, b.length() - 1));
        str = "GMT+00:00";
        append2 = append3.append(str);
        return append2.toString();
    }

    protected boolean m() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    protected boolean n() {
        return b(10) && b(11);
    }

    protected boolean o() {
        return b(12) && b(13);
    }

    private String a(int i) {
        return i < 10 ? "0" + i : Integer.toString(i);
    }

    static m b(byte[] bArr) {
        return new m(bArr);
    }

    private boolean b(int i) {
        byte b;
        byte[] bArr = this.f;
        return bArr.length > i && (b = bArr[i]) >= 48 && b <= 57;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 24, this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, this.f.length);
    }
}
