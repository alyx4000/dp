package org.commonmark.internal.inline;

import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: classes6.dex */
public abstract class EmphasisDelimiterProcessor implements DelimiterProcessor {
    private final char delimiterChar;

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 1;
    }

    protected EmphasisDelimiterProcessor(char c) {
        this.delimiterChar = c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.delimiterChar;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.delimiterChar;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        if ((delimiterRun.canClose() || delimiterRun2.canOpen()) && delimiterRun2.originalLength() % 3 != 0 && (delimiterRun.originalLength() + delimiterRun2.originalLength()) % 3 == 0) {
            return 0;
        }
        return (delimiterRun.length() < 2 || delimiterRun2.length() < 2) ? 1 : 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text text, Text text2, int i) {
        String valueOf = String.valueOf(getOpeningCharacter());
        Node emphasis = i == 1 ? new Emphasis(valueOf) : new StrongEmphasis(valueOf + valueOf);
        Node next = text.getNext();
        while (next != null && next != text2) {
            Node next2 = next.getNext();
            emphasis.appendChild(next);
            next = next2;
        }
        text.insertAfter(emphasis);
    }
}
