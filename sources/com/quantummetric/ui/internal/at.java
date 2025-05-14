package com.quantummetric.ui.internal;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
final class at {

    /* renamed from: a, reason: collision with root package name */
    bz f68a;
    Map<Integer, Long> b = new ConcurrentHashMap();
    l c = new l();
    private int e = 0;
    int d = 0;

    at(bz bzVar) {
        this.f68a = bzVar;
    }

    final synchronized void a(final Bitmap bitmap, int i, final boolean z, h<Long> hVar) {
        boolean z2 = true;
        this.e++;
        final int generationId = bitmap != null ? bitmap.getGenerationId() : 0;
        final int i2 = (i != 0 || bitmap == null) ? i : generationId;
        Long l = i2 != 0 ? this.b.get(Integer.valueOf(i2)) : null;
        if (l == null && z) {
            l = this.b.get(Integer.valueOf(generationId));
        }
        if (l == null && i2 != 0) {
            CopyOnWriteArrayList<h<Long>> copyOnWriteArrayList = this.c.get(Integer.valueOf(i2));
            if (copyOnWriteArrayList != null) {
                Iterator<h<Long>> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(hVar)) {
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                CopyOnWriteArrayList<h<Long>> copyOnWriteArrayList2 = this.c.get(Integer.valueOf(i2));
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(hVar);
                    return;
                }
                CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
                this.c.put(Integer.valueOf(i2), copyOnWriteArrayList3);
                copyOnWriteArrayList3.add(hVar);
                cl.a(new Runnable() { // from class: com.quantummetric.instrument.internal.at.1
                    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
                    
                        if (r0.a(r1) != false) goto L19;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
                    /* JADX WARN: Removed duplicated region for block: B:23:0x00ca  */
                    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void run() {
                        /*
                            r8 = this;
                            com.quantummetric.instrument.internal.at r0 = com.quantummetric.ui.internal.at.this
                            int r1 = r0.d
                            r2 = 1
                            int r1 = r1 + r2
                            r0.d = r1
                            com.quantummetric.instrument.internal.at r0 = com.quantummetric.ui.internal.at.this
                            com.quantummetric.instrument.internal.bz r0 = r0.f68a
                            android.graphics.Bitmap r1 = r2
                            java.lang.System.currentTimeMillis()
                            r3 = 0
                            if (r1 == 0) goto L89
                            boolean r5 = r1.isRecycled()
                            if (r5 == 0) goto L1c
                            goto L89
                        L1c:
                            int r5 = r1.getWidth()
                            int r6 = r0.i
                            r7 = 0
                            if (r5 <= r6) goto L61
                            int r5 = r1.getHeight()
                            int r6 = r0.i
                            if (r5 <= r6) goto L61
                            int r5 = r0.i
                            int r6 = r0.i
                            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r5, r6, r7)
                            boolean r0 = r0.a(r1)
                            if (r0 == 0) goto L3c
                            goto L89
                        L3c:
                            android.graphics.ColorMatrix r0 = new android.graphics.ColorMatrix
                            r0.<init>()
                            r5 = 0
                            r0.setSaturation(r5)
                            android.graphics.ColorMatrixColorFilter r6 = new android.graphics.ColorMatrixColorFilter
                            r6.<init>(r0)
                            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
                            android.graphics.Bitmap r1 = r1.copy(r0, r2)
                            android.graphics.Paint r0 = new android.graphics.Paint
                            r0.<init>()
                            r0.setColorFilter(r6)
                            android.graphics.Canvas r2 = new android.graphics.Canvas
                            r2.<init>(r1)
                            r2.drawBitmap(r1, r5, r5, r0)
                            goto L68
                        L61:
                            boolean r0 = r0.a(r1)
                            if (r0 == 0) goto L68
                            goto L89
                        L68:
                            int r0 = r1.getAllocationByteCount()
                            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
                            r1.copyPixelsToBuffer(r0)
                            byte[] r0 = r0.array()
                            com.quantummetric.instrument.internal.bj r1 = new com.quantummetric.instrument.internal.bj
                            r1.<init>()
                            int r2 = r0.length
                            r1.update(r0, r7, r2)
                            long r0 = r1.getValue()
                            long r0 = java.lang.Math.abs(r0)
                            goto L8a
                        L89:
                            r0 = r3
                        L8a:
                            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                            if (r2 == 0) goto L9f
                            com.quantummetric.instrument.internal.at r2 = com.quantummetric.ui.internal.at.this
                            java.util.Map<java.lang.Integer, java.lang.Long> r2 = r2.b
                            int r3 = r3
                            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                            java.lang.Long r4 = java.lang.Long.valueOf(r0)
                            r2.put(r3, r4)
                        L9f:
                            boolean r2 = r4
                            if (r2 == 0) goto Lb8
                            int r2 = r5
                            if (r2 <= 0) goto Lb8
                            com.quantummetric.instrument.internal.at r2 = com.quantummetric.ui.internal.at.this
                            java.util.Map<java.lang.Integer, java.lang.Long> r2 = r2.b
                            int r3 = r5
                            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                            java.lang.Long r4 = java.lang.Long.valueOf(r0)
                            r2.put(r3, r4)
                        Lb8:
                            com.quantummetric.instrument.internal.at r2 = com.quantummetric.ui.internal.at.this
                            int r3 = r3
                            com.quantummetric.instrument.internal.l r4 = r2.c
                            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
                            java.lang.Object r4 = r4.get(r5)
                            java.util.concurrent.CopyOnWriteArrayList r4 = (java.util.concurrent.CopyOnWriteArrayList) r4
                            if (r4 == 0) goto Leb
                            java.util.Iterator r4 = r4.iterator()
                        Lce:
                            boolean r5 = r4.hasNext()
                            if (r5 == 0) goto Le2
                            java.lang.Object r5 = r4.next()
                            com.quantummetric.instrument.internal.h r5 = (com.quantummetric.ui.internal.h) r5
                            java.lang.Long r6 = java.lang.Long.valueOf(r0)
                            r5.a(r6)
                            goto Lce
                        Le2:
                            com.quantummetric.instrument.internal.l r0 = r2.c
                            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
                            r0.remove(r1)
                        Leb:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.at.AnonymousClass1.run():void");
                    }
                });
                return;
            }
        }
        hVar.a(l);
    }
}
