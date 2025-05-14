package sdk.pendo.io.f9;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.g9.o0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J.\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0012J\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0012J&\u0010\u000f\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lsdk/pendo/io/f9/i;", "Lsdk/pendo/io/f9/h;", "Landroid/view/View;", "rootView", "", "tree", "Lorg/json/JSONArray;", "childElements", "textsWithElementsInfo", "", "b", "Lsdk/pendo/io/f9/g;", "viewNode", "discoverySet", "specialElementsJsonArray", "a", "viewNullable", "pendoViewNode", "(Lsdk/pendo/io/f9/g;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "rootViews", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/d;", "Lkotlin/collections/ArrayList;", "fragmentsInfoList", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewPagerOnPageSelectedListener", "", "isRespondToScrollChangeEventsForScreenId", "excludeNestedText", "includeText", "isForCapture", "<init>", "(Ljava/util/ArrayList;Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;ZZZZ)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class i extends h {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenDataHelperSynchronizedScan", f = "ScreenDataHelperSynchronizedScan.kt", i = {0, 0, 0, 0, 1, 1}, l = {199, 204}, m = "addTouchListenersToVisibleViewsRemoveNonVisibleViewsRecursive", n = {"this", "iterator", "childView", "view", "this", "iterator"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    static final class a extends ContinuationImpl {
        Object A;
        Object f;
        Object f0;
        Object s;
        /* synthetic */ Object t0;
        int v0;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.t0 = obj;
            this.v0 |= Integer.MIN_VALUE;
            return i.this.a((g) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenDataHelperSynchronizedScan", f = "ScreenDataHelperSynchronizedScan.kt", i = {0, 0, 0}, l = {179, 182}, m = "addTouchListenersToVisibleViewsRemoveNonVisibleViewsWrapper", n = {"this", "pendoViewNode", "view"}, s = {"L$0", "L$1", "L$2"})
    static final class b extends ContinuationImpl {
        Object A;
        Object f;
        /* synthetic */ Object f0;
        Object s;
        int u0;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f0 = obj;
            this.u0 |= Integer.MIN_VALUE;
            return i.this.b((g) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenDataHelperSynchronizedScan$synchronizedScreenDataScan$1", f = "ScreenDataHelperSynchronizedScan.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g A;
        int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(g gVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.A = gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new c(this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                g gVar = this.A;
                this.f = 1;
                if (iVar.b(gVar, this) == coroutine_suspended) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ArrayList<d> fragmentsInfoList, ViewPager.OnPageChangeListener viewPagerOnPageSelectedListener, boolean z, boolean z2, boolean z3, boolean z4) {
        super(fragmentsInfoList, viewPagerOnPageSelectedListener, z, z2, z3, z4);
        Intrinsics.checkNotNullParameter(fragmentsInfoList, "fragmentsInfoList");
        Intrinsics.checkNotNullParameter(viewPagerOnPageSelectedListener, "viewPagerOnPageSelectedListener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b0 -> B:11:0x0064). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sdk.pendo.io.f9.g r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof sdk.pendo.io.f9.i.a
            if (r0 == 0) goto L13
            r0 = r11
            sdk.pendo.io.f9.i$a r0 = (sdk.pendo.io.f9.i.a) r0
            int r1 = r0.v0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.v0 = r1
            goto L18
        L13:
            sdk.pendo.io.f9.i$a r0 = new sdk.pendo.io.f9.i$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.t0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.v0
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L53
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r10 = r0.s
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r2 = r0.f
            sdk.pendo.io.f9.i r2 = (sdk.pendo.io.f9.i) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r2
            goto L64
        L35:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3d:
            java.lang.Object r10 = r0.f0
            android.view.View r10 = (android.view.View) r10
            java.lang.Object r2 = r0.A
            sdk.pendo.io.f9.g r2 = (sdk.pendo.io.f9.g) r2
            java.lang.Object r5 = r0.s
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.f
            sdk.pendo.io.f9.i r6 = (sdk.pendo.io.f9.i) r6
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r2
            r2 = r6
            goto L95
        L53:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.ArrayList r10 = r10.a()
            java.util.Iterator r10 = r10.iterator()
            java.lang.String r11 = "iterator(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r11 = r9
        L64:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto Lb3
            java.lang.Object r2 = r10.next()
            java.lang.String r5 = "next(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            sdk.pendo.io.f9.g r2 = (sdk.pendo.io.f9.g) r2
            android.view.View r5 = r2.c()
            if (r5 != 0) goto L7c
            goto L64
        L7c:
            sdk.pendo.io.g9.o0 r6 = sdk.pendo.io.g9.o0.f1142a
            r0.f = r11
            r0.s = r10
            r0.A = r2
            r0.f0 = r5
            r0.v0 = r4
            java.lang.Object r6 = r6.a(r5, r0)
            if (r6 != r1) goto L8f
            return r1
        L8f:
            r7 = r5
            r5 = r10
            r10 = r7
            r8 = r2
            r2 = r11
            r11 = r8
        L95:
            boolean r10 = r2.a(r10)
            if (r10 == 0) goto L9e
            r5.remove()
        L9e:
            r0.f = r2
            r0.s = r5
            r10 = 0
            r0.A = r10
            r0.f0 = r10
            r0.v0 = r3
            java.lang.Object r10 = r2.a(r11, r0)
            if (r10 != r1) goto Lb0
            return r1
        Lb0:
            r11 = r2
            r10 = r5
            goto L64
        Lb3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.i.a(sdk.pendo.io.f9.g, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(sdk.pendo.io.f9.g r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof sdk.pendo.io.f9.i.b
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.f9.i$b r0 = (sdk.pendo.io.f9.i.b) r0
            int r1 = r0.u0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.u0 = r1
            goto L18
        L13:
            sdk.pendo.io.f9.i$b r0 = new sdk.pendo.io.f9.i$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.u0
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7a
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.A
            android.view.View r6 = (android.view.View) r6
            java.lang.Object r2 = r0.s
            sdk.pendo.io.f9.g r2 = (sdk.pendo.io.f9.g) r2
            java.lang.Object r4 = r0.f
            sdk.pendo.io.f9.i r4 = (sdk.pendo.io.f9.i) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L64
        L44:
            kotlin.ResultKt.throwOnFailure(r7)
            android.view.View r7 = r6.c()
            if (r7 != 0) goto L50
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L50:
            sdk.pendo.io.g9.o0 r2 = sdk.pendo.io.g9.o0.f1142a
            r0.f = r5
            r0.s = r6
            r0.A = r7
            r0.u0 = r4
            java.lang.Object r2 = r2.a(r7, r0)
            if (r2 != r1) goto L61
            return r1
        L61:
            r4 = r5
            r2 = r6
            r6 = r7
        L64:
            boolean r6 = r4.a(r6)
            if (r6 != 0) goto L7d
            r6 = 0
            r0.f = r6
            r0.s = r6
            r0.A = r6
            r0.u0 = r3
            java.lang.Object r6 = r4.a(r2, r0)
            if (r6 != r1) goto L7a
            return r1
        L7a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L7d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.i.b(sdk.pendo.io.f9.g, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final g a(View viewNullable, Set<View> discoverySet) {
        g a2;
        if (b(viewNullable)) {
            return null;
        }
        Intrinsics.checkNotNull(viewNullable);
        g gVar = new g(viewNullable);
        discoverySet.add(viewNullable);
        if (viewNullable instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) viewNullable;
            if (viewGroup.getChildCount() > 0) {
                IntProgression a3 = o0.f1142a.a(viewGroup);
                int first = a3.getFirst();
                int last = a3.getLast();
                int step = a3.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        View childAt = viewGroup.getChildAt(first);
                        if (!discoverySet.contains(childAt) && (a2 = a(childAt, discoverySet)) != null) {
                            gVar.a(a2);
                        }
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
        }
        return gVar;
    }

    private final void b(View rootView, Set<View> tree, JSONArray childElements, JSONArray textsWithElementsInfo) {
        g a2 = a(rootView, tree);
        if (a2 == null) {
            return;
        }
        BuildersKt.runBlocking(o0.f1142a.a(), new c(a2, null));
        a(a2, tree, childElements, textsWithElementsInfo);
    }

    private final void a(g viewNode, Set<View> discoverySet, JSONArray specialElementsJsonArray, JSONArray textsWithElementsInfo) {
        View c2 = viewNode.c();
        if (c2 == null) {
            return;
        }
        a(c2, textsWithElementsInfo);
        JSONObject jSONObject = new JSONObject();
        b(c2, jSONObject);
        if (c2 instanceof ViewGroup) {
            JSONArray jSONArray = new JSONArray();
            Iterator<g> it = viewNode.a().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                g next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                a(next, discoverySet, a(jSONObject, jSONArray, specialElementsJsonArray), textsWithElementsInfo);
            }
            a(jSONArray, jSONObject);
        }
        a(jSONObject, specialElementsJsonArray);
    }

    @Override // sdk.pendo.io.f9.h
    public void a(Set<? extends View> rootViews, JSONArray textsWithElementsInfo, JSONArray childElements) {
        Intrinsics.checkNotNullParameter(rootViews, "rootViews");
        Intrinsics.checkNotNullParameter(textsWithElementsInfo, "textsWithElementsInfo");
        Intrinsics.checkNotNullParameter(childElements, "childElements");
        Iterator<T> it = rootViews.iterator();
        while (it.hasNext()) {
            b((View) it.next(), new LinkedHashSet(), childElements, textsWithElementsInfo);
        }
    }
}
