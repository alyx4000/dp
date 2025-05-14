package com.quantummetric.ui.internal;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Switch;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import coil.request.ImageRequest;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.brotli.dec.BrotliInputStream;

/* loaded from: classes5.dex */
final class ag {
    private static boolean A = false;

    /* renamed from: a, reason: collision with root package name */
    static boolean f36a = true;
    static boolean b;
    static boolean c;
    static boolean d;
    static boolean e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static boolean i;
    private static boolean j;
    private static boolean k;
    private static boolean l;
    private static boolean m;
    private static boolean n;
    private static boolean o;
    private static boolean p;
    private static boolean q;
    private static boolean r;
    private static boolean s;
    private static boolean t;
    private static boolean u;
    private static boolean v;
    private static boolean w;
    private static boolean x;
    private static boolean y;
    private static boolean z;

    static void a() {
        try {
            f = RecyclerView.class.isInterface();
            g = true;
        } catch (Throwable unused) {
            f = !f;
            g = false;
        }
        try {
            f = ViewPager.class.isInterface();
            h = true;
        } catch (Throwable unused2) {
            f = !f;
            h = false;
        }
        try {
            f = AlertDialogLayout.class.isInterface();
            d = true;
        } catch (Throwable unused3) {
            f = !f;
            d = false;
        }
        try {
            f = FragmentActivity.class.isInterface();
            c = true;
        } catch (Throwable unused4) {
            f = !f;
            c = false;
        }
        try {
            f = TextInputLayout.class.isInterface();
            i = true;
            j = !TextInputLayout.class.getName().contains("support");
        } catch (Throwable unused5) {
            i = false;
        }
        try {
            f = TextInputEditText.class.isInterface();
            k = true;
        } catch (Throwable unused6) {
            k = false;
        }
        try {
            f = Chip.class.isInterface();
            l = true;
        } catch (Throwable unused7) {
            l = false;
        }
        try {
            f = CardView.class.isInterface();
            m = true;
        } catch (Throwable unused8) {
            m = false;
        }
        try {
            f = Interceptor.class.isInterface();
            n = true;
        } catch (Throwable unused9) {
            n = false;
        }
        try {
            f = BrotliInputStream.class.isInterface();
            o = true;
        } catch (Throwable unused10) {
            o = false;
        }
        try {
            f = RoundedBitmapDrawable.class.isInterface();
            p = true;
        } catch (Throwable unused11) {
            p = false;
        }
        try {
            f = DrawerArrowDrawable.class.isInterface();
            q = true;
        } catch (Throwable unused12) {
            q = false;
        }
        try {
            f = BottomNavigationItemView.class.isInterface();
            r = true;
        } catch (Throwable unused13) {
            r = false;
        }
        if (!b) {
            try {
                f = ReactViewGroup.class.isInterface();
                b = true;
                e();
            } catch (Throwable unused14) {
                b = false;
            }
        }
        try {
            f = SwitchCompat.class.isInterface();
            s = true;
        } catch (Throwable unused15) {
            s = false;
        }
        try {
            f = ActionMenuItemView.class.isInterface();
            t = true;
        } catch (Throwable unused16) {
            t = false;
        }
        try {
            f = MaterialShapeDrawable.class.isInterface();
            u = true;
        } catch (Throwable unused17) {
            u = false;
        }
        try {
            f = MaterialButton.class.isInterface();
            v = true;
        } catch (Throwable unused18) {
            v = false;
        }
        try {
            f = AndroidComposeView.class.isInterface();
            e = true;
            by.a();
            try {
                aa.q = ((Integer) by.b(null, Class.forName("androidx.compose.ui.R$id"), "compose_view_saveable_id_tag")).intValue();
            } catch (Throwable unused19) {
            }
        } catch (Throwable unused20) {
            e = false;
        }
        try {
            f = LayoutNode.class.isInterface();
            w = true;
            try {
                f = MutableIntState.class.isInterface();
                x = true;
            } catch (Throwable unused21) {
                x = false;
            }
            try {
                f = ColorProducer.class.isInterface();
                y = true;
            } catch (Throwable unused22) {
                y = false;
            }
        } catch (Throwable unused23) {
            w = false;
        }
        try {
            f = ImageRequest.class.isInterface();
            z = true;
        } catch (Throwable unused24) {
            z = false;
        }
        try {
            f = NestedScrollView.class.isInterface();
            A = true;
        } catch (Throwable unused25) {
            A = false;
        }
    }

