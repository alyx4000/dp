package com.iterable.iterableapi;

/* loaded from: classes5.dex */
class IterablePushRegistrationData {
    String authToken;
    String email;
    String messagingPlatform;
    String projectNumber;
    String pushIntegrationName;
    PushRegistrationAction pushRegistrationAction;
    String userId;

    public enum PushRegistrationAction {
        ENABLE,
        DISABLE
    }

    IterablePushRegistrationData(String str, String str2, String str3, String str4, String str5, PushRegistrationAction pushRegistrationAction) {
        this.email = str;
        this.userId = str2;
        this.pushIntegrationName = str3;
        this.projectNumber = str4;
        this.messagingPlatform = str5;
        this.pushRegistrationAction = pushRegistrationAction;
    }

    IterablePushRegistrationData(String str, String str2, String str3, String str4, PushRegistrationAction pushRegistrationAction) {
        this.projectNumber = "";
        this.messagingPlatform = "FCM";
        this.email = str;
        this.userId = str2;
        this.pushIntegrationName = str4;
        this.pushRegistrationAction = pushRegistrationAction;
        this.authToken = str3;
    }
}
