package kotlin.reflect.jvm.internal.impl.resolve;

import _COROUTINE.ArtificialStackFrames;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: overridingUtils.kt */
/* loaded from: classes2.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> descriptorByHandle) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (true) {
            LinkedList linkedList2 = linkedList;
            if (!linkedList2.isEmpty()) {
                Object first = CollectionsKt.first((List<? extends Object>) linkedList);
                final SmartSet create2 = SmartSet.Companion.create();
                Collection<ArtificialStackFrames> extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList2, descriptorByHandle, new Function1<H, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2((OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1<H>) obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(H it) {
                        SmartSet<H> smartSet = create2;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        smartSet.add(it);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(extractMembersOverridableInBothWays, "conflictedHandles = Smar…nflictedHandles.add(it) }");
                if (extractMembersOverridableInBothWays.size() == 1 && create2.isEmpty()) {
                    Object single = CollectionsKt.single(extractMembersOverridableInBothWays);
                    Intrinsics.checkNotNullExpressionValue(single, "overridableGroup.single()");
                    create.add(single);
                } else {
                    ArtificialStackFrames artificialStackFrames = (Object) OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, descriptorByHandle);
                    Intrinsics.checkNotNullExpressionValue(artificialStackFrames, "selectMostSpecificMember…roup, descriptorByHandle)");
                    CallableDescriptor invoke = descriptorByHandle.invoke(artificialStackFrames);
                    for (ArtificialStackFrames it : extractMembersOverridableInBothWays) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        if (!OverridingUtil.isMoreSpecific(invoke, descriptorByHandle.invoke(it))) {
                            create2.add(it);
                        }
                    }
                    SmartSet smartSet = create2;
                    if (!smartSet.isEmpty()) {
                        create.addAll(smartSet);
                    }
                    create.add(artificialStackFrames);
                }
            } else {
                return create;
            }
        }
    }
}
