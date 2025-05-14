package org.socure.core;

import java.util.Arrays;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public double[] f807a;

    public e(double d) {
        this.f807a = new double[]{d, 0.0d, 0.0d, 0.0d};
    }

    public e(double[] dArr) {
        if (dArr != null && dArr.length == 4) {
            this.f807a = (double[]) dArr.clone();
        } else {
            this.f807a = new double[4];
            a(dArr);
        }
    }

    public void a(double[] dArr) {
        if (dArr != null) {
            double[] dArr2 = this.f807a;
            dArr2[0] = dArr.length > 0 ? dArr[0] : 0.0d;
            dArr2[1] = dArr.length > 1 ? dArr[1] : 0.0d;
            dArr2[2] = dArr.length > 2 ? dArr[2] : 0.0d;
            dArr2[3] = dArr.length > 3 ? dArr[3] : 0.0d;
            return;
        }
        double[] dArr3 = this.f807a;
        dArr3[3] = 0.0d;
        dArr3[2] = 0.0d;
        dArr3[1] = 0.0d;
        dArr3[0] = 0.0d;
    }

    public Object clone() {
        return new e(this.f807a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && Arrays.equals(this.f807a, ((e) obj).f807a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f807a) + 31;
    }

    public String toString() {
        return "[" + this.f807a[0] + ", " + this.f807a[1] + ", " + this.f807a[2] + ", " + this.f807a[3] + "]";
    }
}
