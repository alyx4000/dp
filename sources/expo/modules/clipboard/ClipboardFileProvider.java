package expo.modules.clipboard;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.actions.SearchIntents;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ClipboardFileProvider.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J1\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0005H\u0016JO\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0011\u001a\u00020\u00122\u0010\u0010!\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010#J;\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010%R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lexpo/modules/clipboard/ClipboardFileProvider;", "Landroid/content/ContentProvider;", "()V", "defaultProjectionColumns", "", "", "[Ljava/lang/String;", "strategy", "Lexpo/modules/clipboard/ClipboardFileProvider$PathStrategy;", "attachInfo", "", "context", "Landroid/content/Context;", "info", "Landroid/content/pm/ProviderInfo;", IterableConstants.ITERABLE_IN_APP_ACTION_DELETE, "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", SearchIntents.EXTRA_QUERY, "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "PathStrategy", "SimplePathStrategy", "expo-clipboard_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClipboardFileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private final String[] defaultProjectionColumns = {"_display_name", "_size"};
    private PathStrategy strategy;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final File DEVICE_ROOT = new File("/");
    private static final HashMap<String, PathStrategy> cache = new HashMap<>();

    /* compiled from: ClipboardFileProvider.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lexpo/modules/clipboard/ClipboardFileProvider$PathStrategy;", "", "getFileForUri", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "getUriForFile", "file", "expo-clipboard_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        super.attachInfo(context, info);
        if (!info.exported) {
            throw new AssertionError("ClipboardFileProvider must be exported");
        }
        Companion companion = INSTANCE;
        String str = info.authority;
        Intrinsics.checkNotNullExpressionValue(str, "info.authority");
        this.strategy = companion.getPathStrategy$expo_clipboard_release(context, str);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        PathStrategy pathStrategy = this.strategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strategy");
            pathStrategy = null;
        }
        File fileForUri = pathStrategy.getFileForUri(uri);
        String name = fileForUri.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            return "application/octet-stream";
        }
        String name2 = fileForUri.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
        String substring = name2.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring);
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int i;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (projection == null) {
            projection = this.defaultProjectionColumns;
        }
        PathStrategy pathStrategy = this.strategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strategy");
            pathStrategy = null;
        }
        File fileForUri = pathStrategy.getFileForUri(uri);
        String[] strArr = new String[projection.length];
        Object[] objArr = new Object[projection.length];
        int i2 = 0;
        for (String str : projection) {
            if (Intrinsics.areEqual(str, "_display_name")) {
                strArr[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileForUri.getName();
            } else if (Intrinsics.areEqual(str, "_size")) {
                strArr[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(fileForUri.length());
            }
            i2 = i;
        }
        Object[] copyOf = Arrays.copyOf(strArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] copyOf2 = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        MatrixCursor matrixCursor = new MatrixCursor((String[]) copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("This is a read-only provider");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("This is a read-only provider");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("This is a read-only provider");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (!Intrinsics.areEqual("r", mode)) {
            throw new IllegalArgumentException("mode must be \"r\"".toString());
        }
        PathStrategy pathStrategy = this.strategy;
        if (pathStrategy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strategy");
            pathStrategy = null;
        }
        return ParcelFileDescriptor.open(pathStrategy.getFileForUri(uri), 268435456);
    }

    /* compiled from: ClipboardFileProvider.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0016\"\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001cJ \u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0007J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/clipboard/ClipboardFileProvider$Companion;", "", "()V", "ATTR_NAME", "", "ATTR_PATH", "DEVICE_ROOT", "Ljava/io/File;", "META_DATA_FILE_PROVIDER_PATHS", "TAG_CACHE_PATH", "TAG_EXTERNAL", "TAG_EXTERNAL_CACHE", "TAG_EXTERNAL_FILES", "TAG_FILES_PATH", "TAG_ROOT_PATH", "cache", "Ljava/util/HashMap;", "Lexpo/modules/clipboard/ClipboardFileProvider$PathStrategy;", "Lkotlin/collections/HashMap;", "buildPath", Constants.SENSITIVITY_BASE, "segments", "", "(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;", "getPathStrategy", "context", "Landroid/content/Context;", "authority", "getPathStrategy$expo_clipboard_release", "getUriForFile", "Landroid/net/Uri;", "file", "parsePathStrategy", "targetFileFromTag", ViewHierarchyNode.JsonKeys.TAG, "expo-clipboard_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uri getUriForFile(Context context, String authority, File file) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(authority, "authority");
            Intrinsics.checkNotNullParameter(file, "file");
            return getPathStrategy$expo_clipboard_release(context, authority).getUriForFile(file);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v9, types: [T, expo.modules.clipboard.ClipboardFileProvider$PathStrategy] */
        public final PathStrategy getPathStrategy$expo_clipboard_release(Context context, String authority) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(authority, "authority");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            synchronized (ClipboardFileProvider.cache) {
                PathStrategy pathStrategy = (PathStrategy) ClipboardFileProvider.cache.get(authority);
                T t = pathStrategy;
                if (pathStrategy == null) {
                    try {
                        objectRef.element = ClipboardFileProvider.INSTANCE.parsePathStrategy(context, authority);
                        ClipboardFileProvider.cache.put(authority, objectRef.element);
                        t = (PathStrategy) objectRef.element;
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to parse expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS meta-data", e);
                    } catch (XmlPullParserException e2) {
                        throw new IllegalArgumentException("Failed to parse expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS meta-data", e2);
                    }
                }
                objectRef.element = t;
                Unit unit = Unit.INSTANCE;
            }
            return (PathStrategy) objectRef.element;
        }

        private final PathStrategy parsePathStrategy(Context context, String authority) throws IOException, XmlPullParserException {
            SimplePathStrategy simplePathStrategy = new SimplePathStrategy(authority);
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(authority, 128);
            if (resolveContentProvider == null) {
                throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + authority);
            }
            XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(packageManager, ClipboardFileProvider.META_DATA_FILE_PROVIDER_PATHS);
            if (loadXmlMetaData == null) {
                throw new IllegalArgumentException("Missing expo.modules.clipboard.CLIPBOARD_FILE_PROVIDER_PATHS meta-data");
            }
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    return simplePathStrategy;
                }
                if (next == 2) {
                    String tag = loadXmlMetaData.getName();
                    Intrinsics.checkNotNullExpressionValue(tag, "tag");
                    File targetFileFromTag = targetFileFromTag(tag, context);
                    if (targetFileFromTag != null) {
                        simplePathStrategy.addRoot(loadXmlMetaData.getAttributeValue(null, "name"), ClipboardFileProvider.INSTANCE.buildPath(targetFileFromTag, loadXmlMetaData.getAttributeValue(null, ClipboardFileProvider.ATTR_PATH)));
                    }
                }
            }
        }

        private final File targetFileFromTag(String tag, Context context) {
            switch (tag.hashCode()) {
                case -1642807877:
                    if (tag.equals(ClipboardFileProvider.TAG_FILES_PATH)) {
                        return context.getFilesDir();
                    }
                    return null;
                case -1360690478:
                    if (!tag.equals(ClipboardFileProvider.TAG_EXTERNAL_CACHE)) {
                        return null;
                    }
                    File[] externalCacheDirs = context.getExternalCacheDirs();
                    Intrinsics.checkNotNullExpressionValue(externalCacheDirs, "context.externalCacheDirs");
                    if (!(!(externalCacheDirs.length == 0))) {
                        externalCacheDirs = null;
                    }
                    if (externalCacheDirs != null) {
                        return externalCacheDirs[0];
                    }
                    return null;
                case -913292752:
                    if (tag.equals(ClipboardFileProvider.TAG_ROOT_PATH)) {
                        return ClipboardFileProvider.DEVICE_ROOT;
                    }
                    return null;
                case -50149145:
                    if (tag.equals(ClipboardFileProvider.TAG_EXTERNAL)) {
                        return Environment.getExternalStorageDirectory();
                    }
                    return null;
                case -17221744:
                    if (tag.equals(ClipboardFileProvider.TAG_CACHE_PATH)) {
                        return context.getCacheDir();
                    }
                    return null;
                case 1308690685:
                    if (!tag.equals(ClipboardFileProvider.TAG_EXTERNAL_FILES)) {
                        return null;
                    }
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "context.getExternalFilesDirs(null)");
                    if (!(!(externalFilesDirs.length == 0))) {
                        externalFilesDirs = null;
                    }
                    if (externalFilesDirs != null) {
                        return externalFilesDirs[0];
                    }
                    return null;
                default:
                    return null;
            }
        }

        private final File buildPath(File base, String... segments) {
            for (String str : segments) {
                if (str != null) {
                    base = new File(base, str);
                }
            }
            return base;
        }
    }

    /* compiled from: ClipboardFileProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/clipboard/ClipboardFileProvider$SimplePathStrategy;", "Lexpo/modules/clipboard/ClipboardFileProvider$PathStrategy;", "authority", "", "(Ljava/lang/String;)V", "roots", "Ljava/util/HashMap;", "Ljava/io/File;", "Lkotlin/collections/HashMap;", "addRoot", "", "name", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "getFileForUri", "uri", "Landroid/net/Uri;", "getUriForFile", "file", "expo-clipboard_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SimplePathStrategy implements PathStrategy {
        private final String authority;
        private final HashMap<String, File> roots;

        public SimplePathStrategy(String authority) {
            Intrinsics.checkNotNullParameter(authority, "authority");
            this.authority = authority;
            this.roots = new HashMap<>();
        }

        public final void addRoot(String name, File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            if (!((name == null || TextUtils.isEmpty(name)) ? false : true)) {
                throw new IllegalArgumentException("Name must not be empty".toString());
            }
            try {
                File newRoot = root.getCanonicalFile();
                HashMap<String, File> hashMap = this.roots;
                Intrinsics.checkNotNullExpressionValue(newRoot, "newRoot");
                hashMap.put(name, newRoot);
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + root, e);
            }
        }

        @Override // expo.modules.clipboard.ClipboardFileProvider.PathStrategy
        public Uri getUriForFile(File file) {
            String substring;
            Intrinsics.checkNotNullParameter(file, "file");
            try {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.checkNotNullExpressionValue(canonicalPath, "{\n        file.canonicalPath\n      }");
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.roots.entrySet()) {
                    String rootPath = entry2.getValue().getPath();
                    Intrinsics.checkNotNullExpressionValue(rootPath, "rootPath");
                    if (StringsKt.startsWith$default(canonicalPath, rootPath, false, 2, (Object) null) && (entry == null || rootPath.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException(("Failed to find configured root that contains " + ((Object) canonicalPath)).toString());
                }
                String rootPath2 = entry.getValue().getPath();
                Intrinsics.checkNotNullExpressionValue(rootPath2, "rootPath");
                if (StringsKt.endsWith$default(rootPath2, "/", false, 2, (Object) null)) {
                    substring = canonicalPath.substring(rootPath2.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                } else {
                    substring = canonicalPath.substring(rootPath2.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                }
                return new Uri.Builder().scheme("content").authority(this.authority).encodedPath(Uri.encode(entry.getKey()) + "/" + Uri.encode(substring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // expo.modules.clipboard.ClipboardFileProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String encodedPath = uri.getEncodedPath();
            Intrinsics.checkNotNull(encodedPath);
            int indexOf$default = StringsKt.indexOf$default((CharSequence) encodedPath, IOUtils.DIR_SEPARATOR_UNIX, 1, false, 4, (Object) null);
            String substring = encodedPath.substring(1, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String decode = Uri.decode(substring);
            String substring2 = encodedPath.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            String decode2 = Uri.decode(substring2);
            Intrinsics.checkNotNullExpressionValue(decode2, "decode(path.substring(splitIndex + 1))");
            File file = this.roots.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                Intrinsics.checkNotNullExpressionValue(canonicalFile, "{\n        file.canonicalFile\n      }");
                if (FilesKt.startsWith(canonicalFile, file)) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }
}
