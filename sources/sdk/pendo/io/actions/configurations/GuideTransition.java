package sdk.pendo.io.actions.configurations;

import com.facebook.react.uimanager.ViewProps;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.l;

/* loaded from: classes6.dex */
public final class GuideTransition {
    public static final String GUIDE_NO_DIRECTION_FIELD_VALUE = "noDirection";
    public static final String GUIDE_TRANSITION_BACKGROUND_ID = "backgroundId";
    public static final String GUIDE_TRANSITION_DIRECTION_FIELD = "direction";
    public static final String GUIDE_TRANSITION_DURATION_FIELD = "duration";
    public static final String GUIDE_TRANSITION_EFFECT_FIELD = "effect";
    public static final String GUIDE_TRANSITION_TYPE_FIELD = "type";
    private String mBackgroundId;
    private GuideTransitionDirection mDirection;
    private int mDuration;
    private GuideTransitionEffect mEffect;
    private GuideTransitionType mType;

    public enum GuideTransitionDirection {
        LEFT(ViewProps.LEFT),
        RIGHT(ViewProps.RIGHT),
        TOP(ViewProps.TOP),
        BOTTOM(ViewProps.BOTTOM);

        private static final Map<String, GuideTransitionDirection> LOOKUP_TABLE = new HashMap();
        private final String mDirection;

        static {
            Iterator it = EnumSet.allOf(GuideTransitionDirection.class).iterator();
            while (it.hasNext()) {
                GuideTransitionDirection guideTransitionDirection = (GuideTransitionDirection) it.next();
                LOOKUP_TABLE.put(guideTransitionDirection.mDirection, guideTransitionDirection);
            }
        }

        GuideTransitionDirection(String str) {
            this.mDirection = str;
        }

        public static GuideTransitionDirection get(String str) {
            return LOOKUP_TABLE.get(str);
        }

        public boolean equals(GuideTransitionDirection guideTransitionDirection) {
            return this.mDirection.equals(guideTransitionDirection.mDirection);
        }

        public String getDirection() {
            return this.mDirection;
        }
    }

    public enum GuideTransitionEffect {
        POP("pop"),
        FADE("fade"),
        SLIDE("slide"),
        LAND("land");

        private static final Map<String, GuideTransitionEffect> LOOKUP_TABLE = new HashMap();
        private final String mEffect;

        static {
            Iterator it = EnumSet.allOf(GuideTransitionEffect.class).iterator();
            while (it.hasNext()) {
                GuideTransitionEffect guideTransitionEffect = (GuideTransitionEffect) it.next();
                LOOKUP_TABLE.put(guideTransitionEffect.mEffect, guideTransitionEffect);
            }
        }

        GuideTransitionEffect(String str) {
            this.mEffect = str;
        }

        public static GuideTransitionEffect get(String str) {
            return LOOKUP_TABLE.get(str);
        }

        public boolean equals(GuideTransitionEffect guideTransitionEffect) {
            return this.mEffect.equals(guideTransitionEffect.mEffect);
        }

        public String getEffect() {
            return this.mEffect;
        }
    }

    public enum GuideTransitionType {
        IN("in"),
        OUT("out"),
        REVERSE_IN("reverseIn"),
        REVERSE_OUT("reverseOut");

        private static final Map<String, GuideTransitionType> LOOKUP_TABLE = new HashMap();
        private final String mType;

        static {
            Iterator it = EnumSet.allOf(GuideTransitionType.class).iterator();
            while (it.hasNext()) {
                GuideTransitionType guideTransitionType = (GuideTransitionType) it.next();
                LOOKUP_TABLE.put(guideTransitionType.mType, guideTransitionType);
            }
        }

        GuideTransitionType(String str) {
            this.mType = str;
        }

        public static GuideTransitionType get(String str) {
            return LOOKUP_TABLE.get(str);
        }

        public boolean equals(GuideTransitionType guideTransitionType) {
            return this.mType.equals(guideTransitionType.mType);
        }

        public String getType() {
            return this.mType;
        }
    }

    public GuideTransition(String str, String str2, String str3, int i, String str4) {
        this.mDirection = str.equals(GUIDE_NO_DIRECTION_FIELD_VALUE) ? null : GuideTransitionDirection.get(str);
        this.mEffect = GuideTransitionEffect.get(str2);
        this.mType = GuideTransitionType.get(str3);
        this.mDuration = i;
        this.mBackgroundId = str4;
    }

    public static GuideTransition getGuideTransition(l lVar) {
        if (!isValidTransition(lVar)) {
            return null;
        }
        String g = (!lVar.d(GUIDE_TRANSITION_DIRECTION_FIELD) || lVar.a(GUIDE_TRANSITION_DIRECTION_FIELD).i()) ? GUIDE_NO_DIRECTION_FIELD_VALUE : lVar.a(GUIDE_TRANSITION_DIRECTION_FIELD).g();
        String g2 = lVar.a(GUIDE_TRANSITION_EFFECT_FIELD).g();
        String g3 = lVar.a("type").g();
        int c = lVar.a("duration").c();
        i a2 = lVar.a(GUIDE_TRANSITION_BACKGROUND_ID);
        return new GuideTransition(g, g2, g3, c, a2 != null ? a2.g() : null);
    }

    public static boolean isValidTransition(l lVar) {
        return lVar.d(GUIDE_TRANSITION_EFFECT_FIELD) && lVar.d("type") && lVar.d("duration");
    }

    public String getBackgroundId() {
        return this.mBackgroundId;
    }

    public GuideTransitionDirection getDirection() {
        return this.mDirection;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public GuideTransitionEffect getEffect() {
        return this.mEffect;
    }

    public GuideTransitionType getType() {
        return this.mType;
    }
}
