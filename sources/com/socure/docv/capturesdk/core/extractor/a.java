package com.socure.docv.capturesdk.core.extractor;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.socure.docv.capturesdk.core.extractor.i;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final BarcodeScanner f363a;

    public a() {
        BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(2048, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .setBa…_PDF417)\n        .build()");
        BarcodeScanner client = BarcodeScanning.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(options)");
        this.f363a = client;
    }

    public static final void a(i reader, a this$0, List barcodes) {
        Intrinsics.checkNotNullParameter(reader, "$reader");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_BR_MLK", barcodes.size() + " barcodes detected in image");
        Intrinsics.checkNotNullExpressionValue(barcodes, "barcodes");
        reader.a(this$0.a((List<? extends Barcode>) barcodes), barcodes.size() > 0);
    }

    public static final void a(i reader, Exception it) {
        Intrinsics.checkNotNullParameter(reader, "$reader");
        Intrinsics.checkNotNullParameter(it, "it");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_BR_MLK", "Barcode reading failed", null, 4, null);
        i.a.a(reader, null, false, 2, null);
    }

    public final com.socure.docv.capturesdk.core.extractor.model.b a(Barcode barcode) {
        Barcode.DriverLicense driverLicense = barcode.getDriverLicense();
        if (driverLicense == null) {
            return null;
        }
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_BR_MLK", "DL being parsed is: " + driverLicense);
        com.socure.docv.capturesdk.core.extractor.model.b bVar = new com.socure.docv.capturesdk.core.extractor.model.b();
        bVar.c = driverLicense.getFirstName();
        bVar.j = driverLicense.getLastName();
        bVar.q = driverLicense.getBirthDate();
        bVar.k = driverLicense.getLicenseNumber();
        bVar.n = driverLicense.getFirstName() + " " + driverLicense.getMiddleName() + " " + driverLicense.getLastName();
        bVar.m = driverLicense.getExpiryDate();
        bVar.d = driverLicense.getGender();
        bVar.e = driverLicense.getAddressState();
        bVar.f = driverLicense.getAddressStreet();
        bVar.g = driverLicense.getAddressCity();
        bVar.h = driverLicense.getAddressZip();
        bVar.i = driverLicense.getAddressCity();
        bVar.l = driverLicense.getIssueDate();
        bVar.r = b.b(driverLicense.getBirthDate());
        bVar.s = driverLicense.getIssuingCountry();
        return bVar;
    }

    public final com.socure.docv.capturesdk.core.extractor.model.b a(List<? extends Barcode> list) {
        com.socure.docv.capturesdk.core.extractor.model.b bVar;
        com.socure.docv.capturesdk.core.parser.b bVar2 = new com.socure.docv.capturesdk.core.parser.b();
        com.socure.docv.capturesdk.core.extractor.model.b bVar3 = null;
        for (Barcode barcode : list) {
            com.socure.docv.capturesdk.common.logger.b.d("SDLT_BR_MLK", "Raw value of barcode: " + barcode.getRawValue());
            int valueType = barcode.getValueType();
            if (valueType == 12 || valueType == 2048) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_BR_MLK", "Barcode format found PDF417, or DRIVER_LICENSE : " + barcode.getValueType());
                bVar = a(barcode);
                if (bVar != null && b.a(bVar3, bVar)) {
                    bVar3 = bVar;
                }
            } else {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_BR_MLK", "Some other barcode type found " + barcode.getValueType());
                String textData = barcode.getRawValue();
                if (textData != null) {
                    Intrinsics.checkNotNullExpressionValue(textData, "textData");
                    bVar = bVar2.a(textData);
                    if (b.a(bVar3, bVar)) {
                        bVar3 = bVar;
                    }
                }
            }
        }
        return bVar3;
    }

    public final Pair<com.socure.docv.capturesdk.core.extractor.model.b, Boolean> a(Bitmap bitmap, long j) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_BR_MLK", "readBlocking called at: " + System.currentTimeMillis());
        InputImage fromBitmap = InputImage.fromBitmap(bitmap, 0);
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(bitmap, 0)");
        Task<List<Barcode>> process = this.f363a.process(fromBitmap);
        Intrinsics.checkNotNullExpressionValue(process, "scanner.process(inputImage)");
        try {
            List<? extends Barcode> barcodes = (List) Tasks.await(process, j, TimeUnit.MILLISECONDS);
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_BR_MLK", "readBlocking resumed at: " + System.currentTimeMillis());
            Intrinsics.checkNotNullExpressionValue(barcodes, "barcodes");
            return new Pair<>(a(barcodes), Boolean.valueOf(barcodes.size() > 0));
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_BR_MLK", "readBlocking failure called at: " + System.currentTimeMillis() + " : Message: " + th.getLocalizedMessage() + ", Exception: " + Log.getStackTraceString(th));
            return new Pair<>(null, Boolean.FALSE);
        }
    }

    public final void a(Bitmap bitmap, final i reader) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(reader, "reader");
        InputImage fromBitmap = InputImage.fromBitmap(bitmap, 0);
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(bitmap, 0)");
        this.f363a.process(fromBitmap).addOnSuccessListener(new OnSuccessListener() { // from class: com.socure.docv.capturesdk.core.extractor.a$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                a.a(i.this, this, (List) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.socure.docv.capturesdk.core.extractor.a$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                a.a(i.this, exc);
            }
        });
    }
}
