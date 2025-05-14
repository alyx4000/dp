package expo.modules.updates.db.dao;

import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.common.util.UriUtil;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateAssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AssetDao.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\rH'J\b\u0010\u0011\u001a\u00020\u0004H'J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H'J\b\u0010\u0016\u001a\u00020\u0004H'J\b\u0010\u0017\u001a\u00020\u0004H'J\b\u0010\u0018\u001a\u00020\u0004H'J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0017J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0017J\u001e\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\rH'J\u0012\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010$\u001a\u00020\u0015H'J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\bH'¨\u0006)"}, d2 = {"Lexpo/modules/updates/db/dao/AssetDao;", "", "()V", "_deleteAssetsMarkedForDeletion", "", "_insertAsset", "", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", "_insertUpdateAsset", "updateAsset", "Lexpo/modules/updates/db/entity/UpdateAssetEntity;", "_loadAssetWithKey", "", DatabaseConstants.KEY_FIELD, "", "_loadAssetsMarkedForDeletion", "_markAllAssetsForDeletion", "_setUpdateLaunchAsset", "assetId", "updateId", "Ljava/util/UUID;", "_unmarkDuplicateUsedAssetsFromDeletion", "_unmarkUsedAssetsFromDeletion", "_unmarkUsedLaunchAssetsFromDeletion", "addExistingAssetToUpdate", "", "update", "Lexpo/modules/updates/db/entity/UpdateEntity;", "isLaunchAsset", "deleteUnusedAssets", "insertAssets", "assets", "loadAllAssets", "loadAssetWithKey", "loadAssetsForUpdate", "id", "mergeAndUpdateAsset", "existingEntity", "newEntity", "assetEntity", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AssetDao {
    public abstract void _deleteAssetsMarkedForDeletion();

    public abstract long _insertAsset(AssetEntity asset);

    public abstract void _insertUpdateAsset(UpdateAssetEntity updateAsset);

    public abstract List<AssetEntity> _loadAssetWithKey(String key);

    public abstract List<AssetEntity> _loadAssetsMarkedForDeletion();

    public abstract void _markAllAssetsForDeletion();

    public abstract void _setUpdateLaunchAsset(long assetId, UUID updateId);

    public abstract void _unmarkDuplicateUsedAssetsFromDeletion();

    public abstract void _unmarkUsedAssetsFromDeletion();

    public abstract void _unmarkUsedLaunchAssetsFromDeletion();

    public abstract List<AssetEntity> loadAllAssets();

    public abstract List<AssetEntity> loadAssetsForUpdate(UUID id);

    public abstract void updateAsset(AssetEntity assetEntity);

    public void insertAssets(List<AssetEntity> assets, UpdateEntity update) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(update, "update");
        for (AssetEntity assetEntity : assets) {
            long _insertAsset = _insertAsset(assetEntity);
            _insertUpdateAsset(new UpdateAssetEntity(update.getId(), _insertAsset));
            if (assetEntity.getIsLaunchAsset()) {
                _setUpdateLaunchAsset(_insertAsset, update.getId());
            }
        }
    }

    public final AssetEntity loadAssetWithKey(String key) {
        List<AssetEntity> _loadAssetWithKey = _loadAssetWithKey(key);
        if (!_loadAssetWithKey.isEmpty()) {
            return _loadAssetWithKey.get(0);
        }
        return null;
    }

    public final void mergeAndUpdateAsset(AssetEntity existingEntity, AssetEntity newEntity) {
        boolean z;
        Intrinsics.checkNotNullParameter(existingEntity, "existingEntity");
        Intrinsics.checkNotNullParameter(newEntity, "newEntity");
        boolean z2 = true;
        if (newEntity.getUrl() == null || (existingEntity.getUrl() != null && Intrinsics.areEqual(newEntity.getUrl(), existingEntity.getUrl()))) {
            z = false;
        } else {
            existingEntity.setUrl(newEntity.getUrl());
            z = true;
        }
        JSONObject extraRequestHeaders = newEntity.getExtraRequestHeaders();
        if (extraRequestHeaders == null || (existingEntity.getExtraRequestHeaders() != null && Intrinsics.areEqual(extraRequestHeaders, existingEntity.getExtraRequestHeaders()))) {
            z2 = z;
        } else {
            existingEntity.setExtraRequestHeaders(newEntity.getExtraRequestHeaders());
        }
        if (z2) {
            updateAsset(existingEntity);
        }
        existingEntity.setLaunchAsset(newEntity.getIsLaunchAsset());
        existingEntity.setEmbeddedAssetFilename(newEntity.getEmbeddedAssetFilename());
        existingEntity.setResourcesFilename(newEntity.getResourcesFilename());
        existingEntity.setResourcesFolder(newEntity.getResourcesFolder());
        existingEntity.setScale(newEntity.getScale());
        existingEntity.setScales(newEntity.getScales());
    }

    public boolean addExistingAssetToUpdate(UpdateEntity update, AssetEntity asset, boolean isLaunchAsset) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(asset, "asset");
        AssetEntity loadAssetWithKey = loadAssetWithKey(asset.getKey());
        if (loadAssetWithKey == null) {
            return false;
        }
        long id = loadAssetWithKey.getId();
        _insertUpdateAsset(new UpdateAssetEntity(update.getId(), id));
        if (!isLaunchAsset) {
            return true;
        }
        _setUpdateLaunchAsset(id, update.getId());
        return true;
    }

    public List<AssetEntity> deleteUnusedAssets() {
        _markAllAssetsForDeletion();
        _unmarkUsedAssetsFromDeletion();
        _unmarkUsedLaunchAssetsFromDeletion();
        _unmarkDuplicateUsedAssetsFromDeletion();
        List<AssetEntity> _loadAssetsMarkedForDeletion = _loadAssetsMarkedForDeletion();
        _deleteAssetsMarkedForDeletion();
        return _loadAssetsMarkedForDeletion;
    }
}
