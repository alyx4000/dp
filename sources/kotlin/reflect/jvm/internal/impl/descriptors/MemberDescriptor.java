package kotlin.reflect.jvm.internal.impl.descriptors;

/* loaded from: classes2.dex */
public interface MemberDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility {
    Modality getModality();

    DescriptorVisibility getVisibility();

    boolean isActual();

    boolean isExpect();

    boolean isExternal();
}
