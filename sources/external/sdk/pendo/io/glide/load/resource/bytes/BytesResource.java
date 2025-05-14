package external.sdk.pendo.io.glide.load.resource.bytes;

import sdk.pendo.io.i0.j;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class BytesResource implements c<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bArr) {
        this.bytes = (byte[]) j.a(bArr);
    }

    @Override // sdk.pendo.io.t.c
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // sdk.pendo.io.t.c
    public int getSize() {
        return this.bytes.length;
    }

    @Override // sdk.pendo.io.t.c
    public void recycle() {
    }

    @Override // sdk.pendo.io.t.c
    public byte[] get() {
        return this.bytes;
    }
}
