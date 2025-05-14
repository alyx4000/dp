package sdk.pendo.io.o2;

import com.squareup.moshi.Json;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.Writer;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import sdk.pendo.io.s2.h;
import sdk.pendo.io.s2.i;
import sdk.pendo.io.s2.k;
import sdk.pendo.io.s2.l;

@Deprecated
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final sdk.pendo.io.s2.b f1456a = new sdk.pendo.io.s2.f(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}).a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.i())).a(sdk.pendo.io.s2.e.a(32, 127));
    public static final sdk.pendo.io.s2.b b = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.i()), sdk.pendo.io.s2.e.a(32, 127));
    public static final sdk.pendo.io.s2.b c = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.i()), sdk.pendo.io.s2.e.a(32, 127));

    @Deprecated
    public static final sdk.pendo.io.s2.b d = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.c()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.a()));
    public static final sdk.pendo.io.s2.b e = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.c()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.a()), new sdk.pendo.io.s2.f(new String[]{Json.UNSET_NAME, ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), sdk.pendo.io.s2.g.a(127, 132), sdk.pendo.io.s2.g.a(134, Token.LETEXPR), new l());
    public static final sdk.pendo.io.s2.b f = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.c()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.a()), new sdk.pendo.io.s2.f(new String[]{Json.UNSET_NAME, ""}, new String[]{"\u000b", "&#11;"}, new String[]{"\f", "&#12;"}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), sdk.pendo.io.s2.g.a(1, 8), sdk.pendo.io.s2.g.a(14, 31), sdk.pendo.io.s2.g.a(127, 132), sdk.pendo.io.s2.g.a(134, Token.LETEXPR), new l());
    public static final sdk.pendo.io.s2.b g = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.c()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.g()));
    public static final sdk.pendo.io.s2.b h = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.c()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.g()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.e()));
    public static final sdk.pendo.io.s2.b i = new a();
    public static final sdk.pendo.io.s2.b j;
    public static final sdk.pendo.io.s2.b k;
    public static final sdk.pendo.io.s2.b l;
    public static final sdk.pendo.io.s2.b m;
    public static final sdk.pendo.io.s2.b n;
    public static final sdk.pendo.io.s2.b o;
    public static final sdk.pendo.io.s2.b p;

    static class a extends sdk.pendo.io.s2.b {
        private static final String b = String.valueOf(Typography.quote);
        private static final char[] c = {',', Typography.quote, CharUtils.CR, '\n'};

        a() {
        }

        @Override // sdk.pendo.io.s2.b
        public int a(CharSequence charSequence, int i, Writer writer) {
            if (i != 0) {
                throw new IllegalStateException("CsvEscaper should never reach the [1] index");
            }
            if (g.b(charSequence.toString(), c)) {
                writer.write(charSequence.toString());
            } else {
                writer.write(34);
                String obj = charSequence.toString();
                String str = b;
                writer.write(g.a(obj, str, str + str));
                writer.write(34);
            }
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    static class b extends sdk.pendo.io.s2.b {
        private static final String b = String.valueOf(Typography.quote);
        private static final char[] c = {',', Typography.quote, CharUtils.CR, '\n'};

        b() {
        }

        @Override // sdk.pendo.io.s2.b
        public int a(CharSequence charSequence, int i, Writer writer) {
            String obj;
            if (i != 0) {
                throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
            }
            if (charSequence.charAt(0) == '\"' && charSequence.charAt(charSequence.length() - 1) == '\"') {
                String obj2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                if (g.a(obj2, c)) {
                    StringBuilder sb = new StringBuilder();
                    String str = b;
                    obj = g.a(obj2, sb.append(str).append(str).toString(), str);
                } else {
                    obj = charSequence.toString();
                }
            } else {
                obj = charSequence.toString();
            }
            writer.write(obj);
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    static {
        sdk.pendo.io.s2.a aVar = new sdk.pendo.io.s2.a(new i(), new k(), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.j()), new sdk.pendo.io.s2.f(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
        j = aVar;
        k = aVar;
        l = aVar;
        m = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.d()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.h()), new sdk.pendo.io.s2.h(new h.a[0]));
        n = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.d()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.h()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.f()), new sdk.pendo.io.s2.h(new h.a[0]));
        o = new sdk.pendo.io.s2.a(new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.d()), new sdk.pendo.io.s2.f(sdk.pendo.io.s2.d.b()), new sdk.pendo.io.s2.h(new h.a[0]));
        p = new b();
    }

    public static final String a(String str) {
        return c.a(str);
    }
}
