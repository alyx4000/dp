package expo.modules.structuredheaders;

/* loaded from: classes2.dex */
public interface NumberItem<T> extends Item<T>, LongSupplier {
    int getDivisor();

    @Override // expo.modules.structuredheaders.Item, expo.modules.structuredheaders.Parametrizable
    NumberItem<T> withParams(Parameters parameters);
}
