package sdk.pendo.io.models;

import com.amplitude.reactnative.DatabaseConstants;
import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public class AppKeyData {

    @c("datacenter")
    private String mDataCenter;

    @c(DatabaseConstants.KEY_FIELD)
    private String mKey;

    public String getDataCenter() {
        return this.mDataCenter;
    }

    public String getKey() {
        return this.mKey;
    }
}
