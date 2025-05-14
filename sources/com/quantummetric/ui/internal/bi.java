package com.quantummetric.ui.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.pager.PagerScrollPosition;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotMutableStateImpl;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import com.iterable.iterableapi.IterableConstants;
import com.quantummetric.ui.internal.s;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
final class bi {
    private static Bitmap a(LayoutNode layoutNode, Modifier modifier, Object obj, boolean z) {
        Object b = by.b(obj, "state$delegate");
        if (b == null) {
            return null;
        }
        Object value = b instanceof SnapshotMutableState ? ((SnapshotMutableState) b).getValue() : null;
        if (value == null) {
            return null;
        }
        if (!z || !value.getClass().getName().contains("Loading")) {
            Object b2 = by.b(by.b(value, "result"), IterableConstants.ICON_FOLDER_IDENTIFIER);
            if (b2 instanceof BitmapDrawable) {
                return ((BitmapDrawable) b2).getBitmap();
            }
            return null;
        }
        s.c a2 = s.a().a(layoutNode, s.d.b);
        if (a2.c == null) {
            a2.c = new HashMap<>();
        }
        a2.c.put("PAINTER_MODIFIER", modifier);
        return null;
    }

    static Bitmap a(LayoutNode layoutNode, Modifier modifier, boolean z) {
        Object obj;
        Object b = by.b(modifier, "painter");
        if (b != null) {
            String name = b.getClass().getName();
            if (name.contains("coil")) {
                obj = a(layoutNode, modifier, b, z);
            } else {
                Object b2 = name.contains("vector") ? by.b(modifier, "painter", "vector", "cacheDrawScope", "mCachedImage", "bitmap") : name.contains("BitmapPainter") ? by.b(b, "image", "bitmap") : null;
                if (b2 == null && z) {
                    s.c a2 = s.a().a(layoutNode, s.d.b);
                    if (a2.c == null) {
                        a2.c = new HashMap<>();
                    }
                    a2.c.put("PAINTER_MODIFIER", modifier);
                }
                obj = b2;
            }
        } else {
            obj = null;
        }
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    private static cm a(Object obj, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        Object obj2 = field.get(obj);
        cm cfVar = (!(obj2 instanceof SnapshotMutableStateImpl) || (obj2 instanceof cg)) ? ag.d(obj2) ? new cf((MutableIntState) obj2) : null : new cg((SnapshotMutableStateImpl) obj2);
        if (cfVar != null) {
            field.set(obj, cfVar);
        }
        return cfVar;
    }

    static Object a(Object obj) {
        Object b = by.b(obj, "$coercedProgress");
        return (b == null || (b instanceof Float)) ? b : by.b(b, "$progress", "$progress");
    }

    private static List<Integer> a(Brush brush) {
        List list = (List) by.b(brush, "colors");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Object a2 = by.a(((Long) by.b(list.get(i), "value")).longValue());
            if (a2 instanceof Integer) {
                Integer num = (Integer) a2;
                if (num.intValue() != 0) {
                    arrayList.add(num);
                }
            }
        }
        return arrayList;
    }

