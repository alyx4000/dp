package sdk.pendo.io.k8;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import com.iterable.iterableapi.IterableConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import sdk.pendo.io.g9.r;
import sdk.pendo.io.l8.b;
import sdk.pendo.io.l8.d;
import sdk.pendo.io.l8.e;
import sdk.pendo.io.utilities.AndroidUtils;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/k8/b;", "Lsdk/pendo/io/k8/a;", "Lorg/json/JSONObject;", "json", "", "b", "", "c", "[Lsdk/pendo/io/k8/a;", "mDeviceInfoCollectors", "e", "()Lorg/json/JSONObject;", IterableConstants.KEY_DEVICE_INFO, "<init>", "()V", "d", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b extends sdk.pendo.io.k8.a {

    /* renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String e = "device_info";
    private static final Lazy<b> f = LazyKt.lazy(a.f);

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.k8.a[] mDeviceInfoCollectors = {new sdk.pendo.io.l8.a(), new sdk.pendo.io.l8.c(), new d(), new e()};

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/k8/b;", "a", "()Lsdk/pendo/io/k8/b;"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function0<b> {
        public static final a f = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return c.f1294a.a();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/k8/b$b;", "", "", "DEVICE_INFO", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lsdk/pendo/io/k8/b;", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lsdk/pendo/io/k8/b;", "instance", "ERROR_STR", "NO_DEVICE_ID", "UUID_INFO", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.k8.b$b, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.e;
        }

        public final b b() {
            return (b) b.f.getValue();
        }
    }

    private final JSONObject e() {
        Resources resources;
        Configuration configuration;
        LocaleList locales;
        JSONObject jSONObject = new JSONObject();
        String g = AndroidUtils.g();
        if (g == null) {
            sdk.pendo.io.g9.d.a(new sdk.pendo.io.i8.b("Cannot get device id!"), "No Device Id");
            g = "ERROR";
        }
        b.Companion companion = sdk.pendo.io.l8.b.INSTANCE;
        r.a(jSONObject, companion.c(), g);
        r.a(jSONObject, companion.d(), "UUID");
        Context a2 = a();
        String languageTags = (a2 == null || (resources = a2.getResources()) == null || (configuration = resources.getConfiguration()) == null || (locales = configuration.getLocales()) == null) ? null : locales.toLanguageTags();
        if (languageTags != null) {
            r.a(jSONObject, companion.e(), languageTags);
        }
        for (sdk.pendo.io.k8.a aVar : this.mDeviceInfoCollectors) {
            aVar.a(jSONObject);
        }
        return jSONObject;
    }

    @Override // sdk.pendo.io.k8.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        r.a(json, e, e());
    }
}
