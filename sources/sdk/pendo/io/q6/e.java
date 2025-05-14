package sdk.pendo.io.q6;

/* loaded from: classes6.dex */
public final class e {
    public static void a() {
        if (sdk.pendo.io.t6.a.a()) {
            if ((Thread.currentThread() instanceof sdk.pendo.io.n6.i) || sdk.pendo.io.t6.a.b()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
