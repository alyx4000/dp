package expo.modules.medialibrary;

import android.content.Context;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.albums.migration.MigrateAlbum;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MediaLibraryModule.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class MediaLibraryModule$definition$1$16$action$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ File $albumDir;
    final /* synthetic */ List<MediaLibraryUtils.AssetFile> $assets;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaLibraryModule$definition$1$16$action$1(MediaLibraryModule mediaLibraryModule, List<MediaLibraryUtils.AssetFile> list, File file, Promise promise) {
        super(0);
        this.this$0 = mediaLibraryModule;
        this.$assets = list;
        this.$albumDir = file;
        this.$promise = promise;
    }

    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$1$16$action$1$1", f = "MediaLibraryModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.medialibrary.MediaLibraryModule$definition$1$16$action$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $albumDir;
        final /* synthetic */ List<MediaLibraryUtils.AssetFile> $assets;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ MediaLibraryModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MediaLibraryModule mediaLibraryModule, List<MediaLibraryUtils.AssetFile> list, File file, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = mediaLibraryModule;
            this.$assets = list;
            this.$albumDir = file;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$assets, this.$albumDir, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Context context = this.this$0.getContext();
                List<MediaLibraryUtils.AssetFile> list = this.$assets;
                String name = this.$albumDir.getName();
                Intrinsics.checkNotNullExpressionValue(name, "albumDir.name");
                new MigrateAlbum(context, list, name, this.$promise).execute();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new AnonymousClass1(this.this$0, this.$assets, this.$albumDir, this.$promise, null), 3, null);
    }
}
