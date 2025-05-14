package org.commonmark.node;

/* loaded from: classes6.dex */
public class HardLineBreak extends Node {
    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