    static boolean a(Activity activity) {
        return c && (activity instanceof FragmentActivity);
    }

    static boolean a(Drawable drawable) {
        return p && (drawable instanceof RoundedBitmapDrawable);
    }

    static boolean a(View view) {
        return g && (view instanceof RecyclerView);
    }

    static boolean a(Object obj) {
        return n && (obj instanceof Request);
    }

    static boolean a(String str) {
        return aa.k && "SvgView".equals(str);
    }

    static boolean b() {
        return j;
    }

    static boolean b(Drawable drawable) {
        return q && (drawable instanceof DrawerArrowDrawable);
    }

    static boolean b(View view) {
        return h && (view instanceof ViewPager);
    }

    static boolean b(Object obj) {
        return n && (obj instanceof Response);
    }

    static boolean b(String str) {
        return aa.k && "ReactViewBackgroundDrawable".equals(str);
    }

    static boolean c() {
        return o;
    }

    static boolean c(Drawable drawable) {
        return drawable != null && drawable.getClass().getName().contains("com.facebook.drawee.generic");
    }

    static boolean c(View view) {
        return i && (view instanceof TextInputLayout);
    }

    static boolean c(Object obj) {
        return w && (obj instanceof LayoutNode);
    }

    static boolean c(String str) {
        return b && str.equals("QuantumView");
    }

    static void d() {
        if (b) {
            return;
        }
        try {
            f = ReactViewGroup.class.isInterface();
            b = true;
            e();
        } catch (Throwable unused) {
            b = false;
        }
    }

    static boolean d(Drawable drawable) {
        return u && (drawable instanceof MaterialShapeDrawable);
    }

    static boolean d(View view) {
        return k && (view instanceof TextInputEditText);
    }

    static boolean d(Object obj) {
        return x && (obj instanceof MutableIntState);
    }

    private static void e() {
        try {
            Field declaredField = Class.forName("com.facebook.react.R$id").getDeclaredField("react_test_id");
            declaredField.setAccessible(true);
            aa.p = ((Integer) declaredField.get(null)).intValue();
        } catch (Throwable unused) {
        }
    }

    static boolean e(View view) {
        return l && (view instanceof Chip);
    }

    static boolean e(Object obj) {
        return y && (obj instanceof ColorProducer);
    }

    static boolean f(View view) {
        return m && (view instanceof CardView);
    }

    static boolean f(Object obj) {
        return z && (obj instanceof ImageRequest);
    }

    static boolean g(View view) {
        return aa.k && view != null && view.getClass().getName().equals("com.reactnativenavigation.react.ReactView");
    }

    static boolean g(Object obj) {
        return A && (obj instanceof NestedScrollView);
    }

    static boolean h(View view) {
        return r && (view instanceof BottomNavigationItemView);
    }

    static boolean i(View view) {
        return s && (view instanceof SwitchCompat);
    }

    static boolean j(View view) {
        return (s && (view instanceof SwitchCompat)) || (view instanceof Switch);
    }

    static boolean k(View view) {
        return b && view.getClass().getName().contains("com.BV.LinearGradient");
    }

    static boolean l(View view) {
        return b && (view instanceof ReactViewGroup);
    }

    static boolean m(View view) {
        return e && (view instanceof AndroidComposeView);
    }

    static boolean n(View view) {
        return t && (view instanceof ActionMenuItemView);
    }

    static boolean o(View view) {
        return v && (view instanceof MaterialButton);
    }
}
