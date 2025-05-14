package sdk.pendo.io.s8;

import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public abstract class a implements Runnable {
    private p.c mWorker;

    protected abstract void execute();

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                execute();
            } catch (Exception e) {
                PendoLogger.d(e, e.getMessage(), new Object[0]);
                if (this.mWorker == null || this.mWorker.a()) {
                    return;
                }
            }
        } finally {
            p.c cVar = this.mWorker;
            if (cVar != null && !cVar.a()) {
                this.mWorker.dispose();
            }
        }
    }

    public void setWorker(p.c cVar) {
        this.mWorker = cVar;
    }
}
