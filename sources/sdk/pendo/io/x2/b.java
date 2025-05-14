package sdk.pendo.io.x2;

import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.messaging.Constants;
import io.sentry.ProfilingTraceData;
import io.sentry.protocol.SentryThread;
import io.sentry.util.HttpUtils;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.time.TimeZones;
import sdk.pendo.io.e3.c;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.d;
import sdk.pendo.io.k3.f;
import sdk.pendo.io.k3.g;
import sdk.pendo.io.k3.r;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.r;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.x;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u001a\u0016\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u001a;\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b*\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0005\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00060\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\r¢\u0006\u0004\b\u0005\u0010\u0011\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\b\u001a-\u0010\u0005\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0014\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u0005\u0010\u0016\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b*\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0005\u0010\u0017\u001a\u001e\u0010\u0005\u001a\u00020\u0015*\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u001a\u001e\u0010\u000f\u001a\u00020\u0015*\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u001a\u001e\u0010\u001a\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u001a&\u0010\u0005\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u001a&\u0010\u0005\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u001a\n\u0010\u000f\u001a\u00020\u0015*\u00020\u0006\u001a\n\u0010\u0005\u001a\u00020\b*\u00020\u0006\u001a\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u001a)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u000b\"\u00020\u001f¢\u0006\u0004\b\u0005\u0010!\u001a\u0012\u0010\u0005\u001a\u00020#*\u00020\"2\u0006\u0010$\u001a\u00020#\u001a \u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010&\u001a\n\u0010\u0005\u001a\u00020\u0015*\u00020\u001c\u001a\u0010\u0010\u0005\u001a\u00020**\b\u0012\u0004\u0012\u00020)0(\u001a\u0010\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020)0(*\u00020*\u001a\u0012\u0010\u0005\u001a\u00020\b*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0012\u001a\n\u0010\u0005\u001a\u00020,*\u00020+\u001a\u0015\u0010\u0005\u001a\u00020\u0015*\u00020-2\u0006\u0010.\u001a\u00020\u0015H\u0086\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0015*\u00020/2\u0006\u0010.\u001a\u00020\u0015H\u0086\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u00020\u00152\u0006\u0010.\u001a\u00020\u0000H\u0086\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u0002002\u0006\u00101\u001a\u00020\u0015\u001a\n\u0010\u0005\u001a\u00020\u0015*\u00020\"\u001a\u001a\u0010\u000f\u001a\u00020\b*\u0002022\u0006\u0010%\u001a\u00020\u00152\u0006\u00103\u001a\u00020&\u001a\u001a\u0010\u0005\u001a\u00020\b*\u0002022\u0006\u00104\u001a\u00020\u00152\u0006\u00103\u001a\u00020&\u001a\u0012\u0010\u0005\u001a\u00020\b*\u0002052\u0006\u00106\u001a\u00020\"\u001a\u0012\u0010\u0005\u001a\u00020\u0015*\u0002072\u0006\u0010\u000f\u001a\u00020-\u001a\u0014\u0010\u0005\u001a\u00020\u0015*\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u001a\n\u0010\u0005\u001a\u00020\u0000*\u000208\u001a\u0012\u0010\u0005\u001a\u00020\u0000*\u00020\u00062\u0006\u00109\u001a\u00020\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0015*\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020\u0015\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000(\"\u0004\b\u0000\u0010:*\b\u0012\u0004\u0012\u00028\u00000(\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000(\"\u0004\b\u0000\u0010:2\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u0000H\u0007¢\u0006\u0004\b\u0005\u0010<\u001a.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010?\"\u0004\b\u0000\u0010=\"\u0004\b\u0001\u0010>*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010?\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020@\u001a\n\u0010\u0005\u001a\u00020\u0004*\u000205\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0015\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010A*\b\u0012\u0004\u0012\u00028\u00000B2\u0006\u0010C\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0005\u0010D\u001a \u0010\u0005\u001a\u00020H*\u00060Ej\u0002`F2\u0010\u0010G\u001a\f\u0012\b\u0012\u00060Ej\u0002`F0(\"\u0014\u0010K\u001a\u00020I8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010J\"\u0014\u0010M\u001a\u00020*8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010L\"\u0014\u0010P\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010O\"\u0014\u0010T\u001a\u00020Q8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010S\"\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010W\"\u0014\u0010\\\u001a\u00020Y8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010[\"\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_\"\u0014\u0010c\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\ba\u0010b\"\u0014\u0010f\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006g"}, d2 = {"", "arrayLength", "offset", "count", "", "a", "", "name", "", SentryThread.JsonKeys.DAEMON, "Ljava/util/concurrent/ThreadFactory;", "", "other", "Ljava/util/Comparator;", "comparator", "b", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lsdk/pendo/io/w2/v;", "includeDefaultPort", "value", "", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "c", "delimiters", "", "delimiter", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lsdk/pendo/io/k3/f;", "Ljava/nio/charset/Charset;", "default", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "", "Lsdk/pendo/io/e3/c;", "Lsdk/pendo/io/w2/u;", "Lsdk/pendo/io/w2/r;", "Lsdk/pendo/io/w2/r$c;", "", "mask", "", "Lsdk/pendo/io/k3/e;", Constants.ScionAnalytics.PARAM_MEDIUM, "Lsdk/pendo/io/k3/a0;", "timeUnit", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "Ljava/net/Socket;", "source", "Lsdk/pendo/io/k3/d;", "Lsdk/pendo/io/w2/d0;", "defaultValue", ExifInterface.GPS_DIRECTION_TRUE, "elements", "([Ljava/lang/Object;)Ljava/util/List;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ljava/io/Closeable;", ExifInterface.LONGITUDE_EAST, "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "", "[B", "EMPTY_BYTE_ARRAY", "Lsdk/pendo/io/w2/u;", "EMPTY_HEADERS", "Lsdk/pendo/io/w2/e0;", "Lsdk/pendo/io/w2/e0;", "EMPTY_RESPONSE", "Lsdk/pendo/io/w2/c0;", "d", "Lsdk/pendo/io/w2/c0;", "EMPTY_REQUEST", "Lsdk/pendo/io/k3/r;", "e", "Lsdk/pendo/io/k3/r;", "UNICODE_BOMS", "Ljava/util/TimeZone;", "f", "Ljava/util/TimeZone;", "UTC", "Lkotlin/text/Regex;", "g", "Lkotlin/text/Regex;", "VERIFY_AS_IP_ADDRESS", "h", "Z", "assertionsEnabled", ContextChain.TAG_INFRA, "Ljava/lang/String;", "okHttpName", "okhttp"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1746a;
    public static final u b = u.INSTANCE.a(new String[0]);
    public static final e0 c;
    public static final c0 d;
    private static final r e;
    public static final TimeZone f;
    private static final Regex g;
    public static final boolean h;
    public static final String i;

    static {
        byte[] bArr = new byte[0];
        f1746a = bArr;
        c = e0.Companion.a(e0.INSTANCE, bArr, null, 1, null);
        d = c0.Companion.a(c0.INSTANCE, bArr, (x) null, 0, 0, 7, (Object) null);
        r.Companion companion = r.INSTANCE;
        g.Companion companion2 = g.INSTANCE;
        e = companion.a(companion2.a("efbbbf"), companion2.a("feff"), companion2.a("fffe"), companion2.a("0000ffff"), companion2.a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone(TimeZones.GMT_ID);
        Intrinsics.checkNotNull(timeZone);
        f = timeZone;
        g = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        h = false;
        String name = z.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        i = StringsKt.removeSuffix(StringsKt.removePrefix(name, (CharSequence) "external.sdk.pendo.io.okhttp3."), (CharSequence) "Client");
    }

    public static final int a(byte b2, int i2) {
        return b2 & i2;
    }

    public static final int a(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (!('a' <= c2 && c2 < 'g')) {
            c3 = 'A';
            if (!('A' <= c2 && c2 < 'G')) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static final int a(short s, int i2) {
        return s & i2;
    }

    public static final long a(int i2, long j) {
        return i2 & j;
    }

    public static final <E> void a(List<E> list, E e2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.contains(e2)) {
            return;
        }
        list.add(e2);
    }

    public static final int b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final boolean c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.equals(name, "Authorization", true) || StringsKt.equals(name, HttpUtils.COOKIE_HEADER_NAME, true) || StringsKt.equals(name, "Proxy-Authorization", true) || StringsKt.equals(name, "Set-Cookie", true);
    }

    public static final int b(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i4 = i3 - 1;
        if (i2 <= i4) {
            while (true) {
                char charAt = str.charAt(i4);
                if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                    return i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4--;
            }
        }
        return i2;
    }

    public static final String c(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int a2 = a(str, i2, i3);
        String substring = str.substring(a2, b(str, a2, i3));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int b(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return b(str, i2, i3);
    }

    public static /* synthetic */ String c(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return c(str, i2, i3);
    }

    public static final String[] b(String[] strArr, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final r.c a(final sdk.pendo.io.w2.r rVar) {
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        return new r.c() { // from class: sdk.pendo.io.x2.b$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.w2.r.c
            public final sdk.pendo.io.w2.r a(e eVar) {
                sdk.pendo.io.w2.r a2;
                a2 = b.a(sdk.pendo.io.w2.r.this, eVar);
                return a2;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        if (r5 == Long.MAX_VALUE) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0073, code lost:
    
        r11.d().a(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007b, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        r11.d().a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (r5 != Long.MAX_VALUE) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean b(sdk.pendo.io.k3.a0 r11, int r12, java.util.concurrent.TimeUnit r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "timeUnit"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            long r0 = java.lang.System.nanoTime()
            sdk.pendo.io.k3.b0 r2 = r11.getTimeout()
            boolean r2 = r2.getHasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L27
            sdk.pendo.io.k3.b0 r2 = r11.getTimeout()
            long r5 = r2.c()
            long r5 = r5 - r0
            goto L28
        L27:
            r5 = r3
        L28:
            sdk.pendo.io.k3.b0 r2 = r11.getTimeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.a(r12)
            sdk.pendo.io.k3.d r12 = new sdk.pendo.io.k3.d     // Catch: java.lang.Throwable -> L54 java.io.InterruptedIOException -> L66
            r12.<init>()     // Catch: java.lang.Throwable -> L54 java.io.InterruptedIOException -> L66
        L3e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.c(r12, r7)     // Catch: java.lang.Throwable -> L54 java.io.InterruptedIOException -> L66
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L4e
            r12.m()     // Catch: java.lang.Throwable -> L54 java.io.InterruptedIOException -> L66
            goto L3e
        L4e:
            int r12 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r13 = 1
            if (r12 != 0) goto L73
            goto L6b
        L54:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            sdk.pendo.io.k3.b0 r11 = r11.getTimeout()
            if (r13 != 0) goto L61
            r11.a()
            goto L65
        L61:
            long r0 = r0 + r5
            r11.a(r0)
        L65:
            throw r12
        L66:
            int r12 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r13 = 0
            if (r12 != 0) goto L73
        L6b:
            sdk.pendo.io.k3.b0 r11 = r11.getTimeout()
            r11.a()
            goto L7b
        L73:
            sdk.pendo.io.k3.b0 r11 = r11.getTimeout()
            long r0 = r0 + r5
            r11.a(r0)
        L7b:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x2.b.b(sdk.pendo.io.k3.a0, int, java.util.concurrent.TimeUnit):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sdk.pendo.io.w2.r a(sdk.pendo.io.w2.r this_asFactory, e it) {
        Intrinsics.checkNotNullParameter(this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return this_asFactory;
    }

    public static final <T> List<T> b(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return g.matches(str);
    }

    public static final int b(String str, int i2) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    public static final boolean a(v vVar, v other) {
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(vVar.getHost(), other.getHost()) && vVar.getPort() == other.getPort() && Intrinsics.areEqual(vVar.getScheme(), other.getScheme());
    }

    public static final int a(String name, long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(name, "name");
        boolean z = true;
        if (!(j >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j);
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException((name + " too large.").toString());
        }
        if (millis == 0 && j > 0) {
            z = false;
        }
        if (z) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small.").toString());
    }

    public static final void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void a(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void a(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!Intrinsics.areEqual(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] a(String[] strArr, String value) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[ArraysKt.getLastIndex(strArr2)] = value;
        return strArr2;
    }

    public static final int a(String str, char c2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final int a(String str, String delimiters, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i2 < i3) {
            if (StringsKt.contains$default((CharSequence) delimiters, str.charAt(i2), false, 2, (Object) null)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int a(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return a(str, c2, i2, i3);
    }

    public static final boolean a(a0 a0Var, int i2, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(a0Var, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return b(a0Var, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String a(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final boolean a(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    Iterator it = ArrayIteratorKt.iterator(strArr2);
                    while (it.hasNext()) {
                        if (comparator.compare(str, (String) it.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long a(d0 d0Var) {
        Intrinsics.checkNotNullParameter(d0Var, "<this>");
        String a2 = d0Var.getHeaders().a(HttpRequest.HEADER_CONTENT_LENGTH);
        if (a2 != null) {
            return a(a2, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> a(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int a(String[] strArr, String value, Comparator<String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], value) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int a(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int a(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return a(str, i2, i3);
    }

    public static final int a(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt != ' ' && charAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static final boolean a(Socket socket, f source) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z = !source.i();
                socket.setSoTimeout(soTimeout);
                return z;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final Charset a(f fVar, Charset charset) {
        Charset charset2;
        String str;
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        int a2 = fVar.a(e);
        if (a2 == -1) {
            return charset;
        }
        if (a2 == 0) {
            charset2 = StandardCharsets.UTF_8;
            str = "UTF_8";
        } else if (a2 == 1) {
            charset2 = StandardCharsets.UTF_16BE;
            str = "UTF_16BE";
        } else {
            if (a2 != 2) {
                if (a2 == 3) {
                    return Charsets.INSTANCE.UTF32_BE();
                }
                if (a2 == 4) {
                    return Charsets.INSTANCE.UTF32_LE();
                }
                throw new AssertionError();
            }
            charset2 = StandardCharsets.UTF_16LE;
            str = "UTF_16LE";
        }
        Intrinsics.checkNotNullExpressionValue(charset2, str);
        return charset2;
    }

    public static final int a(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        return a(fVar.readByte(), 255) | (a(fVar.readByte(), 255) << 16) | (a(fVar.readByte(), 255) << 8);
    }

    public static final int a(d dVar, byte b2) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        int i2 = 0;
        while (!dVar.i() && dVar.h(0L) == b2) {
            i2++;
            dVar.readByte();
        }
        return i2;
    }

    public static final ThreadFactory a(final String name, final boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() { // from class: sdk.pendo.io.x2.b$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread a2;
                a2 = b.a(name, z, runnable);
                return a2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread a(String name, boolean z, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z);
        return thread;
    }

    public static final List<c> a(u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        IntRange until = RangesKt.until(0, uVar.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new c(uVar.a(nextInt), uVar.b(nextInt)));
        }
        return arrayList;
    }

    public static final u a(List<c> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        u.a aVar = new u.a();
        for (c cVar : list) {
            aVar.b(cVar.getName().o(), cVar.getValue().o());
        }
        return aVar.a();
    }

    public static final String a(int i2) {
        String hexString = Integer.toHexString(i2);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String a(long j) {
        String hexString = Long.toHexString(j);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String a(v vVar, boolean z) {
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        String host = StringsKt.contains$default((CharSequence) vVar.getHost(), (CharSequence) ":", false, 2, (Object) null) ? "[" + vVar.getHost() + ']' : vVar.getHost();
        return (z || vVar.getPort() != v.INSTANCE.a(vVar.getScheme())) ? host + ':' + vVar.getPort() : host;
    }

    public static /* synthetic */ String a(v vVar, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return a(vVar, z);
    }

    public static final <K, V> Map<K, V> a(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final long a(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final Throwable a(Exception exc, List<? extends Exception> suppressed) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(exc, it.next());
        }
        return exc;
    }

    public static final void a(sdk.pendo.io.k3.e eVar, int i2) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        eVar.writeByte((i2 >>> 16) & 255);
        eVar.writeByte((i2 >>> 8) & 255);
        eVar.writeByte(i2 & 255);
    }
}
