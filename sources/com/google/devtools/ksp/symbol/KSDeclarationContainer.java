package com.google.devtools.ksp.symbol;

import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* compiled from: KSDeclarationContainer.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSDeclarationContainer;", "Lcom/google/devtools/ksp/symbol/KSNode;", "declarations", "Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "getDeclarations", "()Lkotlin/sequences/Sequence;", "api"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KSDeclarationContainer extends KSNode {
    Sequence<KSDeclaration> getDeclarations();
}
