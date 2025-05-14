package com.extole.android.sdk.impl.app.condition;

import com.extole.android.sdk.Condition;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventCondition.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/extole/android/sdk/impl/app/condition/EventCondition;", "Lcom/extole/android/sdk/Condition;", "eventNames", "", "", "hasDataKeys", "", "hasDataValues", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Set;)V", "getEventNames", "()Ljava/util/List;", "getHasDataKeys", "()Ljava/util/Set;", "getHasDataValues", "getType", "Lcom/extole/android/sdk/Condition$ConditionType;", "passes", "", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "toString", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EventCondition implements Condition {

    @SerializedName("event_names")
    private final List<String> eventNames;

    @SerializedName("has_data_keys")
    private final Set<String> hasDataKeys;

    @SerializedName("has_data_values")
    private final Set<String> hasDataValues;

    public EventCondition(List<String> eventNames, Set<String> set, Set<String> set2) {
        Intrinsics.checkNotNullParameter(eventNames, "eventNames");
        this.eventNames = eventNames;
        this.hasDataKeys = set;
        this.hasDataValues = set2;
    }

    @Override // com.extole.android.sdk.Condition
    public String getTitle() {
        return Condition.DefaultImpls.getTitle(this);
    }

    public final List<String> getEventNames() {
        return this.eventNames;
    }

    public /* synthetic */ EventCondition(List list, Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? SetsKt.emptySet() : set2);
    }

    public final Set<String> getHasDataKeys() {
        return this.hasDataKeys;
    }

    public final Set<String> getHasDataValues() {
        return this.hasDataValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    @Override // com.extole.android.sdk.Condition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean passes(com.extole.android.sdk.impl.app.AppEvent r10, com.extole.android.sdk.impl.ExtoleInternal r11) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.app.condition.EventCondition.passes(com.extole.android.sdk.impl.app.AppEvent, com.extole.android.sdk.impl.ExtoleInternal):boolean");
    }

    @Override // com.extole.android.sdk.Condition
    public Condition.ConditionType getType() {
        return Condition.ConditionType.EVENT;
    }

    public String toString() {
        return "ConditionType: " + getType() + ", eventNames: " + this.eventNames;
    }
}
