package com.squareup.kotlinpoet;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/squareup/kotlinpoet/NullAppendable;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "()V", "append", "c", "", "charSequence", "", ViewProps.START, "", ViewProps.END, "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NullAppendable implements Appendable {
    public static final NullAppendable INSTANCE = new NullAppendable();

    @Override // java.lang.Appendable
    public NullAppendable append(char c) {
        return this;
    }

    @Override // java.lang.Appendable
    public NullAppendable append(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return this;
    }

    @Override // java.lang.Appendable
    public NullAppendable append(CharSequence charSequence, int start, int end) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return this;
    }

    private NullAppendable() {
    }
}
