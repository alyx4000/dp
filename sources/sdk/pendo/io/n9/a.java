package sdk.pendo.io.n9;

import android.content.res.Resources;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.sdk.react.PlatformStateManager;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/n9/a;", "", "Landroid/view/View;", "delegateView", "Lsdk/pendo/io/sdk/react/PlatformStateManager;", "platformManager", "", "a", "", "b", "Ljava/lang/String;", "sTargetViewResourceIdentifierForScreenView", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1445a = new a();

    /* renamed from: b, reason: from kotlin metadata */
    private static String sTargetViewResourceIdentifierForScreenView = "";

    private a() {
    }

    public String a() {
        return sTargetViewResourceIdentifierForScreenView;
    }

    public void a(View delegateView, PlatformStateManager platformManager) {
        Intrinsics.checkNotNullParameter(delegateView, "delegateView");
        Intrinsics.checkNotNullParameter(platformManager, "platformManager");
        if (platformManager.isReactNativeApp()) {
            return;
        }
        try {
            String str = "";
            String resourceEntryName = delegateView.getId() == -1 ? "" : delegateView.getResources().getResourceEntryName(delegateView.getId());
            if (resourceEntryName != null) {
                str = resourceEntryName;
            }
            sTargetViewResourceIdentifierForScreenView = str;
        } catch (Resources.NotFoundException unused) {
        }
    }
}
