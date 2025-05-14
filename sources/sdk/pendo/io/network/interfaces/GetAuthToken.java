package sdk.pendo.io.network.interfaces;

import com.amplitude.reactnative.DatabaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import sdk.pendo.io.l0.c;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.y6.r;
import sdk.pendo.io.z6.f;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\bR$\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lsdk/pendo/io/network/interfaces/GetAuthToken;", "", "Lsdk/pendo/io/x5/j;", "Lsdk/pendo/io/y6/r;", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "getAccessTokenSigned", "()Lsdk/pendo/io/x5/j;", "accessTokenSigned", "GetAuthTokenResponse", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface GetAuthToken {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR6\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\n¨\u0006 "}, d2 = {"Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "", "()V", "accessToken", "", "disableAnonVisitorGenerator", "", "getDisableAnonVisitorGenerator", "()Z", "setDisableAnonVisitorGenerator", "(Z)V", "promotedMetadataFields", "", "", "getPromotedMetadataFields", "()Ljava/util/Map;", "setPromotedMetadataFields", "(Ljava/util/Map;)V", "redirectionDatacenter", "getRedirectionDatacenter", "()Ljava/lang/String;", "setRedirectionDatacenter", "(Ljava/lang/String;)V", "redirectionHost", "getRedirectionHost", "setRedirectionHost", "redirectionKey", "getRedirectionKey", "setRedirectionKey", "synchronizedScreenDataScan", "getSynchronizedScreenDataScan", "setSynchronizedScreenDataScan", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetAuthTokenResponse {
        public String accessToken;

        @c("disableMobileGenerateAnonVisitor")
        private boolean disableAnonVisitorGenerator = true;

        @c("promotedMetadataFields")
        private Map<String, ? extends List<String>> promotedMetadataFields;

        @c("datacenter")
        private String redirectionDatacenter;

        @c("host")
        private String redirectionHost;

        @c(DatabaseConstants.KEY_FIELD)
        private String redirectionKey;

        @c("synchronizedScreenDataScan")
        private boolean synchronizedScreenDataScan;

        public final boolean getDisableAnonVisitorGenerator() {
            return this.disableAnonVisitorGenerator;
        }

        public final Map<String, List<String>> getPromotedMetadataFields() {
            return this.promotedMetadataFields;
        }

        public final String getRedirectionDatacenter() {
            return this.redirectionDatacenter;
        }

        public final String getRedirectionHost() {
            return this.redirectionHost;
        }

        public final String getRedirectionKey() {
            return this.redirectionKey;
        }

        public final boolean getSynchronizedScreenDataScan() {
            return this.synchronizedScreenDataScan;
        }

        public final void setDisableAnonVisitorGenerator(boolean z) {
            this.disableAnonVisitorGenerator = z;
        }

        public final void setPromotedMetadataFields(Map<String, ? extends List<String>> map) {
            this.promotedMetadataFields = map;
        }

        public final void setRedirectionDatacenter(String str) {
            this.redirectionDatacenter = str;
        }

        public final void setRedirectionHost(String str) {
            this.redirectionHost = str;
        }

        public final void setRedirectionKey(String str) {
            this.redirectionKey = str;
        }

        public final void setSynchronizedScreenDataScan(boolean z) {
            this.synchronizedScreenDataScan = z;
        }
    }

    @f("v2/devices/getAccessTokenSigned")
    j<r<GetAuthTokenResponse>> getAccessTokenSigned();
}
