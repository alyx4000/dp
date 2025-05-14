package com.quantummetric.ui.internal;

import com.facebook.common.callercontext.ContextChain;
import java.util.List;

/* loaded from: classes5.dex */
final class ac {

    /* renamed from: a, reason: collision with root package name */
    List<a> f23a;
    boolean b;

    enum a {
        WHITE_TEXT_COLOR,
        BLACK_TEXT_COLOR,
        SINGLE_LINE,
        WHITE_BACKGROUND,
        BLACK_BACKGROUND
    }

    ac() {
    }

    final void a(ar arVar, ch chVar) {
        String str;
        if (chVar.i()) {
            arVar.a((ar) ContextChain.TAG_PRODUCT);
            str = " ";
        } else {
            str = "";
        }
        List<a> list = this.f23a;
        if (list != null) {
            if (list.contains(a.BLACK_BACKGROUND)) {
                arVar.a((ar) str).a((ar) "bbc");
            } else if (this.f23a.contains(a.WHITE_BACKGROUND)) {
                arVar.a((ar) str).a((ar) "wbc");
            }
        }
    }

    final boolean a() {
        List<a> list = this.f23a;
        if (list != null) {
            return list.contains(a.WHITE_BACKGROUND) || this.f23a.contains(a.BLACK_BACKGROUND);
        }
        return false;
    }

    public final String toString() {
        List<a> list = this.f23a;
        return list != null ? list.toString() : super.toString();
    }
}
