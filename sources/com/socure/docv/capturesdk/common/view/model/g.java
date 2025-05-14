package com.socure.docv.capturesdk.common.view.model;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f355a;
    public final h b;
    public final h c;
    public final h d;
    public final Bitmap e;
    public final b f;
    public final b g;
    public final Bitmap h;

    public g(String imageDimenRatio, h title, h confirmationTitle, h confirmationText, Bitmap previewBitmap, b agreeButton, b retake, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageDimenRatio, "imageDimenRatio");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(confirmationTitle, "confirmationTitle");
        Intrinsics.checkNotNullParameter(confirmationText, "confirmationText");
        Intrinsics.checkNotNullParameter(previewBitmap, "previewBitmap");
        Intrinsics.checkNotNullParameter(agreeButton, "agreeButton");
        Intrinsics.checkNotNullParameter(retake, "retake");
        this.f355a = imageDimenRatio;
        this.b = title;
        this.c = confirmationTitle;
        this.d = confirmationText;
        this.e = previewBitmap;
        this.f = agreeButton;
        this.g = retake;
        this.h = bitmap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.f355a, gVar.f355a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && Intrinsics.areEqual(this.e, gVar.e) && Intrinsics.areEqual(this.f, gVar.f) && Intrinsics.areEqual(this.g, gVar.g) && Intrinsics.areEqual(this.h, gVar.h);
    }

    public int hashCode() {
        int hashCode = (this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f355a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Bitmap bitmap = this.h;
        return hashCode + (bitmap == null ? 0 : bitmap.hashCode());
    }

    public String toString() {
        return "PreviewData(imageDimenRatio=" + this.f355a + ", title=" + this.b + ", confirmationTitle=" + this.c + ", confirmationText=" + this.d + ", previewBitmap=" + this.e + ", agreeButton=" + this.f + ", retake=" + this.g + ", debugImage=" + this.h + ")";
    }
}
