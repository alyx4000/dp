package external.sdk.pendo.io.mozilla.javascript.optimizer;

import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes2.dex */
public final class OptFunctionNode {
    private int directTargetIndex = -1;
    public final FunctionNode fnode;
    boolean itsContainsCalls0;
    boolean itsContainsCalls1;
    private boolean itsParameterNumberContext;
    private boolean[] numberVarFlags;

    OptFunctionNode(FunctionNode functionNode) {
        this.fnode = functionNode;
        functionNode.setCompilerData(this);
    }

    public static OptFunctionNode get(ScriptNode scriptNode) {
        return (OptFunctionNode) scriptNode.getCompilerData();
    }

    public int getDirectTargetIndex() {
        return this.directTargetIndex;
    }

    public boolean getParameterNumberContext() {
        return this.itsParameterNumberContext;
    }

    public int getVarCount() {
        return this.fnode.getParamAndVarCount();
    }

    public int getVarIndex(Node node) {
        Node firstChild;
        int intProp = node.getIntProp(7, -1);
        if (intProp == -1) {
            int type = node.getType();
            if (type == 55) {
                firstChild = node;
            } else {
                if (type != 56 && type != 157) {
                    throw Kit.codeBug();
                }
                firstChild = node.getFirstChild();
            }
            intProp = this.fnode.getIndexForNameNode(firstChild);
            if (intProp < 0) {
                throw Kit.codeBug();
            }
            node.putIntProp(7, intProp);
        }
        return intProp;
    }

    public boolean isNumberVar(int i) {
        boolean[] zArr;
        int paramCount = i - this.fnode.getParamCount();
        if (paramCount < 0 || (zArr = this.numberVarFlags) == null) {
            return false;
        }
        return zArr[paramCount];
    }

    public boolean isParameter(int i) {
        return i < this.fnode.getParamCount();
    }

    public boolean isTargetOfDirectCall() {
        return this.directTargetIndex >= 0;
    }

    void setDirectTargetIndex(int i) {
        if (i < 0 || this.directTargetIndex >= 0) {
            Kit.codeBug();
        }
        this.directTargetIndex = i;
    }

    void setIsNumberVar(int i) {
        int paramCount = i - this.fnode.getParamCount();
        if (paramCount < 0) {
            Kit.codeBug();
        }
        if (this.numberVarFlags == null) {
            this.numberVarFlags = new boolean[this.fnode.getParamAndVarCount() - this.fnode.getParamCount()];
        }
        this.numberVarFlags[paramCount] = true;
    }

    void setParameterNumberContext(boolean z) {
        this.itsParameterNumberContext = z;
    }

    public static OptFunctionNode get(ScriptNode scriptNode, int i) {
        return (OptFunctionNode) scriptNode.getFunctionNode(i).getCompilerData();
    }
}
