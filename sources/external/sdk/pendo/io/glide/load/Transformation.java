package external.sdk.pendo.io.glide.load;

import android.content.Context;
import java.security.MessageDigest;
import sdk.pendo.io.q.f;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public interface Transformation<T> extends f {
    c<T> transform(Context context, c<T> cVar, int i, int i2);

    @Override // sdk.pendo.io.q.f
    /* synthetic */ void updateDiskCacheKey(MessageDigest messageDigest);
}
