package io.invertase.firebase.perf;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.util.Constants;

/* loaded from: classes2.dex */
public class ScreenTrace {
    private static final String FRAME_METRICS_AGGREGATOR_CLASSNAME = "androidx.core.app.FrameMetricsAggregator";
    private static final String TAG = "RNFirebasePerf";
    private final Activity activity;
    private final FrameMetricsAggregator frameMetricsAggregator;
    private Trace perfScreenTrace;
    private final String traceName;

    public ScreenTrace(Activity activity, String str) throws IllegalStateException {
        this.activity = activity;
        this.traceName = str;
        if (!checkScreenTraceSupport(activity)) {
            throw new IllegalStateException("Device does not support screen traces. Hardware acceleration must be enabled and Android must not be 8.0 or 8.1.");
        }
        this.frameMetricsAggregator = new FrameMetricsAggregator();
    }

    public void recordScreenTrace() {
        Log.d(TAG, "Recording screen trace " + this.traceName);
        this.frameMetricsAggregator.add(this.activity);
        this.perfScreenTrace = FirebasePerformance.startTrace(getScreenTraceName());
    }

    public void sendScreenTrace() {
        int i;
        int i2;
        SparseIntArray sparseIntArray;
        if (this.perfScreenTrace == null) {
            return;
        }
        SparseIntArray[] reset = this.frameMetricsAggregator.reset();
        int i3 = 0;
        if (reset == null || (sparseIntArray = reset[0]) == null) {
            i = 0;
            i2 = 0;
        } else {
            int i4 = 0;
            i = 0;
            i2 = 0;
            while (i3 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i3);
                int valueAt = sparseIntArray.valueAt(i3);
                i4 += valueAt;
                if (keyAt > 700) {
                    i2 += valueAt;
                }
                if (keyAt > 16) {
                    i += valueAt;
                }
                i3++;
            }
            i3 = i4;
        }
        if (i3 > 0) {
            this.perfScreenTrace.putMetric(Constants.CounterNames.FRAMES_TOTAL.toString(), i3);
        }
        if (i > 0) {
            this.perfScreenTrace.putMetric(Constants.CounterNames.FRAMES_SLOW.toString(), i);
        }
        if (i2 > 0) {
            this.perfScreenTrace.putMetric(Constants.CounterNames.FRAMES_FROZEN.toString(), i2);
        }
        Log.d(TAG, "sendScreenTrace " + this.traceName + ", name: " + getScreenTraceName() + ", total_frames: " + i3 + ", slow_frames: " + i + ", frozen_frames: " + i2);
        this.perfScreenTrace.stop();
    }

    private static boolean checkScreenTraceSupport(Activity activity) {
        boolean checkSDKVersion = checkSDKVersion();
        boolean checkFrameMetricsAggregatorClass = checkFrameMetricsAggregatorClass();
        boolean z = (activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
        boolean z2 = checkSDKVersion && checkFrameMetricsAggregatorClass && z;
        Log.d(TAG, "isValidSDKVersion: " + checkSDKVersion + "isScreenTraceSupported(" + activity + "): " + z2 + " [hasFrameMetricsAggregatorClass: " + checkFrameMetricsAggregatorClass + ", isActivityHardwareAccelerated: " + z + "]");
        return z2;
    }

    private static boolean checkSDKVersion() {
        return (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27) ? false : true;
    }

    private static boolean checkFrameMetricsAggregatorClass() {
        try {
            Class.forName(FRAME_METRICS_AGGREGATOR_CLASSNAME);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private String getScreenTraceName() {
        return Constants.SCREEN_TRACE_PREFIX + this.traceName;
    }
}
