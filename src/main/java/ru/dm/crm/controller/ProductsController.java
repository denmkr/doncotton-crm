package ru.dm.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dm.crm.entity.Product;
import ru.dm.crm.service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis on 24/03/2018.
 */
@Controller
public class ProductsController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(ModelMap model) {
        List<Product> products = productService.findAll();

        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(value = "/products/{articule}", method = RequestMethod.GET)
    public String getProductsByArticule(ModelMap model, @PathVariable(value = "articule") String articule) {
        List<Product> products = new ArrayList<Product>();
        products.add(productService.findByArticule(articule));

        model.addAttribute("products", products);
        return "products";
    }

}
