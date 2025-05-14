package com.socure.idplus.device.internal.utils;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f617a;
    public final int b;
    public final int c;
    public final int d;

    public c(int i, int i2, int i3, int i4) {
        this.f617a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f617a == cVar.f617a && this.b == cVar.b && this.c == cVar.c && this.d == cVar.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + ((Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f617a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DisplayDimensions(viewportWidth=" + this.f617a + ", viewportHeight=" + this.b + ", screenWidth=" + this.c + ", screenHeight=" + this.d + ")";
    }
}
