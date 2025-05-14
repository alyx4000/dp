package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import sdk.pendo.io.q.g;

/* loaded from: classes2.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final String TAG = "BitmapEncoder";
    private final sdk.pendo.io.u.a arrayPool;
    public static final g<Integer> COMPRESSION_QUALITY = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final g<Bitmap.CompressFormat> COMPRESSION_FORMAT = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder
    public sdk.pendo.io.q.c getEncodeStrategy(Options options) {
        return sdk.pendo.io.q.c.TRANSFORMED;
    }

    public BitmapEncoder(sdk.pendo.io.u.a aVar) {
        this.arrayPool = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #5 {all -> 0x00c8, blocks: (B:3:0x0023, B:15:0x004e, B:18:0x006d, B:20:0x0073, B:42:0x00c4, B:40:0x00c7, B:37:0x0069), top: B:2:0x0023 }] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder, sdk.pendo.io.q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean encode(sdk.pendo.io.t.c<android.graphics.Bitmap> r9, java.io.File r10, external.sdk.pendo.io.glide.load.Options r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.String r1 = "Compressed with type: "
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r2 = r8.getFormat(r9, r11)
            int r3 = r9.getWidth()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = r9.getHeight()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "encode: [%dx%d] %s"
            sdk.pendo.io.j0.b.a(r5, r3, r4, r2)
            long r3 = sdk.pendo.io.i0.f.a()     // Catch: java.lang.Throwable -> Lc8
            sdk.pendo.io.q.g<java.lang.Integer> r5 = external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_QUALITY     // Catch: java.lang.Throwable -> Lc8
            java.lang.Object r5 = r11.get(r5)     // Catch: java.lang.Throwable -> Lc8
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> Lc8
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> Lc8
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            sdk.pendo.io.u.a r10 = r8.arrayPool     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            if (r10 == 0) goto L46
            sdk.pendo.io.r.a r10 = new sdk.pendo.io.r.a     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            sdk.pendo.io.u.a r6 = r8.arrayPool     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r6 = r10
            goto L47
        L46:
            r6 = r7
        L47:
            r9.compress(r2, r5, r6)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r6.close()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r10 = 1
            r6.close()     // Catch: java.io.IOException -> L6c java.lang.Throwable -> Lc8
            goto L6c
        L52:
            r9 = move-exception
            goto Lc2
        L54:
            r10 = move-exception
            r6 = r7
            goto L5a
        L57:
            r9 = move-exception
            goto Lc1
        L59:
            r10 = move-exception
        L5a:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L66
            java.lang.String r5 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r5, r10)     // Catch: java.lang.Throwable -> L57
        L66:
            r10 = 0
            if (r6 == 0) goto L6c
            r6.close()     // Catch: java.io.IOException -> L6c java.lang.Throwable -> Lc8
        L6c:
            r5 = 2
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> Lc8
            if (r5 == 0) goto Lbd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc8
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r1 = r5.append(r2)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r2 = " of size "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lc8
            int r2 = sdk.pendo.io.i0.k.a(r9)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r2 = " in "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lc8
            double r2 = sdk.pendo.io.i0.f.a(r3)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r2 = ", options format: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lc8
            sdk.pendo.io.q.g<android.graphics.Bitmap$CompressFormat> r2 = external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_FORMAT     // Catch: java.lang.Throwable -> Lc8
            java.lang.Object r11 = r11.get(r2)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r11 = r1.append(r11)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r1 = ", hasAlpha: "
            java.lang.StringBuilder r11 = r11.append(r1)     // Catch: java.lang.Throwable -> Lc8
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r9 = r11.append(r9)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc8
            android.util.Log.v(r0, r9)     // Catch: java.lang.Throwable -> Lc8
        Lbd:
            sdk.pendo.io.j0.b.a()
            return r10
        Lc1:
            r7 = r6
        Lc2:
            if (r7 == 0) goto Lc7
            r7.close()     // Catch: java.io.IOException -> Lc7 java.lang.Throwable -> Lc8
        Lc7:
            throw r9     // Catch: java.lang.Throwable -> Lc8
        Lc8:
            r9 = move-exception
            sdk.pendo.io.j0.b.a()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder.encode(sdk.pendo.io.t.c, java.io.File, external.sdk.pendo.io.glide.load.Options):boolean");
    }
}
