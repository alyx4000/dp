package external.sdk.pendo.io.mozilla.javascript.json;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class JsonParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Context cx;
    private int length;
    private int pos;
    private Scriptable scope;
    private String src;

    public static class ParseException extends Exception {
        private static final long serialVersionUID = 4804542791749920772L;

        ParseException(Exception exc) {
            super(exc);
        }

        ParseException(String str) {
            super(str);
        }
    }

    public JsonParser(Context context, Scriptable scriptable) {
        this.cx = context;
        this.scope = scriptable;
    }

    private void consume(char c) {
        consumeWhitespace();
        int i = this.pos;
        if (i >= this.length) {
            throw new ParseException("Expected " + c + " but reached end of stream");
        }
        String str = this.src;
        this.pos = i + 1;
        char charAt = str.charAt(i);
        if (charAt != c) {
            throw new ParseException("Expected " + c + " found " + charAt);
        }
    }

    private void consumeWhitespace() {
        while (true) {
            int i = this.pos;
            if (i >= this.length) {
                return;
            }
            char charAt = this.src.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                return;
            } else {
                this.pos++;
            }
        }
    }

    private static int fromHex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if (c < 'A' || c > 'F') {
            c2 = 'a';
            if (c < 'a' || c > 'f') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    private char nextOrNumberError(int i) {
        int i2 = this.pos;
        int i3 = this.length;
        if (i2 >= i3) {
            throw numberError(i, i3);
        }
        String str = this.src;
        this.pos = i2 + 1;
        return str.charAt(i2);
    }

    private ParseException numberError(int i, int i2) {
        return new ParseException("Unsupported number format: " + this.src.substring(i, i2));
    }

    private Object readArray() {
        consumeWhitespace();
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == ']') {
            this.pos++;
            return this.cx.newArray(this.scope, 0);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length) {
                throw new ParseException("Unterminated array literal");
            }
            char charAt = this.src.charAt(i2);
            if (charAt != ',') {
                if (charAt == ']') {
                    if (!z) {
                        throw new ParseException("Unexpected comma in array literal");
                    }
                    this.pos++;
                    return this.cx.newArray(this.scope, arrayList.toArray());
                }
                if (z) {
                    throw new ParseException("Missing comma in array literal");
                }
                arrayList.add(readValue());
                z = true;
            } else {
                if (!z) {
                    throw new ParseException("Unexpected comma in array literal");
                }
                this.pos++;
                z = false;
            }
            consumeWhitespace();
        }
    }

    private void readDigits() {
        char charAt;
        while (true) {
            int i = this.pos;
            if (i >= this.length || (charAt = this.src.charAt(i)) < '0' || charAt > '9') {
                return;
            } else {
                this.pos++;
            }
        }
    }

    private Boolean readFalse() {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 4 || this.src.charAt(i2) != 'a' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 's' || this.src.charAt(this.pos + 3) != 'e') {
            throw new ParseException("Unexpected token: f");
        }
        this.pos += 4;
        return Boolean.FALSE;
    }

    private Object readNull() {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 3 || this.src.charAt(i2) != 'u' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 'l') {
            throw new ParseException("Unexpected token: n");
        }
        this.pos += 3;
        return null;
    }

    private Number readNumber(char c) {
        char charAt;
        int i = this.pos - 1;
        if (c == '-' && ((c = nextOrNumberError(i)) < '0' || c > '9')) {
            throw numberError(i, this.pos);
        }
        if (c != '0') {
            readDigits();
        }
        int i2 = this.pos;
        if (i2 < this.length && this.src.charAt(i2) == '.') {
            this.pos++;
            char nextOrNumberError = nextOrNumberError(i);
            if (nextOrNumberError < '0' || nextOrNumberError > '9') {
                throw numberError(i, this.pos);
            }
            readDigits();
        }
        int i3 = this.pos;
        if (i3 < this.length && ((charAt = this.src.charAt(i3)) == 'e' || charAt == 'E')) {
            this.pos++;
            char nextOrNumberError2 = nextOrNumberError(i);
            if (nextOrNumberError2 == '-' || nextOrNumberError2 == '+') {
                nextOrNumberError2 = nextOrNumberError(i);
            }
            if (nextOrNumberError2 < '0' || nextOrNumberError2 > '9') {
                throw numberError(i, this.pos);
            }
            readDigits();
        }
        double parseDouble = Double.parseDouble(this.src.substring(i, this.pos));
        int i4 = (int) parseDouble;
        return ((double) i4) == parseDouble ? Integer.valueOf(i4) : Double.valueOf(parseDouble);
    }

    private Object readObject() {
        consumeWhitespace();
        Scriptable newObject = this.cx.newObject(this.scope);
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == '}') {
            this.pos++;
            return newObject;
        }
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length) {
                throw new ParseException("Unterminated object literal");
            }
            String str = this.src;
            this.pos = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt != '\"') {
                if (charAt != ',') {
                    if (charAt != '}') {
                        throw new ParseException("Unexpected token in object literal");
                    }
                    if (z) {
                        return newObject;
                    }
                    throw new ParseException("Unexpected comma in object literal");
                }
                if (!z) {
                    throw new ParseException("Unexpected comma in object literal");
                }
                z = false;
            } else {
                if (z) {
                    throw new ParseException("Missing comma in object literal");
                }
                String readString = readString();
                consume(':');
                Object readValue = readValue();
                long indexFromString = ScriptRuntime.indexFromString(readString);
                if (indexFromString < 0) {
                    newObject.put(readString, newObject, readValue);
                } else {
                    newObject.put((int) indexFromString, newObject, readValue);
                }
                z = true;
            }
            consumeWhitespace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0037, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String readString() {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.json.JsonParser.readString():java.lang.String");
    }

    private Boolean readTrue() {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 3 || this.src.charAt(i2) != 'r' || this.src.charAt(this.pos + 1) != 'u' || this.src.charAt(this.pos + 2) != 'e') {
            throw new ParseException("Unexpected token: t");
        }
        this.pos += 3;
        return Boolean.TRUE;
    }

    private Object readValue() {
        consumeWhitespace();
        int i = this.pos;
        if (i >= this.length) {
            throw new ParseException("Empty JSON string");
        }
        String str = this.src;
        this.pos = i + 1;
        char charAt = str.charAt(i);
        if (charAt == '\"') {
            return readString();
        }
        if (charAt != '-') {
            if (charAt == '[') {
                return readArray();
            }
            if (charAt == 'f') {
                return readFalse();
            }
            if (charAt == 'n') {
                return readNull();
            }
            if (charAt == 't') {
                return readTrue();
            }
            if (charAt == '{') {
                return readObject();
            }
            switch (charAt) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    throw new ParseException("Unexpected token: " + charAt);
            }
        }
        return readNumber(charAt);
    }

    public synchronized Object parseValue(String str) {
        Object readValue;
        if (str == null) {
            throw new ParseException("Input string may not be null");
        }
        this.pos = 0;
        this.length = str.length();
        this.src = str;
        readValue = readValue();
        consumeWhitespace();
        if (this.pos < this.length) {
            throw new ParseException("Expected end of stream at char " + this.pos);
        }
        return readValue;
    }
}
