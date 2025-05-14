package sdk.pendo.io.o1;

import java.io.StringWriter;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class i {
    public static String a(CharSequence... charSequenceArr) {
        CharSequence charSequence;
        if (charSequenceArr.length == 0) {
            return "";
        }
        if (charSequenceArr.length == 1) {
            charSequence = charSequenceArr[0];
        } else {
            int i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
                int length = charSequenceArr[i3].length();
                i2 += length;
                if (i != -2 && length > 0) {
                    i = i == -1 ? i3 : -2;
                }
            }
            if (i2 == 0) {
                return "";
            }
            if (i <= 0) {
                StringBuilder sb = new StringBuilder(i2);
                for (CharSequence charSequence2 : charSequenceArr) {
                    sb.append(charSequence2);
                }
                return sb.toString();
            }
            charSequence = charSequenceArr[i];
        }
        return charSequence.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x009f, code lost:
    
        if (r8 != false) goto L40;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0040. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, boolean r8) {
        /*
            if (r7 != 0) goto L4
            r7 = 0
            return r7
        L4:
            int r0 = r7.length()
            java.io.StringWriter r1 = new java.io.StringWriter
            int r2 = r0 * 2
            r1.<init>(r2)
            r2 = 0
        L10:
            if (r2 >= r0) goto Lab
            char r3 = r7.charAt(r2)
            r4 = 4095(0xfff, float:5.738E-42)
            if (r3 <= r4) goto L22
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\\u"
            goto L75
        L22:
            r4 = 255(0xff, float:3.57E-43)
            if (r3 <= r4) goto L2e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\\u0"
            goto L75
        L2e:
            r4 = 127(0x7f, float:1.78E-43)
            java.lang.String r5 = "\\u00"
            if (r3 <= r4) goto L3a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L75
        L3a:
            r4 = 32
            r6 = 92
            if (r3 >= r4) goto L89
            switch(r3) {
                case 8: goto L65;
                case 9: goto L5f;
                case 10: goto L59;
                case 11: goto L43;
                case 12: goto L53;
                case 13: goto L4d;
                default: goto L43;
            }
        L43:
            r4 = 15
            if (r3 <= r4) goto L6e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L75
        L4d:
            r1.write(r6)
            r3 = 114(0x72, float:1.6E-43)
            goto L6a
        L53:
            r1.write(r6)
            r3 = 102(0x66, float:1.43E-43)
            goto L6a
        L59:
            r1.write(r6)
            r3 = 110(0x6e, float:1.54E-43)
            goto L6a
        L5f:
            r1.write(r6)
            r3 = 116(0x74, float:1.63E-43)
            goto L6a
        L65:
            r1.write(r6)
            r3 = 98
        L6a:
            r1.write(r3)
            goto La7
        L6e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\\u000"
        L75:
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r3 = a(r3)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            r1.write(r3)
            goto La7
        L89:
            r4 = 34
            if (r3 == r4) goto La1
            r4 = 39
            if (r3 == r4) goto L9f
            r4 = 47
            if (r3 == r4) goto La1
            if (r3 == r6) goto L98
            goto L6a
        L98:
            r1.write(r6)
            r1.write(r6)
            goto La7
        L9f:
            if (r8 == 0) goto La4
        La1:
            r1.write(r6)
        La4:
            r1.write(r4)
        La7:
            int r2 = r2 + 1
            goto L10
        Lab:
            java.lang.String r7 = r1.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.o1.i.a(java.lang.String, boolean):java.lang.String");
    }

    public static String a(char c) {
        return Integer.toHexString(c).toUpperCase();
    }

    public static String a(String str, Iterable<?> iterable) {
        return a(str, "", iterable);
    }

    public static String a(String str, String str2, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(str2);
        while (true) {
            append.append(it.next()).append(str2);
            if (!it.hasNext()) {
                return sb.toString();
            }
            append = sb.append(str).append(str2);
        }
    }

    public static <T extends CharSequence> T a(T t, String str, Object... objArr) {
        if (t == null || t.length() == 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    public static <T> T a(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static boolean a(boolean... zArr) {
        int i = 0;
        for (boolean z : zArr) {
            if (z && (i = i + 1) > 1) {
                return false;
            }
        }
        return 1 == i;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringWriter stringWriter = new StringWriter(length);
        StringBuilder sb = new StringBuilder(4);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (z2) {
                sb.append(charAt);
                if (sb.length() == 4) {
                    try {
                        stringWriter.write((char) Integer.parseInt(sb.toString(), 16));
                        sb.setLength(0);
                        z = false;
                        z2 = false;
                    } catch (NumberFormatException e) {
                        throw new sdk.pendo.io.n1.h("Unable to parse unicode value: " + ((Object) sb), e);
                    }
                } else {
                    continue;
                }
            } else if (z) {
                int i2 = 34;
                if (charAt != '\"') {
                    i2 = 39;
                    if (charAt != '\'') {
                        if (charAt == '\\') {
                            stringWriter.write(92);
                            z = false;
                        } else if (charAt == 'b') {
                            i2 = 8;
                        } else if (charAt == 'f') {
                            i2 = 12;
                        } else if (charAt == 'n') {
                            i2 = 10;
                        } else if (charAt == 'r') {
                            i2 = 13;
                        } else if (charAt == 't') {
                            i2 = 9;
                        } else if (charAt != 'u') {
                            z = false;
                            stringWriter.write(charAt);
                        } else {
                            z = false;
                            z2 = true;
                        }
                    }
                }
                stringWriter.write(i2);
                z = false;
            } else {
                if (charAt == '\\') {
                    z = true;
                }
                stringWriter.write(charAt);
            }
        }
        if (z) {
            stringWriter.write(92);
        }
        return stringWriter.toString();
    }
}
