package com.socure.docv.capturesdk.core.extractor;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.processor.model.FinalOutputProcessData;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f371a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ e c;
    public final /* synthetic */ long d;
    public final /* synthetic */ d e;

    public static final class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f372a;
        public final /* synthetic */ Ref.ObjectRef<Bitmap> b;
        public final /* synthetic */ long c;
        public final /* synthetic */ FinalOutputProcessData d;
        public final /* synthetic */ d e;

        public a(long j, Ref.ObjectRef<Bitmap> objectRef, long j2, FinalOutputProcessData finalOutputProcessData, d dVar) {
            this.f372a = j;
            this.b = objectRef;
            this.c = j2;
            this.d = finalOutputProcessData;
            this.e = dVar;
        }

        @Override // com.socure.docv.capturesdk.core.extractor.i
        public void a(com.socure.docv.capturesdk.core.extractor.model.a aVar, boolean z) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_FOE", "MrzReader data onRead callback in " + (System.currentTimeMillis() - this.f372a));
            Ref.ObjectRef<Bitmap> objectRef = this.b;
            Bitmap bitmap = objectRef.element;
            if (bitmap != null) {
                bitmap.recycle();
                objectRef.element = null;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_FOE", "MrzReader + faceReader data onRead callback in: " + currentTimeMillis + " ms");
            this.d.setData(aVar);
            this.d.setFound(z);
            this.d.setDuration(currentTimeMillis);
            this.e.a(this.d);
        }
    }

    public h(long j, Bitmap bitmap, e eVar, long j2, d dVar) {
        this.f371a = j;
        this.b = bitmap;
        this.c = eVar;
        this.d = j2;
        this.e = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4, types: [T, android.graphics.Bitmap] */
    @Override // com.socure.docv.capturesdk.core.extractor.i
    public void a(com.socure.docv.capturesdk.core.extractor.model.a aVar, boolean z) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FOE", "faceReader data onRead callback in " + (System.currentTimeMillis() - this.f371a));
        this.b.recycle();
        FinalOutputProcessData finalOutputProcessData = new FinalOutputProcessData(null, null, false, false, 0L, 31, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (aVar != null && z && (aVar instanceof com.socure.docv.capturesdk.core.extractor.model.c)) {
            com.socure.docv.capturesdk.core.extractor.model.c cVar = (com.socure.docv.capturesdk.core.extractor.model.c) aVar;
            UtilsKt.appendFaceDataToOutput(cVar, z, finalOutputProcessData);
            objectRef.element = ImageUtils.INSTANCE.rotateBitmap$capturesdk_productionRelease(this.c.b, cVar.b);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap bitmap = (Bitmap) objectRef.element;
        if (bitmap == null) {
            bitmap = this.c.b;
        }
        new k(bitmap, new a(currentTimeMillis, objectRef, this.d, finalOutputProcessData, this.e)).a();
    }
}
