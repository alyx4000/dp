package com.quantummetric.ui.internal;

import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
final class bv extends dg {
    bv(View view) {
        super(view);
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void j() {
        super.j();
        try {
            View view = this.F.get();
            if (view != null) {
                int i = 0;
                Object b = by.b(view, "mColors");
                if (b == null && aa.C) {
                    Field[] declaredFields = view.getClass().getDeclaredFields();
                    int length = declaredFields.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        Field field = declaredFields[i];
                        if (field.getType() == int[].class) {
                            field.setAccessible(true);
                            b = field.get(view);
                            break;
                        }
                        i++;
                    }
                }
                if (b instanceof int[]) {
                    this.v.a(180, (int[]) b);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
