package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.Tables4kGCMMultiplier;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes6.dex */
public class GCMSIVBlockCipher implements AEADBlockCipher {
    private static final byte ADD = -31;
    private static final int AEAD_COMPLETE = 2;
    private static final int BUFLEN = 16;
    private static final int HALFBUFLEN = 8;
    private static final int INIT = 1;
    private static final byte MASK = Byte.MIN_VALUE;
    private static final int MAX_DATALEN = 2147483623;
    private static final int NONCELEN = 12;
    private boolean forEncryption;
    private byte[] macBlock;
    private final GCMSIVHasher theAEADHasher;
    private final BlockCipher theCipher;
    private final GCMSIVHasher theDataHasher;
    private GCMSIVCache theEncData;
    private int theFlags;
    private final byte[] theGHash;
    private byte[] theInitialAEAD;
    private final GCMMultiplier theMultiplier;
    private byte[] theNonce;
    private GCMSIVCache thePlain;
    private final byte[] theReverse;

    private static class GCMSIVCache extends ByteArrayOutputStream {
        GCMSIVCache() {
        }

        void clearBuffer() {
            Arrays.fill(getBuffer(), (byte) 0);
        }

        byte[] getBuffer() {
            return this.buf;
        }
    }

    private class GCMSIVHasher {
        private int numActive;
        private long numHashed;
        private final byte[] theBuffer;
        private final byte[] theByte;

        private GCMSIVHasher() {
            this.theBuffer = new byte[16];
            this.theByte = new byte[1];
        }

        void completeHash() {
            if (this.numActive > 0) {
                Arrays.fill(GCMSIVBlockCipher.this.theReverse, (byte) 0);
                GCMSIVBlockCipher.fillReverse(this.theBuffer, 0, this.numActive, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher.gHASH(gCMSIVBlockCipher.theReverse);
            }
        }

        long getBytesProcessed() {
            return this.numHashed;
        }

        void reset() {
            this.numActive = 0;
            this.numHashed = 0L;
        }

        void updateHash(byte b) {
            byte[] bArr = this.theByte;
            bArr[0] = b;
            updateHash(bArr, 0, 1);
        }

        void updateHash(byte[] bArr, int i, int i2) {
            int i3;
            int i4 = this.numActive;
            int i5 = 16 - i4;
            int i6 = 0;
            if (i4 <= 0 || i2 < i5) {
                i3 = i2;
            } else {
                System.arraycopy(bArr, i, this.theBuffer, i4, i5);
                GCMSIVBlockCipher.fillReverse(this.theBuffer, 0, 16, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher.gHASH(gCMSIVBlockCipher.theReverse);
                i3 = i2 - i5;
                this.numActive = 0;
                i6 = i5 + 0;
            }
            while (i3 >= 16) {
                GCMSIVBlockCipher.fillReverse(bArr, i + i6, 16, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher2 = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher2.gHASH(gCMSIVBlockCipher2.theReverse);
                i6 += i5;
                i3 -= i5;
            }
            if (i3 > 0) {
                System.arraycopy(bArr, i + i6, this.theBuffer, this.numActive, i3);
                this.numActive += i3;
            }
            this.numHashed += i2;
        }
    }

    public GCMSIVBlockCipher() {
        this(new AESEngine());
    }

    public GCMSIVBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new Tables4kGCMMultiplier());
    }

