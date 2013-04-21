package net.frozenlogic.mediacenter.impl.plugins.youtube;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.MediaContext;
import net.frozenlogic.mediacenter.activities.MediaState;

public class YoutubeVideoListActivity implements Activity {
    @Override
    public void initialize(ActivityContext activityContext) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        MediaContext mediaContext = activityContext.getMediaContext();
        YouTubeUrlBuilder builder = new YouTubeUrlBuilder();

        String youtubeUrl = activityContext.getUiContext().getParameter("videoId");
        return mediaContext.createMediaActivity(youtubeUrl, MediaState.ACTIVE);
    }
}
