package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
final class s implements sdk.pendo.io.q.f {
    private static final sdk.pendo.io.i0.g<Class<?>, byte[]> j = new sdk.pendo.io.i0.g<>(50);
    private final sdk.pendo.io.u.a b;
    private final sdk.pendo.io.q.f c;
    private final sdk.pendo.io.q.f d;
    private final int e;
    private final int f;
    private final Class<?> g;
    private final Options h;
    private final Transformation<?> i;

    s(sdk.pendo.io.u.a aVar, sdk.pendo.io.q.f fVar, sdk.pendo.io.q.f fVar2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.b = aVar;
        this.c = fVar;
        this.d = fVar2;
        this.e = i;
        this.f = i2;
        this.i = transformation;
        this.g = cls;
        this.h = options;
    }

    private byte[] a() {
        sdk.pendo.io.i0.g<Class<?>, byte[]> gVar = j;
        byte[] bArr = gVar.get(this.g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.g.getName().getBytes(sdk.pendo.io.q.f.f1506a);
        gVar.put(this.g, bytes);
        return bytes;
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f == sVar.f && this.e == sVar.e && sdk.pendo.io.i0.k.b(this.i, sVar.i) && this.g.equals(sVar.g) && this.c.equals(sVar.c) && this.d.equals(sVar.d) && this.h.equals(sVar.h);
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        int hashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        Transformation<?> transformation = this.i;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + '}';
    }

    @Override // sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.i;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.b.put(bArr);
    }
}
