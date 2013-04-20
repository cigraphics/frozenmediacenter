package net.frozenlogic.mediacenter.plugins;

import java.util.List;

public interface PluginsContainer {

    void installPlugin(Plugin plugin);

    void uninstallPlugin(Plugin plugin);

    List<Plugin> getPlugins();

    Plugin getPlugin(Integer idPlugin);

    PluginContext getPluginContext(Plugin plugin);
}
