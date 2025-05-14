package androidx.camera.core.processing;

import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_SurfaceEdge extends SurfaceEdge {
    private final List<SettableSurface> surfaces;

    AutoValue_SurfaceEdge(List<SettableSurface> list) {
        if (list == null) {
            throw new NullPointerException("Null surfaces");
        }
        this.surfaces = list;
    }

    @Override // androidx.camera.core.processing.SurfaceEdge
    public List<SettableSurface> getSurfaces() {
        return this.surfaces;
    }

    public String toString() {
        return "SurfaceEdge{surfaces=" + this.surfaces + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceEdge) {
            return this.surfaces.equals(((SurfaceEdge) obj).getSurfaces());
        }
        return false;
    }

    public int hashCode() {
        return this.surfaces.hashCode() ^ 1000003;
    }
}
