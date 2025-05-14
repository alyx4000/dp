package sdk.pendo.io.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.CarouselVisualGuide;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuide;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.b6.b;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.c8.f;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d6.j;
import sdk.pendo.io.g9.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.y8.a;

/* loaded from: classes6.dex */
public final class PendoGuideVisualActivity extends BaseRxActivity {
    private static final String d = "PendoGuideVisualActivity";
    private b b;
    private VisualGuide c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        finish();
        overridePendingTransition(0, 0);
        b();
    }

    public boolean a(String str, String str2, boolean z) {
        GuideModel e = z ? a.d().e() : GuidesManager.INSTANCE.getGuide(str);
        String currentStepId = StepSeenManager.getInstance().getCurrentStepId();
        if (e == null || currentStepId == null) {
            PendoLogger.w(d, "Not showing guide due to guideModel or guideStepId being null");
            return false;
        }
        a(str);
        d a2 = f.e().a(e);
        String guideStepCarouselId = e.getGuideStepCarouselId(currentStepId);
        if (guideStepCarouselId != null) {
            this.c = new CarouselVisualGuide(e, guideStepCarouselId, VisualGuidesManager.getInstance(), StepSeenManager.getInstance());
        } else {
            this.c = new VisualGuide(e, VisualGuidesManager.getInstance(), StepSeenManager.getInstance());
        }
        return l.a(this, this.c, a2, str2, currentStepId);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            PendoCommand pendoCommand = PendoCommandDispatcher.PredefinedCommands.BACK_PRESSED;
            pendoCommand.setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(this.c.getGuideId()));
            PendoCommandDispatcher.getInstance().dispatchCommand(pendoCommand, false);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            c.g().j();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    @Override // sdk.pendo.io.activities.BaseRxActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(getIntent().getStringExtra("GUIDE_ID"), getIntent().getStringExtra("ACTIVATED_BY"), getIntent().getBooleanExtra("IS_PREVIEW", false));
    }

    @Override // sdk.pendo.io.activities.BaseRxActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        GuidesManager.INSTANCE.setCurrentGuideAsNull();
        VisualGuidesManager.getInstance().setIsFullScreenGuideShowing(false);
        this.c = null;
        b();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT != 26) {
            super.setRequestedOrientation(i);
        }
    }

    public static Intent a(String str, ActivationManager.ActivationEvents activationEvents, boolean z) {
        Intent intent = new Intent(PendoInternal.m(), (Class<?>) PendoGuideVisualActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("GUIDE_ID", str);
        bundle.putString("ACTIVATED_BY", activationEvents.getActivationEvent());
        bundle.putBoolean("IS_PREVIEW", z);
        intent.putExtras(bundle);
        return intent;
    }

    public boolean b(String str, String str2, boolean z) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                getWindow().setSoftInputMode(16);
            }
            if (str != null && !str.isEmpty()) {
                if (str2 == null || str2.isEmpty()) {
                    str2 = "";
                    PendoLogger.i(d, "Activation method was not received");
                }
                if (a(str, str2, z)) {
                    return true;
                }
                finish();
                return false;
            }
            PendoLogger.i(d, "Aborting showing guide, as the guide id received is invalid");
            finish();
            return false;
        } catch (Exception e) {
            StringBuilder append = new StringBuilder().append(d).append(" activated by: ");
            if (str2 == null) {
                str2 = "missing";
            }
            StringBuilder append2 = append.append(str2).append("\n isPreview: ").append(z).append("\n guideId: ");
            if (str == null) {
                str = "no id";
            }
            PendoLogger.e(e, append2.append(str).toString(), e.getMessage());
            finish();
            return false;
        }
    }

    private void b() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.dispose();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PendoCommand pendoCommand) {
        this.b = (b) this.c.getAnimationManager().getFinishedAnimationObservable().a(new j() { // from class: sdk.pendo.io.activities.PendoGuideVisualActivity$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean booleanValue;
                booleanValue = ((Boolean) obj).booleanValue();
                return booleanValue;
            }
        }).c((sdk.pendo.io.x5.j<Boolean>) sdk.pendo.io.d9.c.a(new e() { // from class: sdk.pendo.io.activities.PendoGuideVisualActivity$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                PendoGuideVisualActivity.this.b((Boolean) obj);
            }
        }, d + " FinishedAnimationObservable"));
    }

    private void a(String str) {
        PendoCommandsEventBus.getInstance().subscribe(a(), PendoCommand.createFilter(str, "any", PendoCommandAction.PendoCommandGlobalAction.NOTIFY_CLOSE, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY), new e() { // from class: sdk.pendo.io.activities.PendoGuideVisualActivity$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                PendoGuideVisualActivity.this.a((PendoCommand) obj);
            }
        });
    }
}
