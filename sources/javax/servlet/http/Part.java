package javax.servlet.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/* loaded from: classes2.dex */
public interface Part {
    void delete() throws IOException;

    String getContentType();

    String getHeader(String str);

    Collection<String> getHeaderNames();

    Collection<String> getHeaders(String str);

    InputStream getInputStream() throws IOException;

    String getName();

    long getSize();

    String getSubmittedFileName();

    void write(String str) throws IOException;
}
