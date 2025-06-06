package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes6.dex */
public class BERBitString extends ASN1BitString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
    private final ASN1BitString[] elements;
    private final int segmentLimit;

    public BERBitString(byte b, int i) {
        super(b, i);
        this.elements = null;
        this.segmentLimit = 1000;
    }

    public BERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        this(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public BERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public BERBitString(byte[] bArr, int i) {
        this(bArr, i, 1000);
    }

    public BERBitString(byte[] bArr, int i, int i2) {
        super(bArr, i);
        this.elements = null;
        this.segmentLimit = i2;
    }

    BERBitString(byte[] bArr, boolean z) {
        super(bArr, z);
        this.elements = null;
        this.segmentLimit = 1000;
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr) {
        this(aSN1BitStringArr, 1000);
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr, int i) {
        super(flattenBitStrings(aSN1BitStringArr), false);
        this.elements = aSN1BitStringArr;
        this.segmentLimit = i;
    }

    static byte[] flattenBitStrings(ASN1BitString[] aSN1BitStringArr) {
        int length = aSN1BitStringArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return aSN1BitStringArr[0].contents;
        }
        int i = length - 1;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr = aSN1BitStringArr[i3].contents;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            i2 += bArr.length - 1;
        }
        byte[] bArr2 = aSN1BitStringArr[i].contents;
        byte b = bArr2[0];
        byte[] bArr3 = new byte[i2 + bArr2.length];
        bArr3[0] = b;
        int i4 = 1;
        for (ASN1BitString aSN1BitString : aSN1BitStringArr) {
            byte[] bArr4 = aSN1BitString.contents;
            int length2 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i4, length2);
            i4 += length2;
        }
        return bArr3;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        if (!encodeConstructed()) {
            DLBitString.encode(aSN1OutputStream, z, this.contents, 0, this.contents.length);
            return;
        }
        aSN1OutputStream.writeIdentifier(z, 35);
        aSN1OutputStream.write(128);
        ASN1BitString[] aSN1BitStringArr = this.elements;
        if (aSN1BitStringArr != null) {
            aSN1OutputStream.writePrimitives(aSN1BitStringArr);
        } else if (this.contents.length >= 2) {
            byte b = this.contents[0];
            int length = this.contents.length;
            int i = length - 1;
            int i2 = this.segmentLimit - 1;
            while (i > i2) {
                DLBitString.encode(aSN1OutputStream, true, (byte) 0, this.contents, length - i, i2);
                i -= i2;
            }
            DLBitString.encode(aSN1OutputStream, true, b, this.contents, length - i, i);
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return this.elements != null || this.contents.length > this.segmentLimit;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean z) throws IOException {
        if (!encodeConstructed()) {
            return DLBitString.encodedLength(z, this.contents.length);
        }
        int i = z ? 4 : 3;
        if (this.elements == null) {
            if (this.contents.length < 2) {
                return i;
            }
            int length = this.contents.length - 2;
            int i2 = this.segmentLimit;
            int i3 = length / (i2 - 1);
            return i + (DLBitString.encodedLength(true, i2) * i3) + DLBitString.encodedLength(true, this.contents.length - (i3 * (this.segmentLimit - 1)));
        }
        int i4 = 0;
        while (true) {
            ASN1BitString[] aSN1BitStringArr = this.elements;
            if (i4 >= aSN1BitStringArr.length) {
                return i;
            }
            i += aSN1BitStringArr[i4].encodedLength(true);
            i4++;
        }
    }
}
