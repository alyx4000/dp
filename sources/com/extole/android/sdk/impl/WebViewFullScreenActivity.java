package com.extole.android.sdk.impl;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.extole.mobile.sdk.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;

/* compiled from: WebViewFullScreenActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/extole/android/sdk/impl/WebViewFullScreenActivity;", "Landroid/app/Activity;", "()V", "webView", "Landroid/webkit/WebView;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WebViewFullScreenActivity extends Activity {
    private WebView webView;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com_extole_activity_webview);
        Bundle extras = getIntent().getExtras();
        Intrinsics.checkNotNull(extras);
        String string = extras.getString("extole_zone_name");
        if (string == null) {
            string = "";
        }
        Set<String> keySet = extras.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "extras.keySet()");
        ArrayList arrayList = new ArrayList();
        for (String str : keySet) {
            Pair pair = TuplesKt.to(str, extras.getString(str));
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        ArrayList<Pair> arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Pair pair2 : arrayList2) {
            Object first = pair2.getFirst();
            Intrinsics.checkNotNull(first);
            Object second = pair2.getSecond();
            Intrinsics.checkNotNull(second);
            linkedHashMap.put((String) first, (String) second);
        }
        WebView webView = (WebView) findViewById(R.id.webview);
        this.webView = webView;
        if (webView != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new WebViewFullScreenActivity$onCreate$1$1(this, linkedHashMap, string, null), 3, null);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView = this.webView;
        boolean z = false;
        if (webView != null && webView.canGoBack()) {
            z = true;
        }
        if (z) {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.goBack();
                return;
            }
            return;
        }
        finish();
    }
}
