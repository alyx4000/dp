package io.castle.highwind.android;

import java.util.Iterator;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class w {
    public static final String a(int i) {
        String str = "0" + Integer.toString(i & 255, CharsKt.checkRadix(16));
        return StringsKt.slice(str, RangesKt.until(str.length() - 2, str.length()));
    }

    public static final String c(String str) {
        Iterator<String> it = StringsKt.chunked(str, 2).iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = str2 + Character.toChars(Integer.parseInt(it.next(), CharsKt.checkRadix(16)) & 255)[0];
        }
        return str2;
    }

    public static final String b(String str) {
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < length; i++) {
            str2 = str2 + Integer.toString(str.charAt(i) & 15, CharsKt.checkRadix(16));
        }
        return str2;
    }

    public static final String a(Integer[] numArr) {
        String str = "";
        for (Integer num : numArr) {
            str = str + a(num.intValue());
        }
        return str;
    }

    public static final String a(int i, int i2) {
        int i3 = i2 * 2;
        String str = "";
        for (int min = (int) Math.min(Math.pow(2.0d, i2 * 8) - 1, i); min > 0; min >>>= 8) {
            str = a(min) + str;
        }
        if (i3 > 0) {
            while (str.length() < i3) {
                str = "0" + str;
            }
        }
        return str;
    }

    public static final String a(String str) {
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < length; i++) {
            str2 = str2 + a(str.charAt(i));
        }
        return str2;
    }
}
