package external.sdk.pendo.io.mozilla.javascript;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* loaded from: classes2.dex */
public class ImplementationVersion {
    private static final ImplementationVersion version = new ImplementationVersion();
    private String versionString;

    private ImplementationVersion() {
        InputStream openStream;
        Attributes mainAttributes;
        try {
            Enumeration<URL> resources = ImplementationVersion.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                try {
                    openStream = FirebasePerfUrlConnection.openStream(resources.nextElement());
                    try {
                        mainAttributes = new Manifest(openStream).getMainAttributes();
                    } finally {
                    }
                } catch (IOException unused) {
                    continue;
                }
                if ("Mozilla Rhino".equals(mainAttributes.getValue("Implementation-Title"))) {
                    this.versionString = "Rhino " + mainAttributes.getValue("Implementation-Version") + " " + mainAttributes.getValue("Built-Date").replaceAll("-", " ");
                    if (openStream != null) {
                        openStream.close();
                        return;
                    }
                    return;
                }
                if (openStream != null) {
                    openStream.close();
                }
            }
        } catch (IOException unused2) {
        }
    }

    public static String get() {
        return version.versionString;
    }
}
