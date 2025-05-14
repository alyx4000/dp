package sdk.pendo.io.d7;

import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.x5.o;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/d7/a;", "Lsdk/pendo/io/a7/a;", "", "Lsdk/pendo/io/x5/o;", "observer", "", "d", "Landroid/widget/CompoundButton;", "f", "Landroid/widget/CompoundButton;", "view", "n", "()Ljava/lang/Boolean;", "initialValue", "<init>", "(Landroid/widget/CompoundButton;)V", "a", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
final class a extends sdk.pendo.io.a7.a<Boolean> {

    /* renamed from: f, reason: from kotlin metadata */
    private final CompoundButton view;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/d7/a$a;", "Lsdk/pendo/io/y5/a;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton;", "compoundButton", "", "isChecked", "", "onCheckedChanged", "b", "s", "Landroid/widget/CompoundButton;", "view", "Lsdk/pendo/io/x5/o;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/x5/o;", "observer", "<init>", "(Landroid/widget/CompoundButton;Lsdk/pendo/io/x5/o;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.d7.a$a, reason: collision with other inner class name */
    private static final class C0113a extends sdk.pendo.io.y5.a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: A, reason: from kotlin metadata */
        private final o<? super Boolean> observer;

        /* renamed from: s, reason: from kotlin metadata */
        private final CompoundButton view;

        public C0113a(CompoundButton view, o<? super Boolean> observer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.view = view;
            this.observer = observer;
        }

        @Override // sdk.pendo.io.y5.a
        protected void b() {
            this.view.setOnCheckedChangeListener(null);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            Intrinsics.checkNotNullParameter(compoundButton, "compoundButton");
            if (a()) {
                return;
            }
            this.observer.onNext(Boolean.valueOf(isChecked));
        }
    }

    public a(CompoundButton view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // sdk.pendo.io.a7.a
    protected void d(o<? super Boolean> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (sdk.pendo.io.b7.a.a(observer)) {
            C0113a c0113a = new C0113a(this.view, observer);
            observer.onSubscribe(c0113a);
            this.view.setOnCheckedChangeListener(c0113a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.a7.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Boolean m() {
        return Boolean.valueOf(this.view.isChecked());
    }
}
