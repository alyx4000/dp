package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipboardModule.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"CLIPBOARD_CHANGED_EVENT_NAME", "", "CLIPBOARD_DIRECTORY_NAME", "TAG", "kotlin.jvm.PlatformType", "moduleName", "hasTextContent", "", "Landroid/content/ClipDescription;", "getHasTextContent", "(Landroid/content/ClipDescription;)Z", "plainTextFromHtml", "htmlContent", "coerceToPlainText", "Landroid/content/ClipData$Item;", "context", "Landroid/content/Context;", "expo-clipboard_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClipboardModuleKt {
    public static final String CLIPBOARD_CHANGED_EVENT_NAME = "onClipboardChanged";
    public static final String CLIPBOARD_DIRECTORY_NAME = ".clipboard";
    private static final String TAG = "ClipboardModule";
    private static final String moduleName = "ExpoClipboard";

    /* JADX INFO: Access modifiers changed from: private */
    public static final String plainTextFromHtml(String str) {
        Spanned fromHtml = Html.fromHtml(str, 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n    Html.fromHtml(html…ROM_HTML_MODE_LEGACY)\n  }");
        char[] cArr = new char[fromHtml.length()];
        TextUtils.getChars(fromHtml, 0, fromHtml.length(), cArr, 0);
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String coerceToPlainText(ClipData.Item item, Context context) {
        if (item.getText() == null && item.getHtmlText() != null) {
            String htmlText = item.getHtmlText();
            Intrinsics.checkNotNullExpressionValue(htmlText, "htmlText");
            return plainTextFromHtml(htmlText);
        }
        return item.coerceToText(context).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasTextContent(ClipDescription clipDescription) {
        return clipDescription.hasMimeType("text/plain") || clipDescription.hasMimeType("text/html");
    }
}
