package sdk.pendo.io.a5;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;
import sdk.pendo.io.m3.q;
import sdk.pendo.io.m3.q1;
import sdk.pendo.io.m3.r;
import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f850a;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] e;
    private static final byte[] f;

    static {
        v vVar = sdk.pendo.io.v3.b.c;
        sdk.pendo.io.e4.a aVar = new sdk.pendo.io.e4.a(vVar);
        v vVar2 = sdk.pendo.io.v3.b.d;
        sdk.pendo.io.e4.a aVar2 = new sdk.pendo.io.e4.a(vVar2);
        v vVar3 = sdk.pendo.io.v3.b.e;
        sdk.pendo.io.e4.a aVar3 = new sdk.pendo.io.e4.a(vVar3);
        q1 q1Var = q1.s;
        sdk.pendo.io.e4.a aVar4 = new sdk.pendo.io.e4.a(vVar, q1Var);
        sdk.pendo.io.e4.a aVar5 = new sdk.pendo.io.e4.a(vVar2, q1Var);
        sdk.pendo.io.e4.a aVar6 = new sdk.pendo.io.e4.a(vVar3, q1Var);
        v vVar4 = sdk.pendo.io.y3.a.i;
        sdk.pendo.io.e4.a aVar7 = new sdk.pendo.io.e4.a(vVar4, aVar);
        sdk.pendo.io.e4.a aVar8 = new sdk.pendo.io.e4.a(vVar4, aVar2);
        sdk.pendo.io.e4.a aVar9 = new sdk.pendo.io.e4.a(vVar4, aVar3);
        sdk.pendo.io.e4.a aVar10 = new sdk.pendo.io.e4.a(vVar4, aVar4);
        sdk.pendo.io.e4.a aVar11 = new sdk.pendo.io.e4.a(vVar4, aVar5);
        sdk.pendo.io.e4.a aVar12 = new sdk.pendo.io.e4.a(vVar4, aVar6);
        q qVar = new q(sdk.pendo.io.z4.k.d(4));
        q qVar2 = new q(sdk.pendo.io.z4.k.d(5));
        q qVar3 = new q(sdk.pendo.io.z4.k.d(6));
        q qVar4 = new q(1L);
        try {
            f850a = new sdk.pendo.io.y3.c(aVar, aVar7, qVar, qVar4).a(ASN1Encoding.DER);
            b = new sdk.pendo.io.y3.c(aVar2, aVar8, qVar2, qVar4).a(ASN1Encoding.DER);
            c = new sdk.pendo.io.y3.c(aVar3, aVar9, qVar3, qVar4).a(ASN1Encoding.DER);
            d = new sdk.pendo.io.y3.c(aVar4, aVar10, qVar, qVar4).a(ASN1Encoding.DER);
            e = new sdk.pendo.io.y3.c(aVar5, aVar11, qVar2, qVar4).a(ASN1Encoding.DER);
            f = new sdk.pendo.io.y3.c(aVar6, aVar12, qVar3, qVar4).a(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }

    public static boolean a(sdk.pendo.io.e4.a aVar) {
        v h = aVar.h();
        return sdk.pendo.io.y3.a.b.b(h) || sdk.pendo.io.e4.k.m.b(h);
    }

    public static boolean b(sdk.pendo.io.e4.a aVar) {
        return sdk.pendo.io.y3.a.b.b(aVar.h());
    }

    public static boolean a(short s, sdk.pendo.io.e4.a aVar) {
        byte[] bArr;
        byte[] bArr2;
        if (!sdk.pendo.io.y3.a.k.b(aVar.h())) {
            return false;
        }
        sdk.pendo.io.m3.g i = aVar.i();
        if (i == null || (i instanceof r)) {
            switch (s) {
            }
            return false;
        }
        try {
            byte[] a2 = i.b().a(ASN1Encoding.DER);
            switch (s) {
                case 9:
                    bArr = f850a;
                    bArr2 = d;
                    break;
                case 10:
                    bArr = b;
                    bArr2 = e;
                    break;
                case 11:
                    bArr = c;
                    bArr2 = f;
                    break;
                default:
                    return false;
            }
            return sdk.pendo.io.d5.a.a(bArr, a2) || sdk.pendo.io.d5.a.a(bArr2, a2);
        } catch (Exception unused) {
            return false;
        }
    }
}
