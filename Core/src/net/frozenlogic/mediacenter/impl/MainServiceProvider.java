package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ServiceContext;
import net.frozenlogic.mediacenter.ServiceProvider;

import java.io.IOException;

public class MainServiceProvider implements ServiceProvider {


    @Override
    public void handle(ServiceContext context) {
        try {
            context.getResponse().getWriter().append("Ok. It works.");
            context.getResponse().getWriter().flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
