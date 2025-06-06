package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.EngineFactory;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Immutable
/* loaded from: classes5.dex */
final class HkdfHpkeKdf implements HpkeKdf {
    private final String macAlgorithm;

    HkdfHpkeKdf(String macAlgorithm) {
        this.macAlgorithm = macAlgorithm;
    }

    private byte[] extract(final byte[] ikm, final byte[] salt) throws GeneralSecurityException {
        Mac engineFactory = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (salt == null || salt.length == 0) {
            engineFactory.init(new SecretKeySpec(new byte[engineFactory.getMacLength()], this.macAlgorithm));
        } else {
            engineFactory.init(new SecretKeySpec(salt, this.macAlgorithm));
        }
        return engineFactory.doFinal(ikm);
    }

    private byte[] expand(final byte[] prk, final byte[] info, int length) throws GeneralSecurityException {
        Mac engineFactory = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (length > engineFactory.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr = new byte[length];
        engineFactory.init(new SecretKeySpec(prk, this.macAlgorithm));
        byte[] bArr2 = new byte[0];
        int i = 1;
        int i2 = 0;
        while (true) {
            engineFactory.update(bArr2);
            engineFactory.update(info);
            engineFactory.update((byte) i);
            bArr2 = engineFactory.doFinal();
            if (bArr2.length + i2 < length) {
                System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                i2 += bArr2.length;
                i++;
            } else {
                System.arraycopy(bArr2, 0, bArr, i2, length - i2);
                return bArr;
            }
        }
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExtract(byte[] salt, byte[] ikm, String ikmLabel, byte[] suiteId) throws GeneralSecurityException {
        return extract(HpkeUtil.labelIkm(ikmLabel, ikm, suiteId), salt);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExpand(byte[] prk, byte[] info, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException {
        return expand(prk, HpkeUtil.labelInfo(infoLabel, info, suiteId, length), length);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] extractAndExpand(byte[] salt, byte[] ikm, String ikmLabel, byte[] info, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException {
        return expand(extract(HpkeUtil.labelIkm(ikmLabel, ikm, suiteId), salt), HpkeUtil.labelInfo(infoLabel, info, suiteId, length), length);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] getKdfId() throws GeneralSecurityException {
        String str = this.macAlgorithm;
        str.hashCode();
        switch (str) {
            case "HmacSha256":
                return HpkeUtil.HKDF_SHA256_KDF_ID;
            case "HmacSha384":
                return HpkeUtil.HKDF_SHA384_KDF_ID;
            case "HmacSha512":
                return HpkeUtil.HKDF_SHA512_KDF_ID;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    int getMacLength() throws GeneralSecurityException {
        return Mac.getInstance(this.macAlgorithm).getMacLength();
    }
}
