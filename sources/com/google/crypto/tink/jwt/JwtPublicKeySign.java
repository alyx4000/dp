package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
/* loaded from: classes5.dex */
public interface JwtPublicKeySign {
    String signAndEncode(RawJwt token) throws GeneralSecurityException;
}
