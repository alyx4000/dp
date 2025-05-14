package sdk.pendo.io.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class a {
    private static final Pattern b = Pattern.compile("\\s*,\\s*");

    /* renamed from: a, reason: collision with root package name */
    private final List<Integer> f1652a;

    private a(List<Integer> list) {
        this.f1652a = Collections.unmodifiableList(list);
    }

    public List<Integer> a() {
        return this.f1652a;
    }

    public boolean b() {
        return this.f1652a.size() == 1;
    }

    public String toString() {
        return "[" + sdk.pendo.io.o1.i.a(",", this.f1652a) + "]";
    }

    public static a a(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != ' ' && charAt != '-') {
                throw new sdk.pendo.io.n1.f("Failed to parse ArrayIndexOperation: " + str);
            }
        }
        String[] split = b.split(str, -1);
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            arrayList.add(b(str2));
        }
        return new a(arrayList);
    }

    private static Integer b(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception e) {
            throw new sdk.pendo.io.n1.f("Failed to parse token in ArrayIndexOperation: " + str, e);
        }
    }
}
