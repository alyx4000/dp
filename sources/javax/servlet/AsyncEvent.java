package javax.servlet;

/* loaded from: classes2.dex */
public class AsyncEvent {
    private AsyncContext context;
    private ServletRequest request;
    private ServletResponse response;
    private Throwable throwable;

    public AsyncEvent(AsyncContext asyncContext) {
        this(asyncContext, asyncContext.getRequest(), asyncContext.getResponse(), null);
    }

    public AsyncEvent(AsyncContext asyncContext, ServletRequest servletRequest, ServletResponse servletResponse) {
        this(asyncContext, servletRequest, servletResponse, null);
    }

    public AsyncEvent(AsyncContext asyncContext, Throwable th) {
        this(asyncContext, asyncContext.getRequest(), asyncContext.getResponse(), th);
    }

    public AsyncEvent(AsyncContext asyncContext, ServletRequest servletRequest, ServletResponse servletResponse, Throwable th) {
        this.context = asyncContext;
        this.request = servletRequest;
        this.response = servletResponse;
        this.throwable = th;
    }

    public AsyncContext getAsyncContext() {
        return this.context;
    }

    public ServletRequest getSuppliedRequest() {
        return this.request;
    }

    public ServletResponse getSuppliedResponse() {
        return this.response;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
