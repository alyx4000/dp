package sdk.pendo.io.c0;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import external.sdk.pendo.io.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes6.dex */
public class j extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.c0.a f935a;
    private final l b;
    private final Set<j> c;
    private RequestManager d;
    private j e;
    private Fragment f;

    private class a implements l {
        a() {
        }

        @Override // sdk.pendo.io.c0.l
        public Set<RequestManager> a() {
            Set<j> a2 = j.this.a();
            HashSet hashSet = new HashSet(a2.size());
            for (j jVar : a2) {
                if (jVar.d() != null) {
                    hashSet.add(jVar.d());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + j.this + "}";
        }
    }

    public j() {
        this(new sdk.pendo.io.c0.a());
    }

    private void a(j jVar) {
        this.c.add(jVar);
    }

    private Fragment c() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    private void f() {
        j jVar = this.e;
        if (jVar != null) {
            jVar.b(this);
            this.e = null;
        }
    }

    sdk.pendo.io.c0.a b() {
        return this.f935a;
    }

    public RequestManager d() {
        return this.d;
    }

    public l e() {
        return this.b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f935a.a();
        f();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        f();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f935a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f935a.c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + c() + "}";
    }

    j(sdk.pendo.io.c0.a aVar) {
        this.b = new a();
        this.c = new HashSet();
        this.f935a = aVar;
    }

    private void b(j jVar) {
        this.c.remove(jVar);
    }

    Set<j> a() {
        if (equals(this.e)) {
            return Collections.unmodifiableSet(this.c);
        }
        if (this.e == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (j jVar : this.e.a()) {
            if (a(jVar.getParentFragment())) {
                hashSet.add(jVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private boolean a(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    void b(Fragment fragment) {
        this.f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private void a(Activity activity) {
        f();
        j c = external.sdk.pendo.io.glide.a.a(activity).h().c(activity);
        this.e = c;
        if (equals(c)) {
            return;
        }
        this.e.a(this);
    }

    public void a(RequestManager requestManager) {
        this.d = requestManager;
    }
}
