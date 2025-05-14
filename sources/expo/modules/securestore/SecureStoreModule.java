package expo.modules.securestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.amplitude.reactnative.DatabaseConstants;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.securestore.encryptors.AESEncryptor;
import expo.modules.securestore.encryptors.HybridAESEncryptor;
import expo.modules.securestore.encryptors.KeyBasedEncryptor;
import java.security.KeyStore;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SecureStoreModule.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J#\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJC\u0010\u001b\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001c0!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010$J=\u0010%\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001c0!2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010&JM\u0010'\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001c0!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020#H\u0002¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020+J+\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010-\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J0\u00101\u001a\u00020#2\u0006\u00102\u001a\u0002032\u0006\u0010-\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J3\u00104\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00106\u001a\u00020#H\u0082@ø\u0001\u0000¢\u0006\u0002\u00107R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lexpo/modules/securestore/SecureStoreModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "authenticationHelper", "Lexpo/modules/securestore/AuthenticationHelper;", "hybridAESEncryptor", "Lexpo/modules/securestore/encryptors/HybridAESEncryptor;", "keyStore", "Ljava/security/KeyStore;", "mAESEncryptor", "Lexpo/modules/securestore/encryptors/AESEncryptor;", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "createKeychainAwareKey", "", DatabaseConstants.KEY_FIELD, "keychainService", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "deleteItemImpl", "", "options", "Lexpo/modules/securestore/SecureStoreOptions;", "getItemImpl", "(Ljava/lang/String;Lexpo/modules/securestore/SecureStoreOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKeyEntry", ExifInterface.LONGITUDE_EAST, "Ljava/security/KeyStore$Entry;", "keyStoreEntryClass", "Ljava/lang/Class;", "encryptor", "Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "", "(Ljava/lang/Class;Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;Lexpo/modules/securestore/SecureStoreOptions;Z)Ljava/security/KeyStore$Entry;", "getLegacyKeyEntry", "(Ljava/lang/Class;Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;Lexpo/modules/securestore/SecureStoreOptions;)Ljava/security/KeyStore$Entry;", "getPreferredKeyEntry", SecureStoreModule.USES_KEYSTORE_SUFFIX_PROPERTY, "(Ljava/lang/Class;Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;Lexpo/modules/securestore/SecureStoreOptions;ZZ)Ljava/security/KeyStore$Entry;", "getSharedPreferences", "Landroid/content/SharedPreferences;", "readJSONEncodedItem", "prefs", "(Ljava/lang/String;Landroid/content/SharedPreferences;Lexpo/modules/securestore/SecureStoreOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeKeyFromKeystore", "keyStoreAlias", "saveEncryptedItem", "encryptedItem", "Lorg/json/JSONObject;", "setItemImpl", "value", "keyIsInvalidated", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/securestore/SecureStoreOptions;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo-secure-store_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SecureStoreModule extends Module {
    public static final String AUTHENTICATED_KEYSTORE_SUFFIX = "keystoreAuthenticated";
    public static final String DEFAULT_KEYSTORE_ALIAS = "key_v1";
    private static final String KEYSTORE_ALIAS_PROPERTY = "keystoreAlias";
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String SCHEME_PROPERTY = "scheme";
    private static final String SHARED_PREFERENCES_NAME = "SecureStore";
    public static final String TAG = "ExpoSecureStore";
    public static final String UNAUTHENTICATED_KEYSTORE_SUFFIX = "keystoreUnauthenticated";
    public static final String USES_KEYSTORE_SUFFIX_PROPERTY = "usesKeystoreSuffix";
    private AuthenticationHelper authenticationHelper;
    private HybridAESEncryptor hybridAESEncryptor;
    private KeyStore keyStore;
    private final AESEncryptor mAESEncryptor = new AESEncryptor();

    public Context getReactContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        SecureStoreModule secureStoreModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (secureStoreModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(secureStoreModule);
            moduleDefinitionBuilder.Name(TAG);
            AsyncFunctionBuilder AsyncFunction = moduleDefinitionBuilder.AsyncFunction("setValueWithKeyAsync");
            AsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Coroutine$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Coroutine$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Coroutine$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SecureStoreOptions.class);
                }
            }))}, new SecureStoreModule$definition$lambda$6$$inlined$Coroutine$4(null, this)));
            AsyncFunctionBuilder AsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("getValueWithKeyAsync");
            AsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction2.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Coroutine$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Coroutine$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SecureStoreOptions.class);
                }
            }))}, new SecureStoreModule$definition$lambda$6$$inlined$Coroutine$7(null, this)));
            moduleDefinitionBuilder.getSyncFunctions().put("setValueWithKeySync", new SyncFunctionComponent("setValueWithKeySync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Function$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SecureStoreOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Function$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = (String) it[0];
                    String str2 = (String) it[1];
                    Object obj = it[2];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                    }
                    SecureStoreOptions secureStoreOptions = (SecureStoreOptions) obj;
                    if (str2 != null) {
                        BuildersKt__BuildersKt.runBlocking$default(null, new SecureStoreModule$definition$1$3$1(SecureStoreModule.this, str2, str, secureStoreOptions, null), 1, null);
                        return Unit.INSTANCE;
                    }
                    throw new NullKeyException();
                }
            }));
            moduleDefinitionBuilder.getSyncFunctions().put("getValueWithKeySync", new SyncFunctionComponent("getValueWithKeySync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Function$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SecureStoreOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Function$7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Object runBlocking$default;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new SecureStoreModule$definition$1$4$1(SecureStoreModule.this, str, (SecureStoreOptions) obj2, null), 1, null);
                        return (String) runBlocking$default;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteValueWithKeyAsync", SecureStoreOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deleteValueWithKeyAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        SecureStoreOptions secureStoreOptions = (SecureStoreOptions) promise;
                        try {
                            SecureStoreModule.this.deleteItemImpl(str, secureStoreOptions);
                            return;
                        } catch (CodedException e) {
                            throw e;
                        } catch (Exception e2) {
                            throw new DeleteException(e2.getMessage(), str, secureStoreOptions.getKeychainService(), e2);
                        }
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deleteValueWithKeyAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false, new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SecureStoreOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        SecureStoreOptions secureStoreOptions = (SecureStoreOptions) obj2;
                        try {
                            SecureStoreModule.this.deleteItemImpl(str, secureStoreOptions);
                            return Unit.INSTANCE;
                        } catch (CodedException e) {
                            throw e;
                        } catch (Exception e2) {
                            throw new DeleteException(e2.getMessage(), str, secureStoreOptions.getKeychainService(), e2);
                        }
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$OnCreate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AESEncryptor aESEncryptor;
                    SecureStoreModule.this.authenticationHelper = new AuthenticationHelper(SecureStoreModule.this.getReactContext(), SecureStoreModule.this.getAppContext().getLegacyModuleRegistry());
                    SecureStoreModule secureStoreModule2 = SecureStoreModule.this;
                    Context reactContext = SecureStoreModule.this.getReactContext();
                    aESEncryptor = SecureStoreModule.this.mAESEncryptor;
                    secureStoreModule2.hybridAESEncryptor = new HybridAESEncryptor(reactContext, aESEncryptor);
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    SecureStoreModule secureStoreModule3 = SecureStoreModule.this;
                    Intrinsics.checkNotNullExpressionValue(keyStore, "keyStore");
                    secureStoreModule3.keyStore = keyStore;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getItemImpl(String str, SecureStoreOptions secureStoreOptions, Continuation<? super String> continuation) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences.contains(createKeychainAwareKey(str, secureStoreOptions.getKeychainService()))) {
            return readJSONEncodedItem(str, sharedPreferences, secureStoreOptions, continuation);
        }
        if (sharedPreferences.contains(str)) {
            return readJSONEncodedItem(str, sharedPreferences, secureStoreOptions, continuation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x007e  */
    /* JADX WARN: Type inference failed for: r19v0, types: [expo.modules.securestore.SecureStoreModule] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [expo.modules.securestore.SecureStoreOptions] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Class, java.lang.Class<java.security.KeyStore$SecretKeyEntry>] */
    /* JADX WARN: Type inference failed for: r2v8, types: [expo.modules.securestore.SecureStoreOptions] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readJSONEncodedItem(java.lang.String r20, android.content.SharedPreferences r21, expo.modules.securestore.SecureStoreOptions r22, kotlin.coroutines.Continuation<? super java.lang.String> r23) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.securestore.SecureStoreModule.readJSONEncodedItem(java.lang.String, android.content.SharedPreferences, expo.modules.securestore.SecureStoreOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(2:3|(9:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(4:17|18|19|20))(2:49|(2:51|(2:53|54)(2:55|56))(11:(2:85|86)|58|59|61|62|(3:75|76|77)|64|65|66|67|(1:69)(1:70)))|21|22|(1:24)|32|33))|92|6|7|(0)(0)|21|22|(0)|32|33|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0158, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0159, code lost:
    
        r8 = r2;
        r9 = r3;
        r7 = r4;
        r6 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x018f, code lost:
    
        android.util.Log.w(expo.modules.securestore.SecureStoreModule.TAG, "Key has been invalidated, retrying with the key deleted");
        r13.L$0 = r15;
        r13.L$1 = r15;
        r13.L$2 = r15;
        r13.L$3 = r15;
        r13.L$4 = r15;
        r13.L$5 = r15;
        r13.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01ab, code lost:
    
        if (r6.setItemImpl(r7, r8, r9, true, r13) == r14) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01ad, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01d1, code lost:
    
        throw new expo.modules.securestore.EncryptException("Encryption Failed. The key " + r7 + " has been permanently invalidated and cannot be reinitialized", r7, r9.getKeychainService(), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014a A[Catch: CodedException -> 0x0071, KeyPermanentlyInvalidatedException -> 0x0158, Exception -> 0x0164, GeneralSecurityException -> 0x0176, TRY_LEAVE, TryCatch #3 {KeyPermanentlyInvalidatedException -> 0x0158, blocks: (B:22:0x012c, B:24:0x014a), top: B:21:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setItemImpl(java.lang.String r19, java.lang.String r20, expo.modules.securestore.SecureStoreOptions r21, boolean r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.securestore.SecureStoreModule.setItemImpl(java.lang.String, java.lang.String, expo.modules.securestore.SecureStoreOptions, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean saveEncryptedItem(JSONObject encryptedItem, SharedPreferences prefs, String key, boolean requireAuthentication, String keychainService) {
        encryptedItem.put(USES_KEYSTORE_SUFFIX_PROPERTY, true);
        encryptedItem.put(KEYSTORE_ALIAS_PROPERTY, keychainService);
        encryptedItem.put(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, requireAuthentication);
        String jSONObject = encryptedItem.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "encryptedItem.toString()");
        if (jSONObject.length() == 0) {
            throw new WriteException("Could not JSON-encode the encrypted item for SecureStore - the string " + jSONObject + " is null or empty", key, keychainService, null, 8, null);
        }
        return prefs.edit().putString(key, jSONObject).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteItemImpl(String key, SecureStoreOptions options) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        String createKeychainAwareKey = createKeychainAwareKey(key, options.getKeychainService());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getReactContext());
        boolean commit = sharedPreferences.contains(createKeychainAwareKey) ? sharedPreferences.edit().remove(createKeychainAwareKey).commit() : true;
        if (sharedPreferences.contains(key)) {
            commit = sharedPreferences.edit().remove(key).commit() && commit;
        }
        if (defaultSharedPreferences.contains(key)) {
            commit = defaultSharedPreferences.edit().remove(key).commit() && commit;
        }
        if (!commit) {
            throw new DeleteException("Could not delete the item from SecureStore", key, options.getKeychainService(), null, 8, null);
        }
    }

    private final void removeKeyFromKeystore(String keyStoreAlias, String keychainService) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        Map<String, ?> all = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "sharedPreferences.all");
        KeyStore keyStore = this.keyStore;
        if (keyStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore = null;
        }
        keyStore.deleteEntry(keyStoreAlias);
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String str = value instanceof String ? (String) value : null;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(KEYSTORE_ALIAS_PROPERTY);
                    if (optString != null && jSONObject.optBoolean(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, false) && Intrinsics.areEqual(keychainService, optString)) {
                        sharedPreferences.edit().remove(key).apply();
                        Log.w(TAG, "Removing entry: " + key + " due to the encryption key being deleted");
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    private final <E extends KeyStore.Entry> E getLegacyKeyEntry(Class<E> keyStoreEntryClass, KeyBasedEncryptor<E> encryptor, SecureStoreOptions options) {
        String keyStoreAlias = encryptor.getKeyStoreAlias(options);
        KeyStore keyStore = this.keyStore;
        if (keyStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore = null;
        }
        if (!keyStore.containsAlias(encryptor.getKeyStoreAlias(options))) {
            return null;
        }
        KeyStore keyStore2 = this.keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore2 = null;
        }
        KeyStore.Entry entry = keyStore2.getEntry(keyStoreAlias, null);
        if (keyStoreEntryClass.isInstance(entry)) {
            return keyStoreEntryClass.cast(entry);
        }
        return null;
    }

    private final <E extends KeyStore.Entry> E getKeyEntry(Class<E> keyStoreEntryClass, KeyBasedEncryptor<E> encryptor, SecureStoreOptions options, boolean requireAuthentication) {
        String extendedKeyStoreAlias = encryptor.getExtendedKeyStoreAlias(options, requireAuthentication);
        KeyStore keyStore = this.keyStore;
        KeyStore keyStore2 = null;
        if (keyStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore = null;
        }
        if (!keyStore.containsAlias(extendedKeyStoreAlias)) {
            if (requireAuthentication) {
                AuthenticationHelper authenticationHelper = this.authenticationHelper;
                if (authenticationHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authenticationHelper");
                    authenticationHelper = null;
                }
                authenticationHelper.assertBiometricsSupport();
            }
            KeyStore keyStore3 = this.keyStore;
            if (keyStore3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            } else {
                keyStore2 = keyStore3;
            }
            return encryptor.initializeKeyStoreEntry(keyStore2, options);
        }
        KeyStore keyStore4 = this.keyStore;
        if (keyStore4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore4 = null;
        }
        KeyStore.Entry entry = keyStore4.getEntry(extendedKeyStoreAlias, null);
        if (!keyStoreEntryClass.isInstance(entry)) {
            throw new KeyStoreException("The entry for the keystore alias \"" + extendedKeyStoreAlias + "\" is not a " + keyStoreEntryClass.getSimpleName());
        }
        E cast = keyStoreEntryClass.cast(entry);
        if (cast != null) {
            return cast;
        }
        throw new KeyStoreException("The entry for the keystore alias \"" + extendedKeyStoreAlias + "\" couldn't be cast to correct class");
    }

    private final <E extends KeyStore.Entry> E getPreferredKeyEntry(Class<E> keyStoreEntryClass, KeyBasedEncryptor<E> encryptor, SecureStoreOptions options, boolean requireAuthentication, boolean usesKeystoreSuffix) {
        if (usesKeystoreSuffix) {
            return (E) getKeyEntry(keyStoreEntryClass, encryptor, options, requireAuthentication);
        }
        return (E) getLegacyKeyEntry(keyStoreEntryClass, encryptor, options);
    }

    public final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = getReactContext().getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "reactContext.getSharedPr…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    private final String createKeychainAwareKey(String key, String keychainService) {
        return keychainService + "-" + key;
    }
}
