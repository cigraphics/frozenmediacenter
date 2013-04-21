package net.frozenlogic.mediacenter.impl.plugins;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiContext;

import java.util.ArrayList;
import java.util.List;

class MoviesListActivity implements Activity {

    @Override
    public void initialize(ActivityContext activityContext) {
        UiContext context = activityContext.getUiContext();
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
}
