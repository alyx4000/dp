package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final int f813a;
    protected a b;

    public a(int i) {
        this(i, null);
    }

    public abstract a a(String str);

    public abstract a a(String str, String str2);

    public abstract void a();

    public abstract void a(String str, Object obj);

    public abstract void a(String str, String str2, String str3);

    public a(int i, a aVar) {
        if (i != 589824 && i != 524288 && i != 458752 && i != 393216 && i != 327680 && i != 262144 && i != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + i);
        }
        if (i == 17432576) {
            j.a(this);
        }
        this.f813a = i;
        this.b = aVar;
    }
}
