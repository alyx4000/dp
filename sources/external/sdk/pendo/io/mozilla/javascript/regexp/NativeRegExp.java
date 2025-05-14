package external.sdk.pendo.io.mozilla.javascript.regexp;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Symbol;
import external.sdk.pendo.io.mozilla.javascript.SymbolKey;
import external.sdk.pendo.io.mozilla.javascript.TopLevel;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import kotlin.UByte;
import org.apache.commons.io.IOUtils;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes2.dex */
public class NativeRegExp extends IdScriptableObject implements Function {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANCHOR_BOL = -2;
    private static final int INDEX_LEN = 2;
    private static final int Id_compile = 1;
    private static final int Id_exec = 4;
    private static final int Id_global = 3;
    private static final int Id_ignoreCase = 4;
    private static final int Id_lastIndex = 1;
    private static final int Id_multiline = 5;
    private static final int Id_prefix = 6;
    private static final int Id_source = 2;
    private static final int Id_test = 5;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_MULTILINE = 4;
    public static final int MATCH = 1;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 8;
    public static final int PREFIX = 2;
    private static final Object REGEXP_TAG = new Object();
    private static final byte REOP_ALNUM = 9;
    private static final byte REOP_ALT = 31;
    private static final byte REOP_ALTPREREQ = 53;
    private static final byte REOP_ALTPREREQ2 = 55;
    private static final byte REOP_ALTPREREQi = 54;
    private static final byte REOP_ASSERT = 41;
    private static final byte REOP_ASSERTNOTTEST = 44;
    private static final byte REOP_ASSERTTEST = 43;
    private static final byte REOP_ASSERT_NOT = 42;
    private static final byte REOP_BACKREF = 13;
    private static final byte REOP_BOL = 2;
    private static final byte REOP_CLASS = 22;
    private static final byte REOP_DIGIT = 7;
    private static final byte REOP_DOT = 6;
    private static final byte REOP_EMPTY = 1;
    private static final byte REOP_END = 57;
    private static final byte REOP_ENDCHILD = 49;
    private static final byte REOP_EOL = 3;
    private static final byte REOP_FLAT = 14;
    private static final byte REOP_FLAT1 = 15;
    private static final byte REOP_FLAT1i = 17;
    private static final byte REOP_FLATi = 16;
    private static final byte REOP_JUMP = 32;
    private static final byte REOP_LPAREN = 29;
    private static final byte REOP_MINIMALOPT = 47;
    private static final byte REOP_MINIMALPLUS = 46;
    private static final byte REOP_MINIMALQUANT = 48;
    private static final byte REOP_MINIMALREPEAT = 52;
    private static final byte REOP_MINIMALSTAR = 45;
    private static final byte REOP_NCLASS = 23;
    private static final byte REOP_NONALNUM = 10;
    private static final byte REOP_NONDIGIT = 8;
    private static final byte REOP_NONSPACE = 12;
    private static final byte REOP_OPT = 28;
    private static final byte REOP_PLUS = 27;
    private static final byte REOP_QUANT = 25;
    private static final byte REOP_REPEAT = 51;
    private static final byte REOP_RPAREN = 30;
    private static final byte REOP_SIMPLE_END = 23;
    private static final byte REOP_SIMPLE_START = 1;
    private static final byte REOP_SPACE = 11;
    private static final byte REOP_STAR = 26;
    private static final byte REOP_UCFLAT1 = 18;
    private static final byte REOP_UCFLAT1i = 19;
    private static final byte REOP_WBDRY = 4;
    private static final byte REOP_WNONBDRY = 5;
    private static final int SymbolId_match = 7;
    private static final int SymbolId_search = 8;
    public static final int TEST = 0;
    private static final boolean debug = false;
    private static final long serialVersionUID = 4965263491464903264L;
    Object lastIndex;
    private int lastIndexAttr;
    private RECompiled re;

    NativeRegExp() {
        this.lastIndex = ScriptRuntime.zeroObj;
        this.lastIndexAttr = 6;
    }

    private static void addCharacterRangeToCharSet(RECharSet rECharSet, char c, char c2) {
        int i = c / '\b';
        int i2 = c2 / '\b';
        if (c2 >= rECharSet.length || c > c2) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        char c3 = (char) (c & 7);
        char c4 = (char) (c2 & 7);
        if (i == i2) {
            byte[] bArr = rECharSet.bits;
            bArr[i] = (byte) (((255 >> (7 - (c4 - c3))) << c3) | bArr[i]);
            return;
        }
        byte[] bArr2 = rECharSet.bits;
        bArr2[i] = (byte) ((255 << c3) | bArr2[i]);
        while (true) {
            i++;
            if (i >= i2) {
                byte[] bArr3 = rECharSet.bits;
                bArr3[i2] = (byte) (bArr3[i2] | (255 >> (7 - c4)));
                return;
            }
            rECharSet.bits[i] = -1;
        }
    }

