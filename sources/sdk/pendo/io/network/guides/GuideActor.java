package sdk.pendo.io.network.guides;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.request.target.Target;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.models.networkReponses.GuideContentResponse;
import sdk.pendo.io.utilities.AndroidUtils;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b9\u0010:J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0006\u0010\u0012\u001a\u00020\bJ4\u0010\u001b\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J<\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016R\u0014\u0010 \u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lsdk/pendo/io/network/guides/GuideActor;", "Lsdk/pendo/io/e0/b;", "Landroid/graphics/drawable/Drawable;", "", "guideUrl", "Lsdk/pendo/io/models/networkReponses/GuideContentResponse;", "guideService", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "removeGuideFromSystem", "", "imageSources", "fetchImages", "prepareGuideContent", "prepareGuideImages", "content", "Lsdk/pendo/io/models/GuideModel;", "mergeContent", "cancelDownloads", "Lexternal/sdk/pendo/io/glide/load/engine/n;", "error", "", "p1", "Lexternal/sdk/pendo/io/glide/request/target/Target;", "p2", "", "p3", "onLoadFailed", "image", "Lsdk/pendo/io/q/a;", "p4", "onResourceReady", GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE, "Lsdk/pendo/io/models/GuideModel;", "Lsdk/pendo/io/actions/GuidesManager;", "guideManager", "Lsdk/pendo/io/actions/GuidesManager;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "", "imageCounter", "I", "getImageCounter", "()I", "setImageCounter", "(I)V", "Lkotlinx/coroutines/Job;", "jobContent", "Lkotlinx/coroutines/Job;", "getJobContent", "()Lkotlinx/coroutines/Job;", "setJobContent", "(Lkotlinx/coroutines/Job;)V", "jobImages", "getJobImages", "setJobImages", "<init>", "(Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/GuidesManager;Landroid/content/Context;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class GuideActor implements sdk.pendo.io.e0.b<Drawable> {
    private final Context context;
    private final GuideModel guide;
    private final GuidesManager guideManager;
    private int imageCounter;
    private Job jobContent;
    private Job jobImages;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.network.guides.GuideActor", f = "GuideActor.kt", i = {0}, l = {48}, m = "guideService", n = {"this"}, s = {"L$0"})
    static final class a extends ContinuationImpl {
        Object f;
        int f0;
        /* synthetic */ Object s;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.s = obj;
            this.f0 |= Integer.MIN_VALUE;
            return GuideActor.this.guideService(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.network.guides.GuideActor$prepareGuideContent$1", f = "GuideActor.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int f;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GuideActor.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GuideActor guideActor = GuideActor.this;
                String contentUrl = guideActor.guide.getContentUrl();
                Intrinsics.checkNotNullExpressionValue(contentUrl, "getContentUrl(...)");
                this.f = 1;
                obj = guideActor.guideService(contentUrl, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GuideContentResponse guideContentResponse = (GuideContentResponse) obj;
            if (guideContentResponse != null) {
                GuideActor guideActor2 = GuideActor.this;
                guideActor2.mergeContent(guideContentResponse);
                guideActor2.guide.setContentReady();
                guideActor2.prepareGuideImages();
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.network.guides.GuideActor$prepareGuideImages$1", f = "GuideActor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int f;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GuideActor.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<String> images = GuideActor.this.guide.getImages();
            Intrinsics.checkNotNull(images);
            if (!images.isEmpty()) {
                GuideActor.this.guide.setNeedsImages();
                GuideActor.this.setImageCounter(images.size());
                GuideActor.this.fetchImages(images);
            } else {
                GuideActor.this.guide.setImageReady();
            }
            return Unit.INSTANCE;
        }
    }

    public GuideActor(GuideModel guide, GuidesManager guideManager, Context context) {
        Intrinsics.checkNotNullParameter(guide, "guide");
        Intrinsics.checkNotNullParameter(guideManager, "guideManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.guide = guide;
        this.guideManager = guideManager;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchImages(List<String> imageSources) {
        try {
            Point h = AndroidUtils.h();
            for (String str : imageSources) {
                external.sdk.pendo.io.glide.a.d(this.context).m1094load(StringsKt.trim((CharSequence) str).toString()).override(h.x, h.y).diskCacheStrategy(sdk.pendo.io.t.a.f1540a).listener(this).submit();
                PendoLogger.d("downloading image: %s", str);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = imageSources.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append("\n");
            }
            PendoLogger.e(e, e.getMessage(), "Error getting images: GuideId: " + this.guide.getGuideId() + " images: " + ((Object) sb));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:11:0x002a, B:12:0x0062, B:14:0x006a, B:17:0x006e), top: B:10:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #0 {Exception -> 0x002e, blocks: (B:11:0x002a, B:12:0x0062, B:14:0x006a, B:17:0x006e), top: B:10:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object guideService(java.lang.String r7, kotlin.coroutines.Continuation<? super sdk.pendo.io.models.networkReponses.GuideContentResponse> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof sdk.pendo.io.network.guides.GuideActor.a
            if (r0 == 0) goto L13
            r0 = r8
            sdk.pendo.io.network.guides.GuideActor$a r0 = (sdk.pendo.io.network.guides.GuideActor.a) r0
            int r1 = r0.f0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f0 = r1
            goto L18
        L13:
            sdk.pendo.io.network.guides.GuideActor$a r0 = new sdk.pendo.io.network.guides.GuideActor$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.s
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f0
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r7 = r0.f
            sdk.pendo.io.network.guides.GuideActor r7 = (sdk.pendo.io.network.guides.GuideActor) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2e
            goto L62
        L2e:
            r8 = move-exception
            goto L75
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            sdk.pendo.io.q8.a r8 = sdk.pendo.io.network.interfaces.a.o()
            if (r8 == 0) goto L82
            android.net.Uri r2 = sdk.pendo.io.network.interfaces.a.g()     // Catch: java.lang.Exception -> L73
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L73
            r5.<init>()     // Catch: java.lang.Exception -> L73
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.Exception -> L73
            java.lang.StringBuilder r7 = r2.append(r7)     // Catch: java.lang.Exception -> L73
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L73
            r0.f = r6     // Catch: java.lang.Exception -> L73
            r0.f0 = r4     // Catch: java.lang.Exception -> L73
            java.lang.Object r8 = r8.a(r7, r0)     // Catch: java.lang.Exception -> L73
            if (r8 != r1) goto L61
            return r1
        L61:
            r7 = r6
        L62:
            sdk.pendo.io.y6.r r8 = (sdk.pendo.io.y6.r) r8     // Catch: java.lang.Exception -> L2e
            boolean r0 = r8.d()     // Catch: java.lang.Exception -> L2e
            if (r0 != 0) goto L6e
            r7.removeGuideFromSystem()     // Catch: java.lang.Exception -> L2e
            return r3
        L6e:
            java.lang.Object r7 = r8.a()     // Catch: java.lang.Exception -> L2e
            return r7
        L73:
            r8 = move-exception
            r7 = r6
        L75:
            r7.removeGuideFromSystem()
            java.lang.String r7 = r8.getMessage()
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            sdk.pendo.io.logging.PendoLogger.e(r8, r7, r0)
        L82:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.network.guides.GuideActor.guideService(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void removeGuideFromSystem() {
        GuidesManager guidesManager = this.guideManager;
        String guideId = this.guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        guidesManager.removeGuideFromSystem(guideId);
        this.guide.setContentError();
    }

    public final void cancelDownloads() {
        Job job = this.jobContent;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.jobImages;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    public final int getImageCounter() {
        return this.imageCounter;
    }

    public final Job getJobContent() {
        return this.jobContent;
    }

    public final Job getJobImages() {
        return this.jobImages;
    }

    public final GuideModel mergeContent(GuideContentResponse content) {
        Intrinsics.checkNotNullParameter(content, "content");
        List<StepModel> steps = this.guide.getSteps();
        Intrinsics.checkNotNullExpressionValue(steps, "getSteps(...)");
        int i = 0;
        for (Object obj : steps) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((StepModel) obj).getStepContentModel().setStepContentModel(content.getSteps().get(i).getContent().getGuide());
            f carousels = content.getCarousels();
            if (carousels != null) {
                this.guide.setCarousels(carousels);
            }
            i = i2;
        }
        return this.guide;
    }

    @Override // sdk.pendo.io.e0.b
    public boolean onLoadFailed(n error, Object p1, Target<Drawable> p2, boolean p3) {
        this.guide.setImageError();
        return false;
    }

    @Override // sdk.pendo.io.e0.b
    public boolean onResourceReady(Drawable image, Object p1, Target<Drawable> p2, sdk.pendo.io.q.a p3, boolean p4) {
        Intrinsics.checkNotNullParameter(image, "image");
        int i = this.imageCounter - 1;
        this.imageCounter = i;
        if (i != 0) {
            return false;
        }
        this.guide.setImageReady();
        return false;
    }

    public final void prepareGuideContent() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new b(null), 2, null);
        this.jobContent = launch$default;
    }

    public final void prepareGuideImages() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new c(null), 2, null);
        this.jobImages = launch$default;
    }

    public final void setImageCounter(int i) {
        this.imageCounter = i;
    }

    public final void setJobContent(Job job) {
        this.jobContent = job;
    }

    public final void setJobImages(Job job) {
        this.jobImages = job;
    }
}
