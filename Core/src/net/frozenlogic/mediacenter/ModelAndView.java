package net.frozenlogic.mediacenter;

public class ModelAndView {

    private String viewName;
    private Object model;

    public ModelAndView(String viewName, Object model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public Object getModel() {
        return model;
    }
}