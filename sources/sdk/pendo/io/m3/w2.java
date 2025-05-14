package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class w2 {

    /* renamed from: a, reason: collision with root package name */
    private String f1395a;
    private int b = 0;

    public w2(String str) {
        this.f1395a = str;
    }

    public boolean a() {
        return this.b != -1;
    }

    public String b() {
        int i = this.b;
        if (i == -1) {
            return null;
        }
        int indexOf = this.f1395a.indexOf(46, i);
        if (indexOf == -1) {
            String substring = this.f1395a.substring(this.b);
            this.b = -1;
            return substring;
        }
        String substring2 = this.f1395a.substring(this.b, indexOf);
        this.b = indexOf + 1;
        return substring2;
    }
}
