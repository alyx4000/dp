package sdk.pendo.io;

import android.content.Context;
import android.view.View;
import com.facebook.react.common.ReactConstants;
import java.util.Map;

/* loaded from: classes6.dex */
public final class Pendo {
    public static final JWT jwt = new JWT();

    public static class PendoOptions {
        public static final String DISABLE_ANALYTICS = "disableAnalytics";
        public static final String FLUTTER_BRIDGE = "flutterBridge";
        public static final String FRAMEWORK = "framework";
        public static final String FRAMEWORK_TYPE = "frameworkType";
        public static final String FRAMEWORK_VERSION = "frameworkVersion";
        public static final String USE_PROVIDED_SCREEN_ID = "useProvidedScreenId";
        public static final String XAMARIN_BRIDGE = "xamarinBridge";
        private Map<String, Object> mAdditionalOptions;
        private boolean mDisableAppAnalytics;
        private boolean mEnableAutoSessionEndDetection;
        private String mEnvironment;
        private boolean mExcludeHiddenElementsWhileScanning;
        private Framework mFramework;
        private FrameworkType mFrameworkType;
        private String mFrameworkVersion;
        private boolean mImportInitModelFromLocalFile;
        private boolean mIncludeAllGuideContent;
        private boolean mUseClickableElementsFromJS;
        private boolean mUseProvidedScreenId;

        public static class Builder {
            private boolean mUseClickableElementsFromJS = true;
            private boolean mEnableAutoSessionEndDetection = false;
            private String mEnvironment = null;
            private Map<String, Object> mAdditionalOptions = null;
            private boolean mIncludeAllGuideContent = false;
            private boolean mImportInitModelFromLocalFile = false;
            private boolean mExcludeGhostElementsWhileScanning = true;

            public PendoOptions build() {
                return new PendoOptions(this);
            }

            public Builder setAdditionalOptions(Map<String, Object> map) {
                this.mAdditionalOptions = map;
                return this;
            }

            public Builder setEnableAutoSessionEndDetection(boolean z) {
                this.mEnableAutoSessionEndDetection = z;
                return this;
            }

            public Builder setEnvironmentDebugOnly(String str) {
                this.mEnvironment = str;
                return this;
            }

            public Builder setExcludeHiddenElementsWhileScanning(boolean z) {
                this.mExcludeGhostElementsWhileScanning = z;
                return this;
            }

            public Builder setImportInitModelFromLocalFile(boolean z) {
                this.mImportInitModelFromLocalFile = z;
                return this;
            }

            public Builder setIncludeAllGuideContent(boolean z) {
                this.mIncludeAllGuideContent = z;
                return this;
            }

            public Builder setUseClickableElementsFromJS(boolean z) {
                this.mUseClickableElementsFromJS = z;
                return this;
            }
        }

        public enum Framework {
            NATIVE("AndroidX"),
            REACT_NATIVE(ReactConstants.TAG),
            FLUTTER("Flutter"),
            XAMARIN_FORMS("XamarinForms"),
            MAUI("MAUI");

            private final String name;

            Framework(String str) {
                this.name = str;
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }
        }

        public enum FrameworkType {
            REACT_NAVIGATION("ReactNavigation"),
            REACT_NATIVE_NAVIGATION("ReactNativeNavigation"),
            FLUTTER_OBSERVABLE("Observable"),
            TRACK("Track");

            private final String name;

            FrameworkType(String str) {
                this.name = str;
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }
        }

        public PendoOptions() {
            this.mFramework = Framework.NATIVE;
            this.mFrameworkType = null;
            this.mFrameworkVersion = null;
            this.mEnableAutoSessionEndDetection = false;
            this.mUseClickableElementsFromJS = true;
            this.mEnvironment = null;
            this.mDisableAppAnalytics = false;
            this.mImportInitModelFromLocalFile = false;
            this.mIncludeAllGuideContent = false;
            this.mExcludeHiddenElementsWhileScanning = true;
            this.mUseProvidedScreenId = false;
            this.mAdditionalOptions = null;
        }

        private <T> T extractAdditionalOption(Map<String, Object> map, String str, Class<T> cls, T t) {
            try {
                Object obj = map.get(str);
                if (obj != null && obj.getClass().equals(cls)) {
                    return cls.cast(obj);
                }
            } catch (Exception unused) {
            }
            return t;
        }

        public Map<String, Object> getAdditionalOptions() {
            return this.mAdditionalOptions;
        }

        public boolean getDisableAnalytics() {
            return this.mDisableAppAnalytics;
        }

        public boolean getEnableAutoSessionEndDetection() {
            return this.mEnableAutoSessionEndDetection;
        }

        public String getEnvironment() {
            return this.mEnvironment;
        }

