package io.castle.android.queue;

import android.content.Context;
import com.squareup.tape2.ObjectQueue;
import com.squareup.tape2.QueueFile;
import io.castle.android.Castle;
import io.castle.android.CastleLogger;
import io.castle.android.Utils;
import io.castle.android.api.CastleAPIService;
import io.castle.android.api.model.Event;
import io.castle.android.api.model.Monitor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes2.dex */
public class EventQueue implements Callback<Void> {
    private static final String BATCH_QUEUE_FILENAME = "castle-queue";
    private static final int MAX_BATCH_SIZE = 20;
    private static final String QUEUE_FILENAME = "castle-monitor-queue";
    private ObjectQueue<Event> eventObjectQueue;
    private ExecutorService executor;
    private Call<Void> flushCall;
    private int flushCount;

    public EventQueue(Context context) {
        try {
            init(context);
        } catch (IOException e) {
            CastleLogger.e("Failed to create queue", e);
            getFile(context).delete();
            try {
                init(context);
            } catch (IOException e2) {
                CastleLogger.e("Deleted queue file. Retried. Failed.", e2);
            }
        }
    }

    private synchronized File getFile(Context context) {
        return getFile(context, QUEUE_FILENAME);
    }

    private synchronized File getFile(Context context, String str) {
        return new File(context.getApplicationContext().getFilesDir().getAbsoluteFile(), str);
    }

    private synchronized void init(Context context) throws IOException {
        this.executor = Executors.newSingleThreadExecutor();
        try {
            getFile(context, BATCH_QUEUE_FILENAME).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.eventObjectQueue = ObjectQueue.create(new QueueFile.Builder(getFile(context)).build(), new GsonConverter(Event.class));
    }

    public synchronized void add(final Event event) {
        this.executor.execute(new Runnable() { // from class: io.castle.android.queue.EventQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EventQueue.this.m1134lambda$add$0$iocastleandroidqueueEventQueue(event);
            }
        });
    }

    /* renamed from: lambda$add$0$io-castle-android-queue-EventQueue, reason: not valid java name */
    /* synthetic */ void m1134lambda$add$0$iocastleandroidqueueEventQueue(Event event) {
        try {
            if (Castle.configuration().debugLoggingEnabled()) {
                CastleLogger.d("Tracking event " + Utils.getGsonInstance().toJson(event));
            }
            this.eventObjectQueue.add(event);
            if (needsFlush()) {
                flush();
            }
        } catch (IOException e) {
            CastleLogger.e("Add to queue failed", e);
        }
    }

    private synchronized void trim() throws IOException {
        if (!isFlushing() && size() > Castle.configuration().maxQueueLimit()) {
            int size = size() - Castle.configuration().maxQueueLimit();
            remove(size);
            CastleLogger.d("Trimmed " + size + " events from queue");
        }
    }

    public synchronized void flush() {
        CastleLogger.d("EventQueue size " + this.eventObjectQueue.size());
        if (!isFlushing() && !this.eventObjectQueue.isEmpty()) {
            this.executor.execute(new Runnable() { // from class: io.castle.android.queue.EventQueue$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EventQueue.this.m1135lambda$flush$1$iocastleandroidqueueEventQueue();
                }
            });
        }
    }

    /* renamed from: lambda$flush$1$io-castle-android-queue-EventQueue, reason: not valid java name */
    /* synthetic */ void m1135lambda$flush$1$iocastleandroidqueueEventQueue() {
        try {
            trim();
            int min = Math.min(20, this.eventObjectQueue.size());
            ArrayList arrayList = new ArrayList(min);
            Iterator<Event> it = this.eventObjectQueue.iterator();
            for (int i = 0; i < min; i++) {
                try {
                    Event next = it.next();
                    if (next != null) {
                        arrayList.add(next);
                    }
                } catch (Error e) {
                    CastleLogger.e("Unable to read from queue", e);
                } catch (Exception e2) {
                    CastleLogger.e("Unable to read from queue", e2);
                }
            }
            Monitor monitorWithEvents = Monitor.monitorWithEvents(Collections.unmodifiableList(arrayList));
            if (monitorWithEvents == null) {
                CastleLogger.d("Did not flush EventQueue");
                if (min > 0) {
                    this.eventObjectQueue.clear();
                    CastleLogger.d("Clearing EventQueue because of unreadable data");
                    return;
                }
                return;
            }
            CastleLogger.d("Flushing EventQueue " + min);
            this.flushCount = min;
            try {
                this.flushCall = CastleAPIService.getInstance().monitor(monitorWithEvents);
            } catch (NullPointerException unused) {
                CastleLogger.d("Did not flush EventQueue because NPE, clearing EventQueue");
                this.eventObjectQueue.clear();
            }
            this.flushCall.enqueue(this);
        } catch (IOException e3) {
            CastleLogger.e("Unable to flush queue", e3);
        }
    }

    public synchronized boolean isFlushing() {
        return this.flushCall != null;
    }

    public synchronized boolean needsFlush() {
        return this.eventObjectQueue.size() >= Castle.configuration().flushLimit();
    }

    private synchronized void flushed() {
        this.flushCall = null;
        this.flushCount = 0;
    }

    public synchronized int size() {
        return this.eventObjectQueue.size();
    }

    private synchronized void remove(int i) {
        try {
            this.eventObjectQueue.remove(i);
            CastleLogger.d("Removed " + i + " events from EventQueue");
        } catch (Exception e) {
            CastleLogger.e("Failed to remove events from queue", e);
            try {
                CastleLogger.d("Clearing EventQueue");
                this.eventObjectQueue.clear();
            } catch (Exception e2) {
                CastleLogger.d("Unable to clear EventQueue");
                e2.printStackTrace();
            }
        }
    }

    @Override // retrofit2.Callback
    public synchronized void onResponse(Call<Void> call, Response<Void> response) {
        if (response.isSuccessful()) {
            CastleLogger.i(response.code() + " " + response.message());
            CastleLogger.i("Monitor request successful");
            this.executor.execute(new Runnable() { // from class: io.castle.android.queue.EventQueue$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    EventQueue.this.m1136lambda$onResponse$2$iocastleandroidqueueEventQueue();
                }
            });
        } else {
            CastleLogger.e(response.code() + " " + response.message());
            try {
                CastleLogger.e("Monitor request error:" + response.errorBody().string());
            } catch (Exception e) {
                CastleLogger.e("Monitor request error", e);
            }
            flushed();
        }
    }

    /* renamed from: lambda$onResponse$2$io-castle-android-queue-EventQueue, reason: not valid java name */
    /* synthetic */ void m1136lambda$onResponse$2$iocastleandroidqueueEventQueue() {
        remove(this.flushCount);
        flushed();
        if (needsFlush()) {
            Castle.flush();
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<Void> call, Throwable th) {
        CastleLogger.e("Monitor request failed", th);
        flushed();
    }

    public synchronized void destroy() {
        Call<Void> call = this.flushCall;
        if (call != null) {
            call.cancel();
        }
        flushed();
        this.executor.shutdown();
    }
}
