package com.socure.docv.capturesdk.common.view.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f351a;
    public final String b;
    public final String c;
    public final String d;

    public b(String label, String labelColor, String str, String str2) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(labelColor, "labelColor");
        this.f351a = label;
        this.b = labelColor;
        this.c = str;
        this.d = str2;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.f351a, bVar.f351a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d);
    }

    public int hashCode() {
        int a2 = com.socure.docv.capturesdk.common.analytics.model.a.a(this.b, this.f351a.hashCode() * 31, 31);
        String str = this.c;
        int hashCode = (a2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Button(label=" + this.f351a + ", labelColor=" + this.b + ", borderColor=" + this.c + ", bgColor=" + this.d + ")";
    }
}
