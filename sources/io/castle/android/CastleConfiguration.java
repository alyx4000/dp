package io.castle.android;

import java.util.List;

/* loaded from: classes2.dex */
public class CastleConfiguration {
    private static final String CASTLE_API_PATH = "v1/";
    private static final String DEFAULT_API_DOMAIN = "m.castle.io";
    private static final boolean DEFAULT_DEBUG_LOGGING_ENABLED = false;
    private static final int DEFAULT_FLUSH_LIMIT = 20;
    private static final int DEFAULT_MAX_QUEUE_LIMIT = 1000;
    private static final boolean DEFAULT_SCREEN_TRACKING_ENABLED = false;
    private List<String> baseURLAllowList;
    private boolean debugLoggingEnabled;
    private int flushLimit;
    private int maxQueueLimit;
    private String publishableKey;
    private boolean screenTrackingEnabled;

    public CastleConfiguration() {
        this(new Builder());
    }

    private CastleConfiguration(Builder builder) {
        this.debugLoggingEnabled = builder.debugLoggingEnabled();
        this.flushLimit = builder.flushLimit();
        this.maxQueueLimit = builder.maxQueueLimit();
        this.publishableKey = builder.publishableKey();
        this.screenTrackingEnabled = builder.screenTrackingEnabled();
        this.baseURLAllowList = builder.baseURLAllowList();
    }

    public List<String> baseURLAllowList() {
        return this.baseURLAllowList;
    }

    public boolean debugLoggingEnabled() {
        return this.debugLoggingEnabled;
    }

    public int flushLimit() {
        return this.flushLimit;
    }

    public int maxQueueLimit() {
        return this.maxQueueLimit;
    }

    public String publishableKey() {
        return this.publishableKey;
    }

    public boolean screenTrackingEnabled() {
        return this.screenTrackingEnabled;
    }

    public String baseUrl() {
        return String.format("https://%s/%s", DEFAULT_API_DOMAIN, CASTLE_API_PATH);
    }

    public static final class Builder {
        private List<String> baseURLAllowList;
        private boolean debugLoggingEnabled;
        private int flushLimit;
        private int maxQueueLimit;
        private String publishableKey;
        private boolean screenTrackingEnabled;

        public Builder() {
            this.debugLoggingEnabled = false;
            this.flushLimit = 20;
            this.maxQueueLimit = 1000;
            this.screenTrackingEnabled = false;
        }

        public Builder(CastleConfiguration castleConfiguration) {
            this.debugLoggingEnabled = castleConfiguration.debugLoggingEnabled();
            this.flushLimit = castleConfiguration.flushLimit();
            this.maxQueueLimit = castleConfiguration.maxQueueLimit();
            this.publishableKey = castleConfiguration.publishableKey();
            this.screenTrackingEnabled = castleConfiguration.screenTrackingEnabled();
            this.baseURLAllowList = castleConfiguration.baseURLAllowList();
        }

        public Builder baseURLAllowList(List<String> list) {
            this.baseURLAllowList = list;
            return this;
        }

        public List<String> baseURLAllowList() {
            return this.baseURLAllowList;
        }

        public Builder debugLoggingEnabled(boolean z) {
            this.debugLoggingEnabled = z;
            return this;
        }

        public boolean debugLoggingEnabled() {
            return this.debugLoggingEnabled;
        }

        public int flushLimit() {
            return this.flushLimit;
        }

        public Builder flushLimit(int i) {
            this.flushLimit = i;
            return this;
        }

        public int maxQueueLimit() {
            return this.maxQueueLimit;
        }

        public Builder maxQueueLimit(int i) {
            this.maxQueueLimit = i;
            return this;
        }

        public Builder publishableKey(String str) {
            this.publishableKey = str;
            return this;
        }

        public String publishableKey() {
            return this.publishableKey;
        }

        public Builder screenTrackingEnabled(boolean z) {
            this.screenTrackingEnabled = z;
            return this;
        }

        public boolean screenTrackingEnabled() {
            return this.screenTrackingEnabled;
        }

        public CastleConfiguration build() {
            return new CastleConfiguration(this);
        }
    }
}
