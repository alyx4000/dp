package com.squareup.moshi;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.webkit.ProxyConfig;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.apache.commons.io.IOUtils;

/* loaded from: classes5.dex */
final class JsonValueSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private long limit;
    private final Buffer prefix;
    private final BufferedSource source;
    private int stackSize;
    private ByteString state;
    static final ByteString STATE_JSON = ByteString.encodeUtf8("[]{}\"'/#");
    static final ByteString STATE_SINGLE_QUOTED = ByteString.encodeUtf8("'\\");
    static final ByteString STATE_DOUBLE_QUOTED = ByteString.encodeUtf8("\"\\");
    static final ByteString STATE_END_OF_LINE_COMMENT = ByteString.encodeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
    static final ByteString STATE_C_STYLE_COMMENT = ByteString.encodeUtf8(ProxyConfig.MATCH_ALL_SCHEMES);
    static final ByteString STATE_END_OF_JSON = ByteString.EMPTY;

    JsonValueSource(BufferedSource bufferedSource) {
        this(bufferedSource, new Buffer(), STATE_JSON, 0);
    }

    JsonValueSource(BufferedSource bufferedSource, Buffer buffer, ByteString byteString, int i) {
        this.limit = 0L;
        this.closed = false;
        this.source = bufferedSource;
        this.buffer = bufferedSource.getBuffer();
        this.prefix = buffer;
        this.state = byteString;
        this.stackSize = i;
    }

    private void advanceLimit(long j) throws IOException {
        while (true) {
            long j2 = this.limit;
            if (j2 >= j) {
                return;
            }
            ByteString byteString = this.state;
            ByteString byteString2 = STATE_END_OF_JSON;
            if (byteString == byteString2) {
                return;
            }
            if (j2 == this.buffer.size()) {
                if (this.limit > 0) {
                    return;
                } else {
                    this.source.require(1L);
                }
            }
            long indexOfElement = this.buffer.indexOfElement(this.state, this.limit);
            if (indexOfElement == -1) {
                this.limit = this.buffer.size();
            } else {
                byte b = this.buffer.getByte(indexOfElement);
                ByteString byteString3 = this.state;
                ByteString byteString4 = STATE_JSON;
                if (byteString3 == byteString4) {
                    if (b == 34) {
                        this.state = STATE_DOUBLE_QUOTED;
                        this.limit = indexOfElement + 1;
                    } else if (b == 35) {
                        this.state = STATE_END_OF_LINE_COMMENT;
                        this.limit = indexOfElement + 1;
                    } else if (b == 39) {
                        this.state = STATE_SINGLE_QUOTED;
                        this.limit = indexOfElement + 1;
                    } else if (b != 47) {
                        if (b != 91) {
                            if (b != 93) {
                                if (b != 123) {
                                    if (b != 125) {
                                    }
                                }
                            }
                            int i = this.stackSize - 1;
                            this.stackSize = i;
                            if (i == 0) {
                                this.state = byteString2;
                            }
                            this.limit = indexOfElement + 1;
                        }
                        this.stackSize++;
                        this.limit = indexOfElement + 1;
                    } else {
                        long j3 = 2 + indexOfElement;
                        this.source.require(j3);
                        long j4 = indexOfElement + 1;
                        byte b2 = this.buffer.getByte(j4);
                        if (b2 == 47) {
                            this.state = STATE_END_OF_LINE_COMMENT;
                            this.limit = j3;
                        } else if (b2 == 42) {
                            this.state = STATE_C_STYLE_COMMENT;
                            this.limit = j3;
                        } else {
                            this.limit = j4;
                        }
                    }
                } else if (byteString3 == STATE_SINGLE_QUOTED || byteString3 == STATE_DOUBLE_QUOTED) {
                    if (b == 92) {
                        long j5 = indexOfElement + 2;
                        this.source.require(j5);
                        this.limit = j5;
                    } else {
                        if (this.stackSize > 0) {
                            byteString2 = byteString4;
                        }
                        this.state = byteString2;
                        this.limit = indexOfElement + 1;
                    }
                } else if (byteString3 == STATE_C_STYLE_COMMENT) {
                    long j6 = 2 + indexOfElement;
                    this.source.require(j6);
                    long j7 = indexOfElement + 1;
                    if (this.buffer.getByte(j7) == 47) {
                        this.limit = j6;
                        this.state = byteString4;
                    } else {
                        this.limit = j7;
                    }
                } else if (byteString3 == STATE_END_OF_LINE_COMMENT) {
                    this.limit = indexOfElement + 1;
                    this.state = byteString4;
                } else {
                    throw new AssertionError();
                }
            }
        }
    }

    public void discard() throws IOException {
        this.closed = true;
        while (this.state != STATE_END_OF_JSON) {
            advanceLimit(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            this.source.skip(this.limit);
        }
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.prefix.exhausted()) {
            long read = this.prefix.read(buffer, j);
            long j2 = j - read;
            if (this.buffer.exhausted()) {
                return read;
            }
            long read2 = read(buffer, j2);
            return read2 != -1 ? read + read2 : read;
        }
        advanceLimit(j);
        long j3 = this.limit;
        if (j3 == 0) {
            if (this.state == STATE_END_OF_JSON) {
                return -1L;
            }
            throw new AssertionError();
        }
        long min = Math.min(j, j3);
        buffer.write(this.buffer, min);
        this.limit -= min;
        return min;
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return this.source.getTimeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }
}
