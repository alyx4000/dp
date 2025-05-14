package sdk.pendo.io.t0;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.s0.c;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final c f1541a;
    private final Map<String, sdk.pendo.io.s0.a> b = new HashMap();
    private Typeface c;

    public a(c cVar) {
        this.f1541a = cVar;
        for (sdk.pendo.io.s0.a aVar : cVar.b()) {
            this.b.put(aVar.b(), aVar);
        }
    }

    public c a() {
        return this.f1541a;
    }

    public Typeface a(Context context) {
        Typeface typeface = this.c;
        if (typeface != null) {
            return typeface;
        }
        synchronized (this) {
            Typeface typeface2 = this.c;
            if (typeface2 != null) {
                return typeface2;
            }
            Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), this.f1541a.a());
            this.c = createFromAsset;
            return createFromAsset;
        }
    }

    public boolean a(sdk.pendo.io.s0.a aVar) {
        return this.b.values().contains(aVar);
    }
}
