package external.sdk.pendo.io.mozilla.javascript.ast;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class XmlLiteral extends AstNode {
    private List<XmlFragment> fragments;

    public XmlLiteral() {
        this.fragments = new ArrayList();
        this.type = 146;
    }

    public void addFragment(XmlFragment xmlFragment) {
        assertNotNull(xmlFragment);
        this.fragments.add(xmlFragment);
        xmlFragment.setParent(this);
    }

    public List<XmlFragment> getFragments() {
        return this.fragments;
    }

    public void setFragments(List<XmlFragment> list) {
        assertNotNull(list);
        this.fragments.clear();
        Iterator<XmlFragment> it = list.iterator();
        while (it.hasNext()) {
            addFragment(it.next());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        Iterator<XmlFragment> it = this.fragments.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toSource(0));
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Iterator<XmlFragment> it = this.fragments.iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
        }
    }

    public XmlLiteral(int i) {
        super(i);
        this.fragments = new ArrayList();
        this.type = 146;
    }

    public XmlLiteral(int i, int i2) {
        super(i, i2);
        this.fragments = new ArrayList();
        this.type = 146;
    }
}
