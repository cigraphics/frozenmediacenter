package net.frozenlogic.mediacenter.impl.plugins.picasa;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.List;

public class PicasaPhotosShowAlbumActivity implements Activity {

    @Override
    public void initialize(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;
        PicasaPhotosClient photosClient = new PicasaPhotosClient();
        try {
            List<Photo> album = photosClient.getAlbum("default");
            return new PicasaPhotosActivity(album);
        }
        catch (PicasaPhotosClientException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ActivityType getActivityType() {
        return ActivityType.UI;
    }
}
