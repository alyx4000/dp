package external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScript;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public class SoftCachingModuleScriptProvider extends CachingModuleScriptProviderBase {
    private static final long serialVersionUID = 1;
    private transient ReferenceQueue<Script> scriptRefQueue;
    private transient ConcurrentMap<String, ScriptReference> scripts;

    private static class ScriptReference extends SoftReference<Script> {
        private final URI base;
        private final String moduleId;
        private final URI uri;
        private final Object validator;

        ScriptReference(Script script, String str, URI uri, URI uri2, Object obj, ReferenceQueue<Script> referenceQueue) {
            super(script, referenceQueue);
            this.moduleId = str;
            this.uri = uri;
            this.base = uri2;
            this.validator = obj;
        }

        CachingModuleScriptProviderBase.CachedModuleScript getCachedModuleScript() {
            Script script = get();
            if (script == null) {
                return null;
            }
            return new CachingModuleScriptProviderBase.CachedModuleScript(new ModuleScript(script, this.uri, this.base), this.validator);
        }

        String getModuleId() {
            return this.moduleId;
        }
    }

    public SoftCachingModuleScriptProvider(ModuleSourceProvider moduleSourceProvider) {
        super(moduleSourceProvider);
        this.scriptRefQueue = new ReferenceQueue<>();
        this.scripts = new ConcurrentHashMap(16, 0.75f, CachingModuleScriptProviderBase.getConcurrencyLevel());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.scriptRefQueue = new ReferenceQueue<>();
        this.scripts = new ConcurrentHashMap();
        for (Map.Entry entry : ((Map) objectInputStream.readObject()).entrySet()) {
            CachingModuleScriptProviderBase.CachedModuleScript cachedModuleScript = (CachingModuleScriptProviderBase.CachedModuleScript) entry.getValue();
            putLoadedModule((String) entry.getKey(), cachedModuleScript.getModule(), cachedModuleScript.getValidator());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ScriptReference> entry : this.scripts.entrySet()) {
            CachingModuleScriptProviderBase.CachedModuleScript cachedModuleScript = entry.getValue().getCachedModuleScript();
            if (cachedModuleScript != null) {
                hashMap.put(entry.getKey(), cachedModuleScript);
            }
        }
        objectOutputStream.writeObject(hashMap);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase
    protected CachingModuleScriptProviderBase.CachedModuleScript getLoadedModule(String str) {
        ScriptReference scriptReference = this.scripts.get(str);
        if (scriptReference != null) {
            return scriptReference.getCachedModuleScript();
        }
        return null;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase, external.sdk.pendo.io.mozilla.javascript.commonjs.module.ModuleScriptProvider
    public ModuleScript getModuleScript(Context context, String str, URI uri, URI uri2, Scriptable scriptable) {
        while (true) {
            ScriptReference scriptReference = (ScriptReference) this.scriptRefQueue.poll();
            if (scriptReference == null) {
                return super.getModuleScript(context, str, uri, uri2, scriptable);
            }
            this.scripts.remove(scriptReference.getModuleId(), scriptReference);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase
    protected void putLoadedModule(String str, ModuleScript moduleScript, Object obj) {
        this.scripts.put(str, new ScriptReference(moduleScript.getScript(), str, moduleScript.getUri(), moduleScript.getBase(), obj, this.scriptRefQueue));
    }
}
