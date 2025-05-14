package sdk.pendo.io.q6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class f {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> cls) {
        sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.e(a(cls.getName())));
    }

    public static boolean a(AtomicReference<sdk.pendo.io.b6.b> atomicReference, sdk.pendo.io.b6.b bVar, Class<?> cls) {
        sdk.pendo.io.f6.b.a(bVar, "next is null");
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == sdk.pendo.io.e6.b.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }
}
