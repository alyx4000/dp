package expo.modules.updates.loader;

import expo.modules.updates.manifest.UpdateManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteUpdate.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/loader/UpdateResponsePart;", "", "()V", "DirectiveUpdateResponsePart", "ManifestUpdateResponsePart", "Lexpo/modules/updates/loader/UpdateResponsePart$DirectiveUpdateResponsePart;", "Lexpo/modules/updates/loader/UpdateResponsePart$ManifestUpdateResponsePart;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UpdateResponsePart {
    public /* synthetic */ UpdateResponsePart(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: RemoteUpdate.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lexpo/modules/updates/loader/UpdateResponsePart$ManifestUpdateResponsePart;", "Lexpo/modules/updates/loader/UpdateResponsePart;", "updateManifest", "Lexpo/modules/updates/manifest/UpdateManifest;", "(Lexpo/modules/updates/manifest/UpdateManifest;)V", "getUpdateManifest", "()Lexpo/modules/updates/manifest/UpdateManifest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ManifestUpdateResponsePart extends UpdateResponsePart {
        private final UpdateManifest updateManifest;

        public static /* synthetic */ ManifestUpdateResponsePart copy$default(ManifestUpdateResponsePart manifestUpdateResponsePart, UpdateManifest updateManifest, int i, Object obj) {
            if ((i & 1) != 0) {
                updateManifest = manifestUpdateResponsePart.updateManifest;
            }
            return manifestUpdateResponsePart.copy(updateManifest);
        }

        /* renamed from: component1, reason: from getter */
        public final UpdateManifest getUpdateManifest() {
            return this.updateManifest;
        }

        public final ManifestUpdateResponsePart copy(UpdateManifest updateManifest) {
            Intrinsics.checkNotNullParameter(updateManifest, "updateManifest");
            return new ManifestUpdateResponsePart(updateManifest);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ManifestUpdateResponsePart) && Intrinsics.areEqual(this.updateManifest, ((ManifestUpdateResponsePart) other).updateManifest);
        }

        public int hashCode() {
            return this.updateManifest.hashCode();
        }

        public String toString() {
            return "ManifestUpdateResponsePart(updateManifest=" + this.updateManifest + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ManifestUpdateResponsePart(UpdateManifest updateManifest) {
            super(null);
            Intrinsics.checkNotNullParameter(updateManifest, "updateManifest");
            this.updateManifest = updateManifest;
        }

        public final UpdateManifest getUpdateManifest() {
            return this.updateManifest;
        }
    }

    private UpdateResponsePart() {
    }

    /* compiled from: RemoteUpdate.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lexpo/modules/updates/loader/UpdateResponsePart$DirectiveUpdateResponsePart;", "Lexpo/modules/updates/loader/UpdateResponsePart;", "updateDirective", "Lexpo/modules/updates/loader/UpdateDirective;", "(Lexpo/modules/updates/loader/UpdateDirective;)V", "getUpdateDirective", "()Lexpo/modules/updates/loader/UpdateDirective;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class DirectiveUpdateResponsePart extends UpdateResponsePart {
        private final UpdateDirective updateDirective;

        public static /* synthetic */ DirectiveUpdateResponsePart copy$default(DirectiveUpdateResponsePart directiveUpdateResponsePart, UpdateDirective updateDirective, int i, Object obj) {
            if ((i & 1) != 0) {
                updateDirective = directiveUpdateResponsePart.updateDirective;
            }
            return directiveUpdateResponsePart.copy(updateDirective);
        }

        /* renamed from: component1, reason: from getter */
        public final UpdateDirective getUpdateDirective() {
            return this.updateDirective;
        }

        public final DirectiveUpdateResponsePart copy(UpdateDirective updateDirective) {
            Intrinsics.checkNotNullParameter(updateDirective, "updateDirective");
            return new DirectiveUpdateResponsePart(updateDirective);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DirectiveUpdateResponsePart) && Intrinsics.areEqual(this.updateDirective, ((DirectiveUpdateResponsePart) other).updateDirective);
        }

        public int hashCode() {
            return this.updateDirective.hashCode();
        }

        public String toString() {
            return "DirectiveUpdateResponsePart(updateDirective=" + this.updateDirective + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectiveUpdateResponsePart(UpdateDirective updateDirective) {
            super(null);
            Intrinsics.checkNotNullParameter(updateDirective, "updateDirective");
            this.updateDirective = updateDirective;
        }

        public final UpdateDirective getUpdateDirective() {
            return this.updateDirective;
        }
    }
}
