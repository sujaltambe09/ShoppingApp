package com.shop.ShoppingApp.service;

import com.shop.ShoppingApp.model.Product;
import com.shop.ShoppingApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(new Product(1,"Laptop",50000),
//                                            new Product(2,"Mobile",20000),
//                                            new Product(3, "Charger", 1000)));

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductsById(int prodId) {
        return repo.findById(prodId).orElse(new Product(0,"No Item", 0));
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}

