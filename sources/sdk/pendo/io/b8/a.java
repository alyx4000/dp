package sdk.pendo.io.b8;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.sdk.react.PlatformStateManager;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0005B3\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/b8/a;", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;", "Landroid/view/View;", "view", "", "a", "Landroid/os/Bundle;", "arguments", "", "perform", "Lsdk/pendo/io/e9/a;", "Lsdk/pendo/io/e9/a;", "analyticsManager", "Lsdk/pendo/io/actions/ActivationManager;", "b", "Lsdk/pendo/io/actions/ActivationManager;", "activationManager", "c", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;", "originalCustomAction", "", "label", "", "actionId", "<init>", "(Lsdk/pendo/io/e9/a;Lsdk/pendo/io/actions/ActivationManager;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;Ljava/lang/CharSequence;I)V", "d", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a extends AccessibilityNodeInfoCompat.AccessibilityActionCompat {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.e9.a analyticsManager;

    /* renamed from: b, reason: from kotlin metadata */
    private final ActivationManager activationManager;

    /* renamed from: c, reason: from kotlin metadata */
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat originalCustomAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(sdk.pendo.io.e9.a analyticsManager, ActivationManager activationManager, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, int i) {
        super(i, charSequence);
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(activationManager, "activationManager");
        this.analyticsManager = analyticsManager;
        this.activationManager = activationManager;
        this.originalCustomAction = accessibilityActionCompat;
    }

    private final void a(View view) {
        try {
            JSONObject b = o0.f1142a.b(view);
            sdk.pendo.io.n9.a.f1445a.a(view, PlatformStateManager.INSTANCE);
            this.analyticsManager.a(b, false);
            boolean z = c.g().f() != null;
            PendoLogger.d("Clicked view: " + view, new Object[0]);
            if (z) {
                ActivationManager.handleClick$default(this.activationManager, b, null, 2, null);
            }
        } catch (Exception e) {
            PendoLogger.e("PendoAccessibilityAction createClickAnalyticAndCheckForGuides failed " + e.getMessage(), e);
        }
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat
    public boolean perform(View view, Bundle arguments) {
        if (view != null) {
            a(view);
        }
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = this.originalCustomAction;
        if (accessibilityActionCompat != null) {
            return accessibilityActionCompat.perform(view, arguments);
        }
        return false;
    }
}
