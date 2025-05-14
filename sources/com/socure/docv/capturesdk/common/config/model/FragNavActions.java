package com.socure.docv.capturesdk.common.config.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/socure/docv/capturesdk/common/config/model/FragNavActions;", "", "forwardNavActionId", "", "backwardNavActionId", "(II)V", "getBackwardNavActionId", "()I", "getForwardNavActionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FragNavActions {
    private final int backwardNavActionId;
    private final int forwardNavActionId;

    public FragNavActions(int i, int i2) {
        this.forwardNavActionId = i;
        this.backwardNavActionId = i2;
    }

    public static /* synthetic */ FragNavActions copy$default(FragNavActions fragNavActions, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = fragNavActions.forwardNavActionId;
        }
        if ((i3 & 2) != 0) {
            i2 = fragNavActions.backwardNavActionId;
        }
        return fragNavActions.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getForwardNavActionId() {
        return this.forwardNavActionId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBackwardNavActionId() {
        return this.backwardNavActionId;
    }

    public final FragNavActions copy(int forwardNavActionId, int backwardNavActionId) {
        return new FragNavActions(forwardNavActionId, backwardNavActionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FragNavActions)) {
            return false;
        }
        FragNavActions fragNavActions = (FragNavActions) other;
        return this.forwardNavActionId == fragNavActions.forwardNavActionId && this.backwardNavActionId == fragNavActions.backwardNavActionId;
    }

    public final int getBackwardNavActionId() {
        return this.backwardNavActionId;
    }

    public final int getForwardNavActionId() {
        return this.forwardNavActionId;
    }

    public int hashCode() {
        return Integer.hashCode(this.backwardNavActionId) + (Integer.hashCode(this.forwardNavActionId) * 31);
    }

    public String toString() {
        return "FragNavActions(forwardNavActionId=" + this.forwardNavActionId + ", backwardNavActionId=" + this.backwardNavActionId + ")";
    }
}
