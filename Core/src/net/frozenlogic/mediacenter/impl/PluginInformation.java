package net.frozenlogic.mediacenter.impl;

public class PluginInformation {
    private Integer idPlugin;
    private String name;
    private String backgroundUrl;
    private boolean isCore;

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public Integer getIdPlugin() {
        return idPlugin;
    }

    public void setIdPlugin(Integer idPlugin) {
        this.idPlugin = idPlugin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCore() {
        return isCore;
    }

    public void setCore(boolean core) {
        isCore = core;
    }
}
