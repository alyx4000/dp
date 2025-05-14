package expo.modules.mailcomposer;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Records.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010&\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\t\u0010\u0019R$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0015¨\u0006."}, d2 = {"Lexpo/modules/mailcomposer/MailComposerOptions;", "Lexpo/modules/kotlin/records/Record;", "recipients", "", "", "ccRecipients", "bccRecipients", "subject", "body", "isHtml", "", "attachments", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getAttachments$annotations", "()V", "getAttachments", "()Ljava/util/List;", "getBccRecipients$annotations", "getBccRecipients", "getBody$annotations", "getBody", "()Ljava/lang/String;", "getCcRecipients$annotations", "getCcRecipients", "isHtml$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRecipients$annotations", "getRecipients", "getSubject$annotations", "getSubject", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lexpo/modules/mailcomposer/MailComposerOptions;", "equals", "other", "", "hashCode", "", "toString", "expo-mail-composer_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MailComposerOptions implements Record {
    private final List<String> attachments;
    private final List<String> bccRecipients;
    private final String body;
    private final List<String> ccRecipients;
    private final Boolean isHtml;
    private final List<String> recipients;
    private final String subject;

    public static /* synthetic */ MailComposerOptions copy$default(MailComposerOptions mailComposerOptions, List list, List list2, List list3, String str, String str2, Boolean bool, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mailComposerOptions.recipients;
        }
        if ((i & 2) != 0) {
            list2 = mailComposerOptions.ccRecipients;
        }
        List list5 = list2;
        if ((i & 4) != 0) {
            list3 = mailComposerOptions.bccRecipients;
        }
        List list6 = list3;
        if ((i & 8) != 0) {
            str = mailComposerOptions.subject;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = mailComposerOptions.body;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            bool = mailComposerOptions.isHtml;
        }
        Boolean bool2 = bool;
        if ((i & 64) != 0) {
            list4 = mailComposerOptions.attachments;
        }
        return mailComposerOptions.copy(list, list5, list6, str3, str4, bool2, list4);
    }

    @Field
    public static /* synthetic */ void getAttachments$annotations() {
    }

    @Field
    public static /* synthetic */ void getBccRecipients$annotations() {
    }

    @Field
    public static /* synthetic */ void getBody$annotations() {
    }

    @Field
    public static /* synthetic */ void getCcRecipients$annotations() {
    }

    @Field
    public static /* synthetic */ void getRecipients$annotations() {
    }

    @Field
    public static /* synthetic */ void getSubject$annotations() {
    }

    @Field
    public static /* synthetic */ void isHtml$annotations() {
    }

    public final List<String> component1() {
        return this.recipients;
    }

    public final List<String> component2() {
        return this.ccRecipients;
    }

    public final List<String> component3() {
        return this.bccRecipients;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getIsHtml() {
        return this.isHtml;
    }

    public final List<String> component7() {
        return this.attachments;
    }

    public final MailComposerOptions copy(List<String> recipients, List<String> ccRecipients, List<String> bccRecipients, String subject, String body, Boolean isHtml, List<String> attachments) {
        return new MailComposerOptions(recipients, ccRecipients, bccRecipients, subject, body, isHtml, attachments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MailComposerOptions)) {
            return false;
        }
        MailComposerOptions mailComposerOptions = (MailComposerOptions) other;
        return Intrinsics.areEqual(this.recipients, mailComposerOptions.recipients) && Intrinsics.areEqual(this.ccRecipients, mailComposerOptions.ccRecipients) && Intrinsics.areEqual(this.bccRecipients, mailComposerOptions.bccRecipients) && Intrinsics.areEqual(this.subject, mailComposerOptions.subject) && Intrinsics.areEqual(this.body, mailComposerOptions.body) && Intrinsics.areEqual(this.isHtml, mailComposerOptions.isHtml) && Intrinsics.areEqual(this.attachments, mailComposerOptions.attachments);
    }

    public int hashCode() {
        List<String> list = this.recipients;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.ccRecipients;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.bccRecipients;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.subject;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.body;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isHtml;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<String> list4 = this.attachments;
        return hashCode6 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "MailComposerOptions(recipients=" + this.recipients + ", ccRecipients=" + this.ccRecipients + ", bccRecipients=" + this.bccRecipients + ", subject=" + this.subject + ", body=" + this.body + ", isHtml=" + this.isHtml + ", attachments=" + this.attachments + ")";
    }

    public MailComposerOptions(List<String> list, List<String> list2, List<String> list3, String str, String str2, Boolean bool, List<String> list4) {
        this.recipients = list;
        this.ccRecipients = list2;
        this.bccRecipients = list3;
        this.subject = str;
        this.body = str2;
        this.isHtml = bool;
        this.attachments = list4;
    }

    public final List<String> getRecipients() {
        return this.recipients;
    }

    public final List<String> getCcRecipients() {
        return this.ccRecipients;
    }

    public final List<String> getBccRecipients() {
        return this.bccRecipients;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getBody() {
        return this.body;
    }

    public final Boolean isHtml() {
        return this.isHtml;
    }

    public final List<String> getAttachments() {
        return this.attachments;
    }
}
