package sdk.pendo.io.p4;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes6.dex */
public interface b {
    KeyPairGenerator a(String str);

    Mac b(String str);

    CertificateFactory c(String str);

    Cipher d(String str);

    AlgorithmParameters e(String str);

    Signature f(String str);

    KeyAgreement g(String str);

    MessageDigest h(String str);

    KeyFactory i(String str);
}
