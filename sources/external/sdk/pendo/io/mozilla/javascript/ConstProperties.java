package external.sdk.pendo.io.mozilla.javascript;

/* loaded from: classes2.dex */
public interface ConstProperties {
    void defineConst(String str, Scriptable scriptable);

    boolean isConst(String str);

    void putConst(String str, Scriptable scriptable, Object obj);
}
