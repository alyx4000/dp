package sdk.pendo.io.views.custom;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.a6.a;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.g9.h0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.views.custom.ActionableBlock;
import sdk.pendo.io.w6.b;
import sdk.pendo.io.x5.o;

/* loaded from: classes4.dex */
public final class VisualActionButton extends AppCompatButton implements ActionableBlock, PendoCustomView {
    public static final int DISABLED_STATE_POSITION = 1;
    public static final int NORMAL_STATE_POSITION = 2;
    public static final int NUMBER_OF_STATES = 3;
    public static final int PRESSED_STATE_POSITION = 0;
    public static final h0 VOID_TRIGGER = new h0();
    private final o<h0> clickObserver;
    private final b<h0> clickSubject;
    int[] mButtonTextColors;
    private List<PendoCommand> mCommands;
    private float[] mCornerRadii;
    private GradientDrawable mDisabledBackgroundDrawable;
    private GradientDrawable mNormalBackgroundDrawable;
    private String mOnSubmit;
    private GradientDrawable mPressedBackgroundDrawable;
    private StateListDrawable mStateListDrawable;
    int[][] mStates;
    private int mStrokeColor;
    private int mStrokeWidth;
    boolean setDisabledTextColor;
    boolean setPressedTextColor;

    public VisualActionButton(Context context) {
        this(context, null);
    }

    private void generateStateListDrawableBackground() {
        this.mStateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = this.mPressedBackgroundDrawable;
        if (gradientDrawable != null) {
            ((GradientDrawable) gradientDrawable.mutate()).setCornerRadii(this.mCornerRadii);
            ((GradientDrawable) this.mPressedBackgroundDrawable.mutate()).setStroke(this.mStrokeWidth, this.mStrokeColor);
            this.mStateListDrawable.addState(new int[]{R.attr.state_pressed}, this.mPressedBackgroundDrawable);
        }
        GradientDrawable gradientDrawable2 = this.mDisabledBackgroundDrawable;
        if (gradientDrawable2 != null) {
            ((GradientDrawable) gradientDrawable2.mutate()).setCornerRadii(this.mCornerRadii);
            ((GradientDrawable) this.mDisabledBackgroundDrawable.mutate()).setStroke(this.mStrokeWidth, this.mStrokeColor);
            this.mStateListDrawable.addState(new int[]{-16842910}, this.mDisabledBackgroundDrawable);
        }
        GradientDrawable gradientDrawable3 = this.mNormalBackgroundDrawable;
        if (gradientDrawable3 != null) {
            ((GradientDrawable) gradientDrawable3.mutate()).setCornerRadii(this.mCornerRadii);
            ((GradientDrawable) this.mNormalBackgroundDrawable.mutate()).setStroke(this.mStrokeWidth, this.mStrokeColor);
            this.mStateListDrawable.addState(new int[0], this.mNormalBackgroundDrawable);
        }
        setBackground(this.mStateListDrawable);
    }

    private boolean setColorsIfNeeded() {
        int[] iArr = this.mButtonTextColors;
        if (iArr == null) {
            return false;
        }
        if (!this.setPressedTextColor) {
            iArr[0] = iArr[2];
        }
        if (!this.setDisabledTextColor) {
            iArr[1] = iArr[2];
        }
        return true;
    }

    private boolean shouldChangeDefaultBackground() {
        return (this.mNormalBackgroundDrawable == null && this.mPressedBackgroundDrawable == null && this.mDisabledBackgroundDrawable == null) ? false : true;
    }

