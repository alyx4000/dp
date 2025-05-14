package sdk.pendo.io.s2;

import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public abstract class c extends b {
    @Override // sdk.pendo.io.s2.b
    public final int a(CharSequence charSequence, int i, Writer writer) {
        return a(Character.codePointAt(charSequence, i), writer) ? 1 : 0;
    }

    public abstract boolean a(int i, Writer writer);
}
