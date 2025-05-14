package sdk.pendo.io.models;

import java.util.Iterator;
import sdk.pendo.io.actions.configurations.GuideTransition;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.l0.c;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public class GuideConfigurationModel {

    @c("delayMs")
    private long mDelayMs;

    @c("timeoutMs")
    private long mTimeoutMs;

    @c("transition")
    private i mTransition;

    public long getDelayMs() {
        return this.mDelayMs;
    }

    public long getTimeoutMs() {
        return this.mTimeoutMs;
    }

    public final GuideTransition getTransition(String str) {
        i iVar = this.mTransition;
        if (iVar != null) {
            try {
                if (!iVar.h()) {
                    if (this.mTransition.j()) {
                        PendoLogger.d("Transition should be an array, not an object", new Object[0]);
                    }
                    return null;
                }
                f d = this.mTransition.d();
                if (d != null && d.size() > 0) {
                    Iterator<i> it = d.iterator();
                    while (it.hasNext()) {
                        l lVar = (l) it.next();
                        i a2 = lVar.a("type");
                        if (a2 != null && str.equals(a2.g())) {
                            return GuideTransition.getGuideTransition(lVar);
                        }
                    }
                }
                PendoLogger.d("No transitions to return", new Object[0]);
                return null;
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "inOut: " + str);
            }
        }
        return null;
    }

    public i getTransition() {
        return this.mTransition;
    }
}
