package sdk.pendo.io.k0;

import java.math.BigInteger;

/* loaded from: classes6.dex */
public final class n extends i {
    private final Object f;

    public n(Boolean bool) {
        this.f = sdk.pendo.io.m0.a.a(bool);
    }

    @Override // sdk.pendo.io.k0.i
    public boolean a() {
        return o() ? ((Boolean) this.f).booleanValue() : Boolean.parseBoolean(g());
    }

    @Override // sdk.pendo.io.k0.i
    public float b() {
        return p() ? n().floatValue() : Float.parseFloat(g());
    }

    @Override // sdk.pendo.io.k0.i
    public int c() {
        return p() ? n().intValue() : Integer.parseInt(g());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f == null) {
            return nVar.f == null;
        }
        if (a(this) && a(nVar)) {
            return n().longValue() == nVar.n().longValue();
        }
        Object obj2 = this.f;
        if (!(obj2 instanceof Number) || !(nVar.f instanceof Number)) {
            return obj2.equals(nVar.f);
        }
        double doubleValue = n().doubleValue();
        double doubleValue2 = nVar.n().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    @Override // sdk.pendo.io.k0.i
    public String g() {
        return p() ? n().toString() : o() ? ((Boolean) this.f).toString() : (String) this.f;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = n().longValue();
        } else {
            Object obj = this.f;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(n().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public double l() {
        return p() ? n().doubleValue() : Double.parseDouble(g());
    }

    public long m() {
        return p() ? n().longValue() : Long.parseLong(g());
    }

    public Number n() {
        Object obj = this.f;
        return obj instanceof String ? new sdk.pendo.io.m0.f((String) obj) : (Number) obj;
    }

    public boolean o() {
        return this.f instanceof Boolean;
    }

    public boolean p() {
        return this.f instanceof Number;
    }

    public boolean q() {
        return this.f instanceof String;
    }

    public n(Number number) {
        this.f = sdk.pendo.io.m0.a.a(number);
    }

    private static boolean a(n nVar) {
        Object obj = nVar.f;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public n(String str) {
        this.f = sdk.pendo.io.m0.a.a(str);
    }
}
