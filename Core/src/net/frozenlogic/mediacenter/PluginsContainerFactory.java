package net.frozenlogic.mediacenter;

import net.frozenlogic.mediacenter.plugins.PluginsContainer;

class PluginsContainerFactory {

    public PluginsContainer getPluginsContainer() {
        return (PluginsContainer) ConfigurationManager.getOrRegisterApplicationContext().getBean("PluginsContainer");
    }
}
