package io.branch.referral;

import android.content.Context;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import io.branch.referral.Defines;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.User;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes2.dex */
class ApkParser {
    private static final int endDocTag = 1048833;
    private static final int endTag = 1048835;
    private static final int startTag = 1048834;

    ApkParser() {
    }

    public JSONObject decompressXMLForValidator(byte[] bArr, Context context) {
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int i2;
        int i3;
        String decodeResourceId;
        String decodeResourceId2;
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject4 = new JSONObject();
        int i4 = 36;
        int LEW = (LEW(bArr, 16) * 4) + 36;
        int LEW2 = LEW(bArr, 12);
        int i5 = LEW2;
        while (true) {
            int length = bArr.length - 4;
            i = startTag;
            if (i5 >= length) {
                break;
            }
            if (LEW(bArr, i5) == startTag) {
                LEW2 = i5;
                break;
            }
            i5 += 4;
        }
        String str = "";
        while (true) {
            try {
                if (LEW2 >= bArr.length) {
                    jSONObject2 = jSONObject4;
                    break;
                }
                try {
                    int LEW3 = LEW(bArr, LEW2);
                    if (LEW3 != i) {
                        jSONObject2 = jSONObject4;
                        i2 = i4;
                        if (LEW3 != endTag) {
                            break;
                        }
                        LEW2 += 24;
                    } else {
                        int LEW4 = LEW(bArr, LEW2 + 28);
                        LEW2 += 36;
                        int i6 = 0;
                        while (i6 < LEW4) {
                            int LEW5 = LEW(bArr, LEW2 + 4);
                            int LEW6 = LEW(bArr, LEW2 + 8);
                            int LEW7 = LEW(bArr, LEW2 + 16);
                            int i7 = LEW2 + 20;
                            String compXmlString = compXmlString(bArr, i4, LEW, LEW5);
                            int i8 = LEW4;
                            jSONObject2 = jSONObject4;
                            if ("scheme".equals(compXmlString)) {
                                if (LEW6 != -1) {
                                    try {
                                        decodeResourceId2 = compXmlString(bArr, 36, LEW, LEW6);
                                    } catch (JSONException e) {
                                        e = e;
                                        jSONObject = jSONObject2;
                                        e.printStackTrace();
                                        return jSONObject;
                                    }
                                } else {
                                    decodeResourceId2 = BranchUtil.decodeResourceId(context, LEW7);
                                }
                                if (validURI(decodeResourceId2)) {
                                    if (!jSONObject3.has(decodeResourceId2)) {
                                        jSONObject3.put(decodeResourceId2, new JSONArray());
                                    } else if (jSONObject3.has("0")) {
                                        jSONObject3.put(decodeResourceId2, (JSONArray) jSONObject3.get("0"));
                                        jSONObject3.remove("0");
                                    }
                                    str = decodeResourceId2;
                                }
                                if ("http".equals(decodeResourceId2) || "https".equals(decodeResourceId2)) {
                                    str = decodeResourceId2;
                                }
                            } else if ("host".equals(compXmlString)) {
                                String compXmlString2 = LEW6 != -1 ? compXmlString(bArr, 36, LEW, LEW6) : BranchUtil.decodeResourceId(context, LEW7);
                                if (jSONObject3.has(str) && str != null && !"https".equals(str) && !"http".equals(str)) {
                                    JSONArray jSONArray2 = jSONObject3.getJSONArray(str);
                                    jSONArray2.put(compXmlString2);
                                    jSONObject3.put(str, jSONArray2);
                                } else {
                                    if (!"https".equals(str) && !"http".equals(str)) {
                                        JSONArray jSONArray3 = new JSONArray();
                                        jSONArray3.put(compXmlString2);
                                        jSONObject3.put("0", jSONArray3);
                                    }
                                    jSONArray.put(compXmlString2);
                                }
                            } else if ("name".equals(compXmlString)) {
                                if (LEW6 != -1) {
                                    i3 = 36;
                                    decodeResourceId = compXmlString(bArr, 36, LEW, LEW6);
                                } else {
                                    i3 = 36;
                                    decodeResourceId = BranchUtil.decodeResourceId(context, LEW7);
                                }
                                if ("android.intent.action.VIEW".equals(decodeResourceId)) {
                                    str = null;
                                }
                                i6++;
                                i4 = i3;
                                LEW2 = i7;
                                LEW4 = i8;
                                jSONObject4 = jSONObject2;
                            }
                            i3 = 36;
                            i6++;
                            i4 = i3;
                            LEW2 = i7;
                            LEW4 = i8;
                            jSONObject4 = jSONObject2;
                        }
                        jSONObject2 = jSONObject4;
                        i2 = i4;
                    }
                    i4 = i2;
                    jSONObject4 = jSONObject2;
                    i = startTag;
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject4;
                    jSONObject = jSONObject2;
                    e.printStackTrace();
                    return jSONObject;
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = jSONObject4;
            }
        }
        jSONObject3.remove("0");
        jSONObject = jSONObject2;
        try {
            jSONObject.put(Defines.Jsonkey.URIScheme.getKey(), jSONObject3);
            jSONObject.put(Defines.Jsonkey.AppLinks.getKey(), jSONArray);
        } catch (JSONException e4) {
            e = e4;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    private boolean validURI(String str) {
        return (str == null || "http".equals(str) || str.equals("https") || str.equals(User.JsonKeys.GEO) || str.equals(ProxyConfig.MATCH_ALL_SCHEMES) || str.equals(SentryStackFrame.JsonKeys.PACKAGE) || str.equals("sms") || str.equals("smsto") || str.equals("mms") || str.equals("mmsto") || str.equals("tel") || str.equals("voicemail") || str.equals("file") || str.equals("content") || str.equals("mailto")) ? false : true;
    }

    private String compXmlString(byte[] bArr, int i, int i2, int i3) {
        if (i3 < 0) {
            return null;
        }
        return compXmlStringAt(bArr, i2 + LEW(bArr, i + (i3 * 4)));
    }

    private String compXmlStringAt(byte[] bArr, int i) {
        int i2 = ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i] & UByte.MAX_VALUE);
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i + 2 + (i3 * 2)];
        }
        return new String(bArr2);
    }

    private int LEW(byte[] bArr, int i) {
        return (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 3] << BuiltinOptions.BatchToSpaceNDOptions) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i + 2] << 16) & 16711680) | ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }
}
