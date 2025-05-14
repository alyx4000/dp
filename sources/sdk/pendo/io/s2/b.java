package sdk.pendo.io.s2;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

@Deprecated
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f1536a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    public abstract int a(CharSequence charSequence, int i, Writer writer);

    public final String a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            a(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final void a(CharSequence charSequence, Writer writer) {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (charSequence == null) {
            return;
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a2 = a(charSequence, i, writer);
            if (a2 == 0) {
                char charAt = charSequence.charAt(i);
                writer.write(charAt);
                i++;
                if (Character.isHighSurrogate(charAt) && i < length) {
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isLowSurrogate(charAt2)) {
                        writer.write(charAt2);
                        i++;
                    }
                }
            } else {
                for (int i2 = 0; i2 < a2; i2++) {
                    i += Character.charCount(Character.codePointAt(charSequence, i));
                }
            }
        }
    }

    public final b a(b... bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length + 1];
        bVarArr2[0] = this;
        System.arraycopy(bVarArr, 0, bVarArr2, 1, bVarArr.length);
        return new a(bVarArr2);
    }
}
