package com.socure.docv.capturesdk.common.view.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final d f353a;
    public final d b;
    public final d c;
    public final d d;
    public final d e;
    public final d f;

    public e(d v1, d v2, d v3, d h1, d h2, d h3) {
        Intrinsics.checkNotNullParameter(v1, "v1");
        Intrinsics.checkNotNullParameter(v2, "v2");
        Intrinsics.checkNotNullParameter(v3, "v3");
        Intrinsics.checkNotNullParameter(h1, "h1");
        Intrinsics.checkNotNullParameter(h2, "h2");
        Intrinsics.checkNotNullParameter(h3, "h3");
        this.f353a = v1;
        this.b = v2;
        this.c = v3;
        this.d = h1;
        this.e = h2;
        this.f = h3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.f353a, eVar.f353a) && Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c) && Intrinsics.areEqual(this.d, eVar.d) && Intrinsics.areEqual(this.e, eVar.e) && Intrinsics.areEqual(this.f, eVar.f);
    }

    public int hashCode() {
        return this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f353a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "GridLines(v1=" + this.f353a + ", v2=" + this.b + ", v3=" + this.c + ", h1=" + this.d + ", h2=" + this.e + ", h3=" + this.f + ")";
    }
}
