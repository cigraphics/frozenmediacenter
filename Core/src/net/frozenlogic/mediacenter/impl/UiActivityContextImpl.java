package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.UiActivityContext;

import java.util.Map;

class UiActivityContextImpl implements UiActivityContext {

    private Activity currentActivity;
    private Activity defaultActivity;
    private ModelAndView modelAndView;
    private Map<String, String[]> parameters;

    public UiActivityContextImpl(Activity defaultActivity, Activity currentActivity, Map<String, String[]> parameters) {
        this.currentActivity = currentActivity;
        this.parameters = parameters;
        this.defaultActivity = defaultActivity;
    }

    public UiActivityContextImpl(Activity defaultActivity, Map<String, String[]> parameters) {
        this.defaultActivity = defaultActivity;
        this.parameters = parameters;
    }

    @Override
    public Activity getCurrentActivity() {
        return this.currentActivity;
    }

    @Override
    public Activity getDefaultActivity() {
        return this.defaultActivity;
    }

    @Override
    public void setModelAndView(ModelAndView modelAndView) {
        this.modelAndView = modelAndView;
    }

    public ModelAndView getModelAndView() {
        return modelAndView;
    }

    @Override
    public Map<String, String[]> getParameters() {
        return this.parameters;
    }
}

