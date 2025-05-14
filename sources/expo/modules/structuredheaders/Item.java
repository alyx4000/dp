package expo.modules.structuredheaders;

/* loaded from: classes2.dex */
public interface Item<T> extends ListElement<T>, Parametrizable<T> {
    @Override // expo.modules.structuredheaders.Parametrizable
    Item<T> withParams(Parameters parameters);
}
