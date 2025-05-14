package io.branch.referral.util;

import android.content.Context;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequestLogEvent;
import io.branch.referral.ServerResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BranchEvent {
    private final List<BranchUniversalObject> buoList;
    private final JSONObject customProperties;
    private final String eventName;
    private final boolean isStandardEvent;
    private final JSONObject standardProperties;
    private final HashMap<String, Object> topLevelProperties;

    public interface BranchLogEventCallback {
        void onFailure(Exception exc);

        void onSuccess(int i);
    }

    public BranchEvent(BRANCH_STANDARD_EVENT branch_standard_event) {
        this(branch_standard_event.getName());
    }

    public BranchEvent(String str) {
        this.topLevelProperties = new HashMap<>();
        this.standardProperties = new JSONObject();
        this.customProperties = new JSONObject();
        this.eventName = str;
        BRANCH_STANDARD_EVENT[] values = BRANCH_STANDARD_EVENT.values();
        int length = values.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (str.equals(values[i].getName())) {
                z = true;
                break;
            }
            i++;
        }
        this.isStandardEvent = z;
        this.buoList = new ArrayList();
    }

    public BranchEvent setCustomerEventAlias(String str) {
        return addTopLevelProperty(Defines.Jsonkey.CustomerEventAlias.getKey(), str);
    }

    public BranchEvent setAdType(AdType adType) {
        return addStandardProperty(Defines.Jsonkey.AdType.getKey(), adType.getName());
    }

    public BranchEvent setTransactionID(String str) {
        return addStandardProperty(Defines.Jsonkey.TransactionID.getKey(), str);
    }

    public BranchEvent setCurrency(CurrencyType currencyType) {
        return addStandardProperty(Defines.Jsonkey.Currency.getKey(), currencyType.toString());
    }

    public BranchEvent setRevenue(double d) {
        return addStandardProperty(Defines.Jsonkey.Revenue.getKey(), Double.valueOf(d));
    }

    public BranchEvent setShipping(double d) {
        return addStandardProperty(Defines.Jsonkey.Shipping.getKey(), Double.valueOf(d));
    }

    public BranchEvent setTax(double d) {
        return addStandardProperty(Defines.Jsonkey.Tax.getKey(), Double.valueOf(d));
    }

    public BranchEvent setCoupon(String str) {
        return addStandardProperty(Defines.Jsonkey.Coupon.getKey(), str);
    }

    public BranchEvent setAffiliation(String str) {
        return addStandardProperty(Defines.Jsonkey.Affiliation.getKey(), str);
    }

    public BranchEvent setDescription(String str) {
        return addStandardProperty(Defines.Jsonkey.Description.getKey(), str);
    }

    public BranchEvent setSearchQuery(String str) {
        return addStandardProperty(Defines.Jsonkey.SearchQuery.getKey(), str);
    }

    private BranchEvent addStandardProperty(String str, Object obj) {
        if (obj != null) {
            try {
                this.standardProperties.put(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.standardProperties.remove(str);
        }
        return this;
    }

    private BranchEvent addTopLevelProperty(String str, Object obj) {
        if (!this.topLevelProperties.containsKey(str)) {
            this.topLevelProperties.put(str, obj);
        } else {
            this.topLevelProperties.remove(str);
        }
        return this;
    }

    public BranchEvent addCustomDataProperty(String str, String str2) {
        try {
            this.customProperties.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BranchEvent addContentItems(BranchUniversalObject... branchUniversalObjectArr) {
        Collections.addAll(this.buoList, branchUniversalObjectArr);
        return this;
    }

    public BranchEvent addContentItems(List<BranchUniversalObject> list) {
        this.buoList.addAll(list);
        return this;
    }

    public String getEventName() {
        return this.eventName;
    }

    public boolean logEvent(Context context) {
        return logEvent(context, null);
    }

    public boolean logEvent(Context context, final BranchLogEventCallback branchLogEventCallback) {
        Defines.RequestPath requestPath = this.isStandardEvent ? Defines.RequestPath.TrackStandardEvent : Defines.RequestPath.TrackCustomEvent;
        if (Branch.getInstance() != null) {
            Branch.getInstance().requestQueue_.handleNewRequest(new ServerRequestLogEvent(context, requestPath, this.eventName, this.topLevelProperties, this.standardProperties, this.customProperties, this.buoList) { // from class: io.branch.referral.util.BranchEvent.1
                @Override // io.branch.referral.ServerRequestLogEvent, io.branch.referral.ServerRequest
                public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
                    BranchLogEventCallback branchLogEventCallback2 = branchLogEventCallback;
                    if (branchLogEventCallback2 != null) {
                        branchLogEventCallback2.onSuccess(serverResponse.getStatusCode());
                    }
                }

                @Override // io.branch.referral.ServerRequestLogEvent, io.branch.referral.ServerRequest
                public void handleFailure(int i, String str) {
                    if (branchLogEventCallback != null) {
                        branchLogEventCallback.onFailure(new Exception("Failed logEvent server request: " + i + str));
                    }
                }
            });
            return true;
        }
        if (branchLogEventCallback != null) {
            branchLogEventCallback.onFailure(new Exception("Failed logEvent server request: The Branch instance was not available"));
        }
        return false;
    }
}
