package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class BaseProducerContext implements ProducerContext {
    private static final String ORIGIN_SUBCATEGORY_DEFAULT = "default";
    private final List<ProducerContextCallbacks> mCallbacks;
    private final Object mCallerContext;
    private final Map<String, Object> mExtras;
    private final String mId;
    private final ImagePipelineConfigInterface mImagePipelineConfig;
    private final ImageRequest mImageRequest;
    private boolean mIsCancelled;
    private boolean mIsIntermediateResultExpected;
    private boolean mIsPrefetch;
    private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    private Priority mPriority;
    private final ProducerListener2 mProducerListener;

    @Nullable
    private final String mUiComponentId;
    public static final Set<String> INITIAL_KEYS = ImmutableSet.of((Object[]) new String[]{"id", "uri_source"});
    private static final Object CALLER_CONTEXT_UNSET = new Object();

    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, @Nullable Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this(imageRequest, str, null, null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfigInterface);
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, @Nullable String str2, @Nullable Map<String, ?> map, ProducerListener2 producerListener2, @Nullable Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.mImageRequest = imageRequest;
        this.mId = str;
        HashMap hashMap = new HashMap();
        this.mExtras = hashMap;
        hashMap.put("id", str);
        hashMap.put("uri_source", imageRequest == null ? "null-request" : imageRequest.getSourceUri());
        putExtras(map);
        this.mUiComponentId = str2;
        this.mProducerListener = producerListener2;
        this.mCallerContext = obj == null ? CALLER_CONTEXT_UNSET : obj;
        this.mLowestPermittedRequestLevel = requestLevel;
        this.mIsPrefetch = z;
        this.mPriority = priority;
        this.mIsIntermediateResultExpected = z2;
        this.mIsCancelled = false;
        this.mCallbacks = new ArrayList();
        this.mImagePipelineConfig = imagePipelineConfigInterface;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @Nullable
    public String getUiComponentId() {
        return this.mUiComponentId;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ProducerListener2 getProducerListener() {
        return this.mProducerListener;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized Priority getPriority() {
        return this.mPriority;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isIntermediateResultExpected() {
        return this.mIsIntermediateResultExpected;
    }

    public synchronized boolean isCancelled() {
        return this.mIsCancelled;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void addCallbacks(ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.mCallbacks.add(producerContextCallbacks);
            z = this.mIsCancelled;
        }
        if (z) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImagePipelineConfigInterface getImagePipelineConfig() {
        return this.mImagePipelineConfig;
    }

    public void cancel() {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean z) {
        if (z == this.mIsPrefetch) {
            return null;
        }
        this.mIsPrefetch = z;
        return new ArrayList(this.mCallbacks);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority priority) {
        if (priority == this.mPriority) {
            return null;
        }
        this.mPriority = priority;
        return new ArrayList(this.mCallbacks);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        if (z == this.mIsIntermediateResultExpected) {
            return null;
        }
        this.mIsIntermediateResultExpected = z;
        return new ArrayList(this.mCallbacks);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> cancelNoCallbacks() {
        if (this.mIsCancelled) {
            return null;
        }
        this.mIsCancelled = true;
        return new ArrayList(this.mCallbacks);
    }

    public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onCancellationRequested();
        }
    }

    public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIsPrefetchChanged();
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIsIntermediateResultExpectedChanged();
        }
    }

    public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().onPriorityChanged();
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtra(String str, @Nullable Object obj) {
        if (INITIAL_KEYS.contains(str)) {
            return;
        }
        this.mExtras.put(str, obj);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtras(@Nullable Map<String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            putExtra(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    @Nullable
    public <T> T getExtra(String str) {
        return (T) this.mExtras.get(str);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    @Nullable
    public <E> E getExtra(String str, @Nullable E e) {
        E e2 = (E) this.mExtras.get(str);
        return e2 == null ? e : e2;
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public Map<String, Object> getExtras() {
        return this.mExtras;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@Nullable String str, @Nullable String str2) {
        this.mExtras.put("origin", str);
        this.mExtras.put("origin_sub", str2);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@Nullable String str) {
        putOriginExtra(str, "default");
    }
}
