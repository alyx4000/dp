package external.sdk.pendo.io.mozilla.javascript;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes2.dex */
final class NativeMath extends IdScriptableObject {
    private static final int Id_E = 37;
    private static final int Id_LN10 = 39;
    private static final int Id_LN2 = 40;
    private static final int Id_LOG10E = 42;
    private static final int Id_LOG2E = 41;
    private static final int Id_PI = 38;
    private static final int Id_SQRT1_2 = 43;
    private static final int Id_SQRT2 = 44;
    private static final int Id_abs = 2;
    private static final int Id_acos = 3;
    private static final int Id_acosh = 30;
    private static final int Id_asin = 4;
    private static final int Id_asinh = 31;
    private static final int Id_atan = 5;
    private static final int Id_atan2 = 6;
    private static final int Id_atanh = 32;
    private static final int Id_cbrt = 20;
    private static final int Id_ceil = 7;
    private static final int Id_clz32 = 36;
    private static final int Id_cos = 8;
    private static final int Id_cosh = 21;
    private static final int Id_exp = 9;
    private static final int Id_expm1 = 22;
    private static final int Id_floor = 10;
    private static final int Id_fround = 35;
    private static final int Id_hypot = 23;
    private static final int Id_imul = 28;
    private static final int Id_log = 11;
    private static final int Id_log10 = 25;
    private static final int Id_log1p = 24;
    private static final int Id_log2 = 34;
    private static final int Id_max = 12;
    private static final int Id_min = 13;
    private static final int Id_pow = 14;
    private static final int Id_random = 15;
    private static final int Id_round = 16;
    private static final int Id_sign = 33;
    private static final int Id_sin = 17;
    private static final int Id_sinh = 26;
    private static final int Id_sqrt = 18;
    private static final int Id_tan = 19;
    private static final int Id_tanh = 27;
    private static final int Id_toSource = 1;
    private static final int Id_trunc = 29;
    private static final int LAST_METHOD_ID = 36;
    private static final double LOG2E = 1.4426950408889634d;
    private static final int MAX_ID = 44;
    private static final long serialVersionUID = -8838847185801131569L;
    private static final Object MATH_TAG = "Math";
    private static final Double Double32 = Double.valueOf(32.0d);

    private NativeMath() {
    }

    static void init(Scriptable scriptable, boolean z) {
        NativeMath nativeMath = new NativeMath();
        nativeMath.activatePrototypeMap(44);
        nativeMath.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeMath.setParentScope(scriptable);
        if (z) {
            nativeMath.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "Math", nativeMath, 2);
    }

    private static double js_hypot(Object[] objArr) {
        double d = 0.0d;
        if (objArr == null) {
            return 0.0d;
        }
        boolean z = false;
        boolean z2 = false;
        for (Object obj : objArr) {
            double number = ScriptRuntime.toNumber(obj);
            if (Double.isNaN(number)) {
                z2 = true;
            } else if (Double.isInfinite(number)) {
                z = true;
            } else {
                d += number * number;
            }
        }
        if (z) {
            return Double.POSITIVE_INFINITY;
        }
        if (z2) {
            return Double.NaN;
        }
        return Math.sqrt(d);
    }

    private static int js_imul(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return ScriptRuntime.toInt32(objArr, 0) * ScriptRuntime.toInt32(objArr, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r22 > 0.0d) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r22 > 0.0d) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
    
        if (r20 < 1.0d) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0076, code lost:
    
        if (r20 < 1.0d) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007d, code lost:
    
        if (r22 > 0.0d) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0095, code lost:
    
