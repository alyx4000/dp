package com.google.android.material.textfield;

import android.widget.EditText;

/* loaded from: classes3.dex */
class EditTextUtils {
    private EditTextUtils() {
    }

    static boolean isEditable(EditText editText) {
        return editText.getInputType() != 0;
    }
}
