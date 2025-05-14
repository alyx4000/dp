package com.socure.docv.capturesdk.common.config.model;

import android.os.Parcel;
import android.os.Parcelable;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\"B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/socure/docv/capturesdk/common/config/model/ModelConfig;", "Landroid/os/Parcelable;", "path", "", "confidence", "", "type", "Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;", "(Ljava/lang/String;Ljava/lang/Float;Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;)V", "getConfidence", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPath", "()Ljava/lang/String;", "getType", "()Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Float;Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;)Lcom/socure/docv/capturesdk/common/config/model/ModelConfig;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Type", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelConfig implements Parcelable {
    public static final Parcelable.Creator<ModelConfig> CREATOR = new Creator();
    private final Float confidence;
    private final String path;
    private final Type type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ModelConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ModelConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ModelConfig(parcel.readString(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), Type.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ModelConfig[] newArray(int i) {
            return new ModelConfig[i];
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;", "", "(Ljava/lang/String;I)V", "BLUR", "CORNER", "GLARE", "GLARE_INTENSITY", "UNKNOWN", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        BLUR,
        CORNER,
        GLARE,
        GLARE_INTENSITY,
        UNKNOWN
    }

    public ModelConfig(String str, Float f, Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.path = str;
        this.confidence = f;
        this.type = type;
    }

    public static /* synthetic */ ModelConfig copy$default(ModelConfig modelConfig, String str, Float f, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelConfig.path;
        }
        if ((i & 2) != 0) {
            f = modelConfig.confidence;
        }
        if ((i & 4) != 0) {
            type = modelConfig.type;
        }
        return modelConfig.copy(str, f, type);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final Float getConfidence() {
        return this.confidence;
    }

    /* renamed from: component3, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final ModelConfig copy(String path, Float confidence, Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ModelConfig(path, confidence, type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelConfig)) {
            return false;
        }
        ModelConfig modelConfig = (ModelConfig) other;
        return Intrinsics.areEqual(this.path, modelConfig.path) && Intrinsics.areEqual((Object) this.confidence, (Object) modelConfig.confidence) && this.type == modelConfig.type;
    }

    public final Float getConfidence() {
        return this.confidence;
    }

    public final String getPath() {
        return this.path;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.path;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f = this.confidence;
        return this.type.hashCode() + ((hashCode + (f != null ? f.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "ModelConfig(path=" + this.path + ", confidence=" + this.confidence + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.path);
        Float f = this.confidence;
        if (f == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f.floatValue());
        }
        parcel.writeString(this.type.name());
    }
}
