package net.frozenlogic.mediacenter;

import org.apache.jasper.servlet.JspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.net.URL;

class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        URL url = Main.class.getProtectionDomain().getCodeSource().getLocation();
        String resourceBase = url.getProtocol() + ":" + url.getPath();
        handler.setClassLoader(Thread.currentThread().getContextClassLoader());
        handler.setContextPath("/");
        handler.setResourceBase(resourceBase);
        ServletHolder jspServlethHolder = handler.addServlet(JspServlet.class, "*.jsp");
        handler.addServlet(MainServlet.class, "/");
        ServletHolder defaultServletHolder = handler.addServlet(DefaultServlet.class, "/resources/*");
        defaultServletHolder.setInitParameter("resourceBase", resourceBase);

        jspServlethHolder.setInitParameter("classpath", handler.getClassPath());
        server.setHandler(handler);

        try {
            server.start();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
