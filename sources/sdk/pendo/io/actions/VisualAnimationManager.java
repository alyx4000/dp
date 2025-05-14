package sdk.pendo.io.actions;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import external.sdk.pendo.io.yoyo.YoYo;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.configurations.GuideTransition;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.d6.j;
import sdk.pendo.io.d8.b;
import sdk.pendo.io.g9.e;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideConfigurationModel;
import sdk.pendo.io.n.d;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;
import sdk.pendo.io.w6.a;
import sdk.pendo.io.x5.f;

/* loaded from: classes6.dex */
public final class VisualAnimationManager {
    private static final int DEFAULT_FADE_COLOR = -872415232;
    private static final int DEFAULT_FADE_ENTER_DURATION = 50;
    private static final int GUIDE_DISMISSED_DELAY = 17;
    private static final String IN_TYPE_TRANSITION = "in";
    private static final String OUT_TYPE_TRANSITION = "out";
    private static final String REVERSE_IN_TYPE_TRANSITION = "reverseIn";
    private static final String REVERSE_OUT_TYPE_TRANSITION = "reverseOut";
    private LinearLayout mFadedBackgroundLinearLayout;
    private final GuideConfigurationModel mGuideActionConfiguration;
    private final String mGuideId;
    private final a<Boolean> mFinishedAnimation = a.b(Boolean.FALSE);
    private boolean mFadedBackgroundUsesDefaultColor = true;

    VisualAnimationManager(String str, GuideConfigurationModel guideConfigurationModel) {
        this.mGuideId = str;
        this.mGuideActionConfiguration = guideConfigurationModel;
    }

    private View addFadedBackgroundLayout(ViewGroup viewGroup, ViewGroup viewGroup2, GuideTransition guideTransition, View view) {
        if (guideTransition != null) {
            String backgroundId = guideTransition.getBackgroundId();
            if (d.a().containsKey(backgroundId)) {
                view = viewGroup2.findViewById(d.a().get(backgroundId).intValue());
            }
        }
        LinearLayout linearLayout = new LinearLayout(PendoInternal.m());
        this.mFadedBackgroundLinearLayout = linearLayout;
        if (view != null) {
            Drawable background = view.getBackground();
            if (background != null) {
                setBackgroundTransparent(view);
                if (background instanceof GradientDrawable) {
                    this.mFadedBackgroundLinearLayout.setBackground(background);
                } else if (!(background instanceof sdk.pendo.io.o9.a)) {
                    this.mFadedBackgroundLinearLayout.setBackgroundColor(((ColorDrawable) background).getColor());
                }
                this.mFadedBackgroundUsesDefaultColor = false;
                viewGroup.addView(this.mFadedBackgroundLinearLayout);
                this.mFadedBackgroundLinearLayout.setVisibility(8);
                viewGroup2.setVisibility(8);
                viewGroup.addView(viewGroup2);
                return view;
            }
            linearLayout = this.mFadedBackgroundLinearLayout;
        }
        linearLayout.setBackgroundColor(DEFAULT_FADE_COLOR);
        viewGroup.addView(this.mFadedBackgroundLinearLayout);
        this.mFadedBackgroundLinearLayout.setVisibility(8);
        viewGroup2.setVisibility(8);
        viewGroup.addView(viewGroup2);
        return view;
    }

