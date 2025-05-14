package com.socure.docv.capturesdk.common.network.model.stepup;

import androidx.autofill.HintConstants;
import com.squareup.moshi.JsonClass;
import io.sentry.protocol.Geo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Address;", "", "country", "", "physicalAddress", "physicalAddress2", Geo.JsonKeys.CITY, "state", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getPhysicalAddress", "setPhysicalAddress", "getPhysicalAddress2", "setPhysicalAddress2", "getPostalCode", "setPostalCode", "getState", "setState", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Address {
    private String city;
    private String country;
    private String physicalAddress;
    private String physicalAddress2;
    private String postalCode;
    private String state;

    public Address() {
        this(null, null, null, null, null, null, 63, null);
    }

    public Address(String str, String str2, String str3, String str4, String str5, String str6) {
        this.country = str;
        this.physicalAddress = str2;
        this.physicalAddress2 = str3;
        this.city = str4;
        this.state = str5;
        this.postalCode = str6;
    }

    public /* synthetic */ Address(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public static /* synthetic */ Address copy$default(Address address, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = address.country;
        }
        if ((i & 2) != 0) {
            str2 = address.physicalAddress;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = address.physicalAddress2;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = address.city;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = address.state;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = address.postalCode;
        }
        return address.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhysicalAddress() {
        return this.physicalAddress;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPhysicalAddress2() {
        return this.physicalAddress2;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    public final Address copy(String country, String physicalAddress, String physicalAddress2, String city, String state, String postalCode) {
        return new Address(country, physicalAddress, physicalAddress2, city, state, postalCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address address = (Address) other;
        return Intrinsics.areEqual(this.country, address.country) && Intrinsics.areEqual(this.physicalAddress, address.physicalAddress) && Intrinsics.areEqual(this.physicalAddress2, address.physicalAddress2) && Intrinsics.areEqual(this.city, address.city) && Intrinsics.areEqual(this.state, address.state) && Intrinsics.areEqual(this.postalCode, address.postalCode);
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getPhysicalAddress() {
        return this.physicalAddress;
    }

    public final String getPhysicalAddress2() {
        return this.physicalAddress2;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        String str = this.country;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.physicalAddress;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.physicalAddress2;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.city;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.state;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.postalCode;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setPhysicalAddress(String str) {
        this.physicalAddress = str;
    }

    public final void setPhysicalAddress2(String str) {
        this.physicalAddress2 = str;
    }

    public final void setPostalCode(String str) {
        this.postalCode = str;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public String toString() {
        return "Address(country=" + this.country + ", physicalAddress=" + this.physicalAddress + ", physicalAddress2=" + this.physicalAddress2 + ", city=" + this.city + ", state=" + this.state + ", postalCode=" + this.postalCode + ")";
    }
}
