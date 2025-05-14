package sdk.pendo.io.t2;

import java.util.Objects;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f1548a;
    private c b;
    private EnumC0236b c;
    private long d;
    private long e;
    private long f;
    private long g;

    /* renamed from: sdk.pendo.io.t2.b$b, reason: collision with other inner class name */
    private enum EnumC0236b {
        SPLIT,
        UNSPLIT
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class c {
        private static final /* synthetic */ c[] $VALUES;
        public static final c RUNNING;
        public static final c STOPPED;
        public static final c SUSPENDED;
        public static final c UNSTARTED;

        enum a extends c {
            a(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean a() {
                return true;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean b() {
                return false;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean c() {
                return false;
            }
        }

        /* renamed from: sdk.pendo.io.t2.b$c$b, reason: collision with other inner class name */
        enum C0237b extends c {
            C0237b(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean a() {
                return false;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean b() {
                return true;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean c() {
                return false;
            }
        }

        /* renamed from: sdk.pendo.io.t2.b$c$c, reason: collision with other inner class name */
        enum C0238c extends c {
            C0238c(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean a() {
                return true;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean b() {
                return false;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean c() {
                return true;
            }
        }

        enum d extends c {
            d(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean a() {
                return false;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean b() {
                return true;
            }

            @Override // sdk.pendo.io.t2.b.c
            boolean c() {
                return false;
            }
        }

        static {
            a aVar = new a(DebugCoroutineInfoImplKt.RUNNING, 0);
            RUNNING = aVar;
            C0237b c0237b = new C0237b("STOPPED", 1);
            STOPPED = c0237b;
            C0238c c0238c = new C0238c(DebugCoroutineInfoImplKt.SUSPENDED, 2);
            SUSPENDED = c0238c;
            d dVar = new d("UNSTARTED", 3);
            UNSTARTED = dVar;
            $VALUES = new c[]{aVar, c0237b, c0238c, dVar};
        }

        private c(String str, int i) {
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) $VALUES.clone();
        }

        abstract boolean a();

        abstract boolean b();

        abstract boolean c();
    }

    public b() {
        this(null);
    }

    public String a() {
        return sdk.pendo.io.t2.a.a(c());
    }

    public long b() {
        long j;
        c cVar = this.b;
        if (cVar == c.STOPPED || cVar == c.SUSPENDED) {
            j = this.g;
        } else {
            if (cVar == c.UNSTARTED) {
                return 0L;
            }
            if (cVar != c.RUNNING) {
                throw new IllegalStateException("Illegal running state has occurred.");
            }
            j = System.nanoTime();
        }
        return j - this.d;
    }

    public long c() {
        return b() / 1000000;
    }

    public boolean d() {
        return this.b.a();
    }

    public boolean e() {
        return this.b.b();
    }

    public boolean f() {
        return this.b.c();
    }

    public void g() {
        this.b = c.UNSTARTED;
        this.c = EnumC0236b.UNSPLIT;
    }

    public void h() {
        c cVar = this.b;
        if (cVar == c.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
        if (cVar != c.UNSTARTED) {
            throw new IllegalStateException("Stopwatch already started. ");
        }
        this.d = System.nanoTime();
        this.e = System.currentTimeMillis();
        this.b = c.RUNNING;
    }

    public void i() {
        c cVar = this.b;
        c cVar2 = c.RUNNING;
        if (cVar != cVar2 && cVar != c.SUSPENDED) {
            throw new IllegalStateException("Stopwatch is not running. ");
        }
        if (cVar == cVar2) {
            this.g = System.nanoTime();
            this.f = System.currentTimeMillis();
        }
        this.b = c.STOPPED;
    }

    public String toString() {
        String objects = Objects.toString(this.f1548a, "");
        String a2 = a();
        return objects.isEmpty() ? a2 : objects + " " + a2;
    }

    public b(String str) {
        this.b = c.UNSTARTED;
        this.c = EnumC0236b.UNSPLIT;
        this.f1548a = str;
    }
}
