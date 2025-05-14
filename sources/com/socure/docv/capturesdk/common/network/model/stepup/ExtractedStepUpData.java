package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import io.sentry.SentryLockReason;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u007f\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010¨\u00067"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "", "issueDate", "", SentryLockReason.JsonKeys.ADDRESS, "parsedAddress", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Address;", "type", "firstName", "surName", "dob", "expirationDate", "documentNumber", "fullName", "(Ljava/lang/String;Ljava/lang/String;Lcom/socure/docv/capturesdk/common/network/model/stepup/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getDob", "setDob", "getDocumentNumber", "setDocumentNumber", "getExpirationDate", "setExpirationDate", "getFirstName", "setFirstName", "getFullName", "setFullName", "getIssueDate", "setIssueDate", "getParsedAddress", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/Address;", "setParsedAddress", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/Address;)V", "getSurName", "setSurName", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExtractedStepUpData {
    private String address;
    private String dob;
    private String documentNumber;
    private String expirationDate;
    private String firstName;
    private String fullName;
    private String issueDate;
    private Address parsedAddress;
    private String surName;
    private final String type;

    public ExtractedStepUpData(String str, String str2, Address address, String type, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.issueDate = str;
        this.address = str2;
        this.parsedAddress = address;
        this.type = type;
        this.firstName = str3;
        this.surName = str4;
        this.dob = str5;
        this.expirationDate = str6;
        this.documentNumber = str7;
        this.fullName = str8;
    }

    public /* synthetic */ ExtractedStepUpData(String str, String str2, Address address, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : address, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIssueDate() {
        return this.issueDate;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component3, reason: from getter */
    public final Address getParsedAddress() {
        return this.parsedAddress;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSurName() {
        return this.surName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDob() {
        return this.dob;
    }

    /* renamed from: component8, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    public final ExtractedStepUpData copy(String issueDate, String address, Address parsedAddress, String type, String firstName, String surName, String dob, String expirationDate, String documentNumber, String fullName) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ExtractedStepUpData(issueDate, address, parsedAddress, type, firstName, surName, dob, expirationDate, documentNumber, fullName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtractedStepUpData)) {
            return false;
        }
        ExtractedStepUpData extractedStepUpData = (ExtractedStepUpData) other;
        return Intrinsics.areEqual(this.issueDate, extractedStepUpData.issueDate) && Intrinsics.areEqual(this.address, extractedStepUpData.address) && Intrinsics.areEqual(this.parsedAddress, extractedStepUpData.parsedAddress) && Intrinsics.areEqual(this.type, extractedStepUpData.type) && Intrinsics.areEqual(this.firstName, extractedStepUpData.firstName) && Intrinsics.areEqual(this.surName, extractedStepUpData.surName) && Intrinsics.areEqual(this.dob, extractedStepUpData.dob) && Intrinsics.areEqual(this.expirationDate, extractedStepUpData.expirationDate) && Intrinsics.areEqual(this.documentNumber, extractedStepUpData.documentNumber) && Intrinsics.areEqual(this.fullName, extractedStepUpData.fullName);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDob() {
        return this.dob;
    }

    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getIssueDate() {
        return this.issueDate;
    }

    public final Address getParsedAddress() {
        return this.parsedAddress;
    }

    public final String getSurName() {
        return this.surName;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.issueDate;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.address;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Address address = this.parsedAddress;
        int a2 = com.socure.docv.capturesdk.common.analytics.model.a.a(this.type, (hashCode2 + (address == null ? 0 : address.hashCode())) * 31, 31);
        String str3 = this.firstName;
        int hashCode3 = (a2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.surName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.dob;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.expirationDate;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.documentNumber;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.fullName;
        return hashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setDob(String str) {
        this.dob = str;
    }

    public final void setDocumentNumber(String str) {
        this.documentNumber = str;
    }

    public final void setExpirationDate(String str) {
        this.expirationDate = str;
    }

    public final void setFirstName(String str) {
        this.firstName = str;
    }

    public final void setFullName(String str) {
        this.fullName = str;
    }

    public final void setIssueDate(String str) {
        this.issueDate = str;
    }

    public final void setParsedAddress(Address address) {
        this.parsedAddress = address;
    }

    public final void setSurName(String str) {
        this.surName = str;
    }

    public String toString() {
        return "ExtractedStepUpData(issueDate=" + this.issueDate + ", address=" + this.address + ", parsedAddress=" + this.parsedAddress + ", type=" + this.type + ", firstName=" + this.firstName + ", surName=" + this.surName + ", dob=" + this.dob + ", expirationDate=" + this.expirationDate + ", documentNumber=" + this.documentNumber + ", fullName=" + this.fullName + ")";
    }
}
