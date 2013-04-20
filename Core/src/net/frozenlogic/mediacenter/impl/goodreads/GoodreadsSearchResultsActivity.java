package net.frozenlogic.mediacenter.impl.goodreads;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.List;

public class GoodreadsSearchResultsActivity implements Activity {
    private List<SearchResult> searchResultList;

    public GoodreadsSearchResultsActivity(List<SearchResult> searchResultList) {
        this.searchResultList = searchResultList;
    }

    @Override
    public void initialize(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
        context.setModelAndView(new ModelAndView("/templates/goodreads/searchResults.jsp", this.searchResultList));
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ActivityType getActivityType() {
        return ActivityType.UI;
    }
    }
