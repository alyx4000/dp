package com.socure.docv.capturesdk.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.snackbar.Snackbar;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.NewLabels;
import com.socure.docv.capturesdk.common.view.model.f;
import com.socure.docv.capturesdk.common.view.model.g;
import com.socure.docv.capturesdk.common.view.model.h;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.Output;
import com.socure.docv.capturesdk.feature.help.presentation.ui.HelpView;
import com.socure.docv.capturesdk.feature.preview.presentation.ui.PreviewView;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J/\u0010\u001c\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010 \u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010(\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b&\u0010'J7\u00102\u001a\u00020%2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020%0.H\u0000¢\u0006\u0004\b0\u00101J\u001f\u00105\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b3\u00104J\u000e\u00107\u001a\u0002062\u0006\u0010\u0018\u001a\u00020\u0017J\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004092\u0006\u00108\u001a\u00020\tJ\u0016\u0010=\u001a\u00020<2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\t¨\u0006@"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/HelpPreviewUtils;", "", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "scanType", "", "getHelpBannerImage", "Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;", "newLabels", "", "", "getHelpInstruction", "Landroid/content/Context;", "context", "", "isCardVertical", "getDimensionRatio", "getPreviewConfirmationText", "color", "", "ratio", "getLightColor", "Lcom/socure/docv/capturesdk/core/processor/model/Output;", "output", "Lcom/socure/docv/capturesdk/common/network/model/stepup/App;", "configData", "Lcom/socure/docv/capturesdk/common/view/model/g;", "getPreviewUiData$capturesdk_productionRelease", "(Landroid/content/Context;Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/core/processor/model/Output;Lcom/socure/docv/capturesdk/common/network/model/stepup/App;)Lcom/socure/docv/capturesdk/common/view/model/g;", "getPreviewUiData", "Lcom/socure/docv/capturesdk/common/view/model/f;", "getHelpViewUiData$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/common/network/model/stepup/App;)Lcom/socure/docv/capturesdk/common/view/model/f;", "getHelpViewUiData", "Landroid/view/View;", "view", "Lcom/socure/docv/capturesdk/databinding/g;", "binding", "", "setVisibilityFocus$capturesdk_productionRelease", "(Landroid/view/View;Lcom/socure/docv/capturesdk/databinding/g;)V", "setVisibilityFocus", "Landroid/widget/ImageView;", "ivDbgPreviewScan", "icSaveImages", "Landroid/graphics/Bitmap;", "debugBitmap", "Lkotlin/Function0;", "saveDebugImage", "showPreviewDbgImg$capturesdk_productionRelease", "(Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lkotlin/jvm/functions/Function0;)V", "showPreviewDbgImg", "getScannerHelpText$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;)Ljava/lang/String;", "getScannerHelpText", "Lcom/socure/docv/capturesdk/common/view/model/b;", "getFailureRetryButtonColor", "primaryColor", "Lkotlin/Pair;", "getPreviewProgressButtonColors", ViewProps.BORDER_COLOR, "Landroid/graphics/drawable/Drawable;", "getSecondaryButtonDrawable", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class HelpPreviewUtils {
    public static final HelpPreviewUtils INSTANCE = new HelpPreviewUtils();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScanType.values().length];
            iArr[ScanType.LICENSE_FRONT.ordinal()] = 1;
            iArr[ScanType.LICENSE_BACK.ordinal()] = 2;
            iArr[ScanType.PASSPORT.ordinal()] = 3;
            iArr[ScanType.SELFIE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private HelpPreviewUtils() {
    }

    private final String getDimensionRatio(Context context, ScanType scanType, boolean isCardVertical) {
        Resources resources;
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            resources = context.getResources();
            i = isCardVertical ? R.string.socure_vertical_license_aspect_ratio_bg : R.string.socure_license_aspect_ratio_bg;
        } else if (i2 == 3) {
            resources = context.getResources();
            i = R.string.socure_passport_aspect_ratio_preview_bg;
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            resources = context.getResources();
            i = R.string.socure_selfie_preview_ratio;
        }
        String string = resources.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "with(context) {\n        …}\n            }\n        }");
        return string;
    }

    private final int getHelpBannerImage(ScanType scanType) {
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return R.drawable.socure_help_lic_front;
        }
        if (i == 2) {
            return R.drawable.socure_help_lic_back;
        }
        if (i == 3) {
            return R.drawable.socure_help_passport;
        }
        if (i == 4) {
            return R.drawable.socure_help_selfie;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<String> getHelpInstruction(ScanType scanType, NewLabels newLabels) {
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return CollectionsKt.listOf((Object[]) new String[]{newLabels.getPlaceIdFlat(), newLabels.getHoldPhoneOverId(), newLabels.getFocusCameraId()});
        }
        if (i == 2) {
            return CollectionsKt.listOf((Object[]) new String[]{newLabels.getFlipYourId(), newLabels.getHoldPhoneOverId(), newLabels.getFocusCameraId()});
        }
        if (i == 3) {
            return CollectionsKt.listOf((Object[]) new String[]{newLabels.getOpenPassport(), newLabels.getHoldPhoneOverPassport(), newLabels.getFocusCameraPassport()});
        }
        if (i == 4) {
            return CollectionsKt.listOf((Object[]) new String[]{newLabels.getAlignFaceFrame(), newLabels.getHoldDevice(), newLabels.getLookDirectly()});
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getLightColor(String color, float ratio) {
        return ColorUtils.blendARGB(Color.parseColor(color), -1, ratio);
    }

    private final String getPreviewConfirmationText(ScanType scanType, NewLabels newLabels) {
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return newLabels.isAllInfoVisible();
        }
        if (i == 2) {
            return newLabels.isAllInfoVisibleBarcode();
        }
        if (i == 3) {
            return newLabels.isAllInfoVisiblePassport();
        }
        if (i == 4) {
            return newLabels.isYourFaceInFrame();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPreviewDbgImg$lambda-2, reason: not valid java name */
    public static final void m960showPreviewDbgImg$lambda2(final Function0 saveDebugImage, View view) {
        Intrinsics.checkNotNullParameter(saveDebugImage, "$saveDebugImage");
        b.a("SDLT_HELP_PREVIEW_UTILS", "Debug image saver clicked");
        Snackbar anchorView = Snackbar.make(view, "Export debug images to disk?", 0).setAction("YES", new View.OnClickListener() { // from class: com.socure.docv.capturesdk.common.utils.HelpPreviewUtils$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HelpPreviewUtils.m961showPreviewDbgImg$lambda2$lambda1(Function0.this, view2);
            }
        }).setActionTextColor(-16711936).setAnchorView(view);
        Intrinsics.checkNotNullExpressionValue(anchorView, "make(it, \"Export debug i…       .setAnchorView(it)");
        anchorView.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPreviewDbgImg$lambda-2$lambda-1, reason: not valid java name */
    public static final void m961showPreviewDbgImg$lambda2$lambda1(Function0 saveDebugImage, View view) {
        Intrinsics.checkNotNullParameter(saveDebugImage, "$saveDebugImage");
        saveDebugImage.invoke();
    }

    public final com.socure.docv.capturesdk.common.view.model.b getFailureRetryButtonColor(App configData) {
        Intrinsics.checkNotNullParameter(configData, "configData");
        return new com.socure.docv.capturesdk.common.view.model.b(Utils.INSTANCE.getRetakeBtnText$capturesdk_productionRelease(configData.getNewLabels()), configData.getTheme().getPrimary().getButton().getPrimary().getColor(), null, configData.getTheme().getPrimary().getButton().getPrimary().getBackgroundColor(), 4, null);
    }

    public final f getHelpViewUiData$capturesdk_productionRelease(ScanType scanType, App configData) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(configData, "configData");
        return new f(new h(UtilsKt.getHelpTitleText(scanType, configData.getNewLabels()), configData.getTheme().getPrimary().getColor()), getHelpBannerImage(scanType), getHelpInstruction(scanType, configData.getNewLabels()), configData.getTheme().getPrimary().getColor(), new com.socure.docv.capturesdk.common.view.model.b(configData.getNewLabels().getBackToScanning(), configData.getTheme().getPrimary().getButton().getPrimary().getColor(), configData.getTheme().getPrimary().getButton().getPrimary().getBorderColor(), configData.getTheme().getPrimary().getButton().getPrimary().getBackgroundColor()));
    }

    public final Pair<Integer, Integer> getPreviewProgressButtonColors(String primaryColor) {
        Intrinsics.checkNotNullParameter(primaryColor, "primaryColor");
        return new Pair<>(Integer.valueOf(getLightColor(primaryColor, 0.8f)), Integer.valueOf(getLightColor(primaryColor, 0.6f)));
    }

    public final g getPreviewUiData$capturesdk_productionRelease(Context context, ScanType scanType, Output output, App configData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(configData, "configData");
        String dimensionRatio = getDimensionRatio(context, scanType, output.getFinalBitmap().getHeight() > output.getFinalBitmap().getWidth());
        h hVar = new h(UtilsKt.getConfirmationTitleText(scanType, configData.getNewLabels()), configData.getTheme().getPrimary().getColor());
        String previewConfirmationText = getPreviewConfirmationText(scanType, configData.getNewLabels());
        h hVar2 = new h(configData.getNewLabels().getSubmitImageForValidation(), configData.getTheme().getPrimary().getColor());
        h hVar3 = new h(previewConfirmationText, configData.getTheme().getPrimary().getColor());
        Utils utils = Utils.INSTANCE;
        return new g(dimensionRatio, hVar, hVar2, hVar3, output.getFinalBitmap(), new com.socure.docv.capturesdk.common.view.model.b(utils.getContBtnText$capturesdk_productionRelease(scanType, configData.getNewLabels()), configData.getTheme().getPrimary().getButton().getPrimary().getColor(), null, configData.getTheme().getPrimary().getButton().getPrimary().getBackgroundColor(), 4, null), new com.socure.docv.capturesdk.common.view.model.b(utils.getRetakeBtnText$capturesdk_productionRelease(configData.getNewLabels()), configData.getTheme().getPrimary().getButton().getSecondary().getColor(), configData.getTheme().getPrimary().getButton().getSecondary().getBorderColor(), null, 8, null), output.getDebugBitmap());
    }

    public final String getScannerHelpText$capturesdk_productionRelease(ScanType scanType, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return newLabels.getPlaceFlatAndHoldId();
        }
        if (i == 2) {
            return newLabels.getFlipIdBarcode();
        }
        if (i == 3) {
            return newLabels.getPlaceFlatAndHoldPassport();
        }
        if (i == 4) {
            return newLabels.getMovePhoneFront();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Drawable getSecondaryButtonDrawable(Context context, String borderColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke((int) context.getResources().getDimension(R.dimen.stroke_button_stroke_width_socure), Color.parseColor(borderColor));
        gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen.stroke_button_corner_radius_socure));
        gradientDrawable.setColor(0);
        return gradientDrawable;
    }

    public final void setVisibilityFocus$capturesdk_productionRelease(View view, com.socure.docv.capturesdk.databinding.g binding) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(binding, "binding");
        if (view instanceof PreviewView) {
            binding.d.c.setVisibility(8);
            PreviewView previewView = binding.d.d;
            previewView.getClass();
            previewView.f464a = System.currentTimeMillis();
            previewView.setVisibility(0);
            PreviewView previewView2 = binding.d.d;
            Intrinsics.checkNotNullExpressionValue(previewView2, "binding.bsContainer.previewView");
            UtilsKt.requestFocusAccessibilityEvent(previewView2);
            return;
        }
        if (view instanceof HelpView) {
            PreviewView previewView3 = binding.d.d;
            previewView3.f464a = -1L;
            previewView3.setVisibility(8);
            binding.d.c.setVisibility(0);
            HelpView helpView = binding.d.c;
            Intrinsics.checkNotNullExpressionValue(helpView, "binding.bsContainer.helpView");
            UtilsKt.requestFocusAccessibilityEvent(helpView);
        }
    }

    public final void showPreviewDbgImg$capturesdk_productionRelease(ImageView ivDbgPreviewScan, ImageView icSaveImages, Bitmap debugBitmap, final Function0<Unit> saveDebugImage) {
        Intrinsics.checkNotNullParameter(ivDbgPreviewScan, "ivDbgPreviewScan");
        Intrinsics.checkNotNullParameter(icSaveImages, "icSaveImages");
        Intrinsics.checkNotNullParameter(saveDebugImage, "saveDebugImage");
        Utils utils = Utils.INSTANCE;
        if (!utils.showDebugImage$capturesdk_productionRelease() || debugBitmap == null || debugBitmap.isRecycled()) {
            b.a("SDLT_HELP_PREVIEW_UTILS", "showDebugImage: " + utils.showDebugImage$capturesdk_productionRelease() + " | debug img null: " + (debugBitmap == null) + " | recycled: " + (debugBitmap != null ? Boolean.valueOf(debugBitmap.isRecycled()) : null));
            ivDbgPreviewScan.setVisibility(8);
            icSaveImages.setVisibility(8);
            return;
        }
        b.a("SDLT_HELP_PREVIEW_UTILS", "showing DebugImage");
        icSaveImages.setOnClickListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.common.utils.HelpPreviewUtils$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelpPreviewUtils.m960showPreviewDbgImg$lambda2(Function0.this, view);
            }
        });
        ivDbgPreviewScan.setVisibility(0);
        icSaveImages.setVisibility(0);
        ivDbgPreviewScan.setImageBitmap(debugBitmap);
    }
}
