package com.socure.docv.capturesdk.common.view.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final h f354a;
    public final int b;
    public final List<String> c;
    public final String d;
    public final b e;

    public f(h title, int i, List<String> instructionList, String instrTextColor, b continueButton) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(instructionList, "instructionList");
        Intrinsics.checkNotNullParameter(instrTextColor, "instrTextColor");
        Intrinsics.checkNotNullParameter(continueButton, "continueButton");
        this.f354a = title;
        this.b = i;
        this.c = instructionList;
        this.d = instrTextColor;
        this.e = continueButton;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.f354a, fVar.f354a) && this.b == fVar.b && Intrinsics.areEqual(this.c, fVar.c) && Intrinsics.areEqual(this.d, fVar.d) && Intrinsics.areEqual(this.e, fVar.e);
    }

    public int hashCode() {
        return this.e.hashCode() + com.socure.docv.capturesdk.common.analytics.model.a.a(this.d, (this.c.hashCode() + ((Integer.hashCode(this.b) + (this.f354a.hashCode() * 31)) * 31)) * 31, 31);
    }

    public String toString() {
        return "HelpViewData(title=" + this.f354a + ", imageResId=" + this.b + ", instructionList=" + this.c + ", instrTextColor=" + this.d + ", continueButton=" + this.e + ")";
    }
}
