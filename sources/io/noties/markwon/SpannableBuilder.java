package io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class SpannableBuilder implements Appendable, CharSequence {
    private final StringBuilder builder;
    private final Deque<Span> spans;

    static boolean isPositionValid(int i, int i2, int i3) {
        return i3 > i2 && i2 >= 0 && i3 <= i;
    }

    public static void setSpans(SpannableBuilder spannableBuilder, Object obj, int i, int i2) {
        if (obj == null || !isPositionValid(spannableBuilder.length(), i, i2)) {
            return;
        }
        setSpansInternal(spannableBuilder, obj, i, i2);
    }

    public SpannableBuilder() {
        this("");
    }

    public SpannableBuilder(CharSequence charSequence) {
        this.spans = new ArrayDeque(8);
        this.builder = new StringBuilder(charSequence);
        copySpans(0, charSequence);
    }

    public SpannableBuilder append(String str) {
        this.builder.append(str);
        return this;
    }

    @Override // java.lang.Appendable
    public SpannableBuilder append(char c) {
        this.builder.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public SpannableBuilder append(CharSequence charSequence) {
        copySpans(length(), charSequence);
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public SpannableBuilder append(CharSequence charSequence, int i, int i2) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        copySpans(length(), subSequence);
        this.builder.append(subSequence);
        return this;
    }

    public SpannableBuilder append(CharSequence charSequence, Object obj) {
        int length = length();
        append(charSequence);
        setSpan(obj, length);
        return this;
    }

    public SpannableBuilder append(CharSequence charSequence, Object obj, int i) {
        int length = length();
        append(charSequence);
        setSpan(obj, length, length(), i);
        return this;
    }

    public SpannableBuilder setSpan(Object obj, int i) {
        return setSpan(obj, i, length());
    }

    public SpannableBuilder setSpan(Object obj, int i, int i2) {
        return setSpan(obj, i, i2, 33);
    }

    public SpannableBuilder setSpan(Object obj, int i, int i2, int i3) {
        this.spans.push(new Span(obj, i, i2, i3));
        return this;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.builder.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.builder.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        List<Span> spans = getSpans(i, i2);
        if (spans.isEmpty()) {
            return this.builder.subSequence(i, i2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.builder.subSequence(i, i2));
        int length = spannableStringBuilder.length();
        for (Span span : spans) {
            int max = Math.max(0, span.start - i);
            spannableStringBuilder.setSpan(span.what, max, Math.min(length, (span.end - span.start) + max), span.flags);
        }
        return spannableStringBuilder;
    }

    public List<Span> getSpans(int i, int i2) {
        int length = length();
        if (!isPositionValid(length, i, i2)) {
            return Collections.emptyList();
        }
        if (i == 0 && length == i2) {
            ArrayList arrayList = new ArrayList(this.spans);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator<Span> descendingIterator = this.spans.descendingIterator();
        while (descendingIterator.hasNext()) {
            Span next = descendingIterator.next();
            if ((next.start >= i && next.start < i2) || ((next.end <= i2 && next.end > i) || (next.start < i && next.end > i2))) {
                arrayList2.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char lastChar() {
        return this.builder.charAt(length() - 1);
    }

    public CharSequence removeFromEnd(int i) {
        Span next;
        int length = length();
        SpannableStringBuilderReversed spannableStringBuilderReversed = new SpannableStringBuilderReversed(this.builder.subSequence(i, length));
        Iterator<Span> it = this.spans.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.start >= i && next.end <= length) {
                spannableStringBuilderReversed.setSpan(next.what, next.start - i, next.end - i, 33);
                it.remove();
            }
        }
        this.builder.replace(i, length, "");
        return spannableStringBuilderReversed;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.builder.toString();
    }

    public CharSequence text() {
        return spannableStringBuilder();
    }

    public SpannableStringBuilder spannableStringBuilder() {
        SpannableStringBuilderReversed spannableStringBuilderReversed = new SpannableStringBuilderReversed(this.builder);
        for (Span span : this.spans) {
            spannableStringBuilderReversed.setSpan(span.what, span.start, span.end, span.flags);
        }
        return spannableStringBuilderReversed;
    }

    public void clear() {
        this.builder.setLength(0);
        this.spans.clear();
    }

    private void copySpans(int i, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z = spanned instanceof SpannableStringBuilderReversed;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                if (!z) {
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = spans[i2];
                        setSpan(obj, spanned.getSpanStart(obj) + i, spanned.getSpanEnd(obj) + i, spanned.getSpanFlags(obj));
                    }
                    return;
                }
                for (int i3 = length - 1; i3 >= 0; i3--) {
                    Object obj2 = spans[i3];
                    setSpan(obj2, spanned.getSpanStart(obj2) + i, spanned.getSpanEnd(obj2) + i, spanned.getSpanFlags(obj2));
                }
            }
        }
    }

    public static class Span {
        public int end;
        public final int flags;
        public int start;
        public final Object what;

        Span(Object obj, int i, int i2, int i3) {
            this.what = obj;
            this.start = i;
            this.end = i2;
            this.flags = i3;
        }
    }

    static class SpannableStringBuilderReversed extends SpannableStringBuilder {
        SpannableStringBuilderReversed(CharSequence charSequence) {
            super(charSequence);
        }
    }

    private static void setSpansInternal(SpannableBuilder spannableBuilder, Object obj, int i, int i2) {
        if (obj != null) {
            if (obj.getClass().isArray()) {
                for (Object obj2 : (Object[]) obj) {
                    setSpansInternal(spannableBuilder, obj2, i, i2);
                }
                return;
            }
            spannableBuilder.setSpan(obj, i, i2, 33);
        }
    }
}
