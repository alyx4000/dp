package com.quantummetric.ui.internal;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
final class cw extends cx {
    int o;
    int p;
    int q;
    Set<Integer> r;

    cw(View view) {
        super(view);
        this.r = new HashSet();
    }

    @Override // com.quantummetric.ui.internal.cx
    final void a(int i, int i2) {
        int childAdapterPosition;
        if (!this.u || this.y) {
            try {
                if (ag.a(this.B.get())) {
                    RecyclerView recyclerView = (RecyclerView) this.B.get();
                    if (recyclerView.getAdapter() != null) {
                        this.o = recyclerView.getAdapter().getItemCount();
                    }
                    if (recyclerView.getChildCount() > 1) {
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager instanceof LinearLayoutManager) {
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                            this.p = linearLayoutManager.findFirstVisibleItemPosition();
                            childAdapterPosition = linearLayoutManager.findLastVisibleItemPosition();
                        } else {
                            View childAt = recyclerView.getChildAt(0);
                            View childAt2 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                            if (childAt != null && childAt2 != null) {
                                this.p = recyclerView.getChildAdapterPosition(childAt);
                                childAdapterPosition = recyclerView.getChildAdapterPosition(childAt2);
                            }
                        }
                        this.q = childAdapterPosition;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (!this.u && (i != 0 || i2 != 0)) {
            this.u = true;
            this.r.clear();
        }
        super.a(i, i2);
    }
}