    private static void addCharacterToCharSet(RECharSet rECharSet, char c) {
        int i = c / '\b';
        if (c >= rECharSet.length) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        byte[] bArr = rECharSet.bits;
        bArr[i] = (byte) ((1 << (c & 7)) | bArr[i]);
    }

    private static int addIndex(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw Kit.codeBug();
        }
        if (i2 > 65535) {
            throw Context.reportRuntimeError("Too complex regexp");
        }
        bArr[i] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) i2;
        return i + 2;
    }

    private static boolean backrefMatcher(REGlobalData rEGlobalData, int i, String str, int i2) {
        long[] jArr = rEGlobalData.parens;
        if (jArr == null || i >= jArr.length) {
            return false;
        }
        int parensIndex = rEGlobalData.parensIndex(i);
        if (parensIndex == -1) {
            return true;
        }
        int parensLength = rEGlobalData.parensLength(i);
        int i3 = rEGlobalData.cp;
        if (i3 + parensLength > i2) {
            return false;
        }
        if ((rEGlobalData.regexp.flags & 2) != 0) {
            for (int i4 = 0; i4 < parensLength; i4++) {
                char charAt = str.charAt(parensIndex + i4);
                char charAt2 = str.charAt(rEGlobalData.cp + i4);
                if (charAt != charAt2 && upcase(charAt) != upcase(charAt2)) {
                    return false;
                }
            }
        } else if (!str.regionMatches(parensIndex, str, i3, parensLength)) {
            return false;
        }
        rEGlobalData.cp += parensLength;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1 A[LOOP:1: B:27:0x009d->B:31:0x00b1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v10, types: [int] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean calculateBitmapSize(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState r15, external.sdk.pendo.io.mozilla.javascript.regexp.RENode r16, char[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.calculateBitmapSize(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState, external.sdk.pendo.io.mozilla.javascript.regexp.RENode, char[], int, int):boolean");
    }

    private static boolean classMatcher(REGlobalData rEGlobalData, RECharSet rECharSet, char c) {
        if (!rECharSet.converted) {
            processCharSet(rEGlobalData, rECharSet);
        }
        int i = c >> 3;
        int i2 = rECharSet.length;
        boolean z = true;
        if (i2 != 0 && c < i2 && (rECharSet.bits[i] & (1 << (c & 7))) != 0) {
            z = false;
        }
        return rECharSet.sense ^ z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00da, code lost:
    
        if (r10.kid2.op == 2) goto L51;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00b6. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static external.sdk.pendo.io.mozilla.javascript.regexp.RECompiled compileRE(external.sdk.pendo.io.mozilla.javascript.Context r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.compileRE(external.sdk.pendo.io.mozilla.javascript.Context, java.lang.String, java.lang.String, boolean):external.sdk.pendo.io.mozilla.javascript.regexp.RECompiled");
    }

    private static void doFlat(CompilerState compilerState, char c) {
        RENode rENode = new RENode((byte) 14);
        compilerState.result = rENode;
        rENode.chr = c;
        rENode.length = 1;
        rENode.flatIndex = -1;
        compilerState.progLength += 3;
    }

    private static char downcase(char c) {
        if (c < 128) {
            return ('A' > c || c > 'Z') ? c : (char) (c + ' ');
        }
        char lowerCase = Character.toLowerCase(c);
        return lowerCase < 128 ? c : lowerCase;
    }

    private static int emitREBytecode(CompilerState compilerState, RECompiled rECompiled, int i, RENode rENode) {
        int i2;
        int i3;
        byte[] bArr = rECompiled.program;
        while (rENode != null) {
            int i4 = i + 1;
            byte b = rENode.op;
            bArr[i] = b;
            if (b != 1) {
                if (b != 22) {
                    if (b != 25) {
                        if (b != 29) {
                            if (b != 31) {
                                if (b != 13) {
                                    if (b != 14) {
                                        if (b == 41) {
                                            int emitREBytecode = emitREBytecode(compilerState, rECompiled, i4 + 2, rENode.kid);
                                            i2 = emitREBytecode + 1;
                                            bArr[emitREBytecode] = 43;
                                        } else if (b != 42) {
                                            switch (b) {
                                                case 53:
                                                case 54:
                                                case 55:
                                                    boolean z = b == 54;
                                                    char c = rENode.chr;
                                                    if (z) {
                                                        c = upcase(c);
                                                    }
                                                    addIndex(bArr, i4, c);
                                                    int i5 = i4 + 2;
                                                    addIndex(bArr, i5, z ? upcase((char) rENode.index) : rENode.index);
                                                    i4 = i5 + 2;
                                                    break;
                                            }
                                        } else {
                                            int emitREBytecode2 = emitREBytecode(compilerState, rECompiled, i4 + 2, rENode.kid);
                                            i2 = emitREBytecode2 + 1;
                                            bArr[emitREBytecode2] = 44;
                                        }
                                        resolveForwardJump(bArr, i4, i2);
                                    } else {
                                        if (rENode.flatIndex != -1) {
                                            while (true) {
                                                RENode rENode2 = rENode.next;
                                                if (rENode2 != null && rENode2.op == 14) {
                                                    int i6 = rENode.flatIndex;
                                                    int i7 = rENode.length;
                                                    if (i6 + i7 == rENode2.flatIndex) {
                                                        rENode.length = i7 + rENode2.length;
                                                        rENode.next = rENode2.next;
                                                    }
                                                }
                                            }
                                        }
                                        int i8 = rENode.flatIndex;
                                        if (i8 == -1 || rENode.length <= 1) {
                                            i3 = rENode.chr;
                                            if (i3 < 256) {
                                                if ((compilerState.flags & 2) != 0) {
                                                    bArr[i4 - 1] = 17;
                                                } else {
                                                    bArr[i4 - 1] = 15;
                                                }
                                                i2 = i4 + 1;
                                                bArr[i4] = (byte) i3;
                                            } else {
                                                if ((compilerState.flags & 2) != 0) {
                                                    bArr[i4 - 1] = 19;
                                                } else {
                                                    bArr[i4 - 1] = 18;
                                                }
                                                i = addIndex(bArr, i4, i3);
                                            }
                                        } else {
                                            if ((compilerState.flags & 2) != 0) {
                                                bArr[i4 - 1] = 16;
                                            } else {
                                                bArr[i4 - 1] = 14;
                                            }
                                            i = addIndex(bArr, addIndex(bArr, i4, i8), rENode.length);
                                        }
                                    }
                                }
                            }
                            RENode rENode3 = rENode.kid2;
                            int emitREBytecode3 = emitREBytecode(compilerState, rECompiled, i4 + 2, rENode.kid);
                            int i9 = emitREBytecode3 + 1;
                            bArr[emitREBytecode3] = 32;
                            int i10 = i9 + 2;
                            resolveForwardJump(bArr, i4, i10);
                            int emitREBytecode4 = emitREBytecode(compilerState, rECompiled, i10, rENode3);
                            int i11 = emitREBytecode4 + 1;
                            bArr[emitREBytecode4] = 32;
                            i = i11 + 2;
                            resolveForwardJump(bArr, i9, i);
                            resolveForwardJump(bArr, i11, i);
                        } else {
                            int emitREBytecode5 = emitREBytecode(compilerState, rECompiled, addIndex(bArr, i4, rENode.parenIndex), rENode.kid);
                            i4 = emitREBytecode5 + 1;
                            bArr[emitREBytecode5] = 30;
                        }
                        i3 = rENode.parenIndex;
                        i = addIndex(bArr, i4, i3);
                    } else {
                        int i12 = rENode.min;
                        if (i12 == 0 && rENode.max == -1) {
                            bArr[i4 - 1] = rENode.greedy ? (byte) 26 : (byte) 45;
                        } else if (i12 == 0 && rENode.max == 1) {
                            bArr[i4 - 1] = rENode.greedy ? (byte) 28 : (byte) 47;
                        } else if (i12 == 1 && rENode.max == -1) {
                            bArr[i4 - 1] = rENode.greedy ? (byte) 27 : (byte) 46;
                        } else {
                            if (!rENode.greedy) {
                                bArr[i4 - 1] = 48;
                            }
                            i4 = addIndex(bArr, addIndex(bArr, i4, i12), rENode.max + 1);
                        }
                        int addIndex = addIndex(bArr, addIndex(bArr, i4, rENode.parenCount), rENode.parenIndex);
                        int emitREBytecode6 = emitREBytecode(compilerState, rECompiled, addIndex + 2, rENode.kid);
                        i2 = emitREBytecode6 + 1;
                        bArr[emitREBytecode6] = 49;
                        resolveForwardJump(bArr, addIndex, i2);
                    }
                    i = i2;
                } else {
                    if (!rENode.sense) {
                        bArr[i4 - 1] = BuiltinOptions.GatherOptions;
                    }
                    i = addIndex(bArr, i4, rENode.index);
                    rECompiled.classList[rENode.index] = new RECharSet(rENode.bmsize, rENode.startIndex, rENode.kidlen, rENode.sense);
                }
                rENode = rENode.next;
            } else {
                i4--;
            }
            i = i4;
            continue;
            rENode = rENode.next;
        }
        return i;
    }

    private static String escapeRegExp(Object obj) {
        String scriptRuntime = ScriptRuntime.toString(obj);
        StringBuilder sb = null;
        int i = 0;
        for (int indexOf = scriptRuntime.indexOf(47); indexOf > -1; indexOf = scriptRuntime.indexOf(47, indexOf + 1)) {
            if (indexOf == i || scriptRuntime.charAt(indexOf - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) scriptRuntime, i, indexOf);
                sb.append("\\/");
                i = indexOf + 1;
            }
        }
        if (sb == null) {
            return scriptRuntime;
        }
        sb.append((CharSequence) scriptRuntime, i, scriptRuntime.length());
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object execSub(external.sdk.pendo.io.mozilla.javascript.Context r9, external.sdk.pendo.io.mozilla.javascript.Scriptable r10, java.lang.Object[] r11, int r12) {
        /*
            r8 = this;
            external.sdk.pendo.io.mozilla.javascript.regexp.RegExpImpl r3 = getImpl(r9)
            int r0 = r11.length
            r7 = 0
            if (r0 != 0) goto Lf
            java.lang.String r11 = r3.input
            if (r11 != 0) goto L15
            java.lang.Object r11 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
            goto L11
        Lf:
            r11 = r11[r7]
        L11:
            java.lang.String r11 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r11)
        L15:
            r4 = r11
            external.sdk.pendo.io.mozilla.javascript.regexp.RECompiled r11 = r8.re
            int r11 = r11.flags
            r11 = r11 & 1
            r0 = 0
            if (r11 == 0) goto L27
            java.lang.Object r11 = r8.lastIndex
            double r5 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toInteger(r11)
            goto L28
        L27:
            r5 = r0
        L28:
            int r11 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r11 < 0) goto L61
            int r11 = r4.length()
            double r0 = (double) r11
            int r11 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r11 >= 0) goto L36
            goto L61
        L36:
            int r11 = (int) r5
            int[] r11 = new int[]{r11}
            r0 = r8
            r1 = r9
            r2 = r10
            r5 = r11
            r6 = r12
            java.lang.Object r9 = r0.executeRegExp(r1, r2, r3, r4, r5, r6)
            external.sdk.pendo.io.mozilla.javascript.regexp.RECompiled r10 = r8.re
            int r10 = r10.flags
            r10 = r10 & 1
            if (r10 == 0) goto L67
            if (r9 == 0) goto L5b
            java.lang.Object r10 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
            if (r9 != r10) goto L53
            goto L5b
        L53:
            r10 = r11[r7]
            double r10 = (double) r10
            java.lang.Double r10 = java.lang.Double.valueOf(r10)
            goto L5d
        L5b:
            java.lang.Double r10 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.zeroObj
        L5d:
            r8.setLastIndex(r10)
            goto L67
        L61:
            java.lang.Double r9 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.zeroObj
            r8.setLastIndex(r9)
            r9 = 0
        L67:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.execSub(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[], int):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x00aa, code lost:
    
        if (classMatcher(r20, r20.regexp.classList[r1], r3) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x00b7, code lost:
    
        if (r3 != r1) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:191:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0396  */
    /* JADX WARN: Type inference failed for: r0v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v19, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean executeREBytecode(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData r20, java.lang.String r21, int r22) {
        /*
            Method dump skipped, instructions count: 1100
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.executeREBytecode(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData, java.lang.String, int):boolean");
    }

    private static boolean flatNIMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        char[] cArr = rEGlobalData.regexp.source;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i + i4];
            char charAt = str.charAt(rEGlobalData.cp + i4);
            if (c != charAt && upcase(c) != upcase(charAt)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    private static boolean flatNMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (rEGlobalData.regexp.source[i + i4] != str.charAt(rEGlobalData.cp + i4)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    private static int getDecimalValue(char c, CompilerState compilerState, int i, String str) {
        int i2 = compilerState.cp;
        char[] cArr = compilerState.cpbegin;
        int i3 = c - 48;
        boolean z = false;
        while (true) {
            int i4 = compilerState.cp;
            if (i4 == compilerState.cpend) {
                break;
            }
            char c2 = cArr[i4];
            if (!isDigit(c2)) {
                break;
            }
            if (!z && (i3 = (i3 * 10) + (c2 - '0')) >= i) {
                i3 = i;
                z = true;
            }
            compilerState.cp++;
        }
        if (z) {
            reportError(str, String.valueOf(cArr, i2, compilerState.cp - i2));
        }
        return i3;
    }

    private static RegExpImpl getImpl(Context context) {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(context);
    }

    private static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
    }

    private static int getOffset(byte[] bArr, int i) {
        return getIndex(bArr, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.re = compileRE(context, "", null, false);
        nativeRegExp.activatePrototypeMap(8);
        nativeRegExp.setParentScope(scriptable);
        nativeRegExp.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        NativeRegExpCtor nativeRegExpCtor = new NativeRegExpCtor();
        nativeRegExp.defineProperty("constructor", nativeRegExpCtor, 2);
        ScriptRuntime.setFunctionProtoAndParent(nativeRegExpCtor, scriptable);
        nativeRegExpCtor.setImmunePrototypeProperty(nativeRegExp);
        if (z) {
            nativeRegExp.sealObject();
            nativeRegExpCtor.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "RegExp", nativeRegExpCtor, 2);
    }

    private static boolean isControlLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean isLineTerm(char c) {
        return ScriptRuntime.isJSLineTerminator(c);
    }

    private static boolean isREWhiteSpace(int i) {
        return ScriptRuntime.isJSWhitespaceOrLineTerminator(i);
    }

    private static boolean isWord(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || isDigit(c) || c == '_';
    }

    private static boolean matchRegExp(REGlobalData rEGlobalData, RECompiled rECompiled, String str, int i, int i2, boolean z) {
        int i3 = rECompiled.parenCount;
        if (i3 != 0) {
            rEGlobalData.parens = new long[i3];
        } else {
            rEGlobalData.parens = null;
        }
        rEGlobalData.backTrackStackTop = null;
        rEGlobalData.stateStackTop = null;
        rEGlobalData.multiline = z || (rECompiled.flags & 4) != 0;
        rEGlobalData.regexp = rECompiled;
        int i4 = rECompiled.anchorCh;
        int i5 = i;
        while (i5 <= i2) {
            if (i4 >= 0) {
                while (i5 != i2) {
                    char charAt = str.charAt(i5);
                    if (charAt != i4 && ((rEGlobalData.regexp.flags & 2) == 0 || upcase(charAt) != upcase((char) i4))) {
                        i5++;
                    }
                }
                return false;
            }
            rEGlobalData.cp = i5;
            rEGlobalData.skipped = i5 - i;
            for (int i6 = 0; i6 < rECompiled.parenCount; i6++) {
                rEGlobalData.parens[i6] = -1;
            }
            boolean executeREBytecode = executeREBytecode(rEGlobalData, str, i2);
            rEGlobalData.backTrackStackTop = null;
            rEGlobalData.stateStackTop = null;
            if (executeREBytecode) {
                return true;
            }
            if (i4 == -2 && !rEGlobalData.multiline) {
                rEGlobalData.skipped = i2;
                return false;
            }
            i5 = rEGlobalData.skipped + i + 1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (r1 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        r1 = new external.sdk.pendo.io.mozilla.javascript.regexp.RENode((byte) 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r5.result = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean parseAlternative(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState r5) {
        /*
            char[] r0 = r5.cpbegin
            r1 = 0
            r2 = r1
        L4:
            int r3 = r5.cp
            int r4 = r5.cpend
            if (r3 == r4) goto L31
            char r3 = r0[r3]
            r4 = 124(0x7c, float:1.74E-43)
            if (r3 == r4) goto L31
            int r4 = r5.parenNesting
            if (r4 == 0) goto L19
            r4 = 41
            if (r3 != r4) goto L19
            goto L31
        L19:
            boolean r3 = parseTerm(r5)
            if (r3 != 0) goto L21
            r5 = 0
            return r5
        L21:
            if (r1 != 0) goto L27
            external.sdk.pendo.io.mozilla.javascript.regexp.RENode r1 = r5.result
            r2 = r1
            goto L2b
        L27:
            external.sdk.pendo.io.mozilla.javascript.regexp.RENode r3 = r5.result
            r2.next = r3
        L2b:
            external.sdk.pendo.io.mozilla.javascript.regexp.RENode r3 = r2.next
            if (r3 == 0) goto L4
            r2 = r3
            goto L2b
        L31:
            r0 = 1
            if (r1 != 0) goto L39
            external.sdk.pendo.io.mozilla.javascript.regexp.RENode r1 = new external.sdk.pendo.io.mozilla.javascript.regexp.RENode
            r1.<init>(r0)
        L39:
            r5.result = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.parseAlternative(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState):boolean");
    }

    private static boolean parseDisjunction(CompilerState compilerState) {
        int i;
        int i2;
        int i3;
        if (!parseAlternative(compilerState)) {
            return false;
        }
        char[] cArr = compilerState.cpbegin;
        int i4 = compilerState.cp;
        if (i4 != cArr.length && cArr[i4] == '|') {
            compilerState.cp = i4 + 1;
            RENode rENode = new RENode((byte) 31);
            rENode.kid = compilerState.result;
            if (!parseDisjunction(compilerState)) {
                return false;
            }
            RENode rENode2 = compilerState.result;
            rENode.kid2 = rENode2;
            compilerState.result = rENode;
            RENode rENode3 = rENode.kid;
            byte b = rENode3.op;
            if (b == 14 && rENode2.op == 14) {
                rENode.op = (compilerState.flags & 2) == 0 ? (byte) 53 : (byte) 54;
                rENode.chr = rENode3.chr;
                i2 = rENode2.chr;
            } else if (b == 22 && (i3 = rENode3.index) < 256 && rENode2.op == 14 && (compilerState.flags & 2) == 0) {
                rENode.op = (byte) 55;
                rENode.chr = rENode2.chr;
                rENode.index = i3;
                i = compilerState.progLength + 13;
                compilerState.progLength = i;
            } else if (b == 14 && rENode2.op == 22 && (i2 = rENode2.index) < 256 && (compilerState.flags & 2) == 0) {
                rENode.op = (byte) 55;
                rENode.chr = rENode3.chr;
            } else {
                i = compilerState.progLength + 9;
                compilerState.progLength = i;
            }
            rENode.index = i2;
            i = compilerState.progLength + 13;
            compilerState.progLength = i;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:116:0x00f4. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x029e A[ADDED_TO_REGION, REMOVE, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0328  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean parseTerm(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState r16) {
        /*
            Method dump skipped, instructions count: 968
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.parseTerm(external.sdk.pendo.io.mozilla.javascript.regexp.CompilerState):boolean");
    }

    private static REProgState popProgState(REGlobalData rEGlobalData) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.stateStackTop = rEProgState.previous;
        return rEProgState;
    }

    private static void processCharSet(REGlobalData rEGlobalData, RECharSet rECharSet) {
        synchronized (rECharSet) {
            if (!rECharSet.converted) {
                processCharSetImpl(rEGlobalData, rECharSet);
                rECharSet.converted = true;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0054. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0057. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x005a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ee A[LOOP:1: B:29:0x00d7->B:33:0x00ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void processCharSetImpl(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData r18, external.sdk.pendo.io.mozilla.javascript.regexp.RECharSet r19) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.processCharSetImpl(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData, external.sdk.pendo.io.mozilla.javascript.regexp.RECharSet):void");
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, rEGlobalData.cp, rEProgState.continuationOp, rEProgState.continuationPc);
    }

    private static void pushProgState(REGlobalData rEGlobalData, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        rEGlobalData.stateStackTop = new REProgState(rEGlobalData.stateStackTop, i, i2, i3, rEBackTrackData, i4, i5);
    }

    private static NativeRegExp realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeRegExp) {
            return (NativeRegExp) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    private static boolean reopIsSimple(int i) {
        return i >= 1 && i <= 23;
    }

    private static void reportError(String str, String str2) {
        throw ScriptRuntime.constructError("SyntaxError", ScriptRuntime.getMessage1(str, str2));
    }

    private static void reportWarning(Context context, String str, String str2) {
        if (context.hasFeature(11)) {
            Context.reportWarning(ScriptRuntime.getMessage1(str, str2));
        }
    }

    private static void resolveForwardJump(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw Kit.codeBug();
        }
        addIndex(bArr, i, i2 - i);
    }

    private void setLastIndex(Object obj) {
        if ((this.lastIndexAttr & 1) != 0) {
            throw ScriptRuntime.typeError1("msg.modify.readonly", "lastIndex");
        }
        this.lastIndex = obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (upcase(r5) == upcase(r4)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r4.charAt(r6) == r5) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
    
        if (upcase(r6) == upcase(r4)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
    
        if (r4.charAt(r0) == r6) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
    
        if (isREWhiteSpace(r4.charAt(r0)) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ce, code lost:
    
        if (isREWhiteSpace(r4.charAt(r0)) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00db, code lost:
    
        if (isWord(r4.charAt(r0)) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e8, code lost:
    
        if (isWord(r4.charAt(r0)) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f5, code lost:
    
        if (isDigit(r4.charAt(r0)) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0102, code lost:
    
        if (isDigit(r4.charAt(r0)) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010f, code lost:
    
        if (isLineTerm(r4.charAt(r0)) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0136, code lost:
    
        if (isWord(r4.charAt(r6)) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0157, code lost:
    
        if (isWord(r4.charAt(r6)) != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016b, code lost:
    
        if (isLineTerm(r4.charAt(r0)) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x017e, code lost:
    
        if (isLineTerm(r4.charAt(r0 - 1)) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if (classMatcher(r3, r3.regexp.classList[r5], r4.charAt(r6)) != false) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int simpleMatch(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData r3, java.lang.String r4, int r5, byte[] r6, int r7, int r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp.simpleMatch(external.sdk.pendo.io.mozilla.javascript.regexp.REGlobalData, java.lang.String, int, byte[], int, int, boolean):int");
    }

    private static int toASCIIHexDigit(int i) {
        if (i < 48) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = i | 32;
        if (97 > i2 || i2 > 102) {
            return -1;
        }
        return (i2 - 97) + 10;
    }

    private static char upcase(char c) {
        if (c < 128) {
            return ('a' > c || c > 'z') ? c : (char) (c - ' ');
        }
        char upperCase = Character.toUpperCase(c);
        return upperCase < 128 ? c : upperCase;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (context.getLanguageVersion() < 200) {
            return execSub(context, scriptable, objArr, 1);
        }
        throw ScriptRuntime.notFunctionError(scriptable2);
    }

    Scriptable compile(Context context, Scriptable scriptable, Object[] objArr) {
        String str;
        Object obj;
        Object obj2;
        if (objArr.length > 0) {
            Object obj3 = objArr[0];
            if (obj3 instanceof NativeRegExp) {
                if (objArr.length > 1 && objArr[1] != Undefined.instance) {
                    throw ScriptRuntime.typeError0("msg.bad.regexp.compile");
                }
                NativeRegExp nativeRegExp = (NativeRegExp) obj3;
                this.re = nativeRegExp.re;
                obj = nativeRegExp.lastIndex;
                setLastIndex(obj);
                return this;
            }
        }
        if (objArr.length != 0) {
            Object obj4 = objArr[0];
            if (!(obj4 instanceof Undefined)) {
                str = escapeRegExp(obj4);
                this.re = compileRE(context, str, (objArr.length > 1 || (obj2 = objArr[1]) == Undefined.instance) ? null : ScriptRuntime.toString(obj2), false);
                obj = ScriptRuntime.zeroObj;
                setLastIndex(obj);
                return this;
            }
        }
        str = "";
        this.re = compileRE(context, str, (objArr.length > 1 || (obj2 = objArr[1]) == Undefined.instance) ? null : ScriptRuntime.toString(obj2), false);
        obj = ScriptRuntime.zeroObj;
        setLastIndex(obj);
        return this;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        if (context.getLanguageVersion() < 200) {
            return (Scriptable) execSub(context, scriptable, objArr, 1);
        }
        throw ScriptRuntime.notFunctionError(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(REGEXP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        switch (methodId) {
            case 1:
                return realThis(scriptable2, idFunctionObject).compile(context, scriptable, objArr);
            case 2:
            case 3:
                return realThis(scriptable2, idFunctionObject).toString();
            case 4:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 5:
                Object execSub = realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 0);
                Boolean bool = Boolean.TRUE;
                return bool.equals(execSub) ? bool : Boolean.FALSE;
            case 6:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 2);
            case 7:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 8:
                Scriptable scriptable3 = (Scriptable) realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
                return scriptable3.get("index", scriptable3);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Boolean] */
    Object executeRegExp(Context context, Scriptable scriptable, RegExpImpl regExpImpl, String str, int[] iArr, int i) {
        Scriptable newArray;
        Scriptable scriptable2;
        int i2;
        Object obj;
        NativeRegExp nativeRegExp = this;
        REGlobalData rEGlobalData = new REGlobalData();
        int i3 = iArr[0];
        int length = str.length();
        int i4 = i3 > length ? length : i3;
        SubString subString = null;
        if (!matchRegExp(rEGlobalData, nativeRegExp.re, str, i4, length, regExpImpl.multiline)) {
            if (i != 2) {
                return null;
            }
            return Undefined.instance;
        }
        int i5 = rEGlobalData.cp;
        iArr[0] = i5;
        int i6 = i5 - (rEGlobalData.skipped + i4);
        int i7 = i5 - i6;
        if (i == 0) {
            scriptable2 = null;
            newArray = Boolean.TRUE;
        } else {
            newArray = context.newArray(scriptable, 0);
            newArray.put(0, newArray, str.substring(i7, i7 + i6));
            scriptable2 = newArray;
        }
        int i8 = nativeRegExp.re.parenCount;
        if (i8 == 0) {
            regExpImpl.parens = null;
            subString = new SubString();
        } else {
            regExpImpl.parens = new SubString[i8];
            int i9 = 0;
            while (i9 < nativeRegExp.re.parenCount) {
                int parensIndex = rEGlobalData.parensIndex(i9);
                if (parensIndex != -1) {
                    subString = new SubString(str, parensIndex, rEGlobalData.parensLength(i9));
                    regExpImpl.parens[i9] = subString;
                    if (i != 0) {
                        i2 = i9 + 1;
                        obj = subString.toString();
                        scriptable2.put(i2, scriptable2, obj);
                        i9++;
                        nativeRegExp = this;
                    } else {
                        i9++;
                        nativeRegExp = this;
                    }
                } else if (i != 0) {
                    i2 = i9 + 1;
                    obj = Undefined.instance;
                    scriptable2.put(i2, scriptable2, obj);
                    i9++;
                    nativeRegExp = this;
                } else {
                    i9++;
                    nativeRegExp = this;
                }
            }
        }
        regExpImpl.lastParen = subString;
        if (i != 0) {
            scriptable2.put("index", scriptable2, Integer.valueOf(rEGlobalData.skipped + i4));
            scriptable2.put("input", scriptable2, str);
        }
        if (regExpImpl.lastMatch == null) {
            regExpImpl.lastMatch = new SubString();
            regExpImpl.leftContext = new SubString();
            regExpImpl.rightContext = new SubString();
        }
        SubString subString2 = regExpImpl.lastMatch;
        subString2.str = str;
        subString2.index = i7;
        subString2.length = i6;
        regExpImpl.leftContext.str = str;
        if (context.getLanguageVersion() == 120) {
            SubString subString3 = regExpImpl.leftContext;
            subString3.index = i4;
            subString3.length = rEGlobalData.skipped;
        } else {
            SubString subString4 = regExpImpl.leftContext;
            subString4.index = 0;
            subString4.length = i4 + rEGlobalData.skipped;
        }
        SubString subString5 = regExpImpl.rightContext;
        subString5.str = str;
        subString5.index = i5;
        subString5.length = length - i5;
        return newArray;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int i2;
        int length = str.length();
        if (length == 6) {
            char charAt = str.charAt(0);
            if (charAt == 'g') {
                str2 = "global";
                i = 3;
            } else {
                if (charAt == 's') {
                    str2 = "source";
                    i = 2;
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 9) {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'l') {
                str2 = "lastIndex";
                i = 1;
            } else {
                if (charAt2 == 'm') {
                    str2 = "multiline";
                    i = 5;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 10) {
                str2 = "ignoreCase";
                i = 4;
            }
            str2 = null;
            i = 0;
        }
        int i3 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        if (i3 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i3 == 1) {
            i2 = this.lastIndexAttr;
        } else {
            if (i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
                throw new IllegalStateException();
            }
            i2 = 7;
        }
        return IdScriptableObject.instanceIdInfo(i2, i3);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        if (SymbolKey.MATCH.equals(symbol)) {
            return 7;
        }
        return SymbolKey.SEARCH.equals(symbol) ? 8 : 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "RegExp";
    }

    int getFlags() {
        return this.re.flags;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? super.getInstanceIdName(i) : "multiline" : "ignoreCase" : "global" : "source" : "lastIndex";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        if (i == 1) {
            return this.lastIndex;
        }
        if (i == 2) {
            return new String(this.re.source);
        }
        if (i == 3) {
            return ScriptRuntime.wrapBoolean((this.re.flags & 1) != 0);
        }
        if (i == 4) {
            return ScriptRuntime.wrapBoolean((this.re.flags & 2) != 0);
        }
        if (i != 5) {
            return super.getInstanceIdValue(i);
        }
        return ScriptRuntime.wrapBoolean((this.re.flags & 4) != 0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 5;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return "object";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        if (i == 7) {
            initPrototypeMethod(REGEXP_TAG, i, SymbolKey.MATCH, "[Symbol.match]", 1);
            return;
        }
        if (i == 8) {
            initPrototypeMethod(REGEXP_TAG, i, SymbolKey.SEARCH, "[Symbol.search]", 1);
            return;
        }
        int i2 = 0;
        int i3 = 1;
        switch (i) {
            case 1:
                i2 = 2;
                str = "compile";
                String str3 = str;
                i3 = i2;
                str2 = str3;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 2:
                str = "toString";
                String str32 = str;
                i3 = i2;
                str2 = str32;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 3:
                str = "toSource";
                String str322 = str;
                i3 = i2;
                str2 = str322;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 4:
                str2 = "exec";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 5:
                str2 = "test";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 6:
                str2 = "prefix";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i != 1) {
            super.setInstanceIdAttributes(i, i2);
        } else {
            this.lastIndexAttr = i2;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLastIndex(obj);
        } else {
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                return;
            }
            super.setInstanceIdValue(i, obj);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("/");
        char[] cArr = this.re.source;
        if (cArr.length != 0) {
            sb.append(cArr);
        } else {
            sb.append("(?:)");
        }
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        if ((this.re.flags & 1) != 0) {
            sb.append('g');
        }
        if ((this.re.flags & 2) != 0) {
            sb.append('i');
        }
        if ((this.re.flags & 4) != 0) {
            sb.append('m');
        }
        return sb.toString();
    }

    NativeRegExp(Scriptable scriptable, RECompiled rECompiled) {
        Double d = ScriptRuntime.zeroObj;
        this.lastIndex = d;
        this.lastIndexAttr = 6;
        this.re = rECompiled;
        setLastIndex(d);
        ScriptRuntime.setBuiltinProtoAndParent(this, scriptable, TopLevel.Builtins.RegExp);
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i, int i2, int i3, int i4) {
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, i2, i3, i4);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 4;
        if (length != 4) {
            i = 6;
            if (length == 6) {
                str2 = "prefix";
            } else if (length != 7) {
                if (length == 8) {
                    i = 3;
                    char charAt = str.charAt(3);
                    if (charAt == 'o') {
                        str2 = "toSource";
                    } else if (charAt == 't') {
                        str2 = "toString";
                        i = 2;
                    }
                }
                str2 = null;
                i = 0;
            } else {
                str2 = "compile";
                i = 1;
            }
        } else {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'e') {
                str2 = "exec";
            } else {
                if (charAt2 == 't') {
                    str2 = "test";
                    i = 5;
                }
                str2 = null;
                i = 0;
            }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
