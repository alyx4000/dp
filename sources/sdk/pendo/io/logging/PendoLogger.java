package sdk.pendo.io.logging;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import sdk.pendo.io.g9.e0;

/* loaded from: classes6.dex */
public final class PendoLogger {
    static final String ASSERT = "A";
    static final int CALL_STACK_INDEX = 7;
    static final String DEBUG = "D";
    static final String ERROR = "E";
    static final String INFO = "I";
    static final int MAX_LOG_LENGTH = 4000;
    private static final x[] TREE_ARRAY_EMPTY;
    static final String VERBOSE = "V";
    static final String WARNING = "W";
    private static volatile x[] sForestAsArray;
    static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
    private static final List<x> FOREST = new ArrayList();
    private static final x TREE_OF_SOULS = new n();

    class a extends sdk.pendo.io.s8.a {
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        a(String str, Object[] objArr) {
            this.f = str;
            this.s = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.e(this.f, this.s);
        }
    }

    class b extends sdk.pendo.io.s8.a {
        final /* synthetic */ Object[] A;
        final /* synthetic */ Throwable f;
        final /* synthetic */ String s;

        b(Throwable th, String str, Object[] objArr) {
            this.f = th;
            this.s = str;
            this.A = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.e(this.f, this.s, this.A);
        }
    }

    class c extends sdk.pendo.io.s8.a {
        final /* synthetic */ Throwable f;

        c(Throwable th) {
            this.f = th;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.f(this.f);
        }
    }

    class d extends sdk.pendo.io.s8.a {
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        d(String str, Object[] objArr) {
            this.f = str;
            this.s = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.b(this.f, this.s);
        }
    }

    class e extends sdk.pendo.io.s8.a {
        final /* synthetic */ Object[] A;
        final /* synthetic */ Throwable f;
        final /* synthetic */ String s;

        e(Throwable th, String str, Object[] objArr) {
            this.f = th;
            this.s = str;
            this.A = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.b(this.f, this.s, this.A);
        }
    }

    class f extends sdk.pendo.io.s8.a {
        final /* synthetic */ Throwable f;

        f(Throwable th) {
            this.f = th;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.b(this.f);
        }
    }

    class g extends sdk.pendo.io.s8.a {
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        g(String str, Object[] objArr) {
            this.f = str;
            this.s = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.f(this.f, this.s);
        }
    }

    class h extends sdk.pendo.io.s8.a {
        final /* synthetic */ Object[] A;
        final /* synthetic */ Throwable f;
        final /* synthetic */ String s;

        h(Throwable th, String str, Object[] objArr) {
            this.f = th;
            this.s = str;
            this.A = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.f(this.f, this.s, this.A);
        }
    }

    class i extends sdk.pendo.io.s8.a {
        final /* synthetic */ Throwable f;

        i(Throwable th) {
            this.f = th;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.g(this.f);
        }
    }

    class j extends sdk.pendo.io.s8.a {
        final /* synthetic */ Object[] A;
        final /* synthetic */ int f;
        final /* synthetic */ String s;

        j(int i, String str, Object[] objArr) {
            this.f = i;
            this.s = str;
            this.A = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.a(this.f, this.s, this.A);
        }
    }

    class k extends sdk.pendo.io.s8.a {
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        k(String str, Object[] objArr) {
            this.f = str;
            this.s = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.d(this.f, this.s);
        }
    }

    class l extends sdk.pendo.io.s8.a {
        final /* synthetic */ String A;
        final /* synthetic */ int f;
        final /* synthetic */ Object[] f0;
        final /* synthetic */ Throwable s;

        l(int i, Throwable th, String str, Object[] objArr) {
            this.f = i;
            this.s = th;
            this.A = str;
            this.f0 = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.a(this.f, this.s, this.A, this.f0);
        }
    }

    class m extends sdk.pendo.io.s8.a {
        final /* synthetic */ int f;
        final /* synthetic */ Throwable s;

        m(int i, Throwable th) {
            this.f = i;
            this.s = th;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.a(this.f, this.s);
        }
    }

