package sdk.pendo.io.j8;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sdk.pendo.io.models.SessionDataKt;

/* loaded from: classes6.dex */
public enum b implements sdk.pendo.io.s0.a {
    icon_mic(45056),
    icon_mute(45057),
    icon_volume_up(45058),
    icon_volume_off(45059),
    icon_resize_full_alt(45312),
    icon_right_open(45568),
    icon_left_open(45569),
    icon_left_circled2(45570),
    icon_right_circled2(45571),
    icon_angle_left(45572),
    icon_angle_right(45573),
    icon_angle_circled_right(45574),
    icon_angle_circled_left(45575),
    icon_angle_double_left(45576),
    icon_angle_double_right(45577),
    icon_right_big(45584),
    icon_left_big(45585),
    icon_right_circled(45586),
    icon_left_circled(45587),
    icon_arrows_cw(45824),
    icon_play(46080),
    icon_stop(46081),
    icon_pause(46082),
    icon_to_end(46085),
    icon_to_end_alt(46086),
    icon_to_start(46087),
    icon_to_start_alt(46088),
    icon_fast_fw(46089),
    icon_fast_bw(46096),
    icon_youtube_play(46097),
    icon_award(46336),
    icon_off(46592),
    icon_cc_visa(46848),
    icon_cc_mastercard(46849),
    icon_cc_discover(46850),
    icon_cc_amex(46851),
    icon_cc_paypal(46852),
    icon_cc_stripe(46853),
    icon_android(47104),
    icon_apple(47105),
    icon_retweet(49152),
    icon_comment(49408),
    icon_comment_empty(49409),
    icon_bell(49664),
    icon_bell_alt(49665),
    icon_attention_alt(49920),
    icon_attention(49921),
    icon_attention_circled(49922),
    icon_trash(50176),
    icon_trash_empty(50177),
    icon_phone(50432),
    icon_phone_squared(50433),
    icon_menu(50688),
    icon_cog(50689),
    icon_wrench(50690),
    icon_list_bullet(50691),
    icon_ellipsis(50692),
    icon_basket(50944),
    icon_cart_plus(50945),
    icon_cart_arrow_down(50946),
    icon_calendar(51200),
    icon_calendar_empty(51201),
    icon_login(51456),
    icon_logout(51457),
    icon_lock(53248),
    icon_lock_open_alt(53249),
    icon_pin(53504),
    icon_eye(53760),
    icon_eye_off(53761),
    icon_tag(54016),
    icon_thumbs_up(54272),
    icon_thumbs_down(54273),
    icon_thumbs_up_alt(54274),
    icon_thumbs_down_alt(54275),
    icon_angellist(54276),
    icon_download_cloud(54528),
    icon_upload_cloud(54529),
    icon_pencil(54784),
    icon_edit(54785),
    icon_print(55040),
    icon_ok(57345),
    icon_ok_circled(57346),
    icon_ok_circled2(57347),
    icon_ok_squared(57348),
    icon_check_empty(57349),
    icon_check(57350),
    icon_toggle_off(57351),
    icon_toggle_on(57352),
    icon_circle(57353),
    icon_circle_empty(57360),
    icon_circle_thin(57361),
    icon_dot_circled(57362),
    icon_blank(57363),
    icon_ok_circled_1(57364),
    icon_ok_1(57365),
    icon_ok_outline(57366),
    icon_ok_2(57367),
    icon_check_outline(57368),
    icon_check_1(57369),
    icon_ok_3(57376),
    icon_check_empty_1(57377),
    icon_check_2(57378),
    icon_ok_circle(57379),
    icon_star(57600),
    icon_star_empty(57601),
    icon_star_half(57602),
    icon_star_half_alt(57603),
    icon_cancel(57856),
    icon_cancel_circled(57857),
    icon_cancel_circled2(57858),
    icon_minus(57859),
    icon_minus_circled(57860),
    icon_minus_squared(57861),
    icon_minus_squared_alt(57862),
    icon_plus(58112),
    icon_plus_circled(58113),
    icon_plus_squared(58114),
    icon_plus_squared_alt(58115),
    icon_help(58368),
    icon_help_circled(58369),
    icon_info_circled(58624),
    icon_info(58625),
    icon_smile(58880),
    icon_frown(58881),
    icon_meh(58882),
    icon_emo_happy(58883),
    icon_emo_wink(58884),
    icon_emo_unhappy(58885),
    icon_emo_sleep(58886),
    icon_emo_thumbsup(58887),
    icon_emo_surprised(58888),
    icon_emo_angry(58889),
    icon_spin6(59136),
    icon_spin5(59137),
    icon_spin4(59138),
    icon_spin3(59139),
    icon_spin2(59140),
    icon_spin1(59141),
    icon_facebook(59392),
    icon_facebook_official(59394),
    icon_google(59395),
    icon_gplus(59396),
    icon_gplus_squared(59397),
    icon_linkedin_squared(59398),
    icon_linkedin(59399),
    icon_tumblr(59400),
    icon_tumblr_squared(59401),
    icon_facebook_squared(59402),
    icon_twitter_squared(59408),
    icon_twitter(59409),
    icon_youtube(59410),
    icon_youtube_squared(59411),
    icon_dropbox(59412),
    icon_gittip(59537),
    icon_paypal(59543),
    icon_music(59648),
    icon_search(61440),
    icon_mail(61696),
    icon_mail_alt(61697),
    icon_mail_squared(61698),
    icon_heart(61952),
    icon_heart_empty(61953),
    icon_video(62208),
    icon_picture(62464),
    icon_camera(62720),
    icon_home(62976),
    icon_link(63232),
    icon_link_ext(63488),
    icon_link_ext_alt(63489),
    icon_forward(63490),
    icon_export(63491),
    icon_export_alt(63492),
    icon_share(63493),
    icon_share_squared(63494),
    icon_paper_plane(63495),
    icon_paper_plane_empty(63497),
    icon_attach(63744);

    private static final Map<Character, b> LOOKUP_TABLE = new HashMap();
    final char mCharacter;

    b(char c) {
        this.mCharacter = c;
    }

    @Override // sdk.pendo.io.s0.a
    public char a() {
        return this.mCharacter;
    }

    @Override // sdk.pendo.io.s0.a
    public String b() {
        return name().replace(SessionDataKt.UNDERSCORE, '-');
    }

    public static synchronized b a(Character ch) {
        b bVar;
        synchronized (b.class) {
            if (LOOKUP_TABLE.isEmpty()) {
                Iterator it = EnumSet.allOf(b.class).iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) it.next();
                    LOOKUP_TABLE.put(Character.valueOf(bVar2.mCharacter), bVar2);
                }
            }
            bVar = LOOKUP_TABLE.get(ch);
        }
        return bVar;
    }
}
