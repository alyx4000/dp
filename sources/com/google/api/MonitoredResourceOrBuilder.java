package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes3.dex */
public interface MonitoredResourceOrBuilder extends MessageLiteOrBuilder {
    boolean containsLabels(String str);

    @Deprecated
    Map<String, String> getLabels();

    int getLabelsCount();

    Map<String, String> getLabelsMap();

    String getLabelsOrDefault(String str, String str2);

    String getLabelsOrThrow(String str);

    String getType();

    ByteString getTypeBytes();
}
