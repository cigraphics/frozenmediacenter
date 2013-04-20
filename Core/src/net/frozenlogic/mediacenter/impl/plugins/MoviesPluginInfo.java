package net.frozenlogic.mediacenter.impl.plugins;

import net.frozenlogic.mediacenter.plugins.PluginInfo;

import java.util.ArrayList;
import java.util.List;

public class MoviesPluginInfo implements PluginInfo {

    @Override
    public String getName() {
        return "Filme";
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
        return "Contine filmele preferate salvate si permite cautarea si adaugarea de filme noi in lista. ";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}

