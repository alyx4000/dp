package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: classes5.dex */
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() { // from class: com.google.crypto.tink.shaded.protobuf.BufferAllocator.1
        @Override // com.google.crypto.tink.shaded.protobuf.BufferAllocator
        public AllocatedBuffer allocateHeapBuffer(int capacity) {
            return AllocatedBuffer.wrap(new byte[capacity]);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int capacity) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(capacity));
        }
    };

    public abstract AllocatedBuffer allocateDirectBuffer(int capacity);

    public abstract AllocatedBuffer allocateHeapBuffer(int capacity);

    BufferAllocator() {
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
