package sdk.pendo.io.n1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class a {
    private static b e;

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.x1.b f1411a;
    private final sdk.pendo.io.y1.c b;
    private final Set<i> c;
    private final Collection<c> d;

    /* renamed from: sdk.pendo.io.n1.a$a, reason: collision with other inner class name */
    public static class C0202a {

        /* renamed from: a, reason: collision with root package name */
        private sdk.pendo.io.x1.b f1412a;
        private sdk.pendo.io.y1.c b;
        private EnumSet<i> c = EnumSet.noneOf(i.class);
        private Collection<c> d = new ArrayList();

        public a a() {
            if (this.f1412a == null || this.b == null) {
                b c = a.c();
                if (this.f1412a == null) {
                    this.f1412a = c.c();
                }
                if (this.b == null) {
                    this.b = c.a();
                }
            }
            return new a(this.f1412a, this.b, this.c, this.d);
        }

        public C0202a a(Collection<c> collection) {
            if (collection == null) {
                collection = Collections.emptyList();
            }
            this.d = collection;
            return this;
        }

        public C0202a a(sdk.pendo.io.x1.b bVar) {
            this.f1412a = bVar;
            return this;
        }

        public C0202a a(sdk.pendo.io.y1.c cVar) {
            this.b = cVar;
            return this;
        }

        public C0202a a(Set<i> set) {
            this.c.addAll(set);
            return this;
        }

        public C0202a a(i... iVarArr) {
            if (iVarArr.length > 0) {
                this.c.addAll(Arrays.asList(iVarArr));
            }
            return this;
        }
    }

    public interface b {
        sdk.pendo.io.y1.c a();

        Set<i> b();

        sdk.pendo.io.x1.b c();
    }

    private a(sdk.pendo.io.x1.b bVar, sdk.pendo.io.y1.c cVar, EnumSet<i> enumSet, Collection<c> collection) {
        sdk.pendo.io.o1.i.a(bVar, "jsonProvider can not be null", new Object[0]);
        sdk.pendo.io.o1.i.a(cVar, "mappingProvider can not be null", new Object[0]);
        sdk.pendo.io.o1.i.a(enumSet, "setOptions can not be null", new Object[0]);
        sdk.pendo.io.o1.i.a(collection, "evaluationListeners can not be null", new Object[0]);
        this.f1411a = bVar;
        this.b = cVar;
        this.c = Collections.unmodifiableSet(enumSet);
        this.d = Collections.unmodifiableCollection(collection);
    }

    public static a b() {
        b c = c();
        return a().a(c.c()).a(c.b()).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b c() {
        b bVar = e;
        return bVar == null ? sdk.pendo.io.o1.b.b : bVar;
    }

    public a a(i... iVarArr) {
        EnumSet noneOf = EnumSet.noneOf(i.class);
        noneOf.addAll(this.c);
        noneOf.addAll(Arrays.asList(iVarArr));
        return a().a(this.f1411a).a(this.b).a((Set<i>) noneOf).a(this.d).a();
    }

    public Collection<c> d() {
        return this.d;
    }

    public Set<i> e() {
        return this.c;
    }

    public sdk.pendo.io.x1.b f() {
        return this.f1411a;
    }

    public sdk.pendo.io.y1.c g() {
        return this.b;
    }

    public static C0202a a() {
        return new C0202a();
    }

    public boolean a(i iVar) {
        return this.c.contains(iVar);
    }
}
