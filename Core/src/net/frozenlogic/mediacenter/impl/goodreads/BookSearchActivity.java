package net.frozenlogic.mediacenter.impl.goodreads;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.List;

public class BookSearchActivity implements Activity {
    @Override
    public void initialize(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
        context.setModelAndView(new ModelAndView("/templates/goodreads/search.jsp", new Object()));
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
        String term = context.getParameters().get("term")[0];

        GoodreadsClient client = new GoodreadsClient();
        try {
            List<SearchResult> results = client.search(term);
            return new GoodreadsSearchResultsActivity(results);
        }
        catch (GoodreadsClientException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ActivityType getActivityType() {
        return ActivityType.UI;
    }

}
