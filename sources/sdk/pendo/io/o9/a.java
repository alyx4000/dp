package sdk.pendo.io.o9;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.facebook.common.callercontext.ContextChain;
import io.sentry.clientreport.DiscardedEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.g9.g0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n.f;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001BA\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010,\u001a\u00020\u0018\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010/\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u000b¨\u00062"}, d2 = {"Lsdk/pendo/io/o9/a;", "Landroid/graphics/drawable/BitmapDrawable;", "", "invalidateSelf", "Landroid/graphics/Canvas;", "canvas", "draw", "", "getIntrinsicHeight", "getIntrinsicWidth", "a", "I", "mBorderColor", "b", "mBorderWidth", "", "c", "F", "mCornerRadius", "Lsdk/pendo/io/n/f$a;", "d", "Lsdk/pendo/io/n/f$a;", "mTile", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "e", "Ljava/lang/ref/WeakReference;", "mViewWeakReference", "Landroid/graphics/Matrix;", "f", "Landroid/graphics/Matrix;", "mDrawMatrix", "", "g", "Z", "mIsValid", "Landroid/graphics/Shader$TileMode;", "h", "Landroid/graphics/Shader$TileMode;", "mTileMode", ContextChain.TAG_INFRA, "mBackgroundColor", "Landroid/graphics/Bitmap;", "bitmap", "view", "", "tile", "backgroundColor", "<init>", "(Landroid/graphics/Bitmap;Landroid/view/View;Ljava/lang/String;IIIF)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a extends BitmapDrawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mBorderColor;

    /* renamed from: b, reason: from kotlin metadata */
    private final int mBorderWidth;

    /* renamed from: c, reason: from kotlin metadata */
    private final float mCornerRadius;

    /* renamed from: d, reason: from kotlin metadata */
    private final f.a mTile;

    /* renamed from: e, reason: from kotlin metadata */
    private final WeakReference<View> mViewWeakReference;

    /* renamed from: f, reason: from kotlin metadata */
    private final Matrix mDrawMatrix;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean mIsValid;

    /* renamed from: h, reason: from kotlin metadata */
    private final Shader.TileMode mTileMode;

    /* renamed from: i, reason: from kotlin metadata */
    private final int mBackgroundColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Bitmap bitmap, View view, String tile, int i, int i2, int i3, float f) {
        super(g0.b(), bitmap);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tile, "tile");
        this.mBorderColor = i2;
        this.mBorderWidth = i3;
        this.mCornerRadius = f;
        f.a b = f.a.b(tile);
        this.mTile = b;
        this.mViewWeakReference = new WeakReference<>(view);
        this.mDrawMatrix = new Matrix();
        this.mBackgroundColor = i;
        if (b != null) {
            Shader.TileMode b2 = b.b();
            this.mTileMode = b2;
            if (b2 != null) {
                setTileModeXY(b2, b2);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DiscardedEvent.JsonKeys.REASON, "wrong tile given: " + tile);
            d.a(d.b.ERROR_REASON_CONFIGURATION, jSONObject);
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
        throw new IllegalArgumentException("Given bad tile: " + tile);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.o9.a.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.mIsValid = false;
    }
}
