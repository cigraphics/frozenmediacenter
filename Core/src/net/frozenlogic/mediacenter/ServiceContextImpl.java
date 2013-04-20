package net.frozenlogic.mediacenter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceContextImpl implements ServiceContext {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext servletContext;

    public ServiceContextImpl(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
        this.request = request;
        this.response = response;
        this.servletContext = servletContext;
    }

    @Override
    public HttpServletRequest getRequest() {
        return this.request;
    }

    @Override
    public HttpServletResponse getResponse() {
        return this.response;
    }

    @Override
    public ServletContext getServletContext() {
        return this.servletContext;
    }
}
