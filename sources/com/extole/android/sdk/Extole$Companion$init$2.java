package com.extole.android.sdk;

import android.content.Context;
import com.extole.android.sdk.Action;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.app.App;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Extole.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.Extole$Companion$init$2", f = "Extole.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class Extole$Companion$init$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ExtoleInternal>, Object> {
    final /* synthetic */ List<ProtocolHandler> $additionalProtocolHandlers;
    final /* synthetic */ Map<String, String> $appData;
    final /* synthetic */ Map<String, String> $appHeaders;
    final /* synthetic */ String $appName;
    final /* synthetic */ Function2<App, Map<String, ? extends Object>, List<Operation>> $configurationLoader;
    final /* synthetic */ Context $context;
    final /* synthetic */ Map<String, String> $data;
    final /* synthetic */ Set<Action.ActionType> $disabledActions;
    final /* synthetic */ String $email;
    final /* synthetic */ String $jwt;
    final /* synthetic */ Set<String> $labels;
    final /* synthetic */ boolean $listenToEvents;
    final /* synthetic */ String $programDomain;
    final /* synthetic */ String $sandbox;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Extole$Companion$init$2(String str, String str2, String str3, Context context, Set<String> set, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, String str4, boolean z, Function2<? super App, ? super Map<String, ? extends Object>, ? extends List<? extends Operation>> function2, List<? extends ProtocolHandler> list, Set<? extends Action.ActionType> set2, String str5, Continuation<? super Extole$Companion$init$2> continuation) {
        super(2, continuation);
        this.$programDomain = str;
        this.$appName = str2;
        this.$sandbox = str3;
        this.$context = context;
        this.$labels = set;
        this.$data = map;
        this.$appData = map2;
        this.$appHeaders = map3;
        this.$email = str4;
        this.$listenToEvents = z;
        this.$configurationLoader = function2;
        this.$additionalProtocolHandlers = list;
        this.$disabledActions = set2;
        this.$jwt = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Extole$Companion$init$2(this.$programDomain, this.$appName, this.$sandbox, this.$context, this.$labels, this.$data, this.$appData, this.$appHeaders, this.$email, this.$listenToEvents, this.$configurationLoader, this.$additionalProtocolHandlers, this.$disabledActions, this.$jwt, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ExtoleInternal> continuation) {
        return ((Extole$Companion$init$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ExtoleInternal.INSTANCE.init(this.$programDomain, this.$appName, this.$sandbox, this.$context, this.$labels, this.$data, this.$appData, this.$appHeaders, this.$email, this.$listenToEvents, this.$configurationLoader, this.$additionalProtocolHandlers, this.$disabledActions, this.$jwt);
    }
}
