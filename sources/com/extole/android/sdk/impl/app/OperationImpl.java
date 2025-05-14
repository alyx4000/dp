package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.Action;
import com.extole.android.sdk.Condition;
import com.extole.android.sdk.Operation;
import com.extole.android.sdk.impl.ExtoleInternal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OperationImpl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/extole/android/sdk/impl/app/OperationImpl;", "Lcom/extole/android/sdk/Operation;", "conditions", "", "Lcom/extole/android/sdk/Condition;", "actions", "Lcom/extole/android/sdk/Action;", "(Ljava/util/List;Ljava/util/List;)V", "actionsToExecute", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "executeActions", "", "(Lcom/extole/android/sdk/impl/app/AppEvent;Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActions", "getConditions", "passingConditions", "toString", "", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OperationImpl implements Operation {
    private final List<Action> actions;
    private final List<Condition> conditions;

    /* JADX WARN: Multi-variable type inference failed */
    public OperationImpl(List<? extends Condition> conditions, List<? extends Action> actions) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.conditions = conditions;
        this.actions = actions;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0095 -> B:10:0x0097). Please report as a decompilation issue!!! */
    @Override // com.extole.android.sdk.Operation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object executeActions(com.extole.android.sdk.impl.app.AppEvent r10, com.extole.android.sdk.impl.ExtoleInternal r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.extole.android.sdk.impl.app.OperationImpl$executeActions$1
            if (r0 == 0) goto L14
            r0 = r12
            com.extole.android.sdk.impl.app.OperationImpl$executeActions$1 r0 = (com.extole.android.sdk.impl.app.OperationImpl$executeActions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.extole.android.sdk.impl.app.OperationImpl$executeActions$1 r0 = new com.extole.android.sdk.impl.app.OperationImpl$executeActions$1
            r0.<init>(r9, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r10 = r0.L$2
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r0.L$1
            com.extole.android.sdk.impl.ExtoleInternal r11 = (com.extole.android.sdk.impl.ExtoleInternal) r11
            java.lang.Object r2 = r0.L$0
            com.extole.android.sdk.impl.app.AppEvent r2 = (com.extole.android.sdk.impl.app.AppEvent) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L97
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.List r12 = r9.actionsToExecute(r10, r11)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
            r8 = r11
            r11 = r10
            r10 = r12
            r12 = r8
        L4f:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto Lbd
            java.lang.Object r2 = r10.next()
            com.extole.android.sdk.Action r2 = (com.extole.android.sdk.Action) r2
            java.util.Set r4 = r12.getDisabledActions()
            com.extole.android.sdk.Action$ActionType r5 = r2.getType()
            boolean r4 = r4.contains(r5)
            r5 = 0
            if (r4 != 0) goto L9a
            com.extole.android.sdk.ExtoleLogger r4 = r12.getLogger()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Executing action "
            r6.<init>(r7)
            java.lang.String r7 = r2.getTitle()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r4.debug(r6, r5)
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r2 = r2.execute(r11, r12, r0)
            if (r2 != r1) goto L95
            return r1
        L95:
            r2 = r11
            r11 = r12
        L97:
            r12 = r11
            r11 = r2
            goto L4f
        L9a:
            com.extole.android.sdk.ExtoleLogger r4 = r12.getLogger()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Skipping "
            r6.<init>(r7)
            com.extole.android.sdk.Action$ActionType r2 = r2.getType()
            java.lang.StringBuilder r2 = r6.append(r2)
            java.lang.String r6 = " because it is disabled"
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r4.debug(r2, r5)
            goto L4f
        Lbd:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.app.OperationImpl.executeActions(com.extole.android.sdk.impl.app.AppEvent, com.extole.android.sdk.impl.ExtoleInternal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.extole.android.sdk.Operation
    public List<Condition> passingConditions(AppEvent event, ExtoleInternal extole) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extole, "extole");
        List<Condition> list = this.conditions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Condition) obj).passes(event, extole)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.extole.android.sdk.Operation
    public List<Action> actionsToExecute(AppEvent event, ExtoleInternal extole) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extole, "extole");
        if (passingConditions(event, extole).size() == this.conditions.size()) {
            return this.actions;
        }
        return CollectionsKt.emptyList();
    }

    @Override // com.extole.android.sdk.Operation
    public List<Action> getActions() {
        return this.actions;
    }

    @Override // com.extole.android.sdk.Operation
    public List<Condition> getConditions() {
        return this.conditions;
    }

    public String toString() {
        return "Operation Conditions: " + this.conditions + ", Actions: " + this.actions;
    }
}
