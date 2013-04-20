package net.frozenlogic.mediacenter.impl;

import net.frozenlogic.mediacenter.ServiceProvider;
import net.frozenlogic.mediacenter.ServiceProviderNotFoundException;
import net.frozenlogic.mediacenter.ServiceProviderRegistrationException;
import net.frozenlogic.mediacenter.ServiceProvidersManager;

import java.util.HashMap;
import java.util.Map;

class ServiceProvidersManagerImpl implements ServiceProvidersManager {

    private Map<String, ServiceProvider> serviceProviderMap = new HashMap<String, ServiceProvider>();

    public Map<String, ServiceProvider> getServiceProviderMap() {
        return serviceProviderMap;
    }

    public void setServiceProviderMap(Map<String, ServiceProvider> serviceProviderMap) {
        this.serviceProviderMap = serviceProviderMap;
    }

    @Override
    public void registerProvider(String contextName, ServiceProvider serviceProvider) throws ServiceProviderRegistrationException {
        if (serviceProviderMap.containsKey(contextName)) {
            throw new ServiceProviderRegistrationException("The context '" + contextName + "' is already registered.");
        } else {
            serviceProviderMap.put(contextName, serviceProvider);
        }
    }

    @Override
    public void unregisterProvider(String contextName) {
        if (serviceProviderMap.containsKey(contextName)) {
            serviceProviderMap.remove(contextName);
        }
    }

    @Override
    public ServiceProvider getServiceProvider(String contextName) throws ServiceProviderNotFoundException {
        if (serviceProviderMap.containsKey(contextName)) {
            return serviceProviderMap.get(contextName);
        } else {
            throw new ServiceProviderNotFoundException("No provider is currently registered for context " + contextName);
        }
    }
}
