package io.branch.referral;

import android.text.TextUtils;
import io.branch.referral.Defines;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class BranchLinkData extends JSONObject {
    private String alias;
    private String campaign;
    private String channel;
    private int duration;
    private String feature;
    private JSONObject params;
    private String stage;
    private Collection<String> tags;
    private int type;

    public void putTags(Collection<String> collection) throws JSONException {
        if (collection != null) {
            this.tags = collection;
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            put(Defines.LinkParam.Tags.getKey(), jSONArray);
        }
    }

    public Collection<String> getTags() {
        return this.tags;
    }

    public void putAlias(String str) throws JSONException {
        if (str != null) {
            this.alias = str;
            put(Defines.LinkParam.Alias.getKey(), str);
        }
    }

    public String getAlias() {
        return this.alias;
    }

    public void putType(int i) throws JSONException {
        if (i != 0) {
            this.type = i;
            put(Defines.LinkParam.Type.getKey(), i);
        }
    }

    public int getType() {
        return this.type;
    }

    public void putDuration(int i) throws JSONException {
        if (i > 0) {
            this.duration = i;
            put(Defines.LinkParam.Duration.getKey(), i);
        }
    }

    public int getDuration() {
        return this.duration;
    }

    public void putChannel(String str) throws JSONException {
        if (str != null) {
            this.channel = str;
            put(Defines.LinkParam.Channel.getKey(), str);
        }
    }

    public String getChannel() {
        return this.channel;
    }

    public void putFeature(String str) throws JSONException {
        if (str != null) {
            this.feature = str;
            put(Defines.LinkParam.Feature.getKey(), str);
        }
    }

    public String getFeature() {
        return this.feature;
    }

    public void putStage(String str) throws JSONException {
        if (str != null) {
            this.stage = str;
            put(Defines.LinkParam.Stage.getKey(), str);
        }
    }

    public String getStage() {
        return this.stage;
    }

    public void putCampaign(String str) throws JSONException {
        if (str != null) {
            this.campaign = str;
            put(Defines.LinkParam.Campaign.getKey(), str);
        }
    }

    public String getCampaign() {
        return this.campaign;
    }

    public void putParams(JSONObject jSONObject) throws JSONException {
        this.params = jSONObject;
        put(Defines.LinkParam.Data.getKey(), jSONObject);
    }

    public JSONObject getParams() {
        return this.params;
    }

    public void putSource() throws JSONException {
        put("source", Defines.Jsonkey.URLSource.getKey());
    }

    public String getSource() {
        return Defines.Jsonkey.URLSource.getKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BranchLinkData branchLinkData = (BranchLinkData) obj;
        String str = this.alias;
        if (str == null) {
            if (branchLinkData.alias != null) {
                return false;
            }
        } else if (!str.equals(branchLinkData.alias)) {
            return false;
        }
        String str2 = this.channel;
        if (str2 == null) {
            if (branchLinkData.channel != null) {
                return false;
            }
        } else if (!str2.equals(branchLinkData.channel)) {
            return false;
        }
        String str3 = this.feature;
        if (str3 == null) {
            if (branchLinkData.feature != null) {
                return false;
            }
        } else if (!str3.equals(branchLinkData.feature)) {
            return false;
        }
        String str4 = this.stage;
        if (str4 == null) {
            if (branchLinkData.stage != null) {
                return false;
            }
        } else if (!str4.equals(branchLinkData.stage)) {
            return false;
        }
        String str5 = this.campaign;
        if (str5 == null) {
            if (branchLinkData.campaign != null) {
                return false;
            }
        } else if (!str5.equals(branchLinkData.campaign)) {
            return false;
        }
        if (this.type != branchLinkData.type || this.duration != branchLinkData.duration) {
            return false;
        }
        Collection<String> collection = this.tags;
        if (collection == null) {
            if (branchLinkData.tags != null) {
                return false;
            }
        } else {
            String obj2 = collection.toString();
            Collection<String> collection2 = branchLinkData.tags;
            if (!obj2.equals(collection2 != null ? collection2.toString() : null)) {
                return false;
            }
        }
        JSONObject jSONObject = this.params;
        if (jSONObject == null) {
            if (branchLinkData.params != null) {
                return false;
            }
        } else {
            String jSONObject2 = jSONObject.toString();
            JSONObject jSONObject3 = branchLinkData.params;
            if (!jSONObject2.equals(jSONObject3 != null ? jSONObject3.toString() : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = (this.type + 19) * 19;
        String str = this.alias;
        int hashCode = (i + (str == null ? 0 : str.toLowerCase().hashCode())) * 19;
        String str2 = this.channel;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.toLowerCase().hashCode())) * 19;
        String str3 = this.feature;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.toLowerCase().hashCode())) * 19;
        String str4 = this.stage;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.toLowerCase().hashCode())) * 19;
        String str5 = this.campaign;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.toLowerCase().hashCode())) * 19;
        JSONObject jSONObject = this.params;
        int hashCode6 = ((hashCode5 + (jSONObject != null ? jSONObject.toString().toLowerCase().hashCode() : 0)) * 19) + this.duration;
        Collection<String> collection = this.tags;
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                hashCode6 = (hashCode6 * 19) + it.next().toLowerCase().hashCode();
            }
        }
        return hashCode6;
    }

    public JSONObject getLinkDataJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.channel)) {
                jSONObject.put("~" + Defines.LinkParam.Channel.getKey(), this.channel);
            }
            if (!TextUtils.isEmpty(this.alias)) {
                jSONObject.put("~" + Defines.LinkParam.Alias.getKey(), this.alias);
            }
            if (!TextUtils.isEmpty(this.feature)) {
                jSONObject.put("~" + Defines.LinkParam.Feature.getKey(), this.feature);
            }
            if (!TextUtils.isEmpty(this.stage)) {
                jSONObject.put("~" + Defines.LinkParam.Stage.getKey(), this.stage);
            }
            if (!TextUtils.isEmpty(this.campaign)) {
                jSONObject.put("~" + Defines.LinkParam.Campaign.getKey(), this.campaign);
            }
            if (has(Defines.LinkParam.Tags.getKey())) {
                jSONObject.put(Defines.LinkParam.Tags.getKey(), getJSONArray(Defines.LinkParam.Tags.getKey()));
            }
            jSONObject.put("~" + Defines.LinkParam.Type.getKey(), this.type);
            jSONObject.put("~" + Defines.LinkParam.Duration.getKey(), this.duration);
        } catch (JSONException e) {
            BranchLogger.d(e.getMessage());
        }
        return jSONObject;
    }
}
