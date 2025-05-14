package sdk.pendo.io.y4;

import java.util.Hashtable;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    protected final sdk.pendo.io.z4.f f1788a;
    protected final Hashtable b;

    public m(sdk.pendo.io.z4.f fVar, Hashtable hashtable) {
        if (fVar == null) {
            throw new NullPointerException("'certificate' cannot be null");
        }
        this.f1788a = fVar;
        this.b = hashtable;
    }

    public sdk.pendo.io.z4.f a() {
        return this.f1788a;
    }

    public Hashtable b() {
        return this.b;
    }
}
