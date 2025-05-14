package sdk.pendo.io.b2;

import com.facebook.hermes.intl.Constants;
import java.io.IOException;

/* loaded from: classes6.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    public static final e f885a;
    public static final f b;
    public static final d c;
    public static final c d;
    public static final b e;

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements h {
        private b() {
        }

        @Override // sdk.pendo.io.b2.j.h
        public void a(String str, Appendable appendable) {
            String str2;
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '\f') {
                        str2 = "\\f";
                    } else if (charAt == '\r') {
                        str2 = "\\r";
                    } else if (charAt == '\"') {
                        str2 = "\\\"";
                    } else if (charAt == '/') {
                        str2 = "\\/";
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                str2 = "\\b";
                                break;
                            case '\t':
                                str2 = "\\t";
                                break;
                            case '\n':
                                str2 = "\\n";
                                break;
                            default:
                                if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    charAt = "0123456789ABCDEF".charAt((charAt >> 0) & 15);
                                }
                                appendable.append(charAt);
                                continue;
                        }
                    } else {
                        str2 = "\\\\";
                    }
                    appendable.append(str2);
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements h {
        private c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        
            if (r2 <= 159) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
        
            if (r2 <= 8447) goto L28;
         */
        @Override // sdk.pendo.io.b2.j.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.lang.String r6, java.lang.Appendable r7) {
            /*
                r5 = this;
                int r0 = r6.length()     // Catch: java.io.IOException -> L84
                r1 = 0
            L5:
                if (r1 >= r0) goto L83
                char r2 = r6.charAt(r1)     // Catch: java.io.IOException -> L84
                r3 = 12
                if (r2 == r3) goto L7b
                r3 = 13
                if (r2 == r3) goto L78
                r3 = 34
                if (r2 == r3) goto L75
                r3 = 92
                if (r2 == r3) goto L72
                switch(r2) {
                    case 8: goto L2b;
                    case 9: goto L28;
                    case 10: goto L25;
                    default: goto L1e;
                }     // Catch: java.io.IOException -> L84
            L1e:
                if (r2 < 0) goto L2e
                r3 = 31
                if (r2 <= r3) goto L3e
                goto L2e
            L25:
                java.lang.String r2 = "\\n"
                goto L7d
            L28:
                java.lang.String r2 = "\\t"
                goto L7d
            L2b:
                java.lang.String r2 = "\\b"
                goto L7d
            L2e:
                r3 = 127(0x7f, float:1.78E-43)
                if (r2 < r3) goto L36
                r3 = 159(0x9f, float:2.23E-43)
                if (r2 <= r3) goto L3e
            L36:
                r3 = 8192(0x2000, float:1.148E-41)
                if (r2 < r3) goto L6e
                r3 = 8447(0x20ff, float:1.1837E-41)
                if (r2 > r3) goto L6e
            L3e:
                java.lang.String r3 = "\\u"
                r7.append(r3)     // Catch: java.io.IOException -> L84
                java.lang.String r3 = "0123456789ABCDEF"
                int r4 = r2 >> 12
                r4 = r4 & 15
                char r4 = r3.charAt(r4)     // Catch: java.io.IOException -> L84
                r7.append(r4)     // Catch: java.io.IOException -> L84
                int r4 = r2 >> 8
                r4 = r4 & 15
                char r4 = r3.charAt(r4)     // Catch: java.io.IOException -> L84
                r7.append(r4)     // Catch: java.io.IOException -> L84
                int r4 = r2 >> 4
                r4 = r4 & 15
                char r4 = r3.charAt(r4)     // Catch: java.io.IOException -> L84
                r7.append(r4)     // Catch: java.io.IOException -> L84
                int r2 = r2 >> 0
                r2 = r2 & 15
                char r2 = r3.charAt(r2)     // Catch: java.io.IOException -> L84
            L6e:
                r7.append(r2)     // Catch: java.io.IOException -> L84
                goto L80
            L72:
                java.lang.String r2 = "\\\\"
                goto L7d
            L75:
                java.lang.String r2 = "\\\""
                goto L7d
            L78:
                java.lang.String r2 = "\\r"
                goto L7d
            L7b:
                java.lang.String r2 = "\\f"
            L7d:
                r7.append(r2)     // Catch: java.io.IOException -> L84
            L80:
                int r1 = r1 + 1
                goto L5
            L83:
                return
            L84:
                java.lang.RuntimeException r6 = new java.lang.RuntimeException
                java.lang.String r7 = "Impossible Exception"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b2.j.c.a(java.lang.String, java.lang.Appendable):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d implements g {
        private d() {
        }

        @Override // sdk.pendo.io.b2.j.g
        public boolean a(String str) {
            int i;
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if (j.b(charAt) || j.e(charAt)) {
                return true;
            }
            for (int i2 = 1; i2 < length; i2++) {
                char charAt2 = str.charAt(i2);
                if (j.d(charAt2) || j.e(charAt2)) {
                    return true;
                }
            }
            if (j.a(str)) {
                return true;
            }
            char charAt3 = str.charAt(0);
            if ((charAt3 >= '0' && charAt3 <= '9') || charAt3 == '-') {
                int i3 = 1;
                while (i3 < length) {
                    charAt3 = str.charAt(i3);
                    if (charAt3 < '0' || charAt3 > '9') {
                        break;
                    }
                    i3++;
                }
                if (i3 == length) {
                    return true;
                }
                if (charAt3 != '.') {
                    i = i3 + 1;
                    while (i < length) {
                        charAt3 = str.charAt(i);
                        if (charAt3 < '0' || charAt3 > '9') {
                            break;
                        }
                    }
                    if (i == length) {
                        return true;
                    }
                    if (charAt3 == 'E' || charAt3 == 'e') {
                        i++;
                        if (i == length) {
                            return false;
                        }
                        char charAt4 = str.charAt(i);
                        if (charAt4 == '+' || charAt4 == '-') {
                            i++;
                            str.charAt(i);
                        }
                    }
                    if (i == length) {
                        return false;
                    }
                    while (i < length) {
                        char charAt5 = str.charAt(i);
                        if (charAt5 < '0' || charAt5 > '9') {
                            break;
                        }
                        i++;
                    }
                    if (i == length) {
                        return true;
                    }
                }
                i++;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e implements g {
        private e() {
        }

        @Override // sdk.pendo.io.b2.j.g
        public boolean a(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                return true;
            }
            for (int i = 0; i < length; i++) {
                char charAt2 = str.charAt(i);
                if (j.a(charAt2) || j.b(charAt2) || j.c(charAt2) || j.e(charAt2)) {
                    return true;
                }
            }
            return j.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class f implements g {
        private f() {
        }

        @Override // sdk.pendo.io.b2.j.g
        public boolean a(String str) {
            return true;
        }
    }

    public interface g {
        boolean a(String str);
    }

    public interface h {
        void a(String str, Appendable appendable);
    }

    static {
        f885a = new e();
        b = new f();
        c = new d();
        d = new c();
        e = new b();
    }

    public static boolean a(char c2) {
        return c2 == '\r' || c2 == '\n' || c2 == '\t' || c2 == ' ';
    }

    public static boolean a(String str) {
        String str2;
        if (str.length() < 3) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == 'n') {
            str2 = "null";
        } else if (charAt == 't') {
            str2 = "true";
        } else if (charAt == 'f') {
            str2 = Constants.CASEFIRST_FALSE;
        } else {
            if (charAt != 'N') {
                return false;
            }
            str2 = "NaN";
        }
        return str.equals(str2);
    }

    public static boolean b(char c2) {
        return c2 == '{' || c2 == '[' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == ':' || c2 == '\'' || c2 == '\"';
    }

    public static boolean c(char c2) {
        return c2 == '\b' || c2 == '\f' || c2 == '\n';
    }

    public static boolean d(char c2) {
        return c2 == '}' || c2 == ']' || c2 == ',' || c2 == ':';
    }

    public static boolean e(char c2) {
        return (c2 >= 0 && c2 <= 31) || (c2 >= 127 && c2 <= 159) || (c2 >= 8192 && c2 <= 8447);
    }
}
