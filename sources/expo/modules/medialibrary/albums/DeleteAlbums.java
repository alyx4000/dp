package expo.modules.medialibrary.albums;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.MediaLibraryUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteAlbums.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/medialibrary/albums/DeleteAlbums;", "", "context", "Landroid/content/Context;", "albumIds", "", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/util/List;Lexpo/modules/kotlin/Promise;)V", "mAlbumIds", "", "[Ljava/lang/String;", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeleteAlbums {
    private final Context context;
    private final String[] mAlbumIds;
    private final Promise promise;

    public DeleteAlbums(Context context, List<String> albumIds, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(albumIds, "albumIds");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.promise = promise;
        this.mAlbumIds = (String[]) albumIds.toArray(new String[0]);
    }

    public final void execute() {
        MediaLibraryUtils.INSTANCE.deleteAssets(this.context, "bucket_id IN (" + MediaLibraryUtils.INSTANCE.queryPlaceholdersFor(this.mAlbumIds) + " )", this.mAlbumIds, this.promise);
    }
}
