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
public class ProductsController {

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "products";
    }
}
