package com.socure.idplus.device.internal.input.manager.view;

import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import com.socure.idplus.device.internal.behavior.model.InputChangeAction;
import com.socure.idplus.device.internal.behavior.model.InputChangeEvent;
import com.socure.idplus.device.internal.input.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final int f574a;
    public InputChangeAction b = InputChangeAction.UNKNOWN;
    public final /* synthetic */ b c;

    public a(b bVar, int i) {
        this.c = bVar;
        this.f574a = i;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null) {
            return;
        }
        this.b = InputChangeAction.UNKNOWN;
        b bVar = this.c;
        if (bVar.b.b && i3 == 0) {
            String valueOf = String.valueOf(bVar.a());
            if (valueOf.length() == i2 && Intrinsics.areEqual(charSequence.subSequence(i, i2 + i).toString(), valueOf)) {
                this.b = InputChangeAction.CUT;
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence != null) {
            b bVar = this.c;
            if (bVar.b.b && i3 != 0) {
                String valueOf = String.valueOf(bVar.a());
                if (valueOf.length() == i3 && Intrinsics.areEqual(charSequence.subSequence(i, i3 + i).toString(), valueOf)) {
                    this.b = InputChangeAction.PASTE;
                }
            }
        }
        d dVar = this.c.d;
        InputChangeEvent inputChangeEvent = new InputChangeEvent(SystemClock.uptimeMillis(), this.c.f == this.f574a, this.b);
        dVar.getClass();
        Intrinsics.checkNotNullParameter(inputChangeEvent, "inputChangeEvent");
        dVar.a(inputChangeEvent);
        this.b = InputChangeAction.UNKNOWN;
        this.c.b.b = false;
    }
}
