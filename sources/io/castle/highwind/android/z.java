package io.castle.highwind.android;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public final String f783a;

    public z(String str) {
        this.f783a = str;
    }

    public abstract y a();

    public final void a(List<String> list, x xVar) {
        String a2;
        int i = xVar.c;
        if (i == 1) {
            return;
        }
        switch (c.a(i)) {
            case 0:
            case 1:
            case 2:
                a2 = xVar.a();
                break;
            case 3:
                a2 = xVar.a() + w.a(((Integer) xVar.b).intValue());
                break;
            case 4:
                String str = (String) xVar.b;
                StringBuilder append = new StringBuilder().append(xVar.a());
                Integer[] a3 = e0.f770a.a(str, 255);
                a2 = append.append(w.a(a3.length) + w.a(a3)).toString();
                break;
            case 5:
                int intValue = ((Integer) xVar.b).intValue();
                if (intValue > 127) {
                    a2 = xVar.a() + w.a((intValue & 32767) | 32768, 2);
                    break;
                } else {
                    a2 = xVar.a() + w.a(intValue);
                    break;
                }
            case 6:
                a2 = xVar.a() + w.a((int) Math.rint(((Double) xVar.b).doubleValue() * 10));
                break;
            case 7:
                a2 = xVar.a() + ((String) xVar.b);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        list.add(a2);
    }

    public final y a(String[] strArr) {
        return new y(ArraysKt.joinToString$default(strArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), strArr.length);
    }
}
