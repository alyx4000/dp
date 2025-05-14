package external.sdk.pendo.io.gson.internal.sql;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.r0.b;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // sdk.pendo.io.k0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f747a;

    private SqlTimeTypeAdapter() {
        this.f747a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Time a(sdk.pendo.io.r0.a aVar) {
        Time time;
        if (aVar.D() == b.NULL) {
            aVar.A();
            return null;
        }
        String B = aVar.B();
        try {
            synchronized (this) {
                time = new Time(this.f747a.parse(B).getTime());
            }
            return time;
        } catch (ParseException e) {
            throw new q("Failed parsing '" + B + "' as SQL Time; at path " + aVar.r(), e);
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Time time) {
        String format;
        if (time == null) {
            cVar.s();
            return;
        }
        synchronized (this) {
            format = this.f747a.format((Date) time);
        }
        cVar.e(format);
    }
}
