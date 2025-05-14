package sdk.pendo.io.f9;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.ViewPager;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import io.sentry.protocol.Response;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.ElementInfoAndViewRef;
import sdk.pendo.io.f9.h;
import sdk.pendo.io.g9.b0;
import sdk.pendo.io.g9.h0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.sdk.xamarin.XamarinBridge;
import sdk.pendo.io.sdk.xamarin.XamarinFlyoutPageListener;
import sdk.pendo.io.x5.o;

@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002Û\u0001\b\u0016\u0018\u0000 ã\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0010B\u0013\u0012\b\u0010à\u0001\u001a\u00030ß\u0001¢\u0006\u0006\bá\u0001\u0010â\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J,\u0010\u0010\u001a\u00020\u00042\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\nH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u001c\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0016J\u0010\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\n\u0010%\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010(\u001a\u00020'H\u0016JP\u0010\u0010\u001a\u00020\u00042\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0016J\b\u00104\u001a\u00020'H\u0016J\b\u00105\u001a\u00020'H\u0016J\b\u00106\u001a\u00020'H\u0016J\b\u00107\u001a\u00020'H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u00108\u001a\u00020'H\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0016J\b\u0010<\u001a\u00020\u0004H\u0016J\b\u0010=\u001a\u00020\u0004H\u0016J\u000f\u0010>\u001a\u00020'H\u0000¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0004H\u0000¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0016J\b\u0010C\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020\u0004H\u0016J\u000f\u0010E\u001a\u00020'H\u0000¢\u0006\u0004\bE\u0010?J\u000f\u0010F\u001a\u00020\u0004H\u0000¢\u0006\u0004\bF\u0010AJ\u001f\u0010\u0010\u001a\u00020#2\u0006\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020'H\u0010¢\u0006\u0004\b\u0010\u0010IJ\u0017\u0010\u0010\u001a\u00020'2\u0006\u0010:\u001a\u000209H\u0000¢\u0006\u0004\b\u0010\u0010JJ/\u0010\u0010\u001a\u00020'2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010PJ!\u0010\u0010\u001a\u0004\u0018\u00010\u00172\u0006\u0010Q\u001a\u00020\r2\u0006\u0010:\u001a\u000209H\u0000¢\u0006\u0004\b\u0010\u0010RJ\u000f\u0010S\u001a\u00020'H\u0000¢\u0006\u0004\bS\u0010?J\u0019\u0010(\u001a\u00020\u00042\b\u0010T\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b(\u0010UJ\u000f\u0010V\u001a\u00020'H\u0010¢\u0006\u0004\bV\u0010?J\u000f\u0010W\u001a\u00020'H\u0010¢\u0006\u0004\bW\u0010?J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0017H\u0010¢\u0006\u0004\b\u0010\u0010YJ\u000f\u0010Z\u001a\u00020\u0004H\u0010¢\u0006\u0004\bZ\u0010AJ\u000f\u0010[\u001a\u00020\u000bH\u0010¢\u0006\u0004\b[\u0010\\J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u0010\u0010UJ\b\u0010^\u001a\u00020#H\u0016J\b\u0010\u0010\u001a\u00020_H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010:\u001a\u0002092\u0006\u0010\"\u001a\u00020`H\u0016J\u001f\u0010(\u001a\u00020\u00042\u0006\u0010:\u001a\u0002092\u0006\u0010\"\u001a\u00020`H\u0010¢\u0006\u0004\b(\u0010aJ\u0012\u0010d\u001a\u00020\u00042\b\u0010c\u001a\u0004\u0018\u00010bH\u0016J\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010e2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020f0eH\u0016J\b\u0010i\u001a\u00020'H\u0007J\b\u0010j\u001a\u00020'H\u0007R\u0014\u0010l\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0010\u0010kR\u0014\u0010m\u001a\u0002008\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010\u0007R\u0014\u0010n\u001a\u0002008\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u0010\u0007R\u0014\u0010o\u001a\u0002008\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u0007R\u0014\u0010p\u001a\u0002008\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\u0007R\u0014\u0010q\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b<\u0010kR\u0014\u0010r\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b6\u0010kR\u0014\u0010s\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b4\u0010kR\u0014\u0010t\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u0010kR\u0014\u0010u\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b^\u0010kR\u0014\u0010v\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b=\u0010kR\u0014\u0010w\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bC\u0010kR\u0014\u0010x\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001d\u0010kR\u0014\u0010y\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010kR\u0014\u0010z\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010kR\u001a\u0010|\u001a\u00020\u000b8\u0000X\u0080D¢\u0006\f\n\u0004\b%\u0010k\u001a\u0004\b{\u0010\\R\u001a\u0010~\u001a\u00020\u000b8\u0000X\u0080D¢\u0006\f\n\u0004\b5\u0010k\u001a\u0004\b}\u0010\\R\u001b\u0010\u0080\u0001\u001a\u00020\u000b8\u0000X\u0080D¢\u0006\f\n\u0004\b\u001c\u0010k\u001a\u0004\b\u007f\u0010\\R\u0019\u0010\u0083\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010\u0082\u0001R0\u0010\u008b\u0001\u001a\u00030\u0084\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u001e\n\u0005\bF\u0010\u0085\u0001\u0012\u0005\b\u008a\u0001\u0010A\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u008d\u0001R\\\u0010\u0094\u0001\u001a@\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\u008f\u0001j\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e`\u0090\u00018\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u0019\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0097\u0001R \u0010\u009b\u0001\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b}\u0010\u009a\u0001R*\u0010\u009e\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u009c\u00010\fj\t\u0012\u0005\u0012\u00030\u009c\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b@\u0010\u009d\u0001R0\u0010£\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0012\u0010\u009a\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001b\u0010¦\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bZ\u0010¥\u0001R+\u0010\u00ad\u0001\u001a\u0005\u0018\u00010§\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0011\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010¯\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bD\u0010®\u0001R'\u0010³\u0001\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\bi\u0010®\u0001\u001a\u0005\b°\u0001\u0010?\"\u0006\b±\u0001\u0010²\u0001R;\u0010º\u0001\u001a\u0004\u0018\u00010#2\t\u0010´\u0001\u001a\u0004\u0018\u00010#8\u0000@@X\u0081\u000e¢\u0006\u001d\n\u0005\bV\u0010µ\u0001\u0012\u0005\b¹\u0001\u0010A\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0005\b\u0010\u0010¸\u0001R\u001a\u0010»\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bj\u0010µ\u0001R%\u0010½\u0001\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b\u0005\u0010k\u001a\u0005\b\u0096\u0001\u0010\\\"\u0005\b¼\u0001\u0010UR\u0016\u0010¾\u0001\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\t\u0010®\u0001R%\u0010Á\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030¿\u0001\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010À\u0001R\u0016\u0010Â\u0001\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0015\u0010®\u0001R\u0017\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0014\u0010®\u0001R \u0010*\u001a\u00020'2\u0007\u0010Ã\u0001\u001a\u00020'8\u0002@CX\u0082\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010®\u0001R\u0017\u0010+\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0006\u0010®\u0001R \u0010,\u001a\u00020'2\u0007\u0010Ã\u0001\u001a\u00020'8\u0002@CX\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010®\u0001R\u0017\u0010-\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bW\u0010®\u0001R\u0017\u0010/\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bE\u0010®\u0001R\u0017\u0010.\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\b\u0010®\u0001R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010\u0007R\u0018\u00102\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010®\u0001R\u0019\u0010Æ\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010®\u0001R\u0019\u0010È\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010®\u0001R\u001c\u0010Ì\u0001\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R#\u0010Ö\u0001\u001a\f\u0012\u0005\u0012\u00030Õ\u0001\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u0097\u0001R#\u0010Ø\u0001\u001a\f\u0012\u0005\u0012\u00030Õ\u0001\u0018\u00010\u0095\u00018C@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010\u0097\u0001R#\u0010Ú\u0001\u001a\f\u0012\u0005\u0012\u00030Õ\u0001\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010\u0097\u0001R\u0018\u0010Þ\u0001\u001a\u00030Û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001¨\u0006ä\u0001"}, d2 = {"Lsdk/pendo/io/f9/k;", "Lsdk/pendo/io/f9/f;", "Lsdk/pendo/io/e9/c;", "Lsdk/pendo/io/p8/b;", "", "H", "N", "J", "R", "I", "", "", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/h$b;", "Lkotlin/collections/ArrayList;", "newSpecialViewsMap", "a", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M", "L", "K", "Ljava/util/HashSet;", "Landroid/view/View;", "Lkotlin/collections/HashSet;", "v", ViewProps.START, "Lsdk/pendo/io/x5/j;", "r", "m", "d", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "e", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lorg/json/JSONObject;", "n", ContextChain.TAG_PRODUCT, "o", "", "b", "includePageViewTexts", "includeFeatureClickTexts", "includeFeatureClickNestedTexts", "includeRetroElementCompatibilityHashes", "isOldScreenIdFormat", "ignoreDynamicFragmentsInScrollView", "isRespondToScrollChangeEventsForScreenId", "", "globalLayoutChangeDebouncer", "shouldDetectClicksForAccessibility", "c", "h", "q", "g", ContextChain.TAG_INFRA, "shouldForceScan", "Landroid/app/Activity;", "activity", "onActivityPaused", "f", "k", "O", "()Z", "z", "()V", "onActivityResumed", "l", "D", "Q", "t", "includeText", "isForCapture", "(ZZ)Lorg/json/JSONObject;", "(Landroid/app/Activity;)Z", "type", "", "count", "selectedIndex", "specialViewItem", "(Ljava/lang/String;IILsdk/pendo/io/f9/h$b;)Z", "item", "(Lsdk/pendo/io/f9/h$b;Landroid/app/Activity;)Landroid/view/View;", ExifInterface.LATITUDE_SOUTH, "newScreenId", "(Ljava/lang/String;)V", "F", "P", "rootView", "(Landroid/view/View;)V", "B", "s", "()Ljava/lang/String;", "previousScreenId", "j", "Lorg/json/JSONArray;", "Lsdk/pendo/io/h9/c;", "(Landroid/app/Activity;Lsdk/pendo/io/h9/c;)V", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", Response.TYPE, "onGetAccessTokenResponseReceived", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", ExifInterface.LONGITUDE_EAST, "G", "Ljava/lang/String;", "TAG", "GLOBAL_LAYOUT_TIMEOUT", "SCROLL_DEBOUNCE_TIMEOUT", "STATE_CHANGE_TIMEOUT", "DELAY_FOR_XAMARIN_FORMS_FLYOUT", "PERSISTENT_SCREEN_MANAGER_FILE", "PERSISTENT_INCLUDE_PAGE_TEXTS_KEY", "PERSISTENT_INCLUDE_FEATURE_TEXTS_KEY", "PERSISTENT_INCLUDE_FEATURE_CLICK_NESTED_TEXTS_KEY", "PERSISTENT_INCLUDE_RE_COMPATIBILITY_HASHES_KEY", "PERSISTENT_IS_OLD_SCREEN_ID_FORMAT_KEY", "PERSISTENT_IGNORE_DYNAMIC_FRAGMENTS_IN_SCROLLVIEW_KEY", "PERSISTENT_IS_RESPOND_TO_SCROLL_EVENTS_KEY", "PERSISTENT_GLOBAL_LAYOUT_CHANGE_DEBOUNCER_KEY", "PERSISTENT_SHOULD_IGNORE_DYNAMIC_ELEMENTS_DURING_SCAN_KEY", "getVIEW_PAGER$pendoIO_release", "VIEW_PAGER", ViewHierarchyNode.JsonKeys.Y, "TAB_LAYOUT", "u", "BOTTOM_NAVIGATION_VIEW", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "Lsdk/pendo/io/f9/e;", "Lsdk/pendo/io/f9/e;", "getScreenIdGenerator", "()Lsdk/pendo/io/f9/e;", "setScreenIdGenerator", "(Lsdk/pendo/io/f9/e;)V", "getScreenIdGenerator$annotations", "screenIdGenerator", "Lsdk/pendo/io/sdk/xamarin/XamarinBridge;", "Lsdk/pendo/io/sdk/xamarin/XamarinBridge;", "sXamarinBridge", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", ViewHierarchyNode.JsonKeys.X, "()Ljava/util/HashMap;", "specialViewsMap", "Lsdk/pendo/io/w6/b;", "w", "Lsdk/pendo/io/w6/b;", "screenChangedNewScreenIdSubject", "screenLayoutChangedSameScreenIdSubject", "Ljava/lang/ref/WeakReference;", "pendoDrawerListenerRef", "Lsdk/pendo/io/f9/d;", "Ljava/util/ArrayList;", "fragmentsInfoList", "getCurrentActivityRef$pendoIO_release", "()Ljava/lang/ref/WeakReference;", "setCurrentActivityRef$pendoIO_release", "(Ljava/lang/ref/WeakReference;)V", "currentActivityRef", "Lsdk/pendo/io/g9/q0$b;", "Lsdk/pendo/io/g9/q0$b;", "currentRootViewData", "Lsdk/pendo/io/f9/a;", "Lsdk/pendo/io/f9/a;", "getFocusHandler$pendoIO_release", "()Lsdk/pendo/io/f9/a;", "setFocusHandler$pendoIO_release", "(Lsdk/pendo/io/f9/a;)V", "focusHandler", "Z", "disableBackCapture", "getForceScreenScanOnGlobalLayoutChange$pendoIO_release", "setForceScreenScanOnGlobalLayoutChange$pendoIO_release", "(Z)V", "forceScreenScanOnGlobalLayoutChange", "newValue", "Lorg/json/JSONObject;", "getCurrentScreenData$pendoIO_release", "()Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getCurrentScreenData$pendoIO_release$annotations", "currentScreenData", "previousScreenData", "setCurrentScreenId$pendoIO_release", "currentScreenId", Pendo.PendoOptions.USE_PROVIDED_SCREEN_ID, "", "Ljava/util/Map;", "additionalOptions", "shouldExcludeGhostElementsForCapture", "<set-?>", ExifInterface.GPS_DIRECTION_TRUE, "U", "shouldIgnoreDynamicElementsDuringScan", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "synchronizedScreenDataScan", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", ExifInterface.LONGITUDE_WEST, "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "mOnScrollChangedListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "X", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mOnGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "Y", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "mOnWindowFocusChangeListener", "Lsdk/pendo/io/g9/h0;", "mActivityStateChangeSubject", "a0", "mGlobalLayoutStateChangeSubject", "b0", "mScrollChangeSubject", "sdk/pendo/io/f9/k$k", "c0", "Lsdk/pendo/io/f9/k$k;", "viewPagerOnPageChangeListener", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;)V", "d0", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public class k implements sdk.pendo.io.f9.f, sdk.pendo.io.e9.c, sdk.pendo.io.p8.b {

    /* renamed from: A, reason: from kotlin metadata */
    private WeakReference<Activity> currentActivityRef;

    /* renamed from: B, reason: from kotlin metadata */
    private q0.b currentRootViewData;

    /* renamed from: C, reason: from kotlin metadata */
    private a focusHandler;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean disableBackCapture;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean forceScreenScanOnGlobalLayoutChange;

    /* renamed from: F, reason: from kotlin metadata */
    private volatile JSONObject currentScreenData;

    /* renamed from: G, reason: from kotlin metadata */
    private volatile JSONObject previousScreenData;

    /* renamed from: H, reason: from kotlin metadata */
    private volatile String currentScreenId;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean useProvidedScreenId;

    /* renamed from: J, reason: from kotlin metadata */
    private final Map<String, Object> additionalOptions;

    /* renamed from: K, reason: from kotlin metadata */
    private final boolean shouldExcludeGhostElementsForCapture;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile boolean includePageViewTexts;

    /* renamed from: M, reason: from kotlin metadata */
    private volatile boolean includeFeatureClickTexts;

    /* renamed from: N, reason: from kotlin metadata */
    private volatile boolean includeFeatureClickNestedTexts;

    /* renamed from: O, reason: from kotlin metadata */
    private volatile boolean includeRetroElementCompatibilityHashes;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isOldScreenIdFormat;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isRespondToScrollChangeEventsForScreenId;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean ignoreDynamicFragmentsInScrollView;

    /* renamed from: S, reason: from kotlin metadata */
    private long globalLayoutChangeDebouncer;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean shouldDetectClicksForAccessibility;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean shouldIgnoreDynamicElementsDuringScan;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean synchronizedScreenDataScan;

    /* renamed from: W, reason: from kotlin metadata */
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;

    /* renamed from: X, reason: from kotlin metadata */
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;

    /* renamed from: Y, reason: from kotlin metadata */
    private ViewTreeObserver.OnWindowFocusChangeListener mOnWindowFocusChangeListener;

    /* renamed from: Z, reason: from kotlin metadata */
    private sdk.pendo.io.w6.b<h0> mActivityStateChangeSubject;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: a0, reason: from kotlin metadata */
    private sdk.pendo.io.w6.b<h0> mGlobalLayoutStateChangeSubject;

    /* renamed from: b, reason: from kotlin metadata */
    private final long GLOBAL_LAYOUT_TIMEOUT;

    /* renamed from: b0, reason: from kotlin metadata */
    private sdk.pendo.io.w6.b<h0> mScrollChangeSubject;

    /* renamed from: c, reason: from kotlin metadata */
    private final long SCROLL_DEBOUNCE_TIMEOUT;

    /* renamed from: c0, reason: from kotlin metadata */
    private final C0140k viewPagerOnPageChangeListener;

    /* renamed from: d, reason: from kotlin metadata */
    private final long STATE_CHANGE_TIMEOUT;

    /* renamed from: e, reason: from kotlin metadata */
    private final long DELAY_FOR_XAMARIN_FORMS_FLYOUT;

    /* renamed from: f, reason: from kotlin metadata */
    private final String PERSISTENT_SCREEN_MANAGER_FILE;

    /* renamed from: g, reason: from kotlin metadata */
    private final String PERSISTENT_INCLUDE_PAGE_TEXTS_KEY;

    /* renamed from: h, reason: from kotlin metadata */
    private final String PERSISTENT_INCLUDE_FEATURE_TEXTS_KEY;

    /* renamed from: i, reason: from kotlin metadata */
    private final String PERSISTENT_INCLUDE_FEATURE_CLICK_NESTED_TEXTS_KEY;

    /* renamed from: j, reason: from kotlin metadata */
    private final String PERSISTENT_INCLUDE_RE_COMPATIBILITY_HASHES_KEY;

    /* renamed from: k, reason: from kotlin metadata */
    private final String PERSISTENT_IS_OLD_SCREEN_ID_FORMAT_KEY;

    /* renamed from: l, reason: from kotlin metadata */
    private final String PERSISTENT_IGNORE_DYNAMIC_FRAGMENTS_IN_SCROLLVIEW_KEY;

    /* renamed from: m, reason: from kotlin metadata */
    private final String PERSISTENT_IS_RESPOND_TO_SCROLL_EVENTS_KEY;

    /* renamed from: n, reason: from kotlin metadata */
    private final String PERSISTENT_GLOBAL_LAYOUT_CHANGE_DEBOUNCER_KEY;

    /* renamed from: o, reason: from kotlin metadata */
    private final String PERSISTENT_SHOULD_IGNORE_DYNAMIC_ELEMENTS_DURING_SCAN_KEY;

    /* renamed from: p, reason: from kotlin metadata */
    private final String VIEW_PAGER;

    /* renamed from: q, reason: from kotlin metadata */
    private final String TAB_LAYOUT;

    /* renamed from: r, reason: from kotlin metadata */
    private final String BOTTOM_NAVIGATION_VIEW;

    /* renamed from: s, reason: from kotlin metadata */
    private CoroutineDispatcher mainDispatcher;

    /* renamed from: t, reason: from kotlin metadata */
    private sdk.pendo.io.f9.e screenIdGenerator;

    /* renamed from: u, reason: from kotlin metadata */
    private XamarinBridge sXamarinBridge;

    /* renamed from: v, reason: from kotlin metadata */
    private final HashMap<String, ArrayList<h.b>> specialViewsMap;

    /* renamed from: w, reason: from kotlin metadata */
    private final sdk.pendo.io.w6.b<String> screenChangedNewScreenIdSubject;

    /* renamed from: x, reason: from kotlin metadata */
    private final sdk.pendo.io.w6.b<String> screenLayoutChangedSameScreenIdSubject;

    /* renamed from: y, reason: from kotlin metadata */
    private WeakReference<PendoDrawerListener> pendoDrawerListenerRef;

    /* renamed from: z, reason: from kotlin metadata */
    private ArrayList<sdk.pendo.io.f9.d> fragmentsInfoList;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$generateScreenshotBitmap$1", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity A;
        int f;
        final /* synthetic */ sdk.pendo.io.h9.c f0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, sdk.pendo.io.h9.c cVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.A = activity;
            this.f0 = cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return k.this.new b(this.A, this.f0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            k.this.b(this.A, this.f0);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"sdk/pendo/io/f9/k$c", "Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "Lorg/json/JSONObject;", "viewAsJson", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "", "onViewFound", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class c implements OnElementInScreenFoundListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<ActivationManager.Trigger> f1098a;
        final /* synthetic */ ArrayList<ElementInfoAndViewRef> b;

        c(List<ActivationManager.Trigger> list, ArrayList<ElementInfoAndViewRef> arrayList) {
            this.f1098a = list;
            this.b = arrayList;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
        
            r5 = r10.b;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
            r5.add(new sdk.pendo.io.actions.ElementInfoAndViewRef(r4, r12, r2));
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0012 A[SYNTHETIC] */
        @Override // sdk.pendo.io.listeners.views.OnElementInScreenFoundListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onViewFound(org.json.JSONObject r11, java.lang.ref.WeakReference<android.view.View> r12) {
            /*
                r10 = this;
                java.lang.String r0 = "retroElementInfo"
                java.lang.String r1 = "viewAsJson"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
                java.lang.String r1 = "viewRef"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
                java.util.List<sdk.pendo.io.actions.ActivationManager$Trigger> r1 = r10.f1098a
                java.util.Iterator r1 = r1.iterator()
            L12:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L9f
                java.lang.Object r2 = r1.next()
                sdk.pendo.io.actions.ActivationManager$Trigger r2 = (sdk.pendo.io.actions.ActivationManager.Trigger) r2
                r3 = 0
                org.json.JSONObject r4 = r11.getJSONObject(r0)     // Catch: java.lang.Exception -> L8f
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L8f
                r5.<init>()     // Catch: java.lang.Exception -> L8f
                r5.put(r0, r4)     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.models.StepLocationModel r6 = r2.getLocation()     // Catch: java.lang.Exception -> L8f
                if (r6 == 0) goto L36
                java.lang.String r6 = r6.getFeatureSelector()     // Catch: java.lang.Exception -> L8f
                goto L37
            L36:
                r6 = 0
            L37:
                r7 = 1
                if (r6 == 0) goto L43
                boolean r6 = kotlin.text.StringsKt.isBlank(r6)     // Catch: java.lang.Exception -> L8f
                if (r6 == 0) goto L41
                goto L43
            L41:
                r6 = r3
                goto L44
            L43:
                r6 = r7
            L44:
                if (r6 != 0) goto L12
                sdk.pendo.io.n1.a r6 = sdk.pendo.io.n1.a.b()     // Catch: java.lang.Exception -> L8f
                r8 = 2
                sdk.pendo.io.n1.i[] r8 = new sdk.pendo.io.n1.i[r8]     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.n1.i r9 = sdk.pendo.io.n1.i.DEFAULT_PATH_LEAF_TO_NULL     // Catch: java.lang.Exception -> L8f
                r8[r3] = r9     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.n1.i r9 = sdk.pendo.io.n1.i.SUPPRESS_EXCEPTIONS     // Catch: java.lang.Exception -> L8f
                r8[r7] = r9     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.n1.a r6 = r6.a(r8)     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.n1.j r6 = sdk.pendo.io.n1.g.a(r6)     // Catch: java.lang.Exception -> L8f
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.n1.b r5 = r6.a(r5)     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.models.StepLocationModel r6 = r2.getLocation()     // Catch: java.lang.Exception -> L8f
                java.lang.String r6 = r6.getFeatureSelector()     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.n1.l[] r8 = new sdk.pendo.io.n1.l[r3]     // Catch: java.lang.Exception -> L8f
                java.lang.Object r5 = r5.a(r6, r8)     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.b2.a r5 = (sdk.pendo.io.b2.a) r5     // Catch: java.lang.Exception -> L8f
                if (r5 == 0) goto L7f
                boolean r5 = r5.isEmpty()     // Catch: java.lang.Exception -> L8f
                if (r5 == 0) goto L7e
                goto L7f
            L7e:
                r7 = r3
            L7f:
                if (r7 != 0) goto L12
                java.util.ArrayList<sdk.pendo.io.actions.ElementInfoAndViewRef> r5 = r10.b     // Catch: java.lang.Exception -> L8f
                sdk.pendo.io.actions.ElementInfoAndViewRef r6 = new sdk.pendo.io.actions.ElementInfoAndViewRef     // Catch: java.lang.Exception -> L8f
                kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch: java.lang.Exception -> L8f
                r6.<init>(r4, r12, r2)     // Catch: java.lang.Exception -> L8f
                r5.add(r6)     // Catch: java.lang.Exception -> L8f
                goto L12
            L8f:
                r2 = move-exception
                java.lang.String r4 = r2.getMessage()
                if (r4 != 0) goto L98
                java.lang.String r4 = "getMatchingElementsIfExist"
            L98:
                java.lang.Object[] r3 = new java.lang.Object[r3]
                sdk.pendo.io.logging.PendoLogger.w(r2, r4, r3)
                goto L12
            L9f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.k.c.onViewFound(org.json.JSONObject, java.lang.ref.WeakReference):void");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$handleNewScreenId$1", f = "ScreenManagerBase.kt", i = {}, l = {1094}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int f;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return k.this.new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = k.this.DELAY_FOR_XAMARIN_FORMS_FLYOUT;
                this.f = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/g9/h0;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lsdk/pendo/io/g9/h0;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class e extends Lambda implements Function1<h0, Boolean> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(h0 h0Var) {
            return Boolean.valueOf(k.this.Q());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/g9/h0;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lsdk/pendo/io/g9/h0;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class f extends Lambda implements Function1<h0, Boolean> {
        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(h0 h0Var) {
            return Boolean.valueOf(k.this.Q());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/g9/h0;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lsdk/pendo/io/g9/h0;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class g extends Lambda implements Function1<h0, Boolean> {
        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(h0 h0Var) {
            return Boolean.valueOf(k.this.Q());
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$onDialogAppear$1$1", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ k A;
        int f;
        final /* synthetic */ View s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(View view, k kVar, Continuation<? super h> continuation) {
            super(2, continuation);
            this.s = view;
            this.A = kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(this.s, this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ViewTreeObserver viewTreeObserver = this.s.getViewTreeObserver();
            if (this.A.mOnGlobalLayoutListener != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.A.mOnGlobalLayoutListener);
                viewTreeObserver.addOnGlobalLayoutListener(this.A.mOnGlobalLayoutListener);
            }
            viewTreeObserver.removeOnScrollChangedListener(this.A.mOnScrollChangedListener);
            viewTreeObserver.addOnScrollChangedListener(this.A.mOnScrollChangedListener);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$registerActivityLayoutChangesListeners$1$1", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ k A;
        int f;
        final /* synthetic */ Activity s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Activity activity, k kVar, Continuation<? super i> continuation) {
            super(2, continuation);
            this.s = activity;
            this.A = kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new i(this.s, this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ViewTreeObserver viewTreeObserver = this.s.getWindow().getDecorView().getViewTreeObserver();
            if (this.A.mOnGlobalLayoutListener != null) {
                viewTreeObserver.addOnGlobalLayoutListener(this.A.mOnGlobalLayoutListener);
            }
            viewTreeObserver.addOnScrollChangedListener(this.A.mOnScrollChangedListener);
            viewTreeObserver.addOnWindowFocusChangeListener(this.A.mOnWindowFocusChangeListener);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$unregisterActivityLayoutChangesListeners$1$1", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ k A;
        int f;
        final /* synthetic */ Activity s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Activity activity, k kVar, Continuation<? super j> continuation) {
            super(2, continuation);
            this.s = activity;
            this.A = kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new j(this.s, this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ViewTreeObserver viewTreeObserver = this.s.getWindow().getDecorView().getViewTreeObserver();
            if (this.A.mOnGlobalLayoutListener != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.A.mOnGlobalLayoutListener);
            }
            viewTreeObserver.removeOnScrollChangedListener(this.A.mOnScrollChangedListener);
            viewTreeObserver.removeOnWindowFocusChangeListener(this.A.mOnWindowFocusChangeListener);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"sdk/pendo/io/f9/k$k", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", ViewProps.POSITION, "", "positionOffset", "positionOffsetPixels", "", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.f9.k$k, reason: collision with other inner class name */
    public static final class C0140k implements ViewPager.OnPageChangeListener {
        C0140k() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            sdk.pendo.io.w6.b bVar;
            if ((k.this.x().containsKey(k.this.getTAB_LAYOUT()) || k.this.x().containsKey(k.this.getBOTTOM_NAVIGATION_VIEW())) && (bVar = k.this.mGlobalLayoutStateChangeSubject) != null) {
                bVar.onNext(new h0());
            }
        }
    }

    public k(Pendo.PendoOptions pendoOptions) {
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        this.TAG = "ScreenManager";
        this.GLOBAL_LAYOUT_TIMEOUT = 100L;
        this.SCROLL_DEBOUNCE_TIMEOUT = 100L;
        this.STATE_CHANGE_TIMEOUT = 300L;
        this.DELAY_FOR_XAMARIN_FORMS_FLYOUT = 300L;
        this.PERSISTENT_SCREEN_MANAGER_FILE = "pendo_screen_manager";
        this.PERSISTENT_INCLUDE_PAGE_TEXTS_KEY = "includePageViewTexts";
        this.PERSISTENT_INCLUDE_FEATURE_TEXTS_KEY = "includeFeatureClickTexts";
        this.PERSISTENT_INCLUDE_FEATURE_CLICK_NESTED_TEXTS_KEY = "includeFeatureClickNestedTexts";
        this.PERSISTENT_INCLUDE_RE_COMPATIBILITY_HASHES_KEY = "includeRetroElementCompatibilityHashes";
        this.PERSISTENT_IS_OLD_SCREEN_ID_FORMAT_KEY = "isOldScreenIdFormat";
        this.PERSISTENT_IGNORE_DYNAMIC_FRAGMENTS_IN_SCROLLVIEW_KEY = "ignoreDynamicFragmentsInScrollView";
        this.PERSISTENT_IS_RESPOND_TO_SCROLL_EVENTS_KEY = "isRespondToScrollChangeEventsForScreenId";
        this.PERSISTENT_GLOBAL_LAYOUT_CHANGE_DEBOUNCER_KEY = "globalLayoutChangeDebouncer";
        this.PERSISTENT_SHOULD_IGNORE_DYNAMIC_ELEMENTS_DURING_SCAN_KEY = "shouldIgnoreDynamicElementsDuringScan";
        this.VIEW_PAGER = "ViewPager";
        this.TAB_LAYOUT = "TabLayout";
        this.BOTTOM_NAVIGATION_VIEW = "BottomNavigationView";
        this.mainDispatcher = Dispatchers.getMain().getImmediate();
        this.screenIdGenerator = new sdk.pendo.io.f9.j();
        this.specialViewsMap = new HashMap<>();
        sdk.pendo.io.w6.b<String> n = sdk.pendo.io.w6.b.n();
        Intrinsics.checkNotNullExpressionValue(n, "create(...)");
        this.screenChangedNewScreenIdSubject = n;
        sdk.pendo.io.w6.b<String> n2 = sdk.pendo.io.w6.b.n();
        Intrinsics.checkNotNullExpressionValue(n2, "create(...)");
        this.screenLayoutChangedSameScreenIdSubject = n2;
        this.fragmentsInfoList = new ArrayList<>();
        XamarinBridge xamarinBridge = null;
        this.currentActivityRef = new WeakReference<>(null);
        this.currentScreenId = "";
        this.useProvidedScreenId = pendoOptions.getUseProvidedScreenId();
        Map<String, Object> additionalOptions = pendoOptions.getAdditionalOptions();
        this.additionalOptions = additionalOptions;
        this.shouldExcludeGhostElementsForCapture = pendoOptions.getExcludeHiddenElementsWhileScanning();
        this.includePageViewTexts = true;
        this.includeFeatureClickTexts = true;
        this.includeRetroElementCompatibilityHashes = true;
        this.isOldScreenIdFormat = true;
        this.ignoreDynamicFragmentsInScrollView = true;
        this.globalLayoutChangeDebouncer = 100L;
        this.viewPagerOnPageChangeListener = new C0140k();
        if (additionalOptions != null) {
            Object obj = additionalOptions.get(Pendo.PendoOptions.XAMARIN_BRIDGE);
            xamarinBridge = (XamarinBridge) (obj instanceof XamarinBridge ? obj : null);
        }
        this.sXamarinBridge = xamarinBridge;
        if (xamarinBridge != null) {
            xamarinBridge.addFlyoutListener(new XamarinFlyoutPageListener());
        }
    }

    private final void A() {
        if (this.mActivityStateChangeSubject == null) {
            sdk.pendo.io.w6.b<h0> n = sdk.pendo.io.w6.b.n();
            this.mActivityStateChangeSubject = n;
            Intrinsics.checkNotNull(n, "null cannot be cast to non-null type external.sdk.pendo.io.reactivex.subjects.PublishSubject<sdk.pendo.io.utilities.RxUtils.RxVoidEvent>");
            sdk.pendo.io.x5.j<h0> c2 = n.a(sdk.pendo.io.v6.a.a()).f(this.STATE_CHANGE_TIMEOUT, TimeUnit.MILLISECONDS).c(sdk.pendo.io.n8.c.g().a());
            final e eVar = new e();
            c2.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda5
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean a2;
                    a2 = k.a(Function1.this, obj);
                    return a2;
                }
            }).i().a(sdk.pendo.io.d9.c.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda6
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    k.a(k.this, (h0) obj);
                }
            }, "ScreenManager activity state observer - screen changed"));
        }
    }

    private final void C() {
        if (this.mScrollChangeSubject == null) {
            sdk.pendo.io.w6.b<h0> n = sdk.pendo.io.w6.b.n();
            this.mScrollChangeSubject = n;
            Intrinsics.checkNotNull(n, "null cannot be cast to non-null type external.sdk.pendo.io.reactivex.subjects.PublishSubject<sdk.pendo.io.utilities.RxUtils.RxVoidEvent>");
            sdk.pendo.io.x5.j<h0> c2 = n.a(this.SCROLL_DEBOUNCE_TIMEOUT, TimeUnit.MILLISECONDS).c(sdk.pendo.io.n8.c.g().a());
            final g gVar = new g();
            c2.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda7
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean c3;
                    c3 = k.c(Function1.this, obj);
                    return c3;
                }
            }).i().a(sdk.pendo.io.d9.c.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda8
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    k.c(k.this, (h0) obj);
                }
            }, "ScreenManager initialise scroll change observer"));
        }
    }

    private final synchronized void H() {
        SharedPreferences a2 = b0.a(this.PERSISTENT_SCREEN_MANAGER_FILE);
        if (a2 != null) {
            this.includePageViewTexts = a2.getBoolean(this.PERSISTENT_INCLUDE_PAGE_TEXTS_KEY, this.includePageViewTexts);
            this.includeFeatureClickTexts = a2.getBoolean(this.PERSISTENT_INCLUDE_FEATURE_TEXTS_KEY, this.includeFeatureClickTexts);
            this.includeFeatureClickNestedTexts = a2.getBoolean(this.PERSISTENT_INCLUDE_FEATURE_CLICK_NESTED_TEXTS_KEY, this.includeFeatureClickNestedTexts);
            this.includeRetroElementCompatibilityHashes = a2.getBoolean(this.PERSISTENT_INCLUDE_RE_COMPATIBILITY_HASHES_KEY, this.includeRetroElementCompatibilityHashes);
            this.isOldScreenIdFormat = a2.getBoolean(this.PERSISTENT_IS_OLD_SCREEN_ID_FORMAT_KEY, true);
        }
        String str = this.PERSISTENT_IGNORE_DYNAMIC_FRAGMENTS_IN_SCROLLVIEW_KEY;
        Object valueOf = Boolean.valueOf(a2 != null ? a2.getBoolean(str, true) : true);
        Map map = this.additionalOptions;
        Object obj = map != null ? map.get(str) : null;
        if (obj != null && (obj instanceof Boolean)) {
            valueOf = obj;
        }
        this.ignoreDynamicFragmentsInScrollView = ((Boolean) valueOf).booleanValue();
        String str2 = this.PERSISTENT_IS_RESPOND_TO_SCROLL_EVENTS_KEY;
        Object valueOf2 = Boolean.valueOf(a2 != null ? a2.getBoolean(str2, false) : false);
        Map map2 = this.additionalOptions;
        Object obj2 = map2 != null ? map2.get(str2) : null;
        if (obj2 != null && (obj2 instanceof Boolean)) {
            valueOf2 = obj2;
        }
        this.isRespondToScrollChangeEventsForScreenId = ((Boolean) valueOf2).booleanValue();
        String str3 = this.PERSISTENT_GLOBAL_LAYOUT_CHANGE_DEBOUNCER_KEY;
        Object valueOf3 = Long.valueOf(a2 != null ? a2.getLong(str3, this.GLOBAL_LAYOUT_TIMEOUT) : this.GLOBAL_LAYOUT_TIMEOUT);
        Map map3 = this.additionalOptions;
        Object obj3 = map3 != null ? map3.get(str3) : null;
        if (obj3 != null && (obj3 instanceof Long)) {
            valueOf3 = obj3;
        }
        this.globalLayoutChangeDebouncer = ((Number) valueOf3).longValue();
        Object obj4 = Boolean.FALSE;
        Map map4 = this.additionalOptions;
        Object obj5 = map4 != null ? map4.get("disableBackCapture") : null;
        if (obj5 == null || !(obj5 instanceof Boolean)) {
            obj5 = obj4;
        }
        this.disableBackCapture = ((Boolean) obj5).booleanValue();
        String str4 = this.PERSISTENT_SHOULD_IGNORE_DYNAMIC_ELEMENTS_DURING_SCAN_KEY;
        Map map5 = this.additionalOptions;
        Object obj6 = map5 != null ? map5.get(str4) : null;
        if (obj6 != null && (obj6 instanceof Boolean)) {
            obj4 = obj6;
        }
        boolean booleanValue = ((Boolean) obj4).booleanValue();
        this.shouldIgnoreDynamicElementsDuringScan = booleanValue;
        PendoLogger.d(this.TAG, "loadPolicy additionalOptions flags - ignoreDynamicFragmentsInScrollView " + this.ignoreDynamicFragmentsInScrollView + ", isRespondToScrollChangeEventsForScreenId " + this.isRespondToScrollChangeEventsForScreenId + ", globalLayoutChangeDebouncer " + this.globalLayoutChangeDebouncer + ", shouldIgnoreDynamicElementsDuringScan " + booleanValue);
    }

    private final void I() {
        WeakReference<View> weakReference;
        View view;
        Job launch$default;
        q0.b bVar = this.currentRootViewData;
        if (bVar != null && (weakReference = bVar.f1145a) != null && (view = weakReference.get()) != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.mainDispatcher, null, new h(view, this, null), 2, null);
            if (launch$default != null) {
                return;
            }
        }
        PendoLogger.w("Screen Manager onDialogAppear -> current root view is null", new Object[0]);
        Unit unit = Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r0 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void J() {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.R()     // Catch: java.lang.Throwable -> L2d
            java.lang.ref.WeakReference<android.app.Activity> r0 = r7.currentActivityRef     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L2d
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L21
            kotlinx.coroutines.GlobalScope r1 = kotlinx.coroutines.GlobalScope.INSTANCE     // Catch: java.lang.Throwable -> L2d
            kotlinx.coroutines.CoroutineDispatcher r2 = r7.mainDispatcher     // Catch: java.lang.Throwable -> L2d
            sdk.pendo.io.f9.k$i r4 = new sdk.pendo.io.f9.k$i     // Catch: java.lang.Throwable -> L2d
            r3 = 0
            r4.<init>(r0, r7, r3)     // Catch: java.lang.Throwable -> L2d
            r3 = 0
            r5 = 2
            r6 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto L2b
        L21:
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = "Screen Manager can't register activity layout changes listeners -> activity is null"
            sdk.pendo.io.logging.PendoLogger.w(r1, r0)     // Catch: java.lang.Throwable -> L2d
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2d
        L2b:
            monitor-exit(r7)
            return
        L2d:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.k.J():void");
    }

    private final void K() {
        if (this.mOnGlobalLayoutListener != null || PlatformStateManager.INSTANCE.isReactNativeApp()) {
            return;
        }
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                k.g(k.this);
            }
        };
    }

    private final void L() {
        if (this.mOnScrollChangedListener == null) {
            this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda4
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    k.h(k.this);
                }
            };
        }
    }

    private final void M() {
        if (this.mOnWindowFocusChangeListener == null) {
            this.mOnWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda2
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public final void onWindowFocusChanged(boolean z) {
                    k.a(k.this, z);
                }
            };
        }
    }

    private final synchronized void N() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences.Editor putBoolean2;
        SharedPreferences.Editor putBoolean3;
        SharedPreferences.Editor putBoolean4;
        SharedPreferences.Editor putBoolean5;
        SharedPreferences.Editor putBoolean6;
        SharedPreferences.Editor putBoolean7;
        SharedPreferences.Editor putLong;
        SharedPreferences a2 = b0.a(this.PERSISTENT_SCREEN_MANAGER_FILE);
        if (a2 != null && (edit = a2.edit()) != null && (putBoolean = edit.putBoolean(this.PERSISTENT_INCLUDE_PAGE_TEXTS_KEY, this.includePageViewTexts)) != null && (putBoolean2 = putBoolean.putBoolean(this.PERSISTENT_INCLUDE_FEATURE_TEXTS_KEY, this.includeFeatureClickTexts)) != null && (putBoolean3 = putBoolean2.putBoolean(this.PERSISTENT_INCLUDE_FEATURE_CLICK_NESTED_TEXTS_KEY, this.includeFeatureClickNestedTexts)) != null && (putBoolean4 = putBoolean3.putBoolean(this.PERSISTENT_INCLUDE_RE_COMPATIBILITY_HASHES_KEY, this.includeRetroElementCompatibilityHashes)) != null && (putBoolean5 = putBoolean4.putBoolean(this.PERSISTENT_IS_OLD_SCREEN_ID_FORMAT_KEY, this.isOldScreenIdFormat)) != null && (putBoolean6 = putBoolean5.putBoolean(this.PERSISTENT_IGNORE_DYNAMIC_FRAGMENTS_IN_SCROLLVIEW_KEY, this.ignoreDynamicFragmentsInScrollView)) != null && (putBoolean7 = putBoolean6.putBoolean(this.PERSISTENT_IS_RESPOND_TO_SCROLL_EVENTS_KEY, this.isRespondToScrollChangeEventsForScreenId)) != null && (putLong = putBoolean7.putLong(this.PERSISTENT_GLOBAL_LAYOUT_CHANGE_DEBOUNCER_KEY, this.globalLayoutChangeDebouncer)) != null) {
            putLong.apply();
        }
    }

    private final void R() {
        Job launch$default;
        Activity activity = this.currentActivityRef.get();
        if (activity != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.mainDispatcher, null, new j(activity, this, null), 2, null);
            if (launch$default != null) {
                return;
            }
        }
        PendoLogger.w("Screen Manager can't unregister activity layout changes listeners -> activity is null", new Object[0]);
        Unit unit = Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HashSet<View> v() {
        WeakReference<View> weakReference;
        View view;
        T t;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Unit unit = null;
        if (sdk.pendo.io.n8.c.g().f() == null) {
            return null;
        }
        o0 o0Var = o0.f1142a;
        Activity f2 = sdk.pendo.io.n8.c.g().f();
        Intrinsics.checkNotNullExpressionValue(f2, "getCurrentVisibleActivity(...)");
        q0.b a2 = o0.a(o0Var, f2, false, 2, null);
        if (a2 != null && (weakReference = a2.f1145a) != null && (view = weakReference.get()) != null) {
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            if (platformStateManager.isReactNativeAnalyticsEnabled()) {
                t = platformStateManager.getReactRoots(view);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(view);
                t = hashSet;
            }
            objectRef.element = t;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PendoLogger.d(this.TAG + " getMatchingElementsIfExist -> current root view is null", new Object[0]);
        }
        return (HashSet) objectRef.element;
    }

    public void B() {
        if (this.mGlobalLayoutStateChangeSubject == null) {
            sdk.pendo.io.w6.b<h0> n = sdk.pendo.io.w6.b.n();
            this.mGlobalLayoutStateChangeSubject = n;
            Intrinsics.checkNotNull(n, "null cannot be cast to non-null type external.sdk.pendo.io.reactivex.subjects.PublishSubject<sdk.pendo.io.utilities.RxUtils.RxVoidEvent>");
            sdk.pendo.io.x5.j<h0> c2 = n.a(sdk.pendo.io.v6.a.a()).g(this.globalLayoutChangeDebouncer, TimeUnit.MILLISECONDS).c(sdk.pendo.io.n8.c.g().a());
            final f fVar = new f();
            c2.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean b2;
                    b2 = k.b(Function1.this, obj);
                    return b2;
                }
            }).i().a(sdk.pendo.io.d9.c.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    k.b(k.this, (h0) obj);
                }
            }, "ScreenManager initialise global layout state change observer"));
        }
    }

    public void D() {
        B();
        C();
        A();
        K();
        L();
        M();
    }

    public final boolean E() {
        return StringsKt.contains$default((CharSequence) this.currentScreenId, (CharSequence) "__DIALOG__", false, 2, (Object) null);
    }

    public boolean F() {
        return PlatformStateManager.INSTANCE.getForceNotifyNewScreen();
    }

    public final boolean G() {
        return StringsKt.contains$default((CharSequence) this.currentScreenId, (CharSequence) "__PANEL__", false, 2, (Object) null);
    }

    public final boolean O() {
        return sdk.pendo.io.t8.a.d() || PlatformStateManager.INSTANCE.isAppAnalyticsDisabled() || !PendoInternal.U();
    }

    public boolean P() {
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        return platformStateManager.isReactNativeApp() && !platformStateManager.isReactNativeAnalyticsEnabled();
    }

    public final boolean Q() {
        return (!PendoInternal.U() || sdk.pendo.io.e9.b.e().f() || this.currentActivityRef.get() == null) ? false : true;
    }

    public final boolean S() {
        if (this.currentScreenData != null) {
            Activity f2 = sdk.pendo.io.n8.c.g().f();
            if (f2 != null) {
                Intrinsics.checkNotNull(f2);
                return a(f2);
            }
            PendoLogger.e("ScreenManager.getUpdatedScreenData, activity is null", new Object[0]);
        }
        return false;
    }

    @Override // sdk.pendo.io.e9.c
    /* renamed from: g, reason: from getter */
    public boolean getIncludeRetroElementCompatibilityHashes() {
        return this.includeRetroElementCompatibilityHashes;
    }

    @Override // sdk.pendo.io.e9.c
    /* renamed from: h, reason: from getter */
    public boolean getIncludeFeatureClickTexts() {
        return this.includeFeatureClickTexts;
    }

    @Override // sdk.pendo.io.e9.c
    /* renamed from: i, reason: from getter */
    public boolean getShouldDetectClicksForAccessibility() {
        return this.shouldDetectClicksForAccessibility;
    }

    @Override // sdk.pendo.io.f9.f
    /* renamed from: j */
    public JSONObject getRetroactiveScreenData() {
        return a(true, true);
    }

    @Override // sdk.pendo.io.f9.f
    public synchronized void k() {
        this.forceScreenScanOnGlobalLayoutChange = true;
        f();
    }

    @Override // sdk.pendo.io.f9.f
    public void l() {
        sdk.pendo.io.w6.b<h0> bVar = this.mGlobalLayoutStateChangeSubject;
        if (bVar != null) {
            bVar.onNext(new h0());
        }
    }

    @Override // sdk.pendo.io.f9.f
    public void m() {
        if (getCurrentScreenId().length() > 0) {
            this.screenChangedNewScreenIdSubject.onNext(getCurrentScreenId());
        }
    }

    @Override // sdk.pendo.io.f9.f
    public JSONObject n() {
        JSONObject jSONObject = this.currentScreenData;
        if (jSONObject != null) {
            return new JSONObject(jSONObject.toString());
        }
        return null;
    }

    @Override // sdk.pendo.io.f9.f
    /* renamed from: o, reason: from getter */
    public String getCurrentScreenId() {
        return this.currentScreenId;
    }

    @Override // sdk.pendo.io.f9.f
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(this.currentActivityRef.get(), activity)) {
            R();
            this.currentActivityRef = new WeakReference<>(null);
        }
    }

    @Override // sdk.pendo.io.f9.f
    public void onActivityResumed(final Activity activity) {
        PendoDrawerListener pendoDrawerListener;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (sdk.pendo.io.t8.a.d() || P()) {
            return;
        }
        this.currentActivityRef = new WeakReference<>(activity);
        WeakReference<PendoDrawerListener> weakReference = this.pendoDrawerListenerRef;
        if (weakReference != null && (pendoDrawerListener = weakReference.get()) != null) {
            pendoDrawerListener.setDrawerState(0);
        }
        D();
        J();
        sdk.pendo.io.x5.j.a(new h0()).a(sdk.pendo.io.v6.a.a()).a((o) sdk.pendo.io.d9.c.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.f9.k$$ExternalSyntheticLambda9
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                k.a(k.this, activity, (h0) obj);
            }
        }, "ScreenManager perform on computation thread observer onActivityResumed"));
    }

    @Override // sdk.pendo.io.p8.b
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
        if (response != null) {
            boolean synchronizedScreenDataScan = response.getSynchronizedScreenDataScan();
            this.synchronizedScreenDataScan = synchronizedScreenDataScan;
            this.screenIdGenerator.a(synchronizedScreenDataScan);
        }
    }

    @Override // sdk.pendo.io.f9.f
    /* renamed from: p, reason: from getter */
    public JSONObject getPreviousScreenData() {
        return this.previousScreenData;
    }

    @Override // sdk.pendo.io.e9.c
    /* renamed from: q, reason: from getter */
    public boolean getIncludeFeatureClickNestedTexts() {
        return this.includeFeatureClickNestedTexts;
    }

    @Override // sdk.pendo.io.f9.f
    public sdk.pendo.io.x5.j<String> r() {
        return this.screenChangedNewScreenIdSubject;
    }

    public String s() {
        Activity activity = this.currentActivityRef.get();
        WeakReference<PendoDrawerListener> weakReference = this.pendoDrawerListenerRef;
        PendoDrawerListener pendoDrawerListener = weakReference != null ? weakReference.get() : null;
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        return platformStateManager.isReactNativeApp() ? this.screenIdGenerator.a(platformStateManager, this.currentScreenId) : platformStateManager.isXamarinFormsOrMaui() ? this.useProvidedScreenId ? this.screenIdGenerator.a(this.currentScreenId, this.currentRootViewData, this.sXamarinBridge, pendoDrawerListener) : this.screenIdGenerator.a(this.fragmentsInfoList, activity, this.currentRootViewData, this.isOldScreenIdFormat, this.currentScreenId, this.sXamarinBridge, this.ignoreDynamicFragmentsInScrollView, pendoDrawerListener) : this.screenIdGenerator.a(this.fragmentsInfoList, activity, this.currentRootViewData, this.isOldScreenIdFormat, this.currentScreenId, this.ignoreDynamicFragmentsInScrollView, pendoDrawerListener);
    }

    @Override // sdk.pendo.io.f9.f
    public void start() {
        PendoLogger.d("Initializing ScreenManager", new Object[0]);
        H();
        if (!this.disableBackCapture) {
            this.focusHandler = new a(null, 1, null);
        }
        sdk.pendo.io.p8.a.d().a(this);
    }

    public final synchronized void t() {
        if (O()) {
            return;
        }
        b(s());
    }

    /* renamed from: u, reason: from getter */
    public final String getBOTTOM_NAVIGATION_VIEW() {
        return this.BOTTOM_NAVIGATION_VIEW;
    }

    public final String w() {
        return this.currentScreenId;
    }

    public final HashMap<String, ArrayList<h.b>> x() {
        return this.specialViewsMap;
    }

    /* renamed from: y, reason: from getter */
    public final String getTAB_LAYOUT() {
        return this.TAB_LAYOUT;
    }

    public final void z() {
        if (O()) {
            return;
        }
        if (E() || G()) {
            I();
        }
        a(a(this.includePageViewTexts, false));
        this.screenChangedNewScreenIdSubject.onNext(this.currentScreenId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        sdk.pendo.io.w6.b<h0> bVar = this$0.mGlobalLayoutStateChangeSubject;
        if (bVar != null) {
            bVar.onNext(new h0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        sdk.pendo.io.w6.b<h0> bVar = this$0.mScrollChangeSubject;
        if (bVar != null) {
            bVar.onNext(new h0());
        }
    }

    public void a(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        if (platformStateManager.isReactNativeAnalyticsEnabled()) {
            platformStateManager.filterReactRoots(rootView);
        }
        XamarinBridge xamarinBridge = this.sXamarinBridge;
        if (xamarinBridge != null) {
            xamarinBridge.onLayoutChanged();
        }
        t();
    }

    @Override // sdk.pendo.io.e9.c
    /* renamed from: b, reason: from getter */
    public boolean getShouldExcludeGhostElementsForCapture() {
        return this.shouldExcludeGhostElementsForCapture;
    }

    @Override // sdk.pendo.io.e9.c
    /* renamed from: c, reason: from getter */
    public boolean getIncludePageViewTexts() {
        return this.includePageViewTexts;
    }

    @Override // sdk.pendo.io.f9.f
    public sdk.pendo.io.x5.j<String> d() {
        return this.screenLayoutChangedSameScreenIdSubject;
    }

    @Override // sdk.pendo.io.f9.f
    public WeakReference<PendoDrawerListener> e() {
        return this.pendoDrawerListenerRef;
    }

    @Override // sdk.pendo.io.f9.f
    public synchronized void f() {
        sdk.pendo.io.w6.b<h0> bVar = this.mActivityStateChangeSubject;
        if (bVar != null) {
            bVar.onNext(new h0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final View a(h.b item, Activity activity) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(activity, "activity");
        View view = item.c().get();
        return view == null ? activity.findViewById(item.getViewId()) : view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(k this$0, h0 h0Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (PlatformStateManager.INSTANCE.isNotReactNativeApp()) {
            Activity activity = this$0.currentActivityRef.get();
            Unit unit = null;
            if (activity != null) {
                this$0.currentRootViewData = o0.a(o0.f1142a, activity, false, 2, null);
                XamarinBridge xamarinBridge = this$0.sXamarinBridge;
                if (xamarinBridge != null) {
                    xamarinBridge.onLayoutChanged();
                }
                this$0.f();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                PendoLogger.w("ScreenManager mGlobalLayoutStateChangeSubject -> activity is null", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(k this$0, h0 h0Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isRespondToScrollChangeEventsForScreenId) {
            this$0.f();
        } else {
            this$0.screenLayoutChangedSameScreenIdSubject.onNext(this$0.currentScreenId);
        }
    }

    @Override // sdk.pendo.io.f9.f
    public void a(Activity activity, sdk.pendo.io.h9.c listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.mainDispatcher), null, null, new b(activity, listener, null), 3, null);
    }

    @Override // sdk.pendo.io.f9.f
    public List<ElementInfoAndViewRef> a(List<ActivationManager.Trigger> triggerList) {
        Intrinsics.checkNotNullParameter(triggerList, "triggerList");
        HashSet<View> v = v();
        ArrayList arrayList = new ArrayList();
        if (o0.a(o0.f1142a, v, false, new c(triggerList, arrayList), 2, null) == null) {
            return null;
        }
        return arrayList;
    }

    public final synchronized void b(String newScreenId) {
        boolean z = true;
        if (newScreenId == null) {
            PendoLogger.w(this.TAG, "newScreenIdentified -> screenName is null");
            return;
        }
        if (newScreenId.length() != 0) {
            z = false;
        }
        if (z) {
            PendoLogger.d(this.TAG + " -> Empty screen id - Ignoring.", new Object[0]);
        } else if (!Intrinsics.areEqual(newScreenId, this.currentScreenId)) {
            PendoLogger.d(this.TAG + " -> Screen changed from " + this.currentScreenId + " to " + newScreenId, new Object[0]);
            String str = this.currentScreenId;
            this.currentScreenId = newScreenId;
            a(str);
        } else if (Intrinsics.areEqual(newScreenId, this.currentScreenId)) {
            if (F()) {
                PendoLogger.d(this.TAG + " -> force notify Screen changed for " + this.currentScreenId, new Object[0]);
                z();
            } else {
                PendoLogger.d(this.TAG + " -> Layout of the " + this.currentScreenId + " screen changed", new Object[0]);
                a(this.forceScreenScanOnGlobalLayoutChange);
            }
        }
        PlatformStateManager.INSTANCE.setForceNotifyNewScreen(false);
        this.forceScreenScanOnGlobalLayoutChange = false;
    }

    public synchronized JSONObject a(boolean includeText, boolean isForCapture) {
        h.a a2;
        WeakReference<View> weakReference;
        View view;
        a aVar;
        ArrayList arrayList = new ArrayList(this.fragmentsInfoList);
        sdk.pendo.io.f9.h iVar = this.synchronizedScreenDataScan ? new sdk.pendo.io.f9.i(arrayList, this.viewPagerOnPageChangeListener, this.isRespondToScrollChangeEventsForScreenId, false, includeText, isForCapture) : new sdk.pendo.io.f9.h(arrayList, this.viewPagerOnPageChangeListener, this.isRespondToScrollChangeEventsForScreenId, false, includeText, isForCapture);
        String str = this.currentScreenId;
        WeakReference<Activity> weakReference2 = this.currentActivityRef;
        q0.b bVar = this.currentRootViewData;
        a2 = iVar.a(str, weakReference2, bVar != null ? bVar.f1145a : null);
        q0.b bVar2 = this.currentRootViewData;
        if (bVar2 != null && (weakReference = bVar2.f1145a) != null && (view = weakReference.get()) != null && (view instanceof ViewGroup) && (aVar = this.focusHandler) != null) {
            ViewTreeObserver viewTreeObserver = ((ViewGroup) view).getViewTreeObserver();
            Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "getViewTreeObserver(...)");
            aVar.a(viewTreeObserver, new WeakReference<>(view));
        }
        a(a2.b());
        return a2.getScreenDataJson();
    }

    public void b(Activity activity, sdk.pendo.io.h9.c listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        q0.b(activity, listener);
    }

    @Override // sdk.pendo.io.f9.f
    public JSONArray a() {
        WeakReference<View> weakReference;
        View view;
        if (this.currentActivityRef.get() == null) {
            return new JSONArray();
        }
        q0.b bVar = this.currentRootViewData;
        if (bVar == null || (weakReference = bVar.f1145a) == null || (view = weakReference.get()) == null) {
            return new JSONArray();
        }
        HashSet<View> hashSet = new HashSet<>();
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        if (platformStateManager.isReactNativeAnalyticsEnabled()) {
            hashSet = platformStateManager.getReactRoots(view);
        } else {
            hashSet.add(view);
        }
        JSONArray a2 = o0.a(o0.f1142a, hashSet, true, null, 4, null);
        return a2 == null ? new JSONArray() : a2;
    }

    public final boolean a(String type, int count, int selectedIndex, h.b specialViewItem) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(specialViewItem, "specialViewItem");
        if (count != 0 && specialViewItem.getLastKnownSelectedIndex() >= 0 && selectedIndex != specialViewItem.getLastKnownSelectedIndex()) {
            PendoLogger.d(this.TAG + "-> handleChangesInSpecialView " + type + " significantly changed, selectedIndex = " + selectedIndex, new Object[0]);
            if (Intrinsics.areEqual(type, this.TAB_LAYOUT) || Intrinsics.areEqual(type, this.BOTTOM_NAVIGATION_VIEW)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.f9.f
    public void a(boolean shouldForceScan) {
        PendoLogger.i(this.TAG, "handleGlobalLayoutChanges, shouldForceScan: " + shouldForceScan);
        if (O()) {
            return;
        }
        boolean S = S();
        if (shouldForceScan || !this.shouldIgnoreDynamicElementsDuringScan || S) {
            PendoLogger.i(this.TAG, "handleGlobalLayoutChanges, scan the screen");
            a(a(this.includePageViewTexts, false));
        }
        (S ? this.screenChangedNewScreenIdSubject : this.screenLayoutChangedSameScreenIdSubject).onNext(this.currentScreenId);
    }

    public void a(String previousScreenId) {
        boolean z;
        Intrinsics.checkNotNullParameter(previousScreenId, "previousScreenId");
        try {
            if (PlatformStateManager.INSTANCE.isXamarinFormsOrMaui()) {
                XamarinBridge xamarinBridge = this.sXamarinBridge;
                if (xamarinBridge != null) {
                    z = true;
                    if (xamarinBridge.isFlyoutPage()) {
                        if (z && Intrinsics.areEqual(previousScreenId, "__DRAWER__")) {
                            BuildersKt.runBlocking(Dispatchers.getDefault(), new d(null));
                        }
                    }
                }
                z = false;
                if (z) {
                    BuildersKt.runBlocking(Dispatchers.getDefault(), new d(null));
                }
            }
        } catch (Exception e2) {
            PendoLogger.d(e2, this.TAG + " -> Error reading from xamarin forms bridge", new Object[0]);
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(k this$0, h0 h0Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t();
    }

    public final boolean a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            boolean z = false;
            for (Map.Entry<String, ArrayList<h.b>> entry : this.specialViewsMap.entrySet()) {
                Iterator<h.b> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    h.b next = it.next();
                    Intrinsics.checkNotNull(next);
                    View a2 = a(next, activity);
                    if (a2 == null) {
                        PendoLogger.d(this.TAG + "-> loopViewsForChanges " + ((Object) entry.getKey()) + " significantly changed, type changed", new Object[0]);
                        return true;
                    }
                    if (Intrinsics.areEqual(entry.getKey(), this.TAB_LAYOUT) && (a2 instanceof TabLayout)) {
                        z = a(this.TAB_LAYOUT, ((TabLayout) a2).getTabCount(), ((TabLayout) a2).getSelectedTabPosition(), next);
                        if (z) {
                            return true;
                        }
                    } else {
                        if (!Intrinsics.areEqual(entry.getKey(), this.BOTTOM_NAVIGATION_VIEW) || !(a2 instanceof BottomNavigationView)) {
                            PendoLogger.d(this.TAG + " -> loopViewsForChanges - the view type (" + ((Object) entry.getKey()) + " vs. " + a2.getClass().getCanonicalName() + ") did not match any of the special views!", new Object[0]);
                            return true;
                        }
                        z = a(this.BOTTOM_NAVIGATION_VIEW, ((BottomNavigationView) a2).getMenu().size(), ((BottomNavigationView) a2).getSelectedItemId(), next);
                        if (z) {
                            return true;
                        }
                    }
                }
            }
            return z;
        } catch (Exception e2) {
            PendoLogger.w(e2, this.TAG + " -> loopViewsForChanges - An exception was caught, will signal for re-scanning the screen", new Object[0]);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(k this$0, Activity activity, h0 h0Var) {
        WeakReference<View> weakReference;
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Unit unit = null;
        q0.b a2 = o0.a(o0.f1142a, activity, false, 2, null);
        this$0.currentRootViewData = a2;
        if (a2 != null && (weakReference = a2.f1145a) != null && (view = weakReference.get()) != null) {
            this$0.a(view);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PendoLogger.w("ScreenManager onActivityResumed -> root view is null", new Object[0]);
        }
    }

    private final void a(Map<String, ? extends ArrayList<h.b>> newSpecialViewsMap) {
        this.specialViewsMap.clear();
        for (Map.Entry<String, ? extends ArrayList<h.b>> entry : newSpecialViewsMap.entrySet()) {
            String key = entry.getKey();
            ArrayList<h.b> value = entry.getValue();
            if (this.specialViewsMap.containsKey(key)) {
                ArrayList<h.b> arrayList = this.specialViewsMap.get(key);
                if (arrayList != null) {
                    arrayList.addAll(value);
                }
            } else {
                this.specialViewsMap.put(key, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(k this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        sdk.pendo.io.w6.b<h0> bVar = this$0.mGlobalLayoutStateChangeSubject;
        if (bVar != null) {
            bVar.onNext(new h0());
        }
    }

    public final void a(JSONObject jSONObject) {
        this.previousScreenData = this.currentScreenData;
        this.currentScreenData = jSONObject;
    }

    @Override // sdk.pendo.io.f9.f
    public void a(WeakReference<PendoDrawerListener> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pendoDrawerListenerRef = listener;
    }

    @Override // sdk.pendo.io.e9.c
    public synchronized void a(boolean includePageViewTexts, boolean includeFeatureClickTexts, boolean includeFeatureClickNestedTexts, boolean includeRetroElementCompatibilityHashes, boolean isOldScreenIdFormat, boolean ignoreDynamicFragmentsInScrollView, boolean isRespondToScrollChangeEventsForScreenId, long globalLayoutChangeDebouncer, boolean shouldDetectClicksForAccessibility) {
        this.includePageViewTexts = includePageViewTexts;
        this.includeFeatureClickTexts = includeFeatureClickTexts;
        this.includeFeatureClickNestedTexts = includeFeatureClickTexts && includeFeatureClickNestedTexts;
        this.includeRetroElementCompatibilityHashes = includeRetroElementCompatibilityHashes;
        this.isOldScreenIdFormat = isOldScreenIdFormat;
        String str = this.PERSISTENT_IGNORE_DYNAMIC_FRAGMENTS_IN_SCROLLVIEW_KEY;
        Object valueOf = Boolean.valueOf(ignoreDynamicFragmentsInScrollView);
        Map map = this.additionalOptions;
        Object obj = map != null ? map.get(str) : null;
        if (obj != null && (obj instanceof Boolean)) {
            valueOf = obj;
        }
        this.ignoreDynamicFragmentsInScrollView = ((Boolean) valueOf).booleanValue();
        String str2 = this.PERSISTENT_IS_RESPOND_TO_SCROLL_EVENTS_KEY;
        Object valueOf2 = Boolean.valueOf(isRespondToScrollChangeEventsForScreenId);
        Map map2 = this.additionalOptions;
        Object obj2 = map2 != null ? map2.get(str2) : null;
        if (obj2 != null && (obj2 instanceof Boolean)) {
            valueOf2 = obj2;
        }
        this.isRespondToScrollChangeEventsForScreenId = ((Boolean) valueOf2).booleanValue();
        String str3 = this.PERSISTENT_GLOBAL_LAYOUT_CHANGE_DEBOUNCER_KEY;
        Object valueOf3 = Long.valueOf(globalLayoutChangeDebouncer);
        Map map3 = this.additionalOptions;
        Object obj3 = map3 != null ? map3.get(str3) : null;
        if (obj3 != null && (obj3 instanceof Long)) {
            valueOf3 = obj3;
        }
        this.globalLayoutChangeDebouncer = ((Number) valueOf3).longValue();
        this.shouldDetectClicksForAccessibility = shouldDetectClicksForAccessibility;
        N();
        try {
            Activity activity = this.currentActivityRef.get();
            Context baseContext = activity != null ? activity.getBaseContext() : null;
            if (shouldDetectClicksForAccessibility && sdk.pendo.io.g9.b.a(baseContext)) {
                f();
            }
        } catch (Exception e2) {
            PendoLogger.w(this.TAG, "Failed to re-scan for accessibility " + e2);
        }
    }
}
