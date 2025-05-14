package sdk.pendo.io.v7;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import okio.Utf8;
import org.bouncycastle.asn1.BERTags;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static int[] f1690a;
    private static int b;
    private static int c;

    /* renamed from: sdk.pendo.io.v7.a$a, reason: collision with other inner class name */
    public static class C0252a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1691a = true;
    }

    private static boolean a(int i, boolean z) {
        if (i < 55296 || i > 57343) {
            return true;
        }
        if (z) {
            throw new b("Lone surrogate U+" + Integer.toHexString(i).toUpperCase(Locale.US) + " is not a scalar value");
        }
        return false;
    }

    public static String b(String str, C0252a c0252a) {
        boolean z = c0252a.f1691a;
        int[] a2 = a(str);
        int length = a2.length;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (true) {
            i++;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(b(a2[i], z));
        }
    }

    private static char[] a(int i, int i2) {
        return Character.toChars(((i >> i2) & 63) | 128);
    }

    private static String b(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        if ((i & (-128)) == 0) {
            return sb.append(Character.toChars(i)).toString();
        }
        if ((i & (-2048)) == 0) {
            sb.append(Character.toChars(((i >> 6) & 31) | 192));
        } else if (((-65536) & i) == 0) {
            if (!a(i, z)) {
                i = Utf8.REPLACEMENT_CODE_POINT;
            }
            sb.append(Character.toChars(((i >> 12) & 15) | BERTags.FLAGS));
            sb.append(a(i, 6));
        } else if (((-2097152) & i) == 0) {
            sb.append(Character.toChars(((i >> 18) & 7) | 240));
            sb.append(a(i, 12));
            sb.append(a(i, 6));
        }
        sb.append(Character.toChars((i & 63) | 128));
        return sb.toString();
    }

    public static String a(String str, C0252a c0252a) {
        boolean z = c0252a.f1691a;
        int[] a2 = a(str);
        f1690a = a2;
        b = a2.length;
        c = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int a3 = a(z);
            if (a3 == -1) {
                return a(a(arrayList));
            }
            arrayList.add(Integer.valueOf(a3));
        }
    }

    private static int a(boolean z) {
        int i = c;
        int i2 = b;
        if (i > i2) {
            throw new b("Invalid byte index");
        }
        if (i == i2) {
            return -1;
        }
        int i3 = f1690a[i] & 255;
        c = i + 1;
        if ((i3 & 128) == 0) {
            return i3;
        }
        if ((i3 & BERTags.FLAGS) == 192) {
            int a2 = a() | ((i3 & 31) << 6);
            if (a2 >= 128) {
                return a2;
            }
            throw new b("Invalid continuation byte");
        }
        if ((i3 & 240) == 224) {
            int a3 = (a() << 6) | ((i3 & 15) << 12) | a();
            if (a3 >= 2048) {
                return a(a3, z) ? a3 : Utf8.REPLACEMENT_CODE_POINT;
            }
            throw new b("Invalid continuation byte");
        }
        if ((i3 & 248) == 240) {
            int a4 = (a() << 12) | ((i3 & 15) << 18) | (a() << 6) | a();
            if (a4 >= 65536 && a4 <= 1114111) {
                return a4;
            }
        }
        throw new b("Invalid continuation byte");
    }

    private static int[] a(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    private static int a() {
        int i = c;
        if (i >= b) {
            throw new b("Invalid byte index");
        }
        int i2 = f1690a[i] & 255;
        c = i + 1;
        if ((i2 & 192) == 128) {
            return i2 & 63;
        }
        throw new b("Invalid continuation byte");
    }

    private static int[] a(String str) {
        int length = str.length();
        int i = 0;
        int[] iArr = new int[str.codePointCount(0, length)];
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return iArr;
    }

    private static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.appendCodePoint(i);
        }
        return sb.toString();
    }
}
