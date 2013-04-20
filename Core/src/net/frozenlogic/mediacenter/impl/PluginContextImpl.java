package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.User;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.plugins.PluginContext;

import java.util.HashMap;
import java.util.Map;

class PluginContextImpl implements PluginContext {
    private Map<String, Object> parameters = new HashMap<String, Object>();
    private User user;
    private Integer idPlugin;

    public PluginContextImpl(Integer idPlugin) {
        this.idPlugin = idPlugin;
    }

    @Override
    public Integer getIdPlugin() {
        return this.idPlugin;
    }

    @Override
    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void registerActivity(Activity activity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
