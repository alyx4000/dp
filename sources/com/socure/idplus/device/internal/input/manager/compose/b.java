package com.socure.idplus.device.internal.input.manager.compose;

import android.view.View;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import com.socure.idplus.device.internal.behavior.model.InputChangeAction;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b implements PlatformTextInputService {

    /* renamed from: a, reason: collision with root package name */
    public final PlatformTextInputService f571a;
    public final /* synthetic */ d b;

    public b(d dVar, PlatformTextInputService platformTextInputService) {
        Intrinsics.checkNotNullParameter(platformTextInputService, "platformTextInputService");
        this.b = dVar;
        this.f571a = platformTextInputService;
    }

    public final void a(int i, TextFieldValue textFieldValue, String str) {
        d dVar;
        String str2;
        int length = str.length() + i;
        if (textFieldValue.getText().length() >= length && Intrinsics.areEqual(textFieldValue.getText().subSequence(i, length).toString(), str) && (str2 = (dVar = this.b).f) != null) {
            dVar.a(str2, InputChangeAction.PASTE);
        }
    }

    public final void hideSoftwareKeyboard() {
        this.f571a.hideSoftwareKeyboard();
    }

    public final void showSoftwareKeyboard() {
        this.f571a.showSoftwareKeyboard();
    }

    public final void startInput(TextFieldValue value, ImeOptions imeOptions, Function1 onEditCommand, Function1 onImeActionPerformed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(onEditCommand, "onEditCommand");
        Intrinsics.checkNotNullParameter(onImeActionPerformed, "onImeActionPerformed");
        if (this.b.i) {
            this.f571a.startInput(value, imeOptions, new a(this.b, onEditCommand), onImeActionPerformed);
        } else {
            this.f571a.startInput(value, imeOptions, onEditCommand, onImeActionPerformed);
        }
    }

    public final void stopInput() {
        d dVar = this.b;
        if (!dVar.i) {
            this.f571a.stopInput();
            return;
        }
        if (dVar.f != null) {
            dVar.c.a(false);
        }
        this.b.f = null;
        this.f571a.stopInput();
    }

    public final void updateState(TextFieldValue textFieldValue, TextFieldValue newValue) {
        d dVar;
        String str;
        d dVar2;
        String str2;
        View view;
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        this.f571a.updateState(textFieldValue, newValue);
        d dVar3 = this.b;
        if (dVar3.i) {
            if (dVar3.f == null) {
                WeakReference weakReference = dVar3.e;
                if (weakReference == null || (view = (View) weakReference.get()) == null) {
                    return;
                }
                d dVar4 = this.b;
                dVar4.g.set(0, 0, 0, 0);
                view.getFocusedRect(dVar4.g);
                dVar4.f = dVar4.a(dVar4.g);
                dVar4.c.a(true);
                return;
            }
            if (!dVar3.b.b) {
                if (textFieldValue == null || !Intrinsics.areEqual(textFieldValue.getText(), newValue.getText()) || (str = (dVar = this.b).f) == null) {
                    return;
                }
                dVar.a(str, InputChangeAction.UNKNOWN);
                return;
            }
            String text = textFieldValue != null ? TextFieldValueKt.getSelectedText(textFieldValue).getText() : null;
            if (text == null) {
                text = "";
            }
            AnnotatedString selectedText = TextFieldValueKt.getSelectedText(newValue);
            String valueOf = String.valueOf(this.b.a());
            if (text.length() <= 0 || selectedText.length() != 0) {
                if (textFieldValue == null) {
                    textFieldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
                }
                if (textFieldValue.getText().length() < newValue.getText().length()) {
                    String valueOf2 = String.valueOf(this.b.a());
                    if (textFieldValue.getText().length() == 0) {
                        a(0, newValue, valueOf2);
                    } else {
                        String text2 = textFieldValue.getText();
                        int i = 0;
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            if (i < text2.length()) {
                                int i4 = i3 + 1;
                                if (text2.charAt(i) != newValue.getText().charAt(i3)) {
                                    a(i3, newValue, valueOf2);
                                    break;
                                } else {
                                    i++;
                                    i2 = i3;
                                    i3 = i4;
                                }
                            } else {
                                int i5 = i2 + 1;
                                if (i5 < newValue.getText().length()) {
                                    a(i5, newValue, valueOf2);
                                }
                            }
                        }
                    }
                }
            } else if (Intrinsics.areEqual(text, valueOf) && (str2 = (dVar2 = this.b).f) != null) {
                dVar2.a(str2, InputChangeAction.CUT);
            }
            this.b.b.b = false;
        }
    }
}
