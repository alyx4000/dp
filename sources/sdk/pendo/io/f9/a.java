package sdk.pendo.io.f9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoBackCapture;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b6\u00107J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\b\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\rJ!\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\b\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011RB\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0013j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004`\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\b\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\b\u0010\"\"\u0004\b\b\u0010#R*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u0016\u0010'\"\u0004\b\b\u0010(R\"\u0010/\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b\b\u0010.R\"\u00105\u001a\n 1*\u0004\u0018\u000100008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b%\u00104¨\u00068"}, d2 = {"Lsdk/pendo/io/f9/a;", "", "Landroid/view/ViewTreeObserver;", "viewTree", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "currentViewRef", "", "a", "Lsdk/pendo/io/views/custom/PendoBackCapture;", "pendoBackCapture", "(Lsdk/pendo/io/views/custom/PendoBackCapture;)V", "d", "()Lsdk/pendo/io/views/custom/PendoBackCapture;", "currentViewRoot", "(Landroid/view/ViewGroup;Lsdk/pendo/io/views/custom/PendoBackCapture;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getBackCaptureMap$pendoIO_release", "()Ljava/util/HashMap;", "backCaptureMap", "c", "Landroid/view/ViewTreeObserver;", "()Landroid/view/ViewTreeObserver;", "(Landroid/view/ViewTreeObserver;)V", "currentViewTree", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "()Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "(Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;)V", "currentFocusListener", "e", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "currentRootViewRef", "f", "I", "getCurrentViewHash$pendoIO_release", "()I", "(I)V", "currentViewHash", "", "kotlin.jvm.PlatformType", "g", "Ljava/lang/String;", "()Ljava/lang/String;", "TAG", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher dispatcher;

    /* renamed from: b, reason: from kotlin metadata */
    private final HashMap<Integer, WeakReference<PendoBackCapture>> backCaptureMap;

    /* renamed from: c, reason: from kotlin metadata */
    private ViewTreeObserver currentViewTree;

    /* renamed from: d, reason: from kotlin metadata */
    private ViewTreeObserver.OnGlobalFocusChangeListener currentFocusListener;

    /* renamed from: e, reason: from kotlin metadata */
    private WeakReference<ViewGroup> currentRootViewRef;

    /* renamed from: f, reason: from kotlin metadata */
    private int currentViewHash;

    /* renamed from: g, reason: from kotlin metadata */
    private final String TAG;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FocusHandler$addKeyListenerToCurrentFocusedViewOrToPendoBackCapture$1", f = "FocusHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: sdk.pendo.io.f9.a$a, reason: collision with other inner class name */
    static final class C0139a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PendoBackCapture A;
        int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0139a(PendoBackCapture pendoBackCapture, Continuation<? super C0139a> continuation) {
            super(2, continuation);
            this.A = pendoBackCapture;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0139a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new C0139a(this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            WeakReference<ViewGroup> b = a.this.b();
            ViewGroup viewGroup = b != null ? b.get() : null;
            View findFocus = viewGroup != null ? viewGroup.findFocus() : null;
            if (findFocus != null) {
                a aVar = a.this;
                PendoBackCapture pendoBackCapture = this.A;
                PendoLogger.d(aVar.getTAG() + " addKeyListenerToCurrentFocusedViewOrToPendoBackCapture - in focus element is: " + findFocus, new Object[0]);
                sdk.pendo.io.p9.a.a(findFocus, pendoBackCapture);
            } else {
                a aVar2 = a.this;
                PendoBackCapture pendoBackCapture2 = this.A;
                PendoLogger.d(aVar2.getTAG() + " addKeyListenerToCurrentFocusedViewOrToPendoBackCapture - pendoBackCapture requested focus", new Object[0]);
                pendoBackCapture2.requestFocus();
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FocusHandler$addPendoBackCaptureToViewGroup$1", f = "FocusHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup A;
        int f;
        final /* synthetic */ PendoBackCapture s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(PendoBackCapture pendoBackCapture, ViewGroup viewGroup, Continuation<? super b> continuation) {
            super(2, continuation);
            this.s = pendoBackCapture;
            this.A = viewGroup;
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
            try {
            } catch (Exception e) {
                PendoLogger.w(e, "Error adding pendoBackCapture", new Object[0]);
            }
            if (Intrinsics.areEqual(this.s.getParent(), this.A)) {
                return Unit.INSTANCE;
            }
            ViewParent parent = this.s.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.s);
            }
            ViewGroup viewGroup2 = this.A;
            if (viewGroup2 != null) {
                viewGroup2.addView(this.s);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FocusHandler$setFocusListener$1", f = "FocusHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a A;
        int f;
        final /* synthetic */ WeakReference<ViewGroup> f0;
        final /* synthetic */ ViewTreeObserver s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ViewTreeObserver viewTreeObserver, a aVar, WeakReference<ViewGroup> weakReference, Continuation<? super c> continuation) {
            super(2, continuation);
            this.s = viewTreeObserver;
            this.A = aVar;
            this.f0 = weakReference;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.s, this.A, this.f0, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008d A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:5:0x000b, B:7:0x0013, B:10:0x0016, B:12:0x0024, B:14:0x0060, B:18:0x006b, B:20:0x0073, B:21:0x007c, B:23:0x008d, B:24:0x0093, B:26:0x00a5, B:28:0x00e9, B:33:0x00b9), top: B:4:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a5 A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:5:0x000b, B:7:0x0013, B:10:0x0016, B:12:0x0024, B:14:0x0060, B:18:0x006b, B:20:0x0073, B:21:0x007c, B:23:0x008d, B:24:0x0093, B:26:0x00a5, B:28:0x00e9, B:33:0x00b9), top: B:4:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                Method dump skipped, instructions count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void a(PendoBackCapture pendoBackCapture) {
        Intrinsics.checkNotNullParameter(pendoBackCapture, "pendoBackCapture");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.dispatcher, null, new C0139a(pendoBackCapture, null), 2, null);
    }

    public final WeakReference<ViewGroup> b() {
        return this.currentRootViewRef;
    }

    /* renamed from: c, reason: from getter */
    public final ViewTreeObserver getCurrentViewTree() {
        return this.currentViewTree;
    }

    public final PendoBackCapture d() {
        WeakReference<ViewGroup> weakReference = this.currentRootViewRef;
        ViewGroup viewGroup = weakReference != null ? weakReference.get() : null;
        if (viewGroup == null) {
            return null;
        }
        WeakReference<PendoBackCapture> weakReference2 = this.backCaptureMap.get(Integer.valueOf(this.currentViewHash));
        PendoBackCapture pendoBackCapture = weakReference2 != null ? weakReference2.get() : null;
        if (pendoBackCapture != null) {
            PendoLogger.d(this.TAG + " getPendoBackCapture - pendoBackCapture found in backCaptureMap for " + this.currentViewHash + " view hash", new Object[0]);
            if (pendoBackCapture.getParent() == null) {
                PendoLogger.d(this.TAG + " getPendoBackCapture - pendoBackCapture parent is null. Adding pendoBackCapture to ViewGroup: " + viewGroup + " with hash: " + this.currentViewHash, new Object[0]);
                a(viewGroup, pendoBackCapture);
            }
            return pendoBackCapture;
        }
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PendoBackCapture pendoBackCapture2 = new PendoBackCapture(context);
        this.backCaptureMap.put(Integer.valueOf(this.currentViewHash), new WeakReference<>(pendoBackCapture2));
        PendoLogger.d(this.TAG + " getPendoBackCapture - pendoBackCapture instance added to backCaptureMap with key: " + this.currentViewHash + " . Total # of keys: " + this.backCaptureMap.size(), new Object[0]);
        a(viewGroup, pendoBackCapture2);
        return pendoBackCapture2;
    }

    /* renamed from: e, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    public a(CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.backCaptureMap = new HashMap<>();
        this.currentViewHash = -1;
        this.TAG = "a";
    }

    public final synchronized void a(ViewGroup currentViewRoot, PendoBackCapture pendoBackCapture) {
        Intrinsics.checkNotNullParameter(pendoBackCapture, "pendoBackCapture");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.dispatcher, null, new b(pendoBackCapture, currentViewRoot, null), 2, null);
    }

    public /* synthetic */ a(CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getMain().getImmediate() : coroutineDispatcher);
    }

    /* renamed from: a, reason: from getter */
    public final ViewTreeObserver.OnGlobalFocusChangeListener getCurrentFocusListener() {
        return this.currentFocusListener;
    }

    public final void a(ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener) {
        this.currentFocusListener = onGlobalFocusChangeListener;
    }

    public final void a(WeakReference<ViewGroup> weakReference) {
        this.currentRootViewRef = weakReference;
    }

    public final void a(int i) {
        this.currentViewHash = i;
    }

    public final void a(ViewTreeObserver viewTreeObserver) {
        this.currentViewTree = viewTreeObserver;
    }

    public final void a(ViewTreeObserver viewTree, WeakReference<ViewGroup> currentViewRef) {
        Intrinsics.checkNotNullParameter(viewTree, "viewTree");
        Intrinsics.checkNotNullParameter(currentViewRef, "currentViewRef");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.dispatcher, null, new c(viewTree, this, currentViewRef, null), 2, null);
    }
}
