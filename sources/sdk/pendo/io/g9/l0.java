package sdk.pendo.io.g9;

import sdk.pendo.io.events.ConditionData;

/* loaded from: classes6.dex */
public final class l0 {
    public static boolean a(ConditionData conditionData) {
        ConditionData.Operator operator;
        return (conditionData == null || (operator = ConditionData.Operator.get(conditionData.getOperator())) == null || operator.equals(ConditionData.Operator.EXISTS) || operator.equals(ConditionData.Operator.NOT_EXISTS)) ? false : true;
    }
}
