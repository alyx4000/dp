package com.socure.docv.capturesdk.feature.scanner.data;

import com.socure.docv.capturesdk.common.utils.FeedManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/VideoManager;", "Lcom/socure/docv/capturesdk/common/utils/FeedManager;", "frameGenerator", "Lcom/socure/docv/capturesdk/feature/scanner/data/FrameGenerator;", "cropCoordinates", "", "", "(Lcom/socure/docv/capturesdk/feature/scanner/data/FrameGenerator;Ljava/util/List;)V", "getCropCoordinates", "()Ljava/util/List;", "clear", "", "freeze", "getFrameGenerator", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoManager implements FeedManager {
    private final List<List<Double>> cropCoordinates;
    private final FrameGenerator frameGenerator;

    public VideoManager(FrameGenerator frameGenerator, List<List<Double>> cropCoordinates) {
        Intrinsics.checkNotNullParameter(cropCoordinates, "cropCoordinates");
        this.frameGenerator = frameGenerator;
        this.cropCoordinates = cropCoordinates;
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public void clear() {
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public void freeze() {
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public List<List<Double>> getCropCoordinates() {
        return this.cropCoordinates;
    }

    @Override // com.socure.docv.capturesdk.common.utils.FeedManager
    public FrameGenerator getFrameGenerator() {
        return null;
    }
}
