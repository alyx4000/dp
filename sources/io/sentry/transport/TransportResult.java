package io.sentry.transport;

/* loaded from: classes2.dex */
public abstract class TransportResult {
    public abstract int getResponseCode();

    public abstract boolean isSuccess();

    public static TransportResult success() {
        return SuccessTransportResult.INSTANCE;
    }

    public static TransportResult error(int i) {
        return new ErrorTransportResult(i);
    }

    public static TransportResult error() {
        return error(-1);
    }

    private TransportResult() {
    }

    private static final class SuccessTransportResult extends TransportResult {
        static final SuccessTransportResult INSTANCE = new SuccessTransportResult();

        @Override // io.sentry.transport.TransportResult
        public int getResponseCode() {
            return -1;
        }

        @Override // io.sentry.transport.TransportResult
        public boolean isSuccess() {
            return true;
        }

        private SuccessTransportResult() {
            super();
        }
    }

    private static final class ErrorTransportResult extends TransportResult {
        private final int responseCode;

        @Override // io.sentry.transport.TransportResult
        public boolean isSuccess() {
            return false;
        }

        ErrorTransportResult(int i) {
            super();
            this.responseCode = i;
        }

        @Override // io.sentry.transport.TransportResult
        public int getResponseCode() {
            return this.responseCode;
        }
    }
}
