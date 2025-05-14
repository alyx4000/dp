package io.branch.referral;

import android.content.Context;
import io.branch.referral.Defines;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BranchQRCodeCache {
    private final Context context_;
    public ConcurrentHashMap<JSONObject, byte[]> cache = new ConcurrentHashMap<>();
    private final SystemObserver systemObserver_ = new SystemObserverInstance();

    public static BranchQRCodeCache getInstance() {
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return null;
        }
        return branch.getBranchQRCodeCache();
    }

    BranchQRCodeCache(Context context) {
        this.context_ = context;
    }

    private class SystemObserverInstance extends SystemObserver {
        public SystemObserverInstance() {
        }
    }

    SystemObserver getSystemObserver() {
        return this.systemObserver_;
    }

    public void addQRCodeToCache(JSONObject jSONObject, byte[] bArr) {
        this.cache.clear();
        try {
            jSONObject.getJSONObject("data").remove(Defines.Jsonkey.CreationTimestamp.getKey());
            this.cache.put(jSONObject, bArr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public byte[] checkQRCodeCache(JSONObject jSONObject) {
        if (this.cache.isEmpty()) {
            return null;
        }
        try {
            jSONObject.getJSONObject("data").remove(Defines.Jsonkey.CreationTimestamp.getKey());
            JSONObject next = this.cache.keySet().iterator().next();
            if (areEqual(jSONObject, next)) {
                return this.cache.get(next);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean areEqual(Object obj, Object obj2) throws JSONException {
        return convertJsonElement(obj).equals(convertJsonElement(obj2));
    }

    private static Object convertJsonElement(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, convertJsonElement(jSONObject.get(next)));
            }
            return hashMap;
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(convertJsonElement(jSONArray.get(i)));
        }
        return hashSet;
    }
}
