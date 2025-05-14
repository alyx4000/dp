package expo.modules.core.interfaces;

/* loaded from: classes3.dex */
public interface RuntimeEnvironmentInterface {

    public interface PlatformVersion {
        int major();

        int minor();

        int patch();

        String prerelease();
    }

    String platformName();

    PlatformVersion platformVersion();
}
