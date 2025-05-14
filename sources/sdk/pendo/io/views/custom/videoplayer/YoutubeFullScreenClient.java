package sdk.pendo.io.views.custom.videoplayer;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/YoutubeFullScreenClient;", "Landroid/webkit/WebChromeClient;", "fullScreenViewContainer", "Landroid/view/ViewGroup;", "youtubePlayer", "Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer;", "(Landroid/view/ViewGroup;Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer;)V", "customView", "Landroid/view/View;", "getFullScreenViewContainer", "()Landroid/view/ViewGroup;", "setFullScreenViewContainer", "(Landroid/view/ViewGroup;)V", "matchParentLayout", "Landroid/widget/FrameLayout$LayoutParams;", "getYoutubePlayer", "()Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer;", "setYoutubePlayer", "(Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer;)V", "onHideCustomView", "", "onShowCustomView", "view", "callback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class YoutubeFullScreenClient extends WebChromeClient {
    public static final long DELAY_FOR_CUSTOM_VIEW_TO_FULLY_LOAD = 500;
    public static final String TAG = "FullScreenClient";
    private View customView;
    private ViewGroup fullScreenViewContainer;
    private FrameLayout.LayoutParams matchParentLayout;
    private PendoYoutubePlayer youtubePlayer;

    public YoutubeFullScreenClient(ViewGroup viewGroup, PendoYoutubePlayer youtubePlayer) {
        Intrinsics.checkNotNullParameter(youtubePlayer, "youtubePlayer");
        this.fullScreenViewContainer = viewGroup;
        this.youtubePlayer = youtubePlayer;
        this.matchParentLayout = new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShowCustomView$lambda$2(YoutubeFullScreenClient this$0, View view, boolean z, WebChromeClient.CustomViewCallback callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.customView = view;
        if (this$0.fullScreenViewContainer != null) {
            view.setLayoutParams(this$0.matchParentLayout);
            ViewGroup viewGroup = this$0.fullScreenViewContainer;
            if (viewGroup != null) {
                viewGroup.addView(view);
            }
            this$0.youtubePlayer.setVisibility(8);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.onCustomViewHidden();
            PendoLogger.d(TAG, "Failed to enter fullScreen");
        }
        if (z) {
            this$0.youtubePlayer.playVideo();
        }
    }

    public final ViewGroup getFullScreenViewContainer() {
        return this.fullScreenViewContainer;
    }

    public final PendoYoutubePlayer getYoutubePlayer() {
        return this.youtubePlayer;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        this.youtubePlayer.setVisibility(0);
        ViewGroup viewGroup = this.fullScreenViewContainer;
        if (viewGroup != null) {
            viewGroup.removeView(this.customView);
        }
        this.customView = null;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(final View view, final WebChromeClient.CustomViewCallback callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final boolean isPlaying = this.youtubePlayer.getIsPlaying();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.YoutubeFullScreenClient$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                YoutubeFullScreenClient.onShowCustomView$lambda$2(YoutubeFullScreenClient.this, view, isPlaying, callback);
            }
        }, 500L);
    }

    public final void setFullScreenViewContainer(ViewGroup viewGroup) {
        this.fullScreenViewContainer = viewGroup;
    }

    public final void setYoutubePlayer(PendoYoutubePlayer pendoYoutubePlayer) {
        Intrinsics.checkNotNullParameter(pendoYoutubePlayer, "<set-?>");
        this.youtubePlayer = pendoYoutubePlayer;
    }
}
