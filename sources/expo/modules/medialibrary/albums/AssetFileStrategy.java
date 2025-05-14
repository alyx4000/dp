package expo.modules.medialibrary.albums;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.albums.AssetFileStrategy;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetFileStrategy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lexpo/modules/medialibrary/albums/AssetFileStrategy;", "", "apply", "Ljava/io/File;", "src", "dir", "context", "Landroid/content/Context;", "Companion", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AssetFileStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    File apply(File src, File dir, Context context) throws IOException;

    /* compiled from: AssetFileStrategy.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/medialibrary/albums/AssetFileStrategy$Companion;", "", "()V", "copyStrategy", "Lexpo/modules/medialibrary/albums/AssetFileStrategy;", "getCopyStrategy", "()Lexpo/modules/medialibrary/albums/AssetFileStrategy;", "moveStrategy", "getMoveStrategy", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final AssetFileStrategy copyStrategy = new AssetFileStrategy() { // from class: expo.modules.medialibrary.albums.AssetFileStrategy$Companion$$ExternalSyntheticLambda0
            @Override // expo.modules.medialibrary.albums.AssetFileStrategy
            public final File apply(File file, File file2, Context context) {
                File copyStrategy$lambda$0;
                copyStrategy$lambda$0 = AssetFileStrategy.Companion.copyStrategy$lambda$0(file, file2, context);
                return copyStrategy$lambda$0;
            }
        };
        private static final AssetFileStrategy moveStrategy = new AssetFileStrategy() { // from class: expo.modules.medialibrary.albums.AssetFileStrategy$Companion$$ExternalSyntheticLambda1
            @Override // expo.modules.medialibrary.albums.AssetFileStrategy
            public final File apply(File file, File file2, Context context) {
                File moveStrategy$lambda$1;
                moveStrategy$lambda$1 = AssetFileStrategy.Companion.moveStrategy$lambda$1(file, file2, context);
                return moveStrategy$lambda$1;
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final File copyStrategy$lambda$0(File src, File dir, Context context) {
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(dir, "dir");
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 2>");
            return MediaLibraryUtils.INSTANCE.safeCopyFile(src, dir);
        }

        public final AssetFileStrategy getCopyStrategy() {
            return copyStrategy;
        }

        public final AssetFileStrategy getMoveStrategy() {
            return moveStrategy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final File moveStrategy$lambda$1(File src, File dir, Context context) {
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(dir, "dir");
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT >= 30 && (src instanceof MediaLibraryUtils.AssetFile)) {
                Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.parseLong(((MediaLibraryUtils.AssetFile) src).getAssetId()));
                Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(MediaStor…NT_URI, assetId.toLong())");
                File safeCopyFile = MediaLibraryUtils.INSTANCE.safeCopyFile(src, dir);
                context.getContentResolver().delete(withAppendedId, null);
                return safeCopyFile;
            }
            File safeMoveFile = MediaLibraryUtils.INSTANCE.safeMoveFile(src, dir);
            context.getContentResolver().delete(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), "_data=?", new String[]{src.getPath()});
            return safeMoveFile;
        }
    }
}
