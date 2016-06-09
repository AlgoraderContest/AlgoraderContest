package de.inefficient.algoradercontest.server.config.management;

import de.inefficient.algoradercontest.server.web.session.ACSession;
import org.springframework.core.MethodParameter;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.springframework.messaging.simp.SimpMessageHeaderAccessor.getSessionAttributes;

/**
 * Created by samuel on 17.10.15.
 */
public class ACSessionArgumentResolver implements HandlerMethodArgumentResolver, org.springframework.web.method.support.HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return ACSession.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (webRequest.getNativeRequest() instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) webRequest
                    .getNativeRequest();
            HttpSession session = request.getSession(false);
            if (session != null) {
                return sessionNotNull(session.getAttribute(ACSession.SESSION));
            }
        }
        return ACSession.notExisting();
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, Message<?> message) throws Exception {
        Map<String, Object> session = getSessionAttributes(message.getHeaders());
        return sessionNotNull(session.get(ACSession.SESSION));
    }

    private Object sessionNotNull(Object session) {
        if (session != null) {
            return session;
        }
        return ACSession.notExisting();
    }
}