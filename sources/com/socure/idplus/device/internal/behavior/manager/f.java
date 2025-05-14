package com.socure.idplus.device.internal.behavior.manager;

import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f556a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar) {
        super(0);
        this.f556a = gVar;
    }

    public final void a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.f556a.a();
        } else {
            final g gVar = this.f556a;
            gVar.e.post(new Runnable() { // from class: com.socure.idplus.device.internal.behavior.manager.f$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    f.a(g.this);
                }
            });
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }

    public static final void a(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }
}
