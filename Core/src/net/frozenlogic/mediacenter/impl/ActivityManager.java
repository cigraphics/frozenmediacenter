package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.ServiceContext;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityManager {

    private Activity defaultActivity;

    private Activity currentActivity;

    private List<Activity> pastActivities = new ArrayList<Activity>();

    public Activity getDefaultActivity() {
        return defaultActivity;
    }

    public void setDefaultActivity(Activity defaultActivity) {
        this.defaultActivity = defaultActivity;
    }

    public void initialize() {
        this.currentActivity = this.defaultActivity;
    }

    private void setCurrentActivity(Activity activity, ServiceContext context) throws IOException, ServletException {
        this.currentActivity = activity;
        ActivityContext activityContext = this.getActivityContext(this.currentActivity, context);
        this.currentActivity.initialize(activityContext);
        this.handleActivityContext(activityContext, context);
    }

    public void executeActivity(ServiceContext context) throws IOException, ServletException {
        ActivityContext activityContext = this.getActivityContext(this.currentActivity, context);
        try{
            this.setCurrentActivity(this.currentActivity.perform(activityContext), context);
        }  catch(Exception ex){
            throw new ServletException(ex) ;
        }
        this.handleActivityContext(activityContext, context);
    }

    private void handleActivityContext(ActivityContext activityContext, ServiceContext context) throws IOException, ServletException {
        if (activityContext instanceof UiActivityContextImpl) {
            UiActivityContextImpl uiActivityContext = (UiActivityContextImpl) activityContext;
            if (uiActivityContext.getModelAndView() != null) {
                ModelAndView modelAndView = uiActivityContext.getModelAndView();
                context.getRequest().setAttribute("model", modelAndView.getModel());
                context.getServletContext().getRequestDispatcher(modelAndView.getViewName()).include(context.getRequest(), context.getResponse());
            }
        }
    }

    private ActivityContext getActivityContext(Activity activity, ServiceContext context) {
        if (activity.getActivityType() == ActivityType.UI) {
            return new UiActivityContextImpl(this.defaultActivity, this.currentActivity, context.getRequest().getParameterMap());
        }
        else {
            return null;
        }
    }
}

