package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.FrameworkUtils;
import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiContext;
import net.frozenlogic.mediacenter.plugins.InteractionPlugin;
import net.frozenlogic.mediacenter.plugins.Plugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginsContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SystemActivity implements Activity {
    @Override
    public void initialize(ActivityContext activityContext) {
        this.perform(activityContext);
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        UiContext context = activityContext.getUiContext();

        PluginsContainer pluginsContainer = FrameworkUtils.getPluginsContainer();

        if (context.isParameterSet("idPlugin")) {
            Integer idPlugin = Integer.parseInt(context.getParameter("idPlugin"));
            Plugin plugin = pluginsContainer.getPlugin(idPlugin);
            if (plugin instanceof InteractionPlugin) {
                InteractionPlugin interactionPlugin = (InteractionPlugin) plugin;
                return interactionPlugin.getInteractionActivity();
            } else {
                return this;
            }
        } else {
            List<Plugin> plugins = pluginsContainer.getPlugins();
            List<PluginInformation> pluginInformations = new ArrayList<PluginInformation>();
            for (Plugin plugin : plugins) {
                if (plugin instanceof InteractionPlugin || plugin instanceof CorePlugin) {
                    boolean isCore = plugin instanceof CorePlugin;
                    PluginContext pluginContext = pluginsContainer.getPluginContext(plugin);
                    PluginInformation pluginInformation = new PluginInformation();
                    pluginInformation.setCore(isCore);
                    pluginInformation.setIdPlugin(pluginContext.getIdPlugin());
                    pluginInformation.setName(plugin.getPluginInfo().getName());
                    if (plugin instanceof CorePlugin) {
                        CorePlugin corePlugin = (CorePlugin) plugin;
                        pluginInformation.setBackgroundUrl(corePlugin.getThumbnailBackgroundUrl());
                    } else {
                        pluginInformation.setBackgroundUrl(plugin.getPluginInfo().getIconUrl());
                    }

                    pluginInformations.add(pluginInformation);
                }
            }

            MainMenu mainMenu = new MainMenu(pluginInformations);
            context.setModelAndView(new ModelAndView("/templates/menu.jsp", mainMenu));

            return this;
        }
    }
}
