package com.socure.docv.capturesdk.common.view.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public float f352a;
    public float b;
    public float c;
    public float d;
    public final float e;
    public final float f;

    public d(float f, float f2, float f3, float f4) {
        this.f352a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f3 - f;
        this.f = f4 - f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.f352a), (Object) Float.valueOf(dVar.f352a)) && Intrinsics.areEqual((Object) Float.valueOf(this.b), (Object) Float.valueOf(dVar.b)) && Intrinsics.areEqual((Object) Float.valueOf(this.c), (Object) Float.valueOf(dVar.c)) && Intrinsics.areEqual((Object) Float.valueOf(this.d), (Object) Float.valueOf(dVar.d));
    }

    public int hashCode() {
        return Float.hashCode(this.d) + ((Float.hashCode(this.c) + ((Float.hashCode(this.b) + (Float.hashCode(this.f352a) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "GridLine(startX=" + this.f352a + ", startY=" + this.b + ", endX=" + this.c + ", endY=" + this.d + ")";
    }
}