    public GCMSIVBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        this.theGHash = new byte[16];
        this.theReverse = new byte[16];
        this.macBlock = new byte[16];
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Cipher required with a block size of 16.");
        }
        this.theCipher = blockCipher;
        this.theMultiplier = gCMMultiplier;
        this.theAEADHasher = new GCMSIVHasher();
        this.theDataHasher = new GCMSIVHasher();
    }

    private static int bufLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private byte[] calculateTag() {
        this.theDataHasher.completeHash();
        byte[] completePolyVal = completePolyVal();
        byte[] bArr = new byte[16];
        for (int i = 0; i < 12; i++) {
            completePolyVal[i] = (byte) (completePolyVal[i] ^ this.theNonce[i]);
        }
        completePolyVal[15] = (byte) (completePolyVal[15] & ByteCompanionObject.MAX_VALUE);
        this.theCipher.processBlock(completePolyVal, 0, bArr, 0);
        return bArr;
    }

    private void checkAEADStatus(int i) {
        int i2 = this.theFlags;
        if ((i2 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i2 & 2) != 0) {
            throw new IllegalStateException("AEAD data cannot be processed after ordinary data");
        }
        if (this.theAEADHasher.getBytesProcessed() - Long.MIN_VALUE > (MAX_DATALEN - i) - Long.MIN_VALUE) {
            throw new IllegalStateException("AEAD byte count exceeded");
        }
    }

    private static void checkBuffer(byte[] bArr, int i, int i2, boolean z) {
        int bufLength = bufLength(bArr);
        int i3 = i + i2;
        if ((i2 < 0 || i < 0 || i3 < 0) || i3 > bufLength) {
            if (!z) {
                throw new DataLengthException("Input buffer too short.");
            }
        }
    }

    private void checkStatus(int i) {
        long j;
        int i2 = this.theFlags;
        if ((i2 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i2 & 2) == 0) {
            this.theAEADHasher.completeHash();
            this.theFlags |= 2;
        }
        long size = this.thePlain.size();
        if (this.forEncryption) {
            j = 2147483623;
        } else {
            size = this.theEncData.size();
            j = 2147483639;
        }
        if (size - Long.MIN_VALUE > (j - i) - Long.MIN_VALUE) {
            throw new IllegalStateException("byte count exceeded");
        }
    }

    private byte[] completePolyVal() {
        byte[] bArr = new byte[16];
        gHashLengths();
        fillReverse(this.theGHash, 0, 16, bArr);
        return bArr;
    }

    private void decryptPlain() throws InvalidCipherTextException {
        byte[] buffer = this.theEncData.getBuffer();
        int size = this.theEncData.size() - 16;
        if (size < 0) {
            throw new InvalidCipherTextException("Data too short");
        }
        byte[] copyOfRange = Arrays.copyOfRange(buffer, size, size + 16);
        byte[] clone = Arrays.clone(copyOfRange);
        clone[15] = (byte) (clone[15] | Byte.MIN_VALUE);
        byte[] bArr = new byte[16];
        int i = 0;
        while (size > 0) {
            this.theCipher.processBlock(clone, 0, bArr, 0);
            int min = Math.min(16, size);
            xorBlock(bArr, buffer, i, min);
            this.thePlain.write(bArr, 0, min);
            this.theDataHasher.updateHash(bArr, 0, min);
            size -= min;
            i += min;
            incrementCounter(clone);
        }
        byte[] calculateTag = calculateTag();
        if (!Arrays.constantTimeAreEqual(calculateTag, copyOfRange)) {
            reset();
            throw new InvalidCipherTextException("mac check failed");
        }
        byte[] bArr2 = this.macBlock;
        System.arraycopy(calculateTag, 0, bArr2, 0, bArr2.length);
    }

    private void deriveKeys(KeyParameter keyParameter) {
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        int length = keyParameter.getKey().length;
        byte[] bArr4 = new byte[length];
        System.arraycopy(this.theNonce, 0, bArr, 4, 12);
        this.theCipher.init(true, keyParameter);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 8, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 8, 8);
        if (length == 32) {
            bArr[0] = (byte) (bArr[0] + 1);
            this.theCipher.processBlock(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 16, 8);
            bArr[0] = (byte) (bArr[0] + 1);
            this.theCipher.processBlock(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 24, 8);
        }
        this.theCipher.init(true, new KeyParameter(bArr4));
        fillReverse(bArr3, 0, 16, bArr2);
        mulX(bArr2);
        this.theMultiplier.init(bArr2);
        this.theFlags |= 1;
    }

    private int encryptPlain(byte[] bArr, byte[] bArr2, int i) {
        byte[] buffer = this.thePlain.getBuffer();
        byte[] clone = Arrays.clone(bArr);
        clone[15] = (byte) (clone[15] | Byte.MIN_VALUE);
        byte[] bArr3 = new byte[16];
        int size = this.thePlain.size();
        int i2 = 0;
        while (size > 0) {
            this.theCipher.processBlock(clone, 0, bArr3, 0);
            int min = Math.min(16, size);
            xorBlock(bArr3, buffer, i2, min);
            System.arraycopy(bArr3, 0, bArr2, i + i2, min);
            size -= min;
            i2 += min;
            incrementCounter(clone);
        }
        return this.thePlain.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fillReverse(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = 0;
        int i4 = 15;
        while (i3 < i2) {
            bArr2[i4] = bArr[i + i3];
            i3++;
            i4--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gHASH(byte[] bArr) {
        xorBlock(this.theGHash, bArr);
        this.theMultiplier.multiplyH(this.theGHash);
    }

    private void gHashLengths() {
        byte[] bArr = new byte[16];
        Pack.longToBigEndian(this.theDataHasher.getBytesProcessed() * 8, bArr, 0);
        Pack.longToBigEndian(this.theAEADHasher.getBytesProcessed() * 8, bArr, 8);
        gHASH(bArr);
    }

    private static void incrementCounter(byte[] bArr) {
        for (int i = 0; i < 4; i++) {
            byte b = (byte) (bArr[i] + 1);
            bArr[i] = b;
            if (b != 0) {
                return;
            }
        }
    }

    private static void mulX(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            bArr[i2] = (byte) (i | ((b >> 1) & 127));
            i = (b & 1) == 0 ? 0 : -128;
        }
        if (i != 0) {
            bArr[0] = (byte) (bArr[0] ^ ADD);
        }
    }

    private void resetStreams() {
        GCMSIVCache gCMSIVCache = this.thePlain;
        if (gCMSIVCache != null) {
            gCMSIVCache.clearBuffer();
        }
        this.theAEADHasher.reset();
        this.theDataHasher.reset();
        this.thePlain = new GCMSIVCache();
        this.theEncData = this.forEncryption ? null : new GCMSIVCache();
        this.theFlags &= -3;
        Arrays.fill(this.theGHash, (byte) 0);
        byte[] bArr = this.theInitialAEAD;
        if (bArr != null) {
            this.theAEADHasher.updateHash(bArr, 0, bArr.length);
        }
    }

    private static void xorBlock(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    private static void xorBlock(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3 + i]);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        checkStatus(0);
        checkBuffer(bArr, i, getOutputSize(0), true);
        if (!this.forEncryption) {
            decryptPlain();
            int size = this.thePlain.size();
            System.arraycopy(this.thePlain.getBuffer(), 0, bArr, i, size);
            resetStreams();
            return size;
        }
        byte[] calculateTag = calculateTag();
        int encryptPlain = encryptPlain(calculateTag, bArr, i) + 16;
        System.arraycopy(calculateTag, 0, bArr, i + this.thePlain.size(), 16);
        byte[] bArr2 = this.macBlock;
        System.arraycopy(calculateTag, 0, bArr2, 0, bArr2.length);
        resetStreams();
        return encryptPlain;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.theCipher.getAlgorithmName() + "-GCM-SIV";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        return Arrays.clone(this.macBlock);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int i) {
        if (this.forEncryption) {
            return i + this.thePlain.size() + 16;
        }
        int size = i + this.theEncData.size();
        if (size > 16) {
            return size - 16;
        }
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.theCipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] iv;
        KeyParameter keyParameter;
        byte[] bArr;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getAssociatedText();
            iv = aEADParameters.getNonce();
            keyParameter = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to GCM-SIV");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
            bArr = null;
        }
        if (iv == null || iv.length != 12) {
            throw new IllegalArgumentException("Invalid nonce");
        }
        if (keyParameter == null || !(keyParameter.getKey().length == 16 || keyParameter.getKey().length == 32)) {
            throw new IllegalArgumentException("Invalid key");
        }
        this.forEncryption = z;
        this.theInitialAEAD = bArr;
        this.theNonce = iv;
        deriveKeys(keyParameter);
        resetStreams();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte b) {
        checkAEADStatus(1);
        this.theAEADHasher.updateHash(b);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) {
        checkAEADStatus(i2);
        checkBuffer(bArr, i, i2, false);
        this.theAEADHasher.updateHash(bArr, i, i2);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
        checkStatus(1);
        if (!this.forEncryption) {
            this.theEncData.write(b);
            return 0;
        }
        this.thePlain.write(b);
        this.theDataHasher.updateHash(b);
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        checkStatus(i2);
        checkBuffer(bArr, i, i2, false);
        if (this.forEncryption) {
            this.thePlain.write(bArr, i, i2);
            this.theDataHasher.updateHash(bArr, i, i2);
        } else {
            this.theEncData.write(bArr, i, i2);
        }
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        resetStreams();
    }
}
