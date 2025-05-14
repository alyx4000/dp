package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;
import com.iterable.iterableapi.IterablePushRegistrationData;

/* loaded from: classes5.dex */
class IterablePushRegistrationTask extends AsyncTask<IterablePushRegistrationData, Void, Void> {
    static final String TAG = "IterablePushRegistration";
    IterablePushRegistrationData iterablePushRegistrationData;

    IterablePushRegistrationTask() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(IterablePushRegistrationData... iterablePushRegistrationDataArr) {
        IterablePushRegistrationData iterablePushRegistrationData = iterablePushRegistrationDataArr[0];
        this.iterablePushRegistrationData = iterablePushRegistrationData;
        if (iterablePushRegistrationData.pushIntegrationName != null) {
            PushRegistrationObject deviceToken = getDeviceToken();
            if (deviceToken == null) {
                return null;
            }
            if (this.iterablePushRegistrationData.pushRegistrationAction == IterablePushRegistrationData.PushRegistrationAction.ENABLE) {
                IterableApi.sharedInstance.registerDeviceToken(this.iterablePushRegistrationData.email, this.iterablePushRegistrationData.userId, this.iterablePushRegistrationData.authToken, this.iterablePushRegistrationData.pushIntegrationName, deviceToken.token, IterableApi.getInstance().getDeviceAttributes());
                return null;
            }
            if (this.iterablePushRegistrationData.pushRegistrationAction != IterablePushRegistrationData.PushRegistrationAction.DISABLE) {
                return null;
            }
            IterableApi.sharedInstance.disableToken(this.iterablePushRegistrationData.email, this.iterablePushRegistrationData.userId, this.iterablePushRegistrationData.authToken, deviceToken.token, null, null);
            return null;
        }
        IterableLogger.e("IterablePush", "iterablePushRegistrationData has not been specified");
        return null;
    }

    PushRegistrationObject getDeviceToken() {
        try {
            Context mainActivityContext = IterableApi.sharedInstance.getMainActivityContext();
            if (mainActivityContext == null) {
                IterableLogger.e(TAG, "MainActivity Context is null");
                return null;
            }
            if (Util.getSenderId(mainActivityContext) == null) {
                IterableLogger.e(TAG, "Could not find gcm_defaultSenderId, please check that Firebase SDK is set up properly");
                return null;
            }
            return new PushRegistrationObject(Util.getFirebaseToken());
        } catch (Exception e) {
            IterableLogger.e(TAG, "Exception while retrieving the device token: check that firebase is added to the build dependencies", e);
            return null;
        }
    }

    static class Util {
        static UtilImpl instance = new UtilImpl();

        Util() {
        }

        static String getFirebaseToken() {
            return instance.getFirebaseToken();
        }

        static String getSenderId(Context context) {
            return instance.getSenderId(context);
        }

        static class UtilImpl {
            UtilImpl() {
            }

            String getFirebaseToken() {
                return IterableFirebaseMessagingService.getFirebaseToken();
            }

            String getSenderId(Context context) {
                int identifier = context.getResources().getIdentifier(IterableConstants.FIREBASE_SENDER_ID, "string", context.getPackageName());
                if (identifier != 0) {
                    return context.getResources().getString(identifier);
                }
                return null;
            }
        }
    }

    static class PushRegistrationObject {
        String messagingPlatform = "FCM";
        String token;

        PushRegistrationObject(String str) {
            this.token = str;
        }
    }
}
