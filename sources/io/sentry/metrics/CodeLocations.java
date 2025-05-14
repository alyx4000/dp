package io.sentry.metrics;

import io.sentry.protocol.SentryStackFrame;
import java.util.Map;

/* loaded from: classes2.dex */
public final class CodeLocations {
    private final Map<MetricResourceIdentifier, SentryStackFrame> locations;
    private final double timestamp;

    public CodeLocations(double d, Map<MetricResourceIdentifier, SentryStackFrame> map) {
        this.timestamp = d;
        this.locations = map;
    }

    public double getTimestamp() {
        return this.timestamp;
    }

    public Map<MetricResourceIdentifier, SentryStackFrame> getLocations() {
        return this.locations;
    }
}
