package sdk.pendo.io.d4;

import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import java.util.Hashtable;
import sdk.pendo.io.c4.d;
import sdk.pendo.io.e4.k;
import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class b extends a {
    public static final v A;
    public static final v B;
    public static final v C;
    public static final v D;
    public static final v E;
    public static final v F;
    public static final v G;
    public static final v H;
    public static final v I;
    public static final v J;
    public static final v K;
    public static final v L;
    public static final v M;
    public static final v N;
    private static final Hashtable O;
    private static final Hashtable P;
    public static final d Q;
    public static final v c;
    public static final v d;
    public static final v e;
    public static final v f;
    public static final v g;
    public static final v h;
    public static final v i;
    public static final v j;
    public static final v k;
    public static final v l;
    public static final v m;
    public static final v n;
    public static final v o;
    public static final v p;
    public static final v q;
    public static final v r;
    public static final v s;
    public static final v t;
    public static final v u;
    public static final v v;
    public static final v w;
    public static final v x;
    public static final v y;
    public static final v z;
    protected final Hashtable b = a.a(O);

    /* renamed from: a, reason: collision with root package name */
    protected final Hashtable f987a = a.a(P);

    static {
        v m2 = new v("2.5.4.6").m();
        c = m2;
        v m3 = new v("2.5.4.10").m();
        d = m3;
        v m4 = new v("2.5.4.11").m();
        e = m4;
        v m5 = new v("2.5.4.12").m();
        f = m5;
        v m6 = new v("2.5.4.3").m();
        g = m6;
        h = new v("2.5.4.5").m();
        v m7 = new v("2.5.4.9").m();
        i = m7;
        v m8 = new v("2.5.4.5").m();
        j = m8;
        v m9 = new v("2.5.4.7").m();
        k = m9;
        v m10 = new v("2.5.4.8").m();
        l = m10;
        v m11 = new v("2.5.4.4").m();
        m = m11;
        v m12 = new v("2.5.4.42").m();
        n = m12;
        v m13 = new v("2.5.4.43").m();
        o = m13;
        v m14 = new v("2.5.4.44").m();
        p = m14;
        v m15 = new v("2.5.4.45").m();
        q = m15;
        v m16 = new v("2.5.4.13").m();
        r = m16;
        v m17 = new v("2.5.4.15").m();
        s = m17;
        v m18 = new v("2.5.4.17").m();
        t = m18;
        v m19 = new v("2.5.4.46").m();
        u = m19;
        v m20 = new v("2.5.4.65").m();
        v = m20;
        v m21 = new v("2.5.4.72").m();
        w = m21;
        v m22 = new v("1.3.6.1.5.5.7.9.1").m();
        x = m22;
        v m23 = new v("1.3.6.1.5.5.7.9.2").m();
        y = m23;
        v m24 = new v("1.3.6.1.5.5.7.9.3").m();
        z = m24;
        v m25 = new v("1.3.6.1.5.5.7.9.4").m();
        A = m25;
        v m26 = new v("1.3.6.1.5.5.7.9.5").m();
        B = m26;
        v m27 = new v("1.3.36.8.3.14").m();
        C = m27;
        v m28 = new v("2.5.4.16").m();
        D = m28;
        E = new v("2.5.4.54").m();
        v vVar = k.g;
        F = vVar;
        v vVar2 = k.h;
        G = vVar2;
        v vVar3 = k.i;
        H = vVar3;
        v vVar4 = sdk.pendo.io.y3.a.a0;
        I = vVar4;
        v vVar5 = sdk.pendo.io.y3.a.b0;
        J = vVar5;
        v vVar6 = sdk.pendo.io.y3.a.h0;
        K = vVar6;
        L = vVar4;
        v vVar7 = new v("0.9.2342.19200300.100.1.25");
        M = vVar7;
        v vVar8 = new v("0.9.2342.19200300.100.1.1");
        N = vVar8;
        Hashtable hashtable = new Hashtable();
        O = hashtable;
        Hashtable hashtable2 = new Hashtable();
        P = hashtable2;
        hashtable.put(m2, "C");
        hashtable.put(m3, "O");
        hashtable.put(m5, ExifInterface.GPS_DIRECTION_TRUE);
        hashtable.put(m4, "OU");
        hashtable.put(m6, "CN");
        hashtable.put(m9, "L");
        hashtable.put(m10, "ST");
        hashtable.put(m8, "SERIALNUMBER");
        hashtable.put(vVar4, ExifInterface.LONGITUDE_EAST);
        hashtable.put(vVar7, "DC");
        hashtable.put(vVar8, "UID");
        hashtable.put(m7, "STREET");
        hashtable.put(m11, "SURNAME");
        hashtable.put(m12, "GIVENNAME");
        hashtable.put(m13, "INITIALS");
        hashtable.put(m14, "GENERATION");
        hashtable.put(m16, "DESCRIPTION");
        hashtable.put(m21, "ROLE");
        hashtable.put(vVar6, "unstructuredAddress");
        hashtable.put(vVar5, "unstructuredName");
        hashtable.put(m15, "UniqueIdentifier");
        hashtable.put(m19, "DN");
        hashtable.put(m20, "Pseudonym");
        hashtable.put(m28, "PostalAddress");
        hashtable.put(m27, "NameAtBirth");
        hashtable.put(m25, "CountryOfCitizenship");
        hashtable.put(m26, "CountryOfResidence");
        hashtable.put(m24, "Gender");
        hashtable.put(m23, "PlaceOfBirth");
        hashtable.put(m22, "DateOfBirth");
        hashtable.put(m18, "PostalCode");
        hashtable.put(m17, "BusinessCategory");
        hashtable.put(vVar, "TelephoneNumber");
        hashtable.put(vVar2, "Name");
        hashtable.put(vVar3, "external.sdk.pendo.io.organizationIdentifier");
        hashtable2.put("c", m2);
        hashtable2.put("o", m3);
        hashtable2.put("t", m5);
        hashtable2.put("ou", m4);
        hashtable2.put("cn", m6);
        hashtable2.put("l", m9);
        hashtable2.put("st", m10);
        hashtable2.put("sn", m11);
        hashtable2.put("serialnumber", m8);
        hashtable2.put("street", m7);
        hashtable2.put("emailaddress", vVar4);
        hashtable2.put("dc", vVar7);
        hashtable2.put("e", vVar4);
        hashtable2.put("uid", vVar8);
        hashtable2.put("surname", m11);
        hashtable2.put("givenname", m12);
        hashtable2.put("initials", m13);
        hashtable2.put("generation", m14);
        hashtable2.put("description", m16);
        hashtable2.put(ViewProps.ROLE, m21);
        hashtable2.put("unstructuredaddress", vVar6);
        hashtable2.put("unstructuredname", vVar5);
        hashtable2.put("uniqueidentifier", m15);
        hashtable2.put("dn", m19);
        hashtable2.put("pseudonym", m20);
        hashtable2.put("postaladdress", m28);
        hashtable2.put("nameatbirth", m27);
        hashtable2.put("countryofcitizenship", m25);
        hashtable2.put("countryofresidence", m26);
        hashtable2.put(HintConstants.AUTOFILL_HINT_GENDER, m24);
        hashtable2.put("placeofbirth", m23);
        hashtable2.put("dateofbirth", m22);
        hashtable2.put("postalcode", m18);
        hashtable2.put("businesscategory", m17);
        hashtable2.put("telephonenumber", vVar);
        hashtable2.put("name", vVar2);
        hashtable2.put("external.sdk.pendo.io.organizationidentifier", vVar3);
        Q = new b();
    }

    protected b() {
    }

    @Override // sdk.pendo.io.c4.d
    public String a(sdk.pendo.io.c4.c cVar) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        for (sdk.pendo.io.c4.b bVar : cVar.h()) {
            if (z2) {
                z2 = false;
            } else {
                stringBuffer.append(',');
            }
            c.a(stringBuffer, bVar, this.b);
        }
        return stringBuffer.toString();
    }
}
