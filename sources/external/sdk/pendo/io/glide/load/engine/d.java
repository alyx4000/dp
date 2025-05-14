package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.engine.cache.a;
import java.io.File;

/* loaded from: classes2.dex */
class d<DataType> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.q.d<DataType> f666a;
    private final DataType b;
    private final Options c;

    d(sdk.pendo.io.q.d<DataType> dVar, DataType datatype, Options options) {
        this.f666a = dVar;
        this.b = datatype;
        this.c = options;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a.b
    public boolean a(File file) {
        return this.f666a.encode(this.b, file, this.c);
    }
}
