package expo.modules.medialibrary.albums.migration;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckIfAlbumShouldBeMigrated.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¨\u0006\u0006"}, d2 = {"getAlbumDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "albumId", "", "expo-media-library_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckIfAlbumShouldBeMigratedKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final File getAlbumDirectory(Context context, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri external_content_uri = MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI();
        Cursor query = contentResolver.query(external_content_uri, new String[]{"_data"}, "media_type != 0 AND bucket_id=?", new String[]{str}, null);
        try {
            Cursor cursor = query;
            if (cursor != null && cursor.moveToNext()) {
                File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
                if (file.isFile()) {
                    String parent = file.getParent();
                    if (parent == null) {
                        CloseableKt.closeFinally(query, null);
                        return null;
                    }
                    Intrinsics.checkNotNullExpressionValue(parent, "fileInAlbum.parent ?: return null");
                    File file2 = new File(parent);
                    CloseableKt.closeFinally(query, null);
                    return file2;
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(query, th);
                throw th2;
            }
        }
    }
}
