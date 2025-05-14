package expo.modules.crypto;

import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigestOptions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lexpo/modules/crypto/DigestOptions;", "Lexpo/modules/kotlin/records/Record;", "()V", "encoding", "Lexpo/modules/crypto/DigestOptions$Encoding;", "getEncoding$annotations", "getEncoding", "()Lexpo/modules/crypto/DigestOptions$Encoding;", "setEncoding", "(Lexpo/modules/crypto/DigestOptions$Encoding;)V", "Encoding", "expo-crypto_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DigestOptions implements Record {
    private Encoding encoding = Encoding.HEX;

    @Field
    public static /* synthetic */ void getEncoding$annotations() {
    }

    public final Encoding getEncoding() {
        return this.encoding;
    }

    public final void setEncoding(Encoding encoding) {
        Intrinsics.checkNotNullParameter(encoding, "<set-?>");
        this.encoding = encoding;
    }

    /* compiled from: DigestOptions.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/crypto/DigestOptions$Encoding;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HEX", "BASE64", "expo-crypto_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Encoding implements Enumerable {
        HEX(IterableConstants.ITERABLE_IN_APP_BGCOLOR_HEX),
        BASE64("base64");

        private final String value;

        Encoding(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
