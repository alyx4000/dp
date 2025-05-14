package com.quantummetric.ui.internal;

import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import com.quantummetric.ui.internal.i;
import io.sentry.protocol.Request;

/* loaded from: classes5.dex */
final class ar {

    /* renamed from: a, reason: collision with root package name */
    final StringBuilder f65a;

    ar() {
        this.f65a = new StringBuilder();
    }

    ar(int i) {
        this.f65a = new StringBuilder(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final <T> ar a(T t) {
        StringBuilder sb;
        CharSequence charSequence;
        if (t instanceof CharSequence) {
            sb = this.f65a;
            charSequence = (CharSequence) t;
        } else {
            if (!(t instanceof ar)) {
                this.f65a.append(t);
                return this;
            }
            sb = this.f65a;
            charSequence = ((ar) t).f65a;
        }
        sb.append(charSequence);
        return this;
    }

    final <T> ar a(String str, T t, String str2, boolean z) {
        if (z) {
            this.f65a.append(str).append(":").append(t).append(str2).append(";");
        }
        return this;
    }

    final <T> ar a(String str, T t, boolean z) {
        if (z) {
            this.f65a.append(str).append(":").append(t).append(";");
        }
        return this;
    }

    final <T> ar a(String str, int... iArr) {
        this.f65a.append(str).append(":");
        if (iArr != null) {
            a(iArr);
        }
        this.f65a.append(";");
        return this;
    }

    final <T> ar a(int... iArr) {
        int i;
        int i2;
        return (iArr.length == 4 && (i = iArr[0]) == iArr[2] && (i2 = iArr[1]) == iArr[3]) ? i == i2 ? b(i) : b(i, i2) : b(iArr);
    }

    final void a(float f) {
        if (f != 0.0f) {
            this.f65a.append(aa.ai).append(":").append(Integer.valueOf(de.b(f))).append(";");
        }
    }

    final void a(int i, int[] iArr) {
        if (iArr != null) {
            StringBuilder append = new StringBuilder("linear-gradient(").append(i).append("deg");
            for (int i2 : iArr) {
                append.append(",").append(de.b(i2));
            }
            append.append(")");
            this.f65a.append(AppStateModule.APP_STATE_BACKGROUND).append(":").append((Object) append).append(";");
        }
    }

    final void a(ar arVar, b bVar) {
        StringBuilder sb;
        String str;
        String num;
        StringBuilder append;
        String str2;
        if (bVar instanceof dj) {
            sb = this.f65a;
            str = "<iframe style=\"";
        } else {
            sb = this.f65a;
            str = "<div style=\"";
        }
        sb.append(str);
        this.f65a.append((CharSequence) arVar.f65a).append("\" id=\"").append(a.a(bVar));
        String str3 = bVar.g;
        if (!de.b(str3)) {
            this.f65a.append("\" data-").append("c").append("=\"").append(str3);
        }
        arVar.f65a.setLength(0);
        if (bVar.u.b) {
            this.f65a.append("\" class=\"");
            bVar.u.a(this, bVar);
        }
        if (bVar.e instanceof co) {
            num = ((co) bVar.e).z;
            if (!de.b(num)) {
                append = this.f65a.append("\" data-");
                str2 = ViewProps.ROLE;
                append.append(str2).append("=\"").append(num);
            }
        } else if (bVar.e instanceof da) {
            da daVar = (da) bVar.e;
            String b = dh.b(bVar.f);
            if (!de.b(b)) {
                String c = dh.c(bVar.f);
                if (!de.b(b)) {
                    this.f65a.append("\" data-").append("activity").append("=\"").append(b);
                }
                if (!de.b(c)) {
                    this.f65a.append("\" data-").append("custom-page").append("=\"").append(c);
                }
            }
            String d = dh.d(bVar.f);
            if (!de.b(d)) {
                this.f65a.append("\" data-").append(Request.JsonKeys.FRAGMENT).append("=\"").append(d);
            }
            if (daVar.E != null) {
                i iVar = daVar.E;
                for (i.a aVar : i.a.values()) {
                    String name = aVar.name();
                    String optString = iVar.optString(name);
                    String a2 = i.a(name);
                    if (!de.b(optString)) {
                        this.f65a.append("\" data-").append(a2).append("=\"").append(optString);
                    }
                }
            }
            int i = daVar.D;
            if (i >= 0) {
                num = Integer.toString(i);
                if (!de.b(num)) {
                    append = this.f65a.append("\" data-");
                    str2 = "ind";
                    append.append(str2).append("=\"").append(num);
                }
            }
        }
        if (aa.d) {
            String a_ = bVar.e.a_();
            if (!de.b(a_)) {
                this.f65a.append("\" data-").append("id").append("=\"").append(a_);
            }
        }
        if (aa.s) {
            bd.a();
            String a3 = bd.a(bVar.f);
            if (!de.b(a3)) {
                this.f65a.append("\" data-").append("applied-masking").append("=\"").append(a3);
            }
        }
        this.f65a.append("\">");
        bVar.b(this);
        bVar.a(this);
        if (bVar.z) {
            return;
        }
        a(bVar);
    }

    final void a(b bVar) {
        if (bVar instanceof dj) {
            this.f65a.append("</iframe>");
            return;
        }
        this.f65a.append("</div>");
        bVar.c(this);
        if (bVar.r || (bVar instanceof cc) || (bVar instanceof r)) {
            this.f65a.append("</div>");
        }
    }

    final void a(Float[] fArr, ch chVar) {
        boolean z;
        boolean z2;
        int length = fArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else {
                if (fArr[i].floatValue() > 0.0d) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= fArr.length - 1) {
                z2 = true;
                break;
            }
            float floatValue = fArr[i2].floatValue();
            i2++;
            if (floatValue != fArr[i2].floatValue()) {
                z2 = false;
                break;
            }
        }
        if (!z2) {
            a("border-radius", de.b(fArr[0].floatValue()), de.b(fArr[1].floatValue()), de.b(fArr[2].floatValue()), de.b(fArr[3].floatValue()));
        } else if (z) {
            chVar.a(fArr[0].floatValue());
        }
    }

    final <T> ar b(int... iArr) {
        for (int i = 0; i < iArr.length; i++) {
            this.f65a.append(iArr[i]);
            if (iArr[i] != 0) {
                this.f65a.append("px");
            }
            if (i != iArr.length - 1) {
                this.f65a.append(" ");
            }
        }
        return this;
    }

    public final String toString() {
        return this.f65a.toString();
    }
}
