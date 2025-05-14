package sdk.pendo.io.n;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.facebook.react.uimanager.ViewProps;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.protocol.SentryStackFrame;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.g9.g0;
import sdk.pendo.io.g9.j;
import sdk.pendo.io.g9.j0;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.PersonalizationDefVal;
import sdk.pendo.io.n.c;
import sdk.pendo.io.views.custom.ActionableBlock;
import sdk.pendo.io.views.custom.IBackgroundRenderView;
import sdk.pendo.io.views.custom.PendoAbstractRadioButton;
import sdk.pendo.io.views.custom.PendoCheckableCustomView;
import sdk.pendo.io.views.custom.PendoCircularCloseButton;
import sdk.pendo.io.views.custom.PendoCustomView;
import sdk.pendo.io.views.custom.PendoLinearLayout;
import sdk.pendo.io.views.custom.PendoMultipleRowViewGroup;
import sdk.pendo.io.views.custom.PendoRegularRadioButton;
import sdk.pendo.io.views.custom.PendoScrollView;
import sdk.pendo.io.views.custom.VisualActionButton;
import sdk.pendo.io.views.custom.VisualActionImage;
import sdk.pendo.io.views.custom.videoplayer.VideoPlayerView;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: sdk.pendo.io.n.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0199a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1405a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[c.EnumC0200c.values().length];
            b = iArr;
            try {
                iArr[c.EnumC0200c.DIMEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[c.EnumC0200c.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[c.EnumC0200c.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[c.EnumC0200c.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[c.EnumC0200c.COLOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[c.EnumC0200c.REF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[c.EnumC0200c.BASE64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[c.EnumC0200c.DRAWABLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[c.b.values().length];
            f1405a = iArr2;
            try {
                iArr2[c.b.ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1405a[c.b.POLLID.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1405a[c.b.TAG.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1405a[c.b.VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1405a[c.b.HR_COLOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1405a[c.b.BACKGROUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1405a[c.b.TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1405a[c.b.TEXTCOLOR.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1405a[c.b.TEXTSIZE.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1405a[c.b.ALTTEXT.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f1405a[c.b.ACCESSIBILITYTEXT.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f1405a[c.b.SHOULDIGNOREACCESSIBILITY.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f1405a[c.b.THEMESTYLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f1405a[c.b.SELECTEDTEXTSIZE.ordinal()] = 14;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f1405a[c.b.FONTSTYLE.ordinal()] = 15;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f1405a[c.b.PADDING.ordinal()] = 16;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f1405a[c.b.PADDING_LEFT.ordinal()] = 17;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f1405a[c.b.PADDING_TOP.ordinal()] = 18;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f1405a[c.b.PADDING_RIGHT.ordinal()] = 19;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f1405a[c.b.PADDING_BOTTOM.ordinal()] = 20;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f1405a[c.b.INCLUDE_FONT_PADDING.ordinal()] = 21;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f1405a[c.b.LAYOUT_MINWIDTH.ordinal()] = 22;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f1405a[c.b.ELLIPSIZE.ordinal()] = 23;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f1405a[c.b.MAXLINES.ordinal()] = 24;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f1405a[c.b.ORIENTATION.ordinal()] = 25;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f1405a[c.b.SUM_WEIGHT.ordinal()] = 26;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f1405a[c.b.WEIGHTSUM.ordinal()] = 27;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f1405a[c.b.GRAVITY.ordinal()] = 28;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f1405a[c.b.FONTFAMILY.ordinal()] = 29;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f1405a[c.b.SRC.ordinal()] = 30;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f1405a[c.b.SCALETYPE.ordinal()] = 31;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f1405a[c.b.ADJUSTVIEWBOUNDS.ordinal()] = 32;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f1405a[c.b.DRAWABLELEFT.ordinal()] = 33;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f1405a[c.b.DRAWABLETOP.ordinal()] = 34;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f1405a[c.b.DRAWABLERIGHT.ordinal()] = 35;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f1405a[c.b.DRAWABLEBOTTOM.ordinal()] = 36;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f1405a[c.b.ENABLED.ordinal()] = 37;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f1405a[c.b.SELECTED.ordinal()] = 38;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f1405a[c.b.CLICKABLE.ordinal()] = 39;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f1405a[c.b.SCALEX.ordinal()] = 40;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f1405a[c.b.SCALEY.ordinal()] = 41;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f1405a[c.b.FUNCTION.ordinal()] = 42;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f1405a[c.b.VISIBILITY.ordinal()] = 43;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f1405a[c.b.ONSUBMIT.ordinal()] = 44;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f1405a[c.b.XCOLOR.ordinal()] = 45;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f1405a[c.b.XWIDTH.ordinal()] = 46;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f1405a[c.b.FRAMECOLOR.ordinal()] = 47;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f1405a[c.b.FRAMEWIDTH.ordinal()] = 48;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f1405a[c.b.SELECTEDFRAMECOLOR.ordinal()] = 49;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f1405a[c.b.SELECTEDFRAMEWIDTH.ordinal()] = 50;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f1405a[c.b.TEXTDIRECTION.ordinal()] = 51;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f1405a[c.b.CHECKED.ordinal()] = 52;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f1405a[c.b.CHECKEDBACKGROUND.ordinal()] = 53;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f1405a[c.b.CHECKEDTEXTCOLOR.ordinal()] = 54;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f1405a[c.b.BACKGROUNDIMAGEURL.ordinal()] = 55;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f1405a[c.b.BACKGROUNDIMAGEFILLTYPE.ordinal()] = 56;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f1405a[c.b.HINT.ordinal()] = 57;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f1405a[c.b.VALIDATOR.ordinal()] = 58;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f1405a[c.b.TEXTCOLORHINT.ordinal()] = 59;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f1405a[c.b.SINGLELINE.ordinal()] = 60;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f1405a[c.b.INPUTTYPE.ordinal()] = 61;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f1405a[c.b.CORNERRADIUS.ordinal()] = 62;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f1405a[c.b.SELECTEDCORNERRADIUS.ordinal()] = 63;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f1405a[c.b.TEXTCOLORNORMAL.ordinal()] = 64;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f1405a[c.b.TEXTCOLORPRESSED.ordinal()] = 65;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f1405a[c.b.TEXTCOLORDISABLED.ordinal()] = 66;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f1405a[c.b.BACKGROUNDCOLORNORMAL.ordinal()] = 67;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f1405a[c.b.BACKGROUNDCOLORPRESSED.ordinal()] = 68;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f1405a[c.b.BACKGROUNDCOLORDISABLED.ordinal()] = 69;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f1405a[c.b.ICONSIZE.ordinal()] = 70;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f1405a[c.b.SELECTEDICONSIZE.ordinal()] = 71;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f1405a[c.b.SELECTEDICON.ordinal()] = 72;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f1405a[c.b.UNSELECTEDICON.ordinal()] = 73;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f1405a[c.b.SELECTEDICONCOLOR.ordinal()] = 74;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f1405a[c.b.UNSELECTEDICONCOLOR.ordinal()] = 75;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f1405a[c.b.PADDING_BETWEEN.ordinal()] = 76;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f1405a[c.b.PADDINGLINES.ordinal()] = 77;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f1405a[c.b.ASPECTRATIO.ordinal()] = 78;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f1405a[c.b.VIDEO_URL.ordinal()] = 79;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f1405a[c.b.VIDEO_ID.ordinal()] = 80;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                f1405a[c.b.AUTOPLAY.ordinal()] = 81;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                f1405a[c.b.IMGWIDTH.ordinal()] = 82;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f1405a[c.b.ARIALABEL.ordinal()] = 83;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f1405a[c.b.LAYOUT_HEIGHT.ordinal()] = 84;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f1405a[c.b.LAYOUT_WIDTH.ordinal()] = 85;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f1405a[c.b.MAXWIDTH.ordinal()] = 86;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f1405a[c.b.MINHEIGHT.ordinal()] = 87;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f1405a[c.b.LAYOUT_MARGIN.ordinal()] = 88;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f1405a[c.b.LAYOUT_MARGINLEFT.ordinal()] = 89;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f1405a[c.b.LAYOUT_MARGINTOP.ordinal()] = 90;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f1405a[c.b.LAYOUT_MARGINRIGHT.ordinal()] = 91;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                f1405a[c.b.LAYOUT_MARGINBOTTOM.ordinal()] = 92;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                f1405a[c.b.LAYOUT_ABOVE.ordinal()] = 93;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                f1405a[c.b.LAYOUT_BELOW.ordinal()] = 94;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                f1405a[c.b.LAYOUT_TOLEFTOF.ordinal()] = 95;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                f1405a[c.b.LAYOUT_TORIGHTOF.ordinal()] = 96;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                f1405a[c.b.LAYOUT_TOSTARTOF.ordinal()] = 97;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                f1405a[c.b.LAYOUT_TOENDOF.ordinal()] = 98;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNBASELINE.ordinal()] = 99;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNLEFT.ordinal()] = 100;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNTOP.ordinal()] = 101;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNRIGHT.ordinal()] = 102;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNBOTTOM.ordinal()] = 103;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNSTART.ordinal()] = 104;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNEND.ordinal()] = 105;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNWITHPARENTIFMISSING.ordinal()] = 106;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNPARENTTOP.ordinal()] = 107;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNPARENTBOTTOM.ordinal()] = 108;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNPARENTLEFT.ordinal()] = 109;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNPARENTRIGHT.ordinal()] = 110;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNPARENTSTART.ordinal()] = 111;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                f1405a[c.b.LAYOUT_ALIGNPARENTEND.ordinal()] = 112;
            } catch (NoSuchFieldError unused120) {
            }
            try {
                f1405a[c.b.LAYOUT_CENTERHORIZONTAL.ordinal()] = 113;
            } catch (NoSuchFieldError unused121) {
            }
            try {
                f1405a[c.b.LAYOUT_CENTERVERTICAL.ordinal()] = 114;
            } catch (NoSuchFieldError unused122) {
            }
            try {
                f1405a[c.b.LAYOUT_CENTERINPARENT.ordinal()] = 115;
            } catch (NoSuchFieldError unused123) {
            }
            try {
                f1405a[c.b.LAYOUT_GRAVITY.ordinal()] = 116;
            } catch (NoSuchFieldError unused124) {
            }
            try {
                f1405a[c.b.LAYOUT_WEIGHT.ordinal()] = 117;
            } catch (NoSuchFieldError unused125) {
            }
        }
    }

    private static void A(View view, c cVar) {
        if ((view instanceof TextView) && c.EnumC0200c.BOOLEAN == cVar.b) {
            ((TextView) view).setIncludeFontPadding(cVar.c().booleanValue());
        }
    }

    private static void B(View view, c cVar) {
        if (view instanceof EditText) {
            ((EditText) view).setInputType(a(cVar.j()));
        }
    }

    private static void C(View view, c cVar) {
        if (view instanceof TextView) {
            ((TextView) view).setMaxLines(cVar.h());
        }
    }

    private static void D(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0200c.DIMEN) {
            return;
        }
        view.setMinimumHeight(cVar.h());
    }

    private static void E(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0200c.DIMEN) {
            return;
        }
        view.setMinimumWidth(cVar.h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void F(View view, c cVar) {
        if ((view instanceof ActionableBlock) && cVar.b.equals(c.EnumC0200c.STRING)) {
            ((ActionableBlock) view).setOnSubmit(cVar.j());
        }
    }

    private static void G(View view, c cVar) {
        if (view instanceof LinearLayout) {
            int i = C0199a.b[cVar.b.ordinal()];
            if (i == 3) {
                ((LinearLayout) view).setOrientation(cVar.h() == 0 ? 0 : 1);
            } else {
                if (i != 4) {
                    return;
                }
                ((LinearLayout) view).setOrientation(!cVar.j().equalsIgnoreCase("HORIZONTAL") ? 1 : 0);
            }
        }
    }

    private static void H(View view, c cVar) {
        if (view == null || (view instanceof ScrollView) || cVar.b != c.EnumC0200c.DIMEN) {
            return;
        }
        int h = cVar.h();
        view.setPadding(h, h, h, h);
    }

    private static void I(View view, c cVar) {
        if (cVar.b == c.EnumC0200c.DIMEN) {
            if (view instanceof PendoRegularRadioButton) {
                ((PendoRegularRadioButton) view).setPaddingBetween(cVar.h());
            } else if (view instanceof PendoMultipleRowViewGroup) {
                ((PendoMultipleRowViewGroup) view).setPaddingBetween(cVar.h());
            }
        }
    }

    private static void J(View view, c cVar) {
        if ((view instanceof PendoMultipleRowViewGroup) && cVar.b == c.EnumC0200c.DIMEN) {
            ((PendoMultipleRowViewGroup) view).setPaddingLines(cVar.h());
        }
    }

    private static void K(View view, c cVar) {
        if ((view instanceof ImageView) && cVar.b == c.EnumC0200c.STRING) {
            ((ImageView) view).setScaleType(ImageView.ScaleType.valueOf(cVar.j().toUpperCase(Locale.US)));
        }
    }

    private static void L(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0200c.BOOLEAN) {
            return;
        }
        view.setScaleX(cVar.e());
    }

    private static void M(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0200c.BOOLEAN) {
            return;
        }
        view.setScaleY(cVar.e());
    }

    private static void N(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0200c.BOOLEAN) {
            return;
        }
        view.setSelected(cVar.c().booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void O(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0200c.DIMEN) {
            ((PendoCheckableCustomView) view).setSelectedCornerRadius(cVar.e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void P(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.COLOR) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setSelectedStrokeColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void Q(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.DIMEN) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setSelectedStrokeWidth(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void R(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0200c.STRING) {
            ((PendoCheckableCustomView) view).setSelectedIcon(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void S(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0200c.COLOR) {
            ((PendoCheckableCustomView) view).setSelectedIconColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void T(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0200c.DIMEN) {
            ((PendoCheckableCustomView) view).setSelectedIconSize(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void U(View view, c cVar) {
        if (cVar.b == c.EnumC0200c.DIMEN && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setSelectedTextSize(cVar.e());
        }
    }

    private static void V(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.BOOLEAN) && cVar.c().booleanValue()) {
            view.setImportantForAccessibility(2);
        }
    }

    private static void W(View view, c cVar) {
        if (view instanceof EditText) {
            ((EditText) view).setSingleLine(cVar.c().booleanValue());
        }
    }

    private static void X(View view, c cVar) {
        if ((view instanceof VisualActionImage) && cVar.b.equals(c.EnumC0200c.STRING)) {
            ((VisualActionImage) view).setResourceURL(cVar.j());
            return;
        }
        if (view instanceof ImageView) {
            int i = C0199a.b[cVar.b.ordinal()];
            if (i == 6) {
                ((ImageView) view).setImageResource(a(view.getContext(), cVar.j()));
            } else {
                if (i != 7) {
                    return;
                }
                ((ImageView) view).setImageBitmap(cVar.a());
            }
        }
    }

    private static void Y(View view, c cVar) {
        view.setTag(cVar.j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void Z(View view, c cVar) {
        if (cVar.b == c.EnumC0200c.COLOR) {
            int d = cVar.d();
            if (view instanceof PendoCheckableCustomView) {
                ((PendoCheckableCustomView) view).setDefaultTextColor(d);
            } else if (view instanceof TextView) {
                ((TextView) view).setTextColor(d);
            }
        }
    }

    private static void a(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.STRING)) {
            String str = null;
            try {
                try {
                    str = cVar.j();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                } catch (Exception e) {
                    PendoLogger.d(e);
                    if (TextUtils.isEmpty(null)) {
                        return;
                    }
                }
                view.setContentDescription(str);
            } catch (Throwable th) {
                if (!TextUtils.isEmpty(null)) {
                    view.setContentDescription(null);
                }
                throw th;
            }
        }
    }

    private static void a0(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((VisualActionButton) view).setDisabledTextColor(cVar.d());
        }
    }

    private static void b(View view, c cVar) {
        try {
            if ("title".equalsIgnoreCase(cVar.j())) {
                ViewCompat.setAccessibilityHeading(view, true);
            }
        } catch (Exception e) {
            PendoLogger.d(e, "%s: applyAccessibilityHeading", "DynamicHelper");
        }
    }

    private static void b0(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((VisualActionButton) view).setNormalTextColor(cVar.d());
        }
    }

    private static void c(View view, c cVar) {
        if ((view instanceof ImageView) && cVar.b == c.EnumC0200c.BOOLEAN) {
            ((ImageView) view).setAdjustViewBounds(cVar.c().booleanValue());
        }
    }

    private static void c0(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((VisualActionButton) view).setPressedTextColor(cVar.d());
        }
    }

    public static void d(View view, c cVar) {
        if (view instanceof ViewGroup) {
            try {
                String j = cVar.b.equals(c.EnumC0200c.STRING) ? cVar.j() : null;
                if (j0.a(j)) {
                    PendoLogger.d("DynamicHelper applyAriaLabel value is empty or null", new Object[0]);
                    return;
                }
                Context context = view.getContext();
                if (context instanceof PendoGuideVisualActivity) {
                    ((PendoGuideVisualActivity) context).setTitle(j);
                } else {
                    ViewCompat.setAccessibilityPaneTitle(view, j);
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
            } catch (Exception e) {
                PendoLogger.d(e, "%s applyAriaLabel Message: %s", "DynamicHelper", e.getMessage());
            }
        }
    }

    private static void d0(View view, c cVar) {
        if (!"rtl".equals(cVar.j())) {
            view.setLayoutDirection(0);
            return;
        }
        if (view instanceof PendoRegularRadioButton) {
            ((PendoRegularRadioButton) view).setRtl(true);
        }
        view.setLayoutDirection(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void e(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0200c.STRING) {
            ((VideoPlayerView) view).setAspectRatio(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void e0(View view, c cVar) {
        if (cVar.b == c.EnumC0200c.DIMEN) {
            if (view instanceof PendoCheckableCustomView) {
                ((PendoCheckableCustomView) view).setDefaultTextSize(cVar.e());
            } else if (view instanceof TextView) {
                ((TextView) view).setTextSize(2, cVar.e());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void f(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0200c.BOOLEAN) {
            ((VideoPlayerView) view).setAutoPlay(cVar.c().booleanValue());
        }
    }

    private static void f0(View view, c cVar) {
        TextView textView;
        int h;
        if (view instanceof TextView) {
            int i = C0199a.b[cVar.b.ordinal()];
            if (i == 3) {
                textView = (TextView) view;
                h = cVar.h();
            } else {
                if (i != 4) {
                    return;
                }
                String j = cVar.j();
                textView = (TextView) view;
                if ("bold".equals(j)) {
                    h = 1;
                } else {
                    if (!"italic".equals(j)) {
                        if ("bold_italic".equals(j)) {
                            textView.setTypeface(null, 3);
                            return;
                        } else {
                            if ("underline".equals(j)) {
                                textView.setPaintFlags(textView.getPaintFlags() | 8);
                                return;
                            }
                            return;
                        }
                    }
                    h = 2;
                }
            }
            textView.setTypeface(null, h);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void g(View view, c cVar) {
        Drawable b;
        if (view != 0) {
            int i = C0199a.b[cVar.b.ordinal()];
            if (i == 5) {
                int d = cVar.d();
                if (view instanceof PendoCircularCloseButton) {
                    ((PendoCircularCloseButton) view).setCircleColor(d);
                    return;
                } else if (view instanceof PendoCheckableCustomView) {
                    ((PendoCheckableCustomView) view).setDefaultBackgroundColor(d);
                    return;
                } else {
                    view.setBackgroundColor(d);
                    return;
                }
            }
            if (i == 6) {
                view.setBackgroundResource(a(view.getContext(), cVar.j()));
                return;
            }
            if (i == 7) {
                b = cVar.b();
            } else if (i != 8) {
                return;
            } else {
                b = cVar.g();
            }
            view.setBackground(b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void g0(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0200c.STRING) {
            ((PendoCheckableCustomView) view).setUnselectedIcon(cVar.j());
        }
    }

    private static void h(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((VisualActionButton) view).setDisabledBackgroundColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void h0(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0200c.COLOR) {
            ((PendoCheckableCustomView) view).setUnselectedIconColor(cVar.d());
        }
    }

    private static void i(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((VisualActionButton) view).setNormalBackgroundColor(cVar.d());
        }
    }

    private static void i0(View view, c cVar) {
    }

    private static void j(View view, c cVar) {
        if ((view instanceof VisualActionButton) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((VisualActionButton) view).setPressedBackgroundColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void j0(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0200c.STRING) {
            ((VideoPlayerView) view).setVideoId(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void k(View view, c cVar) {
        if (view instanceof IBackgroundRenderView) {
            ((IBackgroundRenderView) view).setImageBackgroundURL(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void k0(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0200c.STRING) {
            ((VideoPlayerView) view).setVideoUrl(cVar.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void l(View view, c cVar) {
        if (view instanceof IBackgroundRenderView) {
            ((IBackgroundRenderView) view).setImageFillType(cVar.j());
        }
    }

    private static void l0(View view, c cVar) {
        int i;
        String j = cVar.j();
        if (j == null) {
            return;
        }
        if (j.equalsIgnoreCase("removed") || j.equalsIgnoreCase("gone")) {
            i = 8;
        } else if (j.equals(ViewProps.HIDDEN)) {
            i = 4;
        } else if (!j.equals(ViewProps.VISIBLE)) {
            return;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void m(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.COLOR) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setCheckedBackgroundColor(cVar.d());
        }
    }

    private static void m0(View view, c cVar) {
        if ((view instanceof LinearLayout) && cVar.b == c.EnumC0200c.FLOAT) {
            ((LinearLayout) view).setWeightSum(cVar.e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void n(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.COLOR) && (view instanceof PendoCheckableCustomView)) {
            ((PendoCheckableCustomView) view).setCheckedTextColor(cVar.d());
        }
    }

    private static void n0(View view, c cVar) {
        if ((view instanceof PendoCircularCloseButton) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((PendoCircularCloseButton) view).setXColor(cVar.d());
        }
    }

    private static void o(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0200c.BOOLEAN) {
            return;
        }
        view.setClickable(cVar.c().booleanValue());
    }

    private static void o0(View view, c cVar) {
        if ((view instanceof PendoCircularCloseButton) && cVar.b.equals(c.EnumC0200c.DIMEN)) {
            ((PendoCircularCloseButton) view).setXWidth(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void p(View view, c cVar) {
        if (view instanceof PendoCustomView) {
            int i = C0199a.b[cVar.b.ordinal()];
            if (i == 1) {
                ((PendoCustomView) view).setCornerRadius(cVar.e());
            } else {
                if (i != 2) {
                    return;
                }
                ((PendoCustomView) view).setCornerRadii(cVar.f());
            }
        }
    }

    private static void q(View view, c cVar) {
        if (view instanceof TextView) {
            ((TextView) view).setEllipsize(TextUtils.TruncateAt.valueOf(cVar.j().toUpperCase(Locale.US).trim()));
        }
    }

    private static void r(View view, c cVar) {
        if (view == null || cVar.b != c.EnumC0200c.BOOLEAN) {
            return;
        }
        view.setEnabled(cVar.c().booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void s(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.COLOR) && (view instanceof PendoCustomView)) {
            ((PendoCustomView) view).setStrokeColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void t(View view, c cVar) {
        if (cVar.b.equals(c.EnumC0200c.DIMEN) && (view instanceof PendoCustomView)) {
            ((PendoCustomView) view).setStrokeWidth(cVar.h());
        }
    }

    private static void u(View view, c cVar) {
        Class<?>[] clsArr;
        Object[] array;
        if (cVar.b != c.EnumC0200c.JSON) {
            return;
        }
        try {
            JSONObject i = cVar.i();
            String string = i.getString(SentryStackFrame.JsonKeys.FUNCTION);
            JSONArray jSONArray = i.getJSONArray("args");
            try {
                if (jSONArray != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            boolean has = jSONObject.has("primitive");
                            String string2 = jSONObject.getString(has ? "primitive" : "class");
                            if (!string2.contains(".")) {
                                string2 = "java.lang." + string2;
                            }
                            Class<?> cls = Class.forName(string2);
                            if (has) {
                                arrayList.add((Class) cls.getField(CredentialProviderBaseController.TYPE_TAG).get(null));
                            } else {
                                arrayList.add(cls);
                            }
                            try {
                                arrayList2.add(a(jSONObject, "value", cls));
                            } catch (Exception e) {
                                PendoLogger.e(e, e.getMessage(), "class: " + cls.getCanonicalName());
                            }
                        }
                        clsArr = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
                        array = arrayList2.toArray(new Object[arrayList2.size()]);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused) {
                    }
                    view.getClass().getMethod(string, clsArr).invoke(view, array);
                    return;
                }
                view.getClass().getMethod(string, clsArr).invoke(view, array);
                return;
            } catch (NoSuchMethodException e3) {
                PendoLogger.e(e3, e3.getMessage(), new Object[0]);
                return;
            } catch (SecurityException e4) {
                PendoLogger.e(e4, e4.getMessage(), new Object[0]);
                return;
            }
            clsArr = new Class[0];
            array = new Object[0];
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception e6) {
            PendoLogger.e(e6, e6.getMessage(), new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r0 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        ((android.widget.RelativeLayout) r3).setGravity(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        r3 = (android.widget.TextView) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if (r0 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void v(android.view.View r3, sdk.pendo.io.n.c r4) {
        /*
            boolean r0 = r3 instanceof android.widget.TextView
            if (r0 != 0) goto Lc
            boolean r1 = r3 instanceof android.widget.LinearLayout
            if (r1 != 0) goto Lc
            boolean r1 = r3 instanceof android.widget.RelativeLayout
            if (r1 == 0) goto L5a
        Lc:
            int[] r1 = sdk.pendo.io.n.a.C0199a.b
            sdk.pendo.io.n.c$c r2 = r4.b
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 3
            if (r1 == r2) goto L36
            r2 = 4
            if (r1 == r2) goto L1d
            goto L5a
        L1d:
            java.lang.String r1 = r4.j()
            java.lang.Integer r4 = a(r4, r1)
            int r4 = r4.intValue()
            boolean r1 = r3 instanceof sdk.pendo.io.views.custom.PendoAbstractRadioButton
            if (r1 == 0) goto L2e
            goto L3e
        L2e:
            boolean r1 = r3 instanceof android.widget.LinearLayout
            if (r1 == 0) goto L33
            goto L4a
        L33:
            if (r0 == 0) goto L55
            goto L52
        L36:
            int r4 = r4.h()
            boolean r1 = r3 instanceof sdk.pendo.io.views.custom.PendoAbstractRadioButton
            if (r1 == 0) goto L46
        L3e:
            sdk.pendo.io.views.custom.PendoAbstractRadioButton r3 = (sdk.pendo.io.views.custom.PendoAbstractRadioButton) r3
            r4 = r4 | 16
        L42:
            r3.setGravity(r4)
            goto L5a
        L46:
            boolean r1 = r3 instanceof android.widget.LinearLayout
            if (r1 == 0) goto L50
        L4a:
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.setGravity(r4)
            goto L5a
        L50:
            if (r0 == 0) goto L55
        L52:
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L42
        L55:
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.setGravity(r4)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.n.a.v(android.view.View, sdk.pendo.io.n.c):void");
    }

    private static void w(View view, c cVar) {
        if (view instanceof EditText) {
            ((EditText) view).setHint(cVar.j());
        }
    }

    private static void x(View view, c cVar) {
        if ((view instanceof EditText) && cVar.b.equals(c.EnumC0200c.COLOR)) {
            ((EditText) view).setHintTextColor(cVar.d());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void y(View view, c cVar) {
        if ((view instanceof PendoCheckableCustomView) && cVar.b == c.EnumC0200c.DIMEN) {
            ((PendoCheckableCustomView) view).setIconSize(cVar.h());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void z(View view, c cVar) {
        if ((view instanceof VideoPlayerView) && cVar.b == c.EnumC0200c.DIMEN && cVar.k()) {
            String replace = cVar.j().replace("%", "");
            try {
                ((VideoPlayerView) view).setImageWidthInPercents(Integer.parseInt(replace));
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "applyImageWidth with " + replace);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, Map<String, c> map) {
        for (c cVar : map.values()) {
            int i = C0199a.f1405a[cVar.f1407a.ordinal()];
            if (i == 2 || i == 3) {
                Y(view, cVar);
            } else if (i == 6) {
                g(view, cVar);
            } else if (i == 22) {
                E(view, cVar);
            } else if (i == 62) {
                p(view, cVar);
            } else if (i == 10 || i == 11) {
                a(view, cVar);
            } else if (i == 31) {
                K(view, cVar);
            } else if (i == 32) {
                c(view, cVar);
            } else if (i == 47) {
                s(view, cVar);
            } else if (i == 48) {
                t(view, cVar);
            } else if (i == 55) {
                k(view, cVar);
            } else if (i != 56) {
                switch (i) {
                    case 25:
                        G(view, cVar);
                        break;
                    case 26:
                    case 27:
                        m0(view, cVar);
                        break;
                }
            } else {
                l(view, cVar);
            }
        }
        if (view instanceof PendoCustomView) {
            ((PendoCustomView) view).renderView();
        }
    }

    private static void b(View view, c cVar, int i) {
        if (view == null || (view instanceof ScrollView) || cVar.b != c.EnumC0200c.DIMEN) {
            return;
        }
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        iArr[i] = cVar.h();
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    private static void a(View view, c cVar, boolean z) {
        if ((view instanceof CompoundButton) && cVar.b == c.EnumC0200c.BOOLEAN) {
            if ((view instanceof RadioButton) && z) {
                view.setId(View.generateViewId());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("elementType", "RadioButton");
                    jSONObject.put("error", "No ID for RadioButton!");
                } catch (JSONException unused) {
                }
                sdk.pendo.io.g9.d.a(d.b.ERROR_REASON_CONFIGURATION, jSONObject);
            }
            ((CompoundButton) view).setChecked(cVar.c().booleanValue());
        }
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void a(View view, c cVar, int i) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            int i2 = C0199a.b[cVar.b.ordinal()];
            if (i2 == 6) {
                try {
                    compoundDrawables[i] = view.getContext().getResources().getDrawable(a(view.getContext(), cVar.j()));
                } catch (Exception unused) {
                }
            } else if (i2 == 7) {
                compoundDrawables[i] = cVar.b();
            } else if (i2 == 8) {
                compoundDrawables[i] = cVar.g();
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    private static int b(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    private static void a(View view, c cVar, c cVar2) {
        c.EnumC0200c enumC0200c;
        String j = cVar.j();
        if ((view instanceof TextView) && (enumC0200c = cVar.b) != null && enumC0200c.equals(c.EnumC0200c.STRING)) {
            try {
                if (m0.d(j)) {
                    JSONArray jSONArray = new JSONArray(j);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (j.a(jSONArray.get(i).toString(), (TextView) view).booleanValue()) {
                            return;
                        }
                    }
                } else if (!m0.e(j) && j.a(j, (TextView) view).booleanValue()) {
                    return;
                }
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), "font family: " + j);
            }
            j.a(j, cVar2, (TextView) view);
        }
    }

    public static float b(float f) {
        return TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics());
    }

    static void a(View view, Map<String, c> map, ViewGroup viewGroup, HashMap<String, Integer> hashMap) {
        int i;
        RelativeLayout.LayoutParams layoutParams;
        int intValue;
        RadioGroup.LayoutParams layoutParams2;
        int intValue2;
        if (viewGroup == null) {
            return;
        }
        boolean z = viewGroup instanceof ScrollView;
        ViewGroup.LayoutParams a2 = a(viewGroup);
        for (c cVar : map.values()) {
            try {
                i = 4;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
            switch (C0199a.f1405a[cVar.f1407a.ordinal()]) {
                case 84:
                    c cVar2 = map.get(c.b.MAXHEIGHT.name());
                    a2.height = a(cVar.h(), cVar2 != null ? cVar2.h() : 0);
                case 85:
                    a2.width = cVar.h();
                case 86:
                    a(view, z, cVar);
                case 87:
                    D(view, cVar);
                case 88:
                    a(a2, z, cVar);
                case 89:
                    a(a2, z, cVar, 0);
                case 90:
                    a(a2, z, cVar, 1);
                case 91:
                    a(a2, z, cVar, 2);
                case 92:
                    a(a2, z, cVar, 3);
                case 93:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 2;
                        layoutParams.addRule(i, intValue);
                    }
                case 94:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 3;
                        layoutParams.addRule(i, intValue);
                    }
                case 95:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 0;
                        layoutParams.addRule(i, intValue);
                    }
                case 96:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 1;
                        layoutParams.addRule(i, intValue);
                    }
                case 97:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 16;
                        layoutParams.addRule(i, intValue);
                    }
                case 98:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 17;
                        layoutParams.addRule(i, intValue);
                    }
                case 99:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        layoutParams.addRule(i, intValue);
                    }
                case 100:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 5;
                        layoutParams.addRule(i, intValue);
                    }
                case 101:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 6;
                        layoutParams.addRule(i, intValue);
                    }
                case 102:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 7;
                        layoutParams.addRule(i, intValue);
                    }
                case 103:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 8;
                        layoutParams.addRule(i, intValue);
                    }
                case 104:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 18;
                        layoutParams.addRule(i, intValue);
                    }
                case 105:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        layoutParams = (RelativeLayout.LayoutParams) a2;
                        intValue = hashMap.get(cVar.j()).intValue();
                        i = 19;
                        layoutParams.addRule(i, intValue);
                    }
                case 106:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).alignWithParent = cVar.c().booleanValue();
                    }
                case 107:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(10);
                    }
                case 108:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(12);
                    }
                case 109:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(9);
                    }
                case 110:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(11);
                    }
                case 111:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(20);
                    }
                case 112:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(21);
                    }
                case 113:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(14);
                    }
                case 114:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(15);
                    }
                case 115:
                    if (a2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) a2).addRule(13);
                    }
                case 116:
                    if (!z) {
                        int i2 = C0199a.b[cVar.b.ordinal()];
                        if (i2 == 3) {
                            if (a2 instanceof LinearLayout.LayoutParams) {
                                ((LinearLayout.LayoutParams) a2).gravity = cVar.h();
                            }
                            if (a2 instanceof FrameLayout.LayoutParams) {
                                ((FrameLayout.LayoutParams) a2).gravity = cVar.h();
                            }
                            if (a2 instanceof RadioGroup.LayoutParams) {
                                layoutParams2 = (RadioGroup.LayoutParams) a2;
                                intValue2 = cVar.h();
                            }
                        } else if (i2 == 4) {
                            Integer a3 = a(cVar, cVar.j().toUpperCase(Locale.US));
                            if (a2 instanceof LinearLayout.LayoutParams) {
                                ((LinearLayout.LayoutParams) a2).gravity = a3.intValue();
                            }
                            if (a2 instanceof FrameLayout.LayoutParams) {
                                ((FrameLayout.LayoutParams) a2).gravity = a3.intValue();
                            }
                            if (a2 instanceof RadioGroup.LayoutParams) {
                                layoutParams2 = (RadioGroup.LayoutParams) a2;
                                intValue2 = a3.intValue();
                            }
                        }
                        layoutParams2.gravity = intValue2;
                    }
                case 117:
                    if (cVar.b == c.EnumC0200c.FLOAT && (a2 instanceof LinearLayout.LayoutParams)) {
                        ((LinearLayout.LayoutParams) a2).weight = cVar.e();
                    }
                    break;
            }
        }
        view.setLayoutParams(a2);
    }

    private static void a(ViewGroup.LayoutParams layoutParams, boolean z, c cVar) {
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || z) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int h = cVar.h();
        marginLayoutParams.rightMargin = h;
        marginLayoutParams.leftMargin = h;
        marginLayoutParams.topMargin = h;
        marginLayoutParams.bottomMargin = h;
    }

    private static void a(ViewGroup.LayoutParams layoutParams, boolean z, c cVar, int i) {
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || z) {
            return;
        }
        if (i == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = cVar.h();
            return;
        }
        if (i == 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = cVar.h();
        } else if (i == 2) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = cVar.h();
        } else {
            if (i != 3) {
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cVar.h();
        }
    }

    private static void a(View view, boolean z, c cVar) {
        if (cVar.b == c.EnumC0200c.DIMEN) {
            if ((view instanceof PendoLinearLayout) && !z) {
                ((PendoLinearLayout) view).setLayoutMaxWidth(cVar.h());
            } else if (view instanceof PendoScrollView) {
                ((PendoScrollView) view).setLayoutMaxWidth(cVar.h());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static String a(View view, Map<String, c> map, Map<String, PersonalizationDefVal> map2) {
        String str = "";
        for (c cVar : map.values()) {
            switch (C0199a.f1405a[cVar.f1407a.ordinal()]) {
                case 1:
                    str = cVar.j();
                    break;
                case 2:
                case 3:
                    Y(view, cVar);
                    break;
                case 4:
                    if (view instanceof PendoAbstractRadioButton) {
                        ((PendoAbstractRadioButton) view).setResponseId(cVar.j());
                        break;
                    } else {
                        break;
                    }
                case 5:
                case 6:
                    g(view, cVar);
                    break;
                case 7:
                    c cVar2 = map.get(c.b.ACCESSIBILITYTEXT.name());
                    if (cVar2 != null && !cVar2.j().isEmpty()) {
                        r6 = false;
                    }
                    a(view, cVar, r6, map2);
                    break;
                case 8:
                    Z(view, cVar);
                    break;
                case 9:
                    e0(view, cVar);
                    break;
                case 10:
                case 11:
                    a(view, cVar);
                    break;
                case 12:
                    V(view, cVar);
                    break;
                case 13:
                    b(view, cVar);
                    break;
                case 14:
                    U(view, cVar);
                    break;
                case 15:
                    f0(view, cVar);
                    break;
                case 16:
                    H(view, cVar);
                    break;
                case 17:
                    b(view, cVar, 0);
                    break;
                case 18:
                    b(view, cVar, 1);
                    break;
                case 19:
                    b(view, cVar, 2);
                    break;
                case 20:
                    b(view, cVar, 3);
                    break;
                case 21:
                    A(view, cVar);
                    break;
                case 22:
                    E(view, cVar);
                    break;
                case 23:
                    q(view, cVar);
                    break;
                case 24:
                    C(view, cVar);
                    break;
                case 25:
                    G(view, cVar);
                    break;
                case 26:
                case 27:
                    m0(view, cVar);
                    break;
                case 28:
                    v(view, cVar);
                    break;
                case 29:
                    a(view, cVar, map.get(c.b.FONTSTYLE.name()));
                    break;
                case 30:
                    X(view, cVar);
                    break;
                case 31:
                    K(view, cVar);
                    break;
                case 32:
                    c(view, cVar);
                    break;
                case 33:
                    a(view, cVar, 0);
                    break;
                case 34:
                    a(view, cVar, 1);
                    break;
                case 35:
                    a(view, cVar, 2);
                    break;
                case 36:
                    a(view, cVar, 3);
                    break;
                case 37:
                    r(view, cVar);
                    break;
                case 38:
                    N(view, cVar);
                    break;
                case 39:
                    o(view, cVar);
                    break;
                case 40:
                    L(view, cVar);
                    break;
                case 41:
                    M(view, cVar);
                    break;
                case 42:
                    u(view, cVar);
                    break;
                case 43:
                    l0(view, cVar);
                    break;
                case 44:
                    F(view, cVar);
                    break;
                case 45:
                    n0(view, cVar);
                    break;
                case 46:
                    o0(view, cVar);
                    break;
                case 47:
                    s(view, cVar);
                    break;
                case 48:
                    t(view, cVar);
                    break;
                case 49:
                    P(view, cVar);
                    break;
                case 50:
                    Q(view, cVar);
                    break;
                case 51:
                    d0(view, cVar);
                    break;
                case 52:
                    a(view, cVar, map.get(c.b.ID.name()) == null);
                    break;
                case 53:
                    m(view, cVar);
                    break;
                case 54:
                    n(view, cVar);
                    break;
                case 55:
                    k(view, cVar);
                    break;
                case 56:
                    l(view, cVar);
                    break;
                case 57:
                    w(view, cVar);
                    break;
                case 58:
                    i0(view, cVar);
                    break;
                case 59:
                    x(view, cVar);
                    break;
                case 60:
                    W(view, cVar);
                    break;
                case 61:
                    B(view, cVar);
                    break;
                case 62:
                    p(view, cVar);
                    break;
                case 63:
                    O(view, cVar);
                    break;
                case 64:
                    b0(view, cVar);
                    break;
                case 65:
                    c0(view, cVar);
                    break;
                case 66:
                    a0(view, cVar);
                    break;
                case 67:
                    i(view, cVar);
                    break;
                case 68:
                    j(view, cVar);
                    break;
                case 69:
                    h(view, cVar);
                    break;
                case 70:
                    y(view, cVar);
                    break;
                case 71:
                    T(view, cVar);
                    break;
                case 72:
                    R(view, cVar);
                    break;
                case 73:
                    g0(view, cVar);
                    break;
                case 74:
                    S(view, cVar);
                    break;
                case 75:
                    h0(view, cVar);
                    break;
                case 76:
                    I(view, cVar);
                    break;
                case 77:
                    J(view, cVar);
                    break;
                case 78:
                    e(view, cVar);
                    break;
                case 79:
                    k0(view, cVar);
                    break;
                case 80:
                    j0(view, cVar);
                    break;
                case 81:
                    f(view, cVar);
                    break;
                case 82:
                    z(view, cVar);
                    break;
                case 83:
                    d(view, cVar);
                    break;
            }
        }
        if (view instanceof PendoCustomView) {
            ((PendoCustomView) view).renderView();
        }
        return str;
    }

    private static void a(View view, c cVar, boolean z, Map<String, PersonalizationDefVal> map) {
        if (view instanceof TextView) {
            int i = C0199a.b[cVar.b.ordinal()];
            if (i != 4) {
                if (i != 6) {
                    return;
                }
                ((TextView) view).setText(b(view.getContext(), cVar.j()));
                return;
            }
            TextView textView = (TextView) view;
            String a2 = b.INSTANCE.a(cVar.j(), map);
            textView.setText(a2);
            if (z) {
                textView.setContentDescription(a2);
            }
        }
    }

    private static int a(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "textUri":
                return 16;
            case "number":
                return 2;
            case "textMultiLine":
                return 131072;
            case "text":
                return 1;
            case "phone":
                return 3;
            case "textPassword":
                return 128;
            case "textEmailAddress":
                return 32;
            default:
                return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.view.ViewGroup.LayoutParams a(android.view.ViewGroup r8) {
        /*
            java.lang.String r0 = "$LayoutParams"
            r1 = -2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            if (r8 == 0) goto L89
            r3 = 0
            java.lang.Class r4 = r8.getClass()     // Catch: java.lang.Exception -> L62
        Le:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L62
            r5.<init>()     // Catch: java.lang.Exception -> L62
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Exception -> L62
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L62
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch: java.lang.Exception -> L62
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L62
            boolean r5 = b(r5)     // Catch: java.lang.Exception -> L62
            if (r5 != 0) goto L2e
            java.lang.Class r4 = r4.getSuperclass()     // Catch: java.lang.Exception -> L62
            goto Le
        L2e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L62
            r5.<init>()     // Catch: java.lang.Exception -> L62
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Exception -> L62
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch: java.lang.Exception -> L62
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.lang.Exception -> L62
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L62
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L62
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L62
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L62
            r5[r3] = r6     // Catch: java.lang.Exception -> L62
            r7 = 1
            r5[r7] = r6     // Catch: java.lang.Exception -> L62
            java.lang.reflect.Constructor r0 = r0.getConstructor(r5)     // Catch: java.lang.Exception -> L62
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L62
            r4[r3] = r2     // Catch: java.lang.Exception -> L62
            r4[r7] = r2     // Catch: java.lang.Exception -> L62
            java.lang.Object r0 = r0.newInstance(r4)     // Catch: java.lang.Exception -> L62
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0     // Catch: java.lang.Exception -> L62
            goto L8a
        L62:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "view class: '"
            r2.<init>(r4)
            java.lang.Class r8 = r8.getClass()
            java.lang.StringBuilder r8 = r2.append(r8)
            java.lang.String r2 = "' Message:"
            java.lang.StringBuilder r8 = r8.append(r2)
            java.lang.String r2 = r0.getMessage()
            java.lang.StringBuilder r8 = r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r2 = new java.lang.Object[r3]
            sdk.pendo.io.logging.PendoLogger.e(r0, r8, r2)
        L89:
            r0 = 0
        L8a:
            if (r0 != 0) goto L91
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r0.<init>(r1, r1)
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.n.a.a(android.view.ViewGroup):android.view.ViewGroup$LayoutParams");
    }

    public static int a() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static float a(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    private static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, IterableConstants.ICON_FOLDER_IDENTIFIER, context.getPackageName());
    }

    private static Object a(JSONObject jSONObject, String str, Class cls) {
        return (cls == Integer.class || cls == Integer.TYPE) ? Integer.valueOf(jSONObject.getInt(str)) : (cls == Boolean.class || cls == Boolean.TYPE) ? Boolean.valueOf(jSONObject.getBoolean(str)) : (cls == Double.class || cls == Double.TYPE) ? Double.valueOf(jSONObject.getDouble(str)) : (cls == Float.class || cls == Float.TYPE) ? Float.valueOf((float) jSONObject.getDouble(str)) : (cls == Long.class || cls == Long.TYPE) ? Long.valueOf(jSONObject.getLong(str)) : cls == String.class ? jSONObject.getString(str) : cls == JSONObject.class ? jSONObject.getJSONObject(str) : jSONObject.get(str);
    }

    private static Integer a(c cVar, String str) {
        int i = 0;
        for (String str2 : str.split("\\|")) {
            i += ((Integer) cVar.a(Gravity.class, str2.toUpperCase(Locale.US))).intValue();
        }
        return Integer.valueOf(i);
    }

    static void a(Object obj, View view, HashMap<String, Integer> hashMap) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(e.class)) {
                String id = ((e) field.getAnnotation(e.class)).id();
                if (id.equalsIgnoreCase("")) {
                    id = field.getName();
                }
                if (hashMap.containsKey(id)) {
                    try {
                        try {
                            field.set(obj, view.findViewById(hashMap.get(id).intValue()));
                        } catch (IllegalAccessException e) {
                            PendoLogger.e(e, e.getMessage(), new Object[0]);
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                }
            } else if (field.getName().equalsIgnoreCase("ids") && field.getType() == hashMap.getClass()) {
                try {
                    field.set(obj, hashMap);
                } catch (IllegalAccessException e2) {
                    PendoLogger.e(e2, e2.getMessage(), new Object[0]);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view) {
        if (view instanceof IBackgroundRenderView) {
            ((IBackgroundRenderView) view).renderBackground();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i));
            i++;
        }
    }

    private static int a(int i, int i2) {
        return ((i == -1 || i == -2) && i2 > 0 && ((float) i2) < ((float) g0.b().getDisplayMetrics().heightPixels)) ? i2 : i;
    }
}
