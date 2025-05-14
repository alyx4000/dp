package io.sentry;

import io.sentry.MeasurementUnit;
import java.io.Closeable;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IMetricsAggregator extends Closeable {
    void distribution(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i);

    void flush(boolean z);

    void gauge(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i);

    void increment(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i);

    void set(String str, int i, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i2);

    void set(String str, String str2, MeasurementUnit measurementUnit, Map<String, String> map, long j, int i);

    void timing(String str, Runnable runnable, MeasurementUnit.Duration duration, Map<String, String> map, int i);
}
