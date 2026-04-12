package com.ProductCrud.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProductCrud.demo.domain.product.ProductDTO;
import com.ProductCrud.demo.service.DataBaseService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    DataBaseService dbs;

    @GetMapping("/Add")
    public String AddNewProduct() {
        return "newProduct";
    }

    @PostMapping("/Add")
    public String AddNewProduct(@ModelAttribute ProductDTO productDTO, Model model) {
        dbs.SaveProduct(productDTO);
        return "redirect:/MyProducts";
    }
}