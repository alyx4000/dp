package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.d;
import sdk.pendo.io.m0.i;
import sdk.pendo.io.r0.b;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final u b = new u() { // from class: external.sdk.pendo.io.gson.internal.bind.DateTypeAdapter.1
        @Override // sdk.pendo.io.k0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f728a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f728a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (d.b()) {
            arrayList.add(i.a(2, 2));
        }
    }

    private Date b(sdk.pendo.io.r0.a aVar) {
        String B = aVar.B();
        synchronized (this.f728a) {
            Iterator<DateFormat> it = this.f728a.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(B);
                } catch (ParseException unused) {
                }
            }
            try {
                return sdk.pendo.io.o0.a.a(B, new ParsePosition(0));
            } catch (ParseException e) {
                throw new q("Failed parsing '" + B + "' as Date; at path " + aVar.r(), e);
            }
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Date a(sdk.pendo.io.r0.a aVar) {
        if (aVar.D() != b.NULL) {
            return b(aVar);
        }
        aVar.A();
        return null;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.s();
            return;
        }
        DateFormat dateFormat = this.f728a.get(0);
        synchronized (this.f728a) {
            format = dateFormat.format(date);
        }
        cVar.e(format);
    }
}
