package sdk.pendo.io.t5;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u001b\u0010\u0007\u001a\u0017\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005¢\u0006\u0002\b\u0006H\u0007*,\u0010\t\"\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u00062\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0006¨\u0006\n"}, d2 = {"", "createdAtStart", "Lkotlin/Function1;", "Lsdk/pendo/io/o5/a;", "", "Lexternal/sdk/pendo/io/org/koin/dsl/ModuleDeclaration;", "Lkotlin/ExtensionFunctionType;", "moduleDeclaration", "a", "ModuleDeclaration", "koin-core"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {
    public static final sdk.pendo.io.o5.a a(boolean z, Function1<? super sdk.pendo.io.o5.a, Unit> moduleDeclaration) {
        Intrinsics.checkNotNullParameter(moduleDeclaration, "moduleDeclaration");
        sdk.pendo.io.o5.a aVar = new sdk.pendo.io.o5.a(z);
        moduleDeclaration.invoke(aVar);
        return aVar;
    }

    public static /* synthetic */ sdk.pendo.io.o5.a a(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z, function1);
    }
}
