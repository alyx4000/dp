package com.karumi.dexter;

import android.app.Activity;
import android.content.Context;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.listener.EmptyPermissionRequestErrorListener;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public final class Dexter implements DexterBuilder, DexterBuilder.Permission, DexterBuilder.SinglePermissionListener, DexterBuilder.MultiPermissionListener {
    private static DexterInstance instance;
    private Collection<String> permissions;
    private MultiplePermissionsListener listener = new BaseMultiplePermissionsListener();
    private PermissionRequestErrorListener errorListener = new EmptyPermissionRequestErrorListener();
    private boolean shouldExecuteOnSameThread = false;

    private Dexter(Context context) {
        initialize(context);
    }

    private Thread getThread() {
        return this.shouldExecuteOnSameThread ? ThreadFactory.makeSameThread() : ThreadFactory.makeMainThread();
    }

    private static void initialize(Context context) {
        DexterInstance dexterInstance = instance;
        if (dexterInstance == null) {
            instance = new DexterInstance(context, new AndroidPermissionService(), new IntentProvider());
        } else {
            dexterInstance.setContext(context);
        }
    }

    static void onActivityDestroyed(DexterActivity dexterActivity) {
        DexterInstance dexterInstance = instance;
        if (dexterInstance != null) {
            dexterInstance.onActivityDestroyed(dexterActivity);
        }
    }

    static void onActivityReady(Activity activity) {
        DexterInstance dexterInstance = instance;
        if (dexterInstance != null) {
            dexterInstance.onActivityReady(activity);
        }
    }

    static void onPermissionsRequested(Collection<String> collection, Collection<String> collection2) {
        DexterInstance dexterInstance = instance;
        if (dexterInstance != null) {
            dexterInstance.onPermissionRequestGranted(collection);
            instance.onPermissionRequestDenied(collection2);
        }
    }

    @Deprecated
    public static DexterBuilder.Permission withActivity(Activity activity) {
        return new Dexter(activity);
    }

    public static DexterBuilder.Permission withContext(Context context) {
        return new Dexter(context);
    }

    @Override // com.karumi.dexter.DexterBuilder
    public void check() {
        try {
            instance.checkPermissions(this.listener, this.permissions, getThread());
        } catch (DexterException e) {
            this.errorListener.onError(e.error);
        }
    }

    @Override // com.karumi.dexter.DexterBuilder
    public DexterBuilder onSameThread() {
        this.shouldExecuteOnSameThread = true;
        return this;
    }

    @Override // com.karumi.dexter.DexterBuilder
    public DexterBuilder withErrorListener(PermissionRequestErrorListener permissionRequestErrorListener) {
        this.errorListener = permissionRequestErrorListener;
        return this;
    }

    @Override // com.karumi.dexter.DexterBuilder.MultiPermissionListener
    public DexterBuilder withListener(MultiplePermissionsListener multiplePermissionsListener) {
        this.listener = multiplePermissionsListener;
        return this;
    }

    @Override // com.karumi.dexter.DexterBuilder.SinglePermissionListener
    public DexterBuilder withListener(PermissionListener permissionListener) {
        this.listener = new MultiplePermissionsListenerToPermissionListenerAdapter(permissionListener);
        return this;
    }

    @Override // com.karumi.dexter.DexterBuilder.Permission
    public DexterBuilder.SinglePermissionListener withPermission(String str) {
        this.permissions = Collections.singletonList(str);
        return this;
    }

    @Override // com.karumi.dexter.DexterBuilder.Permission
    public DexterBuilder.MultiPermissionListener withPermissions(Collection<String> collection) {
        this.permissions = new ArrayList(collection);
        return this;
    }

    @Override // com.karumi.dexter.DexterBuilder.Permission
    public DexterBuilder.MultiPermissionListener withPermissions(String... strArr) {
        this.permissions = Arrays.asList(strArr);
        return this;
    }
}
