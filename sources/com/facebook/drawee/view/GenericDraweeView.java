package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {

    @Nullable
    private static InflateHierarchyListener sInflateHierarchyListener;

    public interface InflateHierarchyListener {
        void onInflateHierarchy(GenericDraweeView genericDraweeView, Context context, @Nullable AttributeSet attributeSet);
    }

    public static void setInflateHierarchyListener(@Nullable InflateHierarchyListener inflateHierarchyListener) {
        sInflateHierarchyListener = inflateHierarchyListener;
    }

    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    public GenericDraweeView(Context context) {
        super(context);
        inflateHierarchy(context, null);
    }

    public GenericDraweeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }

    protected void inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeView#inflateHierarchy");
        }
        GenericDraweeHierarchyBuilder inflateBuilder = GenericDraweeHierarchyInflater.inflateBuilder(context, attributeSet);
        setAspectRatio(inflateBuilder.getDesiredAspectRatio());
        setHierarchy(inflateBuilder.build());
        InflateHierarchyListener inflateHierarchyListener = sInflateHierarchyListener;
        if (inflateHierarchyListener != null) {
            inflateHierarchyListener.onInflateHierarchy(this, context, attributeSet);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }
}
