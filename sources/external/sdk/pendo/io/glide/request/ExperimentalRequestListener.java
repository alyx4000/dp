package external.sdk.pendo.io.glide.request;

import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.request.target.Target;

@Deprecated
/* loaded from: classes2.dex */
public abstract class ExperimentalRequestListener<ResourceT> implements sdk.pendo.io.e0.b<ResourceT> {
    @Override // sdk.pendo.io.e0.b
    public abstract /* synthetic */ boolean onLoadFailed(n nVar, Object obj, Target target, boolean z);

    @Override // sdk.pendo.io.e0.b
    public abstract /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, sdk.pendo.io.q.a aVar, boolean z);

    public abstract boolean onResourceReady(ResourceT resourcet, Object obj, Target<ResourceT> target, sdk.pendo.io.q.a aVar, boolean z, boolean z2);
}
