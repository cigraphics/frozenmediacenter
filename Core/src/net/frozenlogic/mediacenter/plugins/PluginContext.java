package net.frozenlogic.mediacenter.plugins;

import net.frozenlogic.mediacenter.User;
import net.frozenlogic.mediacenter.activities.Activity;

import java.util.Map;

public interface PluginContext {

    Integer getIdPlugin();

    Map<String, Object> getParameters();

    //EntityManager getEntityManager();

    User getUser();

    void registerActivity(Activity activity);
}
