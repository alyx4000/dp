package sdk.pendo.io.g9;

import external.sdk.pendo.io.yoyo.Techniques;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* loaded from: classes6.dex */
public final class e {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1127a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[GuideTransition.GuideTransitionDirection.values().length];
            c = iArr;
            try {
                iArr[GuideTransition.GuideTransitionDirection.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[GuideTransition.GuideTransitionDirection.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[GuideTransition.GuideTransitionDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[GuideTransition.GuideTransitionDirection.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[GuideTransition.GuideTransitionType.values().length];
            b = iArr2;
            try {
                iArr2[GuideTransition.GuideTransitionType.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GuideTransition.GuideTransitionType.REVERSE_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GuideTransition.GuideTransitionType.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GuideTransition.GuideTransitionType.REVERSE_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[GuideTransition.GuideTransitionEffect.values().length];
            f1127a = iArr3;
            try {
                iArr3[GuideTransition.GuideTransitionEffect.POP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1127a[GuideTransition.GuideTransitionEffect.FADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1127a[GuideTransition.GuideTransitionEffect.SLIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1127a[GuideTransition.GuideTransitionEffect.LAND.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static Techniques a(GuideTransition guideTransition) {
        int i = a.f1127a[guideTransition.getEffect().ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Techniques.FadeIn : c(guideTransition) : e(guideTransition) : b(guideTransition) : d(guideTransition);
    }

    private static Techniques b(GuideTransition guideTransition) {
        int i = a.b[guideTransition.getType().ordinal()];
        return (i == 1 || i == 2) ? Techniques.FadeIn : (i == 3 || i == 4) ? Techniques.FadeOut : Techniques.FadeIn;
    }

    private static Techniques c(GuideTransition guideTransition) {
        int i = a.b[guideTransition.getType().ordinal()];
        return (i == 1 || i == 2) ? Techniques.Landing : (i == 3 || i == 4) ? Techniques.TakingOff : Techniques.FadeIn;
    }

    private static Techniques d(GuideTransition guideTransition) {
        int i = a.b[guideTransition.getType().ordinal()];
        return (i == 1 || i == 2) ? Techniques.BounceIn : (i == 3 || i == 4) ? Techniques.ZoomOut : Techniques.FadeIn;
    }

    private static Techniques e(GuideTransition guideTransition) {
        int i = a.c[guideTransition.getDirection().ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Techniques.FadeIn : g(guideTransition) : h(guideTransition) : f(guideTransition) : i(guideTransition);
    }

    private static Techniques f(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInUp : Techniques.SlideOutDown;
    }

    private static Techniques g(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInRight : Techniques.SlideOutRight;
    }

    private static Techniques h(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInLeft : Techniques.SlideOutLeft;
    }

    private static Techniques i(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInDown : Techniques.SlideOutUp;
    }
}
