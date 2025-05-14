package external.sdk.pendo.io.glide.load.resource.file;

import external.sdk.pendo.io.glide.load.Options;
import java.io.File;
import sdk.pendo.io.q.i;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class FileDecoder implements i<File, File> {
    @Override // sdk.pendo.io.q.i
    public c<File> decode(File file, int i, int i2, Options options) {
        return new FileResource(file);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(File file, Options options) {
        return true;
    }
}
