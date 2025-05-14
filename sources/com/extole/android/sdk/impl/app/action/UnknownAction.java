package com.extole.android.sdk.impl.app.action;

import android.util.Log;
import com.extole.android.sdk.Action;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.app.AppEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: UnknownAction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/extole/android/sdk/impl/app/action/UnknownAction;", "Lcom/extole/android/sdk/Action;", "()V", "execute", "", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/app/AppEvent;Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getType", "Lcom/extole/android/sdk/Action$ActionType;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UnknownAction implements Action {
    @Override // com.extole.android.sdk.Action
    public String getTitle() {
        return Action.DefaultImpls.getTitle(this);
    }

    @Override // com.extole.android.sdk.Action
    public Object execute(AppEvent appEvent, ExtoleInternal extoleInternal, Continuation<? super Unit> continuation) {
        Log.d("Extole", "UnknownAction executed");
        return Unit.INSTANCE;
    }

    @Override // com.extole.android.sdk.Action
    public Action.ActionType getType() {
        return Action.ActionType.CUSTOM;
    }
}
