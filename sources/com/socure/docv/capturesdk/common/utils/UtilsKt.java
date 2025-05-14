package com.socure.docv.capturesdk.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.AmplitudeReactNativeModule;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.api.DocumentType;
import com.socure.docv.capturesdk.api.Keys;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.analytics.model.Blur;
import com.socure.docv.capturesdk.common.analytics.model.CameraDevice;
import com.socure.docv.capturesdk.common.analytics.model.Edge;
import com.socure.docv.capturesdk.common.analytics.model.EventData;
import com.socure.docv.capturesdk.common.analytics.model.Face;
import com.socure.docv.capturesdk.common.analytics.model.Glare;
import com.socure.docv.capturesdk.common.analytics.model.MetricData;
import com.socure.docv.capturesdk.common.analytics.model.RegionWiseLines;
import com.socure.docv.capturesdk.common.analytics.model.SubRegionInfo;
import com.socure.docv.capturesdk.common.config.model.FragNavActions;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.Accessibility;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentComponent;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentPostRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.Content;
import com.socure.docv.capturesdk.common.network.model.stepup.Errors;
import com.socure.docv.capturesdk.common.network.model.stepup.ExtractedStepUpData;
import com.socure.docv.capturesdk.common.network.model.stepup.Label;
import com.socure.docv.capturesdk.common.network.model.stepup.MinMax;
import com.socure.docv.capturesdk.common.network.model.stepup.NewLabels;
import com.socure.docv.capturesdk.common.network.model.stepup.Screens;
import com.socure.docv.capturesdk.common.network.model.stepup.SelfieMetrics;
import com.socure.docv.capturesdk.common.network.model.stepup.TrackingProperty;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadResult;
import com.socure.docv.capturesdk.common.network.model.stepup.Websdk;
import com.socure.docv.capturesdk.common.session.a;
import com.socure.docv.capturesdk.common.upload.l;
import com.socure.docv.capturesdk.common.view.model.c;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.pipeline.model.SelfieRange;
import com.socure.docv.capturesdk.core.pipeline.model.SelfieRangeType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.FinalOutputProcessData;
import com.socure.docv.capturesdk.core.processor.model.Output;
import com.socure.docv.capturesdk.feature.orchestrator.data.Config;
import com.socure.docv.capturesdk.feature.orchestrator.data.ConfigRequest;
import com.socure.docv.capturesdk.feature.orchestrator.data.Flow;
import com.socure.docv.capturesdk.feature.orchestrator.data.FlowRequest;
import com.socure.docv.capturesdk.feature.scanner.data.CardGuide;
import com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBox;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBoxConstraintData;
import io.castle.android.api.model.Event;
import io.sentry.ProfilingTraceData;
import io.sentry.Session;
import io.sentry.protocol.App;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.RequestBody;

