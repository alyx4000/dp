package com.socure.docv.capturesdk.databinding;

import android.view.View;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.socure.docv.capturesdk.common.view.BrandLayout;
import com.socure.docv.capturesdk.common.view.CustomToolbar;
import com.socure.docv.capturesdk.common.view.GraphicOverlay;
import com.socure.docv.capturesdk.feature.scanner.presentation.ui.InfoLayout;
import com.socure.docv.capturesdk.feature.scanner.presentation.ui.OverlayLayout;
import com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerBottomLayout;
import com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerHelpGraphic;

/* loaded from: classes5.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f400a;
    public final View b;
    public final BrandLayout c;
    public final a d;
    public final ScannerBottomLayout e;
    public final InfoLayout f;
    public final CustomToolbar g;
    public final OverlayLayout h;
    public final GraphicOverlay i;
    public final VideoView j;
    public final AppCompatImageView k;
    public final PreviewView l;
    public final ScannerHelpGraphic m;

    public g(CoordinatorLayout coordinatorLayout, View view, BrandLayout brandLayout, a aVar, ScannerBottomLayout scannerBottomLayout, InfoLayout infoLayout, ConstraintLayout constraintLayout, CustomToolbar customToolbar, OverlayLayout overlayLayout, View view2, CircularProgressIndicator circularProgressIndicator, Guideline guideline, GraphicOverlay graphicOverlay, VideoView videoView, AppCompatImageView appCompatImageView, PreviewView previewView, ScannerHelpGraphic scannerHelpGraphic, ConstraintLayout constraintLayout2) {
        this.f400a = coordinatorLayout;
        this.b = view;
        this.c = brandLayout;
        this.d = aVar;
        this.e = scannerBottomLayout;
        this.f = infoLayout;
        this.g = customToolbar;
        this.h = overlayLayout;
        this.i = graphicOverlay;
        this.j = videoView;
        this.k = appCompatImageView;
        this.l = previewView;
        this.m = scannerHelpGraphic;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f400a;
    }
}
