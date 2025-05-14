package sdk.pendo.io.p;

import android.os.StrictMode;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public final class a implements Closeable {
    private final File A;
    private final File f;
    private final File f0;
    private final File s;
    private final int t0;
    private long u0;
    private final int v0;
    private Writer x0;
    private int z0;
    private long w0 = 0;
    private final LinkedHashMap<String, d> y0 = new LinkedHashMap<>(0, 0.75f, true);
    private long A0 = 0;
    final ThreadPoolExecutor B0 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> C0 = new CallableC0222a();

    /* renamed from: sdk.pendo.io.p.a$a, reason: collision with other inner class name */
    class CallableC0222a implements Callable<Void> {
        CallableC0222a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.x0 == null) {
                    return null;
                }
                a.this.p();
                if (a.this.e()) {
                    a.this.o();
                    a.this.z0 = 0;
                }
                return null;
            }
        }
    }

    private static final class b implements ThreadFactory {
        private b() {
        }

        /* synthetic */ b(CallableC0222a callableC0222a) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f1480a;
        private final boolean[] b;
        private boolean c;

        private c(d dVar) {
            this.f1480a = dVar;
            this.b = dVar.e ? null : new boolean[a.this.v0];
        }

        public void a() {
            a.this.a(this, false);
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void c() {
            a.this.a(this, true);
            this.c = true;
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0222a callableC0222a) {
            this(dVar);
        }

        public File a(int i) {
            File b;
            synchronized (a.this) {
                if (this.f1480a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f1480a.e) {
                    this.b[i] = true;
                }
                b = this.f1480a.b(i);
                a.this.f.mkdirs();
            }
            return b;
        }
    }

    private final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f1481a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private c f;
        private long g;

        private d(String str) {
            this.f1481a = str;
            this.b = new long[a.this.v0];
            this.c = new File[a.this.v0];
            this.d = new File[a.this.v0];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < a.this.v0; i++) {
                append.append(i);
                this.c[i] = new File(a.this.f, append.toString());
                append.append(DefaultDiskStorage.FileType.TEMP);
                this.d[i] = new File(a.this.f, append.toString());
                append.setLength(length);
            }
        }

        /* synthetic */ d(a aVar, String str, CallableC0222a callableC0222a) {
            this(str);
        }

        public File b(int i) {
            return this.d[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length != a.this.v0) {
                throw a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public File a(int i) {
            return this.c[i];
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private IOException a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f1482a;
        private final long b;
        private final long[] c;
        private final File[] d;

        private e(String str, long j, File[] fileArr, long[] jArr) {
            this.f1482a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }

        public File a(int i) {
            return this.d[i];
        }

        /* synthetic */ e(a aVar, String str, long j, File[] fileArr, long[] jArr, CallableC0222a callableC0222a) {
            this(str, j, fileArr, jArr);
        }
    }

    private a(File file, int i, int i2, long j) {
        this.f = file;
        this.t0 = i;
        this.s = new File(file, "journal");
        this.A = new File(file, "journal.tmp");
        this.f0 = new File(file, "journal.bkp");
        this.v0 = i2;
        this.u0 = j;
    }

    private void m() {
        a(this.A);
        Iterator<d> it = this.y0.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.v0) {
                    this.w0 += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.v0) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void n() {
        sdk.pendo.io.p.b bVar = new sdk.pendo.io.p.b(new FileInputStream(this.s), sdk.pendo.io.p.c.f1483a);
        try {
            String e2 = bVar.e();
            String e3 = bVar.e();
            String e4 = bVar.e();
            String e5 = bVar.e();
            String e6 = bVar.e();
            if (!"libcore.io.DiskLruCache".equals(e2) || !"1".equals(e3) || !Integer.toString(this.t0).equals(e4) || !Integer.toString(this.v0).equals(e5) || !"".equals(e6)) {
                throw new IOException("unexpected journal header: [" + e2 + ", " + e3 + ", " + e5 + ", " + e6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.e());
                    i++;
                } catch (EOFException unused) {
                    this.z0 = i - this.y0.size();
                    if (bVar.b()) {
                        o();
                    } else {
                        this.x0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.s, true), sdk.pendo.io.p.c.f1483a));
                    }
                    sdk.pendo.io.p.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            sdk.pendo.io.p.c.a(bVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        Writer writer = this.x0;
        if (writer != null) {
            a(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.A), sdk.pendo.io.p.c.f1483a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.t0));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.v0));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.y0.values()) {
                bufferedWriter.write((dVar.f != null ? new StringBuilder().append("DIRTY ").append(dVar.f1481a).append('\n') : new StringBuilder().append("CLEAN ").append(dVar.f1481a).append(dVar.a()).append('\n')).toString());
            }
            a(bufferedWriter);
            if (this.s.exists()) {
                a(this.s, this.f0, true);
            }
            a(this.A, this.s, false);
            this.f0.delete();
            this.x0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.s, true), sdk.pendo.io.p.c.f1483a));
        } catch (Throwable th) {
            a(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        while (this.w0 > this.u0) {
            e(this.y0.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.x0 == null) {
            return;
        }
        Iterator it = new ArrayList(this.y0.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f != null) {
                dVar.f.a();
            }
        }
        p();
        a(this.x0);
        this.x0 = null;
    }

    private void d(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.y0.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        d dVar = this.y0.get(substring);
        CallableC0222a callableC0222a = null;
        if (dVar == null) {
            dVar = new d(this, substring, callableC0222a);
            this.y0.put(substring, dVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, callableC0222a);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int i = this.z0;
        return i >= 2000 && i >= this.y0.size();
    }

    public void b() {
        close();
        sdk.pendo.io.p.c.a(this.f);
    }

    public synchronized e c(String str) {
        a();
        d dVar = this.y0.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.z0++;
        this.x0.append((CharSequence) "READ");
        this.x0.append(' ');
        this.x0.append((CharSequence) str);
        this.x0.append('\n');
        if (e()) {
            this.B0.submit(this.C0);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }

    public c b(String str) {
        return a(str, -1L);
    }

    public synchronized boolean e(String str) {
        a();
        d dVar = this.y0.get(str);
        if (dVar != null && dVar.f == null) {
            for (int i = 0; i < this.v0; i++) {
                File a2 = dVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.w0 -= dVar.b[i];
                dVar.b[i] = 0;
            }
            this.z0++;
            this.x0.append((CharSequence) "REMOVE");
            this.x0.append(' ');
            this.x0.append((CharSequence) str);
            this.x0.append('\n');
            this.y0.remove(str);
            if (e()) {
                this.B0.submit(this.C0);
            }
            return true;
        }
        return false;
    }

    private void a() {
        if (this.x0 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void b(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private static void a(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        d dVar = cVar.f1480a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i = 0; i < this.v0; i++) {
                if (!cVar.b[i]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.b(i).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.v0; i2++) {
            File b2 = dVar.b(i2);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = dVar.a(i2);
                b2.renameTo(a2);
                long j = dVar.b[i2];
                long length = a2.length();
                dVar.b[i2] = length;
                this.w0 = (this.w0 - j) + length;
            }
        }
        this.z0++;
        dVar.f = null;
        if (!(dVar.e | z)) {
            this.y0.remove(dVar.f1481a);
            this.x0.append((CharSequence) "REMOVE");
            this.x0.append(' ');
            this.x0.append((CharSequence) dVar.f1481a);
            this.x0.append('\n');
        } else {
            dVar.e = true;
            this.x0.append((CharSequence) "CLEAN");
            this.x0.append(' ');
            this.x0.append((CharSequence) dVar.f1481a);
            this.x0.append((CharSequence) dVar.a());
            this.x0.append('\n');
            if (z) {
                long j2 = this.A0;
                this.A0 = 1 + j2;
                dVar.g = j2;
            }
        }
        b(this.x0);
        if (this.w0 > this.u0 || e()) {
            this.B0.submit(this.C0);
        }
    }

    private static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c a(String str, long j) {
        a();
        d dVar = this.y0.get(str);
        CallableC0222a callableC0222a = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0222a);
            this.y0.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0222a);
        dVar.f = cVar;
        this.x0.append((CharSequence) "DIRTY");
        this.x0.append(' ');
        this.x0.append((CharSequence) str);
        this.x0.append('\n');
        b(this.x0);
        return cVar;
    }

    public static a a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.s.exists()) {
            try {
                aVar.n();
                aVar.m();
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.b();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.o();
        return aVar2;
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }
}