@Metadata(bv = {}, d1 = {"\u0000\u0080\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001aH\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0017j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u00182\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015H\u0000\u001a.\u0010\u001b\u001a\u0004\u0018\u00010\u00112\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015H\u0000\u001a\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a\u0018\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0016\u0010)\u001a\u00020(2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0000\u001a\u0010\u0010*\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0000\u001a\u0012\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010,\u001a\u00020+H\u0000\u001a*\u00104\u001a\u0002032\u0006\u0010/\u001a\u00020\u00142\u0018\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110100H\u0000\u001a\u0018\u00105\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a\u0018\u00106\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0018\u00107\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a\u0018\u00108\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a\u0010\u0010;\u001a\u00020(2\u0006\u0010:\u001a\u000209H\u0000\u001a\u0010\u0010=\u001a\u00020(2\u0006\u0010<\u001a\u00020\u0011H\u0000\u001a\u0010\u0010>\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0011H\u0000\u001a\u0010\u0010?\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0011H\u0000\u001aH\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020@0\u0017j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020@`\u00182\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015H\u0000\u001a\u0012\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010C\u001a\u00020BH\u0000\u001a\u0010\u0010H\u001a\u00020\u00112\u0006\u0010G\u001a\u00020FH\u0000\u001a\u0010\u0010I\u001a\u00020\u00112\u0006\u0010G\u001a\u00020FH\u0000\u001a \u0010P\u001a\u0002032\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020NH\u0000\u001a\u0010\u0010R\u001a\u00020(2\u0006\u0010Q\u001a\u00020BH\u0000\u001a\u0010\u0010T\u001a\u00020(2\u0006\u0010S\u001a\u00020\u0011H\u0000\u001a\b\u0010U\u001a\u00020(H\u0000\u001a\b\u0010V\u001a\u00020(H\u0000\u001a\u0012\u0010Z\u001a\u00020Y2\b\u0010X\u001a\u0004\u0018\u00010WH\u0000\u001a\u0014\u0010\\\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010\u0011H\u0000\u001a.\u0010b\u001a\b\u0012\u0004\u0012\u00020]0\u00042\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\u00042\u0006\u0010_\u001a\u00020(2\b\u0010a\u001a\u0004\u0018\u00010`H\u0000\u001a\u001e\u0010e\u001a\u00020d2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020]0\u00042\u0006\u0010c\u001a\u00020]H\u0000\u001a\u0010\u0010g\u001a\u00020B2\u0006\u0010f\u001a\u00020]H\u0000\u001a\u0010\u0010h\u001a\u00020B2\u0006\u0010f\u001a\u00020]H\u0000\u001a\u0010\u0010i\u001a\u00020]2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a\u0010\u0010j\u001a\u00020]2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001aa\u0010n\u001a \u0012\u0004\u0012\u00020\u0011\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011010\u0004012\u0006\u0010k\u001a\u00020\u00112*\u0010m\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011010l\"\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001101H\u0000¢\u0006\u0004\bn\u0010o\u001a\u001c\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011012\u0006\u0010q\u001a\u00020pH\u0000\u001a8\u0010u\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011010\u0004\u0018\u0001012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010t\u001a\u00020sH\u0000\u001a\u0014\u0010w\u001a\u0004\u0018\u00010`2\b\u0010v\u001a\u0004\u0018\u00010\u0011H\u0000\u001a\u0010\u0010x\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a&\u0010y\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0011012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001aF\u0010~\u001a \u0012\u0004\u0012\u00020\u0011\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011010\u0004012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010{\u001a\u00020z2\u0006\u0010|\u001a\u00020\u00112\u0006\u0010}\u001a\u00020pH\u0000\u001a\"\u0010\u0081\u0001\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$2\u0007\u0010\u0080\u0001\u001a\u00020\u007fH\u0000\u001a#\u0010\u0084\u0001\u001a\u0002032\u0007\u0010O\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020(2\u0006\u0010t\u001a\u00020sH\u0000\u001a\u0013\u0010\u0087\u0001\u001a\u0002032\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001H\u0000\u001a\u0011\u0010\u0088\u0001\u001a\u00020(2\u0006\u0010G\u001a\u00020FH\u0000\u001a\u0011\u0010\u0089\u0001\u001a\u00020\u00052\u0006\u0010G\u001a\u00020FH\u0000\u001aP\u0010\u008d\u0001\u001a\u00030\u008a\u00012!\u0010\u008b\u0001\u001a\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100012!\u0010\u008c\u0001\u001a\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010001H\u0000\u001a-\u0010\u008e\u0001\u001a\u00030\u008a\u00012!\u0010\u008b\u0001\u001a\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010001H\u0000\u001aZ\u0010\u0090\u0001\u001aD\u0012\u001e\u0012\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010001\u0012\u001e\u0012\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010001\u0018\u0001012\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a*\u0010\u0093\u0001\u001a\u00030\u008a\u00012\u000e\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u0001002\u000e\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u000100H\u0000\u001a\u0014\u0010\u0095\u0001\u001a\u00030\u008a\u00012\b\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0000\u001a+\u0010\u0098\u0001\u001a\u00020(2\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0096\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0097\u0001\u001a\u00020(H\u0000\u001a\u009b\u0001\u0010\u009b\u0001\u001a\u00020(2G\u0010\u0099\u0001\u001aB\u0012\u001e\u0012\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010001\u0012\u001e\u0012\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010001012G\u0010\u009a\u0001\u001aB\u0012\u001e\u0012\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010001\u0012\u001e\u0012\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u000100\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u0001000101H\u0000\u001a\u001b\u0010\u009e\u0001\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020\u00052\u0007\u0010\u009d\u0001\u001a\u00020\u0005H\u0000\u001a\u001b\u0010¡\u0001\u001a\u00020\u00052\u0007\u0010\u009f\u0001\u001a\u00020\u00052\u0007\u0010 \u0001\u001a\u00020\u0005H\u0000\u001a\u001b\u0010¤\u0001\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\b\u0010£\u0001\u001a\u00030¢\u0001H\u0000\u001a/\u0010©\u0001\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010£\u0001\u001a\u00030¢\u00012\b\u0010¦\u0001\u001a\u00030¥\u00012\b\u0010¨\u0001\u001a\u00030§\u0001H\u0000\u001a\u001e\u0010«\u0001\u001a\u00030ª\u00012\b\u0010¦\u0001\u001a\u00030¥\u00012\b\u0010¨\u0001\u001a\u00030§\u0001H\u0000\u001a&\u0010¯\u0001\u001a\u00030®\u00012\b\u0010\u00ad\u0001\u001a\u00030¬\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u00052\u0007\u0010 \u0001\u001a\u00020\u0005H\u0000\u001a\u001d\u0010³\u0001\u001a\u00030°\u00012\b\u0010±\u0001\u001a\u00030°\u00012\u0007\u0010²\u0001\u001a\u00020\u0005H\u0000\u001a(\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00012\b\u0010µ\u0001\u001a\u00030´\u00012\u0007\u0010¶\u0001\u001a\u00020B2\u0007\u0010·\u0001\u001a\u00020BH\u0000\u001a\u0019\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\u000500*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a$\u0010¾\u0001\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010¼\u0001\u001a\u00030»\u00012\u0007\u0010½\u0001\u001a\u00020(H\u0000\u001a'\u0010Ä\u0001\u001a\u00030Ã\u00012\u001b\u0010Â\u0001\u001a\u0016\u0012\u0005\u0012\u00030À\u00010¿\u0001j\n\u0012\u0005\u0012\u00030À\u0001`Á\u0001H\u0000\u001a8\u0010Ê\u0001\u001a\u00030É\u00012\u0006\u0010Q\u001a\u00020B2\t\u0010Å\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010Æ\u0001\u001a\u00020B2\u0007\u0010Ç\u0001\u001a\u00020\u00112\u0007\u0010È\u0001\u001a\u00020\u0011H\u0000\u001a\u001d\u0010Ï\u0001\u001a\u00030Î\u00012\u0007\u0010Ë\u0001\u001a\u00020(2\b\u0010Í\u0001\u001a\u00030Ì\u0001H\u0000\u001a&\u0010Ó\u0001\u001a\u00020B2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Ñ\u0001\u001a\u00030Ð\u00012\u0007\u0010Ò\u0001\u001a\u00020BH\u0000\u001ad\u0010Ø\u0001\u001a\u0002032\u0019\u0010Ô\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001101002\u0006\u0010/\u001a\u00020\u00142\u001b\u0010Â\u0001\u001a\u0016\u0012\u0005\u0012\u00030À\u00010¿\u0001j\n\u0012\u0005\u0012\u00030À\u0001`Á\u00012\u0007\u0010Õ\u0001\u001a\u00020(2\u0007\u0010Ö\u0001\u001a\u00020B2\u0007\u0010×\u0001\u001a\u00020BH\u0000\u001a&\u0010Ý\u0001\u001a\u0002032\u0007\u0010Õ\u0001\u001a\u00020(2\b\u0010Ú\u0001\u001a\u00030Ù\u00012\b\u0010Ü\u0001\u001a\u00030Û\u0001H\u0000\u001a7\u0010ß\u0001\u001a\u0002032\u0019\u0010Ô\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001101002\u0007\u0010Þ\u0001\u001a\u00020p2\b\u0010Ú\u0001\u001a\u00030Ù\u0001H\u0000\u001ap\u0010æ\u0001\u001a\u0004\u0018\u00018\u0002\"\n\b\u0000\u0010á\u0001*\u00030à\u0001\"\n\b\u0001\u0010â\u0001*\u00030à\u0001\"\n\b\u0002\u0010ã\u0001*\u00030à\u00012\t\u0010\u0099\u0001\u001a\u0004\u0018\u00018\u00002\t\u0010\u009a\u0001\u001a\u0004\u0018\u00018\u00012\u001c\u0010å\u0001\u001a\u0017\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00020ä\u0001H\u0086\bø\u0001\u0000¢\u0006\u0006\bæ\u0001\u0010ç\u0001\u001a\u0013\u0010è\u0001\u001a\u00020(2\b\u0010Í\u0001\u001a\u00030Ì\u0001H\u0000\u001a\u0013\u0010ë\u0001\u001a\u00020(2\b\u0010ê\u0001\u001a\u00030é\u0001H\u0000\u001a\u0013\u0010ì\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020$H\u0000\u001a\u0011\u0010í\u0001\u001a\u00020\u00112\u0006\u0010G\u001a\u00020FH\u0002\u001a\u0011\u0010î\u0001\u001a\u00020\u00112\u0006\u0010G\u001a\u00020FH\u0002\u001a\u0011\u0010ï\u0001\u001a\u00020\u00112\u0006\u0010G\u001a\u00020FH\u0002\u001a\u001e\u0010ñ\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110ð\u00012\u0006\u0010G\u001a\u00020FH\u0000\u001a'\u0010õ\u0001\u001a\u00020\u00112\b\u0010ó\u0001\u001a\u00030ò\u00012\t\u0010ô\u0001\u001a\u0004\u0018\u00010BH\u0000¢\u0006\u0006\bõ\u0001\u0010ö\u0001\u001a=\u0010ø\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011010l2\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010÷\u0001\u001a\u00020p2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0006\bø\u0001\u0010ù\u0001\u001a\u0019\u0010ú\u0001\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0019\u0010û\u0001\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a&\u0010þ\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110ð\u00012\u000e\u0010ý\u0001\u001a\t\u0012\u0005\u0012\u00030ü\u00010\u0004H\u0000\u001a\u001d\u0010\u0080\u0002\u001a\u00020(2\u0007\u0010f\u001a\u00030À\u00012\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0011H\u0000\u001a\u0012\u0010\u0082\u0002\u001a\u00020\u00112\u0007\u0010\u0081\u0002\u001a\u00020\u0011H\u0000\u001a\u0012\u0010\u0084\u0002\u001a\u00030\u0083\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a\u0010\u0010\u0086\u0002\u001a\t\u0012\u0005\u0012\u00030\u0085\u00020\u0004H\u0000\u001a\n\u0010\u0088\u0002\u001a\u00030\u0087\u0002H\u0000\u001a\u0016\u0010\u008b\u0002\u001a\u00030\u008a\u00022\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u0085\u0002H\u0000\u001a\u0011\u0010\u008c\u0002\u001a\u00020(2\u0006\u0010G\u001a\u00020FH\u0002\u001a+\u0010\u008e\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110ð\u00012\b\u0010Ñ\u0001\u001a\u00030Ð\u00012\t\u0010\u008d\u0002\u001a\u0004\u0018\u00010WH\u0000\u001a\u001a\u0010\u008f\u0002\u001a\t\u0012\u0005\u0012\u00030\u0085\u00020\u00042\b\u0010Ñ\u0001\u001a\u00030Ð\u0001H\u0000\"\u0017\u0010\u0090\u0002\u001a\u00020\u00118\u0002X\u0082T¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0092\u0002"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "cornerMetric", "Lcom/socure/docv/capturesdk/common/analytics/model/Edge;", "getCornerData", "", "", "regionList", "Lcom/socure/docv/capturesdk/common/analytics/model/RegionWiseLines;", "getRegionWiseData", "blurMetric", "Lcom/socure/docv/capturesdk/common/analytics/model/Blur;", "getBlurData", "glareMetric", "Lcom/socure/docv/capturesdk/common/analytics/model/Glare;", "getGlareData", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "scanType", "", "getLabel", "Ljava/util/LinkedHashMap;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadImage;", "Lkotlin/collections/LinkedHashMap;", "uploadMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCaptureModeMap", "uploadImageMap", "extractedDataToJson", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Screens;", "screens", "getCaptureTitleText", "Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;", "newLabels", "getHelpTitleText", "getConfirmationTitleText", "getKeepSteadyText", "Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;", "detectionCallback", "getGuidingMessageForSelfie", "metrics", "", "isFaceFoundForSelfie", "getDisplayText", "Lcom/socure/docv/capturesdk/core/processor/model/Output;", "output", "Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;", "getSelfieMetrics", "uploadImage", "", "Lkotlin/Pair;", "mutableList", "", "appendSelfieParams", "getWarningDarkPrimaryText", "getWarningBlurPrimaryText", "getManualCapturePrimaryText", "getManualCaptureSecondaryText", "Lcom/socure/docv/capturesdk/common/analytics/model/MetricData;", "metricData", "checkMinimumCameraResolutionSupport", "text", "startsWithPkEndsWithFiller", "fixAlphabets", "fixSpecialChars", "", "getCapturedImageMap", "", "responseCode", "Lcom/socure/docv/capturesdk/api/ResponseCode;", "getResponseCode", "Landroid/content/Context;", "context", "getPackageName", "getDeviceId", "Lcom/socure/docv/capturesdk/common/network/model/ApiType;", "apiType", "Lcom/socure/docv/capturesdk/core/pipeline/model/ApiResponse;", "result", "Landroid/content/Intent;", "data", "updateErrorDataBasedOnApiType", ApiConstant.KEY_CODE, "isDefaultCode", "msg", "isDefaultMsg", "isOldOs", "lowRamDevice", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/Config;", "config", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequest;", "getConfigForApi", "configJson", "getConfig", "Lcom/socure/docv/capturesdk/common/view/model/c;", "skipScreens", "isSelfieEnabled", "Lcom/socure/docv/capturesdk/api/DocumentType;", ApiConstant.DOCUMENT_TYPE, "setFragNavActions", DatabaseConstants.KEY_FIELD, "Lcom/socure/docv/capturesdk/common/config/model/FragNavActions;", "getFragNavActions", Event.EVENT_TYPE_SCREEN, "getNavActionId", "getNavFragId", "getCurrentScreenForScanner", "getCurrentScreenForPreview", IterableConstants.KEY_EVENT_NAME, "", "args", "addEvent", "(Ljava/lang/String;[Lkotlin/Pair;)Lkotlin/Pair;", "", "duration", "getEventDurationPair", "Lcom/socure/docv/capturesdk/core/processor/model/FinalOutputProcessData;", "finalOutputProcessData", "getEventDataFromExtractedData", "docTypeLabel", "getDocType", "getPowerByLabel", "getManualWarningMessages", "Lcom/socure/docv/capturesdk/common/analytics/a;", "docSelection", "cause", "viewShownTime", "getRetakeEvent", "Lcom/socure/docv/capturesdk/common/session/a;", "sm", "getDetectionWarningMsg", "Lcom/socure/docv/capturesdk/core/extractor/model/c;", "faceFound", "appendFaceDataToOutput", "Landroid/view/View;", "view", "requestFocusAccessibilityEvent", "isTalkBackEnabled", "getFontScale", "", "line", "referenceLine", "relativeTilt", "calcAngleWithX", "coords", "findLargestSides", "coordinates1", "coordinates2", "distanceBetween", "angle", "normaliseAngle", "tiltTolerance", "isBBoxVertical", "flipDoc", "p1", "p2", "comparePareOfPairs", ViewHierarchyNode.JsonKeys.X, ViewProps.SCALE_X, ViewProps.TRANSLATE_X, ViewHierarchyNode.JsonKeys.Y, ViewProps.SCALE_Y, ViewProps.TRANSLATE_Y, "Lcom/socure/docv/capturesdk/common/network/model/stepup/App;", App.TYPE, "getSelfieAccessibilityAnnouncementMessage", "", "floatArray", "Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "dimension", "getCardAccessibilityAnnouncement", "Lcom/socure/docv/capturesdk/feature/scanner/data/CardGuide;", "getCardPosition", "Landroid/graphics/Rect;", "rect", "Landroid/graphics/RectF;", "translateRect", "Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBox;", "guidingBox", "scaleValue", "getScaledGuidingBoxArea", "Landroid/text/Spanned;", "spanned", ViewProps.START, ViewProps.END, "", "getSpannedText", "removeNegative", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Accessibility;", "accessibility", "noAnalysisMode", "getInitialAnnouncement", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/utils/Screen;", "Lkotlin/collections/ArrayList;", "screenFlow", "Lokhttp3/RequestBody;", "getDocumentTypeBody", "message", "internalErrorCode", "internalErrorMessage", "endpoint", "Lcom/socure/docv/capturesdk/common/analytics/model/EventData;", "getEventErrorData", "given", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Consent;", "consent", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentPostRequest;", "formConsentRequest", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Websdk;", "websdk", "defaultValue", "getAttemptCount", "eventParams", ApiConstant.VALIDATE_IMAGE, "attemptCount", "maxAttemptCount", "appendUploadCommonEventParams", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadResult;", "uploadResult", "Lcom/socure/docv/capturesdk/common/upload/l;", "verificationCallBack", "validateUploadResponse", "uploadStartTime", "appendUploadSuccessEventParams", "", "T1", "T2", "R", "Lkotlin/Function2;", "block", "safeLet", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "consentValidated", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentComponent;", "component", "consentComponentInvalid", "getLastFailure", "getTargetSdkVersion", "getMinSdkVersion", "getCompileSdkVersion", "", "getLateAttrs", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Errors;", Session.JsonKeys.ERRORS, "errorCode", "getPreviewWarningMsg", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/Errors;Ljava/lang/Integer;)Ljava/lang/String;", "captureDuration", "getScannedEventAttrs", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;JLcom/socure/docv/capturesdk/core/processor/model/Output;)[Lkotlin/Pair;", "getCornerDetectionFailedText", "getDocumentTooCloseMsg", "Lcom/socure/docv/capturesdk/common/network/model/stepup/TrackingProperty;", "trackingProperties", "getTrackingPropertyMap", "uuid", "isUploadUrlAppendRequired", "docUploadUuid", "appendUploadUrl", "Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBoxConstraintData;", "getGuidingBoxData", "Lcom/socure/docv/capturesdk/core/pipeline/model/SelfieRange;", "getDefaultSelfieRangeValues", "Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;", "getDefaultSelfieAngleMinMax", "selfieRange", "Lkotlin/ranges/IntRange;", "getSelfieRange", "isGooglePlayServicesAvailable", "userConfig", "getFlowResponseMap", "getConfigSelfieRangeValues", "TAG", "Ljava/lang/String;", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class UtilsKt {
    private static final String TAG = "SDLT_UTIL";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            int[] iArr = new int[ScanType.values().length];
            iArr[ScanType.SELFIE.ordinal()] = 1;
            iArr[ScanType.PASSPORT.ordinal()] = 2;
            iArr[ScanType.LICENSE_FRONT.ordinal()] = 3;
            iArr[ScanType.LICENSE_BACK.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DetectionCallback.values().length];
            iArr2[DetectionCallback.FACE_NOT_FOUND.ordinal()] = 1;
            iArr2[DetectionCallback.FACE_AT_LEFT.ordinal()] = 2;
            iArr2[DetectionCallback.FACE_AT_UP.ordinal()] = 3;
            iArr2[DetectionCallback.FACE_AT_DOWN.ordinal()] = 4;
            iArr2[DetectionCallback.FACE_AT_RIGHT.ordinal()] = 5;
            iArr2[DetectionCallback.FACE_IS_BIG.ordinal()] = 6;
            iArr2[DetectionCallback.FACE_TOO_SMALL.ordinal()] = 7;
            iArr2[DetectionCallback.FACE_ORIENTATION_WRONG.ordinal()] = 8;
            iArr2[DetectionCallback.LOW_BRIGHTNESS.ordinal()] = 9;
            iArr2[DetectionCallback.GLARE_DETECTED.ordinal()] = 10;
            iArr2[DetectionCallback.BLUR_DETECTED.ordinal()] = 11;
            iArr2[DetectionCallback.CORNER_DETECTION_FAILED.ordinal()] = 12;
            iArr2[DetectionCallback.CAPTURING.ordinal()] = 13;
            iArr2[DetectionCallback.READY_FOR_SELFIE_CAPTURE.ordinal()] = 14;
            iArr2[DetectionCallback.BARCODE_NOT_FOUND.ordinal()] = 15;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ApiType.values().length];
            iArr3[ApiType.UPLOAD_END.ordinal()] = 1;
            iArr3[ApiType.UPLOAD_STATUS.ordinal()] = 2;
            iArr3[ApiType.START.ordinal()] = 3;
            iArr3[ApiType.START_UPLOAD.ordinal()] = 4;
            iArr3[ApiType.CONFIG.ordinal()] = 5;
            iArr3[ApiType.FLOW.ordinal()] = 6;
            iArr3[ApiType.FETCH_CONSENT.ordinal()] = 7;
            iArr3[ApiType.IMAGE_UPLOAD.ordinal()] = 8;
            iArr3[ApiType.POST_CONSENT.ordinal()] = 9;
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[DocumentType.values().length];
            iArr4[DocumentType.LICENSE.ordinal()] = 1;
            iArr4[DocumentType.PASSPORT.ordinal()] = 2;
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[c.values().length];
            iArr5[c.SELECTOR.ordinal()] = 1;
            iArr5[c.SCANNER_FRONT.ordinal()] = 2;
            iArr5[c.SCANNER_BACK.ordinal()] = 3;
            iArr5[c.SCANNER_PASSPORT.ordinal()] = 4;
            iArr5[c.SCANNER_SELFIE.ordinal()] = 5;
            iArr5[c.PREVIEW_FRONT.ordinal()] = 6;
            iArr5[c.PREVIEW_BACK.ordinal()] = 7;
            iArr5[c.PREVIEW_PASSPORT.ordinal()] = 8;
            iArr5[c.PREVIEW_SELFIE.ordinal()] = 9;
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[CardGuide.values().length];
            iArr6[CardGuide.MOVE_PHONE_UP.ordinal()] = 1;
            iArr6[CardGuide.MOVE_PHONE_DOWN.ordinal()] = 2;
            iArr6[CardGuide.MOVE_PHONE_LEFT.ordinal()] = 3;
            iArr6[CardGuide.MOVE_PHONE_RIGHT.ordinal()] = 4;
            iArr6[CardGuide.CARD_TOO_CLOSE.ordinal()] = 5;
            iArr6[CardGuide.CARD_NOT_FOUND.ordinal()] = 6;
            $EnumSwitchMapping$5 = iArr6;
        }
    }

    public static final Pair<String, List<Pair<String, String>>> addEvent(String eventName, Pair<String, String>... args) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(args, "args");
        b.a(TAG, "addEvent called");
        return new Pair<>(eventName, CollectionsKt.listOf(Arrays.copyOf(args, args.length)));
    }

    public static final void appendFaceDataToOutput(com.socure.docv.capturesdk.core.extractor.model.c data, boolean z, FinalOutputProcessData finalOutputProcessData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(finalOutputProcessData, "finalOutputProcessData");
        b.a(TAG, "called appendFaceDataToOutput");
        finalOutputProcessData.setFaceFound(z);
        finalOutputProcessData.setFace(CollectionsKt.arrayListOf(new Face(null, Boolean.valueOf(z), Double.valueOf(1.0d), Integer.valueOf((int) data.b), 1, null)));
    }

    public static final void appendSelfieParams(UploadImage uploadImage, List<Pair<String, String>> mutableList) {
        Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
        Intrinsics.checkNotNullParameter(mutableList, "mutableList");
        SelfieMetrics selfieMetrics = uploadImage.getSelfieMetrics();
        if (selfieMetrics != null) {
            Double pitch = selfieMetrics.getPitch();
            if (pitch != null) {
                mutableList.add(new Pair<>("pitch", String.valueOf(pitch.doubleValue())));
            }
            Double yaw = selfieMetrics.getYaw();
            if (yaw != null) {
                mutableList.add(new Pair<>("yaw", String.valueOf(yaw.doubleValue())));
            }
            Double roll = selfieMetrics.getRoll();
            if (roll != null) {
                mutableList.add(new Pair<>("roll", String.valueOf(roll.doubleValue())));
            }
            Integer faceWidth = selfieMetrics.getFaceWidth();
            if (faceWidth != null) {
                mutableList.add(new Pair<>("face_width", String.valueOf(faceWidth.intValue())));
            }
            Integer faceHeight = selfieMetrics.getFaceHeight();
            if (faceHeight != null) {
                mutableList.add(new Pair<>("face_height", String.valueOf(faceHeight.intValue())));
            }
            Float faceRatio = selfieMetrics.getFaceRatio();
            if (faceRatio != null) {
                mutableList.add(new Pair<>("face_ratio", String.valueOf(faceRatio.floatValue())));
            }
            String displayText = selfieMetrics.getDisplayText();
            if (displayText != null) {
                mutableList.add(new Pair<>("display_text", displayText));
            }
        }
    }

    public static final void appendUploadCommonEventParams(List<Pair<String, String>> eventParams, UploadImage uploadImage, ArrayList<Screen> screenFlow, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(eventParams, "eventParams");
        Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
        Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
        b.b(TAG, "appendUploadCommonEventParams called");
        Utils utils = Utils.INSTANCE;
        if (utils.isSelfie$capturesdk_productionRelease(uploadImage.getScanType())) {
            appendSelfieParams(uploadImage, eventParams);
        }
        eventParams.add(new Pair<>("height", String.valueOf((int) uploadImage.getDimension().getH())));
        eventParams.add(new Pair<>("width", String.valueOf((int) uploadImage.getDimension().getW())));
        eventParams.add(new Pair<>("facet_type", utils.getDocSelFacet$capturesdk_productionRelease(screenFlow, uploadImage.getScanType())));
        eventParams.add(new Pair<>("validate_image", String.valueOf(z)));
        eventParams.add(new Pair<>("attempt_count", String.valueOf(i)));
        eventParams.add(new Pair<>(Event.EVENT_TYPE_SCREEN, "preview"));
    }

    public static final void appendUploadSuccessEventParams(List<Pair<String, String>> eventParams, long j, UploadResult uploadResult) {
        Intrinsics.checkNotNullParameter(eventParams, "eventParams");
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        b.b(TAG, "appendUploadSuccessEventParams called");
        eventParams.add(new Pair<>(Keys.KEY_DOCUMENT_UUID, uploadResult.getUuid()));
        eventParams.add(new Pair<>("duration", String.valueOf(System.currentTimeMillis() - j)));
        eventParams.add(new Pair<>("upload_reference_id", uploadResult.getReferenceId()));
        String error = uploadResult.getError();
        if (error != null) {
            eventParams.add(new Pair<>("internal_error_message", error));
        }
        Integer errorCode = uploadResult.getErrorCode();
        if (errorCode != null) {
            eventParams.add(new Pair<>("internal_error_code", String.valueOf(errorCode.intValue())));
        }
    }

    public static final String appendUploadUrl(String docUploadUuid) {
        Intrinsics.checkNotNullParameter(docUploadUuid, "docUploadUuid");
        b.b(TAG, "appendUploadUrl called");
        return ApiConstant.UPLOAD_URL + File.separator + docUploadUuid;
    }

    public static final double calcAngleWithX(Pair<? extends List<Double>, ? extends List<Double>> line) {
        Intrinsics.checkNotNullParameter(line, "line");
        Double valueOf = Double.valueOf(0.0d);
        double relativeTilt = relativeTilt(line, new Pair(CollectionsKt.mutableListOf(valueOf, valueOf), CollectionsKt.mutableListOf(Double.valueOf(10.0d), valueOf)));
        return relativeTilt < 0.0d ? relativeTilt + 360.0d : relativeTilt;
    }

    public static final boolean checkMinimumCameraResolutionSupport(MetricData metricData) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(metricData, "metricData");
        b.b(TAG, "checkMinimumCameraResolution");
        ArrayList<CameraDevice> devices = metricData.getDevices();
        Iterator<T> it = devices.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((CameraDevice) obj2).getLabel(), ConstantsKt.BACK_CAMERA)) {
                break;
            }
        }
        CameraDevice cameraDevice = (CameraDevice) obj2;
        Iterator<T> it2 = devices.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.areEqual(((CameraDevice) next).getLabel(), ConstantsKt.FRONT_CAMERA)) {
                obj = next;
                break;
            }
        }
        CameraDevice cameraDevice2 = (CameraDevice) obj;
        if (cameraDevice != null && (cameraDevice.getCapabilities().getWidth().getMax() < 2048 || cameraDevice.getCapabilities().getHeight().getMax() < 1152)) {
            return false;
        }
        if (cameraDevice2 != null) {
            return cameraDevice2.getCapabilities().getWidth().getMax() >= 1280 && cameraDevice2.getCapabilities().getHeight().getMax() >= 720;
        }
        return true;
    }

    public static final boolean comparePareOfPairs(Pair<? extends Pair<? extends List<Double>, ? extends List<Double>>, ? extends Pair<? extends List<Double>, ? extends List<Double>>> p1, Pair<? extends Pair<? extends List<Double>, ? extends List<Double>>, ? extends Pair<? extends List<Double>, ? extends List<Double>>> p2) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        return Intrinsics.areEqual(p1.getFirst().getFirst(), p2.getFirst().getFirst()) && Intrinsics.areEqual(p1.getFirst().getSecond(), p2.getFirst().getSecond()) && Intrinsics.areEqual(p1.getSecond().getFirst(), p2.getSecond().getFirst()) && Intrinsics.areEqual(p1.getSecond().getSecond(), p2.getSecond().getSecond());
    }

    public static final boolean consentComponentInvalid(ConsentComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        if (StringsKt.isBlank(component.getContent()) || StringsKt.isBlank(component.getType())) {
            return true;
        }
        if (Intrinsics.areEqual(component.getType(), Content.CHECKBOX.getLabel())) {
            String id = component.getId();
            if ((id == null || StringsKt.isBlank(id)) || component.getMandatory() == null) {
                return true;
            }
        }
        return false;
    }

    public static final boolean consentValidated(Consent consent) {
        String str;
        Intrinsics.checkNotNullParameter(consent, "consent");
        if (!StringsKt.isBlank(consent.getVersion()) && !StringsKt.isBlank(consent.getLanguage()) && !StringsKt.isBlank(consent.getTitle()) && !StringsKt.isBlank(consent.getBtnLabelAgree()) && !StringsKt.isBlank(consent.getBtnLabelDecline()) && !StringsKt.isBlank(consent.getWarningMsg()) && !StringsKt.isBlank(consent.getWarningBtnLabel()) && !consent.getComponents().isEmpty()) {
            for (ConsentComponent consentComponent : consent.getComponents()) {
                if (consentComponentInvalid(consentComponent)) {
                    str = "found an invalid component: " + consentComponent;
                }
            }
            return true;
        }
        str = "one of the fields is empty or blank";
        b.a(TAG, str, null, 4, null);
        return false;
    }

    public static final double distanceBetween(List<Double> coordinates1, List<Double> coordinates2) {
        Intrinsics.checkNotNullParameter(coordinates1, "coordinates1");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates2");
        return Math.hypot(coordinates1.get(0).doubleValue() - coordinates2.get(0).doubleValue(), coordinates1.get(1).doubleValue() - coordinates2.get(1).doubleValue());
    }

    public static final String extractedDataToJson(LinkedHashMap<ScanType, UploadImage> uploadImageMap) {
        Intrinsics.checkNotNullParameter(uploadImageMap, "uploadImageMap");
        ExtractedStepUpData baseExtractedDataForEnd = Utils.INSTANCE.getBaseExtractedDataForEnd(uploadImageMap);
        if (baseExtractedDataForEnd != null) {
            return new Gson().toJson(baseExtractedDataForEnd);
        }
        return null;
    }

    public static final Pair<Pair<List<Double>, List<Double>>, Pair<List<Double>, List<Double>>> findLargestSides(List<Float> coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        Pair pair = new Pair(CollectionsKt.mutableListOf(Double.valueOf(coords.get(0).floatValue()), Double.valueOf(coords.get(1).floatValue())), CollectionsKt.mutableListOf(Double.valueOf(coords.get(3).floatValue()), Double.valueOf(coords.get(4).floatValue())));
        Pair pair2 = new Pair(CollectionsKt.mutableListOf(Double.valueOf(coords.get(3).floatValue()), Double.valueOf(coords.get(4).floatValue())), CollectionsKt.mutableListOf(Double.valueOf(coords.get(6).floatValue()), Double.valueOf(coords.get(7).floatValue())));
        Pair pair3 = new Pair(CollectionsKt.mutableListOf(Double.valueOf(coords.get(9).floatValue()), Double.valueOf(coords.get(10).floatValue())), CollectionsKt.mutableListOf(Double.valueOf(coords.get(6).floatValue()), Double.valueOf(coords.get(7).floatValue())));
        Pair pair4 = new Pair(CollectionsKt.mutableListOf(Double.valueOf(coords.get(0).floatValue()), Double.valueOf(coords.get(1).floatValue())), CollectionsKt.mutableListOf(Double.valueOf(coords.get(9).floatValue()), Double.valueOf(coords.get(10).floatValue())));
        if (distanceBetween((List) pair.getFirst(), (List) pair.getSecond()) > distanceBetween((List) pair2.getFirst(), (List) pair2.getSecond()) && distanceBetween((List) pair3.getFirst(), (List) pair3.getSecond()) > distanceBetween((List) pair4.getFirst(), (List) pair4.getSecond())) {
            b.b(TAG, "largest side is 1, 3");
            return new Pair<>(pair, pair3);
        }
        if (distanceBetween((List) pair2.getFirst(), (List) pair2.getSecond()) <= distanceBetween((List) pair3.getFirst(), (List) pair3.getSecond()) || distanceBetween((List) pair4.getFirst(), (List) pair4.getSecond()) <= distanceBetween((List) pair.getFirst(), (List) pair.getSecond())) {
            return null;
        }
        b.b(TAG, "largest side is 2, 4");
        return new Pair<>(pair2, pair4);
    }

    public static final String fixAlphabets(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "0", "O", false, 4, (Object) null), "1", "I", false, 4, (Object) null), "5", ExifInterface.LATITUDE_SOUTH, false, 4, (Object) null), "8", "B", false, 4, (Object) null), ExifInterface.GPS_MEASUREMENT_2D, "Z", false, 4, (Object) null);
    }

    public static final String fixSpecialChars(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "«", length >= 44 ? "<" : "<<", false, 4, (Object) null), "»", length >= 44 ? ">" : ">>", false, 4, (Object) null), "ó", "6", false, 4, (Object) null), "Ó", "6", false, 4, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean flipDoc(java.util.List<java.lang.Float> r10, double r11, boolean r13) {
        /*
            java.lang.String r0 = "coords"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 63
            r9 = 0
            r1 = r10
            java.lang.String r0 = kotlin.collections.CollectionsKt.joinToString$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "flipDoc - "
            r1.<init>(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = ", "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "SDLT_UTIL"
            com.socure.docv.capturesdk.common.logger.b.b(r2, r0)
            kotlin.Pair r10 = findLargestSides(r10)
            r0 = 0
            if (r10 == 0) goto Lb9
            java.lang.Object r3 = r10.getFirst()
            kotlin.Pair r3 = (kotlin.Pair) r3
            double r3 = calcAngleWithX(r3)
            double r3 = normaliseAngle(r3)
            java.lang.Object r10 = r10.getSecond()
            kotlin.Pair r10 = (kotlin.Pair) r10
            double r5 = calcAngleWithX(r10)
            double r5 = normaliseAngle(r5)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r7 = "angleWX detected: "
            r10.<init>(r7)
            java.lang.StringBuilder r10 = r10.append(r3)
            java.lang.StringBuilder r10 = r10.append(r1)
            java.lang.StringBuilder r10 = r10.append(r5)
            java.lang.String r1 = " | is vertical: $"
            java.lang.StringBuilder r10 = r10.append(r1)
            java.lang.StringBuilder r10 = r10.append(r13)
            java.lang.String r10 = r10.toString()
            com.socure.docv.capturesdk.common.logger.b.b(r2, r10)
            double r1 = r3 * r5
            r7 = 0
            int r10 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            r1 = 1
            if (r10 < 0) goto L9b
            double r7 = java.lang.Math.abs(r3)
            int r10 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r10 > 0) goto L9b
            double r7 = java.lang.Math.abs(r5)
            int r10 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r10 > 0) goto L9b
            if (r13 != 0) goto Lb3
        L9b:
            double r2 = java.lang.Math.abs(r3)
            r7 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r7 = r7 - r11
            int r10 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r10 < 0) goto Lb5
            double r10 = java.lang.Math.abs(r5)
            int r10 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r10 < 0) goto Lb5
            if (r13 != 0) goto Lb5
        Lb3:
            r10 = r1
            goto Lb6
        Lb5:
            r10 = r0
        Lb6:
            if (r10 != r1) goto Lb9
            r0 = r1
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.common.utils.UtilsKt.flipDoc(java.util.List, double, boolean):boolean");
    }

    public static final ConsentPostRequest formConsentRequest(boolean z, Consent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        return new ConsentPostRequest(z, consent.getVersion(), consent.getLanguage(), consent.getSelection$capturesdk_productionRelease());
    }

    public static final int getAttemptCount(Config config, Websdk websdk, int i) {
        Integer maxSubmitCount;
        Intrinsics.checkNotNullParameter(websdk, "websdk");
        int value = (config == null || (maxSubmitCount = config.getMaxSubmitCount()) == null) ? websdk.getIvsMaxSubmitCount().getValue() : maxSubmitCount.intValue();
        return value <= 0 ? i : value;
    }

    public static final Blur getBlurData(DetectionMetric detectionMetric) {
        b.b(TAG, "getBlurData - blurMetric: " + detectionMetric);
        if (detectionMetric == null) {
            return null;
        }
        Blur blur = new Blur(null, null, null, null, null, 31, null);
        blur.setVariance(detectionMetric.getOutputMeasure());
        blur.setAvgVariance(detectionMetric.getOutputMeasure());
        blur.setHighestAvgVariance(detectionMetric.getOutputMeasure());
        return blur;
    }

    public static final HashMap<String, String> getCaptureModeMap(LinkedHashMap<ScanType, UploadImage> uploadMap) {
        Intrinsics.checkNotNullParameter(uploadMap, "uploadMap");
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<ScanType, UploadImage> entry : uploadMap.entrySet()) {
            hashMap.put(entry.getKey().getValue(), entry.getValue().getCaptureType().getValue());
        }
        return hashMap;
    }

    public static final String getCaptureTitleText(ScanType scanType, Screens screens) {
        Label header;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(screens, "screens");
        b.b(TAG, "getCaptureTitleText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            header = screens.getSelfieCapture().getHeader();
        } else if (i == 2) {
            header = screens.getPassport().getHeader();
        } else if (i == 3) {
            header = screens.getFrontCapture().getHeader();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            header = screens.getBackCapture().getHeader();
        }
        return header.getLabel();
    }

    public static final HashMap<String, byte[]> getCapturedImageMap(LinkedHashMap<ScanType, UploadImage> uploadMap) {
        Intrinsics.checkNotNullParameter(uploadMap, "uploadMap");
        HashMap<String, byte[]> hashMap = new HashMap<>();
        for (Map.Entry<ScanType, UploadImage> entry : uploadMap.entrySet()) {
            hashMap.put(entry.getKey().getValue(), entry.getValue().getImage());
        }
        return hashMap;
    }

    public static final String getCardAccessibilityAnnouncement(ScanType scanType, com.socure.docv.capturesdk.common.network.model.stepup.App app, float[] floatArray, Dimension dimension) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(floatArray, "floatArray");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        b.a(TAG, "getCardAccessibilityAnnouncement called");
        switch (WhenMappings.$EnumSwitchMapping$5[getCardPosition(floatArray, dimension).ordinal()]) {
            case 1:
                return app.getAccessibility().getMovePhoneUp();
            case 2:
                return app.getAccessibility().getMovePhoneDown();
            case 3:
                return app.getAccessibility().getMovePhoneLeft();
            case 4:
                return app.getAccessibility().getMovePhoneRight();
            case 5:
                return scanType == ScanType.PASSPORT ? app.getNewLabels().getPassportTooClose() : app.getNewLabels().getIdTooClose();
            case 6:
                return scanType == ScanType.PASSPORT ? app.getAccessibility().getNoPassportDetected() : app.getAccessibility().getNoCardDetected();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final CardGuide getCardPosition(float[] floatArray, Dimension dimension) {
        Intrinsics.checkNotNullParameter(floatArray, "floatArray");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        b.a(TAG, "getCardAccessibilityAnnouncement called");
        Rect rect = new Rect(MathKt.roundToInt(floatArray[0]), MathKt.roundToInt(floatArray[1]), MathKt.roundToInt(floatArray[3]), MathKt.roundToInt(floatArray[7]));
        if (rect.width() / dimension.getW() > (rect.height() > rect.width() ? 0.6d : 0.94d)) {
            return CardGuide.CARD_TOO_CLOSE;
        }
        float f = floatArray[2];
        if (f >= 0.9f && floatArray[5] >= 0.9f) {
            return CardGuide.MOVE_PHONE_DOWN;
        }
        float f2 = floatArray[8];
        return (f2 < 0.9f || floatArray[11] < 0.9f) ? (f < 0.9f || floatArray[11] < 0.9f) ? (floatArray[5] < 0.9f || f2 < 0.9f) ? CardGuide.CARD_NOT_FOUND : CardGuide.MOVE_PHONE_LEFT : CardGuide.MOVE_PHONE_RIGHT : CardGuide.MOVE_PHONE_UP;
    }

    private static final String getCompileSdkVersion(Context context) {
        return Build.VERSION.SDK_INT >= 31 ? String.valueOf(context.getApplicationContext().getApplicationInfo().compileSdkVersion) : "-1";
    }

    public static final Config getConfig(String str) {
        try {
            Object fromJson = new Gson().fromJson(str, (Class<Object>) Config.class);
            ((Config) fromJson).setRaw(str);
            return (Config) fromJson;
        } catch (Throwable th) {
            b.a(TAG, "ex in getConfig: " + Log.getStackTraceString(th), null, 4, null);
            if (str == null || StringsKt.isBlank(str)) {
                return null;
            }
            return new Config(str, null, null, null, null, 30, null);
        }
    }

    public static final ConfigRequest getConfigForApi(Config config) {
        if (config == null) {
            return new ConfigRequest(null, null, 3, null);
        }
        try {
            JsonElement parse = new JsonParser().parse(new Gson().toJson(config));
            if (parse == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.google.gson.JsonObject");
            }
            JsonObject jsonObject = (JsonObject) parse;
            jsonObject.remove(Keys.KEY_DOCUMENT_TYPE);
            jsonObject.remove(Keys.KEY_MAX_SUBMIT);
            Flow flow = config.getFlow();
            String name = flow != null ? flow.getName() : null;
            return new ConfigRequest(name == null ? null : new FlowRequest(name), config.getLanguage());
        } catch (Throwable th) {
            b.a(TAG, "getConfigForApi ex: " + Log.getStackTraceString(th), null, 4, null);
            return new ConfigRequest(null, null, 3, null);
        }
    }

    public static final List<SelfieRange> getConfigSelfieRangeValues(Websdk websdk) {
        Intrinsics.checkNotNullParameter(websdk, "websdk");
        return CollectionsKt.listOf((Object[]) new SelfieRange[]{new SelfieRange(SelfieRangeType.PITCH, websdk.getSelfiePitch()), new SelfieRange(SelfieRangeType.ROLL, websdk.getSelfieRoll()), new SelfieRange(SelfieRangeType.YAW, websdk.getSelfieYaw())});
    }

    public static final String getConfirmationTitleText(ScanType scanType, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        b.b(TAG, "getConfirmationTitleText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return newLabels.getSelfieCaptured();
        }
        if (i == 2) {
            return newLabels.getPassportCaptured();
        }
        if (i == 3) {
            return newLabels.getFrontSideCaptured();
        }
        if (i == 4) {
            return newLabels.getBackSideCaptured();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Edge getCornerData(DetectionMetric detectionMetric) {
        b.b(TAG, "getCornerData - cornerMetric: " + detectionMetric);
        if (detectionMetric == null) {
            return null;
        }
        Edge edge = new Edge(null, null, null, null, 15, null);
        edge.setEdgeDetectedAllSides(Boolean.valueOf(detectionMetric.getCheckPassed()));
        edge.setEdgeDetectedThreeSides(Boolean.valueOf(detectionMetric.getCheckPassed()));
        edge.setRegionWiseLines(getRegionWiseData(detectionMetric.getRegionList()));
        Boolean bool = Boolean.TRUE;
        edge.setSubRegionInfo(new SubRegionInfo(bool, bool, bool, bool));
        return edge;
    }

    public static final String getCornerDetectionFailedText(ScanType scanType, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        return scanType == ScanType.PASSPORT ? newLabels.getAlignDocumentPassport() : newLabels.getAlignDocumentId();
    }

    public static final c getCurrentScreenForPreview(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        b.a(TAG, "getCurrentScreenForPreview called - scanType: " + scanType.getValue());
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return c.PREVIEW_SELFIE;
        }
        if (i == 2) {
            return c.PREVIEW_PASSPORT;
        }
        if (i == 3) {
            return c.PREVIEW_FRONT;
        }
        if (i == 4) {
            return c.PREVIEW_BACK;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final c getCurrentScreenForScanner(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        b.a(TAG, "getCurrentScreenForScanner called - scanType: " + scanType.getValue());
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return c.SCANNER_SELFIE;
        }
        if (i == 2) {
            return c.SCANNER_PASSPORT;
        }
        if (i == 3) {
            return c.SCANNER_FRONT;
        }
        if (i == 4) {
            return c.SCANNER_BACK;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final MinMax getDefaultSelfieAngleMinMax() {
        return new MinMax(-9, 9);
    }

    public static final List<SelfieRange> getDefaultSelfieRangeValues() {
        return CollectionsKt.listOf((Object[]) new SelfieRange[]{new SelfieRange(SelfieRangeType.PITCH, getDefaultSelfieAngleMinMax()), new SelfieRange(SelfieRangeType.ROLL, getDefaultSelfieAngleMinMax()), new SelfieRange(SelfieRangeType.YAW, getDefaultSelfieAngleMinMax())});
    }

    public static final String getDetectionWarningMsg(ScanType scanType, DetectionCallback detectionCallback, a sm) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(detectionCallback, "detectionCallback");
        Intrinsics.checkNotNullParameter(sm, "sm");
        switch (WhenMappings.$EnumSwitchMapping$1[detectionCallback.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 14:
                return getGuidingMessageForSelfie(detectionCallback, a.f305a.b().getNewLabels());
            case 9:
                return getWarningDarkPrimaryText(scanType, sm.b().getScreens());
            case 10:
                return sm.b().getNewLabels().getAdjustLighting();
            case 11:
                return getWarningBlurPrimaryText(scanType, sm.b().getNewLabels());
            case 12:
                return getCornerDetectionFailedText(scanType, sm.b().getNewLabels());
            case 13:
                return getKeepSteadyText(scanType, sm.b().getScreens());
            case 15:
                return sm.b().getNewLabels().getMakeSureBarcode();
            default:
                b.a(TAG, "unhandled detectionCallback: " + detectionCallback);
                return "";
        }
    }

    public static final String getDeviceId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("sdlt_shared_pref", 0);
        String string = sharedPreferences.getString(AmplitudeReactNativeModule.DEVICE_ID_KEY, null);
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            sharedPreferences.edit().putString(AmplitudeReactNativeModule.DEVICE_ID_KEY, string).apply();
        }
        return string == null ? Utils.INSTANCE.randomString$capturesdk_productionRelease(32) : string;
    }

    public static final String getDisplayText(DetectionCallback detectionCallback) {
        Intrinsics.checkNotNullParameter(detectionCallback, "detectionCallback");
        switch (WhenMappings.$EnumSwitchMapping$1[detectionCallback.ordinal()]) {
            case 1:
                return SelfieConstants.FACE_NOT_FOUND;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return SelfieConstants.FACE_NOT_ALIGNED;
            case 7:
                return SelfieConstants.FACE_TOO_SMALL;
            case 8:
                return SelfieConstants.FACE_ORIENTATION_WRONG;
            default:
                return SelfieConstants.READY_FOR_SELFIE_CAPTURE;
        }
    }

    public static final DocumentType getDocType(String str) {
        DocumentType documentType = DocumentType.LICENSE;
        if (Intrinsics.areEqual(str, documentType.getLabel())) {
            return documentType;
        }
        DocumentType documentType2 = DocumentType.PASSPORT;
        if (Intrinsics.areEqual(str, documentType2.getLabel())) {
            return documentType2;
        }
        return null;
    }

    public static final String getDocumentTooCloseMsg(ScanType scanType, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        return scanType == ScanType.PASSPORT ? newLabels.getPassportTooClose() : newLabels.getIdTooClose();
    }

    public static final RequestBody getDocumentTypeBody(ArrayList<Screen> screenFlow) {
        Object obj;
        RequestBody textPlainBody;
        Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
        b.a(TAG, "getDocumentTypeBody");
        Iterator<T> it = screenFlow.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Screen screen = (Screen) obj;
            if (screen.getScanType() == ScanType.LICENSE_FRONT || screen.getScanType() == ScanType.LICENSE_BACK) {
                break;
            }
        }
        return (((Screen) obj) == null || (textPlainBody = ApiUtilsKt.toTextPlainBody(ApiConstant.DOCUMENT_TYPE_LICENSE)) == null) ? ApiUtilsKt.toTextPlainBody(ApiConstant.DOCUMENT_TYPE_PASSPORT) : textPlainBody;
    }

    public static final Pair<String, List<Pair<String, String>>> getEventDataFromExtractedData(ScanType scanType, FinalOutputProcessData finalOutputProcessData) {
        String str;
        Pair<String, List<Pair<String, String>>> addEvent;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(finalOutputProcessData, "finalOutputProcessData");
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            return addEvent(finalOutputProcessData.getData() != null ? "passport_document_front_mrz_success" : finalOutputProcessData.getFound() ? "passport_document_front_mrz_partial" : "passport_document_front_mrz_failure", getEventDurationPair(finalOutputProcessData.getDuration()));
        }
        if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (finalOutputProcessData.getFound()) {
                return (finalOutputProcessData.getData() == null || (addEvent = addEvent("id_card_document_back_barcode_success", getEventDurationPair(finalOutputProcessData.getDuration()))) == null) ? addEvent("id_card_document_back_barcode_failure", new Pair("type", "extraction_failure"), getEventDurationPair(finalOutputProcessData.getDuration())) : addEvent;
            }
            String str2 = finalOutputProcessData.getFaceFound() ? "face_detected" : "not_detected";
            b.a(TAG, "Face detection failed - scanType: " + scanType + " | failureType: " + str2);
            return addEvent("id_card_document_back_barcode_failure", new Pair("type", str2), getEventDurationPair(finalOutputProcessData.getDuration()));
        }
        if (finalOutputProcessData.getData() == null || !finalOutputProcessData.getFound() || !(finalOutputProcessData.getData() instanceof com.socure.docv.capturesdk.core.extractor.model.c)) {
            String str3 = !finalOutputProcessData.getFound() ? "face_not_detected" : finalOutputProcessData.getData() == null ? "no_angle_data" : "unknown";
            b.a(TAG, "Face detection failed - scanType: " + scanType + " | failureType: " + str3);
            return addEvent("orientation_correction_fail", new Pair("type", str3), getEventDurationPair(finalOutputProcessData.getDuration()));
        }
        com.socure.docv.capturesdk.core.extractor.model.a data = finalOutputProcessData.getData();
        if (data == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.core.extractor.model.ExtractedFace");
        }
        com.socure.docv.capturesdk.core.extractor.model.c cVar = (com.socure.docv.capturesdk.core.extractor.model.c) data;
        if (cVar.b == 0.0f) {
            return addEvent("orientation_correction_no_action", getEventDurationPair(finalOutputProcessData.getDuration()));
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = new Pair("angle", String.valueOf((int) cVar.b));
        float f = cVar.b;
        if (!(f == 180.0f)) {
            if (!(f == 360.0f)) {
                str = "vertical";
                pairArr[1] = new Pair("type", str);
                pairArr[2] = getEventDurationPair(finalOutputProcessData.getDuration());
                return addEvent("orientation_correction_success", pairArr);
            }
        }
        str = "horizontal";
        pairArr[1] = new Pair("type", str);
        pairArr[2] = getEventDurationPair(finalOutputProcessData.getDuration());
        return addEvent("orientation_correction_success", pairArr);
    }

    public static final Pair<String, String> getEventDurationPair(long j) {
        return new Pair<>("duration", String.valueOf(j));
    }

    public static final EventData getEventErrorData(int i, String str, int i2, String internalErrorMessage, String endpoint) {
        Intrinsics.checkNotNullParameter(internalErrorMessage, "internalErrorMessage");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = new Pair(ApiConstant.KEY_CODE, String.valueOf(i));
        if (str == null) {
            str = "NULL";
        }
        pairArr[1] = new Pair("message", str);
        pairArr[2] = new Pair("internal_error_code", String.valueOf(i2));
        pairArr[3] = new Pair("internal_error_message", internalErrorMessage);
        pairArr[4] = new Pair("endpoint", endpoint);
        return new EventData("request_failure", CollectionsKt.arrayListOf(pairArr));
    }

    public static final Map<String, String> getFlowResponseMap(Websdk websdk, Config config) {
        Intrinsics.checkNotNullParameter(websdk, "websdk");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, String.valueOf(websdk.getManualCaptureTimeout().getValue()));
        linkedHashMap.put("camera_priming_enabled", String.valueOf(websdk.getShowCameraPriming().getValue()));
        linkedHashMap.put("selfie_enabled", String.valueOf(websdk.getEnableSelfie().getValue()));
        linkedHashMap.put("persist_capture_state", String.valueOf(websdk.getPersistCaptureState().getValue()));
        linkedHashMap.put("selfie_pitch_min", String.valueOf(websdk.getSelfiePitch().getMin()));
        linkedHashMap.put("selfie_pitch_max", String.valueOf(websdk.getSelfiePitch().getMax()));
        linkedHashMap.put("selfie_roll_min", String.valueOf(websdk.getSelfieRoll().getMin()));
        linkedHashMap.put("selfie_roll_max", String.valueOf(websdk.getSelfieRoll().getMax()));
        linkedHashMap.put("selfie_yaw_min", String.valueOf(websdk.getSelfieYaw().getMin()));
        linkedHashMap.put("selfie_yaw_max", String.valueOf(websdk.getSelfieYaw().getMax()));
        linkedHashMap.put("max_attempt_count", String.valueOf(getAttemptCount(config, websdk, 3)));
        return linkedHashMap;
    }

    public static final float getFontScale(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return Settings.System.getFloat(context.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            b.a(TAG, "SettingNotFoundException exception: " + e.getMessage(), null, 4, null);
            return 0.0f;
        }
    }

    public static final FragNavActions getFragNavActions(List<? extends c> screens, c key) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(key, "key");
        b.a(TAG, "getFragNavActions called - key: " + key);
        int indexOf = screens.indexOf(key);
        int i = 0;
        int navActionId = indexOf > 0 ? getNavActionId(screens.get(indexOf - 1)) : 0;
        if (indexOf < screens.size() - 1 && indexOf >= 0) {
            i = getNavActionId(screens.get(indexOf + 1));
        }
        return new FragNavActions(i, navActionId);
    }

    public static final Glare getGlareData(DetectionMetric detectionMetric) {
        b.b(TAG, "getGlareData - glareMetric: " + detectionMetric);
        if (detectionMetric == null) {
            return null;
        }
        Glare glare = new Glare(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
        glare.setGlare(Boolean.valueOf(!detectionMetric.getCheckPassed()));
        glare.setContourGlare(Boolean.valueOf(!detectionMetric.getCheckPassed()));
        glare.setPercentage(detectionMetric.getOutputMeasure());
        glare.setMaxGlarePercentage(detectionMetric.getOutputMeasure());
        glare.setMaxPerimeterRatio(detectionMetric.getOutputMeasure());
        return glare;
    }

    public static final GuidingBoxConstraintData getGuidingBoxData(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        b.b(TAG, "getGuidingBoxData called");
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return new GuidingBoxConstraintData(ConstantsKt.SELFIE_GUIDING_BOX_RATIO, R.drawable.socure_white_selfie_bounding_box, 0, Float.valueOf(0.55f));
        }
        if (i == 2) {
            return new GuidingBoxConstraintData(ConstantsKt.PASSPORT_GUIDING_BOX_RATIO, R.drawable.socure_guiding_box_thin, -1, null, 8, null);
        }
        if (i == 3 || i == 4) {
            return new GuidingBoxConstraintData(ConstantsKt.LICENSE_GUIDING_BOX_RATIO, R.drawable.socure_guiding_box_thin, -1, null, 8, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getGuidingMessageForSelfie(DetectionCallback detectionCallback, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(detectionCallback, "detectionCallback");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        b.b(TAG, "getGuidingMessageForSelfie detectionCallback: " + detectionCallback);
        switch (WhenMappings.$EnumSwitchMapping$1[detectionCallback.ordinal()]) {
            case 1:
                return newLabels.getAlignFaceBox();
            case 2:
            case 3:
            case 4:
            case 5:
                return newLabels.getFaceMustBeVisible();
            case 6:
                return newLabels.getFaceTooClose();
            case 7:
                return newLabels.getMoveCloser();
            case 8:
                return newLabels.getFaceNotParallel();
            default:
                return newLabels.getGreatNowCapture();
        }
    }

    public static final String getHelpTitleText(ScanType scanType, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        b.b(TAG, "getHelpTitleText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return newLabels.getSelfieCapture();
        }
        if (i == 2) {
            return newLabels.getPassportCapture();
        }
        if (i == 3) {
            return newLabels.getFrontCapture();
        }
        if (i == 4) {
            return newLabels.getBackCapture();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getInitialAnnouncement(ScanType scanType, Accessibility accessibility, boolean z) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(accessibility, "accessibility");
        b.b(TAG, "getInitialAnnouncement called");
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return z ? accessibility.getMovePhoneFrontLowEndDevice() : accessibility.getMovePhoneFront();
        }
        if (i == 2) {
            return accessibility.getFocusCameraPassport();
        }
        if (i == 3) {
            return accessibility.getFocusCameraId();
        }
        if (i == 4) {
            return accessibility.getFlipIdBarcode();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getKeepSteadyText(ScanType scanType, Screens screens) {
        Label keepSteadyText;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(screens, "screens");
        b.b(TAG, "keepSteadyText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            b.a(TAG, "scanType:" + scanType + " is empty");
            return "";
        }
        if (i == 2) {
            keepSteadyText = screens.getPassport().getKeepSteadyText();
        } else if (i == 3) {
            keepSteadyText = screens.getFrontCapture().getKeepSteadyText();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            keepSteadyText = screens.getBackCapture().getKeepSteadyText();
        }
        return keepSteadyText.getLabel();
    }

    public static final String getLabel(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        b.b(TAG, "getLabel called - scanType: " + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            return ConstantsKt.FRONT_CAMERA;
        }
        if (i == 2 || i == 3 || i == 4) {
            return ConstantsKt.BACK_CAMERA;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getLastFailure(DetectionCallback detectionCallback) {
        Intrinsics.checkNotNullParameter(detectionCallback, "detectionCallback");
        b.b(TAG, "getLastFailure called - detectionCallback: " + detectionCallback.name());
        switch (WhenMappings.$EnumSwitchMapping$1[detectionCallback.ordinal()]) {
            case 9:
                return ConstantsKt.BRIGHTNESS;
            case 10:
                return ConstantsKt.GLARE;
            case 11:
                return ConstantsKt.BLUR;
            case 12:
                return ConstantsKt.CORNER_DETECTION;
            default:
                return null;
        }
    }

    public static final Map<String, String> getLateAttrs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b.b(TAG, "getLateAttrs called");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("app_unique_id", getPackageName(context));
        linkedHashMap.put(AmplitudeReactNativeModule.DEVICE_ID_KEY, getDeviceId(context));
        linkedHashMap.put("voice_over_enabled", String.valueOf(isTalkBackEnabled(context)));
        linkedHashMap.put("text_size", String.valueOf(getFontScale(context)));
        linkedHashMap.put("min_sdk_version", getMinSdkVersion(context));
        linkedHashMap.put("target_sdk_version", getTargetSdkVersion(context));
        linkedHashMap.put("compile_sdk_version", getCompileSdkVersion(context));
        linkedHashMap.put("is_google_service_available", String.valueOf(isGooglePlayServicesAvailable(context)));
        return linkedHashMap;
    }

    public static final String getManualCapturePrimaryText(ScanType scanType, Screens screens) {
        Label manualCapturePrimaryText;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(screens, "screens");
        b.b(TAG, "getManualCapturePrimaryText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            manualCapturePrimaryText = screens.getSelfieCapture().getManualCapturePrimaryText();
        } else if (i == 2) {
            manualCapturePrimaryText = screens.getPassport().getManualCapturePrimaryText();
        } else if (i == 3) {
            manualCapturePrimaryText = screens.getFrontCapture().getManualCapturePrimaryText();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            manualCapturePrimaryText = screens.getBackCapture().getManualCapturePrimaryText();
        }
        return manualCapturePrimaryText.getLabel();
    }

    public static final String getManualCaptureSecondaryText(ScanType scanType, Screens screens) {
        Label manualCaptureSecondaryText;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(screens, "screens");
        b.b(TAG, "getManualCaptureSecText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            manualCaptureSecondaryText = screens.getSelfieCapture().getManualCaptureSecondaryText();
        } else if (i == 2) {
            manualCaptureSecondaryText = screens.getPassport().getManualCaptureSecondaryText();
        } else if (i == 3) {
            manualCaptureSecondaryText = screens.getFrontCapture().getManualCaptureSecondaryText();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            manualCaptureSecondaryText = screens.getBackCapture().getManualCaptureSecondaryText();
        }
        return manualCaptureSecondaryText.getLabel();
    }

    public static final Pair<String, String> getManualWarningMessages(ScanType scanType, Screens screens) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(screens, "screens");
        return new Pair<>(scanType == ScanType.SELFIE ? null : getManualCapturePrimaryText(scanType, screens), getManualCaptureSecondaryText(scanType, screens));
    }

    private static final String getMinSdkVersion(Context context) {
        return String.valueOf(context.getApplicationContext().getApplicationInfo().minSdkVersion);
    }

    public static final int getNavActionId(c screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        b.a(TAG, "getNavActionToNavigateToScreen called - screen: " + screen);
        switch (WhenMappings.$EnumSwitchMapping$4[screen.ordinal()]) {
            case 1:
                return R.id.socure_action_doc_selection;
            case 2:
            case 3:
            case 4:
            case 5:
                return R.id.socure_action_camera;
            case 6:
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final int getNavFragId(c screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        b.a(TAG, "getNavFragmentToNavigateToScreen called - screen: " + screen);
        int i = WhenMappings.$EnumSwitchMapping$4[screen.ordinal()];
        if (i == 1) {
            return R.id.socure_nav_doc_selection_frag;
        }
        if (i == 2 || i == 3 || i == 4 || i == 5) {
            return R.id.socure_nav_scanner_frag;
        }
        return 0;
    }

    public static final String getPackageName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        return packageName;
    }

    public static final String getPowerByLabel(Screens screens) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        return screens.getCommon().getLabels().getPoweredBy().getLabel();
    }

    public static final String getPreviewWarningMsg(Errors errors, Integer num) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        Map<String, String> ivs = errors.getIvs();
        String str = ivs.get(String.valueOf(num));
        if (str != null) {
            return str;
        }
        String str2 = ivs.get("default");
        return str2 == null ? "" : str2;
    }

    public static final RegionWiseLines getRegionWiseData(List<Float> regionList) {
        Intrinsics.checkNotNullParameter(regionList, "regionList");
        b.b(TAG, "getRegionWiseData - regionList: " + CollectionsKt.joinToString$default(regionList, null, null, null, 0, null, null, 63, null));
        if (!(!regionList.isEmpty())) {
            return null;
        }
        RegionWiseLines regionWiseLines = new RegionWiseLines(null, null, null, null, 15, null);
        regionWiseLines.setTopRegion(CollectionsKt.arrayListOf(Double.valueOf(regionList.get(0).floatValue()), Double.valueOf(regionList.get(1).floatValue())));
        regionWiseLines.setRightRegion(CollectionsKt.arrayListOf(Double.valueOf(regionList.get(3).floatValue()), Double.valueOf(regionList.get(4).floatValue())));
        regionWiseLines.setBottomRegion(CollectionsKt.arrayListOf(Double.valueOf(regionList.get(6).floatValue()), Double.valueOf(regionList.get(7).floatValue())));
        regionWiseLines.setLeftRegion(CollectionsKt.arrayListOf(Double.valueOf(regionList.get(9).floatValue()), Double.valueOf(regionList.get(10).floatValue())));
        return regionWiseLines;
    }

    public static final ResponseCode getResponseCode(int i) {
        if (i == -1) {
            return ResponseCode.UNKNOWN_ERROR;
        }
        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.getCode() == i) {
                return responseCode;
            }
        }
        return null;
    }

    public static final Pair<String, List<Pair<String, String>>> getRetakeEvent(ScanType scanType, com.socure.docv.capturesdk.common.analytics.a docSelection, String cause, long j) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(docSelection, "docSelection");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Utils utils = Utils.INSTANCE;
        String replacePlaceholders$capturesdk_productionRelease = utils.replacePlaceholders$capturesdk_productionRelease(utils.isSelfie$capturesdk_productionRelease(scanType) ? "[Document_Type]_[Capture_Type]_retake" : "[Document_Type]_[Capture_Type]_scan_retake", scanType, docSelection);
        List mutableListOf = CollectionsKt.mutableListOf(new Pair("type", cause));
        mutableListOf.add(TuplesKt.to("screen_duration", String.valueOf(System.currentTimeMillis() - j)));
        mutableListOf.add(TuplesKt.to(Event.EVENT_TYPE_SCREEN, "preview"));
        return new Pair<>(replacePlaceholders$capturesdk_productionRelease, mutableListOf);
    }

    public static final GuidingBox getScaledGuidingBoxArea(GuidingBox guidingBox, float f) {
        Intrinsics.checkNotNullParameter(guidingBox, "guidingBox");
        b.b(TAG, "getScaledGuidingBoxArea called");
        return new GuidingBox((int) ((guidingBox.getWidth() * f) + guidingBox.getWidth()), (int) ((guidingBox.getHeight() * f) + guidingBox.getHeight()), (int) (guidingBox.getLeftTopX() - (guidingBox.getLeftTopX() * f)), (int) (guidingBox.getLeftTopY() - (guidingBox.getLeftTopY() * f)), guidingBox.getParentDimension());
    }

    public static final Pair<String, String>[] getScannedEventAttrs(ScanType scanType, long j, Output output) {
        Object obj;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(output, "output");
        List mutableListOf = CollectionsKt.mutableListOf(new Pair("capture_duration", String.valueOf(j)));
        if (scanType == ScanType.LICENSE_BACK && output.getCaptureType() == CaptureType.AUTO) {
            Iterator<T> it = output.getMetrics().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((DetectionMetric) obj).getDetectionType() == DetectionType.BARCODE) {
                    break;
                }
            }
            DetectionMetric detectionMetric = (DetectionMetric) obj;
            mutableListOf.add(new Pair("type", detectionMetric != null ? detectionMetric.getCheckPassed() : false ? "barcode_check_included" : "barcode_check_not_included"));
        }
        Object[] array = mutableListOf.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Pair[]) array;
    }

    public static final String getSelfieAccessibilityAnnouncementMessage(DetectionCallback detectionCallback, com.socure.docv.capturesdk.common.network.model.stepup.App app) {
        Intrinsics.checkNotNullParameter(detectionCallback, "detectionCallback");
        Intrinsics.checkNotNullParameter(app, "app");
        b.b(TAG, "getSelfieAccessibilityAnnouncementMessage called");
        switch (WhenMappings.$EnumSwitchMapping$1[detectionCallback.ordinal()]) {
            case 1:
                return app.getAccessibility().getAlignFaceFrame();
            case 2:
                return app.getAccessibility().getMovePhoneLeft();
            case 3:
                return app.getAccessibility().getMovePhoneUp();
            case 4:
                return app.getAccessibility().getMovePhoneDown();
            case 5:
                return app.getAccessibility().getMovePhoneRight();
            case 6:
                return app.getNewLabels().getFaceTooClose();
            case 7:
                return app.getAccessibility().getFaceIsSmall();
            case 8:
                return app.getAccessibility().getHoldPhoneFront();
            default:
                return app.getAccessibility().getIdealFace();
        }
    }

    public static final SelfieMetrics getSelfieMetrics(Output output) {
        Object obj;
        Intrinsics.checkNotNullParameter(output, "output");
        Iterator<T> it = output.getMetrics().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DetectionMetric) obj).getDetectionType() == DetectionType.SELFIE) {
                break;
            }
        }
        DetectionMetric detectionMetric = (DetectionMetric) obj;
        if (detectionMetric != null) {
            return detectionMetric.getSelfieMetrics();
        }
        return null;
    }

    public static final IntRange getSelfieRange(SelfieRange selfieRange) {
        return selfieRange != null ? new IntRange(selfieRange.getMinMax().getMin(), selfieRange.getMinMax().getMax()) : new IntRange(-9, 9);
    }

    public static final CharSequence getSpannedText(Spanned spanned, int i, int i2) {
        Intrinsics.checkNotNullParameter(spanned, "spanned");
        if (i < 0 || i2 < 0) {
            return null;
        }
        return spanned.subSequence(i, i2);
    }

    private static final String getTargetSdkVersion(Context context) {
        return String.valueOf(context.getApplicationContext().getApplicationInfo().targetSdkVersion);
    }

    public static final Map<String, String> getTrackingPropertyMap(List<TrackingProperty> trackingProperties) {
        Intrinsics.checkNotNullParameter(trackingProperties, "trackingProperties");
        b.b(TAG, "updateTrackingProperties");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!trackingProperties.isEmpty()) {
            for (TrackingProperty trackingProperty : trackingProperties) {
                linkedHashMap.put(trackingProperty.getKey(), trackingProperty.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final String getWarningBlurPrimaryText(ScanType scanType, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        b.b(TAG, "getWarningBlurPrimaryText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            b.a(TAG, "scanType:" + scanType + " is empty");
            return "";
        }
        if (i == 2) {
            return newLabels.getEnsurePassportFocus();
        }
        if (i == 3 || i == 4) {
            return newLabels.getEnsureIdFocus();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String getWarningDarkPrimaryText(ScanType scanType, Screens screens) {
        Label errorTextSecondary;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(screens, "screens");
        b.b(TAG, "getWarningDarkPrimaryText scanType:" + scanType);
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i == 1) {
            errorTextSecondary = screens.getSelfieCapture().getErrorTextSecondary();
        } else if (i == 2) {
            errorTextSecondary = screens.getPassport().getDarkErrorSecondary();
        } else if (i == 3) {
            errorTextSecondary = screens.getFrontCapture().getErrorMessageSecondaryText();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            errorTextSecondary = screens.getBackCapture().getDarkErrorSecondary();
        }
        return errorTextSecondary.getLabel();
    }

    public static final boolean isDefaultCode(int i) {
        return i == ResponseCode.UNKNOWN_ERROR.getCode() || i == -1;
    }

    public static final boolean isDefaultMsg(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return Intrinsics.areEqual(msg, ResponseCode.UNKNOWN_ERROR.getMessage()) || Intrinsics.areEqual(msg, ConstantsKt.MESSAGE_NOT_AVAILABLE) || StringsKt.isBlank(msg);
    }

    public static final boolean isFaceFoundForSelfie(List<DetectionMetric> metrics) {
        DetectionCallback detectionCallback;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (!(!metrics.isEmpty()) || (detectionCallback = ((DetectionMetric) CollectionsKt.first((List) metrics)).getDetectionCallback()) == null) {
            return false;
        }
        return CollectionsKt.listOf((Object[]) new DetectionCallback[]{DetectionCallback.READY_FOR_SELFIE_CAPTURE, DetectionCallback.FACE_AT_LEFT, DetectionCallback.FACE_AT_UP, DetectionCallback.FACE_AT_DOWN, DetectionCallback.FACE_AT_RIGHT, DetectionCallback.FACE_TOO_SMALL, DetectionCallback.FACE_ORIENTATION_WRONG}).contains(detectionCallback);
    }

    private static final boolean isGooglePlayServicesAvailable(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }

    public static final boolean isOldOs() {
        return Build.VERSION.SDK_INT < 28;
    }

    public static final boolean isTalkBackEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("accessibility");
        if (systemService != null) {
            return ((AccessibilityManager) systemService).isTouchExplorationEnabled();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    }

    public static final boolean isUploadUrlAppendRequired(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        b.b(TAG, "isUploadUrlAppendRequired called");
        if (screen.getIndex() == 1) {
            return !(str == null || StringsKt.isBlank(str));
        }
        return true;
    }

    public static final boolean lowRamDevice() {
        return ConstantsKt.getTOTAL_MEMORY() < 3000;
    }

    public static final double normaliseAngle(double d) {
        double d2 = (d <= 90.0d || d > 180.0d) ? (d <= 180.0d || d > 270.0d) ? (d <= 270.0d || d > 360.0d) ? d : 360.0d - d : d - 180 : 180.0d - d;
        b.b(TAG, "angleWX: " + d + " normalised to " + d2);
        return d2;
    }

    public static final double relativeTilt(Pair<? extends List<Double>, ? extends List<Double>> line, Pair<? extends List<Double>, ? extends List<Double>> referenceLine) {
        Intrinsics.checkNotNullParameter(line, "line");
        Intrinsics.checkNotNullParameter(referenceLine, "referenceLine");
        return Math.abs(Math.toDegrees(Math.atan2(line.getFirst().get(1).doubleValue() - line.getSecond().get(1).doubleValue(), line.getFirst().get(0).doubleValue() - line.getSecond().get(0).doubleValue()) - Math.atan2(referenceLine.getFirst().get(1).doubleValue() - referenceLine.getSecond().get(1).doubleValue(), referenceLine.getFirst().get(0).doubleValue() - referenceLine.getSecond().get(0).doubleValue())));
    }

    public static final List<Float> removeNegative(List<Float> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(RangesKt.coerceAtLeast(((Number) it.next()).floatValue(), 0.0f)));
        }
        return arrayList;
    }

    public static final void requestFocusAccessibilityEvent(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.requestFocus();
        view.sendAccessibilityEvent(8);
    }

    public static final <T1, T2, R> R safeLet(T1 t1, T2 t2, Function2<? super T1, ? super T2, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (t1 == null || t2 == null) {
            return null;
        }
        return block.invoke(t1, t2);
    }

    public static final List<c> setFragNavActions(List<? extends c> skipScreens, boolean z, DocumentType documentType) {
        c cVar;
        Intrinsics.checkNotNullParameter(skipScreens, "skipScreens");
        b.a(TAG, "setFragNavActions called - isSelfieEnabled: " + z + " | documentType: " + documentType);
        ArrayList arrayList = new ArrayList();
        c cVar2 = c.SELECTOR;
        if (!skipScreens.contains(cVar2)) {
            arrayList.add(cVar2);
        }
        if (documentType != null) {
            int i = WhenMappings.$EnumSwitchMapping$3[documentType.ordinal()];
            if (i == 1) {
                arrayList.add(c.SCANNER_FRONT);
                arrayList.add(c.PREVIEW_FRONT);
                arrayList.add(c.SCANNER_BACK);
                cVar = c.PREVIEW_BACK;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(c.SCANNER_PASSPORT);
                cVar = c.PREVIEW_PASSPORT;
            }
            arrayList.add(cVar);
        }
        if (z) {
            arrayList.add(c.SCANNER_SELFIE);
            arrayList.add(c.PREVIEW_SELFIE);
        }
        return arrayList;
    }

    public static final boolean startsWithPkEndsWithFiller(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return Pattern.compile("(PK)([A-Z]{3})([A-Z]+)(<<)([A-Z]+)(<+)").matcher(text).find();
    }

    public static final RectF translateRect(Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RectF(translateX(rect.left, f), translateY(rect.top, f2), translateX(rect.right, f), translateY(rect.bottom, f2));
    }

    public static final float translateX(float f, float f2) {
        return f * f2;
    }

    public static final float translateY(float f, float f2) {
        return f * f2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final void updateErrorDataBasedOnApiType(ApiType apiType, ApiResponse result, Intent data) {
        ResponseCode responseCode;
        int statusCode;
        String message;
        Intrinsics.checkNotNullParameter(apiType, "apiType");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(data, "data");
        switch (WhenMappings.$EnumSwitchMapping$2[apiType.ordinal()]) {
            case 1:
            case 2:
                responseCode = ResponseCode.SESSION_EXPIRED;
                data.putExtra("status_code", responseCode.getCode());
                message = responseCode.getMessage();
                data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                if (isDefaultMsg(result.getStatusMsg()) || isDefaultCode(result.getStatusCode())) {
                    responseCode = ResponseCode.SESSION_INITIATION_FAILURE;
                    data.putExtra("status_code", responseCode.getCode());
                    message = responseCode.getMessage();
                    data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                    break;
                }
                statusCode = result.getStatusCode();
                data.putExtra("status_code", statusCode);
                message = result.getStatusMsg();
                data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                break;
            case 8:
                if (!ConstantsKt.getCONSENT_EXP_MSG_SET().contains(result.getStatusMsg())) {
                    if (isDefaultCode(result.getStatusCode()) || isDefaultMsg(result.getStatusMsg())) {
                        if (!isDefaultCode(result.getHttpCode()) && !isDefaultMsg(result.getStatusMsg())) {
                            statusCode = result.getHttpCode();
                            data.putExtra("status_code", statusCode);
                            message = result.getStatusMsg();
                            data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                        } else if (isDefaultCode(result.getHttpCode()) || isDefaultMsg(result.getHttpMsg())) {
                            responseCode = ResponseCode.UPLOAD_FAILURE;
                            data.putExtra("status_code", responseCode.getCode());
                            message = responseCode.getMessage();
                            data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                            break;
                        } else {
                            data.putExtra("status_code", result.getHttpCode());
                            message = result.getHttpMsg();
                            data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                        }
                    }
                    statusCode = result.getStatusCode();
                    data.putExtra("status_code", statusCode);
                    message = result.getStatusMsg();
                    data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                }
                responseCode = ResponseCode.SESSION_EXPIRED;
                data.putExtra("status_code", responseCode.getCode());
                message = responseCode.getMessage();
                data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                break;
            case 9:
                statusCode = result.getStatusCode();
                data.putExtra("status_code", statusCode);
                message = result.getStatusMsg();
                data.putExtra(Keys.KEY_STATUS_MESSAGE, message);
                break;
        }
    }

    public static final void validateUploadResponse(boolean z, UploadResult uploadResult, l verificationCallBack) {
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        Intrinsics.checkNotNullParameter(verificationCallBack, "verificationCallBack");
        b.b(TAG, "validateUploadResponse called with validateImage: " + z + " | uploadResult: " + uploadResult);
        if ((!StringsKt.isBlank(uploadResult.getUuid())) && uploadResult.getErrorCode() == null) {
            verificationCallBack.b();
        } else if (z) {
            verificationCallBack.a();
        } else {
            verificationCallBack.a(ExtensionsKt.toUnKnownApiResponse(ApiType.IMAGE_UPLOAD));
        }
    }
}
