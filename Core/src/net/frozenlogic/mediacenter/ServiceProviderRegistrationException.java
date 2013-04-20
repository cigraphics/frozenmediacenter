package net.frozenlogic.mediacenter;

public class ServiceProviderRegistrationException extends Exception {
    public ServiceProviderRegistrationException() {
        super();
    }

    public ServiceProviderRegistrationException(String message) {
        super(message);
    }

    public ServiceProviderRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceProviderRegistrationException(Throwable cause) {
        super(cause);
    }

    public ServiceProviderRegistrationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
