package io.castle.highwind.android;

import android.content.Context;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.regex.Matcher;
import kotlin.Pair;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.Mutex;

/* loaded from: classes2.dex */
public final class p extends z {
    public final e b;
    public final g c;

    public p(Context context, String str) {
        super(str);
        this.b = new e(context);
        this.c = new g(context);
    }

    @Override // io.castle.highwind.android.z
    public final y a() {
        String group;
        ArrayList arrayList = new ArrayList();
        this.c.getClass();
        a(arrayList, new x(0, String.valueOf((int) ((SystemClock.elapsedRealtime() / 1000) / 60)), 5));
        g gVar = this.c;
        if (Mutex.DefaultImpls.tryLock$default(gVar.e, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new j(gVar, null), 2, null);
        }
        Pair<? extends Long, ? extends Long> pair = gVar.d;
        a(arrayList, new x(1, pair != null ? Long.valueOf(pair.getSecond().longValue() / DurationKt.NANOS_IN_MILLIS).toString() : null, 5));
        Pair<? extends Long, ? extends Long> pair2 = this.c.d;
        a(arrayList, new x(2, pair2 != null ? String.valueOf(pair2.getFirst().longValue() / DurationKt.NANOS_IN_MILLIS) : null, 5));
        e eVar = this.b;
        Matcher matcher = eVar.c.matcher(eVar.a("/proc/meminfo"));
        a(arrayList, new x(3, (!matcher.find() || (group = matcher.group(1)) == null) ? "0" : String.valueOf(Integer.parseInt(group) / 1024), 5));
        int i = this.b.f768a.getResources().getConfiguration().orientation;
        a(arrayList, new x(4, Integer.valueOf(i != 1 ? i != 2 ? 0 : 4 : 1), 4));
        return a((String[]) arrayList.toArray(new String[0]));
    }
}
