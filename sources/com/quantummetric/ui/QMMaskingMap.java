package com.quantummetric.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class QMMaskingMap extends HashMap<String, Object> {

    public enum Type {
        Bodies,
        Headers,
        Text,
        ApiUrl,
        MaskEverythingMode,
        Images,
        Inputs,
        Activity,
        Fragment,
        ViewId,
        ViewClass
    }

    public QMMaskingMap(Type type) {
        put("type", type.name());
    }

    public QMMaskingMap addExactMatchList(String... strArr) {
        put("exact_match_list", new ArrayList(Arrays.asList(strArr)));
        return this;
    }

    public QMMaskingMap addRegexList(String... strArr) {
        put("regex_list", new ArrayList(Arrays.asList(strArr)));
        return this;
    }
}
