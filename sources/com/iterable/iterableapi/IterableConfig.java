package com.iterable.iterableapi;

import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes5.dex */
public class IterableConfig {
    final String[] allowedProtocols;
    final IterableAuthHandler authHandler;
    final boolean autoPushRegistration;

    @Deprecated
    final boolean checkForDeferredDeeplink;
    final IterableCustomActionHandler customActionHandler;
    final IterableDataRegion dataRegion;
    final boolean encryptionEnforced;
    final long expiringAuthTokenRefreshPeriod;
    final double inAppDisplayInterval;
    final IterableInAppHandler inAppHandler;
    final int logLevel;
    final String pushIntegrationName;
    final IterableUrlHandler urlHandler;
    final boolean useInMemoryStorageForInApps;

    private IterableConfig(Builder builder) {
        this.pushIntegrationName = builder.pushIntegrationName;
        this.urlHandler = builder.urlHandler;
        this.customActionHandler = builder.customActionHandler;
        this.autoPushRegistration = builder.autoPushRegistration;
        this.checkForDeferredDeeplink = builder.checkForDeferredDeeplink;
        this.logLevel = builder.logLevel;
        this.inAppHandler = builder.inAppHandler;
        this.inAppDisplayInterval = builder.inAppDisplayInterval;
        this.authHandler = builder.authHandler;
        this.expiringAuthTokenRefreshPeriod = builder.expiringAuthTokenRefreshPeriod;
        this.allowedProtocols = builder.allowedProtocols;
        this.dataRegion = builder.dataRegion;
        this.useInMemoryStorageForInApps = builder.useInMemoryStorageForInApps;
        this.encryptionEnforced = builder.encryptionEnforced;
    }

    public static class Builder {
        private IterableAuthHandler authHandler;
        private boolean checkForDeferredDeeplink;
        private IterableCustomActionHandler customActionHandler;
        private String pushIntegrationName;
        private IterableUrlHandler urlHandler;
        private boolean autoPushRegistration = true;
        private int logLevel = 6;
        private IterableInAppHandler inAppHandler = new IterableDefaultInAppHandler();
        private double inAppDisplayInterval = 30.0d;
        private long expiringAuthTokenRefreshPeriod = DateUtils.MILLIS_PER_MINUTE;
        private String[] allowedProtocols = new String[0];
        private IterableDataRegion dataRegion = IterableDataRegion.US;
        private boolean useInMemoryStorageForInApps = false;
        private boolean encryptionEnforced = false;

        public Builder setPushIntegrationName(String str) {
            this.pushIntegrationName = str;
            return this;
        }

        public Builder setUrlHandler(IterableUrlHandler iterableUrlHandler) {
            this.urlHandler = iterableUrlHandler;
            return this;
        }

        public Builder setCustomActionHandler(IterableCustomActionHandler iterableCustomActionHandler) {
            this.customActionHandler = iterableCustomActionHandler;
            return this;
        }

        public Builder setAutoPushRegistration(boolean z) {
            this.autoPushRegistration = z;
            return this;
        }

        public Builder setCheckForDeferredDeeplink(boolean z) {
            this.checkForDeferredDeeplink = z;
            return this;
        }

        public Builder setLogLevel(int i) {
            this.logLevel = i;
            return this;
        }

        public Builder setInAppHandler(IterableInAppHandler iterableInAppHandler) {
            this.inAppHandler = iterableInAppHandler;
            return this;
        }

        public Builder setInAppDisplayInterval(double d) {
            this.inAppDisplayInterval = d;
            return this;
        }

        public Builder setAuthHandler(IterableAuthHandler iterableAuthHandler) {
            this.authHandler = iterableAuthHandler;
            return this;
        }

        public Builder setExpiringAuthTokenRefreshPeriod(Long l) {
            this.expiringAuthTokenRefreshPeriod = l.longValue() * 1000;
            return this;
        }

        public Builder setAllowedProtocols(String[] strArr) {
            this.allowedProtocols = strArr;
            return this;
        }

        public Builder setEncryptionEnforced(boolean z) {
            this.encryptionEnforced = z;
            return this;
        }

        public Builder setDataRegion(IterableDataRegion iterableDataRegion) {
            this.dataRegion = iterableDataRegion;
            return this;
        }

        public Builder setUseInMemoryStorageForInApps(boolean z) {
            this.useInMemoryStorageForInApps = z;
            return this;
        }

        public IterableConfig build() {
            return new IterableConfig(this);
        }
    }
}
