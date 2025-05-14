package external.sdk.pendo.io.mozilla.javascript;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLLib;
import java.io.Serializable;
import kotlin.UByte;
import okio.Utf8;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;

/* loaded from: classes2.dex */
public class NativeGlobal implements Serializable, IdFunctionCall {
    private static final Object FTAG = PendoGlobalCommandHandler.PENDO_GLOBAL_COMMAND_DEST;
    private static final int INVALID_UTF8 = Integer.MAX_VALUE;
    private static final int Id_decodeURI = 1;
    private static final int Id_decodeURIComponent = 2;
    private static final int Id_encodeURI = 3;
    private static final int Id_encodeURIComponent = 4;
    private static final int Id_escape = 5;
    private static final int Id_eval = 6;
    private static final int Id_isFinite = 7;
    private static final int Id_isNaN = 8;
    private static final int Id_isXMLName = 9;
    private static final int Id_new_CommonError = 14;
    private static final int Id_parseFloat = 10;
    private static final int Id_parseInt = 11;
    private static final int Id_unescape = 12;
    private static final int Id_uneval = 13;
    private static final int LAST_SCOPE_FUNCTION_ID = 13;
    private static final String URI_DECODE_RESERVED = ";/?:@&=+$,#";
    static final long serialVersionUID = 6080442165748707530L;

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable) {
        return ScriptRuntime.constructError(str, str2);
    }

    private static String decode(String str, boolean z) {
        int i;
        int i2;
        char c;
        int length = str.length();
        char[] cArr = null;
        int i3 = 0;
        int i4 = 0;
        while (i3 != length) {
            char charAt = str.charAt(i3);
            if (charAt != '%') {
                if (cArr != null) {
                    cArr[i4] = charAt;
                    i4++;
                }
                i3++;
            } else {
                if (cArr == null) {
                    cArr = new char[length];
                    str.getChars(0, i3, cArr, 0);
                    i4 = i3;
                }
                int i5 = i3 + 3;
                if (i5 > length) {
                    throw uriError();
                }
                int unHex = unHex(str.charAt(i3 + 1), str.charAt(i3 + 2));
                if (unHex < 0) {
                    throw uriError();
                }
                if ((unHex & 128) != 0) {
                    if ((unHex & 192) == 128) {
                        throw uriError();
                    }
                    if ((unHex & 32) == 0) {
                        unHex &= 31;
                        i = 1;
                        i2 = 128;
                    } else if ((unHex & 16) == 0) {
                        unHex &= 15;
                        i = 2;
                        i2 = 2048;
                    } else if ((unHex & 8) == 0) {
                        unHex &= 7;
                        i = 3;
                        i2 = 65536;
                    } else if ((unHex & 4) == 0) {
                        unHex &= 3;
                        i = 4;
                        i2 = 2097152;
                    } else {
                        if ((unHex & 2) != 0) {
                            throw uriError();
                        }
                        unHex &= 1;
                        i = 5;
                        i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    }
                    if ((i * 3) + i5 > length) {
                        throw uriError();
                    }
                    for (int i6 = 0; i6 != i; i6++) {
                        if (str.charAt(i5) != '%') {
                            throw uriError();
                        }
                        int unHex2 = unHex(str.charAt(i5 + 1), str.charAt(i5 + 2));
                        if (unHex2 < 0 || (unHex2 & 192) != 128) {
                            throw uriError();
                        }
                        unHex = (unHex << 6) | (unHex2 & 63);
                        i5 += 3;
                    }
                    if (unHex < i2 || (unHex >= 55296 && unHex <= 57343)) {
                        unHex = Integer.MAX_VALUE;
                    } else if (unHex == 65534 || unHex == 65535) {
                        unHex = Utf8.REPLACEMENT_CODE_POINT;
                    }
                    if (unHex >= 65536) {
                        int i7 = unHex - 65536;
                        if (i7 > 1048575) {
                            throw uriError();
                        }
                        char c2 = (char) ((i7 >>> 10) + 55296);
                        char c3 = (char) ((i7 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                        cArr[i4] = c2;
                        c = c3;
                        i4++;
                        if (z || URI_DECODE_RESERVED.indexOf(c) < 0) {
                            cArr[i4] = c;
                            i4++;
                        } else {
                            while (i3 != i5) {
                                cArr[i4] = str.charAt(i3);
                                i3++;
                                i4++;
                            }
                        }
                        i3 = i5;
                    }
                }
                c = (char) unHex;
                if (z) {
                }
                cArr[i4] = c;
                i4++;
                i3 = i5;
            }
        }
        return cArr == null ? str : new String(cArr, 0, i4);
    }

    private static String encode(String str, boolean z) {
        int length = str.length();
        StringBuilder sb = null;
        byte[] bArr = null;
        int i = 0;
        while (i != length) {
            char charAt = str.charAt(i);
            sb = sb;
            if (!encodeUnescaped(charAt, z)) {
                if (sb == null) {
                    StringBuilder sb2 = new StringBuilder(length + 3);
                    sb2.append(str);
                    sb2.setLength(i);
                    bArr = new byte[6];
                    sb = sb2;
                }
                if (56320 <= charAt && charAt <= 57343) {
                    throw uriError();
                }
                int i2 = charAt;
                if (charAt >= 55296) {
                    i2 = charAt;
                    if (56319 >= charAt) {
                        i++;
                        if (i == length) {
                            throw uriError();
                        }
                        int charAt2 = str.charAt(i);
                        if (56320 > charAt2 || charAt2 > 57343) {
                            throw uriError();
                        }
                        i2 = ((charAt - 55296) << 10) + (charAt2 - Utf8.LOG_SURROGATE_HEADER) + 65536;
                    }
                }
                int oneUcs4ToUtf8Char = oneUcs4ToUtf8Char(bArr, i2);
                for (int i3 = 0; i3 < oneUcs4ToUtf8Char; i3++) {
                    int i4 = bArr[i3] & UByte.MAX_VALUE;
                    sb.append('%');
                    sb.append(toHexChar(i4 >>> 4));
                    sb.append(toHexChar(i4 & 15));
                }
            } else if (sb != null) {
                sb.append(charAt);
            }
            i++;
            sb = sb;
        }
        return sb == null ? str : sb.toString();
    }

    private static boolean encodeUnescaped(char c, boolean z) {
        if (('A' > c || c > 'Z') && (('a' > c || c > 'z') && (('0' > c || c > '9') && "-_.!~*'()".indexOf(c) < 0))) {
            return z && URI_DECODE_RESERVED.indexOf(c) >= 0;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void init(external.sdk.pendo.io.mozilla.javascript.Context r16, external.sdk.pendo.io.mozilla.javascript.Scriptable r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeGlobal.init(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, boolean):void");
    }

    static boolean isEvalFunction(Object obj) {
        if (!(obj instanceof IdFunctionObject)) {
            return false;
        }
        IdFunctionObject idFunctionObject = (IdFunctionObject) obj;
        return idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if ((r11 & (-8)) == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object js_escape(java.lang.Object[] r11) {
        /*
            r0 = 0
            java.lang.String r1 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r11, r0)
            int r2 = r11.length
            r3 = 1
            if (r2 <= r3) goto L27
            r11 = r11[r3]
            double r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toNumber(r11)
            boolean r11 = java.lang.Double.isNaN(r4)
            if (r11 != 0) goto L20
            int r11 = (int) r4
            double r6 = (double) r11
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 != 0) goto L20
            r2 = r11 & (-8)
            if (r2 != 0) goto L20
            goto L28
        L20:
            java.lang.String r11 = "msg.bad.esc.mask"
            external.sdk.pendo.io.mozilla.javascript.EvaluatorException r11 = external.sdk.pendo.io.mozilla.javascript.Context.reportRuntimeError0(r11)
            throw r11
        L27:
            r11 = 7
        L28:
            int r2 = r1.length()
            r4 = 0
        L2d:
            if (r0 == r2) goto Lbe
            char r5 = r1.charAt(r0)
            r6 = 43
            if (r11 == 0) goto L74
            r7 = 48
            if (r5 < r7) goto L3f
            r7 = 57
            if (r5 <= r7) goto L6d
        L3f:
            r7 = 65
            if (r5 < r7) goto L47
            r7 = 90
            if (r5 <= r7) goto L6d
        L47:
            r7 = 97
            if (r5 < r7) goto L4f
            r7 = 122(0x7a, float:1.71E-43)
            if (r5 <= r7) goto L6d
        L4f:
            r7 = 64
            if (r5 == r7) goto L6d
            r7 = 42
            if (r5 == r7) goto L6d
            r7 = 95
            if (r5 == r7) goto L6d
            r7 = 45
            if (r5 == r7) goto L6d
            r7 = 46
            if (r5 == r7) goto L6d
            r7 = r11 & 4
            if (r7 == 0) goto L74
            r7 = 47
            if (r5 == r7) goto L6d
            if (r5 != r6) goto L74
        L6d:
            if (r4 == 0) goto Lba
            char r5 = (char) r5
            r4.append(r5)
            goto Lba
        L74:
            if (r4 != 0) goto L83
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r7 = r2 + 3
            r4.<init>(r7)
            r4.append(r1)
            r4.setLength(r0)
        L83:
            r7 = 256(0x100, float:3.59E-43)
            r8 = 37
            r9 = 4
            if (r5 >= r7) goto L99
            r7 = 32
            r10 = 2
            if (r5 != r7) goto L95
            if (r11 != r10) goto L95
            r4.append(r6)
            goto Lba
        L95:
            r4.append(r8)
            goto La2
        L99:
            r4.append(r8)
            r6 = 117(0x75, float:1.64E-43)
            r4.append(r6)
            r10 = r9
        La2:
            int r10 = r10 - r3
            int r10 = r10 * r9
        La4:
            if (r10 < 0) goto Lba
            int r6 = r5 >> r10
            r6 = r6 & 15
            r7 = 10
            if (r6 >= r7) goto Lb1
            int r6 = r6 + 48
            goto Lb3
        Lb1:
            int r6 = r6 + 55
        Lb3:
            char r6 = (char) r6
            r4.append(r6)
            int r10 = r10 + (-4)
            goto La4
        Lba:
            int r0 = r0 + 1
            goto L2d
        Lbe:
            if (r4 != 0) goto Lc1
            goto Lc5
        Lc1:
            java.lang.String r1 = r4.toString()
        Lc5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeGlobal.js_escape(java.lang.Object[]):java.lang.Object");
    }

    private static Object js_eval(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        return ScriptRuntime.evalSpecial(context, topLevelScope, topLevelScope, objArr, "eval code", 1);
    }

    static Object js_parseFloat(Object[] objArr) {
        int i;
        if (objArr.length < 1) {
            return ScriptRuntime.NaNobj;
        }
        boolean z = false;
        String scriptRuntime = ScriptRuntime.toString(objArr[0]);
        int length = scriptRuntime.length();
        for (int i2 = 0; i2 != length; i2++) {
            char charAt = scriptRuntime.charAt(i2);
            if (!ScriptRuntime.isStrWhiteSpaceChar(charAt)) {
                if (charAt == '+' || charAt == '-') {
                    int i3 = i2 + 1;
                    if (i3 == length) {
                        return ScriptRuntime.NaNobj;
                    }
                    i = i3;
                    charAt = scriptRuntime.charAt(i3);
                } else {
                    i = i2;
                }
                if (charAt == 'I') {
                    if (i + 8 > length || !scriptRuntime.regionMatches(i, "Infinity", 0, 8)) {
                        return ScriptRuntime.NaNobj;
                    }
                    return ScriptRuntime.wrapNumber(scriptRuntime.charAt(i2) == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                int i4 = -1;
                int i5 = -1;
                while (true) {
                    if (i < length) {
                        char charAt2 = scriptRuntime.charAt(i);
                        if (charAt2 != '+') {
                            if (charAt2 == 'E' || charAt2 == 'e') {
                                if (i4 == -1 && i != length - 1) {
                                    i4 = i;
                                    i++;
                                }
                            } else if (charAt2 != '-') {
                                if (charAt2 != '.') {
                                    switch (charAt2) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            if (i4 != -1) {
                                                z = true;
                                                break;
                                            } else {
                                                break;
                                            }
                                    }
                                    i++;
                                } else if (i5 == -1) {
                                    i5 = i;
                                    i++;
                                }
                            }
                        }
                        if (i4 == i - 1) {
                            if (i == length - 1) {
                                i--;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                if (i4 == -1 || z) {
                    i4 = i;
                }
                try {
                    return Double.valueOf(scriptRuntime.substring(i2, i4));
                } catch (NumberFormatException unused) {
                    return ScriptRuntime.NaNobj;
                }
            }
        }
        return ScriptRuntime.NaNobj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Object js_parseInt(java.lang.Object[] r11) {
        /*
            r0 = 0
            java.lang.String r1 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r11, r0)
            r2 = 1
            int r11 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toInt32(r11, r2)
            int r3 = r1.length()
            if (r3 != 0) goto L13
            java.lang.Double r11 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.NaNobj
            return r11
        L13:
            r4 = r0
        L14:
            char r5 = r1.charAt(r4)
            boolean r6 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.isStrWhiteSpaceChar(r5)
            if (r6 != 0) goto L1f
            goto L23
        L1f:
            int r4 = r4 + 1
            if (r4 < r3) goto L14
        L23:
            r6 = 43
            if (r5 == r6) goto L2e
            r6 = 45
            if (r5 != r6) goto L2c
            r0 = r2
        L2c:
            if (r0 == 0) goto L30
        L2e:
            int r4 = r4 + 1
        L30:
            r5 = 88
            r6 = 120(0x78, float:1.68E-43)
            r7 = 16
            r8 = -1
            r9 = 48
            if (r11 != 0) goto L3d
            r11 = r8
            goto L5d
        L3d:
            r10 = 2
            if (r11 < r10) goto L9e
            r10 = 36
            if (r11 <= r10) goto L45
            goto L9e
        L45:
            if (r11 != r7) goto L5d
            int r10 = r3 - r4
            if (r10 <= r2) goto L5d
            char r10 = r1.charAt(r4)
            if (r10 != r9) goto L5d
            int r10 = r4 + 1
            char r10 = r1.charAt(r10)
            if (r10 == r6) goto L5b
            if (r10 != r5) goto L5d
        L5b:
            int r4 = r4 + 2
        L5d:
            if (r11 != r8) goto L91
            int r3 = r3 - r4
            if (r3 <= r2) goto L8e
            char r11 = r1.charAt(r4)
            if (r11 != r9) goto L8e
            int r11 = r4 + 1
            char r2 = r1.charAt(r11)
            if (r2 == r6) goto L8b
            if (r2 != r5) goto L73
            goto L8b
        L73:
            if (r9 > r2) goto L8e
            r3 = 57
            if (r2 > r3) goto L8e
            external.sdk.pendo.io.mozilla.javascript.Context r2 = external.sdk.pendo.io.mozilla.javascript.Context.getCurrentContext()
            if (r2 == 0) goto L87
            int r2 = r2.getLanguageVersion()
            r3 = 150(0x96, float:2.1E-43)
            if (r2 >= r3) goto L8e
        L87:
            r7 = 8
            r4 = r11
            goto L92
        L8b:
            int r4 = r4 + 2
            goto L92
        L8e:
            r7 = 10
            goto L92
        L91:
            r7 = r11
        L92:
            double r1 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.stringPrefixToNumber(r1, r4, r7)
            if (r0 == 0) goto L99
            double r1 = -r1
        L99:
            java.lang.Number r11 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.wrapNumber(r1)
            return r11
        L9e:
            java.lang.Double r11 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.NaNobj
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeGlobal.js_parseInt(java.lang.Object[]):java.lang.Object");
    }

    private static Object js_unescape(Object[] objArr) {
        int i;
        int i2;
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        int indexOf = scriptRuntime.indexOf(37);
        if (indexOf < 0) {
            return scriptRuntime;
        }
        int length = scriptRuntime.length();
        char[] charArray = scriptRuntime.toCharArray();
        int i3 = indexOf;
        while (indexOf != length) {
            char c = charArray[indexOf];
            indexOf++;
            if (c == '%' && indexOf != length) {
                if (charArray[indexOf] == 'u') {
                    i2 = indexOf + 1;
                    i = indexOf + 5;
                } else {
                    i = indexOf + 2;
                    i2 = indexOf;
                }
                if (i <= length) {
                    int i4 = 0;
                    while (i2 != i) {
                        i4 = Kit.xDigitToInt(charArray[i2], i4);
                        i2++;
                    }
                    if (i4 >= 0) {
                        c = (char) i4;
                        indexOf = i;
                    }
                }
            }
            charArray[i3] = c;
            i3++;
        }
        return new String(charArray, 0, i3);
    }

    private static int oneUcs4ToUtf8Char(byte[] bArr, int i) {
        if ((i & (-128)) == 0) {
            bArr[0] = (byte) i;
            return 1;
        }
        int i2 = i >>> 11;
        int i3 = 2;
        while (i2 != 0) {
            i2 >>>= 5;
            i3++;
        }
        int i4 = i3;
        while (true) {
            i4--;
            if (i4 <= 0) {
                bArr[0] = (byte) ((256 - (1 << (8 - i3))) + i);
                return i3;
            }
            bArr[i4] = (byte) ((i & 63) | 128);
            i >>>= 6;
        }
    }

    private static char toHexChar(int i) {
        if ((i >> 4) != 0) {
            Kit.codeBug();
        }
        return (char) (i < 10 ? i + 48 : (i - 10) + 65);
    }

    private static int unHex(char c) {
        char c2 = 'A';
        if ('A' > c || c > 'F') {
            c2 = 'a';
            if ('a' > c || c > 'f') {
                if ('0' > c || c > '9') {
                    return -1;
                }
                return c - '0';
            }
        }
        return (c - c2) + 10;
    }

    private static EcmaError uriError() {
        return ScriptRuntime.constructError("URIError", ScriptRuntime.getMessage0("msg.bad.uri"));
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG)) {
            int methodId = idFunctionObject.methodId();
            switch (methodId) {
                case 1:
                case 2:
                    return decode(ScriptRuntime.toString(objArr, 0), methodId == 1);
                case 3:
                case 4:
                    return encode(ScriptRuntime.toString(objArr, 0), methodId == 3);
                case 5:
                    return js_escape(objArr);
                case 6:
                    return js_eval(context, scriptable, objArr);
                case 7:
                    return objArr.length < 1 ? Boolean.FALSE : NativeNumber.isFinite(objArr[0]);
                case 8:
                    return ScriptRuntime.wrapBoolean(objArr.length >= 1 ? Double.isNaN(ScriptRuntime.toNumber(objArr[0])) : true);
                case 9:
                    return ScriptRuntime.wrapBoolean(XMLLib.extractFromScope(scriptable).isXMLName(context, objArr.length == 0 ? Undefined.instance : objArr[0]));
                case 10:
                    return js_parseFloat(objArr);
                case 11:
                    return js_parseInt(objArr);
                case 12:
                    return js_unescape(objArr);
                case 13:
                    return ScriptRuntime.uneval(context, scriptable, objArr.length != 0 ? objArr[0] : Undefined.instance);
                case 14:
                    return NativeError.make(context, scriptable, idFunctionObject, objArr);
            }
        }
        throw idFunctionObject.unknown();
    }

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable, String str3, int i, int i2, String str4) {
        return ScriptRuntime.constructError(str, str2, str3, i, str4, i2);
    }

    private static int unHex(char c, char c2) {
        int unHex = unHex(c);
        int unHex2 = unHex(c2);
        if (unHex < 0 || unHex2 < 0) {
            return -1;
        }
        return (unHex << 4) | unHex2;
    }
}
