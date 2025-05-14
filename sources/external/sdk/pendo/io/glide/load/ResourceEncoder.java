package external.sdk.pendo.io.glide.load;

import java.io.File;
import sdk.pendo.io.q.d;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public interface ResourceEncoder<T> extends d<c<T>> {
    @Override // sdk.pendo.io.q.d
    /* synthetic */ boolean encode(Object obj, File file, Options options);

    sdk.pendo.io.q.c getEncodeStrategy(Options options);
}
