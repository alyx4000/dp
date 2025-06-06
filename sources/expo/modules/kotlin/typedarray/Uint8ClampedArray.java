package expo.modules.kotlin.typedarray;

import com.facebook.react.uimanager.ViewProps;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.jni.TypedArrayKind;
import expo.modules.kotlin.typedarray.GenericTypedArray;
import io.sentry.SentryEnvelopeItemHeader;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConcreteTypedArrays.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J!\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0096\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0096\u0001J\u0011\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\tH\u0096\u0001J\u0011\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0096\u0001J\u0011\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\tH\u0096\u0001J\u0011\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\tH\u0096\u0001J\u0011\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\tH\u0096\u0001J\u0011\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\tH\u0096\u0001J&\u0010+\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b-\u0010.J\t\u0010/\u001a\u000200H\u0096\u0001J!\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0096\u0001J\u0019\u00102\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010,\u001a\u00020!H\u0096\u0001J\u0019\u00103\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0096\u0001J\u0019\u00104\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010,\u001a\u00020$H\u0096\u0001J\u0019\u00105\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010,\u001a\u00020&H\u0096\u0001J\u0019\u00106\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010,\u001a\u00020(H\u0096\u0001J\u0019\u00107\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010,\u001a\u00020*H\u0096\u0001R\u0012\u0010\b\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015ø\u0001\u0002\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00068"}, d2 = {"Lexpo/modules/kotlin/typedarray/Uint8ClampedArray;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "Lexpo/modules/kotlin/typedarray/GenericTypedArray;", "Lkotlin/UByte;", "Lexpo/modules/kotlin/typedarray/RawTypedArrayHolder;", "rawArray", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)V", "byteLength", "", "getByteLength", "()I", "byteOffset", "getByteOffset", "kind", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "getLength", "getRawArray", "()Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "get", "index", "get-Wa3L5BU", "(I)B", IterableConstants.ITERABLE_IN_APP_READ, "", "buffer", "", ViewProps.POSITION, "size", "read2Byte", "", "read4Byte", "read8Byte", "", "readByte", "", "readDouble", "", "readFloat", "", "set", "value", "set-EK-6454", "(IB)V", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "write", "write2Byte", "write4Byte", "write8Byte", "writeByte", "writeDouble", "writeFloat", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Uint8ClampedArray implements TypedArray, GenericTypedArray<UByte>, RawTypedArrayHolder {
    private final JavaScriptTypedArray rawArray;

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getByteLength() {
        return this.rawArray.getByteLength();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getByteOffset() {
        return this.rawArray.getByteOffset();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public TypedArrayKind getKind() {
        return this.rawArray.getKind();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getLength() {
        return this.rawArray.getLength();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void read(byte[] buffer, int position, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.rawArray.read(buffer, position, size);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public short read2Byte(int position) {
        return this.rawArray.read2Byte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int read4Byte(int position) {
        return this.rawArray.read4Byte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public long read8Byte(int position) {
        return this.rawArray.read8Byte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public byte readByte(int position) {
        return this.rawArray.readByte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public double readDouble(int position) {
        return this.rawArray.readDouble(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public float readFloat(int position) {
        return this.rawArray.readFloat(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public ByteBuffer toDirectBuffer() {
        return this.rawArray.toDirectBuffer();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write(byte[] buffer, int position, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.rawArray.write(buffer, position, size);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write2Byte(int position, short value) {
        this.rawArray.write2Byte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write4Byte(int position, int value) {
        this.rawArray.write4Byte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write8Byte(int position, long value) {
        this.rawArray.write8Byte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void writeByte(int position, byte value) {
        this.rawArray.writeByte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void writeDouble(int position, double value) {
        this.rawArray.writeDouble(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void writeFloat(int position, float value) {
        this.rawArray.writeFloat(position, value);
    }

    public Uint8ClampedArray(JavaScriptTypedArray rawArray) {
        Intrinsics.checkNotNullParameter(rawArray, "rawArray");
        this.rawArray = rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public /* bridge */ /* synthetic */ UByte get(int i) {
        return UByte.m1239boximpl(m1034getWa3L5BU(i));
    }

    @Override // expo.modules.kotlin.typedarray.RawTypedArrayHolder
    public JavaScriptTypedArray getRawArray() {
        return this.rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray, java.lang.Iterable
    public Iterator<UByte> iterator() {
        return GenericTypedArray.DefaultImpls.iterator(this);
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public /* bridge */ /* synthetic */ void set(int i, UByte uByte) {
        m1035setEK6454(i, uByte.getData());
    }

    /* renamed from: get-Wa3L5BU, reason: not valid java name */
    public byte m1034getWa3L5BU(int index) {
        Uint8ClampedArray uint8ClampedArray = this;
        if (index >= 0 && index < uint8ClampedArray.getLength()) {
            return UByte.m1245constructorimpl(readByte(index * 1));
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: set-EK-6454, reason: not valid java name */
    public void m1035setEK6454(int index, byte value) {
        Uint8ClampedArray uint8ClampedArray = this;
        if (index >= 0 && index < uint8ClampedArray.getLength()) {
            writeByte(index * 1, value);
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
