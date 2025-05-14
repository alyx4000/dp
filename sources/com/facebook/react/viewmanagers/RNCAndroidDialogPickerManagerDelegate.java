package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface;

/* loaded from: classes3.dex */
public class RNCAndroidDialogPickerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNCAndroidDialogPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCAndroidDialogPickerManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "dropdownIconColor":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setDropdownIconColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "dropdownIconRippleColor":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setDropdownIconRippleColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "numberOfLines":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setNumberOfLines(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "prompt":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setPrompt(t, obj == null ? null : (String) obj);
                break;
            case "color":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "items":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setItems(t, (ReadableArray) obj);
                break;
            case "selected":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "backgroundColor":
                this.mViewManager.setBackgroundColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "blur":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).blur(t);
                break;
            case "focus":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).focus(t);
                break;
            case "setNativeSelected":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setNativeSelected(t, readableArray.getInt(0));
                break;
        }
    }
}
