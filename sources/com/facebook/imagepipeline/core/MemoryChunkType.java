package com.facebook.imagepipeline.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface MemoryChunkType {
    public static final int ASHMEM_MEMORY = 2;
    public static final int BUFFER_MEMORY = 1;
    public static final int NATIVE_MEMORY = 0;
}
