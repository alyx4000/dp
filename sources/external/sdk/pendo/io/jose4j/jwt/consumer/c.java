package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class c extends Exception {
    private List<b.a> f;
    private g s;

    public c(String str, b.a aVar, Throwable th, g gVar) {
        super(str, th);
        this.f = Collections.emptyList();
        this.s = gVar;
        this.f = Collections.singletonList(aVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        if (!this.f.isEmpty()) {
            sb.append(" Additional details: ");
            sb.append(this.f);
        }
        return sb.toString();
    }

    public c(String str, List<b.a> list, g gVar) {
        super(str);
        Collections.emptyList();
        this.f = list;
        this.s = gVar;
    }
}
