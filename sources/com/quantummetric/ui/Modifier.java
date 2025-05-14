package com.quantummetric.ui;

import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Landroidx/compose/ui/Modifier;", "quantumMetricEncrypt", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "quantumMetricMask", "quantumMetricWhitelist", "", "KEY_QM_ENCRYPT", "Ljava/lang/String;", "KEY_QM_MASK", "KEY_QM_WHITELIST"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* renamed from: com.quantummetric.instrument.QuantumMetricModifiersKt, reason: from Kotlin metadata */
/* loaded from: classes5.dex */
public final class Modifier {
    public static final String KEY_QM_ENCRYPT = "QuantumMetricEncrypt";
    public static final String KEY_QM_MASK = "QuantumMetricMask";
    public static final String KEY_QM_WHITELIST = "QuantumMetricWhitelist";

    public static final androidx.compose.ui.Modifier quantumMetricEncrypt(androidx.compose.ui.Modifier modifier) {
        return SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.quantummetric.instrument.QuantumMetricModifiersKt.1
            public final void a(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                semanticsPropertyReceiver.set(new SemanticsPropertyKey(Modifier.KEY_QM_ENCRYPT, (Function2) null, 2, (DefaultConstructorMarker) null), Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                a(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }, 1, (Object) null);
    }

    public static final androidx.compose.ui.Modifier quantumMetricMask(androidx.compose.ui.Modifier modifier) {
        return SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.quantummetric.instrument.QuantumMetricModifiersKt.2
            public final void a(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                semanticsPropertyReceiver.set(new SemanticsPropertyKey(Modifier.KEY_QM_MASK, (Function2) null, 2, (DefaultConstructorMarker) null), Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                a(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }, 1, (Object) null);
    }

    public static final androidx.compose.ui.Modifier quantumMetricWhitelist(androidx.compose.ui.Modifier modifier) {
        return SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.quantummetric.instrument.QuantumMetricModifiersKt.3
            public final void a(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                semanticsPropertyReceiver.set(new SemanticsPropertyKey(Modifier.KEY_QM_WHITELIST, (Function2) null, 2, (DefaultConstructorMarker) null), Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                a(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }, 1, (Object) null);
    }
}
