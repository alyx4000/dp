package sdk.pendo.io.y0;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(str, sb);
        return sb.toString();
    }

    static void a(String str, StringBuilder sb) {
        String str2;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                str2 = "\\f";
            } else if (charAt == '\r') {
                str2 = "\\r";
            } else if (charAt == '\"') {
                str2 = "\\\"";
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        str2 = "\\b";
                        break;
                    case '\t':
                        str2 = "\\t";
                        break;
                    case '\n':
                        str2 = "\\n";
                        break;
                    default:
                        if ((charAt < 0 || charAt > 31) && ((charAt < 127 || charAt > 159) && (charAt < 8192 || charAt > 8447))) {
                            sb.append(charAt);
                            break;
                        } else {
                            String hexString = Integer.toHexString(charAt);
                            sb.append("\\u");
                            for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                                sb.append('0');
                            }
                            str2 = hexString.toUpperCase();
                            break;
                        }
                }
            } else {
                str2 = "\\\\";
            }
            sb.append(str2);
        }
    }

    public static String a(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            a(obj, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void a(Object obj, Writer writer) {
        if (obj == null) {
            writer.write("null");
            return;
        }
        if (obj instanceof String) {
            writer.write(34);
            writer.write(a((String) obj));
            writer.write(34);
            return;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.isInfinite() || d.isNaN()) {
                writer.write("null");
                return;
            } else {
                writer.write(obj.toString());
                return;
            }
        }
        if (obj instanceof Float) {
            Float f = (Float) obj;
            if (f.isInfinite() || f.isNaN()) {
                writer.write("null");
                return;
            } else {
                writer.write(obj.toString());
                return;
            }
        }
        if (obj instanceof Number) {
            writer.write(obj.toString());
            return;
        }
        if (obj instanceof Boolean) {
            writer.write(obj.toString());
            return;
        }
        if (obj instanceof d) {
            ((d) obj).a(writer);
            return;
        }
        if (obj instanceof b) {
            writer.write(((b) obj).c());
            return;
        }
        if (obj instanceof Map) {
            c.a((Map) obj, writer);
            return;
        }
        if (obj instanceof Collection) {
            a.a((Collection) obj, writer);
            return;
        }
        if (obj instanceof byte[]) {
            a.a((byte[]) obj, writer);
            return;
        }
        if (obj instanceof short[]) {
            a.a((short[]) obj, writer);
            return;
        }
        if (obj instanceof int[]) {
            a.a((int[]) obj, writer);
            return;
        }
        if (obj instanceof long[]) {
            a.a((long[]) obj, writer);
            return;
        }
        if (obj instanceof float[]) {
            a.a((float[]) obj, writer);
            return;
        }
        if (obj instanceof double[]) {
            a.a((double[]) obj, writer);
            return;
        }
        if (obj instanceof boolean[]) {
            a.a((boolean[]) obj, writer);
            return;
        }
        if (obj instanceof char[]) {
            a.a((char[]) obj, writer);
        } else if (obj instanceof Object[]) {
            a.a((Object[]) obj, writer);
        } else {
            a(obj.toString(), writer);
        }
    }
}
