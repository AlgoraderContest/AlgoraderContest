package de.inefficient.algoradercontest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by samuel on 07.02.16.
 * @author samuel
 * @version 0.1
 */
@Controller
public class ACController {
    @RequestMapping("/")
    public String getApplicationIndex() {
        return "index";
    }
}
