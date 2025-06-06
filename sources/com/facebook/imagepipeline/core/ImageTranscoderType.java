package com.facebook.imagepipeline.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ImageTranscoderType {
    public static final int JAVA_TRANSCODER = 1;
    public static final int NATIVE_TRANSCODER = 0;
}
