package net.frozenlogic.mediacenter.impl;

import flexjson.JSONSerializer;
import net.frozenlogic.mediacenter.ServiceContext;
import net.frozenlogic.mediacenter.ServiceContextImpl;
import net.frozenlogic.mediacenter.ServiceProvider;

import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ActivityServiceProvider implements ServiceProvider {

    private ActivityManager activityManager;

    public ActivityManager getActivityManager() {
        return activityManager;
    }

    public void setActivityManager(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    @Override
    public void handle(ServiceContext context) {
        try {
            JSONSerializer serializer = new JSONSerializer();
            final CharArrayWriter writer = new CharArrayWriter();

            HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(context.getResponse()) {
                @Override
                public PrintWriter getWriter() throws IOException {
                    return new PrintWriter(writer);
                }
            };

            ServiceContext serviceContext = new ServiceContextImpl(context.getRequest(), wrapper, context.getServletContext());

            this.getActivityManager().executeActivity(serviceContext);

            HtmlResponse response = new HtmlResponse(writer.toString());
            String responseJson = serializer.serialize(response);

            context.getResponse().setContentType("application/json");
            context.getResponse().getWriter().append(responseJson);
            context.getResponse().flushBuffer();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

