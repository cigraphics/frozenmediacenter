package net.frozenlogic.mediacenter.impl.plugins.goodreads;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiContext;

import java.util.List;

public class GoodreadsMenuActivity implements Activity {

    @Override
    public void initialize(ActivityContext activityContext) {
        UiContext context = activityContext.getUiContext();
        GoodreadsClient client = new GoodreadsClient();
        try {
            List<GoodreadsUserGroup> results = client.getBookGroup();
            ModelAndView modelAndView = new ModelAndView("/templates/goodreads/bookGroup.jsp", results);
            context.setModelAndView(modelAndView);
        } catch (GoodreadsClientException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        UiContext context = activityContext.getUiContext();
        GoodreadsUtils utils = new GoodreadsUtils();
        if (utils.isSearch(context)) {
            return new GoodreadsSearchResultsActivity(utils.getSearchResults(context));
        } else {
            return this;
        }
    }
}
