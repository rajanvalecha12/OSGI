package converterconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import converterservice.mathservice.MathService;
import converterservice.mathservice.util.MathUtil;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("MathConsumer Starting...");
		 
        System.out.println("5-3 = " + MathUtil.minus(5, 3));
 
        //
        ServiceReference<?> serviceReference = context.getServiceReference(MathService.class);
        MathService service = (MathService) context
                .getService(serviceReference);
 
        System.out.println("5+3 = " + service.sum(5, 3));
 
        System.out.println("MathConsumer Started");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		 System.out.println("MathConsumer Stopped");
	}

}
