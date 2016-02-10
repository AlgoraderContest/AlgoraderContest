package de.inefficient.algoradercontest.transport.response;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
public abstract class ACResponse {
    /*
     * model and view field names
     */
    private static final String ERRORS = "errors";

    private boolean successful;
    private String message;

    public static ModelAndView modelAndView(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(ERRORS, new ACErrorResponse());
        return modelAndView;
    }

    public static ModelAndView redirect(String path) {
        return new ModelAndView("redirect:" + path);
    }

    public ACResponse(boolean successful) {
        this(successful, null);
    }

    public ACResponse(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }

    public ModelAndView toModelAndView(String viewName) {
        ModelAndView modelAndView = modelAndView(viewName);
        if (this instanceof ACErrorResponse) {
            modelAndView.addObject(ERRORS, this);
        }
        return modelAndView;
    }
}