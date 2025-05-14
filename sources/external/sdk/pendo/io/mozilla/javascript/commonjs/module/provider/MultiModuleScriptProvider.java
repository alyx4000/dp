package external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScript;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScriptProvider;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class MultiModuleScriptProvider implements ModuleScriptProvider {
    private final ModuleScriptProvider[] providers;

    public MultiModuleScriptProvider(Iterable<? extends ModuleScriptProvider> iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator<? extends ModuleScriptProvider> it = iterable.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next());
        }
        this.providers = (ModuleScriptProvider[]) linkedList.toArray(new ModuleScriptProvider[linkedList.size()]);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScriptProvider
    public ModuleScript getModuleScript(Context context, String str, URI uri, URI uri2, Scriptable scriptable) {
        for (ModuleScriptProvider moduleScriptProvider : this.providers) {
            ModuleScript moduleScript = moduleScriptProvider.getModuleScript(context, str, uri, uri2, scriptable);
            if (moduleScript != null) {
                return moduleScript;
            }
        }
        return null;
    }
}
