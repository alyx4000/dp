package com.facebook.fresco.vito.renderer;

import kotlin.Metadata;

/* compiled from: ImageDataModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/fresco/vito/renderer/ColorIntImageDataModel;", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "colorInt", "", "(I)V", "getColorInt", "()I", "renderer_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ColorIntImageDataModel extends ImageDataModel {
    private final int colorInt;

    public ColorIntImageDataModel(int i) {
        super(null);
        this.colorInt = i;
    }

    public final int getColorInt() {
        return this.colorInt;
    }
}
