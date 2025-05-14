package sdk.pendo.io.z1;

import java.lang.reflect.Field;
import java.util.HashMap;
import sdk.pendo.io.a.d0;
import sdk.pendo.io.a.s;
import sdk.pendo.io.a.u;

/* loaded from: classes4.dex */
public class a {
    protected static void a(u uVar, d0 d0Var) {
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        String str4;
        String str5;
        String str6;
        switch (d0Var.c()) {
            case 1:
                i = 184;
                str = "java/lang/Boolean";
                str2 = "valueOf";
                str3 = "(Z)Ljava/lang/Boolean;";
                uVar.a(i, str, str2, str3, false);
                return;
            case 2:
                i2 = 184;
                str4 = "java/lang/Character";
                str5 = "valueOf";
                str6 = "(C)Ljava/lang/Character;";
                break;
            case 3:
                i = 184;
                str = "java/lang/Byte";
                str2 = "valueOf";
                str3 = "(B)Ljava/lang/Byte;";
                uVar.a(i, str, str2, str3, false);
                return;
            case 4:
                i2 = 184;
                str4 = "java/lang/Short";
                str5 = "valueOf";
                str6 = "(S)Ljava/lang/Short;";
                break;
            case 5:
                i = 184;
                str = "java/lang/Integer";
                str2 = "valueOf";
                str3 = "(I)Ljava/lang/Integer;";
                uVar.a(i, str, str2, str3, false);
                return;
            case 6:
                i2 = 184;
                str4 = "java/lang/Float";
                str5 = "valueOf";
                str6 = "(F)Ljava/lang/Float;";
                break;
            case 7:
                i = 184;
                str = "java/lang/Long";
                str2 = "valueOf";
                str3 = "(J)Ljava/lang/Long;";
                uVar.a(i, str, str2, str3, false);
                return;
            case 8:
                i2 = 184;
                str4 = "java/lang/Double";
                str5 = "valueOf";
                str6 = "(D)Ljava/lang/Double;";
                break;
            default:
                return;
        }
        uVar.a(i2, str4, str5, str6, false);
    }

    public static String b(String str) {
        int length = str.length();
        char[] cArr = new char[length + 2];
        cArr[0] = 'i';
        cArr[1] = 's';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[2] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 2] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static String c(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 's';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static b[] a(Class<?> cls, j jVar) {
        HashMap hashMap = new HashMap();
        if (jVar == null) {
            jVar = c.f1868a;
        }
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                String name = field.getName();
                if (!hashMap.containsKey(name)) {
                    b bVar = new b(cls, field, jVar);
                    if (bVar.h()) {
                        hashMap.put(name, bVar);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return (b[]) hashMap.values().toArray(new b[hashMap.size()]);
    }

    public static String a(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static s[] a(int i) {
        s[] sVarArr = new s[i];
        for (int i2 = 0; i2 < i; i2++) {
            sVarArr[i2] = new s();
        }
        return sVarArr;
    }
}
