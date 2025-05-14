package sdk.pendo.io.a8;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a8.a;
import sdk.pendo.io.actions.PendoFloatingVisualGuideManager;
import sdk.pendo.io.g9.k0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/a8/c;", "Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager;", "Landroid/view/View;", "rootView", "Lsdk/pendo/io/a8/e;", "layout", "", "withoutAnimation", "Lsdk/pendo/io/a8/c$a;", "builder", "", "a", "Lsdk/pendo/io/a8/a;", "<init>", "()V", "b", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class c extends PendoFloatingVisualGuideManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String b = "c";
    private static c c;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b(\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0005\u001a\u00020\u0000H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u000e\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010(\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b'\u0010\u001fR\u001c\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u0012\u0004\b)\u0010*R\u001c\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b,\u0010\u0012\u0012\u0004\b-\u0010*¨\u00062"}, d2 = {"Lsdk/pendo/io/a8/c$a;", "Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$Builder;", "", "halfWidthDp", "heightDp", "a", "", "backDropColor", "", "showBackDrop", "", "paddingLeftPx", "b", "paddingTopPx", "d", "paddingRightPx", "c", "paddingBottomPx", "I", "()I", "setBackDropColor", "(I)V", "Z", "g", "()Z", "setShowBackDropProperty", "(Z)V", "showBackDropProperty", "F", "()F", "setBackDropPaddingLeftPx", "(F)V", "backDropPaddingLeftPx", "f", "setBackDropPaddingTopPx", "backDropPaddingTopPx", "e", "setBackDropPaddingRightPx", "backDropPaddingRightPx", "setBackDropPaddingBottomPx", "backDropPaddingBottomPx", "getCaretWidthPx$annotations", "()V", "caretWidthPx", "h", "getCaretHeightPx$annotations", "caretHeightPx", "id", "<init>", "(Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class a extends PendoFloatingVisualGuideManager.Builder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int backDropColor;

        /* renamed from: b, reason: from kotlin metadata */
        private boolean showBackDropProperty;

        /* renamed from: c, reason: from kotlin metadata */
        private float backDropPaddingLeftPx;

        /* renamed from: d, reason: from kotlin metadata */
        private float backDropPaddingTopPx;

        /* renamed from: e, reason: from kotlin metadata */
        private float backDropPaddingRightPx;

        /* renamed from: f, reason: from kotlin metadata */
        private float backDropPaddingBottomPx;

        /* renamed from: g, reason: from kotlin metadata */
        public int caretWidthPx;

        /* renamed from: h, reason: from kotlin metadata */
        public int caretHeightPx;

        public a(String str) {
            super(str);
            this.backDropColor = -1;
            this.caretWidthPx = q0.a(15.0f);
            this.caretHeightPx = q0.a(15.0f);
        }

        public final a a(int backDropColor) {
            this.backDropColor = backDropColor;
            return this;
        }

        public final a b(float paddingLeftPx) {
            this.backDropPaddingLeftPx = paddingLeftPx;
            return this;
        }

        public final a c(float paddingRightPx) {
            this.backDropPaddingRightPx = paddingRightPx;
            return this;
        }

        public final a d(float paddingTopPx) {
            this.backDropPaddingTopPx = paddingTopPx;
            return this;
        }

        /* renamed from: e, reason: from getter */
        public final float getBackDropPaddingRightPx() {
            return this.backDropPaddingRightPx;
        }

        /* renamed from: f, reason: from getter */
        public final float getBackDropPaddingTopPx() {
            return this.backDropPaddingTopPx;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getShowBackDropProperty() {
            return this.showBackDropProperty;
        }

        public final a a(float paddingBottomPx) {
            this.backDropPaddingBottomPx = paddingBottomPx;
            return this;
        }

        /* renamed from: b, reason: from getter */
        public final int getBackDropColor() {
            return this.backDropColor;
        }

        /* renamed from: c, reason: from getter */
        public final float getBackDropPaddingBottomPx() {
            return this.backDropPaddingBottomPx;
        }

        /* renamed from: d, reason: from getter */
        public final float getBackDropPaddingLeftPx() {
            return this.backDropPaddingLeftPx;
        }

        @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a build() {
            PendoFloatingVisualGuideManager.Builder build = super.build();
            Intrinsics.checkNotNull(build, "null cannot be cast to non-null type external.sdk.pendo.io.tooltip.PendoTooltipManager.Builder");
            return (a) build;
        }

        @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a withBackDrop(boolean showBackDrop) {
            this.showBackDropProperty = showBackDrop;
            return this;
        }

        public final a a(String halfWidthDp, String heightDp) {
            Intrinsics.checkNotNullParameter(halfWidthDp, "halfWidthDp");
            Intrinsics.checkNotNullParameter(heightDp, "heightDp");
            this.caretWidthPx = k0.a(halfWidthDp, this.caretWidthPx) * 2;
            this.caretHeightPx = k0.a(heightDp, this.caretHeightPx);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/a8/c$b;", "", "Lsdk/pendo/io/a8/c;", "a", "()Lsdk/pendo/io/a8/c;", "getInstance$annotations", "()V", "instance", "INSTANCE", "Lsdk/pendo/io/a8/c;", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.a8.c$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized c a() {
            if (c.c == null) {
                c.c = new c(null);
                Activity f = sdk.pendo.io.n8.c.g().f();
                PendoFloatingVisualGuideManager.Companion companion = PendoFloatingVisualGuideManager.INSTANCE;
                Intrinsics.checkNotNull(f);
                companion.resetContext(f);
            }
            return c.c;
        }
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final sdk.pendo.io.a8.a a(a builder, View rootView) {
        View anchorView = builder.getAnchorView();
        a.b a2 = anchorView != null ? new a.b(rootView.getContext(), anchorView).a(builder.getBackDropPaddingLeftPx(), builder.getBackDropPaddingTopPx(), builder.getBackDropPaddingRightPx(), builder.getBackDropPaddingBottomPx()).a(builder.getIsSeeThrough()).a(builder.getSeeThroughRadius()).a(builder.getBackDropColor()) : null;
        if (a2 == null) {
            return null;
        }
        return new sdk.pendo.io.a8.a(a2);
    }

    public final boolean a(a builder) {
        WeakReference<View> weakReference;
        View view;
        Intrinsics.checkNotNullParameter(builder, "builder");
        String str = b;
        PendoLogger.i(str + " - tooltip show", new Object[0]);
        if (!builder.getIsCompleted()) {
            throw new IllegalArgumentException("Builder incomplete. Call 'build()' first");
        }
        synchronized (this.mLock) {
            if (this.mFloatingGuides.containsKey(builder.getId())) {
                PendoLogger.w(str + " A tooltip with the same id was already specified", new Object[0]);
                return false;
            }
            Activity f = sdk.pendo.io.n8.c.g().f();
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
                e eVar = new e(contextRef != null ? contextRef.get() : null, builder);
                eVar.setOnFloatingGuideListener(this.mFloatingGuideListener);
                String id = builder.getId();
                if (id != null) {
                    this.mFloatingGuides.put(id, new WeakReference<>(eVar));
                }
                a(builder.getRootView(), eVar, false, builder);
                Unit unit = Unit.INSTANCE;
                return true;
            }
            return false;
        }
    }

    private final void a(View rootView, e layout, boolean withoutAnimation, a builder) {
        sdk.pendo.io.a8.a a2;
        if (rootView instanceof ViewGroup) {
            q0.b(rootView);
            ViewGroup viewGroup = (ViewGroup) rootView;
            View findViewById = viewGroup.findViewById(R.id.content);
            if (layout.getParent() == null && findViewById != null) {
                if (builder.getShowBackDropProperty() && (a2 = a(builder, rootView)) != null) {
                    a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    ((ViewGroup) findViewById).addView(a2);
                    layout.setBackDrop(a2);
                }
                viewGroup.addView(layout, new ViewGroup.LayoutParams(-1, -1));
            }
            if (withoutAnimation) {
                layout.show();
            }
        }
    }
}
