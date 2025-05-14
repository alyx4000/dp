package sdk.pendo.io.c6;

import sdk.pendo.io.q6.g;

/* loaded from: classes6.dex */
public final class b {
    public static RuntimeException a(Throwable th) {
        throw g.a(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
