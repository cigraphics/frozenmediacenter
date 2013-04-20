package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.plugins.Plugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginsContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PluginsContainerImpl implements PluginsContainer {

    private Integer lastIdPlugin = 0;
    private Map<Plugin, PluginContextImpl> map = new HashMap<Plugin, PluginContextImpl>();

    public void initialize() {
        PluginsFactory pluginsFactory = new PluginsFactory();
        List<Plugin> plugins = pluginsFactory.getPlugins();
        for (Plugin plugin : plugins) {
            this.installPlugin(plugin);
        }
    }

    @Override
    public void installPlugin(Plugin plugin) {
        this.lastIdPlugin++;
        PluginContextImpl pluginContext = new PluginContextImpl(this.lastIdPlugin);
        this.map.put(plugin, pluginContext);
        plugin.setPluginContext(pluginContext);
        plugin.initialize();
    }

    @Override
    public void uninstallPlugin(Plugin plugin) {
        this.map.remove(plugin);
        plugin.cleanup();
    }

    @Override
    public List<Plugin> getPlugins() {
        return new ArrayList<Plugin>(this.map.keySet());
    }

    @Override
    public Plugin getPlugin(Integer idPlugin) {
        for (Plugin plugin : map.keySet()) {
            PluginContext pluginContext = map.get(plugin);
            if (pluginContext.getIdPlugin().equals(idPlugin))
                return plugin;
        }
        return null;
    }

    @Override
    public PluginContext getPluginContext(Plugin plugin) {
        if (this.map.containsKey(plugin))
            return this.map.get(plugin);
        else
            return null;
    }
}

