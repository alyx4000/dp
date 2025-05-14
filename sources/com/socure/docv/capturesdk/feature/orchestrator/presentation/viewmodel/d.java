package com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.socure.docv.capturesdk.api.DocumentType;
import com.socure.docv.capturesdk.api.Keys;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.analytics.model.MetricCaptureData;
import com.socure.docv.capturesdk.common.analytics.model.MetricData;
import com.socure.docv.capturesdk.common.config.model.DataFlow;
import com.socure.docv.capturesdk.common.config.model.FragNavActions;
import com.socure.docv.capturesdk.common.config.model.MemoryInfo;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentData;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentPostRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.Data;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowData;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadData;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.network.model.stepup.Websdk;
import com.socure.docv.capturesdk.common.stepup.k;
import com.socure.docv.capturesdk.common.stepup.l;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.Screen;
import com.socure.docv.capturesdk.common.utils.State;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.CaptureMetadata;
import com.socure.docv.capturesdk.core.processor.model.Resolution;
import com.socure.docv.capturesdk.feature.orchestrator.data.Config;
import io.sentry.protocol.Device;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* loaded from: classes5.dex */
public final class d extends com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.a {

    /* renamed from: a, reason: collision with root package name */
    public Application f446a;
    public final com.socure.docv.capturesdk.di.c b;
    public final com.socure.docv.capturesdk.common.network.repository.b c;
    public final com.socure.docv.capturesdk.common.resource.a d;
    public LinkedHashMap<ScanType, UploadImage> e;
    public final MutableSharedFlow<ApiResponse> f;
    public final MutableLiveData<ResponseCode> g;
    public Integer h;
    public final List<com.socure.docv.capturesdk.common.view.model.c> i;
    public Job j;
    public Job k;
    public final Lazy l;
    public final com.socure.docv.capturesdk.common.analytics.b m;
    public ArrayList<Screen> n;
    public HashMap<String, Long> o;
    public Config p;
    public final a q;

