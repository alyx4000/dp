package sdk.pendo.io.f1;

import java.text.DateFormat;
import java.util.Date;

/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private long f1071a;

    private d(long j) {
        c(j);
    }

    private boolean a() {
        long b = b();
        long j = 1000 * b;
        return (b <= 0 || j >= b) && (b >= 0 || j <= b) && (b != 0 || j == 0);
    }

    public static d b(long j) {
        return new d(j);
    }

    public static d d() {
        return a(System.currentTimeMillis());
    }

    public long c() {
        long b = b();
        long j = 1000 * b;
        if (a()) {
            return j;
        }
        throw new ArithmeticException("converting " + b + " seconds to milliseconds (x1000) resulted in long integer overflow (" + j + ")");
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof d) && this.f1071a == ((d) obj).f1071a);
    }

    public int hashCode() {
        long j = this.f1071a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NumericDate{");
        sb.append(b());
        if (a()) {
            sb.append(" -> ").append(DateFormat.getDateTimeInstance(2, 1).format(new Date(c())));
        }
        sb.append('}');
        return sb.toString();
    }

    public static d a(long j) {
        return b(j / 1000);
    }

    public long b() {
        return this.f1071a;
    }

    public void c(long j) {
        this.f1071a = j;
    }

    public boolean a(d dVar) {
        return this.f1071a < dVar.b();
    }
}
