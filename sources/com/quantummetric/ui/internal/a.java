package com.quantummetric.ui.internal;

import android.view.View;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.bp.AnonymousClass3;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, Integer> f17a = new ConcurrentHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [V, com.quantummetric.instrument.internal.b] */
    static b a(Object obj, final String str, final int i, final o<di> oVar) {
        final ap apVar = new ap();
        bp bpVar = new bp(bz.a(), new dc() { // from class: com.quantummetric.instrument.internal.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.quantummetric.ui.internal.dc
            public final void a() {
                b bVar = (b) ap.this.f61a;
                if (bVar != null) {
                    final di diVar = new di(bVar);
                    cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.a(str, i, diVar.b, diVar.b());
                            if (oVar != null) {
                                oVar.a(diVar);
                            }
                        }
                    });
                }
            }
        });
        ?? a2 = dh.a(obj, bpVar);
        apVar.f61a = a2;
        bpVar.d = true;
        bpVar.a(false);
        if (!bpVar.e) {
            cl.a(bpVar.new AnonymousClass3(), 50);
        }
        return a2;
    }

    static String a(View view) {
        String concat = "q".concat(String.valueOf(view.hashCode()));
        if (cc.a(view)) {
            return concat + "-container";
        }
        if (!(view instanceof WebView)) {
            return concat;
        }
        String g = g(view.hashCode());
        return !de.b(g) ? g : concat;
    }

    static String a(b bVar) {
        if (bVar == null) {
            return "";
        }
        boolean z = bVar instanceof dj;
        int i = bVar.f;
        return z ? g(i) : "q".concat(String.valueOf(i));
    }

    static void a() {
        f17a.clear();
    }

    static void a(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        bf bfVar = new bf();
        bfVar.put("t", "r");
        bfVar.put(ContextChain.TAG_PRODUCT, "<BODY");
        bfVar.put(ContextChain.TAG_INFRA, arrayList);
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static void a(final b bVar, final int i, final String str) {
        cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.c(a.d(b.this.f));
                a.a(str, i, (List<String>) null, new di(b.this).b());
            }
        });
    }

    static void a(String str) {
        if (de.b(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("<style>" + str + "</style>");
        bf bfVar = new bf();
        bfVar.put("t", "a");
        bfVar.put(ContextChain.TAG_PRODUCT, "<HEAD");
        bfVar.put(ContextChain.TAG_INFRA, 0);
        bfVar.put("v", arrayList);
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static void a(String str, int i) {
        bf bfVar = new bf();
        bfVar.put(aa.ah, i + aa.f);
        a(str, bfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i, int i2) {
        bf bfVar = new bf();
        bfVar.put("I", "#".concat(String.valueOf(str)));
        bfVar.put("t", ExifInterface.LATITUDE_SOUTH);
        bfVar.put(ViewHierarchyNode.JsonKeys.X, Integer.valueOf(i));
        bfVar.put(ViewHierarchyNode.JsonKeys.Y, Integer.valueOf(i2));
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static void a(String str, int i, List<String> list, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!str.equals("<BODY")) {
            str = "#".concat(String.valueOf(str));
        }
        arrayList.add(str2);
        bf bfVar = new bf();
        bfVar.put("t", "a");
        bfVar.put(ContextChain.TAG_PRODUCT, str);
        bfVar.put(ContextChain.TAG_INFRA, Integer.valueOf(i));
        bfVar.put("v", arrayList);
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
        a(list);
    }

    static void a(String str, bf bfVar) {
        bf bfVar2 = new bf();
        bfVar2.put("I", "#".concat(String.valueOf(str)));
        bfVar2.put("v", bfVar);
        bfVar2.put("t", "nsc");
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar2);
        }
    }

    static void a(String str, String str2) {
        a(str, "style", str2);
    }

    static void a(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(str2);
        bf bfVar = new bf();
        bfVar.put(ContextChain.TAG_PRODUCT, "#" + str + "-text");
        bfVar.put("t", "r");
        bfVar.put(ContextChain.TAG_INFRA, arrayList);
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
        bf bfVar2 = new bf();
        bfVar2.put(ContextChain.TAG_PRODUCT, "#" + str + "-text");
        bfVar2.put("t", "a");
        bfVar2.put(ContextChain.TAG_INFRA, Integer.valueOf(i));
        bfVar2.put("v", arrayList2);
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar2);
        }
    }

    static void a(String str, String str2, String str3) {
        bf bfVar = new bf();
        bfVar.put("n", str2);
        bfVar.put("I", "#".concat(String.valueOf(str)));
        bfVar.put("v", str3);
        bfVar.put("t", ExifInterface.GPS_DIRECTION_TRUE);
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static void a(String str, String str2, boolean z) {
        String str3 = z ? "qenc" : "v";
        bf bfVar = new bf();
        bfVar.put("I", "#".concat(String.valueOf(str)));
        bfVar.put(str3, str2);
        bfVar.put("t", "C");
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            bf bfVar = new bf();
            bfVar.put("dad", str);
            if (QuantumMetric.b != null) {
                QuantumMetric.b._sendReplayOnlyEvent(bfVar);
            }
        }
    }

    static String b(View view) {
        if (view == null) {
            return "";
        }
        String concat = "q".concat(String.valueOf(view.hashCode()));
        if (view instanceof WebView) {
            String g = g(view.hashCode());
            if (!de.b(g)) {
                return g;
            }
        }
        return concat;
    }

    static void b(int i) {
        bf bfVar = new bf();
        bfVar.put("t", "/");
        bfVar.put("o", Integer.valueOf(i));
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static void b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        bu buVar = QuantumMetric.b;
        bf bfVar = new bf();
        bfVar.put("t", Long.valueOf(currentTimeMillis));
        bfVar.put("v", str);
        buVar._sendOutOfBandData("pf", bfVar);
        bf bfVar2 = new bf();
        bfVar2.put(ContextChain.TAG_INFRA, -5);
        bfVar2.put("t", "oe");
        bfVar2.put("tt", Long.valueOf(currentTimeMillis));
        bfVar2.put("v", str);
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar2);
        }
    }

    static void b(String str, int i, int i2) {
        bf bfVar = new bf();
        bfVar.put(aa.ah, (-i2) + aa.f);
        bfVar.put(aa.ag, (-i) + aa.f);
        a(str, bfVar);
    }

    static void b(String str, String str2) {
        bf bfVar = new bf();
        String concat = "#".concat(String.valueOf(str));
        if (!de.b(str)) {
            bfVar.put("I", concat);
        }
        bfVar.put("v", str2);
        bfVar.put("t", "b");
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static String c(int i) {
        return "q".concat(String.valueOf(i)) + "-root";
    }

    static String c(View view) {
        return view != null ? a(view) + " 0" : "";
    }

    static void c(String str) {
        bf bfVar = new bf();
        bfVar.put("t", "rn");
        bfVar.put("c", "#".concat(String.valueOf(str)));
        if (QuantumMetric.b != null) {
            QuantumMetric.b._sendReplayOnlyEvent(bfVar);
        }
    }

    static String d(int i) {
        return "q".concat(String.valueOf(i));
    }

    static void d(View view) {
        if (view != null) {
            int hashCode = view.hashCode();
            Map<Integer, Integer> map = f17a;
            Integer num = map.get(Integer.valueOf(hashCode));
            map.put(Integer.valueOf(hashCode), Integer.valueOf(num != null ? num.intValue() + 1 : 0));
        }
    }

    static void d(String str) {
        bf bfVar = new bf();
        bfVar.put(ViewHierarchyNode.JsonKeys.VISIBILITY, "");
        a(str, bfVar);
    }

    static String e(int i) {
        String concat = "q".concat(String.valueOf(i));
        return f17a.containsKey(Integer.valueOf(i)) ? concat + "-container" : concat;
    }

    static void f(int i) {
        f17a.put(Integer.valueOf(i), 0);
    }

    private static String g(int i) {
        return "q".concat(String.valueOf(i)) + "-" + f17a.get(Integer.valueOf(i));
    }
}
