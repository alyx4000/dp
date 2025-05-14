package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import com.squareup.kotlinpoet.FileSpecKt;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class n extends Exception {
    private static final StackTraceElement[] v0 = new StackTraceElement[0];
    private sdk.pendo.io.q.a A;
    private final List<Throwable> f;
    private Class<?> f0;
    private sdk.pendo.io.q.f s;
    private String t0;
    private Exception u0;

    private static final class a implements Appendable {
        private final Appendable f;
        private boolean s = true;

        a(Appendable appendable) {
            this.f = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) {
            if (this.s) {
                this.s = false;
                this.f.append(FileSpecKt.DEFAULT_INDENT);
            }
            this.s = c == '\n';
            this.f.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.s) {
                this.s = false;
                this.f.append(FileSpecKt.DEFAULT_INDENT);
            }
            if (a2.length() > 0 && a2.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.s = z;
            this.f.append(a2, i, i2);
            return this;
        }
    }

    public n(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (!(th instanceof n)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((n) th).a().iterator();
        while (it.hasNext()) {
            a(it.next(), list);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof n) {
                ((n) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder append = new StringBuilder(71).append(this.t0).append(this.f0 != null ? ", " + this.f0 : "").append(this.A != null ? ", " + this.A : "").append(this.s != null ? ", " + this.s : "");
        List<Throwable> b = b();
        if (b.isEmpty()) {
            return append.toString();
        }
        if (b.size() == 1) {
            append.append("\nThere was 1 root cause:");
        } else {
            append.append("\nThere were ").append(b.size()).append(" root causes:");
        }
        for (Throwable th : b) {
            append.append('\n').append(th.getClass().getName()).append('(').append(th.getMessage()).append(')');
        }
        append.append("\n call GlideException#logRootCauses(String) for more detail");
        return append.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public n(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Throwable> b() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(printStream);
    }

    public n(String str, List<Throwable> list) {
        this.t0 = str;
        setStackTrace(v0);
        this.f = list;
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(printWriter);
    }

    public List<Throwable> a() {
        return this.f;
    }

    public void a(String str) {
        List<Throwable> b = b();
        int size = b.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Log.i(str, "Root cause (" + i2 + " of " + size + ")", b.get(i));
            i = i2;
        }
    }

    private void a(Appendable appendable) {
        a(this, appendable);
        a(a(), new a(appendable));
    }

    void a(sdk.pendo.io.q.f fVar, sdk.pendo.io.q.a aVar) {
        a(fVar, aVar, null);
    }

    void a(sdk.pendo.io.q.f fVar, sdk.pendo.io.q.a aVar, Class<?> cls) {
        this.s = fVar;
        this.A = aVar;
        this.f0 = cls;
    }

    public void a(Exception exc) {
        this.u0 = exc;
    }
}
