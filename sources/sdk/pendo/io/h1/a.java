package sdk.pendo.io.h1;

/* loaded from: classes6.dex */
public class a {
    public static String[] a(String str) {
        String[] split = str.split("\\.");
        if (!str.endsWith(".")) {
            return split;
        }
        String[] strArr = new String[split.length + 1];
        System.arraycopy(split, 0, strArr, 0, split.length);
        strArr[split.length] = "";
        return strArr;
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str == null) {
                str = "";
            }
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
