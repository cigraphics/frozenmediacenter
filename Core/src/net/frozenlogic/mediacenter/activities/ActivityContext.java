package net.frozenlogic.mediacenter.activities;

public interface ActivityContext {

    Activity getCurrentActivity();

    Activity getDefaultActivity();

    MediaContext getMediaContext();

    UiContext getUiContext();
}
