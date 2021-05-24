package br.com.demo.demo.controllers;

import br.com.demo.demo.models.Telephone;
import br.com.demo.demo.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TelephoneController {
    @Autowired
    private TelephoneService telephoneService;

    @PostMapping()
    public ResponseEntity<Telephone> create(@RequestBody Telephone telephone) {
        return new ResponseEntity<>(telephoneService.create(telephone), HttpStatus.OK);
    }

    @PutMapping(path = "/{idTelephone}")
    public ResponseEntity<Telephone> update(@RequestBody Telephone telephone) {
        return new ResponseEntity(telephoneService.update(telephone), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idTelephone}")
    public ResponseEntity<Telephone> findById(@PathVariable("idTelephone") Long idTelephone) {
        return new ResponseEntity<>(telephoneService.findById(idTelephone), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Telephone>> getAll() {
        return ResponseEntity.ok().body(telephoneService.findAll());
    }
}
