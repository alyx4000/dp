package expo.modules.filesystem;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: FileSystemExceptions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/filesystem/FileSystemCannotCreateFileException;", "Lexpo/modules/kotlin/exception/CodedException;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileSystemCannotCreateFileException extends CodedException {
    public FileSystemCannotCreateFileException(Uri uri) {
        super((uri == null || (r3 = new StringBuilder("Provided uri '").append(uri).append("' is not pointing to a directory").toString()) == null) ? "Unknown error" : r3, null, 2, null);
        String sb;
    }
}
