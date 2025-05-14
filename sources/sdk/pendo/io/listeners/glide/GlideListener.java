package sdk.pendo.io.listeners.glide;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.facebook.hermes.intl.Constants;
import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.request.target.Target;
import java.util.List;
import sdk.pendo.io.actions.GuidePreparationManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.e0.b;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q.a;

/* loaded from: classes6.dex */
public class GlideListener<T extends Drawable> implements b<T> {
    private final PendoCommandAction.PendoInternalAction mAction;
    private final String mGuideId;
    private final List<String> mImageSources;
    private final ImageView mImageView;
    private static final String IMAGE_FETCH_RESULT = "ImageFetchResult";
    static final PendoCommandsEventBus.Parameter SUCCESS = new PendoCommandsEventBus.Parameter(IMAGE_FETCH_RESULT, "boolean", "true");
    static final PendoCommandsEventBus.Parameter FAIL = new PendoCommandsEventBus.Parameter(IMAGE_FETCH_RESULT, "boolean", Constants.CASEFIRST_FALSE);

    public GlideListener(String str, List<String> list, PendoCommandAction.PendoInternalAction pendoInternalAction) {
        this(str, list, pendoInternalAction, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onResourceReady$0$sdk-pendo-io-listeners-glide-GlideListener, reason: not valid java name */
    /* synthetic */ void m3134x39ed5a77(Drawable drawable) {
        this.mImageView.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    @Override // sdk.pendo.io.e0.b
    public boolean onLoadFailed(n nVar, Object obj, Target<T> target, boolean z) {
        if (nVar != null) {
            PendoLogger.e(nVar, nVar.getMessage(), "guideStepId: " + this.mGuideId);
        }
        d.a(this.mGuideId, this.mImageSources);
        PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(this.mAction, PendoCommandEventType.PendoPreparationEventType.PREFETCH_IMAGES_END).setDestinationId(GuidePreparationManager.COMMAND_ACTION_DESTINATION).setSourceId(this.mGuideId).addParameter(FAIL).build(), false);
        return false;
    }

    public boolean onResourceReady(final T t, Object obj, Target<T> target, a aVar, boolean z) {
        PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(this.mAction, PendoCommandEventType.PendoPreparationEventType.PREFETCH_IMAGES_END).setDestinationId(GuidePreparationManager.COMMAND_ACTION_DESTINATION).setSourceId(this.mGuideId).addParameter(SUCCESS).build(), false);
        if (t instanceof GifDrawable) {
            ((GifDrawable) t).setLoopCount(0);
        }
        if (this.mImageView != null && t != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sdk.pendo.io.listeners.glide.GlideListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GlideListener.this.m3134x39ed5a77(t);
                }
            });
        }
        return false;
    }

    public GlideListener(String str, List<String> list, PendoCommandAction.PendoInternalAction pendoInternalAction, ImageView imageView) {
        this.mGuideId = str;
        this.mImageSources = list;
        this.mAction = pendoInternalAction;
        this.mImageView = imageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.e0.b
    public /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, a aVar, boolean z) {
        return onResourceReady((GlideListener<T>) obj, obj2, (Target<GlideListener<T>>) target, aVar, z);
    }
}
