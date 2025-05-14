package com.socure.docv.capturesdk.feature.scanner.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;", "", "()V", "container", "Lcom/socure/docv/capturesdk/feature/scanner/data/Container;", "guidingBox", "Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBox;", "default", "", "(Lcom/socure/docv/capturesdk/feature/scanner/data/Container;Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBox;Z)V", "getContainer", "()Lcom/socure/docv/capturesdk/feature/scanner/data/Container;", "getDefault", "()Z", "getGuidingBox", "()Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBox;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ViewDimensions {
    private final Container container;
    private final boolean default;
    private final GuidingBox guidingBox;

    public ViewDimensions() {
        this(new Container(0, 0), new GuidingBox(0, 0, 0, 0, new Dimension(0.0d, 0.0d)), true);
    }

    public ViewDimensions(Container container, GuidingBox guidingBox, boolean z) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(guidingBox, "guidingBox");
        this.container = container;
        this.guidingBox = guidingBox;
        this.default = z;
    }

    public /* synthetic */ ViewDimensions(Container container, GuidingBox guidingBox, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(container, guidingBox, (i & 4) != 0 ? false : z);
    }

    public static /* synthetic */ ViewDimensions copy$default(ViewDimensions viewDimensions, Container container, GuidingBox guidingBox, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            container = viewDimensions.container;
        }
        if ((i & 2) != 0) {
            guidingBox = viewDimensions.guidingBox;
        }
        if ((i & 4) != 0) {
            z = viewDimensions.default;
        }
        return viewDimensions.copy(container, guidingBox, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Container getContainer() {
        return this.container;
    }

    /* renamed from: component2, reason: from getter */
    public final GuidingBox getGuidingBox() {
        return this.guidingBox;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final ViewDimensions copy(Container container, GuidingBox guidingBox, boolean r4) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(guidingBox, "guidingBox");
        return new ViewDimensions(container, guidingBox, r4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewDimensions)) {
            return false;
        }
        ViewDimensions viewDimensions = (ViewDimensions) other;
        return Intrinsics.areEqual(this.container, viewDimensions.container) && Intrinsics.areEqual(this.guidingBox, viewDimensions.guidingBox) && this.default == viewDimensions.default;
    }

    public final Container getContainer() {
        return this.container;
    }

    public final boolean getDefault() {
        return this.default;
    }

    public final GuidingBox getGuidingBox() {
        return this.guidingBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.guidingBox.hashCode() + (this.container.hashCode() * 31)) * 31;
        boolean z = this.default;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ViewDimensions(container=" + this.container + ", guidingBox=" + this.guidingBox + ", default=" + this.default + ")";
    }
}
