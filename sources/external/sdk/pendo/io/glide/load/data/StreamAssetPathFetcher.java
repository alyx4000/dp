package external.sdk.pendo.io.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.glide.load.data.AssetPathFetcher
    public void close(InputStream inputStream) {
        inputStream.close();
    }

    @Override // external.sdk.pendo.io.glide.load.data.AssetPathFetcher, external.sdk.pendo.io.glide.load.data.a
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.sdk.pendo.io.glide.load.data.AssetPathFetcher
    public InputStream loadResource(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
