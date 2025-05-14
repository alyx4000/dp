package sdk.pendo.io.views.custom.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.uimanager.ViewProps;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sdk.pendo.io.R;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0003/01B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0014J\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cJ\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\tH\u0016J\u0012\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u001cH\u0002J\u0006\u0010.\u001a\u00020\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer;", "Landroid/widget/FrameLayout;", "Lsdk/pendo/io/views/custom/videoplayer/VideoPlayerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", PendoYoutubePlayer.AUTOPLAY_PARAMETER, "", "heightRatio", "", "imageWidthPercents", "<set-?>", "isPlaying", "()Z", "mainThreadHandler", "Landroid/os/Handler;", "util", "Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer$PendoYoutubePlayerUtils;", "videoId", "", "videoUrl", "Ljava/net/URL;", "webView", "Landroid/webkit/WebView;", "widthRatio", "generatePlayerOptions", "getVideoId", "loadVideo", "", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "pauseVideo", "playVideo", "setAspectRatio", ViewProps.ASPECT_RATIO, "setAutoPlay", "setImageWidthInPercents", "width", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "setVideoId", "setVideoUrl", "setupWebViewWithIFrame", "stopVideo", "Companion", "IFrameJavaScriptInterface", PendoYoutubePlayerUtils.TAG, "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PendoYoutubePlayer extends FrameLayout implements VideoPlayerView {
    public static final String AUTOPLAY_PARAMETER = "autoplay";
    public static final String BASE_URL = "https://www.youtube.com";
    public static final String CC_LOAD_POLICY_PARAMETER = "cc_load_policy";
    public static final String CONTROLS_PARAMETER = "controls";
    public static final String ENABLEJSAPI_PARAMETER = "enablejsapi";
    public static final String FS_PARAMETER = "fs";
    public static final int HEIGHT_DEFAULT_RATIO = 9;
    public static final String HOST = "www.youtube.com";
    public static final String IFRAME_FILE = "pendo_iframe_api";
    public static final String IFRAME_PARAMETERS_PLACEHOLDER = "<<injectedPlayerVars>>";
    public static final String INTEGRITY_KEY = "FDB497E7C6F9D71A89D042B0FA5B7A4DEA5EE7938F08CFDA9F1FB58EBDF749E7";
    public static final String IV_LOAD_POLICY_PARAMETER = "iv_load_policy";
    public static final String JAVASCRIPT_INTERFACE_NAME = "PendoSDK";
    public static final String MODESTBRANDING_PARAMETER = "modestbranding";
    public static final String ORIGIN_PARAMETER = "origin";
    public static final String PLAYER_PLAYING = "PLAYING";
    public static final String REL_PARAMETER = "rel";
    public static final String SHOWINFO_PARAMETER = "showinfo";
    public static final String TAG = "PendoYoutubePlayer";
    public static final int WIDTH_DEFAULT_RATIO = 16;
    private boolean autoplay;
    private int heightRatio;
    private int imageWidthPercents;
    private boolean isPlaying;
    private final Handler mainThreadHandler;
    private final PendoYoutubePlayerUtils util;
    private String videoId;
    private URL videoUrl;
    private WebView webView;
    private int widthRatio;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0017J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0017J\b\u0010\f\u001a\u00020\u0004H\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0017J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0017J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0017J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0017J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0017J\b\u0010\u0016\u001a\u00020\u0004H\u0017¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer$IFrameJavaScriptInterface;", "Lsdk/pendo/io/views/custom/videoplayer/IFrameApi;", "(Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer;)V", "onApiChange", "", "onError", "error", "", "onPlaybackQualityChange", "quality", "onPlaybackRateChange", "rate", "onReady", "onStateChange", "state", "onVideoCurrentTime", "seconds", "onVideoDuration", "onVideoId", "videoId", "onVideoLoadedFraction", "fraction", "onYouTubeIFrameAPIReady", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class IFrameJavaScriptInterface implements IFrameApi {
        public IFrameJavaScriptInterface() {
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onApiChange() {
            PendoLogger.d(PendoYoutubePlayer.TAG, "onApiChange");
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onError(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onError " + error);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onPlaybackQualityChange(String quality) {
            Intrinsics.checkNotNullParameter(quality, "quality");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onPlaybackQualityChange " + quality);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onPlaybackRateChange(String rate) {
            Intrinsics.checkNotNullParameter(rate, "rate");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onPlaybackRateChange " + rate);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onReady() {
            PendoLogger.d(PendoYoutubePlayer.TAG, "onReady");
            String videoId = PendoYoutubePlayer.this.getVideoId();
            if (videoId != null) {
                PendoYoutubePlayer.this.loadVideo(videoId);
            }
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onStateChange(String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onStateChange " + state);
            PendoYoutubePlayer.this.isPlaying = Intrinsics.areEqual(state, PendoYoutubePlayer.PLAYER_PLAYING);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onVideoCurrentTime(String seconds) {
            Intrinsics.checkNotNullParameter(seconds, "seconds");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoCurrentTime " + seconds);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onVideoDuration(String seconds) {
            Intrinsics.checkNotNullParameter(seconds, "seconds");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoDuration " + seconds);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onVideoId(String videoId) {
            Intrinsics.checkNotNullParameter(videoId, "videoId");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoId " + videoId);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onVideoLoadedFraction(String fraction) {
            Intrinsics.checkNotNullParameter(fraction, "fraction");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoLoadedFraction " + fraction);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.IFrameApi
        @JavascriptInterface
        public void onYouTubeIFrameAPIReady() {
            PendoLogger.d(PendoYoutubePlayer.TAG, "onYouTubeIFrameAPIReady");
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\fJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\f¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/PendoYoutubePlayer$PendoYoutubePlayerUtils;", "", "()V", "calculateRelativeToParentWidth", "", "parentWidthMeasureSpec", "percents", "calculateWidthHeightRatio", "widthMeasureSpec", "widthRatio", "heightRatio", "generatePlayerOptions", "", "getLayoutParamsRespectingImgWidthPercents", "Landroid/view/ViewGroup$LayoutParams;", "params", "imgWidthPercents", "readInputStreamContent", "inputStream", "Ljava/io/InputStream;", "validateAndSetAspectRatio", "Lkotlin/Pair;", ViewProps.ASPECT_RATIO, "validateAndSetImageWidthPercents", "width", "validateAndSetVideoUrl", "Ljava/net/URL;", "videoUrl", "verifyAndGetPlainText", DatabaseConstants.KEY_FIELD, "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PendoYoutubePlayerUtils {
        public static final String TAG = "PendoYoutubePlayerUtils";

        private final String readInputStreamContent(InputStream inputStream) {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
                    StringBuilder sb = new StringBuilder();
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        sb.append(readLine).append("\n");
                    }
                    return sb.toString();
                } catch (Exception e) {
                    PendoLogger.e(TAG, e.getStackTrace(), e.getMessage());
                    inputStream.close();
                    return null;
                }
            } finally {
                inputStream.close();
            }
        }

        public final int calculateRelativeToParentWidth(int parentWidthMeasureSpec, int percents) {
            return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(parentWidthMeasureSpec) * percents) / 100, 1073741824);
        }

        public final int calculateWidthHeightRatio(int widthMeasureSpec, int widthRatio, int heightRatio) {
            return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(widthMeasureSpec) * heightRatio) / widthRatio, 1073741824);
        }

        public final String generatePlayerOptions() {
            String jSONObject = new JSONObject().put(PendoYoutubePlayer.AUTOPLAY_PARAMETER, 0).put(PendoYoutubePlayer.CONTROLS_PARAMETER, 1).put(PendoYoutubePlayer.ENABLEJSAPI_PARAMETER, 1).put(PendoYoutubePlayer.FS_PARAMETER, 1).put("origin", PendoYoutubePlayer.BASE_URL).put(PendoYoutubePlayer.REL_PARAMETER, 0).put(PendoYoutubePlayer.SHOWINFO_PARAMETER, 0).put(PendoYoutubePlayer.IV_LOAD_POLICY_PARAMETER, 3).put(PendoYoutubePlayer.MODESTBRANDING_PARAMETER, 0).put(PendoYoutubePlayer.CC_LOAD_POLICY_PARAMETER, 0).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            return jSONObject;
        }

        public final ViewGroup.LayoutParams getLayoutParamsRespectingImgWidthPercents(ViewGroup.LayoutParams params, int imgWidthPercents) {
            return imgWidthPercents > 0 ? new LinearLayout.LayoutParams(-1, -2) : params;
        }

        public final Pair<Integer, Integer> validateAndSetAspectRatio(String aspectRatio) {
            Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) aspectRatio, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
            try {
                if (strArr.length != 2) {
                    throw new Exception();
                }
                int parseInt = Integer.parseInt(strArr[0]);
                int parseInt2 = Integer.parseInt(strArr[1]);
                if (parseInt <= 0 || parseInt2 <= 0) {
                    throw new Exception();
                }
                return new Pair<>(Integer.valueOf(parseInt), Integer.valueOf(parseInt2));
            } catch (Exception unused) {
                PendoLogger.d(TAG, "validateAndSetAspectRatio -> wrong parameter " + aspectRatio);
                return null;
            }
        }

        public final int validateAndSetImageWidthPercents(int width) {
            if (width > 100) {
                PendoLogger.d(PendoYoutubePlayer.TAG, "The image width percents out of range " + width);
                return 100;
            }
            if (width >= 0) {
                return width;
            }
            PendoLogger.d(PendoYoutubePlayer.TAG, "The image width percents out of range " + width);
            return 0;
        }

        public final URL validateAndSetVideoUrl(String videoUrl) {
            Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
            try {
                return new URL(videoUrl);
            } catch (MalformedURLException unused) {
                PendoLogger.d(PendoYoutubePlayer.TAG, "validateAndSetVideoUrl -> wrong parameter " + videoUrl);
                return null;
            }
        }

        public final String verifyAndGetPlainText(InputStream inputStream, String key) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                String a2 = m0.a(readInputStreamContent(inputStream));
                String a3 = m0.a(a2, key);
                if (a3 != null) {
                    return a3;
                }
                PendoLogger.d(TAG, "The file not pass integrity match " + a2);
                return null;
            } catch (Exception e) {
                PendoLogger.e(PendoYoutubePlayer.TAG, e.getStackTrace(), e.getMessage());
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoYoutubePlayer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.webView = new WebView(context);
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.util = new PendoYoutubePlayerUtils();
        this.widthRatio = 16;
        this.heightRatio = 9;
        addView(this.webView);
    }

    private final String generatePlayerOptions() {
        return this.util.generatePlayerOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getVideoId() {
        String str = this.videoId;
        if (str != null) {
            return str;
        }
        URL url = this.videoUrl;
        if (url == null) {
            PendoLogger.d(TAG, "getVideoId -> no videoId");
            return null;
        }
        String path = url.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return StringsKt.removePrefix(path, (CharSequence) "/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadVideo(String videoId) {
        StringBuilder append;
        String str;
        if (this.autoplay) {
            append = new StringBuilder("javascript:loadVideo('").append(videoId);
            str = "', 0.0)";
        } else {
            append = new StringBuilder("javascript:cueVideo('").append(videoId);
            str = "')";
        }
        final String sb = append.append(str).toString();
        this.mainThreadHandler.post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.PendoYoutubePlayer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PendoYoutubePlayer.loadVideo$lambda$3(PendoYoutubePlayer.this, sb);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadVideo$lambda$3(PendoYoutubePlayer this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        this$0.webView.loadUrl(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pauseVideo$lambda$5(PendoYoutubePlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.webView.loadUrl("javascript:pauseVideo()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playVideo$lambda$4(PendoYoutubePlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.webView.loadUrl("javascript:playVideo()");
    }

    private final void setupWebViewWithIFrame() {
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(2);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        this.webView.setWebViewClient(new WebViewClient() { // from class: sdk.pendo.io.views.custom.videoplayer.PendoYoutubePlayer$setupWebViewWithIFrame$2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url == null || StringsKt.startsWith$default(url, PendoYoutubePlayer.BASE_URL, false, 2, (Object) null)) {
                    return;
                }
                if (view != null) {
                    view.stopLoading();
                }
                PendoLogger.d(PendoYoutubePlayer.TAG, "Stop loading page " + url);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });
        this.webView.addJavascriptInterface(new IFrameJavaScriptInterface(), JAVASCRIPT_INTERFACE_NAME);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        View findViewById = ((Activity) context).findViewById(R.id.insert_visual_container);
        if (((ViewGroup) findViewById) == null) {
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            findViewById = ((Activity) context2).findViewById(R.id.pendo_view_pager_container);
        }
        this.webView.setWebChromeClient(new YoutubeFullScreenClient((ViewGroup) findViewById, this));
        String str = null;
        try {
            PendoYoutubePlayerUtils pendoYoutubePlayerUtils = this.util;
            InputStream open = getResources().getAssets().open(IFRAME_FILE);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            String verifyAndGetPlainText = pendoYoutubePlayerUtils.verifyAndGetPlainText(open, INTEGRITY_KEY);
            if (verifyAndGetPlainText != null) {
                str = StringsKt.replace$default(verifyAndGetPlainText, IFRAME_PARAMETERS_PLACEHOLDER, generatePlayerOptions(), false, 4, (Object) null);
            }
        } catch (Exception e) {
            PendoLogger.d(TAG, e.getStackTrace(), e.getMessage());
        }
        String str2 = str;
        if (str2 != null) {
            this.webView.loadDataWithBaseURL(BASE_URL, str2, "text/html", "utf-8", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopVideo$lambda$6(PendoYoutubePlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.webView.loadUrl("javascript:stopVideo()");
    }

    /* renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupWebViewWithIFrame();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = this.imageWidthPercents;
        if (i > 0) {
            widthMeasureSpec = this.util.calculateRelativeToParentWidth(widthMeasureSpec, i);
        }
        if (getLayoutParams().height == -2) {
            heightMeasureSpec = this.util.calculateWidthHeightRatio(widthMeasureSpec, this.widthRatio, this.heightRatio);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void pauseVideo() {
        if (this.isPlaying) {
            this.mainThreadHandler.post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.PendoYoutubePlayer$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PendoYoutubePlayer.pauseVideo$lambda$5(PendoYoutubePlayer.this);
                }
            });
        }
    }

    public final void playVideo() {
        this.mainThreadHandler.post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.PendoYoutubePlayer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PendoYoutubePlayer.playVideo$lambda$4(PendoYoutubePlayer.this);
            }
        });
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.VideoPlayerView
    public void setAspectRatio(String aspectRatio) {
        Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        Pair<Integer, Integer> validateAndSetAspectRatio = this.util.validateAndSetAspectRatio(aspectRatio);
        if (validateAndSetAspectRatio != null) {
            this.widthRatio = validateAndSetAspectRatio.getFirst().intValue();
            this.heightRatio = validateAndSetAspectRatio.getSecond().intValue();
        }
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.VideoPlayerView
    public void setAutoPlay(boolean autoplay) {
        this.autoplay = autoplay;
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.VideoPlayerView
    public void setImageWidthInPercents(int width) {
        this.imageWidthPercents = this.util.validateAndSetImageWidthPercents(width);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(this.util.getLayoutParamsRespectingImgWidthPercents(params, this.imageWidthPercents));
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.VideoPlayerView
    public void setVideoId(String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.videoId = videoId;
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.VideoPlayerView
    public void setVideoUrl(String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        URL validateAndSetVideoUrl = this.util.validateAndSetVideoUrl(videoUrl);
        if (validateAndSetVideoUrl != null) {
            this.videoUrl = validateAndSetVideoUrl;
        }
    }

    public final void stopVideo() {
        this.mainThreadHandler.post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.PendoYoutubePlayer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PendoYoutubePlayer.stopVideo$lambda$6(PendoYoutubePlayer.this);
            }
        });
    }
}
