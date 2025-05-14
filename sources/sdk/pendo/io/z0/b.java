package sdk.pendo.io.z0;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList f1864a;
    private d b = new d(null);
    private e c = null;
    private int d = 0;

    private List a(a aVar) {
        if (aVar == null) {
            return new sdk.pendo.io.y0.a();
        }
        List b = aVar.b();
        return b == null ? new sdk.pendo.io.y0.a() : b;
    }

    private Map b(a aVar) {
        if (aVar == null) {
            return new sdk.pendo.io.y0.c();
        }
        Map a2 = aVar.a();
        return a2 == null ? new sdk.pendo.io.y0.c() : a2;
    }

    public void c() {
        this.c = null;
        this.d = 0;
        this.f1864a = null;
    }

    private void b() {
        e b = this.b.b();
        this.c = b;
        if (b == null) {
            this.c = new e(-1, null);
        }
    }

    public int a() {
        return this.b.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r1 != 6) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0096, code lost:
    
        if (r1 != 5) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
    
        if (r0.size() > 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
    
        r9.removeFirst();
        r0.removeFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0100, code lost:
    
        r8.d = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ef, code lost:
    
        if (r5 != 5) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f6, code lost:
    
        if (r0.size() > 1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0184 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.io.Reader r9, sdk.pendo.io.z0.a r10) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.z0.b.a(java.io.Reader, sdk.pendo.io.z0.a):java.lang.Object");
    }

    public Object a(String str, a aVar) {
        try {
            return a(new StringReader(str), aVar);
        } catch (IOException e) {
            throw new c(-1, 2, e);
        }
    }

    private int a(LinkedList linkedList) {
        if (linkedList.size() == 0) {
            return -1;
        }
        return ((Integer) linkedList.getFirst()).intValue();
    }

    public void a(Reader reader) {
        this.b.a(reader);
        c();
    }
}
