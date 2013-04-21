package net.frozenlogic.mediacenter.activities;

import net.frozenlogic.mediacenter.impl.plugins.picasa.PicasaClientException;

public interface Activity {

    void initialize(ActivityContext activityContext);

    Activity perform(ActivityContext activityContext);
}

