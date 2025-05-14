package com.quantummetric.ui.internal;

import android.content.Context;
import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import com.quantummetric.ui.BuildConfig;
import com.quantummetric.ui.QuantumMetric;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class y extends JSONObject {

    /* renamed from: a, reason: collision with root package name */
    static boolean f283a = false;
    static boolean b = true;
    static boolean c;
    static boolean d;
    static boolean e;
    static boolean f;
    static boolean g;
    static boolean i;
    static List<String> j = new ArrayList();
    static List<String> k = new ArrayList();
    boolean h;
    public boolean l;

    public y() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(58:2|3|4|(4:5|6|(1:8)(1:576)|(1:10))|(5:12|13|(1:15)|16|(1:18))|20|21|22|(2:26|(9:28|(1:30)|31|(6:34|35|36|38|39|32)|41|42|(2:45|43)|46|47))|49|(3:50|51|(1:53))|55|(2:57|(4:60|(2:62|63)(1:65)|64|58))|(4:66|67|(2:71|(3:73|(4:76|(2:80|81)|82|74)|85))|(8:87|(1:89)|90|(3:92|(4:95|(4:97|(1:99)(2:106|(1:108)(2:109|(1:111)(1:112)))|100|(2:102|103)(1:105))(2:113|114)|104|93)|115)|116|(3:118|(4:121|(2:123|124)(1:126)|125|119)|127)|128|(3:130|(1:132)(1:135)|133)))|136|(3:137|138|(4:140|(1:142)|143|(3:145|(4:148|(2:150|(2:152|153)(1:155))(1:156)|154|146)|157)))|159|(1:163)|164|165|(3:167|(8:170|171|(1:173)|174|175|176|191|168)|327)|329|330|331|(1:333)|(5:335|336|(1:338)|339|(1:341))|(3:343|344|(3:346|(16:349|(1:351)|352|353|354|355|(3:363|364|365)|369|(1:371)(1:561)|372|373|374|375|(2:377|378)(2:379|(2:381|382)(1:383))|365|347)|564))|566|386|(5:388|389|(1:391)|392|(3:394|(1:396)|397))|(3:400|401|(3:403|(4:406|(6:408|(1:410)|411|(3:413|(3:416|(2:418|(2:420|(2:422|(2:424|(2:426|(5:428|(3:447|432|435)|431|432|435)(5:448|(3:450|432|435)|431|432|435))(5:451|(3:453|432|435)|431|432|435))(5:454|(3:456|432|435)|431|432|435))(5:457|(3:459|432|435)|431|432|435))(5:460|(3:462|432|435)|431|432|435))(5:463|(3:465|432|435)|431|432|435)|414)|466)|467|(2:469|(2:471|472)(2:474|(2:476|477)(1:478)))(1:479))(2:480|481)|473|404)|482))|484|(3:485|486|(1:488))|(2:490|491)|(25:493|494|495|496|(1:498)|499|(1:501)|502|(1:504)(1:553)|505|(3:507|(1:509)|510)|511|(1:513)|514|(4:539|540|(5:544|(1:546)|547|(2:550|548)|551)|552)(1:516)|517|(1:519)(1:538)|520|521|(1:523)|524|525|(2:527|(1:529))|531|532)|556|496|(0)|499|(0)|502|(0)(0)|505|(0)|511|(0)|514|(0)(0)|517|(0)(0)|520|521|(0)|524|525|(0)|531|532) */
    /* JADX WARN: Failed to find 'out' block for switch in B:176:0x0422. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:194:0x0524. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0520 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05a3 A[Catch: Exception -> 0x05f9, all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04a4 A[Catch: Exception -> 0x05e7, all -> 0x09d1, TRY_LEAVE, TryCatch #11 {Exception -> 0x05e7, blocks: (B:269:0x045f, B:271:0x0468, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4), top: B:268:0x045f }] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0817 A[Catch: Exception -> 0x0868, all -> 0x09d1, TryCatch #9 {Exception -> 0x0868, blocks: (B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853), top: B:400:0x0767 }] */
    /* JADX WARN: Removed duplicated region for block: B:439:0x081d A[Catch: Exception -> 0x0868, all -> 0x09d1, TryCatch #9 {Exception -> 0x0868, blocks: (B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853), top: B:400:0x0767 }] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0820 A[Catch: Exception -> 0x0868, all -> 0x09d1, TryCatch #9 {Exception -> 0x0868, blocks: (B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853), top: B:400:0x0767 }] */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0823 A[Catch: Exception -> 0x0868, all -> 0x09d1, TryCatch #9 {Exception -> 0x0868, blocks: (B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853), top: B:400:0x0767 }] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0826 A[Catch: Exception -> 0x0868, all -> 0x09d1, TryCatch #9 {Exception -> 0x0868, blocks: (B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853), top: B:400:0x0767 }] */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0829 A[Catch: Exception -> 0x0868, all -> 0x09d1, TryCatch #9 {Exception -> 0x0868, blocks: (B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853), top: B:400:0x0767 }] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x082c A[Catch: Exception -> 0x0868, all -> 0x09d1, TryCatch #9 {Exception -> 0x0868, blocks: (B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853), top: B:400:0x0767 }] */
    /* JADX WARN: Removed duplicated region for block: B:498:0x08b6 A[Catch: all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x08c2 A[Catch: all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:504:0x08d3 A[Catch: all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x08ed A[Catch: all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0925 A[Catch: all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:516:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0986  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x09a3 A[Catch: all -> 0x09d1, TRY_LEAVE, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:527:0x09ae A[Catch: Exception -> 0x09bd, all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0988  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0936 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:553:0x08e6 A[Catch: all -> 0x09d1, TryCatch #19 {all -> 0x09d1, blocks: (B:3:0x0015, B:6:0x0019, B:8:0x0021, B:10:0x002b, B:13:0x002e, B:15:0x0032, B:16:0x0039, B:18:0x0043, B:22:0x006f, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:30:0x00d5, B:31:0x00ef, B:32:0x00f9, B:34:0x00ff, B:36:0x0105, B:42:0x010f, B:43:0x0116, B:45:0x011c, B:47:0x0132, B:49:0x013a, B:51:0x0144, B:53:0x0150, B:55:0x0152, B:57:0x015e, B:58:0x0169, B:60:0x016f, B:62:0x0175, B:67:0x0182, B:69:0x018a, B:71:0x0190, B:74:0x01a4, B:76:0x01aa, B:78:0x01b2, B:80:0x01b9, B:82:0x01c0, B:87:0x01c5, B:89:0x01c9, B:90:0x01d2, B:93:0x01db, B:95:0x01e1, B:97:0x01ed, B:99:0x0212, B:100:0x0235, B:102:0x023b, B:104:0x0243, B:106:0x0218, B:108:0x0220, B:109:0x0226, B:111:0x022e, B:116:0x0248, B:119:0x0251, B:121:0x0257, B:123:0x025f, B:125:0x0270, B:128:0x0273, B:130:0x0279, B:133:0x0293, B:136:0x0295, B:138:0x02d8, B:140:0x02e4, B:142:0x0386, B:143:0x0388, B:146:0x03b1, B:148:0x03b7, B:150:0x03bd, B:152:0x03cd, B:159:0x03d8, B:161:0x03e1, B:163:0x03e7, B:165:0x03ea, B:168:0x03f3, B:171:0x03f9, B:173:0x0403, B:174:0x040a, B:320:0x0426, B:269:0x045f, B:271:0x0468, B:193:0x0520, B:194:0x0524, B:205:0x0556, B:208:0x0564, B:211:0x056e, B:218:0x0580, B:219:0x0582, B:220:0x0584, B:224:0x058d, B:227:0x0594, B:236:0x0597, B:237:0x059d, B:238:0x05a3, B:240:0x05ae, B:241:0x05b0, B:242:0x05cf, B:244:0x05d7, B:247:0x05b4, B:249:0x05bc, B:250:0x05bf, B:252:0x05c9, B:253:0x05cc, B:254:0x0528, B:258:0x0530, B:261:0x0538, B:264:0x0540, B:276:0x0475, B:278:0x0482, B:279:0x0491, B:280:0x04a4, B:283:0x04b4, B:287:0x04c0, B:290:0x04e5, B:292:0x04eb, B:294:0x04f3, B:296:0x0500, B:298:0x0508, B:302:0x0515, B:304:0x051a, B:177:0x042e, B:312:0x0436, B:315:0x043e, B:331:0x0610, B:333:0x0618, B:336:0x0641, B:338:0x0649, B:339:0x064c, B:341:0x0656, B:344:0x065f, B:347:0x0668, B:349:0x066e, B:351:0x0676, B:352:0x067d, B:355:0x06a6, B:357:0x06b8, B:359:0x06be, B:361:0x06c4, B:369:0x06d4, B:371:0x06d8, B:372:0x06dd, B:375:0x06f3, B:377:0x06ff, B:379:0x070a, B:381:0x0710, B:386:0x0721, B:401:0x0767, B:404:0x0770, B:406:0x0776, B:408:0x077c, B:410:0x0780, B:411:0x0787, B:414:0x07a1, B:416:0x07a7, B:432:0x0813, B:435:0x082f, B:436:0x0817, B:437:0x0819, B:439:0x081d, B:440:0x0820, B:441:0x0823, B:442:0x0826, B:443:0x0829, B:444:0x082c, B:445:0x07cd, B:448:0x07d7, B:451:0x07e1, B:454:0x07eb, B:457:0x07f5, B:460:0x07ff, B:463:0x0809, B:467:0x0833, B:469:0x0839, B:471:0x0844, B:474:0x084d, B:476:0x0853, B:486:0x086a, B:488:0x0870, B:491:0x0895, B:495:0x089f, B:496:0x08a9, B:498:0x08b6, B:499:0x08bc, B:501:0x08c2, B:502:0x08c9, B:504:0x08d3, B:505:0x08e9, B:507:0x08ed, B:509:0x08f1, B:510:0x08f6, B:511:0x090d, B:513:0x0925, B:514:0x092c, B:540:0x0936, B:542:0x093e, B:544:0x0944, B:546:0x094c, B:548:0x0954, B:550:0x095a, B:552:0x096b, B:517:0x097e, B:520:0x0989, B:521:0x098b, B:523:0x09a3, B:525:0x09a6, B:527:0x09ae, B:529:0x09ba, B:531:0x09bd, B:553:0x08e6), top: B:2:0x0015 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    y(java.lang.String r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 2568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.y.<init>(java.lang.String):void");
    }

    static List<String> a(JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!de.b(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    static Set<Integer> a(JSONObject jSONObject, String str) {
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                int optInt = jSONArray.optInt(i2, Integer.MIN_VALUE);
                if (optInt != Integer.MIN_VALUE) {
                    hashSet.add(Integer.valueOf(optInt));
                }
            }
        } catch (Exception unused) {
        }
        return hashSet;
    }

    static boolean a(double d2) {
        return Double.isNaN(d2) || ((double) de.g()) <= d2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r5 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        if (r5 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
    
        return com.quantummetric.ui.internal.de.a(r3, r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return com.quantummetric.ui.internal.de.a(r0, r3, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r3, boolean r4, java.lang.String r5) {
        /*
            r0 = 122(0x7a, float:1.71E-43)
            java.lang.String r0 = java.lang.Integer.toString(r0)
            java.lang.String r1 = "."
            boolean r1 = r3.contains(r1)
            r1 = r1 ^ 1
            java.lang.String r2 = "min"
            boolean r5 = r5.equals(r2)
            if (r1 == 0) goto L19
            if (r5 == 0) goto L22
            goto L1d
        L19:
            java.lang.String r0 = "2.0.20"
            if (r5 == 0) goto L22
        L1d:
            boolean r3 = com.quantummetric.ui.internal.de.a(r0, r3, r4)
            goto L26
        L22:
            boolean r3 = com.quantummetric.ui.internal.de.a(r3, r0, r4)
        L26:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.y.a(java.lang.String, boolean, java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return true;
        }
        Context context = null;
        if (QuantumMetric.b != null) {
            bu buVar = QuantumMetric.b;
            context = (buVar.c != null ? buVar.c.get() : null).getApplicationContext();
        }
        if (jSONObject.has("android_version")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("android_version");
            if (optJSONObject != null && optJSONObject.has("min") && !de.a(Build.VERSION.RELEASE, optJSONObject.optString("min"), z)) {
                return false;
            }
            if (optJSONObject != null && optJSONObject.has("max") && !de.a(optJSONObject.optString("max"), Build.VERSION.RELEASE, z)) {
                return false;
            }
        }
        if (jSONObject.has("percentage")) {
            double optDouble = jSONObject.optDouble("percentage");
            if ((Double.isNaN(optDouble) || ((double) de.g()) <= optDouble) == false) {
                return false;
            }
        }
        if (jSONObject.has(App.JsonKeys.APP_VERSION)) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject(App.JsonKeys.APP_VERSION);
            String c2 = de.c(context);
            if (optJSONObject2 != null && optJSONObject2.has("min") && !de.a(c2, optJSONObject2.optString("min"), z)) {
                return false;
            }
            if (optJSONObject2 != null && optJSONObject2.has("max") && !de.a(optJSONObject2.optString("max"), c2, z)) {
                return false;
            }
        }
        if (jSONObject.has("app_version_name")) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("app_version_name");
            String d2 = de.d(context);
            if (optJSONObject3 != null && optJSONObject3.has("min") && !de.a(d2, optJSONObject3.optString("min"), z)) {
                return false;
            }
            if (optJSONObject3 != null && optJSONObject3.has("max") && !de.a(optJSONObject3.optString("max"), d2, z)) {
                return false;
            }
        }
        if (jSONObject.has("quantum_version")) {
            JSONObject optJSONObject4 = jSONObject.optJSONObject("quantum_version");
            if (optJSONObject4 != null && optJSONObject4.has("min") && !a(optJSONObject4.optString("min"), z, "min")) {
                return false;
            }
            if (optJSONObject4 != null && optJSONObject4.has("max") && !a(optJSONObject4.optString("max"), z, "max")) {
                return false;
            }
        }
        if (jSONObject.has("quantum_version_name")) {
            JSONObject optJSONObject5 = jSONObject.optJSONObject("quantum_version_name");
            if (optJSONObject5 != null && optJSONObject5.has("min") && !de.a(BuildConfig.VERSION_NAME, optJSONObject5.optString("min"), z)) {
                return false;
            }
            if (optJSONObject5 != null && optJSONObject5.has("max") && !de.a(optJSONObject5.optString("max"), BuildConfig.VERSION_NAME, z)) {
                return false;
            }
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(App.JsonKeys.APP_NAME);
        if (optJSONObject6 != null) {
            String optString = optJSONObject6.optString("blacklist_package");
            String optString2 = optJSONObject6.optString("blacklist_domain");
            if (!de.b(optString) && optString.equals(de.b(context))) {
                return false;
            }
            if (!de.b(optString2) && optString2.equals(de.c())) {
                return false;
            }
            String optString3 = optJSONObject6.optString("whitelist_package");
            if (!de.b(optString3) && !optString3.equals(de.b(context))) {
                return false;
            }
            String optString4 = optJSONObject6.optString("whitelist_domain");
            if (!de.b(optString4) && !optString4.equals(de.c())) {
                return false;
            }
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("offline");
        if (aa.A && optJSONObject7 != null && optJSONObject7.has("percentage")) {
            double optDouble2 = optJSONObject7.optDouble("percentage");
            if ((Double.isNaN(optDouble2) || ((double) de.g()) <= optDouble2) == false) {
                return false;
            }
        }
        return true;
    }

    final double a(String str) {
        try {
            JSONObject optJSONObject = optJSONObject("exchange_rates");
            if (optJSONObject != null) {
                return optJSONObject.optDouble(str, -1.0d);
            }
            return -1.0d;
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    final boolean a() {
        try {
            JSONObject optJSONObject = optJSONObject(external.sdk.pendo.io.daimajia.BuildConfig.BUILD_TYPE);
            boolean optBoolean = optJSONObject != null ? optJSONObject.optBoolean("run_beta", true) : true;
            JSONArray optJSONArray = optJSONArray("sampling");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    if (a((JSONObject) optJSONArray.get(i2), optBoolean)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    final String b() {
        try {
            JSONObject optJSONObject = optJSONObject("server_config");
            if (optJSONObject != null) {
                return optJSONObject.optString("reportURL", null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    final String c() {
        try {
            JSONObject optJSONObject = optJSONObject("server_config");
            if (optJSONObject != null) {
                return optJSONObject.optString("syncURL", null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    final String d() {
        bu k2 = de.k();
        String str = k2 != null ? k2.e : "";
        try {
            JSONObject jSONObject = getJSONObject("encryption");
            if (de.b(str)) {
                str = jSONObject.optString("public_key", "");
            }
            i = jSONObject.optBoolean("sixteen_bit_encoding", true);
            this.h = jSONObject.optBoolean("encrypt_api_data", true);
            JSONArray optJSONArray = jSONObject.optJSONArray("text_encrypting");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = ((JSONObject) optJSONArray.get(i2)).optString("r_id");
                    if (!de.b(optString)) {
                        bd.a().a(new JSONObject().put("r_id", optString).put("enc", true));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    final boolean e() {
        try {
            JSONObject optJSONObject = optJSONObject("dialogs");
            if (optJSONObject != null) {
                return optJSONObject.optBoolean("track_v", true);
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    final int f() {
        int i2;
        try {
            i2 = optJSONObject(ViewProps.START).optInt("delay");
        } catch (Exception unused) {
            i2 = 0;
        }
        return Math.max(i2, 0);
    }
}
