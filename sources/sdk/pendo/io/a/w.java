package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    protected final int f832a;
    protected w b;

    public w(int i) {
        this(i, null);
    }

    public abstract void a();

    public abstract void a(String str);

    public abstract void a(String str, int i, String str2);

    public abstract void a(String str, int i, String... strArr);

    public abstract void a(String str, String... strArr);

    public abstract void b(String str);

    public abstract void b(String str, int i, String... strArr);

    public abstract void c(String str);

    public w(int i, w wVar) {
        if (i != 589824 && i != 524288 && i != 458752 && i != 393216 && i != 327680 && i != 262144 && i != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + i);
        }
        if (i == 17432576) {
            j.a(this);
        }
        this.f832a = i;
        this.b = wVar;
    }
}
