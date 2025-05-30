package org.bouncycastle.oer.its.template;

import java.math.BigInteger;
import okhttp3.internal.ws.WebSocketProtocol;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.oer.OERDefinition;

/* loaded from: classes6.dex */
public class Ieee1609Dot2BaseTypes {
    public static final OERDefinition.Builder BasePublicEncryptionKey;
    public static final OERDefinition.Builder BitmapSsp;
    public static final OERDefinition.Builder BitmapSspRange;
    public static OERDefinition.Builder CircularRegion;
    public static OERDefinition.Builder CountryAndRegions;
    public static OERDefinition.Builder CountryAndSubregions;
    public static OERDefinition.Builder CountryOnly;
    public static final OERDefinition.Builder CrlSeries;
    public static final OERDefinition.Builder Duration;
    public static final OERDefinition.Builder EccP256CurvePoint;
    public static final OERDefinition.Builder EccP384CurvePoint;
    public static final OERDefinition.Builder EcdsaP256Signature;
    public static final OERDefinition.Builder EcdsaP384Signature;
    public static final OERDefinition.Builder EciesP256EncryptedKey;
    public static OERDefinition.Builder Elevation;
    public static final OERDefinition.Builder EncryptionKey;
    public static OERDefinition.Builder GeographicRegion;
    public static final OERDefinition.Builder GroupLinkageValue;
    public static final OERDefinition.Builder HashAlgorithm;
    public static final OERDefinition.Builder HashedId10;
    public static final OERDefinition.Builder HashedId3;
    public static final OERDefinition.Builder HashedId32;
    public static final OERDefinition.Builder HashedId48;
    public static final OERDefinition.Builder HashedId8;
    public static final OERDefinition.Builder Hostname;
    public static final OERDefinition.Builder IValue;
    public static OERDefinition.Builder IdentifiedRegion;
    public static OERDefinition.Builder KnownLatitude;
    public static OERDefinition.Builder KnownLongitude;
    public static final OERDefinition.Builder LaId;
    public static OERDefinition.Builder Latitude;
    public static final OERDefinition.Builder LinkageSeed;
    public static final OERDefinition.Builder LinkageValue;
    public static OERDefinition.Builder Longitude;
    public static OERDefinition.Builder NinetyDegreeInt;
    public static OERDefinition.Builder OneEightyDegreeInt;
    public static OERDefinition.Builder PolygonalRegion;
    public static final OERDefinition.Builder Psid;
    public static final OERDefinition.Builder PsidSsp;
    public static final OERDefinition.Builder PsidSspRange;
    public static final OERDefinition.Builder PublicEncryptionKey;
    public static final OERDefinition.Builder PublicVerificationKey;
    public static OERDefinition.Builder RectangularRegion;
    public static OERDefinition.Builder RegionAndSubregions;
    public static final OERDefinition.Builder SequenceOfHashedId3;
    public static OERDefinition.Builder SequenceOfIdentifiedRegion;
    public static final OERDefinition.Builder SequenceOfOctetString;
    public static final OERDefinition.Builder SequenceOfPsid;
    public static final OERDefinition.Builder SequenceOfPsidSsp;
    public static final OERDefinition.Builder SequenceOfPsidSspRange;
    public static OERDefinition.Builder SequenceOfRectangularRegion;
    public static OERDefinition.Builder SequenceOfRegionAndSubregions;
    public static final OERDefinition.Builder SequenceOfUint16;
    public static final OERDefinition.Builder ServiceSpecificPermissions;
    public static final OERDefinition.Builder Signature;
    public static final OERDefinition.Builder SspRange;
    public static final OERDefinition.Builder SubjectAssurance;
    public static final OERDefinition.Builder SymmAlgorithm;
    public static final OERDefinition.Builder SymmetricEncryptionKey;
    public static OERDefinition.Builder ThreeDLocation;
    public static final OERDefinition.Builder Time32;
    public static final OERDefinition.Builder Time64;
    public static OERDefinition.Builder TwoDLocation;
    public static final OERDefinition.Builder UINT16;
    public static final OERDefinition.Builder UINT3 = OERDefinition.integer(0, 7);
    public static final OERDefinition.Builder UINT32;
    public static final OERDefinition.Builder UINT64;
    public static final OERDefinition.Builder UINT8;
    public static OERDefinition.Builder UnknownLatitude;
    public static OERDefinition.Builder UnknownLongitude;
    public static final OERDefinition.Builder ValidityPeriod;

