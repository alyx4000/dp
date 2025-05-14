package sdk.pendo.io.network.interfaces;

import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.y6.r;
import sdk.pendo.io.z6.i;
import sdk.pendo.io.z6.o;
import sdk.pendo.io.z6.y;

/* loaded from: classes6.dex */
public interface AnalyticsData {
    @o
    j<r<e0>> send(@y String str, @sdk.pendo.io.z6.a c0 c0Var);

    @o
    j<r<e0>> send(@y String str, @sdk.pendo.io.z6.a c0 c0Var, @i("X-Pendo-JWT") String str2, @i("X-Pendo-SigningKeyName") String str3);
}
