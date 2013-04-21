package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.plugins.Plugin;

public interface CorePlugin extends Plugin {
    Activity getMainActivity();

    String getThumbnailBackgroundUrl();
}
