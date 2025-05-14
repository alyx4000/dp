package com.extole.android.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Me.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/extole/android/sdk/Me;", "", "email", "", "firstName", "lastName", "partnerUserId", "profilePictureUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getFirstName", "getLastName", "getPartnerUserId", "getProfilePictureUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Me {
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String partnerUserId;
    private final String profilePictureUrl;

    public static /* synthetic */ Me copy$default(Me me2, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = me2.email;
        }
        if ((i & 2) != 0) {
            str2 = me2.firstName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = me2.lastName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = me2.partnerUserId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = me2.profilePictureUrl;
        }
        return me2.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPartnerUserId() {
        return this.partnerUserId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getProfilePictureUrl() {
        return this.profilePictureUrl;
    }

    public final Me copy(String email, String firstName, String lastName, String partnerUserId, String profilePictureUrl) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(partnerUserId, "partnerUserId");
        Intrinsics.checkNotNullParameter(profilePictureUrl, "profilePictureUrl");
        return new Me(email, firstName, lastName, partnerUserId, profilePictureUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Me)) {
            return false;
        }
        Me me2 = (Me) other;
        return Intrinsics.areEqual(this.email, me2.email) && Intrinsics.areEqual(this.firstName, me2.firstName) && Intrinsics.areEqual(this.lastName, me2.lastName) && Intrinsics.areEqual(this.partnerUserId, me2.partnerUserId) && Intrinsics.areEqual(this.profilePictureUrl, me2.profilePictureUrl);
    }

    public int hashCode() {
        return (((((((this.email.hashCode() * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.partnerUserId.hashCode()) * 31) + this.profilePictureUrl.hashCode();
    }

    public String toString() {
        return "Me(email=" + this.email + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", partnerUserId=" + this.partnerUserId + ", profilePictureUrl=" + this.profilePictureUrl + ')';
    }

    public Me(String email, String firstName, String lastName, String partnerUserId, String profilePictureUrl) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(partnerUserId, "partnerUserId");
        Intrinsics.checkNotNullParameter(profilePictureUrl, "profilePictureUrl");
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.partnerUserId = partnerUserId;
        this.profilePictureUrl = profilePictureUrl;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPartnerUserId() {
        return this.partnerUserId;
    }

    public final String getProfilePictureUrl() {
        return this.profilePictureUrl;
    }
}
