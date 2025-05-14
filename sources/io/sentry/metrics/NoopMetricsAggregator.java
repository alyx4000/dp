package io.sentry.metrics;

import io.sentry.IMetricsAggregator;
import io.sentry.MeasurementUnit;
import io.sentry.metrics.MetricsApi;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class NoopMetricsAggregator implements IMetricsAggregator, MetricsApi.IMetricsInterface {
    private static final NoopMetricsAggregator instance = new NoopMetricsAggregator();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // io.sentry.IMetricsAggregator
    public void distribution(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i) {
    }

    @Override // io.sentry.IMetricsAggregator
    public void flush(boolean z) {
    }

    @Override // io.sentry.IMetricsAggregator
    public void gauge(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i) {
    }

    @Override // io.sentry.metrics.MetricsApi.IMetricsInterface
    public IMetricsAggregator getMetricsAggregator() {
        return this;
    }

    @Override // io.sentry.IMetricsAggregator
    public void increment(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i) {
    }

    @Override // io.sentry.IMetricsAggregator
    public void set(String str, int i, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i2) {
    }

    @Override // io.sentry.IMetricsAggregator
    public void set(String str, String str2, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i) {
    }

    public static NoopMetricsAggregator getInstance() {
        return instance;
    }

    @Override // io.sentry.IMetricsAggregator
    public void timing(String str, Runnable runnable, MeasurementUnit.Duration duration, Map<String, String> map, int i) {
        runnable.run();
    }

    @Override // io.sentry.metrics.MetricsApi.IMetricsInterface
    public Map<String, String> getDefaultTagsForMetrics() {
        return Collections.emptyMap();
    }
}
