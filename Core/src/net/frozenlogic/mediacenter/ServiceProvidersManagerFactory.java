package net.frozenlogic.mediacenter;

import org.springframework.context.ApplicationContext;

public class ServiceProvidersManagerFactory {
    public ServiceProvidersManager getServiceProvidersManager() {
        ApplicationContext applicationContext = ConfigurationManager.getOrRegisterApplicationContext();
        ServiceProvidersManager serviceProvidersManager = (ServiceProvidersManager) applicationContext.getBean("ServiceProvidersManager");
        return serviceProvidersManager;
    }
}
