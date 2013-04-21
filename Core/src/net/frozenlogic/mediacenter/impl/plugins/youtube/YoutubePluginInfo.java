package net.frozenlogic.mediacenter.impl.plugins.youtube;

import net.frozenlogic.mediacenter.plugins.PluginInfo;

import java.util.ArrayList;
import java.util.List;

public class YoutubePluginInfo implements PluginInfo {
    @Override
    public String getName() {
        return "Youtube";
    }

    @Override
    public List<String> getAuthors() {
        List<String> list = new ArrayList<String>();
        list.add("Dragan Vlad");
        list.add("Ivan Diana");
        list.add("Ivan Alexandru");
        return list;
    }

    @Override
    public String getDescription() {
        return "Youtube plugin";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
