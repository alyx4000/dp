package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LocalContentUriFetchProducer.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;", "Lcom/facebook/imagepipeline/producers/LocalFetchProducer;", "executor", "Ljava/util/concurrent/Executor;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "contentResolver", "Landroid/content/ContentResolver;", "(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;Landroid/content/ContentResolver;)V", "getCameraImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "uri", "Landroid/net/Uri;", "getEncodedImage", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getProducerName", "", "Companion", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    private final ContentResolver contentResolver;
    private static final String[] PROJECTION = {"_id", "_data"};

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.contentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        EncodedImage cameraImage;
        FileInputStream createInputStream;
        InputStream inputStream;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "imageRequest.sourceUri");
        if (UriUtil.isLocalContactUri(sourceUri)) {
            String uri = sourceUri.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            if (StringsKt.endsWith$default(uri, "/photo", false, 2, (Object) null)) {
                inputStream = this.contentResolver.openInputStream(sourceUri);
            } else {
                String uri2 = sourceUri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                if (StringsKt.endsWith$default(uri2, "/display_photo", false, 2, (Object) null)) {
                    try {
                        AssetFileDescriptor openAssetFileDescriptor = this.contentResolver.openAssetFileDescriptor(sourceUri, "r");
                        if (openAssetFileDescriptor == null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        createInputStream = openAssetFileDescriptor.createInputStream();
                    } catch (IOException unused) {
                        throw new IOException("Contact photo does not exist: " + sourceUri);
                    }
                } else {
                    createInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.contentResolver, sourceUri);
                    if (createInputStream == null) {
                        throw new IOException("Contact photo does not exist: " + sourceUri);
                    }
                }
                inputStream = createInputStream;
            }
            if (inputStream == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            return getEncodedImage(inputStream, -1);
        }
        if (UriUtil.isLocalCameraUri(sourceUri) && (cameraImage = getCameraImage(sourceUri)) != null) {
            return cameraImage;
        }
        InputStream openInputStream = this.contentResolver.openInputStream(sourceUri);
        if (openInputStream != null) {
            return getEncodedImage(openInputStream, -1);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final EncodedImage getCameraImage(Uri uri) throws IOException {
        try {
            ParcelFileDescriptor openFileDescriptor = this.contentResolver.openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            EncodedImage encodedImage = getEncodedImage(new FileInputStream(openFileDescriptor.getFileDescriptor()), (int) openFileDescriptor.getStatSize());
            Intrinsics.checkNotNullExpressionValue(encodedImage, "this.getEncodedImage(Fil…criptor.statSize.toInt())");
            openFileDescriptor.close();
            return encodedImage;
        } catch (FileNotFoundException unused) {
            return null;
        }
    }
}
