package net.frozenlogic.mediacenter.activities;

import net.frozenlogic.mediacenter.ModelAndView;

import java.util.Map;

public interface UiContext {

    void setModelAndView(ModelAndView modelAndView);

    String getParameter(String name);

    boolean isParameterSet(String name);
}
