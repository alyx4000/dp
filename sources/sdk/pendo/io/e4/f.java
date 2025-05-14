package sdk.pendo.io.e4;

import androidx.exifinterface.media.ExifInterface;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class f extends t {
    public static final f A;
    public static final f A0;
    public static final f B0;
    public static final f C0;
    public static final f D0;
    public static final f E0;
    public static final f F0;
    public static final f G0;
    public static final f H0;
    public static final f I0;
    public static final f J0;
    public static final f K0;
    public static final f L0;
    public static final f M0;
    public static final f N0;
    public static final f O0;
    public static final f P0;
    public static final f Q0;
    public static final f R0;
    public static final f f0;
    private static final v s;
    public static final f t0;
    public static final f u0;
    public static final f v0;
    public static final f w0;
    public static final f x0;
    public static final f y0;
    public static final f z0;
    private v f;

    static {
        v vVar = new v("1.3.6.1.5.5.7.3");
        s = vVar;
        A = new f(d.M0.b("0"));
        f0 = new f(vVar.b("1"));
        t0 = new f(vVar.b(ExifInterface.GPS_MEASUREMENT_2D));
        u0 = new f(vVar.b(ExifInterface.GPS_MEASUREMENT_3D));
        v0 = new f(vVar.b("4"));
        w0 = new f(vVar.b("5"));
        x0 = new f(vVar.b("6"));
        y0 = new f(vVar.b("7"));
        z0 = new f(vVar.b("8"));
        A0 = new f(vVar.b("9"));
        B0 = new f(vVar.b("10"));
        C0 = new f(vVar.b("11"));
        D0 = new f(vVar.b("12"));
        E0 = new f(vVar.b("13"));
        F0 = new f(vVar.b("14"));
        G0 = new f(vVar.b("15"));
        H0 = new f(vVar.b("16"));
        I0 = new f(vVar.b("17"));
        J0 = new f(vVar.b("18"));
        K0 = new f(vVar.b("19"));
        L0 = new f(vVar.b("27"));
        M0 = new f(vVar.b("28"));
        N0 = new f(vVar.b("32"));
        O0 = new f(new v("1.3.6.1.4.1.311.20.2.2"));
        P0 = new f(new v("1.3.6.1.1.1.1.22"));
        Q0 = new f(new v("1.3.6.1.4.1.311.10.3.3"));
        R0 = new f(new v("2.16.840.1.113730.4.1"));
    }

    private f(v vVar) {
        this.f = vVar;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        return this.f;
    }

    public String h() {
        return this.f.l();
    }

    public String toString() {
        return this.f.toString();
    }
}
