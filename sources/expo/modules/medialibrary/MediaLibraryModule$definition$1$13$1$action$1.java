package expo.modules.medialibrary;

import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: MediaLibraryModule.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class MediaLibraryModule$definition$1$13$1$action$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $albumName;
    final /* synthetic */ String $assetId;
    final /* synthetic */ boolean $copyAsset;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaLibraryModule$definition$1$13$1$action$1(MediaLibraryModule mediaLibraryModule, Promise promise, String str, String str2, boolean z) {
        super(0);
        this.this$0 = mediaLibraryModule;
        this.$promise = promise;
        this.$albumName = str;
        this.$assetId = str2;
        this.$copyAsset = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MediaLibraryModule mediaLibraryModule = this.this$0;
        Promise promise = this.$promise;
        BuildersKt__Builders_commonKt.launch$default(mediaLibraryModule.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$13$1$action$1$invoke$$inlined$withModuleScope$1(promise, null, mediaLibraryModule, this.$albumName, this.$assetId, this.$copyAsset, promise), 3, null);
    }
}
