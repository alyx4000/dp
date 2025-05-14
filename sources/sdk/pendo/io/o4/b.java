package sdk.pendo.io.o4;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;

/* loaded from: classes6.dex */
public class b extends DHParameterSpec {

    /* renamed from: a, reason: collision with root package name */
    private final BigInteger f1460a;
    private final BigInteger b;
    private final int c;

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this(bigInteger, bigInteger2, bigInteger3, null, i);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, 0, i);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, int i2) {
        super(bigInteger, bigInteger3, i2);
        this.f1460a = bigInteger2;
        this.b = bigInteger4;
        this.c = i;
    }
}
