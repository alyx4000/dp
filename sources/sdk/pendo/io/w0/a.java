package sdk.pendo.io.w0;

import java.security.SecureRandom;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SecureRandom f1697a;
    private C0258a b = new C0258a();
    private C0258a c = new C0258a();

    /* renamed from: sdk.pendo.io.w0.a$a, reason: collision with other inner class name */
    public class C0258a {

        /* renamed from: a, reason: collision with root package name */
        private String f1698a;
        private String b;
        private String c;
        private b d;
        private String e;
        private String f;
        private String g;
        private String h;

        public C0258a() {
        }

        public String a() {
            return a(this.c);
        }

        public String b() {
            return a(this.b);
        }

        public b c() {
            return this.d;
        }

        public String d() {
            return a(this.h);
        }

        public String e() {
            return a(this.f);
        }

        public String f() {
            return a(this.g);
        }

        public c g() {
            return null;
        }

        public String h() {
            return a(this.e);
        }

        private String a(String str) {
            return str == null ? this.f1698a : str;
        }
    }

    public enum b {
        UNWRAP,
        DECRYPT
    }

    public static class c {
    }

    public C0258a a() {
        return this.c;
    }

    public SecureRandom b() {
        return this.f1697a;
    }

    public C0258a c() {
        return this.b;
    }
}
