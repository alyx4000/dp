package sdk.pendo.io.g9;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.l9.a;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002JR\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J(\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0018\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JW\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001f0\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001fH\u0003¢\u0006\u0004\b\u0011\u0010!JI\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001f0\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001fH\u0003¢\u0006\u0004\b\u0011\u0010\"J\u001c\u0010\u0011\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020\u0002H\u0007J\u000e\u0010\u0011\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0014J\u001e\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ(\u0010\u0011\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020,J\u001e\u0010\u0011\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u0011\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004J\u001b\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010/JC\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001c2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001f0\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001fH\u0007¢\u0006\u0004\b\u0011\u00101JI\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\"\u0010 \u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001f0\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001fH\u0007¢\u0006\u0004\b\u0018\u00102R\"\u00108\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u00104\u001a\u0004\b\u0011\u00105\"\u0004\b6\u00107R\u001c\u0010<\u001a\n :*\u0004\u0018\u000109098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010;\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lsdk/pendo/io/g9/o0;", "", "", "c", "Landroid/view/View;", "view", "Lorg/json/JSONArray;", "tree", "Ljava/util/HashSet;", "discoverySet", "", "depth", "fakeZ", "isParentAList", "isForCapture", "Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "onViewFoundListener", "a", "rootView", "", "Lorg/json/JSONObject;", "viewAsJSON", "Lsdk/pendo/io/events/IdentificationData;", "viewIdentificationData", "b", "jsonObject", "d", "", "Lsdk/pendo/io/g9/o0$a;", "callbacks", "", "Ljava/lang/Class;", "classes", "(Landroid/view/View;Ljava/util/HashSet;Ljava/util/List;[Ljava/lang/Class;)Z", "(Landroid/view/View;Ljava/util/List;[Ljava/lang/Class;)Z", "Landroid/app/Activity;", "activity", "ignoreDialogs", "Lsdk/pendo/io/g9/q0$b;", "identificationDataJson", "includeText", "includeNestedText", "rootViews", "viewZIndex", "Landroid/view/ViewGroup;", "Lkotlin/ranges/IntProgression;", "viewChild", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "(Landroid/view/View;Lsdk/pendo/io/g9/o0$a;[Ljava/lang/Class;)V", "(Landroid/view/View;Ljava/util/List;[Ljava/lang/Class;)V", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "setMainCoroutineDispatcher", "(Lkotlinx/coroutines/MainCoroutineDispatcher;)V", "mainCoroutineDispatcher", "Lsdk/pendo/io/e9/c;", "kotlin.jvm.PlatformType", "()Lsdk/pendo/io/e9/c;", "policyManager", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final o0 f1142a = new o0();

    /* renamed from: b, reason: from kotlin metadata */
    private static MainCoroutineDispatcher mainCoroutineDispatcher = Dispatchers.getMain();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0006\u0010\t\u001a\u00020\bR(\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/g9/o0$a;", "", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "oBundle", "", "performActionOnView", "", "reset", "<set-?>", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static abstract class a {
        private Bundle data;

        public final Bundle getData() {
            return this.data;
        }

        public abstract boolean performActionOnView(View view, Bundle oBundle);

        public final void reset() {
            this.data = new Bundle();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ViewHierarchyUtility$addListenersToView$2", f = "ViewHierarchyUtility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int f;
        final /* synthetic */ View s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view, Continuation<? super b> continuation) {
            super(2, continuation);
            this.s = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.s, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (p0.b(this.s)) {
                q0.a(this.s, (WeakReference<View>) new WeakReference(this.s));
                if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && this.s.getVisibility() == 0) {
                    String cls = this.s.getClass().toString();
                    Intrinsics.checkNotNullExpressionValue(cls, "toString(...)");
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String lowerCase = cls.toLowerCase(US);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "floatinglistenerbutton", false, 2, (Object) null)) {
                        return Unit.INSTANCE;
                    }
                }
            } else if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && Intrinsics.areEqual(this.s.getClass().getSimpleName(), "ReactViewGroup")) {
                o0.f1142a.c(this.s);
            }
            View view = this.s;
            if ((view instanceof ListView) || (view instanceof GridView)) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.AbsListView");
                AbsListView absListView = (AbsListView) view;
                q0.a(absListView);
                q0.b(absListView);
            } else if (p0.a(view)) {
                View view2 = this.s;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout");
                q0.a((DrawerLayout) view2);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/g9/o0$c", "Lsdk/pendo/io/l9/a$c;", "Landroid/view/View;", "view", "", "isParentAList", "", ViewProps.Z_INDEX, "", "a", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class c implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONArray f1143a;
        final /* synthetic */ OnElementInScreenFoundListener b;

        c(JSONArray jSONArray, OnElementInScreenFoundListener onElementInScreenFoundListener) {
            this.f1143a = jSONArray;
            this.b = onElementInScreenFoundListener;
        }

        @Override // sdk.pendo.io.l9.a.c
        public void a(View view, boolean isParentAList, int zIndex) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                JSONObject a2 = o0.f1142a.a(view, zIndex, isParentAList, true);
                if (a2 == null) {
                    return;
                }
                this.f1143a.put(a2);
                OnElementInScreenFoundListener onElementInScreenFoundListener = this.b;
                if (onElementInScreenFoundListener != null) {
                    onElementInScreenFoundListener.onViewFound(a2, new WeakReference<>(view));
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "get ViewTreeAndScreenState input: view:" + view.getClass().getCanonicalName() + " isParentList:" + isParentAList + " ");
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ViewHierarchyUtility$useMainThreadAddListenersToView$1", f = "ViewHierarchyUtility.kt", i = {}, l = {479}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int f;
        final /* synthetic */ View s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(View view, Continuation<? super d> continuation) {
            super(2, continuation);
            this.s = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.s, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o0 o0Var = o0.f1142a;
                View view = this.s;
                this.f = 1;
                if (o0Var.a(view, this) == coroutine_suspended) {
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

    private o0() {
    }

    private final sdk.pendo.io.e9.c b() {
        return PendoInternal.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            if ((view2.getTouchDelegate() instanceof PendoTouchDelegate) && Intrinsics.areEqual(parent.getClass().getSimpleName(), "ReactViewGroup")) {
                TouchDelegate touchDelegate = view2.getTouchDelegate();
                Intrinsics.checkNotNull(touchDelegate, "null cannot be cast to non-null type sdk.pendo.io.PendoTouchDelegate");
                q0.a(view, ((PendoTouchDelegate) touchDelegate).b());
            }
        }
    }

    private final void d(View view, JSONObject jsonObject) {
        try {
            JSONObject jSONObject = new JSONObject();
            Rect g = q0.g(view);
            jSONObject.put(ViewProps.LEFT, g.left);
            jSONObject.put(ViewProps.TOP, g.top);
            jSONObject.put("width", g.width());
            jSONObject.put("height", g.height());
            jsonObject.put(ViewProps.POSITION, jSONObject);
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    private final void c(View view, JSONObject viewAsJSON) {
        String f = q0.f(view);
        if (f != null) {
            viewAsJSON.put("id", f);
        }
        if (!PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() || view.getId() <= 0) {
            return;
        }
        viewAsJSON.put("reactTag", view.getId());
    }

    public final Object a(View view, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(mainCoroutineDispatcher, new b(view, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final JSONObject b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return a(view, b().h(), b().q());
    }

    public final void d(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new d(view, null), 3, null);
    }

    private final void b(View view, JSONObject jsonObject) {
        try {
            boolean b2 = p0.b(view);
            jsonObject.put("clickable", b2);
            if (b2) {
                TextView d2 = q0.d(view);
                CharSequence text = d2 != null ? d2.getText() : null;
                if (text != null) {
                    jsonObject.put(IdentificationData.FIELD_TEXT_BASE64, m0.b(m0.a(text).toString()));
                }
            }
            jsonObject.put("has_on_click_listeners", view.hasOnClickListeners());
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    private final boolean c() {
        return PendoInternal.w().b();
    }

    public final void a(View rootView) {
        ArrayList arrayList = new ArrayList();
        if (rootView != null) {
            if (!(rootView instanceof ViewGroup)) {
                f1142a.d(rootView);
                return;
            }
            arrayList.add(rootView);
            int i = -1;
            do {
                i++;
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) obj;
                f1142a.d(viewGroup);
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null) {
                        if (childAt instanceof ViewGroup) {
                            arrayList.add(childAt);
                        } else {
                            f1142a.d(childAt);
                        }
                    }
                }
            } while (i < arrayList.size() - 1);
        }
    }

    private final void a(View view, JSONObject viewAsJSON, IdentificationData viewIdentificationData, boolean isForCapture) {
        if (isForCapture) {
            viewAsJSON.put("retroElementTexts", viewIdentificationData.createRetroElementTexts());
            if (b().g()) {
                viewAsJSON.put("retroElementCompatibilityHashes", a(view, viewIdentificationData));
            }
        }
    }

    @SafeVarargs
    public final void b(View view, List<? extends a> callbacks, Class<? extends View>... classes) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(classes, "classes");
        a(view, new HashSet<>(), callbacks, (Class<? extends View>[]) Arrays.copyOf(classes, classes.length));
    }

    private final JSONObject b(View view, boolean isParentAList) {
        if (view == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        b(view, jSONObject);
        d(view, jSONObject);
        if (isParentAList) {
            a(view, jSONObject);
        }
        if ((view instanceof TextView) && !jSONObject.has(IdentificationData.FIELD_TEXT_BASE64)) {
            try {
                jSONObject.put(IdentificationData.FIELD_TEXT_BASE64, m0.b(m0.a(((TextView) view).getText()).toString()));
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
        return jSONObject;
    }

    public final JSONArray a(View view, IdentificationData viewIdentificationData) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewIdentificationData, "viewIdentificationData");
        return sdk.pendo.io.m8.b.a(view, viewIdentificationData).createRetroElementCompatibilityHashes();
    }

    private final IdentificationData a(View view, boolean isForCapture) {
        IdentificationData a2;
        if (isForCapture) {
            Boolean bool = Boolean.TRUE;
            a2 = sdk.pendo.io.m8.b.a(view, bool, bool);
        } else {
            a2 = sdk.pendo.io.m8.b.a(view, Boolean.valueOf(b().h()), Boolean.valueOf(b().q()));
        }
        Intrinsics.checkNotNull(a2);
        return a2;
    }

    public final JSONObject a(View view, int viewZIndex, boolean isParentAList, boolean isForCapture) {
        Intrinsics.checkNotNullParameter(view, "view");
        JSONObject b2 = b(view, isParentAList);
        if (b2 == null) {
            PendoLogger.e("View as JSON is null!", new Object[0]);
            return null;
        }
        b2.put("classHierarchy", m0.a((List<? extends Object>) m0.a(view)));
        c(view, b2);
        IdentificationData a2 = a(view, isForCapture);
        a(view, b2, a2);
        a(view, b2, a2, isForCapture);
        JSONObject json = a2.toJSON();
        Intrinsics.checkNotNullExpressionValue(json, "toJSON(...)");
        b2.put("retroElementInfo", a(json));
        b2.put(ViewProps.Z_INDEX, viewZIndex);
        return b2;
    }

    public final q0.b a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return a(this, activity, false, 2, null);
    }

    public final synchronized q0.b a(Activity activity, boolean ignoreDialogs) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (decorView.getLayoutParams() == null) {
            return null;
        }
        WeakReference weakReference = new WeakReference(decorView);
        ViewGroup.LayoutParams layoutParams = decorView.getLayoutParams();
        q0.b bVar = new q0.b(weakReference, layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null);
        if (!activity.hasWindowFocus() && !ignoreDialogs) {
            List<q0.b> a2 = q0.a(activity);
            if (a2.size() > 1) {
                int size = a2.size() - 1;
                if (a2.get(size).e() || a2.get(size).f()) {
                    return a2.get(size);
                }
            }
        }
        return bVar;
    }

    public static /* synthetic */ q0.b a(o0 o0Var, Activity activity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return o0Var.a(activity, z);
    }

    public final MainCoroutineDispatcher a() {
        return mainCoroutineDispatcher;
    }

    public final IntProgression a(ViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        n0 n0Var = n0.f1140a;
        boolean a2 = n0Var.a(view);
        boolean b2 = n0Var.b(view);
        int childCount = view.getChildCount();
        if (b2) {
            int i = childCount - 1;
            return RangesKt.downTo(i, i);
        }
        if (a2 && childCount > 1) {
            childCount--;
        }
        return RangesKt.until(0, childCount);
    }

    public final JSONArray a(HashSet<View> rootViews, boolean isForCapture, OnElementInScreenFoundListener onViewFoundListener) {
        if (rootViews == null || rootViews.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<View> it = rootViews.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (q0.a(next, 0)) {
                if (isForCapture && c() && PlatformStateManager.INSTANCE.isNotReactNativeApp()) {
                    Intrinsics.checkNotNull(next);
                    a(next, jSONArray, onViewFoundListener);
                    p.a(jSONArray);
                } else {
                    a(next, jSONArray, new HashSet<>(), 0, 0, false, isForCapture, onViewFoundListener);
                }
            }
        }
        return jSONArray;
    }

    public static /* synthetic */ JSONArray a(o0 o0Var, HashSet hashSet, boolean z, OnElementInScreenFoundListener onElementInScreenFoundListener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            onElementInScreenFoundListener = null;
        }
        return o0Var.a((HashSet<View>) hashSet, z, onElementInScreenFoundListener);
    }

    public final JSONObject a(View view, boolean includeText, boolean includeNestedText) {
        Intrinsics.checkNotNullParameter(view, "view");
        JSONObject json = sdk.pendo.io.m8.b.a(view, Boolean.valueOf(includeText), Boolean.valueOf(includeNestedText)).toJSON();
        Intrinsics.checkNotNullExpressionValue(json, "toJSON(...)");
        return a(json);
    }

    public final JSONObject a(JSONObject identificationDataJson) {
        String str;
        Intrinsics.checkNotNullParameter(identificationDataJson, "identificationDataJson");
        if (identificationDataJson.has(IdentificationData.RA_PREDICATE)) {
            str = identificationDataJson.getString(IdentificationData.RA_PREDICATE);
            identificationDataJson.remove(IdentificationData.RA_PREDICATE);
        } else {
            str = null;
        }
        if (identificationDataJson.has(IdentificationData.PREDICATE)) {
            identificationDataJson.remove(IdentificationData.PREDICATE);
        }
        if (str != null) {
            identificationDataJson.put(IdentificationData.PREDICATE, str);
        }
        return identificationDataJson;
    }

    private final int a(View view, JSONArray tree, HashSet<View> discoverySet, int depth, int fakeZ, boolean isParentAList, boolean isForCapture, OnElementInScreenFoundListener onViewFoundListener) {
        int i;
        int i2;
        o0 o0Var = this;
        HashSet<View> hashSet = discoverySet;
        int i3 = depth + fakeZ;
        if (view == null || !q0.a(view, 0)) {
            return i3;
        }
        boolean j = q0.j(view);
        try {
            JSONObject a2 = o0Var.a(view, i3, isParentAList, isForCapture);
            if (a2 == null) {
                return i3;
            }
            tree.put(a2);
            hashSet.add(view);
            if (onViewFoundListener != null) {
                onViewFoundListener.onViewFound(a2, new WeakReference<>(view));
            }
            if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                IntProgression a3 = o0Var.a((ViewGroup) view);
                int first = a3.getFirst();
                int last = a3.getLast();
                int step = a3.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    int i4 = i3;
                    int i5 = first;
                    while (true) {
                        View childAt = ((ViewGroup) view).getChildAt(i5);
                        if (o0Var.a(childAt, hashSet)) {
                            i = last;
                            i2 = i5;
                            i4 = Math.max(i4, a(childAt, tree, discoverySet, i4 + 1, i5, j, isForCapture, onViewFoundListener));
                        } else {
                            i = last;
                            i2 = i5;
                        }
                        if (i2 == i) {
                            break;
                        }
                        i5 = i2 + step;
                        hashSet = discoverySet;
                        last = i;
                        o0Var = this;
                    }
                    i3 = i4;
                }
            }
            return i3 + 1;
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), "get ViewTreeAndScreenState input: view:" + view.getClass().getCanonicalName() + " isParentList:" + isParentAList + " ");
            return -1;
        }
    }

    private final void a(View rootView, JSONArray tree, OnElementInScreenFoundListener onViewFoundListener) {
        PendoLogger.i("ViewHierarchyUtility -> entering populateViewTreeSmartScan", new Object[0]);
        new sdk.pendo.io.l9.a().a(rootView, false, new a.d(0), new ArrayList<>(), new c(tree, onViewFoundListener));
    }

    @SafeVarargs
    private final boolean a(View view, List<? extends a> callbacks, Class<? extends View>... classes) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = classes.length == 0;
        if (!(classes.length == 0)) {
            for (Class<? extends View> cls : classes) {
                if (cls.isInstance(view)) {
                    break;
                }
            }
        }
        z = z3;
        if (z) {
            for (a aVar : callbacks) {
                z2 |= aVar.performActionOnView(view, aVar.getData());
            }
        }
        return z2;
    }

    private final void a(View view, JSONObject jsonObject) {
        int childAdapterPosition;
        ViewParent parent = view.getParent();
        if (parent instanceof AbsListView) {
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.AdapterView<*>");
            childAdapterPosition = ((AdapterView) parent).getPositionForView(view);
        } else {
            childAdapterPosition = parent instanceof RecyclerView ? ((RecyclerView) parent).getChildAdapterPosition(view) : -1;
        }
        if (childAdapterPosition >= 0) {
            try {
                jsonObject.put("list_position", childAdapterPosition);
            } catch (JSONException unused) {
            }
        }
    }

    private final void a(View view, JSONObject viewAsJSON, IdentificationData viewIdentificationData) {
        if (viewAsJSON.has("descriptiveTextBase64")) {
            return;
        }
        try {
            CharSequence contentDescription = view.getContentDescription();
            String textBase64 = viewIdentificationData.getTextBase64();
            if (!(view instanceof ViewGroup) && textBase64 != null) {
                if (textBase64.length() > 0) {
                    viewAsJSON.put("descriptiveTextBase64", textBase64);
                    return;
                }
            }
            viewAsJSON.put("descriptiveTextBase64", m0.b(!TextUtils.isEmpty(contentDescription) ? m0.a((CharSequence) contentDescription.toString()).toString() : m0.a((CharSequence) view.getClass().getSimpleName()).toString()));
        } catch (NullPointerException e) {
            PendoLogger.d(e, "Inside ViewHierarchyUtility.getViewTreeAndScreenState() while trying to populate DESCRIPTIVE_TEXT_BASE64", new Object[0]);
        }
    }

    public final boolean a(View viewChild, HashSet<View> discoverySet) {
        Intrinsics.checkNotNullParameter(discoverySet, "discoverySet");
        if (viewChild == null || discoverySet.contains(viewChild)) {
            return false;
        }
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        return platformStateManager.isNotReactNativeApp() || (platformStateManager.isReactNativeAnalyticsEnabled() && viewChild.getVisibility() == 0);
    }

    @SafeVarargs
    public final void a(View view, a callback, Class<? extends View>... classes) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(classes, "classes");
        ArrayList arrayList = new ArrayList();
        arrayList.add(callback);
        b(view, arrayList, (Class[]) Arrays.copyOf(classes, classes.length));
    }

    @SafeVarargs
    private final boolean a(View view, HashSet<View> discoverySet, List<? extends a> callbacks, Class<? extends View>... classes) {
        ViewGroup viewGroup;
        int childCount;
        if (a(view, callbacks, (Class<? extends View>[]) Arrays.copyOf(classes, classes.length))) {
            return true;
        }
        discoverySet.add(view);
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (!discoverySet.contains(childAt)) {
                    Intrinsics.checkNotNull(childAt);
                    if (a(childAt, discoverySet, callbacks, (Class<? extends View>[]) Arrays.copyOf(classes, classes.length))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