    public void executeClick() {
        JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(this.mCommands);
        PendoCommandDispatcher.getInstance().dispatchCommands(this.mCommands, PendoCommandEventType.UserEventType.TAP_ON, true);
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public CharSequence getElementId() {
        return getContentDescription();
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public sdk.pendo.io.u2.b<ActionableBlock.OnSubmitAction, String> getOnSubmit() {
        String str = this.mOnSubmit;
        if (str != null) {
            ActionableBlock.OnSubmitAction onSubmitAction = ActionableBlock.OnSubmitAction.CLOSE;
            if (str.equals(onSubmitAction.getOnSubmitActionName())) {
                return sdk.pendo.io.u2.b.a(onSubmitAction, null);
            }
            String str2 = this.mOnSubmit;
            ActionableBlock.OnSubmitAction onSubmitAction2 = ActionableBlock.OnSubmitAction.CHANGE_SCREEN;
            if (str2.startsWith(onSubmitAction2.getOnSubmitActionName())) {
                try {
                    return sdk.pendo.io.u2.b.a(onSubmitAction2, ActionableBlock.OnSubmitAction.getChangeScreenId(this.mOnSubmit));
                } catch (IllegalStateException e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            }
        }
        return sdk.pendo.io.u2.b.a(ActionableBlock.OnSubmitAction.CLOSE, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<PendoCommand> list = this.mCommands;
        if (list == null || list.isEmpty()) {
            PendoLogger.d("No commands.", new Object[0]);
        } else {
            this.clickSubject.onNext(VOID_TRIGGER);
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (setColorsIfNeeded()) {
            setTextColor(new ColorStateList(this.mStates, this.mButtonTextColors));
        }
        if (shouldChangeDefaultBackground()) {
            generateStateListDrawableBackground();
        }
        invalidate();
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setActions(List<PendoCommand> list) {
        if (list == null || list.isEmpty()) {
            PendoLogger.d("No commands.", new Object[0]);
        } else {
            this.mCommands = list;
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] fArr) {
        this.mCornerRadii = (float[]) fArr.clone();
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float f) {
        this.mCornerRadii = new float[]{f, f, f, f, f, f, f, f};
    }

    public void setDisabledBackgroundColor(int i) {
        if (this.mDisabledBackgroundDrawable == null) {
            this.mDisabledBackgroundDrawable = new GradientDrawable();
        }
        ((GradientDrawable) this.mDisabledBackgroundDrawable.mutate()).setColor(i);
    }

    public void setDisabledTextColor(int i) {
        if (this.mButtonTextColors == null) {
            this.mButtonTextColors = new int[3];
        }
        this.mButtonTextColors[1] = i;
        this.setDisabledTextColor = true;
    }

    public void setNormalBackgroundColor(int i) {
        if (this.mNormalBackgroundDrawable == null) {
            this.mNormalBackgroundDrawable = new GradientDrawable();
        }
        ((GradientDrawable) this.mNormalBackgroundDrawable.mutate()).setColor(i);
    }

    public void setNormalTextColor(int i) {
        if (this.mButtonTextColors == null) {
            this.mButtonTextColors = new int[3];
        }
        this.mButtonTextColors[2] = i;
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setOnSubmit(String str) {
        this.mOnSubmit = str;
    }

    public void setPressedBackgroundColor(int i) {
        if (this.mPressedBackgroundDrawable == null) {
            this.mPressedBackgroundDrawable = new GradientDrawable();
        }
        ((GradientDrawable) this.mPressedBackgroundDrawable.mutate()).setColor(i);
    }

    public void setPressedTextColor(int i) {
        if (this.mButtonTextColors == null) {
            this.mButtonTextColors = new int[3];
        }
        this.mButtonTextColors[0] = i;
        this.setPressedTextColor = true;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
    }

    public VisualActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public VisualActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b<h0> n = b.n();
        this.clickSubject = n;
        o<h0> oVar = new o<h0>() { // from class: sdk.pendo.io.views.custom.VisualActionButton.1
            @Override // sdk.pendo.io.x5.o
            public void onComplete() {
            }

            @Override // sdk.pendo.io.x5.o
            public void onError(Throwable th) {
            }

            @Override // sdk.pendo.io.x5.o
            public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            }

            @Override // sdk.pendo.io.x5.o
            public void onNext(h0 h0Var) {
                VisualActionButton.this.executeClick();
            }
        };
        this.clickObserver = oVar;
        this.mStates = new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[0]};
        this.mCommands = null;
        n.a(a.a()).b(a.a()).a(500L, TimeUnit.MILLISECONDS).a(oVar);
        setOnClickListener(this);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: sdk.pendo.io.views.custom.VisualActionButton.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                accessibilityEvent.getText().add(VisualActionButton.this.getContentDescription());
            }
        });
    }
}
