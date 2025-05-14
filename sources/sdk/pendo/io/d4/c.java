package sdk.pendo.io.d4;

import com.squareup.kotlinpoet.FileSpecKt;
import java.io.IOException;
import java.util.Hashtable;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.asn1.ASN1Encoding;
import sdk.pendo.io.e5.f;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.g;
import sdk.pendo.io.m3.g0;
import sdk.pendo.io.m3.n0;

/* loaded from: classes6.dex */
public class c {
    public static void a(StringBuffer stringBuffer, sdk.pendo.io.c4.b bVar, Hashtable hashtable) {
        if (!bVar.j()) {
            if (bVar.h() != null) {
                a(stringBuffer, bVar.h(), hashtable);
                return;
            }
            return;
        }
        sdk.pendo.io.c4.a[] i = bVar.i();
        boolean z = true;
        for (int i2 = 0; i2 != i.length; i2++) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append('+');
            }
            a(stringBuffer, i[i2], hashtable);
        }
    }

    private static a0 b(String str) {
        try {
            return a0.a(f.a(str, 1, str.length() - 1));
        } catch (IOException e) {
            throw new IllegalStateException("unknown encoding in name: " + e);
        }
    }

    public static String c(String str) {
        if (str.indexOf(FileSpecKt.DEFAULT_INDENT) < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char charAt = str.charAt(0);
        stringBuffer.append(charAt);
        for (int i = 1; i < str.length(); i++) {
            char charAt2 = str.charAt(i);
            if (charAt != ' ' || charAt2 != ' ') {
                stringBuffer.append(charAt2);
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    public static void a(StringBuffer stringBuffer, sdk.pendo.io.c4.a aVar, Hashtable hashtable) {
        String str = (String) hashtable.get(aVar.h());
        if (str == null) {
            str = aVar.h().l();
        }
        stringBuffer.append(str);
        stringBuffer.append('=');
        stringBuffer.append(b(aVar.i()));
    }

    public static String b(g gVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!(gVar instanceof g0) || (gVar instanceof n0)) {
            try {
                stringBuffer.append('#');
                stringBuffer.append(f.b(gVar.b().a(ASN1Encoding.DER)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String c = ((g0) gVar).c();
            if (c.length() > 0 && c.charAt(0) == '#') {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
            }
            stringBuffer.append(c);
        }
        int length = stringBuffer.length();
        int i = (stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#') ? 2 : 0;
        while (i != length) {
            char charAt = stringBuffer.charAt(i);
            if (charAt != '\"' && charAt != '\\' && charAt != '+' && charAt != ',') {
                switch (charAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i++;
                        continue;
                }
            }
            stringBuffer.insert(i, "\\");
            i += 2;
            length++;
        }
        if (stringBuffer.length() > 0) {
            for (int i2 = 0; stringBuffer.length() > i2 && stringBuffer.charAt(i2) == ' '; i2 += 2) {
                stringBuffer.insert(i2, "\\");
            }
        }
        for (int length2 = stringBuffer.length() - 1; length2 >= 0 && stringBuffer.charAt(length2) == ' '; length2--) {
            stringBuffer.insert(length2, IOUtils.DIR_SEPARATOR_WINDOWS);
        }
        return stringBuffer.toString();
    }

    private static boolean a(sdk.pendo.io.c4.a aVar, sdk.pendo.io.c4.a aVar2) {
        if (aVar == aVar2) {
            return true;
        }
        return aVar != null && aVar2 != null && aVar.h().b(aVar2.h()) && a(aVar.i()).equals(a(aVar2.i()));
    }

    public static String a(g gVar) {
        return a(b(gVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        if (r5 >= r0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7) {
        /*
            int r0 = r7.length()
            r1 = 0
            if (r0 <= 0) goto L1d
            char r0 = r7.charAt(r1)
            r2 = 35
            if (r0 != r2) goto L1d
            sdk.pendo.io.m3.a0 r0 = b(r7)
            boolean r2 = r0 instanceof sdk.pendo.io.m3.g0
            if (r2 == 0) goto L1d
            sdk.pendo.io.m3.g0 r0 = (sdk.pendo.io.m3.g0) r0
            java.lang.String r7 = r0.c()
        L1d:
            java.lang.String r7 = sdk.pendo.io.d5.i.b(r7)
            int r0 = r7.length()
            r2 = 2
            if (r0 >= r2) goto L29
            return r7
        L29:
            int r0 = r0 + (-1)
        L2b:
            r2 = 32
            r3 = 92
            if (r1 >= r0) goto L42
            char r4 = r7.charAt(r1)
            if (r4 != r3) goto L42
            int r4 = r1 + 1
            char r4 = r7.charAt(r4)
            if (r4 != r2) goto L42
            int r1 = r1 + 2
            goto L2b
        L42:
            int r4 = r1 + 1
            r5 = r0
        L45:
            if (r5 <= r4) goto L58
            int r6 = r5 + (-1)
            char r6 = r7.charAt(r6)
            if (r6 != r3) goto L58
            char r6 = r7.charAt(r5)
            if (r6 != r2) goto L58
            int r5 = r5 + (-2)
            goto L45
        L58:
            if (r1 > 0) goto L5c
            if (r5 >= r0) goto L62
        L5c:
            int r5 = r5 + 1
            java.lang.String r7 = r7.substring(r1, r5)
        L62:
            java.lang.String r7 = c(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d4.c.a(java.lang.String):java.lang.String");
    }

    public static boolean a(sdk.pendo.io.c4.b bVar, sdk.pendo.io.c4.b bVar2) {
        if (bVar.size() != bVar2.size()) {
            return false;
        }
        sdk.pendo.io.c4.a[] i = bVar.i();
        sdk.pendo.io.c4.a[] i2 = bVar2.i();
        if (i.length != i2.length) {
            return false;
        }
        for (int i3 = 0; i3 != i.length; i3++) {
            if (!a(i[i3], i2[i3])) {
                return false;
            }
        }
        return true;
    }
}
