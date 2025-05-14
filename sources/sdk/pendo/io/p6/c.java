package sdk.pendo.io.p6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.c6.e;
import sdk.pendo.io.q6.d;

/* loaded from: classes6.dex */
public enum c implements sdk.pendo.io.w5.c {
    CANCELLED;

    public static boolean a(AtomicReference<sdk.pendo.io.w5.c> atomicReference) {
        sdk.pendo.io.w5.c andSet;
        sdk.pendo.io.w5.c cVar = atomicReference.get();
        c cVar2 = CANCELLED;
        if (cVar == cVar2 || (andSet = atomicReference.getAndSet(cVar2)) == cVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void b(long j) {
        sdk.pendo.io.t6.a.b(new e("More produced than requested: " + j));
    }

    public static boolean c(long j) {
        if (j > 0) {
            return true;
        }
        sdk.pendo.io.t6.a.b(new IllegalArgumentException("n > 0 required but it was " + j));
        return false;
    }

    @Override // sdk.pendo.io.w5.c
    public void a(long j) {
    }

    @Override // sdk.pendo.io.w5.c
    public void cancel() {
    }

    public static void a(AtomicReference<sdk.pendo.io.w5.c> atomicReference, AtomicLong atomicLong, long j) {
        sdk.pendo.io.w5.c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.a(j);
            return;
        }
        if (c(j)) {
            d.a(atomicLong, j);
            sdk.pendo.io.w5.c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.a(andSet);
                }
            }
        }
    }

    public static boolean a(AtomicReference<sdk.pendo.io.w5.c> atomicReference, AtomicLong atomicLong, sdk.pendo.io.w5.c cVar) {
        if (!a(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        cVar.a(andSet);
        return true;
    }

    public static void a() {
        sdk.pendo.io.t6.a.b(new e("Subscription already set!"));
    }

    public static boolean a(AtomicReference<sdk.pendo.io.w5.c> atomicReference, sdk.pendo.io.w5.c cVar) {
        sdk.pendo.io.f6.b.a(cVar, "s is null");
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        a();
        return false;
    }

    public static boolean a(AtomicReference<sdk.pendo.io.w5.c> atomicReference, sdk.pendo.io.w5.c cVar, long j) {
        if (!a(atomicReference, cVar)) {
            return false;
        }
        cVar.a(j);
        return true;
    }

    public static boolean a(sdk.pendo.io.w5.c cVar, sdk.pendo.io.w5.c cVar2) {
        if (cVar2 == null) {
            sdk.pendo.io.t6.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.cancel();
        a();
        return false;
    }
}
