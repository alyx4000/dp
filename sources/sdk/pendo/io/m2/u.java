package sdk.pendo.io.m2;

import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0013\u001a\u00020\u000e8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/m2/u;", "Lsdk/pendo/io/m2/a;", "", ViewProps.POSITION, "c", "", "e", "", ContextChain.TAG_PRODUCT, "a", "n", "", "expected", "", "", "d", "Ljava/lang/String;", "s", "()Ljava/lang/String;", "source", "<init>", "(Ljava/lang/String;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class u extends a {

    /* renamed from: d, reason: from kotlin metadata */
    private final String source;

    public u(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // sdk.pendo.io.m2.a
    public boolean a() {
        int i = this.currentPosition;
        if (i == -1) {
            return false;
        }
        while (i < l().length()) {
            char charAt = l().charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = i;
                return b(charAt);
            }
            i++;
        }
        this.currentPosition = i;
        return false;
    }

    @Override // sdk.pendo.io.m2.a
    public int c(int position) {
        if (position < l().length()) {
            return position;
        }
        return -1;
    }

    @Override // sdk.pendo.io.m2.a
    public String d() {
        a(Typography.quote);
        int i = this.currentPosition;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) l(), Typography.quote, i, false, 4, (Object) null);
        if (indexOf$default == -1) {
            b((byte) 1);
            throw new KotlinNothingValueException();
        }
        int i2 = i;
        while (i2 < indexOf$default) {
            int i3 = i2 + 1;
            if (l().charAt(i2) == '\\') {
                return a(l(), this.currentPosition, i2);
            }
            i2 = i3;
        }
        this.currentPosition = indexOf$default + 1;
        String substring = l().substring(i, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // sdk.pendo.io.m2.a
    public byte e() {
        byte a2;
        String l = l();
        do {
            int i = this.currentPosition;
            if (i == -1 || i >= l.length()) {
                return (byte) 10;
            }
            int i2 = this.currentPosition;
            this.currentPosition = i2 + 1;
            a2 = b.a(l.charAt(i2));
        } while (a2 == 3);
        return a2;
    }

    @Override // sdk.pendo.io.m2.a
    public int n() {
        char charAt;
        int i = this.currentPosition;
        if (i == -1) {
            return i;
        }
        while (i < l().length() && ((charAt = l().charAt(i)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i++;
        }
        this.currentPosition = i;
        return i;
    }

    @Override // sdk.pendo.io.m2.a
    public boolean p() {
        int n = n();
        if (n == l().length() || n == -1 || l().charAt(n) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.m2.a
    /* renamed from: s, reason: from getter and merged with bridge method [inline-methods] */
    public String l() {
        return this.source;
    }

    @Override // sdk.pendo.io.m2.a
    public void a(char expected) {
        if (this.currentPosition == -1) {
            c(expected);
        }
        String l = l();
        while (this.currentPosition < l.length()) {
            int i = this.currentPosition;
            this.currentPosition = i + 1;
            char charAt = l.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                if (charAt == expected) {
                    return;
                } else {
                    c(expected);
                }
            }
        }
        c(expected);
    }
}
