package clasem.components;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    /*@Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;*/

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("starTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startime = (long) request.getAttribute("starTime");
        String url = request.getRequestURL().toString();

        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (auth != null && auth.isAuthenticated()) {
            username = auth.getName();
        }

        logRepository.save(new com.udemy.entity.Log(new Date(),auth.getDetails().toString(),username,url));*/

        LOG.info("Url to: '" + url + "' in: '" + (System.currentTimeMillis() - startime) + "ms'");
    }

}