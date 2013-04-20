package net.frozenlogic.mediacenter.impl.goodreads;

import net.frozenlogic.mediacenter.plugins.PluginContext;
import net.frozenlogic.mediacenter.plugins.PluginInfo;

public class GoodreadsPlugin {
    private PluginContext pluginContext;

    @Override
    public void initialize() {

    }

    @Override
    public void setPluginContext(PluginContext context) {
        this.pluginContext = context;
    }

    @Override
    public PluginInfo getPluginInfo() {
        return new BooksPluginInfo();
    }


    @Override
    public Activity getInteractionActivity() {
        //  return new BooksSearchActivity();
        return new BookGroupActivity();
    }

    @Override
    public void cleanup() {

    }
}
