package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.activities.*;

public class ActivityContextImpl implements ActivityContext {

    private Activity currentActivity;
    private Activity defaultActivity;
    private MediaContext mediaContext;
    private UiContext uiContext;

    public ActivityContextImpl(Activity currentActivity, Activity defaultActivity, MediaContext mediaContext, UiContext uiContext) {
        this.currentActivity = currentActivity;
        this.defaultActivity = defaultActivity;
        this.uiContext = uiContext;
        this.mediaContext = mediaContext;
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
    public MediaContext getMediaContext() {
        return this.mediaContext;
    }

    @Override
    public UiContext getUiContext() {
        return this.uiContext;
    }
}
