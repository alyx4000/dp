package io.castle.highwind.android;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class f0 {
    public static final String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return !(country == null || country.length() == 0) ? language + '-' + locale.getCountry() : language;
    }
}
