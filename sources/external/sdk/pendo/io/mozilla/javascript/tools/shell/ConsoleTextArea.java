package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Segment;

/* loaded from: classes2.dex */
public class ConsoleTextArea extends JTextArea implements KeyListener, DocumentListener {
    static final long serialVersionUID = 8557083244830872961L;
    private PipedInputStream in;
    private PrintWriter inPipe;
    private int historyIndex = -1;
    private int outputMark = 0;
    private List<String> history = new ArrayList();
    private ConsoleWriter console1 = new ConsoleWriter(this);
    private ConsoleWriter console2 = new ConsoleWriter(this);
    private PrintStream out = new PrintStream((OutputStream) this.console1, true);
    private PrintStream err = new PrintStream((OutputStream) this.console2, true);

    public ConsoleTextArea(String[] strArr) {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.inPipe = new PrintWriter(pipedOutputStream);
        PipedInputStream pipedInputStream = new PipedInputStream();
        this.in = pipedInputStream;
        try {
            pipedOutputStream.connect(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getDocument().addDocumentListener(this);
        addKeyListener(this);
        setLineWrap(true);
        setFont(new Font("Monospaced", 0, 12));
    }

    public synchronized void changedUpdate(DocumentEvent documentEvent) {
    }

    public void eval(String str) {
        this.inPipe.write(str);
        this.inPipe.write("\n");
        this.inPipe.flush();
        this.console1.flush();
    }

    public PrintStream getErr() {
        return this.err;
    }

    public InputStream getIn() {
        return this.in;
    }

    public PrintStream getOut() {
        return this.out;
    }

    public synchronized void insertUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        int offset = documentEvent.getOffset();
        int i = this.outputMark;
        if (i > offset) {
            this.outputMark = i + length;
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 8 || keyCode == 37) {
            if (this.outputMark != getCaretPosition()) {
                return;
            }
        } else if (keyCode == 36) {
            int caretPosition = getCaretPosition();
            int i = this.outputMark;
            if (caretPosition != i) {
                if (caretPosition <= i || keyEvent.isControlDown()) {
                    return;
                }
                if (keyEvent.isShiftDown()) {
                    moveCaretPosition(this.outputMark);
                } else {
                    setCaretPosition(this.outputMark);
                }
            }
        } else if (keyCode == 10) {
            returnPressed();
        } else if (keyCode == 38) {
            int i2 = this.historyIndex - 1;
            this.historyIndex = i2;
            if (i2 >= 0) {
                if (i2 >= this.history.size()) {
                    this.historyIndex = this.history.size() - 1;
                }
                i2 = this.historyIndex;
                if (i2 >= 0) {
                    String str = this.history.get(i2);
                    replaceRange(str, this.outputMark, getDocument().getLength());
                    int length = this.outputMark + str.length();
                    select(length, length);
                }
            }
            this.historyIndex = i2 + 1;
        } else {
            if (keyCode != 40) {
                return;
            }
            int i3 = this.outputMark;
            if (this.history.size() > 0) {
                int i4 = this.historyIndex + 1;
                this.historyIndex = i4;
                if (i4 < 0) {
                    this.historyIndex = 0;
                }
                int length2 = getDocument().getLength();
                if (this.historyIndex < this.history.size()) {
                    String str2 = this.history.get(this.historyIndex);
                    replaceRange(str2, this.outputMark, length2);
                    i3 = str2.length() + this.outputMark;
                } else {
                    this.historyIndex = this.history.size();
                    replaceRange("", this.outputMark, length2);
                }
            }
            select(i3, i3);
        }
        keyEvent.consume();
    }

    public synchronized void keyReleased(KeyEvent keyEvent) {
    }

    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == '\b') {
            if (this.outputMark == getCaretPosition()) {
                keyEvent.consume();
            }
        } else {
            int caretPosition = getCaretPosition();
            int i = this.outputMark;
            if (caretPosition < i) {
                setCaretPosition(i);
            }
        }
    }

    public synchronized void postUpdateUI() {
        requestFocus();
        setCaret(getCaret());
        int i = this.outputMark;
        select(i, i);
    }

    public synchronized void removeUpdate(DocumentEvent documentEvent) {
        int length = documentEvent.getLength();
        int offset = documentEvent.getOffset();
        int i = this.outputMark;
        if (i > offset) {
            if (i >= offset + length) {
                this.outputMark = i - length;
            } else {
                this.outputMark = offset;
            }
        }
    }

    synchronized void returnPressed() {
        Document document = getDocument();
        int length = document.getLength();
        Segment segment = new Segment();
        try {
            int i = this.outputMark;
            document.getText(i, length - i, segment);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        if (segment.count > 0) {
            this.history.add(segment.toString());
        }
        this.historyIndex = this.history.size();
        this.inPipe.write(segment.array, segment.offset, segment.count);
        append("\n");
        this.outputMark = document.getLength();
        this.inPipe.write("\n");
        this.inPipe.flush();
        this.console1.flush();
    }

    public void select(int i, int i2) {
        requestFocus();
        super.select(i, i2);
    }

    public synchronized void write(String str) {
        insert(str, this.outputMark);
        int length = this.outputMark + str.length();
        this.outputMark = length;
        select(length, length);
    }
}
