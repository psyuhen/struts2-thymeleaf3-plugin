package serendip.struts.plugins.thymeleaf.spi;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.LocalizedTextUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 从struts2的资源文件里面找资源，由于是struts2与Themeleaf的插件bug，新增一个类，在新版本中可以去掉
 * @author : sam.pan
 * @version V1.0
 */
@Component("messageSource")
public class StrutsMessageSource implements MessageSource {
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        String message = LocalizedTextUtil.findDefaultText(code, ActionContext.getContext().getLocale(), args);
        if (message == null) {
            return defaultMessage;
        }

        return message;
    }

    public String getMessage(String code, Object[] args, Locale locale)
        throws NoSuchMessageException {
        String message = LocalizedTextUtil.findDefaultText(code, ActionContext.getContext().getLocale(), args);

        return message;
    }

    public String getMessage(MessageSourceResolvable resolvable, Locale locale)
        throws NoSuchMessageException {
        return "getMessage MessageSourceResolvable null 03";
    }
}
