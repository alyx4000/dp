package sdk.pendo.io.z0;

/* loaded from: classes4.dex */
public class c extends Exception {
    private int A;
    private int f;
    private Object s;

    public c(int i, int i2, Object obj) {
        this.A = i;
        this.f = i2;
        this.s = obj;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder append;
        String str;
        StringBuilder append2;
        StringBuilder sb = new StringBuilder();
        int i = this.f;
        if (i == 0) {
            append = sb.append("Unexpected character (").append(this.s);
            str = ") at position ";
        } else {
            if (i != 1) {
                if (i == 2) {
                    sb.append("Unexpected exception at position ").append(this.A).append(": ").append(this.s);
                    return sb.toString();
                }
                append2 = sb.append("Unknown error at position ");
                append2.append(this.A).append(".");
                return sb.toString();
            }
            append = sb.append("Unexpected token ").append(this.s);
            str = " at position ";
        }
        append2 = append.append(str);
        append2.append(this.A).append(".");
        return sb.toString();
    }
}
