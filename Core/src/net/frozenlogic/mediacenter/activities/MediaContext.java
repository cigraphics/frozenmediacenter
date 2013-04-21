package net.frozenlogic.mediacenter.activities;

public interface MediaContext {
    Activity createMediaActivity(String url, MediaState mediaState);

    MediaState getMediaState();
}
