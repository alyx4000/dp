package org.socure.core;

import io.sentry.protocol.ViewHierarchyNode;

/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public double f808a;
    public double b;

    public f() {
        this(0.0d, 0.0d);
    }

    public f(double d, double d2) {
        this.f808a = d;
        this.b = d2;
    }

    public f(double[] dArr) {
        a(dArr);
    }

    public void a(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f808a = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d = dArr[1];
            }
        } else {
            this.f808a = 0.0d;
        }
        this.b = d;
    }

    public Object clone() {
        return new f(this.f808a, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f808a == fVar.f808a && this.b == fVar.b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f808a);
        return (i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return ((int) this.f808a) + ViewHierarchyNode.JsonKeys.X + ((int) this.b);
    }
}
