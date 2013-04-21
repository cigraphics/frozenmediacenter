package net.frozenlogic.mediacenter.impl;

import java.util.List;

public class MainMenu {

    private List<PluginInformation> plugins;

    public MainMenu(List<PluginInformation> plugins) {
        this.plugins = plugins;
    }

    public List<PluginInformation> getPlugins() {
        return plugins;
    }
}
