package expo.modules.medialibrary;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MediaLibraryEnums.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lexpo/modules/medialibrary/SortBy;", "", "keyName", "", "mediaColumnName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKeyName", "()Ljava/lang/String;", "getMediaColumnName", "DEFAULT", "CREATION_TIME", "MODIFICATION_TIME", "MEDIA_TYPE", "WIDTH", "HEIGHT", "DURATION", "Companion", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum SortBy {
    DEFAULT("default", "_id"),
    CREATION_TIME("creationTime", "datetaken"),
    MODIFICATION_TIME("modificationTime", "date_modified"),
    MEDIA_TYPE("mediaType", "media_type"),
    WIDTH("width", "width"),
    HEIGHT("height", "height"),
    DURATION("duration", "duration");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String keyName;
    private final String mediaColumnName;

    SortBy(String str, String str2) {
        this.keyName = str;
        this.mediaColumnName = str2;
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final String getMediaColumnName() {
        return this.mediaColumnName;
    }

    /* compiled from: MediaLibraryEnums.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¨\u0006\t"}, d2 = {"Lexpo/modules/medialibrary/SortBy$Companion;", "", "()V", "fromKeyName", "Lexpo/modules/medialibrary/SortBy;", "keyName", "", "getConstants", "", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getConstants() {
            SortBy[] values = SortBy.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (SortBy sortBy : values) {
                Pair pair = new Pair(sortBy.getKeyName(), sortBy.getKeyName());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        public final SortBy fromKeyName(String keyName) {
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            for (SortBy sortBy : SortBy.values()) {
                if (Intrinsics.areEqual(sortBy.getKeyName(), keyName)) {
                    return sortBy;
                }
            }
            return null;
        }
    }
}
