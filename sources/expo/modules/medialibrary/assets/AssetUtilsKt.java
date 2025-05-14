package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.BaseJavaModule;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AssetQueryException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaType;
import io.sentry.protocol.Device;
import io.sentry.protocol.Response;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUtils.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a<\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003\u001a\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\t\u001a*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003\u001a<\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e\u001a=\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010$2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&¢\u0006\u0002\u0010'¨\u0006("}, d2 = {"exportMediaType", "", "mediaType", "", "getAssetDimensionsFromCursor", "Lkotlin/Pair;", "contentResolver", "Landroid/content/ContentResolver;", "exifInterface", "Landroidx/exifinterface/media/ExifInterface;", "cursor", "Landroid/database/Cursor;", "localUriColumnIndex", "getExifFullInfo", "", Response.TYPE, "Landroid/os/Bundle;", "getExifLocationForUri", "photoUri", "Landroid/net/Uri;", "getExifLocationLegacy", "maybeRotateAssetSize", "width", "height", Device.JsonKeys.ORIENTATION, "putAssetsInfo", "", "limit", "offset", "resolveWithFullInfo", "", "queryAssetInfo", "context", "Landroid/content/Context;", "selection", "selectionArgs", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;ZLexpo/modules/kotlin/Promise;)V", "expo-media-library_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AssetUtilsKt {
    public static final void queryAssetInfo(Context context, String str, String[] strArr, boolean z, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor query = contentResolver.query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), MediaLibraryConstantsKt.getASSET_PROJECTION(), str, strArr, null);
            try {
                Cursor cursor = query;
                if (cursor == null) {
                    throw new AssetQueryException();
                }
                if (cursor.getCount() == 1) {
                    cursor.moveToFirst();
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
                    putAssetsInfo(contentResolver, cursor, arrayList, 1, 0, z);
                    promise.resolve(arrayList);
                } else {
                    promise.resolve(null);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(query, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            promise.reject(MediaLibraryConstantsKt.ERROR_IO_EXCEPTION, "Could not read file", e);
        } catch (SecurityException e2) {
            promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get asset: need READ_EXTERNAL_STORAGE permission.", e2);
        } catch (UnsupportedOperationException e3) {
            e3.printStackTrace();
            promise.reject(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS, e3.getMessage(), e3);
        }
    }

    public static final void putAssetsInfo(ContentResolver contentResolver, Cursor cursor, List<Bundle> response, int i, int i2, boolean z) throws IOException, UnsupportedOperationException {
        int i3;
        ExifInterface exifInterface;
        Bundle exifLocationLegacy;
        ContentResolver contentResolver2 = contentResolver;
        Intrinsics.checkNotNullParameter(contentResolver2, "contentResolver");
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(response, "response");
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_display_name");
        int columnIndex3 = cursor.getColumnIndex("media_type");
        int columnIndex4 = cursor.getColumnIndex("datetaken");
        int columnIndex5 = cursor.getColumnIndex("date_modified");
        int columnIndex6 = cursor.getColumnIndex("duration");
        int columnIndex7 = cursor.getColumnIndex("_data");
        int columnIndex8 = cursor.getColumnIndex("bucket_id");
        if (cursor.moveToPosition(i2)) {
            int i4 = i;
            int i5 = 0;
            while (i5 < i4 && !cursor.isAfterLast()) {
                String string = cursor.getString(columnIndex);
                String string2 = cursor.getString(columnIndex7);
                int i6 = columnIndex;
                String str = "file://" + string2;
                int i7 = cursor.getInt(columnIndex3);
                int i8 = columnIndex3;
                if (i7 == 1) {
                    try {
                        exifInterface = new ExifInterface(string2);
                        i3 = i5;
                    } catch (IOException e) {
                        i3 = i5;
                        Log.w("expo-media-library", "Could not parse EXIF tags for " + str);
                        e.printStackTrace();
                    }
                    Pair<Integer, Integer> assetDimensionsFromCursor = getAssetDimensionsFromCursor(contentResolver2, exifInterface, cursor, i7, columnIndex7);
                    int intValue = assetDimensionsFromCursor.component1().intValue();
                    int intValue2 = assetDimensionsFromCursor.component2().intValue();
                    int i9 = columnIndex7;
                    Bundle bundle = new Bundle();
                    bundle.putString("id", string);
                    bundle.putString("filename", cursor.getString(columnIndex2));
                    bundle.putString("uri", str);
                    bundle.putString("mediaType", exportMediaType(i7));
                    bundle.putLong("width", intValue);
                    bundle.putLong("height", intValue2);
                    bundle.putLong("creationTime", cursor.getLong(columnIndex4));
                    bundle.putDouble("modificationTime", cursor.getLong(columnIndex5) * 1000.0d);
                    bundle.putDouble("duration", cursor.getInt(columnIndex6) / 1000.0d);
                    bundle.putString("albumId", cursor.getString(columnIndex8));
                    if (z || exifInterface == null) {
                        contentResolver2 = contentResolver;
                    } else {
                        getExifFullInfo(exifInterface, bundle);
                        if (Build.VERSION.SDK_INT >= 29) {
                            Uri photoUri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, string);
                            Intrinsics.checkNotNullExpressionValue(photoUri, "photoUri");
                            contentResolver2 = contentResolver;
                            exifLocationLegacy = getExifLocationForUri(contentResolver2, photoUri);
                        } else {
                            contentResolver2 = contentResolver;
                            exifLocationLegacy = getExifLocationLegacy(exifInterface);
                        }
                        bundle.putParcelable(IterableConstants.ITERABLE_IN_APP_LOCATION, exifLocationLegacy);
                        bundle.putString("localUri", str);
                    }
                    cursor.moveToNext();
                    response.add(bundle);
                    i5 = i3 + 1;
                    i4 = i;
                    columnIndex = i6;
                    columnIndex3 = i8;
                    columnIndex7 = i9;
                } else {
                    i3 = i5;
                }
                exifInterface = null;
                Pair<Integer, Integer> assetDimensionsFromCursor2 = getAssetDimensionsFromCursor(contentResolver2, exifInterface, cursor, i7, columnIndex7);
                int intValue3 = assetDimensionsFromCursor2.component1().intValue();
                int intValue22 = assetDimensionsFromCursor2.component2().intValue();
                int i92 = columnIndex7;
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", string);
                bundle2.putString("filename", cursor.getString(columnIndex2));
                bundle2.putString("uri", str);
                bundle2.putString("mediaType", exportMediaType(i7));
                bundle2.putLong("width", intValue3);
                bundle2.putLong("height", intValue22);
                bundle2.putLong("creationTime", cursor.getLong(columnIndex4));
                bundle2.putDouble("modificationTime", cursor.getLong(columnIndex5) * 1000.0d);
                bundle2.putDouble("duration", cursor.getInt(columnIndex6) / 1000.0d);
                bundle2.putString("albumId", cursor.getString(columnIndex8));
                if (z) {
                }
                contentResolver2 = contentResolver;
                cursor.moveToNext();
                response.add(bundle2);
                i5 = i3 + 1;
                i4 = i;
                columnIndex = i6;
                columnIndex3 = i8;
                columnIndex7 = i92;
            }
        }
    }

    public static final void getExifFullInfo(ExifInterface exifInterface, Bundle response) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundle = new Bundle();
        for (String[] strArr : MediaLibraryConstantsKt.getEXIF_TAGS()) {
            String str = strArr[0];
            String str2 = strArr[1];
            if (exifInterface.getAttribute(str2) != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1325958191) {
                    if (hashCode != -891985903) {
                        if (hashCode == 104431 && str.equals("int")) {
                            bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                        }
                    } else if (str.equals("string")) {
                        bundle.putString(str2, exifInterface.getAttribute(str2));
                    }
                } else if (str.equals("double")) {
                    bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, 0.0d));
                }
            }
        }
        response.putParcelable("exif", bundle);
    }

    public static final Bundle getExifLocationForUri(ContentResolver contentResolver, Uri photoUri) throws UnsupportedOperationException, IOException {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(photoUri, "photoUri");
        try {
            Uri requireOriginal = MediaStore.setRequireOriginal(photoUri);
            Intrinsics.checkNotNullExpressionValue(requireOriginal, "setRequireOriginal(photoUri)");
            InputStream openInputStream = contentResolver.openInputStream(requireOriginal);
            if (openInputStream == null) {
                return null;
            }
            InputStream inputStream = openInputStream;
            try {
                double[] latLong = new ExifInterface(inputStream).getLatLong();
                if (latLong != null) {
                    double d = latLong[0];
                    double d2 = latLong[1];
                    bundle = new Bundle();
                    bundle.putDouble("latitude", d);
                    bundle.putDouble("longitude", d2);
                } else {
                    bundle = null;
                }
                CloseableKt.closeFinally(inputStream, null);
                return bundle;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            Log.w("expo-media-library", "Could not parse EXIF tags for " + photoUri);
            e.printStackTrace();
            return null;
        } catch (UnsupportedOperationException unused) {
            throw new UnsupportedOperationException("Cannot access ExifInterface because of missing ACCESS_MEDIA_LOCATION permission");
        }
    }

    public static final Bundle getExifLocationLegacy(ExifInterface exifInterface) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        double[] latLong = exifInterface.getLatLong();
        if (latLong == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("latitude", latLong[0]);
        bundle.putDouble("longitude", latLong[1]);
        return bundle;
    }

    public static final Pair<Integer, Integer> getAssetDimensionsFromCursor(ContentResolver contentResolver, ExifInterface exifInterface, Cursor cursor, int i, int i2) throws IOException {
        int attributeInt;
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        String string = cursor.getString(i2);
        if (i == 3) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(Uri.parse("file://" + string), "r");
                try {
                    AssetFileDescriptor assetFileDescriptor = openAssetFileDescriptor;
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever2 = mediaMetadataRetriever;
                        Intrinsics.checkNotNull(assetFileDescriptor);
                        mediaMetadataRetriever2.setDataSource(assetFileDescriptor.getFileDescriptor());
                        String extractMetadata = mediaMetadataRetriever2.extractMetadata(18);
                        Intrinsics.checkNotNull(extractMetadata);
                        int parseInt = Integer.parseInt(extractMetadata);
                        String extractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                        Intrinsics.checkNotNull(extractMetadata2);
                        int parseInt2 = Integer.parseInt(extractMetadata2);
                        String extractMetadata3 = mediaMetadataRetriever2.extractMetadata(24);
                        Intrinsics.checkNotNull(extractMetadata3);
                        Pair<Integer, Integer> maybeRotateAssetSize = maybeRotateAssetSize(parseInt, parseInt2, Integer.parseInt(extractMetadata3));
                        AutoCloseableKt.closeFinally(mediaMetadataRetriever, null);
                        CloseableKt.closeFinally(openAssetFileDescriptor, null);
                        return maybeRotateAssetSize;
                    } finally {
                    }
                } finally {
                }
            } catch (FileNotFoundException e) {
                Log.e("expo-media-library", "ContentResolver failed to read " + string + ": " + e.getMessage());
            } catch (NumberFormatException e2) {
                Log.e("expo-media-library", "MediaMetadataRetriever unexpectedly returned non-integer: " + e2.getMessage());
            } catch (RuntimeException e3) {
                Log.e("expo-media-library", "MediaMetadataRetriever finished with unexpected error: " + e3.getMessage());
            }
        }
        int columnIndex = cursor.getColumnIndex("width");
        int columnIndex2 = cursor.getColumnIndex("height");
        int columnIndex3 = cursor.getColumnIndex(Device.JsonKeys.ORIENTATION);
        int i3 = cursor.getInt(columnIndex);
        int i4 = cursor.getInt(columnIndex2);
        int i5 = cursor.getInt(columnIndex3);
        if (i == 1 && (i3 <= 0 || i4 <= 0)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(string, options);
            int i6 = options.outWidth;
            i4 = options.outHeight;
            i3 = i6;
        }
        if (exifInterface != null && ((attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) == 5 || attributeInt == 6 || attributeInt == 7 || attributeInt == 8)) {
            i5 = 90;
        }
        return maybeRotateAssetSize(i3, i4, i5);
    }

    public static final String exportMediaType(int i) {
        MediaType mediaType;
        if (i == 1) {
            mediaType = MediaType.PHOTO;
        } else {
            if (i != 2) {
                if (i == 3) {
                    mediaType = MediaType.VIDEO;
                } else if (i != 4) {
                    mediaType = MediaType.UNKNOWN;
                }
            }
            mediaType = MediaType.AUDIO;
        }
        return mediaType.getApiName();
    }

    public static final Pair<Integer, Integer> maybeRotateAssetSize(int i, int i2, int i3) {
        if (Math.abs(i3) % 180 == 90) {
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
