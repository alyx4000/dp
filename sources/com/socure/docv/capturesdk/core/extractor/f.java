package com.socure.docv.capturesdk.core.extractor;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.analytics.model.Face;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.processor.model.FinalOutputProcessData;
import kotlin.collections.CollectionsKt;

/* loaded from: classes5.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f368a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ e c;
    public final /* synthetic */ d d;

    public f(long j, Bitmap bitmap, e eVar, d dVar) {
        this.f368a = j;
        this.b = bitmap;
        this.c = eVar;
        this.d = dVar;
    }

    @Override // com.socure.docv.capturesdk.core.extractor.i
    public void a(com.socure.docv.capturesdk.core.extractor.model.a aVar, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - this.f368a;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FOE", "FaceReader data onRead callback in: " + currentTimeMillis + " ms");
        this.b.recycle();
        if (aVar != null) {
            aVar.f375a = this.c.f366a;
        }
        FinalOutputProcessData finalOutputProcessData = new FinalOutputProcessData(aVar, null, z, false, currentTimeMillis, 10, null);
        if (aVar != null && z && (aVar instanceof com.socure.docv.capturesdk.core.extractor.model.c)) {
            UtilsKt.appendFaceDataToOutput((com.socure.docv.capturesdk.core.extractor.model.c) aVar, z, finalOutputProcessData);
        } else {
            finalOutputProcessData.setFace(CollectionsKt.arrayListOf(new Face(null, Boolean.FALSE, Double.valueOf(1.0d), null, 9, null)));
        }
        this.d.a(finalOutputProcessData);
    }
}
