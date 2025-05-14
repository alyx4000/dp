package com.extole.android.sdk.impl;

import com.extole.android.sdk.Zone;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* compiled from: ZoneServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/extole/android/sdk/impl/Zones;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.ZoneServiceImpl$getZones$2", f = "ZoneServiceImpl.kt", i = {0}, l = {34}, m = "invokeSuspend", n = {"prefetchedResponses"}, s = {"L$0"})
/* loaded from: classes.dex */
final class ZoneServiceImpl$getZones$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Zones>, Object> {
    final /* synthetic */ Map<String, Object> $data;
    final /* synthetic */ Set<String> $programLabels;
    final /* synthetic */ Set<String> $zonesName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZoneServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ZoneServiceImpl$getZones$2(Set<String> set, Map<String, ? extends Object> map, Set<String> set2, ZoneServiceImpl zoneServiceImpl, Continuation<? super ZoneServiceImpl$getZones$2> continuation) {
        super(2, continuation);
        this.$programLabels = set;
        this.$data = map;
        this.$zonesName = set2;
        this.this$0 = zoneServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZoneServiceImpl$getZones$2 zoneServiceImpl$getZones$2 = new ZoneServiceImpl$getZones$2(this.$programLabels, this.$data, this.$zonesName, this.this$0, continuation);
        zoneServiceImpl$getZones$2.L$0 = obj;
        return zoneServiceImpl$getZones$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Zones> continuation) {
        return ((ZoneServiceImpl$getZones$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map map;
        Deferred async$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String joinToString$default = CollectionsKt.joinToString$default(this.$programLabels, ",", null, null, 0, null, null, 62, null);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.putAll(this.$data);
            linkedHashMap2.put("labels", joinToString$default);
            Set<String> set = this.$zonesName;
            ZoneServiceImpl zoneServiceImpl = this.this$0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZoneServiceImpl$getZones$2$zoneResponses$1$1(zoneServiceImpl, (String) it.next(), linkedHashMap2, null), 3, null);
                arrayList.add(async$default);
            }
            this.L$0 = linkedHashMap;
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            map = linkedHashMap;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        for (Zone zone : (List) obj) {
            map.put(new ZoneResponseKey(zone.getName()), zone);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        return new Zones(MapsKt.toMutableMap(linkedHashMap3));
    }
}
