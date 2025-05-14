package sdk.pendo.io.network.interfaces;

import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.y6.r;
import sdk.pendo.io.z6.f;
import sdk.pendo.io.z6.t;

/* loaded from: classes6.dex */
public interface Init {
    @f("v2/devices/init")
    j<r<InitModel>> initSdk(@t("withContent") int i);
}
