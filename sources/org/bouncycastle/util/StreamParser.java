package org.bouncycastle.util;

import java.util.Collection;

/* loaded from: classes6.dex */
public interface StreamParser {
    Object read() throws StreamParsingException;

    Collection readAll() throws StreamParsingException;
}
