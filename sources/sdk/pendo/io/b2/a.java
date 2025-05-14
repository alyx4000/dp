package sdk.pendo.io.b2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class a extends ArrayList<Object> implements List<Object>, c, f {
    public static String a(List<? extends Object> list, g gVar) {
        StringBuilder sb = new StringBuilder();
        try {
            a(list, sb, gVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    @Override // sdk.pendo.io.b2.b
    public String c() {
        return a(this, i.f884a);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return c();
    }

    @Override // sdk.pendo.io.b2.c
    public String a(g gVar) {
        return a(this, gVar);
    }

    @Override // sdk.pendo.io.b2.e
    public void a(Appendable appendable) {
        a(this, appendable, i.f884a);
    }

    @Override // sdk.pendo.io.b2.f
    public void a(Appendable appendable, g gVar) {
        a(this, appendable, gVar);
    }

    public static void a(Iterable<? extends Object> iterable, Appendable appendable, g gVar) {
        if (iterable == null) {
            appendable.append("null");
        } else {
            sdk.pendo.io.e2.d.g.a(iterable, appendable, gVar);
        }
    }
}
