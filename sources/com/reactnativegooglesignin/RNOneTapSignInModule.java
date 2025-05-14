package com.reactnativegooglesignin;

import android.app.Activity;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.NoCredentialException;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: RNOneTapSignInModule.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/reactnativegooglesignin/RNOneTapSignInModule;", "Lcom/reactnativegooglesignin/NativeOneTapSignInSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "credentialManager", "Landroidx/credentials/CredentialManager;", "buildOneTapSignInRequest", "Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "params", "Lcom/facebook/react/bridge/ReadableMap;", "handleSignInError", "", "e", "Landroidx/credentials/exceptions/GetCredentialException;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "handleSignInSuccess", "result", "Landroidx/credentials/GetCredentialResponse;", "signIn", "signOut", "Companion", "react-native-google-signin_google-signin_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RNOneTapSignInModule extends NativeOneTapSignInSpec {
    public static final String NO_SAVED_CREDENTIAL_FOUND = "NO_SAVED_CREDENTIAL_FOUND";
    public static final String ONE_TAP_START_FAILED = "ONE_TAP_START_FAILED";
    private final CredentialManager credentialManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNOneTapSignInModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        CredentialManager.Companion companion = CredentialManager.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
        this.credentialManager = companion.create(reactApplicationContext);
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void signIn(ReadableMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            RNGoogleSigninModule.rejectWithNullActivity(promise);
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RNOneTapSignInModule$signIn$1(this, currentActivity, new GetCredentialRequest.Builder().addCredentialOption(buildOneTapSignInRequest(params)).build(), promise, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSignInError(GetCredentialException e, Promise promise) {
        if (e instanceof GetCredentialCancellationException) {
            promise.reject("12501", e.getMessage(), e);
            return;
        }
        if (e instanceof NoCredentialException) {
            String message = e.getMessage();
            if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "too many canceled sign-in prompts", false, 2, (Object) null)) {
                promise.reject(ONE_TAP_START_FAILED, e.getMessage(), e);
                return;
            }
            String message2 = e.getMessage();
            if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "Cannot find a matching credential", false, 2, (Object) null)) {
                promise.reject(NO_SAVED_CREDENTIAL_FOUND, e.getMessage(), e);
                return;
            } else {
                promise.reject(e.getType(), e.getMessage(), e);
                return;
            }
        }
        promise.reject(e.getType(), e.getMessage(), e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSignInSuccess(GetCredentialResponse result, Promise promise) {
        Credential credential = result.getCredential();
        if (credential instanceof CustomCredential) {
            if (Intrinsics.areEqual(credential.getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
                try {
                    promise.resolve(Utils.getUserProperties(GoogleIdTokenCredential.INSTANCE.createFrom(credential.getData())));
                    return;
                } catch (GoogleIdTokenParsingException e) {
                    promise.reject(NativeOneTapSignInSpec.NAME, e);
                    return;
                }
            }
            promise.reject(NativeOneTapSignInSpec.NAME, "Unexpected type of custom credential");
            return;
        }
        promise.reject(NativeOneTapSignInSpec.NAME, "Unexpected type of credential");
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void signOut(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RNOneTapSignInModule$signOut$1(this, promise, null), 3, null);
    }

    private final GetGoogleIdOption buildOneTapSignInRequest(ReadableMap params) {
        String string = params.getString("webClientId");
        Intrinsics.checkNotNull(string);
        String string2 = params.getString("nonce");
        return new GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(params.getBoolean("filterByAuthorizedAccounts")).setServerClientId(string).setNonce(string2).setAutoSelectEnabled(params.getBoolean("autoSignIn")).build();
    }
}
