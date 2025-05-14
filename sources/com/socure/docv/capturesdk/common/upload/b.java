package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.common.analytics.model.Face;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadResult;
import com.socure.docv.capturesdk.core.processor.model.Output;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final UploadImage f317a;
    public final UploadResult b;
    public final Output c;
    public final ArrayList<Face> d;

    public b(UploadImage uploadImage, UploadResult uploadResult, Output output, ArrayList<Face> arrayList) {
        Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        Intrinsics.checkNotNullParameter(output, "output");
        this.f317a = uploadImage;
        this.b = uploadResult;
        this.c = output;
        this.d = arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.f317a, bVar.f317a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d);
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.f317a.hashCode() * 31)) * 31)) * 31;
        ArrayList<Face> arrayList = this.d;
        return hashCode + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public String toString() {
        return "ImageUploadResponse(uploadImage=" + this.f317a + ", uploadResult=" + this.b + ", output=" + this.c + ", faces=" + this.d + ")";
    }
}
