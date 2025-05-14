package sdk.pendo.io.w2;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.hermes.intl.Constants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.actions.SearchIntents;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.sentry.protocol.Request;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.math.Primes;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0018\u0018\u0000 '2\u00020\u0001:\u0002\u0015\u000eBc\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\u0012\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0$\u0012\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010$\u0012\b\u0010,\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010.\u001a\u00020\b¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\bJ\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u0017\u0010\u0019\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010#\u001a\u00020\u00128\u0007¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0$8\u0007¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010&R\u0019\u0010,\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u0014\u0010.\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0016R\u0017\u00101\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b-\u00100R\u0011\u00102\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b*\u0010\u0018R\u0011\u00103\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0011\u00104\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0018R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\b0$8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010(R\u0013\u00106\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b%\u0010\u0018R\u0013\u00108\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b7\u0010\u0018R\u0013\u00109\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0018¨\u0006<"}, d2 = {"Lsdk/pendo/io/w2/v;", "", "Ljava/net/URL;", "q", "()Ljava/net/URL;", "Ljava/net/URI;", ContextChain.TAG_PRODUCT, "()Ljava/net/URI;", "", "n", "link", "d", "Lsdk/pendo/io/w2/v$a;", "j", "b", "other", "", "equals", "", "hashCode", "toString", "a", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "scheme", "username", "c", "password", "h", "host", "e", "I", "l", "()I", "port", "", "f", "Ljava/util/List;", "k", "()Ljava/util/List;", "pathSegments", "g", "queryNamesAndValues", Request.JsonKeys.FRAGMENT, ContextChain.TAG_INFRA, "url", "Z", "()Z", "isHttps", "encodedUsername", "encodedPassword", "encodedPath", "encodedPathSegments", "encodedQuery", "m", SearchIntents.EXTRA_QUERY, "encodedFragment", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class v {

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String scheme;

    /* renamed from: b, reason: from kotlin metadata */
    private final String username;

    /* renamed from: c, reason: from kotlin metadata */
    private final String password;

    /* renamed from: d, reason: from kotlin metadata */
    private final String host;

    /* renamed from: e, reason: from kotlin metadata */
    private final int port;

    /* renamed from: f, reason: from kotlin metadata */
    private final List<String> pathSegments;

    /* renamed from: g, reason: from kotlin metadata */
    private final List<String> queryNamesAndValues;

    /* renamed from: h, reason: from kotlin metadata */
    private final String fragment;

    /* renamed from: i, reason: from kotlin metadata */
    private final String url;

    /* renamed from: j, reason: from kotlin metadata */
    private final boolean isHttps;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 -2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J0\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u000f\u0010\u000f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u001fJ\u0006\u0010\t\u001a\u00020 J\b\u0010!\u001a\u00020\u0004H\u0016J!\u0010\t\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010#R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010+\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010$\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\"\u0010.\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010$\u001a\u0004\b,\u0010&\"\u0004\b-\u0010(R$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u00101\u001a\u0004\b2\u00103\"\u0004\b\u0003\u00104R \u00108\u001a\b\u0012\u0004\u0012\u00020\u0004058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u00106\u001a\u0004\b\u0017\u00107R,\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u00106\u001a\u0004\b9\u00107\"\u0004\b:\u0010;R$\u0010?\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010$\u001a\u0004\b>\u0010&\"\u0004\b=\u0010(¨\u0006B"}, d2 = {"Lsdk/pendo/io/w2/v$a;", "", "", "b", "", "input", "startPos", "limit", "", "a", "pos", "", "addTrailingSlash", "alreadyEncoded", "d", "e", "scheme", "g", "username", "m", "password", "f", "host", "c", "port", "pathSegment", "encodedQuery", "name", "value", "encodedName", "encodedValue", "()Lsdk/pendo/io/w2/v$a;", "Lsdk/pendo/io/w2/v;", "toString", Constants.SENSITIVITY_BASE, "(Lsdk/pendo/io/w2/v;Ljava/lang/String;)Lsdk/pendo/io/w2/v$a;", "Ljava/lang/String;", "getScheme$okhttp", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "getEncodedUsername$okhttp", "j", "encodedUsername", "getEncodedPassword$okhttp", ContextChain.TAG_INFRA, "encodedPassword", "getHost$okhttp", "k", "I", "getPort$okhttp", "()I", "(I)V", "", "Ljava/util/List;", "()Ljava/util/List;", "encodedPathSegments", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedQueryNamesAndValues", "h", "getEncodedFragment$okhttp", "encodedFragment", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* renamed from: i, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String scheme;

        /* renamed from: d, reason: from kotlin metadata */
        private String host;

        /* renamed from: f, reason: from kotlin metadata */
        private final List<String> encodedPathSegments;

        /* renamed from: g, reason: from kotlin metadata */
        private List<String> encodedQueryNamesAndValues;

        /* renamed from: h, reason: from kotlin metadata */
        private String encodedFragment;

        /* renamed from: b, reason: from kotlin metadata */
        private String encodedUsername = "";

        /* renamed from: c, reason: from kotlin metadata */
        private String encodedPassword = "";

        /* renamed from: e, reason: from kotlin metadata */
        private int port = -1;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/w2/v$a$a;", "", "", "input", "", "pos", "limit", "c", "d", "b", "a", "INVALID_HOST", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
        /* renamed from: sdk.pendo.io.w2.v$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int a(String input, int pos, int limit) {
                int parseInt;
                try {
                    parseInt = Integer.parseInt(Companion.a(v.INSTANCE, input, pos, limit, "", false, false, false, false, null, 248, null));
                } catch (NumberFormatException unused) {
                }
                if (1 <= parseInt && parseInt < 65536) {
                    return parseInt;
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int b(String input, int pos, int limit) {
                while (pos < limit) {
                    char charAt = input.charAt(pos);
                    if (charAt == '[') {
                        do {
                            pos++;
                            if (pos < limit) {
                            }
                        } while (input.charAt(pos) != ']');
                    } else if (charAt == ':') {
                        return pos;
                    }
                    pos++;
                }
                return limit;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int c(String input, int pos, int limit) {
                if (limit - pos < 2) {
                    return -1;
                }
                char charAt = input.charAt(pos);
                if ((Intrinsics.compare((int) charAt, 97) >= 0 && Intrinsics.compare((int) charAt, 122) <= 0) || (Intrinsics.compare((int) charAt, 65) >= 0 && Intrinsics.compare((int) charAt, 90) <= 0)) {
                    for (int i = pos + 1; i < limit; i++) {
                        char charAt2 = input.charAt(i);
                        if (!(((((('a' <= charAt2 && charAt2 < '{') || ('A' <= charAt2 && charAt2 < '[')) || ('0' <= charAt2 && charAt2 < ':')) || charAt2 == '+') || charAt2 == '-') || charAt2 == '.')) {
                            if (charAt2 == ':') {
                                return i;
                            }
                            return -1;
                        }
                    }
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int d(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final boolean d(String input) {
            return Intrinsics.areEqual(input, ".") || StringsKt.equals(input, "%2e", true);
        }

        private final boolean e(String input) {
            return Intrinsics.areEqual(input, "..") || StringsKt.equals(input, "%2e.", true) || StringsKt.equals(input, ".%2e", true) || StringsKt.equals(input, "%2e%2e", true);
        }

        public final a a(String encodedName, String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = v.INSTANCE;
            list.add(Companion.a(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, Primes.SMALL_FACTOR_LIMIT, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(encodedValue != null ? Companion.a(companion, encodedValue, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, Primes.SMALL_FACTOR_LIMIT, null) : null);
            return this;
        }

        public final a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = v.INSTANCE;
            list.add(Companion.a(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(value != null ? Companion.a(companion, value, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final List<String> c() {
            return this.encodedPathSegments;
        }

        public final a f(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.encodedPassword = Companion.a(v.INSTANCE, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a g(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            String str = "http";
            if (!StringsKt.equals(scheme, "http", true)) {
                str = "https";
                if (!StringsKt.equals(scheme, "https", true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
            }
            this.scheme = str;
            return this;
        }

        public final void h(String str) {
            this.encodedFragment = str;
        }

        public final void i(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final void j(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void k(String str) {
            this.host = str;
        }

        public final void l(String str) {
            this.scheme = str;
        }

        public final a m(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            this.encodedUsername = Companion.a(v.INSTANCE, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        
            if ((r6.encodedPassword.length() > 0) != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
        
            if (r1 != r3.a(r2)) goto L38;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto Lf
                r0.append(r1)
                java.lang.String r1 = "://"
                goto L11
            Lf:
                java.lang.String r1 = "//"
            L11:
                r0.append(r1)
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L20
                r1 = r2
                goto L21
            L20:
                r1 = r3
            L21:
                r4 = 58
                if (r1 != 0) goto L32
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L2f
                r1 = r2
                goto L30
            L2f:
                r1 = r3
            L30:
                if (r1 == 0) goto L50
            L32:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L40
                goto L41
            L40:
                r2 = r3
            L41:
                if (r2 == 0) goto L4b
                r0.append(r4)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L4b:
                r1 = 64
                r0.append(r1)
            L50:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L74
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt.contains$default(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L6f
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L74
            L6f:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L74:
                int r1 = r6.port
                r2 = -1
                if (r1 != r2) goto L7d
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L96
            L7d:
                int r1 = r6.b()
                java.lang.String r2 = r6.scheme
                if (r2 == 0) goto L90
                sdk.pendo.io.w2.v$b r3 = sdk.pendo.io.w2.v.INSTANCE
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                int r2 = r3.a(r2)
                if (r1 == r2) goto L96
            L90:
                r0.append(r4)
                r0.append(r1)
            L96:
                sdk.pendo.io.w2.v$b r1 = sdk.pendo.io.w2.v.INSTANCE
                java.util.List<java.lang.String> r2 = r6.encodedPathSegments
                r1.a(r2, r0)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto Lae
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                r1.b(r2, r0)
            Lae:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto Lbc
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            Lbc:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.w2.v.a.toString():java.lang.String");
        }

        private final int b() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = v.INSTANCE;
            String str = this.scheme;
            Intrinsics.checkNotNull(str);
            return companion.a(str);
        }

        private final void d() {
            List<String> list = this.encodedPathSegments;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        public final a a(String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            a(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final a c(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String b = sdk.pendo.io.x2.a.b(Companion.a(v.INSTANCE, host, 0, 0, false, 7, null));
            if (b == null) {
                throw new IllegalArgumentException("unexpected host: " + host);
            }
            this.host = b;
            return this;
        }

        public final a e() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.encodedPathSegments;
                list.set(i, Companion.a(v.INSTANCE, list.get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list2.get(i2);
                    list2.set(i2, str2 != null ? Companion.a(v.INSTANCE, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.a(v.INSTANCE, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, Token.GENEXPR, null) : null;
            return this;
        }

        public final v a() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = v.INSTANCE;
            String a2 = Companion.a(companion, this.encodedUsername, 0, 0, false, 7, null);
            String a3 = Companion.a(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int b = b();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.a(v.INSTANCE, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? Companion.a(v.INSTANCE, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new v(str, a2, a3, str2, b, arrayList2, arrayList, str4 != null ? Companion.a(v.INSTANCE, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final a b(String encodedQuery) {
            List<String> list;
            if (encodedQuery != null) {
                Companion companion = v.INSTANCE;
                String a2 = Companion.a(companion, encodedQuery, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, Primes.SMALL_FACTOR_LIMIT, null);
                if (a2 != null) {
                    list = companion.d(a2);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final a a(v base, String input) {
            int a2;
            int i;
            int i2;
            String str;
            boolean z;
            int i3;
            String str2;
            int i4;
            boolean z2;
            String input2 = input;
            Intrinsics.checkNotNullParameter(input2, "input");
            int a3 = sdk.pendo.io.x2.b.a(input2, 0, 0, 3, null);
            int b = sdk.pendo.io.x2.b.b(input2, a3, 0, 2, null);
            Companion companion = INSTANCE;
            int c = companion.c(input2, a3, b);
            String str3 = "this as java.lang.String…ing(startIndex, endIndex)";
            boolean z3 = true;
            char c2 = 65535;
            if (c != -1) {
                if (StringsKt.startsWith(input2, "https:", a3, true)) {
                    this.scheme = "https";
                    a3 += 6;
                } else {
                    if (!StringsKt.startsWith(input2, "http:", a3, true)) {
                        StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input2.substring(0, c);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        throw new IllegalArgumentException(sb.append(substring).append('\'').toString());
                    }
                    this.scheme = "http";
                    a3 += 5;
                }
            } else {
                if (base == null) {
                    if (input.length() > 6) {
                        input2 = StringsKt.take(input2, 6) + "...";
                    }
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + input2);
                }
                this.scheme = base.getScheme();
            }
            int d = companion.d(input2, a3, b);
            char c3 = '?';
            char c4 = '#';
            if (d >= 2 || base == null || !Intrinsics.areEqual(base.getScheme(), this.scheme)) {
                int i5 = a3 + d;
                boolean z4 = false;
                boolean z5 = false;
                while (true) {
                    a2 = sdk.pendo.io.x2.b.a(input2, "@/\\?#", i5, b);
                    char charAt = a2 != b ? input2.charAt(a2) : c2;
                    if (charAt == c2 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z4) {
                            z = z3;
                            i3 = b;
                            str2 = str3;
                            i4 = a2;
                            this.encodedPassword += "%40" + Companion.a(v.INSTANCE, input, i5, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                        } else {
                            int a4 = sdk.pendo.io.x2.b.a(input2, ':', i5, a2);
                            Companion companion2 = v.INSTANCE;
                            z = z3;
                            i3 = b;
                            String str4 = str3;
                            String a5 = Companion.a(companion2, input, i5, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z5) {
                                a5 = this.encodedUsername + "%40" + a5;
                            }
                            this.encodedUsername = a5;
                            if (a4 != a2) {
                                this.encodedPassword = Companion.a(companion2, input, a4 + 1, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z2 = z;
                            } else {
                                z2 = z4;
                            }
                            z4 = z2;
                            str2 = str4;
                            z5 = z;
                            i4 = a2;
                        }
                        i5 = i4 + 1;
                        str3 = str2;
                        z3 = z;
                        b = i3;
                        c4 = '#';
                        c3 = '?';
                        c2 = 65535;
                    }
                }
                boolean z6 = z3;
                String str5 = str3;
                i = b;
                Companion companion3 = INSTANCE;
                int b2 = companion3.b(input2, i5, a2);
                int i6 = b2 + 1;
                if (i6 < a2) {
                    i2 = i5;
                    this.host = sdk.pendo.io.x2.a.b(Companion.a(v.INSTANCE, input, i5, b2, false, 4, null));
                    int a6 = companion3.a(input2, i6, a2);
                    this.port = a6;
                    if (!(a6 != -1 ? z6 : false)) {
                        StringBuilder sb2 = new StringBuilder("Invalid URL port: \"");
                        String substring2 = input2.substring(i6, a2);
                        Intrinsics.checkNotNullExpressionValue(substring2, str5);
                        throw new IllegalArgumentException(sb2.append(substring2).append(Typography.quote).toString().toString());
                    }
                    str = str5;
                } else {
                    i2 = i5;
                    str = str5;
                    Companion companion4 = v.INSTANCE;
                    this.host = sdk.pendo.io.x2.a.b(Companion.a(companion4, input, i2, b2, false, 4, null));
                    String str6 = this.scheme;
                    Intrinsics.checkNotNull(str6);
                    this.port = companion4.a(str6);
                }
                if (!(this.host != null ? z6 : false)) {
                    StringBuilder sb3 = new StringBuilder("Invalid URL host: \"");
                    String substring3 = input2.substring(i2, b2);
                    Intrinsics.checkNotNullExpressionValue(substring3, str);
                    throw new IllegalArgumentException(sb3.append(substring3).append(Typography.quote).toString().toString());
                }
                a3 = a2;
            } else {
                this.encodedUsername = base.g();
                this.encodedPassword = base.c();
                this.host = base.getHost();
                this.port = base.getPort();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.e());
                if (a3 == b || input2.charAt(a3) == '#') {
                    b(base.f());
                }
                i = b;
            }
            int i7 = i;
            int a7 = sdk.pendo.io.x2.b.a(input2, "?#", a3, i7);
            a(input2, a3, a7);
            if (a7 < i7 && input2.charAt(a7) == '?') {
                int a8 = sdk.pendo.io.x2.b.a(input2, '#', a7, i7);
                Companion companion5 = v.INSTANCE;
                this.encodedQueryNamesAndValues = companion5.d(Companion.a(companion5, input, a7 + 1, a8, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, JfifUtil.MARKER_RST0, null));
                a7 = a8;
            }
            if (a7 < i7 && input2.charAt(a7) == '#') {
                this.encodedFragment = Companion.a(v.INSTANCE, input, a7 + 1, i7, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final void b(int i) {
            this.port = i;
        }

        public final a a(int port) {
            if (!(1 <= port && port < 65536)) {
                throw new IllegalArgumentException(("unexpected port: " + port).toString());
            }
            this.port = port;
            return this;
        }

        private final void a(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String a2 = Companion.a(v.INSTANCE, input, pos, limit, HttpUrl.PATH_SEGMENT_ENCODE_SET, alreadyEncoded, false, false, false, null, 240, null);
            if (d(a2)) {
                return;
            }
            if (e(a2)) {
                d();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, a2);
            } else {
                this.encodedPathSegments.add(a2);
            }
            if (addTrailingSlash) {
                this.encodedPathSegments.add("");
            }
        }

        private final void a(String input, int startPos, int limit) {
            if (startPos == limit) {
                return;
            }
            char charAt = input.charAt(startPos);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                startPos++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i = startPos;
                while (i < limit) {
                    startPos = sdk.pendo.io.x2.b.a(input, "/\\", i, limit);
                    boolean z = startPos < limit;
                    a(input, i, startPos, z, true);
                    if (z) {
                        i = startPos + 1;
                    }
                }
                return;
            }
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b1\u00102J,\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u000b\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002JV\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0007J%\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\u00142\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0000¢\u0006\u0004\b\u000b\u0010\u0018J'\u0010\u0019\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00142\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u001b\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001a*\u00020\u0003H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0019\u001a\u00020\u001d*\u00020\u0003H\u0007¢\u0006\u0004\b\u0019\u0010\u001eJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001d*\u00020\u0003H\u0007¢\u0006\u0004\b\u001f\u0010\u001eJ1\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010 Jc\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u000b\u0010!R\u0014\u0010\"\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010+\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010,\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b,\u0010#R\u0014\u0010-\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010#R\u0014\u0010.\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b.\u0010#R\u0014\u0010/\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b/\u0010#R\u0014\u00100\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b0\u0010#¨\u00063"}, d2 = {"Lsdk/pendo/io/w2/v$b;", "", "Lsdk/pendo/io/k3/d;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "", "a", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "scheme", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "b", "", "d", "(Ljava/lang/String;)Ljava/util/List;", "Lsdk/pendo/io/w2/v;", "(Ljava/lang/String;)Lsdk/pendo/io/w2/v;", "c", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.w2.v$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str, int i, int i2, String encodeSet, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int i3 = i;
            while (i3 < i2) {
                int codePointAt = str.codePointAt(i3);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z4) && !StringsKt.contains$default((CharSequence) encodeSet, (char) codePointAt, false, 2, (Object) null))) {
                    if (codePointAt == 37) {
                        if (z) {
                            if (z2) {
                                if (!a(str, i3, i2)) {
                                    sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
                                    dVar.a(str, i, i3);
                                    a(dVar, str, i3, i2, encodeSet, z, z2, z3, z4, charset);
                                    return dVar.w();
                                }
                                if (codePointAt != 43 && z3) {
                                    sdk.pendo.io.k3.d dVar2 = new sdk.pendo.io.k3.d();
                                    dVar2.a(str, i, i3);
                                    a(dVar2, str, i3, i2, encodeSet, z, z2, z3, z4, charset);
                                    return dVar2.w();
                                }
                                i3 += Character.charCount(codePointAt);
                            }
                        }
                    }
                    if (codePointAt != 43) {
                    }
                    i3 += Character.charCount(codePointAt);
                }
                sdk.pendo.io.k3.d dVar22 = new sdk.pendo.io.k3.d();
                dVar22.a(str, i, i3);
                a(dVar22, str, i3, i2, encodeSet, z, z2, z3, z4, charset);
                return dVar22.w();
            }
            String substring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        @JvmStatic
        public final v b(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return new a().a((v) null, str).a();
        }

        @JvmStatic
        public final v c(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return b(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final List<String> d(String str) {
            String str2;
            Intrinsics.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str, Typography.amp, i, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = str.length();
                }
                int i2 = indexOf$default;
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, '=', i, false, 4, (Object) null);
                if (indexOf$default2 == -1 || indexOf$default2 > i2) {
                    String substring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    str2 = null;
                } else {
                    String substring2 = str.substring(i, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    str2 = str.substring(indexOf$default2 + 1, i2);
                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(str2);
                i = i2 + 1;
            }
            return arrayList;
        }

        public static /* synthetic */ String a(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return companion.a(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        public final void b(List<String> list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression step = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
                return;
            }
            while (true) {
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    out.append(Typography.amp);
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (first == last) {
                    return;
                } else {
                    first += step2;
                }
            }
        }

        @JvmStatic
        public final int a(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            return Intrinsics.areEqual(scheme, "https") ? 443 : -1;
        }

        private final boolean a(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && sdk.pendo.io.x2.b.a(str.charAt(i + 1)) != -1 && sdk.pendo.io.x2.b.a(str.charAt(i3)) != -1;
        }

        public final String a(String str, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            for (int i3 = i; i3 < i2; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '%' || (charAt == '+' && z)) {
                    sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
                    dVar.a(str, i, i3);
                    a(dVar, str, i3, i2, z);
                    return dVar.w();
                }
            }
            String substring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public static /* synthetic */ String a(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.a(str, i, i2, z);
        }

        public final void a(List<String> list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                out.append(IOUtils.DIR_SEPARATOR_UNIX);
                out.append(list.get(i));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
        
            if (a(r16, r5, r18) == false) goto L41;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a(sdk.pendo.io.k3.d r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lb9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L28
                r8 = 9
                if (r7 == r8) goto L23
                r8 = 10
                if (r7 == r8) goto L23
                r8 = 12
                if (r7 == r8) goto L23
                r8 = 13
                if (r7 != r8) goto L28
            L23:
                r8 = r14
                r12 = r19
                goto Lb2
            L28:
                r8 = 43
                if (r7 != r8) goto L39
                if (r22 == 0) goto L39
                if (r20 == 0) goto L33
                java.lang.String r8 = "+"
                goto L35
            L33:
                java.lang.String r8 = "%2B"
            L35:
                r15.a(r8)
                goto L23
            L39:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L69
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L69
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L49
                if (r23 == 0) goto L69
            L49:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt.contains$default(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L67
                if (r7 != r9) goto L62
                if (r20 == 0) goto L67
                if (r21 == 0) goto L62
                r8 = r14
                boolean r10 = r14.a(r1, r5, r2)
                if (r10 != 0) goto L63
                goto L6c
            L62:
                r8 = r14
            L63:
                r15.f(r7)
                goto Lb2
            L67:
                r8 = r14
                goto L6c
            L69:
                r8 = r14
                r12 = r19
            L6c:
                if (r6 != 0) goto L73
                sdk.pendo.io.k3.d r6 = new sdk.pendo.io.k3.d
                r6.<init>()
            L73:
                if (r3 == 0) goto L87
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r10)
                if (r10 == 0) goto L7e
                goto L87
            L7e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.a(r1, r5, r10, r3)
                goto L8a
            L87:
                r6.f(r7)
            L8a:
                boolean r10 = r6.i()
                if (r10 != 0) goto Lb2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = sdk.pendo.io.w2.v.a()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = sdk.pendo.io.w2.v.a()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8a
            Lb2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lb9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.w2.v.Companion.a(sdk.pendo.io.k3.d, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void a(sdk.pendo.io.k3.d dVar, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                int codePointAt = str.codePointAt(i);
                if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                    if (codePointAt == 43 && z) {
                        dVar.writeByte(32);
                        i++;
                    }
                    dVar.f(codePointAt);
                    i += Character.charCount(codePointAt);
                } else {
                    int a2 = sdk.pendo.io.x2.b.a(str.charAt(i + 1));
                    int a3 = sdk.pendo.io.x2.b.a(str.charAt(i3));
                    if (a2 != -1 && a3 != -1) {
                        dVar.writeByte((a2 << 4) + a3);
                        i = Character.charCount(codePointAt) + i3;
                    }
                    dVar.f(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
        }
    }

    public v(String scheme, String username, String password, String host, int i, List<String> pathSegments, List<String> list, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = Intrinsics.areEqual(scheme, "https");
    }

    public final String b() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String c() {
        if (this.password.length() == 0) {
            return "";
        }
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String d() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, IOUtils.DIR_SEPARATOR_UNIX, this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        String substring = this.url.substring(indexOf$default, sdk.pendo.io.x2.b.a(str, "?#", indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> e() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, IOUtils.DIR_SEPARATOR_UNIX, this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int a2 = sdk.pendo.io.x2.b.a(str, "?#", indexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < a2) {
            int i = indexOf$default + 1;
            int a3 = sdk.pendo.io.x2.b.a(this.url, IOUtils.DIR_SEPARATOR_UNIX, i, a2);
            String substring = this.url.substring(i, a3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            indexOf$default = a3;
        }
        return arrayList;
    }

    public boolean equals(Object other) {
        return (other instanceof v) && Intrinsics.areEqual(((v) other).url, this.url);
    }

    public final String f() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        String substring = this.url.substring(indexOf$default, sdk.pendo.io.x2.b.a(str, '#', indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String g() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, sdk.pendo.io.x2.b.a(str, ":@", length, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: h, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsHttps() {
        return this.isHttps;
    }

    public final a j() {
        a aVar = new a();
        aVar.l(this.scheme);
        aVar.j(g());
        aVar.i(c());
        aVar.k(this.host);
        aVar.b(this.port != INSTANCE.a(this.scheme) ? this.port : -1);
        aVar.c().clear();
        aVar.c().addAll(e());
        aVar.b(f());
        aVar.h(b());
        return aVar;
    }

    public final List<String> k() {
        return this.pathSegments;
    }

    /* renamed from: l, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final String m() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        INSTANCE.b(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String n() {
        a b = b("/...");
        Intrinsics.checkNotNull(b);
        return b.m("").f("").a().getUrl();
    }

    /* renamed from: o, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    public final URI p() {
        String aVar = j().e().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(aVar, ""));
                Intrinsics.checkNotNullExpressionValue(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL q() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: toString, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    @JvmStatic
    public static final v a(String str) {
        return INSTANCE.b(str);
    }

    @JvmStatic
    public static final v c(String str) {
        return INSTANCE.c(str);
    }

    public final a b(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new a().a(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final v d(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        a b = b(link);
        if (b != null) {
            return b.a();
        }
        return null;
    }
}
