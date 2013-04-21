package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.UiContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

class UiContextImpl implements UiContext {

    private ModelAndView modelAndView;
    private HttpServletRequest request;

    public UiContextImpl(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setModelAndView(ModelAndView modelAndView) {
        this.modelAndView = modelAndView;
    }

    @Override
    public String getParameter(String name) {
        return this.request.getParameter(name);
    }

    @Override
    public boolean isParameterSet(String name) {
        return this.request.getParameterMap().containsKey(name);
    }

    public ModelAndView getModelAndView() {
        return modelAndView;
    }
}

