package net.frozenlogic.mediacenter.impl.plugins.goodreads;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.List;

public class BooksListActivity implements Activity {
    private List<GoodreadsUserGroup> bookGroupList;

    BooksListActivity(List<GoodreadsUserGroup> bookGroupList) {
        this.bookGroupList = bookGroupList;
    }

    @Override
    public void initialize(ActivityContext activityContext) {

        UiActivityContext context = (UiActivityContext) activityContext;
        context.setModelAndView(new ModelAndView("/templates/goodreads/bookGroup.jsp", this.bookGroupList));
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        return null;
    }

    @Override
    public ActivityType getActivityType() {
        return ActivityType.UI;
    }
}
