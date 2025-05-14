package com.socure.docv.capturesdk.feature.base.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.PermissionState;
import com.socure.docv.capturesdk.common.utils.Screen;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import io.castle.android.api.model.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/socure/docv/capturesdk/feature/base/presentation/ui/BaseFragment;", "Landroidx/fragment/app/Fragment;", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public abstract class BaseFragment extends Fragment {
    public static final /* synthetic */ int l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f417a;
    public final String b;
    public Screen c;
    public ScanType d;
    public com.socure.docv.capturesdk.common.analytics.a e;
    public final String[] f;
    public Function1<? super PermissionState, Unit> g;
    public final Lazy h;
    public long i;
    public Function1<? super PermissionState, Unit> j;
    public final ActivityResultLauncher<String[]> k;

    public static final class a extends Lambda implements Function1<PermissionState, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(PermissionState permissionState) {
            PermissionState it = permissionState;
            Intrinsics.checkNotNullParameter(it, "it");
            Function1<? super PermissionState, Unit> function1 = BaseFragment.this.g;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPermissionGranted");
                function1 = null;
            }
            function1.invoke(it);
            return Unit.INSTANCE;
        }
    }

    public BaseFragment(String tagPrefix) {
        Intrinsics.checkNotNullParameter(tagPrefix, "tagPrefix");
        this.f417a = tagPrefix + "_BF";
        this.b = "Activity is finishing, won't attempt to modify ui";
        this.f = new String[]{"android.permission.CAMERA"};
        this.h = com.socure.docv.capturesdk.feature.a.a(this);
        this.i = System.currentTimeMillis();
        this.j = new a();
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.socure.docv.capturesdk.feature.base.presentation.ui.BaseFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BaseFragment.a(BaseFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.k = registerForActivityResult;
    }

    public static final void a(BaseFragment this$0, Map result) {
        Function1<? super PermissionState, Unit> function1;
        PermissionState permissionState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : result.entrySet()) {
            if (!((Boolean) entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        com.socure.docv.capturesdk.common.logger.b.a(this$0.f417a, "registerForActivityResult deniedList - " + arrayList);
        if (!arrayList.isEmpty()) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it2 = arrayList.iterator();
            while (true) {
                boolean hasNext = it2.hasNext();
                String str = ConstantsKt.EXPLAINED;
                if (!hasNext) {
                    break;
                }
                Object next = it2.next();
                if (this$0.shouldShowRequestPermissionRationale((String) next)) {
                    str = ConstantsKt.DENIED;
                }
                Object obj = linkedHashMap2.get(str);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap2.put(str, obj);
                }
                ((List) obj).add(next);
            }
            if (((List) linkedHashMap2.get(ConstantsKt.DENIED)) != null) {
                this$0.j.invoke(PermissionState.PERMISSION_DENIED);
            }
            if (((List) linkedHashMap2.get(ConstantsKt.EXPLAINED)) == null) {
                return;
            }
            function1 = this$0.j;
            permissionState = PermissionState.PERMISSION_DO_NOT_ASK_DENIED;
        } else {
            com.socure.docv.capturesdk.common.logger.b.a(this$0.f417a, "Permission was granted");
            function1 = this$0.j;
            permissionState = PermissionState.PERMISSION_GRANTED;
        }
        function1.invoke(permissionState);
    }

    public final com.socure.docv.capturesdk.common.analytics.a a() {
        com.socure.docv.capturesdk.common.analytics.a aVar = this.e;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("docSelection");
        return null;
    }

    public final void a(Guideline glView) {
        Intrinsics.checkNotNullParameter(glView, "glView");
        Integer c = b().c();
        if (c != null) {
            glView.setGuidelineBegin(c.intValue());
        }
    }

    public final void a(String screen) {
        Unit unit;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (this.d == null || this.e == null) {
            a("clicked", new Pair<>("type", "close"), new Pair<>(Event.EVENT_TYPE_SCREEN, screen), d());
        } else {
            a(Utils.INSTANCE.replacePlaceholders$capturesdk_productionRelease("[Document_Type]_[Capture_Type]_capture_abort", c(), a()), new Pair<>(Event.EVENT_TYPE_SCREEN, screen), d());
        }
        String docSelFacet$capturesdk_productionRelease = Utils.INSTANCE.getDocSelFacet$capturesdk_productionRelease(b().d());
        if (docSelFacet$capturesdk_productionRelease != null) {
            a("error", new Pair<>("type", "document_scan_cancel"), new Pair<>(Event.EVENT_TYPE_SCREEN, screen), new Pair<>("facet_type", docSelFacet$capturesdk_productionRelease));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            a("error", new Pair<>("type", "document_scan_cancel"), new Pair<>(Event.EVENT_TYPE_SCREEN, screen));
        }
        b().b();
    }

    public final void a(String event, Pair<String, String>... args) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(args, "args");
        b().a(event, (Pair[]) Arrays.copyOf(args, args.length));
    }

    public final void a(Function1<? super String, Unit> function1) {
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "triggerCameraPermission");
        function1.invoke("camera_popup_shown");
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "requestCameraPermission");
        this.k.launch(this.f);
    }

    public final com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b b() {
        return (com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b) this.h.getValue();
    }

    public final ScanType c() {
        ScanType scanType = this.d;
        if (scanType != null) {
            return scanType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scanType");
        return null;
    }

    public final Pair<String, String> d() {
        return TuplesKt.to("screen_duration", String.valueOf(System.currentTimeMillis() - this.i));
    }

    public final boolean e() {
        return UtilsKt.isOldOs() || UtilsKt.lowRamDevice() || !ConstantsKt.getOPEN_CV_SUPPORTED();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "onAttach");
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "onDestroy");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "onDetach");
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "onStart");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "onStop");
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        com.socure.docv.capturesdk.common.logger.b.a(this.f417a, "onViewStateRestored");
    }
}
