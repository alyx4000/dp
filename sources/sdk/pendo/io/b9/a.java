package sdk.pendo.io.b9;

import sdk.pendo.io.d6.j;

/* loaded from: classes6.dex */
public final class a implements j<Object> {
    private sdk.pendo.io.f7.a f;

    public a(sdk.pendo.io.f7.a aVar) {
        this.f = aVar;
    }

    @Override // sdk.pendo.io.d6.j
    public boolean test(Object obj) {
        sdk.pendo.io.f7.a aVar = (sdk.pendo.io.f7.a) obj;
        return aVar != null && aVar.equals(this.f);
    }
}
