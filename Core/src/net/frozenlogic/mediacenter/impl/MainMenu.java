package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.plugins.InteractionPlugin;

import java.util.Map;

public class MainMenu {

    private Map<Integer, InteractionPlugin> interactionPlugins;

    public MainMenu(Map<Integer, InteractionPlugin> interactionPlugins) {
        this.interactionPlugins = interactionPlugins;
    }

    public Map<Integer, InteractionPlugin> getInteractionPlugins() {
        return interactionPlugins;
    }
}
