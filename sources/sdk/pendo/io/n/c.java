package sdk.pendo.io.n;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.facebook.hermes.intl.Constants;
import java.io.ByteArrayInputStream;
import org.json.JSONObject;
import sdk.pendo.io.g9.p;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public b f1407a;
    public EnumC0200c b;
    public Object c;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1408a;

        static {
            int[] iArr = new int[EnumC0200c.values().length];
            f1408a = iArr;
            try {
                iArr[EnumC0200c.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1408a[EnumC0200c.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1408a[EnumC0200c.DIMEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1408a[EnumC0200c.COLOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1408a[EnumC0200c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1408a[EnumC0200c.BASE64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1408a[EnumC0200c.ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum b {
        NO_VALID,
        ID,
        LAYOUT_WIDTH,
        LAYOUT_HEIGHT,
        PADDING_LEFT,
        PADDING_RIGHT,
        PADDING_TOP,
        PADDING_BOTTOM,
        PADDING,
        INCLUDE_FONT_PADDING,
        LAYOUT_MARGINLEFT,
        LAYOUT_MARGINRIGHT,
        LAYOUT_MARGINTOP,
        LAYOUT_MARGINBOTTOM,
        LAYOUT_MARGIN,
        BACKGROUND,
        ENABLED,
        SELECTED,
        CLICKABLE,
        SCALEX,
        SCALEY,
        LAYOUT_MINWIDTH,
        MINHEIGHT,
        MAXHEIGHT,
        MAXWIDTH,
        ASPECTRATIO,
        TEXT,
        ALTTEXT,
        ACCESSIBILITYTEXT,
        SHOULDIGNOREACCESSIBILITY,
        THEMESTYLE,
        TEXTCOLOR,
        TEXTSIZE,
        FONTSTYLE,
        FONTFAMILY,
        ELLIPSIZE,
        MAXLINES,
        GRAVITY,
        DRAWABLETOP,
        DRAWABLEBOTTOM,
        DRAWABLELEFT,
        DRAWABLERIGHT,
        SRC,
        SCALETYPE,
        ADJUSTVIEWBOUNDS,
        VIDEO_ID,
        VIDEO_URL,
        VIDEO_THUMB_URL,
        VIDEO_TITLE,
        AUTOPLAY,
        VIDEO_PROVIDER,
        IMGWIDTH,
        STEPS,
        HINTLOCATION,
        MINVALUEHINTTEXT,
        MAXVALUEHINTTEXT,
        ICONSIZE,
        SELECTEDICON,
        UNSELECTEDICON,
        SELECTEDICONCOLOR,
        UNSELECTEDICONCOLOR,
        SELECTEDICONSIZE,
        SELECTEDTEXTSIZE,
        SELECTEDTEXTSTYLE,
        SELECTEDTEXTFONTFAMILY,
        PADDING_BETWEEN,
        PADDINGLINES,
        LAYOUT_ABOVE,
        LAYOUT_ALIGNBASELINE,
        LAYOUT_ALIGNBOTTOM,
        LAYOUT_ALIGNEND,
        LAYOUT_ALIGNLEFT,
        LAYOUT_ALIGNPARENTBOTTOM,
        LAYOUT_ALIGNPARENTEND,
        LAYOUT_ALIGNPARENTLEFT,
        LAYOUT_ALIGNPARENTRIGHT,
        LAYOUT_ALIGNPARENTSTART,
        LAYOUT_ALIGNPARENTTOP,
        LAYOUT_ALIGNRIGHT,
        LAYOUT_ALIGNSTART,
        LAYOUT_ALIGNTOP,
        LAYOUT_ALIGNWITHPARENTIFMISSING,
        LAYOUT_BELOW,
        LAYOUT_CENTERHORIZONTAL,
        LAYOUT_CENTERINPARENT,
        LAYOUT_CENTERVERTICAL,
        LAYOUT_TOENDOF,
        LAYOUT_TOLEFTOF,
        LAYOUT_TORIGHTOF,
        LAYOUT_TOSTARTOF,
        LAYOUT_GRAVITY,
        LAYOUT_WEIGHT,
        SUM_WEIGHT,
        WEIGHTSUM,
        ORIENTATION,
        VISIBILITY,
        TAG,
        FUNCTION,
        ACTION,
        ACTIONTYPE,
        ONSUBMIT,
        TEXTDIRECTION,
        BACKGROUNDIMAGEURL,
        BACKGROUNDIMAGEFILLTYPE,
        CHECKED,
        CHECKEDBACKGROUND,
        CHECKEDTEXTCOLOR,
        XCOLOR,
        XWIDTH,
        FRAMECOLOR,
        FRAMEWIDTH,
        SELECTEDFRAMECOLOR,
        SELECTEDFRAMEWIDTH,
        CORNERRADIUS,
        SELECTEDCORNERRADIUS,
        TEXTCOLORNORMAL,
        TEXTCOLORPRESSED,
        TEXTCOLORDISABLED,
        BACKGROUNDCOLORNORMAL,
        BACKGROUNDCOLORPRESSED,
        BACKGROUNDCOLORDISABLED,
        HINT,
        TEXTCOLORHINT,
        INPUTTYPE,
        SINGLELINE,
        VALIDATOR,
        POLLTITLEID,
        POLLID,
        VALUE,
        BUTTON_TYPE,
        HR_COLOR,
        ARIALABEL
    }

    /* renamed from: sdk.pendo.io.n.c$c, reason: collision with other inner class name */
    public enum EnumC0200c {
        NO_VALID,
        STRING,
        DIMEN,
        INTEGER,
        FLOAT,
        ARRAY,
        COLOR,
        REF,
        BOOLEAN,
        BASE64,
        DRAWABLE,
        JSON,
        REGEX
    }

    public c(l lVar) {
        try {
            this.f1407a = g.c(p.a(lVar, "name"));
        } catch (Exception unused) {
            this.f1407a = b.NO_VALID;
        }
        try {
            this.b = g.d(p.a(lVar, "type"));
        } catch (Exception unused2) {
            this.b = EnumC0200c.NO_VALID;
        }
        try {
            this.c = b(lVar.a("value"));
        } catch (Exception e) {
            PendoLogger.e(e, "Dynamic property converting value failure", "jsonObject is: " + lVar);
        }
    }

    private Object b(i iVar) {
        if (iVar == null) {
            return null;
        }
        switch (a.f1408a[this.b.ordinal()]) {
            case 1:
                return Integer.valueOf(iVar.c());
            case 2:
                return Float.valueOf(iVar.b());
            case 3:
                return a(iVar);
            case 4:
                return Integer.valueOf(g.b(iVar.g()));
            case 5:
                String g = iVar.g();
                if (g.equalsIgnoreCase("t")) {
                    return Boolean.TRUE;
                }
                if (g.equalsIgnoreCase("f")) {
                    return Boolean.FALSE;
                }
                if (g.equalsIgnoreCase("true")) {
                    return Boolean.TRUE;
                }
                if (g.equalsIgnoreCase(Constants.CASEFIRST_FALSE)) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(Integer.parseInt(g) == 1);
            case 6:
                try {
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(iVar.g(), 0)));
                } catch (Exception unused) {
                    return null;
                }
            case 7:
                try {
                    float[] fArr = new float[8];
                    sdk.pendo.io.k0.f d = iVar.d();
                    if (d != null) {
                        for (int i = 0; i < d.size(); i++) {
                            fArr[i] = d.a(i).b();
                        }
                    }
                    return fArr;
                } catch (Exception unused2) {
                    return null;
                }
            default:
                return iVar;
        }
    }

    public Object a(i iVar) {
        String g = iVar.g();
        if (g.equals("auto")) {
            return null;
        }
        b bVar = this.f1407a;
        if (bVar != null) {
            if (bVar.equals(b.IMGWIDTH) && g.endsWith("%")) {
                return g;
            }
            if ((this.f1407a.equals(b.TEXTSIZE) || this.f1407a.equals(b.SELECTEDTEXTSIZE)) && g.endsWith("dp")) {
                return Float.valueOf(g.replace("dp", ""));
            }
        }
        return Float.valueOf(a(g));
    }

    Boolean c() {
        return (Boolean) this.c;
    }

    public int d() {
        if (this.b == EnumC0200c.COLOR) {
            return ((Integer) this.c).intValue();
        }
        return -1;
    }

    float e() {
        return ((Float) this.c).floatValue();
    }

    float[] f() {
        return (float[]) this.c;
    }

    Drawable g() {
        return (Drawable) this.c;
    }

    public int h() {
        Object obj = this.c;
        if (!(obj instanceof Integer) && (obj instanceof Float)) {
            return (int) e();
        }
        return ((Integer) obj).intValue();
    }

    JSONObject i() {
        return (JSONObject) this.c;
    }

    public String j() {
        Object obj = this.c;
        return obj instanceof String ? (String) obj : ((i) obj).g();
    }

    public boolean k() {
        Object obj = this.c;
        return (obj instanceof String) && ((String) obj).endsWith("%");
    }

    public boolean l() {
        return this.c != null;
    }

    public float a(String str) {
        if (str.endsWith("dp")) {
            return sdk.pendo.io.n.a.a(Float.parseFloat(str.replace("dp", "")));
        }
        if (str.endsWith("sp")) {
            return sdk.pendo.io.n.a.b(Float.parseFloat(str.replace("sp", "")));
        }
        if (str.endsWith("px")) {
            return Integer.parseInt(str.replace("px", ""));
        }
        if (str.endsWith("%")) {
            return (int) ((Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f) * sdk.pendo.io.n.a.a());
        }
        if (str.equalsIgnoreCase("match_parent")) {
            return -1.0f;
        }
        if (str.equalsIgnoreCase("wrap_content")) {
            return -2.0f;
        }
        return str.contains(".") ? Float.parseFloat(str) : Integer.parseInt(str);
    }

    Drawable b() {
        return new BitmapDrawable(Resources.getSystem(), a());
    }

    Bitmap a() {
        return (Bitmap) this.c;
    }

    Object a(Class cls, String str) {
        try {
            return cls.getField(str).get(cls);
        } catch (Exception e) {
            String message = e.getMessage();
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder("var name ");
            if (str == null) {
                str = "no var name";
            }
            objArr[0] = sb.append(str).append(" class: ").append(cls != null ? cls.getCanonicalName() : "null").toString();
            PendoLogger.e(e, message, objArr);
            return null;
        }
    }
}
