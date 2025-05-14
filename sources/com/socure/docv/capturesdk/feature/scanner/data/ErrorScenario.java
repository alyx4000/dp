package com.socure.docv.capturesdk.feature.scanner.data;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/ErrorScenario;", "", "msg", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "MANUAL_FAILED", "CONTINUOUS_ERRORS_MAXED", "REMOVE_BLOCKER_MANUAL_CAPTURE_FAILED", "REMOVE_BLOCKER_AUTO_CAPTURE_FAILED", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ErrorScenario {
    MANUAL_FAILED("manual_capture_failed"),
    CONTINUOUS_ERRORS_MAXED("continuous_errors_maxed"),
    REMOVE_BLOCKER_MANUAL_CAPTURE_FAILED("remove_blocker_manual_capture_failed"),
    REMOVE_BLOCKER_AUTO_CAPTURE_FAILED("remove_blocker_auto_capture_failed");

    private final String msg;

    ErrorScenario(String str) {
        this.msg = str;
    }

    public final String getMsg() {
        return this.msg;
    }
}
