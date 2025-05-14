package external.sdk.pendo.io.glide.load.resource.transcode;

import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.b0.a;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class UnitTranscoder<Z> implements a<Z, Z> {
    private static final UnitTranscoder<?> UNIT_TRANSCODER = new UnitTranscoder<>();

    public static <Z> a<Z, Z> get() {
        return UNIT_TRANSCODER;
    }

    @Override // sdk.pendo.io.b0.a
    public c<Z> transcode(c<Z> cVar, Options options) {
        return cVar;
    }
}
