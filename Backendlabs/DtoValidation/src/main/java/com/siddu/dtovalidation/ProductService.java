package com.siddu.dtovalidation;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private final Map<Long,Productdto>  products = new HashMap<Long,Productdto>();

    public Productdto createProduct(Productdto product) {

        if(products.containsKey(product.id())) {
           throw new ProductExistException("Product with id " + product.id() + " already exists");
        }
        products.put(product.id(), product);
        return products.get(product.id());
    }



}
