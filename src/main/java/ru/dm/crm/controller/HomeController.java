package ru.dm.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by denis on 24/03/2018.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(ModelMap model) {

        model.addAttribute("page", "main");
        return "home";
    }
}
