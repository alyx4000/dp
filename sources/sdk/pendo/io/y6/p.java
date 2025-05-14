package sdk.pendo.io.y6;

import com.extole.android.sdk.impl.http.HttpRequest;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.UByte;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.s;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.x;
import sdk.pendo.io.w2.y;

/* loaded from: classes4.dex */
final class p {
    private static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    private final String f1852a;
    private final sdk.pendo.io.w2.v b;

    @Nullable
    private String c;

    @Nullable
    private v.a d;
    private final b0.a e = new b0.a();
    private final u.a f;

    @Nullable
    private x g;
    private final boolean h;

    @Nullable
    private y.a i;

    @Nullable
    private s.a j;

    @Nullable
    private c0 k;

    private static class a extends c0 {
        private final c0 b;
        private final x c;

        a(c0 c0Var, x xVar) {
            this.b = c0Var;
            this.c = xVar;
        }

        @Override // sdk.pendo.io.w2.c0
        public long a() {
            return this.b.a();
        }

        @Override // sdk.pendo.io.w2.c0
        /* renamed from: b */
        public x getExpo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY java.lang.String() {
            return this.c;
        }

        @Override // sdk.pendo.io.w2.c0
        public void a(sdk.pendo.io.k3.e eVar) {
            this.b.a(eVar);
        }
    }

    p(String str, sdk.pendo.io.w2.v vVar, @Nullable String str2, @Nullable sdk.pendo.io.w2.u uVar, @Nullable x xVar, boolean z, boolean z2, boolean z3) {
        this.f1852a = str;
        this.b = vVar;
        this.c = str2;
        this.g = xVar;
        this.h = z;
        this.f = uVar != null ? uVar.a() : new u.a();
        if (z2) {
            this.j = new s.a();
        } else if (z3) {
            y.a aVar = new y.a();
            this.i = aVar;
            aVar.a(y.l);
        }
    }

    void a(String str, String str2, boolean z) {
        if (z) {
            this.j.b(str, str2);
        } else {
            this.j.a(str, str2);
        }
    }

    void b(String str, String str2, boolean z) {
        if (this.c == null) {
            throw new AssertionError();
        }
        String replace = this.c.replace("{" + str + "}", a(str2, z));
        if (m.matcher(replace).matches()) {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        this.c = replace;
    }

    void c(String str, @Nullable String str2, boolean z) {
        String str3 = this.c;
        if (str3 != null) {
            v.a b = this.b.b(str3);
            this.d = b;
            if (b == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.c);
            }
            this.c = null;
        }
        if (z) {
            this.d.a(str, str2);
        } else {
            this.d.b(str, str2);
        }
    }

    void a(String str, String str2) {
        if (!HttpRequest.HEADER_CONTENT_TYPE.equalsIgnoreCase(str)) {
            this.f.a(str, str2);
            return;
        }
        try {
            this.g = x.a(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e);
        }
    }

    void a(sdk.pendo.io.w2.u uVar) {
        this.f.a(uVar);
    }

    void a(sdk.pendo.io.w2.u uVar, c0 c0Var) {
        this.i.a(uVar, c0Var);
    }

    void a(y.c cVar) {
        this.i.a(cVar);
    }

    <T> void a(Class<T> cls, @Nullable T t) {
        this.e.a((Class<? super Class<T>>) cls, (Class<T>) t);
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
                dVar.a(str, 0, i);
                a(dVar, str, i, length, z);
                return dVar.w();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void a(sdk.pendo.io.k3.d dVar, String str, int i, int i2, boolean z) {
        sdk.pendo.io.k3.d dVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (dVar2 == null) {
                        dVar2 = new sdk.pendo.io.k3.d();
                    }
                    dVar2.f(codePointAt);
                    while (!dVar2.i()) {
                        int readByte = dVar2.readByte() & UByte.MAX_VALUE;
                        dVar.writeByte(37);
                        char[] cArr = l;
                        dVar.writeByte((int) cArr[(readByte >> 4) & 15]);
                        dVar.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    dVar.f(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    b0.a a() {
        sdk.pendo.io.w2.v d;
        v.a aVar = this.d;
        if (aVar != null) {
            d = aVar.a();
        } else {
            d = this.b.d(this.c);
            if (d == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.c);
            }
        }
        c0 c0Var = this.k;
        if (c0Var == null) {
            s.a aVar2 = this.j;
            if (aVar2 != null) {
                c0Var = aVar2.a();
            } else {
                y.a aVar3 = this.i;
                if (aVar3 != null) {
                    c0Var = aVar3.a();
                } else if (this.h) {
                    c0Var = c0.a((x) null, new byte[0]);
                }
            }
        }
        x xVar = this.g;
        if (xVar != null) {
            if (c0Var != null) {
                c0Var = new a(c0Var, xVar);
            } else {
                this.f.a(HttpRequest.HEADER_CONTENT_TYPE, xVar.getMediaType());
            }
        }
        return this.e.a(d).a(this.f.a()).a(this.f1852a, c0Var);
    }

    void a(c0 c0Var) {
        this.k = c0Var;
    }

    void a(Object obj) {
        this.c = obj.toString();
    }
}