    private static void a(LayoutNode layoutNode) {
        for (LayoutNode layoutNode2 : layoutNode.getZSortedChildren().asMutableList()) {
            if (layoutNode2.getMeasurePolicy().toString().contains("CoreTextField")) {
                if (cu.f176a == null) {
                    cu.f176a = new cu();
                }
                cu.f176a.b.add(Integer.valueOf(layoutNode2.hashCode()));
                return;
            }
            a(layoutNode2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x027d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(com.quantummetric.ui.internal.t r17, com.quantummetric.ui.internal.bh r18, androidx.compose.ui.Modifier r19) throws java.lang.IllegalAccessException {
        /*
            Method dump skipped, instructions count: 1632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.bi.a(com.quantummetric.instrument.internal.t, com.quantummetric.instrument.internal.bh, androidx.compose.ui.Modifier):void");
    }

    static void a(t tVar, co coVar, Modifier modifier) {
        Iterator it = ((SemanticsModifier) modifier).getSemanticsConfiguration().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String semanticsPropertyKey = ((SemanticsPropertyKey) entry.getKey()).toString();
            if (semanticsPropertyKey.contains("ContentDescription")) {
                coVar.y = entry.getValue().toString().replace("[", "").replace("]", "");
            } else if (semanticsPropertyKey.contains("Role")) {
                coVar.z = entry.getValue().toString().replace("[", "").replace("]", "");
            } else if (semanticsPropertyKey.contains("Password")) {
                a(coVar.x.get());
            } else if (semanticsPropertyKey.contains("GetTextLayoutResult")) {
                if (tVar instanceof u) {
                    ((u) tVar).G = b(entry.getValue());
                }
            } else if (semanticsPropertyKey.contains("OnClick")) {
                coVar.B = true;
            } else if (((SemanticsPropertyKey) entry.getKey()).toString().contains("ScrollAxisRange") && (coVar instanceof cn) && s.a().b) {
                cn cnVar = (cn) coVar;
                if (!cnVar.v) {
                    cnVar.v = true;
                    Object b = by.b(entry.getValue(), "value", "$state");
                    if (b != null && !(b instanceof ScrollableState)) {
                        b = by.b(b, "$state");
                    }
                    cnVar.t = !semanticsPropertyKey.contains("Horizontal");
                    a(b, cnVar);
                }
            } else if (semanticsPropertyKey.contains(com.quantummetric.ui.Modifier.KEY_QM_MASK)) {
                coVar.b = true;
            } else if (semanticsPropertyKey.contains(com.quantummetric.ui.Modifier.KEY_QM_ENCRYPT)) {
                coVar.d = true;
            } else if (semanticsPropertyKey.contains(com.quantummetric.ui.Modifier.KEY_QM_WHITELIST)) {
                coVar.e = true;
            }
        }
    }

    private static void a(Object obj, cn cnVar) {
        try {
            s.a aVar = new s.a(cnVar, cnVar.x.get().hashCode());
            if (obj instanceof LazyListState) {
                LazyListState lazyListState = (LazyListState) obj;
                try {
                    a(lazyListState, lazyListState.getClass().getDeclaredField("layoutInfoState")).a(aVar);
                } catch (Throwable unused) {
                }
                Object b = by.b(lazyListState, "scrollableState");
                if (b != null) {
                    try {
                        a(b, b.getClass().getDeclaredField("isScrollingState")).a(new s.b(cnVar));
                        return;
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                return;
            }
            if (obj instanceof ScrollState) {
                cnVar.b(by.b(obj, "value$delegate"));
                try {
                    a(obj, obj.getClass().getDeclaredField("value$delegate")).a(aVar);
                } catch (Throwable unused3) {
                }
            } else if (obj instanceof PagerState) {
                cnVar.w = true;
                Object b2 = by.b((PagerState) obj, PagerState.class, "scrollPosition");
                if (b2 instanceof PagerScrollPosition) {
                    PagerScrollPosition pagerScrollPosition = (PagerScrollPosition) b2;
                    a(pagerScrollPosition, pagerScrollPosition.getClass().getDeclaredField("scrollOffset$delegate")).a(aVar);
                }
            }
        } catch (Throwable unused4) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0048 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:3:0x0001, B:8:0x0048, B:10:0x0054, B:14:0x0066, B:16:0x0074, B:12:0x006e, B:28:0x000f, B:30:0x001b, B:32:0x0025, B:34:0x0029, B:36:0x002d, B:38:0x0031, B:44:0x003a, B:42:0x0042, B:26:0x0007), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.compose.foundation.text.TextDelegate b(java.lang.Object r9) {
        /*
            r0 = 0
            boolean r1 = r9 instanceof androidx.compose.ui.semantics.AccessibilityAction     // Catch: java.lang.Throwable -> L86
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L45
            r1 = r9
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1     // Catch: java.lang.Throwable -> Lf
            kotlin.Function r9 = r1.getAction()     // Catch: java.lang.Throwable -> Lf
            goto L46
        Lf:
            java.lang.Class r1 = r9.getClass()     // Catch: java.lang.Throwable -> L86
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch: java.lang.Throwable -> L86
            int r4 = r1.length     // Catch: java.lang.Throwable -> L86
            r5 = r2
        L19:
            if (r5 >= r4) goto L45
            r6 = r1[r5]     // Catch: java.lang.Throwable -> L86
            java.lang.Class r7 = r6.getType()     // Catch: java.lang.Throwable -> L86
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            if (r7 == r8) goto L37
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L86
            if (r7 == r8) goto L37
            java.lang.Class r8 = java.lang.Float.TYPE     // Catch: java.lang.Throwable -> L86
            if (r7 == r8) goto L37
            java.lang.Class r8 = java.lang.Double.TYPE     // Catch: java.lang.Throwable -> L86
            if (r7 == r8) goto L37
            java.lang.Class r8 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> L86
            if (r7 == r8) goto L37
            r7 = r3
            goto L38
        L37:
            r7 = r2
        L38:
            if (r7 == 0) goto L42
            r6.setAccessible(r3)     // Catch: java.lang.Throwable -> L86
            java.lang.Object r9 = r6.get(r9)     // Catch: java.lang.Throwable -> L86
            goto L46
        L42:
            int r5 = r5 + 1
            goto L19
        L45:
            r9 = r0
        L46:
            if (r9 == 0) goto L86
            java.lang.Class r1 = r9.getClass()     // Catch: java.lang.Throwable -> L86
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch: java.lang.Throwable -> L86
            int r4 = r1.length     // Catch: java.lang.Throwable -> L86
            r5 = r2
        L52:
            if (r5 >= r4) goto L71
            r6 = r1[r5]     // Catch: java.lang.Throwable -> L86
            java.lang.Class r7 = r6.getType()     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L86
            java.lang.String r8 = "TextController"
            boolean r7 = r7.contains(r8)     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L6e
            r6.setAccessible(r3)     // Catch: java.lang.Throwable -> L86
            java.lang.Object r9 = r6.get(r9)     // Catch: java.lang.Throwable -> L86
            goto L72
        L6e:
            int r5 = r5 + 1
            goto L52
        L71:
            r9 = r0
        L72:
            if (r9 == 0) goto L86
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "state"
            r1[r2] = r4     // Catch: java.lang.Throwable -> L86
            java.lang.String r2 = "textDelegate"
            r1[r3] = r2     // Catch: java.lang.Throwable -> L86
            java.lang.Object r9 = com.quantummetric.ui.internal.by.b(r9, r1)     // Catch: java.lang.Throwable -> L86
            androidx.compose.foundation.text.TextDelegate r9 = (androidx.compose.foundation.text.TextDelegate) r9     // Catch: java.lang.Throwable -> L86
            r0 = r9
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.bi.b(java.lang.Object):androidx.compose.foundation.text.TextDelegate");
    }
}
