package sdk.pendo.io.y6;

import java.lang.annotation.Annotation;

/* loaded from: classes4.dex */
final class v implements u {

    /* renamed from: a, reason: collision with root package name */
    private static final u f1859a = new v();

    v() {
    }

    static Annotation[] a(Annotation[] annotationArr) {
        if (w.a(annotationArr, (Class<? extends Annotation>) u.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = f1859a;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return u.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + u.class.getName() + "()";
    }
}
