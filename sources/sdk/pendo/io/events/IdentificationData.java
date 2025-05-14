package sdk.pendo.io.events;

import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.R;
import sdk.pendo.io.g9.a0;
import sdk.pendo.io.g9.g0;
import sdk.pendo.io.g9.m;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.l0.c;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.p2.d;
import sdk.pendo.io.p2.e;
import sdk.pendo.io.p2.g;
import sdk.pendo.io.p2.k;

/* loaded from: classes6.dex */
public final class IdentificationData {
    private static final String CLOSING_BRACKET = "]";
    private static final String EMPTY_STRING = "";
    private static final String FIELD_ACCESSIBILITY = "accessibility";
    private static final String FIELD_ACCESSIBILITY_LABEL = "label";
    private static final String FIELD_ACCESSIBILITY_LABEL_BASE64 = "labelBase64";
    private static final String FIELD_ACCESSIBILITY_LABEL_FOR_IDENTIFIER = "accessibility.label";
    public static final String FIELD_ACCESSIBILITY_LABEL_HASHED = "label";
    public static final String FIELD_CHILD_COUNT = "childCount";
    public static final String FIELD_ID = "id";
    public static final String FIELD_ID_OF_PARENTS = "idOfParents";
    public static final String FIELD_INDEX_IN_PARENT = "indexInParent";
    private static final String FIELD_INSIDE_DRAWER = "insideDrawer";
    private static final String FIELD_INSIDE_LIST = "insideList";
    private static final String FIELD_IS_LIST = "isList";
    public static final String FIELD_NESTED_TEXTS_BASE64 = "nestedTextsBase64";
    public static final String FIELD_NESTED_TEXTS_HASHED = "nestedTextsHash";
    public static final String FIELD_PARENT_ID = "parentId";
    public static final String FIELD_TEXT_BASE64 = "textBase64";
    public static final String FIELD_TEXT_HASHED = "text";
    public static final String FIELD_TYPE = "type";
    private static final String FIELD_VIEW_TAG = "viewTag";
    private static final String OPENING_BRACKET = "[";
    public static final String PREDICATE = "predicate";
    public static final String RA_PREDICATE = "RAPredicate";
    public static final String RETROACTIVE_ELEMENT_INFO = "retroElementInfo";
    public static final String SERIALIZED_NAME = "elementInfo";
    private static final String SPACE = " ";
    private static final String STRINGS_SEPARATOR = ",";
    private static final String[] excludedFields = {"mMandatory", "mAccessibilityData"};

    @c(FIELD_ACCESSIBILITY_LABEL_BASE64)
    private String mAccessibilityBase64;

    @c("label")
    private String mAccessibilityHashed;

    @c("id")
    private String mId;

    @c(FIELD_ID_OF_PARENTS)
    private ArrayList<String> mIdOfParents;

    @c("nestedTextsBased64")
    private JSONArray mNestedTextsBase64;

    @c(FIELD_NESTED_TEXTS_HASHED)
    private String mNestedTextsHashed;

    @c(FIELD_PARENT_ID)
    private String mParentId;

    @c("pendoViewTag")
    private String mPendoViewTagBase64;

    @c(RA_PREDICATE)
    private String mRAPredicate;

    @c(FIELD_TEXT_BASE64)
    private String mTextBase64;

    @c("text")
    private String mTextHashed;

    @c("type")
    private String mType;

    @c(FIELD_VIEW_TAG)
    private String mViewTagBase64;

    @c(FIELD_CHILD_COUNT)
    private int mChildCount = 0;

    @c(FIELD_IS_LIST)
    private boolean mIsList = false;

    @c(FIELD_INSIDE_LIST)
    private boolean mIsInsideList = false;

    @c(FIELD_INDEX_IN_PARENT)
    private Integer mIndexInParent = -1;

    @c(FIELD_INSIDE_DRAWER)
    private boolean mIsInsideDrawer = false;
    private LegacyTexts mLegacyTexts = new LegacyTexts();

    public class LegacyTexts {
        private String mLegacyAccessibilityBase64;
        private String mLegacyNestedTextsBase64;
        private String mLegacyTextBase64;
        public final String LEGACY_FIELD_TEXT = "text";
        public final String LEGACY_FIELD_NESTED_TEXTS = "nestedTexts";

