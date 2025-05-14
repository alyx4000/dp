package com.iterable.iterableapi;

/* loaded from: classes5.dex */
class IterablePushRegistration {
    static IterablePushRegistrationImpl instance = new IterablePushRegistrationImpl();

    IterablePushRegistration() {
    }

    static void executePushRegistrationTask(IterablePushRegistrationData iterablePushRegistrationData) {
        instance.executePushRegistrationTask(iterablePushRegistrationData);
    }

    static class IterablePushRegistrationImpl {
        IterablePushRegistrationImpl() {
        }

        void executePushRegistrationTask(IterablePushRegistrationData iterablePushRegistrationData) {
            new IterablePushRegistrationTask().execute(iterablePushRegistrationData);
        }
    }
}
