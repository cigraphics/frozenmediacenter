package net.frozenlogic.mediacenter.impl.plugins;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.impl.CorePlugin;
import net.frozenlogic.mediacenter.plugins.InteractionPlugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginInfo;

public class MoviesPlugin implements CorePlugin {

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
    public Activity getMainActivity() {
        return new MoviesListActivity();
    }

    @Override
    public String getThumbnailBackgroundUrl() {
        return "/resources/images/movies.jpg";
    }

    @Override
    public void cleanup() {

    }
}

