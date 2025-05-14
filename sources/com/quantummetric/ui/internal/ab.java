package com.quantummetric.ui.internal;

import android.util.Base64;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;

/* loaded from: classes5.dex */
final class ab {
    private static final byte[] b;
    private static final IvParameterSpec c;
    private static boolean g;
    private static boolean h;

    /* renamed from: a, reason: collision with root package name */
    private static final OAEPParameterSpec f22a = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
    private static String d = "";
    private static String e = "";
    private static Cipher f = null;

    static {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        b = bArr;
        c = new IvParameterSpec(bArr);
    }

    static String a(String str) {
        return a(str, f);
    }

    static String a(String str, Cipher cipher) {
        return !de.b(str) ? y.i ? a(str.getBytes(StandardCharsets.UTF_16BE), cipher) : a(str.getBytes(), cipher) : "";
    }

    private static String a(byte[] bArr, Cipher cipher) {
        byte[] bArr2 = new byte[0];
        if (cipher != null) {
            try {
                bArr2 = cipher.doFinal(bArr);
            } catch (Exception unused) {
            }
        }
        if (bArr2.length == 0) {
            int length = bArr.length;
        }
        return Base64.encodeToString(bArr2, 2);
    }

    static void a(y yVar) {
        d = yVar.d();
        if (!h) {
            b();
            g = true;
        }
        h = !de.b(d);
    }

    static boolean a() {
        return f != null;
    }

    static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    static synchronized void b() {
        synchronized (ab.class) {
            if (g) {
                g = false;
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(new String(Base64.decode(d, 2)));
                if (jSONArray.length() >= 2) {
                    PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, Base64.decode(jSONArray.getString(0), 2)), new BigInteger(1, Base64.decode(jSONArray.getString(1), 2))));
                    byte[] bArr = new byte[32];
                    new SecureRandom().nextBytes(bArr);
                    Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPPadding");
                    cipher.init(1, generatePublic, f22a);
                    byte[] doFinal = cipher.doFinal(bArr);
                    Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher2.init(1, new SecretKeySpec(bArr, "AES"), c);
                    e = Base64.encodeToString(doFinal, 2);
                    if (y.i) {
                        e = "v2:" + e;
                    }
                    f = cipher2;
                }
            } catch (Exception unused) {
            }
        }
    }

    static String c() {
        return e;
    }

    static Cipher d() {
        return f;
    }
}
