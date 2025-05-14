package com.socure.docv.capturesdk.common.utils;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import com.amplitude.reactnative.DatabaseConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.mlkit.vision.text.Text;
import com.reactcommunity.rndatetimepicker.Common;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import io.sentry.profilemeasurements.ProfileMeasurement;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import retrofit2.Response;
import sdk.pendo.io.actions.configurations.GuideTransition;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a(\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u00020\u0011\"\b\b\u0000\u0010\u0012*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00120\u0013H\u0000\u001a\u001c\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\u0012*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00120\u0013H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u0011*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u0011*\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0000\u001a\u001c\u0010\u001e\u001a\u00020\u0011*\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\"\u001a\u00020\u0011*\u00020\u001f2\u0006\u0010!\u001a\u00020\u0001H\u0000\u001a\u0014\u0010#\u001a\u00020\u0011*\u00020$2\u0006\u0010 \u001a\u00020\u0018H\u0000\u001a1\u0010%\u001a\u00020\u0011*\u00020\u001f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\u00012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u00020\u0011\"\b\b\u0000\u0010\u0012*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00120\u0013H\u0000\u001a\f\u0010+\u001a\u00020\u0011*\u00020\tH\u0000\u001a\u0018\u0010,\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030-2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010/*\b\u0012\u0004\u0012\u00020100H\u0000\u001a\f\u00102\u001a\u00020\u0003*\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"TAG", "", "getApiResponse", "Lcom/socure/docv/capturesdk/core/pipeline/model/ApiResponse;", "", "apiType", "Lcom/socure/docv/capturesdk/common/network/model/ApiType;", "getDimension", "Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "Landroid/view/View;", "getSerializable", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Landroid/content/Intent;", DatabaseConstants.KEY_FIELD, "(Landroid/content/Intent;Ljava/lang/String;)Ljava/io/Serializable;", "hide", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "isNotVisible", "", ProfileMeasurement.UNIT_PERCENT, "", "", "safeNavigate", "Landroidx/navigation/NavController;", GuideTransition.GUIDE_TRANSITION_DIRECTION_FIELD, "Landroidx/navigation/NavDirections;", "id", "setCorner", "Landroid/widget/TextView;", "color", "strokeColor", "setCornerStroke", "setTint", "Landroid/widget/ImageView;", "setupText", "tvText", Common.TEXT_COLOR, "visibilityFlag", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "show", "showWithFadeInAnimation", "toApiResponse", "Lretrofit2/Response;", "toStringList", "", "", "Lcom/google/mlkit/vision/text/Text$TextBlock;", "toUnKnownApiResponse", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExtensionsKt {
    private static final String TAG = "SDLT_EXT";

    public static final ApiResponse getApiResponse(Throwable th, ApiType apiType) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(apiType, "apiType");
        b.a(TAG, "getApiResponse exception msg: " + th.getMessage(), null, 4, null);
        if (th instanceof SocketTimeoutException) {
            String message = th.getMessage();
            if (message == null) {
                message = ConstantsKt.MESSAGE_NOT_AVAILABLE;
            }
            return new ApiResponse(apiType, -1, ConstantsKt.MESSAGE_NOT_AVAILABLE, -1, message);
        }
        if (th instanceof IOException) {
            ResponseCode responseCode = ResponseCode.NO_INTERNET;
            return new ApiResponse(apiType, responseCode.getCode(), responseCode.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
        }
        int code = ResponseCode.UNKNOWN_ERROR.getCode();
        String stackTraceString = Log.getStackTraceString(th);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(this)");
        return new ApiResponse(apiType, code, stackTraceString, -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
    }

    public static final Dimension getDimension(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new Dimension(view.getWidth(), view.getHeight());
    }

    public static final /* synthetic */ <T extends Serializable> T getSerializable(Intent intent, String key) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) intent.getSerializableExtra(key, Serializable.class);
        }
        T t = (T) intent.getSerializableExtra(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final <V extends View> void hide(BottomSheetBehavior<V> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setState(5);
    }

    public static final <V extends View> boolean isNotVisible(BottomSheetBehavior<V> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        return bottomSheetBehavior.getState() == 5;
    }

    public static final double percent(int i, double d) {
        return (i * d) / 100;
    }

    public static final void safeNavigate(NavController navController, int i) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        b.a(TAG, "navigate called using action id: " + i);
        navController.navigate(i);
    }

    public static final void safeNavigate(NavController navController, NavDirections direction) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        b.a(TAG, "safeNavigate called actionId: " + direction.getActionId());
        NavDestination currentDestination = navController.getCurrentDestination();
        Unit unit = null;
        if (currentDestination != null) {
            if (currentDestination.getAction(direction.getActionId()) != null) {
                try {
                    navController.navigate(direction);
                } catch (Exception e) {
                    b.a(TAG, "safeNavigate exception: " + e.getLocalizedMessage());
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                b.a(TAG, "safeNavigate getAction null");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b.a(TAG, "safeNavigate currentDestination null");
        }
    }

    public static final void setCorner(TextView textView, String color, String strokeColor) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(strokeColor, "strokeColor");
        Drawable background = textView.getBackground();
        if (background == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        gradientDrawable.setColor(Color.parseColor(color));
        gradientDrawable.setStroke(MathKt.roundToInt(TypedValue.applyDimension(1, 1.0f, textView.getResources().getDisplayMetrics())), Color.parseColor(strokeColor));
        textView.setBackground(gradientDrawable);
    }

    public static final void setCornerStroke(TextView textView, String strokeColor) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(strokeColor, "strokeColor");
        Drawable background = textView.getBackground();
        if (background == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        gradientDrawable.setStroke(MathKt.roundToInt(TypedValue.applyDimension(1, 1.0f, textView.getResources().getDisplayMetrics())), Color.parseColor(strokeColor));
        textView.setBackground(gradientDrawable);
    }

    public static final void setTint(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        DrawableCompat.setTint(imageView.getDrawable(), i);
    }

    public static final void setupText(TextView textView, String str, String textColor, Integer num) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        if (str != null) {
            textView.setText(str);
        }
        textView.setTextColor(Color.parseColor(textColor));
        if (num != null) {
            textView.setVisibility(num.intValue());
        }
    }

    public static /* synthetic */ void setupText$default(TextView textView, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        setupText(textView, str, str2, num);
    }

    public static final <V extends View> void show(BottomSheetBehavior<V> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setState(3);
    }

    public static final void showWithFadeInAnimation(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_in));
    }

    public static final ApiResponse toApiResponse(Response<?> response, ApiType apiType) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(apiType, "apiType");
        Pair<Integer, String> errorSocureSdkResponseHttpInfo = ErrorHandlerKt.getErrorSocureSdkResponseHttpInfo(response.errorBody());
        int intValue = errorSocureSdkResponseHttpInfo.getFirst().intValue();
        String second = errorSocureSdkResponseHttpInfo.getSecond();
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "this.message()");
        return new ApiResponse(apiType, intValue, second, code, message);
    }

    public static final List<String> toStringList(List<? extends Text.TextBlock> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String text = ((Text.TextBlock) it.next()).getText();
            Intrinsics.checkNotNullExpressionValue(text, "it.text");
            arrayList.add(text);
        }
        return arrayList;
    }

    public static final ApiResponse toUnKnownApiResponse(ApiType apiType) {
        Intrinsics.checkNotNullParameter(apiType, "<this>");
        ResponseCode responseCode = ResponseCode.UNKNOWN_ERROR;
        return new ApiResponse(apiType, responseCode.getCode(), responseCode.getMessage(), -1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
    }
}
