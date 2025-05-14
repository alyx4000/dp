package sdk.pendo.io.sdk.flutter;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.f9.k;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.v6.a;
import sdk.pendo.io.x5.j;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0019\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010+\u001a\u0004\u0018\u00010(¢\u0006\u0004\bN\u0010OJ0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0003J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001f\u0010\u000b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0010¢\u0006\u0004\b\u000b\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u000b\u001a\u00020\u001dH\u0016J\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0010¢\u0006\u0004\b\u000e\u0010 J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0010\u0010&\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\nJ\u0006\u0010'\u001a\u00020\rR\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R,\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u00109\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\n0:j\b\u0012\u0004\u0012\u00020\n`;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R(\u0010K\u001a\u00020B8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bC\u0010D\u0012\u0004\bI\u0010J\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006Q"}, d2 = {"Lsdk/pendo/io/sdk/flutter/FlutterScreenManager;", "Lsdk/pendo/io/f9/k;", "Lsdk/pendo/io/sdk/flutter/IFlutterEventsCallback;", "Landroid/app/Activity;", "activity", "", ViewProps.LEFT, ViewProps.TOP, "width", "height", "Landroid/view/View;", "a", "view", "", "b", "onActivityResumed", "onActivityPaused", "", "screenName", "", "", "info", "newScreenIdentified", "", "includeText", "isForCapture", "Lorg/json/JSONObject;", "(ZZ)Lorg/json/JSONObject;", "j", "Lorg/json/JSONArray;", "Lsdk/pendo/io/h9/c;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Landroid/app/Activity;Lsdk/pendo/io/h9/c;)V", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "anchorView", "c", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/sdk/flutter/IFlutterBridge;", "e0", "Lsdk/pendo/io/sdk/flutter/IFlutterBridge;", Pendo.PendoOptions.FLUTTER_BRIDGE, "Lsdk/pendo/io/w6/b;", "f0", "Lsdk/pendo/io/w6/b;", "getNewScreenIdentifiedSubject$pendoIO_release", "()Lsdk/pendo/io/w6/b;", "setNewScreenIdentifiedSubject$pendoIO_release", "(Lsdk/pendo/io/w6/b;)V", "newScreenIdentifiedSubject", "g0", "Lorg/json/JSONObject;", ActivationManager.SCREEN_DATA_KEY, "h0", "Ljava/util/Map;", "abstractViewTree", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i0", "Ljava/util/ArrayList;", "anchorViewsList", "j0", "Landroid/view/View;", "activeAnchorView", "Lkotlinx/coroutines/CoroutineDispatcher;", "k0", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineMainDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setCoroutineMainDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "getCoroutineMainDispatcher$annotations", "()V", "coroutineMainDispatcher", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;Lsdk/pendo/io/sdk/flutter/IFlutterBridge;)V", "l0", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class FlutterScreenManager extends k implements IFlutterEventsCallback {
    private static final String m0 = "FlutterScreenManager";

    /* renamed from: e0, reason: from kotlin metadata */
    private final IFlutterBridge flutterBridge;

    /* renamed from: f0, reason: from kotlin metadata */
    private sdk.pendo.io.w6.b<String> newScreenIdentifiedSubject;

    /* renamed from: g0, reason: from kotlin metadata */
    private JSONObject retroactiveScreenData;

    /* renamed from: h0, reason: from kotlin metadata */
    private Map<?, ?> abstractViewTree;

    /* renamed from: i0, reason: from kotlin metadata */
    private final ArrayList<View> anchorViewsList;

    /* renamed from: j0, reason: from kotlin metadata */
    private View activeAnchorView;

    /* renamed from: k0, reason: from kotlin metadata */
    private CoroutineDispatcher coroutineMainDispatcher;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.flutter.FlutterScreenManager$createAnchorView$1", f = "FlutterScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View A;
        int f;
        final /* synthetic */ Activity s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, View view, Continuation<? super b> continuation) {
            super(2, continuation);
            this.s = activity;
            this.A = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.s, this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((ViewGroup) this.s.findViewById(R.id.content)).addView(this.A);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.flutter.FlutterScreenManager$removeViewFromItsParent$1$1", f = "FlutterScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int f;
        final /* synthetic */ View s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(View view, Continuation<? super c> continuation) {
            super(2, continuation);
            this.s = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.s, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ViewGroup viewGroup = (ViewGroup) this.s.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.s);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterScreenManager(Pendo.PendoOptions pendoOptions, IFlutterBridge iFlutterBridge) {
        super(pendoOptions);
        j<String> a2;
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        this.flutterBridge = iFlutterBridge;
        this.retroactiveScreenData = new JSONObject();
        this.abstractViewTree = new HashMap();
        this.anchorViewsList = new ArrayList<>();
        this.coroutineMainDispatcher = Dispatchers.getMain();
        if (iFlutterBridge != null) {
            iFlutterBridge.registerForEvents(this);
            sdk.pendo.io.w6.b<String> n = sdk.pendo.io.w6.b.n();
            this.newScreenIdentifiedSubject = n;
            if (n == null || (a2 = n.a(a.a())) == null) {
                return;
            }
            a2.a(sdk.pendo.io.d9.c.a(new e() { // from class: sdk.pendo.io.sdk.flutter.FlutterScreenManager$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    FlutterScreenManager.a(FlutterScreenManager.this, (String) obj);
                }
            }, m0 + " perform on computation thread observer newScreenIdentified"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FlutterScreenManager this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(str);
    }

    private final void b(View view) {
        if (view != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), this.coroutineMainDispatcher, null, new c(view, null), 2, null);
        }
    }

    public final synchronized void T() {
        b(this.activeAnchorView);
        this.activeAnchorView = null;
    }

    public final synchronized void c(View anchorView) {
        this.activeAnchorView = anchorView;
        for (View view : this.anchorViewsList) {
            if (!Intrinsics.areEqual(view, anchorView)) {
                b(view);
            }
        }
        this.anchorViewsList.clear();
    }

    @Override // sdk.pendo.io.f9.k, sdk.pendo.io.f9.f
    /* renamed from: j, reason: from getter */
    public JSONObject getRetroactiveScreenData() {
        return this.retroactiveScreenData;
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void newScreenIdentified(String screenName, Map<String, ? extends Object> info) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(info, "info");
        PendoLogger.i(m0, "newScreenIdentified -> screen name received from plugin: " + screenName + " and info " + info);
        if (O()) {
            return;
        }
        T();
        Object obj = info.get(ActivationManager.SCREEN_DATA_KEY);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        this.retroactiveScreenData = new JSONObject((Map) obj);
        Object obj2 = info.get("tree");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        this.abstractViewTree = (Map) obj2;
        sdk.pendo.io.w6.b<String> bVar = this.newScreenIdentifiedSubject;
        if (bVar != null) {
            bVar.onNext(screenName);
        }
    }

    @Override // sdk.pendo.io.f9.k, sdk.pendo.io.f9.f
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // sdk.pendo.io.f9.k, sdk.pendo.io.f9.f
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (w().length() > 0) {
            a(false);
        }
    }

    private final View a(Activity activity, double left, double top, double width, double height) {
        View view = new View(activity);
        view.setLayoutParams(new FrameLayout.LayoutParams((int) width, (int) height));
        view.setX((float) left);
        view.setY((float) top);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), this.coroutineMainDispatcher, null, new b(activity, view, null), 2, null);
        return view;
    }

    @Override // sdk.pendo.io.f9.k
    public void b(Activity activity, sdk.pendo.io.h9.c listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        Bitmap createBitmap = Bitmap.createBitmap(decorView != null ? decorView.getWidth() : 0, decorView != null ? decorView.getHeight() : 0, Bitmap.Config.ARGB_8888);
        try {
            IFlutterBridge iFlutterBridge = this.flutterBridge;
            byte[] decode = Base64.decode(iFlutterBridge != null ? iFlutterBridge.generateBitmap() : null, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
            createBitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            PendoLogger.w(m0, "Failed to capture the screen, exception: " + e);
        }
        Intrinsics.checkNotNull(createBitmap);
        listener.a(createBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x014e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be A[SYNTHETIC] */
    @Override // sdk.pendo.io.f9.k, sdk.pendo.io.f9.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<sdk.pendo.io.actions.ElementInfoAndViewRef> a(java.util.List<sdk.pendo.io.actions.ActivationManager.Trigger> r25) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.sdk.flutter.FlutterScreenManager.a(java.util.List):java.util.List");
    }

    @Override // sdk.pendo.io.f9.k
    public JSONObject a(boolean includeText, boolean isForCapture) {
        return this.retroactiveScreenData;
    }

    @Override // sdk.pendo.io.f9.k, sdk.pendo.io.f9.f
    public JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        try {
            ArrayList arrayList = new ArrayList();
            Object obj = this.abstractViewTree.get(CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            arrayList.add((Map) obj);
            while (!arrayList.isEmpty()) {
                Map map = (Map) CollectionsKt.removeLast(arrayList);
                Object obj2 = map.get(IdentificationData.SERIALIZED_NAME);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                jSONArray.put(new JSONObject((Map) obj2));
                Object obj3 = map.get(ViewHierarchyNode.JsonKeys.CHILDREN);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                Iterator it = ((ArrayList) obj3).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    arrayList.add((Map) next);
                }
            }
        } catch (Exception e) {
            PendoLogger.w(m0, "getViewTreeDataForCapture: " + e.getMessage());
        }
        return jSONArray;
    }
}
