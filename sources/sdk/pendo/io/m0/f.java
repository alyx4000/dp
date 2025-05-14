package sdk.pendo.io.m0;

import java.math.BigDecimal;

/* loaded from: classes6.dex */
public final class f extends Number {
    private final String f;

    public f(String str) {
        this.f = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f;
        String str2 = ((f) obj).f;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.f);
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f).longValue();
        }
    }

    public String toString() {
        return this.f;
    }
}
