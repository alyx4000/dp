package sdk.pendo.io.i;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import sdk.pendo.io.l.a;
import sdk.pendo.io.l.d;
import sdk.pendo.io.l.e;
import sdk.pendo.io.l.f;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/i/a;", "", "Ljava/io/InputStream;", "inputStream", "Lsdk/pendo/io/l/a;", "a", "Lsdk/pendo/io/l/e;", "b", "", "maxDataLength", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1170a = new a();

    private a() {
    }

    public final int a(int maxDataLength) {
        return (int) (Math.ceil(MathKt.log2(maxDataLength)) / 8);
    }

    public final e b(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        f a2 = f.INSTANCE.a((int) b.b(inputStream, 1));
        if (a2 != f.V1) {
            throw new sdk.pendo.io.e.b("Unknown version: " + a2);
        }
        byte[] a3 = b.a(inputStream, 32);
        return new e(a2, new d(a3), b.b(inputStream, 8), a(inputStream), b.c(inputStream, 65535));
    }

    private final sdk.pendo.io.l.a a(InputStream inputStream) {
        int b = (int) b.b(inputStream, 1);
        a.EnumC0173a a2 = a.EnumC0173a.INSTANCE.a(b);
        if (a2 == null) {
            StringBuilder sb = new StringBuilder("Unknown hash algorithm: ");
            String num = Integer.toString(b, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            throw new sdk.pendo.io.e.b(sb.append(num).toString());
        }
        int b2 = (int) b.b(inputStream, 1);
        a.b a3 = a.b.INSTANCE.a(b2);
        if (a3 != null) {
            return new sdk.pendo.io.l.a(a2, a3, b.c(inputStream, 65535));
        }
        StringBuilder sb2 = new StringBuilder("Unknown signature algorithm: ");
        String num2 = Integer.toString(b2, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
        throw new sdk.pendo.io.e.b(sb2.append(num2).toString());
    }
}
