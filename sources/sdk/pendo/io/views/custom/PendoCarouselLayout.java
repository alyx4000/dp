package sdk.pendo.io.views.custom;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.sentry.Session;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.views.custom.videoplayer.PendoYoutubePlayer;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bJ\u0006\u0010'\u001a\u00020\u001dJ\u0006\u0010(\u001a\u00020%J\u0016\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+J\b\u0010-\u001a\u00020%H\u0002J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\fJ\u0016\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u00020%2\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lsdk/pendo/io/views/custom/PendoCarouselLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Session.JsonKeys.ATTRS, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "actionCallback", "sdk/pendo/io/views/custom/PendoCarouselLayout$actionCallback$1", "Lsdk/pendo/io/views/custom/PendoCarouselLayout$actionCallback$1;", "indicatorBlockContainer", "Lsdk/pendo/io/views/custom/PendoLinearLayout;", "getIndicatorBlockContainer", "()Lsdk/pendo/io/views/custom/PendoLinearLayout;", "setIndicatorBlockContainer", "(Lsdk/pendo/io/views/custom/PendoLinearLayout;)V", "indicatorContainer", "Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;", "getIndicatorContainer$annotations", "()V", "getIndicatorContainer", "()Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;", "setIndicatorContainer", "(Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;)V", "mStepViewList", "Ljava/util/ArrayList;", "Landroid/view/View;", "mViewPagerAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "<set-?>", "pagesContainer", "getPagesContainer", "()Landroid/widget/FrameLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "addStepView", "", "stepView", "getAdapter", Session.JsonKeys.INIT, "onPageSelected", "previousSelectedPage", "", "currentSelectedPage", "setAndActivateIndicator", "setAndActivateIndicatorContainerBlock", "viewLayout", "setCurrentItem", "index", "smoothScroll", "", "setOnPageChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "updatePageSelectedIndicator", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PendoCarouselLayout extends FrameLayout {
    private final PendoCarouselLayout$actionCallback$1 actionCallback;
    private PendoLinearLayout indicatorBlockContainer;
    private PendoMultipleRowViewGroup indicatorContainer;
    private final ArrayList<View> mStepViewList;
    private final PagerAdapter mViewPagerAdapter;
    private FrameLayout pagesContainer;
    private ViewPager viewPager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1] */
    public PendoCarouselLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionCallback = new o0.a() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1
            @Override // sdk.pendo.io.g9.o0.a
            public boolean performActionOnView(View view, Bundle oBundle) {
                PendoYoutubePlayer pendoYoutubePlayer = view instanceof PendoYoutubePlayer ? (PendoYoutubePlayer) view : null;
                if (pendoYoutubePlayer == null) {
                    return false;
                }
                pendoYoutubePlayer.stopVideo();
                return true;
            }
        };
        this.mStepViewList = new ArrayList<>();
        this.mViewPagerAdapter = new PagerAdapter() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$mViewPagerAdapter$1
            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(ViewGroup container, int position, Object object) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(container, "container");
                Intrinsics.checkNotNullParameter(object, "object");
                arrayList = PendoCarouselLayout.this.mStepViewList;
                container.removeView((View) arrayList.get(position));
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                ArrayList arrayList;
                arrayList = PendoCarouselLayout.this.mStepViewList;
                return arrayList.size();
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public Object instantiateItem(ViewGroup container, int position) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(container, "container");
                arrayList = PendoCarouselLayout.this.mStepViewList;
                container.addView((View) arrayList.get(position));
                arrayList2 = PendoCarouselLayout.this.mStepViewList;
                Object obj = arrayList2.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return obj;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(View view, Object object) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(object, "object");
                return view == object;
            }
        };
        init();
    }

    public static /* synthetic */ void getIndicatorContainer$annotations() {
    }

    private final void setAndActivateIndicator() {
        View childAt;
        PendoMultipleRowViewGroup pendoMultipleRowViewGroup = this.indicatorContainer;
        if (pendoMultipleRowViewGroup == null || (childAt = pendoMultipleRowViewGroup.getChildAt(0)) == null) {
            return;
        }
        Intrinsics.checkNotNull(childAt);
        ((PendoCarouselIndicatorView) childAt).setChecked(true);
    }

    private final void updatePageSelectedIndicator(int previousSelectedPage, int currentSelectedPage) {
        PendoMultipleRowViewGroup pendoMultipleRowViewGroup = this.indicatorContainer;
        if (pendoMultipleRowViewGroup != null) {
            View childAt = pendoMultipleRowViewGroup.getChildAt(previousSelectedPage);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoCarouselIndicatorView");
            View childAt2 = pendoMultipleRowViewGroup.getChildAt(currentSelectedPage);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoCarouselIndicatorView");
            ((PendoCarouselIndicatorView) childAt).setChecked(false);
            ((PendoCarouselIndicatorView) childAt2).setChecked(true);
        }
    }

    public final void addStepView(View stepView) {
        Intrinsics.checkNotNullParameter(stepView, "stepView");
        this.mStepViewList.add(stepView);
    }

    /* renamed from: getAdapter, reason: from getter */
    public final PagerAdapter getMViewPagerAdapter() {
        return this.mViewPagerAdapter;
    }

    public final PendoLinearLayout getIndicatorBlockContainer() {
        return this.indicatorBlockContainer;
    }

    public final PendoMultipleRowViewGroup getIndicatorContainer() {
        return this.indicatorContainer;
    }

    public final FrameLayout getPagesContainer() {
        return this.pagesContainer;
    }

    public final void init() {
        ViewPager viewPager = new ViewPager(getContext());
        this.viewPager = viewPager;
        Intrinsics.checkNotNull(viewPager);
        viewPager.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.pagesContainer = frameLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewPager viewPager2 = this.viewPager;
        Intrinsics.checkNotNull(viewPager2);
        viewPager2.addView(this.pagesContainer);
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            viewPager3.setAdapter(this.mViewPagerAdapter);
        }
        addView(this.viewPager);
    }

    public final void onPageSelected(int previousSelectedPage, int currentSelectedPage) {
        updatePageSelectedIndicator(previousSelectedPage, currentSelectedPage);
        o0 o0Var = o0.f1142a;
        View view = this.mStepViewList.get(previousSelectedPage);
        Intrinsics.checkNotNullExpressionValue(view, "get(...)");
        o0Var.a(view, this.actionCallback, PendoYoutubePlayer.class);
    }

    public final void setAndActivateIndicatorContainerBlock(PendoLinearLayout viewLayout) {
        View childAt;
        Intrinsics.checkNotNullParameter(viewLayout, "viewLayout");
        this.indicatorBlockContainer = viewLayout;
        if (viewLayout != null && (childAt = viewLayout.getChildAt(0)) != null) {
            Intrinsics.checkNotNull(childAt);
            PendoMultipleRowViewGroup pendoMultipleRowViewGroup = (PendoMultipleRowViewGroup) childAt;
            pendoMultipleRowViewGroup.setSingleRow(true);
            this.indicatorContainer = pendoMultipleRowViewGroup;
            setAndActivateIndicator();
        }
        addView(this.indicatorBlockContainer);
    }

    public final void setCurrentItem(int index, boolean smoothScroll) {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(index, smoothScroll);
        }
    }

    public final void setIndicatorBlockContainer(PendoLinearLayout pendoLinearLayout) {
        this.indicatorBlockContainer = pendoLinearLayout;
    }

    public final void setIndicatorContainer(PendoMultipleRowViewGroup pendoMultipleRowViewGroup) {
        this.indicatorContainer = pendoMultipleRowViewGroup;
    }

    public final void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(listener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1] */
    public PendoCarouselLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionCallback = new o0.a() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1
            @Override // sdk.pendo.io.g9.o0.a
            public boolean performActionOnView(View view, Bundle oBundle) {
                PendoYoutubePlayer pendoYoutubePlayer = view instanceof PendoYoutubePlayer ? (PendoYoutubePlayer) view : null;
                if (pendoYoutubePlayer == null) {
                    return false;
                }
                pendoYoutubePlayer.stopVideo();
                return true;
            }
        };
        this.mStepViewList = new ArrayList<>();
        this.mViewPagerAdapter = new PagerAdapter() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$mViewPagerAdapter$1
            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(ViewGroup container, int position, Object object) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(container, "container");
                Intrinsics.checkNotNullParameter(object, "object");
                arrayList = PendoCarouselLayout.this.mStepViewList;
                container.removeView((View) arrayList.get(position));
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                ArrayList arrayList;
                arrayList = PendoCarouselLayout.this.mStepViewList;
                return arrayList.size();
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public Object instantiateItem(ViewGroup container, int position) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(container, "container");
                arrayList = PendoCarouselLayout.this.mStepViewList;
                container.addView((View) arrayList.get(position));
                arrayList2 = PendoCarouselLayout.this.mStepViewList;
                Object obj = arrayList2.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return obj;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(View view, Object object) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(object, "object");
                return view == object;
            }
        };
        init();
    }
}
