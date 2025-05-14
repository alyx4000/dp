package external.sdk.pendo.io.mozilla.javascript;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import external.sdk.pendo.io.mozilla.javascript.TopLevel;
import external.sdk.pendo.io.mozilla.javascript.regexp.NativeRegExp;
import io.sentry.SentryEnvelopeItemHeader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes2.dex */
public class NativeArray extends IdScriptableObject implements List {
    private static final int ConstructorId_concat = -13;
    private static final int ConstructorId_every = -17;
    private static final int ConstructorId_filter = -18;
    private static final int ConstructorId_find = -22;
    private static final int ConstructorId_findIndex = -23;
    private static final int ConstructorId_forEach = -19;
    private static final int ConstructorId_from = -28;
    private static final int ConstructorId_indexOf = -15;
    private static final int ConstructorId_isArray = -26;
    private static final int ConstructorId_join = -5;
    private static final int ConstructorId_lastIndexOf = -16;
    private static final int ConstructorId_map = -20;
    private static final int ConstructorId_of = -27;
    private static final int ConstructorId_pop = -9;
    private static final int ConstructorId_push = -8;
    private static final int ConstructorId_reduce = -24;
    private static final int ConstructorId_reduceRight = -25;
    private static final int ConstructorId_reverse = -6;
    private static final int ConstructorId_shift = -10;
    private static final int ConstructorId_slice = -14;
    private static final int ConstructorId_some = -21;
    private static final int ConstructorId_sort = -7;
    private static final int ConstructorId_splice = -12;
    private static final int ConstructorId_unshift = -11;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double GROW_FACTOR = 1.5d;
    private static final int Id_concat = 13;
    private static final int Id_constructor = 1;
    private static final int Id_copyWithin = 31;
    private static final int Id_entries = 29;
    private static final int Id_every = 17;
    private static final int Id_fill = 26;
    private static final int Id_filter = 18;
    private static final int Id_find = 22;
    private static final int Id_findIndex = 23;
    private static final int Id_forEach = 19;
    private static final int Id_includes = 30;
    private static final int Id_indexOf = 15;
    private static final int Id_join = 5;
    private static final int Id_keys = 27;
    private static final int Id_lastIndexOf = 16;
    private static final int Id_length = 1;
    private static final int Id_map = 20;
    private static final int Id_pop = 9;
    private static final int Id_push = 8;
    private static final int Id_reduce = 24;
    private static final int Id_reduceRight = 25;
    private static final int Id_reverse = 6;
    private static final int Id_shift = 10;
    private static final int Id_slice = 14;
    private static final int Id_some = 21;
    private static final int Id_sort = 7;
    private static final int Id_splice = 12;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_unshift = 11;
    private static final int Id_values = 28;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PRE_GROW_SIZE = 1431655764;
    private static final int MAX_PROTOTYPE_ID = 32;
    private static final int SymbolId_iterator = 32;
    private static final long serialVersionUID = 7331366857676127338L;
    private Object[] dense;
    private boolean denseOnly;
    private long length;
    private int lengthAttr;
    private static final Object ARRAY_TAG = "Array";
    private static final Long NEGATIVE_ONE = -1L;
    private static final Comparator<Object> STRING_COMPARATOR = new StringLikeComparator();
    private static final Comparator<Object> DEFAULT_COMPARATOR = new ElementComparator();
    private static int maximumInitialCapacity = ModuleDescriptor.MODULE_VERSION;

    public static final class ElementComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = -1189948017688708858L;
        private final Comparator<Object> child;

        public ElementComparator() {
            this.child = NativeArray.STRING_COMPARATOR;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Object obj3 = Undefined.instance;
            if (obj == obj3) {
                if (obj2 == obj3) {
                    return 0;
                }
                return obj2 == Scriptable.NOT_FOUND ? -1 : 1;
            }
            Object obj4 = Scriptable.NOT_FOUND;
            if (obj == obj4) {
                return obj2 == obj4 ? 0 : 1;
            }
            if (obj2 == obj4 || obj2 == obj3) {
                return -1;
            }
            return this.child.compare(obj, obj2);
        }

