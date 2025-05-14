package com.google.crypto.tink.jwt;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Optional;

/* loaded from: classes5.dex */
final class JwtFormat {
    static boolean isValidUrlsafeBase64Char(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '-' || c == '_');
    }

    static class Parts {
        String header;
        String payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        Parts(String unsignedCompact, byte[] signatureOrMac, String header, String payload) {
            this.unsignedCompact = unsignedCompact;
            this.signatureOrMac = signatureOrMac;
            this.header = header;
            this.payload = payload;
        }
    }

    private JwtFormat() {
    }

    static void validateUtf8(byte[] data) throws JwtInvalidException {
        try {
            Util.UTF_8.newDecoder().decode(ByteBuffer.wrap(data));
        } catch (CharacterCodingException e) {
            throw new JwtInvalidException(e.getMessage());
        }
    }

    static byte[] strictUrlSafeDecode(String encodedData) throws JwtInvalidException {
        for (int i = 0; i < encodedData.length(); i++) {
            if (!isValidUrlsafeBase64Char(encodedData.charAt(i))) {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return Base64.urlSafeDecode(encodedData);
        } catch (IllegalArgumentException e) {
            throw new JwtInvalidException("invalid encoding: " + e);
        }
    }

    private static void validateAlgorithm(String algo) throws InvalidAlgorithmParameterException {
        algo.hashCode();
        switch (algo) {
            case "ES256":
            case "ES384":
            case "ES512":
            case "HS256":
            case "HS384":
            case "HS512":
            case "PS256":
            case "PS384":
            case "PS512":
            case "RS256":
            case "RS384":
            case "RS512":
                return;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: " + algo);
        }
    }

    static String createHeader(String algorithm, Optional<String> typeHeader, Optional<String> kid) throws InvalidAlgorithmParameterException {
        validateAlgorithm(algorithm);
        JsonObject jsonObject = new JsonObject();
        if (kid.isPresent()) {
            jsonObject.addProperty("kid", kid.get());
        }
        jsonObject.addProperty("alg", algorithm);
        if (typeHeader.isPresent()) {
            jsonObject.addProperty(ClientData.KEY_TYPE, typeHeader.get());
        }
        return Base64.urlSafeEncode(jsonObject.toString().getBytes(Util.UTF_8));
    }

    private static void validateKidInHeader(String expectedKid, JsonObject parsedHeader) throws JwtInvalidException {
        if (!getStringHeader(parsedHeader, "kid").equals(expectedKid)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    static void validateHeader(String expectedAlgorithm, Optional<String> tinkKid, Optional<String> customKid, JsonObject parsedHeader) throws InvalidAlgorithmParameterException, JwtInvalidException {
        validateAlgorithm(expectedAlgorithm);
        String stringHeader = getStringHeader(parsedHeader, "alg");
        if (!stringHeader.equals(expectedAlgorithm)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", expectedAlgorithm, stringHeader));
        }
        if (parsedHeader.has("crit")) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        }
        if (tinkKid.isPresent() && customKid.isPresent()) {
            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
        }
        boolean has = parsedHeader.has("kid");
        if (tinkKid.isPresent()) {
            if (!has) {
                throw new JwtInvalidException("missing kid in header");
            }
            validateKidInHeader(tinkKid.get(), parsedHeader);
        }
        if (customKid.isPresent() && has) {
            validateKidInHeader(customKid.get(), parsedHeader);
        }
    }

    static Optional<String> getTypeHeader(JsonObject header) throws JwtInvalidException {
        if (header.has(ClientData.KEY_TYPE)) {
            return Optional.of(getStringHeader(header, ClientData.KEY_TYPE));
        }
        return Optional.empty();
    }

    private static String getStringHeader(JsonObject header, String name) throws JwtInvalidException {
        if (!header.has(name)) {
            throw new JwtInvalidException("header " + name + " does not exist");
        }
        if (!header.get(name).isJsonPrimitive() || !header.get(name).getAsJsonPrimitive().isString()) {
            throw new JwtInvalidException("header " + name + " is not a string");
        }
        return header.get(name).getAsString();
    }

    static String decodeHeader(String headerStr) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(headerStr);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, Util.UTF_8);
    }

    static String encodePayload(String jsonPayload) {
        return Base64.urlSafeEncode(jsonPayload.getBytes(Util.UTF_8));
    }

    static String decodePayload(String payloadStr) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(payloadStr);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, Util.UTF_8);
    }

    static String encodeSignature(byte[] signature) {
        return Base64.urlSafeEncode(signature);
    }

    static byte[] decodeSignature(String signatureStr) throws JwtInvalidException {
        return strictUrlSafeDecode(signatureStr);
    }

    static Optional<String> getKid(int keyId, OutputPrefixType prefix) throws JwtInvalidException {
        if (prefix == OutputPrefixType.RAW) {
            return Optional.empty();
        }
        if (prefix == OutputPrefixType.TINK) {
            return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(keyId).array()));
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    static Optional<Integer> getKeyId(String kid) {
        byte[] urlSafeDecode = Base64.urlSafeDecode(kid);
        if (urlSafeDecode.length != 4) {
            return Optional.empty();
        }
        return Optional.of(Integer.valueOf(ByteBuffer.wrap(urlSafeDecode).getInt()));
    }

    static Parts splitSignedCompact(String signedCompact) throws JwtInvalidException {
        validateASCII(signedCompact);
        int lastIndexOf = signedCompact.lastIndexOf(46);
        if (lastIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String substring = signedCompact.substring(0, lastIndexOf);
        byte[] decodeSignature = decodeSignature(signedCompact.substring(lastIndexOf + 1));
        int indexOf = substring.indexOf(46);
        if (indexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        if (substring3.indexOf(46) > 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        return new Parts(substring, decodeSignature, decodeHeader(substring2), decodePayload(substring3));
    }

    static String createUnsignedCompact(String algorithm, Optional<String> kid, RawJwt rawJwt) throws InvalidAlgorithmParameterException, JwtInvalidException {
        return createHeader(algorithm, rawJwt.hasTypeHeader() ? Optional.of(rawJwt.getTypeHeader()) : Optional.empty(), kid) + "." + encodePayload(rawJwt.getJsonPayload());
    }

    static String createSignedCompact(String unsignedCompact, byte[] signature) {
        return unsignedCompact + "." + encodeSignature(signature);
    }

    static void validateASCII(String data) throws JwtInvalidException {
        for (int i = 0; i < data.length(); i++) {
            if ((data.charAt(i) & 128) > 0) {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }
}
