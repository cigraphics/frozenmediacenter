package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.activities.MediaState;

public class Video {

    private String url;
    private MediaState mediaState;

    public Video(String url, MediaState mediaState) {
        this.url = url;
        this.mediaState = mediaState;
    }

    public String getUrl() {
        return url;
    }

    public MediaState getMediaState() {
        return mediaState;
    }
}
