package com.quantummetric.ui.internal;

import com.quantummetric.ui.EventType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    static final j f261a = new j(1073741825);
    public static final j b = new j(256);
    static final j c = new j(0);
    public static final j d = new j(0);
    public int flag;

    public j(int i) {
        this.flag = i;
    }

    static int a(j... jVarArr) {
        int i = 0;
        for (j jVar : jVarArr) {
            if (jVar != null) {
                int i2 = jVar.flag;
                int i3 = f261a.flag;
                if (i2 >= i3) {
                    i2 -= i3;
                }
                Iterator<EventType> it = EventType.h.iterator();
                while (it.hasNext()) {
                    int i4 = it.next().flag;
                    if (i4 == (i2 & i4)) {
                        i |= i4;
                    }
                }
            }
        }
        return i;
    }

    static boolean a(int i, j... jVarArr) {
        int length = jVarArr.length;
        for (int i2 = 0; i2 < 4; i2++) {
            j jVar = jVarArr[i2];
            if (jVar != null) {
                int i3 = jVar.flag;
                if ((i & i3) == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(j jVar, j... jVarArr) {
        if (jVar == null || jVarArr == null) {
            return false;
        }
        for (j jVar2 : jVarArr) {
            if (jVar2 != null) {
                int i = jVar.flag;
                if (i == (jVar2.flag & i)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean b(j[] jVarArr) {
        for (j jVar : jVarArr) {
            if (jVar == c) {
                return false;
            }
        }
        return true;
    }

    static j[] b(int i, j... jVarArr) {
        ArrayList arrayList = new ArrayList();
        for (EventType eventType : EventType.h) {
            if (eventType != null) {
                int i2 = eventType.flag;
                if (i2 == (i2 & i)) {
                    arrayList.add(eventType);
                }
            }
        }
        if (jVarArr != null && jVarArr.length > 0) {
            arrayList.addAll(Arrays.asList(jVarArr));
        }
        return (j[]) arrayList.toArray(new j[arrayList.size()]);
    }
}
