package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* loaded from: classes6.dex */
public class X25519KeyGenerationParameters extends KeyGenerationParameters {
    public X25519KeyGenerationParameters(SecureRandom secureRandom) {
        super(secureRandom, 255);
    }
}
