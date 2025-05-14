package javax.servlet;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface Filter {
    default void destroy() {
    }

    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException;

    default void init(FilterConfig filterConfig) throws ServletException {
    }
}
