package com.facebook.common.util;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.facebook.infer.annotation.Assertions;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class UriUtil {
    public static final String DATA_SCHEME = "data";
    public static final String HTTPS_SCHEME = "https";
    public static final String HTTP_SCHEME = "http";
    public static final String LOCAL_ASSET_SCHEME = "asset";
    private static final Uri LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath((Uri) Assertions.assumeNotNull(ContactsContract.AUTHORITY_URI), "display_photo");
    public static final String LOCAL_CONTENT_SCHEME = "content";
    public static final String LOCAL_FILE_SCHEME = "file";
    public static final String LOCAL_RESOURCE_SCHEME = "res";
    public static final String QUALIFIED_RESOURCE_SCHEME = "android.resource";

    @Nullable
    public static URL uriToUrl(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isNetworkUri(@Nullable Uri uri) {
        String schemeOrNull = getSchemeOrNull(uri);
        return "https".equals(schemeOrNull) || "http".equals(schemeOrNull);
    }

    public static boolean isLocalFileUri(@Nullable Uri uri) {
        return "file".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContentUri(@Nullable Uri uri) {
        return "content".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContactUri(Uri uri) {
        return uri.getPath() != null && isLocalContentUri(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith((String) Assertions.assumeNotNull(LOCAL_CONTACT_IMAGE_URI.getPath()));
    }

    public static boolean isLocalCameraUri(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean isLocalAssetUri(@Nullable Uri uri) {
        return LOCAL_ASSET_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalResourceUri(@Nullable Uri uri) {
        return LOCAL_RESOURCE_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isQualifiedResourceUri(@Nullable Uri uri) {
        return QUALIFIED_RESOURCE_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isDataUri(@Nullable Uri uri) {
        return "data".equals(getSchemeOrNull(uri));
    }

    @Nullable
    public static String getSchemeOrNull(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    @Nullable
    public static Uri parseUriOrNull(@Nullable String str) {
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    @Nullable
    public static String getRealPathFromUri(ContentResolver contentResolver, Uri uri) {
        int columnIndex;
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        String string = null;
        if (isLocalContentUri(uri)) {
            try {
                Cursor query = contentResolver.query(uri, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) != -1) {
                            string = query.getString(columnIndex);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query == null) {
                    return string;
                }
                query.close();
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            if (isLocalFileUri(uri)) {
                return uri.getPath();
            }
            return null;
        }
    }

    @Nullable
    public static AssetFileDescriptor getAssetFileDescriptor(ContentResolver contentResolver, Uri uri) {
        if (isLocalContentUri(uri)) {
            try {
                return contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    public static Uri getUriForFile(File file) {
        return Uri.fromFile(file);
    }

    public static Uri getUriForResourceId(int i) {
        return new Uri.Builder().scheme(LOCAL_RESOURCE_SCHEME).path(String.valueOf(i)).build();
    }

    public static Uri getUriForQualifiedResource(String str, int i) {
        return new Uri.Builder().scheme(QUALIFIED_RESOURCE_SCHEME).authority(str).path(String.valueOf(i)).build();
    }
}
