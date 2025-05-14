package sdk.pendo.io.k7;

import com.google.android.gms.location.DeviceOrientationRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f1292a = 100;
    private long b = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
    private int c = 2;
    private double d;
    private int e;

    public long a() {
        BigInteger valueOf = BigInteger.valueOf(this.f1292a);
        BigInteger valueOf2 = BigInteger.valueOf(this.c);
        int i = this.e;
        this.e = i + 1;
        BigInteger multiply = valueOf.multiply(valueOf2.pow(i));
        if (this.d != 0.0d) {
            double random = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(random).multiply(BigDecimal.valueOf(this.d)).multiply(new BigDecimal(multiply)).toBigInteger();
            multiply = (((int) Math.floor(random * 10.0d)) & 1) == 0 ? multiply.subtract(bigInteger) : multiply.add(bigInteger);
        }
        return multiply.min(BigInteger.valueOf(this.b)).longValue();
    }

    public int b() {
        return this.e;
    }

    public void c() {
        this.e = 0;
    }

    public a a(double d) {
        this.d = d;
        return this;
    }

    public a b(long j) {
        this.f1292a = j;
        return this;
    }

    public a a(long j) {
        this.b = j;
        return this;
    }
}
