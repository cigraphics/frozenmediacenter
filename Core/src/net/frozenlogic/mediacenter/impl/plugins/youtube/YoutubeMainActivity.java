package net.frozenlogic.mediacenter.impl.plugins.youtube;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiContext;

import java.util.List;

public class YoutubeMainActivity implements Activity {
    @Override
    public void initialize(ActivityContext activityContext) {
        UiContext context = activityContext.getUiContext();
        ModelAndView modelAndView = new ModelAndView("/templates/youtube/search.jsp", new Object());
        context.setModelAndView(modelAndView);
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        try {
            YoutubeClient youtubeClient = new YoutubeClient();
            String searchTerm = activityContext.getUiContext().getParameter("term");
            List<YouTubeVideo> videos = youtubeClient.search(searchTerm);

            return new YoutubeVideoListActivity(videos);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
