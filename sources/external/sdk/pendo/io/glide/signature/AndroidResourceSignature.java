package external.sdk.pendo.io.glide.signature;

import android.content.Context;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.h0.a;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public final class AndroidResourceSignature implements f {
    private final f applicationVersion;
    private final int nightMode;

    private AndroidResourceSignature(int i, f fVar) {
        this.nightMode = i;
        this.applicationVersion = fVar;
    }

    public static f obtain(Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, a.b(context));
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidResourceSignature)) {
            return false;
        }
        AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
        return this.nightMode == androidResourceSignature.nightMode && this.applicationVersion.equals(androidResourceSignature.applicationVersion);
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return k.a(this.applicationVersion, this.nightMode);
    }

    @Override // sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.applicationVersion.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.nightMode).array());
    }
}
