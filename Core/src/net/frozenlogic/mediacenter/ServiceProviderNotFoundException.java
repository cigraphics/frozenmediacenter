package net.frozenlogic.mediacenter;

public class ServiceProviderNotFoundException extends Exception {
    public ServiceProviderNotFoundException() {
        super();
    }

    public ServiceProviderNotFoundException(String message) {
        super(message);
    }

    public ServiceProviderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceProviderNotFoundException(Throwable cause) {
        super(cause);
    }

    public ServiceProviderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
