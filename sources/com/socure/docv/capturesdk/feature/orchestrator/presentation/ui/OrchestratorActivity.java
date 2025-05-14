package com.socure.docv.capturesdk.feature.orchestrator.presentation.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.api.Keys;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.databinding.h;
import com.socure.docv.capturesdk.di.d;
import com.socure.docv.capturesdk.feature.consent.ui.ConsentFragment;
import com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b;
import com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.f;
import com.socure.docv.capturesdk.feature.progress.ui.ProgressFragment;
import java.util.HashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/socure/docv/capturesdk/feature/orchestrator/presentation/ui/OrchestratorActivity;", "Lcom/socure/docv/capturesdk/feature/base/presentation/ui/a;", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class OrchestratorActivity extends com.socure.docv.capturesdk.feature.base.presentation.ui.a {
    public static final /* synthetic */ int e = 0;
    public b b;
    public Toast c;

    /* renamed from: a, reason: collision with root package name */
    public int f441a = -1;
    public final com.socure.docv.capturesdk.common.resource.a d = new com.socure.docv.capturesdk.common.resource.a();

    @DebugMetadata(c = "com.socure.docv.capturesdk.feature.orchestrator.presentation.ui.OrchestratorActivity$setupLiveData$1", f = "OrchestratorActivity.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f442a;
        public final /* synthetic */ b b;
        public final /* synthetic */ OrchestratorActivity c;

        /* renamed from: com.socure.docv.capturesdk.feature.orchestrator.presentation.ui.OrchestratorActivity$a$a, reason: collision with other inner class name */
        public static final class C0044a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OrchestratorActivity f443a;

            /* renamed from: com.socure.docv.capturesdk.feature.orchestrator.presentation.ui.OrchestratorActivity$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0045a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f444a;

                static {
                    int[] iArr = new int[ApiType.values().length];
                    iArr[ApiType.START.ordinal()] = 1;
                    iArr[ApiType.POST_CONSENT.ordinal()] = 2;
                    f444a = iArr;
                }
            }

            public C0044a(OrchestratorActivity orchestratorActivity) {
                this.f443a = orchestratorActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                ApiResponse apiResponse = (ApiResponse) obj;
                int i = C0045a.f444a[apiResponse.getApiType().ordinal()];
                if (i != 1) {
                    if (i == 2 && apiResponse.getStatusCode() == ResponseCode.SUCCESS.getCode()) {
                        OrchestratorActivity orchestratorActivity = this.f443a;
                        int i2 = OrchestratorActivity.e;
                        orchestratorActivity.getClass();
                        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "setUpOrchestratorNavGraph called");
                        Fragment findFragmentById = orchestratorActivity.getSupportFragmentManager().findFragmentById(orchestratorActivity.f441a);
                        if (findFragmentById == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
                        }
                        NavHostFragment navHostFragment = (NavHostFragment) findFragmentById;
                        NavGraph inflate = navHostFragment.getNavController().getNavInflater().inflate(R.navigation.nav_graph_orchestrator_socure);
                        b bVar = orchestratorActivity.b;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            bVar = null;
                        }
                        inflate.setStartDestination(bVar.f());
                        navHostFragment.getNavController().setGraph(inflate);
                    }
                    OrchestratorActivity.a(this.f443a, apiResponse);
                } else {
                    if (apiResponse.getStatusCode() == ResponseCode.SUCCESS.getCode()) {
                        OrchestratorActivity orchestratorActivity2 = this.f443a;
                        NavController findNavController = ActivityKt.findNavController(orchestratorActivity2, orchestratorActivity2.f441a);
                        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(R.id.action_pop_to_consent);
                        Intrinsics.checkNotNullExpressionValue(actionOnlyNavDirections, "actionPopToConsent()");
                        ExtensionsKt.safeNavigate(findNavController, actionOnlyNavDirections);
                    }
                    OrchestratorActivity.a(this.f443a, apiResponse);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, OrchestratorActivity orchestratorActivity, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = bVar;
            this.c = orchestratorActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f442a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<ApiResponse> i2 = this.b.i();
                C0044a c0044a = new C0044a(this.c);
                this.f442a = 1;
                if (i2.collect(c0044a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public static final void a(OrchestratorActivity this$0, ResponseCode responseCode) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "activityCaller received: " + responseCode);
        Intrinsics.checkNotNullExpressionValue(responseCode, "responseCode");
        this$0.a(responseCode);
    }

    public static final void a(OrchestratorActivity orchestratorActivity, ApiResponse apiResponse) {
        orchestratorActivity.getClass();
        Intent intent = new Intent();
        orchestratorActivity.a(intent, apiResponse);
        orchestratorActivity.setResult(apiResponse.getStatusCode() == ResponseCode.SUCCESS.getCode() ? -1 : 0, intent);
        orchestratorActivity.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "onBackPressed called");
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(this.f441a);
        if (findFragmentById == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        }
        FragmentManager childFragmentManager = ((NavHostFragment) findFragmentById).getChildFragmentManager();
        if ((childFragmentManager.getFragments().get(0) instanceof ProgressFragment) || (childFragmentManager.getFragments().get(0) instanceof ConsentFragment)) {
            return;
        }
        if (this.c == null) {
            this.c = Toast.makeText(this, com.socure.docv.capturesdk.common.session.a.f305a.b().getNewLabels().getBackPressWarningMsg(), 1);
        }
        Toast toast = this.c;
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = this.c;
        if (toast2 != null) {
            toast2.show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        View findChildViewById;
        b bVar = null;
        super.onCreate(null);
        View inflate = getLayoutInflater().inflate(R.layout.orchestrator_activity_socure, (ViewGroup) null, false);
        int i = R.id.fragmentContainerView;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(inflate, i);
        if (fragmentContainerView != null) {
            i = R.id.progress_indicator;
            CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(inflate, i);
            if (circularProgressIndicator != null && (findChildViewById = ViewBindings.findChildViewById(inflate, (i = R.id.upload_blocker_view))) != null) {
                i = R.id.view_upload_loader;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(inflate, i);
                if (constraintLayout != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                    final h hVar = new h(coordinatorLayout, fragmentContainerView, circularProgressIndicator, findChildViewById, constraintLayout);
                    Intrinsics.checkNotNullExpressionValue(hVar, "inflate(layoutInflater)");
                    WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
                    WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
                    Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(window, window.decorView)");
                    insetsController.setSystemBarsBehavior(2);
                    insetsController.hide(WindowInsetsCompat.Type.systemBars());
                    ViewCompat.setOnApplyWindowInsetsListener(coordinatorLayout, new OnApplyWindowInsetsListener() { // from class: com.socure.docv.capturesdk.feature.orchestrator.presentation.ui.OrchestratorActivity$$ExternalSyntheticLambda1
                        @Override // androidx.core.view.OnApplyWindowInsetsListener
                        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            return OrchestratorActivity.a(OrchestratorActivity.this, hVar, view, windowInsetsCompat);
                        }
                    });
                    setContentView(coordinatorLayout);
                    this.f441a = fragmentContainerView.getId();
                    String stringExtra = getIntent().getStringExtra("public_key");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    String stringExtra2 = getIntent().getStringExtra(Keys.KEY_CONFIG_DATA);
                    String str = stringExtra2 != null ? stringExtra2 : "";
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "configJson received: " + str);
                    Application application = getApplication();
                    Intrinsics.checkNotNullExpressionValue(application, "application");
                    com.socure.docv.capturesdk.feature.orchestrator.a e2 = d.a(application).e();
                    e2.getClass();
                    Intrinsics.checkNotNullParameter(this, "owner");
                    this.b = (b) new ViewModelProvider(this, e2.f440a).get(f.class);
                    if (!StringsKt.isBlank(stringExtra)) {
                        try {
                            b bVar2 = this.b;
                            if (bVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                bVar2 = null;
                            }
                            bVar2.a(stringExtra);
                            b bVar3 = this.b;
                            if (bVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                bVar3 = null;
                            }
                            bVar3.a(UtilsKt.getConfig(str));
                            b bVar4 = this.b;
                            if (bVar4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                bVar4 = null;
                            }
                            a(bVar4);
                            b bVar5 = this.b;
                            if (bVar5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                bVar5 = null;
                            }
                            bVar5.j();
                        } catch (Throwable th) {
                            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "error msg: " + th.getLocalizedMessage());
                            b bVar6 = this.b;
                            if (bVar6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                bVar = bVar6;
                            }
                            ResponseCode responseCode = ResponseCode.CONFIG_FLOW_DATA_INVALID;
                            bVar.a("error", new Pair<>("type", responseCode.getMessage()), new Pair<>("message", "ex: " + th.getLocalizedMessage()));
                            a(responseCode);
                        }
                    } else {
                        b bVar7 = this.b;
                        if (bVar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            bVar = bVar7;
                        }
                        ResponseCode responseCode2 = ResponseCode.EMPTY_KEY;
                        bVar.a("error", new Pair<>("type", "session_initiation"), new Pair<>("message", responseCode2.getMessage()));
                        a(responseCode2);
                    }
                    Context applicationContext = getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    new com.socure.docv.capturesdk.common.workers.a(applicationContext, "dbg_images").a();
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "onDestroy");
        Toast toast = this.c;
        if (toast != null) {
            toast.cancel();
            this.c = null;
        }
        super.onDestroy();
    }

    public final void a(ResponseCode responseCode) {
        Intent intent = new Intent();
        b bVar = this.b;
        if (bVar != null) {
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            com.socure.docv.capturesdk.common.session.a.j = UtilsKt.getCapturedImageMap(bVar.a());
        }
        com.socure.docv.capturesdk.common.session.a aVar2 = com.socure.docv.capturesdk.common.session.a.f305a;
        intent.putExtra(Keys.KEY_SESSION_ID, com.socure.docv.capturesdk.common.session.a.g);
        intent.putExtra("status_code", responseCode.getCode());
        intent.putExtra(Keys.KEY_STATUS_MESSAGE, responseCode.getMessage());
        setResult(0, intent);
        finish();
    }

    public static final WindowInsetsCompat a(OrchestratorActivity this$0, h binding, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        b bVar = this$0.b;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        bVar.a(Integer.valueOf(windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).top));
        ViewCompat.setOnApplyWindowInsetsListener(binding.f401a, null);
        return WindowInsetsCompat.CONSUMED;
    }

    public final void a(Intent intent, ApiResponse apiResponse) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "setData called: " + apiResponse);
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        b bVar = this.b;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        com.socure.docv.capturesdk.common.session.a.j = UtilsKt.getCapturedImageMap(bVar.a());
        intent.putExtra(Keys.KEY_SESSION_ID, com.socure.docv.capturesdk.common.session.a.g);
        int statusCode = apiResponse.getStatusCode();
        ResponseCode responseCode = ResponseCode.SUCCESS;
        if (statusCode != responseCode.getCode()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "setData statusCode: " + apiResponse.getStatusCode());
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "setData statusMsg: " + apiResponse.getStatusMsg());
            UtilsKt.updateErrorDataBasedOnApiType(apiResponse.getApiType(), apiResponse, intent);
            return;
        }
        b bVar3 = this.b;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar3 = null;
        }
        com.socure.docv.capturesdk.common.session.a.i = UtilsKt.getCaptureModeMap(bVar3.a());
        b bVar4 = this.b;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            bVar2 = bVar4;
        }
        com.socure.docv.capturesdk.common.session.a.k = UtilsKt.extractedDataToJson(bVar2.a());
        intent.putExtra("status_code", responseCode.getCode());
        intent.putExtra(Keys.KEY_STATUS_MESSAGE, responseCode.getMessage());
        intent.putExtra(Keys.KEY_DOCUMENT_UUID, com.socure.docv.capturesdk.common.session.a.e);
        intent.putExtra(Keys.KEY_EXTRACTED_DATA, com.socure.docv.capturesdk.common.session.a.k);
        HashMap<String, String> hashMap = com.socure.docv.capturesdk.common.session.a.i;
        if (hashMap == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        }
        intent.putExtra(Keys.KEY_CAPTURE_MODE, hashMap);
    }

    public final void a(b bVar) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new a(bVar, this, null), 3, null);
        bVar.g().observe(this, new Observer() { // from class: com.socure.docv.capturesdk.feature.orchestrator.presentation.ui.OrchestratorActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrchestratorActivity.a(OrchestratorActivity.this, (ResponseCode) obj);
            }
        });
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OA", "useOpenCv flag after view model creation: " + this.d.f304a.getOpenCvSupported());
    }
}
