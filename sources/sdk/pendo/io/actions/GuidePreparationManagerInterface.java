package sdk.pendo.io.actions;

import java.util.List;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public interface GuidePreparationManagerInterface {
    void fetchImages(String str, List<String> list);

    boolean getHasImages(String str);

    j<Boolean> getImagesLoadedAsObservable(String str);

    void prepareGuideImages(int i, String str);
}
