package sdk.pendo.io.v1;

/* loaded from: classes4.dex */
public abstract class c extends j {
    protected boolean c(String str, Object obj, g gVar) {
        if (obj == null) {
            if (f()) {
                throw new sdk.pendo.io.n1.k("The path " + str + " is null");
            }
            return false;
        }
        if (gVar.e().e(obj)) {
            return true;
        }
        if (f()) {
            throw new sdk.pendo.io.n1.k(String.format("Filter: %s can only be applied to arrays. Current context is: %s", toString(), obj));
        }
        return false;
    }
}
