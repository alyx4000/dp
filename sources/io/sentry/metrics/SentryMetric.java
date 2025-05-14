package io.sentry.metrics;

import io.sentry.ILogger;
import io.sentry.JsonSerializable;
import io.sentry.MeasurementUnit;
import io.sentry.ObjectWriter;
import io.sentry.protocol.SentryId;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class SentryMetric implements JsonSerializable {
    private final SentryId eventId = new SentryId();
    private final String key;
    private final Map<String, String> tags;
    private final long timestampMs;
    private final MetricType type;
    private final MeasurementUnit unit;
    private final Iterable<?> values;

    public static final class JsonKeys {
        public static final String EVENT_ID = "event_id";
        public static final String NAME = "name";
        public static final String TAGS = "tags";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";
        public static final String UNIT = "unit";
        public static final String VALUE = "value";
    }

    public SentryMetric(Metric metric) {
        this.type = metric.getType();
        this.key = metric.getKey();
        this.unit = metric.getUnit();
        this.tags = metric.getTags();
        this.timestampMs = metric.getTimeStampMs().longValue();
        this.values = metric.serialize();
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("type").value(MetricsHelper.toStatsdType(this.type));
        objectWriter.name("event_id").value(iLogger, this.eventId);
        objectWriter.name("name").value(this.key);
        objectWriter.name("timestamp").value(this.timestampMs / 1000.0d);
        if (this.unit != null) {
            objectWriter.name("unit").value(this.unit.apiName());
        }
        if (this.tags != null) {
            objectWriter.name("tags");
            objectWriter.beginObject();
            for (Map.Entry<String, String> entry : this.tags.entrySet()) {
                objectWriter.name(entry.getKey()).value(entry.getValue());
            }
            objectWriter.endObject();
        }
        objectWriter.name("value");
        objectWriter.beginArray();
        Iterator<?> it = this.values.iterator();
        while (it.hasNext()) {
            objectWriter.value(iLogger, it.next());
        }
        objectWriter.endArray();
        objectWriter.endObject();
    }
}
