package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import javax.swing.JTable;

/* loaded from: classes2.dex */
class Evaluator extends JTable {
    private static final long serialVersionUID = 8133672432982594256L;
    MyTableModel tableModel;

    public Evaluator(SwingGui swingGui) {
        super(new MyTableModel(swingGui));
        this.tableModel = getModel();
    }
}
