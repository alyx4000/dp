package sdk.pendo.io.e6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public enum b implements sdk.pendo.io.b6.b {
    DISPOSED;

    public static boolean a(AtomicReference<sdk.pendo.io.b6.b> atomicReference) {
        sdk.pendo.io.b6.b andSet;
        sdk.pendo.io.b6.b bVar = atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar == bVar2 || (andSet = atomicReference.getAndSet(bVar2)) == bVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static void b() {
        sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.e("Disposable already set!"));
    }

    public static boolean c(AtomicReference<sdk.pendo.io.b6.b> atomicReference, sdk.pendo.io.b6.b bVar) {
        sdk.pendo.io.f6.b.a(bVar, "d is null");
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        b();
        return false;
    }

    public static boolean d(AtomicReference<sdk.pendo.io.b6.b> atomicReference, sdk.pendo.io.b6.b bVar) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, bVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        bVar.dispose();
        return false;
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return true;
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
    }

    public static boolean b(AtomicReference<sdk.pendo.io.b6.b> atomicReference, sdk.pendo.io.b6.b bVar) {
        sdk.pendo.io.b6.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }

    public static boolean a(sdk.pendo.io.b6.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean a(AtomicReference<sdk.pendo.io.b6.b> atomicReference, sdk.pendo.io.b6.b bVar) {
        sdk.pendo.io.b6.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, bVar2, bVar));
        return true;
    }

    public static boolean a(sdk.pendo.io.b6.b bVar, sdk.pendo.io.b6.b bVar2) {
        if (bVar2 == null) {
            sdk.pendo.io.t6.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        b();
        return false;
    }
}
