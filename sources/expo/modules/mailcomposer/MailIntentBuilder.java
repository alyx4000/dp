package expo.modules.mailcomposer;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import androidx.core.content.FileProvider;
import io.sentry.protocol.OperatingSystem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MailIntentBuilder.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/mailcomposer/MailIntentBuilder;", "", "options", "Lexpo/modules/mailcomposer/MailComposerOptions;", "(Lexpo/modules/mailcomposer/MailComposerOptions;)V", "mailIntent", "Landroid/content/Intent;", OperatingSystem.JsonKeys.BUILD, "contentUriFromFile", "Landroid/net/Uri;", "file", "Ljava/io/File;", "application", "Landroid/app/Application;", "putAttachments", "intentName", "", "putBccRecipients", "putBody", "isBodyHtml", "", "putCcRecipients", "putRecipients", "putSubject", "setComponentName", "pkg", "cls", "expo-mail-composer_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MailIntentBuilder {
    private final Intent mailIntent;
    private final MailComposerOptions options;

    public MailIntentBuilder(MailComposerOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        this.mailIntent = new Intent("android.intent.action.SEND_MULTIPLE");
    }

    private final Uri contentUriFromFile(File file, Application application) {
        try {
            Uri uriForFile = FileProvider.getUriForFile(application, application.getPackageName() + ".MailComposerFileProvider", file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "{\n    FileProvider.getUr…er\",\n      file\n    )\n  }");
            return uriForFile;
        } catch (Exception unused) {
            Uri fromFile = Uri.fromFile(file);
            Intrinsics.checkNotNullExpressionValue(fromFile, "{\n    Uri.fromFile(file)\n  }");
            return fromFile;
        }
    }

    /* renamed from: build, reason: from getter */
    public final Intent getMailIntent() {
        return this.mailIntent;
    }

    public final MailIntentBuilder setComponentName(String pkg, String cls) {
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(cls, "cls");
        this.mailIntent.setComponent(new ComponentName(pkg, cls));
        return this;
    }

    public final MailIntentBuilder putRecipients(String intentName) {
        Intrinsics.checkNotNullParameter(intentName, "intentName");
        List<String> recipients = this.options.getRecipients();
        if (recipients != null) {
            this.mailIntent.putExtra(intentName, (String[]) recipients.toArray(new String[0]));
        }
        return this;
    }

    public final MailIntentBuilder putCcRecipients(String intentName) {
        Intrinsics.checkNotNullParameter(intentName, "intentName");
        List<String> ccRecipients = this.options.getCcRecipients();
        if (ccRecipients != null) {
            this.mailIntent.putExtra(intentName, (String[]) ccRecipients.toArray(new String[0]));
        }
        return this;
    }

    public final MailIntentBuilder putBccRecipients(String intentName) {
        Intrinsics.checkNotNullParameter(intentName, "intentName");
        List<String> bccRecipients = this.options.getBccRecipients();
        if (bccRecipients != null) {
            this.mailIntent.putExtra(intentName, (String[]) bccRecipients.toArray(new String[0]));
        }
        return this;
    }

    public final MailIntentBuilder putSubject(String intentName) {
        Intrinsics.checkNotNullParameter(intentName, "intentName");
        String subject = this.options.getSubject();
        if (subject != null) {
            this.mailIntent.putExtra(intentName, subject);
        }
        return this;
    }

    public final MailIntentBuilder putBody(String intentName, boolean isBodyHtml) {
        String body;
        Intrinsics.checkNotNullParameter(intentName, "intentName");
        if (this.options.getBody() != null) {
            if (isBodyHtml) {
                body = Html.fromHtml(this.options.getBody());
            } else {
                body = this.options.getBody();
            }
            this.mailIntent.putExtra(intentName, body);
        }
        return this;
    }

    public final MailIntentBuilder putAttachments(String intentName, Application application) {
        Intrinsics.checkNotNullParameter(intentName, "intentName");
        Intrinsics.checkNotNullParameter(application, "application");
        try {
            List<String> attachments = this.options.getAttachments();
            if (attachments != null) {
                Object[] array = attachments.toArray(new String[0]);
                ArrayList arrayList = new ArrayList(array.length);
                for (Object obj : array) {
                    String path = Uri.parse((String) obj).getPath();
                    if (path == null) {
                        throw new IllegalArgumentException("Path to attachment can not be null".toString());
                    }
                    arrayList.add(contentUriFromFile(new File(path), application));
                }
                this.mailIntent.putParcelableArrayListExtra(intentName, (ArrayList) CollectionsKt.toCollection(arrayList, new ArrayList()));
            }
        } catch (IllegalArgumentException e) {
            Log.e("ExpoMailComposer", "Illegal argument:", e);
        }
        return this;
    }
}
