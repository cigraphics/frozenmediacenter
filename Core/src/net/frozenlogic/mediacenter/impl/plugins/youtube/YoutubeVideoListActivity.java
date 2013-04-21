package net.frozenlogic.mediacenter.impl.plugins.youtube;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.MediaContext;
import net.frozenlogic.mediacenter.activities.MediaState;

import java.util.List;

public class YoutubeVideoListActivity implements Activity {

    private List<YouTubeVideo> videoList;

    public YoutubeVideoListActivity(List<YouTubeVideo> videoList) {
        this.videoList = videoList;
    }

    @Override
    public void initialize(ActivityContext activityContext) {
        activityContext.getUiContext().setModelAndView(new ModelAndView("/templates/youtube/videoList.jsp", this.videoList));
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        MediaContext mediaContext = activityContext.getMediaContext();
        YouTubeUrlBuilder builder = new YouTubeUrlBuilder();

        String youtubeUrl = activityContext.getUiContext().getParameter("videoId");
        return mediaContext.createMediaActivity(builder.createYouTubeUrl(youtubeUrl), MediaState.ACTIVE);
    }
}
