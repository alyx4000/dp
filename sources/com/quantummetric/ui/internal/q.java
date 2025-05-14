package com.quantummetric.ui.internal;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.as;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    static String f265a;
    static String b;
    static bf c;

    static void a(bo boVar, x xVar, boolean z, boolean z2, o<String> oVar) {
        int i;
        long j;
        bf bfVar = new bf();
        bfVar.put(ExifInterface.GPS_DIRECTION_TRUE, "B");
        bfVar.put("u", boVar.f125a);
        bfVar.put("t", Long.valueOf(boVar.e));
        bfVar.put("v", Long.valueOf(System.currentTimeMillis()));
        bfVar.put("z", 1);
        if (z2) {
            bfVar.put("Q", 2);
        }
        if (!aa.A) {
            String str = boVar.b;
            if (!z) {
                bfVar.put("H", str);
            }
            String str2 = boVar.c;
            if (!de.b(boVar.c)) {
                bfVar.put("s", str2);
            }
            String str3 = boVar.d;
            if (!de.b(boVar.d)) {
                bfVar.put("U", str3);
            }
        }
        byte[] a2 = xVar.a();
        int length = a2.length;
        if (z2) {
            int i2 = boVar.f;
            j = boVar.h;
            boVar.f++;
            boVar.h += length;
            i = i2;
        } else {
            i = boVar.g;
            j = boVar.i;
            if (xVar instanceof bg) {
                bg bgVar = (bg) xVar;
                boVar.g += bgVar.size();
                if (bgVar.size() > 0) {
                    bgVar.get(0).put("SN", Integer.valueOf(i));
                }
            }
            boVar.i += length;
        }
        bfVar.put(ExifInterface.LATITUDE_SOUTH, Long.valueOf(j));
        bfVar.put("N", Integer.valueOf(i));
        String a3 = de.a(bfVar);
        String str4 = f265a + "?" + a3;
        if (aa.A) {
            if (bm.f117a == null) {
                bm.f117a = new bm();
            }
            bm bmVar = bm.f117a;
            long j2 = boVar.e;
            if (bmVar.e) {
                synchronized (bmVar.j) {
                    if (z) {
                        try {
                            if (bmVar.b.length() > 0) {
                                bmVar.a(j2, false);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (bmVar.c.size() == 0) {
                        QuantumMetric.a(-50, "", new j[0]);
                    }
                    boolean containsKey = bmVar.c.containsKey(Long.valueOf(j2));
                    if (!containsKey) {
                        bmVar.c.put(Long.valueOf(j2), 1);
                    }
                    bmVar.b.put(new JSONObject().put("e", bmVar.a(a2)).put("q", a3));
                    if (z || (!a3.contains("Q=2") && containsKey)) {
                        bmVar.a(j2, z);
                    }
                    if (oVar != null) {
                        oVar.a("");
                    }
                }
            }
        } else {
            a(str4, a2, oVar);
        }
        if (bm.f117a == null) {
            bm.f117a = new bm();
        }
        if (bm.f117a.f) {
            if (bm.f117a == null) {
                bm.f117a = new bm();
            }
            bm.a(xVar.b());
        }
    }

    static void a(String str, byte[] bArr) {
        as a2 = new as(b + "?" + str, null).a("POST");
        a2.f66a = bArr;
        as.c.execute(a2);
    }

    private static void a(String str, byte[] bArr, final o<String> oVar) {
        as a2 = new as(str, new o<as.a>() { // from class: com.quantummetric.instrument.internal.q.1
            @Override // com.quantummetric.ui.internal.o
            public final /* bridge */ /* synthetic */ void a(as.a aVar) {
                as.a aVar2 = aVar;
                o oVar2 = o.this;
                if (oVar2 != null) {
                    oVar2.a(aVar2.b);
                }
            }
        }).a("POST").a(c);
        a2.f66a = bArr;
        as.c.execute(a2);
    }

    static void a(JSONObject jSONObject, String str, String str2, String str3, o<String> oVar) throws JSONException {
        String string = jSONObject.getString("e");
        String string2 = jSONObject.getString("q");
        bf bfVar = new bf();
        if (!de.b(str3)) {
            bfVar.put("H", str3);
        }
        if (!de.b(str)) {
            bfVar.put("s", str);
        }
        if (!de.b(str2)) {
            bfVar.put("U", str2);
        }
        if (bfVar.size() > 0) {
            string2 = string2 + "&" + de.a(bfVar);
        }
        a(f265a + "?" + string2, Base64.decode(string, 0), oVar);
    }
}
