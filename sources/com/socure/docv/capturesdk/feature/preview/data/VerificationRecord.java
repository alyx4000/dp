package com.socure.docv.capturesdk.feature.preview.data;

import com.socure.docv.capturesdk.common.logger.b;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/socure/docv/capturesdk/feature/preview/data/VerificationRecord;", "", "maxCount", "", "(I)V", "maxSubmitCount", "totalAttempts", "totalCount", "clear", "", "count", "getMaxAttemptCount", "getTotalAttempts", "isTotalAttemptReached", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationRecord {
    private int maxSubmitCount;
    private int totalAttempts;
    private int totalCount;

    public VerificationRecord(int i) {
        this.maxSubmitCount = i;
    }

    public final void clear() {
        this.totalAttempts = 0;
        this.totalCount = 0;
    }

    public final void count() {
        int i = this.totalAttempts + 1;
        this.totalAttempts = i;
        b.a("SDLT_VR", "totalCount: " + this.totalCount + ", totalAttempts: " + i);
    }

    /* renamed from: getMaxAttemptCount, reason: from getter */
    public final int getMaxSubmitCount() {
        return this.maxSubmitCount;
    }

    public final int getTotalAttempts() {
        return this.totalAttempts;
    }

    public final boolean isTotalAttemptReached() {
        return this.totalAttempts < this.maxSubmitCount;
    }
}
