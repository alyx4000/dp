package org.commonmark.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: classes6.dex */
class StaggeredDelimiterProcessor implements DelimiterProcessor {
    private final char delim;
    private int minLength = 0;
    private LinkedList<DelimiterProcessor> processors = new LinkedList<>();

    StaggeredDelimiterProcessor(char c) {
        this.delim = c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.delim;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.delim;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return this.minLength;
    }

    void add(DelimiterProcessor delimiterProcessor) {
        boolean z;
        int minLength;
        int minLength2 = delimiterProcessor.getMinLength();
        ListIterator<DelimiterProcessor> listIterator = this.processors.listIterator();
        do {
            if (listIterator.hasNext()) {
                minLength = listIterator.next().getMinLength();
                if (minLength2 > minLength) {
                    listIterator.previous();
                    listIterator.add(delimiterProcessor);
                    z = true;
                }
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            this.processors.add(delimiterProcessor);
            this.minLength = minLength2;
            return;
        } while (minLength2 != minLength);
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.delim + "' and minimum length " + minLength2);
    }

    private DelimiterProcessor findProcessor(int i) {
        Iterator<DelimiterProcessor> it = this.processors.iterator();
        while (it.hasNext()) {
            DelimiterProcessor next = it.next();
            if (next.getMinLength() <= i) {
                return next;
            }
        }
        return this.processors.getFirst();
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return findProcessor(delimiterRun.length()).getDelimiterUse(delimiterRun, delimiterRun2);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text text, Text text2, int i) {
        findProcessor(i).process(text, text2, i);
    }
}
