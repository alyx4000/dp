package com.socure.idplus.device.internal.input.manager.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.socure.idplus.device.internal.input.c;
import com.socure.idplus.device.internal.input.d;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b extends com.socure.idplus.device.internal.input.manager.b {
    public final c c;
    public final d d;
    public int e;
    public int f;
    public final WeakHashMap g;
    public final ViewTreeObserver.OnGlobalFocusChangeListener h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, c focusChangeProducer, d inputChangeProducer, com.socure.idplus.device.internal.input.manager.monitor.a actionModeMonitor) {
        super(context, actionModeMonitor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(focusChangeProducer, "focusChangeProducer");
        Intrinsics.checkNotNullParameter(inputChangeProducer, "inputChangeProducer");
        Intrinsics.checkNotNullParameter(actionModeMonitor, "actionModeMonitor");
        this.c = focusChangeProducer;
        this.d = inputChangeProducer;
        this.e = 1;
        this.g = new WeakHashMap();
        this.h = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.socure.idplus.device.internal.input.manager.view.b$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view, View view2) {
                b.a(b.this, view, view2);
            }
        };
    }

    public static final void a(b this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view instanceof EditText) {
            this$0.a((EditText) view, false);
        }
        if (view2 instanceof EditText) {
            this$0.a((EditText) view2, true);
        }
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void b() {
        this.f = 0;
        this.e = 1;
        this.g.clear();
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void a(View view, boolean z) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (z) {
                if (this.g.get(editText) == null) {
                    WeakHashMap weakHashMap = this.g;
                    int i = this.e;
                    this.e = i + 1;
                    weakHashMap.put(editText, new a(this, i));
                }
                a aVar = (a) this.g.get(editText);
                if (aVar != null) {
                    editText.addTextChangedListener(aVar);
                }
            } else {
                a aVar2 = (a) this.g.get(editText);
                if (aVar2 != null) {
                    editText.removeTextChangedListener(aVar2);
                }
                this.g.remove(editText);
            }
            if (editText.hasFocus()) {
                a(editText, z);
            }
        }
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void b(ViewGroup contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        contentView.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.h);
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void a(ViewGroup contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        contentView.getViewTreeObserver().addOnGlobalFocusChangeListener(this.h);
    }

    public final void a(EditText editText, boolean z) {
        a aVar = (a) this.g.get(editText);
        int i = aVar != null ? aVar.f574a : 0;
        if (z) {
            this.f = i;
        } else if (this.f == i) {
            this.f = 0;
        }
        this.c.a(z);
    }
}
