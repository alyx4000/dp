package io.noties.markwon;

import org.commonmark.node.Node;

/* loaded from: classes2.dex */
public interface MarkwonSpansFactory {

    public interface Builder {
        @Deprecated
        <N extends Node> Builder addFactory(Class<N> cls, SpanFactory spanFactory);

        <N extends Node> Builder appendFactory(Class<N> cls, SpanFactory spanFactory);

        MarkwonSpansFactory build();

        <N extends Node> SpanFactory getFactory(Class<N> cls);

        <N extends Node> Builder prependFactory(Class<N> cls, SpanFactory spanFactory);

        <N extends Node> SpanFactory requireFactory(Class<N> cls);

        <N extends Node> Builder setFactory(Class<N> cls, SpanFactory spanFactory);
    }

    <N extends Node> SpanFactory get(Class<N> cls);

    <N extends Node> SpanFactory require(Class<N> cls);
}
