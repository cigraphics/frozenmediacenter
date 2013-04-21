package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.MediaContext;
import net.frozenlogic.mediacenter.activities.MediaState;

class MediaContextImpl implements MediaContext {
    @Override
    public Activity createMediaActivity(String url, MediaState mediaState) {
        return new MediaActivityImpl(url, mediaState);
    }

    @Override
    public MediaState getMediaState() {
        return MediaState.ACTIVE;
    }
}
