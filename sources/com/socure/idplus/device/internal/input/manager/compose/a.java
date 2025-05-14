package com.socure.idplus.device.internal.input.manager.compose;

import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import com.socure.idplus.device.internal.behavior.model.InputChangeAction;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f570a;
    public final /* synthetic */ Function1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, Function1 function1) {
        super(1);
        this.f570a = dVar;
        this.b = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        List editCommands = (List) obj;
        Intrinsics.checkNotNullParameter(editCommands, "editCommands");
        d dVar = this.f570a;
        String str = dVar.f;
        if (str != null) {
            Iterator it = editCommands.iterator();
            while (it.hasNext()) {
                if (((EditCommand) it.next()) instanceof SetComposingTextCommand) {
                    dVar.a(str, InputChangeAction.UNKNOWN);
                }
            }
        }
        this.b.invoke(editCommands);
        return Unit.INSTANCE;
    }
}
