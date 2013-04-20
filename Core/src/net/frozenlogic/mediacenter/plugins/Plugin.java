package net.frozenlogic.mediacenter.plugins;

public interface Plugin {

    void initialize();

    void setPluginContext(PluginContext context);

    PluginInfo getPluginInfo();

    void cleanup();
}
