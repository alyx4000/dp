package sdk.pendo.io.c7;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u00020\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lsdk/pendo/io/c7/e;", "Lsdk/pendo/io/x5/j;", "", "Lsdk/pendo/io/x5/o;", "observer", "b", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "a", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
final class e extends j<Unit> {

    /* renamed from: f, reason: from kotlin metadata */
    private final View view;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\n¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/c7/e$a;", "Lsdk/pendo/io/y5/a;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "b", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "Lsdk/pendo/io/x5/o;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/x5/o;", "observer", "<init>", "(Landroid/view/View;Lsdk/pendo/io/x5/o;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final class a extends sdk.pendo.io.y5.a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: A, reason: from kotlin metadata */
        private final o<? super Unit> observer;

        /* renamed from: s, reason: from kotlin metadata */
        private final View view;

        public a(View view, o<? super Unit> observer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.view = view;
            this.observer = observer;
        }

        @Override // sdk.pendo.io.y5.a
        protected void b() {
            this.view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (a()) {
                return;
            }
            this.observer.onNext(Unit.INSTANCE);
        }
    }

    public e(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (sdk.pendo.io.b7.a.a(observer)) {
            a aVar = new a(this.view, observer);
            observer.onSubscribe(aVar);
            this.view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        }
    }
}
