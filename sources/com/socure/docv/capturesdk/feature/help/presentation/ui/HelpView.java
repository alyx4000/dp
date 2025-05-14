package com.socure.docv.capturesdk.feature.help.presentation.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.view.a;
import io.sentry.Session;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \u0003*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \u0003*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\n \u0003*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/socure/docv/capturesdk/feature/help/presentation/ui/HelpView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getView$capturesdk_productionRelease", "()Landroid/view/View;", "view", "Landroid/widget/ImageView;", "b", "getHelpImageView", "()Landroid/widget/ImageView;", "helpImageView", "Landroidx/recyclerview/widget/RecyclerView;", "c", "getRvInstructions", "()Landroidx/recyclerview/widget/RecyclerView;", "rvInstructions", "Landroid/widget/Button;", "d", "getBtnContinue", "()Landroid/widget/Button;", "btnContinue", "Landroid/widget/TextView;", "e", "getTvPreviewTitle", "()Landroid/widget/TextView;", "tvPreviewTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class HelpView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy view;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy helpImageView;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy rvInstructions;

    /* renamed from: d, reason: from kotlin metadata */
    public final Lazy btnContinue;

    /* renamed from: e, reason: from kotlin metadata */
    public final Lazy tvPreviewTitle;

    public final class a extends RecyclerView.Adapter<C0043a> {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f433a;
        public final String b;
        public final LayoutInflater c;

        /* renamed from: com.socure.docv.capturesdk.feature.help.presentation.ui.HelpView$a$a, reason: collision with other inner class name */
        public final class C0043a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f434a;
            public TextView b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0043a(a aVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                View findViewById = itemView.findViewById(R.id.tv_instruction);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_instruction)");
                this.f434a = (TextView) findViewById;
                View findViewById2 = itemView.findViewById(R.id.tv_pointer);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_pointer)");
                this.b = (TextView) findViewById2;
            }
        }

        public a(HelpView helpView, Context context, List<String> data, String instructionTextColor) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(instructionTextColor, "instructionTextColor");
            this.f433a = data;
            this.b = instructionTextColor;
            LayoutInflater from = LayoutInflater.from(context);
            Intrinsics.checkNotNullExpressionValue(from, "from(context)");
            this.c = from;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f433a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(C0043a c0043a, int i) {
            C0043a holder = c0043a;
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.f434a.setText(this.f433a.get(i));
            holder.f434a.setTextColor(Color.parseColor(this.b));
            holder.b.setTextColor(Color.parseColor(this.b));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C0043a onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = this.c.inflate(R.layout.socure_instruction_item, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "mInflater.inflate(R.layo…tion_item, parent, false)");
            return new C0043a(this, inflate);
        }
    }

    public static final class b extends Lambda implements Function0<Button> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Button invoke() {
            return (Button) HelpView.this.getView$capturesdk_productionRelease().findViewById(R.id.btn_continue);
        }
    }

    public static final class c extends Lambda implements Function0<ImageView> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) HelpView.this.getView$capturesdk_productionRelease().findViewById(R.id.help_image_view);
        }
    }

    public static final class d extends Lambda implements Function0<RecyclerView> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public RecyclerView invoke() {
            return (RecyclerView) HelpView.this.getView$capturesdk_productionRelease().findViewById(R.id.rv_instructions);
        }
    }

    public static final class e extends Lambda implements Function0<TextView> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) HelpView.this.getView$capturesdk_productionRelease().findViewById(R.id.tv_preview_title);
        }
    }

    public static final class f extends Lambda implements Function0<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f439a;
        public final /* synthetic */ HelpView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context, HelpView helpView) {
            super(0);
            this.f439a = context;
            this.b = helpView;
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return LayoutInflater.from(this.f439a).inflate(R.layout.socure_help_view, (ViewGroup) this.b, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HelpView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HelpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new f(context, this));
        this.helpImageView = LazyKt.lazy(new c());
        this.rvInstructions = LazyKt.lazy(new d());
        this.btnContinue = LazyKt.lazy(new b());
        this.tvPreviewTitle = LazyKt.lazy(new e());
        addView(getView$capturesdk_productionRelease());
    }

    public /* synthetic */ HelpView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void a(com.socure.docv.capturesdk.common.view.a helpActionCallback, View view) {
        Intrinsics.checkNotNullParameter(helpActionCallback, "$helpActionCallback");
        helpActionCallback.a(com.socure.docv.capturesdk.common.view.model.a.CONTINUE, null);
    }

    private final Button getBtnContinue() {
        return (Button) this.btnContinue.getValue();
    }

    private final ImageView getHelpImageView() {
        return (ImageView) this.helpImageView.getValue();
    }

    private final RecyclerView getRvInstructions() {
        return (RecyclerView) this.rvInstructions.getValue();
    }

    private final TextView getTvPreviewTitle() {
        return (TextView) this.tvPreviewTitle.getValue();
    }

    public final void a(com.socure.docv.capturesdk.common.view.model.f helpViewData, final com.socure.docv.capturesdk.common.view.a helpActionCallback) {
        Intrinsics.checkNotNullParameter(helpViewData, "helpViewData");
        Intrinsics.checkNotNullParameter(helpActionCallback, "helpActionCallback");
        getTvPreviewTitle().setTextColor(Color.parseColor(helpViewData.f354a.b));
        getTvPreviewTitle().setText(helpViewData.f354a.f356a);
        getHelpImageView().setImageResource(helpViewData.b);
        getRvInstructions().setAdapter(new a(this, getContext(), helpViewData.c, helpViewData.d));
        getBtnContinue().setText(helpViewData.e.f351a);
        String str = helpViewData.e.d;
        if (str != null) {
            Button btnContinue = getBtnContinue();
            Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
            ExtensionsKt.setCorner(btnContinue, str, helpViewData.e.d);
        }
        getBtnContinue().setTextColor(Color.parseColor(helpViewData.e.b));
        getBtnContinue().setOnClickListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.help.presentation.ui.HelpView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelpView.a(a.this, view);
            }
        });
    }

    public final View getView$capturesdk_productionRelease() {
        return (View) this.view.getValue();
    }
}
