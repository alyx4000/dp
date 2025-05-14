package com.socure.docv.capturesdk.api;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.gson.Gson;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.session.a;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ResultListener;
import com.socure.docv.capturesdk.common.utils.ScanError;
import com.socure.docv.capturesdk.common.utils.ScannedData;
import com.socure.docv.capturesdk.feature.orchestrator.presentation.ui.OrchestratorActivity;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J$\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/socure/docv/capturesdk/api/SocureDocVHelper;", "", "()V", "configJson", "", "socurePublicKey", "getConfigJson", "configMap", "", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "publicKey", "config", "getResult", "", "data", "resultListener", "Lcom/socure/docv/capturesdk/common/utils/ResultListener;", "initSdk", "printDetailedLog", "flag", "", "printPiiInDebugLog", "print", "setSource", "platform", "Lcom/socure/docv/capturesdk/api/Platform;", "showDebugScanStages", "silenceDebugLog", "silence", "version", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocureDocVHelper {
    public static final SocureDocVHelper INSTANCE = new SocureDocVHelper();
    private static String configJson;
    private static String socurePublicKey;

    private SocureDocVHelper() {
    }

    public static /* synthetic */ Intent getIntent$default(SocureDocVHelper socureDocVHelper, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return socureDocVHelper.getIntent(context, str, str2);
    }

    public static /* synthetic */ void initSdk$default(SocureDocVHelper socureDocVHelper, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        socureDocVHelper.initSdk(context, str, str2);
    }

    public final String getConfigJson(Map<String, ? extends Object> configMap) {
        Intrinsics.checkNotNullParameter(configMap, "configMap");
        try {
            return new Gson().toJson(configMap);
        } catch (Throwable th) {
            b.a(SocureDocVHelperKt.TAG, "Ex trying to save 'raw': " + Log.getStackTraceString(th), null, 4, null);
            return th.getLocalizedMessage();
        }
    }

    public final Intent getIntent(Context context) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = socurePublicKey;
        if (str == null || (intent = INSTANCE.getIntent(context, str, configJson)) == null) {
            throw new IllegalStateException("Socure public key is not set");
        }
        return intent;
    }

    public final Intent getIntent(Context context, String publicKey, String config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intent intent = new Intent(context, (Class<?>) OrchestratorActivity.class);
        intent.putExtra("public_key", publicKey);
        if (config != null) {
            intent.putExtra(Keys.KEY_CONFIG_DATA, config);
        }
        return intent;
    }

    public final void getResult(Intent data, ResultListener resultListener) {
        HashMap hashMap;
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resultListener, "resultListener");
        if (data.getIntExtra("status_code", -1) != ResponseCode.SUCCESS.getCode()) {
            int intExtra = data.getIntExtra("status_code", -1);
            String stringExtra = data.getStringExtra(Keys.KEY_STATUS_MESSAGE);
            if (stringExtra == null) {
                stringExtra = "";
            }
            String stringExtra2 = data.getStringExtra(Keys.KEY_SESSION_ID);
            a aVar = a.f305a;
            HashMap<String, byte[]> hashMap2 = a.j;
            ScanError scanError = new ScanError(intExtra, stringExtra, stringExtra2, hashMap2 != null ? new HashMap(hashMap2) : null);
            aVar.a();
            resultListener.onError(scanError);
            return;
        }
        String stringExtra3 = data.getStringExtra(Keys.KEY_DOCUMENT_UUID);
        String stringExtra4 = data.getStringExtra(Keys.KEY_SESSION_ID);
        String stringExtra5 = data.getStringExtra(Keys.KEY_EXTRACTED_DATA);
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = data.getSerializableExtra(Keys.KEY_CAPTURE_MODE, HashMap.class);
            } else {
                Object serializableExtra = data.getSerializableExtra(Keys.KEY_CAPTURE_MODE);
                if (!(serializableExtra instanceof HashMap)) {
                    serializableExtra = null;
                }
                obj = (HashMap) serializableExtra;
            }
            hashMap = (HashMap) obj;
        } catch (Throwable unused) {
            hashMap = null;
        }
        a aVar2 = a.f305a;
        HashMap<String, byte[]> hashMap3 = a.j;
        ScannedData scannedData = new ScannedData(stringExtra3, stringExtra4, stringExtra5, hashMap, hashMap3 != null ? new HashMap(hashMap3) : null);
        aVar2.a();
        resultListener.onSuccess(scannedData);
    }

    public final void initSdk(Context context, String publicKey, String config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        socurePublicKey = publicKey;
        configJson = config;
    }

    public final void printDetailedLog(boolean flag) {
        ConstantsKt.setPRINT_DETAILED_LOG(flag);
    }

    public final void printPiiInDebugLog(boolean print) {
        ConstantsKt.setPRINT_PII_IN_DEBUG_LOG(print);
    }

    public final void setSource(Platform platform) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        ConstantsKt.setSOURCE_PLATFORM(platform);
    }

    public final void showDebugScanStages(boolean flag) {
        ConstantsKt.setSHOW_DEBUG_SCAN_STAGE(flag);
    }

    public final void silenceDebugLog(boolean silence) {
        ConstantsKt.setSILENCE_DEBUG_LOG(silence);
    }

    public final String version() {
        return "4.3.0";
    }
}
