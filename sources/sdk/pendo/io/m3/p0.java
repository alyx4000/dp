package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public abstract class p0 {
    public static String a(int i, int i2) {
        return (i != 64 ? i != 128 ? i != 192 ? new StringBuilder("[UNIVERSAL ") : new StringBuilder("[PRIVATE ") : new StringBuilder("[CONTEXT ") : new StringBuilder("[APPLICATION ")).append(i2).append("]").toString();
    }
}
