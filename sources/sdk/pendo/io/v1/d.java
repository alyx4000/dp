package sdk.pendo.io.v1;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f1653a;
    private final Integer b;
    private final a c;

    public enum a {
        SLICE_FROM,
        SLICE_TO,
        SLICE_BETWEEN
    }

    private d(Integer num, Integer num2, a aVar) {
        this.f1653a = num;
        this.b = num2;
        this.c = aVar;
    }

    public Integer a() {
        return this.f1653a;
    }

    public a b() {
        return this.c;
    }

    public Integer c() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Integer num = this.f1653a;
        sb.append(num == null ? "" : num.toString());
        sb.append(":");
        Integer num2 = this.b;
        sb.append(num2 != null ? num2.toString() : "");
        sb.append("]");
        return sb.toString();
    }

    public static d a(String str) {
        a aVar;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt) && charAt != '-' && charAt != ':') {
                throw new sdk.pendo.io.n1.f("Failed to parse SliceOperation: " + str);
            }
        }
        String[] split = str.split(":");
        Integer a2 = a(split, 0);
        Integer a3 = a(split, 1);
        if (a2 != null && a3 == null) {
            aVar = a.SLICE_FROM;
        } else if (a2 != null) {
            aVar = a.SLICE_BETWEEN;
        } else {
            if (a3 == null) {
                throw new sdk.pendo.io.n1.f("Failed to parse SliceOperation: " + str);
            }
            aVar = a.SLICE_TO;
        }
        return new d(a2, a3, aVar);
    }

    private static Integer a(String[] strArr, int i) {
        if (strArr.length <= i || strArr[i].equals("")) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(strArr[i]));
    }
}
