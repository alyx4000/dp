package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0001\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Errors;", "", "ivs", "", "", "(Ljava/util/Map;)V", "getIvs", "()Ljava/util/Map;", "setIvs", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Errors {
    private Map<String, String> ivs;

    public Errors(@Json(name = "ivs") Map<String, String> ivs) {
        Intrinsics.checkNotNullParameter(ivs, "ivs");
        this.ivs = ivs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Errors copy$default(Errors errors, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = errors.ivs;
        }
        return errors.copy(map);
    }

    public final Map<String, String> component1() {
        return this.ivs;
    }

    public final Errors copy(@Json(name = "ivs") Map<String, String> ivs) {
        Intrinsics.checkNotNullParameter(ivs, "ivs");
        return new Errors(ivs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Errors) && Intrinsics.areEqual(this.ivs, ((Errors) other).ivs);
    }

    public final Map<String, String> getIvs() {
        return this.ivs;
    }

    public int hashCode() {
        return this.ivs.hashCode();
    }

    public final void setIvs(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.ivs = map;
    }

    public String toString() {
        return "Errors(ivs=" + this.ivs + ")";
    }
}
