package external.sdk.pendo.io.gson.internal.sql;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.r0.b;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // sdk.pendo.io.k0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f746a;

    private SqlDateTypeAdapter() {
        this.f746a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Date a(sdk.pendo.io.r0.a aVar) {
        java.util.Date parse;
        if (aVar.D() == b.NULL) {
            aVar.A();
            return null;
        }
        String B = aVar.B();
        try {
            synchronized (this) {
                parse = this.f746a.parse(B);
            }
            return new Date(parse.getTime());
        } catch (ParseException e) {
            throw new q("Failed parsing '" + B + "' as SQL Date; at path " + aVar.r(), e);
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.s();
            return;
        }
        synchronized (this) {
            format = this.f746a.format((java.util.Date) date);
        }
        cVar.e(format);
    }
}
