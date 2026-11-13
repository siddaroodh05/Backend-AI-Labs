package com.siddu.dtovalidation;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    private final ProductService productService;
    @Autowired
    public Controller(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Productdto>  createProduct(@Valid @RequestBody Productdto productdto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productdto));
    }

}
