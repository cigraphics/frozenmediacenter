package net.frozenlogic.mediacenter.impl.plugins.youtube;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.plugins.InteractionPlugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginInfo;

import java.util.ArrayList;
import java.util.List;

public class YoutubePlugin implements InteractionPlugin {
    @Override
    public Activity getInteractionActivity() {
        return new YoutubeMainActivity();
    }

    @Override
    public void initialize() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setPluginContext(PluginContext context) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PluginInfo getPluginInfo() {
        return new YoutubePluginInfo();
    }

    @Override
    public void cleanup() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
