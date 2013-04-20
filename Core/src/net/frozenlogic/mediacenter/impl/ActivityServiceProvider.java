package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ServiceContext;
import net.frozenlogic.mediacenter.ServiceProvider;

class ActivityServiceProvider implements ServiceProvider {

    private ActivityManager activityManager;

    public ActivityManager getActivityManager() {
        return activityManager;
    }

    public void setActivityManager(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    @Override
    public void handle(ServiceContext context) {
        try {
            this.getActivityManager().executeActivity(context);
            context.getResponse().flushBuffer();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

