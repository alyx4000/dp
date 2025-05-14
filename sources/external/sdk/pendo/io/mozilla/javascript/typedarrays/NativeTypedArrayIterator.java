package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class NativeTypedArrayIterator<T> implements ListIterator<T> {
    private int lastPosition = -1;
    private int position;
    private final NativeTypedArrayView<T> view;

    NativeTypedArrayIterator(NativeTypedArrayView<T> nativeTypedArrayView, int i) {
        this.view = nativeTypedArrayView;
        this.position = i;
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.position < this.view.length;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.position > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T t = this.view.get(this.position);
        int i = this.position;
        this.lastPosition = i;
        this.position = i + 1;
        return t;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.position;
    }

    @Override // java.util.ListIterator
    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.position - 1;
        this.position = i;
        this.lastPosition = i;
        return this.view.get(i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.position - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void set(T t) {
        int i = this.lastPosition;
        if (i < 0) {
            throw new IllegalStateException();
        }
        this.view.js_set(i, t);
    }
}
