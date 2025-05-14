package com.socure.docv.capturesdk.feature.orchestrator.data;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/socure/docv/capturesdk/feature/orchestrator/data/EmptyDataClass;", "", "emptyValue", "", "(Ljava/lang/String;)V", "getEmptyValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EmptyDataClass {
    private final String emptyValue;

    public EmptyDataClass() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EmptyDataClass(String str) {
        this.emptyValue = str;
    }

    public /* synthetic */ EmptyDataClass(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public static /* synthetic */ EmptyDataClass copy$default(EmptyDataClass emptyDataClass, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emptyDataClass.emptyValue;
        }
        return emptyDataClass.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmptyValue() {
        return this.emptyValue;
    }

    public final EmptyDataClass copy(String emptyValue) {
        return new EmptyDataClass(emptyValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EmptyDataClass) && Intrinsics.areEqual(this.emptyValue, ((EmptyDataClass) other).emptyValue);
    }

    public final String getEmptyValue() {
        return this.emptyValue;
    }

    public int hashCode() {
        String str = this.emptyValue;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "EmptyDataClass(emptyValue=" + this.emptyValue + ")";
    }
}
