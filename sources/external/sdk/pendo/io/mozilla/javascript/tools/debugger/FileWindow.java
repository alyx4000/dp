package external.sdk.pendo.io.mozilla.javascript.tools.debugger;

import external.sdk.pendo.io.mozilla.javascript.tools.debugger.Dim;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;

/* loaded from: classes2.dex */
class FileWindow extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = -6212382604952082370L;
    int currentPos;
    private SwingGui debugGui;
    private FileHeader fileHeader;
    private JScrollPane p;
    private Dim.SourceInfo sourceInfo;
    FileTextArea textArea;

    public FileWindow(SwingGui swingGui, Dim.SourceInfo sourceInfo) {
        super(SwingGui.getShortName(sourceInfo.url()), true, true, true, true);
        this.debugGui = swingGui;
        this.sourceInfo = sourceInfo;
        updateToolTip();
        this.currentPos = -1;
        FileTextArea fileTextArea = new FileTextArea(this);
        this.textArea = fileTextArea;
        fileTextArea.setRows(24);
        this.textArea.setColumns(80);
        this.p = new JScrollPane();
        this.fileHeader = new FileHeader(this);
        this.p.setViewportView(this.textArea);
        this.p.setRowHeaderView(this.fileHeader);
        setContentPane(this.p);
        pack();
        updateText(sourceInfo);
        this.textArea.select(0);
    }

    private void updateToolTip() {
        int i = 1;
        int componentCount = getComponentCount() - 1;
        if (componentCount <= 1) {
            if (componentCount < 0) {
                return;
            } else {
                i = componentCount;
            }
        }
        JComponent component = getComponent(i);
        if (component == null || !(component instanceof JComponent)) {
            return;
        }
        component.setToolTipText(getUrl());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("Cut")) {
            return;
        }
        if (actionCommand.equals("Copy")) {
            this.textArea.copy();
        } else {
            actionCommand.equals("Paste");
        }
    }

    public void clearBreakPoint(int i) {
        if (this.sourceInfo.breakableLine(i) && this.sourceInfo.breakpoint(i, false)) {
            this.fileHeader.repaint();
        }
    }

    public void dispose() {
        this.debugGui.removeWindow(this);
        super.dispose();
    }

    public int getPosition(int i) {
        try {
            return this.textArea.getLineStartOffset(i);
        } catch (BadLocationException unused) {
            return -1;
        }
    }

    public String getUrl() {
        return this.sourceInfo.url();
    }

    public boolean isBreakPoint(int i) {
        return this.sourceInfo.breakableLine(i) && this.sourceInfo.breakpoint(i);
    }

    void load() {
        String url = getUrl();
        if (url != null) {
            RunProxy runProxy = new RunProxy(this.debugGui, 2);
            runProxy.fileName = url;
            runProxy.text = this.sourceInfo.source();
            new Thread(runProxy).start();
        }
    }

    public void select(int i, int i2) {
        int length = this.textArea.getDocument().getLength();
        this.textArea.select(length, length);
        this.textArea.select(i, i2);
    }

    public void setBreakPoint(int i) {
        if (this.sourceInfo.breakableLine(i) && this.sourceInfo.breakpoint(i, true)) {
            this.fileHeader.repaint();
        }
    }

    public void setPosition(int i) {
        this.textArea.select(i);
        this.currentPos = i;
        this.fileHeader.repaint();
    }

    public void toggleBreakPoint(int i) {
        if (isBreakPoint(i)) {
            clearBreakPoint(i);
        } else {
            setBreakPoint(i);
        }
    }

    public void updateText(Dim.SourceInfo sourceInfo) {
        this.sourceInfo = sourceInfo;
        String source = sourceInfo.source();
        if (!this.textArea.getText().equals(source)) {
            this.textArea.setText(source);
            int i = this.currentPos;
            if (i == -1) {
                i = 0;
            }
            this.textArea.select(i);
        }
        this.fileHeader.update();
        this.fileHeader.repaint();
    }
}
