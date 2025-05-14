package external.sdk.pendo.io.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.j;
import sdk.pendo.io.k0.m;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.m0.k;
import sdk.pendo.io.r0.b;
import sdk.pendo.io.r0.d;

/* loaded from: classes2.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static i a(Reader reader) {
        try {
            sdk.pendo.io.r0.a aVar = new sdk.pendo.io.r0.a(reader);
            i a2 = a(aVar);
            if (!a2.i() && aVar.D() != b.END_DOCUMENT) {
                throw new q("Did not consume the entire document.");
            }
            return a2;
        } catch (d e) {
            throw new q(e);
        } catch (IOException e2) {
            throw new j(e2);
        } catch (NumberFormatException e3) {
            throw new q(e3);
        }
    }

    public static i a(sdk.pendo.io.r0.a aVar) {
        boolean t = aVar.t();
        aVar.c(true);
        try {
            try {
                return k.a(aVar);
            } catch (OutOfMemoryError e) {
                throw new m("Failed parsing JSON source: " + aVar + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new m("Failed parsing JSON source: " + aVar + " to Json", e2);
            }
        } finally {
            aVar.c(t);
        }
    }

    public static i a(String str) {
        return a(new StringReader(str));
    }
}
