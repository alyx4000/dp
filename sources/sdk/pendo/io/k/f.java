package sdk.pendo.io.k;

import com.facebook.react.uimanager.ViewProps;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.d;
import sdk.pendo.io.b.e;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016R\u0018\u0010\u0011\u001a\u00020\u000e*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u00020\u000e*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0014\u001a\u00020\u000e*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/k/f;", "Lsdk/pendo/io/b/c;", "Ljava/util/Calendar;", ViewProps.START, "expiry", "Lsdk/pendo/io/k/f$a;", "a", "Ljava/security/cert/X509Certificate;", "leafCertificate", "", "", "Lsdk/pendo/io/b/d;", "sctResults", "Lsdk/pendo/io/b/e;", "", "c", "(Ljava/util/Calendar;)I", "year", "b", "month", "dayOfMonth", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class f implements sdk.pendo.io.b.c {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/k/f$a;", "", "", "a", "", "b", "", "toString", "hashCode", "other", "equals", "I", "getRoundedMonthDifference", "()I", "roundedMonthDifference", "Z", "getHasPartialMonth", "()Z", "hasPartialMonth", "<init>", "(IZ)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    private static final /* data */ class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int roundedMonthDifference;

        /* renamed from: b, reason: from kotlin metadata */
        private final boolean hasPartialMonth;

        public a(int i, boolean z) {
            this.roundedMonthDifference = i;
            this.hasPartialMonth = z;
        }

        /* renamed from: a, reason: from getter */
        public final int getRoundedMonthDifference() {
            return this.roundedMonthDifference;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasPartialMonth() {
            return this.hasPartialMonth;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return this.roundedMonthDifference == aVar.roundedMonthDifference && this.hasPartialMonth == aVar.hasPartialMonth;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Integer.hashCode(this.roundedMonthDifference) * 31;
            boolean z = this.hasPartialMonth;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "MonthDifference(roundedMonthDifference=" + this.roundedMonthDifference + ", hasPartialMonth=" + this.hasPartialMonth + ')';
        }
    }

    private final int a(Calendar calendar) {
        return calendar.get(5);
    }

    private final int b(Calendar calendar) {
        return calendar.get(2);
    }

    private final int c(Calendar calendar) {
        return calendar.get(1);
    }

    @Override // sdk.pendo.io.b.c
    public sdk.pendo.io.b.e a(X509Certificate leafCertificate, Map<String, ? extends sdk.pendo.io.b.d> sctResults) {
        Intrinsics.checkNotNullParameter(leafCertificate, "leafCertificate");
        Intrinsics.checkNotNullParameter(sctResults, "sctResults");
        Calendar before = Calendar.getInstance();
        before.setTime(leafCertificate.getNotBefore());
        Calendar after = Calendar.getInstance();
        after.setTime(leafCertificate.getNotAfter());
        Intrinsics.checkNotNullExpressionValue(before, "before");
        Intrinsics.checkNotNullExpressionValue(after, "after");
        a a2 = a(before, after);
        int roundedMonthDifference = a2.getRoundedMonthDifference();
        boolean hasPartialMonth = a2.getHasPartialMonth();
        int i = (roundedMonthDifference > 39 || (roundedMonthDifference == 39 && hasPartialMonth)) ? 5 : (roundedMonthDifference > 27 || (roundedMonthDifference == 27 && hasPartialMonth)) ? 4 : roundedMonthDifference >= 15 ? 3 : 2;
        int i2 = 0;
        if (!sctResults.isEmpty()) {
            Iterator<Map.Entry<String, ? extends sdk.pendo.io.b.d>> it = sctResults.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue() instanceof d.b) {
                    i2++;
                }
            }
        }
        return i2 < i ? new e.b.d(sctResults, i) : new e.c.C0087c(sctResults);
    }

    private final a a(Calendar start, Calendar expiry) {
        if (expiry.compareTo(start) < 0) {
            return new a(0, false);
        }
        return new a((((c(expiry) - c(start)) * 12) + (b(expiry) - b(start))) - (a(expiry) < a(start) ? 1 : 0), a(expiry) != a(start));
    }
}
