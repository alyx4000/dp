package sdk.pendo.io.s2;

import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public class g extends c {
    private final int b;
    private final int c;
    private final boolean d;

    private g(int i, int i2, boolean z) {
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    public static g a(int i, int i2) {
        return new g(i, i2, true);
    }

    @Override // sdk.pendo.io.s2.c
    public boolean a(int i, Writer writer) {
        if (this.d) {
            if (i < this.b || i > this.c) {
                return false;
            }
        } else if (i >= this.b && i <= this.c) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }
}
