package sdk.pendo.io.m2;

import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.SentryThread;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b=\u0010>J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0003J\u0018\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\nH&J\b\u0010\u0005\u001a\u00020\nH&J\b\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0019H\u0004J\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017J\u0010\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\b\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0019H\u0004J\u0017\u0010\u0010\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0010\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\nJ\b\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\nJ\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0007H&J\u0006\u0010%\u001a\u00020\u0007J \u0010\u0005\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0005J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0014J\u000e\u0010\u0010\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\nJ\b\u0010+\u001a\u00020\u0007H\u0016J\u000e\u0010\u0005\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0002J\u0006\u0010/\u001a\u00020.J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\b\u001a\u00020\nR\u0016\u0010\u0006\u001a\u00020\u00028\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u0005\u00100R\u0018\u00102\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00101R&\u0010:\u001a\u000603j\u0002`48\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010\u000e\u001a\u00020\r8$X¤\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lsdk/pendo/io/m2/a;", "", "", "lastPosition", SentryThread.JsonKeys.CURRENT, "a", "currentPosition", "", "c", "o", "", "r", "startPosition", "", "source", "startPos", "b", ViewProps.START, "literalSuffix", "", "j", ViewProps.POSITION, ContextChain.TAG_PRODUCT, "", "e", "", "k", "expected", "expectedToken", "", "(B)Ljava/lang/Void;", "m", "q", "n", "isLenient", "endPos", "d", "g", ContextChain.TAG_INFRA, "h", "fromIndex", "toIndex", "allowLenientStrings", "toString", DatabaseConstants.KEY_FIELD, "message", "", "f", "I", "Ljava/lang/String;", "peekedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "escapedString", "l", "()Ljava/lang/CharSequence;", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    protected int currentPosition;

    /* renamed from: b, reason: from kotlin metadata */
    private String peekedString;

    /* renamed from: c, reason: from kotlin metadata */
    private StringBuilder escapedString = new StringBuilder();

    private final String o() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    private final boolean r() {
        return l().charAt(this.currentPosition - 1) != '\"';
    }

    public abstract void a(char expected);

    public abstract boolean a();

    protected void b(int fromIndex, int toIndex) {
        this.escapedString.append(l(), fromIndex, toIndex);
    }

    protected final boolean b(char c) {
        return !(((c == '}' || c == ']') || c == ':') || c == ',');
    }

    public abstract int c(int position);

    public final boolean c() {
        boolean z;
        int n = n();
        if (n == l().length()) {
            a(this, "EOF", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        if (l().charAt(n) == '\"') {
            n++;
            z = true;
        } else {
            z = false;
        }
        boolean b = b(n);
        if (z) {
            if (this.currentPosition == l().length()) {
                a(this, "EOF", 0, 2, null);
                throw new KotlinNothingValueException();
            }
            if (l().charAt(this.currentPosition) != '\"') {
                a(this, "Expected closing quotation mark", 0, 2, null);
                throw new KotlinNothingValueException();
            }
            this.currentPosition++;
        }
        return b;
    }

    public abstract String d();

    public String d(int startPos, int endPos) {
        return l().subSequence(startPos, endPos).toString();
    }

    public abstract byte e();

    public final long f() {
        boolean z;
        int c = c(n());
        Object obj = null;
        int i = 2;
        if (c >= l().length() || c == -1) {
            a(this, "EOF", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        if (l().charAt(c) == '\"') {
            c++;
            if (c == l().length()) {
                a(this, "EOF", 0, 2, null);
                throw new KotlinNothingValueException();
            }
            z = true;
        } else {
            z = false;
        }
        int i2 = c;
        boolean z2 = false;
        boolean z3 = true;
        long j = 0;
        while (z3) {
            char charAt = l().charAt(i2);
            if (charAt == '-') {
                if (i2 != c) {
                    a(this, "Unexpected symbol '-' in numeric literal", 0, i, obj);
                    throw new KotlinNothingValueException();
                }
                i2++;
                z2 = true;
            } else {
                if (b.a(charAt) != 0) {
                    break;
                }
                i2++;
                z3 = i2 != l().length();
                int i3 = charAt - '0';
                if (!(i3 >= 0 && i3 < 10)) {
                    a(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, i, obj);
                    throw new KotlinNothingValueException();
                }
                j = (j * 10) - i3;
                if (j > 0) {
                    a(this, "Numeric value overflow", 0, 2, null);
                    throw new KotlinNothingValueException();
                }
                obj = null;
                i = 2;
            }
        }
        if (c == i2 || (z2 && c == i2 - 1)) {
            a(this, "Expected numeric literal", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        if (z) {
            if (!z3) {
                a(this, "EOF", 0, 2, null);
                throw new KotlinNothingValueException();
            }
            if (l().charAt(i2) != '\"') {
                a(this, "Expected closing quotation mark", 0, 2, null);
                throw new KotlinNothingValueException();
            }
            i2++;
        }
        this.currentPosition = i2;
        if (z2) {
            return j;
        }
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        a(this, "Numeric value overflow", 0, 2, null);
        throw new KotlinNothingValueException();
    }

    public final String g() {
        return this.peekedString != null ? o() : d();
    }

    public final String h() {
        if (this.peekedString != null) {
            return o();
        }
        int n = n();
        if (n >= l().length() || n == -1) {
            b("EOF", n);
            throw new KotlinNothingValueException();
        }
        byte a2 = b.a(l().charAt(n));
        if (a2 == 1) {
            return g();
        }
        if (a2 != 0) {
            a(this, Intrinsics.stringPlus("Expected beginning of the string, but got ", Character.valueOf(l().charAt(n))), 0, 2, null);
            throw new KotlinNothingValueException();
        }
        boolean z = false;
        while (b.a(l().charAt(n)) == 0) {
            n++;
            if (n >= l().length()) {
                b(this.currentPosition, n);
                int c = c(n);
                if (c == -1) {
                    this.currentPosition = n;
                    return c(0, 0);
                }
                n = c;
                z = true;
            }
        }
        int i = this.currentPosition;
        String d = !z ? d(i, n) : c(i, n);
        this.currentPosition = n;
        return d;
    }

    public final String i() {
        String h = h();
        if (!Intrinsics.areEqual(h, "null") || !r()) {
            return h;
        }
        a(this, "Unexpected 'null' value instead of string literal", 0, 2, null);
        throw new KotlinNothingValueException();
    }

    public void j() {
    }

    public final void k() {
        if (e() == 10) {
            return;
        }
        a(this, "Expected EOF after parsing, but had " + l().charAt(this.currentPosition - 1) + " instead", 0, 2, null);
        throw new KotlinNothingValueException();
    }

    protected abstract CharSequence l();

    public final byte m() {
        CharSequence l = l();
        int i = this.currentPosition;
        while (true) {
            int c = c(i);
            if (c == -1) {
                this.currentPosition = c;
                return (byte) 10;
            }
            char charAt = l.charAt(c);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = c;
                return b.a(charAt);
            }
            i = c + 1;
        }
    }

    public abstract int n();

    public abstract boolean p();

    public final boolean q() {
        int c = c(n());
        int length = l().length() - c;
        if (length < 4 || c == -1) {
            return true;
        }
        int i = 0;
        while (i < 4) {
            int i2 = i + 1;
            if ("null".charAt(i) != l().charAt(i + c)) {
                return true;
            }
            i = i2;
        }
        if (length > 4 && b.a(l().charAt(c + 4)) == 0) {
            return true;
        }
        this.currentPosition = c + 4;
        return false;
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) l()) + "', currentPosition=" + this.currentPosition + ')';
    }

    private final int a(int startPosition) {
        int c = c(startPosition);
        if (c == -1) {
            a(this, "Expected escape sequence to continue, got EOF", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        int i = c + 1;
        char charAt = l().charAt(c);
        if (charAt == 'u') {
            return a(l(), i);
        }
        char a2 = b.a((int) charAt);
        if (a2 != 0) {
            this.escapedString.append(a2);
            return i;
        }
        a(this, "Invalid escaped char '" + charAt + '\'', 0, 2, null);
        throw new KotlinNothingValueException();
    }

    private final String c(int lastPosition, int currentPosition) {
        b(lastPosition, currentPosition);
        String sb = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "escapedString.toString()");
        this.escapedString.setLength(0);
        return sb;
    }

    public final boolean b() {
        return b(n());
    }

    private final int a(int lastPosition, int current) {
        b(lastPosition, current);
        return a(current + 1);
    }

    private final boolean b(int start) {
        int c = c(start);
        if (c >= l().length() || c == -1) {
            a(this, "EOF", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        int i = c + 1;
        int charAt = l().charAt(c) | ' ';
        if (charAt == 116) {
            a("rue", i);
            return true;
        }
        if (charAt == 102) {
            a("alse", i);
            return false;
        }
        a(this, "Expected valid boolean literal prefix, but had '" + h() + '\'', 0, 2, null);
        throw new KotlinNothingValueException();
    }

    protected final void c(char expected) {
        int i = this.currentPosition - 1;
        this.currentPosition = i;
        if (i >= 0 && expected == '\"' && Intrinsics.areEqual(h(), "null")) {
            b("Expected string literal but 'null' literal was found.\nUse 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.", this.currentPosition - 4);
            throw new KotlinNothingValueException();
        }
        b(b.a(expected));
        throw new KotlinNothingValueException();
    }

    private final int a(CharSequence source, int startPos) {
        int i = startPos + 4;
        if (i < source.length()) {
            this.escapedString.append((char) ((b(source, startPos) << 12) + (b(source, startPos + 1) << 8) + (b(source, startPos + 2) << 4) + b(source, startPos + 3)));
            return i;
        }
        this.currentPosition = startPos;
        j();
        if (this.currentPosition + 4 < source.length()) {
            return a(source, this.currentPosition);
        }
        a(this, "Unexpected EOF during unicode escape", 0, 2, null);
        throw new KotlinNothingValueException();
    }

    public final Void b(String message, int position) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw k.a(position, message, l());
    }

    private final void a(String literalSuffix, int current) {
        if (l().length() - current < literalSuffix.length()) {
            a(this, "Unexpected end of boolean literal", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        int length = literalSuffix.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (literalSuffix.charAt(i) != (l().charAt(i + current) | ' ')) {
                a(this, "Expected valid boolean literal prefix, but had '" + h() + '\'', 0, 2, null);
                throw new KotlinNothingValueException();
            }
            i = i2;
        }
        this.currentPosition = current + literalSuffix.length();
    }

    public final Void b(byte expectedToken) {
        b("Expected " + (expectedToken == 1 ? "quotation mark '\"'" : expectedToken == 4 ? "comma ','" : expectedToken == 5 ? "semicolon ':'" : expectedToken == 6 ? "start of the object '{'" : expectedToken == 7 ? "end of the object '}'" : expectedToken == 8 ? "start of the array '['" : expectedToken == 9 ? "end of the array ']'" : "valid token") + ", but had '" + ((this.currentPosition == l().length() || this.currentPosition <= 0) ? "EOF" : String.valueOf(l().charAt(this.currentPosition - 1))) + "' instead", this.currentPosition - 1);
        throw new KotlinNothingValueException();
    }

    private final int b(CharSequence source, int currentPosition) {
        char charAt = source.charAt(currentPosition);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        char c = 'a';
        if (!('a' <= charAt && charAt < 'g')) {
            c = 'A';
            if (!('A' <= charAt && charAt < 'G')) {
                a(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, 2, null);
                throw new KotlinNothingValueException();
            }
        }
        return (charAt - c) + 10;
    }

    public final byte a(byte expected) {
        byte e = e();
        if (e == expected) {
            return e;
        }
        b(expected);
        throw new KotlinNothingValueException();
    }

    protected final String a(CharSequence source, int startPosition, int current) {
        Intrinsics.checkNotNullParameter(source, "source");
        char charAt = source.charAt(current);
        boolean z = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                startPosition = c(a(startPosition, current));
                if (startPosition == -1) {
                    b("EOF", startPosition);
                    throw new KotlinNothingValueException();
                }
            } else {
                current++;
                if (current >= source.length()) {
                    b(startPosition, current);
                    startPosition = c(current);
                    if (startPosition == -1) {
                        b("EOF", startPosition);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = source.charAt(current);
                }
            }
            current = startPosition;
            z = true;
            charAt = source.charAt(current);
        }
        String d = !z ? d(startPosition, current) : c(startPosition, current);
        this.currentPosition = current + 1;
        return d;
    }

    public static /* synthetic */ Void a(a aVar, String str, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i2 & 2) != 0) {
            i = aVar.currentPosition;
        }
        return aVar.b(str, i);
    }

    public final void b(boolean allowLenientStrings) {
        ArrayList arrayList = new ArrayList();
        byte m = m();
        if (m != 8 && m != 6) {
            h();
            return;
        }
        while (true) {
            byte m2 = m();
            boolean z = true;
            if (m2 != 1) {
                if (m2 != 8 && m2 != 6) {
                    z = false;
                }
                if (z) {
                    arrayList.add(Byte.valueOf(m2));
                } else {
                    if (m2 == 9) {
                        if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 8) {
                            throw k.a(this.currentPosition, "found ] instead of }", l());
                        }
                    } else if (m2 == 7) {
                        if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 6) {
                            throw k.a(this.currentPosition, "found } instead of ]", l());
                        }
                    } else if (m2 == 10) {
                        a(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, 2, null);
                        throw new KotlinNothingValueException();
                    }
                    CollectionsKt.removeLast(arrayList);
                }
                e();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (allowLenientStrings) {
                h();
            } else {
                d();
            }
        }
    }

    public final void a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        b("Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.", StringsKt.lastIndexOf$default((CharSequence) d(0, this.currentPosition), key, 0, false, 6, (Object) null));
        throw new KotlinNothingValueException();
    }

    public final String a(boolean isLenient) {
        String g;
        byte m = m();
        if (isLenient) {
            if (m != 1 && m != 0) {
                return null;
            }
            g = h();
        } else {
            if (m != 1) {
                return null;
            }
            g = g();
        }
        this.peekedString = g;
        return g;
    }
}
