package sdk.pendo.io.d7;

import android.widget.RadioGroup;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.x5.o;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/d7/b;", "Lsdk/pendo/io/a7/a;", "", "Lsdk/pendo/io/x5/o;", "observer", "", "d", "Landroid/widget/RadioGroup;", "f", "Landroid/widget/RadioGroup;", "view", "n", "()Ljava/lang/Integer;", "initialValue", "<init>", "(Landroid/widget/RadioGroup;)V", "a", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
final class b extends sdk.pendo.io.a7.a<Integer> {

    /* renamed from: f, reason: from kotlin metadata */
    private final RadioGroup view;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/d7/b$a;", "Lsdk/pendo/io/y5/a;", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "Landroid/widget/RadioGroup;", "radioGroup", "", "checkedId", "", "onCheckedChanged", "b", "s", "Landroid/widget/RadioGroup;", "view", "Lsdk/pendo/io/x5/o;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/x5/o;", "observer", "f0", "I", "lastChecked", "<init>", "(Landroid/widget/RadioGroup;Lsdk/pendo/io/x5/o;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final class a extends sdk.pendo.io.y5.a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: A, reason: from kotlin metadata */
        private final o<? super Integer> observer;

        /* renamed from: f0, reason: from kotlin metadata */
        private int lastChecked;

        /* renamed from: s, reason: from kotlin metadata */
        private final RadioGroup view;

        public a(RadioGroup view, o<? super Integer> observer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.view = view;
            this.observer = observer;
            this.lastChecked = -1;
        }

        @Override // sdk.pendo.io.y5.a
        protected void b() {
            this.view.setOnCheckedChangeListener(null);
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
            if (a() || checkedId == this.lastChecked) {
                return;
            }
            this.lastChecked = checkedId;
            this.observer.onNext(Integer.valueOf(checkedId));
        }
    }

    public b(RadioGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // sdk.pendo.io.a7.a
    protected void d(o<? super Integer> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (sdk.pendo.io.b7.a.a(observer)) {
            a aVar = new a(this.view, observer);
            this.view.setOnCheckedChangeListener(aVar);
            observer.onSubscribe(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.a7.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer m() {
        return Integer.valueOf(this.view.getCheckedRadioButtonId());
    }
}
