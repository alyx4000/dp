package com.quantummetric.ui;

import com.quantummetric.ui.internal.j;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class EventType extends j {
    public static final EventType ABNSegment;
    public static final EventType CartValue;
    public static final EventType Conversion;
    public static final EventType EmailAddress;
    public static final EventType Encrypted;
    public static final EventType FirstName;
    public static final EventType LastName;
    public static final EventType Login;
    public static final EventType e;
    public static final EventType f;
    public static final EventType g;
    public static final List<EventType> h;

    static {
        EventType eventType = new EventType(1);
        Conversion = eventType;
        EventType eventType2 = new EventType(2);
        Login = eventType2;
        EventType eventType3 = new EventType(4);
        EmailAddress = eventType3;
        EventType eventType4 = new EventType(8);
        FirstName = eventType4;
        EventType eventType5 = new EventType(16);
        LastName = eventType5;
        EventType eventType6 = new EventType(64);
        CartValue = eventType6;
        EventType eventType7 = new EventType(128);
        ABNSegment = eventType7;
        EventType eventType8 = new EventType(512);
        e = eventType8;
        EventType eventType9 = new EventType(1024);
        f = eventType9;
        EventType eventType10 = new EventType(2048);
        g = eventType10;
        EventType eventType11 = new EventType(j.b.flag);
        Encrypted = eventType11;
        h = Arrays.asList(eventType, eventType2, eventType3, eventType4, eventType5, eventType6, eventType7, eventType11, eventType8, eventType9, eventType10);
    }

    private EventType(int i) {
        super(i);
    }

    public static boolean a(int i) {
        return i == 1 || i == 64;
    }
}
