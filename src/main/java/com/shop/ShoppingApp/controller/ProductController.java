package com.shop.ShoppingApp.controller;

import com.shop.ShoppingApp.model.Product;
import com.shop.ShoppingApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductsById(prodId);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("{prodId}")
    public void deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
    }
}
