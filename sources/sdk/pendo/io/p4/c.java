package sdk.pendo.io.p4;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    protected final Provider f1496a;

    public c(Provider provider) {
        this.f1496a = provider;
    }

    @Override // sdk.pendo.io.p4.b
    public KeyPairGenerator a(String str) {
        return KeyPairGenerator.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public Mac b(String str) {
        return Mac.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public CertificateFactory c(String str) {
        return CertificateFactory.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public Cipher d(String str) {
        return Cipher.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public AlgorithmParameters e(String str) {
        return AlgorithmParameters.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public Signature f(String str) {
        return Signature.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public KeyAgreement g(String str) {
        return KeyAgreement.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public MessageDigest h(String str) {
        return MessageDigest.getInstance(str, this.f1496a);
    }

    @Override // sdk.pendo.io.p4.b
    public KeyFactory i(String str) {
        return KeyFactory.getInstance(str, this.f1496a);
    }
}
