package br.com.demo.demo.controllers;


import br.com.demo.demo.models.Product;
import br.com.demo.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.OK);
    }

    @PutMapping(path = "/{idProduct}")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idProduct}")
    public ResponseEntity<Product> findById(@PathVariable("idProduct") Long idProduct) {
        return new ResponseEntity<>(productService.findById(idProduct), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }
}
