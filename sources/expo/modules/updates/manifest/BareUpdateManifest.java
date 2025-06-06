package expo.modules.updates.manifest;

import android.util.Log;
import expo.modules.manifests.core.BareManifest;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import expo.modules.updates.loader.EmbeddedLoader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BareUpdateManifest.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0017R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lexpo/modules/updates/manifest/BareUpdateManifest;", "Lexpo/modules/updates/manifest/UpdateManifest;", "manifest", "Lexpo/modules/manifests/core/BareManifest;", "mId", "Ljava/util/UUID;", "mScopeKey", "", "mCommitTime", "Ljava/util/Date;", "mRuntimeVersion", "mAssets", "Lorg/json/JSONArray;", "(Lexpo/modules/manifests/core/BareManifest;Ljava/util/UUID;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lorg/json/JSONArray;)V", "assetEntityList", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getAssetEntityList", "()Ljava/util/List;", "assetEntityList$delegate", "Lkotlin/Lazy;", "isDevelopmentMode", "", "()Z", "getManifest", "()Lexpo/modules/manifests/core/BareManifest;", "updateEntity", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getUpdateEntity", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "updateEntity$delegate", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BareUpdateManifest implements UpdateManifest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "BareUpdateManifest";

    /* renamed from: assetEntityList$delegate, reason: from kotlin metadata */
    private final Lazy assetEntityList;
    private final boolean isDevelopmentMode;
    private final JSONArray mAssets;
    private final Date mCommitTime;
    private final UUID mId;
    private final String mRuntimeVersion;
    private final String mScopeKey;
    private final BareManifest manifest;

    /* renamed from: updateEntity$delegate, reason: from kotlin metadata */
    private final Lazy updateEntity;

    public /* synthetic */ BareUpdateManifest(BareManifest bareManifest, UUID uuid, String str, Date date, String str2, JSONArray jSONArray, DefaultConstructorMarker defaultConstructorMarker) {
        this(bareManifest, uuid, str, date, str2, jSONArray);
    }

    private BareUpdateManifest(BareManifest bareManifest, UUID uuid, String str, Date date, String str2, JSONArray jSONArray) {
        this.manifest = bareManifest;
        this.mId = uuid;
        this.mScopeKey = str;
        this.mCommitTime = date;
        this.mRuntimeVersion = str2;
        this.mAssets = jSONArray;
        this.updateEntity = LazyKt.lazy(new Function0<UpdateEntity>() { // from class: expo.modules.updates.manifest.BareUpdateManifest$updateEntity$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UpdateEntity invoke() {
                UUID uuid2;
                Date date2;
                String str3;
                String str4;
                uuid2 = BareUpdateManifest.this.mId;
                date2 = BareUpdateManifest.this.mCommitTime;
                str3 = BareUpdateManifest.this.mRuntimeVersion;
                str4 = BareUpdateManifest.this.mScopeKey;
                UpdateEntity updateEntity = new UpdateEntity(uuid2, date2, str3, str4, BareUpdateManifest.this.getManifest().getRawJson());
                updateEntity.setStatus(UpdateStatus.EMBEDDED);
                return updateEntity;
            }
        });
        this.assetEntityList = LazyKt.lazy(new Function0<List<AssetEntity>>() { // from class: expo.modules.updates.manifest.BareUpdateManifest$assetEntityList$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<AssetEntity> invoke() {
                UUID uuid2;
                JSONArray jSONArray2;
                JSONArray jSONArray3;
                JSONArray jSONArray4;
                String str3;
                JSONArray jSONArray5;
                String str4;
                String str5;
                JSONArray jSONArray6;
                ArrayList arrayList = new ArrayList();
                uuid2 = BareUpdateManifest.this.mId;
                AssetEntity assetEntity = new AssetEntity("bundle-" + uuid2, "js");
                assetEntity.setLaunchAsset(true);
                assetEntity.setEmbeddedAssetFilename(EmbeddedLoader.BARE_BUNDLE_FILENAME);
                arrayList.add(assetEntity);
                jSONArray2 = BareUpdateManifest.this.mAssets;
                if (jSONArray2 != null) {
                    jSONArray3 = BareUpdateManifest.this.mAssets;
                    if (jSONArray3.length() > 0) {
                        jSONArray4 = BareUpdateManifest.this.mAssets;
                        int length = jSONArray4.length();
                        for (int i = 0; i < length; i++) {
                            try {
                                jSONArray5 = BareUpdateManifest.this.mAssets;
                                JSONObject assetObject = jSONArray5.getJSONObject(i);
                                AssetEntity assetEntity2 = new AssetEntity(assetObject.getString("packagerHash"), assetObject.getString("type"));
                                Intrinsics.checkNotNullExpressionValue(assetObject, "assetObject");
                                JSONArray jSONArray7 = null;
                                if (assetObject.has("resourcesFilename")) {
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                        str4 = assetObject.getString("resourcesFilename");
                                        if (str4 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        str4 = (String) Double.valueOf(assetObject.getDouble("resourcesFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        str4 = (String) Integer.valueOf(assetObject.getInt("resourcesFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str4 = (String) Long.valueOf(assetObject.getLong("resourcesFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        str4 = (String) Boolean.valueOf(assetObject.getBoolean("resourcesFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        Object jSONArray8 = assetObject.getJSONArray("resourcesFilename");
                                        if (jSONArray8 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str4 = (String) jSONArray8;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object jSONObject = assetObject.getJSONObject("resourcesFilename");
                                        if (jSONObject == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str4 = (String) jSONObject;
                                    } else {
                                        Object obj = assetObject.get("resourcesFilename");
                                        if (obj == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str4 = (String) obj;
                                    }
                                } else {
                                    str4 = null;
                                }
                                assetEntity2.setResourcesFilename(str4);
                                if (assetObject.has("resourcesFolder")) {
                                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                        str5 = assetObject.getString("resourcesFolder");
                                        if (str5 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        str5 = (String) Double.valueOf(assetObject.getDouble("resourcesFolder"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        str5 = (String) Integer.valueOf(assetObject.getInt("resourcesFolder"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str5 = (String) Long.valueOf(assetObject.getLong("resourcesFolder"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        str5 = (String) Boolean.valueOf(assetObject.getBoolean("resourcesFolder"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        Object jSONArray9 = assetObject.getJSONArray("resourcesFolder");
                                        if (jSONArray9 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str5 = (String) jSONArray9;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object jSONObject2 = assetObject.getJSONObject("resourcesFolder");
                                        if (jSONObject2 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str5 = (String) jSONObject2;
                                    } else {
                                        Object obj2 = assetObject.get("resourcesFolder");
                                        if (obj2 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str5 = (String) obj2;
                                    }
                                } else {
                                    str5 = null;
                                }
                                assetEntity2.setResourcesFolder(str5);
                                if (assetObject.has("scales")) {
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JSONArray.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                        Object string = assetObject.getString("scales");
                                        if (string == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                                        }
                                        jSONArray6 = (JSONArray) string;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        jSONArray6 = (JSONArray) Double.valueOf(assetObject.getDouble("scales"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        jSONArray6 = (JSONArray) Integer.valueOf(assetObject.getInt("scales"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        jSONArray6 = (JSONArray) Long.valueOf(assetObject.getLong("scales"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        jSONArray6 = (JSONArray) Boolean.valueOf(assetObject.getBoolean("scales"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        jSONArray6 = assetObject.getJSONArray("scales");
                                        if (jSONArray6 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object jSONObject3 = assetObject.getJSONObject("scales");
                                        if (jSONObject3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                                        }
                                        jSONArray6 = (JSONArray) jSONObject3;
                                    } else {
                                        Object obj3 = assetObject.get("scales");
                                        if (obj3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                                        }
                                        jSONArray6 = (JSONArray) obj3;
                                    }
                                    jSONArray7 = jSONArray6;
                                }
                                if (jSONArray7 != null && jSONArray7.length() > 1) {
                                    assetEntity2.setScale(Float.valueOf((float) assetObject.optDouble("scale")));
                                    int length2 = jSONArray7.length();
                                    Float[] fArr = new Float[length2];
                                    for (int i2 = 0; i2 < length2; i2++) {
                                        fArr[i2] = Float.valueOf(0.0f);
                                    }
                                    int length3 = jSONArray7.length();
                                    for (int i3 = 0; i3 < length3; i3++) {
                                        fArr[i3] = Float.valueOf((float) jSONArray7.getDouble(i3));
                                    }
                                    assetEntity2.setScales(fArr);
                                }
                                arrayList.add(assetEntity2);
                            } catch (JSONException e) {
                                str3 = BareUpdateManifest.TAG;
                                Log.e(str3, "Could not read asset from manifest", e);
                            }
                        }
                    }
                }
                return arrayList;
            }
        });
    }

    @Override // expo.modules.updates.manifest.UpdateManifest
    public BareManifest getManifest() {
        return this.manifest;
    }

    @Override // expo.modules.updates.manifest.UpdateManifest
    public UpdateEntity getUpdateEntity() {
        return (UpdateEntity) this.updateEntity.getValue();
    }

    @Override // expo.modules.updates.manifest.UpdateManifest
    public List<AssetEntity> getAssetEntityList() {
        return (List) this.assetEntityList.getValue();
    }

    @Override // expo.modules.updates.manifest.UpdateManifest
    /* renamed from: isDevelopmentMode, reason: from getter */
    public boolean getIsDevelopmentMode() {
        return this.isDevelopmentMode;
    }

    /* compiled from: BareUpdateManifest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/updates/manifest/BareUpdateManifest$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "fromBareManifest", "Lexpo/modules/updates/manifest/BareUpdateManifest;", "manifest", "Lexpo/modules/manifests/core/BareManifest;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BareUpdateManifest fromBareManifest(BareManifest manifest, UpdatesConfiguration configuration) throws JSONException {
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            UUID id = UUID.fromString(manifest.getID());
            Date date = new Date(manifest.getCommitTimeLong());
            String runtimeVersion = configuration.getRuntimeVersion();
            JSONArray assets = manifest.getAssets();
            if (StringsKt.contains$default((CharSequence) runtimeVersion, (CharSequence) ",", false, 2, (Object) null)) {
                throw new AssertionError("Should not be initializing a BareManifest in an environment with multiple runtime versions.");
            }
            Intrinsics.checkNotNullExpressionValue(id, "id");
            return new BareUpdateManifest(manifest, id, configuration.getScopeKey(), date, runtimeVersion, assets, null);
        }
    }
}
