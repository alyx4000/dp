package com.quantummetric.ui.internal;

/* loaded from: classes5.dex */
final class bp {

    /* renamed from: a, reason: collision with root package name */
    bz f126a;
    boolean e;
    private dc f;
    int b = 0;
    int c = 0;
    boolean d = false;
    private boolean g = false;

    /* renamed from: com.quantummetric.instrument.internal.bp$2, reason: invalid class name */
    final class AnonymousClass2 implements h<String> {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ h f128a;

        AnonymousClass2(h hVar) {
            this.f128a = hVar;
        }

        @Override // com.quantummetric.ui.internal.h
        public final /* bridge */ /* synthetic */ void a(String str) {
            bp.this.a(str, this.f128a);
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.bp$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (bp.this.c != bp.this.b) {
                    bp.this.a(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    bp(bz bzVar, dc dcVar) throws NullPointerException {
        bzVar.getClass();
        this.f = dcVar;
        this.f126a = bzVar;
    }

    final void a() {
        this.d = true;
        a(false);
        if (this.e) {
            return;
        }
        cl.a(new AnonymousClass3(), 50);
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x013b, code lost:
    
        if (com.quantummetric.ui.internal.de.g(r6) != false) goto L93;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d A[Catch: Exception -> 0x027c, TryCatch #0 {Exception -> 0x027c, blocks: (B:3:0x0015, B:5:0x001f, B:8:0x0023, B:10:0x003a, B:12:0x0040, B:14:0x0046, B:15:0x0050, B:18:0x0056, B:20:0x0068, B:24:0x007d, B:29:0x0088, B:31:0x008c, B:34:0x0098, B:36:0x009e, B:38:0x00aa, B:40:0x00b0, B:42:0x00bb, B:44:0x0096, B:47:0x00c5, B:49:0x00c9, B:51:0x00cd, B:57:0x00d9, B:61:0x00e0, B:64:0x00e9, B:66:0x00f5, B:68:0x00f9, B:72:0x0107, B:74:0x0110, B:76:0x0116, B:78:0x011e, B:80:0x0124, B:82:0x0180, B:83:0x0192, B:86:0x0198, B:88:0x019e, B:90:0x01a9, B:94:0x01b6, B:96:0x01ba, B:98:0x01c0, B:99:0x01c4, B:101:0x01c8, B:103:0x01ce, B:104:0x01d2, B:106:0x01d6, B:108:0x01dc, B:155:0x0131, B:157:0x0137, B:159:0x013d, B:161:0x0140, B:163:0x0144, B:165:0x0170, B:167:0x0174, B:170:0x014b, B:172:0x014f, B:174:0x0163, B:176:0x0169, B:182:0x0072), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e A[Catch: Exception -> 0x027c, TryCatch #0 {Exception -> 0x027c, blocks: (B:3:0x0015, B:5:0x001f, B:8:0x0023, B:10:0x003a, B:12:0x0040, B:14:0x0046, B:15:0x0050, B:18:0x0056, B:20:0x0068, B:24:0x007d, B:29:0x0088, B:31:0x008c, B:34:0x0098, B:36:0x009e, B:38:0x00aa, B:40:0x00b0, B:42:0x00bb, B:44:0x0096, B:47:0x00c5, B:49:0x00c9, B:51:0x00cd, B:57:0x00d9, B:61:0x00e0, B:64:0x00e9, B:66:0x00f5, B:68:0x00f9, B:72:0x0107, B:74:0x0110, B:76:0x0116, B:78:0x011e, B:80:0x0124, B:82:0x0180, B:83:0x0192, B:86:0x0198, B:88:0x019e, B:90:0x01a9, B:94:0x01b6, B:96:0x01ba, B:98:0x01c0, B:99:0x01c4, B:101:0x01c8, B:103:0x01ce, B:104:0x01d2, B:106:0x01d6, B:108:0x01dc, B:155:0x0131, B:157:0x0137, B:159:0x013d, B:161:0x0140, B:163:0x0144, B:165:0x0170, B:167:0x0174, B:170:0x014b, B:172:0x014f, B:174:0x0163, B:176:0x0169, B:182:0x0072), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb A[Catch: Exception -> 0x027c, TryCatch #0 {Exception -> 0x027c, blocks: (B:3:0x0015, B:5:0x001f, B:8:0x0023, B:10:0x003a, B:12:0x0040, B:14:0x0046, B:15:0x0050, B:18:0x0056, B:20:0x0068, B:24:0x007d, B:29:0x0088, B:31:0x008c, B:34:0x0098, B:36:0x009e, B:38:0x00aa, B:40:0x00b0, B:42:0x00bb, B:44:0x0096, B:47:0x00c5, B:49:0x00c9, B:51:0x00cd, B:57:0x00d9, B:61:0x00e0, B:64:0x00e9, B:66:0x00f5, B:68:0x00f9, B:72:0x0107, B:74:0x0110, B:76:0x0116, B:78:0x011e, B:80:0x0124, B:82:0x0180, B:83:0x0192, B:86:0x0198, B:88:0x019e, B:90:0x01a9, B:94:0x01b6, B:96:0x01ba, B:98:0x01c0, B:99:0x01c4, B:101:0x01c8, B:103:0x01ce, B:104:0x01d2, B:106:0x01d6, B:108:0x01dc, B:155:0x0131, B:157:0x0137, B:159:0x013d, B:161:0x0140, B:163:0x0144, B:165:0x0170, B:167:0x0174, B:170:0x014b, B:172:0x014f, B:174:0x0163, B:176:0x0169, B:182:0x0072), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: Exception -> 0x027c, TryCatch #0 {Exception -> 0x027c, blocks: (B:3:0x0015, B:5:0x001f, B:8:0x0023, B:10:0x003a, B:12:0x0040, B:14:0x0046, B:15:0x0050, B:18:0x0056, B:20:0x0068, B:24:0x007d, B:29:0x0088, B:31:0x008c, B:34:0x0098, B:36:0x009e, B:38:0x00aa, B:40:0x00b0, B:42:0x00bb, B:44:0x0096, B:47:0x00c5, B:49:0x00c9, B:51:0x00cd, B:57:0x00d9, B:61:0x00e0, B:64:0x00e9, B:66:0x00f5, B:68:0x00f9, B:72:0x0107, B:74:0x0110, B:76:0x0116, B:78:0x011e, B:80:0x0124, B:82:0x0180, B:83:0x0192, B:86:0x0198, B:88:0x019e, B:90:0x01a9, B:94:0x01b6, B:96:0x01ba, B:98:0x01c0, B:99:0x01c4, B:101:0x01c8, B:103:0x01ce, B:104:0x01d2, B:106:0x01d6, B:108:0x01dc, B:155:0x0131, B:157:0x0137, B:159:0x013d, B:161:0x0140, B:163:0x0144, B:165:0x0170, B:167:0x0174, B:170:0x014b, B:172:0x014f, B:174:0x0163, B:176:0x0169, B:182:0x0072), top: B:2:0x0015 }] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.quantummetric.instrument.internal.bp$1, com.quantummetric.instrument.internal.h] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(com.quantummetric.ui.internal.da r18, android.graphics.drawable.Drawable r19, final java.lang.String r20, final com.quantummetric.ui.internal.h<java.lang.String> r21) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.bp.a(com.quantummetric.instrument.internal.da, android.graphics.drawable.Drawable, java.lang.String, com.quantummetric.instrument.internal.h):void");
    }

    final synchronized void a(String str, h<String> hVar) {
        this.c++;
        if (hVar != null) {
            hVar.a(str);
        }
        a(false);
    }

    final synchronized void a(boolean z) {
        if (!this.e && (z || (!this.g && this.d && this.b == this.c))) {
            this.e = true;
            dc dcVar = this.f;
            if (dcVar != null) {
                dcVar.a();
            }
            this.g = true;
        }
    }
}