        public ElementComparator(Comparator<Object> comparator) {
            this.child = comparator;
        }
    }

    public static final class StringLikeComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = 5299017659728190979L;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ScriptRuntime.toString(obj).compareTo(ScriptRuntime.toString(obj2));
        }
    }

    public NativeArray(long j) {
        this.lengthAttr = 6;
        boolean z = j <= ((long) maximumInitialCapacity);
        this.denseOnly = z;
        if (z) {
            int i = (int) j;
            Object[] objArr = new Object[i < 10 ? 10 : i];
            this.dense = objArr;
            Arrays.fill(objArr, Scriptable.NOT_FOUND);
        }
        this.length = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static external.sdk.pendo.io.mozilla.javascript.Scriptable callConstructorOrCreateArray(external.sdk.pendo.io.mozilla.javascript.Context r4, external.sdk.pendo.io.mozilla.javascript.Scriptable r5, external.sdk.pendo.io.mozilla.javascript.Scriptable r6, long r7, boolean r9) {
        /*
            boolean r0 = r6 instanceof external.sdk.pendo.io.mozilla.javascript.Function
            r1 = 0
            if (r0 == 0) goto L30
            if (r9 != 0) goto L11
            r2 = 0
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 <= 0) goto Le
            goto L11
        Le:
            java.lang.Object[] r9 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.emptyArgs     // Catch: external.sdk.pendo.io.mozilla.javascript.EcmaError -> L21
            goto L1a
        L11:
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch: external.sdk.pendo.io.mozilla.javascript.EcmaError -> L21
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch: external.sdk.pendo.io.mozilla.javascript.EcmaError -> L21
            r9[r1] = r0     // Catch: external.sdk.pendo.io.mozilla.javascript.EcmaError -> L21
        L1a:
            external.sdk.pendo.io.mozilla.javascript.Function r6 = (external.sdk.pendo.io.mozilla.javascript.Function) r6     // Catch: external.sdk.pendo.io.mozilla.javascript.EcmaError -> L21
            external.sdk.pendo.io.mozilla.javascript.Scriptable r6 = r6.construct(r4, r5, r9)     // Catch: external.sdk.pendo.io.mozilla.javascript.EcmaError -> L21
            goto L31
        L21:
            r6 = move-exception
            java.lang.String r9 = r6.getName()
            java.lang.String r0 = "TypeError"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L2f
            goto L30
        L2f:
            throw r6
        L30:
            r6 = 0
        L31:
            if (r6 != 0) goto L40
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r6 <= 0) goto L3b
            goto L3c
        L3b:
            int r1 = (int) r7
        L3c:
            external.sdk.pendo.io.mozilla.javascript.Scriptable r6 = r4.newArray(r5, r1)
        L40:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.callConstructorOrCreateArray(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, long, boolean):external.sdk.pendo.io.mozilla.javascript.Scriptable");
    }

    private static long concatSpreadArg(Context context, Scriptable scriptable, Scriptable scriptable2, long j) {
        long lengthProperty = getLengthProperty(context, scriptable2, false);
        long j2 = lengthProperty + j;
        if (j2 <= 2147483647L && (scriptable instanceof NativeArray)) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && (scriptable2 instanceof NativeArray)) {
                NativeArray nativeArray2 = (NativeArray) scriptable2;
                if (nativeArray2.denseOnly) {
                    nativeArray.ensureCapacity((int) j2);
                    System.arraycopy(nativeArray2.dense, 0, nativeArray.dense, (int) j, (int) lengthProperty);
                    return j2;
                }
            }
        }
        long j3 = 0;
        while (j3 < lengthProperty) {
            Object rawElem = getRawElem(scriptable2, j3);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, scriptable, j, rawElem);
            }
            j3++;
            j++;
        }
        return j2;
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, parentScope, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        Boolean bool = Boolean.TRUE;
        nativeObject.defineProperty("writable", bool, 0);
        nativeObject.defineProperty("enumerable", bool, 0);
        nativeObject.defineProperty("configurable", bool, 0);
        return nativeObject;
    }

    private static void defineElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            scriptable.put(Long.toString(j), scriptable, obj);
        } else {
            scriptable.put((int) j, scriptable, obj);
        }
    }

    private static void deleteElem(Scriptable scriptable, long j) {
        int i = (int) j;
        if (i == j) {
            scriptable.delete(i);
        } else {
            scriptable.delete(Long.toString(j));
        }
    }

    private static long doConcat(Context context, Scriptable scriptable, Scriptable scriptable2, Object obj, long j) {
        if (isConcatSpreadable(context, scriptable, obj)) {
            return concatSpreadArg(context, scriptable2, (Scriptable) obj, j);
        }
        defineElem(context, scriptable2, j, obj);
        return j + 1;
    }

    private boolean ensureCapacity(int i) {
        if (i <= this.dense.length) {
            return true;
        }
        if (i > MAX_PRE_GROW_SIZE) {
            this.denseOnly = false;
            return false;
        }
        int max = Math.max(i, (int) (r0.length * GROW_FACTOR));
        Object[] objArr = new Object[max];
        Object[] objArr2 = this.dense;
        System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
        Arrays.fill(objArr, this.dense.length, max, Scriptable.NOT_FOUND);
        this.dense = objArr;
        return true;
    }

    private static Object getElem(Context context, Scriptable scriptable, long j) {
        Object rawElem = getRawElem(scriptable, j);
        return rawElem != Scriptable.NOT_FOUND ? rawElem : Undefined.instance;
    }

    static long getLengthProperty(Context context, Scriptable scriptable, boolean z) {
        if (scriptable instanceof NativeString) {
            return ((NativeString) scriptable).getLength();
        }
        if (scriptable instanceof NativeArray) {
            return ((NativeArray) scriptable).getLength();
        }
        Object property = ScriptableObject.getProperty(scriptable, SentryEnvelopeItemHeader.JsonKeys.LENGTH);
        if (property == Scriptable.NOT_FOUND) {
            return 0L;
        }
        double number = ScriptRuntime.toNumber(property);
        if (number > 9.007199254740991E15d) {
            if (z) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
            }
            return 2147483647L;
        }
        if (number < 0.0d) {
            return 0L;
        }
        return ScriptRuntime.toUint32(property);
    }

    static int getMaximumInitialCapacity() {
        return maximumInitialCapacity;
    }

    private static Object getRawElem(Scriptable scriptable, long j) {
        return j > 2147483647L ? ScriptableObject.getProperty(scriptable, Long.toString(j)) : ScriptableObject.getProperty(scriptable, (int) j);
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeArray(0L).exportAsJSClass(32, scriptable, z);
    }

    private static boolean isConcatSpreadable(Context context, Scriptable scriptable, Object obj) {
        Object property;
        if ((obj instanceof Scriptable) && (property = ScriptableObject.getProperty((Scriptable) obj, SymbolKey.IS_CONCAT_SPREADABLE)) != Scriptable.NOT_FOUND && !Undefined.isUndefined(property)) {
            return ScriptRuntime.toBoolean(property);
        }
        if (context.getLanguageVersion() >= 200 || !ScriptRuntime.instanceOf(obj, ScriptRuntime.getExistingCtor(context, scriptable, "Array"), context)) {
            return js_isArray(obj);
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Object iterativeMethod(Context context, IdFunctionObject idFunctionObject, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable newArray;
        double d;
        long j;
        long j2;
        boolean z;
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int abs = Math.abs(idFunctionObject.methodId());
        int i = 23;
        if (22 == abs || 23 == abs) {
            ScriptRuntimeES6.requireObjectCoercible(context, object, idFunctionObject);
        }
        long lengthProperty = getLengthProperty(context, object, abs == 20);
        Object obj2 = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj2 == null || !(obj2 instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj2);
        }
        if (context.getLanguageVersion() >= 200 && (obj2 instanceof NativeRegExp)) {
            throw ScriptRuntime.notFunctionError(obj2);
        }
        Function function = (Function) obj2;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        Scriptable object2 = (objArr.length < 2 || (obj = objArr[1]) == null || obj == Undefined.instance) ? topLevelScope : ScriptRuntime.toObject(context, scriptable, obj);
        if (abs == 18 || abs == 20) {
            newArray = context.newArray(scriptable, abs == 20 ? (int) lengthProperty : 0);
        } else {
            newArray = null;
        }
        long j3 = 0;
        long j4 = 0;
        while (true) {
            if (j3 >= lengthProperty) {
                switch (abs) {
                    case 17:
                        return Boolean.TRUE;
                    case 18:
                    case 20:
                        return newArray;
                    case 19:
                    case 22:
                    default:
                        return Undefined.instance;
                    case 21:
                        return Boolean.FALSE;
                    case 23:
                        d = -1.0d;
                        break;
                }
            } else {
                Object[] objArr2 = new Object[3];
                Object rawElem = getRawElem(object, j3);
                if (rawElem == Scriptable.NOT_FOUND) {
                    if (abs == 22 || abs == i) {
                        rawElem = Undefined.instance;
                    } else {
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                    }
                }
                objArr2[0] = rawElem;
                objArr2[1] = Long.valueOf(j3);
                objArr2[2] = object;
                Object call = function.call(context, topLevelScope, object2, objArr2);
                switch (abs) {
                    case 17:
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        if (!ScriptRuntime.toBoolean(call)) {
                            return Boolean.FALSE;
                        }
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                    case 18:
                        if (ScriptRuntime.toBoolean(call)) {
                            j = lengthProperty;
                            long j5 = j4;
                            j4 = j5 + 1;
                            z = false;
                            defineElem(context, newArray, j5, objArr2[0]);
                            j3++;
                            lengthProperty = j;
                            i = 23;
                        }
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                    case 19:
                    default:
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                    case 20:
                        defineElem(context, newArray, j3, call);
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                    case 21:
                        if (ScriptRuntime.toBoolean(call)) {
                            return Boolean.TRUE;
                        }
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                    case 22:
                        if (ScriptRuntime.toBoolean(call)) {
                            return rawElem;
                        }
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                    case 23:
                        if (ScriptRuntime.toBoolean(call)) {
                            d = j3;
                            break;
                        }
                        j = lengthProperty;
                        j2 = j4;
                        z = false;
                        j4 = j2;
                        j3++;
                        lengthProperty = j;
                        i = 23;
                }
            }
        }
        return ScriptRuntime.wrapNumber(d);
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length == 0) {
            return new NativeArray(0L);
        }
        if (context.getLanguageVersion() == 120) {
            return new NativeArray(objArr);
        }
        Object obj = objArr[0];
        if (objArr.length > 1 || !(obj instanceof Number)) {
            return new NativeArray(objArr);
        }
        long uint32 = ScriptRuntime.toUint32(obj);
        if (uint32 == ((Number) obj).doubleValue()) {
            return new NativeArray(uint32);
        }
        throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
    }

    private static Scriptable js_concat(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Scriptable newArray = context.newArray(topLevelScope, 0);
        long doConcat = doConcat(context, topLevelScope, newArray, object, 0L);
        for (Object obj : objArr) {
            doConcat = doConcat(context, topLevelScope, newArray, obj, doConcat);
        }
        setLengthProperty(context, newArray, doConcat);
        return newArray;
    }

    private static Object js_copyWithin(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        int i = 1;
        long integer = (long) ScriptRuntime.toInteger(objArr.length >= 1 ? objArr[0] : Undefined.instance);
        long max = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty);
        long integer2 = (long) ScriptRuntime.toInteger(objArr.length >= 2 ? objArr[1] : Undefined.instance);
        long max2 = integer2 < 0 ? Math.max(integer2 + lengthProperty, 0L) : Math.min(integer2, lengthProperty);
        long integer3 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long min = Math.min((integer3 < 0 ? Math.max(integer3 + lengthProperty, 0L) : Math.min(integer3, lengthProperty)) - max2, lengthProperty - max);
        if (max2 < max) {
            long j = max2 + min;
            if (max < j) {
                max2 = j - 1;
                max = (max + min) - 1;
                i = -1;
            }
        }
        if ((object instanceof NativeArray) && min <= 2147483647L) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                while (min > 0) {
                    Object[] objArr2 = nativeArray.dense;
                    objArr2[(int) max] = objArr2[(int) max2];
                    long j2 = i;
                    max2 += j2;
                    max += j2;
                    min--;
                }
                return scriptable2;
            }
        }
        while (min > 0) {
            Object rawElem = getRawElem(object, max2);
            if (rawElem == Scriptable.NOT_FOUND || Undefined.isUndefined(rawElem)) {
                deleteElem(object, max);
            } else {
                setElem(context, object, max, rawElem);
            }
            long j3 = i;
            max2 += j3;
            max += j3;
            min--;
        }
        return scriptable2;
    }

    private static Object js_fill(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long lengthProperty = getLengthProperty(context, ScriptRuntime.toObject(context, scriptable, scriptable2), false);
        long integer = objArr.length >= 2 ? (long) ScriptRuntime.toInteger(objArr[1]) : 0L;
        long integer2 = (objArr.length < 3 || Undefined.isUndefined(objArr[2])) ? lengthProperty : (long) ScriptRuntime.toInteger(objArr[2]);
        long max = integer2 < 0 ? Math.max(lengthProperty + integer2, 0L) : Math.min(integer2, lengthProperty);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        for (long max2 = integer < 0 ? Math.max(integer + lengthProperty, 0L) : Math.min(integer, lengthProperty); max2 < max; max2++) {
            setRawElem(context, scriptable2, max2, obj);
        }
        return scriptable2;
    }

    private static Object js_from(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Function function;
        Scriptable object = ScriptRuntime.toObject(scriptable, objArr.length >= 1 ? objArr[0] : Undefined.instance);
        Object obj = objArr.length >= 2 ? objArr[1] : Undefined.instance;
        Scriptable scriptable3 = Undefined.SCRIPTABLE_UNDEFINED;
        boolean z = !Undefined.isUndefined(obj);
        if (!z) {
            function = null;
        } else {
            if (!(obj instanceof Function)) {
                throw ScriptRuntime.typeError0("msg.map.function.not");
            }
            function = (Function) obj;
            if (objArr.length >= 3) {
                scriptable3 = ScriptableObject.ensureScriptable(objArr[2]);
            }
        }
        Function function2 = function;
        Scriptable scriptable4 = scriptable3;
        Object property = ScriptableObject.getProperty(object, SymbolKey.ITERATOR);
        if (!(object instanceof NativeArray) && property != Scriptable.NOT_FOUND && !Undefined.isUndefined(property)) {
            Object callIterator = ScriptRuntime.callIterator(object, context, scriptable);
            if (!Undefined.isUndefined(callIterator)) {
                Scriptable callConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, 0L, false);
                IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, callIterator);
                try {
                    Iterator<Object> iterator2 = iteratorLikeIterable.iterator2();
                    long j = 0;
                    while (iterator2.hasNext()) {
                        Object next = iterator2.next();
                        if (z) {
                            next = function2.call(context, scriptable, scriptable4, new Object[]{next, Long.valueOf(j)});
                        }
                        defineElem(context, callConstructorOrCreateArray, j, next);
                        j++;
                    }
                    iteratorLikeIterable.close();
                    setLengthProperty(context, callConstructorOrCreateArray, j);
                    return callConstructorOrCreateArray;
                } finally {
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        Scriptable callConstructorOrCreateArray2 = callConstructorOrCreateArray(context, scriptable, scriptable2, lengthProperty, true);
        for (long j2 = 0; j2 < lengthProperty; j2++) {
            Object rawElem = getRawElem(object, j2);
            if (rawElem != Scriptable.NOT_FOUND) {
                if (z) {
                    rawElem = function2.call(context, scriptable, scriptable4, new Object[]{rawElem, Long.valueOf(j2)});
                }
                defineElem(context, callConstructorOrCreateArray2, j2, rawElem);
            }
        }
        setLengthProperty(context, callConstructorOrCreateArray2, lengthProperty);
        return callConstructorOrCreateArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r3 < 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean js_includes(external.sdk.pendo.io.mozilla.javascript.Context r7, external.sdk.pendo.io.mozilla.javascript.Scriptable r8, external.sdk.pendo.io.mozilla.javascript.Scriptable r9, java.lang.Object[] r10) {
        /*
            int r0 = r10.length
            r1 = 0
            if (r0 <= 0) goto L7
            r0 = r10[r1]
            goto L9
        L7:
            java.lang.Object r0 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
        L9:
            external.sdk.pendo.io.mozilla.javascript.Scriptable r7 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toObject(r7, r8, r9)
            java.lang.String r8 = "length"
            java.lang.Object r8 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.getProperty(r9, r8)
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            long r8 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toLength(r8, r1)
            r1 = 0
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L24
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L24:
            int r3 = r10.length
            r4 = 2
            r5 = 1
            if (r3 >= r4) goto L2b
            goto L47
        L2b:
            r3 = 1
            r10 = r10[r3]
            double r3 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toInteger(r10)
            long r3 = (long) r3
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 >= 0) goto L3d
            long r3 = r3 + r8
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 >= 0) goto L3d
            goto L3e
        L3d:
            r1 = r3
        L3e:
            long r3 = r8 - r5
            int r10 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r10 <= 0) goto L47
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L47:
            boolean r10 = r7 instanceof external.sdk.pendo.io.mozilla.javascript.NativeArray
            if (r10 == 0) goto L7d
            r10 = r7
            external.sdk.pendo.io.mozilla.javascript.NativeArray r10 = (external.sdk.pendo.io.mozilla.javascript.NativeArray) r10
            boolean r3 = r10.denseOnly
            if (r3 == 0) goto L7d
            external.sdk.pendo.io.mozilla.javascript.Scriptable r7 = r10.getPrototype()
            int r1 = (int) r1
        L57:
            long r2 = (long) r1
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 >= 0) goto L7a
            java.lang.Object[] r2 = r10.dense
            r2 = r2[r1]
            java.lang.Object r3 = external.sdk.pendo.io.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 != r3) goto L6a
            if (r7 == 0) goto L6a
            java.lang.Object r2 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.getProperty(r7, r1)
        L6a:
            if (r2 != r3) goto L6e
            java.lang.Object r2 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
        L6e:
            boolean r2 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.sameZero(r2, r0)
            if (r2 == 0) goto L77
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            return r7
        L77:
            int r1 = r1 + 1
            goto L57
        L7a:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L7d:
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 >= 0) goto L96
            java.lang.Object r10 = getRawElem(r7, r1)
            java.lang.Object r3 = external.sdk.pendo.io.mozilla.javascript.Scriptable.NOT_FOUND
            if (r10 != r3) goto L8b
            java.lang.Object r10 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
        L8b:
            boolean r10 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.sameZero(r10, r0)
            if (r10 == 0) goto L94
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            return r7
        L94:
            long r1 = r1 + r5
            goto L7d
        L96:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.js_includes(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r9 < 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object js_indexOf(external.sdk.pendo.io.mozilla.javascript.Context r7, external.sdk.pendo.io.mozilla.javascript.Scriptable r8, external.sdk.pendo.io.mozilla.javascript.Scriptable r9, java.lang.Object[] r10) {
        /*
            int r0 = r10.length
            r1 = 0
            if (r0 <= 0) goto L7
            r0 = r10[r1]
            goto L9
        L7:
            java.lang.Object r0 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
        L9:
            external.sdk.pendo.io.mozilla.javascript.Scriptable r8 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toObject(r7, r8, r9)
            long r1 = getLengthProperty(r7, r8, r1)
            int r7 = r10.length
            r9 = 2
            r3 = 1
            r5 = 0
            if (r7 >= r9) goto L1a
            goto L36
        L1a:
            r7 = 1
            r7 = r10[r7]
            double r9 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toInteger(r7)
            long r9 = (long) r9
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2c
            long r9 = r9 + r1
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2c
            goto L2d
        L2c:
            r5 = r9
        L2d:
            long r9 = r1 - r3
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 <= 0) goto L36
            java.lang.Long r7 = external.sdk.pendo.io.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r7
        L36:
            boolean r7 = r8 instanceof external.sdk.pendo.io.mozilla.javascript.NativeArray
            if (r7 == 0) goto L6c
            r7 = r8
            external.sdk.pendo.io.mozilla.javascript.NativeArray r7 = (external.sdk.pendo.io.mozilla.javascript.NativeArray) r7
            boolean r9 = r7.denseOnly
            if (r9 == 0) goto L6c
            external.sdk.pendo.io.mozilla.javascript.Scriptable r8 = r7.getPrototype()
            int r9 = (int) r5
        L46:
            long r3 = (long) r9
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 >= 0) goto L69
            java.lang.Object[] r10 = r7.dense
            r10 = r10[r9]
            java.lang.Object r5 = external.sdk.pendo.io.mozilla.javascript.Scriptable.NOT_FOUND
            if (r10 != r5) goto L59
            if (r8 == 0) goto L59
            java.lang.Object r10 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.getProperty(r8, r9)
        L59:
            if (r10 == r5) goto L66
            boolean r10 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.shallowEq(r10, r0)
            if (r10 == 0) goto L66
            java.lang.Long r7 = java.lang.Long.valueOf(r3)
            return r7
        L66:
            int r9 = r9 + 1
            goto L46
        L69:
            java.lang.Long r7 = external.sdk.pendo.io.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r7
        L6c:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 >= 0) goto L85
            java.lang.Object r7 = getRawElem(r8, r5)
            java.lang.Object r9 = external.sdk.pendo.io.mozilla.javascript.Scriptable.NOT_FOUND
            if (r7 == r9) goto L83
            boolean r7 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.shallowEq(r7, r0)
            if (r7 == 0) goto L83
            java.lang.Long r7 = java.lang.Long.valueOf(r5)
            return r7
        L83:
            long r5 = r5 + r3
            goto L6c
        L85:
            java.lang.Long r7 = external.sdk.pendo.io.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.js_indexOf(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static boolean js_isArray(Object obj) {
        if (obj instanceof Scriptable) {
            return "Array".equals(((Scriptable) obj).getClassName());
        }
        return false;
    }

    private static String js_join(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Object obj2;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        long lengthProperty = getLengthProperty(context, object, false);
        int i2 = (int) lengthProperty;
        if (lengthProperty != i2) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
        }
        String scriptRuntime = (objArr.length < 1 || (obj2 = objArr[0]) == Undefined.instance) ? "," : ScriptRuntime.toString(obj2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                StringBuilder sb = new StringBuilder();
                while (i < i2) {
                    if (i != 0) {
                        sb.append(scriptRuntime);
                    }
                    Object[] objArr2 = nativeArray.dense;
                    if (i < objArr2.length && (obj = objArr2[i]) != null && obj != Undefined.instance && obj != Scriptable.NOT_FOUND) {
                        sb.append(ScriptRuntime.toString(obj));
                    }
                    i++;
                }
                return sb.toString();
            }
        }
        if (i2 == 0) {
            return "";
        }
        String[] strArr = new String[i2];
        int i3 = 0;
        for (int i4 = 0; i4 != i2; i4++) {
            Object elem = getElem(context, object, i4);
            if (elem != null && elem != Undefined.instance) {
                String scriptRuntime2 = ScriptRuntime.toString(elem);
                i3 += scriptRuntime2.length();
                strArr[i4] = scriptRuntime2;
            }
        }
        StringBuilder sb2 = new StringBuilder(i3 + ((i2 - 1) * scriptRuntime.length()));
        while (i != i2) {
            if (i != 0) {
                sb2.append(scriptRuntime);
            }
            String str = strArr[i];
            if (str != null) {
                sb2.append(str);
            }
            i++;
        }
        return sb2.toString();
    }

    private static Object js_lastIndexOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        if (objArr.length < 2) {
            j = lengthProperty - 1;
        } else {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer >= lengthProperty) {
                j = lengthProperty - 1;
            } else {
                if (integer < 0) {
                    integer += lengthProperty;
                }
                j = integer;
            }
            if (j < 0) {
                return NEGATIVE_ONE;
            }
        }
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                for (int i = (int) j; i >= 0; i--) {
                    Object obj2 = nativeArray.dense[i];
                    Object obj3 = Scriptable.NOT_FOUND;
                    if (obj2 == obj3 && prototype != null) {
                        obj2 = ScriptableObject.getProperty(prototype, i);
                    }
                    if (obj2 != obj3 && ScriptRuntime.shallowEq(obj2, obj)) {
                        return Long.valueOf(i);
                    }
                }
                return NEGATIVE_ONE;
            }
        }
        while (j >= 0) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j);
            }
            j--;
        }
        return NEGATIVE_ONE;
    }

    private static Object js_of(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable callConstructorOrCreateArray = callConstructorOrCreateArray(context, scriptable, scriptable2, objArr.length, true);
        for (int i = 0; i < objArr.length; i++) {
            defineElem(context, callConstructorOrCreateArray, i, objArr[i]);
        }
        setLengthProperty(context, callConstructorOrCreateArray, objArr.length);
        return callConstructorOrCreateArray;
    }

    private static Object js_pop(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    int i = (int) j2;
                    Object obj2 = objArr2[i];
                    objArr2[i] = Scriptable.NOT_FOUND;
                    return obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, object, lengthProperty);
            deleteElem(object, lengthProperty);
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, object, lengthProperty);
        return obj;
    }

    private static Object js_push(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                while (i < objArr.length) {
                    Object[] objArr2 = nativeArray.dense;
                    long j = nativeArray.length;
                    nativeArray.length = 1 + j;
                    objArr2[(int) j] = objArr[i];
                    i++;
                }
                return ScriptRuntime.wrapNumber(nativeArray.length);
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        while (i < objArr.length) {
            setElem(context, object, i + lengthProperty, objArr[i]);
            i++;
        }
        return context.getLanguageVersion() == 120 ? objArr.length == 0 ? Undefined.instance : objArr[objArr.length - 1] : setLengthProperty(context, object, lengthProperty + objArr.length);
    }

    private static Scriptable js_reverse(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                for (int i2 = ((int) nativeArray.length) - 1; i < i2; i2--) {
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[i];
                    objArr2[i] = objArr2[i2];
                    objArr2[i2] = obj;
                    i++;
                }
                return object;
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        long j = lengthProperty / 2;
        for (long j2 = 0; j2 < j; j2++) {
            long j3 = (lengthProperty - j2) - 1;
            Object rawElem = getRawElem(object, j2);
            setRawElem(context, object, j2, getRawElem(object, j3));
            setRawElem(context, object, j3, rawElem);
        }
        return object;
    }

    private static Object js_shift(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj2 = objArr2[0];
                    System.arraycopy(objArr2, 1, objArr2, 0, (int) j2);
                    Object[] objArr3 = nativeArray.dense;
                    int i = (int) nativeArray.length;
                    Object obj3 = Scriptable.NOT_FOUND;
                    objArr3[i] = obj3;
                    return obj2 == obj3 ? Undefined.instance : obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, object, 0L);
            if (lengthProperty > 0) {
                for (long j3 = 1; j3 <= lengthProperty; j3++) {
                    setRawElem(context, object, j3 - 1, getRawElem(object, j3));
                }
            }
            deleteElem(object, lengthProperty);
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, object, lengthProperty);
        return obj;
    }

    private static Scriptable js_slice(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long sliceIndex;
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        Scriptable newArray = context.newArray(scriptable, 0);
        long lengthProperty = getLengthProperty(context, object, false);
        if (objArr.length == 0) {
            sliceIndex = 0;
        } else {
            sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
            if (objArr.length != 1 && (obj = objArr[1]) != Undefined.instance) {
                lengthProperty = toSliceIndex(ScriptRuntime.toInteger(obj), lengthProperty);
            }
        }
        for (long j = sliceIndex; j < lengthProperty; j++) {
            Object rawElem = getRawElem(object, j);
            if (rawElem != Scriptable.NOT_FOUND) {
                defineElem(context, newArray, j - sliceIndex, rawElem);
            }
        }
        setLengthProperty(context, newArray, Math.max(0L, lengthProperty - sliceIndex));
        return newArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static external.sdk.pendo.io.mozilla.javascript.Scriptable js_sort(final external.sdk.pendo.io.mozilla.javascript.Context r8, final external.sdk.pendo.io.mozilla.javascript.Scriptable r9, external.sdk.pendo.io.mozilla.javascript.Scriptable r10, java.lang.Object[] r11) {
        /*
            external.sdk.pendo.io.mozilla.javascript.Scriptable r10 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toObject(r8, r9, r10)
            int r0 = r11.length
            r1 = 0
            if (r0 <= 0) goto L27
            java.lang.Object r0 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
            r11 = r11[r1]
            if (r0 == r11) goto L27
            external.sdk.pendo.io.mozilla.javascript.Callable r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.getValueFunctionAndThis(r11, r8)
            external.sdk.pendo.io.mozilla.javascript.Scriptable r7 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r8)
            r11 = 2
            java.lang.Object[] r3 = new java.lang.Object[r11]
            external.sdk.pendo.io.mozilla.javascript.NativeArray$ElementComparator r11 = new external.sdk.pendo.io.mozilla.javascript.NativeArray$ElementComparator
            external.sdk.pendo.io.mozilla.javascript.NativeArray$1 r0 = new external.sdk.pendo.io.mozilla.javascript.NativeArray$1
            r2 = r0
            r5 = r8
            r6 = r9
            r2.<init>()
            r11.<init>(r0)
            goto L29
        L27:
            java.util.Comparator<java.lang.Object> r11 = external.sdk.pendo.io.mozilla.javascript.NativeArray.DEFAULT_COMPARATOR
        L29:
            long r2 = getLengthProperty(r8, r10, r1)
            int r9 = (int) r2
            long r4 = (long) r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L55
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r2 = r1
        L36:
            if (r2 == r9) goto L42
            long r3 = (long) r2
            java.lang.Object r3 = getRawElem(r10, r3)
            r0[r2] = r3
            int r2 = r2 + 1
            goto L36
        L42:
            external.sdk.pendo.io.mozilla.javascript.Sorting r2 = external.sdk.pendo.io.mozilla.javascript.Sorting.get()
            r2.hybridSort(r0, r11)
        L49:
            if (r1 >= r9) goto L54
            long r2 = (long) r1
            r11 = r0[r1]
            setRawElem(r8, r10, r2, r11)
            int r1 = r1 + 1
            goto L49
        L54:
            return r10
        L55:
            java.lang.String r8 = java.lang.String.valueOf(r2)
            java.lang.String r9 = "msg.arraylength.too.big"
            external.sdk.pendo.io.mozilla.javascript.EvaluatorException r8 = external.sdk.pendo.io.mozilla.javascript.Context.reportRuntimeError1(r9, r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.js_sort(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[]):external.sdk.pendo.io.mozilla.javascript.Scriptable");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156 A[LOOP:1: B:42:0x0154->B:43:0x0156, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object js_splice(external.sdk.pendo.io.mozilla.javascript.Context r26, external.sdk.pendo.io.mozilla.javascript.Scriptable r27, external.sdk.pendo.io.mozilla.javascript.Scriptable r28, java.lang.Object[] r29) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.js_splice(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Object js_unshift(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        int i = 0;
        if (object instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) object;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                Object[] objArr2 = nativeArray.dense;
                System.arraycopy(objArr2, 0, objArr2, objArr.length, (int) nativeArray.length);
                while (i < objArr.length) {
                    nativeArray.dense[i] = objArr[i];
                    i++;
                }
                long length = nativeArray.length + objArr.length;
                nativeArray.length = length;
                return ScriptRuntime.wrapNumber(length);
            }
        }
        long lengthProperty = getLengthProperty(context, object, false);
        int length2 = objArr.length;
        if (objArr.length > 0) {
            if (lengthProperty > 0) {
                for (long j = lengthProperty - 1; j >= 0; j--) {
                    setRawElem(context, object, length2 + j, getRawElem(object, j));
                }
            }
            while (i < objArr.length) {
                setElem(context, object, i, objArr[i]);
                i++;
            }
        }
        return setLengthProperty(context, object, lengthProperty + objArr.length);
    }

    private static Object reduceMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = getLengthProperty(context, object, false);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        boolean z = i == 24;
        Object obj2 = objArr.length > 1 ? objArr[1] : Scriptable.NOT_FOUND;
        for (long j = 0; j < lengthProperty; j++) {
            long j2 = z ? j : (lengthProperty - 1) - j;
            Object rawElem = getRawElem(object, j2);
            Object obj3 = Scriptable.NOT_FOUND;
            if (rawElem != obj3) {
                obj2 = obj2 == obj3 ? rawElem : function.call(context, topLevelScope, topLevelScope, new Object[]{obj2, rawElem, Long.valueOf(j2), object});
            }
        }
        if (obj2 != Scriptable.NOT_FOUND) {
            return obj2;
        }
        throw ScriptRuntime.typeError0("msg.empty.array.reduce");
    }

    private static void setElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            ScriptableObject.putProperty(scriptable, Long.toString(j), obj);
        } else {
            ScriptableObject.putProperty(scriptable, (int) j, obj);
        }
    }

    private void setLength(Object obj) {
        if ((this.lengthAttr & 1) != 0) {
            return;
        }
        double number = ScriptRuntime.toNumber(obj);
        long uint32 = ScriptRuntime.toUint32(number);
        double d = uint32;
        if (d != number) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        if (this.denseOnly) {
            long j = this.length;
            if (uint32 < j) {
                Object[] objArr = this.dense;
                Arrays.fill(objArr, (int) uint32, objArr.length, Scriptable.NOT_FOUND);
                this.length = uint32;
                return;
            } else {
                if (uint32 < 1431655764 && d < j * GROW_FACTOR && ensureCapacity((int) uint32)) {
                    this.length = uint32;
                    return;
                }
                this.denseOnly = false;
            }
        }
        long j2 = this.length;
        if (uint32 < j2) {
            if (j2 - uint32 > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                for (Object obj2 : getIds()) {
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (toArrayIndex(str) >= uint32) {
                            delete(str);
                        }
                    } else {
                        int intValue = ((Integer) obj2).intValue();
                        if (intValue >= uint32) {
                            delete(intValue);
                        }
                    }
                }
            } else {
                for (long j3 = uint32; j3 < this.length; j3++) {
                    deleteElem(this, j3);
                }
            }
        }
        this.length = uint32;
    }

    private static Object setLengthProperty(Context context, Scriptable scriptable, long j) {
        Number wrapNumber = ScriptRuntime.wrapNumber(j);
        ScriptableObject.putProperty(scriptable, SentryEnvelopeItemHeader.JsonKeys.LENGTH, wrapNumber);
        return wrapNumber;
    }

    static void setMaximumInitialCapacity(int i) {
        maximumInitialCapacity = i;
    }

    private static void setRawElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (obj == Scriptable.NOT_FOUND) {
            deleteElem(scriptable, j);
        } else {
            setElem(context, scriptable, j, obj);
        }
    }

    private static long toArrayIndex(double d) {
        if (Double.isNaN(d)) {
            return -1L;
        }
        long uint32 = ScriptRuntime.toUint32(d);
        if (uint32 != d || uint32 == BodyPartID.bodyIdMax) {
            return -1L;
        }
        return uint32;
    }

    private static int toDenseIndex(Object obj) {
        long arrayIndex = toArrayIndex(obj);
        if (0 > arrayIndex || arrayIndex >= 2147483647L) {
            return -1;
        }
        return (int) arrayIndex;
    }

    private static long toSliceIndex(double d, long j) {
        if (d < 0.0d) {
            d += j;
            if (d < 0.0d) {
                return 0L;
            }
        } else if (d > j) {
            return j;
        }
        return (long) d;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String toStringHelper(external.sdk.pendo.io.mozilla.javascript.Context r18, external.sdk.pendo.io.mozilla.javascript.Scriptable r19, external.sdk.pendo.io.mozilla.javascript.Scriptable r20, boolean r21, boolean r22) {
        /*
            r1 = r18
            r0 = r19
            external.sdk.pendo.io.mozilla.javascript.Scriptable r2 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toObject(r18, r19, r20)
            r3 = 0
            long r4 = getLengthProperty(r1, r2, r3)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r7 = 256(0x100, float:3.59E-43)
            r6.<init>(r7)
            if (r21 == 0) goto L1e
            r7 = 91
            r6.append(r7)
            java.lang.String r7 = ", "
            goto L20
        L1e:
            java.lang.String r7 = ","
        L20:
            external.sdk.pendo.io.mozilla.javascript.ObjToIntMap r8 = r1.iterating
            if (r8 != 0) goto L30
            external.sdk.pendo.io.mozilla.javascript.ObjToIntMap r8 = new external.sdk.pendo.io.mozilla.javascript.ObjToIntMap
            r10 = 31
            r8.<init>(r10)
            r1.iterating = r8
            r8 = r3
            r10 = 1
            goto L35
        L30:
            boolean r8 = r8.has(r2)
            r10 = r3
        L35:
            r11 = 0
            r12 = 0
            if (r8 != 0) goto Lad
            external.sdk.pendo.io.mozilla.javascript.ObjToIntMap r8 = r1.iterating     // Catch: java.lang.Throwable -> La7
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> La7
            if (r21 == 0) goto L4c
            int r8 = r18.getLanguageVersion()     // Catch: java.lang.Throwable -> La7
            r14 = 150(0x96, float:2.1E-43)
            if (r8 >= r14) goto L4a
            goto L4c
        L4a:
            r8 = r3
            goto L4d
        L4c:
            r8 = 1
        L4d:
            r16 = r3
            r14 = r12
        L50:
            int r17 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r17 >= 0) goto L9f
            int r16 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r16 <= 0) goto L5b
            r6.append(r7)     // Catch: java.lang.Throwable -> La7
        L5b:
            java.lang.Object r3 = getRawElem(r2, r14)     // Catch: java.lang.Throwable -> La7
            java.lang.Object r9 = external.sdk.pendo.io.mozilla.javascript.Scriptable.NOT_FOUND     // Catch: java.lang.Throwable -> La7
            if (r3 == r9) goto L96
            if (r8 == 0) goto L6c
            if (r3 == 0) goto L96
            java.lang.Object r9 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance     // Catch: java.lang.Throwable -> La7
            if (r3 != r9) goto L6c
            goto L96
        L6c:
            if (r21 == 0) goto L73
            java.lang.String r3 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.uneval(r1, r0, r3)     // Catch: java.lang.Throwable -> La7
            goto L90
        L73:
            boolean r9 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> La7
            if (r9 == 0) goto L7a
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> La7
            goto L90
        L7a:
            if (r22 == 0) goto L8c
            java.lang.String r9 = "toLocaleString"
            external.sdk.pendo.io.mozilla.javascript.Callable r3 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.getPropFunctionAndThis(r3, r9, r1, r0)     // Catch: java.lang.Throwable -> La7
            external.sdk.pendo.io.mozilla.javascript.Scriptable r9 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r18)     // Catch: java.lang.Throwable -> La7
            java.lang.Object[] r12 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.emptyArgs     // Catch: java.lang.Throwable -> La7
            java.lang.Object r3 = r3.call(r1, r0, r9, r12)     // Catch: java.lang.Throwable -> La7
        L8c:
            java.lang.String r3 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r3)     // Catch: java.lang.Throwable -> La7
        L90:
            r6.append(r3)     // Catch: java.lang.Throwable -> La7
            r16 = 1
            goto L98
        L96:
            r16 = 0
        L98:
            r12 = 1
            long r14 = r14 + r12
            r3 = 0
            r12 = 0
            goto L50
        L9f:
            external.sdk.pendo.io.mozilla.javascript.ObjToIntMap r0 = r1.iterating     // Catch: java.lang.Throwable -> La7
            r0.remove(r2)     // Catch: java.lang.Throwable -> La7
            r3 = r16
            goto Lb0
        La7:
            r0 = move-exception
            if (r10 == 0) goto Lac
            r1.iterating = r11
        Lac:
            throw r0
        Lad:
            r3 = 0
            r14 = 0
        Lb0:
            if (r10 == 0) goto Lb4
            r1.iterating = r11
        Lb4:
            if (r21 == 0) goto Lc9
            if (r3 != 0) goto Lc4
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto Lc4
            java.lang.String r0 = ", ]"
            r6.append(r0)
            goto Lc9
        Lc4:
            r0 = 93
            r6.append(r0)
        Lc9:
            java.lang.String r0 = r6.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.toStringHelper(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, boolean, boolean):java.lang.String");
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        Object[] objArr = this.dense;
        if (objArr != null) {
            this.dense = null;
            this.denseOnly = false;
            for (int i = 0; i < objArr.length; i++) {
                Object obj2 = objArr[i];
                if (obj2 != Scriptable.NOT_FOUND) {
                    put(i, this, obj2);
                }
            }
        }
        long arrayIndex = toArrayIndex(obj);
        if (arrayIndex >= this.length) {
            this.length = arrayIndex + 1;
        }
        super.defineOwnProperty(context, obj, scriptableObject, z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void delete(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || isSealed() || (!this.denseOnly && isGetterOrSetter(null, i, true))) {
            super.delete(i);
        } else {
            this.dense[i] = Scriptable.NOT_FOUND;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:202)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:100)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public java.lang.Object execIdCall(external.sdk.pendo.io.mozilla.javascript.IdFunctionObject r7, external.sdk.pendo.io.mozilla.javascript.Context r8, external.sdk.pendo.io.mozilla.javascript.Scriptable r9, external.sdk.pendo.io.mozilla.javascript.Scriptable r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.execIdCall(external.sdk.pendo.io.mozilla.javascript.IdFunctionObject, external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = ARRAY_TAG;
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_join, "join", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_reverse, "reverse", 0);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_sort, Constants.SORT, 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_push, "push", 1);
        addIdFunctionProperty(idFunctionObject, obj, -9, "pop", 0);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_shift, "shift", 0);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_unshift, "unshift", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_splice, "splice", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_concat, "concat", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_slice, "slice", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_indexOf, "indexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_lastIndexOf, "lastIndexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_every, "every", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_filter, "filter", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_forEach, "forEach", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_map, "map", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_some, "some", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_find, "find", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_findIndex, "findIndex", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_reduce, "reduce", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_reduceRight, "reduceRight", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isArray, "isArray", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_of, "of", 0);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_from, Constants.MessagePayloadKeys.FROM, 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        return str.equals(SentryEnvelopeItemHeader.JsonKeys.LENGTH) ? IdScriptableObject.instanceIdInfo(this.lengthAttr, 1) : super.findInstanceIdInfo(str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 32 : 0;
    }

    @Override // java.util.List
    public Object get(int i) {
        return get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public int getAttributes(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || objArr[i] == Scriptable.NOT_FOUND) {
            return super.getAttributes(i);
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == ScriptRuntime.NumberClass && Context.getContext().getLanguageVersion() == 120) ? Long.valueOf(this.length) : super.getDefaultValue(cls);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = this.dense;
        if (objArr == null) {
            return ids;
        }
        int length = objArr.length;
        long j = this.length;
        if (length > j) {
            length = (int) j;
        }
        if (length == 0) {
            return ids;
        }
        int length2 = ids.length;
        Object[] objArr2 = new Object[length + length2];
        int i = 0;
        for (int i2 = 0; i2 != length; i2++) {
            if (this.dense[i2] != Scriptable.NOT_FOUND) {
                objArr2[i] = Integer.valueOf(i2);
                i++;
            }
        }
        if (i != length) {
            Object[] objArr3 = new Object[i + length2];
            System.arraycopy(objArr2, 0, objArr3, 0, i);
            objArr2 = objArr3;
        }
        System.arraycopy(ids, 0, objArr2, i, length2);
        return objArr2;
    }

    public List<Integer> getIndexIds() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int int32 = ScriptRuntime.toInt32(obj);
            if (int32 >= 0 && ScriptRuntime.toString(int32).equals(ScriptRuntime.toString(obj))) {
                arrayList.add(Integer.valueOf(int32));
            }
        }
        return arrayList;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        return i == 1 ? SentryEnvelopeItemHeader.JsonKeys.LENGTH : super.getInstanceIdName(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapNumber(this.length) : super.getInstanceIdValue(i);
    }

    public long getLength() {
        return this.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int denseIndex;
        Object obj2;
        if (this.dense != null && (denseIndex = toDenseIndex(obj)) >= 0) {
            Object[] objArr = this.dense;
            if (denseIndex < objArr.length && (obj2 = objArr[denseIndex]) != Scriptable.NOT_FOUND) {
                return defaultIndexPropertyDescriptor(obj2);
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.has(i, scriptable);
        }
        Object[] objArr = this.dense;
        return (objArr == null || i < 0 || i >= objArr.length) ? super.has(i, scriptable) : objArr[i] != Scriptable.NOT_FOUND;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        long j = this.length;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        int i2 = 0;
        if (obj == null) {
            while (i2 < i) {
                if (get(i2) == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < i) {
            if (obj.equals(get(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        if (i == 32) {
            initPrototypeMethod(ARRAY_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        switch (i) {
            case 1:
                str = "constructor";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 2:
                str2 = "toString";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 3:
                str2 = "toLocaleString";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 4:
                str2 = "toSource";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 5:
                str = "join";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 6:
                str2 = "reverse";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 7:
                str = com.facebook.hermes.intl.Constants.SORT;
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 8:
                str = "push";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 9:
                str2 = "pop";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 10:
                str2 = "shift";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 11:
                str = "unshift";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 12:
                str3 = "splice";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 13:
                str = "concat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 14:
                str3 = "slice";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 15:
                str = "indexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 16:
                str = "lastIndexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 17:
                str = "every";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 18:
                str = "filter";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 19:
                str = "forEach";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 20:
                str = "map";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 21:
                str = "some";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 22:
                str = "find";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 23:
                str = "findIndex";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 24:
                str = "reduce";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 25:
                str = "reduceRight";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 26:
                str = "fill";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 27:
                str2 = UserMetadata.KEYDATA_FILENAME;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 28:
                str2 = "values";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 29:
                str2 = RemoteConfigConstants.ResponseFieldKey.ENTRIES;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 30:
                str = "includes";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            case 31:
                str3 = "copyWithin";
                i2 = 2;
                str4 = str3;
                initPrototypeMethod(ARRAY_TAG, i, str4, (String) null, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Deprecated
    public long jsGet_length() {
        return getLength();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        long j = this.length;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i = ((int) j) - 1;
        if (obj == null) {
            while (i >= 0) {
                if (get(i) == null) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        while (i >= 0) {
            if (obj.equals(get(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this && !isSealed() && this.dense != null && i >= 0 && (this.denseOnly || !isGetterOrSetter(null, i, true))) {
            if (!isExtensible() && this.length <= i) {
                return;
            }
            Object[] objArr = this.dense;
            if (i < objArr.length) {
                objArr[i] = obj;
                long j = i;
                if (this.length <= j) {
                    this.length = j + 1;
                    return;
                }
                return;
            }
            if (this.denseOnly && i < objArr.length * GROW_FACTOR && ensureCapacity(i + 1)) {
                this.dense[i] = obj;
                this.length = i + 1;
                return;
            }
            this.denseOnly = false;
        }
        super.put(i, scriptable, obj);
        if (scriptable == this && (this.lengthAttr & 1) == 0) {
            long j2 = i;
            if (this.length <= j2) {
                this.length = j2 + 1;
            }
        }
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    void setDenseOnly(boolean z) {
        if (z && !this.denseOnly) {
            throw new IllegalArgumentException();
        }
        this.denseOnly = z;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lengthAttr = i2;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLength(obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        long j = this.length;
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(ScriptRuntime.emptyArgs);
    }

    public NativeArray(Object[] objArr) {
        this.lengthAttr = 6;
        this.denseOnly = true;
        this.dense = objArr;
        this.length = objArr.length;
    }

    private static long toArrayIndex(Object obj) {
        if (obj instanceof String) {
            return toArrayIndex((String) obj);
        }
        if (obj instanceof Number) {
            return toArrayIndex(((Number) obj).doubleValue());
        }
        return -1L;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013f  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int findPrototypeId(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeArray.findPrototypeId(java.lang.String):int");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.get(i, scriptable);
        }
        Object[] objArr = this.dense;
        return (objArr == null || i < 0 || i >= objArr.length) ? super.get(i, scriptable) : objArr[i];
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        long j = this.length;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i2 = (int) j;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        return new ListIterator(i, i2) { // from class: external.sdk.pendo.io.mozilla.javascript.NativeArray.2
            int cursor;
            final /* synthetic */ int val$len;
            final /* synthetic */ int val$start;

            {
                this.val$start = i;
                this.val$len = i2;
                this.cursor = i;
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.cursor < this.val$len;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.cursor > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                int i3 = this.cursor;
                if (i3 == this.val$len) {
                    throw new NoSuchElementException();
                }
                NativeArray nativeArray = NativeArray.this;
                this.cursor = i3 + 1;
                return nativeArray.get(i3);
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.cursor;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                int i3 = this.cursor;
                if (i3 == 0) {
                    throw new NoSuchElementException();
                }
                NativeArray nativeArray = NativeArray.this;
                int i4 = i3 - 1;
                this.cursor = i4;
                return nativeArray.get(i4);
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.cursor - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
        if (scriptable == this) {
            long arrayIndex = toArrayIndex(str);
            if (arrayIndex >= this.length) {
                this.length = arrayIndex + 1;
                this.denseOnly = false;
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        long j = this.length;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = get(i2);
        }
        return objArr;
    }

    private static long toArrayIndex(String str) {
        long arrayIndex = toArrayIndex(ScriptRuntime.toNumber(str));
        if (Long.toString(arrayIndex).equals(str)) {
            return arrayIndex;
        }
        return -1L;
    }

    public Object get(long j) {
        if (j < 0 || j >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object rawElem = getRawElem(this, j);
        if (rawElem == Scriptable.NOT_FOUND || rawElem == Undefined.instance) {
            return null;
        }
        return rawElem instanceof Wrapper ? ((Wrapper) rawElem).unwrap() : rawElem;
    }
}
