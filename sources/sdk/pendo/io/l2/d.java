package sdk.pendo.io.l2;

import com.facebook.common.callercontext.ContextChain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\u0006\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0003\u0010\nR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR(\u0010'\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b!\u0010\"\u0012\u0004\b&\u0010\u0010\u001a\u0004\b\f\u0010#\"\u0004\b$\u0010%R\"\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\nR\"\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\"\u00103\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R\"\u00107\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0006\u001a\u0004\b5\u0010\b\"\u0004\b6\u0010\nR\"\u0010;\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0006\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\nR\"\u0010C\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lsdk/pendo/io/l2/d;", "", "Lsdk/pendo/io/l2/f;", "a", "()Lsdk/pendo/io/l2/f;", "", "Z", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "encodeDefaults", "b", "getExplicitNulls", "setExplicitNulls", "getExplicitNulls$annotations", "()V", "explicitNulls", "c", "getIgnoreUnknownKeys", "ignoreUnknownKeys", "d", "isLenient", "setLenient", "e", "getAllowStructuredMapKeys", "setAllowStructuredMapKeys", "allowStructuredMapKeys", "f", "getPrettyPrint", "setPrettyPrint", "prettyPrint", "", "g", "Ljava/lang/String;", "()Ljava/lang/String;", "setPrettyPrintIndent", "(Ljava/lang/String;)V", "getPrettyPrintIndent$annotations", "prettyPrintIndent", "h", "getCoerceInputValues", "setCoerceInputValues", "coerceInputValues", ContextChain.TAG_INFRA, "getUseArrayPolymorphism", "setUseArrayPolymorphism", "useArrayPolymorphism", "j", "getClassDiscriminator", "setClassDiscriminator", "classDiscriminator", "k", "getAllowSpecialFloatingPointValues", "setAllowSpecialFloatingPointValues", "allowSpecialFloatingPointValues", "l", "getUseAlternativeNames", "setUseAlternativeNames", "useAlternativeNames", "Lsdk/pendo/io/n2/c;", "m", "Lsdk/pendo/io/n2/c;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "serializersModule", "Lsdk/pendo/io/l2/a;", "json", "<init>", "(Lkotlinx/serialization/json/Json;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean encodeDefaults;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean explicitNulls;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean ignoreUnknownKeys;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isLenient;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean allowStructuredMapKeys;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean prettyPrint;

    /* renamed from: g, reason: from kotlin metadata */
    private String prettyPrintIndent;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean coerceInputValues;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean useArrayPolymorphism;

    /* renamed from: j, reason: from kotlin metadata */
    private String classDiscriminator;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean allowSpecialFloatingPointValues;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean useAlternativeNames;

    /* renamed from: m, reason: from kotlin metadata */
    private sdk.pendo.io.n2.c serializersModule;

    public d(a json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.encodeDefaults = json.getConfiguration().getEncodeDefaults();
        this.explicitNulls = json.getConfiguration().getExplicitNulls();
        this.ignoreUnknownKeys = json.getConfiguration().getIgnoreUnknownKeys();
        this.isLenient = json.getConfiguration().getIsLenient();
        this.allowStructuredMapKeys = json.getConfiguration().getAllowStructuredMapKeys();
        this.prettyPrint = json.getConfiguration().getPrettyPrint();
        this.prettyPrintIndent = json.getConfiguration().getPrettyPrintIndent();
        this.coerceInputValues = json.getConfiguration().getCoerceInputValues();
        this.useArrayPolymorphism = json.getConfiguration().getUseArrayPolymorphism();
        this.classDiscriminator = json.getConfiguration().getClassDiscriminator();
        this.allowSpecialFloatingPointValues = json.getConfiguration().getAllowSpecialFloatingPointValues();
        this.useAlternativeNames = json.getConfiguration().getUseAlternativeNames();
        this.serializersModule = json.getSerializersModule();
    }

    public final f a() {
        if (this.useArrayPolymorphism && !Intrinsics.areEqual(this.classDiscriminator, "type")) {
            throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
        }
        if (this.prettyPrint) {
            if (!Intrinsics.areEqual(this.prettyPrintIndent, "    ")) {
                String str = this.prettyPrintIndent;
                boolean z = false;
                int i = 0;
                while (true) {
                    boolean z2 = true;
                    if (i >= str.length()) {
                        z = true;
                        break;
                    }
                    char charAt = str.charAt(i);
                    i++;
                    if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                        z2 = false;
                    }
                }
                if (!z) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had ", getPrettyPrintIndent()).toString());
                }
            }
        } else if (!Intrinsics.areEqual(this.prettyPrintIndent, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
        }
        return new f(this.encodeDefaults, this.ignoreUnknownKeys, this.isLenient, this.allowStructuredMapKeys, this.prettyPrint, this.explicitNulls, this.prettyPrintIndent, this.coerceInputValues, this.useArrayPolymorphism, this.classDiscriminator, this.allowSpecialFloatingPointValues, this.useAlternativeNames);
    }

    /* renamed from: b, reason: from getter */
    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    /* renamed from: c, reason: from getter */
    public final sdk.pendo.io.n2.c getSerializersModule() {
        return this.serializersModule;
    }

    public final void a(boolean z) {
        this.ignoreUnknownKeys = z;
    }
}
