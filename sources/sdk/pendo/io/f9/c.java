package sdk.pendo.io.f9;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.g9.c0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007J2\u0010\t\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/f9/c;", "Lsdk/pendo/io/f9/b;", "Landroid/app/Activity;", "activity", "", "isIgnoreDynamicFragmentsInScrollView", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/d;", "Lkotlin/collections/ArrayList;", "a", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lsdk/pendo/io/f9/g;", "pendoFragmentNode", "", "fragmentList", "", "hierarchyLevel", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class c extends b {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FragmentHelperSynchronizedScan$collectAllVisibleFragmentsInfo$1", f = "FragmentHelperSynchronizedScan.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g A;
        int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g gVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.A = gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c.this.a(this.A);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0019 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(androidx.fragment.app.FragmentManager r4, boolean r5, sdk.pendo.io.f9.g r6) {
        /*
            r3 = this;
            java.lang.String r0 = "pendoFragmentNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            if (r4 == 0) goto L4e
            java.util.List r4 = r4.getFragments()
            java.lang.String r1 = "getFragments(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.util.List r4 = kotlin.collections.CollectionsKt.filterNotNull(r4)
            java.util.Iterator r4 = r4.iterator()
        L19:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L6a
            java.lang.Object r1 = r4.next()
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            if (r5 == 0) goto L3b
            android.view.View r2 = r1.getView()
            if (r2 == 0) goto L32
            android.view.ViewParent r2 = r2.getParent()
            goto L33
        L32:
            r2 = 0
        L33:
            boolean r2 = r3.a(r2)
            if (r2 == 0) goto L3b
            r2 = 1
            goto L3c
        L3b:
            r2 = r0
        L3c:
            if (r2 != 0) goto L19
            sdk.pendo.io.f9.g r2 = new sdk.pendo.io.f9.g
            r2.<init>(r1)
            androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
            r3.a(r1, r5, r2)
            r6.a(r2)
            goto L19
        L4e:
            java.lang.Class r4 = r3.a()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = ".buildPendoFragmentNodeTree, fragment manager is null"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r0]
            sdk.pendo.io.logging.PendoLogger.e(r4, r5)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.c.a(androidx.fragment.app.FragmentManager, boolean, sdk.pendo.io.f9.g):void");
    }

    @Override // sdk.pendo.io.f9.b
    public ArrayList<d> a(Activity activity, boolean isIgnoreDynamicFragmentsInScrollView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ArrayList<d> arrayList = new ArrayList<>();
        if (activity instanceof FragmentActivity) {
            g gVar = new g();
            a(((FragmentActivity) activity).getSupportFragmentManager(), isIgnoreDynamicFragmentsInScrollView, gVar);
            BuildersKt.runBlocking(o0.f1142a.a(), new a(gVar, null));
            a(this, arrayList, gVar, 0, 4, null);
        } else {
            PendoLogger.d(a() + " collectAllVisibleFragmentsInfo, activity is not FragmentActivity", new Object[0]);
        }
        return arrayList;
    }

    public final void a(ArrayList<d> fragmentList, g pendoFragmentNode, int hierarchyLevel) {
        Intrinsics.checkNotNullParameter(fragmentList, "fragmentList");
        Intrinsics.checkNotNullParameter(pendoFragmentNode, "pendoFragmentNode");
        Iterator<g> it = pendoFragmentNode.a().iterator();
        while (it.hasNext()) {
            g next = it.next();
            Fragment b = next.b();
            if (b != null) {
                String simpleName = b.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                View view = b.getView();
                fragmentList.add(new d(simpleName, hierarchyLevel, view != null ? view.hashCode() : -1));
                Intrinsics.checkNotNull(next);
                a(fragmentList, next, hierarchyLevel + 1);
            }
        }
    }

    public static /* synthetic */ void a(c cVar, ArrayList arrayList, g gVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        cVar.a((ArrayList<d>) arrayList, gVar, i);
    }

    public final void a(g pendoFragmentNode) {
        Intrinsics.checkNotNullParameter(pendoFragmentNode, "pendoFragmentNode");
        Iterator<g> it = pendoFragmentNode.a().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            g next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            g gVar = next;
            Fragment b = gVar.b();
            if (b != null) {
                if (c0.a(b)) {
                    a(gVar);
                } else {
                    it.remove();
                }
            }
        }
    }
}
