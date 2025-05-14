package expo.modules;

import expo.modules.adapters.branch.BranchPackage;
import expo.modules.adapters.react.ReactAdapterPackage;
import expo.modules.application.ApplicationModule;
import expo.modules.barcodescanner.BarCodeScannerModule;
import expo.modules.barcodescanner.BarCodeScannerPackage;
import expo.modules.clipboard.ClipboardModule;
import expo.modules.constants.ConstantsModule;
import expo.modules.constants.ConstantsPackage;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.Package;
import expo.modules.crypto.CryptoModule;
import expo.modules.device.DeviceModule;
import expo.modules.devlauncher.DevLauncherPackage;
import expo.modules.devmenu.DevMenuPackage;
import expo.modules.devmenu.modules.DevMenuModule;
import expo.modules.devmenu.modules.DevMenuPreferences;
import expo.modules.documentpicker.DocumentPickerModule;
import expo.modules.easclient.EASClientModule;
import expo.modules.filesystem.FileSystemModule;
import expo.modules.filesystem.FileSystemPackage;
import expo.modules.font.FontLoaderModule;
import expo.modules.haptics.HapticsModule;
import expo.modules.imageloader.ImageLoaderPackage;
import expo.modules.keepawake.KeepAwakeModule;
import expo.modules.keepawake.KeepAwakePackage;
import expo.modules.kotlin.ModulesProvider;
import expo.modules.kotlin.modules.Module;
import expo.modules.lineargradient.LinearGradientModule;
import expo.modules.localauthentication.LocalAuthenticationModule;
import expo.modules.localization.LocalizationModule;
import expo.modules.localization.LocalizationPackage;
import expo.modules.mailcomposer.MailComposerModule;
import expo.modules.medialibrary.MediaLibraryModule;
import expo.modules.notifications.NotificationsPackage;
import expo.modules.notifications.badge.BadgeModule;
import expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule;
import expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule;
import expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule;
import expo.modules.notifications.notifications.channels.NotificationChannelManagerModule;
import expo.modules.notifications.notifications.emitting.NotificationsEmitter;
import expo.modules.notifications.notifications.handling.NotificationsHandler;
import expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule;
import expo.modules.notifications.notifications.scheduling.NotificationScheduler;
import expo.modules.notifications.permissions.NotificationPermissionsModule;
import expo.modules.notifications.serverregistration.ServerRegistrationModule;
import expo.modules.notifications.tokens.PushTokenModule;
import expo.modules.securestore.SecureStoreModule;
import expo.modules.sharing.SharingModule;
import expo.modules.splashscreen.SplashScreenModule;
import expo.modules.splashscreen.SplashScreenPackage;
import expo.modules.storereview.StoreReviewModule;
import expo.modules.systemui.SystemUIModule;
import expo.modules.systemui.SystemUIPackage;
import expo.modules.updates.UpdatesModule;
import expo.modules.updates.UpdatesPackage;
import expo.modules.webbrowser.WebBrowserModule;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class ExpoModulesPackageList implements ModulesProvider {

    private static class LazyHolder {
        static final List<Package> packagesList = Arrays.asList(new BranchPackage(), new ReactAdapterPackage(), new BarCodeScannerPackage(), new ConstantsPackage(), new BasePackage(), new DevLauncherPackage(), new DevMenuPackage(), new FileSystemPackage(), new ImageLoaderPackage(), new KeepAwakePackage(), new LocalizationPackage(), new NotificationsPackage(), new SplashScreenPackage(), new SystemUIPackage(), new UpdatesPackage());
        static final List<Class<? extends Module>> modulesList = Arrays.asList(ApplicationModule.class, BarCodeScannerModule.class, ClipboardModule.class, ConstantsModule.class, CryptoModule.class, DevMenuModule.class, DevMenuPreferences.class, DeviceModule.class, DocumentPickerModule.class, EASClientModule.class, FileSystemModule.class, FontLoaderModule.class, HapticsModule.class, KeepAwakeModule.class, LinearGradientModule.class, LocalAuthenticationModule.class, LocalizationModule.class, MailComposerModule.class, MediaLibraryModule.class, BadgeModule.class, ExpoBackgroundNotificationTasksModule.class, ExpoNotificationCategoriesModule.class, NotificationChannelGroupManagerModule.class, NotificationChannelManagerModule.class, NotificationsEmitter.class, NotificationsHandler.class, NotificationPermissionsModule.class, ExpoNotificationPresentationModule.class, NotificationScheduler.class, ServerRegistrationModule.class, PushTokenModule.class, SecureStoreModule.class, SharingModule.class, SplashScreenModule.class, StoreReviewModule.class, SystemUIModule.class, UpdatesModule.class, WebBrowserModule.class);

        private LazyHolder() {
        }
    }

    public static List<Package> getPackageList() {
        return LazyHolder.packagesList;
    }

    @Override // expo.modules.kotlin.ModulesProvider
    public List<Class<? extends Module>> getModulesList() {
        return LazyHolder.modulesList;
    }
}
