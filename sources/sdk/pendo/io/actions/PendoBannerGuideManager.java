package sdk.pendo.io.actions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.OperatingSystem;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.PendoFloatingVisualGuideManager;
import sdk.pendo.io.g9.k0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.views.custom.IBackgroundRenderView;
import sdk.pendo.io.views.custom.PendoBannerView;
import sdk.pendo.io.views.custom.PendoLinearLayout;
import sdk.pendo.io.views.custom.PendoScrollView;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/actions/PendoBannerGuideManager;", "Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager;", "()V", "bannerStepDuration", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getBannerStepDuration", "()Ljava/util/HashMap;", "setBannerStepDuration", "(Ljava/util/HashMap;)V", "show", "", "builder", "Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;", "showInternal", "", "rootView", "Landroid/view/View;", "layout", "Lsdk/pendo/io/views/custom/PendoBannerView;", "withoutAnimation", "Builder", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PendoBannerGuideManager extends PendoFloatingVisualGuideManager {
    private static PendoBannerGuideManager INSTANCE;
    private HashMap<String, Long> bannerStepDuration;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PendoBannerGuideManager";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;", "Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$Builder;", "id", "", "(Ljava/lang/String;)V", "maxWidthdp", "", "getMaxWidthdp", "()F", "setMaxWidthdp", "(F)V", "backgroundImageProperties", "url", "fillType", "accessibilityText", OperatingSystem.JsonKeys.BUILD, ViewProps.MAX_WIDTH, "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder extends PendoFloatingVisualGuideManager.Builder {
        private float maxWidthdp;

        public Builder(String str) {
            super(str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Builder backgroundImageProperties(String url, String fillType, String accessibilityText) {
            if (url != null && fillType != null) {
                View customView = getCustomView();
                if (customView instanceof PendoLinearLayout ? true : customView instanceof PendoScrollView) {
                    View customView2 = getCustomView();
                    Intrinsics.checkNotNull(customView2, "null cannot be cast to non-null type sdk.pendo.io.views.custom.IBackgroundRenderView");
                    IBackgroundRenderView iBackgroundRenderView = (IBackgroundRenderView) customView2;
                    iBackgroundRenderView.setImageBackgroundURL(url);
                    iBackgroundRenderView.setImageFillType(fillType);
                    iBackgroundRenderView.setStrokeWidth(getStrokeWidth());
                    iBackgroundRenderView.setStrokeColor(getStrokeColor());
                    customView2.setBackgroundColor(getBgColor());
                    iBackgroundRenderView.setCornerRadius(getFrameRadius());
                    if (!TextUtils.isEmpty(accessibilityText)) {
                        customView2.setContentDescription(accessibilityText);
                    }
                }
            }
            return this;
        }

        @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.Builder
        public Builder build() {
            PendoFloatingVisualGuideManager.Builder build = super.build();
            Intrinsics.checkNotNull(build, "null cannot be cast to non-null type sdk.pendo.io.actions.PendoBannerGuideManager.Builder");
            return (Builder) build;
        }

        public final float getMaxWidthdp() {
            return this.maxWidthdp;
        }

        public final Builder maxWidth(float maxWidthdp) {
            this.maxWidthdp = maxWidthdp;
            return this;
        }

        public final void setMaxWidthdp(float f) {
            this.maxWidthdp = f;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/actions/PendoBannerGuideManager$Companion;", "", "()V", "INSTANCE", "Lsdk/pendo/io/actions/PendoBannerGuideManager;", "TAG", "", "kotlin.jvm.PlatformType", "instance", "getInstance$annotations", "getInstance", "()Lsdk/pendo/io/actions/PendoBannerGuideManager;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        public final synchronized PendoBannerGuideManager getInstance() {
            if (PendoBannerGuideManager.INSTANCE == null) {
                PendoBannerGuideManager.INSTANCE = new PendoBannerGuideManager(null);
                Activity f = c.g().f();
                PendoFloatingVisualGuideManager.Companion companion = PendoFloatingVisualGuideManager.INSTANCE;
                Intrinsics.checkNotNull(f);
                companion.resetContext(f);
            }
            return PendoBannerGuideManager.INSTANCE;
        }
    }

    private PendoBannerGuideManager() {
        this.bannerStepDuration = new HashMap<>();
    }

    public static final synchronized PendoBannerGuideManager getInstance() {
        PendoBannerGuideManager companion;
        synchronized (PendoBannerGuideManager.class) {
            companion = INSTANCE.getInstance();
        }
        return companion;
    }

    private final void showInternal(View rootView, PendoBannerView layout, boolean withoutAnimation) {
        if (rootView instanceof ViewGroup) {
            q0.b(rootView);
            if (layout.getParent() == null) {
                ((ViewGroup) rootView).addView(layout, new ViewGroup.LayoutParams(rootView.getWidth(), rootView.getHeight()));
            }
            if (withoutAnimation) {
                layout.show();
            }
        }
    }

    public final HashMap<String, Long> getBannerStepDuration() {
        return this.bannerStepDuration;
    }

    public final void setBannerStepDuration(HashMap<String, Long> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.bannerStepDuration = hashMap;
    }

    public final boolean show(Builder builder) {
        WeakReference<View> weakReference;
        View view;
        Intrinsics.checkNotNullParameter(builder, "builder");
        String str = TAG;
        PendoLogger.i(str + " - show", new Object[0]);
        if (!builder.getIsCompleted()) {
            throw new IllegalArgumentException("Builder incomplete. Call 'build()' first");
        }
        synchronized (this.mLock) {
            if (this.mFloatingGuides.containsKey(builder.getId())) {
                PendoLogger.w(str + " A guide with the same id was already specified", new Object[0]);
                return false;
            }
            Activity f = c.g().f();
            if (f != null && f.getWindow() != null && !f.isFinishing()) {
                q0.b a2 = o0.a(o0.f1142a, f, false, 2, null);
                if (a2 != null && a2.e()) {
                    View anchorView = builder.getAnchorView();
                    if (anchorView != null) {
                        view = k0.a(anchorView);
                    }
                    view = null;
                } else {
                    if (a2 != null && (weakReference = a2.f1145a) != null) {
                        view = weakReference.get();
                    }
                    view = null;
                }
                builder.setRootView(view);
                WeakReference<Context> contextRef = PendoFloatingVisualGuideManager.INSTANCE.getContextRef();
                PendoBannerView pendoBannerView = new PendoBannerView(contextRef != null ? contextRef.get() : null, builder);
                pendoBannerView.setOnFloatingGuideListener(this.mFloatingGuideListener);
                String id = builder.getId();
                if (id != null) {
                    this.mFloatingGuides.put(id, new WeakReference<>(pendoBannerView));
                }
                View rootView = builder.getRootView();
                if (rootView != null) {
                    showInternal(rootView, pendoBannerView, false);
                    Unit unit = Unit.INSTANCE;
                }
                return true;
            }
            return false;
        }
    }

    public /* synthetic */ PendoBannerGuideManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
