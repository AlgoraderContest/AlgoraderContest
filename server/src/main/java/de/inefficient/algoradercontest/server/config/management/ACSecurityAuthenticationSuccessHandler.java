package de.inefficient.algoradercontest.server.config.management;

import de.inefficient.algoradercontest.server.core.service.ACUserService;
import de.inefficient.algoradercontest.server.web.details.ACUserDetails;
import de.inefficient.algoradercontest.server.web.session.ACSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
public class ACSecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private ACUserService userService;

    public ACSecurityAuthenticationSuccessHandler(ACUserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object principal = authentication.getPrincipal();
        if (principal instanceof ACSecurityUserCredentials) {
            String id = ((ACSecurityUserCredentials) principal).getId();
            Optional<ACUserDetails> user = userService.getUserDetails(id);
            if (user.isPresent()) {
                ACSession session = ACSession.from(request.getSession());
                session.setUserDetails(user.get());
                response.sendRedirect("/");
                return;
            }
        }
        request.getSession().invalidate();
        response.sendRedirect("/");
    }
}