        if (r22 > 0.0d) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double js_pow(double r20, double r22) {
        /*
            r0 = r22
            boolean r2 = java.lang.Double.isNaN(r22)
            if (r2 == 0) goto Lb
            r14 = r0
            goto L9e
        Lb:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r4 != 0) goto L16
            r14 = r5
            goto L9e
        L16:
            int r7 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            r8 = -9223372036854775808
            r10 = 0
            r12 = 1
            r14 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            r16 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            if (r7 != 0) goto L41
            double r5 = r5 / r20
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L2e
            if (r4 <= 0) goto L97
            goto L9a
        L2e:
            long r5 = (long) r0
            double r2 = (double) r5
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto L3d
            long r0 = r5 & r12
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 == 0) goto L3d
            if (r4 <= 0) goto L9e
            goto L93
        L3d:
            if (r4 <= 0) goto L97
            goto L9a
        L41:
            double r2 = java.lang.Math.pow(r20, r22)
            boolean r7 = java.lang.Double.isNaN(r2)
            if (r7 == 0) goto L9d
            int r7 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            r18 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r7 != 0) goto L63
            int r0 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r0 < 0) goto L97
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 >= 0) goto L5a
            goto L78
        L5a:
            int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r0 >= 0) goto L9d
            int r0 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r0 >= 0) goto L9d
            goto L9a
        L63:
            int r7 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r7 != 0) goto L79
            int r0 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r0 < 0) goto L9a
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 >= 0) goto L70
            goto L9a
        L70:
            int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r0 >= 0) goto L9d
            int r0 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r0 >= 0) goto L9d
        L78:
            goto L97
        L79:
            int r5 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r5 != 0) goto L80
            if (r4 <= 0) goto L9a
            goto L97
        L80:
            int r5 = (r20 > r14 ? 1 : (r20 == r14 ? 0 : -1))
            if (r5 != 0) goto L9d
            long r2 = (long) r0
            double r5 = (double) r2
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 != 0) goto L95
            long r0 = r2 & r12
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 == 0) goto L95
            if (r4 <= 0) goto L93
            goto L9e
        L93:
            r14 = r8
            goto L9e
        L95:
            if (r4 <= 0) goto L9a
        L97:
            r14 = r16
            goto L9e
        L9a:
            r14 = 0
            goto L9e
        L9d:
            r14 = r2
        L9e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeMath.js_pow(double, double):double");
    }

    private static double js_trunc(double d) {
        return d < 0.0d ? Math.ceil(d) : Math.floor(d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x01db, code lost:
    
        if (r0 != 0.0d) goto L167;
     */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execIdCall(external.sdk.pendo.io.mozilla.javascript.IdFunctionObject r18, external.sdk.pendo.io.mozilla.javascript.Context r19, external.sdk.pendo.io.mozilla.javascript.Scriptable r20, external.sdk.pendo.io.mozilla.javascript.Scriptable r21, java.lang.Object[] r22) {
        /*
            Method dump skipped, instructions count: 772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeMath.execIdCall(external.sdk.pendo.io.mozilla.javascript.IdFunctionObject, external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x029f A[ADDED_TO_REGION] */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int findPrototypeId(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeMath.findPrototypeId(java.lang.String):int");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Math";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        double d;
        String str;
        String str2;
        String str3;
        if (i > 36) {
            switch (i) {
                case 37:
                    d = 2.718281828459045d;
                    str = ExifInterface.LONGITUDE_EAST;
                    break;
                case 38:
                    d = 3.141592653589793d;
                    str = "PI";
                    break;
                case 39:
                    d = 2.302585092994046d;
                    str = "LN10";
                    break;
                case 40:
                    d = 0.6931471805599453d;
                    str = "LN2";
                    break;
                case 41:
                    d = LOG2E;
                    str = "LOG2E";
                    break;
                case 42:
                    d = 0.4342944819032518d;
                    str = "LOG10E";
                    break;
                case 43:
                    d = 0.7071067811865476d;
                    str = "SQRT1_2";
                    break;
                case 44:
                    d = 1.4142135623730951d;
                    str = "SQRT2";
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(i));
            }
            initPrototypeValue(i, str, ScriptRuntime.wrapNumber(d), 7);
            return;
        }
        int i2 = 1;
        switch (i) {
            case 1:
                str2 = "toSource";
                i2 = 0;
                str3 = str2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 2:
                str3 = "abs";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 3:
                str3 = "acos";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 4:
                str3 = "asin";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 5:
                str3 = "atan";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 6:
                str3 = "atan2";
                i2 = 2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 7:
                str3 = "ceil";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 8:
                str3 = "cos";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 9:
                str3 = "exp";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 10:
                str3 = "floor";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 11:
                str3 = "log";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 12:
                str3 = "max";
                i2 = 2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 13:
                str3 = "min";
                i2 = 2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 14:
                str3 = "pow";
                i2 = 2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 15:
                str2 = "random";
                i2 = 0;
                str3 = str2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 16:
                str3 = "round";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 17:
                str3 = "sin";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 18:
                str3 = "sqrt";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 19:
                str3 = "tan";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 20:
                str3 = "cbrt";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 21:
                str3 = "cosh";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 22:
                str3 = "expm1";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 23:
                str3 = "hypot";
                i2 = 2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 24:
                str3 = "log1p";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 25:
                str3 = "log10";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 26:
                str3 = "sinh";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 27:
                str3 = "tanh";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 28:
                str3 = "imul";
                i2 = 2;
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 29:
                str3 = "trunc";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 30:
                str3 = "acosh";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 31:
                str3 = "asinh";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 32:
                str3 = "atanh";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 33:
                str3 = "sign";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 34:
                str3 = "log2";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 35:
                str3 = "fround";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            case 36:
                str3 = "clz32";
                initPrototypeMethod(MATH_TAG, i, str3, i2);
                return;
            default:
                throw new IllegalStateException(String.valueOf(i));
        }
    }
}
