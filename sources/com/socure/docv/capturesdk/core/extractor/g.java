package com.socure.docv.capturesdk.core.extractor;

import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.processor.model.FinalOutputProcessData;

/* loaded from: classes5.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f369a;
    public final /* synthetic */ e b;
    public final /* synthetic */ d c;

    public static final class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FinalOutputProcessData f370a;
        public final /* synthetic */ d b;

        public a(FinalOutputProcessData finalOutputProcessData, d dVar) {
            this.f370a = finalOutputProcessData;
            this.b = dVar;
        }

        @Override // com.socure.docv.capturesdk.core.extractor.i
        public void a(com.socure.docv.capturesdk.core.extractor.model.a aVar, boolean z) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_FOE", "Face reader response for back id - face found?: " + z);
            if (z && (aVar instanceof com.socure.docv.capturesdk.core.extractor.model.c)) {
                UtilsKt.appendFaceDataToOutput((com.socure.docv.capturesdk.core.extractor.model.c) aVar, z, this.f370a);
            }
            this.b.a(this.f370a);
        }
    }

    public g(long j, e eVar, d dVar) {
        this.f369a = j;
        this.b = eVar;
        this.c = dVar;
    }

    @Override // com.socure.docv.capturesdk.core.extractor.i
    public void a(com.socure.docv.capturesdk.core.extractor.model.a aVar, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - this.f369a;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FOE", "Barcode data onRead callback in: " + currentTimeMillis + " ms");
        if (aVar != null) {
            aVar.f375a = this.b.f366a;
        }
        FinalOutputProcessData finalOutputProcessData = new FinalOutputProcessData(aVar, null, z, false, currentTimeMillis, 10, null);
        if (z) {
            this.c.a(finalOutputProcessData);
        } else {
            new c(this.b.b, new a(finalOutputProcessData, this.c), 0, 4, null).a();
        }
    }
}
