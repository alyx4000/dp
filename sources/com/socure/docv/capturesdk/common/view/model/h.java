package com.socure.docv.capturesdk.common.view.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f356a;
    public final String b;

    public h(String label, String labelColor) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(labelColor, "labelColor");
        this.f356a = label;
        this.b = labelColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.f356a, hVar.f356a) && Intrinsics.areEqual(this.b, hVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.f356a.hashCode() * 31);
    }

    public String toString() {
        return "TextLabel(label=" + this.f356a + ", labelColor=" + this.b + ")";
    }
}