    static {
        OERDefinition.Builder integer = OERDefinition.integer(0L, 255L);
        UINT8 = integer;
        OERDefinition.Builder integer2 = OERDefinition.integer(0L, WebSocketProtocol.PAYLOAD_SHORT_MAX);
        UINT16 = integer2;
        OERDefinition.Builder integer3 = OERDefinition.integer(0L, BodyPartID.bodyIdMax);
        UINT32 = integer3;
        OERDefinition.Builder integer4 = OERDefinition.integer(BigInteger.ZERO, new BigInteger("18446744073709551615"));
        UINT64 = integer4;
        SequenceOfUint16 = OERDefinition.seqof(integer2);
        OERDefinition.Builder label = OERDefinition.octets(3).label("HashId3");
        HashedId3 = label;
        SequenceOfHashedId3 = OERDefinition.seqof(label).label("SequenceOfHashedId3");
        HashedId8 = OERDefinition.octets(8).label("HashId8");
        HashedId10 = OERDefinition.octets(10).label("HashId10");
        HashedId32 = OERDefinition.octets(32).label("HashId32");
        HashedId48 = OERDefinition.octets(48).label("HashId48");
        OERDefinition.Builder label2 = integer3.label("Time32");
        Time32 = label2;
        Time64 = integer4.label("Time64");
        OERDefinition.Builder label3 = OERDefinition.choice(integer2.label("microseconds"), integer2.label("milliseconds"), integer2.label("seconds"), integer2.label("minutes"), integer2.label("hours"), integer2.label("sixtyHours"), integer2.label("years")).label("Duration");
        Duration = label3;
        ValidityPeriod = OERDefinition.seq(label2, label3).label("ValidityPeriod");
        IValue = integer2.copy().label("IValue");
        Hostname = OERDefinition.utf8String(0, 255).label("Hostname");
        LinkageValue = OERDefinition.octets(9).label("LinkageValue");
        GroupLinkageValue = OERDefinition.seq(OERDefinition.octets(4), OERDefinition.octets(9)).label("GroupLinkageValue");
        LaId = OERDefinition.octets(2).label("LaId");
        LinkageSeed = OERDefinition.octets(16).label("LinkageSeed");
        OERDefinition.Builder label4 = OERDefinition.choice(OERDefinition.octets(32), OERDefinition.nullValue(), OERDefinition.octets(32), OERDefinition.octets(32), OERDefinition.seq(OERDefinition.octets(32), OERDefinition.octets(32))).label("EccP256CurvePoint");
        EccP256CurvePoint = label4;
        OERDefinition.Builder label5 = OERDefinition.seq(label4, OERDefinition.octets(32)).label("EcdsaP256Signature");
        EcdsaP256Signature = label5;
        OERDefinition.Builder label6 = OERDefinition.choice(OERDefinition.octets(48), OERDefinition.nullValue(), OERDefinition.octets(48), OERDefinition.octets(48), OERDefinition.seq(OERDefinition.octets(48), OERDefinition.octets(48))).label("EccP384CurvePoint");
        EccP384CurvePoint = label6;
        OERDefinition.Builder label7 = OERDefinition.seq(label6, OERDefinition.octets(48)).label("EcdsaP384Signature");
        EcdsaP384Signature = label7;
        Signature = OERDefinition.choice(label5, label5, OERDefinition.extension(), label7).label("Signature");
        OERDefinition.Builder label8 = OERDefinition.enumeration(OERDefinition.enumItem("aes128Ccm"), OERDefinition.extension()).label("SymmAlgorithm");
        SymmAlgorithm = label8;
        HashAlgorithm = OERDefinition.enumeration(OERDefinition.enumItem("sha256"), OERDefinition.extension(), OERDefinition.enumItem("sha384")).label("HashAlgorithm");
        EciesP256EncryptedKey = OERDefinition.seq(label4.copy().label("v(EccP256CurvePoint)"), OERDefinition.octets(16).label("c"), OERDefinition.octets(16).label("t")).label("EciesP256EncryptedKey");
        OERDefinition.Builder label9 = OERDefinition.choice(label4, label4, OERDefinition.extension()).label("BasePublicEncryptionKey");
        BasePublicEncryptionKey = label9;
        OERDefinition.Builder label10 = OERDefinition.seq(label8, label9).label("PublicEncryptionKey");
        PublicEncryptionKey = label10;
        OERDefinition.Builder label11 = OERDefinition.choice(OERDefinition.octets(16).label("aes128Ccm"), OERDefinition.extension()).label("SymmetricEncryptionKey");
        SymmetricEncryptionKey = label11;
        EncryptionKey = OERDefinition.choice(label10.label("public"), label11.label("symmetric")).label("EncryptionKey");
        PublicVerificationKey = OERDefinition.choice(label4.label("ecdsaNistP256"), label4.label("ecdsaBrainpoolP256r1"), OERDefinition.extension(), label6.label("ecdsaBrainpoolP384r1")).label("PublicVerificationKey");
        OERDefinition.Builder label12 = OERDefinition.integer().rangeToMAXFrom(0L).label("Psid");
        Psid = label12;
        OERDefinition.Builder label13 = OERDefinition.octets(0, 31).label("BitmapSsp");
        BitmapSsp = label13;
        OERDefinition.Builder label14 = OERDefinition.choice(OERDefinition.octets().unbounded().label("opaque"), OERDefinition.extension(), label13).label("ServiceSpecificPermissions");
        ServiceSpecificPermissions = label14;
        OERDefinition.Builder label15 = OERDefinition.seq(label12, OERDefinition.optional(label14)).label("PsidSsp");
        PsidSsp = label15;
        SequenceOfPsidSsp = OERDefinition.seqof(label15).label("SequenceOfPsidSsp");
        SequenceOfPsid = OERDefinition.seqof(label12).label("SequenceOfPsid");
        OERDefinition.Builder label16 = OERDefinition.seqof(OERDefinition.octets().rangeToMAXFrom(0L)).label("SequenceOfOctetString");
        SequenceOfOctetString = label16;
        OERDefinition.Builder label17 = OERDefinition.seq(OERDefinition.octets(1, 32).label("sspValue"), OERDefinition.octets(1, 32).label("sspBitMask")).label("BitmapSspRange");
        BitmapSspRange = label17;
        OERDefinition.Builder label18 = OERDefinition.choice(label16.label("opaque"), OERDefinition.nullValue().label("all"), OERDefinition.extension(), label17.label("bitmapSspRange")).label("SspRange");
        SspRange = label18;
        OERDefinition.Builder label19 = OERDefinition.seq(label12.label("psid"), OERDefinition.optional(label18.label("sspRange"))).label("PsidSspRange");
        PsidSspRange = label19;
        SequenceOfPsidSspRange = OERDefinition.seqof(label19).label("SequenceOfPsidSspRange");
        SubjectAssurance = OERDefinition.octets(1).label("SubjectAssurance");
        CrlSeries = integer2.label("CrlSeries");
        OERDefinition.Builder label20 = integer2.label("CountryOnly");
        CountryOnly = label20;
        CountryAndRegions = OERDefinition.seq(label20, OERDefinition.seqof(integer)).label("CountryAndRegions");
        OERDefinition.Builder label21 = OERDefinition.seq(integer, OERDefinition.seqof(integer2)).label("RegionAndSubregions");
        RegionAndSubregions = label21;
        OERDefinition.Builder label22 = OERDefinition.seqof(label21).label("SequenceOfRegionAndSubregions");
        SequenceOfRegionAndSubregions = label22;
        CountryAndSubregions = OERDefinition.seq(CountryOnly, label22).label("CountryAndSubregions");
        OERDefinition.Builder label23 = OERDefinition.integer(-1799999999L, 1800000001L).label("OneEightyDegreeInt");
        OneEightyDegreeInt = label23;
        KnownLongitude = label23.copy().label("KnownLongitude(OneEightyDegreeInt)");
        UnknownLongitude = OERDefinition.integer(1800000001L).label("UnknownLongitude");
        OERDefinition.Builder label24 = OERDefinition.integer(-900000000L, 900000001L).label("NinetyDegreeInt");
        NinetyDegreeInt = label24;
        KnownLatitude = label24.copy().label("KnownLatitude(NinetyDegreeInt)");
        UnknownLatitude = OERDefinition.integer(900000001L);
        Elevation = integer2.label("Elevation");
        Longitude = OneEightyDegreeInt.copy().label("Longitude(OneEightyDegreeInt)");
        OERDefinition.Builder label25 = NinetyDegreeInt.copy().label("Latitude(NinetyDegreeInt)");
        Latitude = label25;
        ThreeDLocation = OERDefinition.seq(label25, Longitude, Elevation).label("ThreeDLocation");
        OERDefinition.Builder label26 = OERDefinition.seq(Latitude, Longitude).label("TwoDLocation");
        TwoDLocation = label26;
        OERDefinition.Builder label27 = OERDefinition.seq(label26, label26).label("RectangularRegion");
        RectangularRegion = label27;
        SequenceOfRectangularRegion = OERDefinition.seqof(label27).label("SequenceOfRectangularRegion");
        CircularRegion = OERDefinition.seq(TwoDLocation, integer2).label("CircularRegion");
        PolygonalRegion = OERDefinition.seqof(TwoDLocation).rangeToMAXFrom(3L).label("PolygonalRegion");
        OERDefinition.Builder label28 = OERDefinition.choice(CountryOnly, CountryAndRegions, CountryAndSubregions, OERDefinition.extension()).label("IdentifiedRegion");
        IdentifiedRegion = label28;
        OERDefinition.Builder label29 = OERDefinition.seqof(label28).label("SequenceOfIdentifiedRegion");
        SequenceOfIdentifiedRegion = label29;
        GeographicRegion = OERDefinition.choice(CircularRegion, SequenceOfRectangularRegion, PolygonalRegion, label29, OERDefinition.extension()).label("GeographicRegion");
    }
}
