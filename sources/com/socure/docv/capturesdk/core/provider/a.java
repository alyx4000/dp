package com.socure.docv.capturesdk.core.provider;

import android.content.Context;
import com.socure.docv.capturesdk.common.config.model.Model;
import com.socure.docv.capturesdk.core.provider.interfaces.d;
import kotlin.jvm.internal.Intrinsics;
import org.tensorflow.lite.support.model.Model;

/* loaded from: classes5.dex */
public final class a implements d<Model> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f393a;
    public final String b;
    public final d<Float> c;
    public final int d;

    public a(Context context, String defaultModelFileName, d<Float> confidenceProvider, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultModelFileName, "defaultModelFileName");
        Intrinsics.checkNotNullParameter(confidenceProvider, "confidenceProvider");
        this.f393a = context;
        this.b = defaultModelFileName;
        this.c = confidenceProvider;
        this.d = i;
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.d
    public Model a() {
        org.tensorflow.lite.support.model.Model createModel = org.tensorflow.lite.support.model.Model.createModel(this.f393a, this.b, new Model.Options.Builder().build());
        Intrinsics.checkNotNullExpressionValue(createModel, "createModel(\n           …r().build()\n            )");
        return new com.socure.docv.capturesdk.common.config.model.Model(createModel, this.c.a().floatValue(), this.d);
    }
}
