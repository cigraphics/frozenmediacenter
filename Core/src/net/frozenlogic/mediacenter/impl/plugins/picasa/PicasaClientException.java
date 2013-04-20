package net.frozenlogic.mediacenter.impl.plugins.picasa;

public class PicasaClientException extends Exception {
    public PicasaClientException(){
        super();
    }

    public PicasaClientException(String message){
        super(message);
    }

    public PicasaClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public PicasaClientException(Throwable cause) {
        super(cause);
    }

    public PicasaClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
