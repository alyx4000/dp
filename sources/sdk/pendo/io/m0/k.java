package sdk.pendo.io.m0;

import external.sdk.pendo.io.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import sdk.pendo.io.k0.q;

/* loaded from: classes6.dex */
public final class k {
    public static sdk.pendo.io.k0.i a(sdk.pendo.io.r0.a aVar) {
        boolean z;
        try {
            try {
                aVar.D();
                z = false;
                try {
                    return TypeAdapters.V.a(aVar);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return sdk.pendo.io.k0.k.f;
                    }
                    throw new q(e);
                }
            } catch (IOException e2) {
                throw new sdk.pendo.io.k0.j(e2);
            } catch (NumberFormatException e3) {
                throw new q(e3);
            } catch (sdk.pendo.io.r0.d e4) {
                throw new q(e4);
            }
        } catch (EOFException e5) {
            e = e5;
            z = true;
        }
    }

    public static void a(sdk.pendo.io.k0.i iVar, sdk.pendo.io.r0.c cVar) {
        TypeAdapters.V.a(cVar, iVar);
    }
}
