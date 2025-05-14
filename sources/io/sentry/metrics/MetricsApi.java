package io.sentry.metrics;

import io.sentry.IMetricsAggregator;
import io.sentry.MeasurementUnit;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MetricsApi {
    private final IMetricsInterface aggregator;

    public interface IMetricsInterface {
        Map<String, String> getDefaultTagsForMetrics();

        IMetricsAggregator getMetricsAggregator();
    }

    public MetricsApi(IMetricsInterface iMetricsInterface) {
        this.aggregator = iMetricsInterface;
    }

    public void increment(String str) {
        increment(str, 1.0d, null, null, null, 1);
    }

    public void increment(String str, double d) {
        increment(str, d, null, null, null, 1);
    }

    public void increment(String str, double d, MeasurementUnit measurementUnit) {
        increment(str, d, measurementUnit, null, null, 1);
    }

    public void increment(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map) {
        increment(str, d, measurementUnit, map, null, 1);
    }

    public void increment(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, Long l) {
        increment(str, d, measurementUnit, map, l, 1);
    }

    public void increment(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, Long l, int i) {
        this.aggregator.getMetricsAggregator().increment(str, d, measurementUnit, MetricsHelper.mergeTags(map, this.aggregator.getDefaultTagsForMetrics()), l != null ? l.longValue() : System.currentTimeMillis(), i);
    }

    public void gauge(String str, double d) {
        gauge(str, d, null, null, null, 1);
    }

    public void gauge(String str, double d, MeasurementUnit measurementUnit) {
        gauge(str, d, measurementUnit, null, null, 1);
    }

    public void gauge(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map) {
        gauge(str, d, measurementUnit, map, null, 1);
    }

    public void gauge(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, Long l) {
        gauge(str, d, measurementUnit, map, l, 1);
    }

    public void gauge(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, Long l, int i) {
        this.aggregator.getMetricsAggregator().gauge(str, d, measurementUnit, MetricsHelper.mergeTags(map, this.aggregator.getDefaultTagsForMetrics()), l != null ? l.longValue() : System.currentTimeMillis(), i);
    }

    public void distribution(String str, double d) {
        distribution(str, d, null, null, null, 1);
    }

    public void distribution(String str, double d, MeasurementUnit measurementUnit) {
        distribution(str, d, measurementUnit, null, null, 1);
    }

    public void distribution(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map) {
        distribution(str, d, measurementUnit, map, null, 1);
    }

    public void distribution(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, Long l) {
        distribution(str, d, measurementUnit, map, l, 1);
    }

    public void distribution(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, Long l, int i) {
        this.aggregator.getMetricsAggregator().distribution(str, d, measurementUnit, MetricsHelper.mergeTags(map, this.aggregator.getDefaultTagsForMetrics()), l != null ? l.longValue() : System.currentTimeMillis(), i);
    }

    public void set(String str, int i) {
        set(str, i, (MeasurementUnit) null, (Map<String, String>) null, (Long) null, 1);
    }

    public void set(String str, int i, MeasurementUnit measurementUnit) {
        set(str, i, measurementUnit, (Map<String, String>) null, (Long) null, 1);
    }

    public void set(String str, int i, MeasurementUnit measurementUnit, Map<String, String> map) {
        set(str, i, measurementUnit, map, (Long) null, 1);
    }

    public void set(String str, int i, MeasurementUnit measurementUnit, Map<String, String> map, Long l) {
        set(str, i, measurementUnit, map, l, 1);
    }

    public void set(String str, int i, MeasurementUnit measurementUnit, Map<String, String> map, Long l, int i2) {
        this.aggregator.getMetricsAggregator().set(str, i, measurementUnit, MetricsHelper.mergeTags(map, this.aggregator.getDefaultTagsForMetrics()), l != null ? l.longValue() : System.currentTimeMillis(), i2);
    }

    public void set(String str, String str2) {
        set(str, str2, (MeasurementUnit) null, (Map<String, String>) null, (Long) null, 1);
    }

    public void set(String str, String str2, MeasurementUnit measurementUnit) {
        set(str, str2, measurementUnit, (Map<String, String>) null, (Long) null, 1);
    }

    public void set(String str, String str2, MeasurementUnit measurementUnit, Map<String, String> map) {
        set(str, str2, measurementUnit, map, (Long) null, 1);
    }

    public void set(String str, String str2, MeasurementUnit measurementUnit, Map<String, String> map, Long l) {
        set(str, str2, measurementUnit, map, l, 1);
    }

    public void set(String str, String str2, MeasurementUnit measurementUnit, Map<String, String> map, Long l, int i) {
        this.aggregator.getMetricsAggregator().set(str, str2, measurementUnit, MetricsHelper.mergeTags(map, this.aggregator.getDefaultTagsForMetrics()), l != null ? l.longValue() : System.currentTimeMillis(), i);
    }

    public void timing(String str, Runnable runnable) {
        timing(str, runnable, null, null, 1);
    }

    public void timing(String str, Runnable runnable, MeasurementUnit.Duration duration) {
        timing(str, runnable, duration, null, 1);
    }

    public void timing(String str, Runnable runnable, MeasurementUnit.Duration duration, Map<String, String> map) {
        timing(str, runnable, duration, map, 1);
    }

    public void timing(String str, Runnable runnable, MeasurementUnit.Duration duration, Map<String, String> map, int i) {
        if (duration == null) {
            duration = MeasurementUnit.Duration.SECOND;
        }
        this.aggregator.getMetricsAggregator().timing(str, runnable, duration, MetricsHelper.mergeTags(map, this.aggregator.getDefaultTagsForMetrics()), i);
    }
}
