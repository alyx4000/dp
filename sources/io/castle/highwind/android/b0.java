package io.castle.highwind.android;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f763a = new a();

    public static final class a {
        public final String a(String str, String str2) {
            String substring = StringsKt.substring(str, RangesKt.until(1, str.length()));
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (char c : substring.toCharArray()) {
                arrayList.add(Integer.toString(Integer.parseInt(Character.toString(c), CharsKt.checkRadix(16)) ^ Integer.parseInt(Character.toString(str2.toCharArray()[i]), CharsKt.checkRadix(16)), CharsKt.checkRadix(16)));
                i = (i + 1) % str2.length();
            }
            return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null) + str2;
        }

        public final String a(String str, int i, char c, String str2) {
            String str3 = new String(CollectionsKt.toCharArray(ArraysKt.slice(str.toCharArray(), RangesKt.until(0, i))));
            int parseInt = Integer.parseInt(String.valueOf(c), CharsKt.checkRadix(16));
            Character[] typedArray = ArraysKt.toTypedArray(str3.toCharArray());
            int length = typedArray.length;
            int i2 = parseInt % length;
            Character[] chArr = new Character[0];
            int length2 = typedArray.length;
            if (i2 > length2) {
                i2 = length2;
            }
            Object[][] objArr = {ArraysKt.slice((Object[]) typedArray, RangesKt.until(i2, length)).toArray(new Character[0]), CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) ArraysKt.slice((Object[]) typedArray, RangesKt.until(0, i2)), (Object[]) chArr), (Iterable) ArraysKt.slice((Object[]) typedArray, RangesKt.until(i2 + length, length2))).toArray(new Character[0])};
            String str4 = new String(ArraysKt.toCharArray((Character[]) ArraysKt.plus(objArr[0], objArr[1])));
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (char c2 : str2.toCharArray()) {
                arrayList.add(Integer.toString(Integer.parseInt(Character.toString(c2), CharsKt.checkRadix(16)) ^ Integer.parseInt(Character.toString(str4.toCharArray()[i3]), CharsKt.checkRadix(16)), CharsKt.checkRadix(16)));
                i3 = (i3 + 1) % str4.length();
            }
            return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        }
    }
}
