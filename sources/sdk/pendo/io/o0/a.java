package sdk.pendo.io.o0;

import java.util.TimeZone;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f1448a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d4 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:18:0x0055, B:20:0x0065, B:21:0x0067, B:23:0x0073, B:24:0x0075, B:26:0x007b, B:30:0x0085, B:35:0x0095, B:37:0x009d, B:43:0x00ce, B:45:0x00d4, B:47:0x00db, B:48:0x0186, B:55:0x00ea, B:56:0x0102, B:57:0x0103, B:60:0x0121, B:62:0x012e, B:65:0x0137, B:67:0x0152, B:70:0x0161, B:71:0x0181, B:73:0x0184, B:74:0x010e, B:75:0x01b8, B:76:0x01bf, B:77:0x00b6, B:78:0x00b9), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b8 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:18:0x0055, B:20:0x0065, B:21:0x0067, B:23:0x0073, B:24:0x0075, B:26:0x007b, B:30:0x0085, B:35:0x0095, B:37:0x009d, B:43:0x00ce, B:45:0x00d4, B:47:0x00db, B:48:0x0186, B:55:0x00ea, B:56:0x0102, B:57:0x0103, B:60:0x0121, B:62:0x012e, B:65:0x0137, B:67:0x0152, B:70:0x0161, B:71:0x0181, B:73:0x0184, B:74:0x010e, B:75:0x01b8, B:76:0x01bf, B:77:0x00b6, B:78:0x00b9), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date a(java.lang.String r19, java.text.ParsePosition r20) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.o0.a.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int a(String str, int i, int i2) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }
}
