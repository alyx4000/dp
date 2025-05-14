package external.sdk.pendo.io.glide.load.data.mediastore;

import java.io.File;

/* loaded from: classes2.dex */
class a {
    a() {
    }

    public boolean a(File file) {
        return file.exists();
    }

    public long b(File file) {
        return file.length();
    }

    public File a(String str) {
        return new File(str);
    }
}
