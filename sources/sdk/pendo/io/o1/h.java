package sdk.pendo.io.o1;

import java.util.Collection;

/* loaded from: classes6.dex */
public abstract class h implements Comparable<h> {
    public static final h s = new a(null);
    protected Object f;

    class a extends h {
        a(Object obj) {
            super(obj);
        }

        @Override // sdk.pendo.io.o1.h
        public Object a() {
            return null;
        }

        @Override // sdk.pendo.io.o1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private static class b extends h {
        private int A;

        private b(Object obj, int i) {
            super(obj);
            this.A = i;
        }

        @Override // sdk.pendo.io.o1.h, java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            return hVar instanceof b ? Integer.compare(((b) hVar).A, this.A) : super.compareTo(hVar);
        }

        @Override // sdk.pendo.io.o1.h
        public Object a() {
            return Integer.valueOf(this.A);
        }
    }

    private static class c extends h {
        private Collection<String> A;

        private c(Object obj, Collection<String> collection) {
            super(obj);
            this.A = collection;
        }

        @Override // sdk.pendo.io.o1.h
        public Object a() {
            return i.a("&&", this.A);
        }

        @Override // sdk.pendo.io.o1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private static class d extends h {
        private String A;

        private d(Object obj, String str) {
            super(obj);
            this.A = str;
        }

        @Override // sdk.pendo.io.o1.h
        public Object a() {
            return this.A;
        }

        @Override // sdk.pendo.io.o1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private static class e extends h {
        private e(Object obj) {
            super(obj);
        }

        @Override // sdk.pendo.io.o1.h
        Object a() {
            return "$";
        }

        @Override // sdk.pendo.io.o1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private h(Object obj) {
        this.f = obj;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h hVar) {
        return a().toString().compareTo(hVar.a().toString()) * (-1);
    }

    abstract Object a();

    public static h a(Object obj, int i) {
        return new b(obj, i);
    }

    public static h a(Object obj, String str) {
        return new d(obj, str);
    }

    public static h a(Object obj, Collection<String> collection) {
        return new c(obj, collection);
    }

    public static h a(Object obj) {
        return new e(obj);
    }
}
