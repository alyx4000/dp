package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public final class f extends IndexOutOfBoundsException {
    private final String f;
    private final int s;

    public f(String str, int i) {
        super("Class too large: " + str);
        this.f = str;
        this.s = i;
    }
}
