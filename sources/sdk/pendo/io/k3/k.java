package sdk.pendo.io.k3;

import io.sentry.ProfilingTraceData;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0001H\u0016J\b\u0010\u0003\u001a\u00020\u0001H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0002\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/k3/k;", "Lsdk/pendo/io/k3/b0;", "delegate", "a", "", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "Ljava/util/concurrent/TimeUnit;", "unit", "f", "", "d", "c", "deadlineNanoTime", "b", "", "e", "Lsdk/pendo/io/k3/b0;", "()Lokio/Timeout;", "setDelegate", "(Lokio/Timeout;)V", "<init>", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public class k extends b0 {

    /* renamed from: f, reason: from kotlin metadata */
    private b0 delegate;

    public k(b0 delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // sdk.pendo.io.k3.b0
    public b0 a() {
        return this.delegate.a();
    }

    @Override // sdk.pendo.io.k3.b0
    public b0 b() {
        return this.delegate.b();
    }

    @Override // sdk.pendo.io.k3.b0
    public long c() {
        return this.delegate.c();
    }

    @Override // sdk.pendo.io.k3.b0
    /* renamed from: d */
    public boolean getHasDeadline() {
        return this.delegate.getHasDeadline();
    }

    @Override // sdk.pendo.io.k3.b0
    public void e() {
        this.delegate.e();
    }

    @Override // sdk.pendo.io.k3.b0
    /* renamed from: f */
    public long getTimeoutNanos() {
        return this.delegate.getTimeoutNanos();
    }

    /* renamed from: g, reason: from getter */
    public final b0 getDelegate() {
        return this.delegate;
    }

    @Override // sdk.pendo.io.k3.b0
    public b0 a(long deadlineNanoTime) {
        return this.delegate.a(deadlineNanoTime);
    }

    public final k a(b0 delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    @Override // sdk.pendo.io.k3.b0
    public b0 a(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.delegate.a(timeout, unit);
    }
}
