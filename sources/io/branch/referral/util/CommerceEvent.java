package io.branch.referral.util;

import io.sentry.ProfilingTraceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CommerceEvent {
    private String affiliation;
    private String coupon;
    private CurrencyType currencyType;
    private List<Product> products;
    private Double revenue;
    private Double shipping;
    private Double tax;
    private String transactionID;

    public Double getRevenue() {
        return this.revenue;
    }

    public void setRevenue(Double d) {
        this.revenue = d;
    }

    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTransactionID(String str) {
        this.transactionID = str;
    }

    public Double getShipping() {
        return this.shipping;
    }

    public void setShipping(Double d) {
        this.shipping = d;
    }

    public Double getTax() {
        return this.tax;
    }

    public void setTax(Double d) {
        this.tax = d;
    }

    public String getCoupon() {
        return this.coupon;
    }

    public void setCoupon(String str) {
        this.coupon = str;
    }

    public String getAffiliation() {
        return this.affiliation;
    }

    public void setAffiliation(String str) {
        this.affiliation = str;
    }

    public void setProducts(List<Product> list) {
        this.products = list;
    }

    public void addProduct(Product product) {
        if (this.products == null) {
            this.products = new ArrayList();
        }
        this.products.add(product);
    }

    public CommerceEvent() {
    }

    public CommerceEvent(Double d, CurrencyType currencyType, String str, Double d2, Double d3, String str2, String str3, List<Product> list) {
        this.revenue = d;
        this.currencyType = currencyType;
        this.transactionID = str;
        this.shipping = d2;
        this.tax = d3;
        this.coupon = str2;
        this.affiliation = str3;
        this.products = list;
    }

    public CommerceEvent(Double d, CurrencyType currencyType, String str, Double d2, Double d3, String str2, String str3, Product product) {
        this.revenue = d;
        this.currencyType = currencyType;
        this.transactionID = str;
        this.shipping = d2;
        this.tax = d3;
        this.coupon = str2;
        this.affiliation = str3;
        ArrayList arrayList = new ArrayList();
        this.products = arrayList;
        arrayList.add(product);
    }

    public JSONObject getCommerceJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("revenue", this.revenue);
            jSONObject.put("currency", this.currencyType);
            jSONObject.put(ProfilingTraceData.JsonKeys.TRANSACTION_ID, this.transactionID);
            jSONObject.put("shipping", this.shipping);
            jSONObject.put("tax", this.tax);
            jSONObject.put("coupon", this.coupon);
            jSONObject.put("affiliation", this.affiliation);
            if (getProducts() != null) {
                jSONObject.put("products", getProducts());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public List<JSONObject> getProducts() {
        if (this.products == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Product> it = this.products.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getProductJSONObject());
        }
        return arrayList;
    }
}
