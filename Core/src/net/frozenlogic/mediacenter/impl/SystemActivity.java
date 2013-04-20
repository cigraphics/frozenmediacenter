package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.FrameworkUtils;
import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiActivityContext;
import net.frozenlogic.mediacenter.plugins.InteractionPlugin;
import net.frozenlogic.mediacenter.plugins.Plugin;
import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginsContainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemActivity implements Activity {
    @Override
    public void initialize(ActivityContext activityContext) {

    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        UiActivityContext context = (UiActivityContext) activityContext;

        PluginsContainer pluginsContainer = FrameworkUtils.getPluginsContainer();

        if (context.getParameters().containsKey("idPlugin")) {
            Integer idPlugin = Integer.parseInt(context.getParameters().get("idPlugin")[0]);
            Plugin plugin = pluginsContainer.getPlugin(idPlugin);
            if (plugin instanceof InteractionPlugin) {
                InteractionPlugin interactionPlugin = (InteractionPlugin) plugin;
                return interactionPlugin.getInteractionActivity();
            } else {
                return this;
            }
        } else {
            List<Plugin> plugins = pluginsContainer.getPlugins();
            Map<Integer, InteractionPlugin> interactionPlugins = new HashMap<Integer, InteractionPlugin>();
            for (Plugin plugin : plugins) {
                if (plugin instanceof InteractionPlugin) {
                    PluginContext pluginContext = pluginsContainer.getPluginContext(plugin);
                    interactionPlugins.put(pluginContext.getIdPlugin(), (InteractionPlugin) plugin);
                }
            }

            MainMenu mainMenu = new MainMenu(interactionPlugins);
            context.setModelAndView(new ModelAndView("/templates/menu.jsp", mainMenu));

            return this;
        }
    }

    @Override
    public ActivityType getActivityType() {
        return ActivityType.UI;
    }
}
