package external.sdk.pendo.io.glide.request;

import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.request.target.Target;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import sdk.pendo.io.f0.c;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, sdk.pendo.io.e0.b<R> {
    private static final a DEFAULT_WAITER = new a();
    private final boolean assertBackgroundThread;
    private n exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private sdk.pendo.io.e0.a request;
    private R resource;
    private boolean resultReceived;
    private final a waiter;
    private final int width;

    static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void a(Object obj, long j) {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long l) {
        if (this.assertBackgroundThread && !isDone()) {
            k.a();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        }
        if (this.resultReceived) {
            return this.resource;
        }
        if (l == null) {
            this.waiter.a(this, 0L);
        } else if (l.longValue() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = l.longValue() + currentTimeMillis;
            while (!isDone() && currentTimeMillis < longValue) {
                this.waiter.a(this, longValue - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (!this.resultReceived) {
            throw new TimeoutException();
        }
        return this.resource;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.isCancelled = true;
            this.waiter.a(this);
            sdk.pendo.io.e0.a aVar = null;
            if (z) {
                sdk.pendo.io.e0.a aVar2 = this.request;
                this.request = null;
                aVar = aVar2;
            }
            if (aVar != null) {
                aVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized sdk.pendo.io.e0.a getRequest() {
        return this.request;
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void getSize(c cVar) {
        cVar.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.isCancelled && !this.resultReceived) {
            z = this.loadFailed;
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.c0.i
    public void onDestroy() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized void onResourceReady(R r, external.sdk.pendo.io.glide.request.transition.a<? super R> aVar) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.c0.i
    public void onStart() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.c0.i
    public void onStop() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void removeCallback(c cVar) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized void setRequest(sdk.pendo.io.e0.a aVar) {
        this.request = aVar;
    }

    RequestFutureTarget(int i, int i2, boolean z, a aVar) {
        this.width = i;
        this.height = i2;
        this.assertBackgroundThread = z;
        this.waiter = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // sdk.pendo.io.e0.b
    public synchronized boolean onLoadFailed(n nVar, Object obj, Target<R> target, boolean z) {
        this.loadFailed = true;
        this.exception = nVar;
        this.waiter.a(this);
        return false;
    }

    @Override // sdk.pendo.io.e0.b
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, sdk.pendo.io.q.a aVar, boolean z) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.a(this);
        return false;
    }
}
