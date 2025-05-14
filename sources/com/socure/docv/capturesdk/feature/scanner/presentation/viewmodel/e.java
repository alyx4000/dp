package com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel;

import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.analytics.model.EventData;
import com.socure.docv.capturesdk.common.analytics.model.Face;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadResult;
import com.socure.docv.capturesdk.common.upload.g;
import com.socure.docv.capturesdk.common.upload.k;
import com.socure.docv.capturesdk.common.upload.l;
import com.socure.docv.capturesdk.common.utils.Screen;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.core.processor.model.Output;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class e implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UploadImage f540a;
    public final /* synthetic */ ArrayList<Screen> b;
    public final /* synthetic */ List<Pair<String, String>> c;
    public final /* synthetic */ com.socure.docv.capturesdk.common.upload.a d;
    public final /* synthetic */ c e;
    public final /* synthetic */ long f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ long h;
    public final /* synthetic */ long i;
    public final /* synthetic */ Output j;
    public final /* synthetic */ ArrayList<Face> k;

    public e(UploadImage uploadImage, ArrayList<Screen> arrayList, List<Pair<String, String>> list, com.socure.docv.capturesdk.common.upload.a aVar, c cVar, long j, boolean z, long j2, long j3, Output output, ArrayList<Face> arrayList2) {
        this.f540a = uploadImage;
        this.b = arrayList;
        this.c = list;
        this.d = aVar;
        this.e = cVar;
        this.f = j;
        this.g = z;
        this.h = j2;
        this.i = j3;
        this.j = output;
        this.k = arrayList2;
    }

    @Override // com.socure.docv.capturesdk.common.upload.k
    public void a(UploadImage uploadImage, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
        Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
        this.c.add(new Pair<>("duration", String.valueOf(System.currentTimeMillis() - this.f)));
        this.c.add(new Pair<>("screen_duration", String.valueOf(System.currentTimeMillis() - this.i)));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.c);
        arrayList.add(new Pair("type", apiResponse.getStatusCode() == ResponseCode.NO_INTERNET.getCode() ? "no_network" : "server"));
        com.socure.docv.capturesdk.common.upload.a aVar = this.d;
        Utils utils = Utils.INSTANCE;
        aVar.a(new EventData(Utils.replacePlaceholders$capturesdk_productionRelease$default(utils, "upload_failed", null, utils.getSelection$capturesdk_productionRelease(this.b), 2, null), CollectionsKt.toList(arrayList)));
        EventData eventErrorData = UtilsKt.getEventErrorData(apiResponse.getHttpCode(), apiResponse.getHttpMsg(), apiResponse.getStatusCode(), apiResponse.getStatusMsg(), apiResponse.getApiType().getEndpoint());
        this.c.addAll(eventErrorData.getEventAttrList());
        this.d.a(new EventData(eventErrorData.getEventName(), this.c));
        this.d.a(new EventData("error", CollectionsKt.arrayListOf(new Pair("type", "upload_failed"), new Pair("message", apiResponse.getStatusMsg()))));
        this.e.i.postValue(new g.a(apiResponse));
    }

    public static final class a implements l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UploadResult f541a;
        public final /* synthetic */ List<Pair<String, String>> b;
        public final /* synthetic */ UploadImage c;
        public final /* synthetic */ long d;
        public final /* synthetic */ c e;
        public final /* synthetic */ long f;
        public final /* synthetic */ com.socure.docv.capturesdk.common.upload.a g;
        public final /* synthetic */ ArrayList<Screen> h;
        public final /* synthetic */ Output i;
        public final /* synthetic */ ArrayList<Face> j;

        public a(UploadResult uploadResult, List<Pair<String, String>> list, UploadImage uploadImage, long j, c cVar, long j2, com.socure.docv.capturesdk.common.upload.a aVar, ArrayList<Screen> arrayList, Output output, ArrayList<Face> arrayList2) {
            this.f541a = uploadResult;
            this.b = list;
            this.c = uploadImage;
            this.d = j;
            this.e = cVar;
            this.f = j2;
            this.g = aVar;
            this.h = arrayList;
            this.i = output;
            this.j = arrayList2;
        }

        @Override // com.socure.docv.capturesdk.common.upload.l
        public void a(ApiResponse apiResponse) {
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            this.b.add(new Pair<>("type", "ivs"));
            this.b.add(new Pair<>("screen_duration", String.valueOf(System.currentTimeMillis() - this.f)));
            com.socure.docv.capturesdk.common.upload.a aVar = this.g;
            Utils utils = Utils.INSTANCE;
            aVar.a(new EventData(Utils.replacePlaceholders$capturesdk_productionRelease$default(utils, "upload_failed", null, utils.getSelection$capturesdk_productionRelease(this.h), 2, null), CollectionsKt.toList(this.b)));
            this.g.a(new EventData("error", CollectionsKt.arrayListOf(new Pair("type", "upload_failed"), new Pair("message", "uuid_not_available"))));
            this.e.i.postValue(new g.a(apiResponse));
        }

        @Override // com.socure.docv.capturesdk.common.upload.l
        public void b() {
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            com.socure.docv.capturesdk.common.session.a.e = this.f541a.getUuid();
            this.b.add(new Pair<>("type", this.c.getCaptureType().getValue()));
            this.b.add(new Pair<>("capture_duration", String.valueOf(this.d)));
            this.b.add(new Pair<>("total_facet_duration", String.valueOf(this.e.q.getTotalScannerScreenDuration())));
            this.b.add(new Pair<>("total_capture_duration", String.valueOf(this.e.q.getTotalCaptureDuration())));
            this.b.add(new Pair<>("screen_duration", String.valueOf(System.currentTimeMillis() - this.f)));
            com.socure.docv.capturesdk.common.upload.a aVar2 = this.g;
            Utils utils = Utils.INSTANCE;
            aVar2.a(new EventData(Utils.replacePlaceholders$capturesdk_productionRelease$default(utils, "upload_complete", null, utils.getSelection$capturesdk_productionRelease(this.h), 2, null), CollectionsKt.toList(this.b)));
            this.e.i.postValue(new g.d(new com.socure.docv.capturesdk.common.upload.b(this.c, this.f541a, this.i, this.j)));
        }

        @Override // com.socure.docv.capturesdk.common.upload.l
        public void a() {
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            String str = com.socure.docv.capturesdk.common.session.a.e;
            if ((str == null || StringsKt.isBlank(str)) && (!StringsKt.isBlank(this.f541a.getUuid()))) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SVM", "retake callback but with a valid uuid - so this should be later used for upload");
                com.socure.docv.capturesdk.common.session.a.e = this.f541a.getUuid();
            }
            this.b.add(new Pair<>("type", "ivs"));
            com.socure.docv.capturesdk.common.upload.a aVar2 = this.g;
            Utils utils = Utils.INSTANCE;
            aVar2.a(new EventData(Utils.replacePlaceholders$capturesdk_productionRelease$default(utils, "upload_failed", null, utils.getSelection$capturesdk_productionRelease(this.h), 2, null), CollectionsKt.toList(this.b)));
            this.e.i.postValue(new g.c(new com.socure.docv.capturesdk.common.upload.b(this.c, this.f541a, this.i, this.j)));
        }
    }

    public void a() {
        Utils utils = Utils.INSTANCE;
        this.d.a(new EventData(utils.replacePlaceholders$capturesdk_productionRelease("upload_start", this.f540a.getScanType(), utils.getSelection$capturesdk_productionRelease(this.b)), this.c));
        this.e.i.postValue(g.b.f323a);
    }

    @Override // com.socure.docv.capturesdk.common.upload.k
    public void a(UploadImage uploadImage, UploadResult uploadResult, int i) {
        Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        UtilsKt.appendUploadSuccessEventParams(this.c, this.f, uploadResult);
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        com.socure.docv.capturesdk.common.session.a.f = uploadResult.getReferenceId();
        UtilsKt.validateUploadResponse(this.g, uploadResult, new a(uploadResult, this.c, uploadImage, this.h, this.e, this.i, this.d, this.b, this.j, this.k));
    }
}
