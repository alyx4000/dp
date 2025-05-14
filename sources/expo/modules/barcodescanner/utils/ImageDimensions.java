package expo.modules.barcodescanner.utils;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageDimensions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t¨\u0006\u001b"}, d2 = {"Lexpo/modules/barcodescanner/utils/ImageDimensions;", "", "innerWidth", "", "innerHeight", ViewProps.ROTATION, "facing", "(IIII)V", "getFacing", "()I", "height", "getHeight", "isLandscape", "", "getRotation", "width", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ImageDimensions {
    private final int facing;
    private final int height;
    private final int innerHeight;
    private final int innerWidth;
    private final boolean isLandscape;
    private final int rotation;
    private final int width;

    /* renamed from: component1, reason: from getter */
    private final int getInnerWidth() {
        return this.innerWidth;
    }

    /* renamed from: component2, reason: from getter */
    private final int getInnerHeight() {
        return this.innerHeight;
    }

    public static /* synthetic */ ImageDimensions copy$default(ImageDimensions imageDimensions, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = imageDimensions.innerWidth;
        }
        if ((i5 & 2) != 0) {
            i2 = imageDimensions.innerHeight;
        }
        if ((i5 & 4) != 0) {
            i3 = imageDimensions.rotation;
        }
        if ((i5 & 8) != 0) {
            i4 = imageDimensions.facing;
        }
        return imageDimensions.copy(i, i2, i3, i4);
    }

    /* renamed from: component3, reason: from getter */
    public final int getRotation() {
        return this.rotation;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFacing() {
        return this.facing;
    }

    public final ImageDimensions copy(int innerWidth, int innerHeight, int rotation, int facing) {
        return new ImageDimensions(innerWidth, innerHeight, rotation, facing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageDimensions)) {
            return false;
        }
        ImageDimensions imageDimensions = (ImageDimensions) other;
        return this.innerWidth == imageDimensions.innerWidth && this.innerHeight == imageDimensions.innerHeight && this.rotation == imageDimensions.rotation && this.facing == imageDimensions.facing;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.innerWidth) * 31) + Integer.hashCode(this.innerHeight)) * 31) + Integer.hashCode(this.rotation)) * 31) + Integer.hashCode(this.facing);
    }

    public String toString() {
        return "ImageDimensions(innerWidth=" + this.innerWidth + ", innerHeight=" + this.innerHeight + ", rotation=" + this.rotation + ", facing=" + this.facing + ")";
    }

    public ImageDimensions(int i, int i2, int i3, int i4) {
        this.innerWidth = i;
        this.innerHeight = i2;
        this.rotation = i3;
        this.facing = i4;
        boolean z = i3 % 180 == 90;
        this.isLandscape = z;
        this.width = z ? i2 : i;
        this.height = z ? i : i2;
    }

    public /* synthetic */ ImageDimensions(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? -1 : i4);
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final int getFacing() {
        return this.facing;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
