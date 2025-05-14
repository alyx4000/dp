package sdk.pendo.io.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.l0.c;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/models/PersonalizationDefVal;", "", "defaultValue", "", "type", "format", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefaultValue", "()Ljava/lang/String;", "setDefaultValue", "(Ljava/lang/String;)V", "getFormat", "setFormat", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class PersonalizationDefVal {

    @c("default")
    private String defaultValue;

    @c("format")
    private String format;

    @c("type")
    private String type;

    public PersonalizationDefVal(String str, String str2, String str3) {
        this.defaultValue = str;
        this.type = str2;
        this.format = str3;
    }

    public static /* synthetic */ PersonalizationDefVal copy$default(PersonalizationDefVal personalizationDefVal, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = personalizationDefVal.defaultValue;
        }
        if ((i & 2) != 0) {
            str2 = personalizationDefVal.type;
        }
        if ((i & 4) != 0) {
            str3 = personalizationDefVal.format;
        }
        return personalizationDefVal.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDefaultValue() {
        return this.defaultValue;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    public final PersonalizationDefVal copy(String defaultValue, String type, String format) {
        return new PersonalizationDefVal(defaultValue, type, format);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonalizationDefVal)) {
            return false;
        }
        PersonalizationDefVal personalizationDefVal = (PersonalizationDefVal) other;
        return Intrinsics.areEqual(this.defaultValue, personalizationDefVal.defaultValue) && Intrinsics.areEqual(this.type, personalizationDefVal.type) && Intrinsics.areEqual(this.format, personalizationDefVal.format);
    }

    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.defaultValue;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.format;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public final void setFormat(String str) {
        this.format = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "PersonalizationDefVal(defaultValue=" + this.defaultValue + ", type=" + this.type + ", format=" + this.format + ")";
    }
}
