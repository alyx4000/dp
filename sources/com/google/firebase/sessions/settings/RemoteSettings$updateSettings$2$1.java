package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* compiled from: RemoteSettings.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {0, 0, 0, 1, 1, 2}, l = {125, 128, 131, 133, 134, 136}, m = "invokeSuspend", n = {"sessionSamplingRate", "sessionTimeoutSeconds", "cacheDuration", "sessionSamplingRate", "cacheDuration", "cacheDuration"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* loaded from: classes5.dex */
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4  */
    /* JADX WARN: Type inference failed for: r13v13, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Double] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
