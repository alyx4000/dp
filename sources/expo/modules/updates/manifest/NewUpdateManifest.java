package expo.modules.updates.manifest;

import android.net.Uri;
import android.util.Log;
import com.amplitude.reactnative.DatabaseConstants;
import expo.modules.manifests.core.NewManifest;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.EmbeddedLoader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NewUpdateManifest.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'BK\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lexpo/modules/updates/manifest/NewUpdateManifest;", "Lexpo/modules/updates/manifest/UpdateManifest;", "manifest", "Lexpo/modules/manifests/core/NewManifest;", "mId", "Ljava/util/UUID;", "mScopeKey", "", "mCommitTime", "Ljava/util/Date;", "mRuntimeVersion", "mLaunchAsset", "Lorg/json/JSONObject;", "mAssets", "Lorg/json/JSONArray;", "mExtensions", "(Lexpo/modules/manifests/core/NewManifest;Ljava/util/UUID;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONObject;)V", "assetEntityList", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getAssetEntityList", "()Ljava/util/List;", "assetEntityList$delegate", "Lkotlin/Lazy;", "assetHeaders", "", "getAssetHeaders", "()Ljava/util/Map;", "assetHeaders$delegate", "isDevelopmentMode", "", "()Z", "getManifest", "()Lexpo/modules/manifests/core/NewManifest;", "updateEntity", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getUpdateEntity", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "updateEntity$delegate", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewUpdateManifest implements UpdateManifest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "UpdateManifest";

    /* renamed from: assetEntityList$delegate, reason: from kotlin metadata */
    private final Lazy assetEntityList;

    /* renamed from: assetHeaders$delegate, reason: from kotlin metadata */
    private final Lazy assetHeaders;
    private final boolean isDevelopmentMode;
    private final JSONArray mAssets;
    private final Date mCommitTime;
    private final JSONObject mExtensions;
    private final UUID mId;
    private final JSONObject mLaunchAsset;
    private final String mRuntimeVersion;
    private final String mScopeKey;
    private final NewManifest manifest;

    /* renamed from: updateEntity$delegate, reason: from kotlin metadata */
    private final Lazy updateEntity;

    public /* synthetic */ NewUpdateManifest(NewManifest newManifest, UUID uuid, String str, Date date, String str2, JSONObject jSONObject, JSONArray jSONArray, JSONObject jSONObject2, DefaultConstructorMarker defaultConstructorMarker) {
        this(newManifest, uuid, str, date, str2, jSONObject, jSONArray, jSONObject2);
    }

    private NewUpdateManifest(NewManifest newManifest, UUID uuid, String str, Date date, String str2, JSONObject jSONObject, JSONArray jSONArray, JSONObject jSONObject2) {
        this.manifest = newManifest;
        this.mId = uuid;
        this.mScopeKey = str;
        this.mCommitTime = date;
        this.mRuntimeVersion = str2;
        this.mLaunchAsset = jSONObject;
        this.mAssets = jSONArray;
        this.mExtensions = jSONObject2;
        this.updateEntity = LazyKt.lazy(new Function0<UpdateEntity>() { // from class: expo.modules.updates.manifest.NewUpdateManifest$updateEntity$2
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
                uuid2 = NewUpdateManifest.this.mId;
                date2 = NewUpdateManifest.this.mCommitTime;
                str3 = NewUpdateManifest.this.mRuntimeVersion;
                str4 = NewUpdateManifest.this.mScopeKey;
                return new UpdateEntity(uuid2, date2, str3, str4, NewUpdateManifest.this.getManifest().getRawJson());
            }
        });
        this.assetHeaders = LazyKt.lazy(new Function0<Map<String, ? extends JSONObject>>() { // from class: expo.modules.updates.manifest.NewUpdateManifest$assetHeaders$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends JSONObject> invoke() {
                JSONObject jSONObject3;
                JSONObject jSONObject4;
                JSONObject jSONObject5;
                jSONObject3 = NewUpdateManifest.this.mExtensions;
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                if (jSONObject3.has("assetRequestHeaders")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object string = jSONObject3.getString("assetRequestHeaders");
                        if (string == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject4 = (JSONObject) string;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jSONObject4 = (JSONObject) Double.valueOf(jSONObject3.getDouble("assetRequestHeaders"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        jSONObject4 = (JSONObject) Integer.valueOf(jSONObject3.getInt("assetRequestHeaders"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jSONObject4 = (JSONObject) Long.valueOf(jSONObject3.getLong("assetRequestHeaders"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jSONObject4 = (JSONObject) Boolean.valueOf(jSONObject3.getBoolean("assetRequestHeaders"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        Object jSONArray2 = jSONObject3.getJSONArray("assetRequestHeaders");
                        if (jSONArray2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject4 = (JSONObject) jSONArray2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        jSONObject4 = jSONObject3.getJSONObject("assetRequestHeaders");
                        if (jSONObject4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    } else {
                        Object obj = jSONObject3.get("assetRequestHeaders");
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject4 = (JSONObject) obj;
                    }
                } else {
                    jSONObject4 = null;
                }
                if (jSONObject4 != null) {
                    Iterator<String> keys = jSONObject4.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
                    Sequence asSequence = SequencesKt.asSequence(keys);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj2 : asSequence) {
                        LinkedHashMap linkedHashMap2 = linkedHashMap;
                        String str3 = (String) obj2;
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JSONObject.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string2 = jSONObject4.getString(str3);
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            jSONObject5 = (JSONObject) string2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jSONObject5 = (JSONObject) Double.valueOf(jSONObject4.getDouble(str3));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jSONObject5 = (JSONObject) Integer.valueOf(jSONObject4.getInt(str3));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jSONObject5 = (JSONObject) Long.valueOf(jSONObject4.getLong(str3));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jSONObject5 = (JSONObject) Boolean.valueOf(jSONObject4.getBoolean(str3));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                            Object jSONArray3 = jSONObject4.getJSONArray(str3);
                            if (jSONArray3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            jSONObject5 = (JSONObject) jSONArray3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                            jSONObject5 = jSONObject4.getJSONObject(str3);
                            if (jSONObject5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                        } else {
                            Object obj3 = jSONObject4.get(str3);
                            if (obj3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            jSONObject5 = (JSONObject) obj3;
                        }
                        linkedHashMap2.put(obj2, jSONObject5);
                    }
                    return linkedHashMap;
                }
                return MapsKt.emptyMap();
            }
        });
        this.assetEntityList = LazyKt.lazy(new Function0<List<AssetEntity>>() { // from class: expo.modules.updates.manifest.NewUpdateManifest$assetEntityList$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<AssetEntity> invoke() {
                JSONArray jSONArray2;
                JSONArray jSONArray3;
                JSONArray jSONArray4;
                JSONArray jSONArray5;
                Map assetHeaders;
                String str3;
                String str4;
                JSONObject jSONObject3;
                JSONObject jSONObject4;
                String str5;
                JSONObject jSONObject5;
                Map assetHeaders2;
                JSONObject jSONObject6;
                JSONObject jSONObject7;
                String str6;
                ArrayList arrayList = new ArrayList();
                try {
                    jSONObject3 = NewUpdateManifest.this.mLaunchAsset;
                    String string = jSONObject3.getString(DatabaseConstants.KEY_FIELD);
                    jSONObject4 = NewUpdateManifest.this.mLaunchAsset;
                    if (jSONObject4.has("fileExtension")) {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            str5 = jSONObject4.getString("fileExtension");
                            if (str5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            str5 = (String) Double.valueOf(jSONObject4.getDouble("fileExtension"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            str5 = (String) Integer.valueOf(jSONObject4.getInt("fileExtension"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str5 = (String) Long.valueOf(jSONObject4.getLong("fileExtension"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            str5 = (String) Boolean.valueOf(jSONObject4.getBoolean("fileExtension"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                            Object jSONArray6 = jSONObject4.getJSONArray("fileExtension");
                            if (jSONArray6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            str5 = (String) jSONArray6;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                            Object jSONObject8 = jSONObject4.getJSONObject("fileExtension");
                            if (jSONObject8 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            str5 = (String) jSONObject8;
                        } else {
                            Object obj = jSONObject4.get("fileExtension");
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            str5 = (String) obj;
                        }
                    } else {
                        str5 = null;
                    }
                    AssetEntity assetEntity = new AssetEntity(string, str5);
                    NewUpdateManifest newUpdateManifest = NewUpdateManifest.this;
                    jSONObject5 = newUpdateManifest.mLaunchAsset;
                    assetEntity.setUrl(Uri.parse(jSONObject5.getString("url")));
                    assetHeaders2 = newUpdateManifest.getAssetHeaders();
                    jSONObject6 = newUpdateManifest.mLaunchAsset;
                    assetEntity.setExtraRequestHeaders((JSONObject) assetHeaders2.get(jSONObject6.getString(DatabaseConstants.KEY_FIELD)));
                    assetEntity.setLaunchAsset(true);
                    assetEntity.setEmbeddedAssetFilename(EmbeddedLoader.BUNDLE_FILENAME);
                    jSONObject7 = newUpdateManifest.mLaunchAsset;
                    if (jSONObject7.has("hash")) {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            str6 = jSONObject7.getString("hash");
                            if (str6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            str6 = (String) Double.valueOf(jSONObject7.getDouble("hash"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            str6 = (String) Integer.valueOf(jSONObject7.getInt("hash"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str6 = (String) Long.valueOf(jSONObject7.getLong("hash"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            str6 = (String) Boolean.valueOf(jSONObject7.getBoolean("hash"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                            Object jSONArray7 = jSONObject7.getJSONArray("hash");
                            if (jSONArray7 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            str6 = (String) jSONArray7;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                            Object jSONObject9 = jSONObject7.getJSONObject("hash");
                            if (jSONObject9 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            str6 = (String) jSONObject9;
                        } else {
                            Object obj2 = jSONObject7.get("hash");
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            str6 = (String) obj2;
                        }
                    } else {
                        str6 = null;
                    }
                    assetEntity.setExpectedHash(str6);
                    arrayList.add(assetEntity);
                } catch (JSONException e) {
                    Log.e(NewUpdateManifest.TAG, "Could not read launch asset from manifest", e);
                }
                jSONArray2 = NewUpdateManifest.this.mAssets;
                if (jSONArray2 != null) {
                    jSONArray3 = NewUpdateManifest.this.mAssets;
                    if (jSONArray3.length() > 0) {
                        jSONArray4 = NewUpdateManifest.this.mAssets;
                        int length = jSONArray4.length();
                        for (int i = 0; i < length; i++) {
                            try {
                                jSONArray5 = NewUpdateManifest.this.mAssets;
                                JSONObject assetObject = jSONArray5.getJSONObject(i);
                                AssetEntity assetEntity2 = new AssetEntity(assetObject.getString(DatabaseConstants.KEY_FIELD), assetObject.getString("fileExtension"));
                                NewUpdateManifest newUpdateManifest2 = NewUpdateManifest.this;
                                assetEntity2.setUrl(Uri.parse(assetObject.getString("url")));
                                assetHeaders = newUpdateManifest2.getAssetHeaders();
                                assetEntity2.setExtraRequestHeaders((JSONObject) assetHeaders.get(assetObject.getString(DatabaseConstants.KEY_FIELD)));
                                Intrinsics.checkNotNullExpressionValue(assetObject, "assetObject");
                                if (assetObject.has("embeddedAssetFilename")) {
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                        str3 = assetObject.getString("embeddedAssetFilename");
                                        if (str3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        str3 = (String) Double.valueOf(assetObject.getDouble("embeddedAssetFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        str3 = (String) Integer.valueOf(assetObject.getInt("embeddedAssetFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str3 = (String) Long.valueOf(assetObject.getLong("embeddedAssetFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        str3 = (String) Boolean.valueOf(assetObject.getBoolean("embeddedAssetFilename"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        Object jSONArray8 = assetObject.getJSONArray("embeddedAssetFilename");
                                        if (jSONArray8 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str3 = (String) jSONArray8;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object jSONObject10 = assetObject.getJSONObject("embeddedAssetFilename");
                                        if (jSONObject10 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str3 = (String) jSONObject10;
                                    } else {
                                        Object obj3 = assetObject.get("embeddedAssetFilename");
                                        if (obj3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str3 = (String) obj3;
                                    }
                                } else {
                                    str3 = null;
                                }
                                assetEntity2.setEmbeddedAssetFilename(str3);
                                if (assetObject.has("hash")) {
                                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                        str4 = assetObject.getString("hash");
                                        if (str4 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        str4 = (String) Double.valueOf(assetObject.getDouble("hash"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        str4 = (String) Integer.valueOf(assetObject.getInt("hash"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str4 = (String) Long.valueOf(assetObject.getLong("hash"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        str4 = (String) Boolean.valueOf(assetObject.getBoolean("hash"));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        Object jSONArray9 = assetObject.getJSONArray("hash");
                                        if (jSONArray9 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str4 = (String) jSONArray9;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object jSONObject11 = assetObject.getJSONObject("hash");
                                        if (jSONObject11 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str4 = (String) jSONObject11;
                                    } else {
                                        Object obj4 = assetObject.get("hash");
                                        if (obj4 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        str4 = (String) obj4;
                                    }
                                } else {
                                    str4 = null;
                                }
                                assetEntity2.setExpectedHash(str4);
                                arrayList.add(assetEntity2);
                            } catch (JSONException e2) {
                                Log.e(NewUpdateManifest.TAG, "Could not read asset from manifest", e2);
                            }
                        }
                    }
                }
                return arrayList;
            }
        });
    }

    @Override // expo.modules.updates.manifest.UpdateManifest
    public NewManifest getManifest() {
        return this.manifest;
    }

    @Override // expo.modules.updates.manifest.UpdateManifest
    public UpdateEntity getUpdateEntity() {
        return (UpdateEntity) this.updateEntity.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, JSONObject> getAssetHeaders() {
        return (Map) this.assetHeaders.getValue();
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

    /* compiled from: NewUpdateManifest.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/manifest/NewUpdateManifest$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "fromNewManifest", "Lexpo/modules/updates/manifest/NewUpdateManifest;", "manifest", "Lexpo/modules/manifests/core/NewManifest;", "extensions", "Lorg/json/JSONObject;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NewUpdateManifest fromNewManifest(NewManifest manifest, JSONObject extensions, UpdatesConfiguration configuration) throws JSONException {
            Date date;
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            UUID id = UUID.fromString(manifest.getID());
            String runtimeVersion = manifest.getRuntimeVersion();
            JSONObject launchAsset = manifest.getLaunchAsset();
            JSONArray assets = manifest.getAssets();
            try {
                date = UpdatesUtils.INSTANCE.parseDateString(manifest.getCreatedAt());
            } catch (ParseException e) {
                Log.e(NewUpdateManifest.TAG, "Could not parse manifest createdAt string; falling back to current time", e);
                date = new Date();
            }
            Intrinsics.checkNotNullExpressionValue(id, "id");
            return new NewUpdateManifest(manifest, id, configuration.getScopeKey(), date, runtimeVersion, launchAsset, assets, extensions, null);
        }
    }
}
