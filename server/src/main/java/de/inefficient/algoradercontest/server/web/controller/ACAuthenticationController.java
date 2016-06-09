package de.inefficient.algoradercontest.server.web.controller;

import de.inefficient.algoradercontest.server.core.service.ACUserService;
import de.inefficient.algoradercontest.server.web.session.ACSession;
import de.inefficient.algoradercontest.server.transport.request.ACRegisterUserRequest;
import de.inefficient.algoradercontest.server.transport.response.ACResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Controller
public class ACAuthenticationController {
    @Autowired
    private ACUserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerAction(ACSession session, ACRegisterUserRequest register) {
        if (session.isUserLoggedIn()) {
            return ACResponse.redirect("/");
        }
        ACResponse response = userService.registerUser(register);
        if (response.isSuccessful()) {
            return ACResponse.redirect("/login");
        }
        return response.toModelAndView("register");
    }

    @RequestMapping("/register")
    public ModelAndView getRegisterContent(ACSession session) {
        if (session.isUserLoggedIn()) {
            return ACResponse.redirect("/");
        }
        return ACResponse.modelAndView("register");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginContent(ACSession session) {
        if (session.isUserLoggedIn()) {
            return "redirect:/";
        }
        return "login";
    }
}