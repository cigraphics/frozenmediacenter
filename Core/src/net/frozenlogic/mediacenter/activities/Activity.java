package net.frozenlogic.mediacenter.activities;

import net.frozenlogic.mediacenter.impl.plugins.picasa.PicasaPhotosClientException;

public interface Activity {

    void initialize(ActivityContext activityContext);

    Activity perform(ActivityContext activityContext) throws PicasaPhotosClientException;

    ActivityType getActivityType();
}

