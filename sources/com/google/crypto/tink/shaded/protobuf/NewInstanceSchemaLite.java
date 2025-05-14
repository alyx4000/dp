package com.google.crypto.tink.shaded.protobuf;

@CheckReturnValue
/* loaded from: classes5.dex */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    NewInstanceSchemaLite() {
    }

    @Override // com.google.crypto.tink.shaded.protobuf.NewInstanceSchema
    public Object newInstance(Object defaultInstance) {
        return ((GeneratedMessageLite) defaultInstance).newMutableInstance();
    }
}
