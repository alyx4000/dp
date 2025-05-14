package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;
import java.util.List;

/* loaded from: classes.dex */
public class ImageProcessorRequest implements ImageProcessor.Request {
    private final List<ImageProxy> mImageProxies;
    private final int mOutputFormat;

    public ImageProcessorRequest(List<ImageProxy> list, int i) {
        this.mImageProxies = list;
        this.mOutputFormat = i;
    }

    @Override // androidx.camera.core.ImageProcessor.Request
    public List<ImageProxy> getInputImages() {
        return this.mImageProxies;
    }

    @Override // androidx.camera.core.ImageProcessor.Request
    public int getOutputFormat() {
        return this.mOutputFormat;
    }
}
