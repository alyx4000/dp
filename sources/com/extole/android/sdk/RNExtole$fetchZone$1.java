package com.extole.android.sdk;

import com.extole.android.sdk.impl.ExtoleInternal;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: RNExtole.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/facebook/react/bridge/WritableMap;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.RNExtole$fetchZone$1", f = "RNExtole.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class RNExtole$fetchZone$1 extends SuspendLambda implements Function1<Continuation<? super WritableMap>, Object> {
    final /* synthetic */ ReadableMap $data;
    final /* synthetic */ String $zoneName;
    int label;
    final /* synthetic */ RNExtole this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNExtole$fetchZone$1(RNExtole rNExtole, String str, ReadableMap readableMap, Continuation<? super RNExtole$fetchZone$1> continuation) {
        super(1, continuation);
        this.this$0 = rNExtole;
        this.$zoneName = str;
        this.$data = readableMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RNExtole$fetchZone$1(this.this$0, this.$zoneName, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super WritableMap> continuation) {
        return ((RNExtole$fetchZone$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ExtoleInternal extoleInternal;
        ExtoleInternal extoleInternal2;
        Pair pair;
        Map<String, ? extends Object> recursivelyDeconstructReadableMap;
        Zone zone;
        Campaign campaign;
        Campaign campaign2;
        Id<Campaign> id;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            extoleInternal = this.this$0.extole;
            if (extoleInternal != null) {
                extoleInternal2 = this.this$0.extole;
                if (extoleInternal2 != null) {
                    String str2 = this.$zoneName;
                    recursivelyDeconstructReadableMap = RNExtole.INSTANCE.recursivelyDeconstructReadableMap(this.$data);
                    if (recursivelyDeconstructReadableMap == null) {
                        recursivelyDeconstructReadableMap = MapsKt.emptyMap();
                    }
                    this.label = 1;
                    obj = extoleInternal2.fetchZone(str2, recursivelyDeconstructReadableMap, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    pair = null;
                    String id2 = (pair != null || (campaign2 = (Campaign) pair.getSecond()) == null || (id = campaign2.getId()) == null) ? null : id.getId();
                    if (pair != null && (campaign = (Campaign) pair.getSecond()) != null) {
                        str = campaign.getProgramLabel();
                    }
                    if (pair != null || (zone = (Zone) pair.getFirst()) == null || (r7 = zone.getContent()) == null) {
                        Map<String, Object> emptyMap = MapsKt.emptyMap();
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("zone", emptyMap);
                    linkedHashMap.put("program_label", str);
                    linkedHashMap.put("campaign_id", id2);
                    return RNExtole.INSTANCE.convertJsonToMap(new JSONObject(linkedHashMap));
                }
            } else {
                throw new Exception("Extole is not initialized");
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        pair = (Pair) obj;
        if (pair != null) {
        }
        if (pair != null) {
            str = campaign.getProgramLabel();
        }
        if (pair != null) {
        }
        Map<String, Object> emptyMap2 = MapsKt.emptyMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("zone", emptyMap2);
        linkedHashMap2.put("program_label", str);
        linkedHashMap2.put("campaign_id", id2);
        return RNExtole.INSTANCE.convertJsonToMap(new JSONObject(linkedHashMap2));
    }
}
