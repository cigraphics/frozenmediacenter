package net.frozenlogic.mediacenter.activities;

public interface Activity {

    void initialize(ActivityContext activityContext);

    Activity perform(ActivityContext activityContext);

    ActivityType getActivityType();
}

