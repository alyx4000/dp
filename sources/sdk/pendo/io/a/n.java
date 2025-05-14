package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    protected final int f826a;
    protected n b;

    public n(int i) {
        this(i, null);
    }

    public abstract a a(int i, e0 e0Var, String str, boolean z);

    public abstract a a(String str, boolean z);

    public abstract void a();

    public abstract void a(c cVar);

    public n(int i, n nVar) {
        if (i != 589824 && i != 524288 && i != 458752 && i != 393216 && i != 327680 && i != 262144 && i != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + i);
        }
        if (i == 17432576) {
            j.a(this);
        }
        this.f826a = i;
        this.b = nVar;
    }
}
