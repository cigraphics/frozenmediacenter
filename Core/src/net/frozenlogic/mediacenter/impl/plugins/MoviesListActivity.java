package net.frozenlogic.mediacenter.impl.plugins;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.ArrayList;
import java.util.List;

class MoviesListActivity implements Activity {

    @Override
    public void initialize(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
        List<String> movieNames = new ArrayList<String>();
        movieNames.add("The dark knight");
        movieNames.add("Zack and Miri make a porno");
        movieNames.add("The Godfather");
        context.setModelAndView(new ModelAndView("/templates/moviesList.jsp", new MoviesList(movieNames)));
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        return this;
    }

    @Override
    public ActivityType getActivityType() {
        return ActivityType.UI;
    }
}