        public LegacyTexts() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasAnyKindOfTexts() {
            return (this.mLegacyTextBase64 == null && this.mLegacyAccessibilityBase64 == null && this.mLegacyNestedTextsBase64 == null) ? false : true;
        }

        private boolean shouldAddToJson(String str, boolean z) {
            return str != null && z;
        }

        public JSONObject createLegacyRAElementInfo(boolean z, boolean z2) {
            LegacyTexts legacyTexts = IdentificationData.this.mLegacyTexts;
            if (legacyTexts.mLegacyTextBase64 == null && !shouldAddToJson(legacyTexts.mLegacyNestedTextsBase64, z2) && !shouldAddToJson(IdentificationData.this.mLegacyTexts.mLegacyAccessibilityBase64, z)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            String str = IdentificationData.this.mParentId;
            if (str != null) {
                jSONObject.put(IdentificationData.FIELD_PARENT_ID, str);
            }
            ArrayList arrayList = IdentificationData.this.mIdOfParents;
            if (arrayList != null) {
                jSONObject.put(IdentificationData.FIELD_ID_OF_PARENTS, arrayList);
            }
            String str2 = IdentificationData.this.mId;
            if (str2 != null) {
                jSONObject.put("id", str2);
            }
            String str3 = IdentificationData.this.mType;
            if (str3 != null) {
                jSONObject.put("type", str3);
            }
            String str4 = IdentificationData.this.mRAPredicate;
            if (str4 != null) {
                jSONObject.put(IdentificationData.RA_PREDICATE, str4);
            }
            String str5 = IdentificationData.this.mLegacyTexts.mLegacyTextBase64;
            if (str5 != null) {
                jSONObject.put("text", str5);
            }
            if (shouldAddToJson(IdentificationData.this.mLegacyTexts.mLegacyNestedTextsBase64, z2)) {
                jSONObject.put("nestedTexts", IdentificationData.this.mLegacyTexts.mLegacyNestedTextsBase64);
            }
            jSONObject.put(IdentificationData.FIELD_CHILD_COUNT, IdentificationData.this.mChildCount);
            if (shouldAddToJson(IdentificationData.this.mLegacyTexts.mLegacyAccessibilityBase64, z)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("label", IdentificationData.this.mLegacyTexts.mLegacyAccessibilityBase64);
                jSONObject.putOpt(IdentificationData.FIELD_ACCESSIBILITY, jSONObject2);
            }
            jSONObject.putOpt(IdentificationData.FIELD_IS_LIST, Boolean.valueOf(IdentificationData.this.mIsList));
            jSONObject.putOpt(IdentificationData.FIELD_INSIDE_LIST, Boolean.valueOf(IdentificationData.this.mIsInsideList));
            jSONObject.putOpt(IdentificationData.FIELD_INDEX_IN_PARENT, IdentificationData.this.mIndexInParent);
            jSONObject.putOpt(IdentificationData.FIELD_INSIDE_DRAWER, Boolean.valueOf(IdentificationData.this.mIsInsideDrawer));
            return jSONObject;
        }

        public String getLegacyAccessibilityBase64() {
            return this.mLegacyAccessibilityBase64;
        }

        public String getLegacyNestedTextsBase64() {
            return this.mLegacyNestedTextsBase64;
        }

        public String getLegacyTextBase64() {
            return this.mLegacyTextBase64;
        }

        public void setAccessibilityData(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mLegacyAccessibilityBase64 = m0.b(str);
        }

        public void setNestedTexts(ArrayList<String> arrayList) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i != 0) {
                    sb.append("_");
                }
                sb.append(m0.b(arrayList.get(i)));
            }
            this.mLegacyNestedTextsBase64 = sb.toString();
        }

        public void setText(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mLegacyTextBase64 = m0.b(str);
        }
    }

    private void addLegacyHashIfNeeded(Set<String> set, boolean z, boolean z2) {
        JSONObject createLegacyRAElementInfo = this.mLegacyTexts.createLegacyRAElementInfo(z, z2);
        if (createLegacyRAElementInfo != null) {
            set.add(m.f1138a.a(o0.f1142a.a(createLegacyRAElementInfo)));
        }
    }

    public static IdentificationData makeFromJson(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            JSONObject jSONObject = ((JSONObject) jSONArray.get(0)).getJSONObject("retroElementInfo");
            IdentificationData identificationData = new IdentificationData();
            identificationData.setPredicate(jSONObject.getString(PREDICATE));
            if (jSONObject.has("id")) {
                identificationData.setId(jSONObject.getString("id"));
            }
            if (jSONObject.has(FIELD_INDEX_IN_PARENT)) {
                identificationData.setIndexInParent(Integer.valueOf(jSONObject.getInt(FIELD_INDEX_IN_PARENT)));
            }
            if (jSONObject.has("text")) {
                identificationData.setTextHashed(jSONObject.getString("text"));
            }
            if (jSONObject.has(FIELD_ACCESSIBILITY)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(FIELD_ACCESSIBILITY);
                if (jSONObject2.has("label")) {
                    identificationData.setAccessibilityHashed(jSONObject2.getString("label"));
                }
            }
            if (jSONObject.has(FIELD_VIEW_TAG)) {
                String string = jSONObject.getString(FIELD_VIEW_TAG);
                identificationData.mViewTagBase64 = string;
                identificationData.mPendoViewTagBase64 = string;
            }
            identificationData.setType(jSONObject.getString("type"));
            identificationData.setChildCount(jSONObject.getInt(FIELD_CHILD_COUNT));
            identificationData.setIsList(jSONObject.getBoolean(FIELD_IS_LIST));
            identificationData.setInsideList(jSONObject.getBoolean(FIELD_INSIDE_LIST));
            identificationData.setInsideDrawer(jSONObject.getBoolean(FIELD_INSIDE_DRAWER));
            identificationData.setIdOfParents(new ArrayList<>(Arrays.asList(jSONObject.getString(FIELD_ID_OF_PARENTS).replace(" ", "").replace(OPENING_BRACKET, "").replace(CLOSING_BRACKET, "").split(STRINGS_SEPARATOR))));
            return identificationData;
        } catch (Exception e) {
            PendoLogger.e(e);
            return null;
        }
    }

    public JSONArray createRetroElementCompatibilityHashes() {
        if (!this.mLegacyTexts.hasAnyKindOfTexts()) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            addLegacyHashIfNeeded(linkedHashSet, false, false);
            addLegacyHashIfNeeded(linkedHashSet, false, true);
            addLegacyHashIfNeeded(linkedHashSet, true, false);
            addLegacyHashIfNeeded(linkedHashSet, true, true);
            return new JSONArray((Collection) linkedHashSet);
        } catch (Exception e) {
            PendoLogger.d(e, "exception in createRetroElementCompatibilityHashes!", new Object[0]);
            return null;
        }
    }

    public String createRetroElementIdentifier() {
        if (TextUtils.isEmpty(this.mAccessibilityHashed) && TextUtils.isEmpty(this.mTextHashed)) {
            return null;
        }
        SortedMap synchronizedSortedMap = Collections.synchronizedSortedMap(new TreeMap());
        if (!TextUtils.isEmpty(this.mAccessibilityHashed)) {
            synchronizedSortedMap.put(FIELD_ACCESSIBILITY_LABEL_FOR_IDENTIFIER, this.mAccessibilityHashed);
        }
        if (!TextUtils.isEmpty(this.mTextHashed)) {
            synchronizedSortedMap.put("text", this.mTextHashed);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : synchronizedSortedMap.keySet()) {
            arrayList.add(str);
            arrayList.add(":");
            arrayList.add((String) synchronizedSortedMap.get(str));
        }
        return m0.a(arrayList, "");
    }

    public JSONObject createRetroElementTexts() {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(this.mTextBase64) && TextUtils.isEmpty(this.mAccessibilityBase64) && ((jSONArray = this.mNestedTextsBase64) == null || jSONArray.length() == 0)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray2 = this.mNestedTextsBase64;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jSONObject.put(FIELD_NESTED_TEXTS_BASE64, this.mNestedTextsBase64);
            }
            if (!TextUtils.isEmpty(this.mTextBase64)) {
                jSONObject.put(FIELD_TEXT_BASE64, this.mTextBase64);
            }
            if (!TextUtils.isEmpty(this.mAccessibilityBase64)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(FIELD_ACCESSIBILITY_LABEL_BASE64, this.mAccessibilityBase64);
                jSONObject.put(FIELD_ACCESSIBILITY, jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    protected String encodeViewTagWithBase64(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Number) || (obj instanceof CharSequence)) {
            return m0.b(obj.toString());
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentificationData)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return e.a(this, (IdentificationData) obj, excludedFields);
    }

    public String getAccessibilityBase64() {
        return this.mAccessibilityBase64;
    }

    public String getAccessibilityHashed() {
        return this.mAccessibilityHashed;
    }

    public int getChildCount() {
        return this.mChildCount;
    }

    public String getId() {
        return this.mId;
    }

    public ArrayList<String> getIdOfParents() {
        return this.mIdOfParents;
    }

    public Integer getIndexInParent() {
        return this.mIndexInParent;
    }

    public LegacyTexts getLegacyTexts() {
        return this.mLegacyTexts;
    }

    public JSONArray getNestedTextsBase64() {
        return this.mNestedTextsBase64;
    }

    public String getNestedTextsHashed() {
        return this.mNestedTextsHashed;
    }

    public String getParentId() {
        return this.mParentId;
    }

    public String getPendoViewTagBase64() {
        return this.mPendoViewTagBase64;
    }

    public String getRAPredicate() {
        return this.mRAPredicate;
    }

    public String getTextBase64() {
        return this.mTextBase64;
    }

    public String getTextHashed() {
        return this.mTextHashed;
    }

    public String getType() {
        return this.mType;
    }

    protected String getViewTag() {
        String str = this.mPendoViewTagBase64;
        return str != null ? str : this.mViewTagBase64;
    }

    public String getViewTagBase64() {
        return this.mViewTagBase64;
    }

    public int hashCode() {
        return g.a(17, 37, this, false, null, excludedFields);
    }

    public boolean isInsideDrawer() {
        return this.mIsInsideDrawer;
    }

    public boolean isInsideList() {
        return this.mIsInsideList;
    }

    public boolean isList() {
        return this.mIsList;
    }

    protected void retrievePendoViewTagAndFormat(View view) {
        try {
            this.mPendoViewTagBase64 = encodeViewTagWithBase64(view.getTag(R.id.pnd_view_tag));
        } catch (Exception unused) {
            this.mPendoViewTagBase64 = null;
        }
    }

    public void retrieveViewTag(View view) {
        retrieveViewTagAndFormat(view);
        retrievePendoViewTagAndFormat(view);
    }

    protected void retrieveViewTagAndFormat(View view) {
        try {
            this.mViewTagBase64 = encodeViewTagWithBase64(view.getTag());
        } catch (Exception unused) {
            this.mViewTagBase64 = null;
        }
    }

    public void setAccessibility(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String b = m0.b(str);
            this.mAccessibilityBase64 = b;
            this.mAccessibilityHashed = m.f1138a.a(b);
        } catch (Exception e) {
            PendoLogger.i(e, "Could not hash the accessibility data" + str, new Object[0]);
            this.mAccessibilityBase64 = null;
            this.mAccessibilityHashed = null;
        }
    }

    public void setAccessibilityHashed(String str) {
        this.mAccessibilityHashed = str;
    }

    public void setChildCount(int i) {
        this.mChildCount = i;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setIdOfParents(ArrayList<String> arrayList) {
        this.mIdOfParents = arrayList;
    }

    public void setIndexInParent(Integer num) {
        this.mIndexInParent = num;
    }

    public void setInsideDrawer(boolean z) {
        this.mIsInsideDrawer = z;
    }

    public void setInsideList(boolean z) {
        this.mIsInsideList = z;
    }

    public void setIsList(boolean z) {
        this.mIsList = z;
    }

    public void setNestedTexts(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        try {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(m0.b(it.next()));
            }
            this.mNestedTextsBase64 = new JSONArray((Collection) arrayList2);
            this.mNestedTextsHashed = m.f1138a.a(m0.a(arrayList2, ""));
        } catch (Exception e) {
            PendoLogger.i(e, "Could not hash the nestedTest", new Object[0]);
            this.mNestedTextsBase64 = null;
            this.mNestedTextsHashed = null;
        }
    }

    public void setNestedTextsHashed(String str) {
        this.mNestedTextsHashed = str;
    }

    public void setParentId(String str) {
        this.mParentId = str;
    }

    protected void setPendoViewTagBase64(String str) {
        this.mPendoViewTagBase64 = str;
    }

    public void setPredicate(View view) {
        this.mRAPredicate = a0.a(view);
    }

    public void setText(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String b = m0.b(str);
            this.mTextBase64 = b;
            this.mTextHashed = m.f1138a.a(b);
        } catch (Exception e) {
            PendoLogger.i(e, "Could not hash the text" + str, new Object[0]);
            this.mTextBase64 = null;
            this.mTextHashed = null;
        }
    }

    public void setTextHashed(String str) {
        this.mTextHashed = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    protected void setViewTagBase64(String str) {
        this.mViewTagBase64 = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        String str = this.mParentId;
        if (str != null) {
            jSONObject.put(FIELD_PARENT_ID, str);
        }
        ArrayList<String> arrayList = this.mIdOfParents;
        if (arrayList != null) {
            jSONObject.put(FIELD_ID_OF_PARENTS, arrayList);
        }
        String str2 = this.mId;
        if (str2 != null) {
            jSONObject.put("id", str2);
        }
        String str3 = this.mType;
        if (str3 != null) {
            jSONObject.put("type", str3);
        }
        String str4 = this.mRAPredicate;
        if (str4 != null) {
            jSONObject.put(RA_PREDICATE, str4);
        }
        if (!TextUtils.isEmpty(this.mAccessibilityHashed)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("label", this.mAccessibilityHashed);
            jSONObject.put(FIELD_ACCESSIBILITY, jSONObject2);
        }
        if (!TextUtils.isEmpty(this.mNestedTextsHashed)) {
            jSONObject.put(FIELD_NESTED_TEXTS_HASHED, this.mNestedTextsHashed);
        }
        if (!TextUtils.isEmpty(this.mTextHashed)) {
            jSONObject.put("text", this.mTextHashed);
        }
        jSONObject.put(FIELD_CHILD_COUNT, this.mChildCount);
        jSONObject.put(FIELD_IS_LIST, this.mIsList);
        jSONObject.put(FIELD_INSIDE_LIST, this.mIsInsideList);
        jSONObject.put(FIELD_INDEX_IN_PARENT, this.mIndexInParent);
        jSONObject.put(FIELD_INSIDE_DRAWER, this.mIsInsideDrawer);
        jSONObject.putOpt(FIELD_VIEW_TAG, getViewTag());
        return jSONObject;
    }

    public String toString() {
        try {
            return toJSON().toString();
        } catch (JSONException e) {
            PendoLogger.e(e);
            return null;
        }
    }

    public d diff(IdentificationData identificationData) {
        sdk.pendo.io.p2.c a2 = new sdk.pendo.io.p2.c(this, identificationData, k.M0, true).a("type", this.mType, identificationData.getType()).a("text", this.mTextHashed, identificationData.getTextHashed()).a(FIELD_INDEX_IN_PARENT, this.mIndexInParent, identificationData.getIndexInParent()).a(FIELD_CHILD_COUNT, this.mChildCount, identificationData.getChildCount()).a("label", this.mAccessibilityHashed, identificationData.getAccessibilityHashed()).a(RA_PREDICATE, this.mRAPredicate, identificationData.getRAPredicate());
        if (!g0.a(this.mId, identificationData.getId())) {
            a2.a("id", this.mId, identificationData.getId());
        }
        if (!g0.a(this.mParentId, identificationData.getParentId())) {
            a2.a(FIELD_PARENT_ID, this.mParentId, identificationData.getParentId());
        }
        ArrayList<String> idOfParents = identificationData.getIdOfParents();
        ArrayList<String> arrayList = this.mIdOfParents;
        if (!(arrayList == null && idOfParents == null) && ((arrayList != null || idOfParents == null) && ((arrayList == null || idOfParents != null) && arrayList.size() == idOfParents.size()))) {
            int i = 0;
            while (true) {
                if (i >= this.mIdOfParents.size()) {
                    break;
                }
                if (!g0.a(this.mIdOfParents.get(i), identificationData.getIdOfParents().get(i))) {
                    a2.a(FIELD_ID_OF_PARENTS, this.mIdOfParents, identificationData.getIdOfParents());
                    break;
                }
                i++;
            }
        } else {
            a2.a(FIELD_ID_OF_PARENTS, this.mIdOfParents, idOfParents);
        }
        return a2.a();
    }

    public void setPredicate(String str) {
        this.mRAPredicate = str;
    }
}
