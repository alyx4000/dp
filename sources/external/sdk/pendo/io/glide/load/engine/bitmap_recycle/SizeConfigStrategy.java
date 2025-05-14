package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public class SizeConfigStrategy implements e {
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGBA_F16_IN_CONFIGS;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS;
    private final c keyPool = new c();
    private final d<b, Bitmap> groupedMap = new d<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f651a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f651a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f651a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f651a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f651a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class b implements f {

        /* renamed from: a, reason: collision with root package name */
        private final c f652a;
        int b;
        private Bitmap.Config c;

        public b(c cVar) {
            this.f652a = cVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.b = i;
            this.c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && k.b(this.c, bVar.c);
        }

        public int hashCode() {
            int i = this.b * 31;
            Bitmap.Config config = this.c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.b, this.c);
        }

        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f
        public void a() {
            this.f652a.a(this);
        }
    }

    static class c extends external.sdk.pendo.io.glide.load.engine.bitmap_recycle.c<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b a(int i, Bitmap.Config config) {
            b b = b();
            b.a(i, config);
            return b;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        ARGB_8888_IN_CONFIGS = configArr;
        RGBA_F16_IN_CONFIGS = configArr;
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void decrementBitmapOfSize(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num2 = (Integer) sizesForConfig.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
        }
        if (num2.intValue() == 1) {
            sizesForConfig.remove(num);
        } else {
            sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private b findBestKey(int i, Bitmap.Config config) {
        b a2 = this.keyPool.a(i, config);
        for (Bitmap.Config config2 : getInConfigs(config)) {
            Integer ceilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.keyPool.a(a2);
                return this.keyPool.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    static String getBitmapString(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return RGBA_F16_IN_CONFIGS;
        }
        int i = a.f651a[config.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new Bitmap.Config[]{config} : ALPHA_8_IN_CONFIGS : ARGB_4444_IN_CONFIGS : RGB_565_IN_CONFIGS : ARGB_8888_IN_CONFIGS;
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        b findBestKey = findBestKey(k.a(i, i2, config), config);
        Bitmap a2 = this.groupedMap.a((d<b, Bitmap>) findBestKey);
        if (a2 != null) {
            decrementBitmapOfSize(Integer.valueOf(findBestKey.b), a2);
            a2.reconfigure(i, i2, config);
        }
        return a2;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public int getSize(Bitmap bitmap) {
        return k.a(bitmap);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return getBitmapString(k.a(i, i2, config), config);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public void put(Bitmap bitmap) {
        b a2 = this.keyPool.a(k.a(bitmap), bitmap.getConfig());
        this.groupedMap.a(a2, bitmap);
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num = (Integer) sizesForConfig.get(Integer.valueOf(a2.b));
        sizesForConfig.put(Integer.valueOf(a2.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap removeLast() {
        Bitmap a2 = this.groupedMap.a();
        if (a2 != null) {
            decrementBitmapOfSize(Integer.valueOf(k.a(a2)), a2);
        }
        return a2;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.groupedMap).append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        return append.append(")}").toString();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(k.a(bitmap), bitmap.getConfig());
    }
}
