package net.frozenlogic.mediacenter.impl.plugins.goodreads;

public class GoodreadsClientException extends Exception {
    public GoodreadsClientException() {
        super();
    }

    public GoodreadsClientException(String message) {
        super(message);
    }

    public GoodreadsClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodreadsClientException(Throwable cause) {
        super(cause);
    }

    public GoodreadsClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
