package expo.modules.clipboard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;

/* compiled from: ClipboardImage.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a!\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a)\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"bitmapFromBase64String", "Landroid/graphics/Bitmap;", "base64Image", "", "bitmapFromContentUriAsync", "context", "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clipDataFromBase64Image", "Landroid/content/ClipData;", "clipboardCacheDir", "Ljava/io/File;", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageFromContentUri", "Lexpo/modules/clipboard/ImageResult;", "options", "Lexpo/modules/clipboard/GetImageOptions;", "(Landroid/content/Context;Landroid/net/Uri;Lexpo/modules/clipboard/GetImageOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureExists", "", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-clipboard_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClipboardImageKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object imageFromContentUri(android.content.Context r6, android.net.Uri r7, expo.modules.clipboard.GetImageOptions r8, kotlin.coroutines.Continuation<? super expo.modules.clipboard.ImageResult> r9) {
        /*
            boolean r0 = r9 instanceof expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1
            if (r0 == 0) goto L14
            r0 = r9
            expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1 r0 = (expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1 r0 = new expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.L$2
            java.io.ByteArrayOutputStream r6 = (java.io.ByteArrayOutputStream) r6
            java.lang.Object r7 = r0.L$1
            expo.modules.clipboard.ImageFormat r7 = (expo.modules.clipboard.ImageFormat) r7
            java.lang.Object r8 = r0.L$0
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L88
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            java.lang.Object r6 = r0.L$0
            r8 = r6
            expo.modules.clipboard.GetImageOptions r8 = (expo.modules.clipboard.GetImageOptions) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L58
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = bitmapFromContentUriAsync(r6, r7, r0)
            if (r9 != r1) goto L58
            return r1
        L58:
            r6 = r9
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            expo.modules.clipboard.ImageFormat r7 = r8.getImageFormat()
            double r8 = r8.getJpegQuality()
            r2 = 100
            double r4 = (double) r2
            double r8 = r8 * r4
            int r8 = (int) r8
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream
            r9.<init>()
            android.graphics.Bitmap$CompressFormat r2 = r7.getCompressFormat()
            r4 = r9
            java.io.OutputStream r4 = (java.io.OutputStream) r4
            r6.compress(r2, r8, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r8 != r1) goto L86
            return r1
        L86:
            r8 = r6
            r6 = r9
        L88:
            byte[] r6 = r6.toByteArray()
            r9 = 0
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r7 = r7.getMimeType()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "data:"
            r0.<init>(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = ";base64,"
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r9.<init>(r7)
            java.lang.StringBuilder r6 = r9.append(r6)
            expo.modules.clipboard.ImageResult r7 = new expo.modules.clipboard.ImageResult
            java.lang.String r6 = r6.toString()
            java.lang.String r9 = "builder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            int r9 = r8.getWidth()
            int r8 = r8.getHeight()
            r7.<init>(r6, r9, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.clipboard.ClipboardImageKt.imageFromContentUri(android.content.Context, android.net.Uri, expo.modules.clipboard.GetImageOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object clipDataFromBase64Image(android.content.Context r9, java.lang.String r10, java.io.File r11, kotlin.coroutines.Continuation<? super android.content.ClipData> r12) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.clipboard.ClipboardImageKt.clipDataFromBase64Image(android.content.Context, java.lang.String, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object bitmapFromContentUriAsync(final android.content.Context r4, final android.net.Uri r5, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r6) {
        /*
            boolean r0 = r6 instanceof expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1 r0 = (expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1 r0 = new expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$2 r2 = new expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$2
            r2.<init>()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.InterruptibleKt.runInterruptible(r6, r2, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            java.lang.String r4 = "context: Context, imageU…source)\n      }\n    }\n  }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.clipboard.ClipboardImageKt.bitmapFromContentUriAsync(android.content.Context, android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Bitmap bitmapFromBase64String(String base64Image) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        try {
            byte[] decode = Base64.decode(base64Image, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null) {
                return decodeByteArray;
            }
            throw new RuntimeException("Failed to convert base64 into Bitmap");
        } catch (RuntimeException e) {
            throw new InvalidImageException(base64Image, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ensureExists(final File file, Continuation<? super Boolean> continuation) {
        return InterruptibleKt.runInterruptible(Dispatchers.getIO(), new Function0<Boolean>() { // from class: expo.modules.clipboard.ClipboardImageKt$ensureExists$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                return Boolean.valueOf(file.createNewFile());
            }
        }, continuation);
    }
}
