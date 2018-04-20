package serendip.struts.plugins.thymeleaf.spi;

import org.springframework.context.MessageSource;
import org.thymeleaf.spring4.messageresolver.SpringMessageResolver;

/**
 * For struts2 messages bridge to Thymeleaf3.
 * @author sam.pan
 *
 */
public class StrutsMessageResolver extends SpringMessageResolver {

	public StrutsMessageResolver(){
		setMessageSource(new StrutsMessageSource());
	}

}
