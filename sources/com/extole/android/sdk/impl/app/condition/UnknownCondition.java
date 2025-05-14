package com.extole.android.sdk.impl.app.condition;

import com.extole.android.sdk.Condition;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.app.AppEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnknownCondition.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/extole/android/sdk/impl/app/condition/UnknownCondition;", "Lcom/extole/android/sdk/Condition;", "()V", "getType", "Lcom/extole/android/sdk/Condition$ConditionType;", "passes", "", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UnknownCondition implements Condition {
    @Override // com.extole.android.sdk.Condition
    public boolean passes(AppEvent event, ExtoleInternal extole) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extole, "extole");
        return false;
    }

    @Override // com.extole.android.sdk.Condition
    public String getTitle() {
        return Condition.DefaultImpls.getTitle(this);
    }

    @Override // com.extole.android.sdk.Condition
    public Condition.ConditionType getType() {
        return Condition.ConditionType.CUSTOM;
    }
}
