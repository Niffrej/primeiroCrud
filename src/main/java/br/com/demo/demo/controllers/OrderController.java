package br.com.demo.demo.controllers;

import br.com.demo.demo.models.Order;
import br.com.demo.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.create(order), HttpStatus.OK);
    }

    @PutMapping(path = "/{idOrder}")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return new ResponseEntity(orderService.update(order), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idOrder}")
    public ResponseEntity<Order> findById(@PathVariable("idOrder") Long idOrder) {
        return new ResponseEntity<>(orderService.findById(idOrder), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }
}
