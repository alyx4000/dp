package sdk.pendo.io.o2;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes6.dex */
public class a {
    public static int[] a(int[] iArr) {
        Arrays.sort(iArr);
        return iArr;
    }

    public static <T> T[] a(T[] tArr, Comparator<? super T> comparator) {
        Arrays.sort(tArr, comparator);
        return tArr;
    }
}
