package io.noties.markwon;

import io.noties.markwon.MarkwonVisitor;

/* loaded from: classes2.dex */
abstract class MarkwonVisitorFactory {
    abstract MarkwonVisitor create();

    MarkwonVisitorFactory() {
    }

    static MarkwonVisitorFactory create(final MarkwonVisitor.Builder builder, final MarkwonConfiguration markwonConfiguration) {
        return new MarkwonVisitorFactory() { // from class: io.noties.markwon.MarkwonVisitorFactory.1
            @Override // io.noties.markwon.MarkwonVisitorFactory
            MarkwonVisitor create() {
                return MarkwonVisitor.Builder.this.build(markwonConfiguration, new RenderPropsImpl());
            }
        };
    }
}