    public static final class a implements ComponentCallbacks2 {
        public a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "onConfigurationChanged called - level: " + configuration);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "onLowMemory called");
            d.this.a(Device.JsonKeys.LOW_MEMORY, new Pair<>("type", Device.JsonKeys.LOW_MEMORY));
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "onTrimMemory called - level: " + i);
            d.this.a(Device.JsonKeys.LOW_MEMORY, new Pair<>("type", "trim_memory"), new Pair<>(ApiConstant.KEY_CODE, String.valueOf(i)));
        }
    }

    @DebugMetadata(c = "com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.OrchestratorViewModel$emitApiResponse$1", f = "OrchestratorViewModel.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f448a;
        public final /* synthetic */ ApiResponse c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApiResponse apiResponse, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = apiResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return d.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return d.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f448a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<ApiResponse> mutableSharedFlow = d.this.f;
                ApiResponse apiResponse = this.c;
                this.f448a = 1;
                if (mutableSharedFlow.emit(apiResponse, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<com.socure.docv.capturesdk.common.analytics.c> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.common.analytics.c invoke() {
            return new com.socure.docv.capturesdk.common.analytics.c(d.this.f446a);
        }
    }

    /* renamed from: com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.d$d, reason: collision with other inner class name */
    public static final class C0046d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f450a;
        public final /* synthetic */ ConsentPostRequest b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0046d(CoroutineExceptionHandler.Companion companion, d dVar, ConsentPostRequest consentPostRequest) {
            super(companion);
            this.f450a = dVar;
            this.b = consentPostRequest;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "consent task exception handled: " + th.getLocalizedMessage(), null, 4, null);
            this.f450a.a("error", new Pair<>("type", "unknown"), new Pair<>("message", "consentExceptionHandler: " + Log.getStackTraceString(th)));
            d.a(this.f450a, true ^ this.b.getConsent(), false);
        }
    }

    public static final class f extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public f(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "event manager ex: " + Log.getStackTraceString(th), null, 4, null);
        }
    }

    public d(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f446a = application;
        com.socure.docv.capturesdk.di.c a2 = com.socure.docv.capturesdk.di.d.a(application);
        this.b = a2;
        com.socure.docv.capturesdk.common.network.repository.b g2 = a2.g();
        this.c = g2;
        this.d = new com.socure.docv.capturesdk.common.resource.a();
        this.e = new LinkedHashMap<>();
        this.f = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.g = new MutableLiveData<>();
        this.i = new ArrayList();
        this.l = LazyKt.lazy(new c());
        com.socure.docv.capturesdk.common.analytics.b bVar = new com.socure.docv.capturesdk.common.analytics.b(g2, new f(CoroutineExceptionHandler.INSTANCE));
        this.m = bVar;
        com.socure.docv.capturesdk.common.session.a.f305a.a();
        Context applicationContext = this.f446a.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
        bVar.a(UtilsKt.getLateAttrs(applicationContext));
        this.n = new ArrayList<>();
        this.o = new HashMap<>();
        this.q = new a();
    }

    public static final void a(d dVar, boolean z, boolean z2) {
        ApiResponse apiResponse;
        dVar.getClass();
        if (!z) {
            ApiType apiType = ApiType.POST_CONSENT;
            ResponseCode responseCode = ResponseCode.CONSENT_NOT_GIVEN;
            apiResponse = new ApiResponse(apiType, responseCode.getCode(), responseCode.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
        } else if (z2) {
            ApiType apiType2 = ApiType.POST_CONSENT;
            ResponseCode responseCode2 = ResponseCode.SUCCESS;
            apiResponse = new ApiResponse(apiType2, responseCode2.getCode(), responseCode2.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
        } else {
            ApiType apiType3 = ApiType.POST_CONSENT;
            ResponseCode responseCode3 = ResponseCode.SESSION_INITIATION_FAILURE;
            apiResponse = new ApiResponse(apiType3, responseCode3.getCode(), responseCode3.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
        }
        dVar.c(apiResponse);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public FragNavActions a(com.socure.docv.capturesdk.common.view.model.c screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "getNavAction called key: " + screen);
        return UtilsKt.getFragNavActions(this.i, screen);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public LinkedHashMap<ScanType, UploadImage> a() {
        return this.e;
    }

    public final void a(int i, String str, int i2, String str2, String str3) {
        Pair<String, String>[] pairArr = new Pair[5];
        pairArr[0] = new Pair<>(ApiConstant.KEY_CODE, String.valueOf(i));
        if (str == null) {
            str = "NULL";
        }
        pairArr[1] = new Pair<>("message", str);
        pairArr[2] = new Pair<>("internal_error_code", String.valueOf(i2));
        pairArr[3] = new Pair<>("internal_error_message", str2);
        pairArr[4] = new Pair<>("endpoint", str3);
        a("request_failure", pairArr);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(DocumentType documentType) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "updateNavFragmentOrderList called documentType :" + documentType);
        ArrayList arrayList = new ArrayList();
        if (documentType != null) {
            a(new DataFlow(Utils.INSTANCE.getScreenSequence(documentType, com.socure.docv.capturesdk.common.session.a.f305a.c().getWebsdk().getEnableSelfie().getValue())).getScreenSequence());
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "we are showing doc selection screen");
        }
        if (this.i.isEmpty() && documentType != null) {
            arrayList.add(com.socure.docv.capturesdk.common.view.model.c.SELECTOR);
        }
        this.i.clear();
        this.i.addAll(UtilsKt.setFragNavActions(arrayList, com.socure.docv.capturesdk.common.session.a.f305a.c().getWebsdk().getEnableSelfie().getValue(), documentType));
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(MetricCaptureData metricCaptureData) {
        Resolution resolution;
        Resolution resolution2;
        Intrinsics.checkNotNullParameter(metricCaptureData, "metricCaptureData");
        CaptureMetadata captureMetadata = metricCaptureData.getCaptureMetadata();
        Integer num = null;
        CaptureType captureType = captureMetadata != null ? captureMetadata.getCaptureType() : null;
        CaptureMetadata captureMetadata2 = metricCaptureData.getCaptureMetadata();
        Integer valueOf = (captureMetadata2 == null || (resolution2 = captureMetadata2.getResolution()) == null) ? null : Integer.valueOf(resolution2.getWidth());
        CaptureMetadata captureMetadata3 = metricCaptureData.getCaptureMetadata();
        if (captureMetadata3 != null && (resolution = captureMetadata3.getResolution()) != null) {
            num = Integer.valueOf(resolution.getHeight());
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "setSettingResolution called - captureType: " + captureType + " || resolution: w:" + valueOf + " h:" + num);
        m().b(metricCaptureData);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "setUploadEndStatus called");
        c(apiResponse);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ScanType scanType) {
        Object obj;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "updateScanCompletion called : currentScanType:" + scanType);
        ArrayList<Screen> d = d();
        Iterator<T> it = d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Screen) obj).getScanType() == scanType) {
                    break;
                }
            }
        }
        Screen screen = (Screen) obj;
        if (screen != null) {
            screen.setState(State.COMPLETED);
        }
        a(d);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(Config config) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "updateConfig called");
        this.p = config;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(Integer num) {
        this.h = num;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ArrayList<Screen> screenFlow) {
        Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "setDocScreenFlow");
        this.n = screenFlow;
    }

    public final void a(Job job) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "cancelJob called for " + job);
        if (job == null || !job.isActive()) {
            return;
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void b() {
        this.g.postValue(ResponseCode.DOCUMENT_SCAN_CANCEL);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void b(com.socure.docv.capturesdk.common.view.model.c screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "updateNavActionsPostCapture called key: " + screen);
        int indexOf = this.i.indexOf(screen);
        if (indexOf < this.i.size()) {
            this.i.subList(0, indexOf + 1).clear();
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "Failed removal due to index out of bound: Index: " + indexOf + ", Size: " + this.i.size(), null, 4, null);
        }
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void b(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "setErrorStatus");
        c(apiResponse);
    }

    public final void b(String str) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "addEventEpoch called for " + str);
        this.o.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public Integer c() {
        return this.h;
    }

    public final void c(ApiResponse apiResponse) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new b(apiResponse, null), 3, null);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public ArrayList<Screen> d() {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "getDocScreenFlow");
        return this.n;
    }

    public final void d(ApiResponse apiResponse) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "updateStepUpState result apiType:" + apiResponse.getApiType() + " || statusCode:" + apiResponse.getStatusCode() + " || msg:" + apiResponse.getStatusMsg());
        ArrayList arrayList = new ArrayList();
        Config config = this.p;
        if (config != null) {
            String raw = config.getRaw();
            if (raw != null) {
                arrayList.add(new Pair("config", raw));
            }
            String documentType = config.getDocumentType();
            if (documentType != null) {
                arrayList.add(new Pair(Keys.KEY_DOCUMENT_TYPE, documentType));
            }
        }
        MemoryInfo memoryInfo = this.d.f304a.getMemoryInfo();
        if (memoryInfo != null) {
            arrayList.addAll(CollectionsKt.listOf((Object[]) new Pair[]{new Pair("total_memory", String.valueOf(memoryInfo.getTotalRam())), new Pair("avail_memory", String.valueOf(memoryInfo.getAvailRam())), new Pair("threshold_memory", String.valueOf(memoryInfo.getThresholdRam())), new Pair("low_memory_state", String.valueOf(memoryInfo.getCurrentlyLowMemory()))}));
        }
        if (apiResponse.getStatusCode() == ResponseCode.SUCCESS.getCode()) {
            Object[] array = arrayList.toArray(new Pair[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Pair[] pairArr = (Pair[]) array;
            a("session_started", (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            c(apiResponse);
            return;
        }
        a(this.j);
        int statusCode = apiResponse.getStatusCode();
        ResponseCode responseCode = ResponseCode.UNKNOWN_ERROR;
        if (statusCode == responseCode.getCode() && !Intrinsics.areEqual(apiResponse.getStatusMsg(), responseCode.getMessage())) {
            arrayList.add(new Pair("message", "stepUp exception: " + apiResponse.getStatusMsg()));
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair("type", "session_initiation"));
        Object[] array2 = arrayList.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        spreadBuilder.addSpread(array2);
        a("error", (Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
        a(apiResponse.getHttpCode(), apiResponse.getHttpMsg(), apiResponse.getStatusCode(), apiResponse.getStatusMsg(), apiResponse.getApiType().getEndpoint());
        b(apiResponse);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public MetricData e() {
        com.socure.docv.capturesdk.common.analytics.c m = m();
        m.getClass();
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "getMetricData called");
        MetricData metricData = m.b;
        if (metricData != null) {
            return metricData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("metricData");
        return null;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public int f() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "called setUpNavFlow");
        Config config = this.p;
        DocumentType docType = UtilsKt.getDocType(config != null ? config.getDocumentType() : null);
        if (docType == null) {
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            if (aVar.c().getWebsdk().getDocumentTypes().size() == 1) {
                docType = UtilsKt.getDocType((String) CollectionsKt.first((List) aVar.c().getWebsdk().getDocumentTypes()));
            }
        }
        a(docType);
        return UtilsKt.getNavFragId(this.i.get(0));
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public LiveData g() {
        return this.g;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void h() {
        this.g.postValue(ResponseCode.CAMERA_ERROR);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public SharedFlow i() {
        return this.f;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void j() {
        Job launch$default;
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "startSession called");
        b("session_start_marker");
        com.socure.docv.capturesdk.common.resource.a aVar = this.d;
        Context context = this.f446a.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "application.applicationContext");
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        aVar.f304a.readMemory$capturesdk_productionRelease(context);
        l lVar = new l(this.c.b(), com.socure.docv.capturesdk.common.session.a.f305a.d(), UtilsKt.getConfigForApi(this.p), new g());
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(lVar.f)), null, null, new k(lVar, null), 3, null);
        this.j = launch$default;
        try {
            this.f446a.getApplicationContext().registerComponentCallbacks(this.q);
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "exception when registerComponentCallbacks: " + th.getLocalizedMessage(), null, 4, null);
        }
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public Config k() {
        return this.p;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void l() {
        this.g.postValue(ResponseCode.UNKNOWN_ERROR);
    }

    public final com.socure.docv.capturesdk.common.analytics.c m() {
        return (com.socure.docv.capturesdk.common.analytics.c) this.l.getValue();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "onCleared called");
        a((Job) null);
        a(this.j);
        a(this.k);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "clearData");
        this.e.clear();
        this.i.clear();
        try {
            this.f446a.getApplicationContext().unregisterComponentCallbacks(this.q);
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "exception when unregisterComponentCallbacks: " + th.getLocalizedMessage(), null, 4, null);
        }
        super.onCleared();
    }

    public static final class e implements com.socure.docv.capturesdk.common.stepup.a {
        public final /* synthetic */ ConsentPostRequest b;

        public e(ConsentPostRequest consentPostRequest) {
            this.b = consentPostRequest;
        }

        @Override // com.socure.docv.capturesdk.common.stepup.a
        public void a(ApiResponse apiResponse) {
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            d.this.a(apiResponse.getHttpCode(), apiResponse.getHttpMsg(), apiResponse.getStatusCode(), apiResponse.getStatusMsg(), apiResponse.getApiType().getEndpoint());
            d.a(d.this, this.b.getConsent(), false);
        }

        @Override // com.socure.docv.capturesdk.common.stepup.a
        public void a(ConsentData consentData, ApiResponse apiResponse) {
            Intrinsics.checkNotNullParameter(consentData, "consentData");
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            String consentId = consentData.getConsentId();
            Intrinsics.checkNotNullParameter(consentId, "<set-?>");
            com.socure.docv.capturesdk.common.session.a.d = consentId;
            d.a(d.this, this.b.getConsent(), true);
        }
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ResponseCode responseCode) {
        Intrinsics.checkNotNullParameter(responseCode, "responseCode");
        this.g.postValue(responseCode);
    }

    public static final class g implements com.socure.docv.capturesdk.common.stepup.d {
        public g() {
        }

        @Override // com.socure.docv.capturesdk.common.stepup.d
        public void a(Data data, ApiResponse apiResponse) {
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "onFailure called");
            if (data != null) {
                d dVar = d.this;
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "sessionData: " + data);
                dVar.m.a(data);
            }
            d.this.d(apiResponse);
        }

        @Override // com.socure.docv.capturesdk.common.stepup.d
        public void a(Data startApiData, StartUploadData startUploadData, FlowData flowData, App configData, Consent consentData, ApiResponse successApiResponse) {
            Intrinsics.checkNotNullParameter(startApiData, "startApiData");
            Intrinsics.checkNotNullParameter(startUploadData, "startUploadData");
            Intrinsics.checkNotNullParameter(flowData, "flowData");
            Intrinsics.checkNotNullParameter(configData, "configData");
            Intrinsics.checkNotNullParameter(consentData, "consentData");
            Intrinsics.checkNotNullParameter(successApiResponse, "successApiResponse");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "onSuccess called");
            d.this.a(startApiData, flowData, configData, consentData);
            d dVar = d.this;
            dVar.getClass();
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "checkSingleDocFlow called");
            if (flowData.getWebsdk().getDocumentTypes().size() == 1) {
                dVar.a(new DataFlow(Utils.INSTANCE.getScreenSequence(flowData.getWebsdk())).getScreenSequence());
            } else {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "checkSingleDocFlow have multiple doc type");
            }
            d.this.a(flowData);
            d dVar2 = d.this;
            Websdk websdk = flowData.getWebsdk();
            dVar2.getClass();
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "updateSelfieAngleData called");
            dVar2.b.a(UtilsKt.getConfigSelfieRangeValues(websdk));
            d.this.m.a(UtilsKt.getFlowResponseMap(com.socure.docv.capturesdk.common.session.a.f305a.c().getWebsdk(), d.this.p));
            d.this.m.a(UtilsKt.getTrackingPropertyMap(startUploadData.getTrackingProperties()));
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "sessionData: " + startApiData);
            d.this.m.a(startApiData);
            d.this.d(successApiResponse);
        }
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ConsentPostRequest consentBody) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(consentBody, "consentBody");
        com.socure.docv.capturesdk.common.stepup.c cVar = new com.socure.docv.capturesdk.common.stepup.c(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new C0046d(CoroutineExceptionHandler.INSTANCE, this, consentBody))), this.c.b());
        e consentPostCallback = new e(consentBody);
        Intrinsics.checkNotNullParameter(consentBody, "consentBody");
        Intrinsics.checkNotNullParameter(consentPostCallback, "consentPostCallback");
        launch$default = BuildersKt__Builders_commonKt.launch$default(cVar.f307a, null, null, new com.socure.docv.capturesdk.common.stepup.b(cVar, consentBody, consentPostCallback, null), 3, null);
        this.k = launch$default;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(String eventName, Pair<String, String>... args) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(args, "args");
        List mutableListOf = CollectionsKt.mutableListOf(Arrays.copyOf(args, args.length));
        Long l = this.o.get("session_start_marker");
        if (l == null) {
            l = -1L;
        }
        long longValue = l.longValue();
        mutableListOf.add(new Pair("session_duration", String.valueOf(longValue > 0 ? System.currentTimeMillis() - longValue : -1L)));
        com.socure.docv.capturesdk.common.analytics.b bVar = this.m;
        Object[] array = mutableListOf.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Pair[] pairArr = (Pair[]) array;
        bVar.a(eventName, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public final void a(FlowData flowData) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "setDeviceMetrics");
        m().a(Utils.INSTANCE.getScreenSequence(flowData.getWebsdk()));
        Gson gson = new Gson();
        com.socure.docv.capturesdk.common.analytics.c m = m();
        m.getClass();
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "getMetricData called");
        MetricData metricData = m.b;
        if (metricData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metricData");
            metricData = null;
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_OVM", "try reading the metricData set: " + gson.toJson(metricData));
    }

    public final void a(Data data, FlowData flowData, App app, Consent consent) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "updateSessionManager called");
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        com.socure.docv.capturesdk.common.session.a.g = data.getEventId();
        String referenceId = data.getReferenceId();
        Intrinsics.checkNotNullParameter(referenceId, "<set-?>");
        com.socure.docv.capturesdk.common.session.a.c = referenceId;
        Intrinsics.checkNotNullParameter(flowData, "<set-?>");
        com.socure.docv.capturesdk.common.session.a.m = flowData;
        Intrinsics.checkNotNullParameter(app, "<set-?>");
        com.socure.docv.capturesdk.common.session.a.l = app;
        Intrinsics.checkNotNullParameter(consent, "<set-?>");
        com.socure.docv.capturesdk.common.session.a.n = consent;
        try {
            com.socure.docv.capturesdk.common.session.a.h = TimeUnit.SECONDS.toMillis(flowData.getWebsdk().getManualCaptureTimeout().getValue());
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "SessionManager ManualCaptureTimeout error: " + th.getLocalizedMessage());
        }
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(String publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "key");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM", "updatePublicKey called");
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        Intrinsics.checkNotNullParameter(publicKey, "<set-?>");
        com.socure.docv.capturesdk.common.session.a.b = publicKey;
        com.socure.docv.capturesdk.common.analytics.b bVar = this.m;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_EM", "updatePublicKey called");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("public_key", publicKey);
        bVar.f287a.a(linkedHashMap);
    }
}
