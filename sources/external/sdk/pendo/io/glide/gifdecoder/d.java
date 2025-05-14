package external.sdk.pendo.io.glide.gifdecoder;

import android.util.Log;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes2.dex */
public class d {
    private ByteBuffer b;
    private c c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f630a = new byte[256];
    private int d = 0;

    private boolean b() {
        return this.c.b != 0;
    }

    private int d() {
        try {
            return this.b.get() & UByte.MAX_VALUE;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private void e() {
        this.c.d.f628a = l();
        this.c.d.b = l();
        this.c.d.c = l();
        this.c.d.d = l();
        int d = d();
        boolean z = (d & 128) != 0;
        int pow = (int) Math.pow(2.0d, (d & 7) + 1);
        b bVar = this.c.d;
        bVar.e = (d & 64) != 0;
        if (z) {
            bVar.k = a(pow);
        } else {
            bVar.k = null;
        }
        this.c.d.j = this.b.position();
        o();
        if (b()) {
            return;
        }
        c cVar = this.c;
        cVar.c++;
        cVar.e.add(cVar.d);
    }

    private void f() {
        int d = d();
        this.d = d;
        if (d <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.d;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.b.get(this.f630a, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.d, e);
                }
                this.c.b = 1;
                return;
            }
        }
    }

    private void g() {
        b(Integer.MAX_VALUE);
    }

    private void h() {
        d();
        int d = d();
        b bVar = this.c.d;
        int i = (d & 28) >> 2;
        bVar.g = i;
        if (i == 0) {
            bVar.g = 1;
        }
        bVar.f = (d & 1) != 0;
        int l = l();
        if (l < 2) {
            l = 10;
        }
        b bVar2 = this.c.d;
        bVar2.i = l * 10;
        bVar2.h = d();
        d();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        j();
        if (!this.c.h || b()) {
            return;
        }
        c cVar = this.c;
        cVar.f629a = a(cVar.i);
        c cVar2 = this.c;
        cVar2.l = cVar2.f629a[cVar2.j];
    }

    private void j() {
        this.c.f = l();
        this.c.g = l();
        int d = d();
        c cVar = this.c;
        cVar.h = (d & 128) != 0;
        cVar.i = (int) Math.pow(2.0d, (d & 7) + 1);
        this.c.j = d();
        this.c.k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.f630a;
            if (bArr[0] == 1) {
                this.c.m = ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[1] & UByte.MAX_VALUE);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!b());
    }

    private int l() {
        return this.b.getShort();
    }

    private void m() {
        this.b = null;
        Arrays.fill(this.f630a, (byte) 0);
        this.c = new c();
        this.d = 0;
    }

    private void n() {
        int d;
        do {
            d = d();
            this.b.position(Math.min(this.b.position() + d, this.b.limit()));
        } while (d > 0);
    }

    private void o() {
        d();
        n();
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public c c() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.c;
        }
        i();
        if (!b()) {
            g();
            c cVar = this.c;
            if (cVar.c < 0) {
                cVar.b = 1;
            }
        }
        return this.c;
    }

    private int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & UByte.MAX_VALUE) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & UByte.MAX_VALUE) << 8) | (bArr[i5] & UByte.MAX_VALUE);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    private void b(int i) {
        boolean z = false;
        while (!z && !b() && this.c.c <= i) {
            int d = d();
            if (d == 33) {
                int d2 = d();
                if (d2 != 1) {
                    if (d2 == 249) {
                        this.c.d = new b();
                        h();
                    } else if (d2 != 254 && d2 == 255) {
                        f();
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < 11; i2++) {
                            sb.append((char) this.f630a[i2]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            k();
                        }
                    }
                }
                n();
            } else if (d == 44) {
                c cVar = this.c;
                if (cVar.d == null) {
                    cVar.d = new b();
                }
                e();
            } else if (d != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    public d a(ByteBuffer byteBuffer) {
        m();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d a(byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
        } else {
            this.b = null;
            this.c.b = 2;
        }
        return this;
    }
}
