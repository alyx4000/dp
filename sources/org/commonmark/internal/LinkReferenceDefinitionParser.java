package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.LinkReferenceDefinition;

/* loaded from: classes6.dex */
public class LinkReferenceDefinitionParser {
    private String destination;
    private StringBuilder label;
    private String normalizedLabel;
    private StringBuilder title;
    private char titleDelimiter;
    private State state = State.START_DEFINITION;
    private final StringBuilder paragraph = new StringBuilder();
    private final List<LinkReferenceDefinition> definitions = new ArrayList();
    private boolean referenceValid = false;

    enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:5:0x0015->B:20:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parse(java.lang.CharSequence r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = r3.paragraph
            int r0 = r0.length()
            if (r0 == 0) goto Lf
            java.lang.StringBuilder r0 = r3.paragraph
            r1 = 10
            r0.append(r1)
        Lf:
            java.lang.StringBuilder r0 = r3.paragraph
            r0.append(r4)
            r0 = 0
        L15:
            int r1 = r4.length()
            if (r0 >= r1) goto L4a
            int[] r1 = org.commonmark.internal.LinkReferenceDefinitionParser.AnonymousClass1.$SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State
            org.commonmark.internal.LinkReferenceDefinitionParser$State r2 = r3.state
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L42;
                case 2: goto L3d;
                case 3: goto L38;
                case 4: goto L33;
                case 5: goto L2e;
                case 6: goto L29;
                default: goto L28;
            }
        L28:
            goto L43
        L29:
            int r0 = r3.title(r4, r0)
            goto L43
        L2e:
            int r0 = r3.startTitle(r4, r0)
            goto L43
        L33:
            int r0 = r3.destination(r4, r0)
            goto L43
        L38:
            int r0 = r3.label(r4, r0)
            goto L43
        L3d:
            int r0 = r3.startDefinition(r4, r0)
            goto L43
        L42:
            return
        L43:
            r1 = -1
            if (r0 != r1) goto L15
            org.commonmark.internal.LinkReferenceDefinitionParser$State r4 = org.commonmark.internal.LinkReferenceDefinitionParser.State.PARAGRAPH
            r3.state = r4
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.LinkReferenceDefinitionParser.parse(java.lang.CharSequence):void");
    }

    /* renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State = iArr;
            try {
                iArr[State.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    CharSequence getParagraphContent() {
        return this.paragraph;
    }

    List<LinkReferenceDefinition> getDefinitions() {
        finishReference();
        return this.definitions;
    }

    State getState() {
        return this.state;
    }

    private int startDefinition(CharSequence charSequence, int i) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        if (skipSpaceTab >= charSequence.length() || charSequence.charAt(skipSpaceTab) != '[') {
            return -1;
        }
        this.state = State.LABEL;
        this.label = new StringBuilder();
        int i2 = skipSpaceTab + 1;
        if (i2 >= charSequence.length()) {
            this.label.append('\n');
        }
        return i2;
    }

    private int label(CharSequence charSequence, int i) {
        int i2;
        int scanLinkLabelContent = LinkScanner.scanLinkLabelContent(charSequence, i);
        if (scanLinkLabelContent == -1) {
            return -1;
        }
        this.label.append(charSequence, i, scanLinkLabelContent);
        if (scanLinkLabelContent >= charSequence.length()) {
            this.label.append('\n');
            return scanLinkLabelContent;
        }
        if (charSequence.charAt(scanLinkLabelContent) != ']' || (i2 = scanLinkLabelContent + 1) >= charSequence.length() || charSequence.charAt(i2) != ':' || this.label.length() > 999) {
            return -1;
        }
        String normalizeLabelContent = Escaping.normalizeLabelContent(this.label.toString());
        if (normalizeLabelContent.isEmpty()) {
            return -1;
        }
        this.normalizedLabel = normalizeLabelContent;
        this.state = State.DESTINATION;
        return Parsing.skipSpaceTab(charSequence, i2 + 1, charSequence.length());
    }

    private int destination(CharSequence charSequence, int i) {
        String obj;
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        int scanLinkDestination = LinkScanner.scanLinkDestination(charSequence, skipSpaceTab);
        if (scanLinkDestination == -1) {
            return -1;
        }
        if (charSequence.charAt(skipSpaceTab) == '<') {
            obj = charSequence.subSequence(skipSpaceTab + 1, scanLinkDestination - 1).toString();
        } else {
            obj = charSequence.subSequence(skipSpaceTab, scanLinkDestination).toString();
        }
        this.destination = obj;
        int skipSpaceTab2 = Parsing.skipSpaceTab(charSequence, scanLinkDestination, charSequence.length());
        if (skipSpaceTab2 >= charSequence.length()) {
            this.referenceValid = true;
            this.paragraph.setLength(0);
        } else if (skipSpaceTab2 == scanLinkDestination) {
            return -1;
        }
        this.state = State.START_TITLE;
        return skipSpaceTab2;
    }

    private int startTitle(CharSequence charSequence, int i) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        if (skipSpaceTab >= charSequence.length()) {
            this.state = State.START_DEFINITION;
            return skipSpaceTab;
        }
        this.titleDelimiter = (char) 0;
        char charAt = charSequence.charAt(skipSpaceTab);
        if (charAt == '\"' || charAt == '\'') {
            this.titleDelimiter = charAt;
        } else if (charAt == '(') {
            this.titleDelimiter = ')';
        }
        if (this.titleDelimiter != 0) {
            this.state = State.TITLE;
            this.title = new StringBuilder();
            skipSpaceTab++;
            if (skipSpaceTab == charSequence.length()) {
                this.title.append('\n');
            }
        } else {
            finishReference();
            this.state = State.START_DEFINITION;
        }
        return skipSpaceTab;
    }

    private int title(CharSequence charSequence, int i) {
        int scanLinkTitleContent = LinkScanner.scanLinkTitleContent(charSequence, i, this.titleDelimiter);
        if (scanLinkTitleContent == -1) {
            return -1;
        }
        this.title.append(charSequence.subSequence(i, scanLinkTitleContent));
        if (scanLinkTitleContent >= charSequence.length()) {
            this.title.append('\n');
            return scanLinkTitleContent;
        }
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, scanLinkTitleContent + 1, charSequence.length());
        if (skipSpaceTab != charSequence.length()) {
            return -1;
        }
        this.referenceValid = true;
        finishReference();
        this.paragraph.setLength(0);
        this.state = State.START_DEFINITION;
        return skipSpaceTab;
    }

    private void finishReference() {
        if (this.referenceValid) {
            String unescapeString = Escaping.unescapeString(this.destination);
            StringBuilder sb = this.title;
            this.definitions.add(new LinkReferenceDefinition(this.normalizedLabel, unescapeString, sb != null ? Escaping.unescapeString(sb.toString()) : null));
            this.label = null;
            this.referenceValid = false;
            this.normalizedLabel = null;
            this.destination = null;
            this.title = null;
        }
    }
}
