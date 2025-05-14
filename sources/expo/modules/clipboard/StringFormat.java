package expo.modules.clipboard;

import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;

/* compiled from: ClipboardOptions.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/clipboard/StringFormat;", "", "Lexpo/modules/kotlin/types/Enumerable;", "jsValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsValue", "()Ljava/lang/String;", "PLAIN", "HTML", "expo-clipboard_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public enum StringFormat implements Enumerable {
    PLAIN("plainText"),
    HTML(IterableConstants.ITERABLE_IN_APP_HTML);

    private final String jsValue;

    StringFormat(String str) {
        this.jsValue = str;
    }

    public final String getJsValue() {
        return this.jsValue;
    }
}
