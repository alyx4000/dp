package com.quantummetric.ui.internal;

import android.content.Context;
import android.util.Base64;
import com.facebook.common.callercontext.ContextChain;
import com.quantummetric.ui.QuantumMetric;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class bm {

    /* renamed from: a, reason: collision with root package name */
    static bm f117a;
    int d;
    boolean e;
    boolean f;
    boolean g;
    long h;
    int i;
    private final String k = "qm-o";
    final Object j = new Object();
    JSONArray b = new JSONArray();
    HashMap<Long, Integer> c = new HashMap<>();

    /* renamed from: com.quantummetric.instrument.internal.bm$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ String f118a;
        private /* synthetic */ String b;

        AnonymousClass1(String str, String str2) {
            this.f118a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            de.a(this.f118a, "qm-o", this.b);
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.bm$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ Context f123a;

        AnonymousClass4(Context context) {
            this.f123a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f123a.deleteFile(aa.d(de.k().d));
        }
    }

    bm() {
    }

    static /* synthetic */ File a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file.getName().contains("-0")) {
                return file;
            }
        }
        return null;
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                } else {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    static /* synthetic */ void a(File file, String str, String str2, o oVar) throws JSONException {
        String a2 = de.a(file);
        file.delete();
        q.a(new JSONArray(a2).getJSONObject(0), str, str2, (String) null, (o<String>) oVar);
    }

    static void a(String str) {
        Context f = de.f();
        if (f == null || QuantumMetric.b == null) {
            return;
        }
        de.a(aa.d(de.k().d), str + IOUtils.LINE_SEPARATOR_WINDOWS, true, f);
    }

    static /* synthetic */ void a(List list, String str, String str2, String str3) throws JSONException {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                String name = file.getName();
                if (!name.contains("-0")) {
                    String a2 = de.a(file);
                    file.delete();
                    if (!name.contains("-")) {
                        JSONObject jSONObject = new JSONObject(a2);
                        String string = jSONObject.getString("q");
                        String string2 = jSONObject.getString(ContextChain.TAG_PRODUCT);
                        if (!de.a(string2, string)) {
                            q.a(string, Base64.decode(string2, 0));
                        }
                    } else if (!name.contains("-0")) {
                        JSONArray jSONArray = new JSONArray(a2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            q.a(jSONArray.getJSONObject(i), str, str2, str3, (o<String>) null);
                        }
                    }
                }
            }
        }
    }

    static File[] b() {
        Context f = de.f();
        if (f == null) {
            return null;
        }
        try {
            File file = new File(f.getFilesDir() + "/qm-o");
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    final String a(byte[] bArr) {
        String encodeToString = Base64.encodeToString(bArr, 0);
        int length = this.d + encodeToString.length();
        this.d = length;
        this.e = length < this.i;
        return encodeToString;
    }

    final void a() {
        try {
            Context f = de.f();
            if (f != null) {
                File file = new File(f.getFilesDir() + "/qm-o");
                if (file.exists()) {
                    a(file);
                }
            }
        } catch (Exception unused) {
        }
    }

    final void a(long j, boolean z) {
        String str;
        String jSONArray = this.b.toString();
        Integer num = this.c.get(Long.valueOf(j));
        if (num != null) {
            if (z) {
                str = j + "-0";
            } else {
                this.c.put(Long.valueOf(j), Integer.valueOf(num.intValue() + 1));
                str = j + "-" + num;
            }
            cl.a(new AnonymousClass1(str, jSONArray));
        }
        this.b = new JSONArray();
    }
}
