package bit.qms.edu.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring application context
 * @author puran
 *
 */
@Component
public class QMSContext implements ApplicationContextAware {
	
	private static ApplicationContext vertxApplicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		vertxApplicationContext = applicationContext;
	}
	
	public ApplicationContext getVertxApplicationContext() {
		return vertxApplicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return vertxApplicationContext;
	}
	

}
