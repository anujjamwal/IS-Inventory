package com.thoughtworks.is.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: riyakata
 * Date: 4/11/13
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GreetingsController {

    @RequestMapping("/")
    public String printHelloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index";
    }
}
