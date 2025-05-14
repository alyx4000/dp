package sdk.pendo.io.w1;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static a f1699a;

    public static a a() {
        if (f1699a == null) {
            synchronized (b.class) {
                if (f1699a == null) {
                    f1699a = b();
                }
            }
        }
        return f1699a;
    }

    private static a b() {
        return new c(400);
    }
}
