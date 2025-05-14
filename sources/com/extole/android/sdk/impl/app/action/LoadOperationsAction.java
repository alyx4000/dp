package com.extole.android.sdk.impl.app.action;

import android.os.Build;
import android.provider.Settings;
import com.amplitude.reactnative.AmplitudeReactNativeModule;
import com.extole.android.sdk.Action;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.app.AppEvent;
import com.google.gson.annotations.SerializedName;
import io.sentry.protocol.OperatingSystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: LoadOperationsAction.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0004H\u0016R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/extole/android/sdk/impl/app/action/LoadOperationsAction;", "Lcom/extole/android/sdk/Action;", "zones", "", "", "data", "", "(Ljava/util/List;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "getZones", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "execute", "", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/app/AppEvent;Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getType", "Lcom/extole/android/sdk/Action$ActionType;", "hashCode", "", "prepareRequestData", "", "removeExecutedActionsFromQueue", "toString", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LoadOperationsAction implements Action {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashSet<LoadOperationsAction> loadOperationActions = new HashSet<>();

    @SerializedName("data")
    private final Map<String, String> data;

    @SerializedName("zones")
    private final List<String> zones;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoadOperationsAction copy$default(LoadOperationsAction loadOperationsAction, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = loadOperationsAction.zones;
        }
        if ((i & 2) != 0) {
            map = loadOperationsAction.data;
        }
        return loadOperationsAction.copy(list, map);
    }

    public final List<String> component1() {
        return this.zones;
    }

    public final Map<String, String> component2() {
        return this.data;
    }

    public final LoadOperationsAction copy(List<String> zones, Map<String, String> data) {
        Intrinsics.checkNotNullParameter(zones, "zones");
        return new LoadOperationsAction(zones, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadOperationsAction)) {
            return false;
        }
        LoadOperationsAction loadOperationsAction = (LoadOperationsAction) other;
        return Intrinsics.areEqual(this.zones, loadOperationsAction.zones) && Intrinsics.areEqual(this.data, loadOperationsAction.data);
    }

    public int hashCode() {
        int hashCode = this.zones.hashCode() * 31;
        Map<String, String> map = this.data;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public LoadOperationsAction(List<String> zones, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(zones, "zones");
        this.zones = zones;
        this.data = map;
    }

    @Override // com.extole.android.sdk.Action
    public String getTitle() {
        return Action.DefaultImpls.getTitle(this);
    }

    public final List<String> getZones() {
        return this.zones;
    }

    public /* synthetic */ LoadOperationsAction(List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    /* compiled from: LoadOperationsAction.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/extole/android/sdk/impl/app/action/LoadOperationsAction$Companion;", "", "()V", "loadOperationActions", "Ljava/util/HashSet;", "Lcom/extole/android/sdk/impl/app/action/LoadOperationsAction;", "Lkotlin/collections/HashSet;", "getLoadOperationActions", "()Ljava/util/HashSet;", "setLoadOperationActions", "(Ljava/util/HashSet;)V", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HashSet<LoadOperationsAction> getLoadOperationActions() {
            return LoadOperationsAction.loadOperationActions;
        }

        public final void setLoadOperationActions(HashSet<LoadOperationsAction> hashSet) {
            Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
            LoadOperationsAction.loadOperationActions = hashSet;
        }
    }

    @Override // com.extole.android.sdk.Action
    public Object execute(AppEvent appEvent, ExtoleInternal extoleInternal, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LoadOperationsAction$execute$2(this, extoleInternal, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> prepareRequestData(ExtoleInternal extole) {
        String deviceId = Settings.Secure.getString(extole.getContext().getContext().getContentResolver(), "android_id");
        Map<String, String> mutableMap = MapsKt.toMutableMap(extole.getData());
        Map<String, String> map = this.data;
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        mutableMap.putAll(map);
        Intrinsics.checkNotNullExpressionValue(deviceId, "deviceId");
        mutableMap.put(AmplitudeReactNativeModule.DEVICE_ID_KEY, deviceId);
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        mutableMap.put(OperatingSystem.TYPE, RELEASE);
        return mutableMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeExecutedActionsFromQueue() {
        HashSet<LoadOperationsAction> hashSet = loadOperationActions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : hashSet) {
            if (((LoadOperationsAction) obj).zones.containsAll(this.zones)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            loadOperationActions.remove((LoadOperationsAction) it.next());
        }
    }

    @Override // com.extole.android.sdk.Action
    public Action.ActionType getType() {
        return Action.ActionType.LOAD_OPERATIONS;
    }

    public String toString() {
        return "Action: " + getType() + ", zones: " + this.zones;
    }
}
