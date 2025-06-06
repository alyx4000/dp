package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes6.dex */
public class Memoizer<I, O> implements Computable<I, O> {
    private final ConcurrentMap<I, Future<O>> cache;
    private final Computable<I, O> computable;
    private final boolean recalculate;

    public Memoizer(Computable<I, O> computable) {
        this(computable, false);
    }

    public Memoizer(Computable<I, O> computable, boolean z) {
        this.cache = new ConcurrentHashMap();
        this.computable = computable;
        this.recalculate = z;
    }

    @Override // org.apache.commons.lang3.concurrent.Computable
    public O compute(final I i) throws InterruptedException {
        FutureTask futureTask;
        while (true) {
            Future<O> future = this.cache.get(i);
            if (future == null && (future = this.cache.putIfAbsent(i, (futureTask = new FutureTask(new Callable<O>() { // from class: org.apache.commons.lang3.concurrent.Memoizer.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public O call() throws InterruptedException {
                    return (O) Memoizer.this.computable.compute(i);
                }
            })))) == null) {
                futureTask.run();
                future = futureTask;
            }
            try {
                continue;
                return future.get();
            } catch (CancellationException unused) {
                this.cache.remove(i, future);
            } catch (ExecutionException e) {
                if (this.recalculate) {
                    this.cache.remove(i, future);
                }
                throw launderException(e.getCause());
            }
        }
    }

    private RuntimeException launderException(Throwable th) {
        if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new IllegalStateException("Unchecked exception", th);
    }
}
