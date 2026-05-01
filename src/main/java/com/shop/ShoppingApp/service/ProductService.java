package com.shop.ShoppingApp.service;

import com.shop.ShoppingApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(new Product(1,"Laptop",50000),
                                            new Product(2,"Mobile",20000),
                                            new Product(3, "Charger", 1000)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductsById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().orElse(new Product(0,"No Iteam",0));
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    public void updateProduct(Product product) {
        int index = 0;

        for(int i = 0; i <products.size(); i++) {
            if(products.get(i).getProdId() == product.getProdId()) {
                index = i;
            }
        }
        products.set(index, product);
    }

    public void deleteProduct(int prodId) {
        int index = 0;

        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getProdId() == prodId) {
                index = i;
            }
        }
        products.remove(index);
    }
}

