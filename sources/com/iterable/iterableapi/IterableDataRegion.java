package com.iterable.iterableapi;

/* loaded from: classes5.dex */
public enum IterableDataRegion {
    US(IterableConstants.BASE_URL_API),
    EU("https://api.eu.iterable.com/api/");

    private final String endpoint;

    IterableDataRegion(String str) {
        this.endpoint = str;
    }

    public String getEndpoint() {
        return this.endpoint;
    }
}
