package osgi.rest.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi.rest.resource.ExampleResource;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<ExampleResource> registration;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		registerRestService(bundleContext);
	}

	private void registerRestService(BundleContext bc) {
		registration = bc.registerService(ExampleResource.class, new ExampleResource(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
		Activator.context = null;
	}

}
