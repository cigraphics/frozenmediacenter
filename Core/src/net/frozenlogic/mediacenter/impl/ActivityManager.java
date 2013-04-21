package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.ServiceContext;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.MediaContext;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityManager {

    private Activity defaultActivity;
    private MediaContext mediaContext;
    private Activity currentActivity;

    private List<Activity> pastActivities = new ArrayList<Activity>();

    public Activity getDefaultActivity() {
        return defaultActivity;
    }

    public void setDefaultActivity(Activity defaultActivity) {
        this.defaultActivity = defaultActivity;
    }

    public MediaContext getMediaContext() {
        return mediaContext;
    }

    public void setMediaContext(MediaContext mediaContext) {
        this.mediaContext = mediaContext;
    }

    public void initialize() {
        this.currentActivity = this.defaultActivity;
    }

    private void setCurrentActivity(Activity activity, ServiceContext context, boolean handleContext) throws IOException, ServletException {
        this.currentActivity = activity;
        ActivityContext activityContext = this.createActivityContext(context);
        this.currentActivity.initialize(activityContext);
        if (handleContext)
            this.handleActivityContext(activityContext, context);
    }

    public void executeActivity(ServiceContext context) throws IOException, ServletException {
        ActivityContext activityContext = this.createActivityContext(context);
        try {
            Activity nextActivity = this.currentActivity.perform(activityContext);
            this.handleActivityContext(activityContext, context);
            boolean isSameActivity = nextActivity.getClass().equals(this.currentActivity.getClass());
            if (!isSameActivity)
                this.pastActivities.add(this.currentActivity);
            this.setCurrentActivity(nextActivity, context, !isSameActivity);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

    public void restorePreviousActivity(ServiceContext context) throws IOException, ServletException {
        if (this.pastActivities.size() > 0)
            this.setCurrentActivity(this.pastActivities.get(this.pastActivities.size() - 1), context, true);
        else
            this.restoreDefaultActivity(context);
    }

    public void restoreDefaultActivity(ServiceContext context) throws IOException, ServletException {
        this.setCurrentActivity(this.defaultActivity, context, true);
    }

    private void handleActivityContext(ActivityContext activityContext, ServiceContext context) throws IOException, ServletException {
        UiContextImpl uiContext = (UiContextImpl) activityContext.getUiContext();
        if (uiContext.getModelAndView() != null) {
            ModelAndView modelAndView = uiContext.getModelAndView();
            context.getRequest().setAttribute("model", modelAndView.getModel());
            context.getServletContext().getRequestDispatcher(modelAndView.getViewName()).include(context.getRequest(), context.getResponse());
        }
    }

    private ActivityContext createActivityContext(ServiceContext context) {
        UiContextImpl uiContext = new UiContextImpl(context.getRequest());
        return new ActivityContextImpl(this.defaultActivity, this.currentActivity, this.mediaContext, uiContext);
    }
}

