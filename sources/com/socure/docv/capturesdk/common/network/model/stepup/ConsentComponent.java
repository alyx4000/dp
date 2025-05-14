package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJF\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006 "}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentComponent;", "", "id", "", "mandatory", "", "type", "content", "selected", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getContent", "()Ljava/lang/String;", "getId", "getMandatory", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelected", "setSelected", "(Ljava/lang/Boolean;)V", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentComponent;", "equals", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConsentComponent {
    private final String content;
    private final String id;
    private final Boolean mandatory;
    private Boolean selected;
    private final String type;

    public ConsentComponent(String str, Boolean bool, String type, String content, Boolean bool2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        this.id = str;
        this.mandatory = bool;
        this.type = type;
        this.content = content;
        this.selected = bool2;
    }

    public /* synthetic */ ConsentComponent(String str, Boolean bool, String str2, String str3, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, bool, str2, str3, bool2);
    }

    public static /* synthetic */ ConsentComponent copy$default(ConsentComponent consentComponent, String str, Boolean bool, String str2, String str3, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consentComponent.id;
        }
        if ((i & 2) != 0) {
            bool = consentComponent.mandatory;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            str2 = consentComponent.type;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = consentComponent.content;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            bool2 = consentComponent.selected;
        }
        return consentComponent.copy(str, bool3, str4, str5, bool2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getMandatory() {
        return this.mandatory;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getSelected() {
        return this.selected;
    }

    public final ConsentComponent copy(String id, Boolean mandatory, String type, String content, Boolean selected) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        return new ConsentComponent(id, mandatory, type, content, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentComponent)) {
            return false;
        }
        ConsentComponent consentComponent = (ConsentComponent) other;
        return Intrinsics.areEqual(this.id, consentComponent.id) && Intrinsics.areEqual(this.mandatory, consentComponent.mandatory) && Intrinsics.areEqual(this.type, consentComponent.type) && Intrinsics.areEqual(this.content, consentComponent.content) && Intrinsics.areEqual(this.selected, consentComponent.selected);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getMandatory() {
        return this.mandatory;
    }

    public final Boolean getSelected() {
        return this.selected;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.mandatory;
        int a2 = com.socure.docv.capturesdk.common.analytics.model.a.a(this.content, com.socure.docv.capturesdk.common.analytics.model.a.a(this.type, (hashCode + (bool == null ? 0 : bool.hashCode())) * 31, 31), 31);
        Boolean bool2 = this.selected;
        return a2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setSelected(Boolean bool) {
        this.selected = bool;
    }

    public String toString() {
        return "ConsentComponent(id=" + this.id + ", mandatory=" + this.mandatory + ", type=" + this.type + ", content=" + this.content + ", selected=" + this.selected + ")";
    }
}
