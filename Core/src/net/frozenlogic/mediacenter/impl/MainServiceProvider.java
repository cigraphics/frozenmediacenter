package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ServiceContext;
import net.frozenlogic.mediacenter.ServiceProvider;

import java.io.IOException;

public class MainServiceProvider implements ServiceProvider {
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
            context.getServletContext().getRequestDispatcher("/templates/header.jsp").include(context.getRequest(), context.getResponse());
            this.getActivityManager().executeActivity(context);
            context.getServletContext().getRequestDispatcher("/templates/footer.jsp").include(context.getRequest(), context.getResponse());
            context.getResponse().flushBuffer();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
