package expo.modules.updates.statemachine;

import kotlin.Metadata;

/* compiled from: UpdatesStateEventType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEventType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Check", "CheckCompleteUnavailable", "CheckCompleteAvailable", "CheckError", "Download", "DownloadComplete", "DownloadError", "Restart", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum UpdatesStateEventType {
    Check("check"),
    CheckCompleteUnavailable("checkCompleteUnavailable"),
    CheckCompleteAvailable("checkCompleteAvailable"),
    CheckError("checkError"),
    Download("download"),
    DownloadComplete("downloadComplete"),
    DownloadError("downloadError"),
    Restart("restart");

    private final String type;

    UpdatesStateEventType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
