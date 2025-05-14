package external.sdk.pendo.io.gson.internal.sql;

import external.sdk.pendo.io.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;
import sdk.pendo.io.k0.u;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f749a;
    public static final DefaultDateTypeAdapter.b<? extends Date> b;
    public static final DefaultDateTypeAdapter.b<? extends Date> c;
    public static final u d;
    public static final u e;
    public static final u f;

    /* renamed from: external.sdk.pendo.io.gson.internal.sql.a$a, reason: collision with other inner class name */
    class C0069a extends DefaultDateTypeAdapter.b<java.sql.Date> {
        C0069a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // external.sdk.pendo.io.gson.internal.bind.DefaultDateTypeAdapter.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.sql.Date a(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    class b extends DefaultDateTypeAdapter.b<Timestamp> {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // external.sdk.pendo.io.gson.internal.bind.DefaultDateTypeAdapter.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Timestamp a(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        u uVar;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f749a = z;
        if (z) {
            b = new C0069a(java.sql.Date.class);
            c = new b(Timestamp.class);
            d = SqlDateTypeAdapter.b;
            e = SqlTimeTypeAdapter.b;
            uVar = SqlTimestampTypeAdapter.b;
        } else {
            uVar = null;
            b = null;
            c = null;
            d = null;
            e = null;
        }
        f = uVar;
    }
}
