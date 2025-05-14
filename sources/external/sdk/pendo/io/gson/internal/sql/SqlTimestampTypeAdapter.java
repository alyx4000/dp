package external.sdk.pendo.io.gson.internal.sql;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.sql.Timestamp;
import java.util.Date;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // sdk.pendo.io.k0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
            if (aVar.a() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.a(Date.class));
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final TypeAdapter<Date> f748a;

    private SqlTimestampTypeAdapter(TypeAdapter<Date> typeAdapter) {
        this.f748a = typeAdapter;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Timestamp a(sdk.pendo.io.r0.a aVar) {
        Date a2 = this.f748a.a(aVar);
        if (a2 != null) {
            return new Timestamp(a2.getTime());
        }
        return null;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Timestamp timestamp) {
        this.f748a.a(cVar, timestamp);
    }
}
