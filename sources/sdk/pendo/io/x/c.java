package sdk.pendo.io.x;

import java.util.Queue;
import sdk.pendo.io.i0.g;
import sdk.pendo.io.i0.k;

/* loaded from: classes4.dex */
public class c<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final g<b<A>, B> f1741a;

    class a extends g<b<A>, B> {
        a(long j) {
            super(j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sdk.pendo.io.i0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemEvicted(b<A> bVar, B b) {
            bVar.a();
        }
    }

    static final class b<A> {
        private static final Queue<b<?>> d = k.a(0);

        /* renamed from: a, reason: collision with root package name */
        private int f1743a;
        private int b;
        private A c;

        private b() {
        }

        static <A> b<A> a(A a2, int i, int i2) {
            b<A> bVar;
            Queue<b<?>> queue = d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a2, i, i2);
            return bVar;
        }

        private void b(A a2, int i, int i2) {
            this.c = a2;
            this.b = i;
            this.f1743a = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.f1743a == bVar.f1743a && this.c.equals(bVar.c);
        }

        public int hashCode() {
            return (((this.f1743a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public void a() {
            Queue<b<?>> queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public c(long j) {
        this.f1741a = new a(j);
    }

    public B a(A a2, int i, int i2) {
        b<A> a3 = b.a(a2, i, i2);
        B b2 = this.f1741a.get(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f1741a.put(b.a(a2, i, i2), b2);
    }
}
