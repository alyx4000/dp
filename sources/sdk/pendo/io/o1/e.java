package sdk.pendo.io.o1;

import java.util.Arrays;
import java.util.LinkedList;
import sdk.pendo.io.n1.l;

/* loaded from: classes6.dex */
public class e implements sdk.pendo.io.n1.b {
    private static final sdk.pendo.io.h7.a c = sdk.pendo.io.h7.b.a((Class<?>) e.class);

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.n1.a f1451a;
    private final Object b;

    e(Object obj, sdk.pendo.io.n1.a aVar) {
        i.a(obj, "json can not be null", new Object[0]);
        i.a(aVar, "configuration can not be null", new Object[0]);
        this.f1451a = aVar;
        this.b = obj;
    }

    private sdk.pendo.io.n1.g b(String str, l[] lVarArr) {
        sdk.pendo.io.w1.a a2 = sdk.pendo.io.w1.b.a();
        String a3 = i.a(str, new LinkedList(Arrays.asList(lVarArr)).toString());
        sdk.pendo.io.n1.g a4 = a2.a(a3);
        if (a4 != null) {
            return a4;
        }
        sdk.pendo.io.n1.g a5 = sdk.pendo.io.n1.g.a(str, lVarArr);
        a2.a(a3, a5);
        return a5;
    }

    @Override // sdk.pendo.io.n1.m
    public <T> T a(String str, l... lVarArr) {
        i.a(str, "path can not be null or empty", new Object[0]);
        return (T) a(b(str, lVarArr));
    }

    public <T> T a(sdk.pendo.io.n1.g gVar) {
        i.a(gVar, "path can not be null", new Object[0]);
        return (T) gVar.a(this.b, this.f1451a);
    }
}
