package net.frozenlogic.mediacenter.impl.plugins.picasa;

import net.frozenlogic.mediacenter.plugins.PluginInfo;

import java.util.ArrayList;
import java.util.List;

public class PicasaPluginInfo implements PluginInfo {

    private List<String> authors;

    @Override
    public String getName() {
        return "Poze Picasa";
    }

    @Override
    public List<String> getAuthors() {
        if(authors == null){
            authors = new ArrayList<String>();
            authors.add("Vlad Dragan");
            authors.add("Ivan Diana");
            authors.add("Ivan Alexandru");
        }
        return authors;
    }

    @Override
    public String getDescription() {
        return "Album foto Picasa.";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getIconUrl() {
        return null;
    }
}
