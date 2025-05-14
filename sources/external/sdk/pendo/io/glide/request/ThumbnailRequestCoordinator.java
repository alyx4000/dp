package external.sdk.pendo.io.glide.request;

import external.sdk.pendo.io.glide.request.b;

/* loaded from: classes2.dex */
public class ThumbnailRequestCoordinator implements b, sdk.pendo.io.e0.a {
    private volatile sdk.pendo.io.e0.a full;
    private b.a fullState;
    private boolean isRunningDuringBegin;
    private final b parent;
    private final Object requestLock;
    private volatile sdk.pendo.io.e0.a thumb;
    private b.a thumbState;

    public ThumbnailRequestCoordinator(Object obj, b bVar) {
        b.a aVar = b.a.CLEARED;
        this.fullState = aVar;
        this.thumbState = aVar;
        this.requestLock = obj;
        this.parent = bVar;
    }

    private boolean parentCanNotifyCleared() {
        b bVar = this.parent;
        return bVar == null || bVar.canNotifyCleared(this);
    }

    private boolean parentCanNotifyStatusChanged() {
        b bVar = this.parent;
        return bVar == null || bVar.canNotifyStatusChanged(this);
    }

    private boolean parentCanSetImage() {
        b bVar = this.parent;
        return bVar == null || bVar.canSetImage(this);
    }

    @Override // sdk.pendo.io.e0.a
    public void begin() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = true;
            try {
                if (this.fullState != b.a.SUCCESS) {
                    b.a aVar = this.thumbState;
                    b.a aVar2 = b.a.RUNNING;
                    if (aVar != aVar2) {
                        this.thumbState = aVar2;
                        this.thumb.begin();
                    }
                }
                if (this.isRunningDuringBegin) {
                    b.a aVar3 = this.fullState;
                    b.a aVar4 = b.a.RUNNING;
                    if (aVar3 != aVar4) {
                        this.fullState = aVar4;
                        this.full.begin();
                    }
                }
            } finally {
                this.isRunningDuringBegin = false;
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canNotifyCleared(sdk.pendo.io.e0.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyCleared() && aVar.equals(this.full) && this.fullState != b.a.PAUSED;
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canNotifyStatusChanged(sdk.pendo.io.e0.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyStatusChanged() && aVar.equals(this.full) && !isAnyResourceSet();
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canSetImage(sdk.pendo.io.e0.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanSetImage() && (aVar.equals(this.full) || this.fullState != b.a.SUCCESS);
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.a
    public void clear() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = false;
            b.a aVar = b.a.CLEARED;
            this.fullState = aVar;
            this.thumbState = aVar;
            this.thumb.clear();
            this.full.clear();
        }
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public b getRoot() {
        b root;
        synchronized (this.requestLock) {
            b bVar = this.parent;
            root = bVar != null ? bVar.getRoot() : this;
        }
        return root;
    }

    @Override // external.sdk.pendo.io.glide.request.b, sdk.pendo.io.e0.a
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.thumb.isAnyResourceSet() || this.full.isAnyResourceSet();
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == b.a.CLEARED;
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == b.a.SUCCESS;
        }
        return z;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isEquivalentTo(sdk.pendo.io.e0.a aVar) {
        if (!(aVar instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) aVar;
        if (this.full == null) {
            if (thumbnailRequestCoordinator.full != null) {
                return false;
            }
        } else if (!this.full.isEquivalentTo(thumbnailRequestCoordinator.full)) {
            return false;
        }
        if (this.thumb == null) {
            if (thumbnailRequestCoordinator.thumb != null) {
                return false;
            }
        } else if (!this.thumb.isEquivalentTo(thumbnailRequestCoordinator.thumb)) {
            return false;
        }
        return true;
    }

    @Override // sdk.pendo.io.e0.a
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == b.a.RUNNING;
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public void onRequestFailed(sdk.pendo.io.e0.a aVar) {
        synchronized (this.requestLock) {
            if (!aVar.equals(this.full)) {
                this.thumbState = b.a.FAILED;
                return;
            }
            this.fullState = b.a.FAILED;
            b bVar = this.parent;
            if (bVar != null) {
                bVar.onRequestFailed(this);
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public void onRequestSuccess(sdk.pendo.io.e0.a aVar) {
        synchronized (this.requestLock) {
            if (aVar.equals(this.thumb)) {
                this.thumbState = b.a.SUCCESS;
                return;
            }
            this.fullState = b.a.SUCCESS;
            b bVar = this.parent;
            if (bVar != null) {
                bVar.onRequestSuccess(this);
            }
            if (!this.thumbState.a()) {
                this.thumb.clear();
            }
        }
    }

    @Override // sdk.pendo.io.e0.a
    public void pause() {
        synchronized (this.requestLock) {
            if (!this.thumbState.a()) {
                this.thumbState = b.a.PAUSED;
                this.thumb.pause();
            }
            if (!this.fullState.a()) {
                this.fullState = b.a.PAUSED;
                this.full.pause();
            }
        }
    }

    public void setRequests(sdk.pendo.io.e0.a aVar, sdk.pendo.io.e0.a aVar2) {
        this.full = aVar;
        this.thumb = aVar2;
    }
}
