package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoveImageTransformMetaDataProducer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\rB\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/common/memory/PooledByteBuffer;", "inputProducer", "Lcom/facebook/imagepipeline/image/EncodedImage;", "(Lcom/facebook/imagepipeline/producers/Producer;)V", "produceResults", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "context", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "RemoveImageTransformMetaDataConsumer", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {
    private final Producer<EncodedImage> inputProducer;

    public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        this.inputProducer = inputProducer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<PooledByteBuffer>> consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(this, consumer), context);
    }

    /* compiled from: RemoveImageTransformMetaDataProducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$RemoveImageTransformMetaDataConsumer;", "Lcom/facebook/imagepipeline/producers/DelegatingConsumer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/common/memory/PooledByteBuffer;", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "(Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;Lcom/facebook/imagepipeline/producers/Consumer;)V", "onNewResultImpl", "", "newResult", "status", "", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
        final /* synthetic */ RemoveImageTransformMetaDataProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveImageTransformMetaDataConsumer(RemoveImageTransformMetaDataProducer removeImageTransformMetaDataProducer, Consumer<CloseableReference<PooledByteBuffer>> consumer) {
            super(consumer);
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            this.this$0 = removeImageTransformMetaDataProducer;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage newResult, int status) {
            CloseableReference<PooledByteBuffer> closeableReference = null;
            try {
                if (EncodedImage.isValid(newResult) && newResult != null) {
                    closeableReference = newResult.getByteBufferRef();
                }
                getConsumer().onNewResult(closeableReference, status);
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
        }
    }
}
