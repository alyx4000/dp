package com.socure.docv.capturesdk.feature.base.presentation.ui;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.utils.PermissionState;
import com.socure.docv.capturesdk.common.utils.Utils;
import io.castle.android.api.model.Event;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1<PermissionState, Unit> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseFragment f419a;
    public final /* synthetic */ Function1<String, Unit> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ FragmentActivity d;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420a;

        static {
            int[] iArr = new int[PermissionState.values().length];
            iArr[PermissionState.PERMISSION_GRANTED.ordinal()] = 1;
            iArr[PermissionState.PERMISSION_DO_NOT_ASK_DENIED.ordinal()] = 2;
            iArr[PermissionState.PERMISSION_DENIED.ordinal()] = 3;
            f420a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(BaseFragment baseFragment, Function1<? super String, Unit> function1, String str, FragmentActivity fragmentActivity) {
        super(1);
        this.f419a = baseFragment;
        this.b = function1;
        this.c = str;
        this.d = fragmentActivity;
    }

    public final void a(PermissionState permissionState) {
        Intrinsics.checkNotNullParameter(permissionState, "permissionState");
        int i = a.f420a[permissionState.ordinal()];
        if (i == 1) {
            com.socure.docv.capturesdk.common.logger.b.a(this.f419a.f417a, "requestCameraPermissionWithCallback PERMISSION_GRANTED");
            this.b.invoke("camera_popup_accepted");
            return;
        }
        if (i == 2) {
            com.socure.docv.capturesdk.common.logger.b.a(this.f419a.f417a, "requestCameraPermissionWithCallback PERMISSION_DO_NOT_ASK_DENIED");
            this.b.invoke("camera_popup_do_not_ask_denied");
            BaseFragment baseFragment = this.f419a;
            String str = this.c;
            com.socure.docv.capturesdk.common.logger.b.a(baseFragment.f417a, "triggerPermissionDeniedError called");
            ResponseCode responseCode = ResponseCode.CAMERA_PERMISSION_DENIED;
            baseFragment.a("error", new Pair<>("type", "camera_permission"), new Pair<>("message", responseCode.getMessage()), new Pair<>("facet_type", Utils.INSTANCE.getDocSelFacet$capturesdk_productionRelease(baseFragment.b().d(), baseFragment.c())), new Pair<>(Event.EVENT_TYPE_SCREEN, str), baseFragment.d());
            baseFragment.b().a(responseCode);
            return;
        }
        if (i != 3) {
            return;
        }
        com.socure.docv.capturesdk.common.logger.b.a(this.f419a.f417a, "requestCameraPermissionWithCallback PERMISSION_DENIED");
        this.f419a.a("camera_permission_denied", new Pair<>("message", ResponseCode.CAMERA_PERMISSION_DENIED.getMessage()), new Pair<>("facet_type", Utils.INSTANCE.getDocSelFacet$capturesdk_productionRelease(this.f419a.b().d(), this.f419a.c())), new Pair<>(Event.EVENT_TYPE_SCREEN, this.c), this.f419a.d());
        this.b.invoke("camera_popup_declined");
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d, R.style.socure_alert_dialog_style);
        com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
        builder.setTitle(aVar.b().getNewLabels().getCameraPermissionTitle());
        builder.setMessage(aVar.b().getNewLabels().getCameraPermissionMsg());
        final BaseFragment baseFragment2 = this.f419a;
        final String str2 = this.c;
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.socure.docv.capturesdk.feature.base.presentation.ui.b$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                b.a(BaseFragment.this, str2, dialogInterface);
            }
        });
        String cameraPermissionButton = aVar.b().getNewLabels().getCameraPermissionButton();
        final BaseFragment baseFragment3 = this.f419a;
        final Function1<String, Unit> function1 = this.b;
        builder.setPositiveButton(cameraPermissionButton, new DialogInterface.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.base.presentation.ui.b$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                b.a(BaseFragment.this, function1, dialogInterface, i2);
            }
        });
        this.b.invoke("camera_permission_explanation_shown");
        builder.show();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PermissionState permissionState) {
        a(permissionState);
        return Unit.INSTANCE;
    }

    public static final void a(BaseFragment this$0, String screen, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(screen, "$screen");
        ResponseCode responseCode = ResponseCode.CAMERA_PERMISSION_DENIED;
        this$0.a("error", new Pair<>("type", "camera_permission"), new Pair<>("message", responseCode.getMessage()), new Pair<>("facet_type", Utils.INSTANCE.getDocSelFacet$capturesdk_productionRelease(this$0.b().d(), this$0.c())), new Pair<>(Event.EVENT_TYPE_SCREEN, screen));
        this$0.b().a(responseCode);
    }

    public static final void a(BaseFragment this$0, Function1 eventTrigger, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eventTrigger, "$eventTrigger");
        dialogInterface.dismiss();
        int i2 = BaseFragment.l;
        this$0.a((Function1<? super String, Unit>) eventTrigger);
    }
}
