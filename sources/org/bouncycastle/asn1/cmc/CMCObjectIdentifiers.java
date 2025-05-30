package org.bouncycastle.asn1.cmc;

import androidx.exifinterface.media.ExifInterface;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes6.dex */
public interface CMCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_cct;
    public static final ASN1ObjectIdentifier id_cct_PKIData;
    public static final ASN1ObjectIdentifier id_cct_PKIResponse;
    public static final ASN1ObjectIdentifier id_cmc;
    public static final ASN1ObjectIdentifier id_cmc_addExtensions;
    public static final ASN1ObjectIdentifier id_cmc_authData;
    public static final ASN1ObjectIdentifier id_cmc_batchRequests;
    public static final ASN1ObjectIdentifier id_cmc_batchResponses;
    public static final ASN1ObjectIdentifier id_cmc_confirmCertAcceptance;
    public static final ASN1ObjectIdentifier id_cmc_controlProcessed;
    public static final ASN1ObjectIdentifier id_cmc_dataReturn;
    public static final ASN1ObjectIdentifier id_cmc_decryptedPOP;
    public static final ASN1ObjectIdentifier id_cmc_encryptedPOP;
    public static final ASN1ObjectIdentifier id_cmc_getCRL;
    public static final ASN1ObjectIdentifier id_cmc_getCert;
    public static final ASN1ObjectIdentifier id_cmc_identification;
    public static final ASN1ObjectIdentifier id_cmc_identityProof;
    public static final ASN1ObjectIdentifier id_cmc_identityProofV2;
    public static final ASN1ObjectIdentifier id_cmc_lraPOPWitness;
    public static final ASN1ObjectIdentifier id_cmc_modCertTemplate;
    public static final ASN1ObjectIdentifier id_cmc_popLinkRandom;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitness;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitnessV2;
    public static final ASN1ObjectIdentifier id_cmc_publishCert;
    public static final ASN1ObjectIdentifier id_cmc_queryPending;
    public static final ASN1ObjectIdentifier id_cmc_recipientNonce;
    public static final ASN1ObjectIdentifier id_cmc_regInfo;
    public static final ASN1ObjectIdentifier id_cmc_responseInfo;
    public static final ASN1ObjectIdentifier id_cmc_revokeRequest;
    public static final ASN1ObjectIdentifier id_cmc_senderNonce;
    public static final ASN1ObjectIdentifier id_cmc_statusInfo;
    public static final ASN1ObjectIdentifier id_cmc_statusInfoV2;
    public static final ASN1ObjectIdentifier id_cmc_transactionId;
    public static final ASN1ObjectIdentifier id_cmc_trustedAnchors;
    public static final ASN1ObjectIdentifier id_pkix;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("7");
        id_cmc = branch;
        ASN1ObjectIdentifier branch2 = aSN1ObjectIdentifier.branch("12");
        id_cct = branch2;
        id_cmc_identityProof = branch.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_cmc_dataReturn = branch.branch("4");
        id_cmc_regInfo = branch.branch("18");
        id_cmc_responseInfo = branch.branch("19");
        id_cmc_queryPending = branch.branch("21");
        id_cmc_popLinkRandom = branch.branch("22");
        id_cmc_popLinkWitness = branch.branch("23");
        id_cmc_identification = branch.branch(ExifInterface.GPS_MEASUREMENT_2D);
        id_cmc_transactionId = branch.branch("5");
        id_cmc_senderNonce = branch.branch("6");
        id_cmc_recipientNonce = branch.branch("7");
        id_cct_PKIData = branch2.branch(ExifInterface.GPS_MEASUREMENT_2D);
        id_cct_PKIResponse = branch2.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_cmc_statusInfo = branch.branch("1");
        id_cmc_addExtensions = branch.branch("8");
        id_cmc_encryptedPOP = branch.branch("9");
        id_cmc_decryptedPOP = branch.branch("10");
        id_cmc_lraPOPWitness = branch.branch("11");
        id_cmc_getCert = branch.branch("15");
        id_cmc_getCRL = branch.branch("16");
        id_cmc_revokeRequest = branch.branch("17");
        id_cmc_confirmCertAcceptance = branch.branch("24");
        id_cmc_statusInfoV2 = branch.branch("25");
        id_cmc_trustedAnchors = branch.branch("26");
        id_cmc_authData = branch.branch("27");
        id_cmc_batchRequests = branch.branch("28");
        id_cmc_batchResponses = branch.branch("29");
        id_cmc_publishCert = branch.branch("30");
        id_cmc_modCertTemplate = branch.branch("31");
        id_cmc_controlProcessed = branch.branch("32");
        id_cmc_identityProofV2 = branch.branch("34");
        id_cmc_popLinkWitnessV2 = branch.branch("33");
    }
}
