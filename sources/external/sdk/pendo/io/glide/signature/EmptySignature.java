package external.sdk.pendo.io.glide.signature;

import java.security.MessageDigest;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public final class EmptySignature implements f {
    private static final EmptySignature EMPTY_KEY = new EmptySignature();

    private EmptySignature() {
    }

    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
