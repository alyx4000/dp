package org.greenrobot.eventbus;

/* loaded from: classes6.dex */
public interface MainThreadSupport {
    Poster createPoster(EventBus eventBus);

    boolean isMainThread();
}
