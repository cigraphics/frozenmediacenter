package net.frozenlogic.mediacenter.impl.plugins.goodreads;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.List;

public class GoodreadsUserGroupActivity implements Activity {
    @Override
    public void initialize(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
        GoodreadsGroupClient client = new GoodreadsGroupClient();
        try {
            List<GoodreadsUserGroup> results = client.getBookGroup();
            return new BooksListActivity(results);
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
