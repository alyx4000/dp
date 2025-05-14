package com.socure.docv.capturesdk.common.utils;

import com.socure.docv.capturesdk.feature.scanner.data.FrameGenerator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/FeedManager;", "", "cropCoordinates", "", "", "getCropCoordinates", "()Ljava/util/List;", "clear", "", "freeze", "getFrameGenerator", "Lcom/socure/docv/capturesdk/feature/scanner/data/FrameGenerator;", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedManager {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static FrameGenerator getFrameGenerator(FeedManager feedManager) {
            return null;
        }
    }

    void clear();

    void freeze();

    List<List<Double>> getCropCoordinates();

    FrameGenerator getFrameGenerator();
}
