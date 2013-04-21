package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.MediaState;

class MediaActivityImpl implements Activity {

    private String url;
    private MediaState mediaState;

    public MediaActivityImpl(String url, MediaState mediaState) {
        this.url = url;
        this.mediaState = mediaState;
    }

    @Override
    public void initialize(ActivityContext activityContext) {
        activityContext.getUiContext().setModelAndView(new ModelAndView("/templates/video.jsp", new Video(this.url, this.mediaState)));
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        return this;
    }
}
