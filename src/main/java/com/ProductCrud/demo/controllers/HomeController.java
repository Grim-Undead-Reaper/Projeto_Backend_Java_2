package com.ProductCrud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ProductCrud.demo.service.DataBaseService;
import com.ProductCrud.demo.domain.product.Product;
import com.ProductCrud.demo.domain.product.ProductDTO;

@Controller
@RequestMapping("/MyProducts")
public class HomeController {

    @Autowired
    DataBaseService dbs;

    @GetMapping
    public String Homepage(Model model){
        List<Product> Products = dbs.GetAll();
        model.addAttribute("Products", Products);
        return "index";
    }

    @PostMapping
    public String Homepage(@ModelAttribute ProductDTO dto, Model model){
        List<Product> Products = dbs.FilteredProducts(dto);

        if (Products.isEmpty()){
            model.addAttribute("Products", null);
        } else {
            model.addAttribute("Products", Products);
        }

        return "index";
    }

    @PostMapping("/ByName")
    public String HomepageFilteredByName(@ModelAttribute ProductDTO dto, Model model){
        System.out.println(dto.productName());
        List<Product> Products = dbs.FilteredByName(dto.productName());
        System.out.println(Products);

        if (Products.isEmpty()){
            model.addAttribute("Products", null);
        } else {
            model.addAttribute("Products", Products);
        }

        return "index";
    }

}