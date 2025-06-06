package io.sentry;

/* loaded from: classes2.dex */
public final class TracesSamplingDecision {
    private final Double profileSampleRate;
    private final Boolean profileSampled;
    private final Double sampleRate;
    private final Boolean sampled;

    public TracesSamplingDecision(Boolean bool) {
        this(bool, null);
    }

    public TracesSamplingDecision(Boolean bool, Double d) {
        this(bool, d, false, null);
    }

    public TracesSamplingDecision(Boolean bool, Double d, Boolean bool2, Double d2) {
        this.sampled = bool;
        this.sampleRate = d;
        this.profileSampled = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
        this.profileSampleRate = d2;
    }

    public Boolean getSampled() {
        return this.sampled;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public Boolean getProfileSampled() {
        return this.profileSampled;
    }

    public Double getProfileSampleRate() {
        return this.profileSampleRate;
    }
}
