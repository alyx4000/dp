package com.socure.docv.capturesdk.core.extractor;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.extractor.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f374a;
    public final i b;

    public k(Bitmap bitmap, i reader) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.f374a = bitmap;
        this.b = reader;
    }

    public static final void a(k this$0, Text text) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            List<Text.TextBlock> textBlocks = text.getTextBlocks();
            Intrinsics.checkNotNullExpressionValue(textBlocks, "visionText.textBlocks");
            int i = 0;
            for (Object obj : textBlocks) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_R", "textBlock " + i + ": " + ((Text.TextBlock) obj).getText());
                i = i2;
            }
            List<Text.TextBlock> textBlocks2 = text.getTextBlocks();
            Intrinsics.checkNotNullExpressionValue(textBlocks2, "visionText.textBlocks");
            Pair<com.socure.docv.capturesdk.core.extractor.model.d, Boolean> a2 = this$0.a(ExtensionsKt.toStringList(textBlocks2));
            this$0.b.a(a2.getFirst(), a2.getSecond().booleanValue());
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_R", "Ex mrz reader: " + Log.getStackTraceString(th), null, 4, null);
            i.a.a(this$0.b, null, false, 2, null);
        }
    }

    public static final void a(k this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_R", "Error in recognising text: " + Log.getStackTraceString(it), null, 4, null);
        i.a.a(this$0.b, null, false, 2, null);
    }

    public final Pair<Boolean, Boolean> a(String str) {
        String upperCase = new Regex("\\s+").replace(str, "").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String fixAlphabets = UtilsKt.fixAlphabets(upperCase);
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_R", "Checking for possible first line on: " + fixAlphabets);
        boolean startsWithPkEndsWithFiller = UtilsKt.startsWithPkEndsWithFiller(fixAlphabets);
        boolean z = fixAlphabets.length() > 30 && (StringsKt.contains((CharSequence) fixAlphabets, (CharSequence) "P<", true) || startsWithPkEndsWithFiller);
        if (!z) {
            z = StringsKt.contains((CharSequence) b.a(str, -1, false), (CharSequence) "<<", true);
        }
        return new Pair<>(Boolean.valueOf(z), Boolean.valueOf(startsWithPkEndsWithFiller));
    }

    public final void a() {
        TextRecognizer client = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(TextRecognizerOptions.DEFAULT_OPTIONS)");
        Bitmap bitmap = this.f374a;
        OnSuccessListener<? super Text> successListener = new OnSuccessListener() { // from class: com.socure.docv.capturesdk.core.extractor.k$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                k.a(k.this, (Text) obj);
            }
        };
        OnFailureListener failureListener = new OnFailureListener() { // from class: com.socure.docv.capturesdk.core.extractor.k$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                k.a(k.this, exc);
            }
        };
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(successListener, "successListener");
        Intrinsics.checkNotNullParameter(failureListener, "failureListener");
        InputImage fromBitmap = InputImage.fromBitmap(bitmap, 0);
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(bitmap, 0)");
        client.process(fromBitmap).addOnSuccessListener(successListener).addOnFailureListener(failureListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.socure.docv.capturesdk.core.extractor.model.d] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final Pair<com.socure.docv.capturesdk.core.extractor.model.d, Boolean> a(List<String> list) {
        ?? r6;
        boolean z;
        Throwable th;
        j jVar = new j();
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            r6 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (StringsKt.contains$default((CharSequence) next, (CharSequence) "\n", false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        for (String str : arrayList) {
            int indexOf = list.indexOf(str);
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null);
            list.remove(str);
            list.addAll(indexOf, split$default);
        }
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            String str2 = list.get(i);
            try {
                Pair<Boolean, Boolean> a2 = a(str2);
                if (a2.getFirst().booleanValue()) {
                    com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_R", "Block index: " + i + " | Block text: " + str2);
                    Pair<String, String> a3 = jVar.a(i, list, a2.getSecond().booleanValue());
                    z = true;
                    if (a3 != null) {
                        com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_R", "MRZ matched - line1: " + ((Object) a3.getFirst()) + " || line2: " + ((Object) a3.getSecond()));
                        try {
                            r6 = new com.socure.docv.capturesdk.core.parser.c().a(a3);
                        } catch (Throwable th2) {
                            th = th2;
                            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_R", "Ex validateTextBlocks: " + Log.getStackTraceString(th), r6, 4, r6);
                            z2 = z;
                            i++;
                            r6 = r6;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        int size2 = list.size();
                        for (int i2 = i + 1; i2 < size2; i2++) {
                            sb.append(b.a(list.get(i2), 2, false));
                        }
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                        if (StringsKt.contains((CharSequence) sb2, (CharSequence) "<<", true)) {
                            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_R", "First line was detected, however lines couldn't be parsed, but there is a possibility of second line");
                        } else {
                            continue;
                        }
                    }
                    z2 = true;
                    break;
                }
                continue;
            } catch (Throwable th3) {
                z = z2;
                th = th3;
            }
            i++;
            r6 = r6;
        }
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_R", "MRZ was " + (r6 == 0 ? "not" : "") + " parsed; Mrz was " + (z2 ? "" : "not") + " found");
        return new Pair<>(r6, Boolean.valueOf(z2));
    }
}
