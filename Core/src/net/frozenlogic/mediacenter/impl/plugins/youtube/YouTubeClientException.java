package net.frozenlogic.mediacenter.impl.plugins.youtube;

class YouTubeClientException extends Exception {
    YouTubeClientException() {
        super();
    }

    YouTubeClientException(String message) {
        super(message);
    }

    YouTubeClientException(String message, Throwable cause) {
        super(message, cause);
    }

    YouTubeClientException(Throwable cause) {
        super(cause);
    }

    YouTubeClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
