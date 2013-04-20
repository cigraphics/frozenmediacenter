package net.frozenlogic.mediacenter.impl.plugins.picasa;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.List;

public class PicasaPhotosActivity implements Activity {
    private List<Photo> album;

    public PicasaPhotosActivity(List<Photo> album){
        this.album = album;
    }

    @Override
    public void initialize(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
        context.setModelAndView(new ModelAndView("/templates/picasa/albumsList.jsp", this.album));
    }

    @Override
    public Activity perform(ActivityContext activityContext) throws PicasaClientException {
        return null;
    }

    @Override
    public ActivityType getActivityType() {
        return ActivityType.UI;
    }
}
