package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DistributionMetric extends Metric {
    private final List<Double> values;

    public DistributionMetric(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, Long l) {
        super(MetricType.Distribution, str, measurementUnit, map, l);
        ArrayList arrayList = new ArrayList();
        this.values = arrayList;
        arrayList.add(Double.valueOf(d));
    }

    @Override // io.sentry.metrics.Metric
    public void add(double d) {
        this.values.add(Double.valueOf(d));
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
