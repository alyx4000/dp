package com.socure.docv.capturesdk.di;

import android.app.Application;
import com.socure.docv.capturesdk.common.config.model.Model;
import com.socure.docv.capturesdk.core.pipeline.model.SelfieRange;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;
import java.util.List;

/* loaded from: classes5.dex */
public interface c {
    com.socure.docv.capturesdk.core.provider.interfaces.d<Model> a();

    void a(ViewDimensions viewDimensions);

    void a(List<SelfieRange> list);

    com.socure.docv.capturesdk.core.provider.interfaces.d<Model> b();

    Application c();

    com.socure.docv.capturesdk.core.provider.interfaces.d<Model> d();

    com.socure.docv.capturesdk.feature.orchestrator.a e();

    List<SelfieRange> f();

    com.socure.docv.capturesdk.common.network.repository.b g();

    com.socure.docv.capturesdk.core.provider.interfaces.d<Model> h();

    ViewDimensions i();
}
