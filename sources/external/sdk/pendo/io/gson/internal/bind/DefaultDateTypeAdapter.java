package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.TypeAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.d;
import sdk.pendo.io.m0.i;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f729a;
    private final List<DateFormat> b;

    public static abstract class b<T extends Date> {
        public static final b<Date> b = new a(Date.class);

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f730a;

        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            @Override // external.sdk.pendo.io.gson.internal.bind.DefaultDateTypeAdapter.b
            protected Date a(Date date) {
                return date;
            }
        }

        protected b(Class<T> cls) {
            this.f730a = cls;
        }

        protected abstract T a(Date date);

        public final u a(int i, int i2) {
            return a(new DefaultDateTypeAdapter<>(this, i, i2));
        }

        public final u a(String str) {
            return a(new DefaultDateTypeAdapter<>(this, str));
        }

        private final u a(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.a(this.f730a, defaultDateTypeAdapter);
        }
    }

    private DefaultDateTypeAdapter(b<T> bVar, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f729a = (b) sdk.pendo.io.m0.a.a(bVar);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (d.b()) {
            arrayList.add(i.a(i, i2));
        }
    }

    private Date b(sdk.pendo.io.r0.a aVar) {
        String B = aVar.B();
        synchronized (this.b) {
            Iterator<DateFormat> it = this.b.iterator();
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
    public T a(sdk.pendo.io.r0.a aVar) {
        if (aVar.D() == sdk.pendo.io.r0.b.NULL) {
            aVar.A();
            return null;
        }
        return this.f729a.a(b(aVar));
    }

    public String toString() {
        StringBuilder sb;
        String simpleName;
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb = new StringBuilder("DefaultDateTypeAdapter(");
            simpleName = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb = new StringBuilder("DefaultDateTypeAdapter(");
            simpleName = dateFormat.getClass().getSimpleName();
        }
        return sb.append(simpleName).append(')').toString();
    }

    private DefaultDateTypeAdapter(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f729a = (b) sdk.pendo.io.m0.a.a(bVar);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.s();
            return;
        }
        DateFormat dateFormat = this.b.get(0);
        synchronized (this.b) {
            format = dateFormat.format(date);
        }
        cVar.e(format);
    }
}