        public boolean getExcludeHiddenElementsWhileScanning() {
            return this.mExcludeHiddenElementsWhileScanning;
        }

        public Framework getFramework() {
            return this.mFramework;
        }

        public FrameworkType getFrameworkType() {
            return this.mFrameworkType;
        }

        public String getFrameworkVersion() {
            return this.mFrameworkVersion;
        }

        public boolean getUseClickableElementsFromJS() {
            return this.mUseClickableElementsFromJS;
        }

        public boolean getUseProvidedScreenId() {
            return this.mUseProvidedScreenId;
        }

        public boolean isImportInitModelFromLocalFile() {
            return this.mImportInitModelFromLocalFile;
        }

        public boolean isIncludeAllGuidesContent() {
            return this.mIncludeAllGuideContent;
        }

        private PendoOptions(Builder builder) {
            Framework framework = Framework.NATIVE;
            this.mFramework = framework;
            this.mFrameworkType = null;
            this.mFrameworkVersion = null;
            this.mEnableAutoSessionEndDetection = false;
            this.mUseClickableElementsFromJS = true;
            this.mEnvironment = null;
            this.mDisableAppAnalytics = false;
            this.mImportInitModelFromLocalFile = false;
            this.mIncludeAllGuideContent = false;
            this.mExcludeHiddenElementsWhileScanning = true;
            this.mUseProvidedScreenId = false;
            this.mAdditionalOptions = null;
            Map<String, Object> map = builder.mAdditionalOptions;
            this.mAdditionalOptions = map;
            this.mFramework = (Framework) extractAdditionalOption(map, FRAMEWORK, Framework.class, framework);
            this.mFrameworkType = (FrameworkType) extractAdditionalOption(this.mAdditionalOptions, FRAMEWORK_TYPE, FrameworkType.class, null);
            this.mFrameworkVersion = (String) extractAdditionalOption(this.mAdditionalOptions, FRAMEWORK_VERSION, String.class, null);
            Map<String, Object> map2 = this.mAdditionalOptions;
            Boolean bool = Boolean.FALSE;
            this.mUseProvidedScreenId = ((Boolean) extractAdditionalOption(map2, USE_PROVIDED_SCREEN_ID, Boolean.class, bool)).booleanValue();
            this.mDisableAppAnalytics = Boolean.TRUE.equals(extractAdditionalOption(this.mAdditionalOptions, DISABLE_ANALYTICS, Boolean.class, bool)) || FrameworkType.TRACK.equals(this.mFrameworkType);
            this.mUseClickableElementsFromJS = builder.mUseClickableElementsFromJS;
            this.mEnableAutoSessionEndDetection = builder.mEnableAutoSessionEndDetection;
            this.mEnvironment = builder.mEnvironment;
            this.mIncludeAllGuideContent = builder.mIncludeAllGuideContent;
            this.mImportInitModelFromLocalFile = builder.mImportInitModelFromLocalFile;
            this.mExcludeHiddenElementsWhileScanning = builder.mExcludeGhostElementsWhileScanning;
        }
    }

    private Pendo() {
    }

    public static synchronized void dismissVisibleGuides() {
        synchronized (Pendo.class) {
            PendoInternal.e();
        }
    }

    public static void endSession() {
        PendoInternal.g();
    }

    public static String getAccountId() {
        return PendoInternal.k();
    }

    public static String getDeviceId() {
        return PendoInternal.n();
    }

    public static String getVisitorId() {
        return PendoInternal.D();
    }

    public static synchronized void pauseGuides(boolean z) {
        synchronized (Pendo.class) {
            PendoInternal.a(z);
        }
    }

    public static synchronized void resumeGuides() {
        synchronized (Pendo.class) {
            PendoInternal.Q();
        }
    }

    public static void screenContentChanged() {
        PendoInternal.R();
    }

    public static boolean sendClickAnalytic(View view) {
        return PendoInternal.a(view);
    }

    public static void setAccountData(Map<String, Object> map) {
        PendoInternal.a(map);
    }

    public static synchronized void setDebugMode(boolean z) {
        synchronized (Pendo.class) {
            PendoInternal.b(z);
        }
    }

    public static void setVisitorData(Map<String, Object> map) {
        PendoInternal.b(map);
    }

    public static synchronized void setup(Context context, String str, PendoOptions pendoOptions, PendoPhasesCallbackInterface pendoPhasesCallbackInterface) {
        synchronized (Pendo.class) {
            PendoInternal.a(context, str, pendoOptions, pendoPhasesCallbackInterface);
        }
    }

    public static void startSession(String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        PendoInternal.a(str, str2, map, map2);
    }

    public static void track(String str, Map<String, Object> map) {
        PendoInternal.a(str, map);
    }
}
