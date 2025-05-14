package com.socure.docv.capturesdk.feature.consent.data;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentComponent;
import com.socure.docv.capturesdk.common.network.model.stepup.Content;
import io.noties.markwon.Markwon;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public final Markwon f421a;
    public final App b;
    public final List<ConsentComponent> c;
    public final Function3<String, String, Boolean, Unit> d;

    /* renamed from: com.socure.docv.capturesdk.feature.consent.data.a$a, reason: collision with other inner class name */
    public final class C0042a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public AppCompatCheckBox f422a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0042a(a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.cb_consent);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.cb_consent)");
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById;
            this.f422a = appCompatCheckBox;
            ViewCompat.enableAccessibleClickableSpanSupport(appCompatCheckBox);
            CompoundButtonCompat.setButtonTintList(this.f422a, new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(aVar.b.getTheme().getPrimary().getButton().getPrimary().getBackgroundColor()), Color.parseColor(aVar.b.getTheme().getPrimary().getColor())}));
        }
    }

    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public TextView f423a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.tv_consent_text);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_consent_text)");
            TextView textView = (TextView) findViewById;
            this.f423a = textView;
            ViewCompat.enableAccessibleClickableSpanSupport(textView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Markwon markdown, App config, List<ConsentComponent> data, Function3<? super String, ? super String, ? super Boolean, Unit> checkboxClicked) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(checkboxClicked, "checkboxClicked");
        this.f421a = markdown;
        this.b = config;
        this.c = data;
        this.d = checkboxClicked;
    }

    public static final void a(int i, ConsentComponent component, a this$0, String id, boolean z, CompoundButton compoundButton, boolean z2) {
        Intrinsics.checkNotNullParameter(component, "$component");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_CA", "position: " + i + " | mandatory: " + component.getMandatory() + " | isChecked: " + z2);
        component.setSelected(Boolean.valueOf(z2));
        this$0.d.invoke(id, z ? "mandatory" : "optional", Boolean.valueOf(z2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        String type = this.c.get(i).getType();
        Content content = Content.CHECKBOX;
        return StringsKt.equals(type, content.getLabel(), true) ? content.getType() : Content.TEXT.getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
        Unit unit;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final ConsentComponent consentComponent = this.c.get(i);
        if (!(holder instanceof C0042a)) {
            if (holder instanceof b) {
                b bVar = (b) holder;
                bVar.f423a.setTextColor(Color.parseColor(this.b.getTheme().getPrimary().getColor()));
                this.f421a.setMarkdown(bVar.f423a, consentComponent.getContent());
                return;
            }
            return;
        }
        final String id = consentComponent.getId();
        Boolean mandatory = consentComponent.getMandatory();
        if (id == null || mandatory == null) {
            unit = null;
        } else {
            final boolean booleanValue = mandatory.booleanValue();
            C0042a c0042a = (C0042a) holder;
            c0042a.f422a.setTextColor(Color.parseColor(this.b.getTheme().getPrimary().getColor()));
            this.f421a.setMarkdown(c0042a.f422a, consentComponent.getContent());
            c0042a.f422a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.socure.docv.capturesdk.feature.consent.data.a$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.a(i, consentComponent, this, id, booleanValue, compoundButton, z);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_CA", "either id or mandatory was null at position " + i, null, 4, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i == Content.CHECKBOX.getType()) {
            View inflate = from.inflate(R.layout.socure_consent_checkbox_item, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…kbox_item, parent, false)");
            return new C0042a(this, inflate);
        }
        View inflate2 = from.inflate(R.layout.socure_consent_text_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflater.inflate(R.layou…text_item, parent, false)");
        return new b(this, inflate2);
    }
}
