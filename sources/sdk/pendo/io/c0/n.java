package sdk.pendo.io.c0;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import external.sdk.pendo.io.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class n extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.c0.a f939a;
    private final l b;
    private final Set<n> c;
    private n d;
    private RequestManager e;
    private Fragment f;

    private class a implements l {
        a() {
        }

        @Override // sdk.pendo.io.c0.l
        public Set<RequestManager> a() {
            Set<n> a2 = n.this.a();
            HashSet hashSet = new HashSet(a2.size());
            for (n nVar : a2) {
                if (nVar.d() != null) {
                    hashSet.add(nVar.d());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + n.this + "}";
        }
    }

    public n() {
        this(new sdk.pendo.io.c0.a());
    }

    private void a(n nVar) {
        this.c.add(nVar);
    }

    private Fragment c() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    private void f() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.b(this);
            this.d = null;
        }
    }

    sdk.pendo.io.c0.a b() {
        return this.f939a;
    }

    public RequestManager d() {
        return this.e;
    }

    public l e() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager a2 = a((Fragment) this);
        if (a2 == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                a(getContext(), a2);
            } catch (IllegalStateException e) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f939a.a();
        f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
        f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f939a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f939a.c();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + c() + "}";
    }

    public n(sdk.pendo.io.c0.a aVar) {
        this.b = new a();
        this.c = new HashSet();
        this.f939a = aVar;
    }

    private boolean b(Fragment fragment) {
        Fragment c = c();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(c)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    Set<n> a() {
        n nVar = this.d;
        if (nVar == null) {
            return Collections.emptySet();
        }
        if (equals(nVar)) {
            return Collections.unmodifiableSet(this.c);
        }
        HashSet hashSet = new HashSet();
        for (n nVar2 : this.d.a()) {
            if (b(nVar2.c())) {
                hashSet.add(nVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    void c(Fragment fragment) {
        FragmentManager a2;
        this.f = fragment;
        if (fragment == null || fragment.getContext() == null || (a2 = a(fragment)) == null) {
            return;
        }
        a(fragment.getContext(), a2);
    }

    private static FragmentManager a(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private void b(n nVar) {
        this.c.remove(nVar);
    }

    private void a(Context context, FragmentManager fragmentManager) {
        f();
        n a2 = external.sdk.pendo.io.glide.a.a(context).h().a(fragmentManager);
        this.d = a2;
        if (equals(a2)) {
            return;
        }
        this.d.a(this);
    }

    public void a(RequestManager requestManager) {
        this.e = requestManager;
    }
}
