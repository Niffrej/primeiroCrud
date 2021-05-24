package br.com.demo.demo.controllers;

import br.com.demo.demo.models.Costumer;
import br.com.demo.demo.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Costumer")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @PostMapping()
    public ResponseEntity<Costumer> create(@RequestBody Costumer costumer) {
        return new ResponseEntity<>(costumerService.create(costumer), HttpStatus.OK);
    }

    @PutMapping(path = "/{idCostumer}")
    public ResponseEntity<Costumer> update(@RequestBody Costumer costumer) {
        return new ResponseEntity(costumerService.update(costumer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idCostumer}")
    public ResponseEntity<Costumer> findById(@PathVariable("idCostumer") Long idCostumer) {
        return new ResponseEntity<>(costumerService.findById(idCostumer), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Costumer>> getAll() {
        return ResponseEntity.ok().body(costumerService.findAll());
    }
}
