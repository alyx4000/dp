package com.quantummetric.ui.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.compose.ui.node.LayoutNode;
import androidx.core.content.ContextCompat;
import com.facebook.react.BuildConfig;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.quantummetric.ui.QuantumMetric;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class de {

    /* renamed from: a, reason: collision with root package name */
    static Charset f180a = Charset.forName("UTF-8");
    private static int b = 2;

    /* renamed from: com.quantummetric.instrument.internal.de$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ String f181a;
        private /* synthetic */ String b;
        private /* synthetic */ Context c;

        AnonymousClass1(String str, String str2, Context context) {
            this.f181a = str;
            this.b = str2;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            de.b(this.f181a, this.b, this.c);
        }
    }

    /* renamed from: com.quantummetric.instrument.internal.de$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f184a;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            f184a = iArr;
            try {
                iArr[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f184a[GradientDrawable.Orientation.BL_TR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f184a[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f184a[GradientDrawable.Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f184a[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f184a[GradientDrawable.Orientation.TR_BL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f184a[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f184a[GradientDrawable.Orientation.TL_BR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static double a(double d) {
        return d * (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d);
    }

    static double a(double d, double d2, double d3) {
        return (d3 / d2) * d;
    }

    static float a(float f) {
        return f * Resources.getSystem().getDisplayMetrics().scaledDensity;
    }

    static int a() {
        try {
            return Resources.getSystem().getDisplayMetrics().widthPixels + (e.a().O <= 0 ? 0 : aa.G);
        } catch (Exception unused) {
            return 1;
        }
    }

    private static int a(Drawable drawable, int i, ColorStateList colorStateList) {
        if (colorStateList == null || !aa.x) {
            return i;
        }
        Paint paint = (Paint) by.b(drawable, "mFillPaint");
        return paint != null && paint.getColorFilter() != null ? aa.F : colorStateList.getDefaultColor();
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0184, code lost:
    
        if (r13 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c6, code lost:
    
        if (r13 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01d3, code lost:
    
        if (r13 != null) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int a(android.graphics.drawable.Drawable r13, com.quantummetric.ui.internal.ar r14, com.quantummetric.ui.internal.dg r15) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.a(android.graphics.drawable.Drawable, com.quantummetric.instrument.internal.ar, com.quantummetric.instrument.internal.dg):int");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|(1:61)(1:7)|(2:9|(5:20|21|22|23|(6:25|(1:27)(1:39)|28|(2:31|32)|33|(2:35|36)(1:38))(2:40|(3:55|56|(0)(0))(6:44|(1:46)(1:54)|47|(4:49|(1:51)(1:53)|52|32)|33|(0)(0)))))|58|21|22|23|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[Catch: all -> 0x013a, TRY_ENTER, TryCatch #0 {all -> 0x013a, blocks: (B:22:0x0062, B:25:0x0071, B:27:0x0083, B:28:0x008d, B:31:0x00a1, B:32:0x0130, B:40:0x00e2, B:42:0x00e8, B:44:0x00ec, B:46:0x00f4, B:47:0x00fa, B:49:0x0102, B:52:0x0118, B:55:0x0135), top: B:21:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2 A[Catch: all -> 0x013a, TryCatch #0 {all -> 0x013a, blocks: (B:22:0x0062, B:25:0x0071, B:27:0x0083, B:28:0x008d, B:31:0x00a1, B:32:0x0130, B:40:0x00e2, B:42:0x00e8, B:44:0x00ec, B:46:0x00f4, B:47:0x00fa, B:49:0x0102, B:52:0x0118, B:55:0x0135), top: B:21:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int a(android.view.View r12, com.quantummetric.ui.internal.ar r13, com.quantummetric.ui.internal.dg r14) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.a(android.view.View, com.quantummetric.instrument.internal.ar, com.quantummetric.instrument.internal.dg):int");
    }

    static int a(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return 0;
        }
        return i(charSequence.toString());
    }

    static int a(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.start();
        }
        return -1;
    }

    static Drawable a(LayerDrawable layerDrawable) {
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        if (numberOfLayers <= 0) {
            return null;
        }
        Drawable drawable = layerDrawable.getDrawable(numberOfLayers - 1);
        if (drawable == null || (drawable != layerDrawable.findDrawableByLayerId(R.id.mask) && (!(drawable instanceof RippleDrawable) || numberOfLayers <= 1))) {
            return drawable;
        }
        if (numberOfLayers > 1) {
            return layerDrawable.getDrawable(numberOfLayers - 2);
        }
        return null;
    }

    private static Drawable a(Field field, Drawable drawable) throws Exception {
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        if (field != null) {
            field.setAccessible(true);
            ActionBarContainer actionBarContainer = (ActionBarContainer) field.get(drawable);
            if (actionBarContainer != null) {
                Field declaredField = actionBarContainer.getClass().getDeclaredField("mBackground");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    drawable2 = (Drawable) declaredField.get(actionBarContainer);
                } else {
                    drawable2 = null;
                }
                if (drawable2 != null) {
                    return drawable2;
                }
                Field declaredField2 = actionBarContainer.getClass().getDeclaredField("mSplitBackground");
                if (declaredField2 != null) {
                    declaredField2.setAccessible(true);
                    drawable3 = (Drawable) declaredField2.get(actionBarContainer);
                } else {
                    drawable3 = null;
                }
                if (drawable3 != null) {
                    return drawable3;
                }
                Field declaredField3 = actionBarContainer.getClass().getDeclaredField("mStackedBackground");
                if (declaredField3 != null) {
                    declaredField3.setAccessible(true);
                    drawable4 = (Drawable) declaredField3.get(actionBarContainer);
                } else {
                    drawable4 = null;
                }
                if (drawable4 != null) {
                    return drawable4;
                }
            }
        }
        return null;
    }

    static View a(View view, int[] iArr) {
        View view2;
        if (iArr != null && iArr.length > 0) {
            view2 = view;
            for (int i : iArr) {
                if (i < 0) {
                    for (int i2 = 0; i != i2; i2--) {
                        if (view2 == null || !(view2.getParent() instanceof View)) {
                            return null;
                        }
                        view2 = (View) view2.getParent();
                    }
                } else if (view2 instanceof ViewGroup) {
                    view2 = ((ViewGroup) view2).getChildAt(i);
                }
                if (view2 == null) {
                    break;
                }
            }
        } else {
            view2 = view;
        }
        if (view2 != view) {
            return view2;
        }
        return null;
    }

    static Object a(Object obj, int[] iArr) {
        View view;
        View view2;
        if (obj instanceof View) {
            view2 = a((View) obj, iArr);
        } else {
            if (!ag.e || !(obj instanceof LayoutNode)) {
                return null;
            }
            View view3 = (LayoutNode) obj;
            if (iArr != null && iArr.length > 0) {
                view = view3;
                loop0: for (int i : iArr) {
                    if (i < 0) {
                        int i2 = 0;
                        while (i != i2) {
                            s.a();
                            View a2 = s.a((LayoutNode) view);
                            if (view == null || a2 == null) {
                                break loop0;
                            }
                            i2--;
                            view = a2;
                        }
                    } else {
                        List asMutableList = view.getZSortedChildren().asMutableList();
                        if (asMutableList.size() > 0) {
                            view = (LayoutNode) asMutableList.get(i);
                        }
                    }
                    if (view == null) {
                        break;
                    }
                }
            } else {
                view = view3;
            }
            if (view != view3) {
                view2 = view;
            }
            view2 = null;
        }
        return view2;
    }

    public static String a(Context context) {
        String str;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            str = applicationInfo.labelRes == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getApplicationContext().getString(applicationInfo.labelRes);
        } catch (Exception unused) {
            str = "";
        }
        return str.matches("^[a-zA-Z_0-9 \\- \\! \\( \\) \\? \\:]*") ? str : "App";
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c1, code lost:
    
        return com.quantummetric.ui.internal.i.b(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0035, code lost:
    
        if (d(r1) != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[Catch: Exception -> 0x00c1, TryCatch #2 {Exception -> 0x00c1, blocks: (B:4:0x0004, B:7:0x0039, B:10:0x003f, B:15:0x004f, B:17:0x0055, B:19:0x005b, B:21:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x007f, B:30:0x0089, B:33:0x008d, B:36:0x0093, B:41:0x00a3, B:43:0x00a9, B:46:0x00af, B:51:0x00bd), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089 A[Catch: Exception -> 0x00c1, TryCatch #2 {Exception -> 0x00c1, blocks: (B:4:0x0004, B:7:0x0039, B:10:0x003f, B:15:0x004f, B:17:0x0055, B:19:0x005b, B:21:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x007f, B:30:0x0089, B:33:0x008d, B:36:0x0093, B:41:0x00a3, B:43:0x00a9, B:46:0x00af, B:51:0x00bd), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0031 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #1 {Exception -> 0x0038, blocks: (B:62:0x001b, B:65:0x0021, B:70:0x0031), top: B:61:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(android.view.View r7) {
        /*
            java.lang.String r0 = ""
            if (r7 == 0) goto Lc1
            int r1 = r7.getId()     // Catch: java.lang.Exception -> Lc1
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L39
            android.content.res.Resources r1 = r7.getResources()     // Catch: java.lang.Exception -> L39
            if (r1 == 0) goto L39
            int r2 = r7.getId()     // Catch: java.lang.Exception -> L39
            java.lang.String r1 = r1.getResourceEntryName(r2)     // Catch: java.lang.Exception -> L39
            boolean r2 = com.quantummetric.ui.internal.aa.t     // Catch: java.lang.Exception -> L38
            if (r2 == 0) goto L38
            if (r1 == 0) goto L2e
            java.lang.String r2 = r1.trim()     // Catch: java.lang.Exception -> L38
            int r2 = r2.length()     // Catch: java.lang.Exception -> L38
            if (r2 != 0) goto L2c
            goto L2e
        L2c:
            r2 = r4
            goto L2f
        L2e:
            r2 = r3
        L2f:
            if (r2 != 0) goto L38
            boolean r2 = d(r1)     // Catch: java.lang.Exception -> L38
            if (r2 == 0) goto L38
            goto L39
        L38:
            r0 = r1
        L39:
            boolean r1 = com.quantummetric.ui.internal.aa.m     // Catch: java.lang.Exception -> Lc1
            if (r1 == 0) goto L8d
            if (r0 == 0) goto L4c
            java.lang.String r1 = r0.trim()     // Catch: java.lang.Exception -> Lc1
            int r1 = r1.length()     // Catch: java.lang.Exception -> Lc1
            if (r1 != 0) goto L4a
            goto L4c
        L4a:
            r1 = r4
            goto L4d
        L4c:
            r1 = r3
        L4d:
            if (r1 == 0) goto L8d
            java.lang.CharSequence r1 = r7.getContentDescription()     // Catch: java.lang.Exception -> Lc1
            if (r1 == 0) goto L8d
            int r2 = r1.length()     // Catch: java.lang.Exception -> Lc1
            if (r2 <= 0) goto L8d
            com.quantummetric.instrument.internal.bd r2 = com.quantummetric.ui.internal.bd.a()     // Catch: java.lang.Exception -> Lc1
            boolean r5 = com.quantummetric.ui.internal.aa.m     // Catch: java.lang.Exception -> Lc1
            if (r5 == 0) goto L86
            boolean r5 = com.quantummetric.ui.internal.bd.c     // Catch: java.lang.Exception -> Lc1
            if (r5 == 0) goto L86
            if (r7 == 0) goto L86
            java.lang.CharSequence r5 = r7.getContentDescription()     // Catch: java.lang.Exception -> Lc1
            if (r5 == 0) goto L86
            java.lang.CharSequence r5 = r7.getContentDescription()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Lc1
            java.util.List<java.lang.String> r6 = r2.n     // Catch: java.lang.Exception -> Lc1
            int r6 = r6.size()     // Catch: java.lang.Exception -> Lc1
            if (r6 <= 0) goto L86
            java.util.List<java.lang.String> r2 = r2.n     // Catch: java.lang.Exception -> Lc1
            boolean r2 = a(r5, r2)     // Catch: java.lang.Exception -> Lc1
            goto L87
        L86:
            r2 = r4
        L87:
            if (r2 != 0) goto L8d
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> Lc1
        L8d:
            boolean r1 = com.quantummetric.ui.internal.aa.k     // Catch: java.lang.Exception -> Lc1
            if (r1 == 0) goto Lad
            if (r0 == 0) goto La0
            java.lang.String r1 = r0.trim()     // Catch: java.lang.Exception -> Lc1
            int r1 = r1.length()     // Catch: java.lang.Exception -> Lc1
            if (r1 != 0) goto L9e
            goto La0
        L9e:
            r1 = r4
            goto La1
        La0:
            r1 = r3
        La1:
            if (r1 == 0) goto Lad
            boolean r1 = com.quantummetric.ui.internal.ag.g(r7)     // Catch: java.lang.Exception -> Lc1
            if (r1 == 0) goto Lad
            java.lang.String r0 = com.quantummetric.ui.internal.cv.b(r7)     // Catch: java.lang.Exception -> Lc1
        Lad:
            if (r0 == 0) goto Lbb
            java.lang.String r1 = r0.trim()     // Catch: java.lang.Exception -> Lc1
            int r1 = r1.length()     // Catch: java.lang.Exception -> Lc1
            if (r1 != 0) goto Lba
            goto Lbb
        Lba:
            r3 = r4
        Lbb:
            if (r3 == 0) goto Lc1
            java.lang.String r0 = com.quantummetric.ui.internal.i.b(r7)     // Catch: java.lang.Exception -> Lc1
        Lc1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.a(android.view.View):java.lang.String");
    }

    static <K, V> String a(Map<K, V> map) {
        ArrayList arrayList = new ArrayList();
        try {
            for (K k : map.keySet()) {
                Object obj = map.get(k);
                if (obj instanceof String) {
                    try {
                        obj = URLEncoder.encode((String) obj, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                arrayList.add(k + "=" + obj);
            }
        } catch (Exception unused2) {
        }
        return TextUtils.join("&", arrayList);
    }

    static String a(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                        return sb2;
                    } catch (Exception unused2) {
                        return sb2;
                    }
                }
                sb.append(readLine);
            }
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    static String a(InputStream inputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[i];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                        try {
                            inputStream.close();
                            return byteArrayOutputStream2;
                        } catch (Exception unused) {
                            return byteArrayOutputStream2;
                        }
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception unused2) {
                inputStream.close();
                return "";
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0004 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(java.util.regex.Pattern r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.util.regex.Matcher r2 = r2.matcher(r3)     // Catch: java.lang.Exception -> L29
        L4:
            boolean r0 = r2.find()     // Catch: java.lang.Exception -> L29
            if (r0 == 0) goto L29
            int r0 = r2.groupCount()     // Catch: java.lang.Exception -> L29
            java.lang.String r0 = r2.group(r0)     // Catch: java.lang.Exception -> L29
            if (r0 == 0) goto L21
            java.lang.String r1 = r0.trim()     // Catch: java.lang.Exception -> L29
            int r1 = r1.length()     // Catch: java.lang.Exception -> L29
            if (r1 != 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 != 0) goto L4
            java.lang.String r3 = r3.replace(r0, r4)     // Catch: java.lang.Exception -> L29
            goto L4
        L29:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.a(java.util.regex.Pattern, java.lang.String, java.lang.String):java.lang.String");
    }

    static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement);
            sb.append("\n");
        }
        return sb.toString();
    }

    static JSONObject a(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj instanceof bg) {
                    obj = ((bg) obj).c();
                } else if (obj instanceof bf) {
                    obj = a((Map<String, ?>) obj);
                } else if (obj instanceof ArrayList) {
                    jSONObject.put(str, new JSONArray((Collection) obj));
                }
                jSONObject.put(str, obj);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    static void a(int i) {
        if (i > 3) {
            b = 3;
        } else {
            b = Math.max(i, 1);
        }
    }

    static void a(String str) {
        if (b >= 3) {
            String[] strArr = {"QM: ".concat(String.valueOf(str))};
            int i = b;
            if (i < 2 || i < 2 || i < 2) {
                return;
            }
            String join = TextUtils.join(" ", strArr);
            int i2 = b;
            if (i2 < 2 || i2 < 2) {
                return;
            }
            Log.v("Quantum Metric", join + " | t=" + Thread.currentThread().getName() + "@" + Thread.currentThread().getId(), null);
        }
    }

    public static void a(final String str, final Context context) {
        if (context != null) {
            if (cl.a()) {
                cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.de.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        de.c(str, context);
                    }
                });
            } else {
                try {
                    context.deleteFile(str);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final String str, final Context context, final h<Boolean> hVar) {
        cl.b(new Runnable() { // from class: com.quantummetric.instrument.internal.de.3
            @Override // java.lang.Runnable
            public final void run() {
                boolean b2 = de.b(str, context);
                QuantumMetric.AnonymousClass1 anonymousClass1 = hVar;
                if (anonymousClass1 != null) {
                    anonymousClass1.a(Boolean.valueOf(b2));
                }
            }
        });
    }

    public static void a(String str, String str2, Context context) {
        if (cl.a()) {
            cl.b(new AnonymousClass1(str, str2, context));
        } else {
            a(str, str2, false, context);
        }
    }

    static void a(String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        Context f = f();
        if (f != null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                String str4 = f.getFilesDir() + "/" + str2;
                File file = new File(str4);
                if (!file.exists()) {
                    file.mkdir();
                }
                fileOutputStream = new FileOutputStream(new File(str4 + "/" + str));
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str3.getBytes());
                fileOutputStream.close();
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            } catch (Exception unused3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
            } catch (Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    static void a(String str, String str2, boolean z, Context context) {
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Exception unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }

    static void a(List<?>... listArr) {
        for (List<?> list : listArr) {
            if (list != null) {
                list.clear();
            }
        }
    }

    static boolean a(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean a(Rect rect) {
        return (rect == null || ((rect.top * rect.right) * rect.bottom) * rect.left == 0) ? false : true;
    }

    static boolean a(Drawable drawable) {
        if (!bz.a().w || !(drawable instanceof LayerDrawable)) {
            return false;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        if (layerDrawable.getNumberOfLayers() != 2) {
            return false;
        }
        Drawable drawable2 = layerDrawable.getDrawable(0);
        Drawable drawable3 = layerDrawable.getDrawable(1);
        if ((drawable2 instanceof ColorDrawable) || (drawable2 instanceof GradientDrawable)) {
            return (drawable3 instanceof BitmapDrawable) || bz.a().b(drawable3);
        }
        return false;
    }

    static boolean a(Object obj) {
        return obj != null && obj.getClass().getName().contains("quantum");
    }

    static boolean a(String str, String str2) {
        return a(str, c(str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[Catch: Exception -> 0x0065, TryCatch #0 {Exception -> 0x0065, blocks: (B:39:0x0006, B:6:0x0018, B:12:0x0029, B:13:0x0032, B:15:0x0035, B:17:0x0038, B:19:0x0042, B:21:0x0045, B:23:0x0048, B:25:0x004b, B:30:0x005f), top: B:38:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            java.lang.String r0 = "\\."
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L13
            java.lang.String r3 = r5.trim()     // Catch: java.lang.Exception -> L65
            int r3 = r3.length()     // Catch: java.lang.Exception -> L65
            if (r3 != 0) goto L11
            goto L13
        L11:
            r3 = r1
            goto L14
        L13:
            r3 = r2
        L14:
            if (r3 != 0) goto L66
            if (r6 == 0) goto L25
            java.lang.String r3 = r6.trim()     // Catch: java.lang.Exception -> L65
            int r3 = r3.length()     // Catch: java.lang.Exception -> L65
            if (r3 != 0) goto L23
            goto L25
        L23:
            r3 = r1
            goto L26
        L25:
            r3 = r2
        L26:
            if (r3 == 0) goto L29
            goto L66
        L29:
            java.lang.String[] r5 = r5.split(r0)     // Catch: java.lang.Exception -> L65
            java.lang.String[] r6 = r6.split(r0)     // Catch: java.lang.Exception -> L65
            r0 = r1
        L32:
            int r3 = r5.length     // Catch: java.lang.Exception -> L65
            if (r0 >= r3) goto L45
            int r3 = r6.length     // Catch: java.lang.Exception -> L65
            if (r0 >= r3) goto L45
            r3 = r5[r0]     // Catch: java.lang.Exception -> L65
            r4 = r6[r0]     // Catch: java.lang.Exception -> L65
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L65
            if (r3 == 0) goto L45
            int r0 = r0 + 1
            goto L32
        L45:
            int r3 = r5.length     // Catch: java.lang.Exception -> L65
            if (r0 >= r3) goto L5f
            int r3 = r6.length     // Catch: java.lang.Exception -> L65
            if (r0 >= r3) goto L5f
            r5 = r5[r0]     // Catch: java.lang.Exception -> L65
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L65
            r6 = r6[r0]     // Catch: java.lang.Exception -> L65
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L65
            int r5 = r5.compareTo(r6)     // Catch: java.lang.Exception -> L65
            if (r5 < 0) goto L5e
            return r2
        L5e:
            return r1
        L5f:
            int r5 = r5.length     // Catch: java.lang.Exception -> L65
            int r6 = r6.length     // Catch: java.lang.Exception -> L65
            if (r5 < r6) goto L64
            return r2
        L64:
            return r1
        L65:
            return r7
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.a(java.lang.String, java.lang.String, boolean):boolean");
    }

    static boolean a(String str, Collection<String> collection) {
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                if (a(str, c(it.next()))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(String str, Pattern pattern) {
        if (pattern != null) {
            try {
                return pattern.matcher(str).find();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean a(String str, boolean z, String... strArr) {
        boolean z2 = false;
        for (String str2 : strArr) {
            z2 = z ? str.equals(str2) : str.contains(str2);
            if (z2) {
                break;
            }
        }
        return z2;
    }

    static boolean a(String str, String... strArr) {
        return a(str, true, strArr);
    }

    static boolean a(String... strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str == null || str.trim().length() == 0) {
                return true;
            }
        }
        return false;
    }

    static int b() {
        try {
            return Resources.getSystem().getDisplayMetrics().heightPixels + (e.a().O <= 0 ? aa.G : 0);
        } catch (Exception unused) {
            return 1;
        }
    }

    static int b(double d) {
        return (int) (d / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d));
    }

    private static int b(Drawable drawable, ar arVar, dg dgVar) {
        float f;
        ColorStateList strokeColor;
        int colorForState;
        try {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) drawable;
            ColorStateList fillColor = materialShapeDrawable.getFillColor();
            r0 = fillColor != null ? fillColor.getDefaultColor() : 0;
            View view = dgVar.F.get();
            if (ag.o(view)) {
                MaterialButton materialButton = (MaterialButton) view;
                int strokeWidth = (int) (materialButton.getStrokeWidth() / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d));
                if (strokeWidth > 0 && (strokeColor = materialButton.getStrokeColor()) != null && (colorForState = strokeColor.getColorForState(new int[]{R.attr.state_enabled}, strokeColor.getDefaultColor())) != 0) {
                    arVar.f65a.append("border").append(":").append(Integer.valueOf(strokeWidth)).append("px solid " + b(colorForState)).append(";");
                }
                f = materialButton.getCornerRadius();
            } else {
                f = 0.0f;
            }
            ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.getShapeAppearanceModel();
            if (f <= 0.0f && shapeAppearanceModel != null) {
                CornerSize bottomLeftCornerSize = shapeAppearanceModel.getBottomLeftCornerSize();
                if (bottomLeftCornerSize instanceof AbsoluteCornerSize) {
                    f = ((AbsoluteCornerSize) bottomLeftCornerSize).getCornerSize();
                } else if (bottomLeftCornerSize instanceof RelativeCornerSize) {
                    f = view.getHeight() * ((RelativeCornerSize) shapeAppearanceModel.getBottomLeftCornerSize()).getRelativePercent();
                }
            }
            if (f > 0.0f) {
                dgVar.t = f;
            }
        } catch (Throwable unused) {
        }
        return r0;
    }

    static Rect b(Drawable drawable) {
        try {
            Drawable c = c(drawable);
            if (!ag.f36a || !(c instanceof InsetDrawable)) {
                return null;
            }
            InsetDrawable insetDrawable = (InsetDrawable) c;
            if (insetDrawable.getDrawable() == null) {
                return null;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            insetDrawable.getPadding(rect);
            insetDrawable.getDrawable().getPadding(rect2);
            rect.set((int) ((rect.left - rect2.left) / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d)), (int) ((rect.top - rect2.top) / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d)), (int) ((rect.right - rect2.right) / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d)), (int) ((rect.bottom - rect2.bottom) / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d)));
            return rect;
        } catch (Exception unused) {
            ag.f36a = false;
            return null;
        }
    }

    static String b(int i) {
        int alpha = Color.alpha(i);
        StringBuilder sb = new StringBuilder(20);
        sb.append(alpha != 255 ? "rgba(" : "rgb(");
        sb.append(Color.red(i)).append(",").append(Color.green(i)).append(",").append(Color.blue(i));
        if (alpha != 255) {
            sb.append(",").append(((int) (alpha / 2.55d)) / 100.0f);
        }
        return sb.append(")").toString();
    }

    static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception unused) {
            return "";
        }
    }

    static <K, V> String b(Map<K, V> map) {
        ArrayList arrayList = new ArrayList();
        try {
            for (K k : map.keySet()) {
                arrayList.add(k + ": " + map.get(k));
            }
        } catch (Exception unused) {
        }
        return TextUtils.join(IOUtils.LINE_SEPARATOR_WINDOWS, arrayList);
    }

    static String b(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile(str2, 2).matcher(str);
            return matcher.find() ? matcher.group(matcher.groupCount()) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    static void b(String str, String str2, Context context) {
        a(str, str2, false, context);
    }

    static boolean b(Rect rect) {
        return rect != null && rect.right == rect.top && rect.top == rect.left && rect.left == rect.bottom;
    }

    static boolean b(View view) {
        return view != null && view.getClass().getName().contains(BuildConfig.LIBRARY_PACKAGE_NAME);
    }

    private static boolean b(Object obj) {
        if (!(obj instanceof Float)) {
            return false;
        }
        float floatValue = ((Float) obj).floatValue();
        return (Float.isNaN(floatValue) || Float.isInfinite(floatValue) || floatValue <= 0.0f) ? false : true;
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    static boolean b(String str, Context context) {
        return context != null && new File(context.getFilesDir(), str).exists();
    }

    static boolean b(String str, String... strArr) {
        return a(str, false, strArr);
    }

    private static int c(Drawable drawable, ar arVar, dg dgVar) {
        Class<?> cls;
        int intValue;
        float f;
        int i = 0;
        try {
            cls = drawable.getClass();
            Object invoke = cls.getDeclaredMethod("getColor", new Class[0]).invoke(drawable, new Object[0]);
            intValue = invoke instanceof Integer ? ((Integer) invoke).intValue() : 0;
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("getFullBorderRadius", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke2 = declaredMethod.invoke(drawable, new Object[0]);
            if (b(invoke2)) {
                dgVar.t = ((Float) invoke2).floatValue();
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("getFullBorderWidth", new Class[0]);
                declaredMethod2.setAccessible(true);
                if (b(declaredMethod2.invoke(drawable, new Object[0]))) {
                    f = (int) (((Float) r3).floatValue() / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0d));
                    if (f == 0.0f) {
                        f = 1.0f;
                    }
                } else {
                    f = 0.0f;
                }
                if (f > 0.0f) {
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod("getBorderColor", Integer.TYPE);
                        declaredMethod3.setAccessible(true);
                        Object invoke3 = declaredMethod3.invoke(drawable, 0);
                        if (invoke3 instanceof Integer) {
                            i = ((Integer) invoke3).intValue();
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
                f = 0.0f;
            }
            if (f <= 0.0f || i == 0) {
                return intValue;
            }
            arVar.f65a.append("border").append(":").append(Float.valueOf(f)).append("px solid " + b(i)).append(";");
            return intValue;
        } catch (Throwable unused4) {
            i = intValue;
            return i;
        }
    }

    static Activity c(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private static Drawable c(Drawable drawable) {
        Drawable current;
        if (drawable instanceof InsetDrawable) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            current = a((LayerDrawable) drawable);
        } else {
            if (!(drawable instanceof StateListDrawable)) {
                return null;
            }
            current = drawable.getCurrent();
        }
        return c(current);
    }

    static String c() {
        Context context = null;
        context = null;
        if (QuantumMetric.b != null) {
            bu buVar = QuantumMetric.b;
            if ((buVar.c != null ? buVar.c.get() : null) != null) {
                bu buVar2 = QuantumMetric.b;
                context = (buVar2.c != null ? buVar2.c.get() : null).getApplicationContext();
            }
        }
        return a(context).replace(" ", "");
    }

    static String c(Context context) {
        try {
            return new StringBuilder().append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    static Pattern c(String str) {
        try {
            return Pattern.compile(str, 2);
        } catch (Exception unused) {
            return null;
        }
    }

    static /* synthetic */ void c(String str, Context context) {
        try {
            context.deleteFile(str);
        } catch (Throwable unused) {
        }
    }

    static void c(String str, String str2) {
        Context f = f();
        if (cl.a()) {
            cl.b(new AnonymousClass1(str, str2, f));
        } else {
            a(str, str2, false, f);
        }
    }

    static String d() {
        try {
            Context context = null;
            context = null;
            if (QuantumMetric.b != null) {
                bu buVar = QuantumMetric.b;
                bu buVar2 = buVar;
                if ((buVar.c != null ? buVar.c.get() : null) != null) {
                    bu buVar3 = QuantumMetric.b;
                    bu buVar4 = buVar3;
                    context = (buVar3.c != null ? buVar3.c.get() : null).getApplicationContext();
                }
            }
            if (context == null) {
                return "";
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str != null ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0016 A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:15:0x0006, B:6:0x0016), top: B:14:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(java.lang.String r2, android.content.Context r3) {
        /*
            java.lang.String r0 = ""
            if (r3 == 0) goto L1f
            if (r2 == 0) goto L13
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Exception -> L1f
            int r1 = r1.length()     // Catch: java.lang.Exception -> L1f
            if (r1 != 0) goto L11
            goto L13
        L11:
            r1 = 0
            goto L14
        L13:
            r1 = 1
        L14:
            if (r1 != 0) goto L1f
            java.io.File r2 = r3.getFileStreamPath(r2)     // Catch: java.lang.Exception -> L1f
            java.lang.String r2 = a(r2)     // Catch: java.lang.Exception -> L1f
            r0 = r2
        L1f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.d(java.lang.String, android.content.Context):java.lang.String");
    }

    static boolean d(View view) {
        Object parent;
        while (view != null) {
            if (!(view.getVisibility() == 0 && view.getAlpha() > 0.0f && view.getWidth() > 0 && view.getHeight() > 0) || (parent = view.getParent()) == null) {
                return false;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return true;
    }

    public static boolean d(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    static View e(View view) {
        if (view == null) {
            return null;
        }
        while (view.getParent() instanceof View) {
            view = (View) view.getParent();
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:2:0x0000, B:4:0x000b, B:9:0x001b, B:10:0x0020, B:12:0x0024, B:15:0x0031, B:16:0x0036), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:2:0x0000, B:4:0x000b, B:9:0x001b, B:10:0x0020, B:12:0x0024, B:15:0x0031, B:16:0x0036), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String e() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> L3d
            r0.<init>()     // Catch: java.lang.Exception -> L3d
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch: java.lang.Exception -> L3d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L3d
            int r1 = r1.length()     // Catch: java.lang.Exception -> L3d
            if (r1 != 0) goto L16
            goto L18
        L16:
            r1 = r2
            goto L19
        L18:
            r1 = r3
        L19:
            if (r1 != 0) goto L20
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch: java.lang.Exception -> L3d
            r0.add(r1)     // Catch: java.lang.Exception -> L3d
        L20:
            java.lang.String r1 = android.os.Build.MODEL     // Catch: java.lang.Exception -> L3d
            if (r1 == 0) goto L2e
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L3d
            int r1 = r1.length()     // Catch: java.lang.Exception -> L3d
            if (r1 != 0) goto L2f
        L2e:
            r2 = r3
        L2f:
            if (r2 != 0) goto L36
            java.lang.String r1 = android.os.Build.MODEL     // Catch: java.lang.Exception -> L3d
            r0.add(r1)     // Catch: java.lang.Exception -> L3d
        L36:
            java.lang.String r1 = " "
            java.lang.String r0 = android.text.TextUtils.join(r1, r0)     // Catch: java.lang.Exception -> L3d
            goto L3f
        L3d:
            java.lang.String r0 = ""
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.e():java.lang.String");
    }

    static String e(Context context) {
        String str;
        boolean z;
        boolean z2 = true;
        try {
            str = d(context);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null && str.trim().length() != 0) {
            z = false;
            if (!z && str.length() > 0 && !d(String.valueOf(str.charAt(0)))) {
                str = b(str, "[0-9.]+");
            }
            if (str != null && str.trim().length() != 0) {
                z2 = false;
            }
            return (!z2 || str.startsWith(".")) ? c(context) : str;
        }
        z = true;
        if (!z) {
            str = b(str, "[0-9.]+");
        }
        if (str != null) {
            z2 = false;
        }
        if (z2) {
        }
    }

    public static boolean e(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    static int f(View view) {
        if (view != null) {
            while (view.getParent() instanceof View) {
                view = (View) view.getParent();
            }
        } else {
            view = null;
        }
        if (view != null) {
            return view.hashCode();
        }
        return -1;
    }

    static Context f() {
        if (QuantumMetric.b != null) {
            bu buVar = QuantumMetric.b;
            if ((buVar.c != null ? buVar.c.get() : null) != null) {
                bu buVar2 = QuantumMetric.b;
                return (buVar2.c != null ? buVar2.c.get() : null).getApplicationContext();
            }
        }
        return null;
    }

    static byte[] f(String str) {
        byte[] bArr = new byte[0];
        try {
            byte[] bytes = str.getBytes("UTF-8");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Deflater deflater = new Deflater(9);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bytes);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return bArr;
        }
    }

    static float g() {
        return (new SecureRandom().nextFloat() * 100.0f) + 0.0f;
    }

    static String g(String str) {
        return d(str, f());
    }

    static boolean g(View view) {
        int[] drawableState;
        if (view == null || (drawableState = view.getDrawableState()) == null) {
            return false;
        }
        for (int i : drawableState) {
            if (i == 16842913) {
                return true;
            }
        }
        return false;
    }

    static float h() {
        return 160.0f / Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    static int h(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if ((parent instanceof ViewGroup) && parent.getParent() != null) {
                return ((ViewGroup) parent).indexOfChild(view);
            }
        }
        return -1;
    }

    static String h(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        String[] split = str.split("[ \n]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i > 0) {
                sb.append(str.charAt(sb.length()));
            }
            char[] cArr = new char[split[i].length()];
            Arrays.fill(cArr, '*');
            sb.append(new String(cArr));
        }
        return sb.toString();
    }

    static int i(String str) {
        if (aa.B) {
            str = str.toLowerCase();
        }
        int length = str.length();
        int min = Math.min(length, 10);
        int i = 7;
        for (int i2 = 0; i2 < min; i2++) {
            i = (i * 31) + str.charAt(i2);
        }
        if (length > 10) {
            i = (i * 31) + str.charAt(length - 1);
        }
        return i * length;
    }

    private static Drawable i(View view) {
        Drawable background = view.getBackground();
        try {
            if (y.k.size() <= 0 || !y.k.contains(view.getClass().getSimpleName())) {
                return background;
            }
            for (Field field : background.getClass().getDeclaredFields()) {
                if (field.getType() == Drawable.class) {
                    field.setAccessible(true);
                    Drawable drawable = (Drawable) field.get(background);
                    return drawable != null ? drawable : background;
                }
            }
            return background;
        } catch (Throwable unused) {
            return background;
        }
    }

    static String i() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    static boolean j() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            Context f = f();
            if (f == null || !a(f, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) f.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return true;
            }
            return activeNetworkInfo.getType() == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0015 A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:16:0x0005, B:5:0x0015, B:6:0x0022, B:8:0x0025), top: B:15:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int[] j(java.lang.String r3) {
        /*
            r0 = 0
            int[] r1 = new int[r0]
            if (r3 == 0) goto L12
            java.lang.String r2 = r3.trim()     // Catch: java.lang.Exception -> L30
            int r2 = r2.length()     // Catch: java.lang.Exception -> L30
            if (r2 != 0) goto L10
            goto L12
        L10:
            r2 = r0
            goto L13
        L12:
            r2 = 1
        L13:
            if (r2 != 0) goto L30
            java.lang.String r2 = "."
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)     // Catch: java.lang.Exception -> L30
            java.lang.String[] r3 = r3.split(r2)     // Catch: java.lang.Exception -> L30
            int r2 = r3.length     // Catch: java.lang.Exception -> L30
            int[] r1 = new int[r2]     // Catch: java.lang.Exception -> L30
        L22:
            int r2 = r3.length     // Catch: java.lang.Exception -> L30
            if (r0 >= r2) goto L30
            r2 = r3[r0]     // Catch: java.lang.Exception -> L30
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L30
            r1[r0] = r2     // Catch: java.lang.Exception -> L30
            int r0 = r0 + 1
            goto L22
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.de.j(java.lang.String):int[]");
    }

    static bu k() {
        return QuantumMetric.b;
    }

    static String k(String str) {
        return ("https://" + c() + "/" + str).replace("!", "");
    }

    static bk l() {
        return QuantumMetric.b.m;
    }

    static String l(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length() - 1;
        return (str.length() > 1 && str.charAt(0) == '[' && str.charAt(length) == ']') ? str.substring(1, length) : str;
    }
}
