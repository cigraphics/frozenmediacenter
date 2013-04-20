package net.frozenlogic.mediacenter.impl.plugins.picasa;

public class PicasaPhotosClientException extends Exception {
    public PicasaPhotosClientException(){
        super();
    }

    public PicasaPhotosClientException(String message){
        super(message);
    }

    public PicasaPhotosClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public PicasaPhotosClientException(Throwable cause) {
        super(cause);
    }

    public PicasaPhotosClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
