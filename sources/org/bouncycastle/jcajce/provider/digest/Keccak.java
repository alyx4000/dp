package org.bouncycastle.jcajce.provider.digest;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.digests.KeccakDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

/* loaded from: classes6.dex */
public class Keccak {

    public static class Digest224 extends DigestKeccak {
        public Digest224() {
            super(BERTags.FLAGS);
        }
    }

    public static class Digest256 extends DigestKeccak {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest288 extends DigestKeccak {
        public Digest288() {
            super(288);
        }
    }

    public static class Digest384 extends DigestKeccak {
        public Digest384() {
            super(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        }
    }

    public static class Digest512 extends DigestKeccak {
        public Digest512() {
            super(512);
        }
    }

    public static class DigestKeccak extends BCMessageDigest implements Cloneable {
        public DigestKeccak(int i) {
            super(new KeccakDigest(i));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.digest = new KeccakDigest((KeccakDigest) this.digest);
            return bCMessageDigest;
        }
    }

    public static class HashMac224 extends BaseMac {
        public HashMac224() {
            super(new HMac(new KeccakDigest(BERTags.FLAGS)));
        }
    }

    public static class HashMac256 extends BaseMac {
        public HashMac256() {
            super(new HMac(new KeccakDigest(256)));
        }
    }

    public static class HashMac288 extends BaseMac {
        public HashMac288() {
            super(new HMac(new KeccakDigest(288)));
        }
    }

    public static class HashMac384 extends BaseMac {
        public HashMac384() {
            super(new HMac(new KeccakDigest(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)));
        }
    }

    public static class HashMac512 extends BaseMac {
        public HashMac512() {
            super(new HMac(new KeccakDigest(512)));
        }
    }

    public static class KeyGenerator224 extends BaseKeyGenerator {
        public KeyGenerator224() {
            super("HMACKECCAK224", BERTags.FLAGS, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator256 extends BaseKeyGenerator {
        public KeyGenerator256() {
            super("HMACKECCAK256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator288 extends BaseKeyGenerator {
        public KeyGenerator288() {
            super("HMACKECCAK288", 288, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator384 extends BaseKeyGenerator {
        public KeyGenerator384() {
            super("HMACKECCAK384", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator512 extends BaseKeyGenerator {
        public KeyGenerator512() {
            super("HMACKECCAK512", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = Keccak.class.getName();

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-224", sb.append(str).append("$Digest224").toString());
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-288", str + "$Digest288");
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-256", str + "$Digest256");
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-384", str + "$Digest384");
            configurableProvider.addAlgorithm("MessageDigest.KECCAK-512", str + "$Digest512");
            addHMACAlgorithm(configurableProvider, "KECCAK224", str + "$HashMac224", str + "$KeyGenerator224");
            addHMACAlgorithm(configurableProvider, "KECCAK256", str + "$HashMac256", str + "$KeyGenerator256");
            addHMACAlgorithm(configurableProvider, "KECCAK288", str + "$HashMac288", str + "$KeyGenerator288");
            addHMACAlgorithm(configurableProvider, "KECCAK384", str + "$HashMac384", str + "$KeyGenerator384");
            addHMACAlgorithm(configurableProvider, "KECCAK512", str + "$HashMac512", str + "$KeyGenerator512");
        }
    }

    private Keccak() {
    }
}
