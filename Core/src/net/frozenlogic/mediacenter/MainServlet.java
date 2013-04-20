package net.frozenlogic.mediacenter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceProvidersManager serviceProvidersManager = new ServiceProvidersManagerFactory().getServiceProvidersManager();

        boolean handled = false;

        try {
            ServiceProvider serviceProvider = serviceProvidersManager.getServiceProvider(req.getServletPath());
            ServiceContext serviceContext = new ServiceContextImpl(req, resp, getServletContext());
            serviceProvider.handle(serviceContext);
            handled = true;
        }
        catch (ServiceProviderNotFoundException ex) {
            handled = false;
        }
    }
}
