package com.quantummetric.ui.internal;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.core.view.ViewCompat;

/* loaded from: classes5.dex */
public final class az {
    public static final void a(u uVar, TextStyle textStyle) {
        uVar.I = ColorKt.toArgb-8_81llA(textStyle.getColor-0d7_KjU());
        if (uVar.I == 0) {
            uVar.I = ViewCompat.MEASURED_STATE_MASK;
        }
        uVar.b(TextUnit.getValue-impl(textStyle.getFontSize-XSAIIZE()));
        TextAlign textAlign = textStyle.getTextAlign-buA522U();
        if (textAlign != null) {
            uVar.b(TextAlign.toString-impl(textAlign.unbox-impl()));
        }
    }
}
