package org.socure.core;

import java.util.List;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes6.dex */
public class Core {
    public static void a(Mat mat, List<Mat> list) {
        Mat mat2 = new Mat();
        split_0(mat.f803a, mat2.f803a);
        int d = mat2.d();
        if (a.f805a != mat2.g() || mat2.a() != 1) {
            throw new IllegalArgumentException("CvType.CV_32SC2 != m.type() ||  m.cols()!=1\n" + mat2);
        }
        list.clear();
        mat2.a(0, 0, new int[d * 2]);
        for (int i = 0; i < d; i++) {
            int i2 = i * 2;
            list.add(new Mat((r1[i2] << 32) | (r1[i2 + 1] & BodyPartID.bodyIdMax)));
        }
        mat2.c();
    }

    public static void a(Mat mat, b bVar, b bVar2) {
        meanStdDev_1(mat.f803a, bVar.f803a, bVar2.f803a);
    }

    private static native void meanStdDev_1(long j, long j2, long j3);

    private static native void split_0(long j, long j2);
}
