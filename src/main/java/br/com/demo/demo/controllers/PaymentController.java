package br.com.demo.demo.controllers;

import br.com.demo.demo.models.Payment;
import br.com.demo.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.create(payment), HttpStatus.OK);
    }

    @PutMapping(path = "/{idPayment}")
    public ResponseEntity<Payment> update(@RequestBody Payment payment) {
        return new ResponseEntity(paymentService.update(payment), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idPayment}")
    public ResponseEntity<Payment> findById(@PathVariable("idPayment") Long idPayment) {
        return new ResponseEntity<>(paymentService.findById(idPayment), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Payment>> getAll() {
        return ResponseEntity.ok().body(paymentService.findAll());
    }
}
