package org.socure.core;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f805a;

    static {
        a(0, 1);
        a(0, 2);
        a(0, 3);
        a(0, 4);
        a(1, 1);
        a(1, 2);
        a(1, 3);
        a(1, 4);
        a(2, 1);
        a(2, 2);
        a(2, 3);
        a(2, 4);
        a(3, 1);
        a(3, 2);
        a(3, 3);
        a(3, 4);
        a(4, 1);
        f805a = a(4, 2);
        a(4, 3);
        a(4, 4);
        a(5, 1);
        a(5, 2);
        a(5, 3);
        a(5, 4);
        a(6, 1);
        a(6, 2);
        a(6, 3);
        a(6, 4);
        a(7, 1);
        a(7, 2);
        a(7, 3);
        a(7, 4);
    }

    public static final int a(int i) {
        return (i >> 3) + 1;
    }

    public static final int a(int i, int i2) {
        if (i2 <= 0 || i2 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        }
        if (i < 0 || i >= 8) {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
        return (i & 7) + ((i2 - 1) << 3);
    }
}
