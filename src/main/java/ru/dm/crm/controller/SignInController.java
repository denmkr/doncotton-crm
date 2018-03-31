package ru.dm.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Denis on 31.03.18.
 */

@Controller
public class SignInController {

    // @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(ModelMap model, @RequestParam(value = "error", required = false) boolean error) {
        if (error) model.addAttribute("error", error);

        return "signin";
    }


}