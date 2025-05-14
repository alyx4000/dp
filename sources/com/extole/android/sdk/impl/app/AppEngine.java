package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.Operation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppEngine.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/extole/android/sdk/impl/app/AppEngine;", "", "operations", "", "Lcom/extole/android/sdk/Operation;", "(Ljava/util/List;)V", "execute", "", "appEvent", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/app/AppEvent;Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppEngine {
    private final List<Operation> operations;

    /* JADX WARN: Multi-variable type inference failed */
    public AppEngine(List<? extends Operation> operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        this.operations = operations;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute(com.extole.android.sdk.impl.app.AppEvent r9, com.extole.android.sdk.impl.ExtoleInternal r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.extole.android.sdk.impl.app.AppEngine$execute$1
            if (r0 == 0) goto L14
            r0 = r11
            com.extole.android.sdk.impl.app.AppEngine$execute$1 r0 = (com.extole.android.sdk.impl.app.AppEngine$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.extole.android.sdk.impl.app.AppEngine$execute$1 r0 = new com.extole.android.sdk.impl.app.AppEngine$execute$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$1
            com.extole.android.sdk.impl.ExtoleInternal r10 = (com.extole.android.sdk.impl.ExtoleInternal) r10
            java.lang.Object r2 = r0.L$0
            com.extole.android.sdk.impl.app.AppEvent r2 = (com.extole.android.sdk.impl.app.AppEvent) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r10 = r2
            goto L4f
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L40:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List<com.extole.android.sdk.Operation> r11 = r8.operations
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r7 = r10
            r10 = r9
            r9 = r11
            r11 = r7
        L4f:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L83
            java.lang.Object r2 = r9.next()
            com.extole.android.sdk.Operation r2 = (com.extole.android.sdk.Operation) r2
            com.extole.android.sdk.ExtoleLogger r4 = r11.getLogger()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Executing operation: "
            r5.<init>(r6)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r4.debug(r5, r6)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r2 = r2.executeActions(r10, r11, r0)
            if (r2 != r1) goto L4f
            return r1
        L83:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.app.AppEngine.execute(com.extole.android.sdk.impl.app.AppEvent, com.extole.android.sdk.impl.ExtoleInternal, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
