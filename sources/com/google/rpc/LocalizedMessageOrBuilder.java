package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface LocalizedMessageOrBuilder extends MessageLiteOrBuilder {
    String getLocale();

    ByteString getLocaleBytes();

    String getMessage();

    ByteString getMessageBytes();
}
