package expo.modules.medialibrary;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.commons.codec.language.bm.Rule;

/* compiled from: MediaLibraryEnums.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lexpo/modules/medialibrary/MediaType;", "", "apiName", "", "mediaColumn", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getApiName", "()Ljava/lang/String;", "getMediaColumn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "AUDIO", "PHOTO", "VIDEO", "UNKNOWN", Rule.ALL, "Companion", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum MediaType {
    AUDIO("audio", 2),
    PHOTO("photo", 1),
    VIDEO("video", 3),
    UNKNOWN("unknown", 0),
    ALL("all", null);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String apiName;
    private final Integer mediaColumn;

    MediaType(String str, Integer num) {
        this.apiName = str;
        this.mediaColumn = num;
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final Integer getMediaColumn() {
        return this.mediaColumn;
    }

    /* compiled from: MediaLibraryEnums.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¨\u0006\t"}, d2 = {"Lexpo/modules/medialibrary/MediaType$Companion;", "", "()V", "fromApiName", "Lexpo/modules/medialibrary/MediaType;", "constantName", "", "getConstants", "", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getConstants() {
            MediaType[] values = MediaType.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (MediaType mediaType : values) {
                Pair pair = new Pair(mediaType.getApiName(), mediaType.getApiName());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        public final MediaType fromApiName(String constantName) {
            Intrinsics.checkNotNullParameter(constantName, "constantName");
            for (MediaType mediaType : MediaType.values()) {
                if (Intrinsics.areEqual(mediaType.getApiName(), constantName)) {
                    return mediaType;
                }
            }
            return null;
        }
    }
}
