package net.frozenlogic.mediacenter.activities;

import net.frozenlogic.mediacenter.ModelAndView;

import java.util.Map;

public interface UiActivityContext extends ActivityContext {

    void setModelAndView(ModelAndView modelAndView);

    Map<String, String[]> getParameters();
}
