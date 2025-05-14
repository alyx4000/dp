package external.sdk.pendo.io.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.j;
import sdk.pendo.io.r0.b;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public abstract class TypeAdapter<T> {
    public final T a(Reader reader) {
        return a(new sdk.pendo.io.r0.a(reader));
    }

    public abstract T a(sdk.pendo.io.r0.a aVar);

    public abstract void a(c cVar, T t);

    public final T a(String str) {
        return a((Reader) new StringReader(str));
    }

    public final TypeAdapter<T> a() {
        return new TypeAdapter<T>() { // from class: external.sdk.pendo.io.gson.TypeAdapter.1
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public T a(sdk.pendo.io.r0.a aVar) {
                if (aVar.D() != b.NULL) {
                    return (T) TypeAdapter.this.a(aVar);
                }
                aVar.A();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(c cVar, T t) {
                if (t == null) {
                    cVar.s();
                } else {
                    TypeAdapter.this.a(cVar, t);
                }
            }
        };
    }

    public final i a(T t) {
        try {
            sdk.pendo.io.n0.a aVar = new sdk.pendo.io.n0.a();
            a(aVar, t);
            return aVar.v();
        } catch (IOException e) {
            throw new j(e);
        }
    }
}
