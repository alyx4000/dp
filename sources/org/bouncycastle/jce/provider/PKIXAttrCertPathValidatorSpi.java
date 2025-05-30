package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.ExtendedPKIXParameters;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;

/* loaded from: classes6.dex */
public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi {
    private final JcaJceHelper helper = new BCJcaJceHelper();

    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParameters;
        boolean z = certPathParameters instanceof ExtendedPKIXParameters;
        if (!z && !(certPathParameters instanceof PKIXExtendedParameters)) {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + ExtendedPKIXParameters.class.getName() + " instance.");
        }
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        Set hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        if (certPathParameters instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters);
            if (z) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
                builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                builder.setValidityModel(extendedPKIXParameters.getValidityModel());
                hashSet = extendedPKIXParameters.getAttrCertCheckers();
                hashSet2 = extendedPKIXParameters.getProhibitedACAttributes();
                hashSet3 = extendedPKIXParameters.getNecessaryACAttributes();
            }
            pKIXExtendedParameters = builder.build();
        } else {
            pKIXExtendedParameters = (PKIXExtendedParameters) certPathParameters;
        }
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        Date date = new Date();
        Date validityDate = CertPathValidatorUtilities.getValidityDate(pKIXExtendedParameters2, date);
        Selector targetConstraints = pKIXExtendedParameters2.getTargetConstraints();
        if (!(targetConstraints instanceof X509AttributeCertStoreSelector)) {
            throw new InvalidAlgorithmParameterException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + getClass().getName() + " class.");
        }
        X509AttributeCertificate attributeCert = ((X509AttributeCertStoreSelector) targetConstraints).getAttributeCert();
        CertPath processAttrCert1 = RFC3281CertPathUtilities.processAttrCert1(attributeCert, pKIXExtendedParameters2);
        CertPathValidatorResult processAttrCert2 = RFC3281CertPathUtilities.processAttrCert2(certPath, pKIXExtendedParameters2);
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(0);
        RFC3281CertPathUtilities.processAttrCert3(x509Certificate, pKIXExtendedParameters2);
        RFC3281CertPathUtilities.processAttrCert4(x509Certificate, hashSet4);
        RFC3281CertPathUtilities.processAttrCert5(attributeCert, validityDate);
        RFC3281CertPathUtilities.processAttrCert7(attributeCert, certPath, processAttrCert1, pKIXExtendedParameters2, hashSet);
        RFC3281CertPathUtilities.additionalChecks(attributeCert, hashSet2, hashSet3);
        RFC3281CertPathUtilities.checkCRLs(attributeCert, pKIXExtendedParameters2, date, validityDate, x509Certificate, certPath.getCertificates(), this.helper);
        return processAttrCert2;
    }
}
