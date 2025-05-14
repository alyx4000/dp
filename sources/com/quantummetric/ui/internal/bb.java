package com.quantummetric.ui.internal;

import com.quantummetric.ui.QMMaskingMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class bb {
    final Object b = new Object();

    /* renamed from: a, reason: collision with root package name */
    final List<QMMaskingMap> f102a = new ArrayList();

    bb() {
    }

    static void a(QMMaskingMap qMMaskingMap) {
        try {
            switch (AnonymousClass1.f103a[QMMaskingMap.Type.valueOf((String) qMMaskingMap.get("type")).ordinal()]) {
                case 1:
                    Object obj = qMMaskingMap.get("regex_list");
                    Iterator it = (obj instanceof List ? (List) obj : new ArrayList()).iterator();
                    while (it.hasNext()) {
                        bd.a().a(new JSONObject().put("regex", (String) it.next()));
                    }
                    break;
                case 2:
                    y.e = true;
                    break;
                case 3:
                    y.g = true;
                    break;
                case 4:
                    y.c = true;
                    break;
                case 5:
                case 6:
                    Object obj2 = qMMaskingMap.get("regex_list");
                    Iterator it2 = (obj2 instanceof List ? (List) obj2 : new ArrayList()).iterator();
                    while (it2.hasNext()) {
                        e.a().i.add((String) it2.next());
                    }
                    break;
                case 7:
                    Object obj3 = qMMaskingMap.get("exact_match_list");
                    Iterator it3 = (obj3 instanceof List ? (List) obj3 : new ArrayList()).iterator();
                    while (it3.hasNext()) {
                        bd.a().a((String) it3.next(), (String) null);
                    }
                    break;
                case 8:
                    Object obj4 = qMMaskingMap.get("exact_match_list");
                    Iterator it4 = (obj4 instanceof List ? (List) obj4 : new ArrayList()).iterator();
                    while (it4.hasNext()) {
                        bd.a().a((String) null, (String) it4.next());
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    static void b(QMMaskingMap qMMaskingMap) {
        QMMaskingMap.Type valueOf = QMMaskingMap.Type.valueOf((String) qMMaskingMap.get("type"));
        try {
            bk bkVar = de.k().m;
            Object obj = qMMaskingMap.get("regex_list");
            List<String> arrayList = obj instanceof List ? (List) obj : new ArrayList<>();
            switch (valueOf) {
                case ApiUrl:
                    bkVar.c = arrayList;
                    break;
                case Headers:
                    for (String str : arrayList) {
                        bkVar.f111a.add(str);
                        bkVar.b.add(str);
                    }
                    break;
                case Bodies:
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        bkVar.a("", it.next());
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    final void a(boolean z) {
        synchronized (this.b) {
            for (QMMaskingMap qMMaskingMap : this.f102a) {
                if (z) {
                    a(qMMaskingMap);
                } else {
                    b(qMMaskingMap);
                }
            }
        }
    }
}
