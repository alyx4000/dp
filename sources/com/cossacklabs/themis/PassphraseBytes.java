package com.cossacklabs.themis;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

/* loaded from: classes.dex */
class PassphraseBytes extends KeyBytes {
    PassphraseBytes(byte[] bArr) {
        super(bArr);
    }

    PassphraseBytes(String str, Charset charset) {
        super(encodePassphrase(str, charset));
    }

    private static byte[] encodePassphrase(String str, Charset charset) {
        if (str == null) {
            throw new NullArgumentException("passphrase cannot be null");
        }
        if (charset == null) {
            throw new NullArgumentException("charset cannot be null");
        }
        try {
            ByteBuffer encode = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str));
            if (encode.hasArray() && encode.arrayOffset() == 0) {
                byte[] array = encode.array();
                if (array.length == encode.remaining()) {
                    return array;
                }
            }
            byte[] bArr = new byte[encode.remaining()];
            encode.get(bArr);
            return bArr;
        } catch (CharacterCodingException e) {
            throw new RuntimeException("failed to encode passphrase in " + charset, e);
        }
    }
}
