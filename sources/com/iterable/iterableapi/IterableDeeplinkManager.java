package com.iterable.iterableapi;

import android.os.AsyncTask;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iterable.iterableapi.IterableHelper;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
class IterableDeeplinkManager {
    private static Pattern deeplinkPattern = Pattern.compile(IterableConstants.ITBL_DEEPLINK_IDENTIFIER);

    IterableDeeplinkManager() {
    }

    static void getAndTrackDeeplink(String str, IterableHelper.IterableActionHandler iterableActionHandler) {
        if (str != null) {
            if (IterableUtil.isUrlOpenAllowed(str)) {
                if (isIterableDeeplink(str)) {
                    new RedirectTask(iterableActionHandler).execute(str);
                    return;
                } else {
                    iterableActionHandler.execute(str);
                    return;
                }
            }
            return;
        }
        iterableActionHandler.execute(null);
    }

    static boolean isIterableDeeplink(String str) {
        return str != null && deeplinkPattern.matcher(str).find();
    }

    private static class RedirectTask extends AsyncTask<String, Void, String> {
        static final int DEFAULT_TIMEOUT_MS = 3000;
        static final String TAG = "RedirectTask";
        private IterableHelper.IterableActionHandler callback;
        public int campaignId;
        public String messageId;
        public int templateId;

        RedirectTask(IterableHelper.IterableActionHandler iterableActionHandler) {
            this.callback = iterableActionHandler;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2 = null;
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            String str = strArr[0];
            try {
                try {
                    httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                try {
                    httpURLConnection.setReadTimeout(3000);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 400) {
                        IterableLogger.d(TAG, "Invalid Request for: " + str + ", returned code " + responseCode);
                    } else if (responseCode >= 300) {
                        str = httpURLConnection.getHeaderField("Location");
                        try {
                            List<String> list = httpURLConnection.getHeaderFields().get("Set-Cookie");
                            if (list != null) {
                                ArrayList arrayList = new ArrayList(list.size());
                                Iterator<String> it = list.iterator();
                                while (it.hasNext()) {
                                    List<HttpCookie> parse = HttpCookie.parse(it.next());
                                    if (parse != null) {
                                        arrayList.addAll(parse);
                                    }
                                }
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    HttpCookie httpCookie = (HttpCookie) it2.next();
                                    if (httpCookie.getName().equals("iterableEmailCampaignId")) {
                                        this.campaignId = Integer.parseInt(httpCookie.getValue());
                                    } else if (httpCookie.getName().equals("iterableTemplateId")) {
                                        this.templateId = Integer.parseInt(httpCookie.getValue());
                                    } else if (httpCookie.getName().equals("iterableMessageId")) {
                                        this.messageId = httpCookie.getValue();
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            IterableLogger.e(TAG, "Error while parsing cookies: " + e2.getMessage());
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                httpURLConnection2 = httpURLConnection;
                IterableLogger.e(TAG, e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return str;
            }
            return str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            IterableHelper.IterableActionHandler iterableActionHandler = this.callback;
            if (iterableActionHandler != null) {
                iterableActionHandler.execute(str);
            }
            if (this.campaignId != 0) {
                IterableApi.sharedInstance.setAttributionInfo(new IterableAttributionInfo(this.campaignId, this.templateId, this.messageId));
            }
        }
    }
}
