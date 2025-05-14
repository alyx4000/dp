package external.sdk.pendo.io.glide.request;

/* loaded from: classes2.dex */
public interface b {

    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        a(boolean z) {
            this.isComplete = z;
        }

        boolean a() {
            return this.isComplete;
        }
    }

    boolean canNotifyCleared(sdk.pendo.io.e0.a aVar);

    boolean canNotifyStatusChanged(sdk.pendo.io.e0.a aVar);

    boolean canSetImage(sdk.pendo.io.e0.a aVar);

    b getRoot();

    boolean isAnyResourceSet();

    void onRequestFailed(sdk.pendo.io.e0.a aVar);

    void onRequestSuccess(sdk.pendo.io.e0.a aVar);
}
