package sdk.pendo.io.y0;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import okhttp3.HttpUrl;

/* loaded from: classes4.dex */
public class a extends ArrayList implements b, d {
    public static String a(Collection collection) {
        StringWriter stringWriter = new StringWriter();
        try {
            a(collection, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // sdk.pendo.io.y0.b
    public String c() {
        return a(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return c();
    }

    @Override // sdk.pendo.io.y0.d
    public void a(Writer writer) {
        a(this, writer);
    }

    public static void a(Collection collection, Writer writer) {
        if (collection == null) {
            writer.write("null");
            return;
        }
        writer.write(91);
        boolean z = true;
        for (Object obj : collection) {
            if (z) {
                z = false;
            } else {
                writer.write(44);
            }
            if (obj == null) {
                writer.write("null");
            } else {
                e.a(obj, writer);
            }
        }
        writer.write(93);
    }

    public static void a(byte[] bArr, Writer writer) {
        String str;
        if (bArr == null) {
            str = "null";
        } else if (bArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            writer.write(String.valueOf((int) bArr[0]));
            for (int i = 1; i < bArr.length; i++) {
                writer.write(",");
                writer.write(String.valueOf((int) bArr[i]));
            }
            str = "]";
        }
        writer.write(str);
    }

    public static void a(char[] cArr, Writer writer) {
        String str;
        if (cArr == null) {
            str = "null";
        } else if (cArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[\"");
            writer.write(e.a(String.valueOf(cArr[0])));
            for (int i = 1; i < cArr.length; i++) {
                writer.write("\",\"");
                writer.write(e.a(String.valueOf(cArr[i])));
            }
            str = "\"]";
        }
        writer.write(str);
    }

    public static void a(double[] dArr, Writer writer) {
        String str;
        if (dArr == null) {
            str = "null";
        } else if (dArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            writer.write(String.valueOf(dArr[0]));
            for (int i = 1; i < dArr.length; i++) {
                writer.write(",");
                writer.write(String.valueOf(dArr[i]));
            }
            str = "]";
        }
        writer.write(str);
    }

    public static void a(float[] fArr, Writer writer) {
        String str;
        if (fArr == null) {
            str = "null";
        } else if (fArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            writer.write(String.valueOf(fArr[0]));
            for (int i = 1; i < fArr.length; i++) {
                writer.write(",");
                writer.write(String.valueOf(fArr[i]));
            }
            str = "]";
        }
        writer.write(str);
    }

    public static void a(int[] iArr, Writer writer) {
        String str;
        if (iArr == null) {
            str = "null";
        } else if (iArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            writer.write(String.valueOf(iArr[0]));
            for (int i = 1; i < iArr.length; i++) {
                writer.write(",");
                writer.write(String.valueOf(iArr[i]));
            }
            str = "]";
        }
        writer.write(str);
    }

    public static void a(long[] jArr, Writer writer) {
        String str;
        if (jArr == null) {
            str = "null";
        } else if (jArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            writer.write(String.valueOf(jArr[0]));
            for (int i = 1; i < jArr.length; i++) {
                writer.write(",");
                writer.write(String.valueOf(jArr[i]));
            }
            str = "]";
        }
        writer.write(str);
    }

    public static void a(Object[] objArr, Writer writer) {
        String str;
        if (objArr == null) {
            str = "null";
        } else if (objArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            e.a(objArr[0], writer);
            for (int i = 1; i < objArr.length; i++) {
                writer.write(",");
                e.a(objArr[i], writer);
            }
            str = "]";
        }
        writer.write(str);
    }

    public static void a(short[] sArr, Writer writer) {
        String str;
        if (sArr == null) {
            str = "null";
        } else if (sArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            writer.write(String.valueOf((int) sArr[0]));
            for (int i = 1; i < sArr.length; i++) {
                writer.write(",");
                writer.write(String.valueOf((int) sArr[i]));
            }
            str = "]";
        }
        writer.write(str);
    }

    public static void a(boolean[] zArr, Writer writer) {
        String str;
        if (zArr == null) {
            str = "null";
        } else if (zArr.length == 0) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else {
            writer.write("[");
            writer.write(String.valueOf(zArr[0]));
            for (int i = 1; i < zArr.length; i++) {
                writer.write(",");
                writer.write(String.valueOf(zArr[i]));
            }
            str = "]";
        }
        writer.write(str);
    }
}
