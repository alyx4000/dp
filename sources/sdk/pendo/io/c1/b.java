package sdk.pendo.io.c1;

import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static final sdk.pendo.io.h7.a f942a;
    private static Class<c> b;

    static {
        sdk.pendo.io.h7.a a2 = sdk.pendo.io.h7.b.a((Class<?>) b.class);
        f942a = a2;
        String property = System.getProperty("external.sdk.pendo.io.jose4j.jwe.kdf.ConcatenationKeyDerivationFunctionWithSha256");
        if (property != null) {
            try {
                Class cls = Class.forName(property);
                b = cls;
                c cVar = (c) cls.newInstance();
                cVar.a(new byte[]{124, -81, BuiltinOptions.PadV2Options, 14, -71, -72, -84, BuiltinOptions.LeakyReluOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.RangeOptions, -52, -39, BuiltinOptions.ResizeNearestNeighborOptions, -58, BuiltinOptions.MirrorPadOptions, -83}, 512, new byte[8]);
                a2.a("Using custom ConcatenationKeyDerivationFunctionWithSha256 implementation: " + cVar.getClass());
            } catch (Throwable th) {
                b = null;
                f942a.a("Using jose4j's concatenation key derivation function implementation because of problems with " + property, th);
            }
        }
    }

    b() {
    }

    static c a(String str) {
        Class<c> cls = b;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                f942a.a("Unable to create new instance of " + b, (Throwable) e);
            }
        }
        return new a("SHA-256", str);
    }
}
