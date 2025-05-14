package okhttp3.internal.http;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;
import okhttp3.Interceptor;

/* compiled from: CallServerInterceptor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", ApiConstant.KEY_CODE, "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    private final boolean shouldIgnoreAndWaitForRealResponse(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e2 A[Catch: IOException -> 0x01a0, TryCatch #1 {IOException -> 0x01a0, blocks: (B:64:0x00ab, B:66:0x00b4, B:22:0x00b8, B:24:0x00e2, B:26:0x00eb, B:27:0x00ee, B:28:0x0112, B:32:0x011d, B:33:0x013c, B:35:0x014a, B:43:0x0160, B:48:0x0173, B:51:0x0193, B:52:0x019e, B:59:0x018b, B:60:0x0169, B:61:0x0155, B:62:0x012c), top: B:63:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0173 A[Catch: IOException -> 0x01a0, TryCatch #1 {IOException -> 0x01a0, blocks: (B:64:0x00ab, B:66:0x00b4, B:22:0x00b8, B:24:0x00e2, B:26:0x00eb, B:27:0x00ee, B:28:0x0112, B:32:0x011d, B:33:0x013c, B:35:0x014a, B:43:0x0160, B:48:0x0173, B:51:0x0193, B:52:0x019e, B:59:0x018b, B:60:0x0169, B:61:0x0155, B:62:0x012c), top: B:63:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0169 A[Catch: IOException -> 0x01a0, TryCatch #1 {IOException -> 0x01a0, blocks: (B:64:0x00ab, B:66:0x00b4, B:22:0x00b8, B:24:0x00e2, B:26:0x00eb, B:27:0x00ee, B:28:0x0112, B:32:0x011d, B:33:0x013c, B:35:0x014a, B:43:0x0160, B:48:0x0173, B:51:0x0193, B:52:0x019e, B:59:0x018b, B:60:0x0169, B:61:0x0155, B:62:0x012c), top: B:63:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v21, types: [okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
