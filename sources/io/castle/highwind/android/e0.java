package io.castle.highwind.android;

import java.util.Date;
import java.util.TimeZone;
import kotlin.collections.ArraysKt;
import org.bouncycastle.asn1.BERTags;

/* loaded from: classes2.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f770a = new a();

    public static final class a {
        public final int a() {
            return (TimeZone.getDefault().getDSTSavings() / 1000) / 60;
        }

        public final int b() {
            return -((TimeZone.getDefault().getOffset(new Date().getTime()) / 1000) / 60);
        }

        public final String c() {
            return TimeZone.getDefault().getID();
        }

        public final Integer[] a(String str, Integer num) {
            Integer[] numArr;
            Integer[] numArr2 = new Integer[0];
            int i = 0;
            int i2 = 0;
            while (i < str.length()) {
                Integer[] numArr3 = new Integer[0];
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    numArr = (Integer[]) ArraysKt.plus(numArr3, Integer.valueOf(charAt));
                } else if (charAt < 2048) {
                    numArr = (Integer[]) ArraysKt.plus((Integer[]) ArraysKt.plus(numArr3, Integer.valueOf((charAt >> 6) | 192)), Integer.valueOf((charAt & '?') | 128));
                } else if (charAt >= 55296 && charAt < 57344) {
                    i++;
                    int charAt2 = (((charAt & 1023) << 10) | (str.charAt(i) & 1023)) + 65536;
                    numArr = (Integer[]) ArraysKt.plus((Integer[]) ArraysKt.plus((Integer[]) ArraysKt.plus((Integer[]) ArraysKt.plus(numArr3, Integer.valueOf((charAt2 >> 18) | 240)), Integer.valueOf(((charAt2 >> 12) & 63) | 128)), Integer.valueOf(((charAt2 >> 6) & 63) | 128)), Integer.valueOf((charAt2 & 63) | 128));
                } else {
                    numArr = (Integer[]) ArraysKt.plus((Integer[]) ArraysKt.plus((Integer[]) ArraysKt.plus(numArr3, Integer.valueOf((charAt >> '\f') | BERTags.FLAGS)), Integer.valueOf(((charAt >> 6) & 63) | 128)), Integer.valueOf((charAt & '?') | 128));
                }
                if (num != null && numArr.length + i2 > num.intValue()) {
                    break;
                }
                i2 += numArr.length;
                numArr2 = (Integer[]) ArraysKt.plus((Object[]) numArr2, (Object[]) numArr);
                i++;
            }
            return numArr2;
        }
    }
}
