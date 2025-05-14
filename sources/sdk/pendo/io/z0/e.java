package sdk.pendo.io.z0;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f1866a;
    public Object b;

    public e(int i, Object obj) {
        this.f1866a = i;
        this.b = obj;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        switch (this.f1866a) {
            case -1:
                str = "END OF FILE";
                sb.append(str);
                break;
            case 0:
                sb.append("VALUE(").append(this.b).append(")");
                break;
            case 1:
                str = "LEFT BRACE({)";
                sb.append(str);
                break;
            case 2:
                str = "RIGHT BRACE(})";
                sb.append(str);
                break;
            case 3:
                str = "LEFT SQUARE([)";
                sb.append(str);
                break;
            case 4:
                str = "RIGHT SQUARE(])";
                sb.append(str);
                break;
            case 5:
                str = "COMMA(,)";
                sb.append(str);
                break;
            case 6:
                str = "COLON(:)";
                sb.append(str);
                break;
        }
        return sb.toString();
    }
}
