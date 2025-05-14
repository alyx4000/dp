package sdk.pendo.io.s2;

import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public class a extends b {
    private final b[] b;

    public a(b... bVarArr) {
        this.b = (b[]) sdk.pendo.io.o2.b.a((Object[]) bVarArr);
    }

    @Override // sdk.pendo.io.s2.b
    public int a(CharSequence charSequence, int i, Writer writer) {
        for (b bVar : this.b) {
            int a2 = bVar.a(charSequence, i, writer);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }
}
