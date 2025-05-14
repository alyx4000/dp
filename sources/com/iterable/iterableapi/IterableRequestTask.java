package com.iterable.iterableapi;

import android.os.AsyncTask;
import android.os.Handler;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class IterableRequestTask extends AsyncTask<IterableApiRequest, Void, IterableApiResponse> {
    static final String ERROR_CODE_INVALID_JWT_PAYLOAD = "InvalidJwtPayload";
    static final int GET_REQUEST_DEFAULT_TIMEOUT_MS = 10000;
    static final int MAX_RETRY_COUNT = 5;
    static final int POST_REQUEST_DEFAULT_TIMEOUT_MS = 3000;
    static final long RETRY_DELAY_MS = 2000;
    static final String TAG = "IterableRequest";
    static String overrideUrl;
    IterableApiRequest iterableApiRequest;
    int retryCount = 0;

    IterableRequestTask() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public IterableApiResponse doInBackground(IterableApiRequest... iterableApiRequestArr) {
        if (iterableApiRequestArr != null && iterableApiRequestArr.length > 0) {
            this.iterableApiRequest = iterableApiRequestArr[0];
        }
        return executeApiRequest(this.iterableApiRequest);
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x04be, code lost:
    
        if (r8 != null) goto L268;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0259: MOVE (r3 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:265:0x0256 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0261: MOVE (r3 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:261:0x025e */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0269: MOVE (r3 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:259:0x0266 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0271: MOVE (r3 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:263:0x026e */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:285:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0357 A[Catch: ArrayIndexOutOfBoundsException -> 0x0340, IOException -> 0x0343, JSONException -> 0x0346, Exception -> 0x03f7, all -> 0x04c8, TryCatch #5 {Exception -> 0x03f7, blocks: (B:48:0x0357, B:50:0x035f, B:56:0x0367, B:60:0x0375, B:62:0x037d, B:63:0x0388, B:70:0x0393, B:73:0x039b, B:75:0x03b5, B:76:0x03ba, B:78:0x03c3, B:80:0x03c9, B:82:0x03d2, B:84:0x03d9, B:89:0x034c), top: B:88:0x034c }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x047e  */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v31, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v44, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v50 */
    /* JADX WARN: Type inference failed for: r8v51 */
    /* JADX WARN: Type inference failed for: r8v52 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.iterable.iterableapi.IterableApiResponse executeApiRequest(com.iterable.iterableapi.IterableApiRequest r21) {
        /*
            Method dump skipped, instructions count: 1236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iterable.iterableapi.IterableRequestTask.executeApiRequest(com.iterable.iterableapi.IterableApiRequest):com.iterable.iterableapi.IterableApiResponse");
    }

    private static String getBaseUrl() {
        String endpoint = IterableApi.getInstance().config.dataRegion.getEndpoint();
        String str = overrideUrl;
        return (str == null || str.isEmpty()) ? endpoint : overrideUrl;
    }

    private static boolean matchesErrorCode(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return false;
        }
        try {
            if (jSONObject.has(ApiConstant.KEY_CODE)) {
                return jSONObject.getString(ApiConstant.KEY_CODE).equals(str);
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static void logError(IterableApiRequest iterableApiRequest, String str, Exception exc) {
        IterableLogger.e(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nException occurred for : " + str + iterableApiRequest.resourcePath);
        IterableLogger.e(TAG, exc.getMessage(), exc);
    }

    private static String buildHeaderString(HttpURLConnection httpURLConnection) {
        StringBuilder sb = new StringBuilder("\nHeaders { \n");
        for (String str : httpURLConnection.getRequestProperties().keySet()) {
            if (!isSensitive(str)) {
                sb.append(str).append(" : ").append(httpURLConnection.getRequestProperties().get(str)).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static boolean isSensitive(String str) {
        return str.equals(IterableConstants.HEADER_API_KEY) || str.equals("Authorization");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(IterableApiResponse iterableApiResponse) {
        if ((!iterableApiResponse.success && iterableApiResponse.responseCode >= 500) && this.retryCount <= 5) {
            final IterableRequestTask iterableRequestTask = new IterableRequestTask();
            iterableRequestTask.setRetryCount(this.retryCount + 1);
            int i = this.retryCount;
            new Handler().postDelayed(new Runnable() { // from class: com.iterable.iterableapi.IterableRequestTask.1
                @Override // java.lang.Runnable
                public void run() {
                    iterableRequestTask.execute(IterableRequestTask.this.iterableApiRequest);
                }
            }, i > 2 ? i * 2000 : 0L);
            return;
        }
        if (iterableApiResponse.success) {
            IterableApi.getInstance().getAuthManager().resetFailedAuth();
            if (this.iterableApiRequest.successCallback != null) {
                this.iterableApiRequest.successCallback.onSuccess(iterableApiResponse.responseJson);
            }
        } else {
            if (matchesErrorCode(iterableApiResponse.responseJson, ERROR_CODE_INVALID_JWT_PAYLOAD)) {
                IterableApi.getInstance().getAuthManager().requestNewAuthToken(true);
            }
            if (this.iterableApiRequest.failureCallback != null) {
                this.iterableApiRequest.failureCallback.onFailure(iterableApiResponse.errorMessage, iterableApiResponse.responseJson);
            }
        }
        if (this.iterableApiRequest.legacyCallback != null) {
            this.iterableApiRequest.legacyCallback.execute(iterableApiResponse.responseBody);
        }
        super.onPostExecute((IterableRequestTask) iterableApiResponse);
    }

    protected void setRetryCount(int i) {
        this.retryCount = i;
    }
}
