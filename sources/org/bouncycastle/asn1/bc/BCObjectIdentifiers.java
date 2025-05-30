package org.bouncycastle.asn1.bc;

import androidx.exifinterface.media.ExifInterface;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes6.dex */
public interface BCObjectIdentifiers {
    public static final ASN1ObjectIdentifier bc;
    public static final ASN1ObjectIdentifier bc_exch;
    public static final ASN1ObjectIdentifier bc_ext;
    public static final ASN1ObjectIdentifier bc_pbe;
    public static final ASN1ObjectIdentifier bc_pbe_sha1;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs5;
    public static final ASN1ObjectIdentifier bc_pbe_sha224;
    public static final ASN1ObjectIdentifier bc_pbe_sha256;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs5;
    public static final ASN1ObjectIdentifier bc_pbe_sha384;
    public static final ASN1ObjectIdentifier bc_pbe_sha512;
    public static final ASN1ObjectIdentifier bc_sig;
    public static final ASN1ObjectIdentifier linkedCertificate;
    public static final ASN1ObjectIdentifier newHope;
    public static final ASN1ObjectIdentifier qTESLA;
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_I;
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_III_size;
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_III_speed;
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_p_I;
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_p_III;
    public static final ASN1ObjectIdentifier qTESLA_p_I;
    public static final ASN1ObjectIdentifier qTESLA_p_III;
    public static final ASN1ObjectIdentifier sphincs256;
    public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA512;
    public static final ASN1ObjectIdentifier xmss;
    public static final ASN1ObjectIdentifier xmss_SHA256;
    public static final ASN1ObjectIdentifier xmss_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_SHA512;
    public static final ASN1ObjectIdentifier xmss_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_SHAKE256ph;
    public static final ASN1ObjectIdentifier xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256ph;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA512;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_with_SHA512;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE256;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        bc = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1");
        bc_pbe = branch;
        ASN1ObjectIdentifier branch2 = branch.branch("1");
        bc_pbe_sha1 = branch2;
        ASN1ObjectIdentifier branch3 = branch.branch("2.1");
        bc_pbe_sha256 = branch3;
        bc_pbe_sha384 = branch.branch("2.2");
        bc_pbe_sha512 = branch.branch("2.3");
        bc_pbe_sha224 = branch.branch("2.4");
        bc_pbe_sha1_pkcs5 = branch2.branch("1");
        ASN1ObjectIdentifier branch4 = branch2.branch(ExifInterface.GPS_MEASUREMENT_2D);
        bc_pbe_sha1_pkcs12 = branch4;
        bc_pbe_sha256_pkcs5 = branch3.branch("1");
        ASN1ObjectIdentifier branch5 = branch3.branch(ExifInterface.GPS_MEASUREMENT_2D);
        bc_pbe_sha256_pkcs12 = branch5;
        bc_pbe_sha1_pkcs12_aes128_cbc = branch4.branch("1.2");
        bc_pbe_sha1_pkcs12_aes192_cbc = branch4.branch("1.22");
        bc_pbe_sha1_pkcs12_aes256_cbc = branch4.branch("1.42");
        bc_pbe_sha256_pkcs12_aes128_cbc = branch5.branch("1.2");
        bc_pbe_sha256_pkcs12_aes192_cbc = branch5.branch("1.22");
        bc_pbe_sha256_pkcs12_aes256_cbc = branch5.branch("1.42");
        ASN1ObjectIdentifier branch6 = aSN1ObjectIdentifier.branch(ExifInterface.GPS_MEASUREMENT_2D);
        bc_sig = branch6;
        ASN1ObjectIdentifier branch7 = branch6.branch("1");
        sphincs256 = branch7;
        sphincs256_with_BLAKE512 = branch7.branch("1");
        sphincs256_with_SHA512 = branch7.branch(ExifInterface.GPS_MEASUREMENT_2D);
        sphincs256_with_SHA3_512 = branch7.branch(ExifInterface.GPS_MEASUREMENT_3D);
        ASN1ObjectIdentifier branch8 = branch6.branch(ExifInterface.GPS_MEASUREMENT_2D);
        xmss = branch8;
        ASN1ObjectIdentifier branch9 = branch8.branch("1");
        xmss_SHA256ph = branch9;
        ASN1ObjectIdentifier branch10 = branch8.branch(ExifInterface.GPS_MEASUREMENT_2D);
        xmss_SHA512ph = branch10;
        ASN1ObjectIdentifier branch11 = branch8.branch(ExifInterface.GPS_MEASUREMENT_3D);
        xmss_SHAKE128ph = branch11;
        ASN1ObjectIdentifier branch12 = branch8.branch("4");
        xmss_SHAKE256ph = branch12;
        xmss_SHA256 = branch8.branch("5");
        xmss_SHA512 = branch8.branch("6");
        xmss_SHAKE128 = branch8.branch("7");
        xmss_SHAKE256 = branch8.branch("8");
        ASN1ObjectIdentifier branch13 = branch6.branch(ExifInterface.GPS_MEASUREMENT_3D);
        xmss_mt = branch13;
        ASN1ObjectIdentifier branch14 = branch13.branch("1");
        xmss_mt_SHA256ph = branch14;
        ASN1ObjectIdentifier branch15 = branch13.branch(ExifInterface.GPS_MEASUREMENT_2D);
        xmss_mt_SHA512ph = branch15;
        xmss_mt_SHAKE128ph = branch13.branch(ExifInterface.GPS_MEASUREMENT_3D);
        xmss_mt_SHAKE256ph = branch13.branch("4");
        xmss_mt_SHA256 = branch13.branch("5");
        xmss_mt_SHA512 = branch13.branch("6");
        ASN1ObjectIdentifier branch16 = branch13.branch("7");
        xmss_mt_SHAKE128 = branch16;
        ASN1ObjectIdentifier branch17 = branch13.branch("8");
        xmss_mt_SHAKE256 = branch17;
        xmss_with_SHA256 = branch9;
        xmss_with_SHA512 = branch10;
        xmss_with_SHAKE128 = branch11;
        xmss_with_SHAKE256 = branch12;
        xmss_mt_with_SHA256 = branch14;
        xmss_mt_with_SHA512 = branch15;
        xmss_mt_with_SHAKE128 = branch16;
        xmss_mt_with_SHAKE256 = branch17;
        ASN1ObjectIdentifier branch18 = branch6.branch("4");
        qTESLA = branch18;
        qTESLA_Rnd1_I = branch18.branch("1");
        qTESLA_Rnd1_III_size = branch18.branch(ExifInterface.GPS_MEASUREMENT_2D);
        qTESLA_Rnd1_III_speed = branch18.branch(ExifInterface.GPS_MEASUREMENT_3D);
        qTESLA_Rnd1_p_I = branch18.branch("4");
        qTESLA_Rnd1_p_III = branch18.branch("5");
        qTESLA_p_I = branch18.branch("11");
        qTESLA_p_III = branch18.branch("12");
        ASN1ObjectIdentifier branch19 = aSN1ObjectIdentifier.branch(ExifInterface.GPS_MEASUREMENT_3D);
        bc_exch = branch19;
        newHope = branch19.branch("1");
        ASN1ObjectIdentifier branch20 = aSN1ObjectIdentifier.branch("4");
        bc_ext = branch20;
        linkedCertificate = branch20.branch("1");
    }
}
