package net.frozenlogic.mediacenter.impl.goodreads;

import net.frozenlogic.mediacenter.plugins.PluginInfo;

import java.util.ArrayList;
import java.util.List;

public class BooksPluginInfo implements PluginInfo {
    @Override
    public String getName() {
        return "Carti";
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
        return "Contine informatii despre autorii preferati, cartile citite sau noutatile aparute. ";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
