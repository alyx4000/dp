package sdk.pendo.io.q6;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public final class m {
    public static <T, U> boolean a(boolean z, boolean z2, o<?> oVar, boolean z3, sdk.pendo.io.g6.g<?> gVar, sdk.pendo.io.b6.b bVar, j<T, U> jVar) {
        if (jVar.c()) {
            gVar.clear();
            bVar.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            Throwable d = jVar.d();
            if (d != null) {
                oVar.onError(d);
            } else {
                oVar.onComplete();
            }
            return true;
        }
        Throwable d2 = jVar.d();
        if (d2 != null) {
            gVar.clear();
            if (bVar != null) {
                bVar.dispose();
            }
            oVar.onError(d2);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        oVar.onComplete();
        return true;
    }

    public static <T> boolean b(long j, sdk.pendo.io.w5.b<? super T> bVar, Queue<T> queue, AtomicLong atomicLong, sdk.pendo.io.d6.d dVar) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, d.a(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 != Long.MIN_VALUE) {
            return false;
        }
        a(j | Long.MIN_VALUE, bVar, queue, atomicLong, dVar);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r15.a(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void a(sdk.pendo.io.g6.f<T> r11, sdk.pendo.io.x5.o<? super U> r12, boolean r13, sdk.pendo.io.b6.b r14, sdk.pendo.io.q6.j<T, U> r15) {
        /*
            r0 = 1
            r1 = r0
        L2:
            boolean r2 = r15.b()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = a(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.b()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = r0
            goto L24
        L22:
            r4 = 0
            r10 = r4
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = a(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.a(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.a(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.q6.m.a(sdk.pendo.io.g6.f, sdk.pendo.io.x5.o, boolean, sdk.pendo.io.b6.b, sdk.pendo.io.q6.j):void");
    }

    static boolean a(sdk.pendo.io.d6.d dVar) {
        try {
            return dVar.getAsBoolean();
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            return true;
        }
    }

    public static <T> void a(sdk.pendo.io.w5.b<? super T> bVar, Queue<T> queue, AtomicLong atomicLong, sdk.pendo.io.d6.d dVar) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            bVar.onComplete();
            return;
        }
        if (a(atomicLong.get(), bVar, queue, atomicLong, dVar)) {
            return;
        }
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j2 = j | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        if (j != 0) {
            a(j2, bVar, queue, atomicLong, dVar);
        }
    }

    static <T> boolean a(long j, sdk.pendo.io.w5.b<? super T> bVar, Queue<T> queue, AtomicLong atomicLong, sdk.pendo.io.d6.d dVar) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (a(dVar)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    bVar.onComplete();
                    return true;
                }
                bVar.onNext(poll);
                j2++;
            } else {
                if (a(dVar)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    bVar.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }
}
