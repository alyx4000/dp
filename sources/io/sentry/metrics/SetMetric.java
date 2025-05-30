package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class SetMetric extends Metric {
    private final Set<Integer> values;

    public SetMetric(String str, MeasurementUnit measurementUnit, Map<String, String> map, Long l) {
        super(MetricType.Set, str, measurementUnit, map, l);
        this.values = new HashSet();
    }

    @Override // io.sentry.metrics.Metric
    public void add(double d) {
        this.values.add(Integer.valueOf((int) d));
    }

    @Override // io.sentry.metrics.Metric
    public int getWeight() {
        return this.values.size();
    }

    @Override // io.sentry.metrics.Metric
    public Iterable<?> serialize() {
        return this.values;
    }
}
