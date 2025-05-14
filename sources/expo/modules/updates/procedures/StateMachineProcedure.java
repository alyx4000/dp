package expo.modules.updates.procedures;

import expo.modules.updates.statemachine.UpdatesStateEvent;
import expo.modules.updates.statemachine.UpdatesStateValue;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: StateMachineProcedure.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineProcedure;", "", "()V", "run", "", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "ProcedureContext", "StateMachineProcedureContext", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StateMachineProcedure {

    /* compiled from: StateMachineProcedure.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "Lexpo/modules/updates/procedures/StateMachineProcedure$StateMachineProcedureContext;", "onComplete", "", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProcedureContext extends StateMachineProcedureContext {
        void onComplete();
    }

    /* compiled from: StateMachineProcedure.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lexpo/modules/updates/procedures/StateMachineProcedure$StateMachineProcedureContext;", "", "getCurrentState", "Lexpo/modules/updates/statemachine/UpdatesStateValue;", "processStateEvent", "", "event", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "resetState", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StateMachineProcedureContext {
        @Deprecated(message = "Avoid needing to access current state to know how to transition to next state")
        UpdatesStateValue getCurrentState();

        void processStateEvent(UpdatesStateEvent event);

        void resetState();
    }

    public abstract void run(ProcedureContext procedureContext);
}
