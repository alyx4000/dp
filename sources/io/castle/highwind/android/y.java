package io.castle.highwind.android;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f782a;
    public final int b;

    public y(String str, int i) {
        this.f782a = str;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Intrinsics.areEqual(this.f782a, yVar.f782a) && this.b == yVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f782a.hashCode() * 31);
    }

    public final String toString() {
        return "Params(data=" + this.f782a + ", size=" + this.b + ')';
    }
}
