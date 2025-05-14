package sdk.pendo.io.g9;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u001c\u0010\u0010\u001a\n \f*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/g9/m;", "", "", "byteArray", "Ljava/security/MessageDigest;", "digest", "", "a", "Lorg/json/JSONObject;", "jsonObject", "text", "b", "kotlin.jvm.PlatformType", "Ljava/security/MessageDigest;", "digestSHA1", "c", "digestSHA2", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f1138a = new m();

    /* renamed from: b, reason: from kotlin metadata */
    private static final MessageDigest digestSHA1 = MessageDigest.getInstance("SHA-1");

    /* renamed from: c, reason: from kotlin metadata */
    private static final MessageDigest digestSHA2 = MessageDigest.getInstance("SHA-256");

    private m() {
    }

    public final synchronized String a(byte[] byteArray) {
        MessageDigest digestSHA12;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        digestSHA12 = digestSHA1;
        Intrinsics.checkNotNullExpressionValue(digestSHA12, "digestSHA1");
        return a(byteArray, digestSHA12);
    }

    public final synchronized String b(byte[] byteArray) {
        MessageDigest digestSHA22;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        digestSHA22 = digestSHA2;
        Intrinsics.checkNotNullExpressionValue(digestSHA22, "digestSHA2");
        return a(byteArray, digestSHA22);
    }

    public final synchronized String a(String text) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(text, "text");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        bytes = text.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return a(bytes);
    }

    public final synchronized String b(String text) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(text, "text");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        bytes = text.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return b(bytes);
    }

    public final synchronized String a(JSONObject jsonObject) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String jSONObject = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        bytes = jSONObject.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return a(bytes);
    }

    private final String a(byte[] byteArray, MessageDigest digest) {
        digest.reset();
        digest.update(byteArray);
        String a2 = m0.a(digest.digest());
        Intrinsics.checkNotNullExpressionValue(a2, "bytesToHex(...)");
        return a2;
    }
}
