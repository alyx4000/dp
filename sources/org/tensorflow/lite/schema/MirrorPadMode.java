package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public final class MirrorPadMode {
    public static final byte REFLECT = 0;
    public static final byte SYMMETRIC = 1;
    public static final String[] names = {"REFLECT", "SYMMETRIC"};

    private MirrorPadMode() {
    }

    public static String name(int i) {
        return names[i];
    }
}
