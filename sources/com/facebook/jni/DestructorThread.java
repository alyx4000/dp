package com.facebook.jni;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class DestructorThread {
    private static final Thread sThread;
    private static final DestructorStack sDestructorStack = new DestructorStack();
    private static final ReferenceQueue sReferenceQueue = new ReferenceQueue();
    private static final DestructorList sDestructorList = new DestructorList();

    public static abstract class Destructor extends PhantomReference<Object> {
        private Destructor next;
        private Destructor previous;

        protected abstract void destruct();

        public Destructor(Object obj) {
            super(obj, DestructorThread.sReferenceQueue);
            DestructorThread.sDestructorStack.push(this);
        }

        private Destructor() {
            super(null, DestructorThread.sReferenceQueue);
        }
    }

    static {
        Thread thread = new Thread("HybridData DestructorThread") { // from class: com.facebook.jni.DestructorThread.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Destructor destructor = (Destructor) DestructorThread.sReferenceQueue.remove();
                        destructor.destruct();
                        if (destructor.previous == null) {
                            DestructorThread.sDestructorStack.transferAllToList();
                        }
                        DestructorList.drop(destructor);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        };
        sThread = thread;
        thread.start();
    }

    private static class Terminus extends Destructor {
        private Terminus() {
            super();
        }

        @Override // com.facebook.jni.DestructorThread.Destructor
        protected void destruct() {
            throw new IllegalStateException("Cannot destroy Terminus Destructor.");
        }
    }

    private static class DestructorStack {
        private final AtomicReference<Destructor> mHead;

        private DestructorStack() {
            this.mHead = new AtomicReference<>();
        }

        public void push(Destructor destructor) {
            Destructor destructor2;
            do {
                destructor2 = this.mHead.get();
                destructor.next = destructor2;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.mHead, destructor2, destructor));
        }

        public void transferAllToList() {
            Destructor andSet = this.mHead.getAndSet(null);
            while (andSet != null) {
                Destructor destructor = andSet.next;
                DestructorThread.sDestructorList.enqueue(andSet);
                andSet = destructor;
            }
        }
    }

    private static class DestructorList {
        private final Destructor mHead;

        public DestructorList() {
            Terminus terminus = new Terminus();
            this.mHead = terminus;
            ((Destructor) terminus).next = new Terminus();
            ((Destructor) terminus).next.previous = terminus;
        }

        public void enqueue(Destructor destructor) {
            destructor.next = this.mHead.next;
            this.mHead.next = destructor;
            destructor.next.previous = destructor;
            destructor.previous = this.mHead;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void drop(Destructor destructor) {
            destructor.next.previous = destructor.previous;
            destructor.previous.next = destructor.next;
        }
    }
}
