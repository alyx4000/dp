package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import java.io.InputStream;
import java.nio.charset.Charset;

@Deprecated
/* loaded from: classes2.dex */
public class ShellLine {
    @Deprecated
    public static InputStream getStream(Scriptable scriptable) {
        ShellConsole console = ShellConsole.getConsole(scriptable, Charset.defaultCharset());
        if (console != null) {
            return console.getIn();
        }
        return null;
    }
}
