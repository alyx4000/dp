package com.extole.android.sdk.impl.app.action;

import com.extole.android.sdk.Action;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeShareAction.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/extole/android/sdk/impl/app/action/NativeShareAction;", "Lcom/extole/android/sdk/Action;", "zone", "", "message", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getMessage", "getZone", "component1", "component2", "component3", "copy", "equals", "", "other", "", "execute", "", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/app/AppEvent;Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShareMessage", "(Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getType", "Lcom/extole/android/sdk/Action$ActionType;", "hashCode", "", "toString", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class NativeShareAction implements Action {

    @SerializedName("image")
    private final String image;

    @SerializedName("message")
    private final String message;

    @SerializedName("zone")
    private final String zone;

    public static /* synthetic */ NativeShareAction copy$default(NativeShareAction nativeShareAction, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nativeShareAction.zone;
        }
        if ((i & 2) != 0) {
            str2 = nativeShareAction.message;
        }
        if ((i & 4) != 0) {
            str3 = nativeShareAction.image;
        }
        return nativeShareAction.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getZone() {
        return this.zone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    public final NativeShareAction copy(String zone, String message, String image) {
        return new NativeShareAction(zone, message, image);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeShareAction)) {
            return false;
        }
        NativeShareAction nativeShareAction = (NativeShareAction) other;
        return Intrinsics.areEqual(this.zone, nativeShareAction.zone) && Intrinsics.areEqual(this.message, nativeShareAction.message) && Intrinsics.areEqual(this.image, nativeShareAction.image);
    }

    public int hashCode() {
        String str = this.zone;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.image;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "NativeShareAction(zone=" + this.zone + ", message=" + this.message + ", image=" + this.image + ')';
    }

    public NativeShareAction(String str, String str2, String str3) {
        this.zone = str;
        this.message = str2;
        this.image = str3;
    }

    @Override // com.extole.android.sdk.Action
    public String getTitle() {
        return Action.DefaultImpls.getTitle(this);
    }

    public final String getZone() {
        return this.zone;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getImage() {
        return this.image;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.extole.android.sdk.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.extole.android.sdk.impl.app.AppEvent r5, com.extole.android.sdk.impl.ExtoleInternal r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r5 = r7 instanceof com.extole.android.sdk.impl.app.action.NativeShareAction$execute$1
            if (r5 == 0) goto L14
            r5 = r7
            com.extole.android.sdk.impl.app.action.NativeShareAction$execute$1 r5 = (com.extole.android.sdk.impl.app.action.NativeShareAction$execute$1) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L14
            int r7 = r5.label
            int r7 = r7 - r1
            r5.label = r7
            goto L19
        L14:
            com.extole.android.sdk.impl.app.action.NativeShareAction$execute$1 r5 = new com.extole.android.sdk.impl.app.action.NativeShareAction$execute$1
            r5.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L46
            if (r1 != r2) goto L3e
            java.lang.Object r6 = r5.L$4
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r5.L$3
            android.content.Intent r0 = (android.content.Intent) r0
            java.lang.Object r1 = r5.L$2
            android.content.Intent r1 = (android.content.Intent) r1
            java.lang.Object r3 = r5.L$1
            android.net.Uri r3 = (android.net.Uri) r3
            java.lang.Object r5 = r5.L$0
            com.extole.android.sdk.impl.ExtoleInternal r5 = (com.extole.android.sdk.impl.ExtoleInternal) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L78
        L3e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L46:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r4.image
            android.net.Uri r3 = android.net.Uri.parse(r7)
            java.lang.String r7 = "parse(image)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            java.lang.String r1 = "android.intent.action.SEND"
            r7.setAction(r1)
            r5.L$0 = r6
            r5.L$1 = r3
            r5.L$2 = r7
            r5.L$3 = r7
            java.lang.String r1 = "android.intent.extra.TEXT"
            r5.L$4 = r1
            r5.label = r2
            java.lang.Object r5 = r4.getShareMessage(r6, r5)
            if (r5 != r0) goto L73
            return r0
        L73:
            r0 = r7
            r7 = r5
            r5 = r6
            r6 = r1
            r1 = r0
        L78:
            java.lang.String r7 = (java.lang.String) r7
            r0.putExtra(r6, r7)
            java.lang.String r6 = "android.intent.extra.STREAM"
            android.os.Parcelable r3 = (android.os.Parcelable) r3
            r1.putExtra(r6, r3)
            java.lang.String r6 = "image/jpeg"
            r1.setType(r6)
            r1.addFlags(r2)
            r6 = 268435456(0x10000000, float:2.524355E-29)
            r1.addFlags(r6)
            java.lang.String r7 = "send"
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            android.content.Intent r7 = android.content.Intent.createChooser(r1, r7)
            r7.addFlags(r6)
            com.extole.android.sdk.impl.ApplicationContext r5 = r5.getContext()
            java.lang.String r6 = "chooser"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            r5.startActivity(r7)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.app.action.NativeShareAction.execute(com.extole.android.sdk.impl.app.AppEvent, com.extole.android.sdk.impl.ExtoleInternal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getShareMessage(com.extole.android.sdk.impl.ExtoleInternal r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.extole.android.sdk.impl.app.action.NativeShareAction$getShareMessage$1
            if (r0 == 0) goto L14
            r0 = r7
            com.extole.android.sdk.impl.app.action.NativeShareAction$getShareMessage$1 r0 = (com.extole.android.sdk.impl.app.action.NativeShareAction$getShareMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.extole.android.sdk.impl.app.action.NativeShareAction$getShareMessage$1 r0 = new com.extole.android.sdk.impl.app.action.NativeShareAction$getShareMessage$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            com.extole.android.sdk.impl.app.action.NativeShareAction r6 = (com.extole.android.sdk.impl.app.action.NativeShareAction) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L63
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r5.message
            if (r7 != 0) goto L7a
            java.lang.String r2 = r5.zone
            if (r2 == 0) goto L7a
            com.extole.android.sdk.ExtoleServices r7 = r6.getServices()
            com.extole.android.sdk.ZoneService r7 = r7.getZoneService()
            java.lang.String r2 = r5.zone
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r2)
            java.util.Map r4 = r6.getData()
            java.util.Set r6 = r6.getLabels()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r7.getZones(r2, r4, r6, r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            r6 = r5
        L63:
            com.extole.android.sdk.impl.Zones r7 = (com.extole.android.sdk.impl.Zones) r7
            java.lang.String r6 = r6.zone
            com.extole.android.sdk.Zone r6 = r7.get(r6)
            if (r6 == 0) goto L74
            java.lang.String r7 = "message"
            java.lang.Object r6 = r6.get(r7)
            goto L75
        L74:
            r6 = 0
        L75:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            return r6
        L7a:
            if (r7 != 0) goto L7e
            java.lang.String r7 = ""
        L7e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.app.action.NativeShareAction.getShareMessage(com.extole.android.sdk.impl.ExtoleInternal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.extole.android.sdk.Action
    public Action.ActionType getType() {
        return Action.ActionType.NATIVE_SHARE;
    }
}
