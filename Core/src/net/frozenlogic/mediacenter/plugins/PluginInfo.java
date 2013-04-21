package net.frozenlogic.mediacenter.plugins;

import java.util.List;

public interface PluginInfo {

    String getName();

    List<String> getAuthors();

    String getDescription();

    String getVersion();

    String getIconUrl();
}
