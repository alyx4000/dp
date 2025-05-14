package org.socure.core;

/* loaded from: classes6.dex */
public class Range {

    /* renamed from: a, reason: collision with root package name */
    public int f804a;
    public int b;

    public Range() {
        this(0, 0);
    }

    public Range(int i, int i2) {
        this.f804a = i;
        this.b = i2;
    }

    public static Range a() {
        return new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public Object clone() {
        return new Range(this.f804a, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.f804a == range.f804a && this.b == range.b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f804a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return "[" + this.f804a + ", " + this.b + ")";
    }
}
