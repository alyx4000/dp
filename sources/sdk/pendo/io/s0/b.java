package sdk.pendo.io.s0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;

/* loaded from: classes6.dex */
public class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private Context f1532a;
    private a b;
    private TextPaint c;
    private int d = -1;
    private int e = 255;

    public b(Context context, a aVar) {
        a(context, aVar);
    }

    public b a(int i) {
        setAlpha(i);
        invalidateSelf();
        return this;
    }

    public b b(int i) {
        this.c.setColor(i);
        invalidateSelf();
        return this;
    }

    public b c(int i) {
        this.d = i;
        setBounds(0, 0, i, i);
        invalidateSelf();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.c.setColorFilter(null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.c.setTextSize(bounds.height());
        Rect rect = new Rect();
        String valueOf = String.valueOf(this.b.a());
        this.c.getTextBounds(valueOf, 0, 1, rect);
        canvas.drawText(valueOf, bounds.exactCenterX(), ((bounds.top + ((r1 - r4) / 2.0f)) + rect.height()) - rect.bottom, this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.c.getAlpha() != i) {
            this.c.setAlpha(i);
        }
        if (i != this.e) {
            this.e = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.c.getColorFilter() != colorFilter) {
            this.c.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        int alpha = this.c.getAlpha();
        int i = a(iArr) ? this.e : this.e / 2;
        this.c.setAlpha(i);
        return alpha != i;
    }

    private void a(Context context, a aVar) {
        this.f1532a = context;
        this.b = aVar;
        this.c = new TextPaint();
        sdk.pendo.io.t0.a a2 = d.a(aVar);
        if (a2 == null) {
            throw new IllegalStateException("Unable to find the module associated with icon " + aVar.b() + ", have you registered the module you are trying to use with Iconify.with(...) in your Application?");
        }
        this.c.setTypeface(a2.a(context));
        this.c.setStyle(Paint.Style.FILL);
        this.c.setTextAlign(Paint.Align.CENTER);
        this.c.setUnderlineText(false);
        this.c.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.c.setAntiAlias(true);
    }

    private boolean a(int[] iArr) {
        for (int i : iArr) {
            if (i == 16842910) {
                return true;
            }
        }
        return false;
    }
}
