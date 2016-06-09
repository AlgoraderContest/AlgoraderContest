package de.inefficient.algoradercontest.server.config.management;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
public class ACSecurityAccessDeniedHandler extends AccessDeniedHandlerImpl {
    private String errorPage;

    public ACSecurityAccessDeniedHandler(String errorPage) {
        this.errorPage = errorPage;
    }

    @Override
    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (accessDeniedException instanceof MissingCsrfTokenException || accessDeniedException instanceof InvalidCsrfTokenException) {
            response.sendRedirect(errorPage);
        }
    }
}