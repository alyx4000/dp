package org.socure.core;

/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public double f806a;
    public double b;

    public d() {
        this(0.0d, 0.0d);
    }

    public d(double d, double d2) {
        this.f806a = d;
        this.b = d2;
    }

    public Object clone() {
        return new d(this.f806a, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f806a == dVar.f806a && this.b == dVar.b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f806a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return "{" + this.f806a + ", " + this.b + "}";
    }
}
