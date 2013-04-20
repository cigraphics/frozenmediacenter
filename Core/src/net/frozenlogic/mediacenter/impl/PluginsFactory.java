package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ConfigurationManager;
import net.frozenlogic.mediacenter.plugins.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PluginsFactory {

    public List<Plugin> getPlugins() {
        Map<String, Plugin> pluginsMap = ConfigurationManager.getOrRegisterApplicationContext("plugins").getBeansOfType(Plugin.class);
        return new ArrayList<Plugin>(pluginsMap.values());
    }
}