package sdk.pendo.io.y6;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import sdk.pendo.io.y6.c;
import sdk.pendo.io.y6.f;

/* loaded from: classes4.dex */
class o {
    private static final o c = d();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1850a;

    @Nullable
    private final Constructor<MethodHandles.Lookup> b;

    static final class a extends o {

        /* renamed from: sdk.pendo.io.y6.o$a$a, reason: collision with other inner class name */
        static final class ExecutorC0276a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            private final Handler f1851a = new Handler(Looper.getMainLooper());

            ExecutorC0276a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f1851a.post(runnable);
            }
        }

        a() {
            super(true);
        }

        @Override // sdk.pendo.io.y6.o
        public Executor a() {
            return new ExecutorC0276a();
        }

        @Override // sdk.pendo.io.y6.o
        @Nullable
        Object a(Method method, Class<?> cls, Object obj, Object... objArr) {
            return super.a(method, cls, obj, objArr);
        }
    }

    o(boolean z) {
        this.f1850a = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.b = constructor;
    }

    private static o d() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new o(true);
    }

    static o e() {
        return c;
    }

    List<? extends c.a> a(@Nullable Executor executor) {
        g gVar = new g(executor);
        return this.f1850a ? Arrays.asList(e.f1822a, gVar) : Collections.singletonList(gVar);
    }

    @Nullable
    Executor a() {
        return null;
    }

    List<? extends f.a> b() {
        return this.f1850a ? Collections.singletonList(m.f1831a) : Collections.emptyList();
    }

    int c() {
        return this.f1850a ? 1 : 0;
    }

    @Nullable
    Object a(Method method, Class<?> cls, Object obj, Object... objArr) {
        Constructor<MethodHandles.Lookup> constructor = this.b;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    boolean a(Method method) {
        return this.f1850a && method.isDefault();
    }
}
