package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndEnvironment;", "", "name", "", "id", "", "(Ljava/lang/String;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadEndEnvironment {
    private final int id;
    private final String name;

    public UploadEndEnvironment(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.id = i;
    }

    public static /* synthetic */ UploadEndEnvironment copy$default(UploadEndEnvironment uploadEndEnvironment, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uploadEndEnvironment.name;
        }
        if ((i2 & 2) != 0) {
            i = uploadEndEnvironment.id;
        }
        return uploadEndEnvironment.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final UploadEndEnvironment copy(String name, int id) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new UploadEndEnvironment(name, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadEndEnvironment)) {
            return false;
        }
        UploadEndEnvironment uploadEndEnvironment = (UploadEndEnvironment) other;
        return Intrinsics.areEqual(this.name, uploadEndEnvironment.name) && this.id == uploadEndEnvironment.id;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return Integer.hashCode(this.id) + (this.name.hashCode() * 31);
    }

    public String toString() {
        return "UploadEndEnvironment(name=" + this.name + ", id=" + this.id + ")";
    }
}
