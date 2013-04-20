package net.frozenlogic.mediacenter;

public interface ServiceProvidersManager {
    void registerProvider(String contextName, ServiceProvider serviceProvider) throws ServiceProviderRegistrationException;

    void unregisterProvider(String contextName);

    ServiceProvider getServiceProvider(String contextName) throws ServiceProviderNotFoundException;
}
