package javax.servlet.http;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;
import javax.servlet.ServletResponse;

/* loaded from: classes2.dex */
public interface HttpServletResponse extends ServletResponse {
    public static final int SC_ACCEPTED = 202;
    public static final int SC_BAD_GATEWAY = 502;
    public static final int SC_BAD_REQUEST = 400;
    public static final int SC_CONFLICT = 409;
    public static final int SC_CONTINUE = 100;
    public static final int SC_CREATED = 201;
    public static final int SC_EXPECTATION_FAILED = 417;
    public static final int SC_FORBIDDEN = 403;
    public static final int SC_FOUND = 302;
    public static final int SC_GATEWAY_TIMEOUT = 504;
    public static final int SC_GONE = 410;
    public static final int SC_HTTP_VERSION_NOT_SUPPORTED = 505;
    public static final int SC_INTERNAL_SERVER_ERROR = 500;
    public static final int SC_LENGTH_REQUIRED = 411;
    public static final int SC_METHOD_NOT_ALLOWED = 405;
    public static final int SC_MOVED_PERMANENTLY = 301;
    public static final int SC_MOVED_TEMPORARILY = 302;
    public static final int SC_MULTIPLE_CHOICES = 300;
    public static final int SC_NON_AUTHORITATIVE_INFORMATION = 203;
    public static final int SC_NOT_ACCEPTABLE = 406;
    public static final int SC_NOT_FOUND = 404;
    public static final int SC_NOT_IMPLEMENTED = 501;
    public static final int SC_NOT_MODIFIED = 304;
    public static final int SC_NO_CONTENT = 204;
    public static final int SC_OK = 200;
    public static final int SC_PARTIAL_CONTENT = 206;
    public static final int SC_PAYMENT_REQUIRED = 402;
    public static final int SC_PRECONDITION_FAILED = 412;
    public static final int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    public static final int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    public static final int SC_REQUEST_ENTITY_TOO_LARGE = 413;
    public static final int SC_REQUEST_TIMEOUT = 408;
    public static final int SC_REQUEST_URI_TOO_LONG = 414;
    public static final int SC_RESET_CONTENT = 205;
    public static final int SC_SEE_OTHER = 303;
    public static final int SC_SERVICE_UNAVAILABLE = 503;
    public static final int SC_SWITCHING_PROTOCOLS = 101;
    public static final int SC_TEMPORARY_REDIRECT = 307;
    public static final int SC_UNAUTHORIZED = 401;
    public static final int SC_UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int SC_USE_PROXY = 305;

    void addCookie(Cookie cookie);

    void addDateHeader(String str, long j);

    void addHeader(String str, String str2);

    void addIntHeader(String str, int i);

    boolean containsHeader(String str);

    String encodeRedirectURL(String str);

    @Deprecated
    String encodeRedirectUrl(String str);

    String encodeURL(String str);

    @Deprecated
    String encodeUrl(String str);

    String getHeader(String str);

    Collection<String> getHeaderNames();

    Collection<String> getHeaders(String str);

    int getStatus();

    default Supplier<Map<String, String>> getTrailerFields() {
        return null;
    }

    void sendError(int i) throws IOException;

    void sendError(int i, String str) throws IOException;

    void sendRedirect(String str) throws IOException;

    void setDateHeader(String str, long j);

    void setHeader(String str, String str2);

    void setIntHeader(String str, int i);

    void setStatus(int i);

    @Deprecated
    void setStatus(int i, String str);

    default void setTrailerFields(Supplier<Map<String, String>> supplier) {
    }
}