    class n extends x {
        n() {
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void a(String str, Object... objArr) {
            a(PendoLogger.DEBUG, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void b(String str, Object... objArr) {
            a("E", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void c(String str, Object... objArr) {
            a(PendoLogger.INFO, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void d(Throwable th) {
            a(PendoLogger.INFO, th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void e(Throwable th) {
            a("V", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void f(Throwable th) {
            a("W", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void g(Throwable th) {
            a("A", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void a(Throwable th) {
            a(PendoLogger.DEBUG, th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void b(Throwable th) {
            a("E", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void c(Throwable th, String str, Object... objArr) {
            a(PendoLogger.INFO, th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void d(String str, Object... objArr) {
            a("V", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void e(String str, Object... objArr) {
            a("W", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void f(String str, Object... objArr) {
            a("A", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void a(Throwable th, String str, Object... objArr) {
            a(PendoLogger.DEBUG, th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void b(Throwable th, String str, Object... objArr) {
            a("E", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void d(Throwable th, String str, Object... objArr) {
            a("V", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void e(Throwable th, String str, Object... objArr) {
            a("W", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void f(Throwable th, String str, Object... objArr) {
            a("A", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        protected void a(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void a(int i, String str, Object... objArr) {
            try {
                a(PendoLogger.logLevelIntToString(i), str, objArr);
            } catch (Exception unused) {
            }
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void a(int i, Throwable th) {
            try {
                a(PendoLogger.logLevelIntToString(i), th);
            } catch (Exception unused) {
            }
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        public void a(int i, Throwable th, String str, Object... objArr) {
            try {
                a(PendoLogger.logLevelIntToString(i), th, str, objArr);
            } catch (Exception unused) {
            }
        }

        private void a(String str, String str2, Object... objArr) {
            x[] xVarArr = PendoLogger.sForestAsArray;
            int length = xVarArr.length;
            for (int i = 0; i < length; i++) {
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "A":
                        xVarArr[i].f(str2, objArr);
                        break;
                    case "D":
                        xVarArr[i].a(str2, objArr);
                        break;
                    case "E":
                        xVarArr[i].b(str2, objArr);
                        break;
                    case "I":
                        xVarArr[i].c(str2, objArr);
                        break;
                    case "V":
                        xVarArr[i].d(str2, objArr);
                        break;
                    case "W":
                        xVarArr[i].e(str2, objArr);
                        break;
                }
            }
        }

        private void a(String str, Throwable th) {
            x[] xVarArr = PendoLogger.sForestAsArray;
            int length = xVarArr.length;
            for (int i = 0; i < length; i++) {
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "A":
                        xVarArr[i].g(th);
                        break;
                    case "D":
                        xVarArr[i].a(th);
                        break;
                    case "E":
                        xVarArr[i].b(th);
                        break;
                    case "I":
                        xVarArr[i].d(th);
                        break;
                    case "V":
                        xVarArr[i].e(th);
                        break;
                    case "W":
                        xVarArr[i].f(th);
                        break;
                }
            }
        }

        private void a(String str, Throwable th, String str2, Object... objArr) {
            x[] xVarArr = PendoLogger.sForestAsArray;
            int length = xVarArr.length;
            for (int i = 0; i < length; i++) {
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "A":
                        xVarArr[i].f(th, str2, objArr);
                        break;
                    case "D":
                        xVarArr[i].a(th, str2, objArr);
                        break;
                    case "E":
                        xVarArr[i].b(th, str2, objArr);
                        break;
                    case "I":
                        xVarArr[i].c(th, str2, objArr);
                        break;
                    case "V":
                        xVarArr[i].d(th, str2, objArr);
                        break;
                    case "W":
                        xVarArr[i].e(th, str2, objArr);
                        break;
                }
            }
        }
    }

    class o extends sdk.pendo.io.s8.a {
        final /* synthetic */ Object[] A;
        final /* synthetic */ Throwable f;
        final /* synthetic */ String s;

        o(Throwable th, String str, Object[] objArr) {
            this.f = th;
            this.s = str;
            this.A = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.d(this.f, this.s, this.A);
        }
    }

    class p extends sdk.pendo.io.s8.a {
        final /* synthetic */ Throwable f;

        p(Throwable th) {
            this.f = th;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.e(this.f);
        }
    }

    class q extends sdk.pendo.io.s8.a {
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        q(String str, Object[] objArr) {
            this.f = str;
            this.s = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.a(this.f, this.s);
        }
    }

    class r extends sdk.pendo.io.s8.a {
        final /* synthetic */ Object[] A;
        final /* synthetic */ Throwable f;
        final /* synthetic */ String s;

        r(Throwable th, String str, Object[] objArr) {
            this.f = th;
            this.s = str;
            this.A = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.a(this.f, this.s, this.A);
        }
    }

    class s extends sdk.pendo.io.s8.a {
        final /* synthetic */ Throwable f;

        s(Throwable th) {
            this.f = th;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.a(this.f);
        }
    }

    class t extends sdk.pendo.io.s8.a {
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        t(String str, Object[] objArr) {
            this.f = str;
            this.s = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.c(this.f, this.s);
        }
    }

    class u extends sdk.pendo.io.s8.a {
        final /* synthetic */ Object[] A;
        final /* synthetic */ Throwable f;
        final /* synthetic */ String s;

        u(Throwable th, String str, Object[] objArr) {
            this.f = th;
            this.s = str;
            this.A = objArr;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.c(this.f, this.s, this.A);
        }
    }

    class v extends sdk.pendo.io.s8.a {
        final /* synthetic */ Throwable f;

        v(Throwable th) {
            this.f = th;
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            PendoLogger.TREE_OF_SOULS.d(this.f);
        }
    }

    public static class w extends x {
        @Override // sdk.pendo.io.logging.PendoLogger.x
        final String a() {
            String a2 = super.a();
            if (a2 != null) {
                return a2;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 7) {
                return a(stackTrace[7]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        protected String a(StackTraceElement stackTraceElement) {
            throw null;
        }

        @Override // sdk.pendo.io.logging.PendoLogger.x
        protected void a(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() < 4000) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int indexOf = str2.indexOf(10, i2);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i2 + 4000);
                    String substring = str2.substring(i2, min);
                    if (i == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i, str, substring);
                    }
                    if (min >= indexOf) {
                        break;
                    } else {
                        i2 = min;
                    }
                }
                i2 = min + 1;
            }
        }
    }

    public static abstract class x {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadLocal<String> f1346a = new ThreadLocal<>();

        private String c(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        protected abstract void a(int i, String str, String str2, Throwable th);

        public void a(String str, Object... objArr) {
            b(3, null, str, objArr);
        }

        protected boolean a(int i) {
            return true;
        }

        public void b(String str, Object... objArr) {
            b(6, null, str, objArr);
        }

        public void d(Throwable th) {
            b(4, th, null, new Object[0]);
        }

        public void e(Throwable th) {
            b(2, th, null, new Object[0]);
        }

        public void f(Throwable th) {
            b(5, th, null, new Object[0]);
        }

        public void g(Throwable th) {
            b(7, th, null, new Object[0]);
        }

        public void a(Throwable th) {
            b(3, th, null, new Object[0]);
        }

        public void b(Throwable th) {
            b(6, th, null, new Object[0]);
        }

        public void c(String str, Object... objArr) {
            b(4, null, str, objArr);
        }

        public void d(String str, Object... objArr) {
            b(2, null, str, objArr);
        }

        public void e(String str, Object... objArr) {
            b(5, null, str, objArr);
        }

        public void f(String str, Object... objArr) {
            b(7, null, str, objArr);
        }

        public void a(Throwable th, String str, Object... objArr) {
            b(3, th, str, objArr);
        }

        public void b(Throwable th, String str, Object... objArr) {
            b(6, th, str, objArr);
        }

        public void c(Throwable th, String str, Object... objArr) {
            b(4, th, str, objArr);
        }

        public void d(Throwable th, String str, Object... objArr) {
            b(2, th, str, objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            b(5, th, str, objArr);
        }

        public void f(Throwable th, String str, Object... objArr) {
            b(7, th, str, objArr);
        }

        private void b(int i, Throwable th, String str, Object... objArr) {
            String a2 = a();
            if (a(i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr.length > 0) {
                        if (!str.contains("%s")) {
                            str = str + " %s";
                        }
                        str = String.format(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + c(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = c(th);
                }
                a(i, a2, str, th);
            }
        }

        String a() {
            String str = this.f1346a.get();
            if (str != null) {
                this.f1346a.remove();
            }
            return str;
        }

        public void a(int i, String str, Object... objArr) {
            b(i, null, str, objArr);
        }

        public void a(int i, Throwable th) {
            b(i, th, null, new Object[0]);
        }

        public void a(int i, Throwable th, String str, Object... objArr) {
            b(i, th, str, objArr);
        }
    }

    static {
        x[] xVarArr = new x[0];
        TREE_ARRAY_EMPTY = xVarArr;
        sForestAsArray = xVarArr;
    }

    private PendoLogger() {
        throw new AssertionError("No instances.");
    }

    public static x asTree() {
        return TREE_OF_SOULS;
    }

    public static void d(String str, Object... objArr) {
        e0.a(new q(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        e0.a(new d(str, objArr));
    }

    public static List<x> forest() {
        List<x> unmodifiableList;
        List<x> list = FOREST;
        synchronized (list) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return unmodifiableList;
    }

    public static void i(String str, Object... objArr) {
        e0.a(new t(str, objArr));
    }

    public static void log(int i2, String str, Object... objArr) {
        e0.a(new j(i2, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String logLevelIntToString(int i2) {
        switch (i2) {
            case 2:
                return "V";
            case 3:
                return DEBUG;
            case 4:
                return INFO;
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                throw new IllegalArgumentException("Level: " + i2 + " is not supported");
        }
    }

    public static void plant(x xVar) {
        if (xVar == null) {
            throw new NullPointerException("tree == null");
        }
        if (xVar == TREE_OF_SOULS) {
            throw new IllegalArgumentException("Cannot plant PendoLogger into itself.");
        }
        List<x> list = FOREST;
        synchronized (list) {
            list.add(xVar);
            sForestAsArray = (x[]) list.toArray(new x[list.size()]);
        }
    }

    public static x tag(String str) {
        for (x xVar : sForestAsArray) {
            xVar.f1346a.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static int treeCount() {
        int size;
        List<x> list = FOREST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    public static void uproot(x xVar) {
        List<x> list = FOREST;
        synchronized (list) {
            if (!list.remove(xVar)) {
                throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + xVar);
            }
            sForestAsArray = (x[]) list.toArray(new x[list.size()]);
        }
    }

    public static void uprootAll() {
        List<x> list = FOREST;
        synchronized (list) {
            list.clear();
            sForestAsArray = TREE_ARRAY_EMPTY;
        }
    }

    public static void v(String str, Object... objArr) {
        e0.a(new k(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        e0.a(new a(str, objArr));
    }

    public static void wtf(String str, Object... objArr) {
        e0.a(new g(str, objArr));
    }

    public static void d(Throwable th) {
        e0.a(new s(th));
    }

    public static void e(Throwable th) {
        e0.a(new f(th));
    }

    public static void i(Throwable th) {
        e0.a(new v(th));
    }

    public static void log(int i2, Throwable th) {
        e0.a(new m(i2, th));
    }

    public static void plant(x... xVarArr) {
        if (xVarArr == null) {
            throw new NullPointerException("trees == null");
        }
        for (x xVar : xVarArr) {
            if (xVar == null) {
                throw new NullPointerException("trees contains null");
            }
            if (xVar == TREE_OF_SOULS) {
                throw new IllegalArgumentException("Cannot plant PendoLogger into itself.");
            }
        }
        List<x> list = FOREST;
        synchronized (list) {
            Collections.addAll(list, xVarArr);
            sForestAsArray = (x[]) list.toArray(new x[list.size()]);
        }
    }

    public static void v(Throwable th) {
        e0.a(new p(th));
    }

    public static void w(Throwable th) {
        e0.a(new c(th));
    }

    public static void wtf(Throwable th) {
        e0.a(new i(th));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        e0.a(new r(th, str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        e0.a(new e(th, str, objArr));
    }

    public static void i(Throwable th, String str, Object... objArr) {
        e0.a(new u(th, str, objArr));
    }

    public static void log(int i2, Throwable th, String str, Object... objArr) {
        e0.a(new l(i2, th, str, objArr));
    }

    public static void v(Throwable th, String str, Object... objArr) {
        e0.a(new o(th, str, objArr));
    }

    public static void w(Throwable th, String str, Object... objArr) {
        e0.a(new b(th, str, objArr));
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        e0.a(new h(th, str, objArr));
    }
}
