package expo.modules.filesystem;

import com.google.firebase.perf.FirebasePerformance;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;

/* compiled from: FileSystemRecords.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/filesystem/HttpMethod;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "POST", "PUT", FirebasePerformance.HttpMethod.PATCH, "expo-file-system_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public enum HttpMethod implements Enumerable {
    POST("POST"),
    PUT("PUT"),
    PATCH(FirebasePerformance.HttpMethod.PATCH);

    private final String value;

    HttpMethod(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
