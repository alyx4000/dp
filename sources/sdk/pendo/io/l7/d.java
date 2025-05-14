package sdk.pendo.io.l7;

import sdk.pendo.io.m7.a;

/* loaded from: classes6.dex */
public class d {

    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sdk.pendo.io.m7.a f1335a;
        final /* synthetic */ String b;
        final /* synthetic */ a.InterfaceC0197a c;

        a(sdk.pendo.io.m7.a aVar, String str, a.InterfaceC0197a interfaceC0197a) {
            this.f1335a = aVar;
            this.b = str;
            this.c = interfaceC0197a;
        }

        @Override // sdk.pendo.io.l7.d.b
        public void destroy() {
            this.f1335a.a(this.b, this.c);
        }
    }

    public interface b {
        void destroy();
    }

    public static b a(sdk.pendo.io.m7.a aVar, String str, a.InterfaceC0197a interfaceC0197a) {
        aVar.b(str, interfaceC0197a);
        return new a(aVar, str, interfaceC0197a);
    }
}
