package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.RNAppleAuthentication.AppleAuthenticationAndroidPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.amplitude.reactnative.AmplitudeReactNativePackage;
import com.extole.android.sdk.ExtoleMobileSdkPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.horcrux.svg.SvgPackage;
import com.iterable.reactnative.RNIterableAPIPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.quantummetric.reactnative.QuantumMetricLibraryPackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactnativecastle.CastlePackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.clipboard.ClipboardPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.picker.RNCPickerPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativedevicerisk.DeviceRiskPackage;
import com.reactnativegooglesignin.RNGoogleSigninPackage;
import com.reactnativemmkv.MmkvPackage;
import com.reactnativerestart.RestartPackage;
import com.reactnativethemis.ThemisPackage;
import com.socure.docv.reactnative.SocureDocVReactNativePackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import expo.modules.ExpoModulesPackage;
import io.branch.rnbranch.RNBranchPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.config.ReactNativeFirebaseConfigPackage;
import io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsPackage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingPackage;
import io.invertase.firebase.perf.ReactNativeFirebasePerfPackage;
import io.sentry.react.RNSentryPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.linusu.RNGetRandomValuesPackage;
import pendo.io.reactnative.ReactNativePendoPackage;
import support.ada.embed.AdaPackage;

/* loaded from: classes3.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new AdaPackage(), new AmplitudeReactNativePackage(), new CastlePackage(), new ExtoleMobileSdkPackage(), new AppleAuthenticationAndroidPackage(), new RNIterableAPIPackage(), new AsyncStoragePackage(), new ClipboardPackage(), new RNDateTimePickerPackage(), new NetInfoPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseCrashlyticsPackage(), new ReactNativeFirebaseMessagingPackage(), new ReactNativeFirebasePerfPackage(), new ReactNativeFirebaseConfigPackage(), new RNGoogleSigninPackage(), new RNCPickerPackage(), new RNSentryPackage(), new SocureDocVReactNativePackage(), new ExpoModulesPackage(), new LottiePackage(), new RNBranchPackage(), new RNDeviceInfo(), new DeviceRiskPackage(), new RNGestureHandlerPackage(), new RNGetRandomValuesPackage(), new MmkvPackage(), new QuantumMetricLibraryPackage(), new ReanimatedPackage(), new RestartPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new SvgPackage(), new ThemisPackage(), new RNCWebViewPackage(), new ReactNativePendoPackage()));
    }
}
