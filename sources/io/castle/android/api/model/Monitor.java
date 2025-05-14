package io.castle.android.api.model;

import com.google.gson.annotations.SerializedName;
import io.castle.android.Castle;
import io.castle.android.CastleLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class Monitor {

    @SerializedName("data")
    private String data;

    public static Monitor monitorWithEvents(List<Event> list) {
        if (list == null) {
            CastleLogger.e("Nil event array parameter provided. Won't flush events.");
            return null;
        }
        if (list.size() == 0) {
            CastleLogger.e("Empty event array parameter provided.");
            return null;
        }
        String userJwt = Castle.userJwt();
        if (userJwt == null) {
            CastleLogger.e("No user jwt set, won't flush events.");
            return null;
        }
        Monitor monitor = new Monitor();
        ArrayList arrayList = new ArrayList();
        Iterator<Event> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().encode());
        }
        monitor.data = Castle.encodePayload(Castle.encodeUser(userJwt), arrayList);
        return monitor;
    }
}
