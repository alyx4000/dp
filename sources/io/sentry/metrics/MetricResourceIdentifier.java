package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import io.sentry.util.Objects;

/* loaded from: classes2.dex */
public final class MetricResourceIdentifier {
    private final String key;
    private final MetricType metricType;
    private final MeasurementUnit unit;

    public MetricResourceIdentifier(MetricType metricType, String str, MeasurementUnit measurementUnit) {
        this.metricType = metricType;
        this.key = str;
        this.unit = measurementUnit;
    }

    public MetricType getMetricType() {
        return this.metricType;
    }

    public String getKey() {
        return this.key;
    }

    public MeasurementUnit getUnit() {
        return this.unit;
    }

    public String toString() {
        return String.format("%s:%s@%s", MetricsHelper.toStatsdType(this.metricType), MetricsHelper.sanitizeKey(this.key), this.unit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MetricResourceIdentifier metricResourceIdentifier = (MetricResourceIdentifier) obj;
        return this.metricType == metricResourceIdentifier.metricType && Objects.equals(this.key, metricResourceIdentifier.key) && Objects.equals(this.unit, metricResourceIdentifier.unit);
    }

    public int hashCode() {
        return Objects.hash(this.metricType, this.key, this.unit);
    }
}
