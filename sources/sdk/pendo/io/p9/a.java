package sdk.pendo.io.p9;

import android.view.TouchDelegate;
import android.view.View;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.views.custom.PendoBackCapture;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\f\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u0000\"7\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u000b8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroid/view/View;", "", "c", "Lsdk/pendo/io/views/custom/PendoBackCapture;", "pendoBackCapture", "", "a", "Landroid/view/View$OnKeyListener;", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getOriginalListeners", "()Ljava/util/HashMap;", "originalListeners", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, View.OnKeyListener> f1505a = new HashMap<>();

    public static final boolean a(View view, PendoBackCapture pendoBackCapture) {
        if (view == null) {
            return false;
        }
        if (view instanceof PendoBackCapture) {
            return true;
        }
        View.OnKeyListener a2 = a(view);
        if (a2 instanceof sdk.pendo.io.q9.a) {
            return true;
        }
        f1505a.put(Integer.valueOf(view.hashCode()), a2);
        view.setOnKeyListener(new sdk.pendo.io.q9.a(a2, pendoBackCapture));
        return true;
    }

    public static final boolean b(View view) {
        TouchDelegate touchDelegate = view != null ? view.getTouchDelegate() : null;
        if (touchDelegate == null || !(touchDelegate instanceof PendoTouchDelegate)) {
            return false;
        }
        PendoTouchDelegate pendoTouchDelegate = (PendoTouchDelegate) touchDelegate;
        if (pendoTouchDelegate.getOnTouchEventHandlerState() == PendoTouchDelegate.OnTouchEventState.PENDO_TOUCH_DELEGATE) {
            return true;
        }
        pendoTouchDelegate.a(PendoTouchDelegate.OnTouchEventState.EXTERNAL_API);
        return false;
    }

    public static final void c(View view) {
        if (view == null || (view instanceof PendoBackCapture)) {
            return;
        }
        view.setOnKeyListener(f1505a.remove(Integer.valueOf(view.hashCode())));
    }

    public static final View.OnKeyListener a(View view) {
        Field declaredField;
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            Field declaredField2 = View.class.getDeclaredField("mListenerInfo");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = obj.getClass().getDeclaredField("mOnKeyListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View.OnKeyListener");
            return (View.OnKeyListener) obj2;
        } catch (Exception unused) {
            return null;
        }
    }
}
