package sdk.pendo.io.c0;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amplitude.reactnative.DatabaseConstants;
import external.sdk.pendo.io.glide.GlideBuilder;
import external.sdk.pendo.io.glide.RequestManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class k implements Handler.Callback {
    private static final b j = new a();

    /* renamed from: a, reason: collision with root package name */
    private volatile RequestManager f937a;
    private final Handler d;
    private final b e;
    private final g i;
    final Map<FragmentManager, j> b = new HashMap();
    final Map<androidx.fragment.app.FragmentManager, n> c = new HashMap();
    private final ArrayMap<View, Fragment> f = new ArrayMap<>();
    private final ArrayMap<View, android.app.Fragment> g = new ArrayMap<>();
    private final Bundle h = new Bundle();

    class a implements b {
        a() {
        }

        @Override // sdk.pendo.io.c0.k.b
        public RequestManager a(external.sdk.pendo.io.glide.a aVar, h hVar, l lVar, Context context) {
            return new RequestManager(aVar, hVar, lVar, context);
        }
    }

    public interface b {
        RequestManager a(external.sdk.pendo.io.glide.a aVar, h hVar, l lVar, Context context);
    }

    public k(b bVar, external.sdk.pendo.io.glide.c cVar) {
        this.e = bVar == null ? j : bVar;
        this.d = new Handler(Looper.getMainLooper(), this);
        this.i = a(cVar);
    }

    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Deprecated
    private void b(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.h.putInt(DatabaseConstants.KEY_FIELD, i);
            try {
                fragment = fragmentManager.getFragment(this.h, DatabaseConstants.KEY_FIELD);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager(), arrayMap);
            }
            i = i2;
        }
    }

    private RequestManager c(Context context) {
        if (this.f937a == null) {
            synchronized (this) {
                if (this.f937a == null) {
                    this.f937a = this.e.a(external.sdk.pendo.io.glide.a.a(context.getApplicationContext()), new sdk.pendo.io.c0.b(), new d(), context.getApplicationContext());
                }
            }
        }
        return this.f937a;
    }

    private static boolean d(Context context) {
        Activity a2 = a(context);
        return a2 == null || !a2.isFinishing();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Map map;
        Object obj2;
        Object obj3;
        int i = message.what;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            map = this.b;
        } else {
            if (i != 2) {
                obj3 = null;
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            map = this.c;
        }
        Object remove = map.remove(obj);
        obj2 = obj;
        obj3 = remove;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    private static g a(external.sdk.pendo.io.glide.c cVar) {
        return (external.sdk.pendo.io.glide.load.resource.bitmap.d.h && external.sdk.pendo.io.glide.load.resource.bitmap.d.g) ? cVar.a(GlideBuilder.WaitForFramesAfterTrimMemory.class) ? new e() : new f() : new c();
    }

    public RequestManager b(Activity activity) {
        if (sdk.pendo.io.i0.k.d()) {
            return b(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return a((FragmentActivity) activity);
        }
        a(activity);
        this.i.a(activity);
        return a(activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    @Deprecated
    j c(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null);
    }

    private static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public RequestManager b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (sdk.pendo.io.i0.k.e() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return b((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        return c(context);
    }

    @Deprecated
    private void a(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        for (android.app.Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager(), arrayMap);
            }
        }
    }

    private static void a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Deprecated
    private android.app.Fragment a(View view, Activity activity) {
        this.g.clear();
        a(activity.getFragmentManager(), this.g);
        View findViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.g.clear();
        return fragment;
    }

    private Fragment a(View view, FragmentActivity fragmentActivity) {
        this.f.clear();
        a(fragmentActivity.getSupportFragmentManager().getFragments(), this.f);
        View findViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f.clear();
        return fragment;
    }

    @Deprecated
    private RequestManager a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        j a2 = a(fragmentManager, fragment);
        RequestManager d = a2.d();
        if (d == null) {
            d = this.e.a(external.sdk.pendo.io.glide.a.a(context), a2.b(), a2.e(), context);
            if (z) {
                d.onStart();
            }
            a2.a(d);
        }
        return d;
    }

    @Deprecated
    public RequestManager a(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (sdk.pendo.io.i0.k.d()) {
            return b(fragment.getActivity().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.i.a(fragment.getActivity());
        }
        return a(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public RequestManager a(View view) {
        if (!sdk.pendo.io.i0.k.d()) {
            sdk.pendo.io.i0.j.a(view);
            sdk.pendo.io.i0.j.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
            Activity a2 = a(view.getContext());
            if (a2 != null) {
                if (!(a2 instanceof FragmentActivity)) {
                    android.app.Fragment a3 = a(view, a2);
                    return a3 == null ? b(a2) : a(a3);
                }
                FragmentActivity fragmentActivity = (FragmentActivity) a2;
                Fragment a4 = a(view, fragmentActivity);
                return a4 != null ? a(a4) : a(fragmentActivity);
            }
        }
        return b(view.getContext().getApplicationContext());
    }

    public RequestManager a(Fragment fragment) {
        sdk.pendo.io.i0.j.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (sdk.pendo.io.i0.k.d()) {
            return b(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.i.a(fragment.getActivity());
        }
        return a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public RequestManager a(FragmentActivity fragmentActivity) {
        if (sdk.pendo.io.i0.k.d()) {
            return b(fragmentActivity.getApplicationContext());
        }
        a((Activity) fragmentActivity);
        this.i.a(fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    private j a(FragmentManager fragmentManager, android.app.Fragment fragment) {
        j jVar = (j) fragmentManager.findFragmentByTag("external.sdk.pendo.io.glide.manager");
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = this.b.get(fragmentManager);
        if (jVar2 != null) {
            return jVar2;
        }
        j jVar3 = new j();
        jVar3.b(fragment);
        this.b.put(fragmentManager, jVar3);
        fragmentManager.beginTransaction().add(jVar3, "external.sdk.pendo.io.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(1, fragmentManager).sendToTarget();
        return jVar3;
    }

    n a(androidx.fragment.app.FragmentManager fragmentManager) {
        return a(fragmentManager, (Fragment) null);
    }

    private n a(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment) {
        n nVar = (n) fragmentManager.findFragmentByTag("external.sdk.pendo.io.glide.manager");
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = this.c.get(fragmentManager);
        if (nVar2 != null) {
            return nVar2;
        }
        n nVar3 = new n();
        nVar3.c(fragment);
        this.c.put(fragmentManager, nVar3);
        fragmentManager.beginTransaction().add(nVar3, "external.sdk.pendo.io.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(2, fragmentManager).sendToTarget();
        return nVar3;
    }

    private RequestManager a(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        n a2 = a(fragmentManager, fragment);
        RequestManager d = a2.d();
        if (d == null) {
            d = this.e.a(external.sdk.pendo.io.glide.a.a(context), a2.b(), a2.e(), context);
            if (z) {
                d.onStart();
            }
            a2.a(d);
        }
        return d;
    }
}
