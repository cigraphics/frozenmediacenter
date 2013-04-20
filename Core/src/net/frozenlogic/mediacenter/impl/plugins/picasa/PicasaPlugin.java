package net.frozenlogic.mediacenter.impl.plugins.picasa;

import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.plugins.InteractionPlugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginInfo;

public class PicasaPlugin implements InteractionPlugin {
    private PluginContext pluginContext;

    @Override
    public Activity getInteractionActivity() {
        return new PicasaAlbumsActivity();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void setPluginContext(PluginContext context) {
        this.pluginContext = context;
    }

    @Override
    public PluginInfo getPluginInfo() {
        return new PicasaPluginInfo();
    }

    @Override
    public void cleanup() { }
}
