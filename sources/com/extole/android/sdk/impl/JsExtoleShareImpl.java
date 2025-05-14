package com.extole.android.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import com.extole.android.sdk.JsExtoleShare;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsExtoleShareImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012:\b\u0002\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0017R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/extole/android/sdk/impl/JsExtoleShareImpl;", "Lcom/extole/android/sdk/JsExtoleShare;", "context", "Landroid/content/Context;", "partnerShareId", "", "intentScopeExtender", "Lkotlin/Function2;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "title", "afterShare", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "defaultShareIntentCreator", "shareText", "share", "jsonData", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsExtoleShareImpl implements JsExtoleShare {
    private final Function0<Unit> afterShare;
    private final Context context;
    private final Function2<Intent, String, Intent> intentScopeExtender;
    private final String partnerShareId;

    /* JADX WARN: Multi-variable type inference failed */
    public JsExtoleShareImpl(Context context, String str, Function2<? super Intent, ? super String, ? extends Intent> intentScopeExtender, Function0<Unit> afterShare) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentScopeExtender, "intentScopeExtender");
        Intrinsics.checkNotNullParameter(afterShare, "afterShare");
        this.context = context;
        this.partnerShareId = str;
        this.intentScopeExtender = intentScopeExtender;
        this.afterShare = afterShare;
    }

    public /* synthetic */ JsExtoleShareImpl(Context context, String str, AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? new Function2<Intent, String, Intent>() { // from class: com.extole.android.sdk.impl.JsExtoleShareImpl.1
            @Override // kotlin.jvm.functions.Function2
            public final Intent invoke(Intent intent, String str2) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return intent;
            }
        } : anonymousClass1, (i & 8) != 0 ? new Function0<Unit>() { // from class: com.extole.android.sdk.impl.JsExtoleShareImpl.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass2);
    }

    @Override // com.extole.android.sdk.JsExtoleShare
    @JavascriptInterface
    public void share(String jsonData) {
        if (jsonData == null) {
            jsonData = "";
        }
        JSONObject jSONObject = new JSONObject(jsonData);
        Uri build = Uri.parse(jSONObject.getString("url")).buildUpon().appendQueryParameter("partner_share_id", this.partnerShareId).build();
        String string = jSONObject.getString("title");
        Intent invoke = this.intentScopeExtender.invoke(defaultShareIntentCreator(string, jSONObject.getString("text") + ' ' + build), string);
        invoke.addFlags(268435456);
        this.context.startActivity(invoke);
        this.afterShare.invoke();
    }

    private final Intent defaultShareIntentCreator(String title, String shareText) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", title);
        intent.putExtra("android.intent.extra.TEXT", shareText);
        intent.addFlags(268435456);
        return intent;
    }
}
