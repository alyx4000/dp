package sdk.pendo.io.n;

import com.amplitude.reactnative.DatabaseConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GlobalEventPropertiesKt;
import sdk.pendo.io.models.PersonalizationDefVal;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/n/b;", "", "a", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern b = Pattern.compile("\\<\\%\\=(.*?)\\%\\>");

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J4\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J(\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J*\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H\u0002J&\u0010\t\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001c\u001a\n \u001b*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0017¨\u0006%"}, d2 = {"Lsdk/pendo/io/n/b$a;", "", "", "originalText", "", "personalizedStringsList", "", "Lsdk/pendo/io/models/PersonalizationDefVal;", "defaultValuesMap", "a", "propertyKey", "c", "text", "Ljava/util/regex/Pattern;", "pattern", "", "groupIndex", "propertySections", "b", DatabaseConstants.KEY_FIELD, "dataMap", "textToSet", "ACCOUNT", "Ljava/lang/String;", "AGENT", "DOT_DELIMITER", "EMPTY_STRING", "kotlin.jvm.PlatformType", "PERSONALIZED_STRING_REGEX", "Ljava/util/regex/Pattern;", "PERSONALIZED_STRING_REGEX_GROUP_INDEX", "I", "PERSONAL_DATA_MAP_LEVELS", "TAG", "VISITOR", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.n.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> a(String text, Pattern pattern, int groupIndex) {
            ArrayList arrayList = new ArrayList();
            if (pattern != null) {
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    try {
                        String group = matcher.group(groupIndex);
                        if (group != null) {
                            Intrinsics.checkNotNull(group);
                            arrayList.add(group);
                        }
                    } catch (Exception e) {
                        PendoLogger.e(e, "Failed to get the string from matcher's pattern group", new Object[0]);
                    }
                }
            }
            return arrayList;
        }

        private final String b(List<String> propertySections) {
            String str;
            Map<String, ? extends Object> i;
            if (!Intrinsics.areEqual(propertySections.get(1), "agent")) {
                return null;
            }
            String str2 = propertySections.get(0);
            if (Intrinsics.areEqual(str2, GlobalEventPropertiesKt.VISITOR_KEY)) {
                str = propertySections.get(2);
                i = PendoInternal.B();
            } else {
                if (!Intrinsics.areEqual(str2, GlobalEventPropertiesKt.ACCOUNT_KEY)) {
                    return null;
                }
                str = propertySections.get(2);
                i = PendoInternal.i();
            }
            return b(str, i);
        }

        private final String c(String propertyKey, Map<String, PersonalizationDefVal> defaultValuesMap) {
            PersonalizationDefVal personalizationDefVal;
            PendoLogger.d("DynamicHelperTextParser, propertyKey is " + propertyKey, new Object[0]);
            List<String> split$default = StringsKt.split$default((CharSequence) propertyKey, new String[]{"."}, false, 0, 6, (Object) null);
            if ((split$default == null || split$default.isEmpty()) || split$default.size() != 3) {
                return null;
            }
            String b = b(split$default);
            if (!(b == null || b.length() == 0)) {
                return b;
            }
            String a2 = a(split$default);
            if (!(a2 == null || a2.length() == 0)) {
                return a2;
            }
            if (defaultValuesMap == null || (personalizationDefVal = defaultValuesMap.get(propertyKey)) == null) {
                return null;
            }
            return personalizationDefVal.getDefaultValue();
        }

        private final String a(String originalText, List<String> personalizedStringsList, Map<String, PersonalizationDefVal> defaultValuesMap) {
            String str;
            String str2 = originalText;
            for (String str3 : personalizedStringsList) {
                PendoLogger.d("DynamicHelperTextParser, personalizedString: " + str3, new Object[0]);
                str = "";
                if (str3.length() > 0) {
                    String c = c(str3, defaultValuesMap);
                    str = c != null ? c : "";
                    PendoLogger.d("DynamicHelperTextParser, propertyValue: " + c + " personalizedValue: " + ((Object) str), new Object[0]);
                }
                String str4 = "<%=" + str3 + "%>";
                PendoLogger.d("DynamicHelperTextParser, stringToReplace: " + str4, new Object[0]);
                str2 = StringsKt.replace$default(str2, str4, str, false, 4, (Object) null);
            }
            return str2;
        }

        private final String b(String key, Map<String, ? extends Object> dataMap) {
            if (dataMap == null) {
                return null;
            }
            try {
                Object obj = dataMap.get(key);
                if (obj != null) {
                    return obj.toString();
                }
                return null;
            } catch (Exception e) {
                PendoLogger.w(e, "DynamicHelperTextParser.getValueFromMapAsString: error while trying to find key = " + key + ", returning null", new Object[0]);
                return null;
            }
        }

        private final String a(List<String> propertySections) {
            Map<String, Map<String, Object>> j;
            String str = propertySections.get(0);
            return b(propertySections.get(2), (!Intrinsics.areEqual(str, GlobalEventPropertiesKt.VISITOR_KEY) ? !(!Intrinsics.areEqual(str, GlobalEventPropertiesKt.ACCOUNT_KEY) || (j = PendoInternal.j()) == null) : (j = PendoInternal.C()) != null) ? null : (Map) j.get(propertySections.get(1)));
        }

        public final String a(String textToSet, Map<String, PersonalizationDefVal> defaultValuesMap) {
            if (textToSet == null) {
                return "";
            }
            Companion companion = b.INSTANCE;
            List<String> a2 = companion.a(textToSet, b.b, 1);
            return a2.isEmpty() ? textToSet : companion.a(textToSet, a2, defaultValuesMap);
        }
    }
}