    private void hideWithAnimation(final b bVar) {
        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(this.mGuideId);
        if (visualGuide == null) {
            PendoLogger.w("Visual guide is null!", new Object[0]);
            return;
        }
        ViewGroup container = visualGuide.getContainer();
        if (container == null) {
            PendoLogger.w("Error while trying to hide guide with animation, container is null. Pendo ID = " + visualGuide.getGuideId(), new Object[0]);
            return;
        }
        if (container.getParent() == null) {
            removeViewsAndFinishUp();
            return;
        }
        GuideTransition transition = this.mGuideActionConfiguration.getTransition(REVERSE_OUT_TYPE_TRANSITION);
        GuideTransition transition2 = this.mGuideActionConfiguration.getTransition(OUT_TYPE_TRANSITION);
        if (!StepSeenManager.getInstance().isBackwardsStep() || transition == null) {
            transition = transition2;
        }
        if (transition != null) {
            PendoLogger.d(String.format(Locale.US, "Out-transition: Type [%s], Duration[%d] ", transition.getType().getType(), Integer.valueOf(transition.getDuration())), new Object[0]);
            YoYo.with(e.a(transition)).onStart(new YoYo.AnimatorCallback() { // from class: sdk.pendo.io.actions.VisualAnimationManager$$ExternalSyntheticLambda0
                @Override // external.sdk.pendo.io.yoyo.YoYo.AnimatorCallback
                public final void call(Animator animator) {
                    VisualAnimationManager.this.m3031x5b02416e(bVar, animator);
                }
            }).onEnd(new YoYo.AnimatorCallback() { // from class: sdk.pendo.io.actions.VisualAnimationManager$$ExternalSyntheticLambda1
                @Override // external.sdk.pendo.io.yoyo.YoYo.AnimatorCallback
                public final void call(Animator animator) {
                    VisualAnimationManager.this.m3032xf5a303ef(animator);
                }
            }).duration(transition.getDuration()).pivotRelationToParent(true).playOn(container);
        } else {
            AnimatorSet b = sdk.pendo.io.d8.a.b(container, visualGuide.getContainerId());
            b.addListener(new Animator.AnimatorListener(bVar) { // from class: sdk.pendo.io.actions.VisualAnimationManager.2
                final /* synthetic */ b val$statusBarColorAnimation;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    VisualAnimationManager.this.removeViewsAndFinishUp();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    VisualAnimationManager.this.reverseStatusBarAnimation(null);
                }
            });
            b.start();
        }
    }

    static /* synthetic */ sdk.pendo.io.w5.a lambda$waitForAnimationDoneAndNotifyClose$5(final String str, sdk.pendo.io.x5.d dVar) {
        PendoCommandAction.PendoCommandGlobalAction pendoCommandGlobalAction = PendoCommandAction.PendoCommandGlobalAction.NOTIFY_CLOSE;
        PendoCommandEventType pendoCommandEventType = PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY;
        PendoCommand.PendoCommandScope pendoCommandScope = PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY;
        final j<PendoCommand> createFilter = PendoCommand.createFilter("any", "any", pendoCommandGlobalAction, pendoCommandEventType, pendoCommandScope);
        final j<PendoCommand> createFilter2 = PendoCommand.createFilter("any", "any", PendoCommandAction.PendoCommandGlobalAction.OUT_ANIMATION_DONE, PendoCommandEventType.SdkEventType.ANIMATION_DONE, pendoCommandScope);
        return dVar.b(PendoCommandsEventBus.getInstance().getCommandEventBus().a(createFilter).a(17L, TimeUnit.SECONDS)).a(new j<PendoCommand>() { // from class: sdk.pendo.io.actions.VisualAnimationManager.3
            private static final String DEEPLINK = "deeplink";
            private boolean mDismissed = false;
            private boolean mAnimationDone = false;
            private boolean mIsDeepLink = false;

            @Override // sdk.pendo.io.d6.j
            public boolean test(PendoCommand pendoCommand) {
                String paramValueFromCommand = pendoCommand.getParamValueFromCommand("guideId");
                if (!TextUtils.isEmpty(paramValueFromCommand) && paramValueFromCommand.equals(str)) {
                    List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
                    if (parameters != null) {
                        for (PendoCommandsEventBus.Parameter parameter : parameters) {
                            if (parameter.getParameterName().equals("type") && parameter.getParameterValue().equals(DEEPLINK)) {
                                this.mIsDeepLink = true;
                                break;
                            }
                        }
                    }
                    try {
                        if (createFilter.test(pendoCommand)) {
                            this.mDismissed = true;
                        } else if (createFilter2.test(pendoCommand)) {
                            this.mAnimationDone = true;
                        }
                    } catch (Exception e) {
                        PendoLogger.e(e, e.getMessage(), new Object[0]);
                    }
                    if (this.mDismissed && this.mAnimationDone) {
                        this.mDismissed = false;
                        this.mAnimationDone = false;
                        if (!this.mIsDeepLink) {
                            return true;
                        }
                        this.mIsDeepLink = false;
                        return false;
                    }
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markAndAnimateStatusBar(b bVar) {
        try {
            if (VisualGuidesManager.getInstance().getVisualGuide(this.mGuideId) == null) {
                PendoLogger.w("Visual guide is null!", new Object[0]);
            }
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    private void playFadedBackgroundAnimation(final ViewGroup viewGroup, final ViewGroup viewGroup2, final GuideTransition guideTransition, final View view, final b bVar, final int i, final VisualGuideBase.VisualGuideType visualGuideType) {
        int i2 = 0;
        if (this.mFadedBackgroundLinearLayout != null && (!GuideTapOnManager.isTapOnLayoutExist() || !this.mFadedBackgroundUsesDefaultColor)) {
            this.mFadedBackgroundLinearLayout.setVisibility(0);
            i2 = 50;
        }
        YoYo.AnimationComposer pivotRelationToParent = YoYo.with(e.a(guideTransition)).onEnd(new YoYo.AnimatorCallback() { // from class: sdk.pendo.io.actions.VisualAnimationManager$$ExternalSyntheticLambda5
            @Override // external.sdk.pendo.io.yoyo.YoYo.AnimatorCallback
            public final void call(Animator animator) {
                VisualAnimationManager.this.m3033x5deaa8cb(viewGroup, viewGroup2, guideTransition, i, view, bVar, visualGuideType, animator);
            }
        }).duration(i2).pivotRelationToParent(true);
        ViewGroup viewGroup3 = this.mFadedBackgroundLinearLayout;
        if (viewGroup3 == null) {
            viewGroup3 = viewGroup2;
        }
        pivotRelationToParent.playOn(viewGroup3);
    }

    private void playGuideAnimation(ViewGroup viewGroup, ViewGroup viewGroup2, GuideTransition guideTransition, int i, View view, final b bVar, VisualGuideBase.VisualGuideType visualGuideType) {
        final VisualGuideBase visualGuide;
        if (viewGroup2 == null || (visualGuide = VisualGuidesManager.getInstance().getVisualGuide(this.mGuideId)) == null) {
            return;
        }
        try {
            if (guideTransition == null) {
                AnimatorSet a2 = sdk.pendo.io.d8.a.a(viewGroup2, i);
                viewGroup2.setVisibility(0);
                if (VisualGuideBase.VisualGuideType.TOOLTIP.equals(visualGuideType) || VisualGuideBase.VisualGuideType.BANNER.equals(visualGuideType)) {
                    viewGroup.addView(viewGroup2);
                }
                a2.addListener(new Animator.AnimatorListener(bVar) { // from class: sdk.pendo.io.actions.VisualAnimationManager.1
                    final /* synthetic */ b val$statusBarColorAnimation;

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            GuidesActionsManager.getInstance().setGuideFullyDisplayedAfterAnimation(VisualAnimationManager.this.mGuideId);
                        } catch (IllegalStateException e) {
                            PendoLogger.e(e, "Illegal state exception of GuidesManager: " + e.getMessage(), new Object[0]);
                        } catch (Exception e2) {
                            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        VisualAnimationManager.this.markAndAnimateStatusBar(null);
                    }
                });
                a2.start();
                return;
            }
            PendoLogger.d(String.format(Locale.US, "In-transition: Type [%s], Duration[%d] ", guideTransition.getType().getType(), Integer.valueOf(guideTransition.getDuration())), new Object[0]);
            viewGroup2.setVisibility(0);
            if (VisualGuideBase.VisualGuideType.TOOLTIP.equals(visualGuideType) || VisualGuideBase.VisualGuideType.BANNER.equals(visualGuideType)) {
                ((PendoFloatingVisualGuideView) viewGroup2).setFloatingGuideVisible();
            }
            View findViewById = viewGroup2.findViewById(i);
            if (findViewById != null) {
                findViewById.setBackgroundColor(0);
                if (view != null) {
                    view.setBackgroundColor(0);
                }
                YoYo.with(e.a(guideTransition)).onStart(new YoYo.AnimatorCallback() { // from class: sdk.pendo.io.actions.VisualAnimationManager$$ExternalSyntheticLambda2
                    @Override // external.sdk.pendo.io.yoyo.YoYo.AnimatorCallback
                    public final void call(Animator animator) {
                        VisualAnimationManager.this.m3034xf4b06386(bVar, animator);
                    }
                }).onEnd(new YoYo.AnimatorCallback() { // from class: sdk.pendo.io.actions.VisualAnimationManager$$ExternalSyntheticLambda3
                    @Override // external.sdk.pendo.io.yoyo.YoYo.AnimatorCallback
                    public final void call(Animator animator) {
                        VisualAnimationManager.this.m3035x8f512607(visualGuide, animator);
                    }
                }).duration(guideTransition.getDuration()).pivotRelationToParent(true).playOn(findViewById);
            }
        } catch (Exception e) {
            PendoLogger.d(e, "animation exception " + e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeViewsAndFinishUp() {
        VisualGuideBase.VisualGuideType visualGuideType;
        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(this.mGuideId);
        if (visualGuide == null) {
            PendoLogger.w("Visual guide is null!", new Object[0]);
            return;
        }
        ViewGroup rootView = visualGuide.getRootView();
        ViewGroup container = visualGuide.getContainer();
        if (rootView == null || container == null) {
            PendoLogger.w("Error trying to stop the animation and hide the Pendo.rootView is null? '" + (rootView == null) + "' container is null? '" + (container == null) + " Pendo ID = " + visualGuide.getGuideId() + "'.", new Object[0]);
            return;
        }
        try {
            visualGuideType = visualGuide.getVisualGuideType();
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), new Object[0]);
        }
        if (!VisualGuideBase.VisualGuideType.TOOLTIP.equals(visualGuideType) && !VisualGuideBase.VisualGuideType.BANNER.equals(visualGuideType)) {
            rootView.removeView(container);
            rootView.removeView(this.mFadedBackgroundLinearLayout);
            this.mFadedBackgroundLinearLayout = null;
            this.mFadedBackgroundUsesDefaultColor = true;
            GuideTapOnManager.resetTapOn();
            setOnFinishedAnimationObservable(Boolean.TRUE);
            PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(PendoCommandAction.PendoCommandGlobalAction.OUT_ANIMATION_DONE, PendoCommandEventType.SdkEventType.ANIMATION_DONE).setSourceId(visualGuide.getGuideId()).setDestinationId("any").setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(visualGuide.getGuideId())).build(), true);
            visualGuide.getAndSetShowing(false);
            visualGuide.onDestroy();
        }
        ((PendoFloatingVisualGuideView) container).removeFromParent();
        rootView.removeView(this.mFadedBackgroundLinearLayout);
        this.mFadedBackgroundLinearLayout = null;
        this.mFadedBackgroundUsesDefaultColor = true;
        GuideTapOnManager.resetTapOn();
        setOnFinishedAnimationObservable(Boolean.TRUE);
        PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(PendoCommandAction.PendoCommandGlobalAction.OUT_ANIMATION_DONE, PendoCommandEventType.SdkEventType.ANIMATION_DONE).setSourceId(visualGuide.getGuideId()).setDestinationId("any").setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(visualGuide.getGuideId())).build(), true);
        visualGuide.getAndSetShowing(false);
        visualGuide.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reverseStatusBarAnimation(b bVar) {
    }

    private void setBackgroundTransparent(View view) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        ((GradientDrawable) gradientDrawable.mutate()).setColor(0);
        view.setBackground(gradientDrawable);
    }

    private void setOnFinishedAnimationObservable(Boolean bool) {
        this.mFinishedAnimation.onNext(bool);
    }

    private void startShowingAnimation(b bVar) {
        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(this.mGuideId);
        if (visualGuide == null) {
            PendoLogger.w("Visual guide is null!", new Object[0]);
            return;
        }
        String guideId = visualGuide.getGuideId();
        ViewGroup rootView = visualGuide.getRootView();
        ViewGroup container = visualGuide.getContainer();
        if (rootView == null || container == null) {
            PendoLogger.w("Cannot start animation to display Pendo. Visual rootView is null? '" + (rootView == null) + "' container is null? '" + (container == null) + " guideId = " + guideId + ".", new Object[0]);
            return;
        }
        GuideTransition transition = this.mGuideActionConfiguration.getTransition(REVERSE_IN_TYPE_TRANSITION);
        GuideTransition transition2 = (!StepSeenManager.getInstance().isBackwardsStep() || transition == null) ? this.mGuideActionConfiguration.getTransition(IN_TYPE_TRANSITION) : transition;
        VisualGuideBase.VisualGuideType visualGuideType = visualGuide.getVisualGuideType();
        View addFadedBackgroundLayout = (VisualGuideBase.VisualGuideType.TOOLTIP.equals(visualGuideType) || VisualGuideBase.VisualGuideType.BANNER.equals(visualGuideType)) ? null : addFadedBackgroundLayout(rootView, container, transition2, null);
        GuideTapOnManager.removeSpinnerFromLayout();
        startYoYoAnimations(rootView, container, transition2, addFadedBackgroundLayout, bVar, visualGuide.getContainerId(), visualGuide.getVisualGuideType());
    }

    private void startYoYoAnimations(ViewGroup viewGroup, ViewGroup viewGroup2, GuideTransition guideTransition, View view, b bVar, int i, VisualGuideBase.VisualGuideType visualGuideType) {
        if (VisualGuideBase.VisualGuideType.TOOLTIP.equals(visualGuideType) || VisualGuideBase.VisualGuideType.BANNER.equals(visualGuideType)) {
            playGuideAnimation(viewGroup, viewGroup2, guideTransition, i, view, bVar, visualGuideType);
        } else {
            playFadedBackgroundAnimation(viewGroup, viewGroup2, guideTransition, view, bVar, i, visualGuideType);
        }
    }

    public static f<PendoCommand, PendoCommand> waitForAnimationDoneAndNotifyClose(final String str) {
        return new f() { // from class: sdk.pendo.io.actions.VisualAnimationManager$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.x5.f
            public final sdk.pendo.io.w5.a a(sdk.pendo.io.x5.d dVar) {
                return VisualAnimationManager.lambda$waitForAnimationDoneAndNotifyClose$5(str, dVar);
            }
        };
    }

    public sdk.pendo.io.x5.j<Boolean> getFinishedAnimationObservable() {
        return this.mFinishedAnimation;
    }

    /* renamed from: lambda$hideWithAnimation$3$sdk-pendo-io-actions-VisualAnimationManager, reason: not valid java name */
    /* synthetic */ void m3031x5b02416e(b bVar, Animator animator) {
        reverseStatusBarAnimation(bVar);
    }

    /* renamed from: lambda$hideWithAnimation$4$sdk-pendo-io-actions-VisualAnimationManager, reason: not valid java name */
    /* synthetic */ void m3032xf5a303ef(Animator animator) {
        removeViewsAndFinishUp();
    }

    /* renamed from: lambda$playFadedBackgroundAnimation$0$sdk-pendo-io-actions-VisualAnimationManager, reason: not valid java name */
    /* synthetic */ void m3033x5deaa8cb(ViewGroup viewGroup, ViewGroup viewGroup2, GuideTransition guideTransition, int i, View view, b bVar, VisualGuideBase.VisualGuideType visualGuideType, Animator animator) {
        playGuideAnimation(viewGroup, viewGroup2, guideTransition, i, view, bVar, visualGuideType);
    }

    /* renamed from: lambda$playGuideAnimation$1$sdk-pendo-io-actions-VisualAnimationManager, reason: not valid java name */
    /* synthetic */ void m3034xf4b06386(b bVar, Animator animator) {
        try {
            markAndAnimateStatusBar(bVar);
        } catch (Exception unused) {
        }
    }

    /* renamed from: lambda$playGuideAnimation$2$sdk-pendo-io-actions-VisualAnimationManager, reason: not valid java name */
    /* synthetic */ void m3035x8f512607(VisualGuideBase visualGuideBase, Animator animator) {
        try {
            GuidesActionsManager.getInstance().setGuideFullyDisplayedAfterAnimation(this.mGuideId);
            visualGuideBase.handleGuideSeenAnalytics();
        } catch (IllegalStateException e) {
            PendoLogger.e(e, "Illegal state exception of GuidesManager: " + e.getMessage(), new Object[0]);
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
        }
    }

    void performHide(b bVar, boolean z) {
        try {
            VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(this.mGuideId);
            if (visualGuide == null) {
                PendoLogger.w("Visual guide is null!", new Object[0]);
                return;
            }
            PendoLogger.v("Calling! showing? " + visualGuide.isShowing(), new Object[0]);
            if (!visualGuide.getAndSetShowing(false)) {
                PendoLogger.d("Already dismissing!", new Object[0]);
                return;
            }
            visualGuide.cancelDuration();
            if (z) {
                hideWithAnimation(bVar);
            } else {
                removeViewsAndFinishUp();
            }
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    void performShow(Activity activity, b bVar) {
        try {
            VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(this.mGuideId);
            if (visualGuide == null) {
                PendoLogger.w("Visual guide is null!", new Object[0]);
                return;
            }
            setOnFinishedAnimationObservable(Boolean.FALSE);
            PendoLogger.v("Calling! showing? " + visualGuide.isShowing(), new Object[0]);
            if (visualGuide.isShowing()) {
                PendoLogger.d("Already showing!", new Object[0]);
                return;
            }
            Activity f = c.g().f();
            if (!(activity instanceof PendoGuideVisualActivity)) {
                activity = f;
            }
            if (activity == null) {
                PendoLogger.e("activity is null! cant performShow", new Object[0]);
                return;
            }
            visualGuide.getAndSetShowing(true);
            startShowingAnimation(bVar);
            visualGuide.startTimeout();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }
}
