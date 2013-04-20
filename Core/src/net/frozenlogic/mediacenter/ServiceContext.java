package net.frozenlogic.mediacenter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceContext {
    HttpServletRequest getRequest();

    HttpServletResponse getResponse();

    ServletContext getServletContext();
}
