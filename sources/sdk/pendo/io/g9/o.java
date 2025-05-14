package sdk.pendo.io.g9;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.JWTSessionData;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0007R\u001b\u0010\u000b\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\b\u0010\u000f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/g9/o;", "Lsdk/pendo/io/g8/a;", "", "jwtToken", "signingKeyName", "", "expectedType", "Lsdk/pendo/io/models/JWTSessionData;", "a", "", "Landroid/content/Context;", "context", "decodedBodyString", "s", "Lkotlin/Lazy;", "()Landroid/content/Context;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class o extends sdk.pendo.io.g8.a {
    public static final o f;

    /* renamed from: s, reason: from kotlin metadata */
    private static final Lazy context;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class a extends Lambda implements Function0<Context> {
        final /* synthetic */ Function0 A;
        final /* synthetic */ sdk.pendo.io.i5.a f;
        final /* synthetic */ sdk.pendo.io.q5.a s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sdk.pendo.io.i5.a aVar, sdk.pendo.io.q5.a aVar2, Function0 function0) {
            super(0);
            this.f = aVar;
            this.s = aVar2;
            this.A = function0;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            sdk.pendo.io.i5.a aVar = this.f;
            return (aVar instanceof sdk.pendo.io.i5.b ? ((sdk.pendo.io.i5.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(Context.class), this.s, this.A);
        }
    }

    static {
        o oVar = new o();
        f = oVar;
        context = LazyKt.lazy(sdk.pendo.io.v5.b.f1684a.a(), (Function0) new a(oVar, null, null));
    }

    private o() {
    }

    public final byte[] a(String jwtToken) {
        List emptyList;
        Intrinsics.checkNotNullParameter(jwtToken, "jwtToken");
        List<String> split = new Regex("\\.").split(jwtToken, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt.emptyList();
        String[] strArr = (String[]) emptyList.toArray(new String[0]);
        if (strArr.length != 3) {
            return null;
        }
        return sdk.pendo.io.u0.a.a(strArr[1]);
    }

    public final String a(Context context2, int expectedType, String decodedBodyString) {
        String string;
        StringBuilder sb;
        StringBuilder append;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(decodedBodyString, "decodedBodyString");
        String string2 = context2.getString(R.string.pnd_error_jwt_body_format, decodedBodyString);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (expectedType == 1) {
            string = context2.getString(R.string.pnd_expected_jwt_visitor_format);
            sb = new StringBuilder();
        } else {
            if (expectedType != 2) {
                if (expectedType != 3) {
                    return "Invalid expected type";
                }
                String str = string2 + context2.getString(R.string.pnd_expected_jwt_account_format);
                string = context2.getString(R.string.pnd_expected_jwt_visitor_format);
                append = new StringBuilder().append(str);
                return append.append(string).toString();
            }
            string = context2.getString(R.string.pnd_expected_jwt_account_format);
            sb = new StringBuilder();
        }
        append = sb.append(string2);
        return append.append(string).toString();
    }

    public final synchronized JWTSessionData a(String jwtToken, String signingKeyName, int expectedType) {
        int i;
        Intrinsics.checkNotNullParameter(jwtToken, "jwtToken");
        Intrinsics.checkNotNullParameter(signingKeyName, "signingKeyName");
        byte[] a2 = a(jwtToken);
        if (a2 == null) {
            return null;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(a2, UTF_8);
        PendoLogger.d("Decoded: ".concat(str), new Object[0]);
        try {
            JWTSessionData jWTSessionData = (JWTSessionData) new external.sdk.pendo.io.gson.a().c().a().a(str, JWTSessionData.class);
            Map<String, Object> accountData = jWTSessionData.getAccountData();
            if (accountData != null) {
                Object remove = accountData.remove("id");
                Intrinsics.checkNotNull(remove, "null cannot be cast to non-null type kotlin.String");
                jWTSessionData.setAccountId((String) remove);
                i = 2;
            } else {
                i = 0;
            }
            Map<String, Object> visitorData = jWTSessionData.getVisitorData();
            if (visitorData != null) {
                Object remove2 = visitorData.remove("id");
                Intrinsics.checkNotNull(remove2, "null cannot be cast to non-null type kotlin.String");
                jWTSessionData.setVisitorId((String) remove2);
                i++;
            }
            if (i != expectedType) {
                o oVar = f;
                throw new sdk.pendo.io.i8.h(oVar.a(oVar.a(), expectedType, str));
            }
            jWTSessionData.setJwt(jwtToken);
            jWTSessionData.setSigningKeyName(signingKeyName);
            return jWTSessionData;
        } catch (Exception e) {
            PendoLogger.e(e, "JWT extract error {" + e + ".message}", new Object[0]);
            return null;
        }
    }

    public final Context a() {
        return (Context) context.getValue();
    }
}
