package external.sdk.pendo.io.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes2.dex */
class c {
    private static final a f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a f641a;
    private final b b;
    private final sdk.pendo.io.u.a c;
    private final ContentResolver d;
    private final List<ImageHeaderParser> e;

    c(List<ImageHeaderParser> list, a aVar, b bVar, sdk.pendo.io.u.a aVar2, ContentResolver contentResolver) {
        this.f641a = aVar;
        this.b = bVar;
        this.c = aVar2;
        this.d = contentResolver;
        this.e = list;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x001d: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:26:0x001d */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            java.lang.String r1 = "Failed to query for thumbnail for Uri: "
            r2 = 0
            external.sdk.pendo.io.glide.load.data.mediastore.b r3 = r6.b     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L29
            android.database.Cursor r3 = r3.a(r7)     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L29
            if (r3 == 0) goto L21
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L1c java.lang.SecurityException -> L1f
            if (r4 == 0) goto L21
            r4 = 0
            java.lang.String r7 = r3.getString(r4)     // Catch: java.lang.Throwable -> L1c java.lang.SecurityException -> L1f
            r3.close()
            return r7
        L1c:
            r7 = move-exception
            r2 = r3
            goto L48
        L1f:
            r4 = move-exception
            goto L2b
        L21:
            if (r3 == 0) goto L26
            r3.close()
        L26:
            return r2
        L27:
            r7 = move-exception
            goto L48
        L29:
            r4 = move-exception
            r3 = r2
        L2b:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L1c
            if (r5 == 0) goto L42
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L1c
            java.lang.StringBuilder r7 = r5.append(r7)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L1c
            android.util.Log.d(r0, r7, r4)     // Catch: java.lang.Throwable -> L1c
        L42:
            if (r3 == 0) goto L47
            r3.close()
        L47:
            return r2
        L48:
            if (r2 == 0) goto L4d
            r2.close()
        L4d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.glide.load.data.mediastore.c.b(android.net.Uri):java.lang.String");
    }

    int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.d.openInputStream(uri);
                int a2 = external.sdk.pendo.io.glide.load.a.a(this.e, inputStream, this.c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return a2;
            } catch (IOException | NullPointerException e) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
                }
                if (inputStream == null) {
                    return -1;
                }
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused2) {
                    return -1;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream c(Uri uri) {
        String b = b(uri);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        File a2 = this.f641a.a(b);
        if (!a(a2)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(a2);
        try {
            return this.d.openInputStream(fromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
        }
    }

    c(List<ImageHeaderParser> list, b bVar, sdk.pendo.io.u.a aVar, ContentResolver contentResolver) {
        this(list, f, bVar, aVar, contentResolver);
    }

    private boolean a(File file) {
        return this.f641a.a(file) && 0 < this.f641a.b(file);
    }
}
