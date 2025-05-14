package sdk.pendo.io.p1;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: classes6.dex */
public enum i {
    GTE(">="),
    LTE("<="),
    EQ("=="),
    TSEQ("==="),
    NE("!="),
    TSNE("!=="),
    LT("<"),
    GT(">"),
    REGEX("=~"),
    NIN("NIN"),
    IN("IN"),
    CONTAINS("CONTAINS"),
    ALL(Rule.ALL),
    SIZE("SIZE"),
    EXISTS("EXISTS"),
    TYPE(CredentialProviderBaseController.TYPE_TAG),
    MATCHES("MATCHES"),
    EMPTY("EMPTY"),
    SUBSETOF("SUBSETOF"),
    ANYOF("ANYOF"),
    NONEOF("NONEOF");

    private final String operatorString;

    i(String str) {
        this.operatorString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }

    public static i a(String str) {
        for (i iVar : values()) {
            if (iVar.operatorString.equals(str.toUpperCase())) {
                return iVar;
            }
        }
        throw new sdk.pendo.io.n1.f("Filter operator " + str + " is not supported!");
    }
}
