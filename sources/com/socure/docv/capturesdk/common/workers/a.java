package com.socure.docv.capturesdk.common.workers;

import android.content.Context;
import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.logger.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final File f357a;

    public a(Context context, String baseDirName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseDirName, "baseDirName");
        this.f357a = context.getExternalFilesDir(baseDirName);
    }

    public final void a() {
        try {
            File file = this.f357a;
            b.a("SDLT_IW", "Deleted files: " + (file != null ? Boolean.valueOf(FilesKt.deleteRecursively(file)) : null));
        } catch (Throwable th) {
            b.a("SDLT_IW", "Clearing base dir hit error: " + th, null, 4, null);
        }
    }

    public final boolean a(Bitmap bitmap, File file) {
        StringBuilder sb;
        try {
            if (file.exists()) {
                b.a("SDLT_IW", "Deleting the existing file", null, 4, null);
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
                return true;
            } finally {
            }
        } catch (IOException e) {
            e = e;
            sb = new StringBuilder("IOEx in writeToDisk: ");
            b.a("SDLT_IW", sb.append(e).toString(), null, 4, null);
            return false;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder("Th caught in writeToDisk: ");
            b.a("SDLT_IW", sb.append(e).toString(), null, 4, null);
            return false;
        }
    }

    public final boolean a(Bitmap bitmap, String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File file = new File(this.f357a, fileName);
        b.b("SDLT_IW", "Trying to save image: " + fileName);
        Unit unit = null;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                boolean a2 = a(bitmap, file);
                b.a("SDLT_IW", "wrote image to disk (" + file.getAbsolutePath() + "): " + a2);
                return a2;
            }
            b.a("SDLT_IW", "bitmap is recycled", null, 4, null);
            unit = Unit.INSTANCE;
        }
        if (unit != null) {
            return false;
        }
        b.b("SDLT_IW", "Bitmap received was null");
        return false;
    }
}
