package sdk.pendo.io.o2;

/* loaded from: classes6.dex */
public class c {
    static int a(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence instanceof String ? ((String) charSequence).indexOf(charSequence2.toString(), i) : charSequence instanceof StringBuilder ? ((StringBuilder) charSequence).indexOf(charSequence2.toString(), i) : charSequence instanceof StringBuffer ? ((StringBuffer) charSequence).indexOf(charSequence2.toString(), i) : charSequence.toString().indexOf(charSequence2.toString(), i);
    }

    static boolean a(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
        }
        int length = charSequence.length() - i;
        int length2 = charSequence2.length() - i2;
        if (i < 0 || i2 < 0 || i3 < 0 || length < i3 || length2 < i3) {
            return false;
        }
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i5 = i + 1;
            char charAt = charSequence.charAt(i);
            int i6 = i2 + 1;
            char charAt2 = charSequence2.charAt(i2);
            if (charAt != charAt2) {
                if (!z) {
                    return false;
                }
                char upperCase = Character.toUpperCase(charAt);
                char upperCase2 = Character.toUpperCase(charAt2);
                if (upperCase != upperCase2 && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
            }
            i = i5;
            i3 = i4;
            i2 = i6;
        }
    }
}
