package org.tensorflow.lite.schema;

import com.iterable.iterableapi.IterableConstants;

/* loaded from: classes6.dex */
public final class LSTMKernelType {
    public static final byte BASIC = 1;
    public static final byte FULL = 0;
    public static final String[] names = {IterableConstants.ITERABLE_IN_APP_TYPE_FULL, "BASIC"};

    private LSTMKernelType() {
    }

    public static String name(int i) {
        return names[i];
    }
}
