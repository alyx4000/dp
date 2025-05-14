package sdk.pendo.io.network.interfaces;

import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.y6.r;
import sdk.pendo.io.z6.o;

/* loaded from: classes6.dex */
public interface SetupProcess {
    @o("v2/devices/setup")
    j<r<e0>> send(@sdk.pendo.io.z6.a c0 c0Var);

    @o("v2/devices/debugData")
    j<r<e0>> sendDebugData(@sdk.pendo.io.z6.a c0 c0Var);
}
