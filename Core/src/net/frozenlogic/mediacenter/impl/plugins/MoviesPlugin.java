package net.frozenlogic.mediacenter.impl.plugins;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.plugins.InteractionPlugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginInfo;

public class MoviesPlugin implements InteractionPlugin {

    private PluginContext pluginContext;

    @Override
    public void initialize() {

    }

    @Override
    public void setPluginContext(PluginContext context) {
        this.pluginContext = context;
    }

    @Override
    public PluginInfo getPluginInfo() {
        return new MoviesPluginInfo();
    }


    @Override
    public Activity getInteractionActivity() {
        return new MoviesListActivity();
    }

    @Override
    public void cleanup() {

    }
}

