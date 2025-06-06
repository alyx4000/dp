package expo.interfaces.devmenu.items;

import expo.interfaces.devmenu.items.DevMenuSelectionList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuDataSource.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R2\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005ø\u0001\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuListDataSource;", "Lexpo/interfaces/devmenu/items/DevMenuDataSourceInterface;", "id", "", "dataFetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "Lexpo/interfaces/devmenu/items/DevMenuSelectionList$Item;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getDataFetcher", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "getId", "()Ljava/lang/String;", "fetchData", "Lexpo/interfaces/devmenu/items/DevMenuDataSourceItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuListDataSource implements DevMenuDataSourceInterface {
    private final Function1<Continuation<? super List<DevMenuSelectionList.Item>>, Object> dataFetcher;
    private final String id;

    /* JADX WARN: Multi-variable type inference failed */
    public DevMenuListDataSource(String id, Function1<? super Continuation<? super List<DevMenuSelectionList.Item>>, ? extends Object> dataFetcher) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(dataFetcher, "dataFetcher");
        this.id = id;
        this.dataFetcher = dataFetcher;
    }

    @Override // expo.interfaces.devmenu.items.DevMenuDataSourceInterface
    public String getId() {
        return this.id;
    }

    public final Function1<Continuation<? super List<DevMenuSelectionList.Item>>, Object> getDataFetcher() {
        return this.dataFetcher;
    }

    @Override // expo.interfaces.devmenu.items.DevMenuDataSourceInterface
    public Object fetchData(Continuation<? super List<? extends DevMenuDataSourceItem>> continuation) {
        return this.dataFetcher.invoke(continuation);
    }
}
