package sdk.pendo.io.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class c extends BufferedReader {
    public c(Reader reader) {
        super(reader);
    }

    private b b(String str) {
        String readLine;
        String str2 = "-----END " + str;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = readLine();
            if (readLine == null) {
                break;
            }
            int indexOf = readLine.indexOf(58);
            if (indexOf >= 0) {
                arrayList.add(new a(readLine.substring(0, indexOf), readLine.substring(indexOf + 1).trim()));
            } else {
                if (readLine.indexOf(str2) != -1) {
                    break;
                }
                stringBuffer.append(readLine.trim());
            }
        }
        if (readLine != null) {
            return new b(str, arrayList, sdk.pendo.io.e5.a.a(stringBuffer.toString()));
        }
        throw new IOException(str2 + " not found");
    }

    public b a() {
        String readLine;
        String substring;
        int indexOf;
        do {
            readLine = readLine();
            if (readLine == null) {
                break;
            }
        } while (!readLine.startsWith("-----BEGIN "));
        if (readLine == null || (indexOf = (substring = readLine.substring(11)).indexOf(45)) <= 0 || !substring.endsWith("-----") || substring.length() - indexOf != 5) {
            return null;
        }
        return b(substring.substring(0, indexOf));
    }
}
