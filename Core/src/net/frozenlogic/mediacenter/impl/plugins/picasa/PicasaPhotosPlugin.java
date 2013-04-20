package net.frozenlogic.mediacenter.impl.plugins.picasa;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.plugins.InteractionPlugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginInfo;

public class PicasaPhotosPlugin implements InteractionPlugin {
    private PluginContext pluginContext;
    @Override
    public Activity getInteractionActivity() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void initialize() {    }

    @Override
    public void setPluginContext(PluginContext context) {
        this.pluginContext = context;
    }

    @Override
    public PluginInfo getPluginInfo() {
        return new PicasaPhotosPluginInfo();
    }

    @Override
    public void cleanup() { }
}
