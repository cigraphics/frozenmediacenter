package net.frozenlogic.mediacenter;

import net.frozenlogic.mediacenter.plugins.PluginsContainer;


public class FrameworkUtils {

    public static PluginsContainer getPluginsContainer() {
        return new PluginsContainerFactory().getPluginsContainer();
    }
}